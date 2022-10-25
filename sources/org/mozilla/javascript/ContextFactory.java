package org.mozilla.javascript;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.mozilla.javascript.xml.XMLLib;

/* loaded from: classes5.dex */
public class ContextFactory {
    private static ContextFactory global = new ContextFactory();
    private static volatile boolean hasCustomGlobal;
    private ClassLoader applicationClassLoader;
    private boolean disabledListening;
    private volatile Object listeners;
    private final Object listenersLock = new Object();
    private volatile boolean sealed;

    /* loaded from: classes5.dex */
    public interface GlobalSetter {
        ContextFactory getContextFactoryGlobal();

        void setContextFactoryGlobal(ContextFactory contextFactory);
    }

    /* loaded from: classes5.dex */
    public interface Listener {
        void contextCreated(Context context);

        void contextReleased(Context context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void observeInstructionCount(Context context, int i) {
    }

    public static ContextFactory getGlobal() {
        return global;
    }

    public static boolean hasExplicitGlobal() {
        return hasCustomGlobal;
    }

    public static synchronized void initGlobal(ContextFactory contextFactory) {
        synchronized (ContextFactory.class) {
            try {
                if (contextFactory == null) {
                    throw new IllegalArgumentException();
                }
                if (hasCustomGlobal) {
                    throw new IllegalStateException();
                }
                hasCustomGlobal = true;
                global = contextFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized GlobalSetter getGlobalSetter() {
        GlobalSetter globalSetter;
        synchronized (ContextFactory.class) {
            if (hasCustomGlobal) {
                throw new IllegalStateException();
            }
            hasCustomGlobal = true;
            globalSetter = new GlobalSetter() { // from class: org.mozilla.javascript.ContextFactory.1GlobalSetterImpl
                @Override // org.mozilla.javascript.ContextFactory.GlobalSetter
                public void setContextFactoryGlobal(ContextFactory contextFactory) {
                    if (contextFactory == null) {
                        contextFactory = new ContextFactory();
                    }
                    ContextFactory unused = ContextFactory.global = contextFactory;
                }

                @Override // org.mozilla.javascript.ContextFactory.GlobalSetter
                public ContextFactory getContextFactoryGlobal() {
                    return ContextFactory.global;
                }
            };
        }
        return globalSetter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context makeContext() {
        return new Context(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasFeature(Context context, int i) {
        switch (i) {
            case 1:
                int languageVersion = context.getLanguageVersion();
                return languageVersion == 100 || languageVersion == 110 || languageVersion == 120;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return context.getLanguageVersion() == 120;
            case 5:
                return true;
            case 6:
                int languageVersion2 = context.getLanguageVersion();
                return languageVersion2 == 0 || languageVersion2 >= 160;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return false;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    private boolean isDom3Present() {
        Class<?> classOrNull = Kit.classOrNull("org.w3c.dom.Node");
        if (classOrNull == null) {
            return false;
        }
        try {
            classOrNull.getMethod("getUserData", String.class);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XMLLib.Factory getE4xImplementationFactory() {
        if (isDom3Present()) {
            return XMLLib.Factory.create("org.mozilla.javascript.xmlimpl.XMLLibImpl");
        }
        if (Kit.classOrNull("org.apache.xmlbeans.XmlCursor") != null) {
            return XMLLib.Factory.create("org.mozilla.javascript.xml.impl.xmlbeans.XMLLibImpl");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedClassLoader createClassLoader(final ClassLoader classLoader) {
        return (GeneratedClassLoader) AccessController.doPrivileged(new PrivilegedAction<DefiningClassLoader>() { // from class: org.mozilla.javascript.ContextFactory.1
            @Override // java.security.PrivilegedAction
            public DefiningClassLoader run() {
                return new DefiningClassLoader(classLoader);
            }
        });
    }

    public final ClassLoader getApplicationClassLoader() {
        return this.applicationClassLoader;
    }

    public final void initApplicationClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("loader is null");
        }
        if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        }
        if (this.applicationClassLoader != null) {
            throw new IllegalStateException("applicationClassLoader can only be set once");
        }
        checkNotSealed();
        this.applicationClassLoader = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object call = callable.call(context, scriptable, scriptable2, objArr);
        return call instanceof ConsString ? call.toString() : call;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onContextCreated(Context context) {
        Object obj = this.listeners;
        int i = 0;
        while (true) {
            Listener listener = (Listener) Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            listener.contextCreated(context);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onContextReleased(Context context) {
        Object obj = this.listeners;
        int i = 0;
        while (true) {
            Listener listener = (Listener) Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            listener.contextReleased(context);
            i++;
        }
    }

    public final void addListener(Listener listener) {
        checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.addListener(this.listeners, listener);
        }
    }

    public final void removeListener(Listener listener) {
        checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.removeListener(this.listeners, listener);
        }
    }

    final void disableContextListening() {
        checkNotSealed();
        synchronized (this.listenersLock) {
            this.disabledListening = true;
            this.listeners = null;
        }
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final void seal() {
        checkNotSealed();
        this.sealed = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkNotSealed() {
        if (this.sealed) {
            throw new IllegalStateException();
        }
    }

    public final Object call(ContextAction contextAction) {
        return Context.call(this, contextAction);
    }

    public Context enterContext() {
        return enterContext(null);
    }

    public final Context enter() {
        return enterContext(null);
    }

    public final void exit() {
        Context.exit();
    }

    public final Context enterContext(Context context) {
        return Context.enter(context, this);
    }
}
