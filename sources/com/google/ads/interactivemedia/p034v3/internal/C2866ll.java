package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.gms.cast.MediaTrack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ll */
/* loaded from: classes2.dex */
public final class C2866ll extends DefaultHandler implements InterfaceC3169wr {

    /* renamed from: a */
    private static final Pattern f8028a = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: b */
    private static final Pattern f8029b = Pattern.compile("CC([1-4])=.*");

    /* renamed from: c */
    private static final Pattern f8030c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: d */
    private static final int[] f8031d = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: e */
    private final XmlPullParserFactory f8032e;

    public C2866ll() {
        try {
            this.f8032e = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* renamed from: A */
    protected static final C2884mc m1708A(XmlPullParser xmlPullParser, String str, C2884mc c2884mc) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? C2884mc.m1650a(attributeValue) : c2884mc;
    }

    /* renamed from: B */
    private static int m1707B(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        C2616ce.m2685h(i == i2);
        return i;
    }

    /* renamed from: C */
    private static long m1706C(long j, long j2) {
        if (j2 != C3282C.TIME_UNSET) {
            j = j2;
        }
        return j == Long.MAX_VALUE ? C3282C.TIME_UNSET : j;
    }

    /* renamed from: D */
    private static final long m1705D(List list, long j, long j2, int i, long j3) {
        int m2520n = i >= 0 ? i + 1 : (int) C2628cq.m2520n(j3 - j, j2);
        for (int i2 = 0; i2 < m2520n; i2++) {
            list.add(new C2878lx(j, j2));
            j += j2;
        }
        return j;
    }

    /* renamed from: b */
    protected static float m1704b(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f8028a.matcher(attributeValue);
            if (matcher.matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                String group = matcher.group(2);
                return !TextUtils.isEmpty(group) ? parseInt / Integer.parseInt(group) : parseInt;
            }
            return f;
        }
        return f;
    }

