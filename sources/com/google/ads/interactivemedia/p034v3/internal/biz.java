package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.biz */
/* loaded from: classes2.dex */
public final class biz implements bgz {

    /* renamed from: a */
    private final bkt f5836a;

    /* renamed from: b */
    private final boolean f5837b;

    /* renamed from: c */
    private final bgs f5838c;

    /* renamed from: d */
    private final bgl f5839d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public biz(Object obj, bkt bktVar, boolean z) {
        bgs bgsVar = obj instanceof bgs ? (bgs) obj : null;
        this.f5838c = bgsVar;
        bgl bglVar = obj instanceof bgl ? (bgl) obj : null;
        this.f5839d = bglVar;
        boolean z2 = true;
        if (bgsVar == null && bglVar == null) {
            z2 = false;
        }
        axd.m4404h(z2);
        this.f5836a = bktVar;
        this.f5837b = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        if (this.f5836a.equals(bktVar) || (this.f5837b && this.f5836a.m3599d() == bktVar.m3600c())) {
            return new bja(this.f5838c, this.f5839d, bghVar, bktVar, this);
        }
        return null;
    }
}
