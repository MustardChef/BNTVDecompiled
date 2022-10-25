package com.google.android.gms.internal.cast;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public interface zzq extends IInterface {
    com.google.android.gms.cast.framework.zzu zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzsVar, Map map) throws RemoteException;

    com.google.android.gms.cast.framework.zzah zzf(String str, String str2, com.google.android.gms.cast.framework.zzap zzapVar) throws RemoteException;

    com.google.android.gms.cast.framework.zzx zzg(CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzr zzrVar) throws RemoteException;

    com.google.android.gms.cast.framework.zzae zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    com.google.android.gms.cast.framework.media.internal.zzi zzi(IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException;
}
