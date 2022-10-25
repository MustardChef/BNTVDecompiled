package com.google.android.gms.cast.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class zzd extends zzp {
    private final List<zzar> zzb;

    public zzd(String str, String str2, String str3) {
        super(str, "MediaControlChannel", null);
        this.zzb = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza() {
        synchronized (this.zzb) {
            for (zzar zzarVar : this.zzb) {
                zzarVar.zze(2002);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<zzar> zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(zzar zzarVar) {
        this.zzb.add(zzarVar);
    }
}
