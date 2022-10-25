package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mj */
/* loaded from: classes2.dex */
public final class HandlerC2891mj extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2895mn f8097a;

    /* renamed from: b */
    private boolean f8098b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2891mj(C2895mn c2895mn, Looper looper) {
        super(looper);
        this.f8097a = c2895mn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m1648a(int i, Object obj, boolean z) {
        obtainMessage(i, new C2892mk(C3059sp.m1122a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
    }

    /* renamed from: b */
    public final synchronized void m1647b() {
        removeCallbacksAndMessages(null);
        this.f8098b = true;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        byte[] bArr;
        IOException c2894mm;
        C2892mk c2892mk = (C2892mk) message.obj;
        try {
            int i = message.what;
            if (i == 0) {
                bArr = this.f8097a.f8106b.mo1484b((C2929nu) c2892mk.f8102d);
            } else if (i == 1) {
                C2895mn c2895mn = this.f8097a;
                bArr = c2895mn.f8106b.mo1483c(c2895mn.f8107c, (aeg) c2892mk.f8102d);
            } else {
                throw new RuntimeException();
            }
        } catch (C2940oe e) {
            C2892mk c2892mk2 = (C2892mk) message.obj;
            if (c2892mk2.f8100b) {
                int i2 = c2892mk2.f8103e + 1;
                c2892mk2.f8103e = i2;
                if (i2 <= C3161wj.m739b(3)) {
                    int i3 = C3059sp.f8852a;
                    long j = c2892mk2.f8099a;
                    SystemClock.elapsedRealtime();
                    SystemClock.elapsedRealtime();
                    long j2 = c2892mk2.f8101c;
                    if (e.getCause() instanceof IOException) {
                        c2894mm = (IOException) e.getCause();
                    } else {
                        c2894mm = new C2894mm(e.getCause());
                    }
                    long m738c = C3161wj.m738c(new C3159wh(c2894mm, c2892mk2.f8103e));
                    if (m738c != C3282C.TIME_UNSET) {
                        synchronized (this) {
                            if (!this.f8098b) {
                                sendMessageDelayed(Message.obtain(message), m738c);
                                return;
                            }
                        }
                    }
                }
            }
            bArr = e;
        } catch (Exception e2) {
            C2613cb.m2697b("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
            bArr = e2;
        }
        long j3 = c2892mk.f8099a;
        synchronized (this) {
            if (!this.f8098b) {
                this.f8097a.f8108d.obtainMessage(message.what, Pair.create(c2892mk.f8102d, bArr)).sendToTarget();
            }
        }
    }
}
