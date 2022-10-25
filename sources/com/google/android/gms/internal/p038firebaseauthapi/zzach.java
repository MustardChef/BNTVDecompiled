package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.common.base.Ascii;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzach */
/* loaded from: classes3.dex */
final class zzach extends zzace {
    private static int zze(byte[] bArr, int i, long j, int i2) {
        int zzj;
        int zzk;
        int zzl;
        if (i2 == 0) {
            zzj = zzaci.zzj(i);
            return zzj;
        } else if (i2 == 1) {
            zzk = zzaci.zzk(i, zzacc.zzp(bArr, j));
            return zzk;
        } else if (i2 == 2) {
            zzl = zzaci.zzl(i, zzacc.zzp(bArr, j), zzacc.zzp(bArr, j + 1));
            return zzl;
        } else {
            throw new AssertionError();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzace
    final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        int length = bArr.length;
        if ((i2 | i3 | (length - i3)) >= 0) {
            long j2 = i2;
            int i5 = (int) (i3 - j2);
            if (i5 >= 16) {
                long j3 = j2;
                i4 = 0;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j4 = j3 + 1;
                    if (zzacc.zzp(bArr, j3) < 0) {
                        break;
                    }
                    i4++;
                    j3 = j4;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j5 = j2 + i4;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j6 = j5 + 1;
                    b = zzacc.zzp(bArr, j5);
                    if (b < 0) {
                        j5 = j6;
                        break;
                    }
                    i6--;
                    j5 = j6;
                }
                if (i6 != 0) {
                    int i7 = i6 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i7 >= 3) {
                                i6 = i7 - 3;
                                long j7 = j5 + 1;
                                byte zzp = zzacc.zzp(bArr, j5);
                                if (zzp > -65 || (((b << Ascii.f9760FS) + (zzp + 112)) >> 30) != 0) {
                                    break;
                                }
                                long j8 = j7 + 1;
                                if (zzacc.zzp(bArr, j7) > -65) {
                                    break;
                                }
                                j = j8 + 1;
                                if (zzacc.zzp(bArr, j8) > -65) {
                                    break;
                                }
                                j5 = j;
                            } else {
                                return zze(bArr, b, j5, i7);
                            }
                        } else if (i7 >= 2) {
                            i6 = i7 - 2;
                            long j9 = j5 + 1;
                            byte zzp2 = zzacc.zzp(bArr, j5);
                            if (zzp2 > -65 || ((b == -32 && zzp2 < -96) || (b == -19 && zzp2 >= -96))) {
                                break;
                            }
                            j5 = j9 + 1;
                            if (zzacc.zzp(bArr, j9) > -65) {
                                break;
                            }
                        } else {
                            return zze(bArr, b, j5, i7);
                        }
                    } else if (i7 == 0) {
                        return b;
                    } else {
                        i6 = i7 - 1;
                        if (b < -62) {
                            break;
                        }
                        j = j5 + 1;
                        if (zzacc.zzp(bArr, j5) > -65) {
                            break;
                        }
                        j5 = j;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzace
    public final String zzc(byte[] bArr, int i, int i2) throws zzzw {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte zzp = zzacc.zzp(bArr, i);
            if (!zzacd.zza(zzp)) {
                break;
            }
            i++;
            cArr[i4] = (char) zzp;
            i4++;
        }
        while (i < i3) {
            int i5 = i + 1;
            byte zzp2 = zzacc.zzp(bArr, i);
            if (zzacd.zza(zzp2)) {
                int i6 = i4 + 1;
                cArr[i4] = (char) zzp2;
                i = i5;
                while (true) {
                    i4 = i6;
                    if (i < i3) {
                        byte zzp3 = zzacc.zzp(bArr, i);
                        if (!zzacd.zza(zzp3)) {
                            break;
                        }
                        i++;
                        i6 = i4 + 1;
                        cArr[i4] = (char) zzp3;
                    }
                }
            } else if (zzacd.zzb(zzp2)) {
                if (i5 < i3) {
                    zzacd.zzc(zzp2, zzacc.zzp(bArr, i5), cArr, i4);
                    i = i5 + 1;
                    i4++;
                } else {
                    throw zzzw.zzi();
                }
            } else if (zzacd.zzd(zzp2)) {
                if (i5 < i3 - 1) {
                    int i7 = i5 + 1;
                    zzacd.zze(zzp2, zzacc.zzp(bArr, i5), zzacc.zzp(bArr, i7), cArr, i4);
                    i = i7 + 1;
                    i4++;
                } else {
                    throw zzzw.zzi();
                }
            } else if (i5 < i3 - 2) {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                zzacd.zzf(zzp2, zzacc.zzp(bArr, i5), zzacc.zzp(bArr, i8), zzacc.zzp(bArr, i9), cArr, i4);
                i4 += 2;
                i = i9 + 1;
            } else {
                throw zzzw.zzi();
            }
        }
        return new String(cArr, 0, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzace
    public final int zzd(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzacc.zzq(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 != length) {
            while (i4 < length) {
                char charAt3 = charSequence.charAt(i4);
                if (charAt3 >= c || j4 >= j5) {
                    if (charAt3 < 2048 && j4 <= (-2) + j5) {
                        long j6 = j4 + j;
                        zzacc.zzq(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                        zzacc.zzq(bArr, j6, (byte) ((charAt3 & '?') | 128));
                        j2 = j6 + j;
                        j3 = j;
                    } else if ((charAt3 >= 55296 && charAt3 <= 57343) || j4 > (-3) + j5) {
                        if (j4 <= (-4) + j5) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt4 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j7 = j4 + 1;
                                    zzacc.zzq(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j8 = j7 + 1;
                                    zzacc.zzq(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j9 = j8 + 1;
                                    zzacc.zzq(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j9 + 1;
                                    zzacc.zzq(bArr, j9, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzacg(i4 - 1, length);
                        } else if (charAt3 < 55296 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(charAt3);
                            sb2.append(" at index ");
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        } else {
                            throw new zzacg(i4, length);
                        }
                    } else {
                        long j10 = j4 + j;
                        zzacc.zzq(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                        long j11 = j10 + j;
                        zzacc.zzq(bArr, j10, (byte) (((charAt3 >>> 6) & 63) | 128));
                        zzacc.zzq(bArr, j11, (byte) ((charAt3 & '?') | 128));
                        j2 = j11 + 1;
                        j3 = 1;
                    }
                    i4++;
                    c = 128;
                    long j12 = j3;
                    j4 = j2;
                    j = j12;
                } else {
                    long j13 = j4 + j;
                    zzacc.zzq(bArr, j4, (byte) charAt3);
                    j3 = j;
                    j2 = j13;
                }
                i4++;
                c = 128;
                long j122 = j3;
                j4 = j2;
                j = j122;
            }
            return (int) j4;
        }
        return (int) j4;
    }
}
