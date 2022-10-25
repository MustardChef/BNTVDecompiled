package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p031e.AbstractC1633t;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.a */
/* loaded from: classes.dex */
public class C1682a extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final String f2350a;

    /* renamed from: c */
    private final C1688c<JSONObject> f2351c;

    public C1682a(String str, C1688c<JSONObject> c1688c, C1662k c1662k) {
        super("CommunicatorRequestTask:" + str, c1662k);
        this.f2350a = str;
        this.f2351c = c1688c;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2058b.m6670Q().m6794a(new AbstractC1633t<JSONObject>(this.f2351c, this.f2058b, m6876g()) { // from class: com.applovin.impl.sdk.network.a.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                this.f2058b.m6634af().m6726a(C1682a.this.f2350a, C1682a.this.f2351c.m6489a(), i, jSONObject, str, false);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                this.f2058b.m6634af().m6726a(C1682a.this.f2350a, C1682a.this.f2351c.m6489a(), i, jSONObject, null, true);
            }
        });
    }
}
