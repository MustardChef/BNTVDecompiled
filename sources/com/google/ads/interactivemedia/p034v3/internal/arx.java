package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arx */
/* loaded from: classes2.dex */
public final class arx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    protected final asi f4958a;

    /* renamed from: b */
    private final String f4959b;

    /* renamed from: c */
    private final String f4960c;

    /* renamed from: d */
    private final LinkedBlockingQueue f4961d;

    /* renamed from: e */
    private final HandlerThread f4962e;

    public arx(Context context, String str, String str2) {
        this.f4959b = str;
        this.f4960c = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.f4962e = handlerThread;
        handlerThread.start();
        asi asiVar = new asi(context, handlerThread.getLooper(), this, this, 9200000);
        this.f4958a = asiVar;
        this.f4961d = new LinkedBlockingQueue();
        asiVar.checkAvailabilityAndConnect();
    }

    /* renamed from: a */
    static afr m4713a() {
        aga m5557an = afr.m5557an();
        m5557an.m5420ah(32768L);
        return (afr) m5557an.mo3179aR();
    }

    /* renamed from: b */
    public final afr m4712b() {
        afr afrVar;
        try {
            afrVar = (afr) this.f4961d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            afrVar = null;
        }
        return afrVar == null ? m4713a() : afrVar;
    }

    /* renamed from: c */
    protected final asn m4711c() {
        try {
            return this.f4958a.m4689a();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public final void m4710d() {
        asi asiVar = this.f4958a;
        if (asiVar != null) {
            if (asiVar.isConnected() || this.f4958a.isConnecting()) {
                this.f4958a.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        asn m4711c = m4711c();
        if (m4711c != null) {
            try {
                try {
                    this.f4961d.put(m4711c.mo4686e(new asj(this.f4959b, this.f4960c)).m4688a());
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    m4710d();
                    this.f4962e.quit();
                    throw th;
                }
            } catch (Throwable unused2) {
                this.f4961d.put(m4713a());
            }
            m4710d();
            this.f4962e.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.f4961d.put(m4713a());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.f4961d.put(m4713a());
        } catch (InterruptedException unused) {
        }
    }
}
