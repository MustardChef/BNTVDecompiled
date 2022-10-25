package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qt */
/* loaded from: classes2.dex */
public final class C3009qt extends MediaCodec.Callback {

    /* renamed from: b */
    private final HandlerThread f8647b;

    /* renamed from: c */
    private Handler f8648c;

    /* renamed from: h */
    private MediaFormat f8653h;

    /* renamed from: i */
    private MediaFormat f8654i;

    /* renamed from: j */
    private MediaCodec.CodecException f8655j;

    /* renamed from: k */
    private long f8656k;

    /* renamed from: l */
    private boolean f8657l;

    /* renamed from: m */
    private IllegalStateException f8658m;

    /* renamed from: a */
    private final Object f8646a = new Object();

    /* renamed from: d */
    private final C3013qx f8649d = new C3013qx();

    /* renamed from: e */
    private final C3013qx f8650e = new C3013qx();

    /* renamed from: f */
    private final ArrayDeque f8651f = new ArrayDeque();

    /* renamed from: g */
    private final ArrayDeque f8652g = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3009qt(HandlerThread handlerThread) {
        this.f8647b = handlerThread;
    }

    /* renamed from: h */
    private final void m1283h(MediaFormat mediaFormat) {
        this.f8650e.m1267b(-2);
        this.f8652g.add(mediaFormat);
    }

    /* renamed from: i */
    private final void m1282i() {
        if (!this.f8652g.isEmpty()) {
            this.f8654i = (MediaFormat) this.f8652g.getLast();
        }
        this.f8649d.m1266c();
        this.f8650e.m1266c();
        this.f8651f.clear();
        this.f8652g.clear();
        this.f8655j = null;
    }

    /* renamed from: j */
    private final void m1281j() {
        IllegalStateException illegalStateException = this.f8658m;
        if (illegalStateException != null) {
            this.f8658m = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.f8655j;
        if (codecException == null) {
            return;
        }
        this.f8655j = null;
        throw codecException;
    }

    /* renamed from: k */
    private final void m1280k(IllegalStateException illegalStateException) {
        synchronized (this.f8646a) {
            this.f8658m = illegalStateException;
        }
    }

    /* renamed from: l */
    private final boolean m1279l() {
        return this.f8656k > 0 || this.f8657l;
    }

    /* renamed from: a */
    public final int m1290a() {
        synchronized (this.f8646a) {
            int i = -1;
            if (m1279l()) {
                return -1;
            }
            m1281j();
            if (!this.f8649d.m1265d()) {
                i = this.f8649d.m1268a();
            }
            return i;
        }
    }

    /* renamed from: b */
    public final int m1289b(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f8646a) {
            if (m1279l()) {
                return -1;
            }
            m1281j();
            if (this.f8650e.m1265d()) {
                return -1;
            }
            int m1268a = this.f8650e.m1268a();
            if (m1268a >= 0) {
                C2616ce.m2688e(this.f8653h);
                MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f8651f.remove();
                bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
            } else if (m1268a == -2) {
                this.f8653h = (MediaFormat) this.f8652g.remove();
                m1268a = -2;
            }
            return m1268a;
        }
    }

    /* renamed from: c */
    public final MediaFormat m1288c() {
        MediaFormat mediaFormat;
        synchronized (this.f8646a) {
            mediaFormat = this.f8653h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    /* renamed from: d */
    public final void m1287d(final Runnable runnable) {
        synchronized (this.f8646a) {
            this.f8656k++;
            Handler handler = this.f8648c;
            int i = C2628cq.f6961a;
            handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.qs
                @Override // java.lang.Runnable
                public final void run() {
                    C3009qt.this.m1285f(runnable);
                }
            });
        }
    }

    /* renamed from: e */
    public final void m1286e(MediaCodec mediaCodec) {
        C2616ce.m2685h(this.f8648c == null);
        this.f8647b.start();
        Handler handler = new Handler(this.f8647b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f8648c = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void m1285f(Runnable runnable) {
        synchronized (this.f8646a) {
            if (!this.f8657l) {
                long j = this.f8656k - 1;
                this.f8656k = j;
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i <= 0) {
                    if (i < 0) {
                        m1280k(new IllegalStateException());
                    } else {
                        m1282i();
                        try {
                            runnable.run();
                        } catch (IllegalStateException e) {
                            m1280k(e);
                        } catch (Exception e2) {
                            m1280k(new IllegalStateException(e2));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public final void m1284g() {
        synchronized (this.f8646a) {
            this.f8657l = true;
            this.f8647b.quit();
            m1282i();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f8646a) {
            this.f8655j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.f8646a) {
            this.f8649d.m1267b(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f8646a) {
            MediaFormat mediaFormat = this.f8654i;
            if (mediaFormat != null) {
                m1283h(mediaFormat);
                this.f8654i = null;
            }
            this.f8650e.m1267b(i);
            this.f8651f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f8646a) {
            m1283h(mediaFormat);
            this.f8654i = null;
        }
    }
}
