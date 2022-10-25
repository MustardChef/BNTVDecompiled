package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau */
/* loaded from: classes3.dex */
public final class zzaau<T> implements zzabd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzacc.zzr();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaar zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzaaf zzn;
    private final zzabr<?, ?> zzo;
    private final zzzc<?> zzp;
    private final zzaaw zzq;
    private final zzaam zzr;

    /* JADX WARN: Multi-variable type inference failed */
    private zzaau(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzaar zzaarVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzaaw zzaawVar, zzaaf zzaafVar, zzabr<?, ?> zzabrVar, zzzc<?> zzzcVar, zzaam zzaamVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i;
        this.zzi = i2 instanceof zzzo;
        this.zzj = zzaarVar;
        boolean z3 = false;
        if (zzabrVar != 0 && zzabrVar.zza((zzaar) i2)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = z2;
        this.zzl = iArr3;
        this.zzm = i3;
        this.zzq = i4;
        this.zzn = zzaawVar;
        this.zzo = zzaafVar;
        this.zzp = zzabrVar;
        this.zzg = i2;
        this.zzr = zzzcVar;
    }

    private final <UT, UB> UB zzA(Object obj, int i, UB ub, zzabr<UT, UB> zzabrVar) {
        int i2 = this.zzc[i];
        Object zzn = zzacc.zzn(obj, zzD(i) & 1048575);
        if (zzn == null || zzy(i) == null) {
            return ub;
        }
        zzaal zzaalVar = (zzaal) zzn;
        zzaak zzaakVar = (zzaak) zzx(i);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzB(Object obj, int i, zzabd zzabdVar) {
        return zzabdVar.zzk(zzacc.zzn(obj, i & 1048575));
    }

    private final void zzC(Object obj, int i, zzabc zzabcVar) throws IOException {
        if (zzG(i)) {
            zzacc.zzo(obj, i & 1048575, zzabcVar.zzn());
        } else if (!this.zzi) {
            zzacc.zzo(obj, i & 1048575, zzabcVar.zzq());
        } else {
            zzacc.zzo(obj, i & 1048575, zzabcVar.zzm());
        }
    }

    private final int zzD(int i) {
        return this.zzc[i + 1];
    }

    private final int zzE(int i) {
        return this.zzc[i + 2];
    }

    private static int zzF(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzG(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzH(T t, long j) {
        return ((Double) zzacc.zzn(t, j)).doubleValue();
    }

    private static <T> float zzI(T t, long j) {
        return ((Float) zzacc.zzn(t, j)).floatValue();
    }

    private static <T> int zzJ(T t, long j) {
        return ((Integer) zzacc.zzn(t, j)).intValue();
    }

    private static <T> long zzK(T t, long j) {
        return ((Long) zzacc.zzn(t, j)).longValue();
    }

    private static <T> boolean zzL(T t, long j) {
        return ((Boolean) zzacc.zzn(t, j)).booleanValue();
    }

    private final boolean zzM(T t, T t2, int i) {
        return zzO(t, i) == zzO(t2, i);
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzO(T t, int i) {
        int zzE = zzE(i);
        long j = zzE & 1048575;
        if (j != 1048575) {
            return (zzacc.zzd(t, j) & (1 << (zzE >>> 20))) != 0;
        }
        int zzD = zzD(i);
        long j2 = zzD & 1048575;
        switch (zzF(zzD)) {
            case 0:
                return zzacc.zzl(t, j2) != 0.0d;
            case 1:
                return zzacc.zzj(t, j2) != 0.0f;
            case 2:
                return zzacc.zzf(t, j2) != 0;
            case 3:
                return zzacc.zzf(t, j2) != 0;
            case 4:
                return zzacc.zzd(t, j2) != 0;
            case 5:
                return zzacc.zzf(t, j2) != 0;
            case 6:
                return zzacc.zzd(t, j2) != 0;
            case 7:
                return zzacc.zzh(t, j2);
            case 8:
                Object zzn = zzacc.zzn(t, j2);
                if (zzn instanceof String) {
                    return !((String) zzn).isEmpty();
                } else if (zzn instanceof zzym) {
                    return !zzym.zzb.equals(zzn);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzacc.zzn(t, j2) != null;
            case 10:
                return !zzym.zzb.equals(zzacc.zzn(t, j2));
            case 11:
                return zzacc.zzd(t, j2) != 0;
            case 12:
                return zzacc.zzd(t, j2) != 0;
            case 13:
                return zzacc.zzd(t, j2) != 0;
            case 14:
                return zzacc.zzf(t, j2) != 0;
            case 15:
                return zzacc.zzd(t, j2) != 0;
            case 16:
                return zzacc.zzf(t, j2) != 0;
            case 17:
                return zzacc.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzP(T t, int i) {
        int zzE = zzE(i);
        long j = 1048575 & zzE;
        if (j == 1048575) {
            return;
        }
        zzacc.zze(t, j, (1 << (zzE >>> 20)) | zzacc.zzd(t, j));
    }

    private final boolean zzQ(T t, int i, int i2) {
        return zzacc.zzd(t, (long) (zzE(i2) & 1048575)) == i;
    }

    private final void zzR(T t, int i, int i2) {
        zzacc.zze(t, zzE(i2) & 1048575, i);
    }

    private final int zzS(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, 0);
    }

    private final int zzT(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzU(i, i2);
    }

    private final int zzU(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final void zzV(T t, zzyx zzyxVar) throws IOException {
        int i;
        if (this.zzh) {
            this.zzp.zzb(t);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < length) {
            int zzD = zzD(i3);
            int i6 = this.zzc[i3];
            int zzF = zzF(zzD);
            if (zzF <= 17) {
                int i7 = this.zzc[i3 + 2];
                int i8 = i7 & i2;
                if (i8 != i5) {
                    i4 = unsafe.getInt(t, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = zzD & i2;
            switch (zzF) {
                case 0:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzf(i6, zzacc.zzl(t, j));
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 1:
                    if ((i4 & i) != 0) {
                        zzyxVar.zze(i6, zzacc.zzj(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 2:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzc(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 3:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzh(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 4:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzi(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 5:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzj(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 6:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzk(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 7:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzl(i6, zzacc.zzh(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 8:
                    if ((i4 & i) != 0) {
                        zzX(i6, unsafe.getObject(t, j), zzyxVar);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 9:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzr(i6, unsafe.getObject(t, j), zzw(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 10:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzn(i6, (zzym) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 11:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzo(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 12:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzg(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 13:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzb(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 14:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzd(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 15:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzp(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 16:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzq(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 17:
                    if ((i4 & i) != 0) {
                        zzyxVar.zzs(i6, unsafe.getObject(t, j), zzw(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 18:
                    zzabf.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 19:
                    zzabf.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 20:
                    zzabf.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 21:
                    zzabf.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 22:
                    zzabf.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 23:
                    zzabf.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 24:
                    zzabf.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 25:
                    zzabf.zzW(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 26:
                    zzabf.zzX(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar);
                    break;
                case 27:
                    zzabf.zzZ(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, zzw(i3));
                    break;
                case 28:
                    zzabf.zzY(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar);
                    break;
                case 29:
                    zzabf.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 30:
                    zzabf.zzV(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 31:
                    zzabf.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 32:
                    zzabf.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 33:
                    zzabf.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 34:
                    zzabf.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, false);
                    break;
                case 35:
                    zzabf.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 36:
                    zzabf.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 37:
                    zzabf.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 38:
                    zzabf.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 39:
                    zzabf.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 40:
                    zzabf.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 41:
                    zzabf.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 42:
                    zzabf.zzW(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 43:
                    zzabf.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 44:
                    zzabf.zzV(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 45:
                    zzabf.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 46:
                    zzabf.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 47:
                    zzabf.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 48:
                    zzabf.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, true);
                    break;
                case 49:
                    zzabf.zzaa(this.zzc[i3], (List) unsafe.getObject(t, j), zzyxVar, zzw(i3));
                    break;
                case 50:
                    zzW(zzyxVar, i6, unsafe.getObject(t, j), i3);
                    break;
                case 51:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzf(i6, zzH(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zze(i6, zzI(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzc(i6, zzK(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzh(i6, zzK(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzi(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzj(i6, zzK(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzk(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzl(i6, zzL(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zzQ(t, i6, i3)) {
                        zzX(i6, unsafe.getObject(t, j), zzyxVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzr(i6, unsafe.getObject(t, j), zzw(i3));
                        break;
                    }
                    break;
                case 61:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzn(i6, (zzym) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzo(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzg(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzb(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzd(i6, zzK(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzp(i6, zzJ(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzq(i6, zzK(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zzQ(t, i6, i3)) {
                        zzyxVar.zzs(i6, unsafe.getObject(t, j), zzw(i3));
                        break;
                    }
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        zzabr<?, ?> zzabrVar = this.zzo;
        zzabrVar.zzr(zzabrVar.zzj(t), zzyxVar);
    }

    private final <K, V> void zzW(zzyx zzyxVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        zzaak zzaakVar = (zzaak) zzx(i2);
        throw null;
    }

    private static final void zzX(int i, Object obj, zzyx zzyxVar) throws IOException {
        if (obj instanceof String) {
            zzyxVar.zzm(i, (String) obj);
        } else {
            zzyxVar.zzn(i, (zzym) obj);
        }
    }

    static zzabs zzg(Object obj) {
        zzzo zzzoVar = (zzzo) obj;
        zzabs zzabsVar = zzzoVar.zzc;
        if (zzabsVar == zzabs.zza()) {
            zzabs zzb2 = zzabs.zzb();
            zzzoVar.zzc = zzb2;
            return zzb2;
        }
        return zzabsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzaau<T> zzl(Class<T> cls, zzaao zzaaoVar, zzaaw zzaawVar, zzaaf zzaafVar, zzabr<?, ?> zzabrVar, zzzc<?> zzzcVar, zzaam zzaamVar) {
        if (zzaaoVar instanceof zzabb) {
            return zzm((zzabb) zzaaoVar, zzaawVar, zzaafVar, zzabrVar, zzzcVar, zzaamVar);
        }
        zzabo zzaboVar = (zzabo) zzaaoVar;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.p038firebaseauthapi.zzaau<T> zzm(com.google.android.gms.internal.p038firebaseauthapi.zzabb r34, com.google.android.gms.internal.p038firebaseauthapi.zzaaw r35, com.google.android.gms.internal.p038firebaseauthapi.zzaaf r36, com.google.android.gms.internal.p038firebaseauthapi.zzabr<?, ?> r37, com.google.android.gms.internal.p038firebaseauthapi.zzzc<?> r38, com.google.android.gms.internal.p038firebaseauthapi.zzaam r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzaau.zzm(com.google.android.gms.internal.firebase-auth-api.zzabb, com.google.android.gms.internal.firebase-auth-api.zzaaw, com.google.android.gms.internal.firebase-auth-api.zzaaf, com.google.android.gms.internal.firebase-auth-api.zzabr, com.google.android.gms.internal.firebase-auth-api.zzzc, com.google.android.gms.internal.firebase-auth-api.zzaam):com.google.android.gms.internal.firebase-auth-api.zzaau");
    }

    private static Field zzo(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzp(T t, T t2, int i) {
        long zzD = zzD(i) & 1048575;
        if (zzO(t2, i)) {
            Object zzn = zzacc.zzn(t, zzD);
            Object zzn2 = zzacc.zzn(t2, zzD);
            if (zzn != null && zzn2 != null) {
                zzacc.zzo(t, zzD, zzzu.zzi(zzn, zzn2));
                zzP(t, i);
            } else if (zzn2 != null) {
                zzacc.zzo(t, zzD, zzn2);
                zzP(t, i);
            }
        }
    }

    private final void zzq(T t, T t2, int i) {
        int zzD = zzD(i);
        int i2 = this.zzc[i];
        long j = zzD & 1048575;
        if (zzQ(t2, i2, i)) {
            Object zzn = zzQ(t, i2, i) ? zzacc.zzn(t, j) : null;
            Object zzn2 = zzacc.zzn(t2, j);
            if (zzn != null && zzn2 != null) {
                zzacc.zzo(t, j, zzzu.zzi(zzn, zzn2));
                zzR(t, i2, i);
            } else if (zzn2 != null) {
                zzacc.zzo(t, j, zzn2);
                zzR(t, i2, i);
            }
        }
    }

    private final int zzr(T t) {
        int i;
        int zzy;
        int zzy2;
        int zzy3;
        int zzB;
        int zzy4;
        int zzz;
        int zzy5;
        int zzy6;
        int zzc;
        int zzA;
        int zzw;
        int zzy7;
        int zzA2;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzD = zzD(i6);
            int i7 = this.zzc[i6];
            int zzF = zzF(zzD);
            if (zzF <= 17) {
                int i8 = this.zzc[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i5) {
                    i4 = unsafe.getInt(t, i9);
                    i5 = i9;
                }
            } else {
                i = 0;
            }
            long j = zzD & 1048575;
            switch (zzF) {
                case 0:
                    if ((i4 & i) != 0) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if ((i4 & i) != 0) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i4 & i) != 0) {
                        long j2 = unsafe.getLong(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(j2);
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i4 & i) != 0) {
                        long j3 = unsafe.getLong(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(j3);
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i4 & i) != 0) {
                        int i10 = unsafe.getInt(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzz(i10);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i4 & i) != 0) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i4 & i) != 0) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i4 & i) != 0) {
                        zzy5 = zzyw.zzy(i7);
                        zzw = zzy5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i4 & i) != 0) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzym) {
                            zzy6 = zzyw.zzy(i7);
                            zzc = ((zzym) object).zzc();
                            zzA = zzyw.zzA(zzc);
                            i2 = zzy6 + zzA + zzc;
                            i3 += i2;
                        } else {
                            zzy4 = zzyw.zzy(i7);
                            zzz = zzyw.zzC((String) object);
                            i2 = zzy4 + zzz;
                            i3 += i2;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if ((i4 & i) != 0) {
                        zzw = zzabf.zzw(i7, unsafe.getObject(t, j), zzw(i6));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i4 & i) != 0) {
                        zzy6 = zzyw.zzy(i7);
                        zzc = ((zzym) unsafe.getObject(t, j)).zzc();
                        zzA = zzyw.zzA(zzc);
                        i2 = zzy6 + zzA + zzc;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i4 & i) != 0) {
                        int i11 = unsafe.getInt(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzA(i11);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i4 & i) != 0) {
                        int i12 = unsafe.getInt(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzz(i12);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i4 & i) != 0) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i4 & i) != 0) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i4 & i) != 0) {
                        int i13 = unsafe.getInt(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzA(zzyw.zzG(i13));
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i4 & i) != 0) {
                        long j4 = unsafe.getLong(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(zzyw.zzH(j4));
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i4 & i) != 0) {
                        zzw = zzyw.zzK(i7, (zzaar) unsafe.getObject(t, j), zzw(i6));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzw = zzabf.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 19:
                    zzw = zzabf.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 20:
                    zzw = zzabf.zzc(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 21:
                    zzw = zzabf.zze(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 22:
                    zzw = zzabf.zzk(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 23:
                    zzw = zzabf.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 24:
                    zzw = zzabf.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 25:
                    zzw = zzabf.zzu(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 26:
                    zzw = zzabf.zzv(i7, (List) unsafe.getObject(t, j));
                    break;
                case 27:
                    zzw = zzabf.zzx(i7, (List) unsafe.getObject(t, j), zzw(i6));
                    break;
                case 28:
                    zzw = zzabf.zzy(i7, (List) unsafe.getObject(t, j));
                    break;
                case 29:
                    zzw = zzabf.zzm(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 30:
                    zzw = zzabf.zzi(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 31:
                    zzw = zzabf.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 32:
                    zzw = zzabf.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 33:
                    zzw = zzabf.zzo(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 34:
                    zzw = zzabf.zzg(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 35:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 36:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 37:
                    zzz = zzabf.zzb((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 38:
                    zzz = zzabf.zzd((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 39:
                    zzz = zzabf.zzj((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 40:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 41:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 42:
                    zzz = zzabf.zzt((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 43:
                    zzz = zzabf.zzl((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 44:
                    zzz = zzabf.zzh((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 45:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 46:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 47:
                    zzz = zzabf.zzn((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 48:
                    zzz = zzabf.zzf((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i7);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 49:
                    zzw = zzabf.zzz(i7, (List) unsafe.getObject(t, j), zzw(i6));
                    break;
                case 50:
                    zzaam.zza(i7, unsafe.getObject(t, j), zzx(i6));
                    continue;
                case 51:
                    if (zzQ(t, i7, i6)) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (zzQ(t, i7, i6)) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (zzQ(t, i7, i6)) {
                        long zzK = zzK(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(zzK);
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (zzQ(t, i7, i6)) {
                        long zzK2 = zzK(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(zzK2);
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (zzQ(t, i7, i6)) {
                        int zzJ = zzJ(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzz(zzJ);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 56:
                    if (zzQ(t, i7, i6)) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (zzQ(t, i7, i6)) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (zzQ(t, i7, i6)) {
                        zzy5 = zzyw.zzy(i7);
                        zzw = zzy5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (zzQ(t, i7, i6)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzym) {
                            zzy6 = zzyw.zzy(i7);
                            zzc = ((zzym) object2).zzc();
                            zzA = zzyw.zzA(zzc);
                            i2 = zzy6 + zzA + zzc;
                            i3 += i2;
                        } else {
                            zzy4 = zzyw.zzy(i7);
                            zzz = zzyw.zzC((String) object2);
                            i2 = zzy4 + zzz;
                            i3 += i2;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (zzQ(t, i7, i6)) {
                        zzw = zzabf.zzw(i7, unsafe.getObject(t, j), zzw(i6));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (zzQ(t, i7, i6)) {
                        zzy6 = zzyw.zzy(i7);
                        zzc = ((zzym) unsafe.getObject(t, j)).zzc();
                        zzA = zzyw.zzA(zzc);
                        i2 = zzy6 + zzA + zzc;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 62:
                    if (zzQ(t, i7, i6)) {
                        int zzJ2 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzA(zzJ2);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 63:
                    if (zzQ(t, i7, i6)) {
                        int zzJ3 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzz(zzJ3);
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 64:
                    if (zzQ(t, i7, i6)) {
                        zzy2 = zzyw.zzy(i7);
                        zzw = zzy2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (zzQ(t, i7, i6)) {
                        zzy = zzyw.zzy(i7);
                        zzw = zzy + 8;
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (zzQ(t, i7, i6)) {
                        int zzJ4 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i7);
                        zzz = zzyw.zzA(zzyw.zzG(zzJ4));
                        i2 = zzy4 + zzz;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 67:
                    if (zzQ(t, i7, i6)) {
                        long zzK3 = zzK(t, j);
                        zzy3 = zzyw.zzy(i7);
                        zzB = zzyw.zzB(zzyw.zzH(zzK3));
                        zzw = zzy3 + zzB;
                        break;
                    } else {
                        continue;
                    }
                case 68:
                    if (zzQ(t, i7, i6)) {
                        zzw = zzyw.zzK(i7, (zzaar) unsafe.getObject(t, j), zzw(i6));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i3 += zzw;
        }
        zzabr<?, ?> zzabrVar = this.zzo;
        int zzq = i3 + zzabrVar.zzq(zzabrVar.zzj(t));
        if (this.zzh) {
            this.zzp.zzb(t);
            throw null;
        }
        return zzq;
    }

    private final int zzs(T t) {
        int zzy;
        int zzy2;
        int zzy3;
        int zzB;
        int zzy4;
        int zzz;
        int zzy5;
        int zzy6;
        int zzc;
        int zzA;
        int zzw;
        int zzy7;
        int zzA2;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzD = zzD(i3);
            int zzF = zzF(zzD);
            int i4 = this.zzc[i3];
            long j = zzD & 1048575;
            if (zzF >= zzzh.DOUBLE_LIST_PACKED.zza() && zzF <= zzzh.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (zzF) {
                case 0:
                    if (zzO(t, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(t, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(t, i3)) {
                        long zzf = zzacc.zzf(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzf);
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(t, i3)) {
                        long zzf2 = zzacc.zzf(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzf2);
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(t, i3)) {
                        int zzd = zzacc.zzd(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzz(zzd);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(t, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(t, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(t, i3)) {
                        zzy5 = zzyw.zzy(i4);
                        zzw = zzy5 + 1;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzO(t, i3)) {
                        break;
                    } else {
                        Object zzn = zzacc.zzn(t, j);
                        if (zzn instanceof zzym) {
                            zzy6 = zzyw.zzy(i4);
                            zzc = ((zzym) zzn).zzc();
                            zzA = zzyw.zzA(zzc);
                            i = zzy6 + zzA + zzc;
                            i2 += i;
                            break;
                        } else {
                            zzy4 = zzyw.zzy(i4);
                            zzz = zzyw.zzC((String) zzn);
                            i = zzy4 + zzz;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzO(t, i3)) {
                        zzw = zzabf.zzw(i4, zzacc.zzn(t, j), zzw(i3));
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(t, i3)) {
                        zzy6 = zzyw.zzy(i4);
                        zzc = ((zzym) zzacc.zzn(t, j)).zzc();
                        zzA = zzyw.zzA(zzc);
                        i = zzy6 + zzA + zzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(t, i3)) {
                        int zzd2 = zzacc.zzd(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzA(zzd2);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(t, i3)) {
                        int zzd3 = zzacc.zzd(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzz(zzd3);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(t, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(t, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(t, i3)) {
                        int zzd4 = zzacc.zzd(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzA(zzyw.zzG(zzd4));
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(t, i3)) {
                        long zzf3 = zzacc.zzf(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzyw.zzH(zzf3));
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(t, i3)) {
                        zzw = zzyw.zzK(i4, (zzaar) zzacc.zzn(t, j), zzw(i3));
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzw = zzabf.zzs(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 19:
                    zzw = zzabf.zzq(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 20:
                    zzw = zzabf.zzc(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 21:
                    zzw = zzabf.zze(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 22:
                    zzw = zzabf.zzk(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 23:
                    zzw = zzabf.zzs(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 24:
                    zzw = zzabf.zzq(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 25:
                    zzw = zzabf.zzu(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 26:
                    zzw = zzabf.zzv(i4, (List) zzacc.zzn(t, j));
                    i2 += zzw;
                    break;
                case 27:
                    zzw = zzabf.zzx(i4, (List) zzacc.zzn(t, j), zzw(i3));
                    i2 += zzw;
                    break;
                case 28:
                    zzw = zzabf.zzy(i4, (List) zzacc.zzn(t, j));
                    i2 += zzw;
                    break;
                case 29:
                    zzw = zzabf.zzm(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 30:
                    zzw = zzabf.zzi(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 31:
                    zzw = zzabf.zzq(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 32:
                    zzw = zzabf.zzs(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 33:
                    zzw = zzabf.zzo(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 34:
                    zzw = zzabf.zzg(i4, (List) zzacc.zzn(t, j), false);
                    i2 += zzw;
                    break;
                case 35:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzz = zzabf.zzb((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzz = zzabf.zzd((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzz = zzabf.zzj((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzz = zzabf.zzt((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzz = zzabf.zzl((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzz = zzabf.zzh((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzz = zzabf.zzp((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzz = zzabf.zzr((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzz = zzabf.zzn((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzz = zzabf.zzf((List) unsafe.getObject(t, j));
                    if (zzz > 0) {
                        zzy7 = zzyw.zzy(i4);
                        zzA2 = zzyw.zzA(zzz);
                        zzy4 = zzy7 + zzA2;
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzw = zzabf.zzz(i4, (List) zzacc.zzn(t, j), zzw(i3));
                    i2 += zzw;
                    break;
                case 50:
                    zzaam.zza(i4, zzacc.zzn(t, j), zzx(i3));
                    break;
                case 51:
                    if (zzQ(t, i4, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzQ(t, i4, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzQ(t, i4, i3)) {
                        long zzK = zzK(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzK);
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzQ(t, i4, i3)) {
                        long zzK2 = zzK(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzK2);
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzQ(t, i4, i3)) {
                        int zzJ = zzJ(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzz(zzJ);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzQ(t, i4, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzQ(t, i4, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzQ(t, i4, i3)) {
                        zzy5 = zzyw.zzy(i4);
                        zzw = zzy5 + 1;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzQ(t, i4, i3)) {
                        break;
                    } else {
                        Object zzn2 = zzacc.zzn(t, j);
                        if (zzn2 instanceof zzym) {
                            zzy6 = zzyw.zzy(i4);
                            zzc = ((zzym) zzn2).zzc();
                            zzA = zzyw.zzA(zzc);
                            i = zzy6 + zzA + zzc;
                            i2 += i;
                            break;
                        } else {
                            zzy4 = zzyw.zzy(i4);
                            zzz = zzyw.zzC((String) zzn2);
                            i = zzy4 + zzz;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzQ(t, i4, i3)) {
                        zzw = zzabf.zzw(i4, zzacc.zzn(t, j), zzw(i3));
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzQ(t, i4, i3)) {
                        zzy6 = zzyw.zzy(i4);
                        zzc = ((zzym) zzacc.zzn(t, j)).zzc();
                        zzA = zzyw.zzA(zzc);
                        i = zzy6 + zzA + zzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzQ(t, i4, i3)) {
                        int zzJ2 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzA(zzJ2);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzQ(t, i4, i3)) {
                        int zzJ3 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzz(zzJ3);
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzQ(t, i4, i3)) {
                        zzy2 = zzyw.zzy(i4);
                        zzw = zzy2 + 4;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzQ(t, i4, i3)) {
                        zzy = zzyw.zzy(i4);
                        zzw = zzy + 8;
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzQ(t, i4, i3)) {
                        int zzJ4 = zzJ(t, j);
                        zzy4 = zzyw.zzy(i4);
                        zzz = zzyw.zzA(zzyw.zzG(zzJ4));
                        i = zzy4 + zzz;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzQ(t, i4, i3)) {
                        long zzK3 = zzK(t, j);
                        zzy3 = zzyw.zzy(i4);
                        zzB = zzyw.zzB(zzyw.zzH(zzK3));
                        i2 += zzy3 + zzB;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzQ(t, i4, i3)) {
                        zzw = zzyw.zzK(i4, (zzaar) zzacc.zzn(t, j), zzw(i3));
                        i2 += zzw;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzabr<?, ?> zzabrVar = this.zzo;
        return i2 + zzabrVar.zzq(zzabrVar.zzj(t));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x021a -> B:120:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014f -> B:67:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01cc -> B:100:0x01cd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzt(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.p038firebaseauthapi.zzxx r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzaau.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.firebase-auth-api.zzxx):int");
    }

    private final <K, V> int zzu(T t, byte[] bArr, int i, int i2, int i3, long j, zzxx zzxxVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzx = zzx(i3);
        Object object = unsafe.getObject(t, j);
        if (zzaam.zzb(object)) {
            zzaal<K, V> zzc = zzaal.zza().zzc();
            zzaam.zzc(zzc, object);
            unsafe.putObject(t, j, zzc);
        }
        zzaak zzaakVar = (zzaak) zzx;
        throw null;
    }

    private final int zzv(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzxx zzxxVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(zzxy.zze(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(zzxy.zzd(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int zzc = zzxy.zzc(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, Long.valueOf(zzxxVar.zzb));
                    unsafe.putInt(t, j2, i4);
                    return zzc;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int zza2 = zzxy.zza(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzxxVar.zza));
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzxy.zze(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzxy.zzd(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int zzc2 = zzxy.zzc(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzxxVar.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return zzc2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int zza3 = zzxy.zza(bArr, i, zzxxVar);
                    int i9 = zzxxVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzaci.zzb(bArr, zza3, zza3 + i9)) {
                        unsafe.putObject(t, j, new String(bArr, zza3, i9, zzzu.zza));
                        zza3 += i9;
                    } else {
                        throw zzzw.zzi();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int zzi = zzxy.zzi(zzw(i8), bArr, i, i2, zzxxVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzxxVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzzu.zzi(object, zzxxVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzi;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int zzh = zzxy.zzh(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, zzxxVar.zzc);
                    unsafe.putInt(t, j2, i4);
                    return zzh;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzxy.zza(bArr, i, zzxxVar);
                    int i10 = zzxxVar.zza;
                    zzzs zzy = zzy(i8);
                    if (zzy == null || zzy.zza()) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        zzg(t).zzh(i3, Long.valueOf(i10));
                    }
                    return zza4;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int zza5 = zzxy.zza(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzyp.zzt(zzxxVar.zza)));
                    unsafe.putInt(t, j2, i4);
                    return zza5;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int zzc3 = zzxy.zzc(bArr, i, zzxxVar);
                    unsafe.putObject(t, j, Long.valueOf(zzyp.zzu(zzxxVar.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return zzc3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int zzj = zzxy.zzj(zzw(i8), bArr, i, i2, (i3 & (-8)) | 4, zzxxVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzxxVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzzu.zzi(object2, zzxxVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzj;
                }
                break;
        }
        return i;
    }

    private final zzabd zzw(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzabd zzabdVar = (zzabd) this.zzd[i3];
        if (zzabdVar != null) {
            return zzabdVar;
        }
        zzabd<T> zzb2 = zzaaz.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzx(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzzs zzy(int i) {
        int i2 = i / 3;
        return (zzzs) this.zzd[i2 + i2 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a8, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02aa, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r19;
        r1 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02f1, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0314, code lost:
        if (r0 != r15) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzz(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.p038firebaseauthapi.zzxx r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzaau.zzz(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzxx):int");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final T zza() {
        return (T) ((zzzo) this.zzg).zzj(4, null, null);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final boolean zzb(T t, T t2) {
        boolean zzD;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzD2 = zzD(i);
            long j = zzD2 & 1048575;
            switch (zzF(zzD2)) {
                case 0:
                    if (zzM(t, t2, i) && Double.doubleToLongBits(zzacc.zzl(t, j)) == Double.doubleToLongBits(zzacc.zzl(t2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzM(t, t2, i) && Float.floatToIntBits(zzacc.zzj(t, j)) == Float.floatToIntBits(zzacc.zzj(t2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzM(t, t2, i) && zzacc.zzf(t, j) == zzacc.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzM(t, t2, i) && zzacc.zzf(t, j) == zzacc.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzM(t, t2, i) && zzacc.zzf(t, j) == zzacc.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzM(t, t2, i) && zzacc.zzh(t, j) == zzacc.zzh(t2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzM(t, t2, i) && zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzM(t, t2, i) && zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzM(t, t2, i) && zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzM(t, t2, i) && zzacc.zzf(t, j) == zzacc.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzM(t, t2, i) && zzacc.zzd(t, j) == zzacc.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzM(t, t2, i) && zzacc.zzf(t, j) == zzacc.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzM(t, t2, i) && zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzD = zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j));
                    break;
                case 50:
                    zzD = zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzE = zzE(i) & 1048575;
                    if (zzacc.zzd(t, zzE) == zzacc.zzd(t2, zzE) && zzabf.zzD(zzacc.zzn(t, j), zzacc.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzD) {
                return false;
            }
        }
        if (this.zzo.zzj(t).equals(this.zzo.zzj(t2))) {
            if (this.zzh) {
                this.zzp.zzb(t);
                this.zzp.zzb(t2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final int zzc(T t) {
        int i;
        int zze;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzD = zzD(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzD;
            int i5 = 37;
            switch (zzF(zzD)) {
                case 0:
                    i = i2 * 53;
                    zze = zzzu.zze(Double.doubleToLongBits(zzacc.zzl(t, j)));
                    i2 = i + zze;
                    break;
                case 1:
                    i = i2 * 53;
                    zze = Float.floatToIntBits(zzacc.zzj(t, j));
                    i2 = i + zze;
                    break;
                case 2:
                    i = i2 * 53;
                    zze = zzzu.zze(zzacc.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 3:
                    i = i2 * 53;
                    zze = zzzu.zze(zzacc.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 4:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 5:
                    i = i2 * 53;
                    zze = zzzu.zze(zzacc.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 6:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 7:
                    i = i2 * 53;
                    zze = zzzu.zzf(zzacc.zzh(t, j));
                    i2 = i + zze;
                    break;
                case 8:
                    i = i2 * 53;
                    zze = ((String) zzacc.zzn(t, j)).hashCode();
                    i2 = i + zze;
                    break;
                case 9:
                    Object zzn = zzacc.zzn(t, j);
                    if (zzn != null) {
                        i5 = zzn.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zze = zzacc.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 11:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 12:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 13:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 14:
                    i = i2 * 53;
                    zze = zzzu.zze(zzacc.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 15:
                    i = i2 * 53;
                    zze = zzacc.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 16:
                    i = i2 * 53;
                    zze = zzzu.zze(zzacc.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 17:
                    Object zzn2 = zzacc.zzn(t, j);
                    if (zzn2 != null) {
                        i5 = zzn2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    zze = zzacc.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 50:
                    i = i2 * 53;
                    zze = zzacc.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 51:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(Double.doubleToLongBits(zzH(t, j)));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = Float.floatToIntBits(zzI(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(zzK(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(zzK(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(zzK(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zzf(zzL(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = ((String) zzacc.zzn(t, j)).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzacc.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzacc.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(zzK(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzJ(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzzu.zze(zzK(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzQ(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzacc.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zzo.zzj(t).hashCode();
        if (this.zzh) {
            this.zzp.zzb(t);
            throw null;
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final int zze(T t) {
        return this.zzj ? zzs(t) : zzr(t);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzf(T t, zzabc zzabcVar, zzzb zzzbVar) throws IOException {
        Objects.requireNonNull(zzzbVar);
        zzabr zzabrVar = this.zzo;
        zzzc<?> zzzcVar = this.zzp;
        zzzg<?> zzzgVar = null;
        Object obj = null;
        while (true) {
            try {
                int zzb2 = zzabcVar.zzb();
                int zzS = zzS(zzb2);
                if (zzS >= 0) {
                    int zzD = zzD(zzS);
                    try {
                        switch (zzF(zzD)) {
                            case 0:
                                zzacc.zzm(t, zzD & 1048575, zzabcVar.zze());
                                zzP(t, zzS);
                                break;
                            case 1:
                                zzacc.zzk(t, zzD & 1048575, zzabcVar.zzf());
                                zzP(t, zzS);
                                break;
                            case 2:
                                zzacc.zzg(t, zzD & 1048575, zzabcVar.zzh());
                                zzP(t, zzS);
                                break;
                            case 3:
                                zzacc.zzg(t, zzD & 1048575, zzabcVar.zzg());
                                zzP(t, zzS);
                                break;
                            case 4:
                                zzacc.zze(t, zzD & 1048575, zzabcVar.zzi());
                                zzP(t, zzS);
                                break;
                            case 5:
                                zzacc.zzg(t, zzD & 1048575, zzabcVar.zzj());
                                zzP(t, zzS);
                                break;
                            case 6:
                                zzacc.zze(t, zzD & 1048575, zzabcVar.zzk());
                                zzP(t, zzS);
                                break;
                            case 7:
                                zzacc.zzi(t, zzD & 1048575, zzabcVar.zzl());
                                zzP(t, zzS);
                                break;
                            case 8:
                                zzC(t, zzD, zzabcVar);
                                zzP(t, zzS);
                                break;
                            case 9:
                                if (zzO(t, zzS)) {
                                    long j = zzD & 1048575;
                                    zzacc.zzo(t, j, zzzu.zzi(zzacc.zzn(t, j), zzabcVar.zzo(zzw(zzS), zzzbVar)));
                                    break;
                                } else {
                                    zzacc.zzo(t, zzD & 1048575, zzabcVar.zzo(zzw(zzS), zzzbVar));
                                    zzP(t, zzS);
                                    break;
                                }
                            case 10:
                                zzacc.zzo(t, zzD & 1048575, zzabcVar.zzq());
                                zzP(t, zzS);
                                break;
                            case 11:
                                zzacc.zze(t, zzD & 1048575, zzabcVar.zzr());
                                zzP(t, zzS);
                                break;
                            case 12:
                                int zzs = zzabcVar.zzs();
                                zzzs zzy = zzy(zzS);
                                if (zzy != null && !zzy.zza()) {
                                    obj = zzabf.zzH(zzb2, zzs, obj, zzabrVar);
                                    break;
                                }
                                zzacc.zze(t, zzD & 1048575, zzs);
                                zzP(t, zzS);
                                break;
                            case 13:
                                zzacc.zze(t, zzD & 1048575, zzabcVar.zzt());
                                zzP(t, zzS);
                                break;
                            case 14:
                                zzacc.zzg(t, zzD & 1048575, zzabcVar.zzu());
                                zzP(t, zzS);
                                break;
                            case 15:
                                zzacc.zze(t, zzD & 1048575, zzabcVar.zzv());
                                zzP(t, zzS);
                                break;
                            case 16:
                                zzacc.zzg(t, zzD & 1048575, zzabcVar.zzw());
                                zzP(t, zzS);
                                break;
                            case 17:
                                if (zzO(t, zzS)) {
                                    long j2 = zzD & 1048575;
                                    zzacc.zzo(t, j2, zzzu.zzi(zzacc.zzn(t, j2), zzabcVar.zzp(zzw(zzS), zzzbVar)));
                                    break;
                                } else {
                                    zzacc.zzo(t, zzD & 1048575, zzabcVar.zzp(zzw(zzS), zzzbVar));
                                    zzP(t, zzS);
                                    break;
                                }
                            case 18:
                                zzabcVar.zzx(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 19:
                                zzabcVar.zzy(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 20:
                                zzabcVar.zzA(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 21:
                                zzabcVar.zzz(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 22:
                                zzabcVar.zzB(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 23:
                                zzabcVar.zzC(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 24:
                                zzabcVar.zzD(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 25:
                                zzabcVar.zzE(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 26:
                                if (zzG(zzD)) {
                                    ((zzyq) zzabcVar).zzF(this.zzn.zza(t, zzD & 1048575), true);
                                    break;
                                } else {
                                    ((zzyq) zzabcVar).zzF(this.zzn.zza(t, zzD & 1048575), false);
                                    break;
                                }
                            case 27:
                                zzabcVar.zzG(this.zzn.zza(t, zzD & 1048575), zzw(zzS), zzzbVar);
                                break;
                            case 28:
                                zzabcVar.zzI(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 29:
                                zzabcVar.zzJ(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 30:
                                List<Integer> zza2 = this.zzn.zza(t, zzD & 1048575);
                                zzabcVar.zzK(zza2);
                                obj = zzabf.zzG(zzb2, zza2, zzy(zzS), obj, zzabrVar);
                                break;
                            case 31:
                                zzabcVar.zzL(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 32:
                                zzabcVar.zzM(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 33:
                                zzabcVar.zzN(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 34:
                                zzabcVar.zzO(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 35:
                                zzabcVar.zzx(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 36:
                                zzabcVar.zzy(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 37:
                                zzabcVar.zzA(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 38:
                                zzabcVar.zzz(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 39:
                                zzabcVar.zzB(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 40:
                                zzabcVar.zzC(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 41:
                                zzabcVar.zzD(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 42:
                                zzabcVar.zzE(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 43:
                                zzabcVar.zzJ(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 44:
                                List<Integer> zza3 = this.zzn.zza(t, zzD & 1048575);
                                zzabcVar.zzK(zza3);
                                obj = zzabf.zzG(zzb2, zza3, zzy(zzS), obj, zzabrVar);
                                break;
                            case 45:
                                zzabcVar.zzL(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 46:
                                zzabcVar.zzM(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 47:
                                zzabcVar.zzN(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 48:
                                zzabcVar.zzO(this.zzn.zza(t, zzD & 1048575));
                                break;
                            case 49:
                                zzabcVar.zzH(this.zzn.zza(t, zzD & 1048575), zzw(zzS), zzzbVar);
                                break;
                            case 50:
                                Object zzx = zzx(zzS);
                                long zzD2 = zzD(zzS) & 1048575;
                                Object zzn = zzacc.zzn(t, zzD2);
                                if (zzn == null) {
                                    zzn = zzaal.zza().zzc();
                                    zzacc.zzo(t, zzD2, zzn);
                                } else if (zzaam.zzb(zzn)) {
                                    Object zzc = zzaal.zza().zzc();
                                    zzaam.zzc(zzc, zzn);
                                    zzacc.zzo(t, zzD2, zzc);
                                    zzn = zzc;
                                }
                                zzaal zzaalVar = (zzaal) zzn;
                                zzaak zzaakVar = (zzaak) zzx;
                                throw null;
                                break;
                            case 51:
                                zzacc.zzo(t, zzD & 1048575, Double.valueOf(zzabcVar.zze()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 52:
                                zzacc.zzo(t, zzD & 1048575, Float.valueOf(zzabcVar.zzf()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 53:
                                zzacc.zzo(t, zzD & 1048575, Long.valueOf(zzabcVar.zzh()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 54:
                                zzacc.zzo(t, zzD & 1048575, Long.valueOf(zzabcVar.zzg()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 55:
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzabcVar.zzi()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 56:
                                zzacc.zzo(t, zzD & 1048575, Long.valueOf(zzabcVar.zzj()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 57:
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzabcVar.zzk()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 58:
                                zzacc.zzo(t, zzD & 1048575, Boolean.valueOf(zzabcVar.zzl()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 59:
                                zzC(t, zzD, zzabcVar);
                                zzR(t, zzb2, zzS);
                                break;
                            case 60:
                                if (zzQ(t, zzb2, zzS)) {
                                    long j3 = zzD & 1048575;
                                    zzacc.zzo(t, j3, zzzu.zzi(zzacc.zzn(t, j3), zzabcVar.zzo(zzw(zzS), zzzbVar)));
                                } else {
                                    zzacc.zzo(t, zzD & 1048575, zzabcVar.zzo(zzw(zzS), zzzbVar));
                                    zzP(t, zzS);
                                }
                                zzR(t, zzb2, zzS);
                                break;
                            case 61:
                                zzacc.zzo(t, zzD & 1048575, zzabcVar.zzq());
                                zzR(t, zzb2, zzS);
                                break;
                            case 62:
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzabcVar.zzr()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 63:
                                int zzs2 = zzabcVar.zzs();
                                zzzs zzy2 = zzy(zzS);
                                if (zzy2 != null && !zzy2.zza()) {
                                    obj = zzabf.zzH(zzb2, zzs2, obj, zzabrVar);
                                    break;
                                }
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzs2));
                                zzR(t, zzb2, zzS);
                                break;
                            case 64:
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzabcVar.zzt()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 65:
                                zzacc.zzo(t, zzD & 1048575, Long.valueOf(zzabcVar.zzu()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 66:
                                zzacc.zzo(t, zzD & 1048575, Integer.valueOf(zzabcVar.zzv()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 67:
                                zzacc.zzo(t, zzD & 1048575, Long.valueOf(zzabcVar.zzw()));
                                zzR(t, zzb2, zzS);
                                break;
                            case 68:
                                zzacc.zzo(t, zzD & 1048575, zzabcVar.zzp(zzw(zzS), zzzbVar));
                                zzR(t, zzb2, zzS);
                                break;
                            default:
                                if (obj == null) {
                                    obj = zzabrVar.zzg();
                                }
                                if (!zzabrVar.zzn(obj, zzabcVar)) {
                                    for (int i = this.zzl; i < this.zzm; i++) {
                                        obj = zzA(t, this.zzk[i], obj, zzabrVar);
                                    }
                                    if (obj != null) {
                                        zzabrVar.zzl(t, obj);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    } catch (zzzv unused) {
                        zzabrVar.zza(zzabcVar);
                        if (obj == null) {
                            obj = zzabrVar.zzk(t);
                        }
                        if (!zzabrVar.zzn(obj, zzabcVar)) {
                            for (int i2 = this.zzl; i2 < this.zzm; i2++) {
                                obj = zzA(t, this.zzk[i2], obj, zzabrVar);
                            }
                            if (obj != null) {
                                zzabrVar.zzl(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                } else if (zzb2 == Integer.MAX_VALUE) {
                    for (int i3 = this.zzl; i3 < this.zzm; i3++) {
                        obj = zzA(t, this.zzk[i3], obj, zzabrVar);
                    }
                    if (obj != null) {
                        zzabrVar.zzl(t, obj);
                        return;
                    }
                    return;
                } else {
                    Object zzf = !this.zzh ? null : zzzcVar.zzf(zzzbVar, this.zzg, zzb2);
                    if (zzf != null) {
                        if (zzzgVar == null) {
                            zzzgVar = zzzcVar.zzc(t);
                        }
                        zzzg<?> zzzgVar2 = zzzgVar;
                        obj = zzzcVar.zze(zzabcVar, zzf, zzzbVar, zzzgVar2, obj, zzabrVar);
                        zzzgVar = zzzgVar2;
                    } else {
                        zzabrVar.zza(zzabcVar);
                        if (obj == null) {
                            obj = zzabrVar.zzk(t);
                        }
                        if (!zzabrVar.zzn(obj, zzabcVar)) {
                            for (int i4 = this.zzl; i4 < this.zzm; i4++) {
                                obj = zzA(t, this.zzk[i4], obj, zzabrVar);
                            }
                            if (obj != null) {
                                zzabrVar.zzl(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzl; i5 < this.zzm; i5++) {
                    obj = zzA(t, this.zzk[i5], obj, zzabrVar);
                }
                if (obj != null) {
                    zzabrVar.zzl(t, obj);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x042b, code lost:
        if (r6 == r3) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x042d, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0433, code lost:
        r3 = r9.zzl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0437, code lost:
        if (r3 >= r9.zzm) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0439, code lost:
        r9.zzA(r12, r9.zzk[r3], r2, r9.zzo);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0445, code lost:
        if (r7 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0449, code lost:
        if (r0 != r32) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0450, code lost:
        throw com.google.android.gms.internal.p038firebaseauthapi.zzzw.zzh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0453, code lost:
        if (r0 > r32) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0455, code lost:
        if (r1 != r7) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0457, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x045c, code lost:
        throw com.google.android.gms.internal.p038firebaseauthapi.zzzw.zzh();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzh(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.p038firebaseauthapi.zzxx r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1156
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzaau.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzxx):int");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzi(T t, byte[] bArr, int i, int i2, zzxx zzxxVar) throws IOException {
        if (this.zzj) {
            zzz(t, bArr, i, i2, zzxxVar);
        } else {
            zzh(t, bArr, i, i2, 0, zzxxVar);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzj(T t) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzD = zzD(this.zzk[i2]) & 1048575;
            Object zzn = zzacc.zzn(t, zzD);
            if (zzn != null) {
                ((zzaal) zzn).zzd();
                zzacc.zzo(t, zzD, zzn);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(t, this.zzk[i]);
            i++;
        }
        this.zzo.zzm(t);
        if (this.zzh) {
            this.zzp.zzd(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final boolean zzk(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzD = zzD(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & zzD) != 0 && !zzN(t, i6, i, i2, i10)) {
                return false;
            }
            int zzF = zzF(zzD);
            if (zzF != 9 && zzF != 17) {
                if (zzF != 27) {
                    if (zzF == 60 || zzF == 68) {
                        if (zzQ(t, i7, i6) && !zzB(t, zzD, zzw(i6))) {
                            return false;
                        }
                    } else if (zzF != 49) {
                        if (zzF == 50 && !((zzaal) zzacc.zzn(t, zzD & 1048575)).isEmpty()) {
                            zzaak zzaakVar = (zzaak) zzx(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzacc.zzn(t, zzD & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzabd zzw = zzw(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzw.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzN(t, i6, i, i2, i10) && !zzB(t, zzD, zzw(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        if (this.zzh) {
            this.zzp.zzb(t);
            throw null;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzn(T t, zzyx zzyxVar) throws IOException {
        if (!this.zzj) {
            zzV(t, zzyxVar);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzD = zzD(i);
                int i2 = this.zzc[i];
                switch (zzF(zzD)) {
                    case 0:
                        if (zzO(t, i)) {
                            zzyxVar.zzf(i2, zzacc.zzl(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzO(t, i)) {
                            zzyxVar.zze(i2, zzacc.zzj(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzO(t, i)) {
                            zzyxVar.zzc(i2, zzacc.zzf(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzO(t, i)) {
                            zzyxVar.zzh(i2, zzacc.zzf(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzO(t, i)) {
                            zzyxVar.zzi(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzO(t, i)) {
                            zzyxVar.zzj(i2, zzacc.zzf(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzO(t, i)) {
                            zzyxVar.zzk(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzO(t, i)) {
                            zzyxVar.zzl(i2, zzacc.zzh(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzO(t, i)) {
                            zzX(i2, zzacc.zzn(t, zzD & 1048575), zzyxVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzO(t, i)) {
                            zzyxVar.zzr(i2, zzacc.zzn(t, zzD & 1048575), zzw(i));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzO(t, i)) {
                            zzyxVar.zzn(i2, (zzym) zzacc.zzn(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzO(t, i)) {
                            zzyxVar.zzo(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzO(t, i)) {
                            zzyxVar.zzg(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzO(t, i)) {
                            zzyxVar.zzb(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzO(t, i)) {
                            zzyxVar.zzd(i2, zzacc.zzf(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzO(t, i)) {
                            zzyxVar.zzp(i2, zzacc.zzd(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzO(t, i)) {
                            zzyxVar.zzq(i2, zzacc.zzf(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzO(t, i)) {
                            zzyxVar.zzs(i2, zzacc.zzn(t, zzD & 1048575), zzw(i));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzabf.zzJ(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 19:
                        zzabf.zzK(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 20:
                        zzabf.zzL(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 21:
                        zzabf.zzM(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 22:
                        zzabf.zzQ(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 23:
                        zzabf.zzO(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 24:
                        zzabf.zzT(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 25:
                        zzabf.zzW(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 26:
                        zzabf.zzX(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar);
                        break;
                    case 27:
                        zzabf.zzZ(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, zzw(i));
                        break;
                    case 28:
                        zzabf.zzY(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar);
                        break;
                    case 29:
                        zzabf.zzR(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 30:
                        zzabf.zzV(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 31:
                        zzabf.zzU(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 32:
                        zzabf.zzP(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 33:
                        zzabf.zzS(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 34:
                        zzabf.zzN(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, false);
                        break;
                    case 35:
                        zzabf.zzJ(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 36:
                        zzabf.zzK(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 37:
                        zzabf.zzL(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 38:
                        zzabf.zzM(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 39:
                        zzabf.zzQ(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 40:
                        zzabf.zzO(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 41:
                        zzabf.zzT(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 42:
                        zzabf.zzW(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 43:
                        zzabf.zzR(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 44:
                        zzabf.zzV(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 45:
                        zzabf.zzU(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 46:
                        zzabf.zzP(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 47:
                        zzabf.zzS(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 48:
                        zzabf.zzN(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, true);
                        break;
                    case 49:
                        zzabf.zzaa(this.zzc[i], (List) zzacc.zzn(t, zzD & 1048575), zzyxVar, zzw(i));
                        break;
                    case 50:
                        zzW(zzyxVar, i2, zzacc.zzn(t, zzD & 1048575), i);
                        break;
                    case 51:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzf(i2, zzH(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zze(i2, zzI(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzc(i2, zzK(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzh(i2, zzK(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzi(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzj(i2, zzK(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzk(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzl(i2, zzL(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzQ(t, i2, i)) {
                            zzX(i2, zzacc.zzn(t, zzD & 1048575), zzyxVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzr(i2, zzacc.zzn(t, zzD & 1048575), zzw(i));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzn(i2, (zzym) zzacc.zzn(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzo(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzg(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzb(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzd(i2, zzK(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzp(i2, zzJ(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzq(i2, zzK(t, zzD & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzQ(t, i2, i)) {
                            zzyxVar.zzs(i2, zzacc.zzn(t, zzD & 1048575), zzw(i));
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzabr<?, ?> zzabrVar = this.zzo;
            zzabrVar.zzr(zzabrVar.zzj(t), zzyxVar);
        } else {
            this.zzp.zzb(t);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabd
    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzD = zzD(i);
            long j = 1048575 & zzD;
            int i2 = this.zzc[i];
            switch (zzF(zzD)) {
                case 0:
                    if (zzO(t2, i)) {
                        zzacc.zzm(t, j, zzacc.zzl(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(t2, i)) {
                        zzacc.zzk(t, j, zzacc.zzj(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(t2, i)) {
                        zzacc.zzg(t, j, zzacc.zzf(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(t2, i)) {
                        zzacc.zzg(t, j, zzacc.zzf(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(t2, i)) {
                        zzacc.zzg(t, j, zzacc.zzf(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(t2, i)) {
                        zzacc.zzi(t, j, zzacc.zzh(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(t2, i)) {
                        zzacc.zzo(t, j, zzacc.zzn(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzp(t, t2, i);
                    break;
                case 10:
                    if (zzO(t2, i)) {
                        zzacc.zzo(t, j, zzacc.zzn(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(t2, i)) {
                        zzacc.zzg(t, j, zzacc.zzf(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(t2, i)) {
                        zzacc.zze(t, j, zzacc.zzd(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(t2, i)) {
                        zzacc.zzg(t, j, zzacc.zzf(t2, j));
                        zzP(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzp(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(t, t2, j);
                    break;
                case 50:
                    zzabf.zzI(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzQ(t2, i2, i)) {
                        zzacc.zzo(t, j, zzacc.zzn(t2, j));
                        zzR(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzq(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzQ(t2, i2, i)) {
                        zzacc.zzo(t, j, zzacc.zzn(t2, j));
                        zzR(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzq(t, t2, i);
                    break;
            }
        }
        zzabf.zzF(this.zzo, t, t2);
        if (this.zzh) {
            zzabf.zzE(this.zzp, t, t2);
        }
    }
}
