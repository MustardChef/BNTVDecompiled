package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auv */
/* loaded from: classes2.dex */
public final class auv extends auy {

    /* renamed from: a */
    final /* synthetic */ auz f5127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public auv(auz auzVar) {
        super(auzVar);
        this.f5127a = auzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.auy
    /* renamed from: a */
    public final Object mo4557a(int i) {
        return this.f5127a.f5135a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f5127a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int m4417E = axd.m4417E(obj);
        int m4550d = this.f5127a.m4550d(obj, m4417E);
        if (m4550d != -1) {
            this.f5127a.m4544j(m4550d, m4417E);
            return true;
        }
        return false;
    }
}
