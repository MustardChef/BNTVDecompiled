package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzad extends com.google.android.gms.internal.cast.zzb implements zzae {
    public static zzae zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
        if (queryLocalInterface instanceof zzae) {
            return (zzae) queryLocalInterface;
        }
        return new zzac(iBinder);
    }
}
