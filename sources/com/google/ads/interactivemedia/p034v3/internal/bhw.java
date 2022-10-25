package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhw */
/* loaded from: classes2.dex */
abstract class bhw implements Iterator {

    /* renamed from: a */
    bhx f5746a;

    /* renamed from: b */
    bhx f5747b = null;

    /* renamed from: c */
    int f5748c;

    /* renamed from: d */
    final /* synthetic */ bhy f5749d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhw(bhy bhyVar) {
        this.f5749d = bhyVar;
        this.f5746a = bhyVar.f5763e.f5753d;
        this.f5748c = bhyVar.f5762d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final bhx m3669a() {
        bhx bhxVar = this.f5746a;
        bhy bhyVar = this.f5749d;
        if (bhxVar != bhyVar.f5763e) {
            if (bhyVar.f5762d != this.f5748c) {
                throw new ConcurrentModificationException();
            }
            this.f5746a = bhxVar.f5753d;
            this.f5747b = bhxVar;
            return bhxVar;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5746a != this.f5749d.f5763e;
    }

    @Override // java.util.Iterator
    public final void remove() {
        bhx bhxVar = this.f5747b;
        if (bhxVar == null) {
            throw new IllegalStateException();
        }
        this.f5749d.m3664e(bhxVar, true);
        this.f5747b = null;
        this.f5748c = this.f5749d.f5762d;
    }
}
