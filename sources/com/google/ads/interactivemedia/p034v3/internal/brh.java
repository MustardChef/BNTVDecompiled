package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2520k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brh */
/* loaded from: classes2.dex */
public final class brh {

    /* renamed from: a */
    private static final ThreadLocal f6896a = new ThreadLocal();

    /* renamed from: b */
    private int f6897b = 17;

    public brh() {
    }

    public brh(byte[] bArr) {
    }

    /* renamed from: a */
    public static int m2722a(Object obj, String... strArr) {
        brh brhVar = new brh(null);
        Class<?> cls = obj.getClass();
        m2717f(obj, cls, brhVar, strArr);
        while (cls.getSuperclass() != null && cls != null) {
            cls = cls.getSuperclass();
            m2717f(obj, cls, brhVar, strArr);
        }
        return brhVar.f6897b;
    }

    /* renamed from: b */
    static Set m2721b() {
        return (Set) f6896a.get();
    }

    /* renamed from: e */
    private static void m2718e(Object obj) {
        Set m2721b = m2721b();
        if (m2721b != null) {
            m2721b.remove(new brj(obj));
            if (m2721b.isEmpty()) {
                f6896a.remove();
            }
        }
    }

    /* renamed from: f */
    private static void m2717f(Object obj, Class cls, brh brhVar, String[] strArr) {
        Set m2721b = m2721b();
        if (m2721b == null || !m2721b.contains(new brj(obj))) {
            try {
                Set m2721b2 = m2721b();
                if (m2721b2 == null) {
                    m2721b2 = new HashSet();
                    f6896a.set(m2721b2);
                }
                m2721b2.add(new brj(obj));
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (Field field : declaredFields) {
                    if (!C2520k.m5994b(strArr, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(bri.class)) {
                        try {
                            brhVar.m2719d(field.get(obj));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            } finally {
                m2718e(obj);
            }
        }
    }

    /* renamed from: c */
    public final void m2720c(long j) {
        this.f6897b = (this.f6897b * 37) + ((int) (j ^ (j >> 32)));
    }

    /* renamed from: d */
    public final void m2719d(Object obj) {
        if (obj == null) {
            this.f6897b *= 37;
        } else if (obj.getClass().isArray()) {
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length = jArr.length;
                while (i < length) {
                    m2720c(jArr[i]);
                    i++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length2 = iArr.length;
                while (i < length2) {
                    this.f6897b = (this.f6897b * 37) + iArr[i];
                    i++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length3 = sArr.length;
                while (i < length3) {
                    this.f6897b = (this.f6897b * 37) + sArr[i];
                    i++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length4 = cArr.length;
                while (i < length4) {
                    this.f6897b = (this.f6897b * 37) + cArr[i];
                    i++;
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length5 = bArr.length;
                while (i < length5) {
                    this.f6897b = (this.f6897b * 37) + bArr[i];
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length6 = dArr.length;
                while (i < length6) {
                    m2720c(Double.doubleToLongBits(dArr[i]));
                    i++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length7 = fArr.length;
                while (i < length7) {
                    this.f6897b = (this.f6897b * 37) + Float.floatToIntBits(fArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length8 = zArr.length;
                while (i < length8) {
                    this.f6897b = (this.f6897b * 37) + (!zArr[i] ? 1 : 0);
                    i++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length9 = objArr.length;
                while (i < length9) {
                    m2719d(objArr[i]);
                    i++;
                }
            }
        } else {
            this.f6897b = (this.f6897b * 37) + obj.hashCode();
        }
    }

    public final int hashCode() {
        return this.f6897b;
    }
}
