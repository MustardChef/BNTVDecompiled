package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auu */
/* loaded from: classes2.dex */
final class auu extends auy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public auu(auz auzVar) {
        super(auzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.auy
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4557a(int i) {
        return new aur(this.f5134b, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int m4549e = this.f5134b.m4549e(key);
            if (m4549e != -1 && anx.m4882b(this.f5134b.f5135a[m4549e], value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int m4417E = axd.m4417E(key);
            int m4548f = this.f5134b.m4548f(key, m4417E);
            if (m4548f == -1 || !anx.m4882b(this.f5134b.f5135a[m4548f], value)) {
                return false;
            }
            this.f5134b.m4543k(m4548f, m4417E);
            return true;
        }
        return false;
    }
}
