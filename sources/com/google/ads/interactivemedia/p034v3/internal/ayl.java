package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayl */
/* loaded from: classes2.dex */
public final class ayl {

    /* renamed from: a */
    private static final awp f5302a = awp.m4450c().m4449d(new ayh()).mo4426a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ayi m4329a() {
        return ayj.f5298a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static Object m4328b(Future future, Class cls) throws Exception {
        ayk.f5301a.mo4330a(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw m4326d(cls, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ayb((Error) cause);
            }
            if (cause instanceof RuntimeException) {
                throw new ayy(cause);
            }
            throw m4326d(cls, cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m4327c(Class cls) {
        boolean z = true;
        atm.m4616f(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        try {
            m4326d(cls, new Exception());
        } catch (Exception unused) {
            z = false;
        }
        atm.m4616f(z, "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    /* renamed from: d */
    private static Exception m4326d(Class cls, Throwable th) {
        for (Constructor constructor : f5302a.m4448e(Arrays.asList(cls.getConstructors()))) {
            Exception exc = (Exception) m4325e(constructor, th);
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        String obj = cls.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 82);
        sb.append("No appropriate constructor for exception of type ");
        sb.append(obj);
        sb.append(" in response to chained exception");
        throw new IllegalArgumentException(sb.toString(), th);
    }

    /* renamed from: e */
    private static Object m4325e(Constructor constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }
}
