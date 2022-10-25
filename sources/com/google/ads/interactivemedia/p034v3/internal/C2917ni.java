package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import com.google.android.exoplayer2.PlaybackException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ni */
/* loaded from: classes2.dex */
final class C2917ni implements InterfaceC2921nm {
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: b */
    public final int mo1587b(C2962p c2962p) {
        return c2962p.f8375o != null ? 1 : 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: i */
    public final InterfaceC2910nb mo1586i(Looper looper, C2915ng c2915ng, C2962p c2962p) {
        if (c2962p.f8375o == null) {
            return null;
        }
        return new C2927ns(new C2909na(new C2941of(), PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: j */
    public final /* synthetic */ InterfaceC2920nl mo1585j(Looper looper, C2915ng c2915ng, C2962p c2962p) {
        return InterfaceC2920nl.f8187b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: o */
    public final /* synthetic */ void mo1584o() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: p */
    public final /* synthetic */ void mo1583p() {
    }
}
