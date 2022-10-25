package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {

    /* renamed from: a */
    private final JSONObject f797a;

    /* renamed from: b */
    private final MaxError f798b;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this(jSONObject, null);
    }

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject, MaxError maxError) {
        this.f797a = jSONObject;
        this.f798b = maxError;
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterClassName() {
        return JsonUtils.getString(this.f797a, "class", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterVersion() {
        return JsonUtils.getString(this.f797a, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "");
    }

    public MaxError getLoadError() {
        return this.f798b;
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getName() {
        return JsonUtils.getString(this.f797a, "name", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getSdkVersion() {
        return JsonUtils.getString(this.f797a, "sdk_version", "");
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + ", loadError=" + getLoadError() + '}';
    }
}
