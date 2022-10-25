package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnq */
/* loaded from: classes2.dex */
final class bnq implements Iterator {

    /* renamed from: a */
    private final Iterator f6291a;

    public bnq(Iterator it) {
        this.f6291a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6291a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f6291a.next();
        return entry.getValue() instanceof bnr ? new bnp(entry) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f6291a.remove();
    }
}
