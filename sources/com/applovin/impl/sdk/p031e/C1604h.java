package com.applovin.impl.sdk.p031e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1648h;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1673m;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.h */
/* loaded from: classes.dex */
public class C1604h extends AbstractRunnableC1589a {

    /* renamed from: a */
    private static final AtomicBoolean f2085a = new AtomicBoolean();

    /* renamed from: c */
    private final int f2086c;

    /* renamed from: d */
    private final Object f2087d;

    /* renamed from: e */
    private InterfaceC1606a f2088e;

    /* renamed from: com.applovin.impl.sdk.e.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1606a {
        /* renamed from: a */
        void mo6587a(JSONObject jSONObject);
    }

    /* renamed from: com.applovin.impl.sdk.e.h$b */
    /* loaded from: classes.dex */
    private class C1607b extends AbstractRunnableC1589a {
        public C1607b(C1662k c1662k) {
            super("TaskTimeoutFetchBasicSettings", c1662k, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C1604h.this.f2087d) {
                if (C1604h.this.f2088e != null) {
                    m6879d("Timing out fetch basic settings...");
                    C1604h.this.m6828a(new JSONObject());
                }
            }
        }
    }

    public C1604h(int i, C1662k c1662k, InterfaceC1606a interfaceC1606a) {
        super("TaskFetchBasicSettings", c1662k, true);
        this.f2087d = new Object();
        this.f2086c = i;
        this.f2088e = interfaceC1606a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6828a(JSONObject jSONObject) {
        synchronized (this.f2087d) {
            InterfaceC1606a interfaceC1606a = this.f2088e;
            if (interfaceC1606a != null) {
                interfaceC1606a.mo6587a(jSONObject);
                this.f2088e = null;
            }
        }
    }

    /* renamed from: c */
    private String m6825c() {
        return C1725g.m6263a((String) this.f2058b.m6656a(C1568b.f1667aM), "5.0/i", m6880d());
    }

    /* renamed from: h */
    private String m6824h() {
        return C1725g.m6263a((String) this.f2058b.m6656a(C1568b.f1668aN), "5.0/i", m6880d());
    }

    /* renamed from: a */
    protected Map<String, String> m6831a() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f2058b.m6656a(C1568b.f1903en)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2058b.m6590x());
        }
        Boolean m6713a = C1648h.m6718b().m6713a(m6877f());
        if (m6713a != null) {
            hashMap.put("huc", m6713a.toString());
        }
        Boolean m6713a2 = C1648h.m6723a().m6713a(m6877f());
        if (m6713a2 != null) {
            hashMap.put("aru", m6713a2.toString());
        }
        Boolean m6713a3 = C1648h.m6716c().m6713a(m6877f());
        if (m6713a3 != null) {
            hashMap.put("dns", m6713a3.toString());
        }
        return hashMap;
    }

    /* renamed from: b */
    protected JSONObject m6827b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            jSONObject.put("is_cross_promo", this.f2058b.m6611e());
            jSONObject.put("init_count", this.f2086c);
            jSONObject.put("server_installed_at", this.f2058b.m6656a(C1568b.f1685ae));
            String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
            if (StringUtils.isValidString(userEngagementSdkVersion)) {
                jSONObject.put("ue_sdk_version", userEngagementSdkVersion);
            }
            if (this.f2058b.m6673N()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f2058b.m6672O()) {
                jSONObject.put("first_install_v2", true);
            }
            String str = (String) this.f2058b.m6656a(C1568b.f1863dz);
            if (StringUtils.isValidString(str)) {
                jSONObject.put("plugin_version", str);
            }
            String m6595s = this.f2058b.m6595s();
            if (StringUtils.isValidString(m6595s)) {
                jSONObject.put("mediation_provider", m6595s);
            }
            jSONObject.put("installed_mediation_adapters", C1391c.m7599a(this.f2058b));
            Map<String, Object> m6546g = this.f2058b.m6667T().m6546g();
            jSONObject.put("package_name", m6546g.get("package_name"));
            jSONObject.put("app_version", m6546g.get("app_version"));
            jSONObject.put("test_ads", m6546g.get("test_ads"));
            jSONObject.put("debug", m6546g.get("debug"));
            jSONObject.put("tg", m6546g.get("tg"));
            jSONObject.put("target_sdk", m6546g.get("target_sdk"));
            if (this.f2058b.m6598p().getInitializationAdUnitIds().size() > 0) {
                List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(this.f2058b.m6598p().getInitializationAdUnitIds());
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(removeTrimmedEmptyStrings, removeTrimmedEmptyStrings.size()));
            }
            Map<String, Object> m6555b = this.f2058b.m6667T().m6555b();
            jSONObject.put("platform", m6555b.get("platform"));
            jSONObject.put("os", m6555b.get("os"));
            jSONObject.put("locale", m6555b.get("locale"));
            jSONObject.put("brand", m6555b.get("brand"));
            jSONObject.put("brand_name", m6555b.get("brand_name"));
            jSONObject.put("hardware", m6555b.get("hardware"));
            jSONObject.put("model", m6555b.get("model"));
            jSONObject.put("revision", m6555b.get("revision"));
            if (m6555b.containsKey("gms_mb")) {
                jSONObject.put("gms_mb", m6555b.get("gms_mb"));
            }
            C1673m.C1677a m6543j = this.f2058b.m6667T().m6543j();
            jSONObject.put("dnt", m6543j.f2333a);
            if (StringUtils.isValidString(m6543j.f2334b)) {
                jSONObject.put("idfa", m6543j.f2334b);
            }
            String name = this.f2058b.m6597q().getName();
            if (StringUtils.isValidString(name)) {
                jSONObject.put("user_segment_name", StringUtils.encodeUrlString(name));
            }
            if (((Boolean) this.f2058b.m6656a(C1568b.f1858du)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f2058b.m6600n());
            }
            if (((Boolean) this.f2058b.m6656a(C1568b.f1860dw)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f2058b.m6599o());
            }
        } catch (JSONException e) {
            m6883a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (f2085a.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.f2058b.m6677J());
            } catch (Throwable th) {
                m6883a("Cannot update security provider", th);
            }
        }
        Map<String, String> m6831a = m6831a();
        C1688c mo6395a = C1688c.m6487a(this.f2058b).mo6391a(m6825c()).mo6380c(m6824h()).mo6390a(m6831a).mo6389a(m6827b()).mo6374d(((Boolean) this.f2058b.m6656a(C1568b.f1909et)).booleanValue()).mo6384b(ShareTarget.METHOD_POST).mo6392a((C1688c.C1689a) new JSONObject()).mo6394a(((Integer) this.f2058b.m6656a(C1568b.f1839db)).intValue()).mo6381c(((Integer) this.f2058b.m6656a(C1568b.f1842de)).intValue()).mo6387b(((Integer) this.f2058b.m6656a(C1568b.f1838da)).intValue()).m6467e(true).mo6395a();
        this.f2058b.m6670Q().m6792a(new C1607b(this.f2058b), C1620o.EnumC1622a.TIMEOUT, ((Integer) this.f2058b.m6656a(C1568b.f1838da)).intValue() + 250);
        AbstractC1633t<JSONObject> abstractC1633t = new AbstractC1633t<JSONObject>(mo6395a, this.f2058b, m6876g()) { // from class: com.applovin.impl.sdk.e.h.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                m6879d("Unable to fetch basic SDK settings: server returned " + i);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                C1604h.this.m6828a(jSONObject);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                C1604h.this.m6828a(jSONObject);
            }
        };
        abstractC1633t.m6770a(C1568b.f1667aM);
        abstractC1633t.m6766b(C1568b.f1668aN);
        this.f2058b.m6670Q().m6794a(abstractC1633t);
    }
}
