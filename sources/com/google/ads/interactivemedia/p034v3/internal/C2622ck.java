package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ck */
/* loaded from: classes2.dex */
public final class C2622ck implements InterfaceC2598bn {
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2598bn
    /* renamed from: a */
    public final long mo2615a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2598bn
    /* renamed from: b */
    public final InterfaceC2605bu mo2614b(Looper looper, Handler.Callback callback) {
        return new C2624cm(new Handler(looper, callback));
    }
}
