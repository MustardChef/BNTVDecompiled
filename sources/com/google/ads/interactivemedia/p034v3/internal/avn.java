package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avn */
/* loaded from: classes2.dex */
final class avn implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final Object[] f5181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avn(Object[] objArr) {
        this.f5181a = objArr;
    }

    Object readResolve() {
        return avo.m4494m(this.f5181a);
    }
}
