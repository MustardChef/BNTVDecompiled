package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.g */
/* loaded from: classes.dex */
public class C1697g {

    /* renamed from: a */
    private String f2410a;

    /* renamed from: b */
    private String f2411b;

    /* renamed from: c */
    private String f2412c;

    /* renamed from: d */
    private String f2413d;

    /* renamed from: e */
    private Map<String, String> f2414e;

    /* renamed from: f */
    private Map<String, String> f2415f;

    /* renamed from: g */
    private Map<String, Object> f2416g;

    /* renamed from: h */
    private boolean f2417h;

    /* renamed from: i */
    private boolean f2418i;

    /* renamed from: j */
    private boolean f2419j;

    /* renamed from: k */
    private String f2420k;

    /* renamed from: l */
    private int f2421l;

    /* renamed from: com.applovin.impl.sdk.network.g$a */
    /* loaded from: classes.dex */
    public static class C1699a {

        /* renamed from: a */
        private String f2422a;

        /* renamed from: b */
        private String f2423b;

        /* renamed from: c */
        private String f2424c;

        /* renamed from: d */
        private String f2425d;

        /* renamed from: e */
        private Map<String, String> f2426e;

        /* renamed from: f */
        private Map<String, String> f2427f;

        /* renamed from: g */
        private Map<String, Object> f2428g;

        /* renamed from: h */
        private boolean f2429h;

        /* renamed from: i */
        private boolean f2430i;

        /* renamed from: j */
        private boolean f2431j;

        /* renamed from: a */
        public C1699a m6418a(String str) {
            this.f2422a = str;
            return this;
        }

        /* renamed from: a */
        public C1699a m6417a(Map<String, String> map) {
            this.f2426e = map;
            return this;
        }

        /* renamed from: a */
        public C1699a m6416a(boolean z) {
            this.f2429h = z;
            return this;
        }

        /* renamed from: a */
        public C1697g m6420a() {
            return new C1697g(this);
        }

        /* renamed from: b */
        public C1699a m6414b(String str) {
            this.f2423b = str;
            return this;
        }

        /* renamed from: b */
        public C1699a m6413b(Map<String, String> map) {
            this.f2427f = map;
            return this;
        }

        /* renamed from: b */
        public C1699a m6412b(boolean z) {
            this.f2430i = z;
            return this;
        }

        /* renamed from: c */
        public C1699a m6410c(String str) {
            this.f2424c = str;
            return this;
        }

        /* renamed from: c */
        public C1699a m6409c(Map<String, Object> map) {
            this.f2428g = map;
            return this;
        }

        /* renamed from: c */
        public C1699a m6408c(boolean z) {
            this.f2431j = z;
            return this;
        }

        /* renamed from: d */
        public C1699a m6406d(String str) {
            this.f2425d = str;
            return this;
        }
    }

    private C1697g(C1699a c1699a) {
        this.f2410a = UUID.randomUUID().toString();
        this.f2411b = c1699a.f2423b;
        this.f2412c = c1699a.f2424c;
        this.f2413d = c1699a.f2425d;
        this.f2414e = c1699a.f2426e;
        this.f2415f = c1699a.f2427f;
        this.f2416g = c1699a.f2428g;
        this.f2417h = c1699a.f2429h;
        this.f2418i = c1699a.f2430i;
        this.f2419j = c1699a.f2431j;
        this.f2420k = c1699a.f2422a;
        this.f2421l = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1697g(JSONObject jSONObject, C1662k c1662k) throws Exception {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        JsonUtils.getString(jSONObject, "httpMethod", "");
        String string3 = jSONObject.getString("targetUrl");
        String string4 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : Collections.emptyMap();
        Map<String, String> synchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : Collections.emptyMap();
        Map<String, Object> synchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : Collections.emptyMap();
        this.f2410a = string;
        this.f2420k = string2;
        this.f2412c = string3;
        this.f2413d = string4;
        this.f2414e = synchronizedMap;
        this.f2415f = synchronizedMap2;
        this.f2416g = synchronizedMap3;
        this.f2417h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f2418i = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f2419j = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f2421l = i;
    }

    /* renamed from: o */
    public static C1699a m6421o() {
        return new C1699a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m6435a() {
        return this.f2411b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m6434b() {
        return this.f2412c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public String m6433c() {
        return this.f2413d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Map<String, String> m6432d() {
        return this.f2414e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Map<String, String> m6431e() {
        return this.f2415f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2410a.equals(((C1697g) obj).f2410a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Map<String, Object> m6430f() {
        return this.f2416g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m6429g() {
        return this.f2417h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean m6428h() {
        return this.f2418i;
    }

    public int hashCode() {
        return this.f2410a.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean m6427i() {
        return this.f2419j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public String m6426j() {
        return this.f2420k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public int m6425k() {
        return this.f2421l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m6424l() {
        this.f2421l++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m6423m() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f2414e;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f2414e = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public JSONObject m6422n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f2410a);
        jSONObject.put("communicatorRequestId", this.f2420k);
        jSONObject.put("httpMethod", this.f2411b);
        jSONObject.put("targetUrl", this.f2412c);
        jSONObject.put("backupUrl", this.f2413d);
        jSONObject.put("isEncodingEnabled", this.f2417h);
        jSONObject.put("gzipBodyEncoding", this.f2418i);
        jSONObject.put("attemptNumber", this.f2421l);
        if (this.f2414e != null) {
            jSONObject.put("parameters", new JSONObject(this.f2414e));
        }
        if (this.f2415f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f2415f));
        }
        if (this.f2416g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f2416g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f2410a + "', communicatorRequestId='" + this.f2420k + "', httpMethod='" + this.f2411b + "', targetUrl='" + this.f2412c + "', backupUrl='" + this.f2413d + "', attemptNumber=" + this.f2421l + ", isEncodingEnabled=" + this.f2417h + ", isGzipBodyEncoding=" + this.f2418i + '}';
    }
}
