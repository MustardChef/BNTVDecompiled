package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.js */
/* loaded from: classes2.dex */
final class C2819js {

    /* renamed from: a */
    private Exception f7719a;

    /* renamed from: b */
    private long f7720b;

    /* renamed from: a */
    public final void m1902a() {
        this.f7719a = null;
    }

    /* renamed from: b */
    public final void m1901b(Exception exc) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7719a == null) {
            this.f7719a = exc;
            this.f7720b = 100 + elapsedRealtime;
        }
        if (elapsedRealtime < this.f7720b) {
            return;
        }
        Exception exc2 = this.f7719a;
        m1902a();
        throw exc2;
    }
}
