package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cm */
/* loaded from: classes2.dex */
final class C2624cm implements InterfaceC2605bu {

    /* renamed from: a */
    private static final List f6950a = new ArrayList(50);

    /* renamed from: b */
    private final Handler f6951b;

    public C2624cm(Handler handler) {
        this.f6951b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* bridge */ /* synthetic */ void m2599k(C2623cl c2623cl) {
        List list = f6950a;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(c2623cl);
            }
        }
    }

    /* renamed from: l */
    private static C2623cl m2598l() {
        C2623cl c2623cl;
        List list = f6950a;
        synchronized (list) {
            c2623cl = list.isEmpty() ? new C2623cl(null) : (C2623cl) list.remove(list.size() - 1);
        }
        return c2623cl;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: a */
    public final InterfaceC2604bt mo2609a(int i) {
        C2623cl m2598l = m2598l();
        m2598l.m2611c(this.f6951b.obtainMessage(i));
        return m2598l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: b */
    public final InterfaceC2604bt mo2608b(int i, Object obj) {
        C2623cl m2598l = m2598l();
        m2598l.m2611c(this.f6951b.obtainMessage(i, obj));
        return m2598l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: c */
    public final boolean mo2607c() {
        return this.f6951b.hasMessages(0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: d */
    public final InterfaceC2604bt mo2606d(int i, int i2) {
        C2623cl m2598l = m2598l();
        m2598l.m2611c(this.f6951b.obtainMessage(1, i, i2));
        return m2598l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: e */
    public final void mo2605e(Runnable runnable) {
        this.f6951b.post(runnable);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: f */
    public final void mo2604f() {
        this.f6951b.removeCallbacksAndMessages(null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: g */
    public final void mo2603g() {
        this.f6951b.removeMessages(2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: h */
    public final void mo2602h(int i) {
        this.f6951b.sendEmptyMessage(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: i */
    public final void mo2601i(long j) {
        this.f6951b.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2605bu
    /* renamed from: j */
    public final void mo2600j(InterfaceC2604bt interfaceC2604bt) {
        ((C2623cl) interfaceC2604bt).m2612b(this.f6951b);
    }
}
