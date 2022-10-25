package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzl extends com.google.android.gms.cast.internal.zzab {
    final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzl(zzm zzmVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zza = str;
    }

    @Override // com.google.android.gms.cast.internal.zzab, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        doExecute(zzwVar);
    }

    @Override // com.google.android.gms.cast.internal.zzab
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        if (TextUtils.isEmpty(this.zza)) {
            setResult((zzl) new Status(2001, "IllegalArgument: sessionId cannot be null or empty", (PendingIntent) null));
            return;
        }
        try {
            zzwVar.zzt(this.zza, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
