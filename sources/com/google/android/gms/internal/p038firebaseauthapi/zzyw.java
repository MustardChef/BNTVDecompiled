package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyw */
/* loaded from: classes3.dex */
public abstract class zzyw extends zzya {
    private static final Logger zza = Logger.getLogger(zzyw.class.getName());
    private static final boolean zzb = zzacc.zza();
    zzyx zze;

    private zzyw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyw(zzyr zzyrVar) {
    }

    public static int zzA(int i) {
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

    public static int zzB(long j) {
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

    public static int zzC(String str) {
        int length;
        try {
            length = zzaci.zzc(str);
        } catch (zzacg unused) {
            length = str.getBytes(zzzu.zza).length;
        }
        return zzA(length) + length;
    }

    public static int zzD(zzzz zzzzVar) {
        int zza2 = zzzzVar.zza();
        return zzA(zza2) + zza2;
    }

    public static int zzE(zzym zzymVar) {
        int zzc = zzymVar.zzc();
        return zzA(zzc) + zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzF(zzaar zzaarVar, zzabd zzabdVar) {
        zzxu zzxuVar = (zzxu) zzaarVar;
        int zzq = zzxuVar.zzq();
        if (zzq == -1) {
            zzq = zzabdVar.zze(zzxuVar);
            zzxuVar.zzr(zzq);
        }
        return zzA(zzq) + zzq;
    }

    public static int zzG(int i) {
        return (i >> 31) ^ (i + i);
    }

    public static long zzH(long j) {
        return (j >> 63) ^ (j + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzK(int i, zzaar zzaarVar, zzabd zzabdVar) {
        int zzA = zzA(i << 3);
        int i2 = zzA + zzA;
        zzxu zzxuVar = (zzxu) zzaarVar;
        int zzq = zzxuVar.zzq();
        if (zzq == -1) {
            zzq = zzabdVar.zze(zzxuVar);
            zzxuVar.zzr(zzq);
        }
        return i2 + zzq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static zzyw zzw(OutputStream outputStream, int i) {
        return new zzyv(outputStream, i);
    }

    public static zzyw zzx(byte[] bArr) {
        return new zzyt(bArr, 0, bArr.length);
    }

    public static int zzy(int i) {
        return zzA(i << 3);
    }

    public static int zzz(int i) {
        if (i >= 0) {
            return zzA(i);
        }
        return 10;
    }

    public final void zzI() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(String str, zzacg zzacgVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzacgVar);
        byte[] bytes = str.getBytes(zzzu.zza);
        try {
            int length = bytes.length;
            zzo(length);
            zza(bytes, 0, length);
        } catch (zzyu e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzyu(e2);
        }
    }

    public abstract void zzO(int i, int i2) throws IOException;

    public abstract void zzP(int i, int i2) throws IOException;

    public abstract void zzQ(int i, int i2) throws IOException;

    public abstract void zzR(int i, int i2) throws IOException;

    public abstract void zzS(int i, long j) throws IOException;

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzya
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(int i, boolean z) throws IOException;

    public abstract void zzj(int i, String str) throws IOException;

    public abstract void zzk(int i, zzym zzymVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(int i, zzaar zzaarVar, zzabd zzabdVar) throws IOException;

    public abstract void zzm(byte b) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public abstract void zzp(int i) throws IOException;

    public abstract void zzq(long j) throws IOException;

    public abstract void zzr(long j) throws IOException;

    public abstract void zzu() throws IOException;
}
