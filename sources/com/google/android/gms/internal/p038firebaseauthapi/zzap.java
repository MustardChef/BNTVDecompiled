package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap */
/* loaded from: classes3.dex */
public final class zzap {
    private final zzht zza;

    private zzap(zzht zzhtVar) {
        this.zza = zzhtVar;
    }

    public static zzap zzb(String str, byte[] bArr, int i) {
        zziu zziuVar;
        zzhs zzd = zzht.zzd();
        zzd.zza(str);
        zzd.zzb(zzym.zzm(bArr));
        zziu zziuVar2 = zziu.UNKNOWN_PREFIX;
        int i2 = i - 1;
        if (i2 == 0) {
            zziuVar = zziu.TINK;
        } else if (i2 != 1) {
            zziuVar = i2 != 2 ? zziu.CRUNCHY : zziu.RAW;
        } else {
            zziuVar = zziu.LEGACY;
        }
        zzd.zzc(zziuVar);
        return new zzap(zzd.zzl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzht zza() {
        return this.zza;
    }
}
