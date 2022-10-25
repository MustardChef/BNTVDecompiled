package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzag extends com.google.android.gms.internal.cast.zzb implements zzah {
    public static zzah zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
        if (queryLocalInterface instanceof zzah) {
            return (zzah) queryLocalInterface;
        }
        return new zzaf(iBinder);
    }
}
