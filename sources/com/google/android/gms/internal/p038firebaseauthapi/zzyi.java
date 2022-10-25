package com.google.android.gms.internal.p038firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi */
/* loaded from: classes3.dex */
public final class zzyi {
    private final zzyw zza;
    private final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyi(int i, zzyb zzybVar) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzyw.zzx(bArr);
    }

    public final zzym zza() {
        this.zza.zzI();
        return new zzyk(this.zzb);
    }

    public final zzyw zzb() {
        return this.zza;
    }
}
