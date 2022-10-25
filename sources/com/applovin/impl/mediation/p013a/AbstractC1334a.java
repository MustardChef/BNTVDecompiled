package com.applovin.impl.mediation.p013a;

import android.os.Bundle;
import android.os.SystemClock;
import com.applovin.impl.mediation.C1471g;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1334a extends C1338e implements MaxAd {

    /* renamed from: a */
    protected C1471g f827a;

    /* renamed from: c */
    private final AtomicBoolean f828c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1334a(JSONObject jSONObject, JSONObject jSONObject2, C1471g c1471g, C1662k c1662k) {
        super(jSONObject, jSONObject2, c1662k);
        this.f828c = new AtomicBoolean();
        this.f827a = c1471g;
    }

    /* renamed from: a */
    public static AbstractC1334a m7817a(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        String string = JsonUtils.getString(jSONObject2, FirebaseAnalytics.Param.AD_FORMAT, null);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(string);
        if (formatFromString.isAdViewAd()) {
            return new C1335b(jSONObject, jSONObject2, c1662k);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new C1337d(jSONObject, jSONObject2, c1662k);
        }
        if (formatFromString.isFullscreenAd()) {
            return new C1336c(jSONObject, jSONObject2, c1662k);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* renamed from: q */
    private long m7801q() {
        return m7741b("load_started_time_ms", 0L);
    }

    /* renamed from: a */
    public abstract AbstractC1334a mo7767a(C1471g c1471g);

    /* renamed from: a */
    public JSONObject m7819a() {
        return m7744a("ad_values", new JSONObject());
    }

    /* renamed from: a */
    public void m7818a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("creative_id")) {
            return;
        }
        m7735c("creative_id", BundleUtils.getString("creative_id", bundle));
    }

    /* renamed from: b */
    public JSONObject m7816b() {
        return m7744a("revenue_parameters", new JSONObject());
    }

    /* renamed from: c */
    public String m7815c() {
        return JsonUtils.getString(m7816b(), "revenue_event", "");
    }

    /* renamed from: d */
    public boolean m7814d() {
        C1471g c1471g = this.f827a;
        return c1471g != null && c1471g.m7305d() && this.f827a.m7303e();
    }

    /* renamed from: e */
    public String m7813e() {
        return m7746a("event_id", "");
    }

    /* renamed from: f */
    public C1471g m7812f() {
        return this.f827a;
    }

    /* renamed from: g */
    public Float m7811g() {
        return m7747a("r_mbr", (Float) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdUnitId() {
        return m7746a("ad_unit_id", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(m7819a(), str, str2);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return m7739b("creative_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(m7739b(FirebaseAnalytics.Param.AD_FORMAT, m7746a(FirebaseAnalytics.Param.AD_FORMAT, (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return m7739b("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(m7808j());
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        return JsonUtils.getDouble(m7744a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
    }

    /* renamed from: h */
    public String m7810h() {
        return m7739b("bid_response", (String) null);
    }

    /* renamed from: i */
    public long m7809i() {
        return m7741b("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, m7756R()));
    }

    /* renamed from: j */
    public String m7808j() {
        return m7739b("third_party_ad_placement_id", (String) null);
    }

    /* renamed from: k */
    public long m7807k() {
        if (m7801q() > 0) {
            return m7805m() - m7801q();
        }
        return -1L;
    }

    /* renamed from: l */
    public void m7806l() {
        m7736c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: m */
    public long m7805m() {
        return m7741b("load_completed_time_ms", 0L);
    }

    /* renamed from: n */
    public void m7804n() {
        m7736c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: o */
    public AtomicBoolean m7803o() {
        return this.f828c;
    }

    /* renamed from: p */
    public void m7802p() {
        this.f827a = null;
    }

    @Override // com.applovin.impl.mediation.p013a.C1338e
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + m7808j() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
