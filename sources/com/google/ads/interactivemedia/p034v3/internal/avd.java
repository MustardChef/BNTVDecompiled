package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avd */
/* loaded from: classes2.dex */
public final class avd extends avg {

    /* renamed from: a */
    private final transient avg f5166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avd(avg avgVar) {
        this.f5166a = avgVar;
    }

    /* renamed from: u */
    private final int m4523u(int i) {
        return (size() - 1) - i;
    }

    /* renamed from: v */
    private final int m4522v(int i) {
        return size() - i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5166a.contains(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return this.f5166a.mo4423e();
    }

    @Override // java.util.List
    public final Object get(int i) {
        atm.m4613i(i, size());
        return this.f5166a.get(m4523u(i));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg
    /* renamed from: h */
    public final avg mo4521h() {
        return this.f5166a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg
    /* renamed from: i */
    public final avg mo4520i(int i, int i2) {
        atm.m4615g(i, i2, size());
        return this.f5166a.subList(m4522v(i2), m4522v(i)).mo4521h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.f5166a.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return m4523u(lastIndexOf);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.f5166a.indexOf(obj);
        if (indexOf >= 0) {
            return m4523u(indexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5166a.size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avg, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
