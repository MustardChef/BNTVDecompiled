package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzcq extends zzdp {
    private final Context zza;
    private final zzec<zzdy<zzdd>> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcq(Context context, @Nullable zzec<zzdy<zzdd>> zzecVar) {
        Objects.requireNonNull(context, "Null context");
        this.zza = context;
        this.zzb = zzecVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    @Nullable
    public final zzec<zzdy<zzdd>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        zzec<zzdy<zzdd>> zzecVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdp) {
            zzdp zzdpVar = (zzdp) obj;
            if (this.zza.equals(zzdpVar.zza()) && ((zzecVar = this.zzb) != null ? zzecVar.equals(zzdpVar.zzb()) : zzdpVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzec<zzdy<zzdd>> zzecVar = this.zzb;
        return hashCode ^ (zzecVar == null ? 0 : zzecVar.hashCode());
    }
}
