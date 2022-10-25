package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodecInfo;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rq */
/* loaded from: classes2.dex */
public final class C3033rq {

    /* renamed from: a */
    public static final /* synthetic */ int f8769a = 0;

    /* renamed from: b */
    private static final Pattern f8770b = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: c */
    private static final HashMap f8771c = new HashMap();

    /* renamed from: d */
    private static int f8772d = -1;

    /* renamed from: a */
    public static int m1212a() throws C3028rl {
        int i;
        if (f8772d == -1) {
            C3019rc m1207f = m1207f(MimeTypes.VIDEO_H264);
            int i2 = 0;
            if (m1207f != null) {
                MediaCodecInfo.CodecProfileLevel[] m1257f = m1207f.m1257f();
                int length = m1257f.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = m1257f[i2].level;
                    if (i4 == 1 || i4 == 2) {
                        i = 25344;
                    } else {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                continue;
                            case 64:
                                i = 202752;
                                continue;
                            case 128:
                            case 256:
                                i = 414720;
                                continue;
                            case 512:
                                i = 921600;
                                continue;
                            case 1024:
                                i = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                continue;
                            case 8192:
                                i = 2228224;
                                continue;
                            case 16384:
                                i = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                continue;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                continue;
                            default:
                                i = -1;
                                continue;
                        }
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, C2628cq.f6961a >= 21 ? 345600 : 172800);
            }
            f8772d = i2;
        }
        return f8772d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0301 A[Catch: NumberFormatException -> 0x0311, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0311, blocks: (B:168:0x02a6, B:170:0x02b8, B:181:0x02d4, B:197:0x0301), top: B:554:0x02a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0142  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair m1211b(com.google.ads.interactivemedia.p034v3.internal.C2962p r17) {
        /*
            Method dump skipped, instructions count: 2744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3033rq.m1211b(com.google.ads.interactivemedia.v3.internal.p):android.util.Pair");
    }

    /* renamed from: c */
    public static C3019rc m1210c() throws C3028rl {
        return m1207f(MimeTypes.AUDIO_RAW);
    }

    /* renamed from: d */
    public static synchronized List m1209d(String str, boolean z, boolean z2) throws C3028rl {
        InterfaceC3029rm c3030rn;
        synchronized (C3033rq.class) {
            C3027rk c3027rk = new C3027rk(str, z, z2);
            HashMap hashMap = f8771c;
            List list = (List) hashMap.get(c3027rk);
            if (list != null) {
                return list;
            }
            if (C2628cq.f6961a >= 21) {
                c3030rn = new C3031ro(z, z2);
            } else {
                c3030rn = new C3030rn(null);
            }
            ArrayList m1206g = m1206g(c3027rk, c3030rn);
            if (z && m1206g.isEmpty() && C2628cq.f6961a >= 21 && C2628cq.f6961a <= 23) {
                m1206g = m1206g(c3027rk, new C3030rn(null));
                if (!m1206g.isEmpty()) {
                    String str2 = ((C3019rc) m1206g.get(0)).f8676a;
                    StringBuilder sb = new StringBuilder(str.length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            if (MimeTypes.AUDIO_RAW.equals(str)) {
                if (C2628cq.f6961a < 26 && C2628cq.f6962b.equals("R9") && m1206g.size() == 1 && ((C3019rc) m1206g.get(0)).f8676a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    m1206g.add(C3019rc.m1256g("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false));
                }
                m1205h(m1206g, C3025ri.f8761b);
            }
            if (C2628cq.f6961a < 21 && m1206g.size() > 1) {
                String str3 = ((C3019rc) m1206g.get(0)).f8676a;
                if ("OMX.SEC.mp3.dec".equals(str3) || "OMX.SEC.MP3.Decoder".equals(str3) || "OMX.brcm.audio.mp3.decoder".equals(str3)) {
                    m1205h(m1206g, C3025ri.f8760a);
                }
            }
            if (C2628cq.f6961a < 32 && m1206g.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((C3019rc) m1206g.get(0)).f8676a)) {
                m1206g.add((C3019rc) m1206g.remove(0));
            }
            List unmodifiableList = Collections.unmodifiableList(m1206g);
            hashMap.put(c3027rk, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* renamed from: e */
    public static List m1208e(List list, final C2962p c2962p) {
        ArrayList arrayList = new ArrayList(list);
        m1205h(arrayList, new InterfaceC3032rp() { // from class: com.google.ads.interactivemedia.v3.internal.rh
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3032rp
            /* renamed from: a */
            public final int mo1213a(Object obj) {
                C2962p c2962p2 = C2962p.this;
                C3019rc c3019rc = (C3019rc) obj;
                int i = C3033rq.f8769a;
                try {
                    return !c3019rc.m1260c(c2962p2) ? 0 : 1;
                } catch (C3028rl unused) {
                    return -1;
                }
            }
        });
        return arrayList;
    }

    /* renamed from: f */
    public static C3019rc m1207f(String str) throws C3028rl {
        List m1209d = m1209d(str, false, false);
        if (m1209d.isEmpty()) {
            return null;
        }
        return (C3019rc) m1209d.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02cf A[Catch: Exception -> 0x0356, TryCatch #1 {Exception -> 0x0356, blocks: (B:160:0x029e, B:166:0x02b5, B:172:0x02c9, B:174:0x02cf, B:179:0x02de, B:181:0x02e8, B:191:0x0312, B:194:0x0318, B:182:0x02ed, B:184:0x02fd, B:186:0x0305, B:175:0x02d5), top: B:222:0x029e }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d5 A[Catch: Exception -> 0x0356, TryCatch #1 {Exception -> 0x0356, blocks: (B:160:0x029e, B:166:0x02b5, B:172:0x02c9, B:174:0x02cf, B:179:0x02de, B:181:0x02e8, B:191:0x0312, B:194:0x0318, B:182:0x02ed, B:184:0x02fd, B:186:0x0305, B:175:0x02d5), top: B:222:0x029e }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02e8 A[Catch: Exception -> 0x0356, TryCatch #1 {Exception -> 0x0356, blocks: (B:160:0x029e, B:166:0x02b5, B:172:0x02c9, B:174:0x02cf, B:179:0x02de, B:181:0x02e8, B:191:0x0312, B:194:0x0318, B:182:0x02ed, B:184:0x02fd, B:186:0x0305, B:175:0x02d5), top: B:222:0x029e }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ed A[Catch: Exception -> 0x0356, TryCatch #1 {Exception -> 0x0356, blocks: (B:160:0x029e, B:166:0x02b5, B:172:0x02c9, B:174:0x02cf, B:179:0x02de, B:181:0x02e8, B:191:0x0312, B:194:0x0318, B:182:0x02ed, B:184:0x02fd, B:186:0x0305, B:175:0x02d5), top: B:222:0x029e }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList m1206g(com.google.ads.interactivemedia.p034v3.internal.C3027rk r22, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm r23) throws com.google.ads.interactivemedia.p034v3.internal.C3028rl {
        /*
            Method dump skipped, instructions count: 980
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3033rq.m1206g(com.google.ads.interactivemedia.v3.internal.rk, com.google.ads.interactivemedia.v3.internal.rm):java.util.ArrayList");
    }

    /* renamed from: h */
    private static void m1205h(List list, final InterfaceC3032rp interfaceC3032rp) {
        Collections.sort(list, new Comparator() { // from class: com.google.ads.interactivemedia.v3.internal.rj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                InterfaceC3032rp interfaceC3032rp2 = InterfaceC3032rp.this;
                int i = C3033rq.f8769a;
                return interfaceC3032rp2.mo1213a(obj2) - interfaceC3032rp2.mo1213a(obj);
            }
        });
    }

    /* renamed from: i */
    private static boolean m1204i(MediaCodecInfo mediaCodecInfo) {
        if (C2628cq.f6961a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String m4881c = anx.m4881c(mediaCodecInfo.getName());
        if (m4881c.startsWith("arc.")) {
            return false;
        }
        return m4881c.startsWith("omx.google.") || m4881c.startsWith("omx.ffmpeg.") || (m4881c.startsWith("omx.sec.") && m4881c.contains(".sw.")) || m4881c.equals("omx.qcom.video.decoder.hevcswvdec") || m4881c.startsWith("c2.android.") || m4881c.startsWith("c2.google.") || !(m4881c.startsWith("omx.") || m4881c.startsWith("c2."));
    }
}
