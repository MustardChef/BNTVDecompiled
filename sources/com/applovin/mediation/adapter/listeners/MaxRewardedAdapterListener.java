package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapterError;

/* loaded from: classes.dex */
public interface MaxRewardedAdapterListener extends MaxAdapterListener {
    void onRewardedAdClicked();

    void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onRewardedAdDisplayed();

    void onRewardedAdDisplayed(Bundle bundle);

    void onRewardedAdHidden();

    void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError);

    void onRewardedAdLoaded();

    void onRewardedAdLoaded(Bundle bundle);

    void onRewardedAdVideoCompleted();

    void onRewardedAdVideoStarted();

    void onUserRewarded(MaxReward maxReward);
}
