package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aou */
/* loaded from: classes2.dex */
public final class aou extends ape {

    /* renamed from: h */
    private List f4810h;

    public aou(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "Zsy6wzxKzkvuI5Zg91hlK7lftgUdlMXbkLzI72tnQVNXNUFbyYhuDjwGRJi5QzOf", "/h10yfi8gz82TQ6rp82eUm/z42AeNO79/O3Nlfr8yws=", agaVar, i, 31, null, null, null);
        this.f4810h = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        this.f4833g.m5437aA(-1L);
        this.f4833g.m5405aw(-1L);
        if (this.f4810h == null) {
            this.f4810h = (List) this.f4830d.invoke(null, this.f4827a.m4908b());
        }
        List list = this.f4810h;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.f4833g) {
            this.f4833g.m5437aA(((Long) this.f4810h.get(0)).longValue());
            this.f4833g.m5405aw(((Long) this.f4810h.get(1)).longValue());
        }
    }
}
