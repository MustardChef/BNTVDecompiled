package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.p010a.C1135c;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.p010a.EnumC1136d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e.w */
/* loaded from: classes.dex */
public class C1638w extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final C1135c f2187a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2188c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1638w(C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super("TaskResolveVastWrapper", c1662k);
        this.f2188c = appLovinAdLoadListener;
        this.f2187a = c1135c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6755a(int i) {
        m6879d("Failed to resolve VAST wrapper due to error code " + i);
        if (i != -1009) {
            C1142i.m8352a(this.f2187a, this.f2188c, i == -1001 ? EnumC1136d.TIMED_OUT : EnumC1136d.GENERAL_WRAPPER_ERROR, i, this.f2058b);
            return;
        }
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2188c;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String m8354a = C1142i.m8354a(this.f2187a);
        if (StringUtils.isValidString(m8354a)) {
            m6884a("Resolving VAST ad with depth " + this.f2187a.m8380a() + " at " + m8354a);
            try {
                this.f2058b.m6670Q().m6794a(new AbstractC1633t<C1766p>(C1688c.m6487a(this.f2058b).mo6391a(m8354a).mo6384b(ShareTarget.METHOD_GET).mo6392a((C1688c.C1689a) C1766p.f2587a).mo6394a(((Integer) this.f2058b.m6656a(C1568b.f1901el)).intValue()).mo6387b(((Integer) this.f2058b.m6656a(C1568b.f1902em)).intValue()).mo6378c(false).mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.w.1
                    @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                    /* renamed from: a */
                    public void mo6491a(int i, String str, C1766p c1766p) {
                        m6879d("Unable to resolve VAST wrapper. Server returned " + i);
                        C1638w.this.m6755a(i);
                    }

                    @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                    /* renamed from: a */
                    public void mo6490a(C1766p c1766p, int i) {
                        this.f2058b.m6670Q().m6794a(AbstractC1627q.m6773a(c1766p, C1638w.this.f2187a, C1638w.this.f2188c, C1638w.this.f2058b));
                    }
                });
                return;
            } catch (Throwable th) {
                m6883a("Unable to resolve VAST wrapper", th);
            }
        } else {
            m6879d("Resolving VAST failed. Could not find resolution URL");
        }
        m6755a(-1);
    }
}
