package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzqb<T> implements zzqj<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzrh.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzpy zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzpm zzk;
    private final zzqx<?, ?> zzl;
    private final zzoi<?> zzm;
    private final zzqd zzn;
    private final zzpt zzo;

    /* JADX WARN: Multi-variable type inference failed */
    private zzqb(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzpy zzpyVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzqd zzqdVar, zzpm zzpmVar, zzqx<?, ?> zzqxVar, zzoi<?> zzoiVar, zzpt zzptVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zzg = zzpyVar;
        boolean z3 = false;
        if (zzqxVar != 0 && zzqxVar.zza(i2)) {
            z3 = true;
        }
        this.zzf = z3;
        this.zzh = z2;
        this.zzi = iArr3;
        this.zzj = i3;
        this.zzn = i4;
        this.zzk = zzqdVar;
        this.zzl = zzpmVar;
        this.zzm = zzqxVar;
        this.zze = i2;
        this.zzo = zzoiVar;
    }

    private final boolean zzA(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzB(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzB(T t, int i) {
        int zzs = zzs(i);
        long j = zzs & 1048575;
        if (j != 1048575) {
            return (zzrh.zzd(t, j) & (1 << (zzs >>> 20))) != 0;
        }
        int zzr = zzr(i);
        long j2 = zzr & 1048575;
        switch (zzt(zzr)) {
            case 0:
                return zzrh.zzl(t, j2) != 0.0d;
            case 1:
                return zzrh.zzj(t, j2) != 0.0f;
            case 2:
                return zzrh.zzf(t, j2) != 0;
            case 3:
                return zzrh.zzf(t, j2) != 0;
            case 4:
                return zzrh.zzd(t, j2) != 0;
            case 5:
                return zzrh.zzf(t, j2) != 0;
            case 6:
                return zzrh.zzd(t, j2) != 0;
            case 7:
                return zzrh.zzh(t, j2);
            case 8:
                Object zzn = zzrh.zzn(t, j2);
                if (zzn instanceof String) {
                    return !((String) zzn).isEmpty();
                } else if (zzn instanceof zzny) {
                    return !zzny.zzb.equals(zzn);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzrh.zzn(t, j2) != null;
            case 10:
                return !zzny.zzb.equals(zzrh.zzn(t, j2));
            case 11:
                return zzrh.zzd(t, j2) != 0;
            case 12:
                return zzrh.zzd(t, j2) != 0;
            case 13:
                return zzrh.zzd(t, j2) != 0;
            case 14:
                return zzrh.zzf(t, j2) != 0;
            case 15:
                return zzrh.zzd(t, j2) != 0;
            case 16:
                return zzrh.zzf(t, j2) != 0;
            case 17:
                return zzrh.zzn(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzC(T t, int i) {
        int zzs = zzs(i);
        long j = 1048575 & zzs;
        if (j == 1048575) {
            return;
        }
        zzrh.zze(t, j, (1 << (zzs >>> 20)) | zzrh.zzd(t, j));
    }

    private final boolean zzD(T t, int i, int i2) {
        return zzrh.zzd(t, (long) (zzs(i2) & 1048575)) == i;
    }

    private final void zzE(T t, int i, int i2) {
        zzrh.zze(t, zzs(i2) & 1048575, i);
    }

    private final void zzF(T t, zzog zzogVar) throws IOException {
        int i;
        if (this.zzf) {
            this.zzm.zzb(t);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < length) {
            int zzr = zzr(i3);
            int i6 = this.zzc[i3];
            int zzt = zzt(zzr);
            if (zzt <= 17) {
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
            long j = zzr & i2;
            switch (zzt) {
                case 0:
                    if ((i4 & i) != 0) {
                        zzogVar.zzf(i6, zzrh.zzl(t, j));
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 1:
                    if ((i4 & i) != 0) {
                        zzogVar.zze(i6, zzrh.zzj(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 2:
                    if ((i4 & i) != 0) {
                        zzogVar.zzc(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 3:
                    if ((i4 & i) != 0) {
                        zzogVar.zzh(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 4:
                    if ((i4 & i) != 0) {
                        zzogVar.zzi(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 5:
                    if ((i4 & i) != 0) {
                        zzogVar.zzj(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 6:
                    if ((i4 & i) != 0) {
                        zzogVar.zzk(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 7:
                    if ((i4 & i) != 0) {
                        zzogVar.zzl(i6, zzrh.zzh(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 8:
                    if ((i4 & i) != 0) {
                        zzH(i6, unsafe.getObject(t, j), zzogVar);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 9:
                    if ((i4 & i) != 0) {
                        zzogVar.zzr(i6, unsafe.getObject(t, j), zzo(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 10:
                    if ((i4 & i) != 0) {
                        zzogVar.zzn(i6, (zzny) unsafe.getObject(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 11:
                    if ((i4 & i) != 0) {
                        zzogVar.zzo(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 12:
                    if ((i4 & i) != 0) {
                        zzogVar.zzg(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 13:
                    if ((i4 & i) != 0) {
                        zzogVar.zzb(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 14:
                    if ((i4 & i) != 0) {
                        zzogVar.zzd(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 15:
                    if ((i4 & i) != 0) {
                        zzogVar.zzp(i6, unsafe.getInt(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 16:
                    if ((i4 & i) != 0) {
                        zzogVar.zzq(i6, unsafe.getLong(t, j));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 17:
                    if ((i4 & i) != 0) {
                        zzogVar.zzs(i6, unsafe.getObject(t, j), zzo(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                case 18:
                    zzql.zzH(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 19:
                    zzql.zzI(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 20:
                    zzql.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 21:
                    zzql.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 22:
                    zzql.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 23:
                    zzql.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 24:
                    zzql.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 25:
                    zzql.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                case 26:
                    zzql.zzV(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar);
                    break;
                case 27:
                    zzql.zzX(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, zzo(i3));
                    break;
                case 28:
                    zzql.zzW(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar);
                    break;
                case 29:
                    zzql.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 30:
                    zzql.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 31:
                    zzql.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 32:
                    zzql.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 33:
                    zzql.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 34:
                    zzql.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, false);
                    break;
                case 35:
                    zzql.zzH(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 36:
                    zzql.zzI(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 37:
                    zzql.zzJ(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 38:
                    zzql.zzK(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 39:
                    zzql.zzO(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 40:
                    zzql.zzM(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 41:
                    zzql.zzR(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 42:
                    zzql.zzU(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 43:
                    zzql.zzP(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 44:
                    zzql.zzT(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 45:
                    zzql.zzS(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 46:
                    zzql.zzN(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 47:
                    zzql.zzQ(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 48:
                    zzql.zzL(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, true);
                    break;
                case 49:
                    zzql.zzY(this.zzc[i3], (List) unsafe.getObject(t, j), zzogVar, zzo(i3));
                    break;
                case 50:
                    zzG(zzogVar, i6, unsafe.getObject(t, j), i3);
                    break;
                case 51:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzf(i6, zzu(t, j));
                        break;
                    }
                    break;
                case 52:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zze(i6, zzv(t, j));
                        break;
                    }
                    break;
                case 53:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzc(i6, zzx(t, j));
                        break;
                    }
                    break;
                case 54:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzh(i6, zzx(t, j));
                        break;
                    }
                    break;
                case 55:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzi(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 56:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzj(i6, zzx(t, j));
                        break;
                    }
                    break;
                case 57:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzk(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 58:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzl(i6, zzy(t, j));
                        break;
                    }
                    break;
                case 59:
                    if (zzD(t, i6, i3)) {
                        zzH(i6, unsafe.getObject(t, j), zzogVar);
                        break;
                    }
                    break;
                case 60:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzr(i6, unsafe.getObject(t, j), zzo(i3));
                        break;
                    }
                    break;
                case 61:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzn(i6, (zzny) unsafe.getObject(t, j));
                        break;
                    }
                    break;
                case 62:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzo(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 63:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzg(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 64:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzb(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 65:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzd(i6, zzx(t, j));
                        break;
                    }
                    break;
                case 66:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzp(i6, zzw(t, j));
                        break;
                    }
                    break;
                case 67:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzq(i6, zzx(t, j));
                        break;
                    }
                    break;
                case 68:
                    if (zzD(t, i6, i3)) {
                        zzogVar.zzs(i6, unsafe.getObject(t, j), zzo(i3));
                        break;
                    }
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        zzqx<?, ?> zzqxVar = this.zzl;
        zzqxVar.zzg(zzqxVar.zzb(t), zzogVar);
    }

    private final <K, V> void zzG(zzog zzogVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        zzpr zzprVar = (zzpr) zzp(i2);
        throw null;
    }

    private static final void zzH(int i, Object obj, zzog zzogVar) throws IOException {
        if (obj instanceof String) {
            zzogVar.zzm(i, (String) obj);
        } else {
            zzogVar.zzn(i, (zzny) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzqb<T> zzg(Class<T> cls, zzpv zzpvVar, zzqd zzqdVar, zzpm zzpmVar, zzqx<?, ?> zzqxVar, zzoi<?> zzoiVar, zzpt zzptVar) {
        if (zzpvVar instanceof zzqi) {
            return zzh((zzqi) zzpvVar, zzqdVar, zzpmVar, zzqxVar, zzoiVar, zzptVar);
        }
        zzqu zzquVar = (zzqu) zzpvVar;
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
    static <T> com.google.android.gms.internal.cast.zzqb<T> zzh(com.google.android.gms.internal.cast.zzqi r34, com.google.android.gms.internal.cast.zzqd r35, com.google.android.gms.internal.cast.zzpm r36, com.google.android.gms.internal.cast.zzqx<?, ?> r37, com.google.android.gms.internal.cast.zzoi<?> r38, com.google.android.gms.internal.cast.zzpt r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqb.zzh(com.google.android.gms.internal.cast.zzqi, com.google.android.gms.internal.cast.zzqd, com.google.android.gms.internal.cast.zzpm, com.google.android.gms.internal.cast.zzqx, com.google.android.gms.internal.cast.zzoi, com.google.android.gms.internal.cast.zzpt):com.google.android.gms.internal.cast.zzqb");
    }

    private static Field zzj(Class<?> cls, String str) {
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

    private final void zzk(T t, T t2, int i) {
        long zzr = zzr(i) & 1048575;
        if (zzB(t2, i)) {
            Object zzn = zzrh.zzn(t, zzr);
            Object zzn2 = zzrh.zzn(t2, zzr);
            if (zzn != null && zzn2 != null) {
                zzrh.zzo(t, zzr, zzpb.zzi(zzn, zzn2));
                zzC(t, i);
            } else if (zzn2 != null) {
                zzrh.zzo(t, zzr, zzn2);
                zzC(t, i);
            }
        }
    }

    private final void zzl(T t, T t2, int i) {
        int zzr = zzr(i);
        int i2 = this.zzc[i];
        long j = zzr & 1048575;
        if (zzD(t2, i2, i)) {
            Object zzn = zzD(t, i2, i) ? zzrh.zzn(t, j) : null;
            Object zzn2 = zzrh.zzn(t2, j);
            if (zzn != null && zzn2 != null) {
                zzrh.zzo(t, j, zzpb.zzi(zzn, zzn2));
                zzE(t, i2, i);
            } else if (zzn2 != null) {
                zzrh.zzo(t, j, zzn2);
                zzE(t, i2, i);
            }
        }
    }

    private final int zzm(T t) {
        int i;
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzr = zzr(i6);
            int i7 = this.zzc[i6];
            int zzt = zzt(zzr);
            if (zzt <= 17) {
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
            long j = zzr & 1048575;
            switch (zzt) {
                case 0:
                    if ((i4 & i) != 0) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 1:
                    if ((i4 & i) != 0) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 2:
                    if ((i4 & i) != 0) {
                        long j2 = unsafe.getLong(t, j);
                        zzw3 = zzof.zzw(i7 << 3);
                        zzx = zzof.zzx(j2);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 3:
                    if ((i4 & i) != 0) {
                        long j3 = unsafe.getLong(t, j);
                        zzw3 = zzof.zzw(i7 << 3);
                        zzx = zzof.zzx(j3);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    if ((i4 & i) != 0) {
                        int i10 = unsafe.getInt(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzv(i10);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 5:
                    if ((i4 & i) != 0) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    if ((i4 & i) != 0) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 7:
                    if ((i4 & i) != 0) {
                        zzw5 = zzof.zzw(i7 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 8:
                    if ((i4 & i) != 0) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzny) {
                            zzw6 = zzof.zzw(i7 << 3);
                            zzc = ((zzny) object).zzc();
                            zzw7 = zzof.zzw(zzc);
                            i2 = zzw6 + zzw7 + zzc;
                            i3 += i2;
                        } else {
                            zzw4 = zzof.zzw(i7 << 3);
                            zzv = zzof.zzy((String) object);
                            i2 = zzw4 + zzv;
                            i3 += i2;
                        }
                    } else {
                        continue;
                    }
                case 9:
                    if ((i4 & i) != 0) {
                        zzw8 = zzql.zzw(i7, unsafe.getObject(t, j), zzo(i6));
                        break;
                    } else {
                        continue;
                    }
                case 10:
                    if ((i4 & i) != 0) {
                        zzw6 = zzof.zzw(i7 << 3);
                        zzc = ((zzny) unsafe.getObject(t, j)).zzc();
                        zzw7 = zzof.zzw(zzc);
                        i2 = zzw6 + zzw7 + zzc;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 11:
                    if ((i4 & i) != 0) {
                        int i11 = unsafe.getInt(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzw(i11);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 12:
                    if ((i4 & i) != 0) {
                        int i12 = unsafe.getInt(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzv(i12);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 13:
                    if ((i4 & i) != 0) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 14:
                    if ((i4 & i) != 0) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 15:
                    if ((i4 & i) != 0) {
                        int i13 = unsafe.getInt(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzw((i13 >> 31) ^ (i13 + i13));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 16:
                    if ((i4 & i) != 0) {
                        long j4 = unsafe.getLong(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzx((j4 >> 63) ^ (j4 + j4));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 17:
                    if ((i4 & i) != 0) {
                        zzw8 = zzof.zzE(i7, (zzpy) unsafe.getObject(t, j), zzo(i6));
                        break;
                    } else {
                        continue;
                    }
                case 18:
                    zzw8 = zzql.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 19:
                    zzw8 = zzql.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 20:
                    zzw8 = zzql.zzc(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 21:
                    zzw8 = zzql.zze(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 22:
                    zzw8 = zzql.zzk(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 23:
                    zzw8 = zzql.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 24:
                    zzw8 = zzql.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 25:
                    zzw8 = zzql.zzu(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 26:
                    zzw8 = zzql.zzv(i7, (List) unsafe.getObject(t, j));
                    break;
                case 27:
                    zzw8 = zzql.zzx(i7, (List) unsafe.getObject(t, j), zzo(i6));
                    break;
                case 28:
                    zzw8 = zzql.zzy(i7, (List) unsafe.getObject(t, j));
                    break;
                case 29:
                    zzw8 = zzql.zzm(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 30:
                    zzw8 = zzql.zzi(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 31:
                    zzw8 = zzql.zzq(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 32:
                    zzw8 = zzql.zzs(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 33:
                    zzw8 = zzql.zzo(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 34:
                    zzw8 = zzql.zzg(i7, (List) unsafe.getObject(t, j), false);
                    break;
                case 35:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 36:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 37:
                    zzv = zzql.zzb((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 38:
                    zzv = zzql.zzd((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 39:
                    zzv = zzql.zzj((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 40:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 41:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 42:
                    zzv = zzql.zzt((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 43:
                    zzv = zzql.zzl((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 44:
                    zzv = zzql.zzh((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 45:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 46:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 47:
                    zzv = zzql.zzn((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 48:
                    zzv = zzql.zzf((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i7);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 49:
                    zzw8 = zzql.zzz(i7, (List) unsafe.getObject(t, j), zzo(i6));
                    break;
                case 50:
                    zzpt.zza(i7, unsafe.getObject(t, j), zzp(i6));
                    continue;
                case 51:
                    if (zzD(t, i7, i6)) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 52:
                    if (zzD(t, i7, i6)) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 53:
                    if (zzD(t, i7, i6)) {
                        long zzx2 = zzx(t, j);
                        zzw3 = zzof.zzw(i7 << 3);
                        zzx = zzof.zzx(zzx2);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    if (zzD(t, i7, i6)) {
                        long zzx3 = zzx(t, j);
                        zzw3 = zzof.zzw(i7 << 3);
                        zzx = zzof.zzx(zzx3);
                        zzw8 = zzw3 + zzx;
                        break;
                    } else {
                        continue;
                    }
                case 55:
                    if (zzD(t, i7, i6)) {
                        int zzw10 = zzw(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzv(zzw10);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 56:
                    if (zzD(t, i7, i6)) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 57:
                    if (zzD(t, i7, i6)) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 58:
                    if (zzD(t, i7, i6)) {
                        zzw5 = zzof.zzw(i7 << 3);
                        zzw8 = zzw5 + 1;
                        break;
                    } else {
                        continue;
                    }
                case 59:
                    if (zzD(t, i7, i6)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzny) {
                            zzw6 = zzof.zzw(i7 << 3);
                            zzc = ((zzny) object2).zzc();
                            zzw7 = zzof.zzw(zzc);
                            i2 = zzw6 + zzw7 + zzc;
                            i3 += i2;
                        } else {
                            zzw4 = zzof.zzw(i7 << 3);
                            zzv = zzof.zzy((String) object2);
                            i2 = zzw4 + zzv;
                            i3 += i2;
                        }
                    } else {
                        continue;
                    }
                case 60:
                    if (zzD(t, i7, i6)) {
                        zzw8 = zzql.zzw(i7, unsafe.getObject(t, j), zzo(i6));
                        break;
                    } else {
                        continue;
                    }
                case 61:
                    if (zzD(t, i7, i6)) {
                        zzw6 = zzof.zzw(i7 << 3);
                        zzc = ((zzny) unsafe.getObject(t, j)).zzc();
                        zzw7 = zzof.zzw(zzc);
                        i2 = zzw6 + zzw7 + zzc;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 62:
                    if (zzD(t, i7, i6)) {
                        int zzw11 = zzw(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzw(zzw11);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 63:
                    if (zzD(t, i7, i6)) {
                        int zzw12 = zzw(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzv(zzw12);
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 64:
                    if (zzD(t, i7, i6)) {
                        zzw2 = zzof.zzw(i7 << 3);
                        zzw8 = zzw2 + 4;
                        break;
                    } else {
                        continue;
                    }
                case 65:
                    if (zzD(t, i7, i6)) {
                        zzw = zzof.zzw(i7 << 3);
                        zzw8 = zzw + 8;
                        break;
                    } else {
                        continue;
                    }
                case 66:
                    if (zzD(t, i7, i6)) {
                        int zzw13 = zzw(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzw((zzw13 >> 31) ^ (zzw13 + zzw13));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 67:
                    if (zzD(t, i7, i6)) {
                        long zzx4 = zzx(t, j);
                        zzw4 = zzof.zzw(i7 << 3);
                        zzv = zzof.zzx((zzx4 >> 63) ^ (zzx4 + zzx4));
                        i2 = zzw4 + zzv;
                        i3 += i2;
                    } else {
                        continue;
                    }
                case 68:
                    if (zzD(t, i7, i6)) {
                        zzw8 = zzof.zzE(i7, (zzpy) unsafe.getObject(t, j), zzo(i6));
                        break;
                    } else {
                        continue;
                    }
                default:
            }
            i3 += zzw8;
        }
        zzqx<?, ?> zzqxVar = this.zzl;
        int zzf = i3 + zzqxVar.zzf(zzqxVar.zzb(t));
        if (this.zzf) {
            this.zzm.zzb(t);
            throw null;
        }
        return zzf;
    }

    private final int zzn(T t) {
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzv;
        int zzw5;
        int zzw6;
        int zzc;
        int zzw7;
        int zzw8;
        int zzu;
        int zzw9;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int zzr = zzr(i3);
            int zzt = zzt(zzr);
            int i4 = this.zzc[i3];
            long j = zzr & 1048575;
            if (zzt >= zzon.DOUBLE_LIST_PACKED.zza() && zzt <= zzon.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (zzt) {
                case 0:
                    if (zzB(t, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzB(t, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzB(t, i3)) {
                        long zzf = zzrh.zzf(t, j);
                        zzw3 = zzof.zzw(i4 << 3);
                        zzx = zzof.zzx(zzf);
                        i2 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzB(t, i3)) {
                        long zzf2 = zzrh.zzf(t, j);
                        zzw3 = zzof.zzw(i4 << 3);
                        zzx = zzof.zzx(zzf2);
                        i2 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzB(t, i3)) {
                        int zzd = zzrh.zzd(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzv(zzd);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzB(t, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzB(t, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzB(t, i3)) {
                        zzw5 = zzof.zzw(i4 << 3);
                        zzw8 = zzw5 + 1;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzB(t, i3)) {
                        break;
                    } else {
                        Object zzn = zzrh.zzn(t, j);
                        if (zzn instanceof zzny) {
                            zzw6 = zzof.zzw(i4 << 3);
                            zzc = ((zzny) zzn).zzc();
                            zzw7 = zzof.zzw(zzc);
                            i = zzw6 + zzw7 + zzc;
                            i2 += i;
                            break;
                        } else {
                            zzw4 = zzof.zzw(i4 << 3);
                            zzv = zzof.zzy((String) zzn);
                            i = zzw4 + zzv;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzB(t, i3)) {
                        zzw8 = zzql.zzw(i4, zzrh.zzn(t, j), zzo(i3));
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzB(t, i3)) {
                        zzw6 = zzof.zzw(i4 << 3);
                        zzc = ((zzny) zzrh.zzn(t, j)).zzc();
                        zzw7 = zzof.zzw(zzc);
                        i = zzw6 + zzw7 + zzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzB(t, i3)) {
                        int zzd2 = zzrh.zzd(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzw(zzd2);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzB(t, i3)) {
                        int zzd3 = zzrh.zzd(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzv(zzd3);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzB(t, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzB(t, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzB(t, i3)) {
                        int zzd4 = zzrh.zzd(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzw((zzd4 >> 31) ^ (zzd4 + zzd4));
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzB(t, i3)) {
                        long zzf3 = zzrh.zzf(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzx((zzf3 >> 63) ^ (zzf3 + zzf3));
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzB(t, i3)) {
                        zzw8 = zzof.zzE(i4, (zzpy) zzrh.zzn(t, j), zzo(i3));
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzw8 = zzql.zzs(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 19:
                    zzw8 = zzql.zzq(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 20:
                    zzw8 = zzql.zzc(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 21:
                    zzw8 = zzql.zze(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 22:
                    zzw8 = zzql.zzk(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 23:
                    zzw8 = zzql.zzs(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 24:
                    zzw8 = zzql.zzq(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 25:
                    zzw8 = zzql.zzu(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 26:
                    zzw8 = zzql.zzv(i4, (List) zzrh.zzn(t, j));
                    i2 += zzw8;
                    break;
                case 27:
                    zzw8 = zzql.zzx(i4, (List) zzrh.zzn(t, j), zzo(i3));
                    i2 += zzw8;
                    break;
                case 28:
                    zzw8 = zzql.zzy(i4, (List) zzrh.zzn(t, j));
                    i2 += zzw8;
                    break;
                case 29:
                    zzw8 = zzql.zzm(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 30:
                    zzw8 = zzql.zzi(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 31:
                    zzw8 = zzql.zzq(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 32:
                    zzw8 = zzql.zzs(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 33:
                    zzw8 = zzql.zzo(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 34:
                    zzw8 = zzql.zzg(i4, (List) zzrh.zzn(t, j), false);
                    i2 += zzw8;
                    break;
                case 35:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zzv = zzql.zzb((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zzv = zzql.zzd((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zzv = zzql.zzj((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zzv = zzql.zzt((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zzv = zzql.zzl((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zzv = zzql.zzh((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zzv = zzql.zzp((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zzv = zzql.zzr((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zzv = zzql.zzn((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zzv = zzql.zzf((List) unsafe.getObject(t, j));
                    if (zzv > 0) {
                        zzu = zzof.zzu(i4);
                        zzw9 = zzof.zzw(zzv);
                        zzw4 = zzu + zzw9;
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    zzw8 = zzql.zzz(i4, (List) zzrh.zzn(t, j), zzo(i3));
                    i2 += zzw8;
                    break;
                case 50:
                    zzpt.zza(i4, zzrh.zzn(t, j), zzp(i3));
                    break;
                case 51:
                    if (zzD(t, i4, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t, i4, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t, i4, i3)) {
                        long zzx2 = zzx(t, j);
                        zzw3 = zzof.zzw(i4 << 3);
                        zzx = zzof.zzx(zzx2);
                        i2 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t, i4, i3)) {
                        long zzx3 = zzx(t, j);
                        zzw3 = zzof.zzw(i4 << 3);
                        zzx = zzof.zzx(zzx3);
                        i2 += zzw3 + zzx;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t, i4, i3)) {
                        int zzw10 = zzw(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzv(zzw10);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t, i4, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t, i4, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t, i4, i3)) {
                        zzw5 = zzof.zzw(i4 << 3);
                        zzw8 = zzw5 + 1;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzD(t, i4, i3)) {
                        break;
                    } else {
                        Object zzn2 = zzrh.zzn(t, j);
                        if (zzn2 instanceof zzny) {
                            zzw6 = zzof.zzw(i4 << 3);
                            zzc = ((zzny) zzn2).zzc();
                            zzw7 = zzof.zzw(zzc);
                            i = zzw6 + zzw7 + zzc;
                            i2 += i;
                            break;
                        } else {
                            zzw4 = zzof.zzw(i4 << 3);
                            zzv = zzof.zzy((String) zzn2);
                            i = zzw4 + zzv;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzD(t, i4, i3)) {
                        zzw8 = zzql.zzw(i4, zzrh.zzn(t, j), zzo(i3));
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t, i4, i3)) {
                        zzw6 = zzof.zzw(i4 << 3);
                        zzc = ((zzny) zzrh.zzn(t, j)).zzc();
                        zzw7 = zzof.zzw(zzc);
                        i = zzw6 + zzw7 + zzc;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t, i4, i3)) {
                        int zzw11 = zzw(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzw(zzw11);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t, i4, i3)) {
                        int zzw12 = zzw(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzv(zzw12);
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t, i4, i3)) {
                        zzw2 = zzof.zzw(i4 << 3);
                        zzw8 = zzw2 + 4;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t, i4, i3)) {
                        zzw = zzof.zzw(i4 << 3);
                        zzw8 = zzw + 8;
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t, i4, i3)) {
                        int zzw13 = zzw(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzw((zzw13 >> 31) ^ (zzw13 + zzw13));
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t, i4, i3)) {
                        long zzx4 = zzx(t, j);
                        zzw4 = zzof.zzw(i4 << 3);
                        zzv = zzof.zzx((zzx4 >> 63) ^ (zzx4 + zzx4));
                        i = zzw4 + zzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t, i4, i3)) {
                        zzw8 = zzof.zzE(i4, (zzpy) zzrh.zzn(t, j), zzo(i3));
                        i2 += zzw8;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzqx<?, ?> zzqxVar = this.zzl;
        return i2 + zzqxVar.zzf(zzqxVar.zzb(t));
    }

    private final zzqj zzo(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzqj zzqjVar = (zzqj) this.zzd[i3];
        if (zzqjVar != null) {
            return zzqjVar;
        }
        zzqj<T> zzb2 = zzqg.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzp(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzq(Object obj, int i, zzqj zzqjVar) {
        return zzqjVar.zzf(zzrh.zzn(obj, i & 1048575));
    }

    private final int zzr(int i) {
        return this.zzc[i + 1];
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private static <T> double zzu(T t, long j) {
        return ((Double) zzrh.zzn(t, j)).doubleValue();
    }

    private static <T> float zzv(T t, long j) {
        return ((Float) zzrh.zzn(t, j)).floatValue();
    }

    private static <T> int zzw(T t, long j) {
        return ((Integer) zzrh.zzn(t, j)).intValue();
    }

    private static <T> long zzx(T t, long j) {
        return ((Long) zzrh.zzn(t, j)).longValue();
    }

    private static <T> boolean zzy(T t, long j) {
        return ((Boolean) zzrh.zzn(t, j)).booleanValue();
    }

    private final boolean zzz(T t, T t2, int i) {
        return zzB(t, i) == zzB(t2, i);
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final boolean zza(T t, T t2) {
        boolean zzD;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzr = zzr(i);
            long j = zzr & 1048575;
            switch (zzt(zzr)) {
                case 0:
                    if (zzz(t, t2, i) && Double.doubleToLongBits(zzrh.zzl(t, j)) == Double.doubleToLongBits(zzrh.zzl(t2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzz(t, t2, i) && Float.floatToIntBits(zzrh.zzj(t, j)) == Float.floatToIntBits(zzrh.zzj(t2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzz(t, t2, i) && zzrh.zzf(t, j) == zzrh.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzz(t, t2, i) && zzrh.zzf(t, j) == zzrh.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzz(t, t2, i) && zzrh.zzf(t, j) == zzrh.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzz(t, t2, i) && zzrh.zzh(t, j) == zzrh.zzh(t2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzz(t, t2, i) && zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzz(t, t2, i) && zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzz(t, t2, i) && zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzz(t, t2, i) && zzrh.zzf(t, j) == zzrh.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzz(t, t2, i) && zzrh.zzd(t, j) == zzrh.zzd(t2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzz(t, t2, i) && zzrh.zzf(t, j) == zzrh.zzf(t2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzz(t, t2, i) && zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j))) {
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
                    zzD = zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j));
                    break;
                case 50:
                    zzD = zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j));
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
                    long zzs = zzs(i) & 1048575;
                    if (zzrh.zzd(t, zzs) == zzrh.zzd(t2, zzs) && zzql.zzD(zzrh.zzn(t, j), zzrh.zzn(t2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzD) {
                return false;
            }
        }
        if (this.zzl.zzb(t).equals(this.zzl.zzb(t2))) {
            if (this.zzf) {
                this.zzm.zzb(t);
                this.zzm.zzb(t2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final int zzb(T t) {
        int i;
        int zze;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzr = zzr(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzr;
            int i5 = 37;
            switch (zzt(zzr)) {
                case 0:
                    i = i2 * 53;
                    zze = zzpb.zze(Double.doubleToLongBits(zzrh.zzl(t, j)));
                    i2 = i + zze;
                    break;
                case 1:
                    i = i2 * 53;
                    zze = Float.floatToIntBits(zzrh.zzj(t, j));
                    i2 = i + zze;
                    break;
                case 2:
                    i = i2 * 53;
                    zze = zzpb.zze(zzrh.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 3:
                    i = i2 * 53;
                    zze = zzpb.zze(zzrh.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 4:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 5:
                    i = i2 * 53;
                    zze = zzpb.zze(zzrh.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 6:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 7:
                    i = i2 * 53;
                    zze = zzpb.zzf(zzrh.zzh(t, j));
                    i2 = i + zze;
                    break;
                case 8:
                    i = i2 * 53;
                    zze = ((String) zzrh.zzn(t, j)).hashCode();
                    i2 = i + zze;
                    break;
                case 9:
                    Object zzn = zzrh.zzn(t, j);
                    if (zzn != null) {
                        i5 = zzn.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zze = zzrh.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 11:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 12:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 13:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 14:
                    i = i2 * 53;
                    zze = zzpb.zze(zzrh.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 15:
                    i = i2 * 53;
                    zze = zzrh.zzd(t, j);
                    i2 = i + zze;
                    break;
                case 16:
                    i = i2 * 53;
                    zze = zzpb.zze(zzrh.zzf(t, j));
                    i2 = i + zze;
                    break;
                case 17:
                    Object zzn2 = zzrh.zzn(t, j);
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
                    zze = zzrh.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 50:
                    i = i2 * 53;
                    zze = zzrh.zzn(t, j).hashCode();
                    i2 = i + zze;
                    break;
                case 51:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(Double.doubleToLongBits(zzu(t, j)));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = Float.floatToIntBits(zzv(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(zzx(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(zzx(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(zzx(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zzf(zzy(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = ((String) zzrh.zzn(t, j)).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzrh.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzrh.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(zzx(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzw(t, j);
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzpb.zze(zzx(t, j));
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzD(t, i4, i3)) {
                        i = i2 * 53;
                        zze = zzrh.zzn(t, j).hashCode();
                        i2 = i + zze;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zzl.zzb(t).hashCode();
        if (this.zzf) {
            this.zzm.zzb(t);
            throw null;
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final int zzd(T t) {
        return this.zzg ? zzn(t) : zzm(t);
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zze(T t) {
        int i;
        int i2 = this.zzi;
        while (true) {
            i = this.zzj;
            if (i2 >= i) {
                break;
            }
            long zzr = zzr(this.zzh[i2]) & 1048575;
            Object zzn = zzrh.zzn(t, zzr);
            if (zzn != null) {
                ((zzps) zzn).zzc();
                zzrh.zzo(t, zzr, zzn);
            }
            i2++;
        }
        int length = this.zzh.length;
        while (i < length) {
            this.zzk.zza(t, this.zzh[i]);
            i++;
        }
        this.zzl.zzc(t);
        if (this.zzf) {
            this.zzm.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzqj
    public final boolean zzf(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzi) {
            int i6 = this.zzh[i5];
            int i7 = this.zzc[i6];
            int zzr = zzr(i6);
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
            if ((268435456 & zzr) != 0 && !zzA(t, i6, i, i2, i10)) {
                return false;
            }
            int zzt = zzt(zzr);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzD(t, i7, i6) && !zzq(t, zzr, zzo(i6))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzps) zzrh.zzn(t, zzr & 1048575)).isEmpty()) {
                            zzpr zzprVar = (zzpr) zzp(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzrh.zzn(t, zzr & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzqj zzo = zzo(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzo.zzf(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzA(t, i6, i, i2, i10) && !zzq(t, zzr, zzo(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        if (this.zzf) {
            this.zzm.zzb(t);
            throw null;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zzi(T t, zzog zzogVar) throws IOException {
        if (!this.zzg) {
            zzF(t, zzogVar);
        } else if (!this.zzf) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzr = zzr(i);
                int i2 = this.zzc[i];
                switch (zzt(zzr)) {
                    case 0:
                        if (zzB(t, i)) {
                            zzogVar.zzf(i2, zzrh.zzl(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzB(t, i)) {
                            zzogVar.zze(i2, zzrh.zzj(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzB(t, i)) {
                            zzogVar.zzc(i2, zzrh.zzf(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzB(t, i)) {
                            zzogVar.zzh(i2, zzrh.zzf(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzB(t, i)) {
                            zzogVar.zzi(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzB(t, i)) {
                            zzogVar.zzj(i2, zzrh.zzf(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzB(t, i)) {
                            zzogVar.zzk(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzB(t, i)) {
                            zzogVar.zzl(i2, zzrh.zzh(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzB(t, i)) {
                            zzH(i2, zzrh.zzn(t, zzr & 1048575), zzogVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzB(t, i)) {
                            zzogVar.zzr(i2, zzrh.zzn(t, zzr & 1048575), zzo(i));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzB(t, i)) {
                            zzogVar.zzn(i2, (zzny) zzrh.zzn(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzB(t, i)) {
                            zzogVar.zzo(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzB(t, i)) {
                            zzogVar.zzg(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzB(t, i)) {
                            zzogVar.zzb(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzB(t, i)) {
                            zzogVar.zzd(i2, zzrh.zzf(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzB(t, i)) {
                            zzogVar.zzp(i2, zzrh.zzd(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzB(t, i)) {
                            zzogVar.zzq(i2, zzrh.zzf(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzB(t, i)) {
                            zzogVar.zzs(i2, zzrh.zzn(t, zzr & 1048575), zzo(i));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzql.zzH(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 19:
                        zzql.zzI(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 20:
                        zzql.zzJ(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 21:
                        zzql.zzK(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 22:
                        zzql.zzO(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 23:
                        zzql.zzM(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 24:
                        zzql.zzR(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 25:
                        zzql.zzU(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 26:
                        zzql.zzV(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar);
                        break;
                    case 27:
                        zzql.zzX(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, zzo(i));
                        break;
                    case 28:
                        zzql.zzW(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar);
                        break;
                    case 29:
                        zzql.zzP(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 30:
                        zzql.zzT(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 31:
                        zzql.zzS(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 32:
                        zzql.zzN(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 33:
                        zzql.zzQ(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 34:
                        zzql.zzL(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, false);
                        break;
                    case 35:
                        zzql.zzH(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 36:
                        zzql.zzI(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 37:
                        zzql.zzJ(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 38:
                        zzql.zzK(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 39:
                        zzql.zzO(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 40:
                        zzql.zzM(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 41:
                        zzql.zzR(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 42:
                        zzql.zzU(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 43:
                        zzql.zzP(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 44:
                        zzql.zzT(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 45:
                        zzql.zzS(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 46:
                        zzql.zzN(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 47:
                        zzql.zzQ(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 48:
                        zzql.zzL(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, true);
                        break;
                    case 49:
                        zzql.zzY(this.zzc[i], (List) zzrh.zzn(t, zzr & 1048575), zzogVar, zzo(i));
                        break;
                    case 50:
                        zzG(zzogVar, i2, zzrh.zzn(t, zzr & 1048575), i);
                        break;
                    case 51:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzf(i2, zzu(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzD(t, i2, i)) {
                            zzogVar.zze(i2, zzv(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzc(i2, zzx(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzh(i2, zzx(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzi(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzj(i2, zzx(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzk(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzl(i2, zzy(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzD(t, i2, i)) {
                            zzH(i2, zzrh.zzn(t, zzr & 1048575), zzogVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzr(i2, zzrh.zzn(t, zzr & 1048575), zzo(i));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzn(i2, (zzny) zzrh.zzn(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzo(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzg(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzb(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzd(i2, zzx(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzp(i2, zzw(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzq(i2, zzx(t, zzr & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzD(t, i2, i)) {
                            zzogVar.zzs(i2, zzrh.zzn(t, zzr & 1048575), zzo(i));
                            break;
                        } else {
                            break;
                        }
                }
            }
            zzqx<?, ?> zzqxVar = this.zzl;
            zzqxVar.zzg(zzqxVar.zzb(t), zzogVar);
        } else {
            this.zzm.zzb(t);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqj
    public final void zzc(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzr = zzr(i);
            long j = 1048575 & zzr;
            int i2 = this.zzc[i];
            switch (zzt(zzr)) {
                case 0:
                    if (zzB(t2, i)) {
                        zzrh.zzm(t, j, zzrh.zzl(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzB(t2, i)) {
                        zzrh.zzk(t, j, zzrh.zzj(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzB(t2, i)) {
                        zzrh.zzg(t, j, zzrh.zzf(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzB(t2, i)) {
                        zzrh.zzg(t, j, zzrh.zzf(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzB(t2, i)) {
                        zzrh.zzg(t, j, zzrh.zzf(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzB(t2, i)) {
                        zzrh.zzi(t, j, zzrh.zzh(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzB(t2, i)) {
                        zzrh.zzo(t, j, zzrh.zzn(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzk(t, t2, i);
                    break;
                case 10:
                    if (zzB(t2, i)) {
                        zzrh.zzo(t, j, zzrh.zzn(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzB(t2, i)) {
                        zzrh.zzg(t, j, zzrh.zzf(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzB(t2, i)) {
                        zzrh.zze(t, j, zzrh.zzd(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzB(t2, i)) {
                        zzrh.zzg(t, j, zzrh.zzf(t2, j));
                        zzC(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzk(t, t2, i);
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
                    this.zzk.zzb(t, t2, j);
                    break;
                case 50:
                    zzql.zzG(this.zzo, t, t2, j);
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
                    if (zzD(t2, i2, i)) {
                        zzrh.zzo(t, j, zzrh.zzn(t2, j));
                        zzE(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzl(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzD(t2, i2, i)) {
                        zzrh.zzo(t, j, zzrh.zzn(t2, j));
                        zzE(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzl(t, t2, i);
                    break;
            }
        }
        zzql.zzF(this.zzl, t, t2);
        if (this.zzf) {
            zzql.zzE(this.zzm, t, t2);
        }
    }
}
