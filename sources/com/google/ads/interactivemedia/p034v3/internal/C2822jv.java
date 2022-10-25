package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jv */
/* loaded from: classes2.dex */
public final class C2822jv extends AudioTrack.StreamEventCallback {

    /* renamed from: a */
    final /* synthetic */ C2823jw f7723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2822jv(C2823jw c2823jw) {
        this.f7723a = c2823jw;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        AudioTrack audioTrack2;
        InterfaceC2805je interfaceC2805je;
        boolean z;
        InterfaceC2805je interfaceC2805je2;
        audioTrack2 = this.f7723a.f7724a.f7768q;
        C2616ce.m2685h(audioTrack == audioTrack2);
        C2824jx c2824jx = this.f7723a.f7724a;
        interfaceC2805je = c2824jx.f7765n;
        if (interfaceC2805je != null) {
            z = c2824jx.f7743Q;
            if (z) {
                interfaceC2805je2 = c2824jx.f7765n;
                interfaceC2805je2.mo1841b();
            }
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        AudioTrack audioTrack2;
        InterfaceC2805je interfaceC2805je;
        boolean z;
        InterfaceC2805je interfaceC2805je2;
        audioTrack2 = this.f7723a.f7724a.f7768q;
        C2616ce.m2685h(audioTrack == audioTrack2);
        C2824jx c2824jx = this.f7723a.f7724a;
        interfaceC2805je = c2824jx.f7765n;
        if (interfaceC2805je != null) {
            z = c2824jx.f7743Q;
            if (z) {
                interfaceC2805je2 = c2824jx.f7765n;
                interfaceC2805je2.mo1841b();
            }
        }
    }
}
