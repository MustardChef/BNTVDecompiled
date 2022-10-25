package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auc */
/* loaded from: classes2.dex */
public class auc extends AbstractCollection {

    /* renamed from: a */
    final Object f5098a;

    /* renamed from: b */
    Collection f5099b;

    /* renamed from: c */
    final auc f5100c;

    /* renamed from: d */
    final Collection f5101d;

    /* renamed from: e */
    final /* synthetic */ auf f5102e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public auc(auf aufVar, Object obj, Collection collection, auc aucVar) {
        this.f5102e = aufVar;
        this.f5098a = obj;
        this.f5099b = collection;
        this.f5100c = aucVar;
        this.f5101d = aucVar == null ? null : aucVar.f5099b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m4591a() {
        Map map;
        auc aucVar = this.f5100c;
        if (aucVar != null) {
            aucVar.m4591a();
            return;
        }
        map = this.f5102e.f5105a;
        map.put(this.f5098a, this.f5099b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        m4590b();
        boolean isEmpty = this.f5099b.isEmpty();
        boolean add = this.f5099b.add(obj);
        if (add) {
            auf.m4577q(this.f5102e);
            if (isEmpty) {
                m4591a();
                return true;
            }
            return add;
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f5099b.addAll(collection);
        if (addAll) {
            auf.m4575s(this.f5102e, this.f5099b.size() - size);
            if (size == 0) {
                m4591a();
                return true;
            }
            return addAll;
        }
        return addAll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m4590b() {
        Map map;
        auc aucVar = this.f5100c;
        if (aucVar != null) {
            aucVar.m4590b();
            if (this.f5100c.f5099b != this.f5101d) {
                throw new ConcurrentModificationException();
            }
        } else if (this.f5099b.isEmpty()) {
            map = this.f5102e.f5105a;
            Collection collection = (Collection) map.get(this.f5098a);
            if (collection != null) {
                this.f5099b = collection;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m4589c() {
        Map map;
        auc aucVar = this.f5100c;
        if (aucVar != null) {
            aucVar.m4589c();
        } else if (this.f5099b.isEmpty()) {
            map = this.f5102e.f5105a;
            map.remove(this.f5098a);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f5099b.clear();
        auf.m4574t(this.f5102e, size);
        m4589c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        m4590b();
        return this.f5099b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        m4590b();
        return this.f5099b.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        m4590b();
        return this.f5099b.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        m4590b();
        return this.f5099b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        m4590b();
        return new aub(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        m4590b();
        boolean remove = this.f5099b.remove(obj);
        if (remove) {
            auf.m4576r(this.f5102e);
            m4589c();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f5099b.removeAll(collection);
        if (removeAll) {
            auf.m4575s(this.f5102e, this.f5099b.size() - size);
            m4589c();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        atm.m4612j(collection);
        int size = size();
        boolean retainAll = this.f5099b.retainAll(collection);
        if (retainAll) {
            auf.m4575s(this.f5102e, this.f5099b.size() - size);
            m4589c();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        m4590b();
        return this.f5099b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        m4590b();
        return this.f5099b.toString();
    }
}
