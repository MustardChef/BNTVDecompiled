package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.an */
/* loaded from: classes2.dex */
public final class C2554an {

    /* renamed from: a */
    private static final ArrayList f4685a = new ArrayList();

    /* renamed from: b */
    private static final Pattern f4686b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* renamed from: a */
    public static int m4976a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (m4964m(str)) {
            return 1;
        }
        if (m4960q(str)) {
            return 2;
        }
        if (m4961p(str)) {
            return 3;
        }
        if (m4963n(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        int size = f4685a.size();
        for (int i = 0; i < size; i++) {
            C2550al c2550al = (C2550al) f4685a.get(i);
            String str2 = c2550al.f4352a;
            if (str.equals(null)) {
                int i2 = c2550al.f4354c;
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m4975b(String str) {
        return m4976a(m4971f(str));
    }

    /* renamed from: c */
    static C2552am m4974c(String str) {
        Matcher matcher = f4686b.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            C2616ce.m2689d(group);
            String group2 = matcher.group(2);
            try {
                return new C2552am(Integer.parseInt(group, 16), group2 != null ? Integer.parseInt(group2) : 0);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m4973d(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : C2628cq.m2545ak(str)) {
            String m4971f = m4971f(str2);
            if (m4971f != null && m4964m(m4971f)) {
                return m4971f;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static String m4972e(String str, String str2) {
        if (str != null && str2 != null) {
            String[] m2545ak = C2628cq.m2545ak(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : m2545ak) {
                if (str2.equals(m4971f(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    /* renamed from: f */
    public static String m4971f(String str) {
        C2552am m4974c;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String m4881c = anx.m4881c(str.trim());
        if (m4881c.startsWith("avc1") || m4881c.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (m4881c.startsWith("hev1") || m4881c.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (m4881c.startsWith("dvav") || m4881c.startsWith("dva1") || m4881c.startsWith("dvhe") || m4881c.startsWith("dvh1")) {
            return MimeTypes.VIDEO_DOLBY_VISION;
        }
        if (m4881c.startsWith("av01")) {
            return MimeTypes.VIDEO_AV1;
        }
        if (m4881c.startsWith("vp9") || m4881c.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (m4881c.startsWith("vp8") || m4881c.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (m4881c.startsWith("mp4a")) {
            if (m4881c.startsWith("mp4a.") && (m4974c = m4974c(m4881c)) != null) {
                str2 = m4970g(m4974c.f4423a);
            }
            return str2 == null ? MimeTypes.AUDIO_AAC : str2;
        } else if (m4881c.startsWith("mha1")) {
            return MimeTypes.AUDIO_MPEGH_MHA1;
        } else {
            if (m4881c.startsWith("mhm1")) {
                return MimeTypes.AUDIO_MPEGH_MHM1;
            }
            if (m4881c.startsWith("ac-3") || m4881c.startsWith("dac3")) {
                return MimeTypes.AUDIO_AC3;
            }
            if (m4881c.startsWith("ec-3") || m4881c.startsWith("dec3")) {
                return MimeTypes.AUDIO_E_AC3;
            }
            if (m4881c.startsWith(MimeTypes.CODEC_E_AC3_JOC)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if (m4881c.startsWith("ac-4") || m4881c.startsWith("dac4")) {
                return MimeTypes.AUDIO_AC4;
            }
            if (m4881c.startsWith("dtsc")) {
                return MimeTypes.AUDIO_DTS;
            }
            if (m4881c.startsWith("dtse")) {
                return MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (m4881c.startsWith("dtsh") || m4881c.startsWith("dtsl")) {
                return MimeTypes.AUDIO_DTS_HD;
            }
            if (m4881c.startsWith("dtsx")) {
                return MimeTypes.AUDIO_DTS_X;
            }
            if (m4881c.startsWith("opus")) {
                return MimeTypes.AUDIO_OPUS;
            }
            if (m4881c.startsWith("vorbis")) {
                return MimeTypes.AUDIO_VORBIS;
            }
            if (m4881c.startsWith("flac")) {
                return MimeTypes.AUDIO_FLAC;
            }
            if (m4881c.startsWith("stpp")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (m4881c.startsWith("wvtt")) {
                return MimeTypes.TEXT_VTT;
            }
            if (m4881c.contains("cea708")) {
                return MimeTypes.APPLICATION_CEA708;
            }
            if (m4881c.contains("eia608") || m4881c.contains("cea608")) {
                return MimeTypes.APPLICATION_CEA608;
            }
            int size = f4685a.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                C2550al c2550al = (C2550al) f4685a.get(i);
                String str3 = c2550al.f4353b;
                if (m4881c.startsWith(null)) {
                    String str4 = c2550al.f4352a;
                    break;
                }
                i++;
            }
            return null;
        }
    }

    /* renamed from: g */
    public static String m4970g(int i) {
        if (i != 32) {
            if (i != 33) {
                if (i != 35) {
                    if (i != 64) {
                        if (i != 163) {
                            if (i != 177) {
                                if (i != 165) {
                                    if (i != 166) {
                                        switch (i) {
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                                return MimeTypes.VIDEO_MPEG2;
                                            case 102:
                                            case 103:
                                            case 104:
                                                return MimeTypes.AUDIO_AAC;
                                            case 105:
                                            case 107:
                                                return MimeTypes.AUDIO_MPEG;
                                            case 106:
                                                return MimeTypes.VIDEO_MPEG;
                                            default:
                                                switch (i) {
                                                    case 169:
                                                    case 172:
                                                        return MimeTypes.AUDIO_DTS;
                                                    case 170:
                                                    case 171:
                                                        return MimeTypes.AUDIO_DTS_HD;
                                                    case 173:
                                                        return MimeTypes.AUDIO_OPUS;
                                                    case 174:
                                                        return MimeTypes.AUDIO_AC4;
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return MimeTypes.AUDIO_E_AC3;
                                }
                                return MimeTypes.AUDIO_AC3;
                            }
                            return MimeTypes.VIDEO_VP9;
                        }
                        return MimeTypes.VIDEO_VC1;
                    }
                    return MimeTypes.AUDIO_AAC;
                }
                return MimeTypes.VIDEO_H265;
            }
            return MimeTypes.VIDEO_H264;
        }
        return MimeTypes.VIDEO_MP4V;
    }

    /* renamed from: h */
    public static String m4969h(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : C2628cq.m2545ak(str)) {
            String m4971f = m4971f(str2);
            if (m4971f != null && m4961p(m4971f)) {
                return m4971f;
            }
        }
        return null;
    }

    /* renamed from: i */
    public static String m4968i(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : C2628cq.m2545ak(str)) {
            String m4971f = m4971f(str2);
            if (m4971f != null && m4960q(m4971f)) {
                return m4971f;
            }
        }
        return null;
    }

    /* renamed from: j */
    public static String m4967j(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1007807498) {
            if (str.equals("audio/x-flac")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -586683234) {
            if (hashCode == 187090231 && str.equals("audio/mp3")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("audio/x-wav")) {
                c = 2;
            }
            c = 65535;
        }
        return c != 0 ? c != 1 ? c != 2 ? str : MimeTypes.AUDIO_WAV : MimeTypes.AUDIO_MPEG : MimeTypes.AUDIO_FLAC;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: k */
    public static boolean m4966k(String str, String str2) {
        char c;
        C2552am m4974c;
        int m5008a;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -432837260:
                if (str.equals(MimeTypes.AUDIO_MPEG_L1)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -432837259:
                if (str.equals(MimeTypes.AUDIO_MPEG_L2)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 187094639:
                if (str.equals(MimeTypes.AUDIO_RAW)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (str.equals(MimeTypes.AUDIO_FLAC)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    c = 5;
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
                return true;
            case '\n':
                return (str2 == null || (m4974c = m4974c(str2)) == null || (m5008a = m4974c.m5008a()) == 0 || m5008a == 16) ? false : true;
            default:
                return false;
        }
    }

    /* renamed from: l */
    public static boolean m4965l(String str, String str2) {
        return m4972e(str, str2) != null;
    }

    /* renamed from: m */
    public static boolean m4964m(String str) {
        return "audio".equals(m4959r(str));
    }

    /* renamed from: n */
    public static boolean m4963n(String str) {
        return "image".equals(m4959r(str));
    }

    /* renamed from: o */
    public static boolean m4962o(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM) || str.startsWith(MimeTypes.VIDEO_MATROSKA) || str.startsWith(MimeTypes.AUDIO_MATROSKA) || str.startsWith(MimeTypes.APPLICATION_MATROSKA);
    }

    /* renamed from: p */
    public static boolean m4961p(String str) {
        return "text".equals(m4959r(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str);
    }

    /* renamed from: q */
    public static boolean m4960q(String str) {
        return "video".equals(m4959r(str));
    }

    /* renamed from: r */
    private static String m4959r(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
