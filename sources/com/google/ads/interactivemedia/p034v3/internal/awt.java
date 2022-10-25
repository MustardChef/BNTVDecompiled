package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awt */
/* loaded from: classes2.dex */
final class awt extends avo {

    /* renamed from: a */
    private final transient avj f5218a;

    /* renamed from: b */
    private final transient avg f5219b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awt(avj avjVar, avg avgVar) {
        this.f5218a = avjVar;
        this.f5219b = avgVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: c */
    public final avg mo4425c() {
        return this.f5219b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5218a.get(obj) != null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public final axf iterator() {
        return this.f5219b.listIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    public final int mo4422g(Object[] objArr) {
        return this.f5219b.mo4422g(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5218a.size();
    }
}
