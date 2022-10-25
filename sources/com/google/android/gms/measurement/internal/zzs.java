package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzs {
    private zzcd.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzr zzd;

    private zzs(zzr zzrVar) {
        this.zzd = zzrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcd.zzc zza(String str, zzcd.zzc zzcVar) {
        String zzc = zzcVar.zzc();
        List<zzcd.zze> zza = zzcVar.zza();
        this.zzd.mo331f_();
        Long l = (Long) zzkr.zzb(zzcVar, "_eid");
        boolean z = l != null;
        if (z && zzc.equals("_ep")) {
            this.zzd.mo331f_();
            zzc = (String) zzkr.zzb(zzcVar, "_en");
            if (TextUtils.isEmpty(zzc)) {
                this.zzd.zzq().zzf().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzcd.zzc, Long> zza2 = this.zzd.zzi().zza(str, l);
                if (zza2 == null || zza2.first == null) {
                    this.zzd.zzq().zzf().zza("Extra parameter without existing main event. eventName, eventId", zzc, l);
                    return null;
                }
                this.zza = (zzcd.zzc) zza2.first;
                this.zzc = ((Long) zza2.second).longValue();
                this.zzd.mo331f_();
                this.zzb = (Long) zzkr.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzaf zzi = this.zzd.zzi();
                zzi.zzc();
                zzi.zzq().zzw().zza("Clearing complex main event info. appId", str);
                try {
                    zzi.m334c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzi.zzq().zze().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzcd.zze zzeVar : this.zza.zza()) {
                this.zzd.mo331f_();
                if (zzkr.zza(zzcVar, zzeVar.zzb()) == null) {
                    arrayList.add(zzeVar);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza);
                zza = arrayList;
            } else {
                this.zzd.zzq().zzf().zza("No unique parameters in main event. eventName", zzc);
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzcVar;
            this.zzd.mo331f_();
            Object zzb = zzkr.zzb(zzcVar, "_epc");
            long longValue = ((Long) (zzb != null ? zzb : 0L)).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzq().zzf().zza("Complex event with zero extra param count. eventName", zzc);
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, zzcVar);
            }
        }
        return (zzcd.zzc) ((com.google.android.gms.internal.measurement.zzhy) zzcVar.zzbo().zza(zzc).zzc().zza(zza).zzy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzs(zzr zzrVar, zzq zzqVar) {
        this(zzrVar);
    }
}
