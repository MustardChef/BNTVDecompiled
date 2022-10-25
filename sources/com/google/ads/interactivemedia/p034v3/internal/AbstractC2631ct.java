package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ct */
/* loaded from: classes2.dex */
public abstract class AbstractC2631ct implements InterfaceC2637cz {

    /* renamed from: a */
    private final boolean f6980a;

    /* renamed from: b */
    private final ArrayList f6981b = new ArrayList(1);

    /* renamed from: c */
    private int f6982c;

    /* renamed from: d */
    private C2642dd f6983d;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC2631ct(boolean z) {
        this.f6980a = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public /* synthetic */ Map mo1124e() {
        return Collections.emptyMap();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: f */
    public final void mo1123f(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2689d(interfaceC2659du);
        if (this.f6981b.contains(interfaceC2659du)) {
            return;
        }
        this.f6981b.add(interfaceC2659du);
        this.f6982c++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m2507g(int i) {
        C2642dd c2642dd = this.f6983d;
        int i2 = C2628cq.f6961a;
        for (int i3 = 0; i3 < this.f6982c; i3++) {
            ((InterfaceC2659du) this.f6981b.get(i3)).mo760a(c2642dd, this.f6980a, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final void m2506h() {
        C2642dd c2642dd = this.f6983d;
        int i = C2628cq.f6961a;
        for (int i2 = 0; i2 < this.f6982c; i2++) {
            ((InterfaceC2659du) this.f6981b.get(i2)).mo759b(c2642dd, this.f6980a);
        }
        this.f6983d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public final void m2505i(C2642dd c2642dd) {
        for (int i = 0; i < this.f6982c; i++) {
            ((InterfaceC2659du) this.f6981b.get(i)).mo758c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final void m2504j(C2642dd c2642dd) {
        this.f6983d = c2642dd;
        for (int i = 0; i < this.f6982c; i++) {
            ((InterfaceC2659du) this.f6981b.get(i)).mo757d(c2642dd, this.f6980a);
        }
    }
}
