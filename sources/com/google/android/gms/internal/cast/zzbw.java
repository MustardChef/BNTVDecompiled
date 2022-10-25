package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public class zzbw extends BaseImplementation.ApiMethodImpl<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzcb> {
    final /* synthetic */ zzby zzc;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzbw(com.google.android.gms.internal.cast.zzby r1, com.google.android.gms.common.api.GoogleApiClient r2) {
        /*
            r0 = this;
            r0.zzc = r1
            com.google.android.gms.common.api.Api r1 = com.google.android.gms.internal.cast.zzby.zzd(r1)
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzbw.<init>(com.google.android.gms.internal.cast.zzby, com.google.android.gms.common.api.GoogleApiClient):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzbx(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzbw) ((Result) obj));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza */
    public void doExecute(zzcb zzcbVar) throws RemoteException {
        throw null;
    }
}
