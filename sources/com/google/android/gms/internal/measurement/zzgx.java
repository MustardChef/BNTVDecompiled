package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzgx {
    private final zzhi zza;
    private final byte[] zzb;

    private zzgx(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzhi.zza(bArr);
    }

    public final zzgp zza() {
        this.zza.zzb();
        return new zzgz(this.zzb);
    }

    public final zzhi zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgx(int i, zzgs zzgsVar) {
        this(i);
    }
}
