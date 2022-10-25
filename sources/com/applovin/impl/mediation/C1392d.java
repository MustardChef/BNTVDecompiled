package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p014b.C1369b;
import com.applovin.impl.mediation.p014b.C1374c;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* renamed from: com.applovin.impl.mediation.d */
/* loaded from: classes.dex */
public class C1392d {

    /* renamed from: a */
    private final C1662k f977a;

    /* renamed from: b */
    private final Map<String, C1396b> f978b = new HashMap(4);

    /* renamed from: c */
    private final Object f979c = new Object();

    /* renamed from: d */
    private final Map<String, AbstractC1334a> f980d = new HashMap(4);

    /* renamed from: e */
    private final Object f981e = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.d$a */
    /* loaded from: classes.dex */
    public static class C1394a implements AbstractC1363a.InterfaceC1364a {

        /* renamed from: a */
        private final C1662k f988a;

        /* renamed from: b */
        private final Activity f989b;

        /* renamed from: c */
        private final C1392d f990c;

        /* renamed from: d */
        private final C1396b f991d;

        /* renamed from: e */
        private final MaxAdFormat f992e;

        /* renamed from: f */
        private C1702i f993f;

        private C1394a(C1702i c1702i, C1396b c1396b, MaxAdFormat maxAdFormat, C1392d c1392d, C1662k c1662k, Activity activity) {
            this.f988a = c1662k;
            this.f989b = activity;
            this.f990c = c1392d;
            this.f991d = c1396b;
            this.f992e = maxAdFormat;
            this.f993f = c1702i;
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            if (this.f988a.m6655a(C1567a.f1618Q, this.f992e) && this.f991d.f998b < ((Integer) this.f988a.m6656a(C1567a.f1617P)).intValue()) {
                C1396b.m7573d(this.f991d);
                final int pow = (int) Math.pow(2.0d, this.f991d.f998b);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1394a c1394a = C1394a.this;
                        c1394a.f993f = new C1702i.C1704a(c1394a.f993f).m6361a("retry_delay_sec", String.valueOf(pow)).m6361a("retry_attempt", String.valueOf(C1394a.this.f991d.f998b)).m6364a();
                        C1394a.this.f990c.m7586b(str, C1394a.this.f992e, C1394a.this.f993f, C1394a.this.f989b, C1394a.this);
                    }
                }, TimeUnit.SECONDS.toMillis(pow));
                return;
            }
            this.f991d.f998b = 0;
            this.f991d.f997a.set(false);
            if (this.f991d.f999c != null) {
                C1728i.m6234a(this.f991d.f999c, str, maxError);
                this.f991d.f999c = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            AbstractC1334a abstractC1334a = (AbstractC1334a) maxAd;
            this.f991d.f998b = 0;
            if (this.f991d.f999c != null) {
                abstractC1334a.m7812f().m7307c().m7824a(this.f991d.f999c);
                this.f991d.f999c.onAdLoaded(abstractC1334a);
                if (abstractC1334a.m7815c().endsWith("load")) {
                    this.f991d.f999c.onAdRevenuePaid(abstractC1334a);
                }
                this.f991d.f999c = null;
                if ((this.f988a.m6625b(C1567a.f1616O).contains(maxAd.getAdUnitId()) || this.f988a.m6655a(C1567a.f1615N, maxAd.getFormat())) && !this.f988a.m6679H().m7351a() && !this.f988a.m6679H().m7347b()) {
                    this.f990c.m7586b(maxAd.getAdUnitId(), maxAd.getFormat(), this.f993f, this.f989b, this);
                    return;
                }
            } else {
                this.f990c.m7593a(abstractC1334a);
            }
            this.f991d.f997a.set(false);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.d$b */
    /* loaded from: classes.dex */
    public static class C1396b {

        /* renamed from: a */
        private final AtomicBoolean f997a;

        /* renamed from: b */
        private int f998b;

        /* renamed from: c */
        private volatile AbstractC1363a.InterfaceC1364a f999c;

        private C1396b() {
            this.f997a = new AtomicBoolean();
        }

        /* renamed from: d */
        static /* synthetic */ int m7573d(C1396b c1396b) {
            int i = c1396b.f998b;
            c1396b.f998b = i + 1;
            return i;
        }
    }

    public C1392d(C1662k c1662k) {
        this.f977a = c1662k;
    }

    /* renamed from: a */
    private AbstractC1334a m7589a(String str) {
        AbstractC1334a abstractC1334a;
        synchronized (this.f981e) {
            abstractC1334a = this.f980d.get(str);
            this.f980d.remove(str);
        }
        return abstractC1334a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7593a(AbstractC1334a abstractC1334a) {
        synchronized (this.f981e) {
            if (this.f980d.containsKey(abstractC1334a.getAdUnitId())) {
                C1710r.m6310i("AppLovinSdk", "Ad in cache already: " + abstractC1334a.getAdUnitId());
            }
            this.f980d.put(abstractC1334a.getAdUnitId(), abstractC1334a);
        }
    }

    /* renamed from: b */
    private C1396b m7587b(String str) {
        C1396b c1396b;
        synchronized (this.f979c) {
            c1396b = this.f978b.get(str);
            if (c1396b == null) {
                c1396b = new C1396b();
                this.f978b.put(str, c1396b);
            }
        }
        return c1396b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7586b(final String str, final MaxAdFormat maxAdFormat, final C1702i c1702i, final Activity activity, final AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        this.f977a.m6670Q().m6793a(new C1369b(maxAdFormat, activity, this.f977a, new C1369b.InterfaceC1373a() { // from class: com.applovin.impl.mediation.d.1
            @Override // com.applovin.impl.mediation.p014b.C1369b.InterfaceC1373a
            /* renamed from: a */
            public void mo7585a(JSONArray jSONArray) {
                C1392d.this.f977a.m6670Q().m6794a(new C1374c(str, maxAdFormat, c1702i, jSONArray, activity, C1392d.this.f977a, interfaceC1364a));
            }
        }), C1391c.m7598a(maxAdFormat));
    }

    /* renamed from: a */
    public void m7588a(String str, MaxAdFormat maxAdFormat, C1702i c1702i, Activity activity, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        AbstractC1334a m7589a = !this.f977a.m6679H().m7347b() ? m7589a(str) : null;
        if (m7589a != null) {
            m7589a.m7812f().m7307c().m7824a(interfaceC1364a);
            interfaceC1364a.onAdLoaded(m7589a);
            if (m7589a.m7815c().endsWith("load")) {
                interfaceC1364a.onAdRevenuePaid(m7589a);
            }
        }
        C1396b m7587b = m7587b(str);
        if (m7587b.f997a.compareAndSet(false, true)) {
            if (m7589a == null) {
                m7587b.f999c = interfaceC1364a;
            }
            m7586b(str, maxAdFormat, c1702i, activity, new C1394a(c1702i, m7587b, maxAdFormat, this, this.f977a, activity));
            return;
        }
        if (m7587b.f999c != null && m7587b.f999c != interfaceC1364a) {
            C1710r.m6311h("MaxInterstitialAd", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
        }
        m7587b.f999c = interfaceC1364a;
    }
}
