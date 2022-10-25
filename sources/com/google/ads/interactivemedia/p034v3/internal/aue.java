package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aue */
/* loaded from: classes2.dex */
public class aue extends auc implements List {

    /* renamed from: f */
    final /* synthetic */ auf f5104f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aue(auf aufVar, Object obj, List list, auc aucVar) {
        super(aufVar, obj, list, aucVar);
        this.f5104f = aufVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        m4590b();
        boolean isEmpty = this.f5099b.isEmpty();
        m4587d().add(i, obj);
        auf.m4577q(this.f5104f);
        if (isEmpty) {
            m4591a();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = m4587d().addAll(i, collection);
        if (addAll) {
            auf.m4575s(this.f5104f, this.f5099b.size() - size);
            if (size == 0) {
                m4591a();
                return true;
            }
            return addAll;
        }
        return addAll;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final List m4587d() {
        return (List) this.f5099b;
    }

    @Override // java.util.List
    public final Object get(int i) {
        m4590b();
        return m4587d().get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        m4590b();
        return m4587d().indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        m4590b();
        return m4587d().lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        m4590b();
        return new aud(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        m4590b();
        Object remove = m4587d().remove(i);
        auf.m4576r(this.f5104f);
        m4589c();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        m4590b();
        return m4587d().set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        m4590b();
        auf aufVar = this.f5104f;
        Object obj = this.f5098a;
        List subList = m4587d().subList(i, i2);
        auc aucVar = this.f5100c;
        if (aucVar == null) {
            aucVar = this;
        }
        return aufVar.m4584g(obj, subList, aucVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        m4590b();
        return new aud(this, i);
    }
}
