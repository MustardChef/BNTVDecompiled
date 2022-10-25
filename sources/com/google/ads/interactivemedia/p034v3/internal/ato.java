package com.google.ads.interactivemedia.p034v3.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ato */
/* loaded from: classes2.dex */
public final class ato {

    /* renamed from: a */
    private static final Object f5075a;

    static {
        Object m4605c = m4605c();
        f5075a = m4605c;
        if (m4605c != null) {
            m4604d("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (m4605c == null) {
            return;
        }
        m4603e(m4605c);
    }

    /* renamed from: a */
    public static String m4607a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: b */
    public static void m4606b(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    /* renamed from: c */
    private static Object m4605c() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static Method m4604d(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    private static void m4603e(Object obj) {
        try {
            Method m4604d = m4604d("getStackTraceDepth", Throwable.class);
            if (m4604d == null) {
                return;
            }
            m4604d.invoke(obj, new Throwable());
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
        }
    }
}
