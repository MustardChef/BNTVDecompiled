package com.applovin.impl.sdk;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C1223b;
import com.applovin.impl.sdk.network.C1697g;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1529c;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.C1543h;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p027a.RunnableC1533f;
import com.applovin.impl.sdk.p030d.C1576a;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1608i;
import com.applovin.impl.sdk.p031e.C1609j;
import com.applovin.impl.sdk.p031e.C1611k;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1626p;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppLovinAdServiceImpl implements AppLovinAdService {

    /* renamed from: a */
    private final C1662k f1411a;

    /* renamed from: b */
    private final C1710r f1412b;

    /* renamed from: d */
    private final Map<C1531d, C1519b> f1414d;

    /* renamed from: c */
    private final Handler f1413c = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final Object f1415e = new Object();

    /* renamed from: f */
    private final Map<String, String> f1416f = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$a */
    /* loaded from: classes.dex */
    public class C1518a implements AppLovinAdLoadListener {

        /* renamed from: b */
        private final C1519b f1424b;

        private C1518a(C1519b c1519b) {
            this.f1424b = c1519b;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            C1531d adZone = appLovinAdBase.getAdZone();
            if (!(appLovinAd instanceof C1543h)) {
                AppLovinAdServiceImpl.this.f1411a.m6663X().m7017a(appLovinAdBase);
                appLovinAd = new C1543h(adZone, AppLovinAdServiceImpl.this.f1411a);
            }
            synchronized (this.f1424b.f1425a) {
                hashSet = new HashSet(this.f1424b.f1427c);
                this.f1424b.f1427c.clear();
                this.f1424b.f1426b = false;
            }
            for (AppLovinAdLoadListener appLovinAdLoadListener : hashSet) {
                AppLovinAdServiceImpl.this.m7264a(appLovinAd, appLovinAdLoadListener);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.f1424b.f1425a) {
                hashSet = new HashSet(this.f1424b.f1427c);
                this.f1424b.f1427c.clear();
                this.f1424b.f1426b = false;
            }
            for (AppLovinAdLoadListener appLovinAdLoadListener : hashSet) {
                AppLovinAdServiceImpl.this.m7274a(i, appLovinAdLoadListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$b */
    /* loaded from: classes.dex */
    public static class C1519b {

        /* renamed from: a */
        final Object f1425a;

        /* renamed from: b */
        boolean f1426b;

        /* renamed from: c */
        final Collection<AppLovinAdLoadListener> f1427c;

        private C1519b() {
            this.f1425a = new Object();
            this.f1427c = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f1426b + ", pendingAdListeners=" + this.f1427c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppLovinAdServiceImpl(C1662k c1662k) {
        this.f1411a = c1662k;
        this.f1412b = c1662k.m6588z();
        HashMap hashMap = new HashMap(5);
        this.f1414d = hashMap;
        hashMap.put(C1531d.m7206g(), new C1519b());
        hashMap.put(C1531d.m7205h(), new C1519b());
        hashMap.put(C1531d.m7204i(), new C1519b());
        hashMap.put(C1531d.m7203j(), new C1519b());
        hashMap.put(C1531d.m7202k(), new C1519b());
    }

    /* renamed from: a */
    private C1519b m7269a(C1531d c1531d) {
        C1519b c1519b;
        synchronized (this.f1415e) {
            c1519b = this.f1414d.get(c1531d);
            if (c1519b == null) {
                c1519b = new C1519b();
                this.f1414d.put(c1531d, c1519b);
            }
        }
        return c1519b;
    }

    /* renamed from: a */
    private String m7263a(String str, long j, int i, String str2, boolean z) {
        try {
            if (StringUtils.isValidString(str)) {
                return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString((i < 0 || i > 100) ? 0 : 0)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
            }
            return null;
        } catch (Throwable th) {
            C1710r c1710r = this.f1412b;
            c1710r.m6318b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    private String m7262a(String str, long j, long j2, boolean z, int i) {
        if (StringUtils.isValidString(str)) {
            Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
            if (i != C1644f.f2195a) {
                appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
                appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(C1644f.m6738a(i)));
            }
            return appendQueryParameter.build().toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7274a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1413c.post(new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    C1710r.m6316c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m7273a(Uri uri, AbstractC1537g abstractC1537g, AppLovinAdView appLovinAdView, C1223b c1223b) {
        if (appLovinAdView == null) {
            this.f1412b.m6314e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
            return;
        }
        if (Utils.openUri(appLovinAdView.getContext(), uri, this.f1411a)) {
            C1728i.m6214c(c1223b.m8122g(), abstractC1537g, appLovinAdView);
        }
        c1223b.m8106o();
    }

    /* renamed from: a */
    private void m7268a(C1531d c1531d, C1702i c1702i, C1518a c1518a) {
        AppLovinAdBase m7015b = this.f1411a.m6663X().m7015b(c1531d);
        if (m7015b == null) {
            m7265a(new C1609j(c1531d, c1702i, c1518a, this.f1411a));
            return;
        }
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Using pre-loaded ad: " + m7015b + " for " + c1531d);
        this.f1411a.m6661Z().m7200a(m7015b, true, false);
        c1518a.adReceived(m7015b);
    }

    /* renamed from: a */
    private void m7267a(C1531d c1531d, C1702i c1702i, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (c1531d == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        C1710r m6588z = this.f1411a.m6588z();
        m6588z.m6319b("AppLovinAdService", "Loading next ad of zone {" + c1531d + "}...");
        C1519b m7269a = m7269a(c1531d);
        synchronized (m7269a.f1425a) {
            m7269a.f1427c.add(appLovinAdLoadListener);
            if (m7269a.f1426b) {
                this.f1412b.m6319b("AppLovinAdService", "Already waiting on an ad load...");
            } else {
                m7269a.f1426b = true;
                m7268a(c1531d, c1702i, new C1518a(m7269a));
            }
        }
    }

    /* renamed from: a */
    private void m7266a(C1576a c1576a) {
        if (!StringUtils.isValidString(c1576a.m6962a())) {
            this.f1412b.m6315d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
            return;
        }
        this.f1411a.m6668S().m6452a(C1697g.m6421o().m6410c(Utils.replaceCommonMacros(c1576a.m6962a())).m6406d(StringUtils.isValidString(c1576a.m6961b()) ? Utils.replaceCommonMacros(c1576a.m6961b()) : null).m6413b(c1576a.m6960c()).m6416a(false).m6408c(c1576a.m6959d()).m6420a());
    }

    /* renamed from: a */
    private void m7265a(AbstractRunnableC1589a abstractRunnableC1589a) {
        if (!this.f1411a.m6613d()) {
            C1710r.m6311h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f1411a.m6660a();
        this.f1411a.m6670Q().m6793a(abstractRunnableC1589a, C1620o.EnumC1622a.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7264a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1413c.post(new Runnable() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    C1710r.m6316c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m7261a(List<C1576a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (C1576a c1576a : list) {
            m7266a(c1576a);
        }
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.f1416f) {
            this.f1416f.putAll(map);
        }
    }

    public AppLovinAd dequeueAd(C1531d c1531d) {
        AppLovinAdBase m7014c = this.f1411a.m6663X().m7014c(c1531d);
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Dequeued ad: " + m7014c + " for zone: " + c1531d + "...");
        return m7014c;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String m6565a = this.f1411a.m6667T().m6565a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return m6565a;
    }

    public Map<String, String> getCustomQueryParamsForNextAdRequest() {
        HashMap hashMap;
        synchronized (this.f1416f) {
            hashMap = new HashMap(this.f1416f);
            this.f1416f.clear();
        }
        return hashMap;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f1411a.m6663X().m7016a(C1531d.m7217a(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public boolean hasPreloadedAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1710r.m6310i("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
            return false;
        }
        return this.f1411a.m6663X().m7016a(C1531d.m7215a(str));
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m7267a(C1531d.m7217a(appLovinAdSize, AppLovinAdType.REGULAR), (C1702i) null, appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, C1702i c1702i, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        m7267a(C1531d.m7216a(appLovinAdSize, AppLovinAdType.REGULAR, str), c1702i, appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        AbstractRunnableC1589a c1626p;
        String trim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(trim)) {
            C1710r.m6310i("AppLovinAdService", "Invalid ad token specified");
            m7274a(-8, appLovinAdLoadListener);
            return;
        }
        C1529c c1529c = new C1529c(trim, this.f1411a);
        if (c1529c.m7221b() != C1529c.EnumC1530a.REGULAR) {
            if (c1529c.m7221b() == C1529c.EnumC1530a.AD_RESPONSE_JSON) {
                JSONObject m7219d = c1529c.m7219d();
                if (m7219d != null) {
                    C1725g.m6249h(m7219d, this.f1411a);
                    C1725g.m6257d(m7219d, this.f1411a);
                    C1725g.m6258c(m7219d, this.f1411a);
                    C1725g.m6255e(m7219d, this.f1411a);
                    if (JsonUtils.getJSONArray(m7219d, "ads", new JSONArray()).length() <= 0) {
                        C1710r c1710r = this.f1412b;
                        c1710r.m6314e("AppLovinAdService", "No ad returned from the server for token: " + c1529c);
                        appLovinAdLoadListener.failedToReceiveAd(204);
                        return;
                    }
                    C1710r c1710r2 = this.f1412b;
                    c1710r2.m6319b("AppLovinAdService", "Rendering ad for token: " + c1529c);
                    C1531d zone = Utils.getZone(m7219d, this.f1411a);
                    RunnableC1533f.C1535a c1535a = new RunnableC1533f.C1535a(zone, appLovinAdLoadListener, this.f1411a);
                    c1535a.m7175a(true);
                    c1626p = new C1626p(m7219d, zone, EnumC1528b.DECODED_AD_TOKEN_JSON, c1535a, this.f1411a);
                } else {
                    C1710r c1710r3 = this.f1412b;
                    c1710r3.m6314e("AppLovinAdService", "Unable to retrieve ad response JSON from token: " + c1529c);
                }
            } else {
                C1710r.m6310i("AppLovinAdService", "Invalid ad token specified: " + c1529c);
            }
            appLovinAdLoadListener.failedToReceiveAd(-8);
            return;
        }
        C1710r c1710r4 = this.f1412b;
        c1710r4.m6319b("AppLovinAdService", "Loading next ad for token: " + c1529c);
        c1626p = new C1611k(c1529c, appLovinAdLoadListener, this.f1411a);
        m7265a(c1626p);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        m7267a(C1531d.m7215a(str), (C1702i) null, appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (removeTrimmedEmptyStrings == null || removeTrimmedEmptyStrings.isEmpty()) {
            C1710r.m6310i("AppLovinAdService", "No zones were provided");
            m7274a(-7, appLovinAdLoadListener);
            return;
        }
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Loading next ad for zones: " + removeTrimmedEmptyStrings);
        m7265a(new C1608i(removeTrimmedEmptyStrings, appLovinAdLoadListener, this.f1411a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1710r c1710r = this.f1412b;
        c1710r.m6319b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        m7267a(C1531d.m7211b(str), (C1702i) null, appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void preloadAd(AppLovinAdSize appLovinAdSize) {
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void preloadAdForZoneId(String str) {
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f1414d + '}';
    }

    public void trackAndLaunchClick(AbstractC1537g abstractC1537g, AppLovinAdView appLovinAdView, C1223b c1223b, Uri uri, PointF pointF, boolean z) {
        if (abstractC1537g == null) {
            this.f1412b.m6314e("AppLovinAdService", "Unable to track ad view click. No ad specified");
            return;
        }
        this.f1412b.m6319b("AppLovinAdService", "Tracking click on an ad...");
        m7261a(abstractC1537g.m7143a(pointF, z));
        m7273a(uri, abstractC1537g, appLovinAdView, c1223b);
    }

    public void trackAndLaunchVideoClick(AbstractC1537g abstractC1537g, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        if (abstractC1537g == null) {
            this.f1412b.m6314e("AppLovinAdService", "Unable to track video click. No ad specified");
            return;
        }
        this.f1412b.m6319b("AppLovinAdService", "Tracking VIDEO click on an ad...");
        m7261a(abstractC1537g.m7144a(pointF));
        Utils.openUri(appLovinAdView.getContext(), uri, this.f1411a);
    }

    public void trackAppKilled(AbstractC1537g abstractC1537g) {
        if (abstractC1537g == null) {
            this.f1412b.m6314e("AppLovinAdService", "Unable to track app killed. No ad specified");
            return;
        }
        this.f1412b.m6319b("AppLovinAdService", "Tracking app killed during ad...");
        List<C1576a> m7107as = abstractC1537g.m7107as();
        if (m7107as != null && !m7107as.isEmpty()) {
            for (C1576a c1576a : m7107as) {
                m7266a(new C1576a(c1576a.m6962a(), c1576a.m6961b()));
            }
            return;
        }
        C1710r c1710r = this.f1412b;
        c1710r.m6315d("AppLovinAdService", "Unable to track app killed during AD #" + abstractC1537g.getAdIdNumber() + ". Missing app killed tracking URL.");
    }

    public void trackFullScreenAdClosed(AbstractC1537g abstractC1537g, long j, long j2, boolean z, int i) {
        C1710r c1710r = this.f1412b;
        if (abstractC1537g == null) {
            c1710r.m6314e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
            return;
        }
        c1710r.m6319b("AppLovinAdService", "Tracking ad closed...");
        List<C1576a> m7108ar = abstractC1537g.m7108ar();
        if (m7108ar == null || m7108ar.isEmpty()) {
            C1710r c1710r2 = this.f1412b;
            c1710r2.m6315d("AppLovinAdService", "Unable to track ad closed for AD #" + abstractC1537g.getAdIdNumber() + ". Missing ad close tracking URL." + abstractC1537g.getAdIdNumber());
            return;
        }
        for (C1576a c1576a : m7108ar) {
            String m7262a = m7262a(c1576a.m6962a(), j, j2, z, i);
            String m7262a2 = m7262a(c1576a.m6961b(), j, j2, z, i);
            if (StringUtils.isValidString(m7262a)) {
                m7266a(new C1576a(m7262a, m7262a2));
            } else {
                C1710r c1710r3 = this.f1412b;
                c1710r3.m6314e("AppLovinAdService", "Failed to parse url: " + c1576a.m6962a());
            }
        }
    }

    public void trackImpression(AbstractC1537g abstractC1537g) {
        if (abstractC1537g == null) {
            this.f1412b.m6314e("AppLovinAdService", "Unable to track impression click. No ad specified");
            return;
        }
        this.f1412b.m6319b("AppLovinAdService", "Tracking impression on ad...");
        m7261a(abstractC1537g.mo7106at());
        this.f1411a.m6661Z().m7198a(abstractC1537g);
    }

    public void trackVideoEnd(AbstractC1537g abstractC1537g, long j, int i, boolean z) {
        C1710r c1710r = this.f1412b;
        if (abstractC1537g == null) {
            c1710r.m6314e("AppLovinAdService", "Unable to track video end. No ad specified");
            return;
        }
        c1710r.m6319b("AppLovinAdService", "Tracking video end on ad...");
        List<C1576a> m7109aq = abstractC1537g.m7109aq();
        if (m7109aq == null || m7109aq.isEmpty()) {
            C1710r c1710r2 = this.f1412b;
            c1710r2.m6315d("AppLovinAdService", "Unable to submit persistent postback for AD #" + abstractC1537g.getAdIdNumber() + ". Missing video end tracking URL.");
            return;
        }
        String l = Long.toString(System.currentTimeMillis());
        for (C1576a c1576a : m7109aq) {
            if (StringUtils.isValidString(c1576a.m6962a())) {
                String m7263a = m7263a(c1576a.m6962a(), j, i, l, z);
                String m7263a2 = m7263a(c1576a.m6961b(), j, i, l, z);
                if (m7263a != null) {
                    m7266a(new C1576a(m7263a, m7263a2));
                } else {
                    C1710r c1710r3 = this.f1412b;
                    c1710r3.m6314e("AppLovinAdService", "Failed to parse url: " + c1576a.m6962a());
                }
            } else {
                this.f1412b.m6315d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }
}
