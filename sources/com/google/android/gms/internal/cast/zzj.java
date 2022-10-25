package com.google.android.gms.internal.cast;

import android.os.Bundle;
import com.google.android.gms.cast.internal.Logger;
import java.math.BigInteger;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzj {
    private static final Logger zza = new Logger("ApplicationAnalyticsUtils");
    private static final String zzb = "20.0.0";
    private final String zzc;
    private final Map<Integer, Integer> zzd;
    private final Map<Integer, Integer> zze;

    public zzj(Bundle bundle, String str) {
        this.zzc = str;
        this.zzd = zzn.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR");
        this.zze = zzn.zza(bundle, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON");
    }

    private final zzks zze(zzi zziVar) {
        long j;
        zzks zzc = zzkt.zzc();
        zzc.zza(zziVar.zzd);
        int i = zziVar.zze;
        zziVar.zze = i + 1;
        zzc.zzd(i);
        String str = zziVar.zzc;
        if (str != null) {
            zzc.zzc(str);
        }
        zzki zza2 = zzkj.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zzc);
        zzc.zzh(zza2.zzp());
        zzkk zza3 = zzkl.zza();
        if (zziVar.zzb != null) {
            zzla zza4 = zzlb.zza();
            zza4.zza(zziVar.zzb);
            zza3.zza(zza4.zzp());
        }
        zza3.zzb(false);
        String str2 = zziVar.zzg;
        if (str2 != null) {
            try {
                String replace = str2.replace("-", "");
                j = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
            } catch (NumberFormatException e) {
                zza.m361w(e, "receiverSessionId %s is not valid for hash", str2);
                j = 0;
            }
            zza3.zzc(j);
        }
        zza3.zzf(zziVar.zzf);
        zzc.zzg(zza3);
        return zzc;
    }

    private static void zzf(zzks zzksVar, boolean z) {
        zzkk zzc = zzkl.zzc(zzksVar.zze());
        zzc.zzb(z);
        zzksVar.zzg(zzc);
    }

    public final zzkt zza(zzi zziVar) {
        return zze(zziVar).zzp();
    }

    public final zzkt zzb(zzi zziVar) {
        zzks zze = zze(zziVar);
        zzkk zzc = zzkl.zzc(zze.zze());
        zzc.zzd(zzfh.APP_SESSION_RESUMED_FROM_SAVED_SESSION.zza());
        zze.zzf(zzc.zzp());
        zzf(zze, true);
        return zze.zzp();
    }

    public final zzkt zzc(zzi zziVar, boolean z) {
        zzks zze = zze(zziVar);
        zzf(zze, z);
        return zze.zzp();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    @org.checkerframework.dataflow.qual.Pure
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.cast.zzkt zzd(com.google.android.gms.internal.cast.zzi r4, int r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.cast.zzks r4 = r3.zze(r4)
            com.google.android.gms.internal.cast.zzkl r0 = r4.zze()
            com.google.android.gms.internal.cast.zzkk r0 = com.google.android.gms.internal.cast.zzkl.zzc(r0)
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zze
            if (r1 == 0) goto L2e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L1b
            goto L2e
        L1b:
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zze
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L30
        L2e:
            int r1 = r5 + 10000
        L30:
            r0.zzd(r1)
            java.util.Map<java.lang.Integer, java.lang.Integer> r1 = r3.zzd
            if (r1 == 0) goto L55
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.util.Map<java.lang.Integer, java.lang.Integer> r5 = r3.zzd
            java.lang.Object r5 = r5.get(r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L57
        L55:
            int r5 = r5 + 10000
        L57:
            r0.zze(r5)
            com.google.android.gms.internal.cast.zzos r5 = r0.zzp()
            com.google.android.gms.internal.cast.zzkl r5 = (com.google.android.gms.internal.cast.zzkl) r5
            r4.zzf(r5)
            com.google.android.gms.internal.cast.zzos r4 = r4.zzp()
            com.google.android.gms.internal.cast.zzkt r4 = (com.google.android.gms.internal.cast.zzkt) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzj.zzd(com.google.android.gms.internal.cast.zzi, int):com.google.android.gms.internal.cast.zzkt");
    }
}
