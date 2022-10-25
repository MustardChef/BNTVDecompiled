package com.google.ads.interactivemedia.p034v3.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okio.Utf8;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bqd */
/* loaded from: classes2.dex */
public final /* synthetic */ class bqd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bqd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bqd(byte[] bArr) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static String m2811B(bls blsVar) {
        bpk bpkVar = new bpk(blsVar);
        StringBuilder sb = new StringBuilder(bpkVar.m2952a());
        for (int i = 0; i < bpkVar.m2952a(); i++) {
            byte mo3057a = bpkVar.f6385a.mo3057a(i);
            if (mo3057a == 34) {
                sb.append("\\\"");
            } else if (mo3057a == 39) {
                sb.append("\\'");
            } else if (mo3057a == 92) {
                sb.append("\\\\");
            } else {
                switch (mo3057a) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (mo3057a < 32 || mo3057a > 126) {
                            sb.append('\\');
                            sb.append((char) (((mo3057a >>> 6) & 3) + 48));
                            sb.append((char) (((mo3057a >>> 3) & 7) + 48));
                            sb.append((char) ((mo3057a & 7) + 48));
                            break;
                        } else {
                            sb.append((char) mo3057a);
                            continue;
                        }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: C */
    public static final Object m2810C(Object obj) {
        return ((bnd) obj).m3289aE(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public static String m2809D(boj bojVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        m2794S(bojVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: E */
    public static final void m2808E(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                m2808E(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                m2808E(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(m2811B(bls.m3502v((String) obj)));
                sb.append('\"');
            } else if (obj instanceof bls) {
                sb.append(": \"");
                sb.append(m2811B((bls) obj));
                sb.append('\"');
            } else if (obj instanceof bnd) {
                sb.append(" {");
                m2794S((bnd) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                m2808E(sb, i4, SDKConstants.PARAM_KEY, entry2.getKey());
                m2808E(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    /* renamed from: F */
    public static final Map m2807F(Object obj) {
        return (boe) obj;
    }

    /* renamed from: G */
    public static final bod m2806G(Object obj) {
        bqd bqdVar = (bqd) obj;
        throw null;
    }

    /* renamed from: H */
    public static final Map m2805H(Object obj) {
        return (boe) obj;
    }

    /* renamed from: I */
    public static final int m2804I(Object obj, Object obj2) {
        boe boeVar = (boe) obj;
        bqd bqdVar = (bqd) obj2;
        if (boeVar.isEmpty()) {
            return 0;
        }
        Iterator it = boeVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    /* renamed from: J */
    public static final boolean m2803J(Object obj) {
        return !((boe) obj).m3187e();
    }

    /* renamed from: K */
    public static final Object m2802K(Object obj, Object obj2) {
        boe boeVar = (boe) obj;
        boe boeVar2 = (boe) obj2;
        if (!boeVar2.isEmpty()) {
            if (!boeVar.m3187e()) {
                boeVar = boeVar.m3190b();
            }
            boeVar.m3188d(boeVar2);
        }
        return boeVar;
    }

    /* renamed from: L */
    public static final Object m2801L() {
        return boe.m3191a().m3190b();
    }

    /* renamed from: M */
    public static final void m2800M(Object obj) {
        ((boe) obj).m3189c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N */
    public static int m2799N(bod bodVar, Object obj, Object obj2) {
        bpz bpzVar = bodVar.f6310a;
        int m3337a = bmu.m3337a(null, 1, obj);
        bpz bpzVar2 = bodVar.f6312c;
        return m3337a + bmu.m3337a(null, 2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: O */
    public static void m2798O(bma bmaVar, bod bodVar, Object obj, Object obj2) throws IOException {
        bpz bpzVar = bodVar.f6310a;
        bmu.m3323o(bmaVar, 1, obj);
        bpz bpzVar2 = bodVar.f6312c;
        bmu.m3323o(bmaVar, 2, obj2);
    }

    /* renamed from: P */
    private static int m2797P(byte b) {
        return b & Utf8.REPLACEMENT_BYTE;
    }

    /* renamed from: Q */
    private static boolean m2796Q(byte b) {
        return b > -65;
    }

    /* renamed from: R */
    private static final String m2795R(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* renamed from: S */
    private static void m2794S(boj bojVar, StringBuilder sb, int i) {
        Method[] declaredMethods;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : bojVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    m2808E(sb, i, m2795R(concat), bnd.m3292aB(method2, bojVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    m2808E(sb, i, m2795R(concat2), bnd.m3292aB(method3, bojVar, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object m3292aB = bnd.m3292aB(method4, bojVar, new Object[0]);
                    if (method5 == null) {
                        if (m3292aB instanceof Boolean) {
                            if (((Boolean) m3292aB).booleanValue()) {
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                        } else if (m3292aB instanceof Integer) {
                            if (((Integer) m3292aB).intValue() != 0) {
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                        } else if (m3292aB instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) m3292aB).floatValue()) != 0) {
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                        } else if (m3292aB instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) m3292aB).doubleValue()) != 0) {
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                        } else {
                            if (m3292aB instanceof String) {
                                equals = m3292aB.equals("");
                            } else if (m3292aB instanceof bls) {
                                equals = m3292aB.equals(bls.f6015b);
                            } else if (m3292aB instanceof boj) {
                                if (m3292aB != ((boj) m3292aB).mo3171aT()) {
                                    m2808E(sb, i, m2795R(concat3), m3292aB);
                                }
                            } else {
                                if ((m3292aB instanceof Enum) && ((Enum) m3292aB).ordinal() == 0) {
                                }
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                            if (!equals) {
                                m2808E(sb, i, m2795R(concat3), m3292aB);
                            }
                        }
                    } else if (((Boolean) bnd.m3292aB(method5, bojVar, new Object[0])).booleanValue()) {
                        m2808E(sb, i, m2795R(concat3), m3292aB);
                    }
                }
            }
        }
        if (bojVar instanceof bnb) {
            Iterator m3331g = ((bnb) bojVar).f6253a.m3331g();
            while (m3331g.hasNext()) {
                Map.Entry entry = (Map.Entry) m3331g.next();
                int i2 = ((bnc) entry.getKey()).f6255b;
                StringBuilder sb2 = new StringBuilder(13);
                sb2.append("[");
                sb2.append(i2);
                sb2.append("]");
                m2808E(sb, i, sb2.toString(), entry.getValue());
            }
        }
        bpm bpmVar = ((bnd) bojVar).f6259c;
        if (bpmVar != null) {
            bpmVar.m2945g(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m2793a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws bnm {
        if (m2796Q(b2) || (((b << Ascii.f9760FS) + (b2 + 112)) >> 30) != 0 || m2796Q(b3) || m2796Q(b4)) {
            throw bnm.m3255d();
        }
        int m2797P = ((b & 7) << 18) | (m2797P(b2) << 12) | (m2797P(b3) << 6) | m2797P(b4);
        cArr[i] = (char) ((m2797P >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((m2797P & AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES) + 56320);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m2792b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m2791c(byte b, byte b2, char[] cArr, int i) throws bnm {
        if (b < -62 || m2796Q(b2)) {
            throw bnm.m3255d();
        }
        cArr[i] = (char) (((b & Ascii.f9769US) << 6) | m2797P(b2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m2789e(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ boolean m2788f(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ boolean m2787g(byte b) {
        return b < -16;
    }

    /* renamed from: n */
    static /* bridge */ /* synthetic */ void m2780n(Object obj, int i, int i2) {
        ((bpm) obj).m2944h(bqb.m2851c(i, 5), Integer.valueOf(i2));
    }

    /* renamed from: o */
    static /* bridge */ /* synthetic */ void m2779o(Object obj, int i, long j) {
        ((bpm) obj).m2944h(bqb.m2851c(i, 1), Long.valueOf(j));
    }

    /* renamed from: p */
    static /* bridge */ /* synthetic */ void m2778p(Object obj, int i, Object obj2) {
        ((bpm) obj).m2944h(bqb.m2851c(i, 3), obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static /* bridge */ /* synthetic */ void m2777q(Object obj, int i, bls blsVar) {
        ((bpm) obj).m2944h(bqb.m2851c(i, 2), blsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* bridge */ /* synthetic */ void m2776r(Object obj, int i, long j) {
        ((bpm) obj).m2944h(bqb.m2851c(i, 0), Long.valueOf(j));
    }

    /* renamed from: s */
    static bpm m2775s(Object obj) {
        return ((bnd) obj).f6259c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static /* bridge */ /* synthetic */ Object m2772v(Object obj, Object obj2) {
        bpm bpmVar = (bpm) obj2;
        return bpmVar.equals(bpm.m2949c()) ? obj : bpm.m2948d((bpm) obj, bpmVar);
    }

    /* renamed from: x */
    static void m2770x(Object obj, bpm bpmVar) {
        ((bnd) obj).f6259c = bpmVar;
    }

    /* renamed from: y */
    static /* synthetic */ Object m2769y(Object obj) {
        ((bpm) obj).m2946f();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean m2786h(Object obj, bot botVar) throws IOException {
        int mo3088d = botVar.mo3088d();
        int m2853a = bqb.m2853a(mo3088d);
        int m2852b = bqb.m2852b(mo3088d);
        if (m2852b == 0) {
            m2776r(obj, m2853a, botVar.mo3080l());
            return true;
        } else if (m2852b == 1) {
            m2779o(obj, m2853a, botVar.mo3081k());
            return true;
        } else if (m2852b == 2) {
            m2777q(obj, m2853a, botVar.mo3076q());
            return true;
        } else if (m2852b != 3) {
            if (m2852b != 4) {
                if (m2852b == 5) {
                    m2780n(obj, m2853a, botVar.mo3086f());
                    return true;
                }
                throw bnm.m3258a();
            }
            return false;
        } else {
            int m2851c = bqb.m2851c(m2853a, 4);
            Object m2947e = bpm.m2947e();
            while (botVar.mo3089c() != Integer.MAX_VALUE && m2786h(m2947e, botVar)) {
            }
            if (m2851c != botVar.mo3088d()) {
                throw bnm.m3257b();
            }
            m2778p(obj, m2853a, m2769y(m2947e));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* bridge */ /* synthetic */ Object m2785i(Object obj) {
        bpm m2775s = m2775s(obj);
        if (m2775s == bpm.m2949c()) {
            bpm m2947e = bpm.m2947e();
            m2770x(obj, m2947e);
            return m2947e;
        }
        return m2775s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ Object m2784j(Object obj) {
        return m2775s(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final void m2783k(Object obj) {
        m2775s(obj).m2946f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void m2782l(Object obj, Object obj2) {
        m2770x(obj, (bpm) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* bridge */ /* synthetic */ void m2781m(Object obj, Object obj2) {
        m2770x(obj, (bpm) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m2790d(byte b, byte b2, byte b3, char[] cArr, int i) throws bnm {
        if (!m2796Q(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if ((b != -19 || b2 < -96) && !m2796Q(b3)) {
                cArr[i] = (char) (((b & Ascii.f9766SI) << 12) | (m2797P(b2) << 6) | m2797P(b3));
                return;
            }
        }
        throw bnm.m3255d();
    }
}
