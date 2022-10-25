package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1526a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.AbstractC1718a;

/* renamed from: com.applovin.impl.mediation.a */
/* loaded from: classes.dex */
public class C1332a extends AbstractC1718a {

    /* renamed from: a */
    private final C1526a f821a;

    /* renamed from: b */
    private final C1710r f822b;

    /* renamed from: c */
    private InterfaceC1333a f823c;

    /* renamed from: d */
    private C1336c f824d;

    /* renamed from: e */
    private int f825e;

    /* renamed from: f */
    private boolean f826f;

    /* renamed from: com.applovin.impl.mediation.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1333a {
        /* renamed from: a */
        void mo7672a(C1336c c1336c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1332a(C1662k c1662k) {
        this.f822b = c1662k.m6588z();
        this.f821a = c1662k.m6636ad();
    }

    /* renamed from: a */
    public void m7821a() {
        this.f822b.m6319b("AdActivityObserver", "Cancelling...");
        this.f821a.m7237b(this);
        this.f823c = null;
        this.f824d = null;
        this.f825e = 0;
        this.f826f = false;
    }

    /* renamed from: a */
    public void m7820a(C1336c c1336c, InterfaceC1333a interfaceC1333a) {
        C1710r c1710r = this.f822b;
        c1710r.m6319b("AdActivityObserver", "Starting for ad " + c1336c.getAdUnitId() + "...");
        m7821a();
        this.f823c = interfaceC1333a;
        this.f824d = c1336c;
        this.f821a.m7239a(this);
    }

    @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f826f) {
            this.f826f = true;
        }
        this.f825e++;
        this.f822b.m6319b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.f825e);
    }

    @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f826f) {
            this.f825e--;
            this.f822b.m6319b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.f825e);
            if (this.f825e <= 0) {
                this.f822b.m6319b("AdActivityObserver", "Last ad Activity destroyed");
                if (this.f823c != null) {
                    this.f822b.m6319b("AdActivityObserver", "Invoking callback...");
                    this.f823c.mo7672a(this.f824d);
                }
                m7821a();
            }
        }
    }
}
