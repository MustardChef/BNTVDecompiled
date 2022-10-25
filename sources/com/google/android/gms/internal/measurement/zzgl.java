package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzgl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzgo zzgoVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzgoVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzgoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, zzgo zzgoVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgoVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgoVar.zza = i5 | (b2 << Ascii.f9767SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgoVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgoVar.zza = i9 | (b4 << Ascii.f9760FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgoVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzgo zzgoVar) {
        byte b;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzgoVar.zzb = j;
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
        zzgoVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzb(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzgo zzgoVar) throws zzij {
        int zza = zza(bArr, i, zzgoVar);
        int i2 = zzgoVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzgoVar.zzc = "";
                return zza;
            }
            zzgoVar.zzc = new String(bArr, zza, i2, zzia.zza);
            return zza + i2;
        }
        throw zzij.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzgo zzgoVar) throws zzij {
        int zza = zza(bArr, i, zzgoVar);
        int i2 = zzgoVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzgoVar.zzc = "";
                return zza;
            }
            zzgoVar.zzc = zzlb.zzb(bArr, zza, i2);
            return zza + i2;
        }
        throw zzij.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i, zzgo zzgoVar) throws zzij {
        int zza = zza(bArr, i, zzgoVar);
        int i2 = zzgoVar.zza;
        if (i2 < 0) {
            throw zzij.zzb();
        }
        if (i2 <= bArr.length - zza) {
            if (i2 == 0) {
                zzgoVar.zzc = zzgp.zza;
                return zza;
            }
            zzgoVar.zzc = zzgp.zza(bArr, zza, i2);
            return zza + i2;
        }
        throw zzij.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzkb zzkbVar, byte[] bArr, int i, int i2, zzgo zzgoVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzgoVar);
            i4 = zzgoVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzij.zza();
        }
        Object zza = zzkbVar.zza();
        int i6 = i4 + i5;
        zzkbVar.zza(zza, bArr, i5, i6, zzgoVar);
        zzkbVar.zzc(zza);
        zzgoVar.zzc = zza;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzkb zzkbVar, byte[] bArr, int i, int i2, int i3, zzgo zzgoVar) throws IOException {
        zzjn zzjnVar = (zzjn) zzkbVar;
        Object zza = zzjnVar.zza();
        int zza2 = zzjnVar.zza((zzjn) zza, bArr, i, i2, i3, zzgoVar);
        zzjnVar.zzc((zzjn) zza);
        zzgoVar.zzc = zza;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzig<?> zzigVar, zzgo zzgoVar) {
        zzib zzibVar = (zzib) zzigVar;
        int zza = zza(bArr, i2, zzgoVar);
        zzibVar.zzd(zzgoVar.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgoVar);
            if (i != zzgoVar.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgoVar);
            zzibVar.zzd(zzgoVar.zza);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzig<?> zzigVar, zzgo zzgoVar) throws IOException {
        zzib zzibVar = (zzib) zzigVar;
        int zza = zza(bArr, i, zzgoVar);
        int i2 = zzgoVar.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgoVar);
            zzibVar.zzd(zzgoVar.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzij.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzkb<?> zzkbVar, int i, byte[] bArr, int i2, int i3, zzig<?> zzigVar, zzgo zzgoVar) throws IOException {
        int zza = zza(zzkbVar, bArr, i2, i3, zzgoVar);
        zzigVar.add(zzgoVar.zzc);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgoVar);
            if (i != zzgoVar.zza) {
                break;
            }
            zza = zza(zzkbVar, bArr, zza2, i3, zzgoVar);
            zzigVar.add(zzgoVar.zzc);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzks zzksVar, zzgo zzgoVar) throws zzij {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzgoVar);
                zzksVar.zza(i, Long.valueOf(zzgoVar.zzb));
                return zzb;
            } else if (i4 == 1) {
                zzksVar.zza(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzgoVar);
                int i5 = zzgoVar.zza;
                if (i5 < 0) {
                    throw zzij.zzb();
                }
                if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzksVar.zza(i, zzgp.zza);
                    } else {
                        zzksVar.zza(i, zzgp.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                }
                throw zzij.zza();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzksVar.zza(i, Integer.valueOf(zza(bArr, i2)));
                    return i2 + 4;
                }
                throw zzij.zzd();
            } else {
                zzks zzb2 = zzks.zzb();
                int i6 = (i & (-8)) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzgoVar);
                    int i8 = zzgoVar.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzb2, zzgoVar);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzij.zzg();
                }
                zzksVar.zza(i, zzb2);
                return i2;
            }
        }
        throw zzij.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzgo zzgoVar) throws zzij {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw zzij.zzd();
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zza(bArr, i2, zzgoVar);
                            i6 = zzgoVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zza(i6, bArr, i2, i3, zzgoVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw zzij.zzg();
                        }
                        return i2;
                    }
                    return zza(bArr, i2, zzgoVar) + zzgoVar.zza;
                }
                return i2 + 8;
            }
            return zzb(bArr, i2, zzgoVar);
        }
        throw zzij.zzd();
    }
}
