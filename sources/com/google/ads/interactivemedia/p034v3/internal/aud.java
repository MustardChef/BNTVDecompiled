package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ListIterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aud */
/* loaded from: classes2.dex */
final class aud extends aub implements ListIterator {

    /* renamed from: d */
    final /* synthetic */ aue f5103d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aud(aue aueVar) {
        super(aueVar);
        this.f5103d = aueVar;
    }

    /* renamed from: b */
    private final ListIterator m4588b() {
        m4592a();
        return (ListIterator) this.f5095a;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean isEmpty = this.f5103d.isEmpty();
        m4588b().add(obj);
        auf.m4577q(this.f5103d.f5104f);
        if (isEmpty) {
            this.f5103d.m4591a();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return m4588b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return m4588b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return m4588b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return m4588b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        m4588b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aud(aue aueVar, int i) {
        super(aueVar, aueVar.m4587d().listIterator(i));
        this.f5103d = aueVar;
    }
}
