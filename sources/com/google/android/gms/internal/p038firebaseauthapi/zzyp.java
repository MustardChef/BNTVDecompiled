package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp */
/* loaded from: classes3.dex */
public abstract class zzyp {
    int zza;
    zzyq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyp(zzyn zzynVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzyp zzs(byte[] bArr, int i, int i2, boolean z) {
        zzyo zzyoVar = new zzyo(bArr, 0, i2, z, null);
        try {
            zzyoVar.zzm(i2);
            return zzyoVar;
        } catch (zzzw e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzt(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzu(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzzw;

    public abstract boolean zzc(int i) throws IOException;

    public abstract boolean zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract zzym zzg() throws IOException;

    public abstract int zzm(int i) throws zzzw;

    public abstract void zzn(int i);

    public abstract boolean zzo() throws IOException;

    public abstract int zzp();
}
