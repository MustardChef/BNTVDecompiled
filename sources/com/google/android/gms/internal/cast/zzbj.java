package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzbj extends UIController {
    private boolean zza = true;

    public abstract void zza(long j);

    public void zzb(boolean z) {
        this.zza = z;
    }

    public final boolean zzc() {
        return this.zza;
    }
}
