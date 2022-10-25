package com.google.android.gms.internal.cast;

import android.os.Build;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzcm extends ThreadLocal<zzcs> {
    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ zzcs initialValue() {
        if (Build.VERSION.SDK_INT >= 16) {
            return new zzcr();
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException("The current thread must have a looper!");
        }
        return new zzcq(myLooper);
    }
}
