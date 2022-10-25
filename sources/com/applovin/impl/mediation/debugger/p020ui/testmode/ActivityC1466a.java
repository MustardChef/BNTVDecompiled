package com.applovin.impl.mediation.debugger.p020ui.testmode;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a */
/* loaded from: classes.dex */
public class ActivityC1466a extends ActivityC1414a implements AdControlButton.InterfaceC1464a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private C1407b f1269a;

    /* renamed from: b */
    private C1662k f1270b;

    /* renamed from: c */
    private MaxAdView f1271c;

    /* renamed from: d */
    private MaxAdView f1272d;

    /* renamed from: e */
    private MaxInterstitialAd f1273e;

    /* renamed from: f */
    private MaxRewardedInterstitialAd f1274f;

    /* renamed from: g */
    private MaxRewardedAd f1275g;

    /* renamed from: h */
    private String f1276h;

    /* renamed from: i */
    private AdControlButton f1277i;

    /* renamed from: j */
    private AdControlButton f1278j;

    /* renamed from: k */
    private AdControlButton f1279k;

    /* renamed from: l */
    private AdControlButton f1280l;

    /* renamed from: m */
    private AdControlButton f1281m;

    /* renamed from: a */
    private AdControlButton m7356a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.f1277i;
        }
        if (str.equals("test_mode_mrec")) {
            return this.f1278j;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.f1279k;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.f1280l;
        }
        if (str.equals(this.f1276h)) {
            return this.f1281m;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    /* renamed from: a */
    private void m7358a() {
        MaxAdFormat maxAdFormat;
        String str;
        boolean isTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(C1799R.C1802id.banner_ad_view_container);
        if (isTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(C1799R.C1802id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (!this.f1269a.m7514o().contains(maxAdFormat)) {
            findViewById(C1799R.C1802id.banner_control_view).setVisibility(8);
            frameLayout.setVisibility(8);
            return;
        }
        MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f1270b.m6664W(), this);
        this.f1271c = maxAdView;
        maxAdView.setListener(this);
        frameLayout.addView(this.f1271c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
        AdControlButton adControlButton = (AdControlButton) findViewById(C1799R.C1802id.banner_control_button);
        this.f1277i = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f1277i.setFormat(maxAdFormat);
    }

    /* renamed from: a */
    private void m7357a(MaxAdFormat maxAdFormat) {
        MaxAdView maxAdView;
        this.f1270b.m6679H().m7350a(this.f1269a.m7522g());
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            maxAdView = this.f1271c;
        } else if (MaxAdFormat.MREC != maxAdFormat) {
            if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.f1273e.loadAd();
                return;
            } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
                this.f1274f.loadAd();
                return;
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.f1275g.loadAd();
                return;
            } else {
                return;
            }
        } else {
            maxAdView = this.f1272d;
        }
        maxAdView.loadAd();
    }

    /* renamed from: b */
    private void m7355b() {
        FrameLayout frameLayout = (FrameLayout) findViewById(C1799R.C1802id.mrec_ad_view_container);
        if (!this.f1269a.m7514o().contains(MaxAdFormat.MREC)) {
            findViewById(C1799R.C1802id.mrec_control_view).setVisibility(8);
            frameLayout.setVisibility(8);
            return;
        }
        MaxAdView maxAdView = new MaxAdView("test_mode_mrec", MaxAdFormat.MREC, this.f1270b.m6664W(), this);
        this.f1272d = maxAdView;
        maxAdView.setListener(this);
        frameLayout.addView(this.f1272d, new FrameLayout.LayoutParams(-1, -1));
        AdControlButton adControlButton = (AdControlButton) findViewById(C1799R.C1802id.mrec_control_button);
        this.f1278j = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f1278j.setFormat(MaxAdFormat.MREC);
    }

    /* renamed from: b */
    private void m7354b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f1273e.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f1274f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f1275g.showAd();
        }
    }

    /* renamed from: c */
    private void m7353c() {
        if (!this.f1269a.m7514o().contains(MaxAdFormat.INTERSTITIAL)) {
            findViewById(C1799R.C1802id.interstitial_control_view).setVisibility(8);
            return;
        }
        MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f1270b.m6664W(), this);
        this.f1273e = maxInterstitialAd;
        maxInterstitialAd.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(C1799R.C1802id.interstitial_control_button);
        this.f1279k = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f1279k.setFormat(MaxAdFormat.INTERSTITIAL);
    }

    /* renamed from: d */
    private void m7352d() {
        if (!this.f1269a.m7514o().contains(MaxAdFormat.REWARDED)) {
            findViewById(C1799R.C1802id.rewarded_control_view).setVisibility(8);
            return;
        }
        String str = "test_mode_rewarded_" + this.f1269a.m7522g();
        this.f1276h = str;
        MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(str, this.f1270b.m6664W(), this);
        this.f1275g = maxRewardedAd;
        maxRewardedAd.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(C1799R.C1802id.rewarded_control_button);
        this.f1281m = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f1281m.setFormat(MaxAdFormat.REWARDED);
    }

    public void initialize(C1407b c1407b) {
        this.f1269a = c1407b;
        this.f1270b = c1407b.m7510s();
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        AdControlButton m7356a = m7356a(maxAd.getAdUnitId());
        m7356a.setControlState(AdControlButton.EnumC1465b.LOAD);
        Utils.showAlert("", "Failed to display " + m7356a.getFormat().getDisplayName() + " with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd maxAd) {
        Utils.showToast("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(MaxAd maxAd) {
        Utils.showToast("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd maxAd) {
        Utils.showToast("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton m7356a = m7356a(str);
        m7356a.setControlState(AdControlButton.EnumC1465b.LOAD);
        Utils.showAlert("", "Failed to load " + m7356a.getFormat().getLabel() + " with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd maxAd) {
        m7356a(maxAd.getAdUnitId()).setControlState(maxAd.getFormat().isAdViewAd() ? AdControlButton.EnumC1465b.LOAD : AdControlButton.EnumC1465b.SHOW);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.testmode.AdControlButton.InterfaceC1464a
    public void onClick(AdControlButton adControlButton) {
        if (AdControlButton.EnumC1465b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.EnumC1465b.LOADING);
            m7357a(adControlButton.getFormat());
        } else if (AdControlButton.EnumC1465b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.EnumC1465b.LOAD);
            m7354b(adControlButton.getFormat());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f1269a == null) {
            C1710r.m6310i("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(C1799R.C1803layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f1269a.m7521h() + " Test Ads");
        m7358a();
        m7355b();
        m7353c();
        m7352d();
        findViewById(C1799R.C1802id.rewarded_interstitial_control_view).setVisibility(8);
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1270b.m6679H().m7350a((String) null);
        MaxAdView maxAdView = this.f1271c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f1272d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f1273e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f1275g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoCompleted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoCompleted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoStarted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoStarted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        Utils.showToast("onUserRewarded", maxAd, this);
    }
}
