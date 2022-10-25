package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aws */
/* loaded from: classes2.dex */
final class aws extends avo {

    /* renamed from: a */
    private final transient avj f5215a;

    /* renamed from: b */
    private final transient Object[] f5216b;

    /* renamed from: c */
    private final transient int f5217c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aws(avj avjVar, Object[] objArr, int i) {
        this.f5215a = avjVar;
        this.f5216b = objArr;
        this.f5217c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f5215a.get(key))) {
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
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    public final int mo4422g(Object[] objArr) {
        return mo4425c().mo4422g(objArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo
    /* renamed from: i */
    final avg mo4438i() {
        return new awr(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5217c;
    }
}
