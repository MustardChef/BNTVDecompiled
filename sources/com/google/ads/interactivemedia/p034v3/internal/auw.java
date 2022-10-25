package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auw */
/* loaded from: classes2.dex */
public final class auw extends auy {

    /* renamed from: a */
    final /* synthetic */ auz f5128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public auw(auz auzVar) {
        super(auzVar);
        this.f5128a = auzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.auy
    /* renamed from: a */
    public final Object mo4557a(int i) {
        return this.f5128a.f5136b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f5128a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int m4417E = axd.m4417E(obj);
        int m4548f = this.f5128a.m4548f(obj, m4417E);
        if (m4548f != -1) {
            this.f5128a.m4543k(m4548f, m4417E);
            return true;
        }
        return false;
    }
}
