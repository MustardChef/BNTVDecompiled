package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1335b;
import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.mediation.p013a.C1339f;
import com.applovin.impl.mediation.p013a.C1341g;
import com.applovin.impl.mediation.p014b.C1376d;
import com.applovin.impl.mediation.p014b.C1384f;
import com.applovin.impl.mediation.p014b.C1385g;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1662k f801a;

    /* renamed from: b */
    private final C1710r f802b;

    /* renamed from: com.applovin.impl.mediation.MediationServiceImpl$a */
    /* loaded from: classes.dex */
    public class C1330a implements AbstractC1363a.InterfaceC1364a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

        /* renamed from: b */
        private final AbstractC1334a f817b;

        /* renamed from: c */
        private AbstractC1363a.InterfaceC1364a f818c;

        public C1330a(AbstractC1334a abstractC1334a, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
            this.f817b = abstractC1334a;
            this.f818c = interfaceC1364a;
        }

        /* renamed from: a */
        public void m7824a(AbstractC1363a.InterfaceC1364a interfaceC1364a) {
            this.f818c = interfaceC1364a;
        }

        /* renamed from: a */
        public void m7823a(MaxAd maxAd, Bundle bundle) {
            this.f817b.m7804n();
            this.f817b.m7818a(bundle);
            MediationServiceImpl.this.m7827b(this.f817b);
            C1728i.m6240a((MaxAdListener) this.f818c, maxAd);
        }

        /* renamed from: b */
        public void m7822b(MaxAd maxAd, Bundle bundle) {
            MediationServiceImpl.this.f802b.m6319b("MediationService", "Scheduling impression for ad via callback...");
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f817b, this.f818c);
            this.f817b.m7818a(bundle);
            MediationServiceImpl.this.f801a.m6634af().m6729a(this.f817b, "DID_DISPLAY");
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f801a.m6637ac().m6334a(maxAd);
                MediationServiceImpl.this.f801a.m6629ak().m6578a(maxAd);
            }
            C1728i.m6219b(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            MediationServiceImpl.this.m7837a(this.f817b, this.f818c);
            C1728i.m6210d(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            C1728i.m6202h(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            MediationServiceImpl.this.m7826b(this.f817b, maxError, this.f818c);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof C1336c)) {
                ((C1336c) maxAd).m7785A();
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            m7822b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            C1728i.m6204g(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MediationServiceImpl.this.f801a.m6634af().m6729a((AbstractC1334a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (maxAd.getFormat().isFullscreenAd()) {
                        MediationServiceImpl.this.f801a.m6637ac().m6330b(maxAd);
                        MediationServiceImpl.this.f801a.m6629ak().m6586a();
                    }
                    C1728i.m6213c(C1330a.this.f818c, maxAd);
                }
            }, maxAd instanceof C1336c ? ((C1336c) maxAd).m7771w() : 0L);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f817b.m7804n();
            MediationServiceImpl.this.m7836a(this.f817b, maxError, this.f818c);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            m7823a(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1728i.m6206f(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1728i.m6208e(this.f818c, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1728i.m6237a(this.f818c, maxAd, maxReward);
            MediationServiceImpl.this.f801a.m6670Q().m6793a(new C1384f((C1336c) maxAd, MediationServiceImpl.this.f801a), C1620o.EnumC1622a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(C1662k c1662k) {
        this.f801a = c1662k;
        this.f802b = c1662k.m6588z();
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    /* renamed from: a */
    private void m7838a(AbstractC1334a abstractC1334a) {
        m7833a("mpreload", abstractC1334a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7837a(AbstractC1334a abstractC1334a, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        this.f801a.m6634af().m6729a(abstractC1334a, "DID_CLICKED");
        this.f801a.m6634af().m6729a(abstractC1334a, "DID_CLICK");
        if (abstractC1334a.m7815c().endsWith("click")) {
            this.f801a.m6634af().m6730a(abstractC1334a);
            C1728i.m6232a((MaxAdRevenueListener) interfaceC1364a, (MaxAd) abstractC1334a);
        }
        m7833a("mclick", abstractC1334a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7836a(AbstractC1334a abstractC1334a, MaxError maxError, MaxAdListener maxAdListener) {
        m7834a(maxError, abstractC1334a);
        destroyAd(abstractC1334a);
        C1728i.m6234a(maxAdListener, abstractC1334a.getAdUnitId(), maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7835a(final C1336c c1336c, final MaxAdListener maxAdListener) {
        final long longValue = ((Long) this.f801a.m6656a(C1567a.f1608G)).longValue();
        if (longValue <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (c1336c.m7803o().get()) {
                    return;
                }
                String str = "Ad (" + c1336c.m7762L() + ") has not been displayed after " + longValue + "ms. Failing ad display...";
                C1710r.m6310i("MediationService", str);
                MediationServiceImpl.this.m7826b(c1336c, new MaxErrorImpl(-1, str), maxAdListener);
                MediationServiceImpl.this.f801a.m6637ac().m6330b(c1336c);
                MediationServiceImpl.this.f801a.m6629ak().m6586a();
            }
        }, longValue);
    }

    /* renamed from: a */
    private void m7834a(MaxError maxError, AbstractC1334a abstractC1334a) {
        long m7807k = abstractC1334a.m7807k();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(m7807k));
        m7830a("mlerr", hashMap, maxError, abstractC1334a);
    }

    /* renamed from: a */
    private void m7833a(String str, C1338e c1338e) {
        m7830a(str, Collections.EMPTY_MAP, (MaxError) null, c1338e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7832a(String str, C1341g c1341g, C1471g c1471g) {
        HashMap hashMap = new HashMap(2);
        Utils.putObjectForStringIfValid("{ADAPTER_VERSION}", c1471g.m7299g(), hashMap);
        Utils.putObjectForStringIfValid("{SDK_VERSION}", c1471g.m7301f(), hashMap);
        m7830a("serr", hashMap, new MaxErrorImpl(str), c1341g);
    }

    /* renamed from: a */
    private void m7831a(String str, Map<String, String> map, C1338e c1338e) {
        m7830a(str, map, (MaxError) null, c1338e);
    }

    /* renamed from: a */
    private void m7830a(String str, Map<String, String> map, MaxError maxError, C1338e c1338e) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("{PLACEMENT}", StringUtils.emptyIfNull(c1338e.getPlacement()));
        if (c1338e instanceof AbstractC1334a) {
            hashMap.put("{CREATIVE_ID}", StringUtils.emptyIfNull(((AbstractC1334a) c1338e).getCreativeId()));
        }
        this.f801a.m6670Q().m6793a(new C1376d(str, hashMap, maxError, c1338e, this.f801a), C1620o.EnumC1622a.MEDIATION_POSTBACKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7827b(AbstractC1334a abstractC1334a) {
        this.f801a.m6634af().m6729a(abstractC1334a, "DID_LOAD");
        if (abstractC1334a.m7815c().endsWith("load")) {
            this.f801a.m6634af().m6730a(abstractC1334a);
        }
        long m7807k = abstractC1334a.m7807k();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(m7807k));
        m7831a("load", hashMap, abstractC1334a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7826b(AbstractC1334a abstractC1334a, MaxError maxError, MaxAdListener maxAdListener) {
        this.f801a.m6634af().m6729a(abstractC1334a, "DID_FAIL_DISPLAY");
        processAdDisplayErrorPostback(maxError, abstractC1334a);
        if (abstractC1334a.m7803o().compareAndSet(false, true)) {
            C1728i.m6239a(maxAdListener, abstractC1334a, maxError);
        }
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final C1341g c1341g, Activity activity, final C1339f.InterfaceC1340a interfaceC1340a) {
        String str;
        C1710r c1710r;
        StringBuilder sb;
        String str2;
        if (c1341g == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (interfaceC1340a == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        final C1471g m7334a = this.f801a.m6686A().m7334a(c1341g);
        if (m7334a != null) {
            MaxAdapterParametersImpl m7845a = MaxAdapterParametersImpl.m7845a(c1341g, maxAdFormat);
            m7334a.m7319a(m7845a, activity);
            MaxSignalCollectionListener maxSignalCollectionListener = new MaxSignalCollectionListener() { // from class: com.applovin.impl.mediation.MediationServiceImpl.2
                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollected(String str3) {
                    interfaceC1340a.mo7654a(C1339f.m7731a(c1341g, m7334a, str3));
                }

                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollectionFailed(String str3) {
                    MediationServiceImpl.this.m7832a(str3, c1341g, m7334a);
                    interfaceC1340a.mo7654a(C1339f.m7728b(c1341g, m7334a, str3));
                }
            };
            if (!c1341g.m7724a()) {
                c1710r = this.f802b;
                sb = new StringBuilder();
                str2 = "Collecting signal for adapter: ";
            } else if (this.f801a.m6685B().m7341a(c1341g)) {
                c1710r = this.f802b;
                sb = new StringBuilder();
                str2 = "Collecting signal for now-initialized adapter: ";
            } else {
                C1710r c1710r2 = this.f802b;
                c1710r2.m6314e("MediationService", "Skip collecting signal for not-initialized adapter: " + m7334a.m7312b());
                str = "Adapter not initialized yet";
            }
            sb.append(str2);
            sb.append(m7334a.m7312b());
            c1710r.m6319b("MediationService", sb.toString());
            m7334a.m7318a(m7845a, c1341g, activity, maxSignalCollectionListener);
            return;
        }
        str = "Could not load adapter";
        interfaceC1340a.mo7654a(C1339f.m7730a(c1341g, str));
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof AbstractC1334a) {
            C1710r c1710r = this.f802b;
            c1710r.m6317c("MediationService", "Destroying " + maxAd);
            AbstractC1334a abstractC1334a = (AbstractC1334a) maxAd;
            C1471g m7812f = abstractC1334a.m7812f();
            if (m7812f != null) {
                m7812f.m7297h();
                abstractC1334a.m7802p();
            }
        }
    }

    public void loadAd(String str, MaxAdFormat maxAdFormat, C1702i c1702i, Activity activity, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (interfaceC1364a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f801a.m6595s())) {
            C1710r.m6310i("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
        }
        if (!this.f801a.m6613d()) {
            C1710r.m6311h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f801a.m6660a();
        if (str.length() != 16 && !str.startsWith("test_mode") && !this.f801a.m6590x().startsWith("05TMD")) {
            C1710r.m6310i("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
        }
        if (!this.f801a.m6648a(maxAdFormat)) {
            this.f801a.m6680G().m7588a(str, maxAdFormat, c1702i, activity, interfaceC1364a);
            return;
        }
        C1710r.m6310i("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
        C1728i.m6234a(interfaceC1364a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
    }

    public void loadThirdPartyMediatedAd(String str, AbstractC1334a abstractC1334a, Activity activity, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (abstractC1334a == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("A valid Activity is required");
        }
        this.f802b.m6319b("MediationService", "Loading " + abstractC1334a + "...");
        this.f801a.m6634af().m6729a(abstractC1334a, "WILL_LOAD");
        m7838a(abstractC1334a);
        C1471g m7334a = this.f801a.m6686A().m7334a(abstractC1334a);
        if (m7334a != null) {
            MaxAdapterParametersImpl m7847a = MaxAdapterParametersImpl.m7847a(abstractC1334a);
            m7334a.m7319a(m7847a, activity);
            AbstractC1334a mo7767a = abstractC1334a.mo7767a(m7334a);
            m7334a.m7316a(str, mo7767a);
            mo7767a.m7806l();
            m7334a.m7314a(str, m7847a, mo7767a, activity, new C1330a(mo7767a, interfaceC1364a));
            return;
        }
        String str2 = "Failed to load " + abstractC1334a + ": adapter not loaded";
        C1710r.m6310i("MediationService", str2);
        m7836a(abstractC1334a, new MaxErrorImpl(-5001, str2), interfaceC1364a);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object m6329c = this.f801a.m6637ac().m6329c();
            if (m6329c instanceof AbstractC1334a) {
                processAdDisplayErrorPostback(MaxAdapterError.WEBVIEW_ERROR, (AbstractC1334a) m6329c);
            }
        }
    }

    public void processAdDisplayErrorPostback(MaxError maxError, AbstractC1334a abstractC1334a) {
        m7830a("mierr", Collections.EMPTY_MAP, maxError, abstractC1334a);
    }

    public void processAdLossPostback(AbstractC1334a abstractC1334a, Float f) {
        String f2 = f != null ? f.toString() : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("{MBR}", f2);
        m7831a("mloss", hashMap, abstractC1334a);
    }

    public void processAdapterInitializationPostback(C1338e c1338e, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        m7830a("minit", hashMap, new MaxErrorImpl(str), c1338e);
    }

    public void processCallbackAdImpressionPostback(AbstractC1334a abstractC1334a, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (abstractC1334a.m7815c().endsWith("cimp")) {
            this.f801a.m6634af().m6730a(abstractC1334a);
            C1728i.m6232a((MaxAdRevenueListener) interfaceC1364a, (MaxAd) abstractC1334a);
        }
        m7833a("mcimp", abstractC1334a);
    }

    public void processRawAdImpressionPostback(AbstractC1334a abstractC1334a, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        this.f801a.m6634af().m6729a(abstractC1334a, "WILL_DISPLAY");
        if (abstractC1334a.m7815c().endsWith("mimp")) {
            this.f801a.m6634af().m6730a(abstractC1334a);
            C1728i.m6232a((MaxAdRevenueListener) interfaceC1364a, (MaxAd) abstractC1334a);
        }
        HashMap hashMap = new HashMap(1);
        if (abstractC1334a instanceof C1336c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((C1336c) abstractC1334a).m7773u()));
        }
        m7831a("mimp", hashMap, abstractC1334a);
    }

    public void processViewabilityAdImpressionPostback(C1335b c1335b, long j, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (c1335b.m7815c().endsWith("vimp")) {
            this.f801a.m6634af().m6730a(c1335b);
            C1728i.m6232a((MaxAdRevenueListener) interfaceC1364a, (MaxAd) c1335b);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(c1335b.m7787y()));
        m7831a("mvimp", hashMap, c1335b);
    }

    public void showFullscreenAd(MaxAd maxAd, String str, final Activity activity, final AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (maxAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        if (!(maxAd instanceof C1336c)) {
            C1710r.m6310i("MediationService", "Unable to show ad for '" + maxAd.getAdUnitId() + "': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). " + maxAd.getFormat() + " ad was provided.");
            throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
        }
        this.f801a.m6637ac().m6333a(true);
        final C1336c c1336c = (C1336c) maxAd;
        final C1471g f = c1336c.m7812f();
        if (f != null) {
            c1336c.m7737c(str);
            long m7772v = c1336c.m7772v();
            C1710r c1710r = this.f802b;
            c1710r.m6317c("MediationService", "Showing ad " + maxAd.getAdUnitId() + " with delay of " + m7772v + "ms...");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.MediationServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c1336c.getFormat() == MaxAdFormat.REWARDED || c1336c.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
                        MediationServiceImpl.this.f801a.m6670Q().m6793a(new C1385g(c1336c, MediationServiceImpl.this.f801a), C1620o.EnumC1622a.MEDIATION_REWARD);
                    }
                    f.m7326a(c1336c, activity);
                    MediationServiceImpl.this.f801a.m6637ac().m6333a(false);
                    MediationServiceImpl.this.m7835a(c1336c, (MaxAdListener) interfaceC1364a);
                    MediationServiceImpl.this.f802b.m6319b("MediationService", "Scheduling impression for ad manually...");
                    MediationServiceImpl.this.processRawAdImpressionPostback(c1336c, interfaceC1364a);
                }
            }, m7772v);
            return;
        }
        this.f801a.m6637ac().m6333a(false);
        C1710r c1710r2 = this.f802b;
        c1710r2.m6315d("MediationService", "Failed to show " + maxAd + ": adapter not found");
        C1710r.m6310i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + c1336c.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }
}
