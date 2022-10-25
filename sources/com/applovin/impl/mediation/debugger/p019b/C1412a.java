package com.applovin.impl.mediation.debugger.p019b;

import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.mediation.p015c.C1390b;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.AbstractC1633t;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.b.a */
/* loaded from: classes.dex */
public class C1412a extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final C1684b.InterfaceC1687c<JSONObject> f1075a;

    public C1412a(C1684b.InterfaceC1687c<JSONObject> interfaceC1687c, C1662k c1662k) {
        super("TaskFetchMediationDebuggerInfo", c1662k, true);
        this.f1075a = interfaceC1687c;
    }

    /* renamed from: a */
    private JSONObject m7494a(C1662k c1662k) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C1391c.m7599a(c1662k));
        } catch (JSONException e) {
            m6883a("Failed to create mediation debugger request post body", e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONObject m7493b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C1391c.m7599a(this.f2058b));
        } catch (JSONException e) {
            m6883a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    protected Map<String, String> m7496a() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f2058b.m6656a(C1568b.f1903en)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2058b.m6590x());
        }
        Map<String, Object> m6546g = this.f2058b.m6667T().m6546g();
        hashMap.put("package_name", String.valueOf(m6546g.get("package_name")));
        hashMap.put("app_version", String.valueOf(m6546g.get("app_version")));
        hashMap.put("platform", "android");
        hashMap.put("os", Build.VERSION.RELEASE);
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6384b(ShareTarget.METHOD_POST).mo6391a(C1390b.m7602c(this.f2058b)).mo6380c(C1390b.m7601d(this.f2058b)).mo6390a(m7496a()).mo6389a(m7494a(this.f2058b)).mo6392a((C1688c.C1689a) new JSONObject()).mo6387b(((Long) this.f2058b.m6656a(C1567a.f1629g)).intValue()).mo6389a(m7493b()).mo6395a(), this.f2058b, m6876g()) { // from class: com.applovin.impl.mediation.debugger.b.a.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                C1412a.this.f1075a.mo6491a(i, str, jSONObject);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                C1412a.this.f1075a.mo6490a(jSONObject, i);
            }
        };
        abstractC1633t.m6770a(C1567a.f1625c);
        abstractC1633t.m6766b(C1567a.f1626d);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }
}
