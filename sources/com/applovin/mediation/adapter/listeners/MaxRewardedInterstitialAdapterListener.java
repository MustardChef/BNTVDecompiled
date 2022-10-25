package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapterError;

/* loaded from: classes.dex */
public interface MaxRewardedInterstitialAdapterListener extends MaxAdapterListener {
    void onRewardedInterstitialAdClicked();

    void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onRewardedInterstitialAdDisplayed();

    void onRewardedInterstitialAdDisplayed(Bundle bundle);

    void onRewardedInterstitialAdHidden();

    void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError);

    void onRewardedInterstitialAdLoaded();

    void onRewardedInterstitialAdLoaded(Bundle bundle);

    void onRewardedInterstitialAdVideoCompleted();

    void onRewardedInterstitialAdVideoStarted();

    void onUserRewarded(MaxReward maxReward);
}
