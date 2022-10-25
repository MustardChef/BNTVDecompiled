package com.applovin.impl.sdk.p027a;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.h */
/* loaded from: classes.dex */
public final class C1543h extends AppLovinAdBase {

    /* renamed from: a */
    private AppLovinAd f1552a;

    /* renamed from: b */
    private final C1531d f1553b;

    public C1543h(C1531d c1531d, C1662k c1662k) {
        super(new JSONObject(), new JSONObject(), EnumC1528b.UNKNOWN, c1662k);
        this.f1553b = c1531d;
    }

    /* renamed from: c */
    private AppLovinAd m7065c() {
        return this.sdk.m6663X().m7013d(this.f1553b);
    }

    /* renamed from: d */
    private String m7064d() {
        C1531d adZone = getAdZone();
        if (adZone == null || adZone.m7208e()) {
            return null;
        }
        return adZone.m7218a();
    }

    /* renamed from: a */
    public AppLovinAd m7068a() {
        return this.f1552a;
    }

    /* renamed from: a */
    public void m7067a(AppLovinAd appLovinAd) {
        this.f1552a = appLovinAd;
    }

    /* renamed from: b */
    public AppLovinAd m7066b() {
        AppLovinAd appLovinAd = this.f1552a;
        return appLovinAd != null ? appLovinAd : m7065c();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd m7066b = m7066b();
        return m7066b != null ? m7066b.equals(obj) : super.equals(obj);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        AppLovinAd m7066b = m7066b();
        if (m7066b != null) {
            return m7066b.getAdIdNumber();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public C1531d getAdZone() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) m7066b();
        return appLovinAdBase != null ? appLovinAdBase.getAdZone() : this.f1553b;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        AppLovinAd m7066b = m7066b();
        if (m7066b instanceof AppLovinAdBase) {
            return ((AppLovinAdBase) m7066b).getCreatedAtMillis();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return getAdZone().m7210c();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public EnumC1528b getSource() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) m7066b();
        return appLovinAdBase != null ? appLovinAdBase.getSource() : EnumC1528b.UNKNOWN;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return getAdZone().m7209d();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (this.f1553b.m7208e()) {
            return null;
        }
        return this.f1553b.m7218a();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public int hashCode() {
        AppLovinAd m7066b = m7066b();
        return m7066b != null ? m7066b.hashCode() : super.hashCode();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public boolean isVideoAd() {
        AppLovinAd m7066b = m7066b();
        return m7066b != null && m7066b.isVideoAd();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + m7064d() + "'}";
    }
}
