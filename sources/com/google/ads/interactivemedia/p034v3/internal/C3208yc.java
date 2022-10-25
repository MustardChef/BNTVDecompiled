package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yc */
/* loaded from: classes2.dex */
public final class C3208yc {

    /* renamed from: a */
    public static final /* synthetic */ int f9468a = 0;

    /* renamed from: b */
    private static final int[] f9469b = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, 11025, 8000, 7350};

    /* renamed from: c */
    private static final int[] f9470c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: a */
    public static C3207yb m557a(byte[] bArr) throws C2555ao {
        return m556b(new C2620ci(bArr), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b9, code lost:
        if (r12 != 3) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.p034v3.internal.C3207yb m556b(com.google.ads.interactivemedia.p034v3.internal.C2620ci r12, boolean r13) throws com.google.ads.interactivemedia.p034v3.internal.C2555ao {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3208yc.m556b(com.google.ads.interactivemedia.v3.internal.ci, boolean):com.google.ads.interactivemedia.v3.internal.yb");
    }

    /* renamed from: c */
    private static int m555c(C2620ci c2620ci) {
        int m2661c = c2620ci.m2661c(5);
        return m2661c == 31 ? c2620ci.m2661c(6) + 32 : m2661c;
    }

    /* renamed from: d */
    private static int m554d(C2620ci c2620ci) throws C2555ao {
        int m2661c = c2620ci.m2661c(4);
        if (m2661c == 15) {
            return c2620ci.m2661c(24);
        }
        if (m2661c < 13) {
            return f9469b[m2661c];
        }
        throw C2555ao.m4866a(null, null);
    }
}
