package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.l */
/* loaded from: classes.dex */
public class C1612l extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final InterfaceC1614a f2097a;

    /* renamed from: com.applovin.impl.sdk.e.l$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1614a {
        /* renamed from: a */
        void mo6803a();
    }

    public C1612l(C1662k c1662k, InterfaceC1614a interfaceC1614a) {
        super("TaskFetchVariables", c1662k);
        this.f2097a = interfaceC1614a;
    }

    /* renamed from: a */
    private Map<String, String> m6807a() {
        return Utils.stringifyObjectMap(this.f2058b.m6667T().m6557a(null, false, false));
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6391a(C1725g.m6248i(this.f2058b)).mo6380c(C1725g.m6247j(this.f2058b)).mo6390a(m6807a()).mo6384b(ShareTarget.METHOD_GET).mo6392a((C1688c.C1689a) new JSONObject()).mo6387b(((Integer) this.f2058b.m6656a(C1568b.f1843df)).intValue()).mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.l.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                m6879d("Unable to fetch variables: server returned " + i);
                C1710r.m6310i("AppLovinVariableService", "Failed to load variables.");
                C1612l.this.f2097a.mo6803a();
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                C1725g.m6257d(jSONObject, this.f2058b);
                C1725g.m6258c(jSONObject, this.f2058b);
                C1725g.m6249h(jSONObject, this.f2058b);
                C1725g.m6255e(jSONObject, this.f2058b);
                C1612l.this.f2097a.mo6803a();
            }
        };
        abstractC1633t.m6770a(C1568b.f1675aU);
        abstractC1633t.m6766b(C1568b.f1676aV);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }
}
