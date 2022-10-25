package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzcy implements zzcx {
    private static zzcy zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcy zza(Context context) {
        zzcy zzcyVar;
        synchronized (zzcy.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcy(context) : new zzcy();
            }
            zzcyVar = zza;
        }
        return zzcyVar;
    }

    private zzcy(Context context) {
        this.zzb = context;
        zzda zzdaVar = new zzda(this, null);
        this.zzc = zzdaVar;
        context.getContentResolver().registerContentObserver(zzcp.zza, true, zzdaVar);
    }

    private zzcy() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcx
    /* renamed from: zzc */
    public final String zza(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcw.zza(new zzcz(this, str) { // from class: com.google.android.gms.internal.measurement.zzdb
                private final zzcy zza;
                private final String zzb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzcz
                public final Object zza() {
                    return this.zza.zzb(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zza() {
        Context context;
        synchronized (zzcy.class) {
            zzcy zzcyVar = zza;
            if (zzcyVar != null && (context = zzcyVar.zzb) != null && zzcyVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb(String str) {
        return zzcp.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
