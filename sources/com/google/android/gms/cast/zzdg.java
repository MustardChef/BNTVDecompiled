package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzdg extends com.google.android.gms.cast.internal.zzc<RemoteMediaPlayer.MediaChannelResult> {
    private com.google.android.gms.cast.internal.zzap zza;
    protected final WeakReference<GoogleApiClient> zzg;
    final /* synthetic */ RemoteMediaPlayer zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzh = remoteMediaPlayer;
        this.zzg = new WeakReference<>(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzdf(this, status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        Object obj;
        zzdd zzddVar;
        zzdd zzddVar2;
        com.google.android.gms.cast.internal.zzw zzwVar2 = zzwVar;
        obj = this.zzh.zza;
        synchronized (obj) {
            GoogleApiClient googleApiClient = this.zzg.get();
            if (googleApiClient == null) {
                setResult((zzdg) new zzdf(this, new Status(2100)));
                return;
            }
            zzddVar = this.zzh.zzc;
            zzddVar.zza(googleApiClient);
            try {
                zza(zzwVar2);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                setResult((zzdg) new zzdf(this, new Status(2100)));
            }
            zzddVar2 = this.zzh.zzc;
            zzddVar2.zza(null);
        }
    }

    abstract void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws com.google.android.gms.cast.internal.zzal;

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.cast.internal.zzap zzb() {
        if (this.zza == null) {
            this.zza = new zzde(this);
        }
        return this.zza;
    }
}
