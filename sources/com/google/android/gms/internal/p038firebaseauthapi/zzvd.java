package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd */
/* loaded from: classes3.dex */
public final class zzvd {
    private static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap<String, zzvc> zzd = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvd(Context context) {
        this.zzb = (Context) Preconditions.checkNotNull(context);
        zzh.zza();
        this.zzc = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzf(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzvd zzvdVar, String str) {
        zzvc zzvcVar = zzvdVar.zzd.get(str);
        if (zzvcVar == null || zzaf.zzb(zzvcVar.zzd) || zzaf.zzb(zzvcVar.zze) || zzvcVar.zzb.isEmpty()) {
            return;
        }
        for (zztb zztbVar : zzvcVar.zzb) {
            zztbVar.zzi(PhoneAuthCredential.zzb(zzvcVar.zzd, zzvcVar.zze));
        }
        zzvcVar.zzh = true;
    }

    private static String zzm(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        String sb2 = sb.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(sb2.getBytes(zzq.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            Logger logger = zza;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(substring).length());
            sb3.append("Package: ");
            sb3.append(str);
            sb3.append(" -- Hash: ");
            sb3.append(substring);
            logger.m345d(sb3.toString(), new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e) {
            Logger logger2 = zza;
            String valueOf = String.valueOf(e.getMessage());
            logger2.m343e(valueOf.length() != 0 ? "NoSuchAlgorithm: ".concat(valueOf) : new String("NoSuchAlgorithm: "), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzvc zzvcVar = this.zzd.get(str);
        if (zzvcVar == null) {
            return;
        }
        if (!zzvcVar.zzi) {
            zzo(str);
        }
        zze(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo(String str) {
        zzvc zzvcVar = this.zzd.get(str);
        if (zzvcVar == null || zzvcVar.zzh || zzaf.zzb(zzvcVar.zzd)) {
            return;
        }
        zza.m339w("Timed out waiting for SMS.", new Object[0]);
        for (zztb zztbVar : zzvcVar.zzb) {
            zztbVar.zzj(zzvcVar.zzd);
        }
        zzvcVar.zzi = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str) {
        return this.zzd.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(final String str, zztb zztbVar, long j, boolean z) {
        this.zzd.put(str, new zzvc(j, z));
        zzc(zztbVar, str);
        zzvc zzvcVar = this.zzd.get(str);
        if (zzvcVar.zza <= 0) {
            zza.m339w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzvcVar.zzf = this.zzc.schedule(new Runnable(this, str) { // from class: com.google.android.gms.internal.firebase-auth-api.zzuy
            private final zzvd zza;
            private final String zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg(this.zzb);
            }
        }, zzvcVar.zza, TimeUnit.SECONDS);
        if (!zzvcVar.zzc) {
            zza.m339w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzvb zzvbVar = new zzvb(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        this.zzb.getApplicationContext().registerReceiver(zzvbVar, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzuz(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zztb zztbVar, String str) {
        zzvc zzvcVar = this.zzd.get(str);
        if (zzvcVar == null) {
            return;
        }
        zzvcVar.zzb.add(zztbVar);
        if (zzvcVar.zzg) {
            zztbVar.zzh(zzvcVar.zzd);
        }
        if (zzvcVar.zzh) {
            zztbVar.zzi(PhoneAuthCredential.zzb(zzvcVar.zzd, zzvcVar.zze));
        }
        if (zzvcVar.zzi) {
            zztbVar.zzj(zzvcVar.zzd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        Signature[] apkContentsSigners;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                apkContentsSigners = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                apkContentsSigners = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String zzm = zzm(packageName, apkContentsSigners[0].toCharsString());
            if (zzm != null) {
                return zzm;
            }
            zza.m343e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.m343e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(String str) {
        zzvc zzvcVar = this.zzd.get(str);
        if (zzvcVar == null) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = zzvcVar.zzf;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            zzvcVar.zzf.cancel(false);
        }
        zzvcVar.zzb.clear();
        this.zzd.remove(str);
    }
}
