package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qo */
/* loaded from: classes2.dex */
public final class C3004qo implements InterfaceC3017ra {

    /* renamed from: a */
    private final MediaCodec f8624a;

    /* renamed from: b */
    private final C3009qt f8625b;

    /* renamed from: c */
    private final C3007qr f8626c;

    /* renamed from: d */
    private boolean f8627d;

    /* renamed from: e */
    private int f8628e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3004qo(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2) {
        this.f8624a = mediaCodec;
        this.f8625b = new C3009qt(handlerThread);
        this.f8626c = new C3007qr(mediaCodec, handlerThread2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* bridge */ /* synthetic */ void m1304o(C3004qo c3004qo, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        c3004qo.f8625b.m1286e(c3004qo.f8624a);
        C2616ce.m2672u("configureCodec");
        c3004qo.f8624a.configure(mediaFormat, surface, mediaCrypto, 0);
        C2616ce.m2671v();
        c3004qo.f8626c.m1297e();
        C2616ce.m2672u("startCodec");
        c3004qo.f8624a.start();
        C2616ce.m2671v();
        c3004qo.f8628e = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m1303s(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: a */
    public final int mo1203a() {
        return this.f8625b.m1290a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: b */
    public final int mo1202b(MediaCodec.BufferInfo bufferInfo) {
        return this.f8625b.m1289b(bufferInfo);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: c */
    public final MediaFormat mo1201c() {
        return this.f8625b.m1288c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: f */
    public final ByteBuffer mo1200f(int i) {
        return this.f8624a.getInputBuffer(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: g */
    public final ByteBuffer mo1199g(int i) {
        return this.f8624a.getOutputBuffer(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: h */
    public final void mo1198h() {
        this.f8626c.m1300b();
        this.f8624a.flush();
        C3009qt c3009qt = this.f8625b;
        final MediaCodec mediaCodec = this.f8624a;
        mediaCodec.getClass();
        c3009qt.m1287d(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ql
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: i */
    public final void mo1197i() {
        try {
            if (this.f8628e == 1) {
                this.f8626c.m1298d();
                this.f8625b.m1284g();
            }
            this.f8628e = 2;
            if (this.f8627d) {
                return;
            }
            this.f8624a.release();
            this.f8627d = true;
        } catch (Throwable th) {
            if (!this.f8627d) {
                this.f8624a.release();
                this.f8627d = true;
            }
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: j */
    public final void mo1196j(int i, long j) {
        this.f8624a.releaseOutputBuffer(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: k */
    public final void mo1195k(int i, boolean z) {
        this.f8624a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: l */
    public final void mo1194l(Surface surface) {
        this.f8624a.setOutputSurface(surface);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: m */
    public final void mo1193m(Bundle bundle) {
        this.f8624a.setParameters(bundle);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: n */
    public final void mo1192n(int i) {
        this.f8624a.setVideoScalingMode(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: p */
    public final void mo1191p() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: q */
    public final void mo1190q(int i, int i2, long j, int i3) {
        this.f8626c.m1296f(i, i2, j, i3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3017ra
    /* renamed from: r */
    public final void mo1189r(int i, C2666ea c2666ea, long j) {
        this.f8626c.m1295g(i, c2666ea, j);
    }
}
