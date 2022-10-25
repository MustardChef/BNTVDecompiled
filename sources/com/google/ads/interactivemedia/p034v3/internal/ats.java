package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ats */
/* loaded from: classes2.dex */
public class ats extends awg {

    /* renamed from: a */
    final transient Map f5080a;

    /* renamed from: b */
    final /* synthetic */ auf f5081b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ats(auf aufVar, Map map) {
        this.f5081b = aufVar;
        this.f5080a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map.Entry m4602a(Map.Entry entry) {
        Object key = entry.getKey();
        return axd.m4393s(key, this.f5081b.mo4585c(key, (Collection) entry.getValue()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awg
    /* renamed from: b */
    protected final Set mo4466b() {
        return new atq(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map;
        Map map2 = this.f5080a;
        auf aufVar = this.f5081b;
        map = aufVar.f5105a;
        if (map2 == map) {
            aufVar.mo4463o();
        } else {
            axd.m4388x(new atr(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f5080a;
        atm.m4612j(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f5080a.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) axd.m4395q(this.f5080a, obj);
        if (collection == null) {
            return null;
        }
        return this.f5081b.mo4585c(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f5080a.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awg, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return this.f5081b.m4571x();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f5080a.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection mo4455a = this.f5081b.mo4455a();
        mo4455a.addAll(collection);
        auf.m4574t(this.f5081b, collection.size());
        collection.clear();
        return mo4455a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5080a.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f5080a.toString();
    }
}
