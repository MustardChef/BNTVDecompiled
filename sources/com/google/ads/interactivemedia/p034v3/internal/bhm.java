package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhm */
/* loaded from: classes2.dex */
final class bhm extends bgy {

    /* renamed from: a */
    final /* synthetic */ boolean f5729a;

    /* renamed from: b */
    final /* synthetic */ boolean f5730b;

    /* renamed from: c */
    final /* synthetic */ bgh f5731c;

    /* renamed from: d */
    final /* synthetic */ bkt f5732d;

    /* renamed from: e */
    final /* synthetic */ bhn f5733e;

    /* renamed from: f */
    private bgy f5734f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhm(bhn bhnVar, boolean z, boolean z2, bgh bghVar, bkt bktVar) {
        this.f5733e = bhnVar;
        this.f5729a = z;
        this.f5730b = z2;
        this.f5731c = bghVar;
        this.f5732d = bktVar;
    }

    /* renamed from: a */
    private final bgy m3680a() {
        bgy bgyVar = this.f5734f;
        if (bgyVar != null) {
            return bgyVar;
        }
        bgy m3726c = this.f5731c.m3726c(this.f5733e, this.f5732d);
        this.f5734f = m3726c;
        return m3726c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final Object read(bkv bkvVar) throws IOException {
        if (this.f5729a) {
            bkvVar.mo3577o();
            return null;
        }
        return m3680a().read(bkvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, Object obj) throws IOException {
        if (this.f5730b) {
            bkxVar.mo3558g();
        } else {
            m3680a().write(bkxVar, obj);
        }
    }
}
