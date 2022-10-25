package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p038firebaseauthapi.zzwg;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzbi {
    private volatile int zza;
    private final zzam zzb;
    private volatile boolean zzc;

    public zzbi(FirebaseApp firebaseApp) {
        Context applicationContext = firebaseApp.getApplicationContext();
        zzam zzamVar = new zzam(firebaseApp);
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzamVar;
        BackgroundDetector.initialize((Application) applicationContext.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzbh(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzg() {
        return this.zza > 0 && !this.zzc;
    }

    public final void zzb(zzwg zzwgVar) {
        if (zzwgVar == null) {
            return;
        }
        long zzf = zzwgVar.zzf();
        if (zzf <= 0) {
            zzf = 3600;
        }
        long zzh = zzwgVar.zzh();
        zzam zzamVar = this.zzb;
        zzamVar.zza = zzh + (zzf * 1000);
        zzamVar.zzb = -1L;
        if (zzg()) {
            this.zzb.zza();
        }
    }

    public final void zzc() {
        this.zzb.zzc();
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzg()) {
                this.zzb.zza();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzc();
        }
        this.zza = i;
    }
}
