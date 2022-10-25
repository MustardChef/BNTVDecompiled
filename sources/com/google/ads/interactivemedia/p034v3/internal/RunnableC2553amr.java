package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amr */
/* loaded from: classes2.dex */
public final class RunnableC2553amr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ams f4640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2553amr(ams amsVar) {
        this.f4640a = amsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        art artVar;
        Object obj2;
        obj = this.f4640a.f4652l;
        synchronized (obj) {
            z = this.f4640a.f4653m;
            if (z) {
                return;
            }
            this.f4640a.f4653m = true;
            try {
                ams.m4993j(this.f4640a);
            } catch (Exception e) {
                artVar = this.f4640a.f4648h;
                artVar.m4727c(2023, -1L, e);
            }
            obj2 = this.f4640a.f4652l;
            synchronized (obj2) {
                this.f4640a.f4653m = false;
            }
        }
    }
}
