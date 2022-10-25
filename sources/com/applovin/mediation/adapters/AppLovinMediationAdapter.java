package com.applovin.mediation.adapters;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.AppLovinRewardedInterstitialAd;
import com.applovin.impl.mediation.MaxRewardImpl;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxRewardedInterstitialAdapter, MaxSignalProvider {
    private AppLovinAdView mLoadedAdView;
    private AppLovinAd mLoadedInterstitialAd;
    private AppLovinAd mLoadedRewardedAd;
    private AppLovinAd mLoadedRewardedInterstitialAd;
    private MaxReward mPendingReward;

    /* renamed from: com.applovin.mediation.adapters.AppLovinMediationAdapter$1 */
    /* loaded from: classes.dex */
    class C17861 implements AppLovinAdLoadListener {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ MaxAdFormat val$adFormat;
        final /* synthetic */ MaxAdViewAdapterListener val$listener;

        C17861(MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
            this.val$adFormat = maxAdFormat;
            this.val$activity = activity;
            this.val$listener = maxAdViewAdapterListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log(this.val$adFormat.getLabel() + " ad loaded");
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AppLovinMediationAdapter.this.mLoadedAdView = new AppLovinAdView(AppLovinMediationAdapter.this.getWrappingSdk(), appLovinAd.getSize(), C17861.this.val$activity);
                    AppLovinMediationAdapter.this.mLoadedAdView.setAdDisplayListener(new AppLovinAdDisplayListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.1.1.1
                        @Override // com.applovin.sdk.AppLovinAdDisplayListener
                        public void adDisplayed(AppLovinAd appLovinAd2) {
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad shown");
                            C17861.this.val$listener.onAdViewAdDisplayed();
                        }

                        @Override // com.applovin.sdk.AppLovinAdDisplayListener
                        public void adHidden(AppLovinAd appLovinAd2) {
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad hidden");
                            C17861.this.val$listener.onAdViewAdHidden();
                        }
                    });
                    AppLovinMediationAdapter.this.mLoadedAdView.setAdClickListener(new AppLovinAdClickListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.1.1.2
                        @Override // com.applovin.sdk.AppLovinAdClickListener
                        public void adClicked(AppLovinAd appLovinAd2) {
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad clicked");
                            C17861.this.val$listener.onAdViewAdClicked();
                        }
                    });
                    AppLovinMediationAdapter.this.mLoadedAdView.setAdViewEventListener(new AppLovinAdViewEventListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.1.1.3
                        @Override // com.applovin.adview.AppLovinAdViewEventListener
                        public void adClosedFullscreen(AppLovinAd appLovinAd2, AppLovinAdView appLovinAdView) {
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad collapsed");
                            C17861.this.val$listener.onAdViewAdCollapsed();
                        }

                        @Override // com.applovin.adview.AppLovinAdViewEventListener
                        public void adFailedToDisplay(AppLovinAd appLovinAd2, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
                            MaxAdapterError maxError = AppLovinMediationAdapter.toMaxError(appLovinAdViewDisplayErrorCode);
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad failed to display with error: " + maxError);
                            C17861.this.val$listener.onAdViewAdDisplayFailed(maxError);
                        }

                        @Override // com.applovin.adview.AppLovinAdViewEventListener
                        public void adLeftApplication(AppLovinAd appLovinAd2, AppLovinAdView appLovinAdView) {
                        }

                        @Override // com.applovin.adview.AppLovinAdViewEventListener
                        public void adOpenedFullscreen(AppLovinAd appLovinAd2, AppLovinAdView appLovinAdView) {
                            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                            appLovinMediationAdapter2.log(C17861.this.val$adFormat.getLabel() + " ad expanded");
                            C17861.this.val$listener.onAdViewAdExpanded();
                        }
                    });
                    C17861.this.val$listener.onAdViewAdLoaded(AppLovinMediationAdapter.this.mLoadedAdView);
                    AppLovinMediationAdapter.this.mLoadedAdView.renderAd(appLovinAd);
                }
            });
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log(this.val$adFormat.getLabel() + " ad failed to load with error code: " + i);
            this.val$listener.onAdViewAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
        }
    }

    /* loaded from: classes.dex */
    private abstract class RewardListenerWrapper implements AppLovinAdRewardListener {
        protected boolean isFullyWatched;

        private RewardListenerWrapper() {
        }

        /* synthetic */ RewardListenerWrapper(AppLovinMediationAdapter appLovinMediationAdapter, C17861 c17861) {
            this();
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("User declined to view rewarded ad");
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("User is over quota: " + map);
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Reward rejected: " + map);
            AppLovinMediationAdapter.this.mPendingReward = null;
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            String str = map.get("currency");
            String str2 = map.get(AppLovinEventParameters.REVENUE_AMOUNT);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                AppLovinMediationAdapter.this.mPendingReward = MaxRewardImpl.createDefault();
            } else {
                int i = 0;
                try {
                    i = (int) Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log("Failed to parse AppLovin reward amount: " + str2, e);
                }
                AppLovinMediationAdapter.this.mPendingReward = MaxRewardImpl.create(i, str);
            }
            AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
            appLovinMediationAdapter2.log("Rewarded verified: " + AppLovinMediationAdapter.this.mPendingReward);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Reward validation request failed with code: " + i);
            AppLovinMediationAdapter.this.mPendingReward = null;
        }
    }

    /* loaded from: classes.dex */
    private class RewardedAdListenerWrapper extends RewardListenerWrapper implements InterfaceC1544i, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private final MaxRewardedAdapterListener listener;

        private RewardedAdListenerWrapper(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            super(AppLovinMediationAdapter.this, null);
            this.listener = maxRewardedAdapterListener;
        }

        /* synthetic */ RewardedAdListenerWrapper(AppLovinMediationAdapter appLovinMediationAdapter, MaxRewardedAdapterListener maxRewardedAdapterListener, C17861 c17861) {
            this(maxRewardedAdapterListener);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad clicked");
            this.listener.onRewardedAdClicked();
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad shown");
            this.listener.onRewardedAdDisplayed();
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            if ((this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded user with reward: " + AppLovinMediationAdapter.this.mPendingReward);
                this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
                AppLovinMediationAdapter.this.mPendingReward = null;
            }
            AppLovinMediationAdapter.this.log("Rewarded ad hidden");
            this.listener.onRewardedAdHidden();
        }

        @Override // com.applovin.impl.sdk.p027a.InterfaceC1544i
        public void onAdDisplayFailed(String str) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded ad failed to display with error: " + str);
            this.listener.onRewardedAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded ad video started");
            this.listener.onRewardedAdVideoStarted();
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded ad video ended at " + d + "% and is fully watched: " + z);
            this.isFullyWatched = z;
            this.listener.onRewardedAdVideoCompleted();
        }
    }

    /* loaded from: classes.dex */
    private class RewardedInterstitialAdListenerWrapper extends RewardListenerWrapper implements InterfaceC1544i, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private final MaxRewardedInterstitialAdapterListener listener;

        private RewardedInterstitialAdListenerWrapper(MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
            super(AppLovinMediationAdapter.this, null);
            this.listener = maxRewardedInterstitialAdapterListener;
        }

        /* synthetic */ RewardedInterstitialAdListenerWrapper(AppLovinMediationAdapter appLovinMediationAdapter, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener, C17861 c17861) {
            this(maxRewardedInterstitialAdapterListener);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad clicked");
            this.listener.onRewardedInterstitialAdClicked();
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad shown");
            this.listener.onRewardedInterstitialAdDisplayed();
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            if ((this.isFullyWatched && AppLovinMediationAdapter.this.mPendingReward != null) || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded interstitial user with reward: " + AppLovinMediationAdapter.this.mPendingReward);
                this.listener.onUserRewarded(AppLovinMediationAdapter.this.mPendingReward);
                AppLovinMediationAdapter.this.mPendingReward = null;
            }
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad hidden");
            this.listener.onRewardedInterstitialAdHidden();
        }

        @Override // com.applovin.impl.sdk.p027a.InterfaceC1544i
        public void onAdDisplayFailed(String str) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded interstitial ad failed to display with error: " + str);
            this.listener.onRewardedInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AppLovinMediationAdapter.this.log("Rewarded interstitial ad video started");
            this.listener.onRewardedInterstitialAdVideoStarted();
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
            appLovinMediationAdapter.log("Rewarded interstitial ad video ended at " + d + "% and is fully watched: " + z);
            this.isFullyWatched = z;
            this.listener.onRewardedInterstitialAdVideoCompleted();
        }
    }

    public AppLovinMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    private void loadFullscreenAd(String str, MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, final MaxAdapterListener maxAdapterListener) {
        AppLovinAdLoadListener appLovinAdLoadListener = new AppLovinAdLoadListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.4
            @Override // com.applovin.sdk.AppLovinAdLoadListener
            public void adReceived(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad loaded");
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    AppLovinMediationAdapter.this.mLoadedInterstitialAd = appLovinAd;
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoaded();
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    AppLovinMediationAdapter.this.mLoadedRewardedAd = appLovinAd;
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoaded();
                } else if (maxAdFormat != MaxAdFormat.REWARDED_INTERSTITIAL) {
                    throw new IllegalStateException("Non-fullscreen ad loaded for fullscreen ad adapter");
                } else {
                    AppLovinMediationAdapter.this.mLoadedRewardedInterstitialAd = appLovinAd;
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoaded();
                }
            }

            @Override // com.applovin.sdk.AppLovinAdLoadListener
            public void failedToReceiveAd(int i) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to load with error code: " + i);
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                } else if (maxAdFormat != MaxAdFormat.REWARDED_INTERSTITIAL) {
                    throw new IllegalStateException("Non-fullscreen ad failed to load for fullscreen ad adapter");
                } else {
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i));
                }
            }
        };
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), appLovinAdLoadListener);
        } else if (TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            log("Loading mediated " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForZoneId(str, appLovinAdLoadListener);
        } else {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + "...");
            getWrappingSdk().getAdService().loadNextAdForZoneId(maxAdapterResponseParameters.getThirdPartyAdPlacementId(), appLovinAdLoadListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(int i) {
        int i2 = 204;
        if (i == -1009) {
            i2 = MaxAdapterError.ERROR_CODE_NO_CONNECTION;
        } else if (i != 204) {
            i2 = i == -1 ? MaxAdapterError.ERROR_CODE_INTERNAL_ERROR : i >= 500 ? MaxAdapterError.ERROR_CODE_SERVER_ERROR : MaxAdapterError.ERROR_CODE_UNSPECIFIED;
        }
        return new MaxAdapterError(i2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        return MaxAdapterError.UNSPECIFIED;
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        log("Collecting signal...");
        maxSignalCollectionListener.onSignalCollected(getWrappingSdk().getAdService().getBidToken());
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return getSdkVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        C17861 c17861 = new C17861(maxAdFormat, activity, maxAdViewAdapterListener);
        if (!TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), c17861);
        } else if (!TextUtils.isEmpty(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + "...");
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, c17861);
        } else {
            AppLovinAdSize appLovinAdSize = null;
            if (maxAdFormat == MaxAdFormat.BANNER) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            } else if (maxAdFormat == MaxAdFormat.MREC) {
                appLovinAdSize = AppLovinAdSize.MREC;
            } else if (maxAdFormat == MaxAdFormat.LEADER) {
                appLovinAdSize = AppLovinAdSize.LEADER;
            }
            if (appLovinAdSize == null) {
                log("Failed to load ad for format: " + maxAdFormat);
                maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
                return;
            }
            log("Loading mediated " + maxAdFormat.getLabel() + " ad...");
            getWrappingSdk().getAdService().loadNextAd(appLovinAdSize, c17861);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        loadFullscreenAd("inter_regular", maxAdapterResponseParameters, MaxAdFormat.INTERSTITIAL, maxInterstitialAdapterListener);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        loadFullscreenAd("inter_videoa", maxAdapterResponseParameters, MaxAdFormat.REWARDED, maxRewardedAdapterListener);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter
    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        loadFullscreenAd("inter_autorew", maxAdapterResponseParameters, MaxAdFormat.REWARDED_INTERSTITIAL, maxRewardedInterstitialAdapterListener);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        this.mLoadedInterstitialAd = null;
        this.mLoadedRewardedAd = null;
        this.mLoadedRewardedInterstitialAd = null;
        AppLovinAdView appLovinAdView = this.mLoadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.mLoadedAdView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        log("Showing interstitial: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        create.setAdDisplayListener(new InterfaceC1544i() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.2
            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adDisplayed(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad shown");
                maxInterstitialAdapterListener.onInterstitialAdDisplayed();
            }

            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adHidden(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad hidden");
                maxInterstitialAdapterListener.onInterstitialAdHidden();
            }

            @Override // com.applovin.impl.sdk.p027a.InterfaceC1544i
            public void onAdDisplayFailed(String str) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Interstitial ad failed to display with error: " + str);
                maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
            }
        });
        create.setAdClickListener(new AppLovinAdClickListener() { // from class: com.applovin.mediation.adapters.AppLovinMediationAdapter.3
            @Override // com.applovin.sdk.AppLovinAdClickListener
            public void adClicked(AppLovinAd appLovinAd) {
                AppLovinMediationAdapter.this.log("Interstitial ad clicked");
                maxInterstitialAdapterListener.onInterstitialAdClicked();
            }
        });
        create.showAndRender(this.mLoadedInterstitialAd);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        log("Showing rewarded ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardedAdListenerWrapper rewardedAdListenerWrapper = new RewardedAdListenerWrapper(this, maxRewardedAdapterListener, null);
        create.show(this.mLoadedRewardedAd, activity, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper);
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter
    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        log("Showing rewarded interstitial ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        RewardedInterstitialAdListenerWrapper rewardedInterstitialAdListenerWrapper = new RewardedInterstitialAdListenerWrapper(this, maxRewardedInterstitialAdapterListener, null);
        if (this.mLoadedRewardedInterstitialAd.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            configureReward(maxAdapterResponseParameters);
            AppLovinRewardedInterstitialAd appLovinRewardedInterstitialAd = new AppLovinRewardedInterstitialAd(getWrappingSdk());
            appLovinRewardedInterstitialAd.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdClickListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.show(this.mLoadedRewardedInterstitialAd, activity, rewardedInterstitialAdListenerWrapper);
            return;
        }
        log("Rewarded interstitial is regular interstitial");
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        create.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
        create.setAdClickListener(rewardedInterstitialAdListenerWrapper);
        create.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
        create.showAndRender(this.mLoadedRewardedInterstitialAd);
    }
}
