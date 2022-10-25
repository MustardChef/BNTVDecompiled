package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjn<T> implements zzkb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkz.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjr zzo;
    private final zzit zzp;
    private final zzkt<?, ?> zzq;
    private final zzhn<?> zzr;
    private final zzjc zzs;

    private zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjjVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjrVar, zzit zzitVar, zzkt<?, ?> zzktVar, zzhn<?> zzhnVar, zzjc zzjcVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjjVar instanceof zzhy;
        this.zzj = z;
        this.zzh = zzhnVar != null && zzhnVar.zza(zzjjVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjrVar;
        this.zzp = zzitVar;
        this.zzq = zzktVar;
        this.zzr = zzhnVar;
        this.zzg = zzjjVar;
        this.zzs = zzjcVar;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.measurement.zzjn<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzjh r34, com.google.android.gms.internal.measurement.zzjr r35, com.google.android.gms.internal.measurement.zzit r36, com.google.android.gms.internal.measurement.zzkt<?, ?> r37, com.google.android.gms.internal.measurement.zzhn<?> r38, com.google.android.gms.internal.measurement.zzjc r39) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzjh, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzkt, com.google.android.gms.internal.measurement.zzhn, com.google.android.gms.internal.measurement.zzjc):com.google.android.gms.internal.measurement.zzjn");
    }

    private static Field zza(Class<?> cls, String str) {
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

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zza(T t) {
        int i;
        int zza2;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzd = zzd(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzd;
            int i5 = 37;
            switch ((zzd & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zza2 = zzia.zza(Double.doubleToLongBits(zzkz.zze(t, j)));
                    i2 = i + zza2;
                    break;
                case 1:
                    i = i2 * 53;
                    zza2 = Float.floatToIntBits(zzkz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 2:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 3:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 4:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 5:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 6:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 7:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzc(t, j));
                    i2 = i + zza2;
                    break;
                case 8:
                    i = i2 * 53;
                    zza2 = ((String) zzkz.zzf(t, j)).hashCode();
                    i2 = i + zza2;
                    break;
                case 9:
                    Object zzf = zzkz.zzf(t, j);
                    if (zzf != null) {
                        i5 = zzf.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zza2 = zzkz.zzf(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 11:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 12:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 13:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 14:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 15:
                    i = i2 * 53;
                    zza2 = zzkz.zza(t, j);
                    i2 = i + zza2;
                    break;
                case 16:
                    i = i2 * 53;
                    zza2 = zzia.zza(zzkz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 17:
                    Object zzf2 = zzkz.zzf(t, j);
                    if (zzf2 != null) {
                        i5 = zzf2.hashCode();
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
                    zza2 = zzkz.zzf(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 50:
                    i = i2 * 53;
                    zza2 = zzkz.zzf(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 51:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = Float.floatToIntBits(zzc(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zzf(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = ((String) zzkz.zzf(t, j)).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkz.zzf(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkz.zzf(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzd(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzia.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzjn<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkz.zzf(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd = zzd(i);
            long j = 1048575 & zzd;
            int i2 = this.zzc[i];
            switch ((zzd & 267386880) >>> 20) {
                case 0:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza(t, j, zzkz.zze(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzd(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza(t, j, zzkz.zzc(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzjn<T>) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
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
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzkd.zza(this.zzs, t, t2, j);
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
                    if (zza((zzjn<T>) t2, i2, i)) {
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
                        zzb((zzjn<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza((zzjn<T>) t2, i2, i)) {
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
                        zzb((zzjn<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzkd.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzkd.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzd = zzd(i) & 1048575;
        if (zza((zzjn<T>) t2, i)) {
            Object zzf = zzkz.zzf(t, zzd);
            Object zzf2 = zzkz.zzf(t2, zzd);
            if (zzf != null && zzf2 != null) {
                zzkz.zza(t, zzd, zzia.zza(zzf, zzf2));
                zzb((zzjn<T>) t, i);
            } else if (zzf2 != null) {
                zzkz.zza(t, zzd, zzf2);
                zzb((zzjn<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd = zzd(i);
        int i2 = this.zzc[i];
        long j = zzd & 1048575;
        if (zza((zzjn<T>) t2, i2, i)) {
            Object zzf = zza((zzjn<T>) t, i2, i) ? zzkz.zzf(t, j) : null;
            Object zzf2 = zzkz.zzf(t2, j);
            if (zzf != null && zzf2 != null) {
                zzkz.zza(t, j, zzia.zza(zzf, zzf2));
                zzb((zzjn<T>) t, i2, i);
            } else if (zzf2 != null) {
                zzkz.zza(t, j, zzf2);
                zzb((zzjn<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zzb(T t) {
        int i;
        long j;
        int zzd;
        int zzb2;
        int zzj;
        int zzh;
        int zzi;
        int zze;
        int zzg;
        int zzb3;
        int zzi2;
        int zze2;
        int zzg2;
        int i2 = 267386880;
        int i3 = 1048575;
        int i4 = 1;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.zzc.length) {
                int zzd2 = zzd(i5);
                int i7 = (zzd2 & i2) >>> 20;
                int i8 = this.zzc[i5];
                long j2 = zzd2 & 1048575;
                if (i7 >= zzhs.DOUBLE_LIST_PACKED.zza() && i7 <= zzhs.SINT64_LIST_PACKED.zza()) {
                    int i9 = this.zzc[i5 + 2];
                }
                switch (i7) {
                    case 0:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzb(i8, 0.0d);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 1:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzb(i8, 0.0f);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 2:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzd(i8, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 3:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zze(i8, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 4:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzf(i8, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 5:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzg(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 6:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzi(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 7:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzb(i8, true);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 8:
                        if (zza((zzjn<T>) t, i5)) {
                            Object zzf = zzkz.zzf(t, j2);
                            if (zzf instanceof zzgp) {
                                zzb3 = zzhi.zzc(i8, (zzgp) zzf);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i8, (String) zzf);
                                break;
                            }
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 9:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzkd.zza(i8, zzkz.zzf(t, j2), zza(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 10:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzc(i8, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 11:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzg(i8, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 12:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzk(i8, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 13:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzj(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 14:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzh(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 15:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzh(i8, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 16:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzf(i8, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 17:
                        if (zza((zzjn<T>) t, i5)) {
                            zzb3 = zzhi.zzc(i8, (zzjj) zzkz.zzf(t, j2), zza(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 18:
                        zzb3 = zzkd.zzi(i8, zza(t, j2), false);
                        break;
                    case 19:
                        zzb3 = zzkd.zzh(i8, zza(t, j2), false);
                        break;
                    case 20:
                        zzb3 = zzkd.zza(i8, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        zzb3 = zzkd.zzb(i8, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        zzb3 = zzkd.zze(i8, zza(t, j2), false);
                        break;
                    case 23:
                        zzb3 = zzkd.zzi(i8, zza(t, j2), false);
                        break;
                    case 24:
                        zzb3 = zzkd.zzh(i8, zza(t, j2), false);
                        break;
                    case 25:
                        zzb3 = zzkd.zzj(i8, zza(t, j2), false);
                        break;
                    case 26:
                        zzb3 = zzkd.zza(i8, zza(t, j2));
                        break;
                    case 27:
                        zzb3 = zzkd.zza(i8, zza(t, j2), zza(i5));
                        break;
                    case 28:
                        zzb3 = zzkd.zzb(i8, zza(t, j2));
                        break;
                    case 29:
                        zzb3 = zzkd.zzf(i8, zza(t, j2), false);
                        break;
                    case 30:
                        zzb3 = zzkd.zzd(i8, zza(t, j2), false);
                        break;
                    case 31:
                        zzb3 = zzkd.zzh(i8, zza(t, j2), false);
                        break;
                    case 32:
                        zzb3 = zzkd.zzi(i8, zza(t, j2), false);
                        break;
                    case 33:
                        zzb3 = zzkd.zzg(i8, zza(t, j2), false);
                        break;
                    case 34:
                        zzb3 = zzkd.zzc(i8, zza(t, j2), false);
                        break;
                    case 35:
                        zzi2 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 36:
                        zzi2 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 37:
                        zzi2 = zzkd.zza((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 38:
                        zzi2 = zzkd.zzb((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 39:
                        zzi2 = zzkd.zze((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 40:
                        zzi2 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 41:
                        zzi2 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 42:
                        zzi2 = zzkd.zzj((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 43:
                        zzi2 = zzkd.zzf((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 44:
                        zzi2 = zzkd.zzd((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 45:
                        zzi2 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 46:
                        zzi2 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 47:
                        zzi2 = zzkd.zzg((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 48:
                        zzi2 = zzkd.zzc((List) unsafe.getObject(t, j2));
                        if (zzi2 > 0) {
                            zze2 = zzhi.zze(i8);
                            zzg2 = zzhi.zzg(zzi2);
                            zzb3 = zze2 + zzg2 + zzi2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 49:
                        zzb3 = zzkd.zzb(i8, (List<zzjj>) zza(t, j2), zza(i5));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i8, zzkz.zzf(t, j2), zzb(i5));
                        break;
                    case 51:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzb(i8, 0.0d);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 52:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzb(i8, 0.0f);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 53:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzd(i8, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 54:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zze(i8, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 55:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzf(i8, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 56:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzg(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 57:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzi(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 58:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzb(i8, true);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 59:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            Object zzf2 = zzkz.zzf(t, j2);
                            if (zzf2 instanceof zzgp) {
                                zzb3 = zzhi.zzc(i8, (zzgp) zzf2);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i8, (String) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 60:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzkd.zza(i8, zzkz.zzf(t, j2), zza(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 61:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzc(i8, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 62:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzg(i8, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 63:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzk(i8, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 64:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzj(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 65:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzh(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 66:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzh(i8, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 67:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzf(i8, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 68:
                        if (zza((zzjn<T>) t, i8, i5)) {
                            zzb3 = zzhi.zzc(i8, (zzjj) zzkz.zzf(t, j2), zza(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    default:
                        i5 += 3;
                        i2 = 267386880;
                }
                i6 += zzb3;
                i5 += 3;
                i2 = 267386880;
            }
            return i6 + zza((zzkt) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        while (i10 < this.zzc.length) {
            int zzd3 = zzd(i10);
            int[] iArr = this.zzc;
            int i14 = iArr[i10];
            int i15 = (zzd3 & 267386880) >>> 20;
            if (i15 <= 17) {
                int i16 = iArr[i10 + 2];
                int i17 = i16 & i3;
                i = i4 << (i16 >>> 20);
                if (i17 != i12) {
                    i13 = unsafe2.getInt(t, i17);
                    i12 = i17;
                }
            } else {
                i = 0;
            }
            long j3 = zzd3 & i3;
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i11 += zzhi.zzb(i14, 0.0d);
                        continue;
                        i10 += 3;
                        i3 = 1048575;
                        i4 = 1;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i11 += zzhi.zzb(i14, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzd = zzhi.zzd(i14, unsafe2.getLong(t, j3));
                        i11 += zzd;
                        break;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzd = zzhi.zze(i14, unsafe2.getLong(t, j3));
                        i11 += zzd;
                        break;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzd = zzhi.zzf(i14, unsafe2.getInt(t, j3));
                        i11 += zzd;
                        break;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i13 & i) != 0) {
                        zzd = zzhi.zzg(i14, 0L);
                        i11 += zzd;
                        break;
                    }
                    break;
                case 6:
                    if ((i13 & i) != 0) {
                        i11 += zzhi.zzi(i14, 0);
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 7:
                    if ((i13 & i) != 0) {
                        i11 += zzhi.zzb(i14, true);
                        j = 0;
                        i10 += 3;
                        i3 = 1048575;
                        i4 = 1;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 8:
                    if ((i13 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzgp) {
                            zzb2 = zzhi.zzc(i14, (zzgp) object);
                        } else {
                            zzb2 = zzhi.zzb(i14, (String) object);
                        }
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 9:
                    if ((i13 & i) != 0) {
                        zzb2 = zzkd.zza(i14, unsafe2.getObject(t, j3), zza(i10));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 10:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzc(i14, (zzgp) unsafe2.getObject(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 11:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzg(i14, unsafe2.getInt(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 12:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzk(i14, unsafe2.getInt(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 13:
                    if ((i13 & i) != 0) {
                        zzj = zzhi.zzj(i14, 0);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 14:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzh(i14, 0L);
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 15:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzh(i14, unsafe2.getInt(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 16:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzf(i14, unsafe2.getLong(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 17:
                    if ((i13 & i) != 0) {
                        zzb2 = zzhi.zzc(i14, (zzjj) unsafe2.getObject(t, j3), zza(i10));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 18:
                    zzb2 = zzkd.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 19:
                    zzh = zzkd.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 20:
                    zzh = zzkd.zza(i14, (List<Long>) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 21:
                    zzh = zzkd.zzb(i14, (List<Long>) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 22:
                    zzh = zzkd.zze(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 23:
                    zzh = zzkd.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 24:
                    zzh = zzkd.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 25:
                    zzh = zzkd.zzj(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 26:
                    zzb2 = zzkd.zza(i14, (List) unsafe2.getObject(t, j3));
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 27:
                    zzb2 = zzkd.zza(i14, (List<?>) unsafe2.getObject(t, j3), zza(i10));
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 28:
                    zzb2 = zzkd.zzb(i14, (List) unsafe2.getObject(t, j3));
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 29:
                    zzb2 = zzkd.zzf(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 30:
                    zzh = zzkd.zzd(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 31:
                    zzh = zzkd.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 32:
                    zzh = zzkd.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 33:
                    zzh = zzkd.zzg(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 34:
                    zzh = zzkd.zzc(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzh;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 35:
                    zzi = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 36:
                    zzi = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 37:
                    zzi = zzkd.zza((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 38:
                    zzi = zzkd.zzb((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 39:
                    zzi = zzkd.zze((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 40:
                    zzi = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 41:
                    zzi = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 42:
                    zzi = zzkd.zzj((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 43:
                    zzi = zzkd.zzf((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 44:
                    zzi = zzkd.zzd((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 45:
                    zzi = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 46:
                    zzi = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 47:
                    zzi = zzkd.zzg((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 48:
                    zzi = zzkd.zzc((List) unsafe2.getObject(t, j3));
                    if (zzi > 0) {
                        zze = zzhi.zze(i14);
                        zzg = zzhi.zzg(zzi);
                        zzj = zze + zzg + zzi;
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 49:
                    zzb2 = zzkd.zzb(i14, (List) unsafe2.getObject(t, j3), zza(i10));
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 50:
                    zzb2 = this.zzs.zza(i14, unsafe2.getObject(t, j3), zzb(i10));
                    i11 += zzb2;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 51:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzb(i14, 0.0d);
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 52:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzj = zzhi.zzb(i14, 0.0f);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 53:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzd(i14, zze(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 54:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zze(i14, zze(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 55:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzf(i14, zzd(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 56:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzg(i14, 0L);
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 57:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzj = zzhi.zzi(i14, 0);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 58:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzj = zzhi.zzb(i14, true);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 59:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzgp) {
                            zzb2 = zzhi.zzc(i14, (zzgp) object2);
                        } else {
                            zzb2 = zzhi.zzb(i14, (String) object2);
                        }
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 60:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzkd.zza(i14, unsafe2.getObject(t, j3), zza(i10));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 61:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzc(i14, (zzgp) unsafe2.getObject(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 62:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzg(i14, zzd(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 63:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzk(i14, zzd(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 64:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzj = zzhi.zzj(i14, 0);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 65:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzh(i14, 0L);
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 66:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzh(i14, zzd(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 67:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzf(i14, zze(t, j3));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 68:
                    if (zza((zzjn<T>) t, i14, i10)) {
                        zzb2 = zzhi.zzc(i14, (zzjj) unsafe2.getObject(t, j3), zza(i10));
                        i11 += zzb2;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                default:
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
            }
            i10 += 3;
            i3 = 1048575;
            i4 = 1;
        }
        int i18 = 0;
        int zza2 = i11 + zza((zzkt) this.zzq, (Object) t);
        if (this.zzh) {
            zzhr<?> zza3 = this.zzr.zza(t);
            for (int i19 = 0; i19 < zza3.zza.zzc(); i19++) {
                Map.Entry<?, Object> zzb4 = zza3.zza.zzb(i19);
                i18 += zzhr.zza((zzht) zzb4.getKey(), zzb4.getValue());
            }
            for (Map.Entry<?, Object> entry : zza3.zza.zzd()) {
                i18 += zzhr.zza((zzht) entry.getKey(), entry.getValue());
            }
            return zza2 + i18;
        }
        return zza2;
    }

    private static <UT, UB> int zza(zzkt<UT, UB> zzktVar, T t) {
        return zzktVar.zzf(zzktVar.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzlm r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzlm r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    private final <K, V> void zza(zzlm zzlmVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlmVar.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkt<UT, UB> zzktVar, T t, zzlm zzlmVar) throws IOException {
        zzktVar.zza((zzkt<UT, UB>) zzktVar.zzb(t), zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzjy zzjyVar, zzhl zzhlVar) throws IOException {
        Objects.requireNonNull(zzhlVar);
        zzkt zzktVar = this.zzq;
        zzhn<?> zzhnVar = this.zzr;
        zzhr<?> zzhrVar = null;
        Object obj = null;
        while (true) {
            try {
                int zza2 = zzjyVar.zza();
                int zzg = zzg(zza2);
                if (zzg >= 0) {
                    int zzd = zzd(zzg);
                    switch ((267386880 & zzd) >>> 20) {
                        case 0:
                            zzkz.zza(t, zzd & 1048575, zzjyVar.zzd());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 1:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zze());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 2:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzg());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 3:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzf());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 4:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzh());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 5:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzi());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 6:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzj());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 7:
                            zzkz.zza(t, zzd & 1048575, zzjyVar.zzk());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 8:
                            zza(t, zzd, zzjyVar);
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 9:
                            if (zza((zzjn<T>) t, zzg)) {
                                long j = zzd & 1048575;
                                zzkz.zza(t, j, zzia.zza(zzkz.zzf(t, j), zzjyVar.zza(zza(zzg), zzhlVar)));
                                break;
                            } else {
                                zzkz.zza(t, zzd & 1048575, zzjyVar.zza(zza(zzg), zzhlVar));
                                zzb((zzjn<T>) t, zzg);
                                continue;
                            }
                        case 10:
                            zzkz.zza(t, zzd & 1048575, zzjyVar.zzn());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 11:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzo());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 12:
                            int zzp = zzjyVar.zzp();
                            zzif zzc = zzc(zzg);
                            if (zzc != null && !zzc.zza(zzp)) {
                                obj = zzkd.zza(zza2, zzp, obj, zzktVar);
                                break;
                            }
                            zzkz.zza((Object) t, zzd & 1048575, zzp);
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 13:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzq());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 14:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzr());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 15:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzs());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 16:
                            zzkz.zza((Object) t, zzd & 1048575, zzjyVar.zzt());
                            zzb((zzjn<T>) t, zzg);
                            continue;
                        case 17:
                            if (zza((zzjn<T>) t, zzg)) {
                                long j2 = zzd & 1048575;
                                zzkz.zza(t, j2, zzia.zza(zzkz.zzf(t, j2), zzjyVar.zzb(zza(zzg), zzhlVar)));
                                break;
                            } else {
                                zzkz.zza(t, zzd & 1048575, zzjyVar.zzb(zza(zzg), zzhlVar));
                                zzb((zzjn<T>) t, zzg);
                                continue;
                            }
                        case 18:
                            zzjyVar.zza(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 19:
                            zzjyVar.zzb(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 20:
                            zzjyVar.zzd(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 21:
                            zzjyVar.zzc(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 22:
                            zzjyVar.zze(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 23:
                            zzjyVar.zzf(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 24:
                            zzjyVar.zzg(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 25:
                            zzjyVar.zzh(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 26:
                            if (zzf(zzd)) {
                                zzjyVar.zzj(this.zzp.zza(t, zzd & 1048575));
                                break;
                            } else {
                                zzjyVar.zzi(this.zzp.zza(t, zzd & 1048575));
                                continue;
                            }
                        case 27:
                            zzjyVar.zza(this.zzp.zza(t, zzd & 1048575), zza(zzg), zzhlVar);
                            continue;
                        case 28:
                            zzjyVar.zzk(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 29:
                            zzjyVar.zzl(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 30:
                            List<Integer> zza3 = this.zzp.zza(t, zzd & 1048575);
                            zzjyVar.zzm(zza3);
                            obj = zzkd.zza(zza2, zza3, zzc(zzg), obj, zzktVar);
                            continue;
                        case 31:
                            zzjyVar.zzn(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 32:
                            zzjyVar.zzo(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 33:
                            zzjyVar.zzp(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 34:
                            zzjyVar.zzq(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 35:
                            zzjyVar.zza(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 36:
                            zzjyVar.zzb(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 37:
                            zzjyVar.zzd(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 38:
                            zzjyVar.zzc(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 39:
                            zzjyVar.zze(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 40:
                            zzjyVar.zzf(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 41:
                            zzjyVar.zzg(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 42:
                            zzjyVar.zzh(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 43:
                            zzjyVar.zzl(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 44:
                            List<Integer> zza4 = this.zzp.zza(t, zzd & 1048575);
                            zzjyVar.zzm(zza4);
                            obj = zzkd.zza(zza2, zza4, zzc(zzg), obj, zzktVar);
                            continue;
                        case 45:
                            zzjyVar.zzn(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 46:
                            zzjyVar.zzo(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 47:
                            zzjyVar.zzp(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 48:
                            zzjyVar.zzq(this.zzp.zza(t, zzd & 1048575));
                            continue;
                        case 49:
                            zzjyVar.zzb(this.zzp.zza(t, zzd & 1048575), zza(zzg), zzhlVar);
                            continue;
                        case 50:
                            Object zzb2 = zzb(zzg);
                            long zzd2 = zzd(zzg) & 1048575;
                            Object zzf = zzkz.zzf(t, zzd2);
                            if (zzf == null) {
                                zzf = this.zzs.zze(zzb2);
                                zzkz.zza(t, zzd2, zzf);
                            } else if (this.zzs.zzc(zzf)) {
                                Object zze = this.zzs.zze(zzb2);
                                this.zzs.zza(zze, zzf);
                                zzkz.zza(t, zzd2, zze);
                                zzf = zze;
                            }
                            zzjyVar.zza(this.zzs.zza(zzf), this.zzs.zzf(zzb2), zzhlVar);
                            continue;
                        case 51:
                            zzkz.zza(t, zzd & 1048575, Double.valueOf(zzjyVar.zzd()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 52:
                            zzkz.zza(t, zzd & 1048575, Float.valueOf(zzjyVar.zze()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 53:
                            zzkz.zza(t, zzd & 1048575, Long.valueOf(zzjyVar.zzg()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 54:
                            zzkz.zza(t, zzd & 1048575, Long.valueOf(zzjyVar.zzf()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 55:
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzjyVar.zzh()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 56:
                            zzkz.zza(t, zzd & 1048575, Long.valueOf(zzjyVar.zzi()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 57:
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzjyVar.zzj()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 58:
                            zzkz.zza(t, zzd & 1048575, Boolean.valueOf(zzjyVar.zzk()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 59:
                            zza(t, zzd, zzjyVar);
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 60:
                            if (zza((zzjn<T>) t, zza2, zzg)) {
                                long j3 = zzd & 1048575;
                                zzkz.zza(t, j3, zzia.zza(zzkz.zzf(t, j3), zzjyVar.zza(zza(zzg), zzhlVar)));
                            } else {
                                zzkz.zza(t, zzd & 1048575, zzjyVar.zza(zza(zzg), zzhlVar));
                                zzb((zzjn<T>) t, zzg);
                            }
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 61:
                            zzkz.zza(t, zzd & 1048575, zzjyVar.zzn());
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 62:
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzjyVar.zzo()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 63:
                            int zzp2 = zzjyVar.zzp();
                            zzif zzc2 = zzc(zzg);
                            if (zzc2 != null && !zzc2.zza(zzp2)) {
                                obj = zzkd.zza(zza2, zzp2, obj, zzktVar);
                                break;
                            }
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzp2));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 64:
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzjyVar.zzq()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 65:
                            zzkz.zza(t, zzd & 1048575, Long.valueOf(zzjyVar.zzr()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 66:
                            zzkz.zza(t, zzd & 1048575, Integer.valueOf(zzjyVar.zzs()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 67:
                            zzkz.zza(t, zzd & 1048575, Long.valueOf(zzjyVar.zzt()));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        case 68:
                            zzkz.zza(t, zzd & 1048575, zzjyVar.zzb(zza(zzg), zzhlVar));
                            zzb((zzjn<T>) t, zza2, zzg);
                            continue;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zzktVar.zza();
                                } catch (zzii unused) {
                                    zzktVar.zza(zzjyVar);
                                    if (obj == null) {
                                        obj = zzktVar.zzc(t);
                                    }
                                    if (!zzktVar.zza((zzkt) obj, zzjyVar)) {
                                        for (int i = this.zzm; i < this.zzn; i++) {
                                            obj = zza((Object) t, this.zzl[i], (int) obj, (zzkt<UT, int>) zzktVar);
                                        }
                                        if (obj != null) {
                                            zzktVar.zzb((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!zzktVar.zza((zzkt) obj, zzjyVar)) {
                                for (int i2 = this.zzm; i2 < this.zzn; i2++) {
                                    obj = zza((Object) t, this.zzl[i2], (int) obj, (zzkt<UT, int>) zzktVar);
                                }
                                if (obj != null) {
                                    zzktVar.zzb((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            continue;
                    }
                } else if (zza2 == Integer.MAX_VALUE) {
                    for (int i3 = this.zzm; i3 < this.zzn; i3++) {
                        obj = zza((Object) t, this.zzl[i3], (int) obj, (zzkt<UT, int>) zzktVar);
                    }
                    if (obj != null) {
                        zzktVar.zzb((Object) t, (T) obj);
                        return;
                    }
                    return;
                } else {
                    Object zza5 = !this.zzh ? null : zzhnVar.zza(zzhlVar, this.zzg, zza2);
                    if (zza5 != null) {
                        if (zzhrVar == null) {
                            zzhrVar = zzhnVar.zzb(t);
                        }
                        zzhr<?> zzhrVar2 = zzhrVar;
                        obj = zzhnVar.zza(zzjyVar, zza5, zzhlVar, zzhrVar2, obj, zzktVar);
                        zzhrVar = zzhrVar2;
                    } else {
                        zzktVar.zza(zzjyVar);
                        if (obj == null) {
                            obj = zzktVar.zzc(t);
                        }
                        if (!zzktVar.zza((zzkt) obj, zzjyVar)) {
                            for (int i4 = this.zzm; i4 < this.zzn; i4++) {
                                obj = zza((Object) t, this.zzl[i4], (int) obj, (zzkt<UT, int>) zzktVar);
                            }
                            if (obj != null) {
                                zzktVar.zzb((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzm; i5 < this.zzn; i5++) {
                    obj = zza((Object) t, this.zzl[i5], (int) obj, (zzkt<UT, int>) zzktVar);
                }
                if (obj != null) {
                    zzktVar.zzb((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    private static zzks zze(Object obj) {
        zzhy zzhyVar = (zzhy) obj;
        zzks zzksVar = zzhyVar.zzb;
        if (zzksVar == zzks.zza()) {
            zzks zzb2 = zzks.zzb();
            zzhyVar.zzb = zzb2;
            return zzb2;
        }
        return zzksVar;
    }

    private static int zza(byte[] bArr, int i, int i2, zzlg zzlgVar, Class<?> cls, zzgo zzgoVar) throws IOException {
        switch (zzjm.zza[zzlgVar.ordinal()]) {
            case 1:
                int zzb2 = zzgl.zzb(bArr, i, zzgoVar);
                zzgoVar.zzc = Boolean.valueOf(zzgoVar.zzb != 0);
                return zzb2;
            case 2:
                return zzgl.zze(bArr, i, zzgoVar);
            case 3:
                zzgoVar.zzc = Double.valueOf(zzgl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzgoVar.zzc = Integer.valueOf(zzgl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzgoVar.zzc = Long.valueOf(zzgl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzgoVar.zzc = Float.valueOf(zzgl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzgl.zza(bArr, i, zzgoVar);
                zzgoVar.zzc = Integer.valueOf(zzgoVar.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzgl.zzb(bArr, i, zzgoVar);
                zzgoVar.zzc = Long.valueOf(zzgoVar.zzb);
                return zzb3;
            case 14:
                return zzgl.zza(zzjx.zza().zza((Class) cls), bArr, i, i2, zzgoVar);
            case 15:
                int zza3 = zzgl.zza(bArr, i, zzgoVar);
                zzgoVar.zzc = Integer.valueOf(zzhb.zze(zzgoVar.zza));
                return zza3;
            case 16:
                int zzb4 = zzgl.zzb(bArr, i, zzgoVar);
                zzgoVar.zzc = Long.valueOf(zzhb.zza(zzgoVar.zzb));
                return zzb4;
            case 17:
                return zzgl.zzd(bArr, i, zzgoVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0233 -> B:116:0x0234). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016b -> B:67:0x016c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e5 -> B:96:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzgo r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzgo zzgoVar) throws IOException {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object zze = this.zzs.zze(zzb2);
            this.zzs.zza(zze, object);
            unsafe.putObject(t, j, zze);
            object = zze;
        }
        zzja<?, ?> zzf = this.zzs.zzf(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzgl.zza(bArr, i, zzgoVar);
        int i4 = zzgoVar.zza;
        if (i4 < 0 || i4 > i2 - zza3) {
            throw zzij.zza();
        }
        int i5 = i4 + zza3;
        Object obj = (K) zzf.zzb;
        Object obj2 = (V) zzf.zzd;
        while (zza3 < i5) {
            int i6 = zza3 + 1;
            int i7 = bArr[zza3];
            if (i7 < 0) {
                i6 = zzgl.zza(i7, bArr, i6, zzgoVar);
                i7 = zzgoVar.zza;
            }
            int i8 = i6;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 == 1) {
                if (i10 == zzf.zza.zzb()) {
                    zza3 = zza(bArr, i8, i2, zzf.zza, (Class<?>) null, zzgoVar);
                    obj = (K) zzgoVar.zzc;
                } else {
                    zza3 = zzgl.zza(i7, bArr, i8, i2, zzgoVar);
                }
            } else {
                if (i9 == 2 && i10 == zzf.zzc.zzb()) {
                    zza3 = zza(bArr, i8, i2, zzf.zzc, zzf.zzd.getClass(), zzgoVar);
                    obj2 = zzgoVar.zzc;
                }
                zza3 = zzgl.zza(i7, bArr, i8, i2, zzgoVar);
            }
        }
        if (zza3 != i5) {
            throw zzij.zzg();
        }
        zza2.put(obj, obj2);
        return i5;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgo zzgoVar) throws IOException {
        int zzb2;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzgl.zzc(bArr, i)));
                    zzb2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzgl.zzd(bArr, i)));
                    zzb2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    zzb2 = zzgl.zzb(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, Long.valueOf(zzgoVar.zzb));
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    zzb2 = zzgl.zza(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzgoVar.zza));
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgl.zzb(bArr, i)));
                    zzb2 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgl.zza(bArr, i)));
                    zzb2 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    zzb2 = zzgl.zzb(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgoVar.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzgl.zza(bArr, i, zzgoVar);
                    int i9 = zzgoVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) != 0 && !zzlb.zza(bArr, zza2, zza2 + i9)) {
                        throw zzij.zzh();
                    } else {
                        unsafe.putObject(t, j, new String(bArr, zza2, i9, zzia.zza));
                        zza2 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzgl.zza(zza(i8), bArr, i, i2, zzgoVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgoVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object, zzgoVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    zzb2 = zzgl.zze(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, zzgoVar.zzc);
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzgl.zza(bArr, i, zzgoVar);
                    int i10 = zzgoVar.zza;
                    zzif zzc = zzc(i8);
                    if (zzc == null || zzc.zza(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        zzb2 = zza4;
                        unsafe.putInt(t, j2, i4);
                        return zzb2;
                    }
                    zze(t).zza(i3, Long.valueOf(i10));
                    return zza4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    zzb2 = zzgl.zza(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzhb.zze(zzgoVar.zza)));
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    zzb2 = zzgl.zzb(bArr, i, zzgoVar);
                    unsafe.putObject(t, j, Long.valueOf(zzhb.zza(zzgoVar.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    zzb2 = zzgl.zza(zza(i8), bArr, i, i2, (i3 & (-8)) | 4, zzgoVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgoVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object2, zzgoVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzb2;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzkb zza(int i) {
        int i2 = (i / 3) << 1;
        zzkb zzkbVar = (zzkb) this.zzd[i2];
        if (zzkbVar != null) {
            return zzkbVar;
        }
        zzkb<T> zza2 = zzjx.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04d7, code lost:
        if (r6 == 1048575) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04d9, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04df, code lost:
        r1 = null;
        r2 = r9.zzm;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04e4, code lost:
        if (r2 >= r9.zzn) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04e6, code lost:
        r1 = (com.google.android.gms.internal.measurement.zzks) r9.zza((java.lang.Object) r12, r9.zzl[r2], (int) r1, (com.google.android.gms.internal.measurement.zzkt<UT, int>) r9.zzq);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04f5, code lost:
        if (r1 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04f7, code lost:
        r9.zzq.zzb((java.lang.Object) r12, (T) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04fc, code lost:
        if (r7 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0500, code lost:
        if (r0 != r31) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0507, code lost:
        throw com.google.android.gms.internal.measurement.zzij.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x050a, code lost:
        if (r0 > r31) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x050c, code lost:
        if (r3 != r7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x050e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0513, code lost:
        throw com.google.android.gms.internal.measurement.zzij.zzg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgo r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02dc, code lost:
        if (r0 == r5) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e0, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0323, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0346, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzgo r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd = zzd(this.zzl[i2]) & 1048575;
            Object zzf = zzkz.zzf(t, zzd);
            if (zzf != null) {
                zzkz.zza(t, zzd, this.zzs.zzd(zzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkt<UT, UB> zzktVar) {
        zzif zzc;
        int i2 = this.zzc[i];
        Object zzf = zzkz.zzf(obj, zzd(i) & 1048575);
        return (zzf == null || (zzc = zzc(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zza(zzf), zzc, (zzif) ub, (zzkt<UT, zzif>) zzktVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzifVar, UB ub, zzkt<UT, UB> zzktVar) {
        zzja<?, ?> zzf = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzifVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzktVar.zza();
                }
                zzgx zzc = zzgp.zzc(zzjb.zza(zzf, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc.zzb(), zzf, next.getKey(), next.getValue());
                    zzktVar.zza((zzkt<UT, UB>) ub, i2, zzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzkb] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzkb] */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zzd(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza(t).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd = zzd(i6);
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
            if (((268435456 & zzd) != 0) && !zza((zzjn<T>) t, i6, i, i2, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zza((zzjn<T>) t, i6, i, i2, i10) && !zza(t, zzd, zza(i6))) {
                    return false;
                }
            } else {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza((zzjn<T>) t, i7, i6) && !zza(t, zzd, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzkz.zzf(t, zzd & 1048575));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzln.MESSAGE) {
                                    zzkb<T> zzkbVar = 0;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkbVar == null) {
                                            zzkbVar = zzjx.zza().zza((Class) next.getClass());
                                        }
                                        boolean zzd2 = zzkbVar.zzd(next);
                                        zzkbVar = zzkbVar;
                                        if (!zzd2) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzkz.zzf(t, zzd & 1048575);
                if (!list.isEmpty()) {
                    ?? zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkb zzkbVar) {
        return zzkbVar.zzd(zzkz.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzlm zzlmVar) throws IOException {
        if (obj instanceof String) {
            zzlmVar.zza(i, (String) obj);
        } else {
            zzlmVar.zza(i, (zzgp) obj);
        }
    }

    private final void zza(Object obj, int i, zzjy zzjyVar) throws IOException {
        if (zzf(i)) {
            zzkz.zza(obj, i & 1048575, zzjyVar.zzm());
        } else if (this.zzi) {
            zzkz.zza(obj, i & 1048575, zzjyVar.zzl());
        } else {
            zzkz.zza(obj, i & 1048575, zzjyVar.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzkz.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzkz.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzkz.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzkz.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkz.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzjn<T>) t, i) == zza((zzjn<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzjn<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze = zze(i);
        long j = zze & 1048575;
        if (j != 1048575) {
            return (zzkz.zza(t, j) & (1 << (zze >>> 20))) != 0;
        }
        int zzd = zzd(i);
        long j2 = zzd & 1048575;
        switch ((zzd & 267386880) >>> 20) {
            case 0:
                return zzkz.zze(t, j2) != 0.0d;
            case 1:
                return zzkz.zzd(t, j2) != 0.0f;
            case 2:
                return zzkz.zzb(t, j2) != 0;
            case 3:
                return zzkz.zzb(t, j2) != 0;
            case 4:
                return zzkz.zza(t, j2) != 0;
            case 5:
                return zzkz.zzb(t, j2) != 0;
            case 6:
                return zzkz.zza(t, j2) != 0;
            case 7:
                return zzkz.zzc(t, j2);
            case 8:
                Object zzf = zzkz.zzf(t, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzgp) {
                    return !zzgp.zza.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzkz.zzf(t, j2) != null;
            case 10:
                return !zzgp.zza.equals(zzkz.zzf(t, j2));
            case 11:
                return zzkz.zza(t, j2) != 0;
            case 12:
                return zzkz.zza(t, j2) != 0;
            case 13:
                return zzkz.zza(t, j2) != 0;
            case 14:
                return zzkz.zzb(t, j2) != 0;
            case 15:
                return zzkz.zza(t, j2) != 0;
            case 16:
                return zzkz.zzb(t, j2) != 0;
            case 17:
                return zzkz.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzb(T t, int i) {
        int zze = zze(i);
        long j = 1048575 & zze;
        if (j == 1048575) {
            return;
        }
        zzkz.zza((Object) t, j, (1 << (zze >>> 20)) | zzkz.zza(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkz.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzkz.zza((Object) t, zze(i2) & 1048575, i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
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
}
