package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rn */
/* loaded from: classes2.dex */
final class C3030rn implements InterfaceC3029rm {
    private C3030rn() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3030rn(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: a */
    public final int mo1219a() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: b */
    public final MediaCodecInfo mo1218b(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: c */
    public final boolean mo1217c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: d */
    public final boolean mo1216d() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3029rm
    /* renamed from: e */
    public final boolean mo1215e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }
}
