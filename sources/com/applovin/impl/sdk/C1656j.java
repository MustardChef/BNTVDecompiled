package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import com.applovin.impl.sdk.C1650i;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.j */
/* loaded from: classes.dex */
public class C1656j implements C1650i.InterfaceC1655a, AppLovinWebViewActivity.EventListener {

    /* renamed from: a */
    private static final AtomicBoolean f2223a = new AtomicBoolean();

    /* renamed from: b */
    private static WeakReference<AppLovinWebViewActivity> f2224b;

    /* renamed from: c */
    private final C1662k f2225c;

    /* renamed from: d */
    private final C1710r f2226d;

    /* renamed from: e */
    private AppLovinUserService.OnConsentDialogDismissListener f2227e;

    /* renamed from: f */
    private C1650i f2228f;

    /* renamed from: g */
    private WeakReference<Activity> f2229g;

    /* renamed from: h */
    private AbstractC1718a f2230h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1656j(C1662k c1662k) {
        this.f2229g = new WeakReference<>(null);
        this.f2225c = c1662k;
        this.f2226d = c1662k.m6588z();
        if (c1662k.m6675L() != null) {
            this.f2229g = new WeakReference<>(c1662k.m6675L());
        }
        c1662k.m6636ad().m7239a(new AbstractC1718a() { // from class: com.applovin.impl.sdk.j.1
            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                C1656j.this.f2229g = new WeakReference(activity);
            }
        });
        this.f2228f = new C1650i(this, c1662k);
    }

    /* renamed from: a */
    private void m6695a(boolean z, long j) {
        m6687f();
        if (z) {
            m6704a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6697a(C1662k c1662k) {
        if (m6692c()) {
            C1710r.m6310i("AppLovinSdk", "Consent dialog already showing");
            return false;
        } else if (!C1725g.m6267a(c1662k.m6677J())) {
            C1710r.m6310i("AppLovinSdk", "No internet available, skip showing of consent dialog");
            return false;
        } else if (!((Boolean) c1662k.m6656a(C1568b.f1695ao)).booleanValue()) {
            this.f2226d.m6314e("ConsentDialogManager", "Blocked publisher from showing consent dialog");
            return false;
        } else if (StringUtils.isValidString((String) c1662k.m6656a(C1568b.f1696ap))) {
            return true;
        } else {
            this.f2226d.m6314e("ConsentDialogManager", "AdServer returned empty consent dialog URL");
            return false;
        }
    }

    /* renamed from: f */
    private void m6687f() {
        this.f2225c.m6636ad().m7237b(this.f2230h);
        if (m6692c()) {
            AppLovinWebViewActivity appLovinWebViewActivity = f2224b.get();
            f2224b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener = this.f2227e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f2227e = null;
                }
            }
        }
    }

    @Override // com.applovin.impl.sdk.C1650i.InterfaceC1655a
    /* renamed from: a */
    public void mo6705a() {
        if (this.f2229g.get() != null) {
            final Activity activity = this.f2229g.get();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.j.4
                @Override // java.lang.Runnable
                public void run() {
                    C1656j.this.m6703a(activity, (AppLovinUserService.OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f2225c.m6656a(C1568b.f1698ar)).longValue());
        }
    }

    /* renamed from: a */
    public void m6704a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.j.3
            @Override // java.lang.Runnable
            public void run() {
                C1656j.this.f2226d.m6319b("ConsentDialogManager", "Scheduling repeating consent alert");
                C1656j.this.f2228f.m6709a(j, C1656j.this.f2225c, C1656j.this);
            }
        });
    }

    /* renamed from: a */
    public void m6703a(final Activity activity, final AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.j.2
            @Override // java.lang.Runnable
            public void run() {
                C1656j c1656j = C1656j.this;
                if (!c1656j.m6697a(c1656j.f2225c) || C1656j.f2223a.getAndSet(true)) {
                    AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener2 = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener2 != null) {
                        onConsentDialogDismissListener2.onDismiss();
                        return;
                    }
                    return;
                }
                C1656j.this.f2229g = new WeakReference(activity);
                C1656j.this.f2227e = onConsentDialogDismissListener;
                C1656j.this.f2230h = new AbstractC1718a() { // from class: com.applovin.impl.sdk.j.2.1
                    @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity2) {
                        if (activity2 instanceof AppLovinWebViewActivity) {
                            if (!C1656j.this.m6692c() || C1656j.f2224b.get() != activity2) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity2;
                                WeakReference unused = C1656j.f2224b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) C1656j.this.f2225c.m6656a(C1568b.f1696ap), C1656j.this);
                            }
                            C1656j.f2223a.set(false);
                        }
                    }
                };
                C1656j.this.f2225c.m6636ad().m7239a(C1656j.this.f2230h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, C1656j.this.f2225c.m6590x());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) C1656j.this.f2225c.m6656a(C1568b.f1697aq));
                activity.startActivity(intent);
            }
        });
    }

    @Override // com.applovin.impl.sdk.C1650i.InterfaceC1655a
    /* renamed from: b */
    public void mo6694b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m6692c() {
        WeakReference<AppLovinWebViewActivity> weakReference = f2224b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // com.applovin.sdk.AppLovinWebViewActivity.EventListener
    public void onReceivedEvent(String str) {
        boolean booleanValue;
        C1662k c1662k;
        C1568b<Long> c1568b;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f2225c.m6677J());
            m6687f();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f2225c.m6677J());
            booleanValue = ((Boolean) this.f2225c.m6656a(C1568b.f1699as)).booleanValue();
            c1662k = this.f2225c;
            c1568b = C1568b.f1704ax;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2225c.m6656a(C1568b.f1700at)).booleanValue();
            c1662k = this.f2225c;
            c1568b = C1568b.f1705ay;
        } else if (!AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            return;
        } else {
            booleanValue = ((Boolean) this.f2225c.m6656a(C1568b.f1701au)).booleanValue();
            c1662k = this.f2225c;
            c1568b = C1568b.f1706az;
        }
        m6695a(booleanValue, ((Long) c1662k.m6656a(c1568b)).longValue());
    }
}
