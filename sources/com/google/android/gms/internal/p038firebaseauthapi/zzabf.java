package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf */
/* loaded from: classes3.dex */
public final class zzabf {
    private static final Class<?> zza;
    private static final zzabr<?, ?> zzb;
    private static final zzabr<?, ?> zzc;
    private static final zzabr<?, ?> zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzabt();
    }

    public static zzabr<?, ?> zzA() {
        return zzb;
    }

    public static zzabr<?, ?> zzB() {
        return zzc;
    }

    public static zzabr<?, ?> zzC() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzD(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzzf<FT>> void zzE(zzzc<FT> zzzcVar, T t, T t2) {
        zzzcVar.zzb(t2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zzF(zzabr<UT, UB> zzabrVar, T t, T t2) {
        zzabrVar.zzi(t, zzabrVar.zzo(zzabrVar.zzj(t), zzabrVar.zzj(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zzG(int i, List<Integer> list, zzzs zzzsVar, UB ub, zzabr<UT, UB> zzabrVar) {
        if (zzzsVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzzsVar.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zzH(i, intValue, ub, zzabrVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzzsVar.zza()) {
                    ub = (UB) zzH(i, intValue2, ub, zzabrVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zzH(int i, int i2, UB ub, zzabr<UT, UB> zzabrVar) {
        if (ub == null) {
            ub = zzabrVar.zzg();
        }
        zzabrVar.zzb(ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zzI(zzaam zzaamVar, T t, T t2, long j) {
        zzacc.zzo(t, j, zzaam.zzc(zzacc.zzn(t, j), zzacc.zzn(t2, j)));
    }

    public static void zzJ(int i, List<Double> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzB(i, list, z);
    }

    public static void zzK(int i, List<Float> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzA(i, list, z);
    }

    public static void zzL(int i, List<Long> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzx(i, list, z);
    }

    public static void zzM(int i, List<Long> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzy(i, list, z);
    }

    public static void zzN(int i, List<Long> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzK(i, list, z);
    }

    public static void zzO(int i, List<Long> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzz(i, list, z);
    }

    public static void zzP(int i, List<Long> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzI(i, list, z);
    }

    public static void zzQ(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzv(i, list, z);
    }

    public static void zzR(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzG(i, list, z);
    }

    public static void zzS(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzJ(i, list, z);
    }

    public static void zzT(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzw(i, list, z);
    }

    public static void zzU(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzH(i, list, z);
    }

    public static void zzV(int i, List<Integer> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzC(i, list, z);
    }

    public static void zzW(int i, List<Boolean> list, zzyx zzyxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzD(i, list, z);
    }

    public static void zzX(int i, List<String> list, zzyx zzyxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzE(i, list);
    }

    public static void zzY(int i, List<zzym> list, zzyx zzyxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzyxVar.zzF(i, list);
    }

    public static void zzZ(int i, List<?> list, zzyx zzyxVar, zzabd zzabdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzyxVar.zzr(i, list.get(i2), zzabdVar);
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzzo.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzaa(int i, List<?> list, zzyx zzyxVar, zzabd zzabdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzyxVar.zzs(i, list.get(i2), zzabdVar);
        }
    }

    private static zzabr<?, ?> zzab(boolean z) {
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
            return (zzabr) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
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
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(zzaagVar.zzd(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(list.get(i2).longValue());
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
        return zzb(list) + (list.size() * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(zzaagVar.zzd(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(list.get(i2).longValue());
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
        return zzd(list) + (size * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(zzyw.zzH(zzaagVar.zzd(i2)));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzB(zzyw.zzH(list.get(i2).longValue()));
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
        return zzf(list) + (size * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzz(zzzpVar.zzd(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzz(list.get(i2).intValue());
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
        return zzh(list) + (size * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzz(zzzpVar.zzd(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzz(list.get(i2).intValue());
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
        return zzj(list) + (size * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzA(zzzpVar.zzd(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzA(list.get(i2).intValue());
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
        return zzl(list) + (size * zzyw.zzy(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            i = 0;
            while (i2 < size) {
                i += zzyw.zzA(zzyw.zzG(zzzpVar.zzd(i2)));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzyw.zzA(zzyw.zzG(list.get(i2).intValue()));
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
        return zzn(list) + (size * zzyw.zzy(i));
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
        return size * (zzyw.zzy(i) + 4);
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
        return size * (zzyw.zzy(i) + 8);
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
        return size * (zzyw.zzy(i) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i, List<?> list) {
        int zzC;
        int zzC2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzyw.zzy(i) * size;
        if (list instanceof zzaab) {
            zzaab zzaabVar = (zzaab) list;
            while (i2 < size) {
                Object zzg = zzaabVar.zzg(i2);
                if (zzg instanceof zzym) {
                    zzC2 = zzyw.zzE((zzym) zzg);
                } else {
                    zzC2 = zzyw.zzC((String) zzg);
                }
                zzy += zzC2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzym) {
                    zzC = zzyw.zzE((zzym) obj);
                } else {
                    zzC = zzyw.zzC((String) obj);
                }
                zzy += zzC;
                i2++;
            }
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i, Object obj, zzabd zzabdVar) {
        if (obj instanceof zzzz) {
            int zzy = zzyw.zzy(i);
            int zza2 = ((zzzz) obj).zza();
            return zzy + zzyw.zzA(zza2) + zza2;
        }
        return zzyw.zzy(i) + zzyw.zzF((zzaar) obj, zzabdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i, List<?> list, zzabd zzabdVar) {
        int zzF;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzyw.zzy(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzzz) {
                zzF = zzyw.zzD((zzzz) obj);
            } else {
                zzF = zzyw.zzF((zzaar) obj, zzabdVar);
            }
            zzy += zzF;
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i, List<zzym> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzyw.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzyw.zzE(list.get(i2));
        }
        return zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i, List<zzaar> list, zzabd zzabdVar) {
        int size = list.size();
        if (size != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += zzyw.zzK(i, list.get(i3), zzabdVar);
            }
            return i2;
        }
        return 0;
    }
}
