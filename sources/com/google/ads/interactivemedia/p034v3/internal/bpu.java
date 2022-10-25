package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpu */
/* loaded from: classes2.dex */
public final class bpu {

    /* renamed from: a */
    static final long f6399a;

    /* renamed from: b */
    static final boolean f6400b;

    /* renamed from: c */
    private static final Unsafe f6401c;

    /* renamed from: d */
    private static final Class f6402d;

    /* renamed from: e */
    private static final boolean f6403e;

    /* renamed from: f */
    private static final boolean f6404f;

    /* renamed from: g */
    private static final bpt f6405g;

    /* renamed from: h */
    private static final boolean f6406h;

    /* renamed from: i */
    private static final boolean f6407i;

    /* renamed from: j */
    private static final long f6408j;

    static {
        Unsafe m2894j = m2894j();
        f6401c = m2894j;
        f6402d = ble.m3537a();
        boolean m2878z = m2878z(Long.TYPE);
        f6403e = m2878z;
        boolean m2878z2 = m2878z(Integer.TYPE);
        f6404f = m2878z2;
        bpt bptVar = null;
        if (m2894j != null) {
            if (m2878z) {
                bptVar = new bps(m2894j);
            } else if (m2878z2) {
                bptVar = new bpr(m2894j);
            }
        }
        f6405g = bptVar;
        f6406h = bptVar == null ? false : bptVar.m2915t();
        f6407i = bptVar == null ? false : bptVar.m2916s();
        f6399a = m2909F(byte[].class);
        m2909F(boolean[].class);
        m2904K(boolean[].class);
        m2909F(int[].class);
        m2904K(int[].class);
        m2909F(long[].class);
        m2904K(long[].class);
        m2909F(float[].class);
        m2904K(float[].class);
        m2909F(double[].class);
        m2904K(double[].class);
        m2909F(Object[].class);
        m2904K(Object[].class);
        Field m2908G = m2908G();
        long j = -1;
        if (m2908G != null && bptVar != null) {
            j = bptVar.m2921n(m2908G);
        }
        f6408j = j;
        f6400b = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private bpu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static boolean m2914A(Object obj, long j) {
        return f6405g.mo2926i(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static boolean m2913B() {
        return f6407i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public static boolean m2912C() {
        return f6406h;
    }

    /* renamed from: D */
    private static byte m2911D(Object obj, long j) {
        return (byte) ((m2900d(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    /* renamed from: E */
    private static byte m2910E(Object obj, long j) {
        return (byte) ((m2900d(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* renamed from: F */
    private static int m2909F(Class cls) {
        if (f6407i) {
            return f6405g.m2925j(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public static Field m2908G() {
        int i = ble.f5993a;
        Field m2907H = m2907H(Buffer.class, "effectiveDirectAddress");
        if (m2907H == null) {
            Field m2907H2 = m2907H(Buffer.class, "address");
            if (m2907H2 == null || m2907H2.getType() != Long.TYPE) {
                return null;
            }
            return m2907H2;
        }
        return m2907H;
    }

    /* renamed from: H */
    private static Field m2907H(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public static void m2906I(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = ((~((int) j)) & 3) << 3;
        m2883u(obj, j2, ((b & 255) << i) | (m2900d(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public static void m2905J(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        m2883u(obj, j2, ((b & 255) << i) | (m2900d(obj, j2) & (~(255 << i))));
    }

    /* renamed from: K */
    private static void m2904K(Class cls) {
        if (f6407i) {
            f6405g.m2924k(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte m2903a(long j) {
        return f6405g.mo2934a(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static double m2902b(Object obj, long j) {
        return f6405g.mo2933b(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static float m2901c(Object obj, long j) {
        return f6405g.mo2932c(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static int m2900d(Object obj, long j) {
        return f6405g.m2923l(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static long m2899e(ByteBuffer byteBuffer) {
        return f6405g.m2922m(byteBuffer, f6408j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static long m2898f(Object obj, long j) {
        return f6405g.m2922m(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static Object m2897g(Class cls) {
        try {
            return f6401c.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static Object m2896h(Object obj, long j) {
        return f6405g.m2920o(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static Unsafe m2894j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new bpq());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static void m2888p(long j, byte[] bArr, long j2, long j3) {
        f6405g.mo2931d(j, bArr, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static void m2887q(Object obj, long j, boolean z) {
        f6405g.mo2930e(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static void m2886r(byte[] bArr, long j, byte b) {
        f6405g.mo2929f(bArr, f6399a + j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static void m2885s(Object obj, long j, double d) {
        f6405g.mo2928g(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public static void m2884t(Object obj, long j, float f) {
        f6405g.mo2927h(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public static void m2883u(Object obj, long j, int i) {
        f6405g.m2919p(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static void m2882v(Object obj, long j, long j2) {
        f6405g.m2918q(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public static void m2881w(Object obj, long j, Object obj2) {
        f6405g.m2917r(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static /* synthetic */ boolean m2880x(Object obj, long j) {
        return m2911D(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static /* synthetic */ boolean m2879y(Object obj, long j) {
        return m2910E(obj, j) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z */
    static boolean m2878z(Class cls) {
        int i = ble.f5993a;
        try {
            Class cls2 = f6402d;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
