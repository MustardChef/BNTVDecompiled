package com.applovin.impl.sdk.p030d;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.g */
/* loaded from: classes.dex */
public class C1587g {

    /* renamed from: a */
    private final C1662k f2054a;

    /* renamed from: b */
    private final Map<String, Long> f2055b = new HashMap();

    public C1587g(C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f2054a = c1662k;
    }

    /* renamed from: e */
    private void m6885e() {
        try {
            this.f2054a.m6653a((C1570d<C1570d<String>>) C1570d.f1943o, (C1570d<String>) m6888c().toString());
        } catch (Throwable th) {
            this.f2054a.m6588z().m6318b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* renamed from: a */
    public long m6893a(C1586f c1586f) {
        return m6892a(c1586f, 1L);
    }

    /* renamed from: a */
    long m6892a(C1586f c1586f, long j) {
        long longValue;
        synchronized (this.f2055b) {
            Long l = this.f2055b.get(c1586f.m6898a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.f2055b.put(c1586f.m6898a(), Long.valueOf(longValue));
        }
        m6885e();
        return longValue;
    }

    /* renamed from: a */
    public void m6894a() {
        synchronized (this.f2055b) {
            this.f2055b.clear();
        }
        m6885e();
    }

    /* renamed from: b */
    public long m6890b(C1586f c1586f) {
        long longValue;
        synchronized (this.f2055b) {
            Long l = this.f2055b.get(c1586f.m6898a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* renamed from: b */
    public void m6891b() {
        synchronized (this.f2055b) {
            for (C1586f c1586f : C1586f.m6895b()) {
                this.f2055b.remove(c1586f.m6898a());
            }
            m6885e();
        }
    }

    /* renamed from: b */
    public void m6889b(C1586f c1586f, long j) {
        synchronized (this.f2055b) {
            this.f2055b.put(c1586f.m6898a(), Long.valueOf(j));
        }
        m6885e();
    }

    /* renamed from: c */
    public JSONObject m6888c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f2055b) {
            jSONObject = new JSONObject();
            for (Map.Entry<String, Long> entry : this.f2055b.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void m6887c(C1586f c1586f) {
        synchronized (this.f2055b) {
            this.f2055b.remove(c1586f.m6898a());
        }
        m6885e();
    }

    /* renamed from: d */
    public void m6886d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f2054a.m6623b((C1570d<C1570d<String>>) C1570d.f1943o, (C1570d<String>) JsonUtils.EMPTY_JSON));
            synchronized (this.f2055b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f2055b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f2054a.m6588z().m6318b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
