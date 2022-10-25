package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpf */
/* loaded from: classes2.dex */
public final class bpf implements Map.Entry, Comparable {

    /* renamed from: a */
    final /* synthetic */ bpi f6371a;

    /* renamed from: b */
    private final Comparable f6372b;

    /* renamed from: c */
    private Object f6373c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bpf(bpi bpiVar, Comparable comparable, Object obj) {
        this.f6371a = bpiVar;
        this.f6372b = comparable;
        this.f6373c = obj;
    }

    /* renamed from: b */
    private static final boolean m2972b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public final Comparable m2973a() {
        return this.f6372b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f6372b.compareTo(((bpf) obj).f6372b);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return m2972b(this.f6372b, entry.getKey()) && m2972b(this.f6373c, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f6372b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f6373c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f6372b;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f6373c;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f6371a.m2956o();
        Object obj2 = this.f6373c;
        this.f6373c = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6372b);
        String valueOf2 = String.valueOf(this.f6373c);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
