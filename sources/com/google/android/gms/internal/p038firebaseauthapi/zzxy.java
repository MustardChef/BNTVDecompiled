package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxy */
/* loaded from: classes3.dex */
public final class zzxy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzxx zzxxVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzxxVar.zza = b;
            return i2;
        }
        return zzb(b, bArr, i2, zzxxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, byte[] bArr, int i2, zzxx zzxxVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzxxVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzxxVar.zza = i5 | (b2 << Ascii.f9767SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzxxVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzxxVar.zza = i9 | (b4 << Ascii.f9760FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzxxVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzxx zzxxVar) {
        byte b;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzxxVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        zzxxVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzxx zzxxVar) throws zzzw {
        int zza = zza(bArr, i, zzxxVar);
        int i2 = zzxxVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzxxVar.zzc = "";
                return zza;
            }
            zzxxVar.zzc = new String(bArr, zza, i2, zzzu.zza);
            return zza + i2;
        }
        throw zzzw.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzxx zzxxVar) throws zzzw {
        int zza = zza(bArr, i, zzxxVar);
        int i2 = zzxxVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzxxVar.zzc = "";
                return zza;
            }
            zzxxVar.zzc = zzaci.zze(bArr, zza, i2);
            return zza + i2;
        }
        throw zzzw.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzxx zzxxVar) throws zzzw {
        int zza = zza(bArr, i, zzxxVar);
        int i2 = zzxxVar.zza;
        if (i2 < 0) {
            throw zzzw.zzc();
        }
        if (i2 <= bArr.length - zza) {
            if (i2 == 0) {
                zzxxVar.zzc = zzym.zzb;
                return zza;
            }
            zzxxVar.zzc = zzym.zzl(bArr, zza, i2);
            return zza + i2;
        }
        throw zzzw.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zzabd zzabdVar, byte[] bArr, int i, int i2, zzxx zzxxVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzb(i4, bArr, i3, zzxxVar);
            i4 = zzxxVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzzw.zzb();
        }
        Object zza = zzabdVar.zza();
        int i6 = i4 + i5;
        zzabdVar.zzi(zza, bArr, i5, i6, zzxxVar);
        zzabdVar.zzj(zza);
        zzxxVar.zzc = zza;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(zzabd zzabdVar, byte[] bArr, int i, int i2, int i3, zzxx zzxxVar) throws IOException {
        zzaau zzaauVar = (zzaau) zzabdVar;
        Object zza = zzaauVar.zza();
        int zzh = zzaauVar.zzh(zza, bArr, i, i2, i3, zzxxVar);
        zzaauVar.zzj(zza);
        zzxxVar.zzc = zza;
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, int i3, zzzt<?> zzztVar, zzxx zzxxVar) {
        zzzp zzzpVar = (zzzp) zzztVar;
        int zza = zza(bArr, i2, zzxxVar);
        zzzpVar.zzf(zzxxVar.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzxxVar);
            if (i != zzxxVar.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzxxVar);
            zzzpVar.zzf(zzxxVar.zza);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i, zzzt<?> zzztVar, zzxx zzxxVar) throws IOException {
        zzzp zzzpVar = (zzzp) zzztVar;
        int zza = zza(bArr, i, zzxxVar);
        int i2 = zzxxVar.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzxxVar);
            zzzpVar.zzf(zzxxVar.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzzw.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(zzabd<?> zzabdVar, int i, byte[] bArr, int i2, int i3, zzzt<?> zzztVar, zzxx zzxxVar) throws IOException {
        int zzi = zzi(zzabdVar, bArr, i2, i3, zzxxVar);
        zzztVar.add(zzxxVar.zzc);
        while (zzi < i3) {
            int zza = zza(bArr, zzi, zzxxVar);
            if (i != zzxxVar.zza) {
                break;
            }
            zzi = zzi(zzabdVar, bArr, zza, i3, zzxxVar);
            zzztVar.add(zzxxVar.zzc);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i, byte[] bArr, int i2, int i3, zzabs zzabsVar, zzxx zzxxVar) throws zzzw {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzxxVar);
                zzabsVar.zzh(i, Long.valueOf(zzxxVar.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzabsVar.zzh(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzxxVar);
                int i5 = zzxxVar.zza;
                if (i5 < 0) {
                    throw zzzw.zzc();
                }
                if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzabsVar.zzh(i, zzym.zzb);
                    } else {
                        zzabsVar.zzh(i, zzym.zzl(bArr, zza, i5));
                    }
                    return zza + i5;
                }
                throw zzzw.zzb();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzabsVar.zzh(i, Integer.valueOf(zzd(bArr, i2)));
                    return i2 + 4;
                }
                throw zzzw.zze();
            } else {
                int i6 = (i & (-8)) | 4;
                zzabs zzb = zzabs.zzb();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzxxVar);
                    int i8 = zzxxVar.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzn(i8, bArr, zza2, i3, zzb, zzxxVar);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzzw.zzh();
                }
                zzabsVar.zzh(i, zzb);
                return i2;
            }
        }
        throw zzzw.zze();
    }
}
