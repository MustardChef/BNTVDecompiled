package com.applovin.mediation.adapters;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.mediation.MaxRewardImpl;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;

/* loaded from: classes.dex */
public abstract class MediationAdapterBase implements MaxAdapter {
    private boolean alwaysRewardUser;
    private final C1710r mLogger;
    private final C1662k mSdk;
    private final String mTag;
    private final AppLovinSdk mWrappingSdk;
    private MaxReward reward;

    public MediationAdapterBase(AppLovinSdk appLovinSdk) {
        this.mWrappingSdk = appLovinSdk;
        C1662k c1662k = appLovinSdk.coreSdk;
        this.mSdk = c1662k;
        this.mLogger = c1662k.m6588z();
        this.mTag = getClass().getSimpleName();
    }

    protected static String mediationTag() {
        return "AppLovinSdk_" + AppLovinSdk.VERSION;
    }

    protected void checkActivities(Context context, Class<?>... clsArr) {
    }

    protected void checkExistence(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            return;
        }
        for (Class<?> cls : clsArr) {
            log("Found: " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void configureReward(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        this.alwaysRewardUser = BundleUtils.getBoolean("always_reward_user", maxAdapterResponseParameters.isTesting(), serverParameters);
        int i = BundleUtils.getInt(AppLovinEventParameters.REVENUE_AMOUNT, 0, serverParameters);
        String string = BundleUtils.getString("currency", "", serverParameters);
        log("Creating reward: " + i + " " + string);
        this.reward = MaxRewardImpl.create(i, string);
    }

    /* renamed from: d */
    protected void m6103d(String str) {
        this.mLogger.m6319b(this.mTag, str);
    }

    /* renamed from: e */
    protected void m6102e(String str) {
        this.mLogger.m6314e(this.mTag, str);
    }

    /* renamed from: e */
    protected void m6101e(String str, Throwable th) {
        this.mLogger.m6318b(this.mTag, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MaxReward getReward() {
        MaxReward maxReward = this.reward;
        return maxReward != null ? maxReward : MaxRewardImpl.createDefault();
    }

    String getVersionString(Class cls, String str) {
        String string = Utils.getString(cls, str);
        if (string == null) {
            log("Failed to retrieve version string.");
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppLovinSdk getWrappingSdk() {
        return this.mWrappingSdk;
    }

    /* renamed from: i */
    protected void m6100i(String str) {
        this.mLogger.m6317c(this.mTag, str);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public boolean isBeta() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void log(String str) {
        this.mLogger.m6317c(this.mTag, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void log(String str, Throwable th) {
        this.mLogger.m6318b(this.mTag, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldAlwaysRewardUser() {
        return this.alwaysRewardUser;
    }

    protected void userError(String str) {
        userError(str, null);
    }

    protected void userError(String str, Throwable th) {
        C1710r.m6316c(this.mTag, str, th);
    }

    /* renamed from: w */
    protected void m6099w(String str) {
        this.mLogger.m6315d(this.mTag, str);
    }
}
