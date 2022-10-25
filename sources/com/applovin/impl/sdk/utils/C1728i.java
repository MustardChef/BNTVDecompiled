package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.i */
/* loaded from: classes.dex */
public class C1728i {
    /* renamed from: a */
    public static void m6242a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdViewEventListener.this.adOpenedFullscreen(C1728i.m6217b(appLovinAd), appLovinAdView);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6241a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdViewEventListener.this.adFailedToDisplay(C1728i.m6217b(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6240a(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6235a(maxAdListener, maxAd, false);
    }

    /* renamed from: a */
    public static void m6239a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        m6238a(maxAdListener, maxAd, maxError, false);
    }

    /* renamed from: a */
    public static void m6238a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, boolean z) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdDisplayFailed(maxAd, maxError);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6237a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        m6236a(maxAdListener, maxAd, maxReward, false);
    }

    /* renamed from: a */
    public static void m6236a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, boolean z) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((MaxRewardedAdListener) MaxAdListener.this).onUserRewarded(maxAd, maxReward);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6235a(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdLoaded(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6234a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        m6233a(maxAdListener, str, maxError, false);
    }

    /* renamed from: a */
    public static void m6233a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, boolean z) {
        if (str == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdLoadFailed(str, maxError);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6232a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        m6231a(maxAdRevenueListener, maxAd, false);
    }

    /* renamed from: a */
    public static void m6231a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || maxAdRevenueListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdRevenueListener.this.onAdRevenuePaid(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad revenue being paid", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6229a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdClickListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdClickListener.this.adClicked(C1728i.m6217b(appLovinAd));
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6228a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdDisplayListener.this.adDisplayed(C1728i.m6217b(appLovinAd));
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6227a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof InterfaceC1544i) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.1
                @Override // java.lang.Runnable
                public void run() {
                    ((InterfaceC1544i) AppLovinAdDisplayListener.this).onAdDisplayFailed(str);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m6226a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdRewardListener.this.validationRequestFailed(C1728i.m6217b(appLovinAd), i);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6225a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdRewardListener.this.userRewardVerified(C1728i.m6217b(appLovinAd), map);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6224a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdVideoPlaybackListener.this.videoPlaybackBegan(C1728i.m6217b(appLovinAd));
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6223a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final double d, final boolean z) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdVideoPlaybackListener.this.videoPlaybackEnded(C1728i.m6217b(appLovinAd), d, z);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m6222a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.20
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppLovinPostbackListener.this.onPostbackSuccess(str);
                    } catch (Throwable th) {
                        C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m6221a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.21
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppLovinPostbackListener.this.onPostbackFailure(str, i);
                    } catch (Throwable th) {
                        C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i + "):", th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static AppLovinAd m6217b(AppLovinAd appLovinAd) {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        return appLovinAdBase.getDummyAd() != null ? appLovinAdBase.getDummyAd() : appLovinAd;
    }

    /* renamed from: b */
    public static void m6220b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdViewEventListener.this.adClosedFullscreen(C1728i.m6217b(appLovinAd), appLovinAdView);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
                }
            }
        });
    }

    /* renamed from: b */
    public static void m6219b(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6218b(maxAdListener, maxAd, false);
    }

    /* renamed from: b */
    public static void m6218b(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdDisplayed(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                }
            }
        });
    }

    /* renamed from: b */
    public static void m6216b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdDisplayListener.this.adHidden(C1728i.m6217b(appLovinAd));
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                }
            }
        });
    }

    /* renamed from: b */
    public static void m6215b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdRewardListener.this.userOverQuota(C1728i.m6217b(appLovinAd), map);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
                }
            }
        });
    }

    /* renamed from: c */
    public static void m6214c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdViewEventListener.this.adLeftApplication(C1728i.m6217b(appLovinAd), appLovinAdView);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
                }
            }
        });
    }

    /* renamed from: c */
    public static void m6213c(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6212c(maxAdListener, maxAd, false);
    }

    /* renamed from: c */
    public static void m6212c(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdHidden(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                }
            }
        });
    }

    /* renamed from: c */
    public static void m6211c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.i.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppLovinAdRewardListener.this.userRewardRejected(C1728i.m6217b(appLovinAd), map);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
                }
            }
        });
    }

    /* renamed from: d */
    public static void m6210d(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6209d(maxAdListener, maxAd, false);
    }

    /* renamed from: d */
    public static void m6209d(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MaxAdListener.this.onAdClicked(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                }
            }
        });
    }

    /* renamed from: e */
    public static void m6208e(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6207e(maxAdListener, maxAd, false);
    }

    /* renamed from: e */
    public static void m6207e(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((MaxRewardedAdListener) MaxAdListener.this).onRewardedVideoStarted(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", th);
                }
            }
        });
    }

    /* renamed from: f */
    public static void m6206f(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6205f(maxAdListener, maxAd, false);
    }

    /* renamed from: f */
    public static void m6205f(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((MaxRewardedAdListener) MaxAdListener.this).onRewardedVideoCompleted(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", th);
                }
            }
        });
    }

    /* renamed from: g */
    public static void m6204g(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6203g(maxAdListener, maxAd, false);
    }

    /* renamed from: g */
    public static void m6203g(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((MaxAdViewAdListener) MaxAdListener.this).onAdExpanded(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", th);
                }
            }
        });
    }

    /* renamed from: h */
    public static void m6202h(MaxAdListener maxAdListener, MaxAd maxAd) {
        m6201h(maxAdListener, maxAd, false);
    }

    /* renamed from: h */
    public static void m6201h(final MaxAdListener maxAdListener, final MaxAd maxAd, boolean z) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z, new Runnable() { // from class: com.applovin.impl.sdk.utils.i.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((MaxAdViewAdListener) MaxAdListener.this).onAdCollapsed(maxAd);
                } catch (Throwable th) {
                    C1710r.m6316c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", th);
                }
            }
        });
    }
}
