package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb */
/* loaded from: classes3.dex */
public final class zzvb extends BroadcastReceiver {
    final /* synthetic */ zzvd zza;
    private final String zzb;

    public zzvb(zzvd zzvdVar, String str) {
        this.zza = zzvdVar;
        this.zzb = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        Logger logger;
        Logger logger2;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                hashMap = this.zza.zzd;
                zzvc zzvcVar = (zzvc) hashMap.get(this.zzb);
                if (zzvcVar == null) {
                    logger2 = zzvd.zza;
                    logger2.m343e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzvcVar.zze = zzvd.zzf(str);
                    if (zzvcVar.zze == null) {
                        logger = zzvd.zza;
                        logger.m343e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzaf.zzb(zzvcVar.zzd)) {
                        zzvd.zzj(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
