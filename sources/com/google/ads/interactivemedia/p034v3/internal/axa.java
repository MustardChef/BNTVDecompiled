package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractSet;
import java.util.Collection;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axa */
/* loaded from: classes2.dex */
abstract class axa extends AbstractSet {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        return axd.m4406f(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        atm.m4612j(collection);
        return super.retainAll(collection);
    }
}
