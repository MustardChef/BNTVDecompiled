package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1648h;
import com.applovin.impl.sdk.C1710r;

/* loaded from: classes.dex */
public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "hasUserConsent()");
        Boolean m6713a = C1648h.m6718b().m6713a(context);
        if (m6713a != null) {
            return m6713a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "isAgeRestrictedUser()");
        Boolean m6713a = C1648h.m6723a().m6713a(context);
        if (m6713a != null) {
            return m6713a.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSell(Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "isDoNotSell()");
        Boolean m6713a = C1648h.m6716c().m6713a(context);
        if (m6713a != null) {
            return m6713a.booleanValue();
        }
        return false;
    }

    public static void setDoNotSell(boolean z, Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "setDoNotSell()");
        if (C1648h.m6715c(z, context)) {
            AppLovinSdk.reinitializeAll(null, null, Boolean.valueOf(z));
        }
    }

    public static void setHasUserConsent(boolean z, Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "setHasUserConsent()");
        if (C1648h.m6717b(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), null, null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        C1710r.m6313f("AppLovinPrivacySettings", "setIsAgeRestrictedUser()");
        if (C1648h.m6719a(z, context)) {
            AppLovinSdk.reinitializeAll(null, Boolean.valueOf(z), null);
        }
    }
}
