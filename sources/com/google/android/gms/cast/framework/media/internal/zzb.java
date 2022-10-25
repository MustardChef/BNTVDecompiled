package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzb {
    private final Context zza;
    private final ImageHints zzb;
    private Uri zzc;
    private zzf zzd;
    private zzd zze;
    private Bitmap zzf;
    private boolean zzg;
    private zza zzh;

    public zzb(Context context) {
        this(context, new ImageHints(-1, 0, 0));
    }

    private final void zze() {
        zzf zzfVar = this.zzd;
        if (zzfVar != null) {
            zzfVar.cancel(true);
            this.zzd = null;
        }
        this.zzc = null;
        this.zzf = null;
        this.zzg = false;
    }

    public final void zza(zza zzaVar) {
        this.zzh = zzaVar;
    }

    public final boolean zzb(Uri uri) {
        if (uri == null) {
            zze();
            return true;
        } else if (uri.equals(this.zzc)) {
            return this.zzg;
        } else {
            zze();
            this.zzc = uri;
            if (this.zzb.getWidthInPixels() == 0 || this.zzb.getHeightInPixels() == 0) {
                this.zzd = new zzf(this.zza, 0, 0, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000, this, null);
            } else {
                this.zzd = new zzf(this.zza, this.zzb.getWidthInPixels(), this.zzb.getHeightInPixels(), false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000, this, null);
            }
            ((zzf) Preconditions.checkNotNull(this.zzd)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Uri) Preconditions.checkNotNull(this.zzc));
            return false;
        }
    }

    public final void zzc() {
        zze();
        this.zzh = null;
    }

    public final void zzd(Bitmap bitmap) {
        this.zzf = bitmap;
        this.zzg = true;
        zza zzaVar = this.zzh;
        if (zzaVar != null) {
            zzaVar.zza(bitmap);
        }
        this.zzd = null;
    }

    public zzb(Context context, ImageHints imageHints) {
        this.zza = context;
        this.zzb = imageHints;
        this.zze = new zzd();
        zze();
    }
}
