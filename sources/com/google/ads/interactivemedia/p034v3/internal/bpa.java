package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpa */
/* loaded from: classes2.dex */
public final class bpa {

    /* renamed from: a */
    private static final Class f6365a;

    /* renamed from: b */
    private static final bqd f6366b;

    /* renamed from: c */
    private static final bqd f6367c;

    /* renamed from: d */
    private static final bqd f6368d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f6365a = cls;
        f6366b = m3001ab(false);
        f6367c = m3001ab(true);
        f6368d = new bqd(null);
    }

    /* renamed from: A */
    public static void m3029A(int i, List list, bqc bqcVar, boy boyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((bmb) bqcVar).mo2816w(i, list.get(i2), boyVar);
        }
    }

    /* renamed from: B */
    public static void m3028B(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2813z(i, list, z);
    }

    /* renamed from: C */
    public static void m3027C(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2849B(i, list, z);
    }

    /* renamed from: D */
    public static void m3026D(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2847D(i, list, z);
    }

    /* renamed from: E */
    public static void m3025E(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2845F(i, list, z);
    }

    /* renamed from: F */
    public static void m3024F(int i, List list, bqc bqcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2842I(i, list);
    }

    /* renamed from: G */
    public static void m3023G(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2840K(i, list, z);
    }

    /* renamed from: H */
    public static void m3022H(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2838M(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: I */
    public static boolean m3021I(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: J */
    public static int m3020J(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bma.m3394ag(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: K */
    public static int m3019K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2999c(list) + (size * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: L */
    public static int m3018L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bma.m3392ai(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M */
    public static int m3017M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bma.m3391aj(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N */
    public static int m3016N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2995g(list) + (size * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: O */
    public static int m3015O(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return m2994h(list) + (list.size() * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: P */
    public static int m3014P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2991k(list) + (size * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Q */
    public static int m3013Q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2990l(list) + (size * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: R */
    public static int m3012R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2988n(list) + (size * bma.m3368u(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: S */
    public static int m3011S(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m2987o(list) + (size * bma.m3368u(i));
    }

    /* renamed from: T */
    public static bqd m3010T() {
        return f6366b;
    }

    /* renamed from: U */
    public static bqd m3009U() {
        return f6367c;
    }

    /* renamed from: V */
    public static bqd m3008V() {
        return f6368d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: W */
    public static Object m3007W(int i, List list, bnh bnhVar, Object obj, bqd bqdVar) {
        if (bnhVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (bnhVar.mo2742a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj = m3006X(i, intValue, obj, bqdVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!bnhVar.mo2742a(intValue2)) {
                    obj = m3006X(i, intValue2, obj, bqdVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: X */
    public static Object m3006X(int i, int i2, Object obj, bqd bqdVar) {
        if (obj == null) {
            obj = bpm.m2947e();
        }
        bqd.m2776r(obj, i, i2);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Y */
    public static void m3005Y(bnv bnvVar, Object obj, Object obj2) {
        bmu m3218aq = bnv.m3218aq(obj2);
        if (m3218aq.m3326l()) {
            return;
        }
        bnv.m3217ar(obj).m3328j(m3218aq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Z */
    public static void m3004Z(bqd bqdVar, Object obj, Object obj2) {
        bqdVar.m2781m(obj, bqd.m2772v(bqdVar.m2784j(obj), bqdVar.m2784j(obj2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m3003a(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aa */
    public static void m3002aa(bqd bqdVar, Object obj, Object obj2, long j) {
        bpu.m2881w(obj, j, bqd.m2802K(bpu.m2896h(obj, j), bpu.m2896h(obj2, j)));
    }

    /* renamed from: ab */
    private static bqd m3001ab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (bqd) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static int m3000b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m3368u = size * bma.m3368u(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            m3368u += bma.m3386c((bls) list.get(i2));
        }
        return m3368u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static int m2999c(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3381h(bneVar.m3275e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3381h(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static int m2998d(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static int m2997e(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static int m2996f(int i, List list, boy boyVar) {
        int size = list.size();
        if (size != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += bma.m3384e(i, (boj) list.get(i3), boyVar);
            }
            return i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static int m2995g(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3381h(bneVar.m3275e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3381h(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static int m2994h(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3364y(bnzVar.m3200e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3364y(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static int m2993i(int i, Object obj, boy boyVar) {
        if (obj instanceof bns) {
            return bma.m3379j(i, (bns) obj);
        }
        return bma.m3368u(i) + bma.m3375n((boj) obj, boyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static int m2992j(int i, List list, boy boyVar) {
        int m3375n;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m3368u = bma.m3368u(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof bns) {
                m3375n = bma.m3378k((bns) obj);
            } else {
                m3375n = bma.m3375n((boj) obj, boyVar);
            }
            m3368u += m3375n;
        }
        return m3368u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static int m2991k(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3373p(bneVar.m3275e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3373p(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static int m2990l(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3371r(bnzVar.m3200e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3371r(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static int m2989m(int i, List list) {
        int m3369t;
        int m3369t2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int m3368u = bma.m3368u(i) * size;
        if (list instanceof bnu) {
            bnu bnuVar = (bnu) list;
            while (i2 < size) {
                Object mo2938f = bnuVar.mo2938f(i2);
                if (mo2938f instanceof bls) {
                    m3369t2 = bma.m3386c((bls) mo2938f);
                } else {
                    m3369t2 = bma.m3369t((String) mo2938f);
                }
                m3368u += m3369t2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof bls) {
                    m3369t = bma.m3386c((bls) obj);
                } else {
                    m3369t = bma.m3369t((String) obj);
                }
                m3368u += m3369t;
                i2++;
            }
        }
        return m3368u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static int m2988n(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3366w(bneVar.m3275e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3366w(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static int m2987o(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            i = 0;
            while (i2 < size) {
                i += bma.m3364y(bnzVar.m3200e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bma.m3364y(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* renamed from: p */
    public static void m2986p(Class cls) {
        Class cls2;
        if (!bnd.class.isAssignableFrom(cls) && (cls2 = f6365a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* renamed from: q */
    public static void m2985q(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2836c(i, list, z);
    }

    /* renamed from: r */
    public static void m2984r(int i, List list, bqc bqcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2834e(i, list);
    }

    /* renamed from: s */
    public static void m2983s(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2832g(i, list, z);
    }

    /* renamed from: t */
    public static void m2982t(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2829j(i, list, z);
    }

    /* renamed from: u */
    public static void m2981u(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2827l(i, list, z);
    }

    /* renamed from: v */
    public static void m2980v(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2825n(i, list, z);
    }

    /* renamed from: w */
    public static void m2979w(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2823p(i, list, z);
    }

    /* renamed from: x */
    public static void m2978x(int i, List list, bqc bqcVar, boy boyVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((bmb) bqcVar).mo2822q(i, list.get(i2), boyVar);
        }
    }

    /* renamed from: y */
    public static void m2977y(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2820s(i, list, z);
    }

    /* renamed from: z */
    public static void m2976z(int i, List list, bqc bqcVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        bqcVar.mo2818u(i, list, z);
    }
}
