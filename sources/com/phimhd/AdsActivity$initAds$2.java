package com.phimhd;

import android.os.Handler;
import android.util.Log;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdsActivity.kt */
@Metadata(m108d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, m107d2 = {"com/phimhd/AdsActivity$initAds$2", "Lcom/applovin/mediation/MaxAdListener;", "onAdClicked", "", "ad", "Lcom/applovin/mediation/MaxAd;", "onAdDisplayFailed", "error", "Lcom/applovin/mediation/MaxError;", "onAdDisplayed", "onAdHidden", "onAdLoadFailed", "adUnitId", "", "onAdLoaded", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class AdsActivity$initAds$2 implements MaxAdListener {
    final /* synthetic */ AdsActivity this$0;

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdsActivity$initAds$2(AdsActivity adsActivity) {
        this.this$0 = adsActivity;
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.this$0.retryAttemptFullScreenDownload = 0;
        Log.d("DuongKK", "LOADED ADS INTER");
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd ad) {
        MaxInterstitialAd maxInterstitialAd;
        Intrinsics.checkNotNullParameter(ad, "ad");
        maxInterstitialAd = this.this$0.mInterstitialDownloadAd;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.loadAd();
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String adUnitId, MaxError error) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(error, "error");
        AdsActivity adsActivity = this.this$0;
        i = adsActivity.retryAttemptFullScreenDownload;
        adsActivity.retryAttemptFullScreenDownload = i + 1;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        i2 = this.this$0.retryAttemptFullScreenDownload;
        long millis = timeUnit.toMillis((long) Math.pow(2.0d, Math.min(6, i2)));
        Handler handler = new Handler();
        final AdsActivity adsActivity2 = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.phimhd.-$$Lambda$AdsActivity$initAds$2$e6XTBeVOliQ4UlYHBlay58reFUU
            @Override // java.lang.Runnable
            public final void run() {
                AdsActivity$initAds$2.m9032onAdLoadFailed$lambda0(AdsActivity.this);
            }
        }, millis);
        Log.d("DuongKK", "LOADED FAIL INTER " + error.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        r1 = r1.mInterstitialDownloadAd;
     */
    /* renamed from: onAdLoadFailed$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m9032onAdLoadFailed$lambda0(com.phimhd.AdsActivity r1) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.applovin.mediation.ads.MaxInterstitialAd r0 = com.phimhd.AdsActivity.access$getMInterstitialDownloadAd$p(r1)
            if (r0 == 0) goto L14
            com.applovin.mediation.ads.MaxInterstitialAd r1 = com.phimhd.AdsActivity.access$getMInterstitialDownloadAd$p(r1)
            if (r1 == 0) goto L14
            r1.loadAd()
        L14:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phimhd.AdsActivity$initAds$2.m9032onAdLoadFailed$lambda0(com.phimhd.AdsActivity):void");
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {
        MaxInterstitialAd maxInterstitialAd;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(error, "error");
        maxInterstitialAd = this.this$0.mInterstitialDownloadAd;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.loadAd();
        }
    }
}
