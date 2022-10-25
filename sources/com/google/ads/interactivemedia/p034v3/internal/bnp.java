package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnp */
/* loaded from: classes2.dex */
final class bnp implements Map.Entry {

    /* renamed from: a */
    private final Map.Entry f6290a;

    /* renamed from: a */
    public final bnr m3244a() {
        return (bnr) this.f6290a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6290a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((bnr) this.f6290a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof boj)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((bnr) this.f6290a.getValue()).m3240d((boj) obj);
    }
}
