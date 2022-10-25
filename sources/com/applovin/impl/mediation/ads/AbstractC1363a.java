package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.utils.C1757j;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.mediation.ads.a */
/* loaded from: classes.dex */
public abstract class AbstractC1363a {

    /* renamed from: a */
    private static C1662k f908a;
    protected final MaxAdFormat adFormat;
    protected final String adUnitId;
    protected final C1710r logger;
    protected final C1662k sdk;
    protected final String tag;
    protected MaxAdListener adListener = null;
    protected MaxAdRevenueListener revenueListener = null;
    protected final C1702i.C1704a loadRequestBuilder = new C1702i.C1704a();

    /* renamed from: com.applovin.impl.mediation.ads.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1364a extends MaxAdListener, MaxAdRevenueListener {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1363a(String str, MaxAdFormat maxAdFormat, String str2, C1662k c1662k) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = c1662k;
        this.tag = str2;
        this.logger = c1662k.m6588z();
    }

    public static void logApiCall(String str, String str2) {
        C1662k c1662k = f908a;
        if (c1662k != null) {
            c1662k.m6588z().m6319b(str, str2);
            return;
        }
        for (AppLovinSdk appLovinSdk : AppLovinSdk.m6086a()) {
            C1662k c1662k2 = appLovinSdk.coreSdk;
            if (!c1662k2.m6611e()) {
                c1662k2.m6588z().m6319b(str, str2);
                f908a = c1662k2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7673a(AbstractC1334a abstractC1334a) {
        C1757j c1757j = new C1757j();
        c1757j.m6200a().m6195a("MAX Ad").m6198a(abstractC1334a).m6200a();
        C1710r.m6313f(this.tag, c1757j.toString());
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        this.logger.m6319b(this.tag, str);
    }

    public void setExtraParameter(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        this.loadRequestBuilder.m6361a(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Setting listener: " + maxAdListener);
        this.adListener = maxAdListener;
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Setting revenue listener: " + maxAdRevenueListener);
        this.revenueListener = maxAdRevenueListener;
    }
}
