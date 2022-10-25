package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bol */
/* loaded from: classes2.dex */
public final class bol<T> implements boy<T> {

    /* renamed from: a */
    private static final int[] f6318a = new int[0];

    /* renamed from: b */
    private static final Unsafe f6319b = bpu.m2894j();

    /* renamed from: c */
    private final int[] f6320c;

    /* renamed from: d */
    private final Object[] f6321d;

    /* renamed from: e */
    private final int f6322e;

    /* renamed from: f */
    private final int f6323f;

    /* renamed from: g */
    private final boj f6324g;

    /* renamed from: h */
    private final boolean f6325h;

    /* renamed from: i */
    private final boolean f6326i;

    /* renamed from: j */
    private final boolean f6327j;

    /* renamed from: k */
    private final boolean f6328k;

    /* renamed from: l */
    private final int[] f6329l;

    /* renamed from: m */
    private final int f6330m;

    /* renamed from: n */
    private final int f6331n;

    /* renamed from: o */
    private final bny f6332o;

    /* renamed from: p */
    private final bqd f6333p;

    /* renamed from: q */
    private final bnv f6334q;

    /* renamed from: r */
    private final bqd f6335r;

    /* renamed from: s */
    private final bqd f6336s;

    private bol(int[] iArr, Object[] objArr, int i, int i2, boj bojVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, bqd bqdVar, bny bnyVar, bqd bqdVar2, bnv bnvVar, bqd bqdVar3, byte[] bArr, byte[] bArr2) {
        this.f6320c = iArr;
        this.f6321d = objArr;
        this.f6322e = i;
        this.f6323f = i2;
        this.f6326i = bojVar instanceof bnd;
        this.f6327j = z;
        this.f6325h = bnvVar != null && bnv.m3216as(bojVar);
        this.f6328k = false;
        this.f6329l = iArr2;
        this.f6330m = i3;
        this.f6331n = i4;
        this.f6335r = bqdVar;
        this.f6332o = bnyVar;
        this.f6333p = bqdVar2;
        this.f6334q = bnvVar;
        this.f6324g = bojVar;
        this.f6336s = bqdVar3;
    }

