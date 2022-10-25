package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blankj.utilcode.constant.TimeConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public class zzkl implements zzgt {
    private static volatile zzkl zza;
    private final zzky zzaa;
    private zzfo zzb;
    private zzex zzc;
    private zzaf zzd;
    private zzfa zze;
    private zzkh zzf;
    private zzr zzg;
    private final zzkr zzh;
    private zzih zzi;
    private zzjr zzj;
    private final zzfu zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzac> zzz;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* loaded from: classes3.dex */
    public class zza implements zzah {
        zzcd.zzg zza;
        List<Long> zzb;
        List<zzcd.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final void zza(zzcd.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.zza = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final boolean zza(long j, zzcd.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() <= 0 || zza(this.zzc.get(0)) == zza(zzcVar)) {
                long zzbp = this.zzd + zzcVar.zzbp();
                if (zzbp >= Math.max(0, zzas.zzh.zza(null).intValue())) {
                    return false;
                }
                this.zzd = zzbp;
                this.zzc.add(zzcVar);
                this.zzb.add(Long.valueOf(j));
                return this.zzc.size() < Math.max(1, zzas.zzi.zza(null).intValue());
            }
            return false;
        }

        private static long zza(zzcd.zzc zzcVar) {
            return ((zzcVar.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkl zzklVar, zzkk zzkkVar) {
            this();
        }
    }

    public static zzkl zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkl.class) {
                if (zza == null) {
                    zza = new zzkl(new zzks(context));
                }
            }
        }
        return zza;
    }

    private zzkl(zzks zzksVar) {
        this(zzksVar, null);
    }

    private zzkl(zzks zzksVar, zzfu zzfuVar) {
        this.zzl = false;
        this.zzaa = new zzko(this);
        Preconditions.checkNotNull(zzksVar);
        zzfu zza2 = zzfu.zza(zzksVar.zza, null, null);
        this.zzk = zza2;
        this.zzy = -1L;
        zzkr zzkrVar = new zzkr(this);
        zzkrVar.zzak();
        this.zzh = zzkrVar;
        zzex zzexVar = new zzex(this);
        zzexVar.zzak();
        this.zzc = zzexVar;
        zzfo zzfoVar = new zzfo(this);
        zzfoVar.zzak();
        this.zzb = zzfoVar;
        this.zzz = new HashMap();
        zza2.zzp().zza(new zzkk(this, zzksVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzks zzksVar) {
        this.zzk.zzp().zzc();
        zzaf zzafVar = new zzaf(this);
        zzafVar.zzak();
        this.zzd = zzafVar;
        this.zzk.zza().zza(this.zzb);
        zzjr zzjrVar = new zzjr(this);
        zzjrVar.zzak();
        this.zzj = zzjrVar;
        zzr zzrVar = new zzr(this);
        zzrVar.zzak();
        this.zzg = zzrVar;
        zzih zzihVar = new zzih(this);
        zzihVar.zzak();
        this.zzi = zzihVar;
        zzkh zzkhVar = new zzkh(this);
        zzkhVar.zzak();
        this.zzf = zzkhVar;
        this.zze = new zzfa(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzk.zzt();
    }

    public final zzab zzb() {
        return this.zzk.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        return this.zzk.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        return this.zzk.zzp();
    }

    public final zzfo zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzex zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzaf zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfa zzv() {
        zzfa zzfaVar = this.zze;
        if (zzfaVar != null) {
            return zzfaVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkh zzw() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzr zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzih zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzjr zzi() {
        return this.zzj;
    }

    public final zzeo zzj() {
        return this.zzk.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzk.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzk.zzl();
    }

    public final zzkv zzk() {
        return this.zzk.zzh();
    }

    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzki zzkiVar) {
        if (zzkiVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkiVar.zzai()) {
            return;
        }
        String valueOf = String.valueOf(zzkiVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, zzac zzacVar) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            this.zzz.put(str, zzacVar);
            zzaf zze = zze();
            if (zzml.zzb() && zze.zzs().zza(zzas.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzacVar);
                zze.zzc();
                zze.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzacVar.zza());
                try {
                    if (zze.m334c_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        zze.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzeq.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze.zzq().zze().zza("Error storing consent setting. appId, error", zzeq.zza(str), e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzac zza(String str) {
        zzac zzacVar = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            zzacVar = this.zzz.get(str);
            if (zzacVar == null) {
                zzacVar = zze().zzj(str);
                if (zzacVar == null) {
                    zzacVar = zzac.zza;
                }
                zza(str, zzacVar);
            }
        }
        return zzacVar;
    }

    private final long zzy() {
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfc zzb = this.zzk.zzb();
        zzb.zzab();
        zzb.zzc();
        long zza2 = zzb.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + zzb.zzo().zzg().nextInt(TimeConstants.DAY);
            zzb.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzaq zzaqVar, String str) {
        boolean z;
        String str2;
        zzf zzb = zze().zzb(str);
        if (zzb == null || TextUtils.isEmpty(zzb.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb2 = zzb(zzb);
        if (zzb2 == null) {
            if (!"_ui".equals(zzaqVar.zza)) {
                this.zzk.zzq().zzh().zza("Could not find package. appId", zzeq.zza(str));
            }
        } else if (!zzb2.booleanValue()) {
            this.zzk.zzq().zze().zza("App version does not match; dropping event. appId", zzeq.zza(str));
            return;
        }
        String zze = zzb.zze();
        String zzl = zzb.zzl();
        long zzm = zzb.zzm();
        String zzn = zzb.zzn();
        long zzo = zzb.zzo();
        long zzp = zzb.zzp();
        boolean zzr = zzb.zzr();
        String zzi = zzb.zzi();
        long zzae = zzb.zzae();
        boolean zzaf = zzb.zzaf();
        boolean zzag = zzb.zzag();
        String zzf = zzb.zzf();
        Boolean zzah = zzb.zzah();
        long zzq = zzb.zzq();
        List<String> zzai = zzb.zzai();
        if (zznv.zzb()) {
            z = zzr;
            if (this.zzk.zza().zze(zzb.zzc(), zzas.zzbi)) {
                str2 = zzb.zzg();
                zzb(zzaqVar, new zzn(str, zze, zzl, zzm, zzn, zzo, zzp, (String) null, z, false, zzi, zzae, 0L, 0, zzaf, zzag, false, zzf, zzah, zzq, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
            }
        } else {
            z = zzr;
        }
        str2 = null;
        zzb(zzaqVar, new zzn(str, zze, zzl, zzm, zzn, zzo, zzp, (String) null, z, false, zzi, zzae, 0L, 0, zzaf, zzag, false, zzf, zzah, zzq, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
    }

    private final void zzb(zzaq zzaqVar, zzn zznVar) {
        if (zznw.zzb() && this.zzk.zza().zza(zzas.zzbz)) {
            zzeu zza2 = zzeu.zza(zzaqVar);
            this.zzk.zzh().zza(zza2.zzb, zze().zzi(zznVar.zza));
            this.zzk.zzh().zza(zza2, this.zzk.zza().zza(zznVar.zza));
            zzaqVar = zza2.zza();
        }
        if (this.zzk.zza().zza(zzas.zzbd) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaqVar.zza) && "referrer API v2".equals(zzaqVar.zzb.zzd("_cis"))) {
            String zzd = zzaqVar.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd)) {
                zza(new zzku("_lgclid", zzaqVar.zzd, zzd, "auto"), zznVar);
            }
        }
        zza(zzaqVar, zznVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzaq zzaqVar, zzn zznVar) {
        List<zzz> zza2;
        List<zzz> zza3;
        List<zzz> zza4;
        zzaq zzaqVar2 = zzaqVar;
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zzx();
        zzn();
        String str = zznVar.zza;
        long j = zzaqVar2.zzd;
        zzh();
        if (zzkr.zza(zzaqVar, zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            if (zznVar.zzu != null) {
                if (zznVar.zzu.contains(zzaqVar2.zza)) {
                    Bundle zzb = zzaqVar2.zzb.zzb();
                    zzb.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.zza, new zzap(zzb), zzaqVar2.zzc, zzaqVar2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.zza, zzaqVar2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzaf zze = zze();
                Preconditions.checkNotEmpty(str);
                zze.zzc();
                zze.zzaj();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    zze.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzeq.zza(str), Long.valueOf(j));
                    zza2 = Collections.emptyList();
                } else {
                    zza2 = zze.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzzVar : zza2) {
                    if (zzzVar != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", zzzVar.zza, this.zzk.zzi().zzc(zzzVar.zzc.zza), zzzVar.zzc.zza());
                        if (zzzVar.zzg != null) {
                            zzc(new zzaq(zzzVar.zzg, j), zznVar);
                        }
                        zze().zze(str, zzzVar.zzc.zza);
                    }
                }
                zzaf zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzc();
                zze2.zzaj();
                if (i < 0) {
                    zze2.zzq().zzh().zza("Invalid time querying expired conditional properties", zzeq.zza(str), Long.valueOf(j));
                    zza3 = Collections.emptyList();
                } else {
                    zza3 = zze2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(zza3.size());
                for (zzz zzzVar2 : zza3) {
                    if (zzzVar2 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", zzzVar2.zza, this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                        zze().zzb(str, zzzVar2.zzc.zza);
                        if (zzzVar2.zzk != null) {
                            arrayList.add(zzzVar2.zzk);
                        }
                        zze().zze(str, zzzVar2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzc(new zzaq((zzaq) obj, j), zznVar);
                }
                zzaf zze3 = zze();
                String str2 = zzaqVar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze3.zzc();
                zze3.zzaj();
                if (i < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzeq.zza(str), zze3.zzn().zza(str2), Long.valueOf(j));
                    zza4 = Collections.emptyList();
                } else {
                    zza4 = zze3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(zza4.size());
                for (zzz zzzVar3 : zza4) {
                    if (zzzVar3 != null) {
                        zzku zzkuVar = zzzVar3.zzc;
                        zzkw zzkwVar = new zzkw(zzzVar3.zza, zzzVar3.zzb, zzkuVar.zza, j, zzkuVar.zza());
                        if (zze().zza(zzkwVar)) {
                            this.zzk.zzq().zzw().zza("User property triggered", zzzVar3.zza, this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                        } else {
                            this.zzk.zzq().zze().zza("Too many active user properties, ignoring", zzeq.zza(zzzVar3.zza), this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                        }
                        if (zzzVar3.zzi != null) {
                            arrayList3.add(zzzVar3.zzi);
                        }
                        zzzVar3.zzc = new zzku(zzkwVar);
                        zzzVar3.zze = true;
                        zze().zza(zzzVar3);
                    }
                }
                zzc(zzaqVar2, zznVar);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzaq((zzaq) obj2, j), zznVar);
                }
                zze().m335b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:74|(1:76)(1:304)|77|(6:82|83|84|(1:86)|87|(0))|296|297|298|299|83|84|(0)|87|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0282, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0284, code lost:
        r7.zzq().zze().zza("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzeq.zza(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0352 A[Catch: all -> 0x09bf, TryCatch #2 {all -> 0x09bf, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:66:0x01ae, B:71:0x01e3, B:73:0x01e9, B:75:0x01f7, B:77:0x0203, B:79:0x020d, B:81:0x0218, B:84:0x021f, B:93:0x02b0, B:95:0x02ba, B:99:0x02f3, B:103:0x0305, B:105:0x0352, B:107:0x0357, B:108:0x0370, B:112:0x0381, B:114:0x0395, B:116:0x039a, B:117:0x03b3, B:121:0x03d8, B:125:0x03fd, B:126:0x0416, B:129:0x0425, B:132:0x0448, B:133:0x0464, B:135:0x046e, B:137:0x047a, B:139:0x0480, B:140:0x048b, B:142:0x0497, B:143:0x04ae, B:145:0x04d5, B:148:0x04ee, B:151:0x0534, B:153:0x055c, B:155:0x0596, B:156:0x059b, B:158:0x05a3, B:159:0x05a8, B:161:0x05b0, B:162:0x05b5, B:164:0x05be, B:165:0x05c4, B:167:0x05d1, B:168:0x05d6, B:170:0x05dc, B:172:0x05ea, B:173:0x0601, B:175:0x0607, B:177:0x0617, B:179:0x0621, B:181:0x0629, B:182:0x062e, B:184:0x0638, B:186:0x0642, B:188:0x064a, B:194:0x0667, B:196:0x066f, B:197:0x0674, B:199:0x0683, B:200:0x0686, B:202:0x069c, B:204:0x06aa, B:230:0x0758, B:232:0x07a0, B:233:0x07a5, B:235:0x07ad, B:237:0x07b3, B:239:0x07c1, B:241:0x07c8, B:243:0x07ce, B:240:0x07c5, B:244:0x07d3, B:246:0x07df, B:248:0x07ee, B:250:0x07fc, B:252:0x080b, B:254:0x081b, B:256:0x0829, B:259:0x083a, B:261:0x086f, B:262:0x0874, B:258:0x082f, B:251:0x0804, B:263:0x0880, B:265:0x0886, B:267:0x0894, B:272:0x08ab, B:274:0x08b5, B:275:0x08bc, B:276:0x08c7, B:278:0x08cd, B:280:0x08fe, B:281:0x090e, B:283:0x0916, B:284:0x091c, B:286:0x0922, B:295:0x096a, B:297:0x0970, B:300:0x098c, B:289:0x0930, B:291:0x0955, B:299:0x0974, B:269:0x089a, B:271:0x08a4, B:206:0x06b0, B:208:0x06ba, B:210:0x06c4, B:212:0x06c8, B:214:0x06d3, B:215:0x06e0, B:217:0x06f2, B:219:0x06f6, B:221:0x06fc, B:223:0x070c, B:225:0x071e, B:229:0x0755, B:226:0x0738, B:228:0x073e, B:189:0x0650, B:191:0x065a, B:193:0x0662, B:152:0x054e, B:86:0x0249, B:87:0x0267, B:92:0x0295, B:91:0x0284, B:78:0x0208, B:69:0x01bc, B:70:0x01d9), top: B:310:0x013b, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0970 A[Catch: all -> 0x09bf, TryCatch #2 {all -> 0x09bf, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:66:0x01ae, B:71:0x01e3, B:73:0x01e9, B:75:0x01f7, B:77:0x0203, B:79:0x020d, B:81:0x0218, B:84:0x021f, B:93:0x02b0, B:95:0x02ba, B:99:0x02f3, B:103:0x0305, B:105:0x0352, B:107:0x0357, B:108:0x0370, B:112:0x0381, B:114:0x0395, B:116:0x039a, B:117:0x03b3, B:121:0x03d8, B:125:0x03fd, B:126:0x0416, B:129:0x0425, B:132:0x0448, B:133:0x0464, B:135:0x046e, B:137:0x047a, B:139:0x0480, B:140:0x048b, B:142:0x0497, B:143:0x04ae, B:145:0x04d5, B:148:0x04ee, B:151:0x0534, B:153:0x055c, B:155:0x0596, B:156:0x059b, B:158:0x05a3, B:159:0x05a8, B:161:0x05b0, B:162:0x05b5, B:164:0x05be, B:165:0x05c4, B:167:0x05d1, B:168:0x05d6, B:170:0x05dc, B:172:0x05ea, B:173:0x0601, B:175:0x0607, B:177:0x0617, B:179:0x0621, B:181:0x0629, B:182:0x062e, B:184:0x0638, B:186:0x0642, B:188:0x064a, B:194:0x0667, B:196:0x066f, B:197:0x0674, B:199:0x0683, B:200:0x0686, B:202:0x069c, B:204:0x06aa, B:230:0x0758, B:232:0x07a0, B:233:0x07a5, B:235:0x07ad, B:237:0x07b3, B:239:0x07c1, B:241:0x07c8, B:243:0x07ce, B:240:0x07c5, B:244:0x07d3, B:246:0x07df, B:248:0x07ee, B:250:0x07fc, B:252:0x080b, B:254:0x081b, B:256:0x0829, B:259:0x083a, B:261:0x086f, B:262:0x0874, B:258:0x082f, B:251:0x0804, B:263:0x0880, B:265:0x0886, B:267:0x0894, B:272:0x08ab, B:274:0x08b5, B:275:0x08bc, B:276:0x08c7, B:278:0x08cd, B:280:0x08fe, B:281:0x090e, B:283:0x0916, B:284:0x091c, B:286:0x0922, B:295:0x096a, B:297:0x0970, B:300:0x098c, B:289:0x0930, B:291:0x0955, B:299:0x0974, B:269:0x089a, B:271:0x08a4, B:206:0x06b0, B:208:0x06ba, B:210:0x06c4, B:212:0x06c8, B:214:0x06d3, B:215:0x06e0, B:217:0x06f2, B:219:0x06f6, B:221:0x06fc, B:223:0x070c, B:225:0x071e, B:229:0x0755, B:226:0x0738, B:228:0x073e, B:189:0x0650, B:191:0x065a, B:193:0x0662, B:152:0x054e, B:86:0x0249, B:87:0x0267, B:92:0x0295, B:91:0x0284, B:78:0x0208, B:69:0x01bc, B:70:0x01d9), top: B:310:0x013b, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172 A[Catch: all -> 0x09bf, TRY_LEAVE, TryCatch #2 {all -> 0x09bf, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:66:0x01ae, B:71:0x01e3, B:73:0x01e9, B:75:0x01f7, B:77:0x0203, B:79:0x020d, B:81:0x0218, B:84:0x021f, B:93:0x02b0, B:95:0x02ba, B:99:0x02f3, B:103:0x0305, B:105:0x0352, B:107:0x0357, B:108:0x0370, B:112:0x0381, B:114:0x0395, B:116:0x039a, B:117:0x03b3, B:121:0x03d8, B:125:0x03fd, B:126:0x0416, B:129:0x0425, B:132:0x0448, B:133:0x0464, B:135:0x046e, B:137:0x047a, B:139:0x0480, B:140:0x048b, B:142:0x0497, B:143:0x04ae, B:145:0x04d5, B:148:0x04ee, B:151:0x0534, B:153:0x055c, B:155:0x0596, B:156:0x059b, B:158:0x05a3, B:159:0x05a8, B:161:0x05b0, B:162:0x05b5, B:164:0x05be, B:165:0x05c4, B:167:0x05d1, B:168:0x05d6, B:170:0x05dc, B:172:0x05ea, B:173:0x0601, B:175:0x0607, B:177:0x0617, B:179:0x0621, B:181:0x0629, B:182:0x062e, B:184:0x0638, B:186:0x0642, B:188:0x064a, B:194:0x0667, B:196:0x066f, B:197:0x0674, B:199:0x0683, B:200:0x0686, B:202:0x069c, B:204:0x06aa, B:230:0x0758, B:232:0x07a0, B:233:0x07a5, B:235:0x07ad, B:237:0x07b3, B:239:0x07c1, B:241:0x07c8, B:243:0x07ce, B:240:0x07c5, B:244:0x07d3, B:246:0x07df, B:248:0x07ee, B:250:0x07fc, B:252:0x080b, B:254:0x081b, B:256:0x0829, B:259:0x083a, B:261:0x086f, B:262:0x0874, B:258:0x082f, B:251:0x0804, B:263:0x0880, B:265:0x0886, B:267:0x0894, B:272:0x08ab, B:274:0x08b5, B:275:0x08bc, B:276:0x08c7, B:278:0x08cd, B:280:0x08fe, B:281:0x090e, B:283:0x0916, B:284:0x091c, B:286:0x0922, B:295:0x096a, B:297:0x0970, B:300:0x098c, B:289:0x0930, B:291:0x0955, B:299:0x0974, B:269:0x089a, B:271:0x08a4, B:206:0x06b0, B:208:0x06ba, B:210:0x06c4, B:212:0x06c8, B:214:0x06d3, B:215:0x06e0, B:217:0x06f2, B:219:0x06f6, B:221:0x06fc, B:223:0x070c, B:225:0x071e, B:229:0x0755, B:226:0x0738, B:228:0x073e, B:189:0x0650, B:191:0x065a, B:193:0x0662, B:152:0x054e, B:86:0x0249, B:87:0x0267, B:92:0x0295, B:91:0x0284, B:78:0x0208, B:69:0x01bc, B:70:0x01d9), top: B:310:0x013b, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ba A[Catch: all -> 0x09bf, TryCatch #2 {all -> 0x09bf, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:66:0x01ae, B:71:0x01e3, B:73:0x01e9, B:75:0x01f7, B:77:0x0203, B:79:0x020d, B:81:0x0218, B:84:0x021f, B:93:0x02b0, B:95:0x02ba, B:99:0x02f3, B:103:0x0305, B:105:0x0352, B:107:0x0357, B:108:0x0370, B:112:0x0381, B:114:0x0395, B:116:0x039a, B:117:0x03b3, B:121:0x03d8, B:125:0x03fd, B:126:0x0416, B:129:0x0425, B:132:0x0448, B:133:0x0464, B:135:0x046e, B:137:0x047a, B:139:0x0480, B:140:0x048b, B:142:0x0497, B:143:0x04ae, B:145:0x04d5, B:148:0x04ee, B:151:0x0534, B:153:0x055c, B:155:0x0596, B:156:0x059b, B:158:0x05a3, B:159:0x05a8, B:161:0x05b0, B:162:0x05b5, B:164:0x05be, B:165:0x05c4, B:167:0x05d1, B:168:0x05d6, B:170:0x05dc, B:172:0x05ea, B:173:0x0601, B:175:0x0607, B:177:0x0617, B:179:0x0621, B:181:0x0629, B:182:0x062e, B:184:0x0638, B:186:0x0642, B:188:0x064a, B:194:0x0667, B:196:0x066f, B:197:0x0674, B:199:0x0683, B:200:0x0686, B:202:0x069c, B:204:0x06aa, B:230:0x0758, B:232:0x07a0, B:233:0x07a5, B:235:0x07ad, B:237:0x07b3, B:239:0x07c1, B:241:0x07c8, B:243:0x07ce, B:240:0x07c5, B:244:0x07d3, B:246:0x07df, B:248:0x07ee, B:250:0x07fc, B:252:0x080b, B:254:0x081b, B:256:0x0829, B:259:0x083a, B:261:0x086f, B:262:0x0874, B:258:0x082f, B:251:0x0804, B:263:0x0880, B:265:0x0886, B:267:0x0894, B:272:0x08ab, B:274:0x08b5, B:275:0x08bc, B:276:0x08c7, B:278:0x08cd, B:280:0x08fe, B:281:0x090e, B:283:0x0916, B:284:0x091c, B:286:0x0922, B:295:0x096a, B:297:0x0970, B:300:0x098c, B:289:0x0930, B:291:0x0955, B:299:0x0974, B:269:0x089a, B:271:0x08a4, B:206:0x06b0, B:208:0x06ba, B:210:0x06c4, B:212:0x06c8, B:214:0x06d3, B:215:0x06e0, B:217:0x06f2, B:219:0x06f6, B:221:0x06fc, B:223:0x070c, B:225:0x071e, B:229:0x0755, B:226:0x0738, B:228:0x073e, B:189:0x0650, B:191:0x065a, B:193:0x0662, B:152:0x054e, B:86:0x0249, B:87:0x0267, B:92:0x0295, B:91:0x0284, B:78:0x0208, B:69:0x01bc, B:70:0x01d9), top: B:310:0x013b, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02f3 A[Catch: all -> 0x09bf, TRY_LEAVE, TryCatch #2 {all -> 0x09bf, blocks: (B:39:0x013b, B:42:0x014a, B:44:0x0154, B:49:0x0160, B:56:0x0172, B:59:0x017e, B:61:0x0195, B:66:0x01ae, B:71:0x01e3, B:73:0x01e9, B:75:0x01f7, B:77:0x0203, B:79:0x020d, B:81:0x0218, B:84:0x021f, B:93:0x02b0, B:95:0x02ba, B:99:0x02f3, B:103:0x0305, B:105:0x0352, B:107:0x0357, B:108:0x0370, B:112:0x0381, B:114:0x0395, B:116:0x039a, B:117:0x03b3, B:121:0x03d8, B:125:0x03fd, B:126:0x0416, B:129:0x0425, B:132:0x0448, B:133:0x0464, B:135:0x046e, B:137:0x047a, B:139:0x0480, B:140:0x048b, B:142:0x0497, B:143:0x04ae, B:145:0x04d5, B:148:0x04ee, B:151:0x0534, B:153:0x055c, B:155:0x0596, B:156:0x059b, B:158:0x05a3, B:159:0x05a8, B:161:0x05b0, B:162:0x05b5, B:164:0x05be, B:165:0x05c4, B:167:0x05d1, B:168:0x05d6, B:170:0x05dc, B:172:0x05ea, B:173:0x0601, B:175:0x0607, B:177:0x0617, B:179:0x0621, B:181:0x0629, B:182:0x062e, B:184:0x0638, B:186:0x0642, B:188:0x064a, B:194:0x0667, B:196:0x066f, B:197:0x0674, B:199:0x0683, B:200:0x0686, B:202:0x069c, B:204:0x06aa, B:230:0x0758, B:232:0x07a0, B:233:0x07a5, B:235:0x07ad, B:237:0x07b3, B:239:0x07c1, B:241:0x07c8, B:243:0x07ce, B:240:0x07c5, B:244:0x07d3, B:246:0x07df, B:248:0x07ee, B:250:0x07fc, B:252:0x080b, B:254:0x081b, B:256:0x0829, B:259:0x083a, B:261:0x086f, B:262:0x0874, B:258:0x082f, B:251:0x0804, B:263:0x0880, B:265:0x0886, B:267:0x0894, B:272:0x08ab, B:274:0x08b5, B:275:0x08bc, B:276:0x08c7, B:278:0x08cd, B:280:0x08fe, B:281:0x090e, B:283:0x0916, B:284:0x091c, B:286:0x0922, B:295:0x096a, B:297:0x0970, B:300:0x098c, B:289:0x0930, B:291:0x0955, B:299:0x0974, B:269:0x089a, B:271:0x08a4, B:206:0x06b0, B:208:0x06ba, B:210:0x06c4, B:212:0x06c8, B:214:0x06d3, B:215:0x06e0, B:217:0x06f2, B:219:0x06f6, B:221:0x06fc, B:223:0x070c, B:225:0x071e, B:229:0x0755, B:226:0x0738, B:228:0x073e, B:189:0x0650, B:191:0x065a, B:193:0x0662, B:152:0x054e, B:86:0x0249, B:87:0x0267, B:92:0x0295, B:91:0x0284, B:78:0x0208, B:69:0x01bc, B:70:0x01d9), top: B:310:0x013b, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzc(com.google.android.gms.measurement.internal.zzaq r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            Method dump skipped, instructions count: 2505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzc(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final String zza(zzac zzacVar) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zzacVar.zze()) {
            return null;
        }
        return zzz();
    }

    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c4 A[Catch: all -> 0x03b0, TryCatch #0 {all -> 0x03b0, blocks: (B:3:0x000c, B:5:0x0018, B:8:0x002d, B:10:0x0033, B:13:0x0048, B:15:0x0050, B:18:0x0059, B:23:0x0065, B:26:0x007a, B:28:0x0084, B:31:0x009c, B:33:0x00bc, B:35:0x00c2, B:36:0x00c5, B:38:0x00d5, B:39:0x00ee, B:41:0x00fe, B:43:0x0104, B:44:0x010e, B:46:0x0138, B:48:0x013e, B:50:0x014c, B:69:0x01a9, B:71:0x01c6, B:73:0x01cc, B:75:0x01da, B:79:0x01e7, B:81:0x01ed, B:83:0x01fb, B:88:0x0209, B:90:0x020f, B:92:0x021d, B:99:0x022e, B:101:0x0261, B:102:0x0264, B:104:0x026a, B:107:0x027a, B:109:0x0282, B:110:0x0285, B:112:0x0293, B:113:0x02aa, B:114:0x02b5, B:116:0x02c4, B:118:0x02d6, B:119:0x02ee, B:123:0x02fc, B:125:0x0303, B:127:0x031c, B:129:0x032b, B:130:0x0333, B:126:0x0313, B:132:0x0374, B:52:0x0156, B:53:0x015a, B:55:0x0160, B:57:0x0174, B:61:0x017d, B:63:0x0183, B:65:0x0197, B:67:0x01a1, B:68:0x01a6, B:133:0x0388, B:135:0x039d, B:137:0x03a7), top: B:143:0x000c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0303 A[Catch: MalformedURLException -> 0x0374, all -> 0x03b0, TryCatch #1 {MalformedURLException -> 0x0374, blocks: (B:119:0x02ee, B:123:0x02fc, B:125:0x0303, B:127:0x031c, B:129:0x032b, B:130:0x0333, B:126:0x0313), top: B:144:0x02ee, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0313 A[Catch: MalformedURLException -> 0x0374, all -> 0x03b0, TryCatch #1 {MalformedURLException -> 0x0374, blocks: (B:119:0x02ee, B:123:0x02fc, B:125:0x0303, B:127:0x031c, B:129:0x032b, B:130:0x0333, B:126:0x0313), top: B:144:0x02ee, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032b A[Catch: MalformedURLException -> 0x0374, all -> 0x03b0, TryCatch #1 {MalformedURLException -> 0x0374, blocks: (B:119:0x02ee, B:123:0x02fc, B:125:0x0303, B:127:0x031c, B:129:0x032b, B:130:0x0333, B:126:0x0313), top: B:144:0x02ee, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022e A[Catch: all -> 0x03b0, TryCatch #0 {all -> 0x03b0, blocks: (B:3:0x000c, B:5:0x0018, B:8:0x002d, B:10:0x0033, B:13:0x0048, B:15:0x0050, B:18:0x0059, B:23:0x0065, B:26:0x007a, B:28:0x0084, B:31:0x009c, B:33:0x00bc, B:35:0x00c2, B:36:0x00c5, B:38:0x00d5, B:39:0x00ee, B:41:0x00fe, B:43:0x0104, B:44:0x010e, B:46:0x0138, B:48:0x013e, B:50:0x014c, B:69:0x01a9, B:71:0x01c6, B:73:0x01cc, B:75:0x01da, B:79:0x01e7, B:81:0x01ed, B:83:0x01fb, B:88:0x0209, B:90:0x020f, B:92:0x021d, B:99:0x022e, B:101:0x0261, B:102:0x0264, B:104:0x026a, B:107:0x027a, B:109:0x0282, B:110:0x0285, B:112:0x0293, B:113:0x02aa, B:114:0x02b5, B:116:0x02c4, B:118:0x02d6, B:119:0x02ee, B:123:0x02fc, B:125:0x0303, B:127:0x031c, B:129:0x032b, B:130:0x0333, B:126:0x0313, B:132:0x0374, B:52:0x0156, B:53:0x015a, B:55:0x0160, B:57:0x0174, B:61:0x017d, B:63:0x0183, B:65:0x0197, B:67:0x01a1, B:68:0x01a6, B:133:0x0388, B:135:0x039d, B:137:0x03a7), top: B:143:0x000c, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzo() {
        /*
            Method dump skipped, instructions count: 951
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzo():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0275 A[Catch: all -> 0x1030, TRY_ENTER, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x027c A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028a A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0666 A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x073d A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x08d3 A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x08e3 A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x08fd A[Catch: all -> 0x1030, TryCatch #6 {all -> 0x1030, blocks: (B:3:0x000f, B:18:0x0081, B:115:0x0278, B:117:0x027c, B:123:0x028a, B:124:0x02b3, B:127:0x02cb, B:130:0x02f3, B:132:0x032a, B:138:0x0340, B:140:0x034a, B:340:0x094c, B:142:0x0374, B:144:0x037a, B:146:0x0390, B:148:0x039e, B:151:0x03be, B:153:0x03c4, B:155:0x03d4, B:157:0x03e2, B:159:0x03f2, B:160:0x0401, B:162:0x0406, B:165:0x041c, B:195:0x0480, B:198:0x048a, B:200:0x0498, B:205:0x04ea, B:201:0x04b9, B:203:0x04c7, B:209:0x04f7, B:212:0x052c, B:213:0x055a, B:215:0x058e, B:217:0x0594, B:239:0x0666, B:240:0x0672, B:243:0x067c, B:249:0x069f, B:246:0x068e, B:252:0x06a5, B:254:0x06b1, B:256:0x06bd, B:272:0x070c, B:275:0x0729, B:277:0x073d, B:279:0x0747, B:282:0x075a, B:284:0x076e, B:286:0x077c, B:330:0x08d3, B:332:0x08dd, B:334:0x08e3, B:335:0x08fd, B:337:0x0910, B:338:0x092a, B:339:0x0932, B:291:0x079a, B:293:0x07a8, B:296:0x07bd, B:298:0x07d1, B:300:0x07df, B:303:0x07f1, B:305:0x0809, B:307:0x0815, B:310:0x0828, B:312:0x083c, B:314:0x0887, B:316:0x088e, B:318:0x0894, B:320:0x089e, B:322:0x08a5, B:324:0x08ab, B:326:0x08b5, B:327:0x08c5, B:260:0x06de, B:264:0x06f2, B:266:0x06f8, B:269:0x0703, B:220:0x05a0, B:222:0x05d5, B:223:0x05f2, B:225:0x05f8, B:227:0x0606, B:231:0x061c, B:228:0x0611, B:234:0x0623, B:236:0x062a, B:237:0x0649, B:172:0x043e, B:175:0x0448, B:178:0x0452, B:345:0x0968, B:347:0x0976, B:349:0x097f, B:360:0x09b1, B:350:0x0987, B:352:0x0990, B:354:0x0996, B:357:0x09a2, B:359:0x09ac, B:363:0x09b8, B:364:0x09c4, B:366:0x09ca, B:372:0x09e3, B:373:0x09ee, B:378:0x09fb, B:382:0x0a22, B:384:0x0a41, B:386:0x0a4f, B:388:0x0a55, B:390:0x0a5f, B:391:0x0a91, B:393:0x0a97, B:395:0x0aa5, B:399:0x0ab0, B:396:0x0aaa, B:400:0x0ab3, B:401:0x0ac2, B:403:0x0ac8, B:405:0x0ad8, B:406:0x0adf, B:408:0x0aeb, B:409:0x0af2, B:410:0x0af5, B:412:0x0afb, B:414:0x0b0d, B:415:0x0b10, B:423:0x0b82, B:425:0x0b9d, B:426:0x0bae, B:428:0x0bb2, B:430:0x0bbe, B:431:0x0bc6, B:433:0x0bca, B:435:0x0bd2, B:436:0x0be0, B:437:0x0beb, B:443:0x0c2c, B:444:0x0c34, B:446:0x0c3a, B:448:0x0c4c, B:450:0x0c50, B:464:0x0c86, B:467:0x0c9c, B:452:0x0c5e, B:454:0x0c62, B:456:0x0c6c, B:458:0x0c70, B:379:0x0a00, B:381:0x0a06, B:52:0x012b, B:71:0x01c8, B:80:0x0202, B:88:0x0222, B:114:0x0275, B:98:0x0245, B:44:0x00e1, B:55:0x0133), top: B:598:0x000f, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0118 A[Catch: SQLiteException -> 0x024c, all -> 0x1024, TRY_LEAVE, TryCatch #0 {all -> 0x1024, blocks: (B:15:0x0079, B:20:0x0085, B:21:0x0089, B:48:0x00f0, B:50:0x0118, B:54:0x012f, B:55:0x0133, B:56:0x0145, B:58:0x014b, B:60:0x0157, B:62:0x0161, B:64:0x016d, B:66:0x0193, B:112:0x0262, B:65:0x0184, B:96:0x0232, B:41:0x00d9, B:46:0x00e8), top: B:591:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x1013  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zza(java.lang.String r43, long r44) {
        /*
            Method dump skipped, instructions count: 4155
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, long):boolean");
    }

    private final void zza(zzcd.zzg.zza zzaVar, long j, boolean z) {
        zzkw zzkwVar;
        String str = z ? "_se" : "_lte";
        zzkw zzc = zze().zzc(zzaVar.zzj(), str);
        if (zzc == null || zzc.zze == null) {
            zzkwVar = new zzkw(zzaVar.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkwVar = new zzkw(zzaVar.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc.zze).longValue() + j));
        }
        zzcd.zzk zzkVar = (zzcd.zzk) ((com.google.android.gms.internal.measurement.zzhy) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzkwVar.zze).longValue()).zzy());
        boolean z2 = false;
        int zza2 = zzkr.zza(zzaVar, str);
        if (zza2 >= 0) {
            zzaVar.zza(zza2, zzkVar);
            z2 = true;
        }
        if (!z2) {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zze().zza(zzkwVar);
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkwVar.zze);
        }
    }

    private final boolean zza(zzcd.zzc.zza zzaVar, zzcd.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzcd.zze zza2 = zzkr.zza((zzcd.zzc) ((com.google.android.gms.internal.measurement.zzhy) zzaVar.zzy()), "_sc");
        String zzd = zza2 == null ? null : zza2.zzd();
        zzh();
        zzcd.zze zza3 = zzkr.zza((zzcd.zzc) ((com.google.android.gms.internal.measurement.zzhy) zzaVar2.zzy()), "_pc");
        String zzd2 = zza3 != null ? zza3.zzd() : null;
        if (zzd2 == null || !zzd2.equals(zzd)) {
            return false;
        }
        zzb(zzaVar, zzaVar2);
        return true;
    }

    private final void zzb(zzcd.zzc.zza zzaVar, zzcd.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        zzcd.zze zza2 = zzkr.zza((zzcd.zzc) ((com.google.android.gms.internal.measurement.zzhy) zzaVar.zzy()), "_et");
        if (!zza2.zze() || zza2.zzf() <= 0) {
            return;
        }
        long zzf = zza2.zzf();
        zzh();
        zzcd.zze zza3 = zzkr.zza((zzcd.zzc) ((com.google.android.gms.internal.measurement.zzhy) zzaVar2.zzy()), "_et");
        if (zza3 != null && zza3.zzf() > 0) {
            zzf += zza3.zzf();
        }
        zzh();
        zzkr.zza(zzaVar2, "_et", Long.valueOf(zzf));
        zzh();
        zzkr.zza(zzaVar, "_fr", (Object) 1L);
    }

    private static void zza(zzcd.zzc.zza zzaVar, String str) {
        List<zzcd.zze> zza2 = zzaVar.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(zza2.get(i).zzb())) {
                zzaVar.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzcd.zzc.zza zzaVar, int i, String str) {
        List<zzcd.zze> zza2 = zzaVar.zza();
        for (int i2 = 0; i2 < zza2.size(); i2++) {
            if ("_err".equals(zza2.get(i2).zzb())) {
                return;
            }
        }
        zzaVar.zza((zzcd.zze) ((com.google.android.gms.internal.measurement.zzhy) zzcd.zze.zzm().zza("_err").zza(Long.valueOf(i).longValue()).zzy())).zza((zzcd.zze) ((com.google.android.gms.internal.measurement.zzhy) zzcd.zze.zzm().zza("_ev").zzb(str).zzy()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0156, code lost:
        r8.zzk.zzb().zze.zza(r8.zzk.zzl().currentTimeMillis());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().m333d_());
    }

    private final void zza(zzf zzfVar) {
        ArrayMap arrayMap;
        zzx();
        if (zznv.zzb() && this.zzk.zza().zze(zzfVar.zzc(), zzas.zzbi)) {
            if (TextUtils.isEmpty(zzfVar.zze()) && TextUtils.isEmpty(zzfVar.zzg()) && TextUtils.isEmpty(zzfVar.zzf())) {
                zza(zzfVar.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzfVar.zze()) && TextUtils.isEmpty(zzfVar.zzf())) {
            zza(zzfVar.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzk.zza().zza(zzfVar);
        try {
            URL url = new URL(zza2);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzfVar.zzc());
            zzca.zzb zza3 = zzc().zza(zzfVar.zzc());
            String zzb = zzc().zzb(zzfVar.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzb);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzex zzd = zzd();
            String zzc = zzfVar.zzc();
            zzkm zzkmVar = new zzkm(this);
            zzd.zzc();
            zzd.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkmVar);
            zzd.zzp().zzc(new zzfb(zzd, zzc, url, null, arrayMap, zzkmVar));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzeq.zza(zzfVar.zzc()), zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
        r6.zzk.zzb().zze.zza(r6.zzk.zzl().currentTimeMillis());
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a A[Catch: all -> 0x018d, TryCatch #2 {all -> 0x0196, blocks: (B:4:0x000c, B:5:0x000e, B:64:0x0180, B:43:0x00f6, B:50:0x0117, B:6:0x0029, B:15:0x0045, B:63:0x0179, B:20:0x0061, B:27:0x00b0, B:28:0x00c5, B:31:0x00cd, B:34:0x00d9, B:36:0x00df, B:41:0x00ec, B:53:0x0124, B:55:0x013a, B:57:0x0162, B:59:0x016c, B:61:0x0172, B:62:0x0176, B:56:0x014a, B:46:0x0103, B:48:0x010d), top: B:73:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #2 {all -> 0x0196, blocks: (B:4:0x000c, B:5:0x000e, B:64:0x0180, B:43:0x00f6, B:50:0x0117, B:6:0x0029, B:15:0x0045, B:63:0x0179, B:20:0x0061, B:27:0x00b0, B:28:0x00c5, B:31:0x00cd, B:34:0x00d9, B:36:0x00df, B:41:0x00ec, B:53:0x0124, B:55:0x013a, B:57:0x0162, B:59:0x016c, B:61:0x0172, B:62:0x0176, B:56:0x014a, B:46:0x0103, B:48:0x010d), top: B:73:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzab() {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzab():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list == null) {
            return;
        }
        for (Runnable runnable : list) {
            runnable.run();
        }
        this.zzo.clear();
    }

    private final Boolean zzb(zzf zzfVar) {
        try {
            if (zzfVar.zzm() != -2147483648L) {
                if (zzfVar.zzm() == Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzfVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzfVar.zzc(), 0).versionName;
                if (zzfVar.zzl() != null && zzfVar.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzr() {
        zzx();
        zzn();
        if (this.zzm) {
            return;
        }
        this.zzm = true;
        if (zzad()) {
            int zza2 = zza(this.zzv);
            int zzae = this.zzk.zzx().zzae();
            zzx();
            if (zza2 > zzae) {
                this.zzk.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
            } else if (zza2 < zzae) {
                if (zza(zzae, this.zzv)) {
                    this.zzk.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                } else {
                    this.zzk.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                }
            }
        }
    }

    private final boolean zzad() {
        FileLock fileLock;
        zzx();
        if (this.zzk.zza().zza(zzas.zzbh) && (fileLock = this.zzu) != null && fileLock.isValid()) {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzv = channel;
            FileLock tryLock = channel.tryLock();
            this.zzu = tryLock;
            if (tryLock != null) {
                this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                return true;
            }
            this.zzk.zzq().zze().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzk.zzq().zze().zza("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.zzk.zzq().zze().zza("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            this.zzk.zzq().zzh().zza("Storage lock already acquired", e3);
            return false;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzk.zza().zza(zzas.zzbr) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzn zznVar) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzaf zze = zze();
        String str = zznVar.zza;
        Preconditions.checkNotEmpty(str);
        zze.zzc();
        zze.zzaj();
        try {
            SQLiteDatabase m334c_ = zze.m334c_();
            String[] strArr = {str};
            int delete = m334c_.delete("apps", "app_id=?", strArr) + 0 + m334c_.delete("events", "app_id=?", strArr) + m334c_.delete("user_attributes", "app_id=?", strArr) + m334c_.delete("conditional_properties", "app_id=?", strArr) + m334c_.delete("raw_events", "app_id=?", strArr) + m334c_.delete("raw_events_metadata", "app_id=?", strArr) + m334c_.delete("queue", "app_id=?", strArr) + m334c_.delete("audience_filter_values", "app_id=?", strArr) + m334c_.delete("main_event_params", "app_id=?", strArr) + m334c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze.zzq().zze().zza("Error resetting analytics data. appId, error", zzeq.zza(str), e);
        }
        if (zznVar.zzh) {
            zzb(zznVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzku zzkuVar, zzn zznVar) {
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            int zzb = this.zzk.zzh().zzb(zzkuVar.zza);
            if (zzb != 0) {
                this.zzk.zzh();
                this.zzk.zzh().zza(this.zzaa, zznVar.zza, zzb, "_ev", zzkv.zza(zzkuVar.zza, 24, true), zzkuVar.zza != null ? zzkuVar.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzk.zzh().zzb(zzkuVar.zza, zzkuVar.zza());
            if (zzb2 != 0) {
                this.zzk.zzh();
                String zza2 = zzkv.zza(zzkuVar.zza, 24, true);
                Object zza3 = zzkuVar.zza();
                this.zzk.zzh().zza(this.zzaa, zznVar.zza, zzb2, "_ev", zza2, (zza3 == null || !((zza3 instanceof String) || (zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object zzc = this.zzk.zzh().zzc(zzkuVar.zza, zzkuVar.zza());
            if (zzc == null) {
                return;
            }
            if ("_sid".equals(zzkuVar.zza)) {
                long j = zzkuVar.zzb;
                String str = zzkuVar.zze;
                long j2 = 0;
                zzkw zzc2 = zze().zzc(zznVar.zza, "_sno");
                if (zzc2 != null && (zzc2.zze instanceof Long)) {
                    j2 = ((Long) zzc2.zze).longValue();
                } else {
                    if (zzc2 != null) {
                        this.zzk.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", zzc2.zze);
                    }
                    zzam zza4 = zze().zza(zznVar.zza, "_s");
                    if (zza4 != null) {
                        j2 = zza4.zzc;
                        this.zzk.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                }
                zza(new zzku("_sno", j, Long.valueOf(j2 + 1), str), zznVar);
            }
            zzkw zzkwVar = new zzkw(zznVar.zza, zzkuVar.zze, zzkuVar.zza, zzkuVar.zzb, zzc);
            this.zzk.zzq().zzw().zza("Setting user property", this.zzk.zzi().zzc(zzkwVar.zzc), zzc);
            zze().zze();
            try {
                zzc(zznVar);
                boolean zza5 = zze().zza(zzkwVar);
                zze().m335b_();
                if (!zza5) {
                    this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                    this.zzk.zzh().zza(this.zzaa, zznVar.zza, 9, (String) null, (String) null, 0);
                }
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzku zzkuVar, zzn zznVar) {
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
            } else if ("_npa".equals(zzkuVar.zza) && zznVar.zzs != null) {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzku("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zznVar.zzs.booleanValue() ? 1L : 0L), "auto"), zznVar);
            } else {
                this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzkuVar.zza));
                zze().zze();
                try {
                    zzc(zznVar);
                    zze().zzb(zznVar.zza, zzkuVar.zza);
                    zze().m335b_();
                    this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzkuVar.zza));
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzki zzkiVar) {
        this.zzp++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzs() {
        this.zzq++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfu zzu() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0483 A[Catch: all -> 0x04af, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b A[Catch: all -> 0x04af, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d2 A[Catch: all -> 0x04af, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020c A[Catch: all -> 0x04af, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0235 A[Catch: all -> 0x04af, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0255 A[Catch: all -> 0x04af, TRY_LEAVE, TryCatch #3 {all -> 0x04af, blocks: (B:24:0x009f, B:26:0x00ad, B:44:0x010f, B:46:0x011b, B:48:0x0132, B:49:0x015a, B:51:0x01ab, B:54:0x01be, B:57:0x01d2, B:59:0x01dd, B:64:0x01ec, B:66:0x01f4, B:68:0x01fa, B:72:0x0209, B:74:0x020c, B:76:0x0230, B:78:0x0235, B:84:0x0255, B:87:0x0269, B:89:0x02bd, B:91:0x02c5, B:93:0x02c9, B:94:0x02cc, B:96:0x02ed, B:135:0x03c9, B:136:0x03cc, B:147:0x043d, B:149:0x044d, B:151:0x0467, B:152:0x046e, B:156:0x04a0, B:98:0x0306, B:103:0x0331, B:105:0x0339, B:107:0x0343, B:111:0x0357, B:115:0x0365, B:119:0x0370, B:122:0x0382, B:125:0x0395, B:127:0x03ad, B:129:0x03b3, B:130:0x03b8, B:132:0x03be, B:112:0x035d, B:101:0x0319, B:139:0x03e4, B:141:0x041a, B:143:0x0422, B:145:0x0426, B:146:0x0429, B:153:0x0483, B:155:0x0487, B:81:0x0245, B:30:0x00bc, B:32:0x00c0, B:36:0x00d1, B:38:0x00eb, B:40:0x00f5, B:43:0x00ff), top: B:168:0x009f, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    private final zzn zzb(String str) {
        zzf zzb = zze().zzb(str);
        if (zzb == null || TextUtils.isEmpty(zzb.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb2 = zzb(zzb);
        if (zzb2 != null && !zzb2.booleanValue()) {
            this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzeq.zza(str));
            return null;
        }
        return new zzn(str, zzb.zze(), zzb.zzl(), zzb.zzm(), zzb.zzn(), zzb.zzo(), zzb.zzp(), (String) null, zzb.zzr(), false, zzb.zzi(), zzb.zzae(), 0L, 0, zzb.zzaf(), zzb.zzag(), false, zzb.zzf(), zzb.zzah(), zzb.zzq(), zzb.zzai(), (zznv.zzb() && this.zzk.zza().zze(str, zzas.zzbi)) ? zzb.zzg() : null, (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) ? zza(str).zza() : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzz zzzVar) {
        zzn zzb = zzb(zzzVar.zza);
        if (zzb != null) {
            zza(zzzVar, zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzz zzzVar, zzn zznVar) {
        Preconditions.checkNotNull(zzzVar);
        Preconditions.checkNotEmpty(zzzVar.zza);
        Preconditions.checkNotNull(zzzVar.zzb);
        Preconditions.checkNotNull(zzzVar.zzc);
        Preconditions.checkNotEmpty(zzzVar.zzc.zza);
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            zzz zzzVar2 = new zzz(zzzVar);
            boolean z = false;
            zzzVar2.zze = false;
            zze().zze();
            try {
                zzz zzd = zze().zzd(zzzVar2.zza, zzzVar2.zzc.zza);
                if (zzd != null && !zzd.zzb.equals(zzzVar2.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzb, zzd.zzb);
                }
                if (zzd != null && zzd.zze) {
                    zzzVar2.zzb = zzd.zzb;
                    zzzVar2.zzd = zzd.zzd;
                    zzzVar2.zzh = zzd.zzh;
                    zzzVar2.zzf = zzd.zzf;
                    zzzVar2.zzi = zzd.zzi;
                    zzzVar2.zze = zzd.zze;
                    zzzVar2.zzc = new zzku(zzzVar2.zzc.zza, zzd.zzc.zzb, zzzVar2.zzc.zza(), zzd.zzc.zze);
                } else if (TextUtils.isEmpty(zzzVar2.zzf)) {
                    zzzVar2.zzc = new zzku(zzzVar2.zzc.zza, zzzVar2.zzd, zzzVar2.zzc.zza(), zzzVar2.zzc.zze);
                    zzzVar2.zze = true;
                    z = true;
                }
                if (zzzVar2.zze) {
                    zzku zzkuVar = zzzVar2.zzc;
                    zzkw zzkwVar = new zzkw(zzzVar2.zza, zzzVar2.zzb, zzkuVar.zza, zzkuVar.zzb, zzkuVar.zza());
                    if (zze().zza(zzkwVar)) {
                        this.zzk.zzq().zzv().zza("User property updated immediately", zzzVar2.zza, this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                    } else {
                        this.zzk.zzq().zze().zza("(2)Too many active user properties, ignoring", zzeq.zza(zzzVar2.zza), this.zzk.zzi().zzc(zzkwVar.zzc), zzkwVar.zze);
                    }
                    if (z && zzzVar2.zzi != null) {
                        zzc(new zzaq(zzzVar2.zzi, zzzVar2.zzd), zznVar);
                    }
                }
                if (zze().zza(zzzVar2)) {
                    this.zzk.zzq().zzv().zza("Conditional property added", zzzVar2.zza, this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                } else {
                    this.zzk.zzq().zze().zza("Too many conditional properties, ignoring", zzeq.zza(zzzVar2.zza), this.zzk.zzi().zzc(zzzVar2.zzc.zza), zzzVar2.zzc.zza());
                }
                zze().m335b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzz zzzVar) {
        zzn zzb = zzb(zzzVar.zza);
        if (zzb != null) {
            zzb(zzzVar, zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzz zzzVar, zzn zznVar) {
        Preconditions.checkNotNull(zzzVar);
        Preconditions.checkNotEmpty(zzzVar.zza);
        Preconditions.checkNotNull(zzzVar.zzc);
        Preconditions.checkNotEmpty(zzzVar.zzc.zza);
        zzx();
        zzn();
        if (zze(zznVar)) {
            if (!zznVar.zzh) {
                zzc(zznVar);
                return;
            }
            zze().zze();
            try {
                zzc(zznVar);
                zzz zzd = zze().zzd(zzzVar.zza, zzzVar.zzc.zza);
                if (zzd != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzzVar.zza, this.zzk.zzi().zzc(zzzVar.zzc.zza));
                    zze().zze(zzzVar.zza, zzzVar.zzc.zza);
                    if (zzd.zze) {
                        zze().zzb(zzzVar.zza, zzzVar.zzc.zza);
                    }
                    if (zzzVar.zzk != null) {
                        zzc(this.zzk.zzh().zza(zzzVar.zza, zzzVar.zzk.zza, zzzVar.zzk.zzb != null ? zzzVar.zzk.zzb.zzb() : null, zzd.zzb, zzzVar.zzk.zzd, true, false, zzlo.zzb() && this.zzk.zza().zza(zzas.zzcl)), zznVar);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzeq.zza(zzzVar.zza), this.zzk.zzi().zzc(zzzVar.zzc.zza));
                }
                zze().m335b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzf zzc(zzn zznVar) {
        zzx();
        zzn();
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zzf zzb = zze().zzb(zznVar.zza);
        zzac zzacVar = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzacVar = zza(zznVar.zza).zzb(zzac.zza(zznVar.zzw));
        }
        String zza2 = (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && !zzacVar.zzc()) ? "" : this.zzj.zza(zznVar.zza);
        if (zzne.zzb() && this.zzk.zza().zza(zzas.zzbn)) {
            if (zzb == null) {
                zzb = new zzf(this.zzk, zznVar.zza);
                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                    if (zzacVar.zze()) {
                        zzb.zza(zza(zzacVar));
                    }
                    if (zzacVar.zzc()) {
                        zzb.zze(zza2);
                    }
                } else {
                    zzb.zza(zzz());
                    zzb.zze(zza2);
                }
            } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzacVar.zzc()) && !zza2.equals(zzb.zzh())) {
                zzb.zze(zza2);
                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                    zzb.zza(zza(zzacVar));
                } else {
                    zzb.zza(zzz());
                }
            } else if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && TextUtils.isEmpty(zzb.zzd()) && zzacVar.zze()) {
                zzb.zza(zza(zzacVar));
            }
            zzb.zzb(zznVar.zzb);
            zzb.zzc(zznVar.zzr);
            if (zznv.zzb() && this.zzk.zza().zze(zzb.zzc(), zzas.zzbi)) {
                zzb.zzd(zznVar.zzv);
            }
            if (!TextUtils.isEmpty(zznVar.zzk)) {
                zzb.zzf(zznVar.zzk);
            }
            if (zznVar.zze != 0) {
                zzb.zzd(zznVar.zze);
            }
            if (!TextUtils.isEmpty(zznVar.zzc)) {
                zzb.zzg(zznVar.zzc);
            }
            zzb.zzc(zznVar.zzj);
            if (zznVar.zzd != null) {
                zzb.zzh(zznVar.zzd);
            }
            zzb.zze(zznVar.zzf);
            zzb.zza(zznVar.zzh);
            if (!TextUtils.isEmpty(zznVar.zzg)) {
                zzb.zzi(zznVar.zzg);
            }
            if (!this.zzk.zza().zza(zzas.zzbx)) {
                zzb.zzp(zznVar.zzl);
            }
            zzb.zzb(zznVar.zzo);
            zzb.zzc(zznVar.zzp);
            zzb.zza(zznVar.zzs);
            zzb.zzf(zznVar.zzt);
            if (zzb.zza()) {
                zze().zza(zzb);
            }
            return zzb;
        }
        return zza(zznVar, zzb, zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd(zzn zznVar) {
        try {
            return (String) this.zzk.zzp().zza(new zzkp(this, zznVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzeq.zza(zznVar.zza), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzab();
    }

    private final boolean zze(zzn zznVar) {
        return (zznv.zzb() && this.zzk.zza().zze(zznVar.zza, zzas.zzbi)) ? (TextUtils.isEmpty(zznVar.zzb) && TextUtils.isEmpty(zznVar.zzv) && TextUtils.isEmpty(zznVar.zzr)) ? false : true : (TextUtils.isEmpty(zznVar.zzb) && TextUtils.isEmpty(zznVar.zzr)) ? false : true;
    }
}
