package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rr */
/* loaded from: classes2.dex */
public final class C3034rr implements InterfaceC3017ra {

    /* renamed from: a */
    private final MediaCodec f8773a;

    /* renamed from: b */
    private final Surface f8774b = null;

    /* renamed from: c */
    private ByteBuffer[] f8775c;

    /* renamed from: d */
    private ByteBuffer[] f8776d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3034rr(MediaCodec mediaCodec, Surface surface) {
        this.f8773a = mediaCodec;
        if (C2628cq.f6961a < 21) {
            this.f8775c = mediaCodec.getInputBuffers();
            this.f8776d = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: a */
    public final int mo1203a() {
        return this.f8773a.dequeueInputBuffer(0L);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: b */
    public final int mo1202b(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f8773a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3) {
                if (C2628cq.f6961a < 21) {
                    this.f8776d = this.f8773a.getOutputBuffers();
                }
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: c */
    public final MediaFormat mo1201c() {
        return this.f8773a.getOutputFormat();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: f */
    public final ByteBuffer mo1200f(int i) {
        if (C2628cq.f6961a >= 21) {
            return this.f8773a.getInputBuffer(i);
        }
        return ((ByteBuffer[]) C2628cq.m2578E(this.f8775c))[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: g */
    public final ByteBuffer mo1199g(int i) {
        if (C2628cq.f6961a >= 21) {
            return this.f8773a.getOutputBuffer(i);
        }
        return ((ByteBuffer[]) C2628cq.m2578E(this.f8776d))[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: h */
    public final void mo1198h() {
        this.f8773a.flush();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: i */
    public final void mo1197i() {
        this.f8775c = null;
        this.f8776d = null;
        this.f8773a.release();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: j */
    public final void mo1196j(int i, long j) {
        this.f8773a.releaseOutputBuffer(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: k */
    public final void mo1195k(int i, boolean z) {
        this.f8773a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: l */
    public final void mo1194l(Surface surface) {
        this.f8773a.setOutputSurface(surface);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: m */
    public final void mo1193m(Bundle bundle) {
        this.f8773a.setParameters(bundle);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: n */
    public final void mo1192n(int i) {
        this.f8773a.setVideoScalingMode(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: p */
    public final void mo1191p() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: q */
    public final void mo1190q(int i, int i2, long j, int i3) {
        this.f8773a.queueInputBuffer(i, 0, i2, j, i3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: r */
    public final void mo1189r(int i, C2666ea c2666ea, long j) {
        this.f8773a.queueSecureInputBuffer(i, 0, c2666ea.m2451a(), j, 0);
    }
}
