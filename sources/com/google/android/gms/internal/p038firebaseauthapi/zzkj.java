package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkj */
/* loaded from: classes3.dex */
final class zzkj {
    private static long zzb(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static long zzc(byte[] bArr, int i, int i2) {
        return (zzb(bArr, i) >> i2) & 67108863;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long zzc = zzc(bArr, 0, 0);
        int i = 2;
        long zzc2 = zzc(bArr, 3, 2) & 67108611;
        long zzc3 = zzc(bArr, 6, 4) & 67092735;
        long zzc4 = zzc(bArr, 9, 6) & 66076671;
        long zzc5 = zzc(bArr, 12, 8) & 1048575;
        long j = zzc2 * 5;
        long j2 = zzc3 * 5;
        long j3 = zzc4 * 5;
        long j4 = zzc5 * 5;
        int i2 = 17;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        int i3 = 0;
        while (true) {
            int length = bArr2.length;
            if (i3 < length) {
                int min = Math.min(16, length - i3);
                System.arraycopy(bArr2, i3, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i2, (byte) 0);
                }
                long zzc6 = j9 + zzc(bArr3, 0, 0);
                long zzc7 = j6 + zzc(bArr3, 3, i);
                long zzc8 = j5 + zzc(bArr3, 6, 4);
                long zzc9 = j7 + zzc(bArr3, 9, 6);
                long zzc10 = j8 + (zzc(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
                long j10 = (zzc6 * zzc) + (zzc7 * j4) + (zzc8 * j3) + (zzc9 * j2) + (zzc10 * j);
                long j11 = (zzc6 * zzc2) + (zzc7 * zzc) + (zzc8 * j4) + (zzc9 * j3) + (zzc10 * j2) + (j10 >> 26);
                long j12 = (zzc6 * zzc3) + (zzc7 * zzc2) + (zzc8 * zzc) + (zzc9 * j4) + (zzc10 * j3) + (j11 >> 26);
                long j13 = (zzc6 * zzc4) + (zzc7 * zzc3) + (zzc8 * zzc2) + (zzc9 * zzc) + (zzc10 * j4) + (j12 >> 26);
                long j14 = (zzc6 * zzc5) + (zzc7 * zzc4) + (zzc8 * zzc3) + (zzc9 * zzc2) + (zzc10 * zzc) + (j13 >> 26);
                j8 = j14 & 67108863;
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j9 = j15 & 67108863;
                j6 = (j11 & 67108863) + (j15 >> 26);
                i3 += 16;
                j7 = j13 & 67108863;
                j5 = j12 & 67108863;
                i2 = 17;
                i = 2;
            } else {
                long j16 = j5 + (j6 >> 26);
                long j17 = j16 & 67108863;
                long j18 = j7 + (j16 >> 26);
                long j19 = j18 & 67108863;
                long j20 = j8 + (j18 >> 26);
                long j21 = j20 & 67108863;
                long j22 = j9 + ((j20 >> 26) * 5);
                long j23 = j22 & 67108863;
                long j24 = (j6 & 67108863) + (j22 >> 26);
                long j25 = j23 + 5;
                long j26 = (j25 >> 26) + j24;
                long j27 = j17 + (j26 >> 26);
                long j28 = j19 + (j27 >> 26);
                long j29 = (j21 + (j28 >> 26)) - 67108864;
                long j30 = j29 >> 63;
                long j31 = ~j30;
                long j32 = (j24 & j30) | (j26 & 67108863 & j31);
                long j33 = (j17 & j30) | (j27 & 67108863 & j31);
                long j34 = (j19 & j30) | (j28 & 67108863 & j31);
                long zzb = (((j23 & j30) | (j25 & 67108863 & j31) | (j32 << 26)) & 4294967295L) + zzb(bArr, 16);
                long zzb2 = (((j32 >> 6) | (j33 << 20)) & 4294967295L) + zzb(bArr, 20) + (zzb >> 32);
                long zzb3 = (((j33 >> 12) | (j34 << 14)) & 4294967295L) + zzb(bArr, 24) + (zzb2 >> 32);
                long zzb4 = zzb(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, zzb & 4294967295L, 0);
                zzd(bArr4, zzb2 & 4294967295L, 4);
                zzd(bArr4, zzb3 & 4294967295L, 8);
                zzd(bArr4, ((((((j29 & j31) | (j30 & j21)) << 8) | (j34 >> 18)) & 4294967295L) + zzb4 + (zzb3 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
        }
    }
}
