package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.q */
/* loaded from: classes.dex */
public class C1304q implements AppLovinInterstitialAdDialog {

    /* renamed from: a */
    protected final C1662k f729a;

    /* renamed from: e */
    private final String f730e;

    /* renamed from: f */
    private final WeakReference<Context> f731f;

    /* renamed from: g */
    private volatile AppLovinAdLoadListener f732g;

    /* renamed from: h */
    private volatile AppLovinAdDisplayListener f733h;

    /* renamed from: i */
    private volatile AppLovinAdVideoPlaybackListener f734i;

    /* renamed from: j */
    private volatile AppLovinAdClickListener f735j;

    /* renamed from: k */
    private volatile AbstractC1537g f736k;

    /* renamed from: l */
    private volatile AbstractC1537g.EnumC1540b f737l;

    /* renamed from: m */
    private volatile InterfaceC1258l f738m;

    /* renamed from: d */
    private static final Map<String, C1304q> f728d = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    public static volatile boolean f726b = false;

    /* renamed from: c */
    public static volatile boolean f727c = false;

    public C1304q(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f729a = appLovinSdk.coreSdk;
        this.f730e = UUID.randomUUID().toString();
        this.f731f = new WeakReference<>(context);
        f726b = true;
        f727c = false;
    }

    /* renamed from: a */
    public static C1304q m7909a(String str) {
        return f728d.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7920a(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.q.6
            @Override // java.lang.Runnable
            public void run() {
                if (C1304q.this.f732g != null) {
                    C1304q.this.f732g.failedToReceiveAd(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7919a(Context context) {
        Intent intent = new Intent(context, this.f736k.m7079p() ? AppLovinFullscreenActivity.class : AppLovinInterstitialActivity.class);
        intent.putExtra("com.applovin.interstitial.wrapper_id", this.f730e);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f729a.m6590x());
        AbstractActivityC1269p.lastKnownWrapper = this;
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    private void m7913a(AbstractC1537g abstractC1537g, final Context context) {
        if (this.f729a.m6636ad().m7238b() == null) {
            abstractC1537g.m7095b(true);
            this.f729a.m6669R().m6893a(C1586f.f2044m);
        }
        f728d.put(this.f730e, this);
        if (((Boolean) this.f729a.m6656a(C1568b.f1870eG)).booleanValue()) {
            this.f729a.m6670Q().m6783b().execute(new Runnable() { // from class: com.applovin.impl.adview.q.2
                @Override // java.lang.Runnable
                public void run() {
                    System.gc();
                }
            });
        }
        this.f736k = abstractC1537g;
        this.f737l = this.f736k.m7078q();
        final long max = Math.max(0L, ((Long) this.f729a.m6656a(C1568b.f1797cl)).longValue());
        C1710r m6588z = this.f729a.m6588z();
        m6588z.m6319b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        m7912a(abstractC1537g, context, new Runnable() { // from class: com.applovin.impl.adview.q.3
            @Override // java.lang.Runnable
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.adview.q.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1304q.this.m7919a(context);
                    }
                }, max);
            }
        });
    }

    /* renamed from: a */
    private void m7912a(AbstractC1537g abstractC1537g, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(abstractC1537g.m7160M()) || !abstractC1537g.m7119ag() || C1725g.m6267a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(abstractC1537g.m7118ah()).setMessage(abstractC1537g.m7117ai()).setPositiveButton(abstractC1537g.m7116aj(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.q.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* renamed from: a */
    private void m7911a(AppLovinAd appLovinAd) {
        if (this.f733h != null) {
            this.f733h.adHidden(appLovinAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7907b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.q.5
            @Override // java.lang.Runnable
            public void run() {
                if (C1304q.this.f732g != null) {
                    C1304q.this.f732g.adReceived(appLovinAd);
                }
            }
        });
    }

    /* renamed from: h */
    private Context m7901h() {
        WeakReference<Context> weakReference = this.f731f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public C1662k m7921a() {
        return this.f729a;
    }

    /* renamed from: a */
    public void m7918a(InterfaceC1258l interfaceC1258l) {
        this.f738m = interfaceC1258l;
    }

    /* renamed from: a */
    protected void m7910a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f729a.m6594t().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* renamed from: b */
    public AbstractC1537g m7908b() {
        return this.f736k;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener m7906c() {
        return this.f734i;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener m7905d() {
        return this.f733h;
    }

    /* renamed from: e */
    public AppLovinAdClickListener m7904e() {
        return this.f735j;
    }

    /* renamed from: f */
    public AbstractC1537g.EnumC1540b m7903f() {
        return this.f737l;
    }

    /* renamed from: g */
    public void m7902g() {
        f726b = false;
        f727c = true;
        f728d.remove(this.f730e);
        if (this.f736k != null) {
            this.f738m = null;
        }
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public boolean isAdReadyToDisplay() {
        return this.f729a.m6594t().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f735j = appLovinAdClickListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f733h = appLovinAdDisplayListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f732g = appLovinAdLoadListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f734i = appLovinAdVideoPlaybackListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void show() {
        m7910a(new AppLovinAdLoadListener() { // from class: com.applovin.impl.adview.q.1
            @Override // com.applovin.sdk.AppLovinAdLoadListener
            public void adReceived(AppLovinAd appLovinAd) {
                C1304q.this.m7907b(appLovinAd);
                C1304q.this.showAndRender(appLovinAd);
            }

            @Override // com.applovin.sdk.AppLovinAdLoadListener
            public void failedToReceiveAd(int i) {
                C1304q.this.m7920a(i);
            }
        });
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd) {
        C1710r m6588z;
        String str;
        Context m7901h = m7901h();
        if (m7901h != null) {
            AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f729a);
            if (maybeRetrieveNonDummyAd != null) {
                if (((AppLovinAdBase) maybeRetrieveNonDummyAd).hasShown() && ((Boolean) this.f729a.m6656a(C1568b.f1726bS)).booleanValue()) {
                    throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                }
                if (maybeRetrieveNonDummyAd instanceof AbstractC1537g) {
                    m7913a((AbstractC1537g) maybeRetrieveNonDummyAd, m7901h);
                    return;
                }
                this.f729a.m6588z().m6314e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + maybeRetrieveNonDummyAd + "'");
                m7911a(maybeRetrieveNonDummyAd);
                return;
            }
            m6588z = this.f729a.m6588z();
            str = "Failed to show ad: " + appLovinAd;
        } else {
            m6588z = this.f729a.m6588z();
            str = "Failed to show interstitial: stale activity reference provided";
        }
        m6588z.m6314e("InterstitialAdDialogWrapper", str);
        m7911a(appLovinAd);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
