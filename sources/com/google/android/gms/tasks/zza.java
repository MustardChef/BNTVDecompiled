package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
final class zza implements OnSuccessListener<Void> {
    final /* synthetic */ OnTokenCanceledListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzb zzbVar, OnTokenCanceledListener onTokenCanceledListener) {
        this.zza = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Void r1) {
        this.zza.onCanceled();
    }
}
