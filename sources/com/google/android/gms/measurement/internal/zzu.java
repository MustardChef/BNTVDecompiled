package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzu {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(String str, zzbv.zzf zzfVar, zzeq zzeqVar) {
        String zzd;
        List<String> list;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zza() || zzfVar.zzb() == zzbv.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzfVar.zzb() == zzbv.zzf.zzb.IN_LIST) {
            if (zzfVar.zzh() == 0) {
                return null;
            }
        } else if (!zzfVar.zzc()) {
            return null;
        }
        zzbv.zzf.zzb zzb = zzfVar.zzb();
        boolean zzf = zzfVar.zzf();
        if (zzf || zzb == zzbv.zzf.zzb.REGEXP || zzb == zzbv.zzf.zzb.IN_LIST) {
            zzd = zzfVar.zzd();
        } else {
            zzd = zzfVar.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str2 = zzd;
        if (zzfVar.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzfVar.zzg();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String str3 : zzg) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return zza(str, zzb, zzf, str2, list, zzb == zzbv.zzf.zzb.REGEXP ? str2 : null, zzeqVar);
    }

    private static Boolean zza(String str, zzbv.zzf.zzb zzbVar, boolean z, String str2, List<String> list, String str3, zzeq zzeqVar) {
        if (str == null) {
            return null;
        }
        if (zzbVar == zzbv.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzbVar != zzbv.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzq.zza[zzbVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzeqVar != null) {
                        zzeqVar.zzh().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(long j, zzbv.zzd zzdVar) {
        try {
            return zza(new BigDecimal(j), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(double d, zzbv.zzd zzdVar) {
        try {
            return zza(new BigDecimal(d), zzdVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zza(String str, zzbv.zzd zzdVar) {
        if (zzkr.zza(str)) {
            try {
                return zza(new BigDecimal(str), zzdVar, 0.0d);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if (r2 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean zza(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbv.zzd r10, double r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbv$zzd, double):java.lang.Boolean");
    }
}
