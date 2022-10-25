package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auf */
/* loaded from: classes2.dex */
public abstract class auf extends aui implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: a */
    private transient Map f5105a;

    /* renamed from: b */
    private transient int f5106b;

    /* JADX INFO: Access modifiers changed from: protected */
    public auf(Map map) {
        atm.m4618d(map.isEmpty());
        this.f5105a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ void m4579n(auf aufVar, Object obj) {
        Object obj2;
        Map map = aufVar.f5105a;
        atm.m4612j(map);
        try {
            obj2 = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            aufVar.f5106b -= size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static /* synthetic */ void m4577q(auf aufVar) {
        aufVar.f5106b++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ void m4576r(auf aufVar) {
        aufVar.f5106b--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static /* synthetic */ void m4575s(auf aufVar, int i) {
        aufVar.f5106b += i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public static /* synthetic */ void m4574t(auf aufVar, int i) {
        aufVar.f5106b -= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Collection mo4455a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Collection mo4586b(Collection collection) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Collection mo4585c(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: d */
    public final int mo4464d() {
        return this.f5106b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: e */
    final Collection mo4573e() {
        return new auh(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: f */
    public final Iterator mo4572f() {
        return new att(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final List m4584g(Object obj, List list, auc aucVar) {
        if (list instanceof RandomAccess) {
            return new aty(this, obj, list, aucVar);
        }
        return new aue(this, obj, list, aucVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final Map m4582i() {
        return this.f5105a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: j */
    Map mo4454j() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final Map m4581k() {
        Map map = this.f5105a;
        if (map instanceof NavigableMap) {
            return new atw(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new atz(this, (SortedMap) map);
        }
        return new ats(this, map);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: l */
    Set mo4453l() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final Set m4580m() {
        Map map = this.f5105a;
        if (map instanceof NavigableMap) {
            return new atx(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new aua(this, (SortedMap) map);
        }
        return new atv(this, map);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: o */
    public final void mo4463o() {
        for (Collection collection : this.f5105a.values()) {
            collection.clear();
        }
        this.f5105a.clear();
        this.f5106b = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final void m4578p(Map map) {
        this.f5105a = map;
        this.f5106b = 0;
        for (Collection collection : map.values()) {
            atm.m4618d(!collection.isEmpty());
            this.f5106b += collection.size();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aui, com.google.ads.interactivemedia.p034v3.internal.awh
    /* renamed from: u */
    public final void mo4462u(Object obj, Object obj2) {
        Collection collection = (Collection) this.f5105a.get(obj);
        if (collection == null) {
            Collection mo4455a = mo4455a();
            if (mo4455a.add(obj2)) {
                this.f5106b++;
                this.f5105a.put(obj, mo4455a);
                return;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(obj2)) {
            this.f5106b++;
        }
    }
}
