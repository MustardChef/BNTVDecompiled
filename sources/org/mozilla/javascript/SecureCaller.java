package org.mozilla.javascript;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecureClassLoader;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public abstract class SecureCaller {
    private static final byte[] secureCallerImplBytecode = loadBytecode();
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> callers = new WeakHashMap();

    public abstract Object call(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr);

    static Object callSecurely(final CodeSource codeSource, Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Map<ClassLoader, SoftReference<SecureCaller>> map;
        SecureCaller secureCaller;
        final Thread currentThread = Thread.currentThread();
        final ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.SecureCaller.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return currentThread.getContextClassLoader();
            }
        });
        Map<CodeSource, Map<ClassLoader, SoftReference<SecureCaller>>> map2 = callers;
        synchronized (map2) {
            map = map2.get(codeSource);
            if (map == null) {
                map = new WeakHashMap<>();
                map2.put(codeSource, map);
            }
        }
        synchronized (map) {
            SoftReference<SecureCaller> softReference = map.get(classLoader);
            SecureCaller secureCaller2 = softReference != null ? softReference.get() : null;
            if (secureCaller2 == null) {
                try {
                    secureCaller2 = (SecureCaller) AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: org.mozilla.javascript.SecureCaller.2
                        @Override // java.security.PrivilegedExceptionAction
                        public Object run() throws Exception {
                            ClassLoader classLoader2;
                            Class<?> cls = getClass();
                            if (classLoader.loadClass(cls.getName()) != cls) {
                                classLoader2 = cls.getClassLoader();
                            } else {
                                classLoader2 = classLoader;
                            }
                            SecureClassLoaderImpl secureClassLoaderImpl = new SecureClassLoaderImpl(classLoader2);
                            return secureClassLoaderImpl.defineAndLinkClass(SecureCaller.class.getName() + "Impl", SecureCaller.secureCallerImplBytecode, codeSource).newInstance();
                        }
                    });
                    map.put(classLoader, new SoftReference<>(secureCaller2));
                } catch (PrivilegedActionException e) {
                    throw new UndeclaredThrowableException(e.getCause());
                }
            }
            secureCaller = secureCaller2;
        }
        return secureCaller.call(callable, context, scriptable, scriptable2, objArr);
    }

    /* loaded from: classes5.dex */
    private static class SecureClassLoaderImpl extends SecureClassLoader {
        SecureClassLoaderImpl(ClassLoader classLoader) {
            super(classLoader);
        }

        Class<?> defineAndLinkClass(String str, byte[] bArr, CodeSource codeSource) {
            Class<?> defineClass = defineClass(str, bArr, 0, bArr.length, codeSource);
            resolveClass(defineClass);
            return defineClass;
        }
    }

    private static byte[] loadBytecode() {
        return (byte[]) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.SecureCaller.3
            @Override // java.security.PrivilegedAction
            public Object run() {
                return SecureCaller.loadBytecodePrivileged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] loadBytecodePrivileged() {
        try {
            InputStream openStream = SecureCaller.class.getResource("SecureCallerImpl.clazz").openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openStream.read();
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    openStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(read);
            }
        } catch (IOException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
