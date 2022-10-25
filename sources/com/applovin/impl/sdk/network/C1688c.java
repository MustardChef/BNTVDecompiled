package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1568b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.c */
/* loaded from: classes.dex */
public class C1688c<T> {

    /* renamed from: a */
    private String f2363a;

    /* renamed from: b */
    private String f2364b;

    /* renamed from: c */
    private Map<String, String> f2365c;

    /* renamed from: d */
    private Map<String, String> f2366d;

    /* renamed from: e */
    private final JSONObject f2367e;

    /* renamed from: f */
    private String f2368f;

    /* renamed from: g */
    private final T f2369g;

    /* renamed from: h */
    private final int f2370h;

    /* renamed from: i */
    private int f2371i;

    /* renamed from: j */
    private final int f2372j;

    /* renamed from: k */
    private final int f2373k;

    /* renamed from: l */
    private final boolean f2374l;

    /* renamed from: m */
    private final boolean f2375m;

    /* renamed from: n */
    private final boolean f2376n;

    /* renamed from: o */
    private final boolean f2377o;

    /* renamed from: p */
    private final boolean f2378p;

    /* renamed from: com.applovin.impl.sdk.network.c$a */
    /* loaded from: classes.dex */
    public static class C1689a<T> {

        /* renamed from: a */
        String f2379a;

        /* renamed from: b */
        String f2380b;

        /* renamed from: c */
        String f2381c;

        /* renamed from: e */
        Map<String, String> f2383e;

        /* renamed from: f */
        JSONObject f2384f;

        /* renamed from: g */
        T f2385g;

        /* renamed from: i */
        int f2387i;

        /* renamed from: j */
        int f2388j;

        /* renamed from: k */
        boolean f2389k;

        /* renamed from: l */
        boolean f2390l;

        /* renamed from: m */
        boolean f2391m;

        /* renamed from: n */
        boolean f2392n;

        /* renamed from: o */
        boolean f2393o;

        /* renamed from: h */
        int f2386h = 1;

        /* renamed from: d */
        Map<String, String> f2382d = new HashMap();

        public C1689a(C1662k c1662k) {
            this.f2387i = ((Integer) c1662k.m6656a(C1568b.f1777cR)).intValue();
            this.f2388j = ((Integer) c1662k.m6656a(C1568b.f1776cQ)).intValue();
            this.f2390l = ((Boolean) c1662k.m6656a(C1568b.f1775cP)).booleanValue();
            this.f2391m = ((Boolean) c1662k.m6656a(C1568b.f1903en)).booleanValue();
            this.f2392n = ((Boolean) c1662k.m6656a(C1568b.f1908es)).booleanValue();
        }

        /* renamed from: a */
        public C1689a<T> mo6394a(int i) {
            this.f2386h = i;
            return this;
        }

        /* renamed from: a */
        public C1689a<T> mo6392a(T t) {
            this.f2385g = t;
            return this;
        }

        /* renamed from: a */
        public C1689a<T> mo6391a(String str) {
            this.f2380b = str;
            return this;
        }

        /* renamed from: a */
        public C1689a<T> mo6390a(Map<String, String> map) {
            this.f2382d = map;
            return this;
        }

