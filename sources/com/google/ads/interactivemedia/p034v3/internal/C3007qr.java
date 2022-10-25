package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qr */
/* loaded from: classes2.dex */
public final class C3007qr {

    /* renamed from: a */
    private static final ArrayDeque f8636a = new ArrayDeque();

    /* renamed from: b */
    private static final Object f8637b = new Object();

    /* renamed from: c */
    private final MediaCodec f8638c;

    /* renamed from: d */
    private final HandlerThread f8639d;

    /* renamed from: e */
    private Handler f8640e;

    /* renamed from: f */
    private final AtomicReference f8641f;

    /* renamed from: g */
    private boolean f8642g;

    /* renamed from: h */
    private final age f8643h;

    public C3007qr(MediaCodec mediaCodec, HandlerThread handlerThread) {
        age ageVar = new age();
        this.f8638c = mediaCodec;
        this.f8639d = handlerThread;
        this.f8643h = ageVar;
        this.f8641f = new AtomicReference();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ void m1301a(C3007qr c3007qr, Message message) {
        int i = message.what;
        C3006qq c3006qq = null;
        if (i == 0) {
            c3006qq = (C3006qq) message.obj;
            int i2 = c3006qq.f8630a;
            int i3 = c3006qq.f8631b;
            try {
                c3007qr.f8638c.queueInputBuffer(i2, 0, c3006qq.f8632c, c3006qq.f8634e, c3006qq.f8635f);
            } catch (RuntimeException e) {
                c3007qr.m1299c(e);
            }
        } else if (i == 1) {
            c3006qq = (C3006qq) message.obj;
            int i4 = c3006qq.f8630a;
            int i5 = c3006qq.f8631b;
            MediaCodec.CryptoInfo cryptoInfo = c3006qq.f8633d;
            long j = c3006qq.f8634e;
            int i6 = c3006qq.f8635f;
            try {
                synchronized (f8637b) {
                    c3007qr.f8638c.queueSecureInputBuffer(i4, 0, cryptoInfo, j, i6);
                }
            } catch (RuntimeException e2) {
                c3007qr.m1299c(e2);
            }
        } else if (i == 2) {
            c3007qr.f8643h.m5362f();
        } else {
            c3007qr.m1299c(new IllegalStateException(String.valueOf(message.what)));
        }
        if (c3006qq != null) {
            ArrayDeque arrayDeque = f8636a;
            synchronized (arrayDeque) {
                arrayDeque.add(c3006qq);
            }
        }
    }

    /* renamed from: h */
    private static C3006qq m1294h() {
        ArrayDeque arrayDeque = f8636a;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new C3006qq();
            }
            return (C3006qq) arrayDeque.removeFirst();
        }
    }

    /* renamed from: i */
    private final void m1293i() {
        RuntimeException runtimeException = (RuntimeException) this.f8641f.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    /* renamed from: b */
    public final void m1300b() {
        if (this.f8642g) {
            try {
                Handler handler = this.f8640e;
                int i = C2628cq.f6961a;
                handler.removeCallbacksAndMessages(null);
                this.f8643h.m5361g();
                this.f8640e.obtainMessage(2).sendToTarget();
                this.f8643h.m5365c();
                m1293i();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* renamed from: c */
    final void m1299c(RuntimeException runtimeException) {
        this.f8641f.set(runtimeException);
    }

    /* renamed from: d */
    public final void m1298d() {
        if (this.f8642g) {
            m1300b();
            this.f8639d.quit();
        }
        this.f8642g = false;
    }

    /* renamed from: e */
    public final void m1297e() {
        if (this.f8642g) {
            return;
        }
        this.f8639d.start();
        this.f8640e = new HandlerC3005qp(this, this.f8639d.getLooper());
        this.f8642g = true;
    }

    /* renamed from: f */
    public final void m1296f(int i, int i2, long j, int i3) {
        m1293i();
        C3006qq m1294h = m1294h();
        m1294h.m1302a(i, i2, j, i3);
        Handler handler = this.f8640e;
        int i4 = C2628cq.f6961a;
        handler.obtainMessage(0, m1294h).sendToTarget();
    }

    /* renamed from: g */
    public final void m1295g(int i, C2666ea c2666ea, long j) {
        m1293i();
        C3006qq m1294h = m1294h();
        m1294h.m1302a(i, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = m1294h.f8633d;
        cryptoInfo.numSubSamples = c2666ea.f7086f;
        cryptoInfo.numBytesOfClearData = m1291k(c2666ea.f7084d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = m1291k(c2666ea.f7085e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) C2616ce.m2689d(m1292j(c2666ea.f7082b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) C2616ce.m2689d(m1292j(c2666ea.f7081a, cryptoInfo.iv));
        cryptoInfo.mode = c2666ea.f7083c;
        if (C2628cq.f6961a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(c2666ea.f7087g, c2666ea.f7088h));
        }
        this.f8640e.obtainMessage(1, m1294h).sendToTarget();
    }

    /* renamed from: j */
    private static byte[] m1292j(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 != null) {
            int length = bArr2.length;
            int length2 = bArr.length;
            if (length >= length2) {
                System.arraycopy(bArr, 0, bArr2, 0, length2);
                return bArr2;
            }
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* renamed from: k */
    private static int[] m1291k(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 != null) {
            int length = iArr2.length;
            int length2 = iArr.length;
            if (length >= length2) {
                System.arraycopy(iArr, 0, iArr2, 0, length2);
                return iArr2;
            }
        }
        return Arrays.copyOf(iArr, iArr.length);
    }
}
