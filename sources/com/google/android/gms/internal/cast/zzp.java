package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzp extends zza implements zzq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzu zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzsVar, Map map) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc.zzd(zza, castOptions);
        zzc.zzf(zza, zzsVar);
        zza.writeMap(map);
        Parcel zzb = zzb(1, zza);
        com.google.android.gms.cast.framework.zzu zzb2 = com.google.android.gms.cast.framework.zzt.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzah zzf(String str, String str2, com.google.android.gms.cast.framework.zzap zzapVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzf(zza, zzapVar);
        Parcel zzb = zzb(2, zza);
        com.google.android.gms.cast.framework.zzah zzb2 = com.google.android.gms.cast.framework.zzag.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzx zzg(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, castOptions);
        zzc.zzf(zza, iObjectWrapper);
        zzc.zzf(zza, zzrVar);
        Parcel zzb = zzb(3, zza);
        com.google.android.gms.cast.framework.zzx zzb2 = com.google.android.gms.cast.framework.zzw.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.zzae zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc.zzf(zza, iObjectWrapper2);
        zzc.zzf(zza, iObjectWrapper3);
        Parcel zzb = zzb(5, zza);
        com.google.android.gms.cast.framework.zzae zzb2 = com.google.android.gms.cast.framework.zzad.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    @Override // com.google.android.gms.internal.cast.zzq
    public final com.google.android.gms.cast.framework.media.internal.zzi zzi(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc.zzf(zza, zzkVar);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc.zzb(zza, false);
        zza.writeLong(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        zza.writeInt(5);
        zza.writeInt(333);
        zza.writeInt(10000);
        Parcel zzb = zzb(6, zza);
        com.google.android.gms.cast.framework.media.internal.zzi zzb2 = com.google.android.gms.cast.framework.media.internal.zzh.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }
}
