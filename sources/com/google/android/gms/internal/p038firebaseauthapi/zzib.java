package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzib */
/* loaded from: classes3.dex */
public final class zzib extends zzzo<zzib, zzhy> implements zzaas {
    private static final zzib zzf;
    private int zzb;
    private zzzt<zzia> zze = zzB();

    static {
        zzib zzibVar = new zzib();
        zzf = zzibVar;
        zzzo.zzy(zzib.class, zzibVar);
    }

    private zzib() {
    }

    public static zzib zze(byte[] bArr, zzzb zzzbVar) throws zzzw {
        return (zzib) zzzo.zzF(zzf, bArr, zzzbVar);
    }

    public static zzhy zzf() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzib zzibVar, zzia zziaVar) {
        zziaVar.getClass();
        zzzt<zzia> zzztVar = zzibVar.zze;
        if (!zzztVar.zza()) {
            zzibVar.zze = zzzo.zzC(zzztVar);
        }
        zzibVar.zze.add(zziaVar);
    }

    public final int zza() {
        return this.zzb;
    }

    public final List<zzia> zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zze.size();
    }

    public final zzia zzd(int i) {
        return this.zze.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzzo
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zzf;
                    }
                    return new zzhy(null);
                }
                return new zzib();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzia.class});
        }
        return (byte) 1;
    }
}
