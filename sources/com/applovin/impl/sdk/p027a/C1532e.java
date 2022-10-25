package com.applovin.impl.sdk.p027a;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.e */
/* loaded from: classes.dex */
public class C1532e {

    /* renamed from: a */
    private final C1662k f1492a;

    /* renamed from: b */
    private final C1710r f1493b;

    /* renamed from: d */
    private final Map<MaxAdFormat, RunnableC1533f> f1495d;

    /* renamed from: g */
    private volatile boolean f1498g;

    /* renamed from: e */
    private LinkedHashSet<C1531d> f1496e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f1497f = new Object();

    /* renamed from: c */
    private final AtomicBoolean f1494c = new AtomicBoolean();

    public C1532e(C1662k c1662k) {
        this.f1492a = c1662k;
        this.f1493b = c1662k.m6588z();
        HashMap hashMap = new HashMap(5);
        this.f1495d = hashMap;
        hashMap.put(MaxAdFormat.BANNER, new RunnableC1533f(MaxAdFormat.BANNER, c1662k));
        hashMap.put(MaxAdFormat.LEADER, new RunnableC1533f(MaxAdFormat.LEADER, c1662k));
        hashMap.put(MaxAdFormat.MREC, new RunnableC1533f(MaxAdFormat.MREC, c1662k));
        hashMap.put(MaxAdFormat.INTERSTITIAL, new RunnableC1533f(MaxAdFormat.INTERSTITIAL, c1662k));
        hashMap.put(MaxAdFormat.REWARDED, new RunnableC1533f(MaxAdFormat.REWARDED, c1662k));
        hashMap.put(MaxAdFormat.REWARDED_INTERSTITIAL, new RunnableC1533f(MaxAdFormat.REWARDED_INTERSTITIAL, c1662k));
    }

    /* renamed from: a */
    private boolean m7201a() {
        return ((Boolean) this.f1492a.m6656a(C1568b.f1883eT)).booleanValue() && this.f1494c.get();
    }

    /* renamed from: c */
    private LinkedHashSet<C1531d> m7195c(JSONArray jSONArray) {
        LinkedHashSet<C1531d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            linkedHashSet.add(C1531d.m7214a(JsonUtils.getString(jSONObject, "id", null), jSONObject));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public void m7200a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        if (m7201a()) {
            this.f1495d.get(appLovinAdBase.getAdZone().m7212b()).m7193a(appLovinAdBase, z, z2);
        }
    }

    /* renamed from: a */
    public void m7199a(C1531d c1531d, boolean z, int i) {
        if (m7201a()) {
            MaxAdFormat m7212b = c1531d.m7212b();
            if (m7212b != null) {
                this.f1495d.get(m7212b).m7188a(c1531d, z, i);
            } else {
                RunnableC1533f.m7191a(c1531d, i, this.f1492a);
            }
        }
    }

    /* renamed from: a */
    public void m7198a(AbstractC1537g abstractC1537g) {
        if (m7201a()) {
            this.f1495d.get(abstractC1537g.getAdZone().m7212b()).m7194a();
        }
    }

    /* renamed from: a */
    public void m7197a(JSONArray jSONArray) {
        if (((Boolean) this.f1492a.m6656a(C1568b.f1883eT)).booleanValue()) {
            if (this.f1494c.compareAndSet(false, true)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
                    C1531d m7214a = C1531d.m7214a(JsonUtils.getString(jSONObject, "id", null), jSONObject);
                    MaxAdFormat m7212b = m7214a.m7212b();
                    if (m7212b == MaxAdFormat.BANNER) {
                        arrayList.add(m7214a);
                    } else if (m7212b == MaxAdFormat.LEADER) {
                        arrayList2.add(m7214a);
                    } else if (m7212b == MaxAdFormat.MREC) {
                        arrayList3.add(m7214a);
                    } else if (m7212b == MaxAdFormat.INTERSTITIAL) {
                        arrayList4.add(m7214a);
                    } else if (m7212b == MaxAdFormat.REWARDED_INTERSTITIAL) {
                        arrayList6.add(m7214a);
                    } else if (m7212b == MaxAdFormat.REWARDED) {
                        arrayList5.add(m7214a);
                    }
                }
                this.f1495d.get(MaxAdFormat.BANNER).m7182a(arrayList);
                this.f1495d.get(MaxAdFormat.LEADER).m7182a(arrayList2);
                this.f1495d.get(MaxAdFormat.MREC).m7182a(arrayList3);
                this.f1495d.get(MaxAdFormat.INTERSTITIAL).m7182a(arrayList4);
                this.f1495d.get(MaxAdFormat.REWARDED).m7182a(arrayList5);
                this.f1495d.get(MaxAdFormat.REWARDED_INTERSTITIAL).m7182a(arrayList6);
            }
        }
    }

    /* renamed from: b */
    public LinkedHashSet<C1531d> m7196b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new LinkedHashSet<>();
        }
        LinkedHashSet<C1531d> linkedHashSet = new LinkedHashSet<>(jSONArray.length());
        synchronized (this.f1497f) {
            if (!this.f1498g) {
                C1710r c1710r = this.f1493b;
                c1710r.m6319b("AdZoneManager", "Found " + jSONArray.length() + " zone(s)...");
                linkedHashSet = m7195c(jSONArray);
                this.f1496e = linkedHashSet;
                this.f1498g = true;
            }
        }
        return linkedHashSet;
    }
}
