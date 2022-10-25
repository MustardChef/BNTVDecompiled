package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzbh implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ zzbi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(zzbi zzbiVar) {
        this.zza = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        boolean zzg;
        zzam zzamVar;
        if (z) {
            this.zza.zzc = true;
            this.zza.zzc();
            return;
        }
        this.zza.zzc = false;
        zzg = this.zza.zzg();
        if (zzg) {
            zzamVar = this.zza.zzb;
            zzamVar.zza();
        }
    }
}
