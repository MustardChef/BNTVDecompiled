package com.google.ads.interactivemedia.p034v3.internal;

import android.media.ApplicationMediaCapabilities;
import android.os.Bundle;
import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cu */
/* loaded from: classes2.dex */
final class C2632cu {
    /* renamed from: a */
    public static void m2503a(Bundle bundle) {
        bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", new ApplicationMediaCapabilities.Builder().addSupportedVideoMimeType(MimeTypes.VIDEO_H265).addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
    }
}
