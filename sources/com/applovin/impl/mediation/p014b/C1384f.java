package com.applovin.impl.mediation.p014b;

import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p031e.AbstractC1636v;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.f */
/* loaded from: classes.dex */
public class C1384f extends AbstractC1636v {

    /* renamed from: a */
    private final C1336c f963a;

    public C1384f(C1336c c1336c, C1662k c1662k) {
        super("TaskReportMaxReward", c1662k);
        this.f963a = c1336c;
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected String mo6744a() {
        return "2.0/mcr";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    public void mo6743a(int i) {
        super.mo6743a(i);
        m6884a("Failed to report reward for mediated ad: " + this.f963a + " - error code: " + i);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected void mo6741a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f963a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f963a.getPlacement());
        String m7769y = this.f963a.m7769y();
        if (!StringUtils.isValidString(m7769y)) {
            m7769y = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", m7769y);
        String m7770x = this.f963a.m7770x();
        if (!StringUtils.isValidString(m7770x)) {
            m7770x = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", m7770x);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: b */
    protected C1565c mo6760b() {
        return this.f963a.m7784B();
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: b */
    protected void mo6759b(JSONObject jSONObject) {
        m6884a("Reported reward successfully for mediated ad: " + this.f963a);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1636v
    /* renamed from: c */
    protected void mo6758c() {
        m6879d("No reward result was found for mediated ad: " + this.f963a);
    }
}
