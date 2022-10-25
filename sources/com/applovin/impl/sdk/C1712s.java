package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p013a.AbstractC1334a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.s */
/* loaded from: classes.dex */
public class C1712s {

    /* renamed from: a */
    private final C1662k f2461a;

    /* renamed from: b */
    private final C1710r f2462b;

    /* renamed from: c */
    private final Map<String, AbstractC1334a> f2463c = new HashMap(4);

    /* renamed from: d */
    private final Object f2464d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1712s(C1662k c1662k) {
        this.f2461a = c1662k;
        this.f2462b = c1662k.m6588z();
    }

    /* renamed from: a */
    public String m6307a(String str) {
        String K;
        synchronized (this.f2464d) {
            AbstractC1334a abstractC1334a = this.f2463c.get(str);
            K = abstractC1334a != null ? abstractC1334a.m7763K() : null;
        }
        return K;
    }

    /* renamed from: a */
    public void m6308a(AbstractC1334a abstractC1334a) {
        synchronized (this.f2464d) {
            C1710r c1710r = this.f2462b;
            c1710r.m6319b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + abstractC1334a);
            this.f2463c.put(abstractC1334a.getAdUnitId(), abstractC1334a);
        }
    }

    /* renamed from: b */
    public void m6306b(AbstractC1334a abstractC1334a) {
        synchronized (this.f2464d) {
            String adUnitId = abstractC1334a.getAdUnitId();
            AbstractC1334a abstractC1334a2 = this.f2463c.get(adUnitId);
            if (abstractC1334a == abstractC1334a2) {
                C1710r c1710r = this.f2462b;
                c1710r.m6319b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + abstractC1334a2);
                this.f2463c.remove(adUnitId);
            } else {
                C1710r c1710r2 = this.f2462b;
                c1710r2.m6319b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + abstractC1334a + " , since it could have already been updated with a new ad: " + abstractC1334a2);
            }
        }
    }
}