    /* renamed from: A */
    private final int m3169A(int i, int i2) {
        int length = (this.f6320c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int m3132s = m3132s(i4);
            if (i == m3132s) {
                return i4;
            }
            if (i < m3132s) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: B */
    private static int m3168B(int i) {
        return (i >>> 20) & 255;
    }

    /* renamed from: C */
    private final int m3167C(int i) {
        return this.f6320c[i + 1];
    }

    /* renamed from: D */
    private static long m3166D(int i) {
        return i & 1048575;
    }

    /* renamed from: E */
    private static long m3165E(Object obj, long j) {
        return ((Long) bpu.m2896h(obj, j)).longValue();
    }

    /* renamed from: F */
    private final bnh m3164F(int i) {
        int i2 = i / 3;
        return (bnh) this.f6321d[i2 + i2 + 1];
    }

    /* renamed from: G */
    private final boy m3163G(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.f6321d;
        boy boyVar = (boy) objArr[i3];
        if (boyVar != null) {
            return boyVar;
        }
        boy m3119b = boq.m3120a().m3119b((Class) objArr[i3 + 1]);
        this.f6321d[i3] = m3119b;
        return m3119b;
    }

    /* renamed from: H */
    private final Object m3162H(int i) {
        int i2 = i / 3;
        return this.f6321d[i2 + i2];
    }

    /* renamed from: I */
    private static Field m3161I(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* renamed from: J */
    private static List m3160J(Object obj, long j) {
        return (List) bpu.m2896h(obj, j);
    }

    /* renamed from: K */
    private final void m3159K(Object obj, Object obj2, int i) {
        long m3166D = m3166D(m3167C(i));
        if (m3150T(obj2, i)) {
            Object m2896h = bpu.m2896h(obj, m3166D);
            Object m2896h2 = bpu.m2896h(obj2, m3166D);
            if (m2896h != null && m2896h2 != null) {
                bpu.m2881w(obj, m3166D, bnk.m3264e(m2896h, m2896h2));
                m3156N(obj, i);
            } else if (m2896h2 != null) {
                bpu.m2881w(obj, m3166D, m2896h2);
                m3156N(obj, i);
            }
        }
    }

    /* renamed from: L */
    private final void m3158L(Object obj, Object obj2, int i) {
        int m3167C = m3167C(i);
        int m3132s = m3132s(i);
        long m3166D = m3166D(m3167C);
        if (m3147W(obj2, m3132s, i)) {
            Object m2896h = m3147W(obj, m3132s, i) ? bpu.m2896h(obj, m3166D) : null;
            Object m2896h2 = bpu.m2896h(obj2, m3166D);
            if (m2896h != null && m2896h2 != null) {
                bpu.m2881w(obj, m3166D, bnk.m3264e(m2896h, m2896h2));
                m3155O(obj, m3132s, i);
            } else if (m2896h2 != null) {
                bpu.m2881w(obj, m3166D, m2896h2);
                m3155O(obj, m3132s, i);
            }
        }
    }

    /* renamed from: M */
    private final void m3157M(Object obj, int i, bot botVar) throws IOException {
        if (m3151S(i)) {
            bpu.m2881w(obj, m3166D(i), botVar.mo3070x());
        } else if (this.f6326i) {
            bpu.m2881w(obj, m3166D(i), botVar.mo3071v());
        } else {
            bpu.m2881w(obj, m3166D(i), botVar.mo3076q());
        }
    }

    /* renamed from: N */
    private final void m3156N(Object obj, int i) {
        int m3125z = m3125z(i);
        long j = 1048575 & m3125z;
        if (j == 1048575) {
            return;
        }
        bpu.m2883u(obj, j, (1 << (m3125z >>> 20)) | bpu.m2900d(obj, j));
    }

    /* renamed from: O */
    private final void m3155O(Object obj, int i, int i2) {
        bpu.m2883u(obj, m3125z(i2) & 1048575, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x048b  */
    /* renamed from: P */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m3154P(java.lang.Object r18, com.google.ads.interactivemedia.p034v3.internal.bqc r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.m3154P(java.lang.Object, com.google.ads.interactivemedia.v3.internal.bqc):void");
    }

    /* renamed from: Q */
    private final void m3153Q(bqc bqcVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            bqcVar.mo2817v(i, bqd.m2806G(m3162H(i2)), bqd.m2807F(obj));
        }
    }

    /* renamed from: R */
    private final boolean m3152R(Object obj, Object obj2, int i) {
        return m3150T(obj, i) == m3150T(obj2, i);
    }

    /* renamed from: S */
    private static boolean m3151S(int i) {
        return (i & 536870912) != 0;
    }

    /* renamed from: T */
    private final boolean m3150T(Object obj, int i) {
        int m3125z = m3125z(i);
        long j = 1048575 & m3125z;
        if (j != 1048575) {
            return (bpu.m2900d(obj, j) & (1 << (m3125z >>> 20))) != 0;
        }
        int m3167C = m3167C(i);
        long m3166D = m3166D(m3167C);
        switch (m3168B(m3167C)) {
            case 0:
                return Double.doubleToRawLongBits(bpu.m2902b(obj, m3166D)) != 0;
            case 1:
                return Float.floatToRawIntBits(bpu.m2901c(obj, m3166D)) != 0;
            case 2:
                return bpu.m2898f(obj, m3166D) != 0;
            case 3:
                return bpu.m2898f(obj, m3166D) != 0;
            case 4:
                return bpu.m2900d(obj, m3166D) != 0;
            case 5:
                return bpu.m2898f(obj, m3166D) != 0;
            case 6:
                return bpu.m2900d(obj, m3166D) != 0;
            case 7:
                return bpu.m2914A(obj, m3166D);
            case 8:
                Object m2896h = bpu.m2896h(obj, m3166D);
                if (m2896h instanceof String) {
                    return !((String) m2896h).isEmpty();
                } else if (m2896h instanceof bls) {
                    return !bls.f6015b.equals(m2896h);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return bpu.m2896h(obj, m3166D) != null;
            case 10:
                return !bls.f6015b.equals(bpu.m2896h(obj, m3166D));
            case 11:
                return bpu.m2900d(obj, m3166D) != 0;
            case 12:
                return bpu.m2900d(obj, m3166D) != 0;
            case 13:
                return bpu.m2900d(obj, m3166D) != 0;
            case 14:
                return bpu.m2898f(obj, m3166D) != 0;
            case 15:
                return bpu.m2900d(obj, m3166D) != 0;
            case 16:
                return bpu.m2898f(obj, m3166D) != 0;
            case 17:
                return bpu.m2896h(obj, m3166D) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: U */
    private final boolean m3149U(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return m3150T(obj, i);
        }
        return (i3 & i4) != 0;
    }

    /* renamed from: V */
    private static boolean m3148V(Object obj, int i, boy boyVar) {
        return boyVar.mo3031l(bpu.m2896h(obj, m3166D(i)));
    }

    /* renamed from: W */
    private final boolean m3147W(Object obj, int i, int i2) {
        return bpu.m2900d(obj, (long) (m3125z(i2) & 1048575)) == i;
    }

    /* renamed from: X */
    private static boolean m3146X(Object obj, long j) {
        return ((Boolean) bpu.m2896h(obj, j)).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x029e, code lost:
        if (r0 != r32) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02a0, code lost:
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r7 = r19;
        r2 = r20;
        r6 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b4, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02e7, code lost:
        if (r0 != r15) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x030a, code lost:
        if (r0 != r15) goto L153;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m3145Y(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.ads.interactivemedia.p034v3.internal.blf r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.m3145Y(java.lang.Object, byte[], int, int, com.google.ads.interactivemedia.v3.internal.blf):void");
    }

    /* renamed from: Z */
    private static final void m3144Z(int i, Object obj, bqc bqcVar) throws IOException {
        if (obj instanceof String) {
            bqcVar.mo2843H(i, (String) obj);
        } else {
            bqcVar.mo2835d(i, (bls) obj);
        }
    }

    /* renamed from: aa */
    private final Object m3143aa(Object obj, int i, Object obj2, bqd bqdVar) {
        bnh m3164F;
        int m3132s = m3132s(i);
        Object m2896h = bpu.m2896h(obj, m3166D(m3167C(i)));
        if (m2896h == null || (m3164F = m3164F(i)) == null) {
            return obj2;
        }
        Map m2805H = bqd.m2805H(m2896h);
        bod m2806G = bqd.m2806G(m3162H(i));
        Iterator it = m2805H.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!m3164F.mo2742a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = bpm.m2947e();
                }
                int m2799N = bqd.m2799N(m2806G, entry.getKey(), entry.getValue());
                bls blsVar = bls.f6015b;
                byte[] bArr = new byte[m2799N];
                bma m3426B = bma.m3426B(bArr);
                try {
                    bqd.m2798O(bnv.m3210ay(m3426B), m2806G, entry.getKey(), entry.getValue());
                    bqd.m2777q(obj2, m3132s, bnv.m3211ax(m3426B, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    /* renamed from: ab */
    private static final int m3142ab(bqd bqdVar, Object obj) {
        int m2951a;
        m2951a = ((bpm) bqdVar.m2784j(obj)).m2951a();
        return m2951a;
    }

    /* renamed from: ac */
    private static final void m3141ac(bqd bqdVar, Object obj, bqc bqcVar) throws IOException {
        ((bpm) bqdVar.m2784j(obj)).m2942j(bqcVar);
    }

    /* renamed from: d */
    static bpm m3139d(Object obj) {
        bnd bndVar = (bnd) obj;
        bpm bpmVar = bndVar.f6259c;
        if (bpmVar == bpm.m2949c()) {
            bpm m2947e = bpm.m2947e();
            bndVar.f6259c = m2947e;
            return m2947e;
        }
        return bpmVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.ads.interactivemedia.p034v3.internal.bol m3138m(com.google.ads.interactivemedia.p034v3.internal.bos r34, com.google.ads.interactivemedia.p034v3.internal.bqd r35, com.google.ads.interactivemedia.p034v3.internal.bny r36, com.google.ads.interactivemedia.p034v3.internal.bqd r37, com.google.ads.interactivemedia.p034v3.internal.bnv r38, com.google.ads.interactivemedia.p034v3.internal.bqd r39) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.m3138m(com.google.ads.interactivemedia.v3.internal.bos, com.google.ads.interactivemedia.v3.internal.bqd, com.google.ads.interactivemedia.v3.internal.bny, com.google.ads.interactivemedia.v3.internal.bqd, com.google.ads.interactivemedia.v3.internal.bnv, com.google.ads.interactivemedia.v3.internal.bqd):com.google.ads.interactivemedia.v3.internal.bol");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static bol m3137n(bog bogVar, bqd bqdVar, bny bnyVar, bqd bqdVar2, bnv bnvVar, bqd bqdVar3) {
        if (bogVar instanceof bos) {
            return m3138m((bos) bogVar, bqdVar, bnyVar, bqdVar2, bnvVar, bqdVar3);
        }
        bpj bpjVar = (bpj) bogVar;
        throw null;
    }

    /* renamed from: o */
    private static double m3136o(Object obj, long j) {
        return ((Double) bpu.m2896h(obj, j)).doubleValue();
    }

    /* renamed from: p */
    private static float m3135p(Object obj, long j) {
        return ((Float) bpu.m2896h(obj, j)).floatValue();
    }

    /* renamed from: q */
    private final int m3134q(Object obj) {
        int i;
        int m3393ah;
        int m2997e;
        int m3368u;
        int m3366w;
        Unsafe unsafe = f6319b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1048575;
        for (int i5 = 0; i5 < this.f6320c.length; i5 += 3) {
            int m3167C = m3167C(i5);
            int m3132s = m3132s(i5);
            int m3168B = m3168B(m3167C);
            if (m3168B <= 17) {
                int i6 = this.f6320c[i5 + 2];
                int i7 = i6 & 1048575;
                i = 1 << (i6 >>> 20);
                if (i7 != i4) {
                    i3 = unsafe.getInt(obj, i7);
                    i4 = i7;
                }
            } else {
                i = 0;
            }
            long m3166D = m3166D(m3167C);
            switch (m3168B) {
                case 0:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3393ah(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3390ak(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3380i(m3132s, unsafe.getLong(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3365x(m3132s, unsafe.getLong(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3382g(m3132s, unsafe.getInt(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3391aj(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3392ai(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3394ag(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i3 & i) != 0) {
                        Object object = unsafe.getObject(obj, m3166D);
                        if (object instanceof bls) {
                            m3393ah = bma.m3387b(m3132s, (bls) object);
                        } else {
                            m3393ah = bma.m3370s(m3132s, (String) object);
                        }
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i3 & i) != 0) {
                        m3393ah = bpa.m2993i(m3132s, unsafe.getObject(obj, m3166D), m3163G(i5));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3387b(m3132s, (bls) unsafe.getObject(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3367v(m3132s, unsafe.getInt(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3385d(m3132s, unsafe.getInt(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3389al(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3388am(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3374o(m3132s, unsafe.getInt(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3372q(m3132s, unsafe.getLong(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i3 & i) != 0) {
                        m3393ah = bma.m3384e(m3132s, (boj) unsafe.getObject(obj, m3166D), m3163G(i5));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    m3393ah = bpa.m3017M(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 19:
                    m3393ah = bpa.m3018L(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 20:
                    m3393ah = bpa.m3015O(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 21:
                    m3393ah = bpa.m3011S(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 22:
                    m3393ah = bpa.m3016N(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 23:
                    m3393ah = bpa.m3017M(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 24:
                    m3393ah = bpa.m3018L(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 25:
                    m3393ah = bpa.m3020J(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 26:
                    m3393ah = bpa.m2989m(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 27:
                    m3393ah = bpa.m2992j(m3132s, (List) unsafe.getObject(obj, m3166D), m3163G(i5));
                    i2 += m3393ah;
                    break;
                case 28:
                    m3393ah = bpa.m3000b(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 29:
                    m3393ah = bpa.m3012R(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 30:
                    m3393ah = bpa.m3019K(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 31:
                    m3393ah = bpa.m3018L(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 32:
                    m3393ah = bpa.m3017M(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 33:
                    m3393ah = bpa.m3014P(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 34:
                    m3393ah = bpa.m3013Q(m3132s, (List) unsafe.getObject(obj, m3166D));
                    i2 += m3393ah;
                    break;
                case 35:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    m2997e = bpa.m2994h((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    m2997e = bpa.m2987o((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    m2997e = bpa.m2995g((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    m2997e = bpa.m3003a((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    m2997e = bpa.m2988n((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    m2997e = bpa.m2999c((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    m2997e = bpa.m2991k((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    m2997e = bpa.m2990l((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i2 += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    m3393ah = bpa.m2996f(m3132s, (List) unsafe.getObject(obj, m3166D), m3163G(i5));
                    i2 += m3393ah;
                    break;
                case 50:
                    bqd.m2804I(unsafe.getObject(obj, m3166D), m3162H(i5));
                    break;
                case 51:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3393ah(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3390ak(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3380i(m3132s, m3165E(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3365x(m3132s, m3165E(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3382g(m3132s, m3131t(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3391aj(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3392ai(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3394ag(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m3147W(obj, m3132s, i5)) {
                        Object object2 = unsafe.getObject(obj, m3166D);
                        if (object2 instanceof bls) {
                            m3393ah = bma.m3387b(m3132s, (bls) object2);
                        } else {
                            m3393ah = bma.m3370s(m3132s, (String) object2);
                        }
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bpa.m2993i(m3132s, unsafe.getObject(obj, m3166D), m3163G(i5));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3387b(m3132s, (bls) unsafe.getObject(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3367v(m3132s, m3131t(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3385d(m3132s, m3131t(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3389al(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3388am(m3132s);
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3374o(m3132s, m3131t(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3372q(m3132s, m3165E(obj, m3166D));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m3147W(obj, m3132s, i5)) {
                        m3393ah = bma.m3384e(m3132s, (boj) unsafe.getObject(obj, m3166D), m3163G(i5));
                        i2 += m3393ah;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int m3142ab = i2 + m3142ab(this.f6333p, obj);
        if (this.f6325h) {
            bmu m3218aq = bnv.m3218aq(obj);
            int i8 = 0;
            for (int i9 = 0; i9 < m3218aq.f6180a.m2969b(); i9++) {
                Map.Entry m2964g = m3218aq.f6180a.m2964g(i9);
                i8 += bmu.m3336b((bmt) m2964g.getKey(), m2964g.getValue());
            }
            for (Map.Entry entry : m3218aq.f6180a.m2967d()) {
                i8 += bmu.m3336b((bmt) entry.getKey(), entry.getValue());
            }
            return m3142ab + i8;
        }
        return m3142ab;
    }

    /* renamed from: r */
    private final int m3133r(Object obj) {
        int m3393ah;
        int m2997e;
        int m3368u;
        int m3366w;
        Unsafe unsafe = f6319b;
        int i = 0;
        for (int i2 = 0; i2 < this.f6320c.length; i2 += 3) {
            int m3167C = m3167C(i2);
            int m3168B = m3168B(m3167C);
            int m3132s = m3132s(i2);
            long m3166D = m3166D(m3167C);
            if (m3168B >= bmw.DOUBLE_LIST_PACKED.m3317a() && m3168B <= bmw.SINT64_LIST_PACKED.m3317a()) {
                int i3 = this.f6320c[i2 + 2];
            }
            switch (m3168B) {
                case 0:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3393ah(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3390ak(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3380i(m3132s, bpu.m2898f(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3365x(m3132s, bpu.m2898f(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3382g(m3132s, bpu.m2900d(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3391aj(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3392ai(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3394ag(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (m3150T(obj, i2)) {
                        Object m2896h = bpu.m2896h(obj, m3166D);
                        if (m2896h instanceof bls) {
                            m3393ah = bma.m3387b(m3132s, (bls) m2896h);
                        } else {
                            m3393ah = bma.m3370s(m3132s, (String) m2896h);
                        }
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (m3150T(obj, i2)) {
                        m3393ah = bpa.m2993i(m3132s, bpu.m2896h(obj, m3166D), m3163G(i2));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3387b(m3132s, (bls) bpu.m2896h(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3367v(m3132s, bpu.m2900d(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3385d(m3132s, bpu.m2900d(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3389al(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3388am(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3374o(m3132s, bpu.m2900d(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3372q(m3132s, bpu.m2898f(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (m3150T(obj, i2)) {
                        m3393ah = bma.m3384e(m3132s, (boj) bpu.m2896h(obj, m3166D), m3163G(i2));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    m3393ah = bpa.m3017M(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 19:
                    m3393ah = bpa.m3018L(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 20:
                    m3393ah = bpa.m3015O(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 21:
                    m3393ah = bpa.m3011S(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 22:
                    m3393ah = bpa.m3016N(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 23:
                    m3393ah = bpa.m3017M(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 24:
                    m3393ah = bpa.m3018L(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 25:
                    m3393ah = bpa.m3020J(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 26:
                    m3393ah = bpa.m2989m(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 27:
                    m3393ah = bpa.m2992j(m3132s, m3160J(obj, m3166D), m3163G(i2));
                    i += m3393ah;
                    break;
                case 28:
                    m3393ah = bpa.m3000b(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 29:
                    m3393ah = bpa.m3012R(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 30:
                    m3393ah = bpa.m3019K(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 31:
                    m3393ah = bpa.m3018L(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 32:
                    m3393ah = bpa.m3017M(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 33:
                    m3393ah = bpa.m3014P(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 34:
                    m3393ah = bpa.m3013Q(m3132s, m3160J(obj, m3166D));
                    i += m3393ah;
                    break;
                case 35:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    m2997e = bpa.m2994h((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    m2997e = bpa.m2987o((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    m2997e = bpa.m2995g((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    m2997e = bpa.m3003a((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    m2997e = bpa.m2988n((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    m2997e = bpa.m2999c((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    m2997e = bpa.m2998d((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    m2997e = bpa.m2997e((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    m2997e = bpa.m2991k((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    m2997e = bpa.m2990l((List) unsafe.getObject(obj, m3166D));
                    if (m2997e > 0) {
                        m3368u = bma.m3368u(m3132s);
                        m3366w = bma.m3366w(m2997e);
                        i += m3368u + m3366w + m2997e;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    m3393ah = bpa.m2996f(m3132s, m3160J(obj, m3166D), m3163G(i2));
                    i += m3393ah;
                    break;
                case 50:
                    bqd.m2804I(bpu.m2896h(obj, m3166D), m3162H(i2));
                    break;
                case 51:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3393ah(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3390ak(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3380i(m3132s, m3165E(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3365x(m3132s, m3165E(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3382g(m3132s, m3131t(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3391aj(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3392ai(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3394ag(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m3147W(obj, m3132s, i2)) {
                        Object m2896h2 = bpu.m2896h(obj, m3166D);
                        if (m2896h2 instanceof bls) {
                            m3393ah = bma.m3387b(m3132s, (bls) m2896h2);
                        } else {
                            m3393ah = bma.m3370s(m3132s, (String) m2896h2);
                        }
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bpa.m2993i(m3132s, bpu.m2896h(obj, m3166D), m3163G(i2));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3387b(m3132s, (bls) bpu.m2896h(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3367v(m3132s, m3131t(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3385d(m3132s, m3131t(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3389al(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3388am(m3132s);
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3374o(m3132s, m3131t(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3372q(m3132s, m3165E(obj, m3166D));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m3147W(obj, m3132s, i2)) {
                        m3393ah = bma.m3384e(m3132s, (boj) bpu.m2896h(obj, m3166D), m3163G(i2));
                        i += m3393ah;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i + m3142ab(this.f6333p, obj);
    }

    /* renamed from: s */
    private final int m3132s(int i) {
        return this.f6320c[i];
    }

    /* renamed from: t */
    private static int m3131t(Object obj, long j) {
        return ((Integer) bpu.m2896h(obj, j)).intValue();
    }

    /* renamed from: u */
    private final int m3130u(Object obj, byte[] bArr, int i, int i2, int i3, long j, blf blfVar) throws IOException {
        Unsafe unsafe = f6319b;
        Object m3162H = m3162H(i3);
        Object object = unsafe.getObject(obj, j);
        if (bqd.m2803J(object)) {
            Object m2801L = bqd.m2801L();
            bqd.m2802K(m2801L, object);
            unsafe.putObject(obj, j, m2801L);
            object = m2801L;
        }
        bod m2806G = bqd.m2806G(m3162H);
        Map m2805H = bqd.m2805H(object);
        int m3227aK = bnv.m3227aK(bArr, i, blfVar);
        int i4 = blfVar.f5994a;
        if (i4 < 0 || i4 > i2 - m3227aK) {
            throw bnm.m3250i();
        }
        int i5 = i4 + m3227aK;
        Object obj2 = m2806G.f6311b;
        Object obj3 = m2806G.f6313d;
        while (m3227aK < i5) {
            int i6 = m3227aK + 1;
            int i7 = bArr[m3227aK];
            if (i7 < 0) {
                i6 = bnv.m3226aL(i7, bArr, i6, blfVar);
                i7 = blfVar.f5994a;
            }
            int i8 = i7 >>> 3;
            if (i8 == 1) {
                bpz bpzVar = m2806G.f6310a;
                throw null;
            } else if (i8 != 2) {
                m3227aK = bnv.m3223aO(i7, bArr, i6, i2, blfVar);
            } else {
                bpz bpzVar2 = m2806G.f6312c;
                throw null;
            }
        }
        if (m3227aK != i5) {
            throw bnm.m3252g();
        }
        m2805H.put(null, null);
        return i5;
    }

    /* renamed from: v */
    private final int m3129v(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, blf blfVar) throws IOException {
        Unsafe unsafe = f6319b;
        long j2 = this.f6320c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(bnv.m3209az(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(bnv.m3237aA(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int m3224aN = bnv.m3224aN(bArr, i, blfVar);
                    unsafe.putObject(obj, j, Long.valueOf(blfVar.f5995b));
                    unsafe.putInt(obj, j2, i4);
                    return m3224aN;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int m3227aK = bnv.m3227aK(bArr, i, blfVar);
                    unsafe.putObject(obj, j, Integer.valueOf(blfVar.f5994a));
                    unsafe.putInt(obj, j2, i4);
                    return m3227aK;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(bnv.m3222aP(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(bnv.m3235aC(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int m3224aN2 = bnv.m3224aN(bArr, i, blfVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(blfVar.f5995b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return m3224aN2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int m3227aK2 = bnv.m3227aK(bArr, i, blfVar);
                    int i9 = blfVar.f5994a;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else if ((i6 & 536870912) == 0 || bpy.m2862j(bArr, m3227aK2, m3227aK2 + i9)) {
                        unsafe.putObject(obj, j, new String(bArr, m3227aK2, i9, bnk.f6265b));
                        m3227aK2 += i9;
                    } else {
                        throw bnm.m3255d();
                    }
                    unsafe.putInt(obj, j2, i4);
                    return m3227aK2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int m3233aE = bnv.m3233aE(m3163G(i8), bArr, i, i2, blfVar);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, blfVar.f5996c);
                    } else {
                        unsafe.putObject(obj, j, bnk.m3264e(object, blfVar.f5996c));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return m3233aE;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int m3236aB = bnv.m3236aB(bArr, i, blfVar);
                    unsafe.putObject(obj, j, blfVar.f5996c);
                    unsafe.putInt(obj, j2, i4);
                    return m3236aB;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int m3227aK3 = bnv.m3227aK(bArr, i, blfVar);
                    int i10 = blfVar.f5994a;
                    bnh m3164F = m3164F(i8);
                    if (m3164F == null || m3164F.mo2742a(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        m3139d(obj).m2944h(i3, Long.valueOf(i10));
                    }
                    return m3227aK3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int m3227aK4 = bnv.m3227aK(bArr, i, blfVar);
                    unsafe.putObject(obj, j, Integer.valueOf(blw.m3458F(blfVar.f5994a)));
                    unsafe.putInt(obj, j2, i4);
                    return m3227aK4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int m3224aN3 = bnv.m3224aN(bArr, i, blfVar);
                    unsafe.putObject(obj, j, Long.valueOf(blw.m3457G(blfVar.f5995b)));
                    unsafe.putInt(obj, j2, i4);
                    return m3224aN3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int m3234aD = bnv.m3234aD(m3163G(i8), bArr, i, i2, (i3 & (-8)) | 4, blfVar);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j, blfVar.f5996c);
                    } else {
                        unsafe.putObject(obj, j, bnk.m3264e(object2, blfVar.f5996c));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return m3234aD;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x021a -> B:120:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014f -> B:67:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01cc -> B:100:0x01cd). Please submit an issue!!! */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int m3128w(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.ads.interactivemedia.p034v3.internal.blf r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.m3128w(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.ads.interactivemedia.v3.internal.blf):int");
    }

    /* renamed from: x */
    private final int m3127x(int i) {
        if (i < this.f6322e || i > this.f6323f) {
            return -1;
        }
        return m3169A(i, 0);
    }

    /* renamed from: y */
    private final int m3126y(int i, int i2) {
        if (i < this.f6322e || i > this.f6323f) {
            return -1;
        }
        return m3169A(i, i2);
    }

    /* renamed from: z */
    private final int m3125z(int i) {
        return this.f6320c[i + 2];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: a */
    public final int mo3040a(Object obj) {
        return this.f6327j ? m3133r(obj) : m3134q(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: b */
    public final int mo3039b(Object obj) {
        int i;
        int m3266c;
        int length = this.f6320c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int m3167C = m3167C(i3);
            int m3132s = m3132s(i3);
            long m3166D = m3166D(m3167C);
            int i4 = 37;
            switch (m3168B(m3167C)) {
                case 0:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(Double.doubleToLongBits(bpu.m2902b(obj, m3166D)));
                    i2 = i + m3266c;
                    break;
                case 1:
                    i = i2 * 53;
                    m3266c = Float.floatToIntBits(bpu.m2901c(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 2:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(bpu.m2898f(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 3:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(bpu.m2898f(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 4:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 5:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(bpu.m2898f(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 6:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 7:
                    i = i2 * 53;
                    m3266c = bnk.m3268a(bpu.m2914A(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 8:
                    i = i2 * 53;
                    m3266c = ((String) bpu.m2896h(obj, m3166D)).hashCode();
                    i2 = i + m3266c;
                    break;
                case 9:
                    Object m2896h = bpu.m2896h(obj, m3166D);
                    if (m2896h != null) {
                        i4 = m2896h.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 10:
                    i = i2 * 53;
                    m3266c = bpu.m2896h(obj, m3166D).hashCode();
                    i2 = i + m3266c;
                    break;
                case 11:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 12:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 13:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 14:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(bpu.m2898f(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 15:
                    i = i2 * 53;
                    m3266c = bpu.m2900d(obj, m3166D);
                    i2 = i + m3266c;
                    break;
                case 16:
                    i = i2 * 53;
                    m3266c = bnk.m3266c(bpu.m2898f(obj, m3166D));
                    i2 = i + m3266c;
                    break;
                case 17:
                    Object m2896h2 = bpu.m2896h(obj, m3166D);
                    if (m2896h2 != null) {
                        i4 = m2896h2.hashCode();
                    }
                    i2 = (i2 * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    m3266c = bpu.m2896h(obj, m3166D).hashCode();
                    i2 = i + m3266c;
                    break;
                case 50:
                    i = i2 * 53;
                    m3266c = bpu.m2896h(obj, m3166D).hashCode();
                    i2 = i + m3266c;
                    break;
                case 51:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(Double.doubleToLongBits(m3136o(obj, m3166D)));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = Float.floatToIntBits(m3135p(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(m3165E(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(m3165E(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(m3165E(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3268a(m3146X(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = ((String) bpu.m2896h(obj, m3166D)).hashCode();
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bpu.m2896h(obj, m3166D).hashCode();
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bpu.m2896h(obj, m3166D).hashCode();
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(m3165E(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = m3131t(obj, m3166D);
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bnk.m3266c(m3165E(obj, m3166D));
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m3147W(obj, m3132s, i3)) {
                        i = i2 * 53;
                        m3266c = bpu.m2896h(obj, m3166D).hashCode();
                        i2 = i + m3266c;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.f6333p.m2784j(obj).hashCode();
        return this.f6325h ? (hashCode * 53) + bnv.m3218aq(obj).hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x054e  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3140c(java.lang.Object r32, byte[] r33, int r34, int r35, int r36, com.google.ads.interactivemedia.p034v3.internal.blf r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.m3140c(java.lang.Object, byte[], int, int, int, com.google.ads.interactivemedia.v3.internal.blf):int");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: e */
    public final Object mo3038e() {
        return bqd.m2810C(this.f6324g);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: f */
    public final void mo3037f(Object obj) {
        int i;
        int i2 = this.f6330m;
        while (true) {
            i = this.f6331n;
            if (i2 >= i) {
                break;
            }
            long m3166D = m3166D(m3167C(this.f6329l[i2]));
            Object m2896h = bpu.m2896h(obj, m3166D);
            if (m2896h != null) {
                bqd.m2800M(m2896h);
                bpu.m2881w(obj, m3166D, m2896h);
            }
            i2++;
        }
        int length = this.f6329l.length;
        while (i < length) {
            this.f6332o.mo3204c(obj, this.f6329l[i]);
            i++;
        }
        this.f6333p.m2783k(obj);
        if (this.f6325h) {
            this.f6334q.m3221an(obj);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: h */
    public final void mo3035h(Object obj, bot botVar, bmr bmrVar) throws IOException {
        Objects.requireNonNull(bmrVar);
        bqd bqdVar = this.f6333p;
        bmu bmuVar = null;
        Object obj2 = null;
        while (true) {
            try {
                int mo3089c = botVar.mo3089c();
                int m3127x = m3127x(mo3089c);
                if (m3127x >= 0) {
                    int m3167C = m3167C(m3127x);
                    try {
                        switch (m3168B(m3167C)) {
                            case 0:
                                bpu.m2885s(obj, m3166D(m3167C), botVar.mo3091a());
                                m3156N(obj, m3127x);
                                break;
                            case 1:
                                bpu.m2884t(obj, m3166D(m3167C), botVar.mo3090b());
                                m3156N(obj, m3127x);
                                break;
                            case 2:
                                bpu.m2882v(obj, m3166D(m3167C), botVar.mo3080l());
                                m3156N(obj, m3127x);
                                break;
                            case 3:
                                bpu.m2882v(obj, m3166D(m3167C), botVar.mo3077o());
                                m3156N(obj, m3127x);
                                break;
                            case 4:
                                bpu.m2883u(obj, m3166D(m3167C), botVar.mo3085g());
                                m3156N(obj, m3127x);
                                break;
                            case 5:
                                bpu.m2882v(obj, m3166D(m3167C), botVar.mo3081k());
                                m3156N(obj, m3127x);
                                break;
                            case 6:
                                bpu.m2883u(obj, m3166D(m3167C), botVar.mo3086f());
                                m3156N(obj, m3127x);
                                break;
                            case 7:
                                bpu.m2887q(obj, m3166D(m3167C), botVar.mo3094S());
                                m3156N(obj, m3127x);
                                break;
                            case 8:
                                m3157M(obj, m3167C, botVar);
                                m3156N(obj, m3127x);
                                break;
                            case 9:
                                if (m3150T(obj, m3127x)) {
                                    bpu.m2881w(obj, m3166D(m3167C), bnk.m3264e(bpu.m2896h(obj, m3166D(m3167C)), botVar.mo3072u(m3163G(m3127x), bmrVar)));
                                    break;
                                } else {
                                    bpu.m2881w(obj, m3166D(m3167C), botVar.mo3072u(m3163G(m3127x), bmrVar));
                                    m3156N(obj, m3127x);
                                    break;
                                }
                            case 10:
                                bpu.m2881w(obj, m3166D(m3167C), botVar.mo3076q());
                                m3156N(obj, m3127x);
                                break;
                            case 11:
                                bpu.m2883u(obj, m3166D(m3167C), botVar.mo3082j());
                                m3156N(obj, m3127x);
                                break;
                            case 12:
                                int mo3087e = botVar.mo3087e();
                                bnh m3164F = m3164F(m3127x);
                                if (m3164F != null && !m3164F.mo2742a(mo3087e)) {
                                    obj2 = bpa.m3006X(mo3089c, mo3087e, obj2, bqdVar);
                                    break;
                                }
                                bpu.m2883u(obj, m3166D(m3167C), mo3087e);
                                m3156N(obj, m3127x);
                                break;
                            case 13:
                                bpu.m2883u(obj, m3166D(m3167C), botVar.mo3084h());
                                m3156N(obj, m3127x);
                                break;
                            case 14:
                                bpu.m2882v(obj, m3166D(m3167C), botVar.mo3079m());
                                m3156N(obj, m3127x);
                                break;
                            case 15:
                                bpu.m2883u(obj, m3166D(m3167C), botVar.mo3083i());
                                m3156N(obj, m3127x);
                                break;
                            case 16:
                                bpu.m2882v(obj, m3166D(m3167C), botVar.mo3078n());
                                m3156N(obj, m3127x);
                                break;
                            case 17:
                                if (m3150T(obj, m3127x)) {
                                    bpu.m2881w(obj, m3166D(m3167C), bnk.m3264e(bpu.m2896h(obj, m3166D(m3167C)), botVar.mo3074s(m3163G(m3127x), bmrVar)));
                                    break;
                                } else {
                                    bpu.m2881w(obj, m3166D(m3167C), botVar.mo3074s(m3163G(m3127x), bmrVar));
                                    m3156N(obj, m3127x);
                                    break;
                                }
                            case 18:
                                botVar.mo3111A(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 19:
                                botVar.mo3107E(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 20:
                                botVar.mo3104H(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 21:
                                botVar.mo3095R(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 22:
                                botVar.mo3105G(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 23:
                                botVar.mo3108D(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 24:
                                botVar.mo3109C(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 25:
                                botVar.mo3069y(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 26:
                                if (m3151S(m3167C)) {
                                    botVar.mo3097P(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                    break;
                                } else {
                                    botVar.mo3098N(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                    break;
                                }
                            case 27:
                                botVar.mo3103I(this.f6332o.mo3205b(obj, m3166D(m3167C)), m3163G(m3127x), bmrVar);
                                break;
                            case 28:
                                botVar.mo3068z(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 29:
                                botVar.mo3096Q(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 30:
                                List mo3205b = this.f6332o.mo3205b(obj, m3166D(m3167C));
                                botVar.mo3110B(mo3205b);
                                obj2 = bpa.m3007W(mo3089c, mo3205b, m3164F(m3127x), obj2, bqdVar);
                                break;
                            case 31:
                                botVar.mo3102J(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 32:
                                botVar.mo3101K(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 33:
                                botVar.mo3100L(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 34:
                                botVar.mo3099M(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 35:
                                botVar.mo3111A(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 36:
                                botVar.mo3107E(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 37:
                                botVar.mo3104H(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 38:
                                botVar.mo3095R(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 39:
                                botVar.mo3105G(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 40:
                                botVar.mo3108D(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 41:
                                botVar.mo3109C(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 42:
                                botVar.mo3069y(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 43:
                                botVar.mo3096Q(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 44:
                                List mo3205b2 = this.f6332o.mo3205b(obj, m3166D(m3167C));
                                botVar.mo3110B(mo3205b2);
                                obj2 = bpa.m3007W(mo3089c, mo3205b2, m3164F(m3127x), obj2, bqdVar);
                                break;
                            case 45:
                                botVar.mo3102J(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 46:
                                botVar.mo3101K(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 47:
                                botVar.mo3100L(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 48:
                                botVar.mo3099M(this.f6332o.mo3205b(obj, m3166D(m3167C)));
                                break;
                            case 49:
                                botVar.mo3106F(this.f6332o.mo3205b(obj, m3166D(m3167C)), m3163G(m3127x), bmrVar);
                                break;
                            case 50:
                                Object m3162H = m3162H(m3127x);
                                long m3166D = m3166D(m3167C(m3127x));
                                Object m2896h = bpu.m2896h(obj, m3166D);
                                if (m2896h == null) {
                                    m2896h = bqd.m2801L();
                                    bpu.m2881w(obj, m3166D, m2896h);
                                } else if (bqd.m2803J(m2896h)) {
                                    Object m2801L = bqd.m2801L();
                                    bqd.m2802K(m2801L, m2896h);
                                    bpu.m2881w(obj, m3166D, m2801L);
                                    m2896h = m2801L;
                                }
                                botVar.mo3092U(bqd.m2805H(m2896h), bqd.m2806G(m3162H));
                                break;
                            case 51:
                                bpu.m2881w(obj, m3166D(m3167C), Double.valueOf(botVar.mo3091a()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 52:
                                bpu.m2881w(obj, m3166D(m3167C), Float.valueOf(botVar.mo3090b()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 53:
                                bpu.m2881w(obj, m3166D(m3167C), Long.valueOf(botVar.mo3080l()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 54:
                                bpu.m2881w(obj, m3166D(m3167C), Long.valueOf(botVar.mo3077o()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 55:
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(botVar.mo3085g()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 56:
                                bpu.m2881w(obj, m3166D(m3167C), Long.valueOf(botVar.mo3081k()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 57:
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(botVar.mo3086f()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 58:
                                bpu.m2881w(obj, m3166D(m3167C), Boolean.valueOf(botVar.mo3094S()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 59:
                                m3157M(obj, m3167C, botVar);
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 60:
                                if (m3147W(obj, mo3089c, m3127x)) {
                                    bpu.m2881w(obj, m3166D(m3167C), bnk.m3264e(bpu.m2896h(obj, m3166D(m3167C)), botVar.mo3072u(m3163G(m3127x), bmrVar)));
                                } else {
                                    bpu.m2881w(obj, m3166D(m3167C), botVar.mo3072u(m3163G(m3127x), bmrVar));
                                    m3156N(obj, m3127x);
                                }
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 61:
                                bpu.m2881w(obj, m3166D(m3167C), botVar.mo3076q());
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 62:
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(botVar.mo3082j()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 63:
                                int mo3087e2 = botVar.mo3087e();
                                bnh m3164F2 = m3164F(m3127x);
                                if (m3164F2 != null && !m3164F2.mo2742a(mo3087e2)) {
                                    obj2 = bpa.m3006X(mo3089c, mo3087e2, obj2, bqdVar);
                                    break;
                                }
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(mo3087e2));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 64:
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(botVar.mo3084h()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 65:
                                bpu.m2881w(obj, m3166D(m3167C), Long.valueOf(botVar.mo3079m()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 66:
                                bpu.m2881w(obj, m3166D(m3167C), Integer.valueOf(botVar.mo3083i()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 67:
                                bpu.m2881w(obj, m3166D(m3167C), Long.valueOf(botVar.mo3078n()));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            case 68:
                                bpu.m2881w(obj, m3166D(m3167C), botVar.mo3074s(m3163G(m3127x), bmrVar));
                                m3155O(obj, mo3089c, m3127x);
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = bpm.m2947e();
                                }
                                if (!bqdVar.m2786h(obj2, botVar)) {
                                    for (int i = this.f6330m; i < this.f6331n; i++) {
                                        obj2 = m3143aa(obj, this.f6329l[i], obj2, bqdVar);
                                    }
                                    if (obj2 != null) {
                                        bqdVar.m2782l(obj, obj2);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    } catch (bnl unused) {
                        if (obj2 == null) {
                            obj2 = bqdVar.m2785i(obj);
                        }
                        if (!bqdVar.m2786h(obj2, botVar)) {
                            for (int i2 = this.f6330m; i2 < this.f6331n; i2++) {
                                obj2 = m3143aa(obj, this.f6329l[i2], obj2, bqdVar);
                            }
                            if (obj2 != null) {
                                bqdVar.m2782l(obj, obj2);
                                return;
                            }
                            return;
                        }
                    }
                } else if (mo3089c == Integer.MAX_VALUE) {
                    for (int i3 = this.f6330m; i3 < this.f6331n; i3++) {
                        obj2 = m3143aa(obj, this.f6329l[i3], obj2, bqdVar);
                    }
                    if (obj2 != null) {
                        bqdVar.m2782l(obj, obj2);
                        return;
                    }
                    return;
                } else {
                    Object m3219ap = !this.f6325h ? null : bnv.m3219ap(bmrVar, this.f6324g, mo3089c);
                    if (m3219ap != null) {
                        if (bmuVar == null) {
                            bmuVar = bnv.m3217ar(obj);
                        }
                        bmu bmuVar2 = bmuVar;
                        obj2 = bnv.m3212aw(botVar, m3219ap, bmrVar, bmuVar2, obj2, bqdVar);
                        bmuVar = bmuVar2;
                    } else {
                        if (obj2 == null) {
                            obj2 = bqdVar.m2785i(obj);
                        }
                        if (!bqdVar.m2786h(obj2, botVar)) {
                            for (int i4 = this.f6330m; i4 < this.f6331n; i4++) {
                                obj2 = m3143aa(obj, this.f6329l[i4], obj2, bqdVar);
                            }
                            if (obj2 != null) {
                                bqdVar.m2782l(obj, obj2);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.f6330m; i5 < this.f6331n; i5++) {
                    obj2 = m3143aa(obj, this.f6329l[i5], obj2, bqdVar);
                }
                if (obj2 != null) {
                    bqdVar.m2782l(obj, obj2);
                }
                throw th;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: i */
    public final void mo3034i(Object obj, byte[] bArr, int i, int i2, blf blfVar) throws IOException {
        if (this.f6327j) {
            m3145Y(obj, bArr, i, i2, blfVar);
        } else {
            m3140c(obj, bArr, i, i2, 0, blfVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0586  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo3033j(java.lang.Object r13, com.google.ads.interactivemedia.p034v3.internal.bqc r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bol.mo3033j(java.lang.Object, com.google.ads.interactivemedia.v3.internal.bqc):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: k */
    public final boolean mo3032k(Object obj, Object obj2) {
        boolean m3021I;
        int length = this.f6320c.length;
        for (int i = 0; i < length; i += 3) {
            int m3167C = m3167C(i);
            long m3166D = m3166D(m3167C);
            switch (m3168B(m3167C)) {
                case 0:
                    if (m3152R(obj, obj2, i) && Double.doubleToLongBits(bpu.m2902b(obj, m3166D)) == Double.doubleToLongBits(bpu.m2902b(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (m3152R(obj, obj2, i) && Float.floatToIntBits(bpu.m2901c(obj, m3166D)) == Float.floatToIntBits(bpu.m2901c(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (m3152R(obj, obj2, i) && bpu.m2898f(obj, m3166D) == bpu.m2898f(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (m3152R(obj, obj2, i) && bpu.m2898f(obj, m3166D) == bpu.m2898f(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (m3152R(obj, obj2, i) && bpu.m2898f(obj, m3166D) == bpu.m2898f(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (m3152R(obj, obj2, i) && bpu.m2914A(obj, m3166D) == bpu.m2914A(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (m3152R(obj, obj2, i) && bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (m3152R(obj, obj2, i) && bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (m3152R(obj, obj2, i) && bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (m3152R(obj, obj2, i) && bpu.m2898f(obj, m3166D) == bpu.m2898f(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (m3152R(obj, obj2, i) && bpu.m2900d(obj, m3166D) == bpu.m2900d(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (m3152R(obj, obj2, i) && bpu.m2898f(obj, m3166D) == bpu.m2898f(obj2, m3166D)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (m3152R(obj, obj2, i) && bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    m3021I = bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D));
                    break;
                case 50:
                    m3021I = bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long m3125z = m3125z(i) & 1048575;
                    if (bpu.m2900d(obj, m3125z) == bpu.m2900d(obj2, m3125z) && bpa.m3021I(bpu.m2896h(obj, m3166D), bpu.m2896h(obj2, m3166D))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!m3021I) {
                return false;
            }
        }
        if (this.f6333p.m2784j(obj).equals(this.f6333p.m2784j(obj2))) {
            if (this.f6325h) {
                return bnv.m3218aq(obj).equals(bnv.m3218aq(obj2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: l */
    public final boolean mo3031l(Object obj) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.f6330m) {
            int i6 = this.f6329l[i5];
            int m3132s = m3132s(i6);
            int m3167C = m3167C(i6);
            int i7 = this.f6320c[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = f6319b.getInt(obj, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & m3167C) != 0 && !m3149U(obj, i6, i, i2, i9)) {
                return false;
            }
            int m3168B = m3168B(m3167C);
            if (m3168B != 9 && m3168B != 17) {
                if (m3168B != 27) {
                    if (m3168B == 60 || m3168B == 68) {
                        if (m3147W(obj, m3132s, i6) && !m3148V(obj, m3167C, m3163G(i6))) {
                            return false;
                        }
                    } else if (m3168B != 49) {
                        if (m3168B == 50 && !bqd.m2807F(bpu.m2896h(obj, m3166D(m3167C))).isEmpty()) {
                            bpz bpzVar = bqd.m2806G(m3162H(i6)).f6312c;
                            throw null;
                        }
                    }
                }
                List list = (List) bpu.m2896h(obj, m3166D(m3167C));
                if (list.isEmpty()) {
                    continue;
                } else {
                    boy m3163G = m3163G(i6);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!m3163G.mo3031l(list.get(i10))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (m3149U(obj, i6, i, i2, i9) && !m3148V(obj, m3167C, m3163G(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.f6325h || bnv.m3218aq(obj).m3324n();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: g */
    public final void mo3036g(Object obj, Object obj2) {
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.f6320c.length; i += 3) {
            int m3167C = m3167C(i);
            long m3166D = m3166D(m3167C);
            int m3132s = m3132s(i);
            switch (m3168B(m3167C)) {
                case 0:
                    if (m3150T(obj2, i)) {
                        bpu.m2885s(obj, m3166D, bpu.m2902b(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m3150T(obj2, i)) {
                        bpu.m2884t(obj, m3166D, bpu.m2901c(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m3150T(obj2, i)) {
                        bpu.m2882v(obj, m3166D, bpu.m2898f(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m3150T(obj2, i)) {
                        bpu.m2882v(obj, m3166D, bpu.m2898f(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m3150T(obj2, i)) {
                        bpu.m2882v(obj, m3166D, bpu.m2898f(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m3150T(obj2, i)) {
                        bpu.m2887q(obj, m3166D, bpu.m2914A(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (m3150T(obj2, i)) {
                        bpu.m2881w(obj, m3166D, bpu.m2896h(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    m3159K(obj, obj2, i);
                    break;
                case 10:
                    if (m3150T(obj2, i)) {
                        bpu.m2881w(obj, m3166D, bpu.m2896h(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m3150T(obj2, i)) {
                        bpu.m2882v(obj, m3166D, bpu.m2898f(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m3150T(obj2, i)) {
                        bpu.m2883u(obj, m3166D, bpu.m2900d(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m3150T(obj2, i)) {
                        bpu.m2882v(obj, m3166D, bpu.m2898f(obj2, m3166D));
                        m3156N(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    m3159K(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f6332o.mo3203d(obj, obj2, m3166D);
                    break;
                case 50:
                    bpa.m3002aa(this.f6336s, obj, obj2, m3166D);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (m3147W(obj2, m3132s, i)) {
                        bpu.m2881w(obj, m3166D, bpu.m2896h(obj2, m3166D));
                        m3155O(obj, m3132s, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    m3158L(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (m3147W(obj2, m3132s, i)) {
                        bpu.m2881w(obj, m3166D, bpu.m2896h(obj2, m3166D));
                        m3155O(obj, m3132s, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    m3158L(obj, obj2, i);
                    break;
            }
        }
        bpa.m3004Z(this.f6333p, obj, obj2);
        if (this.f6325h) {
            bpa.m3005Y(this.f6334q, obj, obj2);
        }
    }
}
