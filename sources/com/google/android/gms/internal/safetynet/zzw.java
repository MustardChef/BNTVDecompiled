package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzw extends zze {
    private final /* synthetic */ zzk.zzf zzak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzk.zzf zzfVar) {
        this.zzak = zzfVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, SafeBrowsingData safeBrowsingData) {
        this.zzak.setResult((zzk.zzf) new zzk.zzi(status, safeBrowsingData));
    }
}
