package com.applovin.sdk;

/* loaded from: classes.dex */
public interface AppLovinSdkConfiguration {

    /* loaded from: classes.dex */
    public enum ConsentDialogState {
        UNKNOWN,
        APPLIES,
        DOES_NOT_APPLY
    }

    ConsentDialogState getConsentDialogState();

    String getCountryCode();
}
