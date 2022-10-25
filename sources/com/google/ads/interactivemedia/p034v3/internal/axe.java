package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axe */
/* loaded from: classes2.dex */
abstract class axe implements Iterator {

    /* renamed from: a */
    final Iterator f5242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public axe(Iterator it) {
        atm.m4612j(it);
        this.f5242a = it;
    }

    /* renamed from: a */
    abstract Object mo4385a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5242a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return mo4385a(this.f5242a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5242a.remove();
    }
}
