package com.google.ads.interactivemedia.p034v3.internal;

import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.uj */
/* loaded from: classes2.dex */
public abstract class AbstractC3107uj implements InterfaceC3125va {

    /* renamed from: b */
    private final long f9071b;

    /* renamed from: c */
    private final long f9072c;

    /* renamed from: d */
    private long f9073d;

    public AbstractC3107uj(long j, long j2) {
        this.f9071b = j;
        this.f9072c = j2;
        this.f9073d = j - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final long m908c() {
        return this.f9073d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m907d() {
        long j = this.f9073d;
        if (j < this.f9071b || j > this.f9072c) {
            throw new NoSuchElementException();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3125va
    /* renamed from: e */
    public final boolean mo850e() {
        long j = this.f9073d + 1;
        this.f9073d = j;
        return j <= this.f9072c;
    }
}
