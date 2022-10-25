package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzw extends com.google.android.gms.internal.cast.zzb implements zzx {
    public static zzx zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
        if (queryLocalInterface instanceof zzx) {
            return (zzx) queryLocalInterface;
        }
        return new zzv(iBinder);
    }
}
