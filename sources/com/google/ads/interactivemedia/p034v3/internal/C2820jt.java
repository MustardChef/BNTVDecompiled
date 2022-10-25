package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jt */
/* loaded from: classes2.dex */
public final class C2820jt implements InterfaceC2811jk {

    /* renamed from: a */
    final /* synthetic */ C2824jx f7721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2820jt(C2824jx c2824jx) {
        this.f7721a = c2824jx;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2811jk
    /* renamed from: a */
    public final void mo1900a(long j) {
        StringBuilder sb = new StringBuilder(61);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        Log.w("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2811jk
    /* renamed from: b */
    public final void mo1899b(long j) {
        InterfaceC2805je interfaceC2805je;
        InterfaceC2805je interfaceC2805je2;
        C2801ja c2801ja;
        C2824jx c2824jx = this.f7721a;
        interfaceC2805je = c2824jx.f7765n;
        if (interfaceC2805je != null) {
            interfaceC2805je2 = c2824jx.f7765n;
            c2801ja = ((C2826jz) interfaceC2805je2).f7779a.f7786c;
            c2801ja.m1956r(j);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2811jk
    /* renamed from: c */
    public final void mo1898c(long j, long j2, long j3, long j4) {
        long m1887G;
        long m1886H;
        m1887G = this.f7721a.m1887G();
        m1886H = this.f7721a.m1886H();
        StringBuilder sb = new StringBuilder(182);
        sb.append("Spurious audio timestamp (frame position mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(m1887G);
        sb.append(", ");
        sb.append(m1886H);
        Log.w("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2811jk
    /* renamed from: d */
    public final void mo1897d(long j, long j2, long j3, long j4) {
        long m1887G;
        long m1886H;
        m1887G = this.f7721a.m1887G();
        m1886H = this.f7721a.m1886H();
        StringBuilder sb = new StringBuilder(180);
        sb.append("Spurious audio timestamp (system clock mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(m1887G);
        sb.append(", ");
        sb.append(m1886H);
        Log.w("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2811jk
    /* renamed from: e */
    public final void mo1896e(int i, long j) {
        InterfaceC2805je interfaceC2805je;
        long j2;
        InterfaceC2805je interfaceC2805je2;
        C2801ja c2801ja;
        interfaceC2805je = this.f7721a.f7765n;
        if (interfaceC2805je != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C2824jx c2824jx = this.f7721a;
            j2 = c2824jx.f7748V;
            interfaceC2805je2 = c2824jx.f7765n;
            c2801ja = ((C2826jz) interfaceC2805je2).f7779a.f7786c;
            c2801ja.m1954t(i, j, elapsedRealtime - j2);
        }
    }
}
