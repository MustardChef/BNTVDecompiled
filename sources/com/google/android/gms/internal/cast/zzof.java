package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzof extends zznp {
    private static final Logger zzb = Logger.getLogger(zzof.class.getName());
    private static final boolean zzc = zzrh.zza();
    zzog zza;

    private zzof() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzof(zzoc zzocVar) {
    }

    public static int zzA(zzny zznyVar) {
        int zzc2 = zznyVar.zzc();
        return zzw(zzc2) + zzc2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzB(zzpy zzpyVar, zzqj zzqjVar) {
        zznm zznmVar = (zznm) zzpyVar;
        int zzn = zznmVar.zzn();
        if (zzn == -1) {
            zzn = zzqjVar.zzd(zznmVar);
            zznmVar.zzo(zzn);
        }
        return zzw(zzn) + zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzE(int i, zzpy zzpyVar, zzqj zzqjVar) {
        int zzw = zzw(i << 3);
        int i2 = zzw + zzw;
        zznm zznmVar = (zznm) zzpyVar;
        int zzn = zznmVar.zzn();
        if (zzn == -1) {
            zzn = zzqjVar.zzd(zznmVar);
            zznmVar.zzo(zzn);
        }
        return i2 + zzn;
    }

    public static zzof zzt(byte[] bArr) {
        return new zzod(bArr, 0, bArr.length);
    }

    public static int zzu(int i) {
        return zzw(i << 3);
    }

    public static int zzv(int i) {
        if (i >= 0) {
            return zzw(i);
        }
        return 10;
    }

    public static int zzw(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzx(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzrl.zzc(str);
        } catch (zzrk unused) {
            length = str.getBytes(zzpb.zza).length;
        }
        return zzw(length) + length;
    }

    public static int zzz(zzpg zzpgVar) {
        int zza = zzpgVar.zza();
        return zzw(zza) + zza;
    }

    public final void zzC() {
        if (zzs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(String str, zzrk zzrkVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzrkVar);
        byte[] bytes = str.getBytes(zzpb.zza);
        try {
            int length = bytes.length;
            zzl(length);
            zzq(bytes, 0, length);
        } catch (zzoe e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzoe(e2);
        }
    }

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, long j) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, boolean z) throws IOException;

    public abstract void zzh(int i, String str) throws IOException;

    public abstract void zzi(int i, zzny zznyVar) throws IOException;

    public abstract void zzj(byte b) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(int i) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(long j) throws IOException;

    public abstract void zzo(long j) throws IOException;

    public abstract void zzq(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzs();
}
