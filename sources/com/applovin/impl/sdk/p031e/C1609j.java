package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1780y;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p027a.RunnableC1533f;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p030d.C1587g;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.j */
/* loaded from: classes.dex */
public class C1609j extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final C1531d f2092a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2093c;

    /* renamed from: d */
    private final C1702i f2094d;

    public C1609j(C1531d c1531d, C1702i c1702i, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        this(c1531d, c1702i, appLovinAdLoadListener, "TaskFetchNextAd", c1662k);
    }

    C1609j(C1531d c1531d, C1702i c1702i, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1662k c1662k) {
        super(str, c1662k);
        this.f2092a = c1531d;
        this.f2093c = appLovinAdLoadListener;
        this.f2094d = c1702i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1609j(C1531d c1531d, AppLovinAdLoadListener appLovinAdLoadListener, String str, C1662k c1662k) {
        this(c1531d, null, appLovinAdLoadListener, str, c1662k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6820a(int i) {
        m6879d("Unable to fetch " + this.f2092a + " ad: server returned " + i);
        if (i == -800) {
            this.f2058b.m6669R().m6893a(C1586f.f2039h);
        }
        this.f2058b.m6661Z().m7199a(this.f2092a, m6812j(), i);
        this.f2093c.failedToReceiveAd(i);
    }

    /* renamed from: a */
    private void m6819a(C1587g c1587g) {
        long m6890b = c1587g.m6890b(C1586f.f2034c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m6890b > TimeUnit.MINUTES.toMillis(((Integer) this.f2058b.m6656a(C1568b.f1850dm)).intValue())) {
            c1587g.m6889b(C1586f.f2034c, currentTimeMillis);
            c1587g.m6887c(C1586f.f2035d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6816a(JSONObject jSONObject) {
        C1725g.m6257d(jSONObject, this.f2058b);
        C1725g.m6258c(jSONObject, this.f2058b);
        C1725g.m6251g(jSONObject, this.f2058b);
        C1725g.m6255e(jSONObject, this.f2058b);
        C1531d.m7213a(jSONObject);
        RunnableC1533f.C1535a c1535a = new RunnableC1533f.C1535a(this.f2092a, this.f2093c, this.f2058b);
        c1535a.m7175a(m6812j());
        this.f2058b.m6670Q().m6794a(new C1626p(jSONObject, this.f2092a, mo6808b(), c1535a, this.f2058b));
    }

    /* renamed from: i */
    private Map<String, String> m6813i() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.f2092a.m7218a());
        if (this.f2092a.m7210c() != null) {
            hashMap.put("AppLovin-Ad-Size", this.f2092a.m7210c().getLabel());
        }
        if (this.f2092a.m7209d() != null) {
            hashMap.put("AppLovin-Ad-Type", this.f2092a.m7209d().getLabel());
        }
        return hashMap;
    }

    /* renamed from: j */
    private boolean m6812j() {
        return (this instanceof C1611k) || (this instanceof C1608i);
    }

    /* renamed from: a */
    Map<String, String> mo6809a() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.f2092a.m7218a());
        if (this.f2092a.m7210c() != null) {
            hashMap.put("size", this.f2092a.m7210c().getLabel());
        }
        if (this.f2092a.m7209d() != null) {
            hashMap.put("require", this.f2092a.m7209d().getLabel());
        }
        hashMap.put("n", String.valueOf(this.f2058b.m6635ae().m6300a(this.f2092a.m7218a())));
        C1702i c1702i = this.f2094d;
        if (c1702i != null) {
            hashMap.putAll(BundleUtils.toStringMap(c1702i.m6365a()));
        }
        return hashMap;
    }

    /* renamed from: b */
    protected EnumC1528b mo6808b() {
        return this.f2092a.m7208e() ? EnumC1528b.APPLOVIN_PRIMARY_ZONE : EnumC1528b.APPLOVIN_CUSTOM_ZONE;
    }

    /* renamed from: c */
    protected String m6815c() {
        return C1725g.m6252g(this.f2058b);
    }

    /* renamed from: h */
    protected String m6814h() {
        return C1725g.m6250h(this.f2058b);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        String str;
        Map<String, String> map;
        m6884a("Fetching next ad of zone: " + this.f2092a);
        if (((Boolean) this.f2058b.m6656a(C1568b.f1817dF)).booleanValue() && Utils.isVPNConnected()) {
            m6884a("User is connected to a VPN");
        }
        C1587g m6669R = this.f2058b.m6669R();
        m6669R.m6893a(C1586f.f2032a);
        if (m6669R.m6890b(C1586f.f2034c) == 0) {
            m6669R.m6889b(C1586f.f2034c, System.currentTimeMillis());
        }
        try {
            if (((Boolean) this.f2058b.m6656a(C1568b.f1845dh)).booleanValue()) {
                str = ShareTarget.METHOD_POST;
                jSONObject = new JSONObject(this.f2058b.m6667T().m6557a(mo6809a(), false, true));
                map = new HashMap<>();
                map.put("rid", UUID.randomUUID().toString());
                if (!((Boolean) this.f2058b.m6656a(C1568b.f1903en)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2058b.m6590x());
                }
            } else {
                Map<String, String> stringifyObjectMap = Utils.stringifyObjectMap(this.f2058b.m6667T().m6557a(mo6809a(), false, false));
                jSONObject = null;
                str = ShareTarget.METHOD_GET;
                map = stringifyObjectMap;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(C1780y.m6107b());
            hashMap.putAll(m6813i());
            m6819a(m6669R);
            C1688c.C1689a m6467e = C1688c.m6487a(this.f2058b).mo6391a(m6815c()).mo6390a(map).mo6380c(m6814h()).mo6384b(str).mo6383b(hashMap).mo6392a((C1688c.C1689a) new JSONObject()).mo6394a(((Integer) this.f2058b.m6656a(C1568b.f1781cV)).intValue()).m6469a(((Boolean) this.f2058b.m6656a(C1568b.f1782cW)).booleanValue()).m6468b(((Boolean) this.f2058b.m6656a(C1568b.f1783cX)).booleanValue()).mo6387b(((Integer) this.f2058b.m6656a(C1568b.f1780cU)).intValue()).m6467e(true);
            if (jSONObject != null) {
                m6467e.mo6389a(jSONObject);
                m6467e.mo6374d(((Boolean) this.f2058b.m6656a(C1568b.f1911ev)).booleanValue());
            }
            AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(m6467e.mo6395a(), this.f2058b) { // from class: com.applovin.impl.sdk.e.j.1
                @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6491a(int i, String str2, JSONObject jSONObject2) {
                    C1609j.this.m6820a(i);
                }

                @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6490a(JSONObject jSONObject2, int i) {
                    if (i != 200) {
                        C1609j.this.m6820a(i);
                        return;
                    }
                    JsonUtils.putLong(jSONObject2, "ad_fetch_latency_millis", this.f2179d.m6501a());
                    JsonUtils.putLong(jSONObject2, "ad_fetch_response_size", this.f2179d.m6498b());
                    C1609j.this.m6816a(jSONObject2);
                }
            };
            abstractC1633t.m6770a(C1568b.f1669aO);
            abstractC1633t.m6766b(C1568b.f1670aP);
            this.f2058b.m6670Q().m6794a(abstractC1633t);
        } catch (Throwable th) {
            m6883a("Unable to fetch ad " + this.f2092a, th);
            m6820a(0);
        }
    }
}
