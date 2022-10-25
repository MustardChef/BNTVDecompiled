package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.StrictMode;
import android.webkit.WebView;
import androidx.preference.PreferenceManager;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdsLoader;
import com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.StreamRequest;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2481az;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh;
import com.google.ads.interactivemedia.p034v3.impl.data.C2496bn;
import com.google.ads.interactivemedia.p034v3.impl.data.C2522m;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2492bj;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2493bk;
import com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aip */
/* loaded from: classes2.dex */
public final class aip implements AdsLoader {

    /* renamed from: a */
    apo f4155a;

    /* renamed from: b */
    private final Context f4156b;

    /* renamed from: c */
    private final ajx f4157c;

    /* renamed from: d */
    private final ajt f4158d;

    /* renamed from: e */
    private final aji f4159e;

    /* renamed from: f */
    private final List f4160f;

    /* renamed from: g */
    private final Map f4161g;

    /* renamed from: h */
    private final Map f4162h;

    /* renamed from: i */
    private final akm f4163i;

    /* renamed from: j */
    private final ImaSdkSettings f4164j;

    /* renamed from: k */
    private final BaseDisplayContainer f4165k;

    /* renamed from: l */
    private final alo f4166l;

    /* renamed from: m */
    private final Object f4167m;

    /* renamed from: n */
    private final ayr f4168n;

    /* renamed from: o */
    private final alv f4169o;

    /* renamed from: p */
    private final TestingConfiguration f4170p;

    /* renamed from: q */
    private alq f4171q;

    public aip(Context context, Uri uri, ImaSdkSettings imaSdkSettings, BaseDisplayContainer baseDisplayContainer, TestingConfiguration testingConfiguration, ExecutorService executorService) {
        ajx ajxVar = new ajx(new akd(new Handler(Looper.getMainLooper()), new WebView(context)), context, uri, imaSdkSettings, testingConfiguration, executorService);
        this.f4158d = new ain(this);
        this.f4159e = new aji();
        this.f4160f = new ArrayList(1);
        this.f4161g = new HashMap();
        this.f4162h = new HashMap();
        this.f4167m = new Object();
        this.f4157c = ajxVar;
        this.f4156b = context;
        this.f4164j = imaSdkSettings == null ? ImaSdkFactory.getInstance().createImaSdkSettings() : imaSdkSettings;
        this.f4165k = baseDisplayContainer;
        ayr m4319a = ayu.m4319a(executorService);
        this.f4168n = m4319a;
        this.f4170p = testingConfiguration;
        akm akmVar = new akm(ajxVar, context);
        this.f4163i = akmVar;
        alv alvVar = new alv(ajxVar);
        this.f4169o = alvVar;
        ajxVar.m5137h(akmVar);
        baseDisplayContainer.claim();
        this.f4166l = new alo(context, m4319a, alvVar);
        this.f4171q = new alq(context, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* bridge */ /* synthetic */ void m5201j(aip aipVar, AdsManagerLoadedEvent adsManagerLoadedEvent) {
        for (AdsLoader.AdsLoadedListener adsLoadedListener : aipVar.f4160f) {
            adsLoadedListener.onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }

    /* renamed from: p */
    static final Object m5195p(Future future) {
        try {
            return ayu.m4317c(future);
        } catch (Exception e) {
            C2525p.m5990b("Error during initialization", e);
            return null;
        } catch (Throwable th) {
            C2525p.m5990b("Error during initialization", new Exception(th));
            return null;
        }
    }

    /* renamed from: q */
    private final aio m5194q() {
        ActivityInfo activityInfo;
        PackageManager packageManager = this.f4156b.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads.interactivemedia.v3")), 65536);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            return aio.create(packageInfo.versionCode, activityInfo.packageName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: r */
    private final AbstractC2481az m5193r() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4156b);
        if (defaultSharedPreferences != null) {
            try {
                return AbstractC2481az.create(defaultSharedPreferences.contains("IABTCF_gdprApplies") ? String.valueOf(defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0)) : "", defaultSharedPreferences.getString("IABTCF_TCString", ""), defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""), defaultSharedPreferences.getString("IABUSPrivacy_String", ""));
            } catch (ClassCastException e) {
                C2525p.m5990b("Failed to read TCF Consent settings from SharedPreferences.", e);
                return null;
            }
        }
        return null;
    }

