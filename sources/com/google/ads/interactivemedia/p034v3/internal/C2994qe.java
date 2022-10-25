package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qe */
/* loaded from: classes2.dex */
public final class C2994qe implements InterfaceC3169wr {

    /* renamed from: aa */
    private final C2983pu f8617aa;

    /* renamed from: ab */
    private final C2990qa f8618ab;

    /* renamed from: a */
    private static final Pattern f8591a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b */
    private static final Pattern f8592b = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: c */
    private static final Pattern f8593c = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: d */
    private static final Pattern f8594d = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: e */
    private static final Pattern f8595e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: f */
    private static final Pattern f8596f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: g */
    private static final Pattern f8597g = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: h */
    private static final Pattern f8598h = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: i */
    private static final Pattern f8599i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: j */
    private static final Pattern f8600j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: k */
    private static final Pattern f8601k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: l */
    private static final Pattern f8602l = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: m */
    private static final Pattern f8603m = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: n */
    private static final Pattern f8604n = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: o */
    private static final Pattern f8605o = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: p */
    private static final Pattern f8606p = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: q */
    private static final Pattern f8607q = m1331n("CAN-SKIP-DATERANGES");

    /* renamed from: r */
    private static final Pattern f8608r = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: s */
    private static final Pattern f8609s = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: t */
    private static final Pattern f8610t = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: u */
    private static final Pattern f8611u = m1331n("CAN-BLOCK-RELOAD");

    /* renamed from: v */
    private static final Pattern f8612v = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: w */
    private static final Pattern f8613w = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: x */
    private static final Pattern f8614x = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: y */
    private static final Pattern f8615y = Pattern.compile("LAST-MSN=(\\d+)\\b");

    /* renamed from: z */
    private static final Pattern f8616z = Pattern.compile("LAST-PART=(\\d+)\\b");

    /* renamed from: A */
    private static final Pattern f8565A = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* renamed from: B */
    private static final Pattern f8566B = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: C */
    private static final Pattern f8567C = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* renamed from: D */
    private static final Pattern f8568D = Pattern.compile("BYTERANGE-START=(\\d+)\\b");

    /* renamed from: E */
    private static final Pattern f8569E = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");

    /* renamed from: F */
    private static final Pattern f8570F = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* renamed from: G */
    private static final Pattern f8571G = Pattern.compile("KEYFORMAT=\"(.+?)\"");

    /* renamed from: H */
    private static final Pattern f8572H = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");

    /* renamed from: I */
    private static final Pattern f8573I = Pattern.compile("URI=\"(.+?)\"");

    /* renamed from: J */
    private static final Pattern f8574J = Pattern.compile("IV=([^,.*]+)");

    /* renamed from: K */
    private static final Pattern f8575K = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* renamed from: L */
    private static final Pattern f8576L = Pattern.compile("TYPE=(PART|MAP)");

    /* renamed from: M */
    private static final Pattern f8577M = Pattern.compile("LANGUAGE=\"(.+?)\"");

    /* renamed from: N */
    private static final Pattern f8578N = Pattern.compile("NAME=\"(.+?)\"");

    /* renamed from: O */
    private static final Pattern f8579O = Pattern.compile("GROUP-ID=\"(.+?)\"");

    /* renamed from: P */
    private static final Pattern f8580P = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");

    /* renamed from: Q */
    private static final Pattern f8581Q = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: R */
    private static final Pattern f8582R = m1331n("AUTOSELECT");

    /* renamed from: S */
    private static final Pattern f8583S = m1331n(MessengerShareContentUtility.PREVIEW_DEFAULT);

    /* renamed from: T */
    private static final Pattern f8584T = m1331n("FORCED");

    /* renamed from: U */
    private static final Pattern f8585U = m1331n("INDEPENDENT");

    /* renamed from: V */
    private static final Pattern f8586V = m1331n("GAP");

    /* renamed from: W */
    private static final Pattern f8587W = m1331n("PRECISE");

    /* renamed from: X */
    private static final Pattern f8588X = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: Y */
    private static final Pattern f8589Y = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: Z */
    private static final Pattern f8590Z = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public C2994qe() {
        C2983pu c2983pu = C2983pu.f8508a;
        throw null;
    }

    public C2994qe(C2983pu c2983pu, C2990qa c2990qa) {
        this.f8617aa = c2983pu;
        this.f8618ab = c2990qa;
    }

    /* renamed from: b */
    private static double m1343b(String str, Pattern pattern) throws C2555ao {
        return Double.parseDouble(m1333l(str, pattern, Collections.emptyMap()));
    }

    /* renamed from: c */
    private static int m1342c(String str, Pattern pattern) throws C2555ao {
        return Integer.parseInt(m1333l(str, pattern, Collections.emptyMap()));
    }

