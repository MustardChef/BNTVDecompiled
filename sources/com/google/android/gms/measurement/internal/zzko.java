package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzko implements zzky {
    final /* synthetic */ zzkl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzkl zzklVar) {
        this.zza = zzklVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, Bundle bundle) {
        zzfu zzfuVar;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzp().zza(new zzkq(this, str, bundle));
            return;
        }
        zzfuVar = this.zza.zzk;
        zzfuVar.zzq().zze().zza("AppId not known when logging error event");
    }
}
