package org.mozilla.javascript.jdk13;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.InterfaceAdapter;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.VMBridge;

/* loaded from: classes5.dex */
public class VMBridge_jdk13 extends VMBridge {
    private ThreadLocal<Object[]> contextLocal = new ThreadLocal<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public boolean isVarArgs(Member member) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public Object getThreadContextHelper() {
        Object[] objArr = this.contextLocal.get();
        if (objArr == null) {
            Object[] objArr2 = new Object[1];
            this.contextLocal.set(objArr2);
            return objArr2;
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public Context getContext(Object obj) {
        return (Context) ((Object[]) obj)[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public void setContext(Object obj, Context context) {
        ((Object[]) obj)[0] = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public ClassLoader getCurrentThreadClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public boolean tryToMakeAccessible(Object obj) {
        if (obj instanceof AccessibleObject) {
            AccessibleObject accessibleObject = (AccessibleObject) obj;
            if (accessibleObject.isAccessible()) {
                return true;
            }
            try {
                accessibleObject.setAccessible(true);
            } catch (Exception unused) {
            }
            return accessibleObject.isAccessible();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr) {
        try {
            return Proxy.getProxyClass(clsArr[0].getClassLoader(), clsArr).getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            throw Kit.initCause(new IllegalStateException(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.VMBridge
    public Object newInterfaceProxy(Object obj, final ContextFactory contextFactory, final InterfaceAdapter interfaceAdapter, final Object obj2, final Scriptable scriptable) {
        try {
            return ((Constructor) obj).newInstance(new InvocationHandler() { // from class: org.mozilla.javascript.jdk13.VMBridge_jdk13.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    if (method.getDeclaringClass() == Object.class) {
                        String name = method.getName();
                        if (name.equals("equals")) {
                            return Boolean.valueOf(obj3 == objArr[0]);
                        } else if (name.equals("hashCode")) {
                            return Integer.valueOf(obj2.hashCode());
                        } else {
                            if (name.equals("toString")) {
                                return "Proxy[" + obj2.toString() + "]";
                            }
                        }
                    }
                    return interfaceAdapter.invoke(contextFactory, obj2, scriptable, obj3, method, objArr);
                }
            });
        } catch (IllegalAccessException e) {
            throw Kit.initCause(new IllegalStateException(), e);
        } catch (InstantiationException e2) {
            throw Kit.initCause(new IllegalStateException(), e2);
        } catch (InvocationTargetException e3) {
            throw Context.throwAsScriptRuntimeEx(e3);
        }
    }
}
