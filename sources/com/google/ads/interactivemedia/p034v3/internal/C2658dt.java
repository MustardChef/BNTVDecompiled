package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dt */
/* loaded from: classes2.dex */
public final class C2658dt implements InterfaceC2637cz {

    /* renamed from: a */
    private final InterfaceC2637cz f7065a;

    /* renamed from: b */
    private long f7066b;

    /* renamed from: c */
    private Uri f7067c;

    /* renamed from: d */
    private Map f7068d;

    public C2658dt(InterfaceC2637cz interfaceC2637cz) {
        C2616ce.m2689d(interfaceC2637cz);
        this.f7065a = interfaceC2637cz;
        this.f7067c = Uri.EMPTY;
        this.f7068d = Collections.emptyMap();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws IOException {
        int a = this.f7065a.mo501a(bArr, i, i2);
        if (a != -1) {
            this.f7066b += a;
        }
        return a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws IOException {
        this.f7067c = c2642dd.f7011a;
        this.f7068d = Collections.emptyMap();
        long mo1127b = this.f7065a.mo1127b(c2642dd);
        Uri mo1126c = mo1126c();
        C2616ce.m2689d(mo1126c);
        this.f7067c = mo1126c;
        this.f7068d = mo1124e();
        return mo1127b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f7065a.mo1126c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws IOException {
        this.f7065a.mo1125d();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public final Map mo1124e() {
        return this.f7065a.mo1124e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: f */
    public final void mo1123f(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2689d(interfaceC2659du);
        this.f7065a.mo1123f(interfaceC2659du);
    }

    /* renamed from: g */
    public final long m2471g() {
        return this.f7066b;
    }

    /* renamed from: h */
    public final Uri m2470h() {
        return this.f7067c;
    }

    /* renamed from: i */
    public final Map m2469i() {
        return this.f7068d;
    }

    /* renamed from: j */
    public final void m2468j() {
        this.f7066b = 0L;
    }
}
