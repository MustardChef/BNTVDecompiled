package com.google.ads.interactivemedia.p034v3.internal;

import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bou */
/* loaded from: classes2.dex */
final class bou extends bll {

    /* renamed from: a */
    final bow f6353a;

    /* renamed from: b */
    blo f6354b = m3066b();

    /* renamed from: c */
    final /* synthetic */ box f6355c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bou(box boxVar) {
        this.f6355c = boxVar;
        this.f6353a = new bow(boxVar);
    }

    /* renamed from: b */
    private final blo m3066b() {
        bow bowVar = this.f6353a;
        if (bowVar.hasNext()) {
            return bowVar.next().iterator();
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blo
    /* renamed from: a */
    public final byte mo3067a() {
        blo bloVar = this.f6354b;
        if (bloVar == null) {
            throw new NoSuchElementException();
        }
        byte mo3067a = bloVar.mo3067a();
        if (!this.f6354b.hasNext()) {
            this.f6354b = m3066b();
        }
        return mo3067a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6354b != null;
    }
}
