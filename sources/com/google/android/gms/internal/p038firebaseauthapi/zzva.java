package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzva */
/* loaded from: classes3.dex */
final class zzva extends zztb {
    final /* synthetic */ zzvd zza;
    private final String zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzva(zzvd zzvdVar, zztb zztbVar, String str) {
        super(zztbVar);
        this.zza = zzvdVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztb
    public final void zzh(String str) {
        Logger logger;
        HashMap hashMap;
        logger = zzvd.zza;
        logger.m345d("onCodeSent", new Object[0]);
        hashMap = this.zza.zzd;
        zzvc zzvcVar = (zzvc) hashMap.get(this.zzb);
        if (zzvcVar == null) {
            return;
        }
        for (zztb zztbVar : zzvcVar.zzb) {
            zztbVar.zzh(str);
        }
        zzvcVar.zzg = true;
        zzvcVar.zzd = str;
        if (zzvcVar.zza <= 0) {
            this.zza.zzg(this.zzb);
        } else if (!zzvcVar.zzc) {
            this.zza.zzo(this.zzb);
        } else if (!zzaf.zzb(zzvcVar.zze)) {
            zzvd.zzj(this.zza, this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztb
    public final void zzk(Status status) {
        Logger logger;
        HashMap hashMap;
        logger = zzvd.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(statusCodeString).length() + 39 + String.valueOf(statusMessage).length());
        sb.append("SMS verification code request failed: ");
        sb.append(statusCodeString);
        sb.append(" ");
        sb.append(statusMessage);
        logger.m343e(sb.toString(), new Object[0]);
        hashMap = this.zza.zzd;
        zzvc zzvcVar = (zzvc) hashMap.get(this.zzb);
        if (zzvcVar == null) {
            return;
        }
        for (zztb zztbVar : zzvcVar.zzb) {
            zztbVar.zzk(status);
        }
        this.zza.zze(this.zzb);
    }
}
