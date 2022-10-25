package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ave */
/* loaded from: classes2.dex */
final class ave implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final Object[] f5167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ave(Object[] objArr) {
        this.f5167a = objArr;
    }

    Object readResolve() {
        return avg.m4516m(this.f5167a);
    }
}
