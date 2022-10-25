package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzba */
/* loaded from: classes3.dex */
public final class zzba<P> {
    private final P zza;
    private final byte[] zzb;
    private final zzhq zzc;
    private final zziu zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(P p, byte[] bArr, zzhq zzhqVar, zziu zziuVar, int i) {
        this.zza = p;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzc = zzhqVar;
        this.zzd = zziuVar;
    }

    public final P zza() {
        return this.zza;
    }

    public final zzhq zzb() {
        return this.zzc;
    }

    public final zziu zzc() {
        return this.zzd;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
