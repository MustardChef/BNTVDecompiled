package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abf */
/* loaded from: classes2.dex */
public final class abf {

    /* renamed from: M */
    public byte[] f2967M;

    /* renamed from: S */
    public C3254zv f2973S;

    /* renamed from: T */
    public boolean f2974T;

    /* renamed from: V */
    public InterfaceC3253zu f2976V;

    /* renamed from: W */
    public int f2977W;

    /* renamed from: X */
    private int f2978X;

    /* renamed from: a */
    public String f2980a;

    /* renamed from: b */
    public String f2981b;

    /* renamed from: c */
    public int f2982c;

    /* renamed from: d */
    public int f2983d;

    /* renamed from: e */
    public int f2984e;

    /* renamed from: f */
    public int f2985f;

    /* renamed from: g */
    public boolean f2986g;

    /* renamed from: h */
    public byte[] f2987h;

    /* renamed from: i */
    public C3252zt f2988i;

    /* renamed from: j */
    public byte[] f2989j;

    /* renamed from: k */
    public C2854l f2990k;

    /* renamed from: l */
    public int f2991l = -1;

    /* renamed from: m */
    public int f2992m = -1;

    /* renamed from: n */
    public int f2993n = -1;

    /* renamed from: o */
    public int f2994o = -1;

    /* renamed from: p */
    public int f2995p = 0;

    /* renamed from: q */
    public int f2996q = -1;

    /* renamed from: r */
    public float f2997r = 0.0f;

    /* renamed from: s */
    public float f2998s = 0.0f;

    /* renamed from: t */
    public float f2999t = 0.0f;

    /* renamed from: u */
    public byte[] f3000u = null;

    /* renamed from: v */
    public int f3001v = -1;

    /* renamed from: w */
    public boolean f3002w = false;

    /* renamed from: x */
    public int f3003x = -1;

    /* renamed from: y */
    public int f3004y = -1;

    /* renamed from: z */
    public int f3005z = -1;

    /* renamed from: A */
    public int f2955A = 1000;

    /* renamed from: B */
    public int f2956B = 200;

    /* renamed from: C */
    public float f2957C = -1.0f;

    /* renamed from: D */
    public float f2958D = -1.0f;

    /* renamed from: E */
    public float f2959E = -1.0f;

    /* renamed from: F */
    public float f2960F = -1.0f;

    /* renamed from: G */
    public float f2961G = -1.0f;

    /* renamed from: H */
    public float f2962H = -1.0f;

    /* renamed from: I */
    public float f2963I = -1.0f;

    /* renamed from: J */
    public float f2964J = -1.0f;

    /* renamed from: K */
    public float f2965K = -1.0f;

    /* renamed from: L */
    public float f2966L = -1.0f;

    /* renamed from: N */
    public int f2968N = 1;

    /* renamed from: O */
    public int f2969O = -1;

    /* renamed from: P */
    public int f2970P = 8000;

    /* renamed from: Q */
    public long f2971Q = 0;

    /* renamed from: R */
    public long f2972R = 0;

    /* renamed from: U */
    public boolean f2975U = true;

    /* renamed from: Y */
    private String f2979Y = "eng";

    private abf() {
    }

    public /* synthetic */ abf(byte[] bArr) {
    }

    /* renamed from: f */
    private static Pair m5939f(C2621cj c2621cj) throws C2555ao {
        try {
            c2621cj.m2643G(16);
            long m2628n = c2621cj.m2628n();
            if (m2628n == 1482049860) {
                return new Pair(MimeTypes.VIDEO_DIVX, null);
            }
            if (m2628n == 859189832) {
                return new Pair(MimeTypes.VIDEO_H263, null);
            }
            if (m2628n != 826496599) {
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
            }
            int m2639c = c2621cj.m2639c() + 20;
            byte[] m2642H = c2621cj.m2642H();
            while (true) {
                int length = m2642H.length;
                if (m2639c < length - 4) {
                    if (m2642H[m2639c] == 0 && m2642H[m2639c + 1] == 0 && m2642H[m2639c + 2] == 1 && m2642H[m2639c + 3] == 15) {
                        return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(m2642H, m2639c, length)));
                    }
                    m2639c++;
                } else {
                    throw C2555ao.m4866a("Failed to find FourCC VC1 initialization data", null);
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C2555ao.m4866a("Error parsing FourCC private data", null);
        }
    }

