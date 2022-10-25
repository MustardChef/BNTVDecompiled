package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkx */
/* loaded from: classes3.dex */
final class zzkx extends zzku {
    private final zzkw zza = new zzkw();

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzku
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.zza.zza(th, true).add(th2);
    }
}
