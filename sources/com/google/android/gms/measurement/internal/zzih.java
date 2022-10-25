package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzih extends zzki {
    public zzih(zzkl zzklVar) {
        super(zzklVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzd() {
        return false;
    }

    public final byte[] zza(zzaq zzaqVar, String str) {
        zzkw zzkwVar;
        Bundle zzb;
        zzcd.zzg.zza zzaVar;
        zzf zzfVar;
        zzcd.zzf.zza zzaVar2;
        Bundle bundle;
        byte[] bArr;
        long j;
        zzam zza;
        zzc();
        this.zzy.zzad();
        Preconditions.checkNotNull(zzaqVar);
        Preconditions.checkNotEmpty(str);
        if (!zzs().zze(str, zzas.zzav)) {
            zzq().zzv().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if (!"_iap".equals(zzaqVar.zza) && !"_iapx".equals(zzaqVar.zza)) {
            zzq().zzv().zza("Generating a payload for this event is not available. package_name, event_name", str, zzaqVar.zza);
            return null;
        } else {
            zzcd.zzf.zza zzb2 = zzcd.zzf.zzb();
            zzi().zze();
            try {
                zzf zzb3 = zzi().zzb(str);
                if (zzb3 == null) {
                    zzq().zzv().zza("Log and bundle not available. package_name", str);
                    return new byte[0];
                } else if (!zzb3.zzr()) {
                    zzq().zzv().zza("Log and bundle disabled. package_name", str);
                    return new byte[0];
                } else {
                    zzcd.zzg.zza zza2 = zzcd.zzg.zzbh().zza(1).zza("android");
                    if (!TextUtils.isEmpty(zzb3.zzc())) {
                        zza2.zzf(zzb3.zzc());
                    }
                    if (!TextUtils.isEmpty(zzb3.zzn())) {
                        zza2.zze(zzb3.zzn());
                    }
                    if (!TextUtils.isEmpty(zzb3.zzl())) {
                        zza2.zzg(zzb3.zzl());
                    }
                    if (zzb3.zzm() != -2147483648L) {
                        zza2.zzh((int) zzb3.zzm());
                    }
                    zza2.zzf(zzb3.zzo()).zzk(zzb3.zzq());
                    if (zznv.zzb() && zzs().zze(zzb3.zzc(), zzas.zzbi)) {
                        if (!TextUtils.isEmpty(zzb3.zze())) {
                            zza2.zzk(zzb3.zze());
                        } else if (!TextUtils.isEmpty(zzb3.zzg())) {
                            zza2.zzp(zzb3.zzg());
                        } else if (!TextUtils.isEmpty(zzb3.zzf())) {
                            zza2.zzo(zzb3.zzf());
                        }
                    } else if (!TextUtils.isEmpty(zzb3.zze())) {
                        zza2.zzk(zzb3.zze());
                    } else if (!TextUtils.isEmpty(zzb3.zzf())) {
                        zza2.zzo(zzb3.zzf());
                    }
                    zzac zza3 = this.zza.zza(str);
                    zza2.zzh(zzb3.zzp());
                    if (this.zzy.zzaa() && zzs().zzh(zza2.zzj())) {
                        if (zzml.zzb() && zzs().zza(zzas.zzci)) {
                            if (zza3.zzc() && !TextUtils.isEmpty(null)) {
                                zza2.zzn(null);
                            }
                        } else {
                            zza2.zzj();
                            if (!TextUtils.isEmpty(null)) {
                                zza2.zzn(null);
                            }
                        }
                    }
                    if (zzml.zzb() && zzs().zza(zzas.zzci)) {
                        zza2.zzq(zza3.zza());
                    }
                    if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza3.zzc()) {
                        Pair<String, Boolean> zza4 = zzf().zza(zzb3.zzc(), zza3);
                        if (zzb3.zzaf() && zza4 != null && !TextUtils.isEmpty((CharSequence) zza4.first)) {
                            zza2.zzh(zza((String) zza4.first, Long.toString(zzaqVar.zzd)));
                            if (zza4.second != null) {
                                zza2.zza(((Boolean) zza4.second).booleanValue());
                            }
                        }
                    }
                    zzk().zzab();
                    zzcd.zzg.zza zzc = zza2.zzc(Build.MODEL);
                    zzk().zzab();
                    zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzk().zze()).zzd(zzk().zzf());
                    if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza3.zze()) {
                        zza2.zzi(zza(zzb3.zzd(), Long.toString(zzaqVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzb3.zzi())) {
                        zza2.zzl(zzb3.zzi());
                    }
                    String zzc2 = zzb3.zzc();
                    List<zzkw> zza5 = zzi().zza(zzc2);
                    Iterator<zzkw> it = zza5.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzkwVar = null;
                            break;
                        }
                        zzkwVar = it.next();
                        if ("_lte".equals(zzkwVar.zzc)) {
                            break;
                        }
                    }
                    if (zzkwVar == null || zzkwVar.zze == null) {
                        zzkw zzkwVar2 = new zzkw(zzc2, "auto", "_lte", zzl().currentTimeMillis(), 0L);
                        zza5.add(zzkwVar2);
                        zzi().zza(zzkwVar2);
                    }
                    zzkr mo331f_ = mo331f_();
                    mo331f_.zzq().zzw().zza("Checking account type status for ad personalization signals");
                    if (mo331f_.zzk().zzi()) {
                        String zzc3 = zzb3.zzc();
                        if (zzb3.zzaf() && mo331f_.zzj().zze(zzc3)) {
                            mo331f_.zzq().zzv().zza("Turning off ad personalization due to account type");
                            Iterator<zzkw> it2 = zza5.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(it2.next().zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zza5.add(new zzkw(zzc3, "auto", "_npa", mo331f_.zzl().currentTimeMillis(), 1L));
                        }
                    }
                    zzcd.zzk[] zzkVarArr = new zzcd.zzk[zza5.size()];
                    for (int i = 0; i < zza5.size(); i++) {
                        zzcd.zzk.zza zza6 = zzcd.zzk.zzj().zza(zza5.get(i).zzc).zza(zza5.get(i).zzd);
                        mo331f_().zza(zza6, zza5.get(i).zze);
                        zzkVarArr[i] = (zzcd.zzk) ((com.google.android.gms.internal.measurement.zzhy) zza6.zzy());
                    }
                    zza2.zzb(Arrays.asList(zzkVarArr));
                    if (zznw.zzb() && zzs().zza(zzas.zzbz) && zzs().zza(zzas.zzca)) {
                        zzeu zza7 = zzeu.zza(zzaqVar);
                        zzo().zza(zza7.zzb, zzi().zzi(str));
                        zzo().zza(zza7, zzs().zza(str));
                        zzb = zza7.zzb;
                    } else {
                        zzb = zzaqVar.zzb.zzb();
                    }
                    Bundle bundle2 = zzb;
                    bundle2.putLong("_c", 1L);
                    zzq().zzv().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1L);
                    bundle2.putString("_o", zzaqVar.zzc);
                    if (zzo().zze(zza2.zzj())) {
                        zzo().zza(bundle2, "_dbg", (Object) 1L);
                        zzo().zza(bundle2, "_r", (Object) 1L);
                    }
                    zzam zza8 = zzi().zza(str, zzaqVar.zza);
                    if (zza8 == null) {
                        zzfVar = zzb3;
                        zzaVar = zza2;
                        zzaVar2 = zzb2;
                        bundle = bundle2;
                        bArr = null;
                        zza = new zzam(str, zzaqVar.zza, 0L, 0L, zzaqVar.zzd, 0L, null, null, null, null);
                        j = 0;
                    } else {
                        zzaVar = zza2;
                        zzfVar = zzb3;
                        zzaVar2 = zzb2;
                        bundle = bundle2;
                        bArr = null;
                        j = zza8.zzf;
                        zza = zza8.zza(zzaqVar.zzd);
                    }
                    zzi().zza(zza);
                    zzan zzanVar = new zzan(this.zzy, zzaqVar.zzc, str, zzaqVar.zza, zzaqVar.zzd, j, bundle);
                    zzcd.zzc.zza zzb4 = zzcd.zzc.zzj().zza(zzanVar.zzc).zza(zzanVar.zzb).zzb(zzanVar.zzd);
                    Iterator<String> it3 = zzanVar.zze.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        zzcd.zze.zza zza9 = zzcd.zze.zzm().zza(next);
                        mo331f_().zza(zza9, zzanVar.zze.zza(next));
                        zzb4.zza(zza9);
                    }
                    zzcd.zzg.zza zzaVar3 = zzaVar;
                    zzaVar3.zza(zzb4).zza(zzcd.zzh.zza().zza(zzcd.zzd.zza().zza(zza.zzc).zza(zzaqVar.zza)));
                    zzaVar3.zzc(zzh().zza(zzfVar.zzc(), Collections.emptyList(), zzaVar3.zzd(), Long.valueOf(zzb4.zzf()), Long.valueOf(zzb4.zzf())));
                    if (zzb4.zze()) {
                        zzaVar3.zzb(zzb4.zzf()).zzc(zzb4.zzf());
                    }
                    long zzk = zzfVar.zzk();
                    int i2 = (zzk > 0L ? 1 : (zzk == 0L ? 0 : -1));
                    if (i2 != 0) {
                        zzaVar3.zze(zzk);
                    }
                    long zzj = zzfVar.zzj();
                    if (zzj != 0) {
                        zzaVar3.zzd(zzj);
                    } else if (i2 != 0) {
                        zzaVar3.zzd(zzk);
                    }
                    zzfVar.zzv();
                    zzcd.zzg.zza zza10 = zzaVar3.zzg((int) zzfVar.zzs()).zzg(33025L).zza(zzl().currentTimeMillis());
                    Boolean bool = Boolean.TRUE;
                    zza10.zzb(true);
                    zzcd.zzf.zza zzaVar4 = zzaVar2;
                    zzaVar4.zza(zzaVar3);
                    zzf zzfVar2 = zzfVar;
                    zzfVar2.zza(zzaVar3.zzf());
                    zzfVar2.zzb(zzaVar3.zzg());
                    zzi().zza(zzfVar2);
                    zzi().m335b_();
                    try {
                        return mo331f_().zzc(((zzcd.zzf) ((com.google.android.gms.internal.measurement.zzhy) zzaVar4.zzy())).zzbk());
                    } catch (IOException e) {
                        zzq().zze().zza("Data loss. Failed to bundle and serialize. appId", zzeq.zza(str), e);
                        return bArr;
                    }
                }
            } catch (SecurityException e2) {
                zzq().zzv().zza("Resettable device id encryption failed", e2.getMessage());
                return new byte[0];
            } catch (SecurityException e3) {
                zzq().zzv().zza("app instance id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzi().zzg();
            }
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
