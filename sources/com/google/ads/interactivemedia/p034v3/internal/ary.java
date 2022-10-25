package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ary */
/* loaded from: classes2.dex */
public final class ary implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    protected final asi f4963a;

    /* renamed from: b */
    private final String f4964b;

    /* renamed from: c */
    private final String f4965c;

    /* renamed from: d */
    private final LinkedBlockingQueue f4966d;

    /* renamed from: e */
    private final HandlerThread f4967e;

    /* renamed from: f */
    private final art f4968f;

    /* renamed from: g */
    private final long f4969g;

    /* renamed from: h */
    private final int f4970h;

    public ary(Context context, int i, String str, String str2, art artVar) {
        this.f4964b = str;
        this.f4970h = i;
        this.f4965c = str2;
        this.f4968f = artVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.f4967e = handlerThread;
        handlerThread.start();
        this.f4969g = System.currentTimeMillis();
        asi asiVar = new asi(context, handlerThread.getLooper(), this, this, 19621000);
        this.f4963a = asiVar;
        this.f4966d = new LinkedBlockingQueue();
        asiVar.checkAvailabilityAndConnect();
    }

    /* renamed from: b */
    static ass m4708b() {
        return new ass();
    }

    /* renamed from: e */
    private final void m4705e(int i, long j) {
        m4704f(i, j, null);
    }

    /* renamed from: f */
    private final void m4704f(int i, long j, Exception exc) {
        this.f4968f.m4727c(i, System.currentTimeMillis() - j, exc);
    }

    /* renamed from: a */
    protected final asn m4709a() {
        try {
            return this.f4963a.m4689a();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final ass m4707c() {
        ass assVar;
        try {
            assVar = (ass) this.f4966d.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            m4704f(2009, this.f4969g, e);
            assVar = null;
        }
        m4705e(PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED, this.f4969g);
        if (assVar != null) {
            if (assVar.f5013c == 7) {
                art.m4723g(afa.f3657c);
            } else {
                art.m4723g(afa.f3656b);
            }
        }
        return assVar == null ? m4708b() : assVar;
    }

    /* renamed from: d */
    public final void m4706d() {
        asi asiVar = this.f4963a;
        if (asiVar != null) {
            if (asiVar.isConnected() || this.f4963a.isConnecting()) {
                this.f4963a.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        asn m4709a = m4709a();
        if (m4709a != null) {
            try {
                ass mo4685f = m4709a.mo4685f(new asr(this.f4970h, this.f4964b, this.f4965c));
                m4705e(5011, this.f4969g);
                this.f4966d.put(mo4685f);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            m4705e(4012, this.f4969g);
            this.f4966d.put(m4708b());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            m4705e(4011, this.f4969g);
            this.f4966d.put(m4708b());
        } catch (InterruptedException unused) {
        }
    }
}
