package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ro */
/* loaded from: classes2.dex */
final class C3031ro implements InterfaceC3029rm {

    /* renamed from: a */
    private final int f8767a;

    /* renamed from: b */
    private MediaCodecInfo[] f8768b;

    public C3031ro(boolean z, boolean z2) {
        int i = 1;
        if (!z && !z2) {
            i = 0;
        }
        this.f8767a = i;
    }

    /* renamed from: f */
    private final void m1214f() {
        if (this.f8768b == null) {
            this.f8768b = new MediaCodecList(this.f8767a).getCodecInfos();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: a */
    public final int mo1219a() {
        m1214f();
        return this.f8768b.length;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: b */
    public final MediaCodecInfo mo1218b(int i) {
        m1214f();
        return this.f8768b[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: c */
    public final boolean mo1217c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: d */
    public final boolean mo1216d() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: e */
    public final boolean mo1215e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }
}
