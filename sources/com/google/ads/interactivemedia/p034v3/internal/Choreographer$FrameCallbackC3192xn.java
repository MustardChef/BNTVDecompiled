package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import com.google.android.exoplayer2.C3282C;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xn */
/* loaded from: classes2.dex */
public final class Choreographer$FrameCallbackC3192xn implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: b */
    private static final Choreographer$FrameCallbackC3192xn f9412b = new Choreographer$FrameCallbackC3192xn();

    /* renamed from: a */
    public volatile long f9413a = C3282C.TIME_UNSET;

    /* renamed from: c */
    private final Handler f9414c;

    /* renamed from: d */
    private final HandlerThread f9415d;

    /* renamed from: e */
    private Choreographer f9416e;

    /* renamed from: f */
    private int f9417f;

    private Choreographer$FrameCallbackC3192xn() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.f9415d = handlerThread;
        handlerThread.start();
        Handler m2509y = C2628cq.m2509y(handlerThread.getLooper(), this);
        this.f9414c = m2509y;
        m2509y.sendEmptyMessage(0);
    }

    /* renamed from: a */
    public static Choreographer$FrameCallbackC3192xn m613a() {
        return f9412b;
    }

    /* renamed from: b */
    public final void m612b() {
        this.f9414c.sendEmptyMessage(1);
    }

    /* renamed from: c */
    public final void m611c() {
        this.f9414c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f9413a = j;
        Choreographer choreographer = this.f9416e;
        C2616ce.m2689d(choreographer);
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f9416e = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.f9417f + 1;
            this.f9417f = i2;
            if (i2 == 1) {
                Choreographer choreographer = this.f9416e;
                C2616ce.m2689d(choreographer);
                choreographer.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.f9417f - 1;
            this.f9417f = i3;
            if (i3 == 0) {
                Choreographer choreographer2 = this.f9416e;
                C2616ce.m2689d(choreographer2);
                choreographer2.removeFrameCallback(this);
                this.f9413a = C3282C.TIME_UNSET;
            }
            return true;
        }
    }
}
