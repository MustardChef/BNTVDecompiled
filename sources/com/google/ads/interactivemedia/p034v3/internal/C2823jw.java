package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;
import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jw */
/* loaded from: classes2.dex */
public final class C2823jw {

    /* renamed from: a */
    final /* synthetic */ C2824jx f7724a;

    /* renamed from: b */
    private final Handler f7725b = new Handler();

    /* renamed from: c */
    private final AudioTrack.StreamEventCallback f7726c = new C2822jv(this);

    public C2823jw(C2824jx c2824jx) {
        this.f7724a = c2824jx;
    }

    /* renamed from: a */
    public final void m1895a(AudioTrack audioTrack) {
        final Handler handler = this.f7725b;
        audioTrack.registerStreamEventCallback(new Executor() { // from class: com.google.ads.interactivemedia.v3.internal.ju
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, this.f7726c);
    }

    /* renamed from: b */
    public final void m1894b(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.f7726c);
        this.f7725b.removeCallbacksAndMessages(null);
    }
}
