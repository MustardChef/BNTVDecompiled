package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzhq implements zzky {
    private final /* synthetic */ zzhb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhq(zzhb zzhbVar) {
        this.zza = zzhbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zza("auto", "_err", bundle, str);
        } else {
            this.zza.zza("auto", "_err", bundle);
        }
    }
}