        /* renamed from: a */
        public C1689a<T> mo6389a(JSONObject jSONObject) {
            this.f2384f = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C1689a<T> m6469a(boolean z) {
            this.f2389k = z;
            return this;
        }

        /* renamed from: a */
        public C1688c<T> mo6395a() {
            return new C1688c<>(this);
        }

        /* renamed from: b */
        public C1689a<T> mo6387b(int i) {
            this.f2387i = i;
            return this;
        }

        /* renamed from: b */
        public C1689a<T> mo6384b(String str) {
            this.f2379a = str;
            return this;
        }

        /* renamed from: b */
        public C1689a<T> mo6383b(Map<String, String> map) {
            this.f2383e = map;
            return this;
        }

        /* renamed from: b */
        public C1689a<T> m6468b(boolean z) {
            this.f2390l = z;
            return this;
        }

        /* renamed from: c */
        public C1689a<T> mo6381c(int i) {
            this.f2388j = i;
            return this;
        }

        /* renamed from: c */
        public C1689a<T> mo6380c(String str) {
            this.f2381c = str;
            return this;
        }

        /* renamed from: c */
        public C1689a<T> mo6378c(boolean z) {
            this.f2391m = z;
            return this;
        }

        /* renamed from: d */
        public C1689a<T> mo6374d(boolean z) {
            this.f2392n = z;
            return this;
        }

        /* renamed from: e */
        public C1689a<T> m6467e(boolean z) {
            this.f2393o = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1688c(C1689a<T> c1689a) {
        this.f2363a = c1689a.f2380b;
        this.f2364b = c1689a.f2379a;
        this.f2365c = c1689a.f2382d;
        this.f2366d = c1689a.f2383e;
        this.f2367e = c1689a.f2384f;
        this.f2368f = c1689a.f2381c;
        this.f2369g = c1689a.f2385g;
        this.f2370h = c1689a.f2386h;
        this.f2371i = c1689a.f2386h;
        this.f2372j = c1689a.f2387i;
        this.f2373k = c1689a.f2388j;
        this.f2374l = c1689a.f2389k;
        this.f2375m = c1689a.f2390l;
        this.f2376n = c1689a.f2391m;
        this.f2377o = c1689a.f2392n;
        this.f2378p = c1689a.f2393o;
    }

    /* renamed from: a */
    public static <T> C1689a<T> m6487a(C1662k c1662k) {
        return new C1689a<>(c1662k);
    }

    /* renamed from: a */
    public String m6489a() {
        return this.f2363a;
    }

    /* renamed from: a */
    public void m6488a(int i) {
        this.f2371i = i;
    }

    /* renamed from: a */
    public void m6486a(String str) {
        this.f2363a = str;
    }

    /* renamed from: b */
    public String m6485b() {
        return this.f2364b;
    }

    /* renamed from: b */
    public void m6484b(String str) {
        this.f2364b = str;
    }

    /* renamed from: c */
    public Map<String, String> m6483c() {
        return this.f2365c;
    }

    /* renamed from: d */
    public Map<String, String> m6482d() {
        return this.f2366d;
    }

    /* renamed from: e */
    public JSONObject m6481e() {
        return this.f2367e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1688c) {
            C1688c c1688c = (C1688c) obj;
            String str = this.f2363a;
            if (str == null ? c1688c.f2363a == null : str.equals(c1688c.f2363a)) {
                Map<String, String> map = this.f2365c;
                if (map == null ? c1688c.f2365c == null : map.equals(c1688c.f2365c)) {
                    Map<String, String> map2 = this.f2366d;
                    if (map2 == null ? c1688c.f2366d == null : map2.equals(c1688c.f2366d)) {
                        String str2 = this.f2368f;
                        if (str2 == null ? c1688c.f2368f == null : str2.equals(c1688c.f2368f)) {
                            String str3 = this.f2364b;
                            if (str3 == null ? c1688c.f2364b == null : str3.equals(c1688c.f2364b)) {
                                JSONObject jSONObject = this.f2367e;
                                if (jSONObject == null ? c1688c.f2367e == null : jSONObject.equals(c1688c.f2367e)) {
                                    T t = this.f2369g;
                                    if (t == null ? c1688c.f2369g == null : t.equals(c1688c.f2369g)) {
                                        return this.f2370h == c1688c.f2370h && this.f2371i == c1688c.f2371i && this.f2372j == c1688c.f2372j && this.f2373k == c1688c.f2373k && this.f2374l == c1688c.f2374l && this.f2375m == c1688c.f2375m && this.f2376n == c1688c.f2376n && this.f2377o == c1688c.f2377o && this.f2378p == c1688c.f2378p;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public String m6480f() {
        return this.f2368f;
    }

    /* renamed from: g */
    public T m6479g() {
        return this.f2369g;
    }

    /* renamed from: h */
    public int m6478h() {
        return this.f2371i;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f2363a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2368f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2364b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.f2369g;
        int hashCode5 = ((((((((((((((((((hashCode4 + (t != null ? t.hashCode() : 0)) * 31) + this.f2370h) * 31) + this.f2371i) * 31) + this.f2372j) * 31) + this.f2373k) * 31) + (this.f2374l ? 1 : 0)) * 31) + (this.f2375m ? 1 : 0)) * 31) + (this.f2376n ? 1 : 0)) * 31) + (this.f2377o ? 1 : 0)) * 31) + (this.f2378p ? 1 : 0);
        Map<String, String> map = this.f2365c;
        if (map != null) {
            hashCode5 = (hashCode5 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f2366d;
        if (map2 != null) {
            hashCode5 = (hashCode5 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f2367e;
        if (jSONObject != null) {
            char[] charArray = jSONObject.toString().toCharArray();
            Arrays.sort(charArray);
            return (hashCode5 * 31) + new String(charArray).hashCode();
        }
        return hashCode5;
    }

    /* renamed from: i */
    public int m6477i() {
        return this.f2370h - this.f2371i;
    }

    /* renamed from: j */
    public int m6476j() {
        return this.f2372j;
    }

    /* renamed from: k */
    public int m6475k() {
        return this.f2373k;
    }

    /* renamed from: l */
    public boolean m6474l() {
        return this.f2374l;
    }

    /* renamed from: m */
    public boolean m6473m() {
        return this.f2375m;
    }

    /* renamed from: n */
    public boolean m6472n() {
        return this.f2376n;
    }

    /* renamed from: o */
    public boolean m6471o() {
        return this.f2377o;
    }

    /* renamed from: p */
    public boolean m6470p() {
        return this.f2378p;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f2363a + ", backupEndpoint=" + this.f2368f + ", httpMethod=" + this.f2364b + ", httpHeaders=" + this.f2366d + ", body=" + this.f2367e + ", emptyResponse=" + this.f2369g + ", initialRetryAttempts=" + this.f2370h + ", retryAttemptsLeft=" + this.f2371i + ", timeoutMillis=" + this.f2372j + ", retryDelayMillis=" + this.f2373k + ", exponentialRetries=" + this.f2374l + ", retryOnAllErrors=" + this.f2375m + ", encodingEnabled=" + this.f2376n + ", gzipBodyEncoding=" + this.f2377o + ", trackConnectionSpeed=" + this.f2378p + '}';
    }
}
