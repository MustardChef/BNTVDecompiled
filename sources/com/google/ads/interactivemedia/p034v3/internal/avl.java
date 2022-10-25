package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avl */
/* loaded from: classes2.dex */
final class avl extends avo {

    /* renamed from: a */
    final /* synthetic */ avs f5180a;

    avl() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = m4501j().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public final axf iterator() {
        return mo4425c().listIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return m4501j().mo4442i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo
    /* renamed from: h */
    final boolean mo4439h() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, java.util.Collection, java.util.Set
    public final int hashCode() {
        return m4501j().hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo
    /* renamed from: i */
    final avg mo4438i() {
        return new avp(this);
    }

    /* renamed from: j */
    final avj m4501j() {
        return this.f5180a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return m4501j().size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb
    Object writeReplace() {
        return new avk(m4501j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public avl(avs avsVar) {
        this();
        this.f5180a = avsVar;
    }
}
