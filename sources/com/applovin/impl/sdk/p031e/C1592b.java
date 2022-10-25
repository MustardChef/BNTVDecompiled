package com.applovin.impl.sdk.p031e;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1673m;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.network.C1692e;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e.b */
/* loaded from: classes.dex */
public class C1592b extends AbstractRunnableC1589a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1592b(C1662k c1662k) {
        super("TaskApiSubmitData", c1662k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6869a(JSONObject jSONObject) {
        try {
            JSONObject m6262a = C1725g.m6262a(jSONObject);
            this.f2058b.m6678I().m7002a(C1568b.f1650W, m6262a.getString("device_id"));
            this.f2058b.m6678I().m7002a(C1568b.f1652Y, m6262a.getString("device_token"));
            this.f2058b.m6678I().m7002a(C1568b.f1653Z, Long.valueOf(m6262a.getLong("publisher_id")));
            this.f2058b.m6678I().m7004a();
            C1725g.m6257d(m6262a, this.f2058b);
            C1725g.m6255e(m6262a, this.f2058b);
            C1725g.m6251g(m6262a, this.f2058b);
            String string = JsonUtils.getString(m6262a, "latest_version", "");
            if (!TextUtils.isEmpty(string) && !AppLovinSdk.VERSION.equals(string)) {
                String str = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                if (JsonUtils.valueExists(m6262a, "sdk_update_message")) {
                    str = JsonUtils.getString(m6262a, "sdk_update_message", str);
                }
                C1710r.m6311h("AppLovinSdk", str);
            }
            this.f2058b.m6669R().m6891b();
        } catch (Throwable th) {
            m6883a("Unable to parse API response", th);
        }
    }

    /* renamed from: b */
    private void m6868b(JSONObject jSONObject) throws JSONException {
        C1673m m6667T = this.f2058b.m6667T();
        Map<String, Object> m6549d = m6667T.m6549d();
        Utils.renameKeyInObjectMap("platform", "type", m6549d);
        Utils.renameKeyInObjectMap("api_level", "sdk_version", m6549d);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(m6549d));
        Map<String, Object> m6546g = m6667T.m6546g();
        Utils.renameKeyInObjectMap("sdk_version", "applovin_sdk_version", m6546g);
        Utils.renameKeyInObjectMap("ia", "installed_at", m6546g);
        jSONObject.put("app_info", new JSONObject(m6546g));
    }

    /* renamed from: c */
    private void m6867c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.f2058b.m6656a(C1568b.f1834dW)).booleanValue()) {
            jSONObject.put("stats", this.f2058b.m6669R().m6888c());
        }
        if (((Boolean) this.f2058b.m6656a(C1568b.f1687ag)).booleanValue()) {
            JSONObject m6457b = C1692e.m6457b(m6877f());
            if (m6457b.length() > 0) {
                jSONObject.put("network_response_codes", m6457b);
            }
            if (((Boolean) this.f2058b.m6656a(C1568b.f1688ah)).booleanValue()) {
                C1692e.m6460a(m6877f());
            }
        }
    }

    /* renamed from: d */
    private void m6866d(JSONObject jSONObject) {
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6391a(C1725g.m6264a("2.0/device", this.f2058b)).mo6380c(C1725g.m6259b("2.0/device", this.f2058b)).mo6390a(C1725g.m6256e(this.f2058b)).mo6384b(ShareTarget.METHOD_POST).mo6389a(jSONObject).mo6374d(((Boolean) this.f2058b.m6656a(C1568b.f1910eu)).booleanValue()).mo6392a((C1688c.C1689a) new JSONObject()).mo6394a(((Integer) this.f2058b.m6656a(C1568b.f1784cY)).intValue()).mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.b.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject2) {
                C1725g.m6269a(i, this.f2058b);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject2, int i) {
                C1592b.this.m6869a(jSONObject2);
            }
        };
        abstractC1633t.m6770a(C1568b.f1671aQ);
        abstractC1633t.m6766b(C1568b.f1672aR);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            m6882b("Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m6868b(jSONObject);
            m6867c(jSONObject);
            m6866d(jSONObject);
        } catch (JSONException e) {
            m6883a("Unable to build JSON message with collected data", e);
        }
    }
}
