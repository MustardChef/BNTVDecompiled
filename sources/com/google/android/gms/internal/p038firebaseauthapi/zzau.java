package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau */
/* loaded from: classes3.dex */
public final class zzau {
    private final zzhy zza;

    private zzau(zzhy zzhyVar) {
        this.zza = zzhyVar;
    }

    public static zzau zza(zzat zzatVar) {
        return new zzau(zzatVar.zzb().zzu());
    }

    public static zzau zzb() {
        return new zzau(zzib.zzf());
    }

    private final synchronized zzia zzg(zzht zzhtVar) throws GeneralSecurityException {
        zzhz zzf;
        zzho zze = zzbk.zze(zzhtVar);
        int zzi = zzi();
        zziu zzc = zzhtVar.zzc();
        if (zzc == zziu.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        zzf = zzia.zzf();
        zzf.zza(zze);
        zzf.zzc(zzi);
        zzf.zzb(zzhq.ENABLED);
        zzf.zzd(zzc);
        return zzf.zzl();
    }

    private final synchronized boolean zzh(int i) {
        boolean z;
        Iterator<zzia> it = this.zza.zzb().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().zzd() == i) {
                z = true;
                break;
            }
        }
        return z;
    }

    private final synchronized int zzi() {
        int zzj;
        zzj = zzj();
        while (zzh(zzj)) {
            zzj = zzj();
        }
        return zzj;
    }

    private static int zzj() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i;
    }

    public final synchronized zzat zzc() throws GeneralSecurityException {
        return zzat.zza(this.zza.zzl());
    }

    public final synchronized zzau zzd(zzap zzapVar) throws GeneralSecurityException {
        zze(zzapVar.zza(), false);
        return this;
    }

    @Deprecated
    public final synchronized int zze(zzht zzhtVar, boolean z) throws GeneralSecurityException {
        zzia zzg;
        zzg = zzg(zzhtVar);
        this.zza.zze(zzg);
        return zzg.zzd();
    }

    public final synchronized zzau zzf(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            zzia zzd = this.zza.zzd(i2);
            if (zzd.zzd() == i) {
                if (!zzd.zzc().equals(zzhq.ENABLED)) {
                    StringBuilder sb = new StringBuilder(63);
                    sb.append("cannot set key as primary because it's not enabled: ");
                    sb.append(i);
                    throw new GeneralSecurityException(sb.toString());
                } else {
                    this.zza.zza(i);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("key not found: ");
        sb2.append(i);
        throw new GeneralSecurityException(sb2.toString());
        return this;
    }
}
