package com.applovin.impl.adview.activity.p012b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1223b;
import com.applovin.impl.adview.C1238d;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.adview.C1268o;
import com.applovin.impl.adview.activity.C1172b;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1644f;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p028b.C1554b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1635u;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.impl.sdk.utils.C1763o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1173a implements C1554b.InterfaceC1564a {

    /* renamed from: a */
    protected final AbstractC1537g f366a;

    /* renamed from: b */
    protected final C1662k f367b;

    /* renamed from: c */
    protected final C1710r f368c;

    /* renamed from: d */
    protected final AppLovinFullscreenActivity f369d;

    /* renamed from: e */
    protected final C1584d f370e;

    /* renamed from: f */
    protected final AppLovinAdView f371f;

    /* renamed from: g */
    protected final C1267n f372g;

    /* renamed from: k */
    protected boolean f376k;

    /* renamed from: l */
    protected final AppLovinAdClickListener f377l;

    /* renamed from: m */
    protected final AppLovinAdDisplayListener f378m;

    /* renamed from: n */
    protected final AppLovinAdVideoPlaybackListener f379n;

    /* renamed from: o */
    protected final C1554b f380o;

    /* renamed from: p */
    protected C1760m f381p;

    /* renamed from: q */
    protected C1760m f382q;

    /* renamed from: s */
    private final AbstractC1718a f384s;

    /* renamed from: t */
    private final AppLovinBroadcastManager.Receiver f385t;

    /* renamed from: u */
    private final C1644f.InterfaceC1646a f386u;

    /* renamed from: x */
    private long f389x;

    /* renamed from: r */
    private final Handler f383r = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    protected final long f373h = SystemClock.elapsedRealtime();

    /* renamed from: v */
    private final AtomicBoolean f387v = new AtomicBoolean();

    /* renamed from: w */
    private final AtomicBoolean f388w = new AtomicBoolean();

    /* renamed from: i */
    protected long f374i = -1;

    /* renamed from: j */
    protected int f375j = C1644f.f2195a;

    /* renamed from: com.applovin.impl.adview.activity.b.a$7 */
    /* loaded from: classes.dex */
    class RunnableC11817 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1267n f401a;

        /* renamed from: b */
        final /* synthetic */ Runnable f402b;

        RunnableC11817(C1267n c1267n, Runnable runnable) {
            this.f401a = c1267n;
            this.f402b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.7.1
                @Override // java.lang.Runnable
                public void run() {
                    C1763o.m6157a(RunnableC11817.this.f401a, 400L, new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC11817.this.f401a.bringToFront();
                            RunnableC11817.this.f402b.run();
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.a$a */
    /* loaded from: classes.dex */
    private class View$OnClickListenerC1185a implements View.OnClickListener, AppLovinAdClickListener {
        private View$OnClickListenerC1185a() {
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            AbstractC1173a.this.f368c.m6319b("InterActivityV2", "Clicking through graphic");
            C1728i.m6229a(AbstractC1173a.this.f377l, appLovinAd);
            AbstractC1173a.this.f370e.m6921b();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == AbstractC1173a.this.f372g) {
                if (AbstractC1173a.this.f366a.m7152U()) {
                    AbstractC1173a.this.m8256b("javascript:al_onCloseButtonTapped();");
                }
                AbstractC1173a.this.mo8165g();
                return;
            }
            C1710r c1710r = AbstractC1173a.this.f368c;
            c1710r.m6314e("InterActivityV2", "Unhandled click on widget: " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1173a(final AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, final C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f366a = abstractC1537g;
        this.f367b = c1662k;
        this.f368c = c1662k.m6588z();
        this.f369d = appLovinFullscreenActivity;
        this.f377l = appLovinAdClickListener;
        this.f378m = appLovinAdDisplayListener;
        this.f379n = appLovinAdVideoPlaybackListener;
        C1554b c1554b = new C1554b(appLovinFullscreenActivity, c1662k);
        this.f380o = c1554b;
        c1554b.m7032a(this);
        C1584d c1584d = new C1584d(abstractC1537g, c1662k);
        this.f370e = c1584d;
        View$OnClickListenerC1185a view$OnClickListenerC1185a = new View$OnClickListenerC1185a();
        C1268o c1268o = new C1268o(c1662k.m6664W(), AppLovinAdSize.INTERSTITIAL, appLovinFullscreenActivity);
        this.f371f = c1268o;
        c1268o.setAdClickListener(view$OnClickListenerC1185a);
        c1268o.setAdDisplayListener(new AppLovinAdDisplayListener() { // from class: com.applovin.impl.adview.activity.b.a.1
            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adDisplayed(AppLovinAd appLovinAd) {
                AbstractC1173a.this.f368c.m6319b("InterActivityV2", "Web content rendered");
            }

            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adHidden(AppLovinAd appLovinAd) {
                AbstractC1173a.this.f368c.m6319b("InterActivityV2", "Closing from WebView");
                AbstractC1173a.this.mo8165g();
            }
        });
        C1223b adViewController = c1268o.getAdViewController();
        adViewController.m8143a(c1584d);
        adViewController.m8098s().setIsShownOutOfContext(abstractC1537g.m7114al());
        c1662k.m6594t().trackImpression(abstractC1537g);
        if (abstractC1537g.m7074u() >= 0) {
            C1267n c1267n = new C1267n(abstractC1537g.m7073v(), appLovinFullscreenActivity);
            this.f372g = c1267n;
            c1267n.setVisibility(8);
            c1267n.setOnClickListener(view$OnClickListenerC1185a);
        } else {
            this.f372g = null;
        }
        if (((Boolean) c1662k.m6656a(C1568b.f1802cq)).booleanValue()) {
            AppLovinBroadcastManager.Receiver receiver = new AppLovinBroadcastManager.Receiver() { // from class: com.applovin.impl.adview.activity.b.a.2
                @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    c1662k.m6594t().trackAppKilled(abstractC1537g);
                    c1662k.m6631ai().unregisterReceiver(this);
                }
            };
            this.f385t = receiver;
            c1662k.m6631ai().registerReceiver(receiver, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        } else {
            this.f385t = null;
        }
        if (abstractC1537g.m7115ak()) {
            C1644f.InterfaceC1646a interfaceC1646a = new C1644f.InterfaceC1646a() { // from class: com.applovin.impl.adview.activity.b.a.3
                @Override // com.applovin.impl.sdk.C1644f.InterfaceC1646a
                public void onRingerModeChanged(int i) {
                    String str;
                    if (AbstractC1173a.this.f375j != C1644f.f2195a) {
                        AbstractC1173a.this.f376k = true;
                    }
                    C1238d m8098s = AbstractC1173a.this.f371f.getAdViewController().m8098s();
                    if (!C1644f.m6738a(i) || C1644f.m6738a(AbstractC1173a.this.f375j)) {
                        str = i == 2 ? "javascript:al_muteSwitchOff();" : "javascript:al_muteSwitchOff();";
                        AbstractC1173a.this.f375j = i;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    m8098s.m8086a(str);
                    AbstractC1173a.this.f375j = i;
                }
            };
            this.f386u = interfaceC1646a;
            c1662k.m6632ah().m6737a(interfaceC1646a);
        } else {
            this.f386u = null;
        }
        if (!((Boolean) c1662k.m6656a(C1568b.f1865eB)).booleanValue()) {
            this.f384s = null;
            return;
        }
        AbstractC1718a abstractC1718a = new AbstractC1718a() { // from class: com.applovin.impl.adview.activity.b.a.4
            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (AbstractC1173a.this.f388w.get()) {
                    return;
                }
                if (activity.getClass().getName().equals(Utils.retrieveLauncherActivityFullyQualifiedName(activity.getApplicationContext()))) {
                    c1662k.m6670Q().m6793a(new C1642y(c1662k, new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C1710r.m6310i("InterActivityV2", "Dismissing on-screen ad due to app relaunched via launcher.");
                            AbstractC1173a.this.mo8165g();
                        }
                    }), C1620o.EnumC1622a.MAIN);
                }
            }
        };
        this.f384s = abstractC1718a;
        c1662k.m6636ad().m7239a(abstractC1718a);
    }

    /* renamed from: a */
    public void m8268a(int i, KeyEvent keyEvent) {
        C1710r c1710r = this.f368c;
        if (c1710r != null) {
            c1710r.m6317c("InterActivityV2", "onKeyDown(int, KeyEvent) -  " + i + ", " + keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8267a(int i, boolean z, boolean z2, long j) {
        if (this.f387v.compareAndSet(false, true)) {
            if (this.f366a.hasVideoUrl() || m8248r()) {
                C1728i.m6223a(this.f379n, this.f366a, i, z2);
            }
            if (this.f366a.hasVideoUrl()) {
                this.f370e.m6918c(i);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f373h;
            this.f367b.m6594t().trackVideoEnd(this.f366a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i, z);
            long elapsedRealtime2 = this.f374i != -1 ? SystemClock.elapsedRealtime() - this.f374i : -1L;
            this.f367b.m6594t().trackFullScreenAdClosed(this.f366a, elapsedRealtime2, j, this.f376k, this.f375j);
            C1710r c1710r = this.f368c;
            c1710r.m6319b("InterActivityV2", "Video ad ended at percent: " + i + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + elapsedRealtime2 + "ms");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8266a(long j) {
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j) + " seconds...");
        this.f381p = C1760m.m6176a(j, this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC1173a.this.f366a.m7120af().getAndSet(true)) {
                    return;
                }
                AbstractC1173a.this.f367b.m6670Q().m6793a(new C1635u(AbstractC1173a.this.f366a, AbstractC1173a.this.f367b), C1620o.EnumC1622a.REWARD);
            }
        });
    }

    /* renamed from: a */
    public void m8265a(Configuration configuration) {
        C1710r c1710r = this.f368c;
        c1710r.m6317c("InterActivityV2", "onConfigurationChanged(Configuration) -  " + configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8263a(C1267n c1267n, long j, Runnable runnable) {
        RunnableC11817 runnableC11817 = new RunnableC11817(c1267n, runnable);
        if (((Boolean) this.f367b.m6656a(C1568b.f1770cK)).booleanValue()) {
            this.f382q = C1760m.m6176a(TimeUnit.SECONDS.toMillis(j), this.f367b, runnableC11817);
        } else {
            this.f367b.m6670Q().m6791a((AbstractRunnableC1589a) new C1642y(this.f367b, runnableC11817), C1620o.EnumC1622a.MAIN, TimeUnit.SECONDS.toMillis(j), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8262a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.f383r);
    }

    /* renamed from: a */
    protected void m8261a(String str) {
        if (this.f366a.m7151V()) {
            m8260a(str, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8260a(final String str, long j) {
        if (j >= 0) {
            m8262a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.6
                @Override // java.lang.Runnable
                public void run() {
                    C1238d m8098s;
                    if (!StringUtils.isValidString(str) || (m8098s = AbstractC1173a.this.f371f.getAdViewController().m8098s()) == null) {
                        return;
                    }
                    m8098s.m8086a(str);
                }
            }, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8259a(boolean z) {
        List<Uri> checkCachedResourcesExist = Utils.checkCachedResourcesExist(z, this.f366a, this.f367b, this.f369d);
        if (checkCachedResourcesExist.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f367b.m6656a(C1568b.f1869eF)).booleanValue()) {
            this.f366a.mo7146a();
            return;
        }
        throw new IllegalStateException("Missing cached resource(s): " + checkCachedResourcesExist);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8258a(boolean z, long j) {
        if (this.f366a.m7153T()) {
            m8260a(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m8256b(String str) {
        m8260a(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m8255b(boolean z) {
        m8258a(z, ((Long) this.f367b.m6656a(C1568b.f1767cH)).longValue());
        C1728i.m6228a(this.f378m, this.f366a);
        this.f367b.m6637ac().m6334a(this.f366a);
        this.f367b.m6629ak().m6578a(this.f366a);
        if (this.f366a.hasVideoUrl() || m8248r()) {
            C1728i.m6224a(this.f379n, this.f366a);
        }
        new C1172b(this.f369d).m8269a(this.f366a);
        this.f370e.m6927a();
        this.f366a.setHasShown(true);
    }

    /* renamed from: c */
    public void mo8189c(boolean z) {
        C1710r c1710r = this.f368c;
        c1710r.m6317c("InterActivityV2", "onWindowFocusChanged(boolean) - " + z);
        m8261a("javascript:al_onWindowFocusChanged( " + z + " );");
        C1760m c1760m = this.f382q;
        if (c1760m != null) {
            if (z) {
                c1760m.m6171c();
            } else {
                c1760m.m6173b();
            }
        }
    }

    /* renamed from: d */
    public abstract void mo8167d();

    /* renamed from: e */
    public void mo8227e() {
        this.f368c.m6317c("InterActivityV2", "onResume()");
        this.f370e.m6916d(SystemClock.elapsedRealtime() - this.f389x);
        m8261a("javascript:al_onAppResumed();");
        m8249o();
        if (this.f380o.m7025d()) {
            this.f380o.m7034a();
        }
    }

    /* renamed from: f */
    public void mo8226f() {
        this.f368c.m6317c("InterActivityV2", "onPause()");
        this.f389x = SystemClock.elapsedRealtime();
        m8261a("javascript:al_onAppPaused();");
        this.f380o.m7034a();
        m8250n();
    }

    /* renamed from: g */
    public void mo8165g() {
        this.f368c.m6317c("InterActivityV2", "dismiss()");
        this.f383r.removeCallbacksAndMessages(null);
        m8260a("javascript:al_onPoststitialDismiss();", this.f366a.m7154S());
        m8251m();
        this.f370e.m6919c();
        if (this.f385t != null) {
            C1760m.m6176a(TimeUnit.SECONDS.toMillis(2L), this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.a.5
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC1173a.this.f369d.stopService(new Intent(AbstractC1173a.this.f369d.getApplicationContext(), AppKilledService.class));
                    AbstractC1173a.this.f367b.m6631ai().unregisterReceiver(AbstractC1173a.this.f385t);
                }
            });
        }
        if (this.f386u != null) {
            this.f367b.m6632ah().m6734b(this.f386u);
        }
        if (this.f384s != null) {
            this.f367b.m6636ad().m7237b(this.f384s);
        }
        this.f369d.finish();
    }

    /* renamed from: h */
    public void m8254h() {
        this.f368c.m6317c("InterActivityV2", "onStop()");
    }

    /* renamed from: i */
    public void mo8181i() {
        AppLovinAdView appLovinAdView = this.f371f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.f371f.destroy();
        }
        mo8164l();
        m8251m();
    }

    /* renamed from: j */
    public void m8253j() {
        C1710r.m6310i("InterActivityV2", "---low memory detected - running garbage collection---");
        System.gc();
    }

    /* renamed from: k */
    public void m8252k() {
        this.f368c.m6317c("InterActivityV2", "onBackPressed()");
        if (this.f366a.m7152U()) {
            m8256b("javascript:onBackPressed();");
        }
    }

    /* renamed from: l */
    protected abstract void mo8164l();

    /* renamed from: m */
    protected void m8251m() {
        if (this.f388w.compareAndSet(false, true)) {
            C1728i.m6216b(this.f378m, this.f366a);
            this.f367b.m6637ac().m6330b(this.f366a);
            this.f367b.m6629ak().m6586a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public void m8250n() {
        C1760m c1760m = this.f381p;
        if (c1760m != null) {
            c1760m.m6173b();
        }
    }

    /* renamed from: o */
    protected void m8249o() {
        C1760m c1760m = this.f381p;
        if (c1760m != null) {
            c1760m.m6171c();
        }
    }

    /* renamed from: p */
    protected abstract boolean mo8163p();

    /* renamed from: q */
    protected abstract boolean mo8162q();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public boolean m8248r() {
        return AppLovinAdType.INCENTIVIZED == this.f366a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f366a.getType();
    }

    /* renamed from: s */
    protected abstract void mo8161s();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public boolean m8247t() {
        return ((Boolean) this.f367b.m6656a(C1568b.f1807cv)).booleanValue() ? this.f367b.m6598p().isMuted() : ((Boolean) this.f367b.m6656a(C1568b.f1805ct)).booleanValue();
    }
}