    /* renamed from: s */
    private final String m5192s() {
        TestingConfiguration testingConfiguration = this.f4170p;
        if (testingConfiguration == null || !testingConfiguration.ignoreStrictModeFalsePositives()) {
            return UUID.randomUUID().toString();
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
        String uuid = UUID.randomUUID().toString();
        StrictMode.setThreadPolicy(threadPolicy);
        return uuid;
    }

    /* renamed from: t */
    private final String m5191t() {
        return String.format("android%s:%s:%s", Build.VERSION.RELEASE, "3.25.1", this.f4156b.getPackageName());
    }

    /* renamed from: u */
    private final String m5190u() {
        NetworkInfo activeNetworkInfo;
        if (this.f4156b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            C2525p.m5988d("Host application doesn't have ACCESS_NETWORK_STATE permission");
            return "android:0";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f4156b.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "android:0" : String.format(Locale.US, "android:%d:%d", Integer.valueOf(activeNetworkInfo.getType()), Integer.valueOf(activeNetworkInfo.getSubtype()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4159e.m5167a(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void addAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.f4160f.add(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void contentComplete() {
        this.f4157c.mo5122o(new ajq(ajo.adsLoader, ajp.contentComplete, "*"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ String m5205f(AdsRequest adsRequest) throws Exception {
        String adTagUrl = adsRequest.getAdTagUrl();
        m5198m();
        if (adTagUrl != null) {
            try {
                Uri parse = Uri.parse(adTagUrl);
                apo apoVar = this.f4155a;
                return (apoVar == null || !apoVar.m4780c(parse)) ? adTagUrl : this.f4155a.m4782a(parse, this.f4156b).toString();
            } catch (RemoteException | apx | IllegalStateException unused) {
                return adTagUrl;
            }
        }
        return adTagUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final /* synthetic */ String m5204g() throws Exception {
        Context context = this.f4156b;
        m5198m();
        try {
            apo apoVar = this.f4155a;
            if (apoVar != null) {
                return apoVar.m4781b(context);
            }
        } catch (RemoteException unused) {
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final ImaSdkSettings getSettings() {
        return this.f4164j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ void m5200k(Task task) {
        List<String> list;
        C2496bn c2496bn = (C2496bn) task.getResult();
        this.f4169o.m5013d(c2496bn.enableInstrumentation);
        Integer num = c2496bn.espAdapterTimeoutMs;
        if (num != null && (list = c2496bn.espAdapters) != null) {
            this.f4166l.m5023h(list, num);
            this.f4166l.m5024g();
        }
        this.f4171q = new alq(this.f4156b, !c2496bn.disableAppSetId);
    }

    /* renamed from: l */
    public final void m5199l() {
        this.f4157c.m5142c().addOnCompleteListener(this.f4168n, new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.internal.aig
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                aip.this.m5200k(task);
            }
        });
    }

    /* renamed from: m */
    final void m5198m() {
        synchronized (this.f4167m) {
            if (this.f4155a == null) {
                try {
                    afc m5682l = aew.m5682l();
                    m5682l.m5653k(aex.f3642b);
                    m5682l.m5654j();
                    m5682l.m5656h();
                    m5682l.m5655i();
                    this.f4155a = new apo(this.f4156b, this.f4168n, (aew) m5682l.mo3179aR());
                } catch (RuntimeException unused) {
                    this.f4155a = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void m5197n(AdDisplayContainer adDisplayContainer, AdsRequest adsRequest, ayq ayqVar, ayq ayqVar2, ayq ayqVar3, String str) throws Exception {
        AbstractC2490bh abstractC2490bh = (AbstractC2490bh) ayu.m4317c(ayqVar);
        adsRequest.setAdTagUrl((String) ayu.m4317c(ayqVar2));
        AbstractC2481az m5193r = m5193r();
        ajq ajqVar = new ajq(ajo.adsLoader, ajp.requestAds, str, AbstractC2489bg.create(adsRequest, m5191t(), m5193r, (List) m5195p(ayqVar3), m5190u(), this.f4164j, m5194q(), C2522m.m5992b(this.f4156b, this.f4170p), abstractC2490bh, adDisplayContainer));
        this.f4157c.m5135j(abstractC2490bh);
        this.f4157c.mo5122o(ajqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void m5196o(StreamRequest streamRequest, ayq ayqVar, ayq ayqVar2, String str, ayq ayqVar3) throws Exception {
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) this.f4165k;
        AbstractC2490bh abstractC2490bh = (AbstractC2490bh) ayu.m4317c(ayqVar);
        String str2 = (String) ayu.m4317c(ayqVar2);
        AbstractC2481az m5193r = m5193r();
        ajq ajqVar = new ajq(ajo.adsLoader, ajp.requestStream, str, AbstractC2489bg.createFromStreamRequest(streamRequest, m5191t(), m5193r, (List) m5195p(ayqVar3), m5190u(), this.f4164j, m5194q(), C2522m.m5992b(this.f4156b, this.f4170p), str2, abstractC2490bh, streamDisplayContainer));
        this.f4157c.m5135j(abstractC2490bh);
        this.f4157c.mo5122o(ajqVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void release() {
        this.f4165k.destroy();
        ajx ajxVar = this.f4157c;
        if (ajxVar != null) {
            ajxVar.m5134l();
        }
        this.f4161g.clear();
        this.f4160f.clear();
        this.f4162h.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4159e.m5164d(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void removeAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.f4160f.remove(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final void requestAds(final AdsRequest adsRequest) {
        final String m5192s = m5192s();
        if (adsRequest == null) {
            this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null.")));
            return;
        }
        BaseDisplayContainer baseDisplayContainer = this.f4165k;
        if (!(baseDisplayContainer instanceof AdDisplayContainer)) {
            this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with AdDisplayContainer.")));
        } else if (baseDisplayContainer.getAdContainer() == null) {
            this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")));
        } else if (!atm.m4619c(adsRequest.getAdTagUrl()) || !atm.m4619c(adsRequest.getAdsResponse())) {
            final AdDisplayContainer adDisplayContainer = (AdDisplayContainer) this.f4165k;
            if (adDisplayContainer.getPlayer() == null) {
                this.f4169o.m5016a(EnumC2492bj.ADS_LOADER, EnumC2493bk.CREATE_SDK_OWNED_PLAYER);
                adDisplayContainer.setPlayer(ImaSdkFactory.createSdkOwnedPlayer(this.f4156b, adDisplayContainer.getAdContainer()));
            }
            this.f4161g.put(m5192s, adsRequest);
            this.f4157c.m5139f(this.f4158d, m5192s);
            this.f4157c.m5140e(adDisplayContainer, m5192s);
            ayr ayrVar = this.f4168n;
            alq alqVar = this.f4171q;
            alqVar.getClass();
            final ayq mo4320a = ayrVar.mo4320a(new aim(alqVar));
            final ayq mo4320a2 = this.f4168n.mo4320a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.aij
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return aip.this.m5205f(adsRequest);
                }
            });
            ayr ayrVar2 = this.f4168n;
            alo aloVar = this.f4166l;
            aloVar.getClass();
            final ayq mo4320a3 = ayrVar2.mo4320a(new ail(aloVar));
            this.f4169o.m5014c(ayu.m4318b(mo4320a, mo4320a2, mo4320a3).m4332a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.aii
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    aip.this.m5197n(adDisplayContainer, adsRequest, mo4320a, mo4320a2, mo4320a3, m5192s);
                    return null;
                }
            }, this.f4168n), this.f4168n, EnumC2492bj.ADS_LOADER, EnumC2493bk.REQUEST_ADS);
        } else {
            this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad tag url must non-null and non empty.")));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsLoader
    public final String requestStream(final StreamRequest streamRequest) {
        final String m5192s = m5192s();
        if (streamRequest == null) {
            this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "StreamRequest cannot be null.")));
        } else {
            BaseDisplayContainer baseDisplayContainer = this.f4165k;
            if (!(baseDisplayContainer instanceof StreamDisplayContainer)) {
                this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with StreamDisplayContainer.")));
            } else if (((StreamDisplayContainer) baseDisplayContainer).getVideoStreamPlayer() == null) {
                this.f4159e.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream requests must specify a player.")));
            } else {
                this.f4162h.put(m5192s, streamRequest);
                this.f4157c.m5139f(this.f4158d, m5192s);
                this.f4157c.m5140e(this.f4165k, m5192s);
                ayr ayrVar = this.f4168n;
                alq alqVar = this.f4171q;
                alqVar.getClass();
                final ayq mo4320a = ayrVar.mo4320a(new aim(alqVar));
                ayr ayrVar2 = this.f4168n;
                alo aloVar = this.f4166l;
                aloVar.getClass();
                final ayq mo4320a2 = ayrVar2.mo4320a(new ail(aloVar));
                final ayq mo4320a3 = this.f4168n.mo4320a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.aih
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return aip.this.m5204g();
                    }
                });
                this.f4169o.m5014c(ayu.m4318b(mo4320a, mo4320a2, mo4320a3).m4332a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.aik
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        aip.this.m5196o(streamRequest, mo4320a, mo4320a3, m5192s, mo4320a2);
                        return null;
                    }
                }, this.f4168n), this.f4168n, EnumC2492bj.ADS_LOADER, EnumC2493bk.REQUEST_STREAM);
            }
        }
        return m5192s;
    }
}
