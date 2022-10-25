package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs */
/* loaded from: classes3.dex */
public final class zzabs {
    private static final zzabs zza = new zzabs(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzabs() {
        this(0, new int[8], new Object[8], true);
    }

    private zzabs(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzabs zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzabs zzb() {
        return new zzabs(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzabs zzc(zzabs zzabsVar, zzabs zzabsVar2) {
        int i = zzabsVar.zzb + zzabsVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzabsVar.zzc, i);
        System.arraycopy(zzabsVar2.zzc, 0, copyOf, zzabsVar.zzb, zzabsVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzabsVar.zzd, i);
        System.arraycopy(zzabsVar2.zzd, 0, copyOf2, zzabsVar.zzb, zzabsVar2.zzb);
        return new zzabs(i, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzabs)) {
            zzabs zzabsVar = (zzabs) obj;
            int i = this.zzb;
            if (i == zzabsVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzabsVar.zzc;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.zzd;
                        Object[] objArr2 = zzabsVar.zzd;
                        int i3 = this.zzb;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    } else if (iArr[i2] != iArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int i = this.zze;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                int zzy = zzyw.zzy(1);
                int zzy2 = zzyw.zzy(2);
                int zzA = zzyw.zzA(i4 >>> 3);
                int zzy3 = zzyw.zzy(3);
                int zzc = ((zzym) this.zzd[i3]).zzc();
                i2 += zzy + zzy + zzy2 + zzA + zzy3 + zzyw.zzA(zzc) + zzc;
            }
            this.zze = i2;
            return i2;
        }
        return i;
    }

    public final int zzf() {
        int zzy;
        int zzB;
        int i;
        int i2 = this.zze;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzb; i4++) {
                int i5 = this.zzc[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 == 1) {
                        ((Long) this.zzd[i4]).longValue();
                        i = zzyw.zzy(i6) + 8;
                    } else if (i7 == 2) {
                        int zzy2 = zzyw.zzy(i6);
                        int zzc = ((zzym) this.zzd[i4]).zzc();
                        i3 += zzy2 + zzyw.zzA(zzc) + zzc;
                    } else if (i7 == 3) {
                        int zzy3 = zzyw.zzy(i6);
                        zzy = zzy3 + zzy3;
                        zzB = ((zzabs) this.zzd[i4]).zzf();
                    } else if (i7 == 5) {
                        ((Integer) this.zzd[i4]).intValue();
                        i = zzyw.zzy(i6) + 4;
                    } else {
                        throw new IllegalStateException(zzzw.zzg());
                    }
                    i3 += i;
                } else {
                    long longValue = ((Long) this.zzd[i4]).longValue();
                    zzy = zzyw.zzy(i6);
                    zzB = zzyw.zzB(longValue);
                }
                i = zzy + zzB;
                i3 += i;
            }
            this.zze = i3;
            return i3;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzaat.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zzyx zzyxVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzyxVar.zzc(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzyxVar.zzj(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzyxVar.zzn(i3, (zzym) obj);
                } else if (i4 == 3) {
                    zzyxVar.zzt(i3);
                    ((zzabs) obj).zzi(zzyxVar);
                    zzyxVar.zzu(i3);
                } else if (i4 == 5) {
                    zzyxVar.zzk(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzzw.zzg());
                }
            }
        }
    }
}
