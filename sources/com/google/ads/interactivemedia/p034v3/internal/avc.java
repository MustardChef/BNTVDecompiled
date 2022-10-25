package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avc */
/* loaded from: classes2.dex */
final class avc extends aug implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final Object f5164a;

    /* renamed from: b */
    final Object f5165b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avc(Object obj, Object obj2) {
        this.f5164a = obj;
        this.f5165b = obj2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getKey() {
        return this.f5164a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getValue() {
        return this.f5165b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
