package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2520k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brf */
/* loaded from: classes2.dex */
public final class brf {

    /* renamed from: a */
    private static final ThreadLocal f6892a = new ThreadLocal();

    /* renamed from: c */
    private final List f6894c;

    /* renamed from: b */
    private boolean f6893b = true;

    /* renamed from: d */
    private String[] f6895d = null;

    public brf() {
        ArrayList arrayList = new ArrayList();
        this.f6894c = arrayList;
        arrayList.add(String.class);
    }

    /* renamed from: a */
    static Set m2731a() {
        return (Set) f6892a.get();
    }

    /* renamed from: b */
    static brl m2730b(Object obj, Object obj2) {
        return brl.m2714c(new brj(obj), new brj(obj2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r1.isInstance(r5) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r7.isInstance(r6) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        r2 = r1;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m2729c(java.lang.Object r5, java.lang.Object r6, java.lang.String... r7) {
        /*
            if (r5 != r6) goto L5
            r5 = 1
            goto L71
        L5:
            com.google.ads.interactivemedia.v3.internal.brf r0 = new com.google.ads.interactivemedia.v3.internal.brf
            r0.<init>()
            r0.f6895d = r7
            boolean r7 = r0.f6893b
            if (r7 != 0) goto L11
            goto L6f
        L11:
            if (r5 == r6) goto L6f
            java.lang.Class r7 = r5.getClass()
            java.lang.Class r1 = r6.getClass()
            boolean r2 = r7.isInstance(r6)
            r3 = 0
            if (r2 == 0) goto L29
            boolean r2 = r1.isInstance(r5)
            if (r2 != 0) goto L35
            goto L37
        L29:
            boolean r2 = r1.isInstance(r5)
            if (r2 == 0) goto L6d
            boolean r2 = r7.isInstance(r6)
            if (r2 != 0) goto L37
        L35:
            r2 = r7
            goto L38
        L37:
            r2 = r1
        L38:
            boolean r4 = r2.isArray()     // Catch: java.lang.IllegalArgumentException -> L6d
            if (r4 == 0) goto L42
            r0.m2726f(r5, r6)     // Catch: java.lang.IllegalArgumentException -> L6d
            goto L6f
        L42:
            java.util.List r4 = r0.f6894c     // Catch: java.lang.IllegalArgumentException -> L6d
            boolean r7 = r4.contains(r7)     // Catch: java.lang.IllegalArgumentException -> L6d
            if (r7 != 0) goto L66
            java.util.List r7 = r0.f6894c     // Catch: java.lang.IllegalArgumentException -> L6d
            boolean r7 = r7.contains(r1)     // Catch: java.lang.IllegalArgumentException -> L6d
            if (r7 == 0) goto L53
            goto L66
        L53:
            r0.m2724h(r5, r6, r2)     // Catch: java.lang.IllegalArgumentException -> L6d
        L56:
            java.lang.Class r7 = r2.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6d
            if (r7 == 0) goto L6f
            if (r2 == 0) goto L6f
            java.lang.Class r2 = r2.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L6d
            r0.m2724h(r5, r6, r2)     // Catch: java.lang.IllegalArgumentException -> L6d
            goto L56
        L66:
            boolean r5 = r5.equals(r6)     // Catch: java.lang.IllegalArgumentException -> L6d
            r0.f6893b = r5     // Catch: java.lang.IllegalArgumentException -> L6d
            goto L6f
        L6d:
            r0.f6893b = r3
        L6f:
            boolean r5 = r0.f6893b
        L71:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.brf.m2729c(java.lang.Object, java.lang.Object, java.lang.String[]):boolean");
    }

    /* renamed from: h */
    private final void m2724h(Object obj, Object obj2, Class cls) {
        Set m2731a = m2731a();
        brl m2730b = m2730b(obj, obj2);
        brk brkVar = (brk) m2730b;
        brl m2714c = brl.m2714c(brkVar.f6901b, brkVar.f6900a);
        if (m2731a == null || !(m2731a.contains(m2730b) || m2731a.contains(m2714c))) {
            try {
                Set m2731a2 = m2731a();
                if (m2731a2 == null) {
                    m2731a2 = new HashSet();
                    f6892a.set(m2731a2);
                }
                m2731a2.add(m2730b(obj, obj2));
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (int i = 0; i < declaredFields.length && this.f6893b; i++) {
                    Field field = declaredFields[i];
                    if (!C2520k.m5994b(this.f6895d, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(brg.class)) {
                        try {
                            m2726f(field.get(obj), field.get(obj2));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            } finally {
                m2723i(obj, obj2);
            }
        }
    }

    /* renamed from: i */
    private static void m2723i(Object obj, Object obj2) {
        Set m2731a = m2731a();
        if (m2731a != null) {
            m2731a.remove(m2730b(obj, obj2));
            if (m2731a.isEmpty()) {
                f6892a.remove();
            }
        }
    }

    /* renamed from: d */
    public final void m2728d(int i, int i2) {
        if (this.f6893b) {
            this.f6893b = i == i2;
        }
    }

    /* renamed from: e */
    public final void m2727e(long j, long j2) {
        if (this.f6893b) {
            this.f6893b = j == j2;
        }
    }

    /* renamed from: f */
    public final void m2726f(Object obj, Object obj2) {
        if (this.f6893b && obj != obj2) {
            if (obj == null || obj2 == null) {
                m2725g();
            } else if (!obj.getClass().isArray()) {
                this.f6893b = obj.equals(obj2);
            } else if (obj.getClass() != obj2.getClass()) {
                m2725g();
            } else {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    long[] jArr2 = (long[]) obj2;
                    if (this.f6893b && jArr != jArr2) {
                        if (jArr.length != jArr2.length) {
                            m2725g();
                            return;
                        }
                        while (i < jArr.length && this.f6893b) {
                            m2727e(jArr[i], jArr2[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int[] iArr2 = (int[]) obj2;
                    if (!this.f6893b || iArr == iArr2) {
                        return;
                    }
                    if (iArr.length != iArr2.length) {
                        m2725g();
                        return;
                    }
                    while (i < iArr.length && this.f6893b) {
                        m2728d(iArr[i], iArr2[i]);
                        i++;
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    short[] sArr2 = (short[]) obj2;
                    if (!this.f6893b || sArr == sArr2) {
                        return;
                    }
                    if (sArr.length != sArr2.length) {
                        m2725g();
                        return;
                    }
                    for (int i2 = 0; i2 < sArr.length && this.f6893b; i2++) {
                        this.f6893b = sArr[i2] == sArr2[i2];
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    char[] cArr2 = (char[]) obj2;
                    if (!this.f6893b || cArr == cArr2) {
                        return;
                    }
                    if (cArr.length != cArr2.length) {
                        m2725g();
                        return;
                    }
                    for (int i3 = 0; i3 < cArr.length && this.f6893b; i3++) {
                        this.f6893b = cArr[i3] == cArr2[i3];
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = (byte[]) obj2;
                    if (!this.f6893b || bArr == bArr2) {
                        return;
                    }
                    if (bArr.length != bArr2.length) {
                        m2725g();
                        return;
                    }
                    for (int i4 = 0; i4 < bArr.length && this.f6893b; i4++) {
                        this.f6893b = bArr[i4] == bArr2[i4];
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    double[] dArr2 = (double[]) obj2;
                    if (!this.f6893b || dArr == dArr2) {
                        return;
                    }
                    if (dArr.length != dArr2.length) {
                        m2725g();
                        return;
                    }
                    while (i < dArr.length && this.f6893b) {
                        m2727e(Double.doubleToLongBits(dArr[i]), Double.doubleToLongBits(dArr2[i]));
                        i++;
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    float[] fArr2 = (float[]) obj2;
                    if (!this.f6893b || fArr == fArr2) {
                        return;
                    }
                    if (fArr.length != fArr2.length) {
                        m2725g();
                        return;
                    }
                    while (i < fArr.length && this.f6893b) {
                        m2728d(Float.floatToIntBits(fArr[i]), Float.floatToIntBits(fArr2[i]));
                        i++;
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    boolean[] zArr2 = (boolean[]) obj2;
                    if (!this.f6893b || zArr == zArr2) {
                        return;
                    }
                    if (zArr.length != zArr2.length) {
                        m2725g();
                        return;
                    }
                    for (int i5 = 0; i5 < zArr.length && this.f6893b; i5++) {
                        this.f6893b = zArr[i5] == zArr2[i5];
                    }
                } else {
                    Object[] objArr = (Object[]) obj;
                    Object[] objArr2 = (Object[]) obj2;
                    if (!this.f6893b || objArr == objArr2) {
                        return;
                    }
                    if (objArr.length != objArr2.length) {
                        m2725g();
                        return;
                    }
                    while (i < objArr.length && this.f6893b) {
                        m2726f(objArr[i], objArr2[i]);
                        i++;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    protected final void m2725g() {
        this.f6893b = false;
    }
}
