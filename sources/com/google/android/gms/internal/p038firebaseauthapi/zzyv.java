package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyv */
/* loaded from: classes3.dex */
public final class zzyv extends zzys {
    private final OutputStream zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyv(OutputStream outputStream, int i) {
        super(i);
        this.zzf = outputStream;
    }

    private final void zzM(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzN();
        }
    }

    private final void zzN() throws IOException {
        this.zzf.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzO(int i, int i2) throws IOException {
        zzo((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzP(int i, int i2) throws IOException {
        zzM(20);
        zzd(i << 3);
        if (i2 >= 0) {
            zzd(i2);
        } else {
            zze(i2);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzQ(int i, int i2) throws IOException {
        zzM(20);
        zzd(i << 3);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzR(int i, int i2) throws IOException {
        zzM(14);
        zzd((i << 3) | 5);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzS(int i, long j) throws IOException {
        zzM(20);
        zzd(i << 3);
        zze(j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw, com.google.android.gms.internal.p038firebaseauthapi.zzya
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzt(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzh(int i, long j) throws IOException {
        zzM(18);
        zzd((i << 3) | 1);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzi(int i, boolean z) throws IOException {
        zzM(11);
        zzd(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzj(int i, String str) throws IOException {
        zzo((i << 3) | 2);
        zzs(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzk(int i, zzym zzymVar) throws IOException {
        zzo((i << 3) | 2);
        zzo(zzymVar.zzc());
        zzymVar.zzg(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzl(int i, zzaar zzaarVar, zzabd zzabdVar) throws IOException {
        zzo((i << 3) | 2);
        zzxu zzxuVar = (zzxu) zzaarVar;
        int zzq = zzxuVar.zzq();
        if (zzq == -1) {
            zzq = zzabdVar.zze(zzxuVar);
            zzxuVar.zzr(zzq);
        }
        zzo(zzq);
        zzabdVar.zzn(zzaarVar, this.zze);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzm(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzN();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzn(int i) throws IOException {
        if (i >= 0) {
            zzo(i);
        } else {
            zzq(i);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzo(int i) throws IOException {
        zzM(5);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzp(int i) throws IOException {
        zzM(4);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzq(long j) throws IOException {
        zzM(10);
        zze(j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzr(long j) throws IOException {
        zzM(8);
        zzg(j);
    }

    public final void zzs(String str) throws IOException {
        int zzc;
        try {
            int length = str.length() * 3;
            int zzA = zzA(length);
            int i = zzA + length;
            int i2 = this.zzb;
            if (i <= i2) {
                if (i > i2 - this.zzc) {
                    zzN();
                }
                int zzA2 = zzA(str.length());
                int i3 = this.zzc;
                try {
                    if (zzA2 != zzA) {
                        zzc = zzaci.zzc(str);
                        zzd(zzc);
                        this.zzc = zzaci.zzd(str, this.zza, this.zzc, zzc);
                    } else {
                        int i4 = i3 + zzA2;
                        this.zzc = i4;
                        int zzd = zzaci.zzd(str, this.zza, i4, this.zzb - i4);
                        this.zzc = i3;
                        zzc = (zzd - i3) - zzA2;
                        zzd(zzc);
                        this.zzc = zzd;
                    }
                    this.zzd += zzc;
                    return;
                } catch (zzacg e) {
                    this.zzd -= this.zzc - i3;
                    this.zzc = i3;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new zzyu(e2);
                }
            }
            byte[] bArr = new byte[length];
            int zzd2 = zzaci.zzd(str, bArr, 0, length);
            zzo(zzd2);
            zzt(bArr, 0, zzd2);
        } catch (zzacg e3) {
            zzJ(str, e3);
        }
    }

    public final void zzt(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i4, i5);
        int i6 = i2 - i5;
        this.zzc = this.zzb;
        this.zzd += i5;
        zzN();
        if (i6 <= this.zzb) {
            System.arraycopy(bArr, i5, this.zza, 0, i6);
            this.zzc = i6;
        } else {
            this.zzf.write(bArr, i5, i6);
        }
        this.zzd += i6;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyw
    public final void zzu() throws IOException {
        if (this.zzc > 0) {
            zzN();
        }
    }
}