    /* renamed from: g */
    private static List m5938g(byte[] bArr) throws C2555ao {
        int i;
        int i2;
        try {
            if (bArr[0] == 2) {
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3] & 255;
                    if (i != 255) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5] & 255;
                    if (i2 != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw C2555ao.m4866a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw C2555ao.m4866a("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] == 5) {
                    int length = bArr.length - i11;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr, i11, bArr3, 0, length);
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(bArr2);
                    arrayList.add(bArr3);
                    return arrayList;
                }
                throw C2555ao.m4866a("Error parsing vorbis codec private", null);
            }
            throw C2555ao.m4866a("Error parsing vorbis codec private", null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C2555ao.m4866a("Error parsing vorbis codec private", null);
        }
    }

    /* renamed from: h */
    private static boolean m5937h(C2621cj c2621cj) throws C2555ao {
        UUID uuid;
        UUID uuid2;
        try {
            int m2635g = c2621cj.m2635g();
            if (m2635g == 1) {
                return true;
            }
            if (m2635g == 65534) {
                c2621cj.m2644F(24);
                long m2627o = c2621cj.m2627o();
                uuid = abg.f3009d;
                if (m2627o == uuid.getMostSignificantBits()) {
                    long m2627o2 = c2621cj.m2627o();
                    uuid2 = abg.f3009d;
                    if (m2627o2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw C2555ao.m4866a("Error parsing MS/ACM codec private", null);
        }
    }

    /* renamed from: i */
    private final byte[] m5936i(String str) throws C2555ao {
        byte[] bArr = this.f2989j;
        if (bArr == null) {
            String valueOf = String.valueOf(str);
            throw C2555ao.m4866a(valueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(valueOf) : new String("Missing CodecPrivate for codec "), null);
        }
        return bArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: e */
    public final void m5940e(InterfaceC3233za interfaceC3233za, int i) throws C2555ao {
        char c;
        List singletonList;
        List list;
        String str;
        int i2;
        String str2;
        byte[] bArr;
        int i3;
        int i4;
        Map map;
        Map map2;
        int i5;
        Map map3;
        C3226yu m503a;
        String str3 = this.f2981b;
        int i6 = 1;
        int i7 = 4;
        int i8 = 0;
        switch (str3.hashCode()) {
            case -2095576542:
                if (str3.equals("V_MPEG4/ISO/AP")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str3.equals("V_MPEG4/ISO/SP")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str3.equals("A_MS/ACM")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str3.equals("A_TRUEHD")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str3.equals("A_VORBIS")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str3.equals("A_MPEG/L2")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str3.equals("A_MPEG/L3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str3.equals("V_MS/VFW/FOURCC")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str3.equals("S_DVBSUB")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str3.equals("V_MPEG4/ISO/ASP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str3.equals("V_MPEG4/ISO/AVC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str3.equals("S_VOBSUB")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str3.equals("A_DTS/LOSSLESS")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str3.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str3.equals("A_AC3")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str3.equals("A_DTS")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 82318131:
                if (str3.equals("V_AV1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str3.equals("V_VP8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str3.equals("V_VP9")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str3.equals("S_HDMV/PGS")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str3.equals("V_THEORA")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str3.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 635596514:
                if (str3.equals("A_PCM/FLOAT/IEEE")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 725948237:
                if (str3.equals("A_PCM/INT/BIG")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str3.equals("A_PCM/INT/LIT")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 738597099:
                if (str3.equals("S_TEXT/ASS")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str3.equals("V_MPEGH/ISO/HEVC")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str3.equals("S_TEXT/UTF8")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str3.equals("V_MPEG2")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str3.equals("A_EAC3")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str3.equals("A_FLAC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str3.equals("A_OPUS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str4 = MimeTypes.AUDIO_RAW;
        C2719g c2719g = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        r11 = null;
        byte[] bArr2 = null;
        switch (c) {
            case 0:
                str4 = MimeTypes.VIDEO_VP8;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 1:
                str4 = MimeTypes.VIDEO_VP9;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 2:
                str4 = MimeTypes.VIDEO_AV1;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 3:
                str4 = MimeTypes.VIDEO_MPEG2;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 4:
            case 5:
            case 6:
                byte[] bArr3 = this.f2989j;
                singletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                str4 = MimeTypes.VIDEO_MP4V;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 7:
                C3213yh m545a = C3213yh.m545a(new C2621cj(m5936i(str3)));
                list = m545a.f9488a;
                this.f2977W = m545a.f9489b;
                str = m545a.f9493f;
                str4 = MimeTypes.VIDEO_H264;
                i2 = -1;
                i7 = -1;
                List list2 = list;
                str2 = str;
                singletonList = list2;
                break;
            case '\b':
                C3238zf m482a = C3238zf.m482a(new C2621cj(m5936i(str3)));
                list = m482a.f9558a;
                this.f2977W = m482a.f9559b;
                str = m482a.f9561d;
                str4 = MimeTypes.VIDEO_H265;
                i2 = -1;
                i7 = -1;
                List list22 = list;
                str2 = str;
                singletonList = list22;
                break;
            case '\t':
                Pair m5939f = m5939f(new C2621cj(m5936i(str3)));
                str4 = (String) m5939f.first;
                singletonList = (List) m5939f.second;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case '\n':
                str4 = MimeTypes.VIDEO_UNKNOWN;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 11:
                singletonList = m5938g(m5936i(str3));
                str4 = MimeTypes.AUDIO_VORBIS;
                str2 = null;
                i2 = 8192;
                i7 = -1;
                break;
            case '\f':
                singletonList = new ArrayList(3);
                singletonList.add(m5936i(this.f2981b));
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f2971Q).array());
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f2972R).array());
                str4 = MimeTypes.AUDIO_OPUS;
                str2 = null;
                i2 = 5760;
                i7 = -1;
                break;
            case '\r':
                singletonList = Collections.singletonList(m5936i(str3));
                C3207yb m557a = C3208yc.m557a(this.f2989j);
                this.f2970P = m557a.f9465a;
                this.f2968N = m557a.f9466b;
                str2 = m557a.f9467c;
                str4 = MimeTypes.AUDIO_AAC;
                i2 = -1;
                i7 = -1;
                break;
            case 14:
                str4 = MimeTypes.AUDIO_MPEG_L2;
                singletonList = null;
                str2 = null;
                i2 = 4096;
                i7 = -1;
                break;
            case 15:
                str4 = MimeTypes.AUDIO_MPEG;
                singletonList = null;
                str2 = null;
                i2 = 4096;
                i7 = -1;
                break;
            case 16:
                str4 = MimeTypes.AUDIO_AC3;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 17:
                str4 = MimeTypes.AUDIO_E_AC3;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 18:
                this.f2973S = new C3254zv();
                str4 = MimeTypes.AUDIO_TRUEHD;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 19:
            case 20:
                str4 = MimeTypes.AUDIO_DTS;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 21:
                str4 = MimeTypes.AUDIO_DTS_HD;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 22:
                singletonList = Collections.singletonList(m5936i(str3));
                str4 = MimeTypes.AUDIO_FLAC;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 23:
                if (m5937h(new C2621cj(m5936i(str3)))) {
                    int i9 = this.f2969O;
                    i7 = C2628cq.m2524j(i9);
                    if (i7 == 0) {
                        StringBuilder sb = new StringBuilder(75);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i9);
                        sb.append(". Setting mimeType to audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                    }
                    singletonList = null;
                    str2 = null;
                    i2 = -1;
                    break;
                } else {
                    Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                }
                singletonList = null;
                str2 = null;
                str4 = MimeTypes.AUDIO_UNKNOWN;
                i2 = -1;
                i7 = -1;
                break;
            case 24:
                int i10 = this.f2969O;
                i7 = C2628cq.m2524j(i10);
                if (i7 == 0) {
                    StringBuilder sb2 = new StringBuilder(89);
                    sb2.append("Unsupported little endian PCM bit depth: ");
                    sb2.append(i10);
                    sb2.append(". Setting mimeType to audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    singletonList = null;
                    str2 = null;
                    str4 = MimeTypes.AUDIO_UNKNOWN;
                    i2 = -1;
                    i7 = -1;
                    break;
                }
                singletonList = null;
                str2 = null;
                i2 = -1;
                break;
            case 25:
                int i11 = this.f2969O;
                if (i11 != 8) {
                    if (i11 != 16) {
                        StringBuilder sb3 = new StringBuilder(86);
                        sb3.append("Unsupported big endian PCM bit depth: ");
                        sb3.append(i11);
                        sb3.append(". Setting mimeType to audio/x-unknown");
                        Log.w("MatroskaExtractor", sb3.toString());
                        singletonList = null;
                        str2 = null;
                        str4 = MimeTypes.AUDIO_UNKNOWN;
                        i2 = -1;
                        i7 = -1;
                        break;
                    } else {
                        i7 = 268435456;
                        singletonList = null;
                        str2 = null;
                        i2 = -1;
                        break;
                    }
                } else {
                    singletonList = null;
                    str2 = null;
                    i2 = -1;
                    i7 = 3;
                    break;
                }
            case 26:
                int i12 = this.f2969O;
                if (i12 != 32) {
                    StringBuilder sb4 = new StringBuilder(90);
                    sb4.append("Unsupported floating point PCM bit depth: ");
                    sb4.append(i12);
                    sb4.append(". Setting mimeType to audio/x-unknown");
                    Log.w("MatroskaExtractor", sb4.toString());
                    singletonList = null;
                    str2 = null;
                    str4 = MimeTypes.AUDIO_UNKNOWN;
                    i2 = -1;
                    i7 = -1;
                    break;
                }
                singletonList = null;
                str2 = null;
                i2 = -1;
                break;
            case 27:
                str4 = MimeTypes.APPLICATION_SUBRIP;
                singletonList = null;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            case 28:
                bArr = abg.f3007b;
                singletonList = avg.m4513p(bArr, m5936i(str3));
                str2 = null;
                str4 = MimeTypes.TEXT_SSA;
                i2 = -1;
                i7 = -1;
                break;
            case 29:
                singletonList = avg.m4514o(m5936i(str3));
                str2 = null;
                str4 = MimeTypes.APPLICATION_VOBSUB;
                i2 = -1;
                i7 = -1;
                break;
            case 30:
                singletonList = null;
                str2 = null;
                str4 = MimeTypes.APPLICATION_PGS;
                i2 = -1;
                i7 = -1;
                break;
            case 31:
                byte[] bArr4 = new byte[4];
                System.arraycopy(m5936i(str3), 0, bArr4, 0, 4);
                singletonList = avg.m4514o(bArr4);
                str4 = MimeTypes.APPLICATION_DVBSUBS;
                str2 = null;
                i2 = -1;
                i7 = -1;
                break;
            default:
                throw C2555ao.m4866a("Unrecognized codec identifier.", null);
        }
        byte[] bArr5 = this.f2967M;
        if (bArr5 != null && (m503a = C3226yu.m503a(new C2621cj(bArr5))) != null) {
            str2 = m503a.f9539a;
            str4 = MimeTypes.VIDEO_DOLBY_VISION;
        }
        String str5 = str4;
        int i13 = (this.f2975U ? 1 : 0) | (true != this.f2974T ? 0 : 2);
        C2935o c2935o = new C2935o();
        if (C2554an.m4964m(str5)) {
            c2935o.m1556H(this.f2968N);
            c2935o.m1531af(this.f2970P);
            c2935o.m1539Y(i7);
        } else if (C2554an.m4960q(str5)) {
            if (this.f2995p == 0) {
                int i14 = this.f2993n;
                i3 = -1;
                if (i14 == -1) {
                    i14 = this.f2991l;
                }
                this.f2993n = i14;
                int i15 = this.f2994o;
                if (i15 == -1) {
                    i15 = this.f2992m;
                }
                this.f2994o = i15;
            } else {
                i3 = -1;
            }
            float f = (this.f2993n == i3 || (i5 = this.f2994o) == i3) ? -1.0f : (this.f2992m * i4) / (this.f2991l * i5);
            if (this.f3002w) {
                if (this.f2957C != -1.0f && this.f2958D != -1.0f && this.f2959E != -1.0f && this.f2960F != -1.0f && this.f2961G != -1.0f && this.f2962H != -1.0f && this.f2963I != -1.0f && this.f2964J != -1.0f && this.f2965K != -1.0f && this.f2966L != -1.0f) {
                    bArr2 = new byte[25];
                    ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                    order.put((byte) 0);
                    order.putShort((short) ((this.f2957C * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2958D * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2959E * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2960F * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2961G * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2962H * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2963I * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.f2964J * 50000.0f) + 0.5f));
                    order.putShort((short) (this.f2965K + 0.5f));
                    order.putShort((short) (this.f2966L + 0.5f));
                    order.putShort((short) this.f2955A);
                    order.putShort((short) this.f2956B);
                }
                c2719g = new C2719g(this.f3003x, this.f3005z, this.f3004y, bArr2);
            }
            String str6 = this.f2980a;
            if (str6 != null) {
                map = abg.f3010e;
                if (map.containsKey(str6)) {
                    map2 = abg.f3010e;
                    i3 = ((Integer) map2.get(this.f2980a)).intValue();
                }
            }
            if (this.f2996q == 0 && Float.compare(this.f2997r, 0.0f) == 0 && Float.compare(this.f2998s, 0.0f) == 0) {
                if (Float.compare(this.f2999t, 0.0f) != 0) {
                    if (Float.compare(this.f2998s, 90.0f) == 0) {
                        i8 = 90;
                    } else if (Float.compare(this.f2998s, -180.0f) == 0 || Float.compare(this.f2998s, 180.0f) == 0) {
                        i8 = 180;
                    } else if (Float.compare(this.f2998s, -90.0f) == 0) {
                        i8 = bqk.f6530aq;
                    }
                }
                c2935o.m1527aj(this.f2991l);
                c2935o.m1547Q(this.f2992m);
                c2935o.m1536aa(f);
                c2935o.m1533ad(i8);
                c2935o.m1535ab(this.f3000u);
                c2935o.m1529ah(this.f3001v);
                c2935o.m1554J(c2719g);
                i6 = 2;
            }
            i8 = i3;
            c2935o.m1527aj(this.f2991l);
            c2935o.m1547Q(this.f2992m);
            c2935o.m1536aa(f);
            c2935o.m1533ad(i8);
            c2935o.m1535ab(this.f3000u);
            c2935o.m1529ah(this.f3001v);
            c2935o.m1554J(c2719g);
            i6 = 2;
        } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str5) && !MimeTypes.TEXT_SSA.equals(str5) && !MimeTypes.APPLICATION_VOBSUB.equals(str5) && !MimeTypes.APPLICATION_PGS.equals(str5) && !MimeTypes.APPLICATION_DVBSUBS.equals(str5)) {
            throw C2555ao.m4866a("Unexpected MIME type.", null);
        } else {
            i6 = 3;
        }
        String str7 = this.f2980a;
        if (str7 != null) {
            map3 = abg.f3010e;
            if (!map3.containsKey(str7)) {
                c2935o.m1543U(this.f2980a);
            }
        }
        c2935o.m1546R(i);
        c2935o.m1532ae(str5);
        c2935o.m1541W(i2);
        c2935o.m1542V(this.f2979Y);
        c2935o.m1530ag(i13);
        c2935o.m1544T(singletonList);
        c2935o.m1555I(str2);
        c2935o.m1551M(this.f2990k);
        C2962p m1506v = c2935o.m1506v();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(this.f2982c, i6);
        this.f2976V = mo489be;
        mo489be.mo443b(m1506v);
    }
}
