package com.phimhd;

import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.blankj.utilcode.util.LogUtils;
import com.bongngotv2.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdsActivity.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m107d2 = {"Lcom/phimhd/AdsActivity;", "Lcom/phimhd/BaseActivity;", "()V", "countDownTimer30MinAds", "Landroid/os/CountDownTimer;", "countDownTimerAds", "mInterstitialAd", "Lcom/applovin/mediation/ads/MaxInterstitialAd;", "mInterstitialDownloadAd", "retryAttemptFullScreen", "", "retryAttemptFullScreenDownload", "tvTimeAds", "Landroid/widget/TextView;", "initAds", "", "initTvTimeCountdonwAds", "initVariables", "initViews", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "releaseCountdownAds", "showFullscreenAds", "showFullscreenDownloadAds", "startCountDownAds", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class AdsActivity extends BaseActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private CountDownTimer countDownTimer30MinAds;
    private CountDownTimer countDownTimerAds;
    private MaxInterstitialAd mInterstitialAd;
    private MaxInterstitialAd mInterstitialDownloadAd;
    private int retryAttemptFullScreen;
    private int retryAttemptFullScreenDownload;
    private TextView tvTimeAds;

    @Override // com.phimhd.BaseActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.phimhd.BaseActivity
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public abstract TextView initTvTimeCountdonwAds();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity
    public void initViews() {
        this.tvTimeAds = initTvTimeCountdonwAds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity
    public void initVariables() {
        initAds();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 2 || newConfig.orientation == 1) {
            MaxInterstitialAd maxInterstitialAd = this.mInterstitialAd;
            if (maxInterstitialAd != null) {
                maxInterstitialAd.loadAd();
            }
            Log.d("DuongKK", "Start Load Ad INTER");
        }
    }

    protected void initAds() {
        AdsActivity adsActivity = this;
        this.mInterstitialAd = new MaxInterstitialAd(Constants.APPLOVIN_UNIT_ID_ADS_INTERSTITIAL_MOVIE, adsActivity);
        this.mInterstitialDownloadAd = new MaxInterstitialAd("f6489886b41a475c", adsActivity);
        MaxInterstitialAd maxInterstitialAd = this.mInterstitialAd;
        Intrinsics.checkNotNull(maxInterstitialAd);
        maxInterstitialAd.setListener(new AdsActivity$initAds$1(this));
        MaxInterstitialAd maxInterstitialAd2 = this.mInterstitialDownloadAd;
        Intrinsics.checkNotNull(maxInterstitialAd2);
        maxInterstitialAd2.setListener(new AdsActivity$initAds$2(this));
        this.countDownTimerAds = new CountDownTimer() { // from class: com.phimhd.AdsActivity$initAds$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(300000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                int i = ((int) j) / 1000;
                Log.d("du", "Sec " + i);
                if (i <= 5) {
                    textView = AdsActivity.this.tvTimeAds;
                    if (textView != null) {
                        textView2 = AdsActivity.this.tvTimeAds;
                        Intrinsics.checkNotNull(textView2);
                        textView2.setVisibility(0);
                        textView3 = AdsActivity.this.tvTimeAds;
                        Intrinsics.checkNotNull(textView3);
                        textView3.setText(AdsActivity.this.getString(R.string.ads_will_show_after, new Object[]{Integer.valueOf(i)}));
                    }
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView;
                CountDownTimer countDownTimer;
                TextView textView2;
                textView = AdsActivity.this.tvTimeAds;
                if (textView != null) {
                    textView2 = AdsActivity.this.tvTimeAds;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setVisibility(4);
                }
                LogUtils.m6080d("onFinish countDownTimerAds- WEB EMBED", new Object[0]);
                AdsActivity.this.showFullscreenAds();
                countDownTimer = AdsActivity.this.countDownTimer30MinAds;
                Intrinsics.checkNotNull(countDownTimer);
                countDownTimer.start();
            }
        };
        this.countDownTimer30MinAds = new CountDownTimer() { // from class: com.phimhd.AdsActivity$initAds$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(Constants.TIME_30MIN_TO_SHOW_ADS, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                int i = ((int) j) / 1000;
                if (i <= 5) {
                    textView = AdsActivity.this.tvTimeAds;
                    if (textView != null) {
                        textView2 = AdsActivity.this.tvTimeAds;
                        Intrinsics.checkNotNull(textView2);
                        textView2.setVisibility(0);
                        textView3 = AdsActivity.this.tvTimeAds;
                        Intrinsics.checkNotNull(textView3);
                        textView3.setText("Quảng cáo sẽ xuất hiện sau " + i + 's');
                    }
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView;
                CountDownTimer countDownTimer;
                TextView textView2;
                textView = AdsActivity.this.tvTimeAds;
                if (textView != null) {
                    textView2 = AdsActivity.this.tvTimeAds;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setVisibility(4);
                }
                LogUtils.m6080d("onFinish countDownTimer30MinAds- WEB EMBED", new Object[0]);
                AdsActivity.this.showFullscreenAds();
                countDownTimer = AdsActivity.this.countDownTimer30MinAds;
                Intrinsics.checkNotNull(countDownTimer);
                countDownTimer.start();
            }
        };
        MaxInterstitialAd maxInterstitialAd3 = this.mInterstitialAd;
        if (maxInterstitialAd3 != null) {
            maxInterstitialAd3.loadAd();
        }
        Log.d("DuongKK", "Start Load Ad INTER");
    }

    public void showFullscreenAds() {
        MaxInterstitialAd maxInterstitialAd = this.mInterstitialAd;
        if (maxInterstitialAd != null) {
            Intrinsics.checkNotNull(maxInterstitialAd);
            if (maxInterstitialAd.isReady()) {
                LogUtils.m6080d("showFullscreenAds - WEB EMBED", new Object[0]);
                MaxInterstitialAd maxInterstitialAd2 = this.mInterstitialAd;
                if (maxInterstitialAd2 != null) {
                    maxInterstitialAd2.showAd();
                    return;
                }
                return;
            }
        }
        LogUtils.m6080d("Ads fullscreen not load yet", new Object[0]);
    }

    public void showFullscreenDownloadAds() {
        MaxInterstitialAd maxInterstitialAd = this.mInterstitialDownloadAd;
        if (maxInterstitialAd != null) {
            Intrinsics.checkNotNull(maxInterstitialAd);
            if (maxInterstitialAd.isReady()) {
                LogUtils.m6080d("DuongKK", "showFullscreenAds mInterstitialDownloadAd - WEB EMBED");
                MaxInterstitialAd maxInterstitialAd2 = this.mInterstitialDownloadAd;
                if (maxInterstitialAd2 != null) {
                    maxInterstitialAd2.showAd();
                    return;
                }
                return;
            }
        }
        LogUtils.m6080d("DuongKK", "Ads fullscreen mInterstitialDownloadAd not load yet");
    }

    public void startCountDownAds() {
        if (this.countDownTimerAds != null) {
            AppController companion = AppController.Companion.getInstance();
            if ((companion != null ? companion.getKey() : null) != null) {
                AppController companion2 = AppController.Companion.getInstance();
                Key key = companion2 != null ? companion2.getKey() : null;
                if (key == null || !key.isExpired()) {
                    return;
                }
                CountDownTimer countDownTimer = this.countDownTimer30MinAds;
                if (countDownTimer != null && countDownTimer != null) {
                    countDownTimer.cancel();
                }
                CountDownTimer countDownTimer2 = this.countDownTimerAds;
                if (countDownTimer2 != null) {
                    countDownTimer2.start();
                }
                Log.d("DuongKK", "start Countdownads");
                return;
            }
            CountDownTimer countDownTimer3 = this.countDownTimer30MinAds;
            if (countDownTimer3 != null && countDownTimer3 != null) {
                countDownTimer3.cancel();
            }
            CountDownTimer countDownTimer4 = this.countDownTimerAds;
            if (countDownTimer4 != null) {
                countDownTimer4.start();
            }
            Log.d("DuongKK", "start Countdownads");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        releaseCountdownAds();
        super.onDestroy();
    }

    public void releaseCountdownAds() {
        CountDownTimer countDownTimer = this.countDownTimer30MinAds;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.countDownTimerAds;
        if (countDownTimer2 != null && countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        Log.d("DuongKK", "Release Countdownads");
    }
}
