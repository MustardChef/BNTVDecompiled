package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdf */
/* loaded from: classes3.dex */
public final class zzdf {
    public static final zzht zza;
    public static final zzht zzb;
    public static final zzht zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zza = zza(zzgv.NIST_P256, zzha.SHA256, zzgb.UNCOMPRESSED, zzbn.zza, zziu.TINK, bArr);
        zzb = zza(zzgv.NIST_P256, zzha.SHA256, zzgb.COMPRESSED, zzbn.zza, zziu.RAW, bArr);
        zzc = zza(zzgv.NIST_P256, zzha.SHA256, zzgb.UNCOMPRESSED, zzbn.zze, zziu.TINK, bArr);
    }

    public static zzht zza(zzgv zzgvVar, zzha zzhaVar, zzgb zzgbVar, zzht zzhtVar, zziu zziuVar, byte[] bArr) {
        zzgg zzc2 = zzgh.zzc();
        zzgs zzd2 = zzgt.zzd();
        zzd2.zza(zzgvVar);
        zzd2.zzb(zzhaVar);
        zzd2.zzc(zzym.zzm(bArr));
        zzgd zzb2 = zzge.zzb();
        zzb2.zza(zzhtVar);
        zzgj zzd3 = zzgk.zzd();
        zzd3.zza(zzd2.zzl());
        zzd3.zzb(zzb2.zzl());
        zzd3.zzc(zzgbVar);
        zzc2.zza(zzd3.zzl());
        zzhs zzd4 = zzht.zzd();
        new zzcx();
        zzd4.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzd4.zzc(zziuVar);
        zzd4.zzb(zzc2.zzl().zzn());
        return zzd4.zzl();
    }
}
