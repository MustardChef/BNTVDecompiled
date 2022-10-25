package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aus */
/* loaded from: classes2.dex */
final class aus extends auy {

    /* renamed from: a */
    final /* synthetic */ auz f5124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aus(auz auzVar) {
        super(auzVar);
        this.f5124a = auzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.auy
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo4557a(int i) {
        return new auq(this.f5124a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int m4551c = this.f5124a.m4551c(key);
            if (m4551c != -1 && anx.m4882b(value, this.f5124a.f5136b[m4551c])) {
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
            int m4550d = this.f5124a.m4550d(key, m4417E);
            if (m4550d == -1 || !anx.m4882b(value, this.f5124a.f5136b[m4550d])) {
                return false;
            }
            this.f5124a.m4544j(m4550d, m4417E);
            return true;
        }
        return false;
    }
}
