package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ha */
/* loaded from: classes2.dex */
public final class C2747ha implements InterfaceC2718fz {

    /* renamed from: a */
    private final InterfaceC2598bn f7482a;

    /* renamed from: b */
    private boolean f7483b;

    /* renamed from: c */
    private long f7484c;

    /* renamed from: d */
    private long f7485d;

    /* renamed from: e */
    private C2559aq f7486e = C2559aq.f4867a;

    public C2747ha(InterfaceC2598bn interfaceC2598bn) {
        this.f7482a = interfaceC2598bn;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: a */
    public final long mo1835a() {
        long m4776a;
        long j = this.f7484c;
        if (this.f7483b) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f7485d;
            C2559aq c2559aq = this.f7486e;
            if (c2559aq.f4868b == 1.0f) {
                m4776a = C2628cq.m2515s(elapsedRealtime);
            } else {
                m4776a = c2559aq.m4776a(elapsedRealtime);
            }
            return j + m4776a;
        }
        return j;
    }

    /* renamed from: b */
    public final void m2109b(long j) {
        this.f7484c = j;
        if (this.f7483b) {
            this.f7485d = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: c */
    public final C2559aq mo1831c() {
        return this.f7486e;
    }

    /* renamed from: d */
    public final void m2108d() {
        if (this.f7483b) {
            return;
        }
        this.f7485d = SystemClock.elapsedRealtime();
        this.f7483b = true;
    }

    /* renamed from: e */
    public final void m2107e() {
        if (this.f7483b) {
            m2109b(mo1835a());
            this.f7483b = false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2718fz
    /* renamed from: g */
    public final void mo1830g(C2559aq c2559aq) {
        if (this.f7483b) {
            m2109b(mo1835a());
        }
        this.f7486e = c2559aq;
    }
}
