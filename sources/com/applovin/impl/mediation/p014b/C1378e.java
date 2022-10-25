package com.applovin.impl.mediation.p014b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p015c.C1389a;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p030d.C1587g;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.utils.C1721d;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.e */
/* loaded from: classes.dex */
public class C1378e extends AbstractRunnableC1589a {

    /* renamed from: a */
    private static final AtomicBoolean f944a = new AtomicBoolean();

    /* renamed from: c */
    private final String f945c;

    /* renamed from: d */
    private final MaxAdFormat f946d;

    /* renamed from: e */
    private final JSONObject f947e;

    /* renamed from: f */
    private final List<AbstractC1334a> f948f;

    /* renamed from: g */
    private final AbstractC1363a.InterfaceC1364a f949g;

    /* renamed from: h */
    private final WeakReference<Activity> f950h;

    /* renamed from: i */
    private final List<MaxMediatedNetworkInfoImpl> f951i;

    /* renamed from: com.applovin.impl.mediation.b.e$a */
    /* loaded from: classes.dex */
    private class C1382a extends AbstractRunnableC1589a {

        /* renamed from: c */
        private final int f959c;

        /* renamed from: d */
        private final AbstractC1334a f960d;

        /* renamed from: e */
        private final List<AbstractC1334a> f961e;

        C1382a(int i, List<AbstractC1334a> list) {
            super(C1378e.this.m6878e(), C1378e.this.f2058b);
            this.f959c = i;
            this.f960d = list.get(i);
            this.f961e = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m7619a() {
            if (this.f959c >= this.f961e.size() - 1) {
                C1378e.this.m7626a(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. See the message in MaxError#getAdLoadFailureInfo()."));
                return;
            }
            this.f2058b.m6670Q().m6793a(new C1382a(this.f959c + 1, this.f961e), C1391c.m7598a(C1378e.this.f946d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public void m7612e(String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
            m6884a("Loading ad " + (this.f959c + 1) + " of " + this.f961e.size() + ": " + this.f960d.m7763K());
            m7612e("started to load ad");
            this.f2058b.m6684C().loadThirdPartyMediatedAd(C1378e.this.f945c, this.f960d, C1378e.this.f950h.get() != null ? (Activity) C1378e.this.f950h.get() : this.f2058b.m6628al(), new C1389a(C1378e.this.f949g) { // from class: com.applovin.impl.mediation.b.e.a.1
                @Override // com.applovin.impl.mediation.p015c.C1389a, com.applovin.mediation.MaxAdListener
                public void onAdLoadFailed(String str, MaxError maxError) {
                    JSONObject jSONObject;
                    C1382a c1382a = C1382a.this;
                    c1382a.m6884a("Ad failed to load with error: " + maxError);
                    JSONArray m7599a = C1391c.m7599a(C1382a.this.f2058b);
                    int i = 0;
                    while (true) {
                        jSONObject = null;
                        if (i >= m7599a.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = JsonUtils.getJSONObject(m7599a, i, (JSONObject) null);
                        if (jSONObject2 != null) {
                            String string = JsonUtils.getString(jSONObject2, "class", null);
                            if (!TextUtils.isEmpty(string) && C1382a.this.f960d.m7764J().equals(string)) {
                                jSONObject = jSONObject2;
                                break;
                            }
                        }
                        i++;
                    }
                    C1378e.this.f951i.add(new MaxMediatedNetworkInfoImpl(jSONObject, maxError));
                    C1382a c1382a2 = C1382a.this;
                    c1382a2.m7612e("failed to load ad: " + maxError.getCode());
                    C1382a.this.m7619a();
                }

                @Override // com.applovin.impl.mediation.p015c.C1389a, com.applovin.mediation.MaxAdListener
                public void onAdLoaded(MaxAd maxAd) {
                    C1382a.this.m7612e("loaded ad");
                    C1378e.this.m7627a(maxAd, C1382a.this.f959c);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1378e(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, Activity activity, C1662k c1662k, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        super("TaskProcessMediationWaterfall:" + str + ":" + maxAdFormat.getLabel(), c1662k);
        this.f951i = new ArrayList();
        this.f945c = str;
        this.f946d = maxAdFormat;
        this.f947e = jSONObject;
        this.f949g = interfaceC1364a;
        this.f950h = new WeakReference<>(activity);
        this.f948f = new ArrayList(jSONObject.length());
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f948f.add(AbstractC1334a.m7817a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, c1662k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7627a(MaxAd maxAd, int i) {
        final Float f;
        AbstractC1334a abstractC1334a = (AbstractC1334a) maxAd;
        this.f2058b.m6683D().m6308a(abstractC1334a);
        List<AbstractC1334a> list = this.f948f;
        List<AbstractC1334a> subList = list.subList(i + 1, list.size());
        long longValue = ((Long) this.f2058b.m6656a(C1567a.f1620S)).longValue();
        float f2 = 1.0f;
        for (final AbstractC1334a abstractC1334a2 : subList) {
            Float m7811g = abstractC1334a2.m7811g();
            if (m7811g != null) {
                f2 *= m7811g.floatValue();
                f = Float.valueOf(f2);
            } else {
                f = null;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    C1378e.this.f2058b.m6684C().processAdLossPostback(abstractC1334a2, f);
                }
            }, TimeUnit.SECONDS.toMillis(longValue));
        }
        m6882b("Waterfall loaded for " + abstractC1334a.m7763K());
        C1728i.m6240a((MaxAdListener) this.f949g, maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7626a(MaxError maxError) {
        C1587g m6669R;
        C1586f c1586f;
        if (maxError.getCode() == 204) {
            m6669R = this.f2058b.m6669R();
            c1586f = C1586f.f2048q;
        } else if (maxError.getCode() == -5001) {
            m6669R = this.f2058b.m6669R();
            c1586f = C1586f.f2049r;
        } else {
            m6669R = this.f2058b.m6669R();
            c1586f = C1586f.f2050s;
        }
        m6669R.m6893a(c1586f);
        m6882b("Waterfall failed to load with error: " + maxError);
        if (this.f951i.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
            sb.append("\n");
            for (int i = 0; i < this.f951i.size(); i++) {
                MaxMediatedNetworkInfoImpl maxMediatedNetworkInfoImpl = this.f951i.get(i);
                sb.append(i);
                sb.append(") ");
                sb.append(maxMediatedNetworkInfoImpl.getName());
                sb.append("\n");
                sb.append("..code: ");
                sb.append(maxMediatedNetworkInfoImpl.getLoadError().getCode());
                sb.append("\n");
                sb.append("..message: ");
                sb.append(maxMediatedNetworkInfoImpl.getLoadError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        C1728i.m6234a(this.f949g, this.f945c, maxError);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f947e.optBoolean("is_testing", false) && !this.f2058b.m6679H().m7351a() && f944a.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    Utils.showAlert("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", (Context) C1378e.this.f950h.get());
                }
            });
        }
        if (this.f948f.size() > 0) {
            m6884a("Starting waterfall for " + this.f948f.size() + " ad(s)...");
            this.f2058b.m6670Q().m6794a(new C1382a(0, this.f948f));
            return;
        }
        m6881c("No ads were returned from the server");
        Utils.maybeHandleNoFillResponseForPublisher(this.f945c, this.f946d, this.f947e, this.f2058b);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f947e, "settings", new JSONObject());
        long j = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j <= 0) {
            m7626a(maxErrorImpl);
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(j);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.b.e.2
            @Override // java.lang.Runnable
            public void run() {
                C1378e.this.m7626a(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", false).booleanValue()) {
            C1721d.m6283a(millis, this.f2058b, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }
}
