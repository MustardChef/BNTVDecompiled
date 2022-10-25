package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zze extends com.google.android.gms.internal.cast.zza implements zzg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final IObjectWrapper zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final List<NotificationAction> zzf() throws RemoteException {
        Parcel zzb = zzb(3, zza());
        ArrayList createTypedArrayList = zzb.createTypedArrayList(NotificationAction.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final int[] zzg() throws RemoteException {
        Parcel zzb = zzb(4, zza());
        int[] createIntArray = zzb.createIntArray();
        zzb.recycle();
        return createIntArray;
    }
}
