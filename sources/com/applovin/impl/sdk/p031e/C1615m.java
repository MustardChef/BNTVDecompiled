package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1673m;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p027a.RunnableC1533f;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.m */
/* loaded from: classes.dex */
public class C1615m extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final RunnableC1533f.EnumC1536b f2099a;

    /* renamed from: c */
    private final RunnableC1533f.EnumC1536b f2100c;

    /* renamed from: d */
    private final JSONArray f2101d;

    /* renamed from: e */
    private final MaxAdFormat f2102e;

    public C1615m(RunnableC1533f.EnumC1536b enumC1536b, RunnableC1533f.EnumC1536b enumC1536b2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1662k c1662k) {
        super("TaskFlushZones", c1662k);
        this.f2099a = enumC1536b;
        this.f2100c = enumC1536b2;
        this.f2101d = jSONArray;
        this.f2102e = maxAdFormat;
    }

    /* renamed from: b */
    private JSONObject m6801b() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        if (this.f2099a != RunnableC1533f.EnumC1536b.UNKNOWN_ZONE) {
            JsonUtils.putString(jSONObject, "format", this.f2102e.getLabel());
            JsonUtils.putInt(jSONObject, "previous_trigger_code", this.f2100c.m7174a());
            JsonUtils.putString(jSONObject, "previous_trigger_reason", this.f2100c.m7173b());
        }
        JsonUtils.putInt(jSONObject, "trigger_code", this.f2099a.m7174a());
        JsonUtils.putString(jSONObject, "trigger_reason", this.f2099a.m7173b());
        JsonUtils.putJsonArray(jSONObject, "zones", this.f2101d);
        return jSONObject;
    }

    /* renamed from: a */
    public Map<String, String> m6802a() {
        C1673m m6667T = this.f2058b.m6667T();
        Map<String, Object> m6549d = m6667T.m6549d();
        m6549d.putAll(m6667T.m6546g());
        m6549d.putAll(m6667T.m6545h());
        if (!((Boolean) this.f2058b.m6656a(C1568b.f1903en)).booleanValue()) {
            m6549d.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2058b.m6590x());
        }
        return Utils.stringifyObjectMap(m6549d);
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, String> m6802a = m6802a();
        JSONObject m6801b = m6801b();
        String m6263a = C1725g.m6263a((String) this.f2058b.m6656a(C1568b.f1884eU), "1.0/flush_zones", this.f2058b);
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6391a(m6263a).mo6380c(C1725g.m6263a((String) this.f2058b.m6656a(C1568b.f1885eV), "1.0/flush_zones", this.f2058b)).mo6390a(m6802a).mo6389a(m6801b).mo6374d(((Boolean) this.f2058b.m6656a(C1568b.f1915ez)).booleanValue()).mo6384b(ShareTarget.METHOD_POST).mo6392a((C1688c.C1689a) new JSONObject()).mo6387b(((Integer) this.f2058b.m6656a(C1568b.f1886eW)).intValue()).mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.m.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                C1725g.m6257d(jSONObject, this.f2058b);
            }
        };
        abstractC1633t.m6770a(C1568b.f1675aU);
        abstractC1633t.m6766b(C1568b.f1676aV);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }
}
