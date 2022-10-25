package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avk */
/* loaded from: classes2.dex */
final class avk implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final avj f5179a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avk(avj avjVar) {
        this.f5179a = avjVar;
    }

    Object readResolve() {
        return this.f5179a.entrySet();
    }
}
