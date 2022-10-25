package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.u */
/* loaded from: classes.dex */
public class C1635u extends AbstractC1636v {

    /* renamed from: a */
    private final AbstractC1537g f2185a;

    public C1635u(AbstractC1537g abstractC1537g, C1662k c1662k) {
        super("TaskReportAppLovinReward", c1662k);
        this.f2185a = abstractC1537g;
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected String mo6744a() {
        return "2.0/cr";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    public void mo6743a(int i) {
        super.mo6743a(i);
        m6879d("Failed to report reward for ad: " + this.f2185a + " - error code: " + i);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected void mo6741a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f2185a.getAdZone().m7218a());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f2185a.m7122ad());
        String clCode = this.f2185a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: b */
    protected C1565c mo6760b() {
        return this.f2185a.m7131aI();
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: b */
    protected void mo6759b(JSONObject jSONObject) {
        m6884a("Reported reward successfully for ad: " + this.f2185a);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: c */
    protected void mo6758c() {
        m6879d("No reward result was found for ad: " + this.f2185a);
    }
}
