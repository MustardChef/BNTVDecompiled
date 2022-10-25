package com.google.ads.interactivemedia.p034v3.internal;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blk */
/* loaded from: classes2.dex */
public final class blk extends bll {

    /* renamed from: a */
    final /* synthetic */ bls f6008a;

    /* renamed from: b */
    private int f6009b = 0;

    /* renamed from: c */
    private final int f6010c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public blk(bls blsVar) {
        this.f6008a = blsVar;
        this.f6010c = blsVar.mo3054d();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blo
    /* renamed from: a */
    public final byte mo3067a() {
        int i = this.f6009b;
        if (i >= this.f6010c) {
            throw new NoSuchElementException();
        }
        this.f6009b = i + 1;
        return this.f6008a.mo3056b(i);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6009b < this.f6010c;
    }
}
