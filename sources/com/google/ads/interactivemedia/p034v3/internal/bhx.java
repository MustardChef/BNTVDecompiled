package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhx */
/* loaded from: classes2.dex */
final class bhx implements Map.Entry {

    /* renamed from: a */
    bhx f5750a;

    /* renamed from: b */
    bhx f5751b;

    /* renamed from: c */
    bhx f5752c;

    /* renamed from: d */
    bhx f5753d;

    /* renamed from: e */
    bhx f5754e;

    /* renamed from: f */
    final Object f5755f;

    /* renamed from: g */
    Object f5756g;

    /* renamed from: h */
    int f5757h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhx() {
        this.f5755f = null;
        this.f5754e = this;
        this.f5753d = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhx(bhx bhxVar, Object obj, bhx bhxVar2, bhx bhxVar3) {
        this.f5750a = bhxVar;
        this.f5755f = obj;
        this.f5757h = 1;
        this.f5753d = bhxVar2;
        this.f5754e = bhxVar3;
        bhxVar3.f5753d = this;
        bhxVar2.f5754e = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f5755f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f5756g;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5755f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5756g;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f5756g;
        this.f5756g = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5755f);
        String valueOf2 = String.valueOf(this.f5756g);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f5755f;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f5756g;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }
}
