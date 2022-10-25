package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.h */
/* loaded from: classes.dex */
public class C1700h<T> extends C1688c {

    /* renamed from: a */
    private String f2432a;

    /* renamed from: b */
    private boolean f2433b;

    /* renamed from: com.applovin.impl.sdk.network.h$a */
    /* loaded from: classes.dex */
    public static class C1701a<T> extends C1688c.C1689a<T> {

        /* renamed from: p */
        private String f2434p;

        /* renamed from: q */
        private boolean f2435q;

        public C1701a(C1662k c1662k) {
            super(c1662k);
            this.f2386h = ((Integer) c1662k.m6656a(C1568b.f1772cM)).intValue();
            this.f2387i = ((Integer) c1662k.m6656a(C1568b.f1771cL)).intValue();
            this.f2388j = ((Integer) c1662k.m6656a(C1568b.f1776cQ)).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: a */
        public /* synthetic */ C1688c.C1689a mo6392a(Object obj) {
            return m6385b((C1701a<T>) obj);
        }

        /* renamed from: b */
        public C1701a m6385b(T t) {
            this.f2385g = t;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: b */
        public C1701a mo6389a(JSONObject jSONObject) {
            this.f2384f = jSONObject;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: b */
        public C1700h<T> mo6395a() {
            return new C1700h<>(this);
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: c */
        public C1701a mo6390a(Map<String, String> map) {
            this.f2382d = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: d */
        public C1701a mo6394a(int i) {
            this.f2386h = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: d */
        public C1701a mo6391a(String str) {
            this.f2380b = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: d */
        public C1701a mo6383b(Map<String, String> map) {
            this.f2383e = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: e */
        public C1701a mo6387b(int i) {
            this.f2387i = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: e */
        public C1701a mo6380c(String str) {
            this.f2381c = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: f */
        public C1701a mo6381c(int i) {
            this.f2388j = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: f */
        public C1701a mo6384b(String str) {
            this.f2379a = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: f */
        public C1701a mo6378c(boolean z) {
            this.f2391m = z;
            return this;
        }

        /* renamed from: g */
        public C1701a m6368g(String str) {
            this.f2434p = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.C1688c.C1689a
        /* renamed from: g */
        public C1701a mo6374d(boolean z) {
            this.f2392n = z;
            return this;
        }

        /* renamed from: h */
        public C1701a m6366h(boolean z) {
            this.f2435q = z;
            return this;
        }
    }

    protected C1700h(C1701a c1701a) {
        super(c1701a);
        this.f2432a = c1701a.f2434p;
        this.f2433b = c1701a.f2435q;
    }

    /* renamed from: b */
    public static C1701a m6399b(C1662k c1662k) {
        return new C1701a(c1662k);
    }

    /* renamed from: q */
    public boolean m6398q() {
        return this.f2432a != null;
    }

    /* renamed from: r */
    public String m6397r() {
        return this.f2432a;
    }

    /* renamed from: s */
    public boolean m6396s() {
        return this.f2433b;
    }
}
