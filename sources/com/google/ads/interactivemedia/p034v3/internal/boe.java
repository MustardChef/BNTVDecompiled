package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.boe */
/* loaded from: classes2.dex */
public final class boe extends LinkedHashMap {

    /* renamed from: a */
    private static final boe f6314a;

    /* renamed from: b */
    private boolean f6315b;

    static {
        boe boeVar = new boe();
        f6314a = boeVar;
        boeVar.m3189c();
    }

    private boe() {
        this.f6315b = true;
    }

    /* renamed from: a */
    public static boe m3191a() {
        return f6314a;
    }

    /* renamed from: f */
    private static int m3186f(Object obj) {
        if (obj instanceof byte[]) {
            return bnk.m3267b((byte[]) obj);
        }
        if (obj instanceof bnf) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* renamed from: g */
    private final void m3185g() {
        if (!this.f6315b) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: b */
    public final boe m3190b() {
        return isEmpty() ? new boe() : new boe(this);
    }

    /* renamed from: c */
    public final void m3189c() {
        this.f6315b = false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m3185g();
        super.clear();
    }

    /* renamed from: d */
    public final void m3188d(boe boeVar) {
        m3185g();
        if (boeVar.isEmpty()) {
            return;
        }
        putAll(boeVar);
    }

    /* renamed from: e */
    public final boolean m3187e() {
        return this.f6315b;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                return true;
            }
            if (size() != map.size()) {
                return false;
            }
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!map.containsKey(entry.getKey())) {
                    return false;
                }
                Object value = entry.getValue();
                Object obj2 = map.get(entry.getKey());
                if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                    equals = value.equals(obj2);
                    continue;
                } else {
                    equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                    continue;
                }
                if (!equals) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i += m3186f(entry.getValue()) ^ m3186f(entry.getKey());
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        m3185g();
        bnk.m3260i(obj);
        bnk.m3260i(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        m3185g();
        for (Object obj : map.keySet()) {
            bnk.m3260i(obj);
            bnk.m3260i(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m3185g();
        return super.remove(obj);
    }

    private boe(Map map) {
        super(map);
        this.f6315b = true;
    }
}