    /* renamed from: c */
    protected static int m1703c(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    /* renamed from: d */
    protected static long m1702d(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : C2628cq.m2513u(attributeValue);
    }

    /* renamed from: e */
    protected static long m1701e(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    /* renamed from: h */
    protected static C2867lm m1698h(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String m1693m = m1693m(xmlPullParser, "schemeIdUri", "");
        String m1693m2 = m1693m(xmlPullParser, "value", null);
        String m1693m3 = m1693m(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!C2616ce.m2680m(xmlPullParser, str));
        return new C2867lm(m1693m, m1693m2, m1693m3);
    }

    /* renamed from: m */
    protected static String m1693m(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* renamed from: n */
    protected static String m1692n(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                m1690p(xmlPullParser);
            }
        } while (!C2616ce.m2680m(xmlPullParser, str));
        return str2;
    }

    /* renamed from: p */
    public static void m1690p(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (C2616ce.m2679n(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (C2616ce.m2679n(xmlPullParser)) {
                    i++;
                } else if (C2616ce.m2681l(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
        if (r0.equals("4000") != false) goto L25;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final int m1689q(org.xmlpull.v1.XmlPullParser r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = m1693m(r8, r0, r1)
            int r2 = r0.hashCode()
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = -1
            switch(r2) {
                case -1352850286: goto L32;
                case -1138141449: goto L28;
                case -986633423: goto L1e;
                case 2036691300: goto L14;
                default: goto L13;
            }
        L13:
            goto L3c
        L14:
            java.lang.String r2 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 3
            goto L3d
        L1e:
            java.lang.String r2 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 1
            goto L3d
        L28:
            java.lang.String r2 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 2
            goto L3d
        L32:
            java.lang.String r2 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            r0 = 0
            goto L3d
        L3c:
            r0 = -1
        L3d:
            java.lang.String r2 = "value"
            if (r0 == 0) goto La5
            if (r0 == r6) goto L95
            if (r0 == r5) goto L4a
            if (r0 == r4) goto L4a
        L47:
            r5 = -1
            goto La9
        L4a:
            java.lang.String r0 = r8.getAttributeValue(r1, r2)
            if (r0 != 0) goto L51
            goto L47
        L51:
            java.lang.String r0 = com.google.ads.interactivemedia.p034v3.internal.anx.m4881c(r0)
            int r1 = r0.hashCode()
            switch(r1) {
                case 1596796: goto L7b;
                case 2937391: goto L71;
                case 3094035: goto L67;
                case 3133436: goto L5d;
                default: goto L5c;
            }
        L5c:
            goto L84
        L5d:
            java.lang.String r1 = "fa01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 3
            goto L85
        L67:
            java.lang.String r1 = "f801"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 2
            goto L85
        L71:
            java.lang.String r1 = "a000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            r3 = 1
            goto L85
        L7b:
            java.lang.String r1 = "4000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L84
            goto L85
        L84:
            r3 = -1
        L85:
            if (r3 == 0) goto L93
            if (r3 == r6) goto La9
            if (r3 == r5) goto L91
            if (r3 == r4) goto L8e
            goto L47
        L8e:
            r5 = 8
            goto La9
        L91:
            r5 = 6
            goto La9
        L93:
            r5 = 1
            goto La9
        L95:
            int r0 = m1703c(r8, r2, r7)
            if (r0 < 0) goto L47
            int[] r1 = com.google.ads.interactivemedia.p034v3.internal.C2866ll.f8031d
            int r2 = r1.length
            r2 = 21
            if (r0 >= r2) goto L47
            r5 = r1[r0]
            goto La9
        La5:
            int r5 = m1703c(r8, r2, r7)
        La9:
            r8.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2680m(r8, r0)
            if (r0 == 0) goto La9
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2866ll.m1689q(org.xmlpull.v1.XmlPullParser):int");
    }

    /* renamed from: r */
    protected static final long m1688r(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }

    /* renamed from: s */
    protected static final List m1687s(XmlPullParser xmlPullParser, List list) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 1;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String m1692n = m1692n(xmlPullParser, "BaseURL");
        if (attributeValue3 == null) {
            attributeValue3 = m1692n;
        }
        if (C2616ce.m2673t(m1692n)) {
            return axd.m4391u(new C2863li(m1692n, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C2863li c2863li = (C2863li) list.get(i);
            arrayList.add(new C2863li(C2616ce.m2674s(c2863li.f8004a, m1692n), c2863li.f8005b, c2863li.f8006c, c2863li.f8007d));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final android.util.Pair m1686t(org.xmlpull.v1.XmlPullParser r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2866ll.m1686t(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* renamed from: u */
    protected static final int m1685u(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return !"text".equals(attributeValue) ? -1 : 3;
    }

    /* renamed from: v */
    protected static long m1684v(XmlPullParser xmlPullParser, String str) throws C2555ao {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? C3282C.TIME_UNSET : C2628cq.m2514t(attributeValue);
    }

    /* renamed from: w */
    protected static float m1683w(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return -3.4028235E38f;
        }
        return Float.parseFloat(attributeValue);
    }

    /* renamed from: x */
    protected static final C2871lq m1682x(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
                return new C2871lq(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return new C2871lq(attributeValue, j, j2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: y */
    protected static final int m1681y(String str) {
        char c;
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1574842690:
                if (str.equals(MediaTrack.ROLE_FORCED_SUBTITLE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1408024454:
                if (str.equals(MediaTrack.ROLE_ALTERNATE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99825:
                if (str.equals(MediaTrack.ROLE_DUB)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3343801:
                if (str.equals(MediaTrack.ROLE_MAIN)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3530173:
                if (str.equals(MediaTrack.ROLE_SIGN)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 899152809:
                if (str.equals(MediaTrack.ROLE_COMMENTARY)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1629013393:
                if (str.equals(MediaTrack.ROLE_EMERGENCY)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1855372047:
                if (str.equals(MediaTrack.ROLE_SUPPLEMENTARY)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
            case '\b':
                return 128;
            case '\t':
                return 256;
            case '\n':
                return 512;
            case 11:
                return 2048;
            default:
                return 0;
        }
    }

    /* renamed from: z */
    protected static final int m1680z(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (anx.m4879e("http://dashif.org/guidelines/trickmode", ((C2867lm) list.get(i2)).f8033a)) {
                i |= 16384;
            }
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009e, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC.equals(r5) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ea  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.ads.interactivemedia.p034v3.internal.C2962p m1700f(java.lang.String r17, java.lang.String r18, int r19, int r20, float r21, int r22, int r23, int r24, java.lang.String r25, java.util.List r26, java.util.List r27, java.lang.String r28, java.util.List r29, java.util.List r30) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2866ll.m1700f(java.lang.String, java.lang.String, int, int, float, int, int, int, java.lang.String, java.util.List, java.util.List, java.lang.String, java.util.List, java.util.List):com.google.ads.interactivemedia.v3.internal.p");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:226:0x099e A[LOOP:8: B:169:0x0672->B:226:0x099e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0c13 A[LOOP:4: B:113:0x03c0->B:296:0x0c13, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0b25 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0928 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0264 A[LOOP:2: B:68:0x01f1->B:78:0x0264, LOOP_END] */
    /* JADX WARN: Type inference failed for: r3v117 */
    /* JADX WARN: Type inference failed for: r3v126 */
    /* JADX WARN: Type inference failed for: r3v128, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v130 */
    /* JADX WARN: Type inference failed for: r3v131 */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3169wr
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.internal.C2864lj mo714a(android.net.Uri r139, java.io.InputStream r140) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 4192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2866ll.mo714a(android.net.Uri, java.io.InputStream):com.google.ads.interactivemedia.v3.internal.lj");
    }

    /* renamed from: i */
    protected final C2871lq m1697i(XmlPullParser xmlPullParser) {
        return m1682x(xmlPullParser, "sourceURL", SessionDescription.ATTR_RANGE);
    }

    /* renamed from: j */
    protected final C2876lv m1696j(XmlPullParser xmlPullParser, C2876lv c2876lv, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long m1701e = m1701e(xmlPullParser, "timescale", c2876lv != null ? c2876lv.f8076i : 1L);
        long m1701e2 = m1701e(xmlPullParser, "presentationTimeOffset", c2876lv != null ? c2876lv.f8077j : 0L);
        long m1701e3 = m1701e(xmlPullParser, TypedValues.TransitionType.S_DURATION, c2876lv != null ? c2876lv.f8062b : C3282C.TIME_UNSET);
        long m1701e4 = m1701e(xmlPullParser, "startNumber", c2876lv != null ? c2876lv.f8061a : 1L);
        long m1706C = m1706C(j3, j4);
        List list = null;
        List list2 = null;
        C2871lq c2871lq = null;
        do {
            xmlPullParser.next();
            if (C2616ce.m2678o(xmlPullParser, "Initialization")) {
                c2871lq = m1697i(xmlPullParser);
            } else if (C2616ce.m2678o(xmlPullParser, "SegmentTimeline")) {
                list = m1691o(xmlPullParser, m1701e, j2);
            } else if (C2616ce.m2678o(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(m1682x(xmlPullParser, "media", "mediaRange"));
            } else {
                m1690p(xmlPullParser);
            }
        } while (!C2616ce.m2680m(xmlPullParser, "SegmentList"));
        if (c2876lv != null) {
            if (c2871lq == null) {
                c2871lq = c2876lv.f8075h;
            }
            if (list == null) {
                list = c2876lv.f8063c;
            }
            if (list2 == null) {
                list2 = c2876lv.f8067e;
            }
        }
        return new C2876lv(c2871lq, m1701e, m1701e2, m1701e4, m1701e3, list, m1706C, list2, C2628cq.m2515s(j5), C2628cq.m2515s(j));
    }

    /* renamed from: k */
    protected final C2877lw m1695k(XmlPullParser xmlPullParser, C2877lw c2877lw, List list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long j6;
        long m1701e = m1701e(xmlPullParser, "timescale", c2877lw != null ? c2877lw.f8076i : 1L);
        long m1701e2 = m1701e(xmlPullParser, "presentationTimeOffset", c2877lw != null ? c2877lw.f8077j : 0L);
        long m1701e3 = m1701e(xmlPullParser, TypedValues.TransitionType.S_DURATION, c2877lw != null ? c2877lw.f8062b : C3282C.TIME_UNSET);
        long m1701e4 = m1701e(xmlPullParser, "startNumber", c2877lw != null ? c2877lw.f8061a : 1L);
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                j6 = -1;
                break;
            }
            C2867lm c2867lm = (C2867lm) list.get(i);
            if (anx.m4879e("http://dashif.org/guidelines/last-segment-number", c2867lm.f8033a)) {
                j6 = Long.parseLong(c2867lm.f8034b);
                break;
            }
            i++;
        }
        long j7 = j6;
        long m1706C = m1706C(j3, j4);
        List list2 = null;
        C2884mc m1708A = m1708A(xmlPullParser, "media", c2877lw != null ? c2877lw.f8069f : null);
        C2884mc m1708A2 = m1708A(xmlPullParser, "initialization", c2877lw != null ? c2877lw.f8068e : null);
        C2871lq c2871lq = null;
        do {
            xmlPullParser.next();
            if (C2616ce.m2678o(xmlPullParser, "Initialization")) {
                c2871lq = m1697i(xmlPullParser);
            } else if (C2616ce.m2678o(xmlPullParser, "SegmentTimeline")) {
                list2 = m1691o(xmlPullParser, m1701e, j2);
            } else {
                m1690p(xmlPullParser);
            }
        } while (!C2616ce.m2680m(xmlPullParser, "SegmentTemplate"));
        if (c2877lw != null) {
            if (c2871lq == null) {
                c2871lq = c2877lw.f8075h;
            }
            if (list2 == null) {
                list2 = c2877lw.f8063c;
            }
        }
        return new C2877lw(c2871lq, m1701e, m1701e2, m1701e4, j7, m1701e3, list2, m1706C, m1708A2, m1708A, C2628cq.m2515s(j5), C2628cq.m2515s(j));
    }

    /* renamed from: l */
    protected final C2879ly m1694l(XmlPullParser xmlPullParser, C2879ly c2879ly) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long m1701e = m1701e(xmlPullParser, "timescale", c2879ly != null ? c2879ly.f8076i : 1L);
        long m1701e2 = m1701e(xmlPullParser, "presentationTimeOffset", c2879ly != null ? c2879ly.f8077j : 0L);
        long j3 = c2879ly != null ? c2879ly.f8073a : 0L;
        long j4 = c2879ly != null ? c2879ly.f8074b : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - parseLong) + 1;
            j2 = parseLong;
        } else {
            j = j4;
            j2 = j3;
        }
        C2871lq c2871lq = c2879ly != null ? c2879ly.f8075h : null;
        do {
            xmlPullParser.next();
            if (C2616ce.m2678o(xmlPullParser, "Initialization")) {
                c2871lq = m1697i(xmlPullParser);
            } else {
                m1690p(xmlPullParser);
            }
        } while (!C2616ce.m2680m(xmlPullParser, "SegmentBase"));
        return new C2879ly(c2871lq, m1701e, m1701e2, j2, j);
    }

    /* renamed from: o */
    protected final List m1691o(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        long j4 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (C2616ce.m2678o(xmlPullParser, ExifInterface.LATITUDE_SOUTH)) {
                long m1701e = m1701e(xmlPullParser, "t", C3282C.TIME_UNSET);
                if (z) {
                    j3 = m1705D(arrayList, j3, j4, i, m1701e);
                }
                if (m1701e == C3282C.TIME_UNSET) {
                    m1701e = j3;
                }
                j4 = m1701e(xmlPullParser, "d", C3282C.TIME_UNSET);
                i = m1703c(xmlPullParser, "r", 0);
                j3 = m1701e;
                z = true;
            } else {
                m1690p(xmlPullParser);
            }
        } while (!C2616ce.m2680m(xmlPullParser, "SegmentTimeline"));
        if (z) {
            m1705D(arrayList, j3, j4, i, C2628cq.m2512v(j2, j, 1000L));
        }
        return arrayList;
    }
}
