package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.C1721d;

/* renamed from: com.applovin.impl.mediation.c */
/* loaded from: classes.dex */
public class C1386c {

    /* renamed from: a */
    private final C1662k f965a;

    /* renamed from: b */
    private final C1710r f966b;

    /* renamed from: c */
    private final InterfaceC1388a f967c;

    /* renamed from: d */
    private C1721d f968d;

    /* renamed from: com.applovin.impl.mediation.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1388a {
        /* renamed from: c */
        void mo7607c(C1336c c1336c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1386c(C1662k c1662k, InterfaceC1388a interfaceC1388a) {
        this.f965a = c1662k;
        this.f966b = c1662k.m6588z();
        this.f967c = interfaceC1388a;
    }

    /* renamed from: a */
    public void m7611a() {
        this.f966b.m6319b("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        C1721d c1721d = this.f968d;
        if (c1721d != null) {
            c1721d.m6284a();
            this.f968d = null;
        }
    }

    /* renamed from: a */
    public void m7610a(final C1336c c1336c, long j) {
        C1710r c1710r = this.f966b;
        c1710r.m6319b("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        this.f968d = C1721d.m6283a(j, this.f965a, new Runnable() { // from class: com.applovin.impl.mediation.c.1
            @Override // java.lang.Runnable
            public void run() {
                C1386c.this.f966b.m6319b("AdHiddenCallbackTimeoutManager", "Timing out...");
                C1386c.this.f967c.mo7607c(c1336c);
            }
        });
    }
}
