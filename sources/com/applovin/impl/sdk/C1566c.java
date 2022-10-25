package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.C1543h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.c */
/* loaded from: classes.dex */
public class C1566c {

    /* renamed from: a */
    private final C1662k f1597a;

    /* renamed from: b */
    private final C1710r f1598b;

    /* renamed from: d */
    private final Map<C1531d, C1713t> f1600d = new HashMap();

    /* renamed from: e */
    private final Map<C1531d, C1713t> f1601e = new HashMap();

    /* renamed from: c */
    private final Object f1599c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1566c(C1662k c1662k) {
        this.f1597a = c1662k;
        this.f1598b = c1662k.m6588z();
        for (C1531d c1531d : C1531d.m7207f()) {
            this.f1600d.put(c1531d, new C1713t());
            this.f1601e.put(c1531d, new C1713t());
        }
    }

    /* renamed from: e */
    private C1713t m7012e(C1531d c1531d) {
        C1713t c1713t;
        synchronized (this.f1599c) {
            c1713t = this.f1600d.get(c1531d);
            if (c1713t == null) {
                c1713t = new C1713t();
                this.f1600d.put(c1531d, c1713t);
            }
        }
        return c1713t;
    }

    /* renamed from: f */
    private C1713t m7011f(C1531d c1531d) {
        C1713t c1713t;
        synchronized (this.f1599c) {
            c1713t = this.f1601e.get(c1531d);
            if (c1713t == null) {
                c1713t = new C1713t();
                this.f1601e.put(c1531d, c1713t);
            }
        }
        return c1713t;
    }

    /* renamed from: g */
    private C1713t m7010g(C1531d c1531d) {
        synchronized (this.f1599c) {
            C1713t m7011f = m7011f(c1531d);
            if (m7011f.m6305a() > 0) {
                return m7011f;
            }
            return m7012e(c1531d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7017a(AppLovinAdBase appLovinAdBase) {
        synchronized (this.f1599c) {
            m7012e(appLovinAdBase.getAdZone()).m6304a(appLovinAdBase);
            C1710r c1710r = this.f1598b;
            c1710r.m6319b("AdPreloadManager", "Ad enqueued: " + appLovinAdBase);
        }
    }

    /* renamed from: a */
    public boolean m7016a(C1531d c1531d) {
        synchronized (this.f1599c) {
            boolean z = true;
            if (m7011f(c1531d).m6305a() > 0) {
                return true;
            }
            if (m7012e(c1531d).m6305a() <= 0) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    public AppLovinAdBase m7015b(C1531d c1531d) {
        C1543h c1543h;
        StringBuilder sb;
        String str;
        synchronized (this.f1599c) {
            C1713t m7012e = m7012e(c1531d);
            if (m7012e.m6305a() > 0) {
                m7011f(c1531d).m6304a(m7012e.m6302c());
                c1543h = new C1543h(c1531d, this.f1597a);
            } else {
                c1543h = null;
            }
        }
        C1710r c1710r = this.f1598b;
        if (c1543h != null) {
            sb = new StringBuilder();
            str = "Retrieved ad of zone ";
        } else {
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(c1531d);
        sb.append("...");
        c1710r.m6319b("AdPreloadManager", sb.toString());
        return c1543h;
    }

    /* renamed from: c */
    public AppLovinAdBase m7014c(C1531d c1531d) {
        AppLovinAdBase m6302c;
        synchronized (this.f1599c) {
            m6302c = m7010g(c1531d).m6302c();
        }
        return m6302c;
    }

    /* renamed from: d */
    public AppLovinAdBase m7013d(C1531d c1531d) {
        AppLovinAdBase m6301d;
        synchronized (this.f1599c) {
            m6301d = m7010g(c1531d).m6301d();
        }
        return m6301d;
    }
}
