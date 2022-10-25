package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ab */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2539ab {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static int m5963a(String str) {
        char c;
        if (str == null) {
            return -1;
        }
        String m4967j = C2554an.m4967j(str);
        switch (m4967j.hashCode()) {
            case -2123537834:
                if (m4967j.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1662384011:
                if (m4967j.equals(MimeTypes.VIDEO_PS)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1662384007:
                if (m4967j.equals(MimeTypes.VIDEO_MP2T)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -1662095187:
                if (m4967j.equals(MimeTypes.VIDEO_WEBM)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1606874997:
                if (m4967j.equals(MimeTypes.AUDIO_AMR_WB)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1487394660:
                if (m4967j.equals(MimeTypes.IMAGE_JPEG)) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1248337486:
                if (m4967j.equals(MimeTypes.APPLICATION_MP4)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1004728940:
                if (m4967j.equals(MimeTypes.TEXT_VTT)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -387023398:
                if (m4967j.equals(MimeTypes.AUDIO_MATROSKA)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -43467528:
                if (m4967j.equals(MimeTypes.APPLICATION_WEBM)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 13915911:
                if (m4967j.equals(MimeTypes.VIDEO_FLV)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (m4967j.equals(MimeTypes.AUDIO_AC3)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (m4967j.equals(MimeTypes.AUDIO_AC4)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 187078669:
                if (m4967j.equals(MimeTypes.AUDIO_AMR)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 187090232:
                if (m4967j.equals(MimeTypes.AUDIO_MP4)) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 187091926:
                if (m4967j.equals(MimeTypes.AUDIO_OGG)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 187099443:
                if (m4967j.equals(MimeTypes.AUDIO_WAV)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1331848029:
                if (m4967j.equals(MimeTypes.VIDEO_MP4)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1503095341:
                if (m4967j.equals(MimeTypes.AUDIO_AMR_NB)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (m4967j.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (m4967j.equals(MimeTypes.AUDIO_FLAC)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (m4967j.equals(MimeTypes.AUDIO_MPEG)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1505118770:
                if (m4967j.equals(MimeTypes.AUDIO_WEBM)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2039520277:
                if (m4967j.equals(MimeTypes.VIDEO_MATROSKA)) {
                    c = '\t';
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
                return 0;
            case 3:
                return 1;
            case 4:
            case 5:
            case 6:
                return 3;
            case 7:
                return 4;
            case '\b':
                return 5;
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                return 6;
            case 14:
                return 7;
            case 15:
            case 16:
            case 17:
                return 8;
            case 18:
                return 9;
            case 19:
                return 10;
            case 20:
                return 11;
            case 21:
                return 12;
            case 22:
                return 13;
            case 23:
                return 14;
            default:
                return -1;
        }
    }

    /* renamed from: b */
    public static int m5962b(Map map) {
        List list = (List) map.get("Content-Type");
        String str = null;
        if (list != null && !list.isEmpty()) {
            str = (String) list.get(0);
        }
        return m5963a(str);
    }

    /* renamed from: c */
    public static int m5961c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        return (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) ? 14 : -1;
    }

    /* renamed from: d */
    public static final C2611c m5960d(int i, int i2) {
        return new C2611c(1, 1);
    }

    /* renamed from: e */
    public static int m5959e(InterfaceC3253zu interfaceC3253zu, InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        return interfaceC3253zu.mo440h(interfaceC2746h, i, z);
    }

    /* renamed from: f */
    public static void m5958f(InterfaceC3253zu interfaceC3253zu, C2621cj c2621cj, int i) {
        interfaceC3253zu.mo439i(c2621cj, i);
    }

    /* renamed from: g */
    public static List m5957g(byte[] bArr) {
        byte b = bArr[11];
        byte b2 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(m5952l(m5953k(((b & 255) << 8) | (b2 & 255))));
        arrayList.add(m5952l(m5953k(3840L)));
        return arrayList;
    }

    /* renamed from: h */
    public static void m5956h(boolean z, String str) throws C2555ao {
        if (!z) {
            throw C2555ao.m4866a(str, null);
        }
    }

    /* renamed from: i */
    public static void m5955i(long j, C2621cj c2621cj, InterfaceC3253zu[] interfaceC3253zuArr) {
        int i;
        while (true) {
            if (c2621cj.m2641a() <= 1) {
                return;
            }
            int m5951m = m5951m(c2621cj);
            int m5951m2 = m5951m(c2621cj);
            int m2639c = c2621cj.m2639c() + m5951m2;
            if (m5951m2 == -1 || m5951m2 > c2621cj.m2641a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                m2639c = c2621cj.m2638d();
            } else if (m5951m == 4 && m5951m2 >= 8) {
                int m2633i = c2621cj.m2633i();
                int m2629m = c2621cj.m2629m();
                if (m2629m == 49) {
                    i = c2621cj.m2637e();
                    m2629m = 49;
                } else {
                    i = 0;
                }
                int m2633i2 = c2621cj.m2633i();
                if (m2629m == 47) {
                    c2621cj.m2643G(1);
                }
                boolean z = m2633i == 181 && (m2629m == 49 || m2629m == 47) && m2633i2 == 3;
                if (m2629m == 49) {
                    z &= i == 1195456820;
                }
                if (z) {
                    m5954j(j, c2621cj, interfaceC3253zuArr);
                }
            }
            c2621cj.m2644F(m2639c);
        }
    }

    /* renamed from: j */
    public static void m5954j(long j, C2621cj c2621cj, InterfaceC3253zu[] interfaceC3253zuArr) {
        int m2633i = c2621cj.m2633i();
        if ((m2633i & 64) != 0) {
            c2621cj.m2643G(1);
            int i = (m2633i & 31) * 3;
            int m2639c = c2621cj.m2639c();
            for (InterfaceC3253zu interfaceC3253zu : interfaceC3253zuArr) {
                c2621cj.m2644F(m2639c);
                interfaceC3253zu.mo442e(c2621cj, i);
                if (j != C3282C.TIME_UNSET) {
                    interfaceC3253zu.mo441f(j, 1, i, 0, null);
                }
            }
        }
    }

    /* renamed from: k */
    private static long m5953k(long j) {
        return (j * C3282C.NANOS_PER_SECOND) / 48000;
    }

    /* renamed from: l */
    private static byte[] m5952l(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    /* renamed from: m */
    private static int m5951m(C2621cj c2621cj) {
        int i = 0;
        while (c2621cj.m2641a() != 0) {
            int m2633i = c2621cj.m2633i();
            i += m2633i;
            if (m2633i != 255) {
                return i;
            }
        }
        return -1;
    }
}
