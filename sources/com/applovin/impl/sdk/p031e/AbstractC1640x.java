package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.x */
/* loaded from: classes.dex */
public abstract class AbstractC1640x extends AbstractRunnableC1589a {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1640x(String str, C1662k c1662k) {
        super(str, c1662k);
    }

    /* renamed from: a */
    protected abstract String mo6744a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6743a(int i) {
        C1725g.m6269a(i, this.f2058b);
    }

    /* renamed from: a */
    protected abstract void mo6741a(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6749a(JSONObject jSONObject, final C1684b.InterfaceC1687c<JSONObject> interfaceC1687c) {
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6391a(C1725g.m6264a(mo6744a(), this.f2058b)).mo6380c(C1725g.m6259b(mo6744a(), this.f2058b)).mo6390a(C1725g.m6256e(this.f2058b)).mo6384b(ShareTarget.METHOD_POST).mo6389a(jSONObject).mo6374d(((Boolean) this.f2058b.m6656a(C1568b.f1914ey)).booleanValue()).mo6392a((C1688c.C1689a) new JSONObject()).mo6394a(mo6748h()).mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.x.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject2) {
                interfaceC1687c.mo6491a(i, str, jSONObject2);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject2, int i) {
                interfaceC1687c.mo6490a(jSONObject2, i);
            }
        };
        abstractC1633t.m6770a(C1568b.f1671aQ);
        abstractC1633t.m6766b(C1568b.f1672aR);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }

    /* renamed from: h */
    protected abstract int mo6748h();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public JSONObject m6747i() {
        JSONObject jSONObject = new JSONObject();
        String m6601m = this.f2058b.m6601m();
        if (((Boolean) this.f2058b.m6656a(C1568b.f1857dt)).booleanValue() && StringUtils.isValidString(m6601m)) {
            JsonUtils.putString(jSONObject, "cuid", m6601m);
        }
        if (((Boolean) this.f2058b.m6656a(C1568b.f1859dv)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f2058b.m6600n());
        }
        if (((Boolean) this.f2058b.m6656a(C1568b.f1861dx)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f2058b.m6599o());
        }
        mo6741a(jSONObject);
        return jSONObject;
    }
}
