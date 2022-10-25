package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p031e.C1601g;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

/* loaded from: classes.dex */
public class PostbackServiceImpl implements AppLovinPostbackService {

    /* renamed from: a */
    private final C1662k f2349a;

    public PostbackServiceImpl(C1662k c1662k) {
        this.f2349a = c1662k;
    }

    @Override // com.applovin.sdk.AppLovinPostbackService
    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(C1700h.m6399b(this.f2349a).mo6391a(str).mo6378c(false).mo6395a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(C1700h c1700h, C1620o.EnumC1622a enumC1622a, AppLovinPostbackListener appLovinPostbackListener) {
        this.f2349a.m6670Q().m6793a(new C1601g(c1700h, enumC1622a, this.f2349a, appLovinPostbackListener), enumC1622a);
    }

    public void dispatchPostbackRequest(C1700h c1700h, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(c1700h, C1620o.EnumC1622a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
