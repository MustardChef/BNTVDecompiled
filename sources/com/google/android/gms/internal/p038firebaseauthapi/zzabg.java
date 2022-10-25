package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabg */
/* loaded from: classes3.dex */
public final class zzabg extends zzabn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabg(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabn
    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzd = zzd(i);
                if (((zzzf) zzd.getKey()).zzb()) {
                    zzd.setValue(Collections.unmodifiableList((List) zzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzzf) entry.getKey()).zzb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
