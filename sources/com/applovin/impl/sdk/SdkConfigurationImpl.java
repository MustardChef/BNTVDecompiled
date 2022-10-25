package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.sdk.AppLovinSdkConfiguration;

/* loaded from: classes.dex */
public class SdkConfigurationImpl implements AppLovinSdkConfiguration {

    /* renamed from: a */
    private final C1662k f1454a;

    public SdkConfigurationImpl(C1662k c1662k) {
        this.f1454a = c1662k;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public AppLovinSdkConfiguration.ConsentDialogState getConsentDialogState() {
        String str = (String) this.f1454a.m6656a(C1568b.f1880eQ);
        return "applies".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.APPLIES : "does_not_apply".equalsIgnoreCase(str) ? AppLovinSdkConfiguration.ConsentDialogState.DOES_NOT_APPLY : AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN;
    }

    @Override // com.applovin.sdk.AppLovinSdkConfiguration
    public String getCountryCode() {
        return (String) this.f1454a.m6656a(C1568b.f1881eR);
    }

    public String toString() {
        return "AppLovinSdkConfiguration{consentDialogState=" + getConsentDialogState() + ", countryCode=" + getCountryCode() + '}';
    }
}
