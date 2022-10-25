package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzql {
    private static final Class<?> zza;
    private static final zzqx<?, ?> zzb;
    private static final zzqx<?, ?> zzc;
    private static final zzqx<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzZ(false);
        zzc = zzZ(true);
        zzd = new zzqz();
    }

    public static zzqx<?, ?> zzA() {
        return zzb;
    }

    public static zzqx<?, ?> zzB() {
        return zzc;
    }

    public static zzqx<?, ?> zzC() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzol<FT>> void zzE(zzoi<FT> zzoiVar, T t, T t2) {
        zzoiVar.zzb(t2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzF(zzqx<UT, UB> zzqxVar, T t, T t2) {
        zzqxVar.zza(t, zzqxVar.zzd(zzqxVar.zzb(t), zzqxVar.zzb(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzG(zzpt zzptVar, T t, T t2, long j) {
        zzps zzpsVar = (zzps) zzrh.zzn(t, j);
        zzps zzpsVar2 = (zzps) zzrh.zzn(t2, j);
        if (!zzpsVar2.isEmpty()) {
            if (!zzpsVar.zzd()) {
                zzpsVar = zzpsVar.zzb();
            }
            zzpsVar.zza(zzpsVar2);
        }
        zzrh.zzo(t, j, zzpsVar);
    }

    public static void zzH(int i, List<Double> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzz(i, list, z);
    }

    public static void zzI(int i, List<Float> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzy(i, list, z);
    }

    public static void zzJ(int i, List<Long> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzv(i, list, z);
    }

    public static void zzK(int i, List<Long> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzw(i, list, z);
    }

    public static void zzL(int i, List<Long> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzI(i, list, z);
    }

    public static void zzM(int i, List<Long> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzx(i, list, z);
    }

    public static void zzN(int i, List<Long> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzG(i, list, z);
    }

    public static void zzO(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzt(i, list, z);
    }

    public static void zzP(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzE(i, list, z);
    }

    public static void zzQ(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzH(i, list, z);
    }

    public static void zzR(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzu(i, list, z);
    }

    public static void zzS(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzF(i, list, z);
    }

    public static void zzT(int i, List<Integer> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzA(i, list, z);
    }

    public static void zzU(int i, List<Boolean> list, zzog zzogVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzB(i, list, z);
    }

    public static void zzV(int i, List<String> list, zzog zzogVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzC(i, list);
    }

    public static void zzW(int i, List<zzny> list, zzog zzogVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzogVar.zzD(i, list);
    }

    public static void zzX(int i, List<?> list, zzog zzogVar, zzqj zzqjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzogVar.zzr(i, list.get(i2), zzqjVar);
        }
    }

    public static void zzY(int i, List<?> list, zzog zzogVar, zzqj zzqjVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzogVar.zzs(i, list.get(i2), zzqjVar);
        }
    }

    private static zzqx<?, ?> zzZ(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzqx) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzos.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpn) {
            zzpn zzpnVar = (zzpn) list;
            i = 0;
            while (i2 < size) {
                i += zzof.zzx(zzpnVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzof.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpn) {
            zzpn zzpnVar = (zzpn) list;
            i = 0;
            while (i2 < size) {
                i += zzof.zzx(zzpnVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzof.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpn) {
            zzpn zzpnVar = (zzpn) list;
            i = 0;
            while (i2 < size) {
                long zze = zzpnVar.zze(i2);
                i += zzof.zzx((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = list.get(i2).longValue();
                i += zzof.zzx((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzot) {
            zzot zzotVar = (zzot) list;
            i = 0;
            while (i2 < size) {
                i += zzof.zzv(zzotVar.zzf(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzof.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzot) {
            zzot zzotVar = (zzot) list;
            i = 0;
            while (i2 < size) {
                i += zzof.zzv(zzotVar.zzf(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzof.zzv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzot) {
            zzot zzotVar = (zzot) list;
            i = 0;
            while (i2 < size) {
                i += zzof.zzw(zzotVar.zzf(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzof.zzw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzot) {
            zzot zzotVar = (zzot) list;
            i = 0;
            while (i2 < size) {
                int zzf = zzotVar.zzf(i2);
                i += zzof.zzw((zzf >> 31) ^ (zzf + zzf));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = list.get(i2).intValue();
                i += zzof.zzw((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzof.zzu(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzof.zzw(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzof.zzw(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzof.zzw(i << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i, List<?> list) {
        int zzy;
        int zzy2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzof.zzu(i) * size;
        if (list instanceof zzpi) {
            zzpi zzpiVar = (zzpi) list;
            while (i2 < size) {
                Object zze = zzpiVar.zze(i2);
                if (zze instanceof zzny) {
                    zzy2 = zzof.zzA((zzny) zze);
                } else {
                    zzy2 = zzof.zzy((String) zze);
                }
                zzu += zzy2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzny) {
                    zzy = zzof.zzA((zzny) obj);
                } else {
                    zzy = zzof.zzy((String) obj);
                }
                zzu += zzy;
                i2++;
            }
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i, Object obj, zzqj zzqjVar) {
        if (obj instanceof zzpg) {
            int zzw = zzof.zzw(i << 3);
            int zza2 = ((zzpg) obj).zza();
            return zzw + zzof.zzw(zza2) + zza2;
        }
        return zzof.zzw(i << 3) + zzof.zzB((zzpy) obj, zzqjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i, List<?> list, zzqj zzqjVar) {
        int zzB;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzof.zzu(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzpg) {
                zzB = zzof.zzz((zzpg) obj);
            } else {
                zzB = zzof.zzB((zzpy) obj, zzqjVar);
            }
            zzu += zzB;
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i, List<zzny> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzof.zzu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzu += zzof.zzA(list.get(i2));
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i, List<zzpy> list, zzqj zzqjVar) {
        int size = list.size();
        if (size != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += zzof.zzE(i, list.get(i3), zzqjVar);
            }
            return i2;
        }
        return 0;
    }
}
