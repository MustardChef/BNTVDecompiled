package com.applovin.impl.sdk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.p */
/* loaded from: classes.dex */
public class C1766p {

    /* renamed from: a */
    public static final C1766p f2587a = new C1766p();

    /* renamed from: b */
    protected String f2588b;

    /* renamed from: c */
    protected final List<C1766p> f2589c;

    /* renamed from: d */
    private final C1766p f2590d;

    /* renamed from: e */
    private final String f2591e;

    /* renamed from: f */
    private final Map<String, String> f2592f;

    private C1766p() {
        this.f2590d = null;
        this.f2591e = "";
        this.f2592f = Collections.emptyMap();
        this.f2588b = "";
        this.f2589c = Collections.emptyList();
    }

    public C1766p(String str, Map<String, String> map, C1766p c1766p) {
        this.f2590d = c1766p;
        this.f2591e = str;
        this.f2592f = Collections.unmodifiableMap(map);
        this.f2589c = new ArrayList();
    }

    /* renamed from: a */
    public String m6154a() {
        return this.f2591e;
    }

    /* renamed from: a */
    public List<C1766p> m6153a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f2589c.size());
            for (C1766p c1766p : this.f2589c) {
                if (str.equalsIgnoreCase(c1766p.m6154a())) {
                    arrayList.add(c1766p);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C1766p m6151b(String str) {
        if (str != null) {
            for (C1766p c1766p : this.f2589c) {
                if (str.equalsIgnoreCase(c1766p.m6154a())) {
                    return c1766p;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> m6152b() {
        return this.f2592f;
    }

    /* renamed from: c */
    public C1766p m6149c(String str) {
        if (str != null) {
            if (this.f2589c.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this);
                while (!arrayList.isEmpty()) {
                    C1766p c1766p = (C1766p) arrayList.get(0);
                    arrayList.remove(0);
                    if (str.equalsIgnoreCase(c1766p.m6154a())) {
                        return c1766p;
                    }
                    arrayList.addAll(c1766p.m6148d());
                }
                return null;
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: c */
    public String m6150c() {
        return this.f2588b;
    }

    /* renamed from: d */
    public List<C1766p> m6148d() {
        return Collections.unmodifiableList(this.f2589c);
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f2591e + "', text='" + this.f2588b + "', attributes=" + this.f2592f + '}';
    }
}
