package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avp */
/* loaded from: classes2.dex */
final class avp extends avg {

    /* renamed from: a */
    final /* synthetic */ avl f5183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avp(avl avlVar) {
        this.f5183a = avlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        awx awxVar;
        avg avgVar;
        awxVar = this.f5183a.f5180a.f5189b;
        E e = awxVar.f5235d.get(i);
        avgVar = this.f5183a.f5180a.f5190c;
        return new AbstractMap.SimpleImmutableEntry(e, avgVar.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5183a.f5180a.size();
    }
}
