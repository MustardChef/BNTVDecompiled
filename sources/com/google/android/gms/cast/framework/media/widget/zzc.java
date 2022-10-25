package com.google.android.gms.cast.framework.media.widget;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzc {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzc(int i, int i2, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzc) && this.zza == ((zzc) obj).zza;
    }

    public final int hashCode() {
        return Integer.valueOf(this.zza).hashCode();
    }
}
