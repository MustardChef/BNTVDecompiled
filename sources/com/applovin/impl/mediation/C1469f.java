package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.f */
/* loaded from: classes.dex */
public class C1469f {

    /* renamed from: a */
    private final C1662k f1293a;

    /* renamed from: b */
    private final C1710r f1294b;

    /* renamed from: c */
    private final Object f1295c = new Object();

    /* renamed from: d */
    private final Map<String, Class<? extends MaxAdapter>> f1296d = new HashMap();

    /* renamed from: e */
    private final Set<String> f1297e = new HashSet();

    /* renamed from: f */
    private final Object f1298f = new Object();

    /* renamed from: g */
    private final Set<C1470a> f1299g = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.f$a */
    /* loaded from: classes.dex */
    public static class C1470a {

        /* renamed from: a */
        private final String f1300a;

        /* renamed from: b */
        private final String f1301b;

        /* renamed from: c */
        private final MaxAdFormat f1302c;

        /* renamed from: d */
        private final JSONObject f1303d;

        C1470a(String str, String str2, AbstractC1334a abstractC1334a, C1662k c1662k) {
            this.f1300a = str;
            this.f1301b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f1303d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (abstractC1334a == null) {
                this.f1302c = null;
                return;
            }
            this.f1302c = abstractC1334a.getFormat();
            if (abstractC1334a.getFormat() != null) {
                JsonUtils.putString(jSONObject, "format", abstractC1334a.getFormat().getLabel());
            }
        }

        /* renamed from: a */
        JSONObject m7328a() {
            return this.f1303d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1470a c1470a = (C1470a) obj;
            if (this.f1300a.equals(c1470a.f1300a) && this.f1301b.equals(c1470a.f1301b)) {
                MaxAdFormat maxAdFormat = this.f1302c;
                MaxAdFormat maxAdFormat2 = c1470a.f1302c;
                return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f1300a.hashCode() * 31) + this.f1301b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f1302c;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f1300a + "', operationTag='" + this.f1301b + "', format=" + this.f1302c + '}';
        }
    }

    public C1469f(C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f1293a = c1662k;
        this.f1294b = c1662k.m6588z();
    }

    /* renamed from: a */
    private C1471g m7333a(C1338e c1338e, Class<? extends MaxAdapter> cls) {
        try {
            return new C1471g(c1338e, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.f1293a.m6664W()), this.f1293a);
        } catch (Throwable th) {
            C1710r.m6316c("MediationAdapterManager", "Failed to load adapter: " + c1338e, th);
            return null;
        }
    }

    /* renamed from: a */
    private Class<? extends MaxAdapter> m7332a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            C1710r.m6310i("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1471g m7334a(C1338e c1338e) {
        Class<? extends MaxAdapter> m7332a;
        if (c1338e != null) {
            String m7763K = c1338e.m7763K();
            String m7764J = c1338e.m7764J();
            if (TextUtils.isEmpty(m7763K)) {
                C1710r c1710r = this.f1294b;
                c1710r.m6314e("MediationAdapterManager", "No adapter name provided for " + m7764J + ", not loading the adapter ");
                return null;
            } else if (TextUtils.isEmpty(m7764J)) {
                C1710r c1710r2 = this.f1294b;
                c1710r2.m6314e("MediationAdapterManager", "Unable to find default className for '" + m7763K + "'");
                return null;
            } else {
                synchronized (this.f1295c) {
                    if (this.f1297e.contains(m7764J)) {
                        C1710r c1710r3 = this.f1294b;
                        c1710r3.m6319b("MediationAdapterManager", "Not attempting to load " + m7763K + " due to prior errors");
                        return null;
                    }
                    if (this.f1296d.containsKey(m7764J)) {
                        m7332a = this.f1296d.get(m7764J);
                    } else {
                        m7332a = m7332a(m7764J);
                        if (m7332a == null) {
                            this.f1297e.add(m7764J);
                            return null;
                        }
                    }
                    C1471g m7333a = m7333a(c1338e, m7332a);
                    if (m7333a != null) {
                        C1710r c1710r4 = this.f1294b;
                        c1710r4.m6319b("MediationAdapterManager", "Loaded " + m7763K);
                        this.f1296d.put(m7764J, m7332a);
                        return m7333a;
                    }
                    C1710r c1710r5 = this.f1294b;
                    c1710r5.m6314e("MediationAdapterManager", "Failed to load " + m7763K);
                    this.f1297e.add(m7764J);
                    return null;
                }
            }
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    /* renamed from: a */
    public Collection<String> m7335a() {
        Set unmodifiableSet;
        synchronized (this.f1295c) {
            HashSet hashSet = new HashSet(this.f1296d.size());
            for (Class<? extends MaxAdapter> cls : this.f1296d.values()) {
                hashSet.add(cls.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    /* renamed from: a */
    public void m7331a(String str, String str2, AbstractC1334a abstractC1334a) {
        synchronized (this.f1298f) {
            C1710r m6588z = this.f1293a.m6588z();
            m6588z.m6314e("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            this.f1299g.add(new C1470a(str, str2, abstractC1334a, this.f1293a));
        }
    }

    /* renamed from: b */
    public Collection<String> m7330b() {
        Set unmodifiableSet;
        synchronized (this.f1295c) {
            unmodifiableSet = Collections.unmodifiableSet(this.f1297e);
        }
        return unmodifiableSet;
    }

    /* renamed from: c */
    public Collection<JSONObject> m7329c() {
        ArrayList arrayList;
        synchronized (this.f1298f) {
            arrayList = new ArrayList(this.f1299g.size());
            for (C1470a c1470a : this.f1299g) {
                arrayList.add(c1470a.m7328a());
            }
        }
        return arrayList;
    }
}