    /* renamed from: d */
    private static int m1341d(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !C2628cq.m2559X(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* renamed from: e */
    private static C2827k m1340e(String str, String str2, Map map) throws C2555ao {
        String m1334k = m1334k(str, f8572H, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String m1333l = m1333l(str, f8573I, map);
            return new C2827k(C2692f.f7210d, MimeTypes.VIDEO_MP4, Base64.decode(m1333l.substring(m1333l.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new C2827k(C2692f.f7210d, "hls", C2628cq.m2554ab(str));
        } else {
            if ("com.microsoft.playready".equals(str2) && "1".equals(m1334k)) {
                String m1333l2 = m1333l(str, f8573I, map);
                return new C2827k(C2692f.f7211e, MimeTypes.VIDEO_MP4, acn.m5833d(C2692f.f7211e, Base64.decode(m1333l2.substring(m1333l2.indexOf(44)), 0)));
            }
            return null;
        }
    }

    /* renamed from: f */
    private static C2854l m1339f(String str, C2827k[] c2827kArr) {
        C2827k[] c2827kArr2 = new C2827k[c2827kArr.length];
        for (int i = 0; i < c2827kArr.length; i++) {
            c2827kArr2[i] = c2827kArr[i].m1840a(null);
        }
        return new C2854l(str, c2827kArr2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* renamed from: g */
    private static C2983pu m1338g(C2993qd c2993qd, String str) throws IOException {
        int i;
        char c;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        C2982pt c2982pt;
        ArrayList arrayList4;
        C2982pt c2982pt2;
        String str2;
        C2982pt c2982pt3;
        String str3;
        int parseInt;
        String str4;
        int i2;
        boolean z;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        int i3;
        int i4;
        ArrayList arrayList10;
        ArrayList arrayList11;
        Uri m2675r;
        HashMap hashMap;
        String str5 = str;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            boolean m1344b = c2993qd.m1344b();
            String str6 = MimeTypes.APPLICATION_M3U8;
            int i5 = -1;
            if (m1344b) {
                String m1345a = c2993qd.m1345a();
                if (m1345a.startsWith("#EXT")) {
                    arrayList19.add(m1345a);
                }
                boolean startsWith = m1345a.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                boolean z4 = z2;
                if (m1345a.startsWith("#EXT-X-DEFINE")) {
                    hashMap3.put(m1333l(m1345a, f8578N, hashMap3), m1333l(m1345a, f8588X, hashMap3));
                } else {
                    if (m1345a.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        hashMap = hashMap2;
                        arrayList11 = arrayList17;
                        arrayList8 = arrayList13;
                        arrayList9 = arrayList14;
                        arrayList10 = arrayList15;
                        arrayList6 = arrayList16;
                        arrayList7 = arrayList19;
                        arrayList5 = arrayList18;
                        z2 = true;
                    } else if (m1345a.startsWith("#EXT-X-MEDIA")) {
                        arrayList17.add(m1345a);
                    } else if (m1345a.startsWith("#EXT-X-SESSION-KEY")) {
                        C2827k m1340e = m1340e(m1345a, m1334k(m1345a, f8571G, "identity", hashMap3), hashMap3);
                        if (m1340e != null) {
                            arrayList18.add(new C2854l(m1336i(m1333l(m1345a, f8570F, hashMap3)), m1340e));
                        }
                    } else {
                        if (!m1345a.startsWith("#EXT-X-STREAM-INF")) {
                            if (startsWith) {
                                startsWith = true;
                            }
                        }
                        boolean contains = z3 | m1345a.contains("CLOSED-CAPTIONS=NONE");
                        if (true != startsWith) {
                            z = contains;
                            i2 = 0;
                        } else {
                            i2 = 16384;
                            z = contains;
                        }
                        int m1342c = m1342c(m1345a, f8596f);
                        arrayList5 = arrayList18;
                        int m1328q = m1328q(m1345a, f8591a);
                        arrayList6 = arrayList16;
                        String m1335j = m1335j(m1345a, f8598h, hashMap3);
                        arrayList7 = arrayList19;
                        String m1335j2 = m1335j(m1345a, f8599i, hashMap3);
                        if (m1335j2 != null) {
                            arrayList8 = arrayList13;
                            String[] m2547ai = C2628cq.m2547ai(m1335j2, "x");
                            i4 = Integer.parseInt(m2547ai[0]);
                            int parseInt2 = Integer.parseInt(m2547ai[1]);
                            if (i4 <= 0 || parseInt2 <= 0) {
                                i4 = -1;
                            } else {
                                i5 = parseInt2;
                            }
                            arrayList9 = arrayList14;
                            i3 = i5;
                        } else {
                            arrayList8 = arrayList13;
                            arrayList9 = arrayList14;
                            i3 = -1;
                            i4 = -1;
                        }
                        String m1335j3 = m1335j(m1345a, f8600j, hashMap3);
                        float parseFloat = m1335j3 != null ? Float.parseFloat(m1335j3) : -1.0f;
                        arrayList10 = arrayList15;
                        String m1335j4 = m1335j(m1345a, f8592b, hashMap3);
                        arrayList11 = arrayList17;
                        String m1335j5 = m1335j(m1345a, f8593c, hashMap3);
                        HashMap hashMap4 = hashMap2;
                        String m1335j6 = m1335j(m1345a, f8594d, hashMap3);
                        String m1335j7 = m1335j(m1345a, f8595e, hashMap3);
                        if (startsWith) {
                            m2675r = C2616ce.m2675r(str5, m1333l(m1345a, f8573I, hashMap3));
                        } else if (c2993qd.m1344b()) {
                            m2675r = C2616ce.m2675r(str5, m1332m(c2993qd.m1345a(), hashMap3));
                        } else {
                            throw C2555ao.m4864c("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        C2935o c2935o = new C2935o();
                        c2935o.m1546R(arrayList12.size());
                        c2935o.m1553K(MimeTypes.APPLICATION_M3U8);
                        c2935o.m1555I(m1335j);
                        c2935o.m1557G(m1328q);
                        c2935o.m1538Z(m1342c);
                        c2935o.m1527aj(i4);
                        c2935o.m1547Q(i3);
                        c2935o.m1548P(parseFloat);
                        c2935o.m1534ac(i2);
                        arrayList12.add(new C2982pt(m2675r, c2935o.m1506v(), m1335j4, m1335j5, m1335j6, m1335j7));
                        hashMap = hashMap4;
                        ArrayList arrayList20 = (ArrayList) hashMap.get(m2675r);
                        if (arrayList20 == null) {
                            arrayList20 = new ArrayList();
                            hashMap.put(m2675r, arrayList20);
                        }
                        arrayList20.add(new C2969pg(m1328q, m1342c, m1335j4, m1335j5, m1335j6, m1335j7));
                        z2 = z4;
                        z3 = z;
                    }
                    hashMap2 = hashMap;
                    arrayList18 = arrayList5;
                    arrayList16 = arrayList6;
                    arrayList19 = arrayList7;
                    arrayList13 = arrayList8;
                    arrayList14 = arrayList9;
                    arrayList15 = arrayList10;
                    arrayList17 = arrayList11;
                    str5 = str;
                }
                hashMap = hashMap2;
                arrayList11 = arrayList17;
                arrayList8 = arrayList13;
                arrayList9 = arrayList14;
                arrayList10 = arrayList15;
                arrayList6 = arrayList16;
                arrayList7 = arrayList19;
                arrayList5 = arrayList18;
                z2 = z4;
                hashMap2 = hashMap;
                arrayList18 = arrayList5;
                arrayList16 = arrayList6;
                arrayList19 = arrayList7;
                arrayList13 = arrayList8;
                arrayList14 = arrayList9;
                arrayList15 = arrayList10;
                arrayList17 = arrayList11;
                str5 = str;
            } else {
                HashMap hashMap5 = hashMap2;
                ArrayList arrayList21 = arrayList17;
                ArrayList arrayList22 = arrayList13;
                ArrayList arrayList23 = arrayList14;
                ArrayList arrayList24 = arrayList15;
                ArrayList arrayList25 = arrayList16;
                ArrayList arrayList26 = arrayList19;
                boolean z5 = z2;
                ArrayList arrayList27 = arrayList18;
                ArrayList arrayList28 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i6 = 0; i6 < arrayList12.size(); i6++) {
                    C2982pt c2982pt4 = (C2982pt) arrayList12.get(i6);
                    if (hashSet.add(c2982pt4.f8502a)) {
                        C2616ce.m2685h(c2982pt4.f8503b.f8370j == null);
                        ArrayList arrayList29 = (ArrayList) hashMap5.get(c2982pt4.f8502a);
                        C2616ce.m2689d(arrayList29);
                        C2549ak c2549ak = new C2549ak(new C2970ph(null, null, arrayList29));
                        C2935o m1426b = c2982pt4.f8503b.m1426b();
                        m1426b.m1540X(c2549ak);
                        arrayList28.add(new C2982pt(c2982pt4.f8502a, m1426b.m1506v(), c2982pt4.f8504c, c2982pt4.f8505d, c2982pt4.f8506e, c2982pt4.f8507f));
                    }
                }
                ArrayList arrayList30 = null;
                C2962p c2962p = null;
                int i7 = 0;
                while (i7 < arrayList21.size()) {
                    ArrayList arrayList31 = arrayList21;
                    String str7 = (String) arrayList31.get(i7);
                    String m1333l = m1333l(str7, f8579O, hashMap3);
                    String m1333l2 = m1333l(str7, f8578N, hashMap3);
                    C2935o c2935o2 = new C2935o();
                    StringBuilder sb = new StringBuilder(m1333l.length() + 1 + m1333l2.length());
                    sb.append(m1333l);
                    sb.append(":");
                    sb.append(m1333l2);
                    c2935o2.m1545S(sb.toString());
                    c2935o2.m1543U(m1333l2);
                    c2935o2.m1553K(str6);
                    ?? m1330o = m1330o(str7, f8583S);
                    int i8 = m1330o;
                    if (m1330o(str7, f8584T)) {
                        i8 = (m1330o == true ? 1 : 0) | 2;
                    }
                    int i9 = i8;
                    if (m1330o(str7, f8582R)) {
                        i9 = (i8 == 1 ? 1 : 0) | 4;
                    }
                    c2935o2.m1530ag(i9);
                    String m1335j8 = m1335j(str7, f8580P, hashMap3);
                    if (TextUtils.isEmpty(m1335j8)) {
                        i = 0;
                    } else {
                        String[] m2547ai2 = C2628cq.m2547ai(m1335j8, ",");
                        i = true != C2628cq.m2562U(m2547ai2, "public.accessibility.describes-video") ? 0 : 512;
                        if (C2628cq.m2562U(m2547ai2, "public.accessibility.transcribes-spoken-dialog")) {
                            i |= 4096;
                        }
                        if (C2628cq.m2562U(m2547ai2, "public.accessibility.describes-music-and-sound")) {
                            i |= 1024;
                        }
                        if (C2628cq.m2562U(m2547ai2, "public.easy-to-read")) {
                            i |= 8192;
                        }
                    }
                    c2935o2.m1534ac(i);
                    c2935o2.m1542V(m1335j(str7, f8577M, hashMap3));
                    String m1335j9 = m1335j(str7, f8573I, hashMap3);
                    Uri m2675r2 = m1335j9 == null ? null : C2616ce.m2675r(str, m1335j9);
                    arrayList21 = arrayList31;
                    String str8 = str6;
                    C2549ak c2549ak2 = new C2549ak(new C2970ph(m1333l, m1333l2, Collections.emptyList()));
                    String m1333l3 = m1333l(str7, f8575K, hashMap3);
                    switch (m1333l3.hashCode()) {
                        case -959297733:
                            if (m1333l3.equals("SUBTITLES")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -333210994:
                            if (m1333l3.equals("CLOSED-CAPTIONS")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 62628790:
                            if (m1333l3.equals("AUDIO")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 81665115:
                            if (m1333l3.equals(ShareConstants.VIDEO_URL)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c == 2) {
                                int i10 = 0;
                                while (true) {
                                    if (i10 < arrayList12.size()) {
                                        c2982pt3 = (C2982pt) arrayList12.get(i10);
                                        if (!m1333l.equals(c2982pt3.f8506e)) {
                                            i10++;
                                        }
                                    } else {
                                        c2982pt3 = null;
                                    }
                                }
                                if (c2982pt3 != null) {
                                    String m2574I = C2628cq.m2574I(c2982pt3.f8503b.f8369i, 3);
                                    c2935o2.m1555I(m2574I);
                                    str3 = C2554an.m4971f(m2574I);
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = MimeTypes.TEXT_VTT;
                                }
                                c2935o2.m1532ae(str3);
                                c2935o2.m1540X(c2549ak2);
                                if (m2675r2 != null) {
                                    arrayList3 = arrayList24;
                                    arrayList3.add(new C2981ps(m2675r2, c2935o2.m1506v(), m1333l2));
                                } else {
                                    arrayList3 = arrayList24;
                                    Log.w("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                }
                                arrayList = arrayList30;
                                arrayList4 = arrayList22;
                                arrayList2 = arrayList23;
                            } else if (c != 3) {
                                arrayList = arrayList30;
                                arrayList4 = arrayList22;
                                arrayList2 = arrayList23;
                                arrayList3 = arrayList24;
                            } else {
                                String m1333l4 = m1333l(str7, f8581Q, hashMap3);
                                if (m1333l4.startsWith("CC")) {
                                    parseInt = Integer.parseInt(m1333l4.substring(2));
                                    str4 = MimeTypes.APPLICATION_CEA608;
                                } else {
                                    parseInt = Integer.parseInt(m1333l4.substring(7));
                                    str4 = MimeTypes.APPLICATION_CEA708;
                                }
                                if (arrayList30 == null) {
                                    arrayList30 = new ArrayList();
                                }
                                c2935o2.m1532ae(str4);
                                c2935o2.m1558F(parseInt);
                                arrayList30.add(c2935o2.m1506v());
                                arrayList4 = arrayList22;
                                arrayList2 = arrayList23;
                                arrayList3 = arrayList24;
                            }
                            arrayList30 = arrayList;
                        } else {
                            arrayList3 = arrayList24;
                            int i11 = 0;
                            while (true) {
                                if (i11 < arrayList12.size()) {
                                    C2982pt c2982pt5 = (C2982pt) arrayList12.get(i11);
                                    arrayList = arrayList30;
                                    if (m1333l.equals(c2982pt5.f8505d)) {
                                        c2982pt2 = c2982pt5;
                                    } else {
                                        i11++;
                                        arrayList30 = arrayList;
                                    }
                                } else {
                                    arrayList = arrayList30;
                                    c2982pt2 = null;
                                }
                            }
                            if (c2982pt2 != null) {
                                String m2574I2 = C2628cq.m2574I(c2982pt2.f8503b.f8369i, 1);
                                c2935o2.m1555I(m2574I2);
                                str2 = C2554an.m4971f(m2574I2);
                            } else {
                                str2 = null;
                            }
                            String m1335j10 = m1335j(str7, f8597g, hashMap3);
                            if (m1335j10 != null) {
                                c2935o2.m1556H(Integer.parseInt(C2628cq.m2546aj(m1335j10, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(str2) && m1335j10.endsWith("/JOC")) {
                                    c2935o2.m1555I(MimeTypes.CODEC_E_AC3_JOC);
                                    str2 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            c2935o2.m1532ae(str2);
                            if (m2675r2 != null) {
                                c2935o2.m1540X(c2549ak2);
                                arrayList2 = arrayList23;
                                arrayList2.add(new C2981ps(m2675r2, c2935o2.m1506v(), m1333l2));
                            } else {
                                arrayList2 = arrayList23;
                                if (c2982pt2 != null) {
                                    c2962p = c2935o2.m1506v();
                                    arrayList30 = arrayList;
                                    arrayList4 = arrayList22;
                                }
                            }
                            arrayList4 = arrayList22;
                            arrayList30 = arrayList;
                        }
                        i7++;
                        arrayList22 = arrayList4;
                        arrayList23 = arrayList2;
                        arrayList24 = arrayList3;
                        str6 = str8;
                    } else {
                        arrayList = arrayList30;
                        arrayList2 = arrayList23;
                        arrayList3 = arrayList24;
                        int i12 = 0;
                        while (true) {
                            if (i12 < arrayList12.size()) {
                                c2982pt = (C2982pt) arrayList12.get(i12);
                                if (!m1333l.equals(c2982pt.f8504c)) {
                                    i12++;
                                }
                            } else {
                                c2982pt = null;
                            }
                        }
                        if (c2982pt != null) {
                            C2962p c2962p2 = c2982pt.f8503b;
                            String m2574I3 = C2628cq.m2574I(c2962p2.f8369i, 2);
                            c2935o2.m1555I(m2574I3);
                            c2935o2.m1532ae(C2554an.m4971f(m2574I3));
                            c2935o2.m1527aj(c2962p2.f8377q);
                            c2935o2.m1547Q(c2962p2.f8378r);
                            c2935o2.m1548P(c2962p2.f8379s);
                        }
                        if (m2675r2 != null) {
                            c2935o2.m1540X(c2549ak2);
                            arrayList4 = arrayList22;
                            arrayList4.add(new C2981ps(m2675r2, c2935o2.m1506v(), m1333l2));
                            arrayList30 = arrayList;
                            i7++;
                            arrayList22 = arrayList4;
                            arrayList23 = arrayList2;
                            arrayList24 = arrayList3;
                            str6 = str8;
                        }
                        arrayList4 = arrayList22;
                        arrayList30 = arrayList;
                        i7++;
                        arrayList22 = arrayList4;
                        arrayList23 = arrayList2;
                        arrayList24 = arrayList3;
                        str6 = str8;
                    }
                }
                return new C2983pu(str, arrayList26, arrayList28, arrayList22, arrayList23, arrayList24, arrayList25, c2962p, z3 ? Collections.emptyList() : arrayList30, z5, hashMap3, arrayList27);
            }
        }
    }

    /* renamed from: h */
    private static String m1337h(long j, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j);
    }

    /* renamed from: i */
    private static String m1336i(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? C3282C.CENC_TYPE_cenc : C3282C.CENC_TYPE_cbcs;
    }

    /* renamed from: j */
    private static String m1335j(String str, Pattern pattern, Map map) {
        return m1334k(str, pattern, null, map);
    }

    /* renamed from: k */
    private static String m1334k(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            C2616ce.m2689d(str2);
        }
        return (map.isEmpty() || str2 == null) ? str2 : m1332m(str2, map);
    }

    /* renamed from: l */
    private static String m1333l(String str, Pattern pattern, Map map) throws C2555ao {
        String m1335j = m1335j(str, pattern, map);
        if (m1335j != null) {
            return m1335j;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw C2555ao.m4864c(sb.toString(), null);
    }

    /* renamed from: m */
    private static String m1332m(String str, Map map) {
        Matcher matcher = f8590Z.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: n */
    private static Pattern m1331n(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 9);
        sb.append(str);
        sb.append("=(NO|YES)");
        return Pattern.compile(sb.toString());
    }

    /* renamed from: o */
    private static boolean m1330o(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    /* renamed from: p */
    private static double m1329p(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            C2616ce.m2689d(group);
            return Double.parseDouble(group);
        }
        return -9.223372036854776E18d;
    }

    /* renamed from: q */
    private static int m1328q(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            C2616ce.m2689d(group);
            return Integer.parseInt(group);
        }
        return -1;
    }

    /* renamed from: r */
    private static long m1327r(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            C2616ce.m2689d(group);
            return Long.parseLong(group);
        }
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v24 */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3169wr
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo714a(Uri uri, InputStream inputStream) throws IOException {
        int read;
        String trim;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ArrayList arrayList;
        C2983pu c2983pu;
        String str6;
        ArrayList arrayList2;
        C2990qa c2990qa;
        String str7;
        String str8;
        String str9;
        String str10;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C2984pv c2984pv;
        HashMap hashMap;
        HashMap hashMap2;
        TreeMap treeMap;
        String str11;
        String str12;
        long j;
        String str13;
        Object obj;
        ArrayList arrayList5;
        TreeMap treeMap2;
        String str14;
        TreeMap treeMap3;
        String str15;
        long j2;
        C2986px c2986px;
        C2854l c2854l;
        long j3;
        String str16;
        String str17;
        String str18;
        HashMap hashMap3;
        int i;
        C2983pu c2983pu2;
        String str19;
        ArrayList arrayList6;
        C2990qa c2990qa2;
        String str20;
        String str21;
        int i2;
        String str22;
        String str23;
        ArrayList arrayList7;
        C2994qe c2994qe = this;
        String str24 = "identity";
        String str25 = "#EXT-X-TARGETDURATION";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            read = bufferedReader.read();
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (read == 239) {
                if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
                throw C2555ao.m4864c("Input does not start with the #EXTM3U header.", null);
            }
            int m1341d = m1341d(bufferedReader, true, read);
            int i3 = 0;
            while (true) {
                if (i3 < 7) {
                    if (m1341d != "#EXTM3U".charAt(i3)) {
                        break;
                    }
                    m1341d = bufferedReader.read();
                    i3++;
                } else if (C2628cq.m2559X(m1341d(bufferedReader, false, m1341d))) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            trim = readLine.trim();
                            if (trim.isEmpty()) {
                                c2994qe = this;
                            } else if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                str = "#EXT-X-KEY";
                                str2 = "#EXTINF";
                                str3 = "#EXT-X-MEDIA-SEQUENCE";
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                }
                                arrayDeque.add(trim);
                            } else {
                                arrayDeque.add(trim);
                                C2983pu m1338g = m1338g(new C2993qd(arrayDeque, bufferedReader), uri.toString());
                                C2628cq.m2566Q(bufferedReader);
                                return m1338g;
                            }
                        } else {
                            C2628cq.m2566Q(bufferedReader);
                            throw C2555ao.m4864c("Failed to parse the playlist, could not identify any tags.", null);
                        }
                    }
                    arrayDeque.add(trim);
                    C2983pu c2983pu3 = c2994qe.f8617aa;
                    C2990qa c2990qa3 = c2994qe.f8618ab;
                    C2993qd c2993qd = new C2993qd(arrayDeque, bufferedReader);
                    String uri2 = uri.toString();
                    boolean z = c2983pu3.f8561v;
                    HashMap hashMap4 = new HashMap();
                    HashMap hashMap5 = new HashMap();
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    HashMap hashMap6 = hashMap5;
                    ArrayList arrayList10 = new ArrayList();
                    ArrayList arrayList11 = new ArrayList();
                    C2988pz c2988pz = new C2988pz(C3282C.TIME_UNSET, false, C3282C.TIME_UNSET, C3282C.TIME_UNSET, false);
                    String str26 = uri2;
                    TreeMap treeMap4 = new TreeMap();
                    Object obj2 = "#EXT-X-ENDLIST";
                    String str27 = "";
                    String str28 = "";
                    String str29 = "#EXT-X-DISCONTINUITY-SEQUENCE";
                    String str30 = "#EXT-X-BYTERANGE";
                    boolean z2 = z;
                    ArrayList arrayList12 = arrayList9;
                    long j4 = -9223372036854775807L;
                    long j5 = -9223372036854775807L;
                    long j6 = -1;
                    long j7 = 0;
                    long j8 = 0;
                    long j9 = 0;
                    long j10 = 0;
                    long j11 = 0;
                    long j12 = 0;
                    long j13 = 0;
                    long j14 = 0;
                    C2988pz c2988pz2 = c2988pz;
                    String str31 = null;
                    String str32 = null;
                    int i4 = 0;
                    boolean z3 = false;
                    boolean z4 = false;
                    int i5 = 0;
                    int i6 = 1;
                    boolean z5 = false;
                    C2854l c2854l2 = null;
                    C2854l c2854l3 = null;
                    boolean z6 = false;
                    C2984pv c2984pv2 = null;
                    int i7 = 0;
                    boolean z7 = false;
                    C2986px c2986px2 = null;
                    Object obj3 = "#EXT-X-DISCONTINUITY";
                    long j15 = -9223372036854775807L;
                    String str33 = null;
                    while (c2993qd.m1344b()) {
                        String str34 = str32;
                        String m1345a = c2993qd.m1345a();
                        C2993qd c2993qd2 = c2993qd;
                        if (m1345a.startsWith("#EXT")) {
                            arrayList11.add(m1345a);
                        }
                        if (m1345a.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                            String m1333l = m1333l(m1345a, f8605o, hashMap4);
                            if ("VOD".equals(m1333l)) {
                                str32 = str34;
                                c2993qd = c2993qd2;
                                i4 = 1;
                            } else if ("EVENT".equals(m1333l)) {
                                i4 = 2;
                                str32 = str34;
                                c2993qd = c2993qd2;
                            } else {
                                str4 = str24;
                                str5 = str25;
                                arrayList = arrayList8;
                                c2983pu = c2983pu3;
                                str6 = str3;
                                arrayList2 = arrayList11;
                                c2990qa = c2990qa3;
                                str7 = str27;
                                str8 = str31;
                                str9 = str;
                                str10 = str2;
                                arrayList3 = arrayList10;
                                arrayList4 = arrayList12;
                                c2984pv = c2984pv2;
                                hashMap = hashMap6;
                                hashMap2 = hashMap4;
                                treeMap = treeMap4;
                                str11 = str33;
                                str12 = str26;
                                j = j12;
                                str13 = str34;
                                obj = obj3;
                            }
                        } else if (m1345a.equals("#EXT-X-I-FRAMES-ONLY")) {
                            str32 = str34;
                            c2993qd = c2993qd2;
                            z7 = true;
                        } else {
                            if (m1345a.startsWith("#EXT-X-START")) {
                                arrayList5 = arrayList8;
                                treeMap2 = treeMap4;
                                j15 = (long) (m1343b(m1345a, f8565A) * 1000000.0d);
                                z3 = m1330o(m1345a, f8587W);
                            } else {
                                arrayList5 = arrayList8;
                                treeMap2 = treeMap4;
                                if (m1345a.startsWith("#EXT-X-SERVER-CONTROL")) {
                                    double m1329p = m1329p(m1345a, f8606p);
                                    long j16 = m1329p == -9.223372036854776E18d ? -9223372036854775807L : (long) (m1329p * 1000000.0d);
                                    boolean m1330o = m1330o(m1345a, f8607q);
                                    double m1329p2 = m1329p(m1345a, f8609s);
                                    long j17 = m1329p2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (m1329p2 * 1000000.0d);
                                    double m1329p3 = m1329p(m1345a, f8610t);
                                    c2988pz2 = new C2988pz(j16, m1330o, j17, m1329p3 == -9.223372036854776E18d ? -9223372036854775807L : (long) (m1329p3 * 1000000.0d), m1330o(m1345a, f8611u));
                                } else if (m1345a.startsWith("#EXT-X-PART-INF")) {
                                    j5 = (long) (m1343b(m1345a, f8603m) * 1000000.0d);
                                } else if (m1345a.startsWith("#EXT-X-MAP")) {
                                    String m1333l2 = m1333l(m1345a, f8573I, hashMap4);
                                    String m1335j = m1335j(m1345a, f8567C, hashMap4);
                                    if (m1335j != null) {
                                        String[] m2547ai = C2628cq.m2547ai(m1335j, "@");
                                        j6 = Long.parseLong(m2547ai[0]);
                                        if (m2547ai.length > 1) {
                                            j9 = Long.parseLong(m2547ai[1]);
                                        }
                                    }
                                    int i8 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
                                    if (i8 == 0) {
                                        j9 = 0;
                                    }
                                    if (str33 != null && str31 == null) {
                                        throw C2555ao.m4864c("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                                    }
                                    c2986px2 = new C2986px(m1333l2, j9, j6, str33, str31);
                                    if (i8 != 0) {
                                        j9 += j6;
                                    }
                                    arrayList8 = arrayList5;
                                    j6 = -1;
                                    str32 = str34;
                                    c2993qd = c2993qd2;
                                    treeMap4 = treeMap2;
                                } else {
                                    String str35 = str31;
                                    String str36 = str33;
                                    if (m1345a.startsWith(str25)) {
                                        j4 = m1342c(m1345a, f8601k) * 1000000;
                                    } else if (m1345a.startsWith(str3)) {
                                        j12 = Long.parseLong(m1333l(m1345a, f8612v, Collections.emptyMap()));
                                        arrayList8 = arrayList5;
                                        j8 = j12;
                                        str32 = str34;
                                        c2993qd = c2993qd2;
                                        treeMap4 = treeMap2;
                                        str33 = str36;
                                        str31 = str35;
                                    } else if (m1345a.startsWith("#EXT-X-VERSION")) {
                                        i6 = m1342c(m1345a, f8604n);
                                    } else if (m1345a.startsWith("#EXT-X-DEFINE")) {
                                        String m1335j2 = m1335j(m1345a, f8589Y, hashMap4);
                                        if (m1335j2 != null) {
                                            String str37 = (String) c2983pu3.f8515h.get(m1335j2);
                                            if (str37 != null) {
                                                hashMap4.put(m1335j2, str37);
                                            }
                                        } else {
                                            hashMap4.put(m1333l(m1345a, f8578N, hashMap4), m1333l(m1345a, f8588X, hashMap4));
                                        }
                                        str4 = str24;
                                        hashMap2 = hashMap4;
                                        str5 = str25;
                                        c2983pu = c2983pu3;
                                        arrayList = arrayList5;
                                        str6 = str3;
                                        arrayList2 = arrayList11;
                                        c2990qa = c2990qa3;
                                        str7 = str27;
                                        str9 = str;
                                        str10 = str2;
                                        arrayList3 = arrayList10;
                                        arrayList4 = arrayList12;
                                        c2984pv = c2984pv2;
                                        j = j12;
                                        str13 = str34;
                                        treeMap = treeMap2;
                                        str11 = str36;
                                        str8 = str35;
                                        hashMap = hashMap6;
                                        str12 = str26;
                                        obj = obj3;
                                    } else if (m1345a.startsWith(str2)) {
                                        j14 = new BigDecimal(m1333l(m1345a, f8613w, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
                                        str28 = m1334k(m1345a, f8614x, str27, hashMap4);
                                    } else if (m1345a.startsWith("#EXT-X-SKIP")) {
                                        int m1342c = m1342c(m1345a, f8608r);
                                        C2616ce.m2685h(c2990qa3 != null && arrayList5.isEmpty());
                                        int i9 = (int) (j8 - c2990qa3.f8547h);
                                        int i10 = m1342c + i9;
                                        if (i9 < 0 || i10 > c2990qa3.f8554o.size()) {
                                            throw new C2992qc();
                                        }
                                        str33 = str36;
                                        str31 = str35;
                                        while (i9 < i10) {
                                            C2986px c2986px3 = (C2986px) c2990qa3.f8554o.get(i9);
                                            String str38 = str25;
                                            int i11 = i10;
                                            if (j8 != c2990qa3.f8547h) {
                                                int i12 = (c2990qa3.f8546g - i5) + c2986px3.f8527f;
                                                ArrayList arrayList13 = new ArrayList();
                                                c2983pu2 = c2983pu3;
                                                str19 = str3;
                                                long j18 = j11;
                                                int i13 = 0;
                                                while (i13 < c2986px3.f8523b.size()) {
                                                    C2984pv c2984pv3 = (C2984pv) c2986px3.f8523b.get(i13);
                                                    ArrayList arrayList14 = arrayList13;
                                                    arrayList14.add(new C2984pv(c2984pv3.f8524c, c2984pv3.f8525d, c2984pv3.f8526e, i12, j18, c2984pv3.f8529h, c2984pv3.f8530i, c2984pv3.f8531j, c2984pv3.f8532k, c2984pv3.f8533l, c2984pv3.f8534m, c2984pv3.f8517a, c2984pv3.f8518b));
                                                    j18 += c2984pv3.f8526e;
                                                    i13++;
                                                    arrayList13 = arrayList14;
                                                    i11 = i11;
                                                    str31 = str31;
                                                    i9 = i9;
                                                    c2990qa3 = c2990qa3;
                                                    str27 = str27;
                                                    str24 = str24;
                                                    hashMap4 = hashMap4;
                                                    str2 = str2;
                                                    arrayList11 = arrayList11;
                                                    str = str;
                                                    arrayList5 = arrayList5;
                                                }
                                                str18 = str24;
                                                hashMap3 = hashMap4;
                                                i = i9;
                                                arrayList6 = arrayList11;
                                                c2990qa2 = c2990qa3;
                                                str20 = str27;
                                                str21 = str31;
                                                i2 = i11;
                                                str22 = str;
                                                str23 = str2;
                                                c2986px3 = new C2986px(c2986px3.f8524c, c2986px3.f8525d, c2986px3.f8522a, c2986px3.f8526e, i12, j11, c2986px3.f8529h, c2986px3.f8530i, c2986px3.f8531j, c2986px3.f8532k, c2986px3.f8533l, c2986px3.f8534m, arrayList13);
                                                arrayList7 = arrayList5;
                                            } else {
                                                str18 = str24;
                                                hashMap3 = hashMap4;
                                                i = i9;
                                                c2983pu2 = c2983pu3;
                                                str19 = str3;
                                                arrayList6 = arrayList11;
                                                c2990qa2 = c2990qa3;
                                                str20 = str27;
                                                str21 = str31;
                                                i2 = i11;
                                                str22 = str;
                                                str23 = str2;
                                                arrayList7 = arrayList5;
                                            }
                                            arrayList7.add(c2986px3);
                                            j11 += c2986px3.f8526e;
                                            long j19 = c2986px3.f8533l;
                                            if (j19 != -1) {
                                                j9 = c2986px3.f8532k + j19;
                                            }
                                            int i14 = c2986px3.f8527f;
                                            C2986px c2986px4 = c2986px3.f8525d;
                                            C2854l c2854l4 = c2986px3.f8529h;
                                            String str39 = c2986px3.f8530i;
                                            String str40 = c2986px3.f8531j;
                                            if (str40 != null && str40.equals(Long.toHexString(j12))) {
                                                str31 = str21;
                                                j12++;
                                                arrayList5 = arrayList7;
                                                i7 = i14;
                                                c2986px2 = c2986px4;
                                                str33 = str39;
                                                i9 = i + 1;
                                                j10 = j11;
                                                str25 = str38;
                                                c2983pu3 = c2983pu2;
                                                str3 = str19;
                                                c2990qa3 = c2990qa2;
                                                str27 = str20;
                                                str24 = str18;
                                                hashMap4 = hashMap3;
                                                str2 = str23;
                                                arrayList11 = arrayList6;
                                                str = str22;
                                                int i15 = i2;
                                                c2854l3 = c2854l4;
                                                i10 = i15;
                                            }
                                            str31 = c2986px3.f8531j;
                                            j12++;
                                            arrayList5 = arrayList7;
                                            i7 = i14;
                                            c2986px2 = c2986px4;
                                            str33 = str39;
                                            i9 = i + 1;
                                            j10 = j11;
                                            str25 = str38;
                                            c2983pu3 = c2983pu2;
                                            str3 = str19;
                                            c2990qa3 = c2990qa2;
                                            str27 = str20;
                                            str24 = str18;
                                            hashMap4 = hashMap3;
                                            str2 = str23;
                                            arrayList11 = arrayList6;
                                            str = str22;
                                            int i152 = i2;
                                            c2854l3 = c2854l4;
                                            i10 = i152;
                                        }
                                    } else {
                                        String str41 = str24;
                                        HashMap hashMap7 = hashMap4;
                                        str5 = str25;
                                        c2983pu = c2983pu3;
                                        arrayList = arrayList5;
                                        str6 = str3;
                                        arrayList2 = arrayList11;
                                        c2990qa = c2990qa3;
                                        str7 = str27;
                                        str10 = str2;
                                        String str42 = str;
                                        if (m1345a.startsWith(str42)) {
                                            String m1333l3 = m1333l(m1345a, f8570F, hashMap7);
                                            str14 = str41;
                                            String m1334k = m1334k(m1345a, f8571G, str14, hashMap7);
                                            if ("NONE".equals(m1333l3)) {
                                                treeMap2.clear();
                                                str32 = str34;
                                                treeMap3 = treeMap2;
                                                str31 = null;
                                            } else {
                                                String m1335j3 = m1335j(m1345a, f8574J, hashMap7);
                                                if (str14.equals(m1334k)) {
                                                    if ("AES-128".equals(m1333l3)) {
                                                        str33 = m1333l(m1345a, f8573I, hashMap7);
                                                        str31 = m1335j3;
                                                        str32 = str34;
                                                        treeMap3 = treeMap2;
                                                        str = str42;
                                                        hashMap4 = hashMap7;
                                                        treeMap4 = treeMap3;
                                                        c2993qd = c2993qd2;
                                                    } else {
                                                        str31 = m1335j3;
                                                        str32 = str34;
                                                        treeMap3 = treeMap2;
                                                    }
                                                } else {
                                                    String m1336i = str34 == null ? m1336i(m1333l3) : str34;
                                                    C2827k m1340e = m1340e(m1345a, m1334k, hashMap7);
                                                    if (m1340e != null) {
                                                        treeMap3 = treeMap2;
                                                        treeMap3.put(m1334k, m1340e);
                                                        str32 = m1336i;
                                                        str31 = m1335j3;
                                                    } else {
                                                        treeMap3 = treeMap2;
                                                        str32 = m1336i;
                                                        str31 = m1335j3;
                                                    }
                                                }
                                                str33 = null;
                                                str = str42;
                                                hashMap4 = hashMap7;
                                                treeMap4 = treeMap3;
                                                c2993qd = c2993qd2;
                                            }
                                            str33 = null;
                                            c2854l3 = null;
                                            str = str42;
                                            hashMap4 = hashMap7;
                                            treeMap4 = treeMap3;
                                            c2993qd = c2993qd2;
                                        } else {
                                            treeMap = treeMap2;
                                            str14 = str41;
                                            hashMap2 = hashMap7;
                                            String str43 = str30;
                                            if (m1345a.startsWith(str43)) {
                                                String[] m2547ai2 = C2628cq.m2547ai(m1333l(m1345a, f8566B, hashMap2), "@");
                                                j6 = Long.parseLong(m2547ai2[0]);
                                                if (m2547ai2.length > 1) {
                                                    j9 = Long.parseLong(m2547ai2[1]);
                                                }
                                                str = str42;
                                                str30 = str43;
                                                hashMap4 = hashMap2;
                                            } else {
                                                String str44 = str29;
                                                if (m1345a.startsWith(str44)) {
                                                    i5 = Integer.parseInt(m1345a.substring(m1345a.indexOf(58) + 1));
                                                    str = str42;
                                                    str30 = str43;
                                                    hashMap4 = hashMap2;
                                                    str29 = str44;
                                                    treeMap4 = treeMap;
                                                    str32 = str34;
                                                    c2993qd = c2993qd2;
                                                    str33 = str36;
                                                    str31 = str35;
                                                    str25 = str5;
                                                    str3 = str6;
                                                    c2990qa3 = c2990qa;
                                                    str27 = str7;
                                                    str2 = str10;
                                                    arrayList11 = arrayList2;
                                                    z4 = true;
                                                    str15 = str14;
                                                } else {
                                                    Object obj4 = obj3;
                                                    if (m1345a.equals(obj4)) {
                                                        i7++;
                                                    } else {
                                                        if (m1345a.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                                            if (j7 == 0) {
                                                                j7 = C2628cq.m2515s(C2628cq.m2514t(m1345a.substring(m1345a.indexOf(58) + 1))) - j11;
                                                            } else {
                                                                str9 = str42;
                                                                str30 = str43;
                                                                str4 = str14;
                                                                str29 = str44;
                                                                arrayList3 = arrayList10;
                                                                arrayList4 = arrayList12;
                                                                c2984pv = c2984pv2;
                                                                j = j12;
                                                                str13 = str34;
                                                                str11 = str36;
                                                                str8 = str35;
                                                                str12 = str26;
                                                                obj = obj4;
                                                            }
                                                        } else if (m1345a.equals("#EXT-X-GAP")) {
                                                            str = str42;
                                                            str30 = str43;
                                                            hashMap4 = hashMap2;
                                                            str29 = str44;
                                                            obj3 = obj4;
                                                            treeMap4 = treeMap;
                                                            str32 = str34;
                                                            c2993qd = c2993qd2;
                                                            str33 = str36;
                                                            str31 = str35;
                                                            str25 = str5;
                                                            str3 = str6;
                                                            c2990qa3 = c2990qa;
                                                            str27 = str7;
                                                            str2 = str10;
                                                            arrayList11 = arrayList2;
                                                            z6 = true;
                                                            str15 = str14;
                                                        } else if (m1345a.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                                            str = str42;
                                                            str30 = str43;
                                                            hashMap4 = hashMap2;
                                                            str29 = str44;
                                                            obj3 = obj4;
                                                            treeMap4 = treeMap;
                                                            str32 = str34;
                                                            c2993qd = c2993qd2;
                                                            str33 = str36;
                                                            str31 = str35;
                                                            str25 = str5;
                                                            str3 = str6;
                                                            c2990qa3 = c2990qa;
                                                            str27 = str7;
                                                            str2 = str10;
                                                            arrayList11 = arrayList2;
                                                            z2 = true;
                                                            str15 = str14;
                                                        } else {
                                                            Object obj5 = obj2;
                                                            if (m1345a.equals(obj5)) {
                                                                str = str42;
                                                                str30 = str43;
                                                                hashMap4 = hashMap2;
                                                                str29 = str44;
                                                                obj3 = obj4;
                                                                treeMap4 = treeMap;
                                                                obj2 = obj5;
                                                                str32 = str34;
                                                                c2993qd = c2993qd2;
                                                                str33 = str36;
                                                                str31 = str35;
                                                                str25 = str5;
                                                                str3 = str6;
                                                                c2990qa3 = c2990qa;
                                                                str27 = str7;
                                                                str2 = str10;
                                                                arrayList11 = arrayList2;
                                                                z5 = true;
                                                                str15 = str14;
                                                            } else if (m1345a.startsWith("#EXT-X-RENDITION-REPORT")) {
                                                                String str45 = str26;
                                                                arrayList3 = arrayList10;
                                                                arrayList3.add(new C2985pw(Uri.parse(C2616ce.m2674s(str45, m1333l(m1345a, f8573I, hashMap2))), m1327r(m1345a, f8615y), m1328q(m1345a, f8616z)));
                                                                str9 = str42;
                                                                str30 = str43;
                                                                str4 = str14;
                                                                str29 = str44;
                                                                obj = obj4;
                                                                obj2 = obj5;
                                                                c2984pv = c2984pv2;
                                                                j = j12;
                                                                str13 = str34;
                                                                str11 = str36;
                                                                str8 = str35;
                                                                hashMap = hashMap6;
                                                                str12 = str45;
                                                                arrayList4 = arrayList12;
                                                            } else {
                                                                arrayList3 = arrayList10;
                                                                String str46 = str26;
                                                                if (m1345a.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                                    c2984pv = c2984pv2;
                                                                    if (c2984pv == null && "PART".equals(m1333l(m1345a, f8576L, hashMap2))) {
                                                                        String m1333l4 = m1333l(m1345a, f8573I, hashMap2);
                                                                        long m1327r = m1327r(m1345a, f8568D);
                                                                        long m1327r2 = m1327r(m1345a, f8569E);
                                                                        str30 = str43;
                                                                        long j20 = j12;
                                                                        String m1337h = m1337h(j20, str36, str35);
                                                                        if (c2854l3 != null || treeMap.isEmpty()) {
                                                                            str16 = str35;
                                                                            str17 = str14;
                                                                            str32 = str34;
                                                                        } else {
                                                                            str16 = str35;
                                                                            str17 = str14;
                                                                            C2827k[] c2827kArr = (C2827k[]) treeMap.values().toArray(new C2827k[0]);
                                                                            str32 = str34;
                                                                            C2854l c2854l5 = new C2854l(str32, c2827kArr);
                                                                            if (c2854l2 == null) {
                                                                                c2854l2 = m1339f(str32, c2827kArr);
                                                                            }
                                                                            c2854l3 = c2854l5;
                                                                        }
                                                                        int i16 = (m1327r > (-1L) ? 1 : (m1327r == (-1L) ? 0 : -1));
                                                                        if (i16 != 0 && m1327r2 == -1) {
                                                                            c2984pv2 = null;
                                                                            j12 = j20;
                                                                            hashMap4 = hashMap2;
                                                                            str29 = str44;
                                                                            obj3 = obj4;
                                                                            treeMap4 = treeMap;
                                                                            obj2 = obj5;
                                                                            arrayList10 = arrayList3;
                                                                            str26 = str46;
                                                                            str33 = str36;
                                                                            c2993qd = c2993qd2;
                                                                            str31 = str16;
                                                                            str25 = str5;
                                                                            c2983pu3 = c2983pu;
                                                                            str3 = str6;
                                                                            c2990qa3 = c2990qa;
                                                                            str27 = str7;
                                                                            str2 = str10;
                                                                            arrayList11 = arrayList2;
                                                                            str = str42;
                                                                            arrayList8 = arrayList;
                                                                            str24 = str17;
                                                                        }
                                                                        c2984pv2 = new C2984pv(m1333l4, c2986px2, 0L, i7, j10, c2854l3, str36, m1337h, i16 != 0 ? m1327r : 0L, m1327r2, false, false, true);
                                                                        j12 = j20;
                                                                        hashMap4 = hashMap2;
                                                                        str29 = str44;
                                                                        obj3 = obj4;
                                                                        treeMap4 = treeMap;
                                                                        obj2 = obj5;
                                                                        arrayList10 = arrayList3;
                                                                        str26 = str46;
                                                                        str33 = str36;
                                                                        c2993qd = c2993qd2;
                                                                        str31 = str16;
                                                                        str25 = str5;
                                                                        c2983pu3 = c2983pu;
                                                                        str3 = str6;
                                                                        c2990qa3 = c2990qa;
                                                                        str27 = str7;
                                                                        str2 = str10;
                                                                        arrayList11 = arrayList2;
                                                                        str = str42;
                                                                        arrayList8 = arrayList;
                                                                        str24 = str17;
                                                                    } else {
                                                                        str9 = str42;
                                                                        str30 = str43;
                                                                        str4 = str14;
                                                                        j = j12;
                                                                        str11 = str36;
                                                                        str29 = str44;
                                                                        obj = obj4;
                                                                        obj2 = obj5;
                                                                        str12 = str46;
                                                                        arrayList4 = arrayList12;
                                                                        str13 = str34;
                                                                        str8 = str35;
                                                                    }
                                                                } else {
                                                                    str9 = str42;
                                                                    str30 = str43;
                                                                    str4 = str14;
                                                                    str29 = str44;
                                                                    c2984pv = c2984pv2;
                                                                    j = j12;
                                                                    str13 = str34;
                                                                    str11 = str36;
                                                                    str8 = str35;
                                                                    if (m1345a.startsWith("#EXT-X-PART")) {
                                                                        String m1337h2 = m1337h(j, str11, str8);
                                                                        String m1333l5 = m1333l(m1345a, f8573I, hashMap2);
                                                                        obj = obj4;
                                                                        long m1343b = (long) (m1343b(m1345a, f8602l) * 1000000.0d);
                                                                        obj2 = obj5;
                                                                        boolean m1330o2 = m1330o(m1345a, f8585U) | (z2 && arrayList12.isEmpty());
                                                                        boolean m1330o3 = m1330o(m1345a, f8586V);
                                                                        String m1335j4 = m1335j(m1345a, f8567C, hashMap2);
                                                                        if (m1335j4 != null) {
                                                                            String[] m2547ai3 = C2628cq.m2547ai(m1335j4, "@");
                                                                            j3 = Long.parseLong(m2547ai3[0]);
                                                                            if (m2547ai3.length > 1) {
                                                                                j13 = Long.parseLong(m2547ai3[1]);
                                                                            }
                                                                        } else {
                                                                            j3 = -1;
                                                                        }
                                                                        int i17 = (j3 > (-1L) ? 1 : (j3 == (-1L) ? 0 : -1));
                                                                        if (i17 == 0) {
                                                                            j13 = 0;
                                                                        }
                                                                        if (c2854l3 != null || treeMap.isEmpty()) {
                                                                            str12 = str46;
                                                                        } else {
                                                                            str12 = str46;
                                                                            C2827k[] c2827kArr2 = (C2827k[]) treeMap.values().toArray(new C2827k[0]);
                                                                            C2854l c2854l6 = new C2854l(str13, c2827kArr2);
                                                                            if (c2854l2 == null) {
                                                                                c2854l2 = m1339f(str13, c2827kArr2);
                                                                            }
                                                                            c2854l3 = c2854l6;
                                                                        }
                                                                        arrayList4 = arrayList12;
                                                                        arrayList4.add(new C2984pv(m1333l5, c2986px2, m1343b, i7, j10, c2854l3, str11, m1337h2, j13, j3, m1330o3, m1330o2, false));
                                                                        j10 += m1343b;
                                                                        if (i17 != 0) {
                                                                            j13 += j3;
                                                                        }
                                                                        j12 = j;
                                                                        hashMap4 = hashMap2;
                                                                        treeMap4 = treeMap;
                                                                        arrayList10 = arrayList3;
                                                                        str32 = str13;
                                                                        arrayList12 = arrayList4;
                                                                        str33 = str11;
                                                                        obj3 = obj;
                                                                        str26 = str12;
                                                                        c2993qd = c2993qd2;
                                                                        str25 = str5;
                                                                        str3 = str6;
                                                                        c2990qa3 = c2990qa;
                                                                        str27 = str7;
                                                                        str2 = str10;
                                                                        arrayList11 = arrayList2;
                                                                        str = str9;
                                                                        arrayList8 = arrayList;
                                                                        c2984pv2 = c2984pv;
                                                                        str24 = str4;
                                                                        str31 = str8;
                                                                        c2983pu3 = c2983pu;
                                                                    } else {
                                                                        obj = obj4;
                                                                        obj2 = obj5;
                                                                        str12 = str46;
                                                                        arrayList4 = arrayList12;
                                                                        if (m1345a.startsWith("#")) {
                                                                            hashMap = hashMap6;
                                                                        } else {
                                                                            String m1337h3 = m1337h(j, str11, str8);
                                                                            j12 = j + 1;
                                                                            String m1332m = m1332m(m1345a, hashMap2);
                                                                            HashMap hashMap8 = hashMap6;
                                                                            C2986px c2986px5 = (C2986px) hashMap8.get(m1332m);
                                                                            int i18 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
                                                                            if (i18 == 0) {
                                                                                j2 = 0;
                                                                            } else {
                                                                                if (z7 && c2986px2 == null && c2986px5 == null) {
                                                                                    c2986px5 = new C2986px(m1332m, 0L, j9, null, null);
                                                                                    hashMap8.put(m1332m, c2986px5);
                                                                                }
                                                                                j2 = j9;
                                                                            }
                                                                            if (c2854l3 != null || treeMap.isEmpty()) {
                                                                                c2986px = c2986px5;
                                                                                c2854l = c2854l3;
                                                                            } else {
                                                                                c2986px = c2986px5;
                                                                                C2827k[] c2827kArr3 = (C2827k[]) treeMap.values().toArray(new C2827k[0]);
                                                                                c2854l = new C2854l(str13, c2827kArr3);
                                                                                if (c2854l2 == null) {
                                                                                    c2854l2 = m1339f(str13, c2827kArr3);
                                                                                }
                                                                            }
                                                                            arrayList.add(new C2986px(m1332m, c2986px2 != null ? c2986px2 : c2986px, str28, j14, i7, j11, c2854l, str11, m1337h3, j2, j6, z6, arrayList4));
                                                                            j10 = j11 + j14;
                                                                            arrayList12 = new ArrayList();
                                                                            if (i18 != 0) {
                                                                                j2 += j6;
                                                                            }
                                                                            j9 = j2;
                                                                            hashMap4 = hashMap2;
                                                                            hashMap6 = hashMap8;
                                                                            treeMap4 = treeMap;
                                                                            arrayList10 = arrayList3;
                                                                            c2854l3 = c2854l;
                                                                            obj3 = obj;
                                                                            j6 = -1;
                                                                            j14 = 0;
                                                                            j11 = j10;
                                                                            str26 = str12;
                                                                            c2993qd = c2993qd2;
                                                                            str25 = str5;
                                                                            str3 = str6;
                                                                            c2990qa3 = c2990qa;
                                                                            str27 = str7;
                                                                            str28 = str27;
                                                                            arrayList11 = arrayList2;
                                                                            str = str9;
                                                                            z6 = false;
                                                                            arrayList8 = arrayList;
                                                                            c2984pv2 = c2984pv;
                                                                            str32 = str13;
                                                                            str33 = str11;
                                                                            str24 = str4;
                                                                            str2 = str10;
                                                                            str31 = str8;
                                                                            c2983pu3 = c2983pu;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        hashMap = hashMap6;
                                                    }
                                                    str = str42;
                                                    str30 = str43;
                                                    hashMap4 = hashMap2;
                                                    str29 = str44;
                                                    obj3 = obj4;
                                                }
                                                arrayList8 = arrayList;
                                                str24 = str15;
                                                c2983pu3 = c2983pu;
                                            }
                                            treeMap4 = treeMap;
                                            str32 = str34;
                                            c2993qd = c2993qd2;
                                            str33 = str36;
                                            str31 = str35;
                                        }
                                        str25 = str5;
                                        str3 = str6;
                                        c2990qa3 = c2990qa;
                                        str27 = str7;
                                        str2 = str10;
                                        arrayList11 = arrayList2;
                                        str15 = str14;
                                        arrayList8 = arrayList;
                                        str24 = str15;
                                        c2983pu3 = c2983pu;
                                    }
                                    arrayList8 = arrayList5;
                                    str32 = str34;
                                    c2993qd = c2993qd2;
                                    treeMap4 = treeMap2;
                                    str33 = str36;
                                    str31 = str35;
                                }
                            }
                            arrayList8 = arrayList5;
                            str32 = str34;
                            c2993qd = c2993qd2;
                            treeMap4 = treeMap2;
                        }
                        j12 = j;
                        hashMap4 = hashMap2;
                        hashMap6 = hashMap;
                        treeMap4 = treeMap;
                        arrayList10 = arrayList3;
                        str32 = str13;
                        arrayList12 = arrayList4;
                        str33 = str11;
                        obj3 = obj;
                        str26 = str12;
                        c2993qd = c2993qd2;
                        str25 = str5;
                        str3 = str6;
                        c2990qa3 = c2990qa;
                        str27 = str7;
                        str2 = str10;
                        arrayList11 = arrayList2;
                        str = str9;
                        arrayList8 = arrayList;
                        c2984pv2 = c2984pv;
                        str24 = str4;
                        str31 = str8;
                        c2983pu3 = c2983pu;
                    }
                    ArrayList arrayList15 = arrayList8;
                    ArrayList arrayList16 = arrayList11;
                    ArrayList arrayList17 = arrayList10;
                    ArrayList arrayList18 = arrayList12;
                    C2984pv c2984pv4 = c2984pv2;
                    String str47 = str26;
                    HashMap hashMap9 = new HashMap();
                    for (int i19 = 0; i19 < arrayList17.size(); i19++) {
                        C2985pw c2985pw = (C2985pw) arrayList17.get(i19);
                        long j21 = c2985pw.f8520b;
                        if (j21 == -1) {
                            j21 = (j8 + arrayList15.size()) - (arrayList18.isEmpty() ? 1L : 0L);
                        }
                        int i20 = c2985pw.f8521c;
                        if (i20 == -1) {
                            i20 = j5 != C3282C.TIME_UNSET ? (arrayList18.isEmpty() ? ((C2986px) axd.m4386z(arrayList15)).f8523b : arrayList18).size() - 1 : -1;
                        }
                        Uri uri3 = c2985pw.f8519a;
                        hashMap9.put(uri3, new C2985pw(uri3, j21, i20));
                    }
                    if (c2984pv4 != null) {
                        arrayList18.add(c2984pv4);
                    }
                    C2990qa c2990qa4 = new C2990qa(i4, str47, arrayList16, j15, z3, j7, z4, i5, j8, i6, j4, j5, z2, z5, j7 != 0, c2854l2, arrayList15, arrayList18, c2988pz2, hashMap9);
                    C2628cq.m2566Q(bufferedReader);
                    return c2990qa4;
                }
            }
            throw C2555ao.m4864c("Input does not start with the #EXTM3U header.", null);
        } catch (Throwable th2) {
            th = th2;
            C2628cq.m2566Q(bufferedReader);
            throw th;
        }
    }
}
