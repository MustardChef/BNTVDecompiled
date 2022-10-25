package com.applovin.adview;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C1304q;
import com.applovin.impl.adview.InterfaceC1258l;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.adview.activity.ServiceConnectionC1161a;
import com.applovin.impl.adview.activity.p012b.AbstractC1173a;
import com.applovin.impl.adview.activity.p012b.C1186b;
import com.applovin.impl.adview.activity.p012b.C1189c;
import com.applovin.impl.adview.activity.p012b.C1191d;
import com.applovin.impl.adview.activity.p012b.C1193e;
import com.applovin.impl.adview.activity.p012b.C1205f;
import com.applovin.impl.adview.activity.p012b.C1218g;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class AppLovinFullscreenActivity extends Activity implements InterfaceC1258l {
    public static C1304q parentInterstitialWrapper;

    /* renamed from: a */
    private C1662k f165a;

    /* renamed from: b */
    private AbstractC1173a f166b;

    /* renamed from: c */
    private final AtomicBoolean f167c = new AtomicBoolean(true);

    /* renamed from: d */
    private ServiceConnectionC1161a f168d;

    /* renamed from: a */
    private void m8436a(String str, Throwable th) {
        C1710r.m6316c("InterActivityV2", str, th);
        AppLovinAdDisplayListener m7905d = parentInterstitialWrapper.m7905d();
        if (m7905d instanceof InterfaceC1544i) {
            C1728i.m6227a(m7905d, str);
        } else {
            C1728i.m6216b(m7905d, parentInterstitialWrapper.m7908b());
        }
        dismiss();
    }

    @Override // com.applovin.impl.adview.InterfaceC1258l
    public void dismiss() {
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.mo8165g();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.m8252k();
        }
        if (Utils.isAppLovinTestEnvironment(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.m8265a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityManager activityManager;
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            if (bundle.getBoolean("com.applovin.dismiss_on_restore", false)) {
                C1710r.m6311h("InterActivityV2", "Dismissing ad. Activity was destroyed while in background.");
                dismiss();
                return;
            }
            C1710r.m6313f("InterActivityV2", "Activity was destroyed while in background.");
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        findViewById(16908290).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        C1662k c1662k = AppLovinSdk.getInstance(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"), new AppLovinSdkSettings(this), this).coreSdk;
        this.f165a = c1662k;
        if (parentInterstitialWrapper == null) {
            Intent intent = new Intent(this, FullscreenAdService.class);
            ServiceConnectionC1161a serviceConnectionC1161a = new ServiceConnectionC1161a(this, this.f165a);
            this.f168d = serviceConnectionC1161a;
            bindService(intent, serviceConnectionC1161a, 1);
            if (C1724f.m6272g()) {
                try {
                    WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        int intValue = ((Integer) c1662k.m6656a(C1568b.f1876eM)).intValue();
        if (intValue != -1 && (activityManager = (ActivityManager) getSystemService("activity")) != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.availMem < intValue) {
                m8436a("Not enough available memory", null);
                return;
            }
        }
        present(parentInterstitialWrapper.m7908b(), parentInterstitialWrapper.m7904e(), parentInterstitialWrapper.m7905d(), parentInterstitialWrapper.m7906c());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        parentInterstitialWrapper = null;
        ServiceConnectionC1161a serviceConnectionC1161a = this.f168d;
        if (serviceConnectionC1161a != null) {
            try {
                unbindService(serviceConnectionC1161a);
            } catch (Throwable unused) {
            }
        }
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.mo8181i();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.m8268a(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.m8253j();
        }
        super.onLowMemory();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.mo8226f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        AbstractC1173a abstractC1173a;
        try {
            super.onResume();
            if (this.f167c.get() || (abstractC1173a = this.f166b) == null) {
                return;
            }
            abstractC1173a.mo8227e();
        } catch (IllegalArgumentException e) {
            this.f165a.m6588z().m6318b("InterActivityV2", "Error was encountered in onResume().", e);
            dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C1662k c1662k = this.f165a;
        if (c1662k != null) {
            bundle.putBoolean("com.applovin.dismiss_on_restore", ((Boolean) c1662k.m6656a(C1568b.f1879eP)).booleanValue());
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        AbstractC1173a abstractC1173a = this.f166b;
        if (abstractC1173a != null) {
            abstractC1173a.m8254h();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.f166b != null) {
            if (!this.f167c.getAndSet(false) || (this.f166b instanceof C1193e)) {
                this.f166b.mo8189c(z);
            }
            if (z) {
                getWindow().getDecorView().setSystemUiVisibility(5894);
            }
        }
        super.onWindowFocusChanged(z);
    }

    public void present(AbstractC1537g abstractC1537g, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        boolean z = false;
        if (abstractC1537g.m7130aJ() && Utils.checkExoPlayerEligibility(this.f165a)) {
            z = true;
        }
        if (abstractC1537g instanceof C1129a) {
            if (z) {
                try {
                    this.f166b = new C1189c(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th) {
                    this.f165a.m6588z().m6321a("InterActivityV2", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th);
                    Utils.isExoPlayerEligible = false;
                    try {
                        this.f166b = new C1191d(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                    } catch (Throwable th2) {
                        m8436a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + this.f165a + " and throwable: " + th2.getMessage(), th2);
                        return;
                    }
                }
            } else {
                try {
                    this.f166b = new C1191d(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th3) {
                    m8436a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + this.f165a + " and throwable: " + th3.getMessage(), th3);
                    return;
                }
            }
        } else if (!abstractC1537g.hasVideoUrl()) {
            try {
                this.f166b = new C1186b(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th4) {
                m8436a("Failed to create FullscreenGraphicAdPresenter with sdk: " + this.f165a + " and throwable: " + th4.getMessage(), th4);
                return;
            }
        } else if (abstractC1537g.m7126aN()) {
            try {
                this.f166b = new C1218g(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th5) {
                m8436a("Failed to create FullscreenWebVideoAdPresenter with sdk: " + this.f165a + " and throwable: " + th5.getMessage(), th5);
                return;
            }
        } else if (z) {
            try {
                this.f166b = new C1193e(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th6) {
                this.f165a.m6588z().m6321a("InterActivityV2", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th6);
                Utils.isExoPlayerEligible = false;
                try {
                    this.f166b = new C1205f(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th7) {
                    m8436a("Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: " + this.f165a + " and throwable: " + th7.getMessage(), th7);
                    return;
                }
            }
        } else {
            try {
                this.f166b = new C1205f(abstractC1537g, this, this.f165a, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th8) {
                m8436a("Failed to create FullscreenVideoAdPresenter with sdk: " + this.f165a + " and throwable: " + th8.getMessage(), th8);
                return;
            }
        }
        this.f166b.mo8167d();
    }
}
