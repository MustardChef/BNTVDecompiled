package com.google.ads.interactivemedia.p034v3.internal;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkn */
/* loaded from: classes2.dex */
final class bkn implements bgz {

    /* renamed from: a */
    private final /* synthetic */ int f5947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bkn(int i) {
        this.f5947a = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        int i = this.f5947a;
        if (i == 0) {
            if (bktVar.m3600c() == Time.class) {
                return new bko(null);
            }
            return null;
        } else if (i != 1) {
            if (bktVar.m3600c() == Timestamp.class) {
                return new bkp(bghVar.m3727b(Date.class));
            }
            return null;
        } else if (bktVar.m3600c() == java.sql.Date.class) {
            return new bkm(null);
        } else {
            return null;
        }
    }
}
