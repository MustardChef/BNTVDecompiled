package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rc */
/* loaded from: classes2.dex */
public final class C3019rc {

    /* renamed from: a */
    public final String f8676a;

    /* renamed from: b */
    public final String f8677b;

    /* renamed from: c */
    public final String f8678c;

    /* renamed from: d */
    public final MediaCodecInfo.CodecCapabilities f8679d;

    /* renamed from: e */
    public final boolean f8680e;

    /* renamed from: f */
    public final boolean f8681f;

    /* renamed from: g */
    private final boolean f8682g;

    C3019rc(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        C2616ce.m2689d(str);
        this.f8676a = str;
        this.f8677b = str2;
        this.f8678c = str3;
        this.f8679d = codecCapabilities;
        this.f8680e = z;
        this.f8681f = z2;
        this.f8682g = C2554an.m4960q(str2);
    }

    /* renamed from: g */
    public static C3019rc m1256g(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = codecCapabilities != null && C2628cq.f6961a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback") && (C2628cq.f6961a > 22 || !(("ODROID-XU3".equals(C2628cq.f6964d) || "Nexus 10".equals(C2628cq.f6964d)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))));
        if (codecCapabilities != null && C2628cq.f6961a >= 21) {
            codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        return new C3019rc(str, str2, str3, codecCapabilities, z5, z4 || (codecCapabilities != null && C2628cq.f6961a >= 21 && codecCapabilities.isFeatureSupported("secure-playback")));
    }

    /* renamed from: h */
    private static Point m1255h(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C2628cq.m2532b(i, widthAlignment) * widthAlignment, C2628cq.m2532b(i2, heightAlignment) * heightAlignment);
    }

