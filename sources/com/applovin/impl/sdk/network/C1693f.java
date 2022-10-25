package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.f */
/* loaded from: classes.dex */
public class C1693f {

    /* renamed from: a */
    private final C1662k f2396a;

    /* renamed from: b */
    private final C1710r f2397b;

    /* renamed from: c */
    private final SharedPreferences f2398c;

    /* renamed from: e */
    private final ArrayList<C1697g> f2400e;

    /* renamed from: d */
    private final Object f2399d = new Object();

    /* renamed from: f */
    private final ArrayList<C1697g> f2401f = new ArrayList<>();

    /* renamed from: g */
    private final Set<C1697g> f2402g = new HashSet();

    public C1693f(C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f2396a = c1662k;
        this.f2397b = c1662k.m6588z();
        this.f2398c = c1662k.m6677J().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
        this.f2400e = m6448b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6451a(final C1697g c1697g, final AppLovinPostbackListener appLovinPostbackListener) {
        C1710r c1710r = this.f2397b;
        c1710r.m6319b("PersistentPostbackManager", "Preparing to submit postback..." + c1697g);
        if (this.f2396a.m6617c()) {
            this.f2397b.m6319b("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
            return;
        }
        synchronized (this.f2399d) {
            if (this.f2402g.contains(c1697g)) {
                C1710r c1710r2 = this.f2397b;
                c1710r2.m6319b("PersistentPostbackManager", "Skip pending postback: " + c1697g.m6434b());
                return;
            }
            c1697g.m6424l();
            m6444c();
            int intValue = ((Integer) this.f2396a.m6656a(C1568b.f1773cN)).intValue();
            if (c1697g.m6425k() <= intValue) {
                synchronized (this.f2399d) {
                    this.f2402g.add(c1697g);
                }
                this.f2396a.m6665V().dispatchPostbackRequest(C1700h.m6399b(this.f2396a).mo6391a(c1697g.m6434b()).mo6380c(c1697g.m6433c()).mo6390a(c1697g.m6432d()).mo6384b(c1697g.m6435a()).mo6383b(c1697g.m6431e()).mo6389a(c1697g.m6430f() != null ? new JSONObject(c1697g.m6430f()) : null).mo6374d(c1697g.m6428h()).mo6378c(c1697g.m6429g()).m6366h(c1697g.m6427i()).m6368g(c1697g.m6426j()).mo6395a(), new AppLovinPostbackListener() { // from class: com.applovin.impl.sdk.network.f.2
                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackFailure(String str, int i) {
                        C1710r c1710r3 = C1693f.this.f2397b;
                        c1710r3.m6317c("PersistentPostbackManager", "Failed to submit postback with errorCode " + i + ". Will retry later...  Postback: " + c1697g);
                        C1693f.this.m6436e(c1697g);
                        C1728i.m6221a(appLovinPostbackListener, str, i);
                    }

                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackSuccess(String str) {
                        C1693f.this.m6437d(c1697g);
                        C1710r c1710r3 = C1693f.this.f2397b;
                        c1710r3.m6319b("PersistentPostbackManager", "Successfully submitted postback: " + c1697g);
                        C1693f.this.m6440d();
                        C1728i.m6222a(appLovinPostbackListener, str);
                    }
                });
                return;
            }
            C1710r c1710r3 = this.f2397b;
            c1710r3.m6315d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + intValue + ". Dequeuing postback: " + c1697g);
            m6437d(c1697g);
        }
    }

    /* renamed from: b */
    private ArrayList<C1697g> m6448b() {
        Set<String> set = (Set) this.f2396a.m6622b(C1570d.f1942n, new LinkedHashSet(0), this.f2398c);
        ArrayList<C1697g> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f2396a.m6656a(C1568b.f1773cN)).intValue();
        C1710r c1710r = this.f2397b;
        c1710r.m6319b("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
        for (String str : set) {
            try {
                C1697g c1697g = new C1697g(new JSONObject(str), this.f2396a);
                if (c1697g.m6425k() < intValue) {
                    arrayList.add(c1697g);
                } else {
                    C1710r c1710r2 = this.f2397b;
                    c1710r2.m6319b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + c1697g);
                }
            } catch (Throwable th) {
                C1710r c1710r3 = this.f2397b;
                c1710r3.m6318b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
            }
        }
        C1710r c1710r4 = this.f2397b;
        c1710r4.m6319b("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6445b(C1697g c1697g) {
        synchronized (this.f2399d) {
            this.f2400e.add(c1697g);
            m6444c();
            C1710r c1710r = this.f2397b;
            c1710r.m6319b("PersistentPostbackManager", "Enqueued postback: " + c1697g);
        }
    }

    /* renamed from: c */
    private void m6444c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f2400e.size());
        Iterator<C1697g> it = this.f2400e.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(it.next().m6422n().toString());
            } catch (Throwable th) {
                this.f2397b.m6318b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.f2396a.m6652a((C1570d<C1570d<HashSet>>) C1570d.f1942n, (C1570d<HashSet>) linkedHashSet, this.f2398c);
        this.f2397b.m6319b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6441c(C1697g c1697g) {
        m6451a(c1697g, (AppLovinPostbackListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6440d() {
        synchronized (this.f2399d) {
            Iterator<C1697g> it = this.f2401f.iterator();
            while (it.hasNext()) {
                m6441c(it.next());
            }
            this.f2401f.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6437d(C1697g c1697g) {
        synchronized (this.f2399d) {
            this.f2402g.remove(c1697g);
            this.f2400e.remove(c1697g);
            m6444c();
        }
        C1710r c1710r = this.f2397b;
        c1710r.m6319b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + c1697g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6436e(C1697g c1697g) {
        synchronized (this.f2399d) {
            this.f2402g.remove(c1697g);
            this.f2401f.add(c1697g);
        }
    }

    /* renamed from: a */
    public void m6456a() {
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.sdk.network.f.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (C1693f.this.f2399d) {
                    if (C1693f.this.f2400e != null) {
                        for (C1697g c1697g : new ArrayList(C1693f.this.f2400e)) {
                            C1693f.this.m6441c(c1697g);
                        }
                    }
                }
            }
        };
        if (!((Boolean) this.f2396a.m6656a(C1568b.f1774cO)).booleanValue()) {
            runnable.run();
            return;
        }
        this.f2396a.m6670Q().m6793a(new C1642y(this.f2396a, runnable), C1620o.EnumC1622a.POSTBACKS);
    }

    /* renamed from: a */
    public void m6452a(C1697g c1697g) {
        m6450a(c1697g, true);
    }

    /* renamed from: a */
    public void m6450a(C1697g c1697g, boolean z) {
        m6449a(c1697g, z, (AppLovinPostbackListener) null);
    }

    /* renamed from: a */
    public void m6449a(final C1697g c1697g, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (StringUtils.isValidString(c1697g.m6434b())) {
            if (z) {
                c1697g.m6423m();
            }
            Runnable runnable = new Runnable() { // from class: com.applovin.impl.sdk.network.f.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C1693f.this.f2399d) {
                        C1693f.this.m6445b(c1697g);
                        C1693f.this.m6451a(c1697g, appLovinPostbackListener);
                    }
                }
            };
            if (!Utils.isMainThread()) {
                runnable.run();
                return;
            }
            this.f2396a.m6670Q().m6793a(new C1642y(this.f2396a, runnable), C1620o.EnumC1622a.POSTBACKS);
        }
    }
}
