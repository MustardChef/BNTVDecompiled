package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzf {
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public boolean zzf;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzf) {
            zzf zzfVar = (zzf) obj;
            return this.zza == zzfVar.zza && this.zzb == zzfVar.zzb && this.zzc == zzfVar.zzc && this.zzd == zzfVar.zzd && this.zze == zzfVar.zze && this.zzf == zzfVar.zzf;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Boolean.valueOf(this.zzf));
    }
}
