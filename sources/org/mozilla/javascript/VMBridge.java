package org.mozilla.javascript;

import java.lang.reflect.Member;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class VMBridge {
    static final VMBridge instance = makeInstance();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Context getContext(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ClassLoader getCurrentThreadClassLoader();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object getThreadContextHelper();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isVarArgs(Member member);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setContext(Object obj, Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean tryToMakeAccessible(Object obj);

    private static VMBridge makeInstance() {
        VMBridge vMBridge;
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk15.VMBridge_jdk15", "org.mozilla.javascript.jdk13.VMBridge_jdk13", "org.mozilla.javascript.jdk11.VMBridge_jdk11"};
        for (int i = 0; i != 4; i++) {
            Class<?> classOrNull = Kit.classOrNull(strArr[i]);
            if (classOrNull != null && (vMBridge = (VMBridge) Kit.newInstanceOrNull(classOrNull)) != null) {
                return vMBridge;
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr) {
        throw Context.reportRuntimeError("VMBridge.getInterfaceProxyHelper is not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object newInterfaceProxy(Object obj, ContextFactory contextFactory, InterfaceAdapter interfaceAdapter, Object obj2, Scriptable scriptable) {
        throw Context.reportRuntimeError("VMBridge.newInterfaceProxy is not supported");
    }

    public Iterator<?> getJavaIterator(Context context, Scriptable scriptable, Object obj) {
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof Iterator) {
                return (Iterator) unwrap;
            }
            return null;
        }
        return null;
    }
}
