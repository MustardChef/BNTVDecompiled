package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinUserSegment;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e */
/* loaded from: classes.dex */
public class C1588e implements AppLovinUserSegment {

    /* renamed from: a */
    private String f2056a;

    @Override // com.applovin.sdk.AppLovinUserSegment
    public String getName() {
        return this.f2056a;
    }

    @Override // com.applovin.sdk.AppLovinUserSegment
    public void setName(String str) {
        if (str != null) {
            if (str.length() > 32) {
                C1710r.m6310i("AppLovinUserSegment", "Setting name greater than 32 characters: " + str);
            }
            if (!StringUtils.isAlphaNumeric(str)) {
                C1710r.m6310i("AppLovinUserSegment", "Setting name that is not alphanumeric: " + str);
            }
        }
        this.f2056a = str;
    }

    public String toString() {
        return "AppLovinUserSegment{name=" + getName() + '}';
    }
}