    /* renamed from: i */
    private final void m1254i(String str) {
        String str2 = this.f8676a;
        String str3 = this.f8677b;
        String str4 = C2628cq.f6965e;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 20 + length2 + str3.length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, sb.toString());
    }

    /* renamed from: j */
    private static boolean m1253j(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point m1255h = m1255h(videoCapabilities, i, i2);
        int i3 = m1255h.x;
        int i4 = m1255h.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* renamed from: a */
    public final Point m1262a(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8679d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return m1255h(videoCapabilities, i, i2);
    }

    /* renamed from: b */
    public final C2680eo m1261b(C2962p c2962p, C2962p c2962p2) {
        int i = true != C2628cq.m2563T(c2962p.f8372l, c2962p2.f8372l) ? 8 : 0;
        if (this.f8682g) {
            if (c2962p.f8380t != c2962p2.f8380t) {
                i |= 1024;
            }
            if (!this.f8680e && (c2962p.f8377q != c2962p2.f8377q || c2962p.f8378r != c2962p2.f8378r)) {
                i |= 512;
            }
            if (!C2628cq.m2563T(c2962p.f8384x, c2962p2.f8384x)) {
                i |= 2048;
            }
            String str = this.f8676a;
            if (C2628cq.f6964d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !c2962p.m1423e(c2962p2)) {
                i |= 2;
            }
            if (i == 0) {
                return new C2680eo(this.f8676a, c2962p, c2962p2, true != c2962p.m1423e(c2962p2) ? 2 : 3, 0);
            }
        } else {
            if (c2962p.f8385y != c2962p2.f8385y) {
                i |= 4096;
            }
            if (c2962p.f8386z != c2962p2.f8386z) {
                i |= 8192;
            }
            if (c2962p.f8355A != c2962p2.f8355A) {
                i |= 16384;
            }
            if (i == 0 && MimeTypes.AUDIO_AAC.equals(this.f8677b)) {
                Pair m1211b = C3033rq.m1211b(c2962p);
                Pair m1211b2 = C3033rq.m1211b(c2962p2);
                if (m1211b != null && m1211b2 != null) {
                    int intValue = ((Integer) m1211b.first).intValue();
                    int intValue2 = ((Integer) m1211b2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new C2680eo(this.f8676a, c2962p, c2962p2, 3, 0);
                    }
                }
            }
            if (!c2962p.m1423e(c2962p2)) {
                i |= 32;
            }
            if (MimeTypes.AUDIO_OPUS.equals(this.f8677b)) {
                i |= 2;
            }
            if (i == 0) {
                return new C2680eo(this.f8676a, c2962p, c2962p2, 1, 0);
            }
        }
        return new C2680eo(this.f8676a, c2962p, c2962p2, 0, i);
    }

    /* renamed from: c */
    public final boolean m1260c(C2962p c2962p) throws C3028rl {
        String m4971f;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = c2962p.f8369i;
        int i = 16;
        if (str != null && (m4971f = C2554an.m4971f(str)) != null) {
            if (!this.f8677b.equals(m4971f)) {
                String str2 = c2962p.f8369i;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 13 + m4971f.length());
                sb.append("codec.mime ");
                sb.append(str2);
                sb.append(", ");
                sb.append(m4971f);
                m1254i(sb.toString());
            } else {
                Pair m1211b = C3033rq.m1211b(c2962p);
                if (m1211b != null) {
                    int intValue = ((Integer) m1211b.first).intValue();
                    int intValue2 = ((Integer) m1211b.second).intValue();
                    if (!this.f8682g) {
                        if (intValue == 42) {
                            intValue = 42;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel[] m1257f = m1257f();
                    if (C2628cq.f6961a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f8677b) && m1257f.length == 0) {
                        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8679d;
                        int intValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
                        int i2 = intValue3 >= 180000000 ? 1024 : intValue3 >= 120000000 ? 512 : intValue3 >= 60000000 ? 256 : intValue3 >= 30000000 ? 128 : intValue3 >= 18000000 ? 64 : intValue3 >= 12000000 ? 32 : intValue3 >= 7200000 ? 16 : intValue3 >= 3600000 ? 8 : intValue3 >= 1800000 ? 4 : intValue3 >= 800000 ? 2 : 1;
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                        codecProfileLevel.profile = 1;
                        codecProfileLevel.level = i2;
                        m1257f = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                    }
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : m1257f) {
                        if (codecProfileLevel2.profile != intValue || codecProfileLevel2.level < intValue2) {
                        }
                    }
                    String str3 = c2962p.f8369i;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 22 + m4971f.length());
                    sb2.append("codec.profileLevel, ");
                    sb2.append(str3);
                    sb2.append(", ");
                    sb2.append(m4971f);
                    m1254i(sb2.toString());
                }
            }
            return false;
        }
        if (this.f8682g) {
            if (c2962p.f8377q <= 0 || c2962p.f8378r <= 0) {
                return true;
            }
            if (C2628cq.f6961a >= 21) {
                return m1258e(c2962p.f8377q, c2962p.f8378r, c2962p.f8379s);
            }
            boolean z = c2962p.f8377q * c2962p.f8378r <= C3033rq.m1212a();
            if (!z) {
                int i3 = c2962p.f8377q;
                int i4 = c2962p.f8378r;
                StringBuilder sb3 = new StringBuilder(40);
                sb3.append("legacyFrameSize, ");
                sb3.append(i3);
                sb3.append("x");
                sb3.append(i4);
                m1254i(sb3.toString());
            }
            return z;
        }
        if (C2628cq.f6961a >= 21) {
            int i5 = c2962p.f8386z;
            if (i5 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.f8679d;
                if (codecCapabilities2 == null) {
                    m1254i("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities == null) {
                    m1254i("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i5)) {
                    StringBuilder sb4 = new StringBuilder(31);
                    sb4.append("sampleRate.support, ");
                    sb4.append(i5);
                    m1254i(sb4.toString());
                    return false;
                }
            }
            int i6 = c2962p.f8385y;
            if (i6 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.f8679d;
                if (codecCapabilities3 == null) {
                    m1254i("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        m1254i("channelCount.aCaps");
                    } else {
                        String str4 = this.f8676a;
                        String str5 = this.f8677b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((C2628cq.f6961a < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str5) && !MimeTypes.AUDIO_AMR_NB.equals(str5) && !MimeTypes.AUDIO_AMR_WB.equals(str5) && !MimeTypes.AUDIO_AAC.equals(str5) && !MimeTypes.AUDIO_VORBIS.equals(str5) && !MimeTypes.AUDIO_OPUS.equals(str5) && !MimeTypes.AUDIO_RAW.equals(str5) && !MimeTypes.AUDIO_FLAC.equals(str5) && !MimeTypes.AUDIO_ALAW.equals(str5) && !MimeTypes.AUDIO_MLAW.equals(str5) && !MimeTypes.AUDIO_MSGSM.equals(str5))) {
                            if (MimeTypes.AUDIO_AC3.equals(str5)) {
                                i = 6;
                            } else if (!MimeTypes.AUDIO_E_AC3.equals(str5)) {
                                i = 30;
                            }
                            StringBuilder sb5 = new StringBuilder(String.valueOf(str4).length() + 59);
                            sb5.append("AssumedMaxChannelAdjustment: ");
                            sb5.append(str4);
                            sb5.append(", [");
                            sb5.append(maxInputChannelCount);
                            sb5.append(" to ");
                            sb5.append(i);
                            sb5.append("]");
                            Log.w(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, sb5.toString());
                            maxInputChannelCount = i;
                        }
                        if (maxInputChannelCount < i6) {
                            StringBuilder sb6 = new StringBuilder(33);
                            sb6.append("channelCount.support, ");
                            sb6.append(i6);
                            m1254i(sb6.toString());
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final boolean m1259d(C2962p c2962p) {
        if (this.f8682g) {
            return this.f8680e;
        }
        Pair m1211b = C3033rq.m1211b(c2962p);
        return m1211b != null && ((Integer) m1211b.first).intValue() == 42;
    }

    /* renamed from: e */
    public final boolean m1258e(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8679d;
        if (codecCapabilities == null) {
            m1254i("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m1254i("sizeAndRate.vCaps");
            return false;
        } else if (m1253j(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i < i2 && ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.f8676a) || !"mcv5a".equals(C2628cq.f6962b)) && m1253j(videoCapabilities, i2, i, d))) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.rotated, ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                sb.append("x");
                sb.append(d);
                String sb2 = sb.toString();
                String str = this.f8676a;
                String str2 = this.f8677b;
                String str3 = C2628cq.f6965e;
                int length = String.valueOf(sb2).length();
                int length2 = String.valueOf(str).length();
                StringBuilder sb3 = new StringBuilder(length + 25 + length2 + str2.length() + String.valueOf(str3).length());
                sb3.append("AssumedSupport [");
                sb3.append(sb2);
                sb3.append("] [");
                sb3.append(str);
                sb3.append(", ");
                sb3.append(str2);
                sb3.append("] [");
                sb3.append(str3);
                sb3.append("]");
                Log.d(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, sb3.toString());
                return true;
            }
            StringBuilder sb4 = new StringBuilder(69);
            sb4.append("sizeAndRate.support, ");
            sb4.append(i);
            sb4.append("x");
            sb4.append(i2);
            sb4.append("x");
            sb4.append(d);
            m1254i(sb4.toString());
            return false;
        }
    }

    /* renamed from: f */
    public final MediaCodecInfo.CodecProfileLevel[] m1257f() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8679d;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f8679d.profileLevels;
    }

    public final String toString() {
        return this.f8676a;
    }
}
