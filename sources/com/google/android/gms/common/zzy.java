package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
final class zzy {
    private String zza = null;
    private long zzb = -1;
    private com.google.android.gms.internal.common.zzu<byte[]> zzc = com.google.android.gms.internal.common.zzu.zzi();
    private com.google.android.gms.internal.common.zzu<byte[]> zzd = com.google.android.gms.internal.common.zzu.zzi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzy zza(String str) {
        this.zza = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzy zzb(long j) {
        this.zzb = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzy zzc(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzc = com.google.android.gms.internal.common.zzu.zzm(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzy zzd(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzd = com.google.android.gms.internal.common.zzu.zzm(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzz zze() {
        if (this.zza != null) {
            if (this.zzb < 0) {
                throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
            }
            if (!this.zzc.isEmpty() || !this.zzd.isEmpty()) {
                return new zzz(this.zza, this.zzb, this.zzc, this.zzd, null);
            }
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        throw new IllegalStateException("packageName must be defined");
    }
}
