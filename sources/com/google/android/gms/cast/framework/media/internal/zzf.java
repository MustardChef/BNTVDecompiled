package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzf extends AsyncTask<Uri, Long, Bitmap> {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzi zzb;
    private final zzb zzc;

    public zzf(Context context, int i, int i2, boolean z, long j, int i3, int i4, int i5, zzb zzbVar, byte[] bArr) {
        this.zzc = zzbVar;
        this.zzb = com.google.android.gms.internal.cast.zzm.zze(context.getApplicationContext(), this, new zze(this, null), i, i2, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Bitmap doInBackground(Uri[] uriArr) {
        Uri uri;
        zzi zziVar;
        Uri[] uriArr2 = uriArr;
        if (uriArr2.length != 1 || (uri = uriArr2[0]) == null || (zziVar = this.zzb) == null) {
            return null;
        }
        try {
            return zziVar.zze(uri);
        } catch (RemoteException e) {
            zza.m368d(e, "Unable to call %s on %s.", "doFetch", zzi.class.getSimpleName());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        zzb zzbVar = this.zzc;
        if (zzbVar != null) {
            zzbVar.zzd(bitmap2);
        }
    }
}
