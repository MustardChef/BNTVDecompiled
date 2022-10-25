package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.z */
/* loaded from: classes.dex */
public class C1643z extends AbstractC1590aa {

    /* renamed from: a */
    private final AbstractC1537g f2193a;

    /* renamed from: c */
    private final AppLovinAdRewardListener f2194c;

    public C1643z(AbstractC1537g abstractC1537g, AppLovinAdRewardListener appLovinAdRewardListener, C1662k c1662k) {
        super("TaskValidateAppLovinReward", c1662k);
        this.f2193a = abstractC1537g;
        this.f2194c = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    public String mo6744a() {
        return "2.0/vr";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    public void mo6743a(int i) {
        String str;
        super.mo6743a(i);
        if (i < 400 || i >= 500) {
            this.f2194c.validationRequestFailed(this.f2193a, i);
            str = "network_timeout";
        } else {
            this.f2194c.userRewardRejected(this.f2193a, Collections.emptyMap());
            str = "rejected";
        }
        this.f2193a.m7141a(C1565c.m7020a(str));
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1590aa
    /* renamed from: a */
    protected void mo6742a(C1565c c1565c) {
        this.f2193a.m7141a(c1565c);
        String m7018b = c1565c.m7018b();
        Map<String, String> m7021a = c1565c.m7021a();
        if (m7018b.equals("accepted")) {
            this.f2194c.userRewardVerified(this.f2193a, m7021a);
        } else if (m7018b.equals("quota_exceeded")) {
            this.f2194c.userOverQuota(this.f2193a, m7021a);
        } else if (m7018b.equals("rejected")) {
            this.f2194c.userRewardRejected(this.f2193a, m7021a);
        } else {
            this.f2194c.validationRequestFailed(this.f2193a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: a */
    protected void mo6741a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f2193a.getAdZone().m7218a());
        String clCode = this.f2193a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1590aa
    /* renamed from: b */
    protected boolean mo6740b() {
        return this.f2193a.m7133aG();
    }
}
