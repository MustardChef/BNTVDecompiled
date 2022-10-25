package com.google.ads.interactivemedia.p034v3.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnv */
/* loaded from: classes2.dex */
public /* synthetic */ class bnv {
    bnv() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bnv(byte[] bArr) {
        this();
    }

    public bnv(char[] cArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aA */
    public static float m3237aA(byte[] bArr, int i) {
        return Float.intBitsToFloat(m3235aC(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aB */
    public static int m3236aB(byte[] bArr, int i, blf blfVar) throws bnm {
        int m3227aK = m3227aK(bArr, i, blfVar);
        int i2 = blfVar.f5994a;
        if (i2 < 0) {
            throw bnm.m3253f();
        }
        if (i2 <= bArr.length - m3227aK) {
            if (i2 == 0) {
                blfVar.f5996c = bls.f6015b;
                return m3227aK;
            }
            blfVar.f5996c = bls.m3503u(bArr, m3227aK, i2);
            return m3227aK + i2;
        }
        throw bnm.m3250i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aC */
    public static int m3235aC(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aD */
    public static int m3234aD(boy boyVar, byte[] bArr, int i, int i2, int i3, blf blfVar) throws IOException {
        bol bolVar = (bol) boyVar;
        Object mo3038e = bolVar.mo3038e();
        int m3140c = bolVar.m3140c(mo3038e, bArr, i, i2, i3, blfVar);
        bolVar.mo3037f(mo3038e);
        blfVar.f5996c = mo3038e;
        return m3140c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aE */
    public static int m3233aE(boy boyVar, byte[] bArr, int i, int i2, blf blfVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = m3226aL(i4, bArr, i3, blfVar);
            i4 = blfVar.f5994a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw bnm.m3250i();
        }
        Object mo3038e = boyVar.mo3038e();
        int i6 = i4 + i5;
        boyVar.mo3034i(mo3038e, bArr, i5, i6, blfVar);
        boyVar.mo3037f(mo3038e);
        blfVar.f5996c = mo3038e;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aF */
    public static int m3232aF(boy boyVar, int i, byte[] bArr, int i2, int i3, bnj bnjVar, blf blfVar) throws IOException {
        int m3233aE = m3233aE(boyVar, bArr, i2, i3, blfVar);
        bnjVar.add(blfVar.f5996c);
        while (m3233aE < i3) {
            int m3227aK = m3227aK(bArr, m3233aE, blfVar);
            if (i != blfVar.f5994a) {
                break;
            }
            m3233aE = m3233aE(boyVar, bArr, m3227aK, i3, blfVar);
            bnjVar.add(blfVar.f5996c);
        }
        return m3233aE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aG */
    public static int m3231aG(byte[] bArr, int i, bnj bnjVar, blf blfVar) throws IOException {
        bne bneVar = (bne) bnjVar;
        int m3227aK = m3227aK(bArr, i, blfVar);
        int i2 = blfVar.f5994a + m3227aK;
        while (m3227aK < i2) {
            m3227aK = m3227aK(bArr, m3227aK, blfVar);
            bneVar.m3273g(blfVar.f5994a);
        }
        if (m3227aK == i2) {
            return m3227aK;
        }
        throw bnm.m3250i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aH */
    public static int m3230aH(byte[] bArr, int i, blf blfVar) throws bnm {
        int m3227aK = m3227aK(bArr, i, blfVar);
        int i2 = blfVar.f5994a;
        if (i2 >= 0) {
            if (i2 == 0) {
                blfVar.f5996c = "";
                return m3227aK;
            }
            blfVar.f5996c = new String(bArr, m3227aK, i2, bnk.f6265b);
            return m3227aK + i2;
        }
        throw bnm.m3253f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aI */
    public static int m3229aI(byte[] bArr, int i, blf blfVar) throws bnm {
        int m3227aK = m3227aK(bArr, i, blfVar);
        int i2 = blfVar.f5994a;
        if (i2 >= 0) {
            if (i2 == 0) {
                blfVar.f5996c = "";
                return m3227aK;
            }
            blfVar.f5996c = bpy.m2864h(bArr, m3227aK, i2);
            return m3227aK + i2;
        }
        throw bnm.m3253f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aJ */
    public static int m3228aJ(int i, byte[] bArr, int i2, int i3, bpm bpmVar, blf blfVar) throws bnm {
        if (bqb.m2853a(i) != 0) {
            int m2852b = bqb.m2852b(i);
            if (m2852b == 0) {
                int m3224aN = m3224aN(bArr, i2, blfVar);
                bpmVar.m2944h(i, Long.valueOf(blfVar.f5995b));
                return m3224aN;
            } else if (m2852b == 1) {
                bpmVar.m2944h(i, Long.valueOf(m3222aP(bArr, i2)));
                return i2 + 8;
            } else if (m2852b == 2) {
                int m3227aK = m3227aK(bArr, i2, blfVar);
                int i4 = blfVar.f5994a;
                if (i4 < 0) {
                    throw bnm.m3253f();
                }
                if (i4 <= bArr.length - m3227aK) {
                    if (i4 == 0) {
                        bpmVar.m2944h(i, bls.f6015b);
                    } else {
                        bpmVar.m2944h(i, bls.m3503u(bArr, m3227aK, i4));
                    }
                    return m3227aK + i4;
                }
                throw bnm.m3250i();
            } else if (m2852b != 3) {
                if (m2852b == 5) {
                    bpmVar.m2944h(i, Integer.valueOf(m3235aC(bArr, i2)));
                    return i2 + 4;
                }
                throw bnm.m3256c();
            } else {
                int i5 = (i & (-8)) | 4;
                bpm m2947e = bpm.m2947e();
                int i6 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int m3227aK2 = m3227aK(bArr, i2, blfVar);
                    int i7 = blfVar.f5994a;
                    if (i7 == i5) {
                        i6 = i7;
                        i2 = m3227aK2;
                        break;
                    }
                    i6 = i7;
                    i2 = m3228aJ(i7, bArr, m3227aK2, i3, m2947e, blfVar);
                }
                if (i2 > i3 || i6 != i5) {
                    throw bnm.m3252g();
                }
                bpmVar.m2944h(i, m2947e);
                return i2;
            }
        }
        throw bnm.m3256c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aK */
    public static int m3227aK(byte[] bArr, int i, blf blfVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            blfVar.f5994a = b;
            return i2;
        }
        return m3226aL(b, bArr, i2, blfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aL */
    public static int m3226aL(int i, byte[] bArr, int i2, blf blfVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            blfVar.f5994a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            blfVar.f5994a = i5 | (b2 << Ascii.f9767SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            blfVar.f5994a = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            blfVar.f5994a = i9 | (b4 << Ascii.f9760FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                blfVar.f5994a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aM */
    public static int m3225aM(int i, byte[] bArr, int i2, int i3, bnj bnjVar, blf blfVar) {
        bne bneVar = (bne) bnjVar;
        int m3227aK = m3227aK(bArr, i2, blfVar);
        bneVar.m3273g(blfVar.f5994a);
        while (m3227aK < i3) {
            int m3227aK2 = m3227aK(bArr, m3227aK, blfVar);
            if (i != blfVar.f5994a) {
                break;
            }
            m3227aK = m3227aK(bArr, m3227aK2, blfVar);
            bneVar.m3273g(blfVar.f5994a);
        }
        return m3227aK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aN */
    public static int m3224aN(byte[] bArr, int i, blf blfVar) {
        byte b;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            blfVar.f5995b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        blfVar.f5995b = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aO */
    public static int m3223aO(int i, byte[] bArr, int i2, int i3, blf blfVar) throws bnm {
        if (bqb.m2853a(i) != 0) {
            int m2852b = bqb.m2852b(i);
            if (m2852b != 0) {
                if (m2852b != 1) {
                    if (m2852b != 2) {
                        if (m2852b != 3) {
                            if (m2852b == 5) {
                                return i2 + 4;
                            }
                            throw bnm.m3256c();
                        }
                        int i4 = (i & (-8)) | 4;
                        int i5 = 0;
                        while (i2 < i3) {
                            i2 = m3227aK(bArr, i2, blfVar);
                            i5 = blfVar.f5994a;
                            if (i5 == i4) {
                                break;
                            }
                            i2 = m3223aO(i5, bArr, i2, i3, blfVar);
                        }
                        if (i2 > i3 || i5 != i4) {
                            throw bnm.m3252g();
                        }
                        return i2;
                    }
                    return m3227aK(bArr, i2, blfVar) + blfVar.f5994a;
                }
                return i2 + 8;
            }
            return m3224aN(bArr, i2, blfVar);
        }
        throw bnm.m3256c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aP */
    public static long m3222aP(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ao */
    public static int m3220ao(Map.Entry entry) {
        return ((bnc) entry.getKey()).f6255b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ap */
    public static Object m3219ap(bmr bmrVar, boj bojVar, int i) {
        return bmrVar.mo2766c(bojVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aq */
    public static bmu m3218aq(Object obj) {
        return ((bnb) obj).f6253a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ar */
    public static bmu m3217ar(Object obj) {
        return ((bnb) obj).m3301f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: as */
    public static boolean m3216as(boj bojVar) {
        return bojVar instanceof bnb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: at */
    public static void m3215at(bot botVar, Object obj, bmr bmrVar, bmu bmuVar) throws IOException {
        bmp bmpVar = (bmp) obj;
        bmuVar.m3327k(bmpVar.f6169b, botVar.mo3073t(bmpVar.f6168a.getClass(), bmrVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: au */
    public static void m3214au(bls blsVar, Object obj, bmr bmrVar, bmu bmuVar) throws IOException {
        bmp bmpVar = (bmp) obj;
        boj mo3178aS = bmpVar.f6168a.mo3174bh().mo3178aS();
        ByteBuffer wrap = ByteBuffer.wrap(blsVar.m3509C());
        if (wrap.hasArray()) {
            blh blhVar = new blh(wrap);
            boq.m3120a().m3118c(mo3178aS).mo3035h(mo3178aS, blhVar, bmrVar);
            bmuVar.m3327k(bmpVar.f6169b, mo3178aS);
            if (blhVar.mo3089c() != Integer.MAX_VALUE) {
                throw bnm.m3257b();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: av */
    public static void m3213av(bqc bqcVar, Map.Entry entry) throws IOException {
        bnc bncVar = (bnc) entry.getKey();
        if (bncVar.f6257d) {
            bpz bpzVar = bpz.DOUBLE;
            switch (bncVar.f6256c.ordinal()) {
                case 0:
                    bpa.m2983s(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 1:
                    bpa.m2979w(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 2:
                    bpa.m2976z(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 3:
                    bpa.m3022H(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 4:
                    bpa.m2977y(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 5:
                    bpa.m2980v(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 6:
                    bpa.m2981u(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 7:
                    bpa.m2985q(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 8:
                    bpa.m3024F(bncVar.f6255b, (List) entry.getValue(), bqcVar);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    bpa.m2978x(bncVar.f6255b, (List) entry.getValue(), bqcVar, boq.m3120a().m3119b(list.get(0).getClass()));
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    bpa.m3029A(bncVar.f6255b, (List) entry.getValue(), bqcVar, boq.m3120a().m3119b(list2.get(0).getClass()));
                    return;
                case 11:
                    bpa.m2984r(bncVar.f6255b, (List) entry.getValue(), bqcVar);
                    return;
                case 12:
                    bpa.m3023G(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 13:
                    bpa.m2977y(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 14:
                    bpa.m3028B(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 15:
                    bpa.m3027C(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 16:
                    bpa.m3026D(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                case 17:
                    bpa.m3025E(bncVar.f6255b, (List) entry.getValue(), bqcVar, false);
                    return;
                default:
                    return;
            }
        }
        bpz bpzVar2 = bpz.DOUBLE;
        switch (bncVar.f6256c.ordinal()) {
            case 0:
                bqcVar.mo2833f(bncVar.f6255b, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                bqcVar.mo2824o(bncVar.f6255b, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                bqcVar.mo2819t(bncVar.f6255b, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                bqcVar.mo2839L(bncVar.f6255b, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                bqcVar.mo2821r(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                bqcVar.mo2826m(bncVar.f6255b, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                bqcVar.mo2828k(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                bqcVar.mo2837b(bncVar.f6255b, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                bqcVar.mo2843H(bncVar.f6255b, (String) entry.getValue());
                return;
            case 9:
                bqcVar.mo2822q(bncVar.f6255b, entry.getValue(), boq.m3120a().m3119b(entry.getValue().getClass()));
                return;
            case 10:
                bqcVar.mo2816w(bncVar.f6255b, entry.getValue(), boq.m3120a().m3119b(entry.getValue().getClass()));
                return;
            case 11:
                bqcVar.mo2835d(bncVar.f6255b, (bls) entry.getValue());
                return;
            case 12:
                bqcVar.mo2841J(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                bqcVar.mo2821r(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                bqcVar.mo2814y(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                bqcVar.mo2850A(bncVar.f6255b, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                bqcVar.mo2848C(bncVar.f6255b, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                bqcVar.mo2846E(bncVar.f6255b, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aw */
    public static Object m3212aw(bot botVar, Object obj, bmr bmrVar, bmu bmuVar, Object obj2, bqd bqdVar) throws IOException {
        Object valueOf;
        Object m3332f;
        bmp bmpVar = (bmp) obj;
        bnc bncVar = bmpVar.f6169b;
        int i = bncVar.f6255b;
        boolean z = bncVar.f6257d;
        if (bmpVar.m3343a() == bpz.ENUM) {
            int mo3085g = botVar.mo3085g();
            if (bmpVar.f6169b.f6254a.mo2738a(mo3085g) == null) {
                return bpa.m3006X(i, mo3085g, obj2, bqdVar);
            }
            valueOf = Integer.valueOf(mo3085g);
        } else {
            switch (bmpVar.m3343a().ordinal()) {
                case 0:
                    valueOf = Double.valueOf(botVar.mo3091a());
                    break;
                case 1:
                    valueOf = Float.valueOf(botVar.mo3090b());
                    break;
                case 2:
                    valueOf = Long.valueOf(botVar.mo3080l());
                    break;
                case 3:
                    valueOf = Long.valueOf(botVar.mo3077o());
                    break;
                case 4:
                    valueOf = Integer.valueOf(botVar.mo3085g());
                    break;
                case 5:
                    valueOf = Long.valueOf(botVar.mo3081k());
                    break;
                case 6:
                    valueOf = Integer.valueOf(botVar.mo3086f());
                    break;
                case 7:
                    valueOf = Boolean.valueOf(botVar.mo3094S());
                    break;
                case 8:
                    valueOf = botVar.mo3071v();
                    break;
                case 9:
                    valueOf = botVar.mo3075r(bmpVar.f6168a.getClass(), bmrVar);
                    break;
                case 10:
                    valueOf = botVar.mo3073t(bmpVar.f6168a.getClass(), bmrVar);
                    break;
                case 11:
                    valueOf = botVar.mo3076q();
                    break;
                case 12:
                    valueOf = Integer.valueOf(botVar.mo3082j());
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 14:
                    valueOf = Integer.valueOf(botVar.mo3084h());
                    break;
                case 15:
                    valueOf = Long.valueOf(botVar.mo3079m());
                    break;
                case 16:
                    valueOf = Integer.valueOf(botVar.mo3083i());
                    break;
                case 17:
                    valueOf = Long.valueOf(botVar.mo3078n());
                    break;
                default:
                    valueOf = null;
                    break;
            }
        }
        if (bmpVar.m3342b()) {
            bmuVar.m3330h(bmpVar.f6169b, valueOf);
        } else {
            int ordinal = bmpVar.m3343a().ordinal();
            if ((ordinal == 9 || ordinal == 10) && (m3332f = bmuVar.m3332f(bmpVar.f6169b)) != null) {
                valueOf = bnk.m3264e(m3332f, valueOf);
            }
            bmuVar.m3327k(bmpVar.f6169b, valueOf);
        }
        return obj2;
    }

    /* renamed from: ax */
    public static bls m3211ax(bma bmaVar, byte[] bArr) {
        bmaVar.m3425C();
        return new blq(bArr);
    }

    /* renamed from: ay */
    public static bma m3210ay(bma bmaVar) {
        return bmaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: az */
    public static double m3209az(byte[] bArr, int i) {
        return Double.longBitsToDouble(m3222aP(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: an */
    public final void m3221an(Object obj) {
        m3218aq(obj).m3329i();
    }
}
