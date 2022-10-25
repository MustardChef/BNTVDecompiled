package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p038firebaseauthapi.zzpl;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Future;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpo */
/* loaded from: classes3.dex */
public abstract class zzpo<T extends zzpl> {
    private zzpk<T> zza;

    abstract Future<zzpk<T>> zza();

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzb(zzpn<A, ResultT> zzpnVar) {
        return (Task<ResultT>) zzd().zza.doRead(zzpnVar.zzb());
    }

    public final <ResultT, A extends Api.AnyClient> Task<ResultT> zzc(zzpn<A, ResultT> zzpnVar) {
        return (Task<ResultT>) zzd().zza.doWrite(zzpnVar.zzb());
    }

    public final zzpk<T> zzd() {
        zzpk<T> zzpkVar;
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zza().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to the GoogleApi: ".concat(valueOf) : new String("There was an error while initializing the connection to the GoogleApi: "));
                }
            }
            zzpkVar = this.zza;
        }
        return zzpkVar;
    }
}
