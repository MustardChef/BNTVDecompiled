package com.applovin.impl.mediation.p014b;

import android.app.Activity;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p015c.C1390b;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.C1780y;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p030d.C1587g;
import com.applovin.impl.sdk.p031e.AbstractC1633t;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.c */
/* loaded from: classes.dex */
public class C1374c extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final String f930a;

    /* renamed from: c */
    private final MaxAdFormat f931c;

    /* renamed from: d */
    private final C1702i f932d;

    /* renamed from: e */
    private final JSONArray f933e;

    /* renamed from: f */
    private final Activity f934f;

    /* renamed from: g */
    private final AbstractC1363a.InterfaceC1364a f935g;

    public C1374c(String str, MaxAdFormat maxAdFormat, C1702i c1702i, JSONArray jSONArray, Activity activity, C1662k c1662k, AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        super("TaskFetchMediatedAd " + str, c1662k);
        this.f930a = str;
        this.f931c = maxAdFormat;
        this.f932d = c1702i;
        this.f933e = jSONArray;
        this.f934f = activity;
        this.f935g = interfaceC1364a;
    }

    /* renamed from: a */
    private String m7653a() {
        return C1390b.m7606a(this.f2058b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7652a(int i, String str) {
        m6879d("Unable to fetch " + this.f930a + " ad: server returned " + i);
        if (i == -800) {
            this.f2058b.m6669R().m6893a(C1586f.f2046o);
        }
        C1728i.m6234a(this.f935g, this.f930a, i == -1009 ? new MaxErrorImpl(-1009, str) : i == -1001 ? new MaxErrorImpl(-1001, str) : StringUtils.isValidString(str) ? new MaxErrorImpl(-1000, str) : new MaxErrorImpl(-1));
    }

    /* renamed from: a */
    private void m7649a(C1587g c1587g) {
        long m6890b = c1587g.m6890b(C1586f.f2034c);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m6890b > TimeUnit.MINUTES.toMillis(((Integer) this.f2058b.m6656a(C1568b.f1850dm)).intValue())) {
            c1587g.m6889b(C1586f.f2034c, currentTimeMillis);
            c1587g.m6887c(C1586f.f2035d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7648a(JSONObject jSONObject) {
        try {
            C1725g.m6257d(jSONObject, this.f2058b);
            C1725g.m6258c(jSONObject, this.f2058b);
            C1725g.m6255e(jSONObject, this.f2058b);
            C1725g.m6249h(jSONObject, this.f2058b);
            C1390b.m7605a(jSONObject, this.f2058b);
            C1390b.m7603b(jSONObject, this.f2058b);
            if (this.f931c != MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, null))) {
                C1710r.m6310i(m6878e(), "Ad format requested does not match ad unit id's format.");
            }
            this.f2058b.m6670Q().m6794a(m7646b(jSONObject));
        } catch (Throwable th) {
            m6883a("Unable to process mediated ad response", th);
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    /* renamed from: b */
    private C1378e m7646b(JSONObject jSONObject) {
        return new C1378e(this.f930a, this.f931c, jSONObject, this.f934f, this.f2058b, this.f935g);
    }

    /* renamed from: b */
    private String m7647b() {
        return C1390b.m7604b(this.f2058b);
    }

    /* renamed from: c */
    private Map<String, String> m7645c() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("AppLovin-Ad-Unit-Id", this.f930a);
        hashMap.put("AppLovin-Ad-Format", this.f931c.getLabel());
        return hashMap;
    }

    /* renamed from: c */
    private void m7644c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray((Collection) this.f2058b.m6686A().m7329c()));
            jSONObject2.put("installed", C1391c.m7599a(this.f2058b));
            jSONObject2.put("initialized", this.f2058b.m6685B().m7336d());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f2058b.m6685B().m7337c()));
            jSONObject2.put("loaded_classnames", new JSONArray((Collection) this.f2058b.m6686A().m7335a()));
            jSONObject2.put("failed_classnames", new JSONArray((Collection) this.f2058b.m6686A().m7330b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            m6883a("Failed to populate adapter classNames", e);
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    /* renamed from: d */
    private void m7643d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f933e;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    /* renamed from: e */
    private void m7642e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.f930a);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.f931c.getLabel());
        Map<String, String> stringMap = BundleUtils.toStringMap(this.f932d.m6365a());
        String m6307a = this.f2058b.m6683D().m6307a(this.f930a);
        if (StringUtils.isValidString(m6307a)) {
            stringMap.put("previous_winning_network", m6307a);
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(stringMap));
        jSONObject2.put("n", String.valueOf(this.f2058b.m6635ae().m6300a(this.f930a)));
        jSONObject.put("ad_info", jSONObject2);
    }

    /* renamed from: h */
    private JSONObject m7641h() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f2058b.m6667T().m6557a(null, false, true));
        m7642e(jSONObject);
        m7643d(jSONObject);
        m7644c(jSONObject);
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        m6884a("Fetching next ad for ad unit id: " + this.f930a + " and format: " + this.f931c);
        if (((Boolean) this.f2058b.m6656a(C1568b.f1817dF)).booleanValue() && Utils.isVPNConnected()) {
            m6884a("User is connected to a VPN");
        }
        C1587g m6669R = this.f2058b.m6669R();
        m6669R.m6893a(C1586f.f2045n);
        if (m6669R.m6890b(C1586f.f2034c) == 0) {
            m6669R.m6889b(C1586f.f2034c, System.currentTimeMillis());
        }
        try {
            JSONObject m7641h = m7641h();
            HashMap hashMap = new HashMap();
            hashMap.put("rid", UUID.randomUUID().toString());
            if (!((Boolean) this.f2058b.m6656a(C1568b.f1903en)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2058b.m6590x());
            }
            if (this.f2058b.m6679H().m7351a()) {
                hashMap.put("test_mode", "1");
            }
            String m7345c = this.f2058b.m6679H().m7345c();
            if (StringUtils.isValidString(m7345c)) {
                hashMap.put("filter_ad_network", m7345c);
                if (!this.f2058b.m6679H().m7351a()) {
                    hashMap.put("fhkZsVqYC7", "1");
                }
                if (this.f2058b.m6679H().m7347b()) {
                    hashMap.put("force_ad_network", m7345c);
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.putAll(C1780y.m6107b());
            hashMap2.putAll(m7645c());
            m7649a(m6669R);
            AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(C1688c.m6487a(this.f2058b).mo6384b(ShareTarget.METHOD_POST).mo6383b(hashMap2).mo6391a(m7653a()).mo6380c(m7647b()).mo6390a((Map<String, String>) hashMap).mo6389a(m7641h).mo6374d(((Boolean) this.f2058b.m6656a(C1567a.f1621T)).booleanValue()).mo6392a((C1688c.C1689a) new JSONObject()).mo6387b(((Long) this.f2058b.m6656a(C1567a.f1628f)).intValue()).mo6394a(((Integer) this.f2058b.m6656a(C1568b.f1781cV)).intValue()).mo6381c(((Long) this.f2058b.m6656a(C1567a.f1627e)).intValue()).m6467e(true).mo6395a(), this.f2058b) { // from class: com.applovin.impl.mediation.b.c.1
                @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6491a(int i, String str, JSONObject jSONObject) {
                    C1374c.this.m7652a(i, str);
                }

                @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
                /* renamed from: a */
                public void mo6490a(JSONObject jSONObject, int i) {
                    if (i != 200) {
                        C1374c.this.m7652a(i, (String) null);
                        return;
                    }
                    JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.f2179d.m6501a());
                    JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.f2179d.m6498b());
                    C1374c.this.m7648a(jSONObject);
                }
            };
            abstractC1633t.m6770a(C1567a.f1625c);
            abstractC1633t.m6766b(C1567a.f1626d);
            this.f2058b.m6670Q().m6794a(abstractC1633t);
        } catch (Throwable th) {
            m6883a("Unable to fetch ad " + this.f930a, th);
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
