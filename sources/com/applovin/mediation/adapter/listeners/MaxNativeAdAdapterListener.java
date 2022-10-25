package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import android.view.View;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.nativeAds.MaxNativeAd;

/* loaded from: classes.dex */
public interface MaxNativeAdAdapterListener extends MaxAdapterListener {
    void onNativeAdClicked();

    void onNativeAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onNativeAdDisplayed(Bundle bundle);

    void onNativeAdLoadFailed(MaxAdapterError maxAdapterError);

    void onNativeAdLoaded(MaxNativeAd maxNativeAd, View view, Bundle bundle);
}
