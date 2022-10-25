package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzp {
    private static final Logger zza = new Logger("DiscoveryManager");
    private final zzab zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    public final IObjectWrapper zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "getWrappedThis", zzab.class.getSimpleName());
            return null;
        }
    }
}
