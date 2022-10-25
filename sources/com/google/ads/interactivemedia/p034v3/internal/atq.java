package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atq */
/* loaded from: classes2.dex */
final class atq extends awd {

    /* renamed from: a */
    final /* synthetic */ ats f5076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public atq(ats atsVar) {
        this.f5076a = atsVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awd
    /* renamed from: a */
    final Map mo4467a() {
        return this.f5076a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awd, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set entrySet = this.f5076a.f5080a.entrySet();
        atm.m4612j(entrySet);
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new atr(this.f5076a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awd, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (contains(obj)) {
            Map.Entry entry = (Map.Entry) obj;
            entry.getClass();
            auf.m4579n(this.f5076a.f5081b, entry.getKey());
            return true;
        }
        return false;
    }
}
