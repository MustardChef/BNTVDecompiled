package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bja */
/* loaded from: classes2.dex */
public final class bja<T> extends bgy<T> {

    /* renamed from: a */
    final bgh f5865a;

    /* renamed from: b */
    private final bgs f5866b;

    /* renamed from: c */
    private final bgl f5867c;

    /* renamed from: d */
    private final bkt f5868d;

    /* renamed from: e */
    private final bgz f5869e;

    /* renamed from: f */
    private final biy f5870f = new biy();

    /* renamed from: g */
    private volatile bgy f5871g;

    public bja(bgs bgsVar, bgl bglVar, bgh bghVar, bkt bktVar, bgz bgzVar) {
        this.f5866b = bgsVar;
        this.f5867c = bglVar;
        this.f5865a = bghVar;
        this.f5868d = bktVar;
        this.f5869e = bgzVar;
    }

    /* renamed from: a */
    public static bgz m3619a(bkt bktVar, Object obj) {
        return new biz(obj, bktVar, bktVar.m3599d() == bktVar.m3600c());
    }

    /* renamed from: b */
    private final bgy m3618b() {
        bgy bgyVar = this.f5871g;
        if (bgyVar != null) {
            return bgyVar;
        }
        bgy m3726c = this.f5865a.m3726c(this.f5869e, this.f5868d);
        this.f5871g = m3726c;
        return m3726c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final T read(bkv bkvVar) throws IOException {
        if (this.f5867c == null) {
            return (T) m3618b().read(bkvVar);
        }
        if (axn.m4378c(bkvVar) instanceof bgo) {
            return null;
        }
        return (T) this.f5867c.m3712a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, T t) throws IOException {
        bgs bgsVar = this.f5866b;
        if (bgsVar == null) {
            m3618b().write(bkxVar, t);
        } else if (t == null) {
            bkxVar.mo3558g();
        } else {
            axn.m4377d(bgsVar.mo3702a(t), bkxVar);
        }
    }
}
