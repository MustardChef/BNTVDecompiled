package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzm {
    private static final Logger zza = new Logger("CastDynamiteModule");

    public static com.google.android.gms.cast.framework.zzu zza(Context context, CastOptions castOptions, zzs zzsVar, Map<String, IBinder> map) throws com.google.android.gms.cast.framework.zzar, RemoteException {
        return zzf(context).zze(ObjectWrapper.wrap(context.getApplicationContext()), castOptions, zzsVar, map);
    }

    public static com.google.android.gms.cast.framework.zzah zzb(Context context, String str, String str2, com.google.android.gms.cast.framework.zzap zzapVar) {
        try {
            return zzf(context).zzf(str, str2, zzapVar);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzar e) {
            zza.m368d(e, "Unable to call %s on %s.", "newSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.zzx zzc(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, com.google.android.gms.cast.framework.zzr zzrVar) {
        if (iObjectWrapper == null) {
            return null;
        }
        try {
            return zzf(context).zzg(castOptions, iObjectWrapper, zzrVar);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzar e) {
            zza.m368d(e, "Unable to call %s on %s.", "newCastSessionImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    public static com.google.android.gms.cast.framework.zzae zzd(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        if (iObjectWrapper != null && iObjectWrapper2 != null) {
            try {
                return zzf(service.getApplicationContext()).zzh(ObjectWrapper.wrap(service), iObjectWrapper, iObjectWrapper2);
            } catch (RemoteException | com.google.android.gms.cast.framework.zzar e) {
                zza.m368d(e, "Unable to call %s on %s.", "newReconnectionServiceImpl", zzq.class.getSimpleName());
            }
        }
        return null;
    }

    public static com.google.android.gms.cast.framework.media.internal.zzi zze(Context context, AsyncTask<Uri, Long, Bitmap> asyncTask, com.google.android.gms.cast.framework.media.internal.zzk zzkVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        try {
            return zzf(context.getApplicationContext()).zzi(ObjectWrapper.wrap(asyncTask), zzkVar, i, i2, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000);
        } catch (RemoteException | com.google.android.gms.cast.framework.zzar e) {
            zza.m368d(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", zzq.class.getSimpleName());
            return null;
        }
    }

    private static zzq zzf(Context context) throws com.google.android.gms.cast.framework.zzar {
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (instantiate == null) {
                return null;
            }
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            if (queryLocalInterface instanceof zzq) {
                return (zzq) queryLocalInterface;
            }
            return new zzp(instantiate);
        } catch (DynamiteModule.LoadingException e) {
            throw new com.google.android.gms.cast.framework.zzar(e);
        }
    }
}
