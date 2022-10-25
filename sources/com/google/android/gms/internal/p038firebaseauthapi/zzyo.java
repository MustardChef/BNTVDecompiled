package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo */
/* loaded from: classes3.dex */
public final class zzyo extends zzyp {
    private final byte[] zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyo(byte[] bArr, int i, int i2, boolean z, zzyn zzynVar) {
        super(null);
        this.zzh = Integer.MAX_VALUE;
        this.zzc = bArr;
        this.zzd = i2;
        this.zzf = 0;
    }

    private final void zzv() {
        int i = this.zzd + this.zze;
        this.zzd = i;
        int i2 = this.zzh;
        if (i <= i2) {
            this.zze = 0;
            return;
        }
        int i3 = i - i2;
        this.zze = i3;
        this.zzd = i - i3;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final int zza() throws IOException {
        if (zzo()) {
            this.zzg = 0;
            return 0;
        }
        int zzh = zzh();
        this.zzg = zzh;
        if ((zzh >>> 3) != 0) {
            return zzh;
        }
        throw zzzw.zze();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final void zzb(int i) throws zzzw {
        if (this.zzg != i) {
            throw zzzw.zzf();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final boolean zzd() throws IOException {
        return zzi() != 0;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final String zze() throws IOException {
        int zzh = zzh();
        if (zzh > 0) {
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzh <= i - i2) {
                String str = new String(this.zzc, i2, zzh, zzzu.zza);
                this.zzf += zzh;
                return str;
            }
        }
        if (zzh == 0) {
            return "";
        }
        if (zzh < 0) {
            throw zzzw.zzc();
        }
        throw zzzw.zzb();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final String zzf() throws IOException {
        int zzh = zzh();
        if (zzh > 0) {
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzh <= i - i2) {
                String zze = zzaci.zze(this.zzc, i2, zzh);
                this.zzf += zzh;
                return zze;
            }
        }
        if (zzh == 0) {
            return "";
        }
        if (zzh <= 0) {
            throw zzzw.zzc();
        }
        throw zzzw.zzb();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final zzym zzg() throws IOException {
        int zzh = zzh();
        if (zzh > 0) {
            int i = this.zzd;
            int i2 = this.zzf;
            if (zzh <= i - i2) {
                zzym zzl = zzym.zzl(this.zzc, i2, zzh);
                this.zzf += zzh;
                return zzl;
            }
        }
        if (zzh != 0) {
            if (zzh > 0) {
                int i3 = this.zzd;
                int i4 = this.zzf;
                if (zzh <= i3 - i4) {
                    int i5 = zzh + i4;
                    this.zzf = i5;
                    return zzym.zzn(Arrays.copyOfRange(this.zzc, i4, i5));
                }
            }
            if (zzh <= 0) {
                throw zzzw.zzc();
            }
            throw zzzw.zzb();
        }
        return zzym.zzb;
    }

    final long zzj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzq = zzq();
            j |= (zzq & Byte.MAX_VALUE) << i;
            if ((zzq & 128) == 0) {
                return j;
            }
        }
        throw zzzw.zzd();
    }

    public final int zzk() throws IOException {
        int i = this.zzf;
        if (this.zzd - i >= 4) {
            byte[] bArr = this.zzc;
            this.zzf = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzzw.zzb();
    }

    public final long zzl() throws IOException {
        int i = this.zzf;
        if (this.zzd - i >= 8) {
            byte[] bArr = this.zzc;
            this.zzf = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw zzzw.zzb();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final int zzm(int i) throws zzzw {
        if (i >= 0) {
            int i2 = i + this.zzf;
            int i3 = this.zzh;
            if (i2 <= i3) {
                this.zzh = i2;
                zzv();
                return i3;
            }
            throw zzzw.zzb();
        }
        throw zzzw.zzc();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final void zzn(int i) {
        this.zzh = i;
        zzv();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final boolean zzo() throws IOException {
        return this.zzf == this.zzd;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final int zzp() {
        return this.zzf;
    }

    public final byte zzq() throws IOException {
        int i = this.zzf;
        if (i != this.zzd) {
            byte[] bArr = this.zzc;
            this.zzf = i + 1;
            return bArr[i];
        }
        throw zzzw.zzb();
    }

    public final void zzr(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzd;
            int i3 = this.zzf;
            if (i <= i2 - i3) {
                this.zzf = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzzw.zzc();
        }
        throw zzzw.zzb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzh() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzf
            int r1 = r5.zzd
            if (r1 != r0) goto L7
            goto L6c
        L7:
            byte[] r2 = r5.zzc
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzf = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L69
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L69
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L69
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6c
        L69:
            r5.zzf = r1
            return r0
        L6c:
            long r0 = r5.zzj()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzyo.zzh():int");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzyp
    public final boolean zzc(int i) throws IOException {
        int zza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzd - this.zzf < 10) {
                while (i3 < 10) {
                    if (zzq() < 0) {
                        i3++;
                    }
                }
                throw zzzw.zzd();
            }
            while (i3 < 10) {
                byte[] bArr = this.zzc;
                int i4 = this.zzf;
                this.zzf = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzzw.zzd();
            return true;
        } else if (i2 == 1) {
            zzr(8);
            return true;
        } else if (i2 == 2) {
            zzr(zzh());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzr(4);
                    return true;
                }
                throw zzzw.zzg();
            }
            return false;
        } else {
            do {
                zza = zza();
                if (zza == 0) {
                    break;
                }
            } while (zzc(zza));
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
    }

    public final long zzi() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.zzf;
        int i3 = this.zzd;
        if (i3 != i2) {
            byte[] bArr = this.zzc;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzf = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << Ascii.f9767SO);
                    if (i8 >= 0) {
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            long j5 = (bArr[i5] << 28) ^ i9;
                            if (j5 < 0) {
                                int i10 = i7 + 1;
                                long j6 = j5 ^ (bArr[i7] << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i10 + 1;
                                    j5 = j6 ^ (bArr[i10] << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i10 = i7 + 1;
                                        j6 = j5 ^ (bArr[i7] << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i10 + 1;
                                            j = (j6 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i10 = i7 + 1;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j;
                                                    i5 = i10;
                                                    this.zzf = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ j6;
                                i5 = i10;
                                this.zzf = i5;
                                return j2;
                            }
                            j4 = 266354560;
                            j = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j2 = j;
                    this.zzf = i5;
                    return j2;
                }
                i = i6 ^ (-128);
                j2 = i;
                this.zzf = i5;
                return j2;
            }
        }
        return zzj();
    }
}
