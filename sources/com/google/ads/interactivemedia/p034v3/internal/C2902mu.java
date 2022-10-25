package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mu */
/* loaded from: classes2.dex */
public final class C2902mu implements InterfaceC2920nl {

    /* renamed from: a */
    final /* synthetic */ C2906my f8138a;

    /* renamed from: c */
    private final C2915ng f8139c;

    /* renamed from: d */
    private InterfaceC2910nb f8140d;

    /* renamed from: e */
    private boolean f8141e;

    public C2902mu(C2906my c2906my, C2915ng c2915ng) {
        this.f8138a = c2906my;
        this.f8139c = c2915ng;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void m1629a(C2962p c2962p) {
        int i;
        Looper looper;
        InterfaceC2910nb m1602w;
        Set set;
        C2906my c2906my = this.f8138a;
        i = c2906my.f8157m;
        if (i == 0 || this.f8141e) {
            return;
        }
        looper = c2906my.f8161q;
        C2616ce.m2689d(looper);
        m1602w = c2906my.m1602w(looper, this.f8139c, c2962p, false);
        this.f8140d = m1602w;
        set = this.f8138a.f8155k;
        set.add(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void m1628b() {
        Set set;
        if (this.f8141e) {
            return;
        }
        InterfaceC2910nb interfaceC2910nb = this.f8140d;
        if (interfaceC2910nb != null) {
            interfaceC2910nb.mo1570m(this.f8139c);
        }
        set = this.f8138a.f8155k;
        set.remove(this);
        this.f8141e = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2920nl
    /* renamed from: c */
    public final void mo1588c() {
        Handler handler = this.f8138a.f8162r;
        C2616ce.m2689d(handler);
        C2628cq.m2537as(handler, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ms
            @Override // java.lang.Runnable
            public final void run() {
                C2902mu.this.m1628b();
            }
        });
    }
}
