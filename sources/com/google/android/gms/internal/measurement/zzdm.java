package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzdm {
    final Uri zza;
    final String zzb;
    final String zzc;
    private final String zzd;
    private final boolean zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    @Nullable
    private final zzdw<Context, Boolean> zzi;

    public zzdm(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzdm(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzdw<Context, Boolean> zzdwVar) {
        this.zzd = null;
        this.zza = uri;
        this.zzb = str2;
        this.zzc = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzdh<Long> zza(String str, long j) {
        zzdh<Long> zzb;
        zzb = zzdh.zzb(this, str, j, true);
        return zzb;
    }

    public final zzdh<Boolean> zza(String str, boolean z) {
        zzdh<Boolean> zzb;
        zzb = zzdh.zzb(this, str, z, true);
        return zzb;
    }

    public final zzdh<Double> zza(String str, double d) {
        zzdh<Double> zzb;
        zzb = zzdh.zzb(this, str, -3.0d, true);
        return zzb;
    }

    public final zzdh<String> zza(String str, String str2) {
        zzdh<String> zzb;
        zzb = zzdh.zzb(this, str, str2, true);
        return zzb;
    }
}
