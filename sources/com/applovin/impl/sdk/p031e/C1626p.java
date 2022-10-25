package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.p */
/* loaded from: classes.dex */
public class C1626p extends AbstractRunnableC1589a implements AppLovinAdLoadListener {

    /* renamed from: a */
    private final JSONObject f2163a;

    /* renamed from: c */
    private final C1531d f2164c;

    /* renamed from: d */
    private final EnumC1528b f2165d;

    /* renamed from: e */
    private final AppLovinAdLoadListener f2166e;

    public C1626p(JSONObject jSONObject, C1531d c1531d, EnumC1528b enumC1528b, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super("TaskProcessAdResponse", c1662k);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (c1531d == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.f2163a = jSONObject;
        this.f2164c = c1531d;
        this.f2165d = enumC1528b;
        this.f2166e = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private void m6777a(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2166e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    private void m6776a(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", "undefined");
        if ("applovin".equalsIgnoreCase(string)) {
            m6884a("Starting task for AppLovin ad...");
            this.f2058b.m6670Q().m6794a(new C1631r(jSONObject, this.f2163a, this.f2165d, this, this.f2058b));
        } else if ("vast".equalsIgnoreCase(string)) {
            m6884a("Starting task for VAST ad...");
            this.f2058b.m6670Q().m6794a(AbstractC1627q.m6772a(jSONObject, this.f2163a, this.f2165d, this, this.f2058b));
        } else {
            m6881c("Unable to process ad of unknown type: " + string);
            failedToReceiveAd(AppLovinErrorCodes.INVALID_RESPONSE);
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f2166e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        m6777a(i);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f2163a, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            m6884a("Processing ad...");
            m6776a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        m6881c("No ads were returned from the server");
        Utils.maybeHandleNoFillResponseForPublisher(this.f2164c.m7218a(), this.f2164c.m7212b(), this.f2163a, this.f2058b);
        m6777a(204);
    }
}
