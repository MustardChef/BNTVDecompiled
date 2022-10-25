package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avf */
/* loaded from: classes2.dex */
public final class avf extends avg {

    /* renamed from: a */
    final transient int f5168a;

    /* renamed from: b */
    final transient int f5169b;

    /* renamed from: c */
    final /* synthetic */ avg f5170c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avf(avg avgVar, int i, int i2) {
        this.f5170c = avgVar;
        this.f5168a = i;
        this.f5169b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: a */
    public final int mo4435a() {
        return this.f5170c.mo4434b() + this.f5168a + this.f5169b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: b */
    public final int mo4434b() {
        return this.f5170c.mo4434b() + this.f5168a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: f */
    public final Object[] mo4433f() {
        return this.f5170c.mo4433f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        atm.m4613i(i, this.f5169b);
        return this.f5170c.get(i + this.f5168a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg
    /* renamed from: i */
    public final avg mo4520i(int i, int i2) {
        atm.m4615g(i, i2, this.f5169b);
        avg avgVar = this.f5170c;
        int i3 = this.f5168a;
        return avgVar.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5169b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
