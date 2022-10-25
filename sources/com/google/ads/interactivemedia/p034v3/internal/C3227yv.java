package com.google.ads.interactivemedia.p034v3.internal;

import androidx.mediarouter.media.MediaRouterJellybean;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yv */
/* loaded from: classes2.dex */
public final class C3227yv {

    /* renamed from: a */
    public static final /* synthetic */ int f9540a = 0;

    /* renamed from: b */
    private static final int[] f9541b = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: c */
    private static final int[] f9542c = {-1, 8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, -1, -1, 11025, 22050, 44100, -1, -1, SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, 24000, OpusUtil.SAMPLE_RATE, -1, -1};

    /* renamed from: d */
    private static final int[] f9543d = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, MediaRouterJellybean.DEVICE_OUT_BLUETOOTH, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: a */
    public static C2962p m502a(byte[] bArr, String str, String str2) {
        C2620ci c2620ci;
        if (bArr[0] == Byte.MAX_VALUE) {
            c2620ci = new C2620ci(bArr);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b = copyOf[0];
            if (b == -2 || b == -1) {
                for (int i = 0; i < copyOf.length - 1; i += 2) {
                    byte b2 = copyOf[i];
                    int i2 = i + 1;
                    copyOf[i] = copyOf[i2];
                    copyOf[i2] = b2;
                }
            }
            c2620ci = new C2620ci(copyOf);
            if (copyOf[0] == 31) {
                C2620ci c2620ci2 = new C2620ci(copyOf);
                while (c2620ci2.m2663a() >= 16) {
                    c2620ci2.m2655i(2);
                    c2620ci.m2652l(c2620ci2.m2661c(14));
                }
            }
            c2620ci.m2659e(copyOf);
        }
        c2620ci.m2655i(60);
        int i3 = f9541b[c2620ci.m2661c(6)];
        int i4 = f9542c[c2620ci.m2661c(4)];
        int m2661c = c2620ci.m2661c(5);
        int i5 = m2661c < 29 ? (f9543d[m2661c] * 1000) / 2 : -1;
        c2620ci.m2655i(10);
        int i6 = c2620ci.m2661c(2) > 0 ? 1 : 0;
        C2935o c2935o = new C2935o();
        c2935o.m1545S(str);
        c2935o.m1532ae(MimeTypes.AUDIO_DTS);
        c2935o.m1557G(i5);
        c2935o.m1556H(i3 + i6);
        c2935o.m1531af(i4);
        c2935o.m1551M(null);
        c2935o.m1542V(str2);
        return c2935o.m1506v();
    }
}
