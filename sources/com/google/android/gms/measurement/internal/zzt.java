package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzmx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzt {
    private String zza;
    private boolean zzb;
    private zzcd.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzr zzh;

    private zzt(zzr zzrVar, String str) {
        this.zzh = zzrVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzt(zzr zzrVar, String str, zzcd.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzrVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzu zzuVar) {
        int zza = zzuVar.zza();
        if (zzuVar.zzc != null) {
            this.zze.set(zza, zzuVar.zzc.booleanValue());
        }
        if (zzuVar.zzd != null) {
            this.zzd.set(zza, zzuVar.zzd.booleanValue());
        }
        if (zzuVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza));
            long longValue = zzuVar.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza), Long.valueOf(longValue));
            }
        }
        if (zzuVar.zzf != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(zza));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(zza), list);
            }
            if (zzuVar.zzb()) {
                list.clear();
            }
            if (zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzbb) && zzuVar.zzc()) {
                list.clear();
            }
            if (zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzbb)) {
                long longValue2 = zzuVar.zzf.longValue() / 1000;
                if (list.contains(Long.valueOf(longValue2))) {
                    return;
                }
                list.add(Long.valueOf(longValue2));
                return;
            }
            list.add(Long.valueOf(zzuVar.zzf.longValue() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    public final zzcd.zza zza(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        zzcd.zza.C5585zza zzh = zzcd.zza.zzh();
        zzh.zza(i);
        zzh.zza(this.zzb);
        zzcd.zzi zziVar = this.zzc;
        if (zziVar != null) {
            zzh.zza(zziVar);
        }
        zzcd.zzi.zza zza = zzcd.zzi.zzi().zzb(zzkr.zza(this.zzd)).zza(zzkr.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer num : this.zzf.keySet()) {
                int intValue = num.intValue();
                arrayList.add((zzcd.zzb) ((com.google.android.gms.internal.measurement.zzhy) zzcd.zzb.zze().zza(intValue).zza(this.zzf.get(Integer.valueOf(intValue)).longValue()).zzy()));
            }
        }
        zza.zzc(arrayList);
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num2 : this.zzg.keySet()) {
                zzcd.zzj.zza zza2 = zzcd.zzj.zze().zza(num2.intValue());
                List<Long> list = this.zzg.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    zza2.zza(list);
                }
                arrayList2.add((zzcd.zzj) ((com.google.android.gms.internal.measurement.zzhy) zza2.zzy()));
            }
        }
        zza.zzd(arrayList2);
        zzh.zza(zza);
        return (zzcd.zza) ((com.google.android.gms.internal.measurement.zzhy) zzh.zzy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzt(zzr zzrVar, String str, zzcd.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzqVar) {
        this(zzrVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzt(zzr zzrVar, String str, zzq zzqVar) {
        this(zzrVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BitSet zza(zzt zztVar) {
        return zztVar.zzd;
    }
}
