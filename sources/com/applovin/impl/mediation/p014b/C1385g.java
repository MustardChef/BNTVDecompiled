package com.applovin.impl.mediation.p014b;

import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p031e.AbstractC1590aa;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.g */
/* loaded from: classes.dex */
public class C1385g extends AbstractC1590aa {

    /* renamed from: a */
    private final C1336c f964a;

    public C1385g(C1336c c1336c, C1662k c1662k) {
        super("TaskValidateMaxReward", c1662k);
        this.f964a = c1336c;
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected String mo6744a() {
        return "2.0/mvr";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    public void mo6743a(int i) {
        super.mo6743a(i);
        this.f964a.m7778a(C1565c.m7020a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1590aa
    /* renamed from: a */
    protected void mo6742a(C1565c c1565c) {
        this.f964a.m7778a(c1565c);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected void mo6741a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f964a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f964a.getPlacement());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.f964a.getFormat().getLabel());
        String m7769y = this.f964a.m7769y();
        if (!StringUtils.isValidString(m7769y)) {
            m7769y = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", m7769y);
        String m7770x = this.f964a.m7770x();
        if (!StringUtils.isValidString(m7770x)) {
            m7770x = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", m7770x);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1590aa
    /* renamed from: b */
    protected boolean mo6740b() {
        return this.f964a.m7768z();
    }
}
