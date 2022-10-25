package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ListIterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpn */
/* loaded from: classes2.dex */
final class bpn implements ListIterator {

    /* renamed from: a */
    final ListIterator f6392a;

    /* renamed from: b */
    final /* synthetic */ int f6393b;

    /* renamed from: c */
    final /* synthetic */ bpp f6394c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bpn(bpp bppVar, int i) {
        bnu bnuVar;
        this.f6394c = bppVar;
        this.f6393b = i;
        bnuVar = bppVar.f6397a;
        this.f6392a = bnuVar.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f6392a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6392a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f6392a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6392a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f6392a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6392a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
