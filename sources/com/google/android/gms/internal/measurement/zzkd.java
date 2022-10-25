package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzkd {
    private static final Class<?> zza = zzd();
    private static final zzkt<?, ?> zzb = zza(false);
    private static final zzkt<?, ?> zzc = zza(true);
    private static final zzkt<?, ?> zzd = new zzkv();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhy.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzlm zzlmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzlm zzlmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zza(i, list);
    }

    public static void zzb(int i, List<zzgp> list, zzlm zzlmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzlm zzlmVar, zzkb zzkbVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zza(i, list, zzkbVar);
    }

    public static void zzb(int i, List<?> list, zzlm zzlmVar, zzkb zzkbVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzlmVar.zzb(i, list, zzkbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzd(zzixVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zze(zzixVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzixVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzk(zzibVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(zzibVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzg(zzibVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            i = 0;
            while (i2 < size) {
                i += zzhi.zzh(zzibVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzhi.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzhi.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhi.zzi(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhi.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhi.zzb(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list) {
        int zzb2;
        int zzb3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        if (list instanceof zziq) {
            zziq zziqVar = (zziq) list;
            while (i2 < size) {
                Object zzb4 = zziqVar.zzb(i2);
                if (zzb4 instanceof zzgp) {
                    zzb3 = zzhi.zzb((zzgp) zzb4);
                } else {
                    zzb3 = zzhi.zzb((String) zzb4);
                }
                zze += zzb3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzgp) {
                    zzb2 = zzhi.zzb((zzgp) obj);
                } else {
                    zzb2 = zzhi.zzb((String) obj);
                }
                zze += zzb2;
                i2++;
            }
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, Object obj, zzkb zzkbVar) {
        if (obj instanceof zzio) {
            return zzhi.zza(i, (zzio) obj);
        }
        return zzhi.zzb(i, (zzjj) obj, zzkbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list, zzkb zzkbVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhi.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzio) {
                zza2 = zzhi.zza((zzio) obj);
            } else {
                zza2 = zzhi.zza((zzjj) obj, zzkbVar);
            }
            zze += zza2;
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzgp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzhi.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhi.zzb(list.get(i2));
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzjj> list, zzkb zzkbVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhi.zzc(i, list.get(i3), zzkbVar);
        }
        return i2;
    }

    public static zzkt<?, ?> zza() {
        return zzb;
    }

    public static zzkt<?, ?> zzb() {
        return zzc;
    }

    public static zzkt<?, ?> zzc() {
        return zzd;
    }

    private static zzkt<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzkt) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzjc zzjcVar, T t, T t2, long j) {
        zzkz.zza(t, j, zzjcVar.zza(zzkz.zzf(t, j), zzkz.zzf(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzht<FT>> void zza(zzhn<FT> zzhnVar, T t, T t2) {
        zzhr<FT> zza2 = zzhnVar.zza(t2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzhnVar.zzb(t).zza(zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzkt<UT, UB> zzktVar, T t, T t2) {
        zzktVar.zza(t, zzktVar.zzc(zzktVar.zzb(t), zzktVar.zzb(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, List<Integer> list, zzif zzifVar, UB ub, zzkt<UT, UB> zzktVar) {
        if (zzifVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzifVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzktVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzifVar.zza(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzktVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, int i2, UB ub, zzkt<UT, UB> zzktVar) {
        if (ub == null) {
            ub = zzktVar.zza();
        }
        zzktVar.zza((zzkt<UT, UB>) ub, i, i2);
        return ub;
    }
}
