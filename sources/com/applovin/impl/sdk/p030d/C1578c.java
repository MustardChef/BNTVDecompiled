package com.applovin.impl.sdk.p030d;

import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p031e.AbstractC1633t;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.android.gms.cast.HlsSegmentFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.c */
/* loaded from: classes.dex */
public class C1578c {

    /* renamed from: a */
    private final C1662k f2005a;

    /* renamed from: b */
    private final C1710r f2006b;

    /* renamed from: c */
    private final Object f2007c = new Object();

    /* renamed from: d */
    private final C1583c f2008d = new C1583c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.d.c$a */
    /* loaded from: classes.dex */
    public static class C1581a {

        /* renamed from: a */
        private final C1662k f2011a;

        /* renamed from: b */
        private final JSONObject f2012b;

        private C1581a(String str, String str2, String str3, C1662k c1662k) {
            JSONObject jSONObject = new JSONObject();
            this.f2012b = jSONObject;
            this.f2011a = c1662k;
            JsonUtils.putString(jSONObject, "pk", str);
            JsonUtils.putLong(jSONObject, HlsSegmentFormat.f9702TS, System.currentTimeMillis());
            if (StringUtils.isValidString(str2)) {
                JsonUtils.putString(jSONObject, "sk1", str2);
            }
            if (StringUtils.isValidString(str3)) {
                JsonUtils.putString(jSONObject, "sk2", str3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m6936a() throws OutOfMemoryError {
            return this.f2012b.toString();
        }

        /* renamed from: a */
        void m6934a(String str, long j) {
            m6932b(str, JsonUtils.getLong(this.f2012b, str, 0L) + j);
        }

        /* renamed from: a */
        void m6933a(String str, String str2) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.f2012b, str, new JSONArray());
            jSONArray.put(str2);
            JsonUtils.putJsonArray(this.f2012b, str, jSONArray);
        }

        /* renamed from: b */
        void m6932b(String str, long j) {
            JsonUtils.putLong(this.f2012b, str, j);
        }

        public String toString() {
            return "AdEventStats{stats='" + this.f2012b + "'}";
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.c$b */
    /* loaded from: classes.dex */
    public class C1582b {

        /* renamed from: b */
        private final AppLovinAdBase f2014b;

        /* renamed from: c */
        private final C1578c f2015c;

        public C1582b(AppLovinAdBase appLovinAdBase, C1578c c1578c) {
            this.f2014b = appLovinAdBase;
            this.f2015c = c1578c;
        }

        /* renamed from: a */
        public C1582b m6930a(C1577b c1577b) {
            this.f2015c.m6953a(c1577b, 1L, this.f2014b);
            return this;
        }

        /* renamed from: a */
        public C1582b m6929a(C1577b c1577b, long j) {
            this.f2015c.m6945b(c1577b, j, this.f2014b);
            return this;
        }

        /* renamed from: a */
        public C1582b m6928a(C1577b c1577b, String str) {
            this.f2015c.m6952a(c1577b, str, this.f2014b);
            return this;
        }

        /* renamed from: a */
        public void m6931a() {
            this.f2015c.m6938e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.d.c$c */
    /* loaded from: classes.dex */
    public class C1583c extends LinkedHashMap<String, C1581a> {
        private C1583c() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, C1581a> entry) {
            return size() > ((Integer) C1578c.this.f2005a.m6656a(C1568b.f1890ea)).intValue();
        }
    }

    public C1578c(C1662k c1662k) {
        this.f2005a = c1662k;
        this.f2006b = c1662k.m6588z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6953a(C1577b c1577b, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null || c1577b == null || !((Boolean) this.f2005a.m6656a(C1568b.f1835dX)).booleanValue()) {
            return;
        }
        synchronized (this.f2007c) {
            m6946b(appLovinAdBase).m6934a(((Boolean) this.f2005a.m6656a(C1568b.f1891eb)).booleanValue() ? c1577b.m6956b() : c1577b.m6958a(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6952a(C1577b c1577b, String str, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null || c1577b == null || !((Boolean) this.f2005a.m6656a(C1568b.f1835dX)).booleanValue()) {
            return;
        }
        synchronized (this.f2008d) {
            m6946b(appLovinAdBase).m6933a(((Boolean) this.f2005a.m6656a(C1568b.f1891eb)).booleanValue() ? c1577b.m6956b() : c1577b.m6958a(), str);
        }
    }

    /* renamed from: a */
    private void m6948a(JSONObject jSONObject) {
        AbstractC1633t<Object> abstractC1633t = new AbstractC1633t<Object>(C1688c.m6487a(this.f2005a).mo6391a(m6942c()).mo6380c(m6940d()).mo6390a(C1725g.m6256e(this.f2005a)).mo6384b(ShareTarget.METHOD_POST).mo6389a(jSONObject).mo6374d(((Boolean) this.f2005a.m6656a(C1568b.f1913ex)).booleanValue()).mo6387b(((Integer) this.f2005a.m6656a(C1568b.f1836dY)).intValue()).mo6394a(((Integer) this.f2005a.m6656a(C1568b.f1837dZ)).intValue()).mo6395a(), this.f2005a) { // from class: com.applovin.impl.sdk.d.c.1
            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, Object obj) {
                C1710r c1710r = C1578c.this.f2006b;
                c1710r.m6314e("AdEventStatsManager", "Failed to submitted ad stats: " + i);
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(Object obj, int i) {
                C1710r c1710r = C1578c.this.f2006b;
                c1710r.m6319b("AdEventStatsManager", "Ad stats submitted: " + i);
            }
        };
        abstractC1633t.m6770a(C1568b.f1671aQ);
        abstractC1633t.m6766b(C1568b.f1672aR);
        this.f2005a.m6670Q().m6793a(abstractC1633t, C1620o.EnumC1622a.BACKGROUND);
    }

    /* renamed from: b */
    private C1581a m6946b(AppLovinAdBase appLovinAdBase) {
        C1581a c1581a;
        synchronized (this.f2007c) {
            String primaryKey = appLovinAdBase.getPrimaryKey();
            c1581a = this.f2008d.get(primaryKey);
            if (c1581a == null) {
                C1581a c1581a2 = new C1581a(primaryKey, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2(), this.f2005a);
                this.f2008d.put(primaryKey, c1581a2);
                c1581a = c1581a2;
            }
        }
        return c1581a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6945b(C1577b c1577b, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase == null || c1577b == null || !((Boolean) this.f2005a.m6656a(C1568b.f1835dX)).booleanValue()) {
            return;
        }
        synchronized (this.f2007c) {
            m6946b(appLovinAdBase).m6932b(((Boolean) this.f2005a.m6656a(C1568b.f1891eb)).booleanValue() ? c1577b.m6956b() : c1577b.m6958a(), j);
        }
    }

    /* renamed from: c */
    private String m6942c() {
        return C1725g.m6264a("2.0/s", this.f2005a);
    }

    /* renamed from: d */
    private String m6940d() {
        return C1725g.m6259b("2.0/s", this.f2005a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6938e() {
        if (((Boolean) this.f2005a.m6656a(C1568b.f1835dX)).booleanValue()) {
            this.f2005a.m6670Q().m6783b().execute(new Runnable() { // from class: com.applovin.impl.sdk.d.c.2
                @Override // java.lang.Runnable
                public void run() {
                    HashSet hashSet;
                    synchronized (C1578c.this.f2007c) {
                        hashSet = new HashSet(C1578c.this.f2008d.size());
                        for (C1581a c1581a : C1578c.this.f2008d.values()) {
                            try {
                                hashSet.add(c1581a.m6936a());
                            } catch (OutOfMemoryError e) {
                                C1710r c1710r = C1578c.this.f2006b;
                                c1710r.m6318b("AdEventStatsManager", "Failed to serialize " + c1581a + " due to OOM error", e);
                                C1578c.this.m6947b();
                            }
                        }
                    }
                    C1578c.this.f2005a.m6653a((C1570d<C1570d<HashSet>>) C1570d.f1948t, (C1570d<HashSet>) hashSet);
                }
            });
        }
    }

    /* renamed from: a */
    public C1582b m6954a(AppLovinAdBase appLovinAdBase) {
        return new C1582b(appLovinAdBase, this);
    }

    /* renamed from: a */
    public void m6955a() {
        if (((Boolean) this.f2005a.m6656a(C1568b.f1835dX)).booleanValue()) {
            Set<String> set = (Set) this.f2005a.m6623b((C1570d<C1570d<HashSet>>) C1570d.f1948t, (C1570d<HashSet>) new HashSet(0));
            this.f2005a.m6624b(C1570d.f1948t);
            if (set == null || set.isEmpty()) {
                this.f2006b.m6319b("AdEventStatsManager", "No serialized ad events found");
                return;
            }
            C1710r c1710r = this.f2006b;
            c1710r.m6319b("AdEventStatsManager", "De-serializing " + set.size() + " stat ad events");
            JSONArray jSONArray = new JSONArray();
            for (String str : set) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (JSONException e) {
                    C1710r c1710r2 = this.f2006b;
                    c1710r2.m6318b("AdEventStatsManager", "Failed to parse: " + str, e);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("stats", jSONArray);
                m6948a(jSONObject);
            } catch (JSONException e2) {
                this.f2006b.m6318b("AdEventStatsManager", "Failed to create stats to submit", e2);
            }
        }
    }

    /* renamed from: b */
    public void m6947b() {
        synchronized (this.f2007c) {
            this.f2006b.m6319b("AdEventStatsManager", "Clearing ad stats...");
            this.f2008d.clear();
        }
    }
}
