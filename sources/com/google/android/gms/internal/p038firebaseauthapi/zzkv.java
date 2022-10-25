package com.google.android.gms.internal.p038firebaseauthapi;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkv */
/* loaded from: classes3.dex */
final class zzkv extends WeakReference<Throwable> {
    private final int zza;

    public zzkv(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzkv zzkvVar = (zzkv) obj;
            if (this.zza == zzkvVar.zza && get() == zzkvVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}
