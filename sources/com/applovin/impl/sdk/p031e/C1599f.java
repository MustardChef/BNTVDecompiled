package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1673m;

/* renamed from: com.applovin.impl.sdk.e.f */
/* loaded from: classes.dex */
public class C1599f extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final InterfaceC1600a f2078a;

    /* renamed from: com.applovin.impl.sdk.e.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1600a {
        /* renamed from: a */
        void mo6526a(C1673m.C1677a c1677a);
    }

    public C1599f(C1662k c1662k, InterfaceC1600a interfaceC1600a) {
        super("TaskCollectAdvertisingId", c1662k, true);
        this.f2078a = interfaceC1600a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2078a.mo6526a(this.f2058b.m6667T().m6543j());
    }
}
