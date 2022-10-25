package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpj */
/* loaded from: classes3.dex */
public final class zzpj {
    private final zzuq zza;

    public zzpj(zzuq zzuqVar) {
        this.zza = (zzuq) Preconditions.checkNotNull(zzuqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzH(zzpj zzpjVar, zzxi zzxiVar, zztb zztbVar, zzuo zzuoVar) {
        if (!zzxiVar.zzk()) {
            zzpjVar.zzO(new zzwg(zzxiVar.zzg(), zzxiVar.zzc(), Long.valueOf(zzxiVar.zzh()), "Bearer"), zzxiVar.zzf(), zzxiVar.zze(), Boolean.valueOf(zzxiVar.zzi()), zzxiVar.zzp(), zztbVar, zzuoVar);
            return;
        }
        zztbVar.zzn(new zzno(zzxiVar.zzb() ? new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL) : zzai.zza(zzxiVar.zzj()), zzxiVar.zzp(), zzxiVar.zzd(), zzxiVar.zzl()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzI(zzpj zzpjVar, zztb zztbVar, zzwg zzwgVar, zzww zzwwVar, zzuo zzuoVar) {
        Preconditions.checkNotNull(zztbVar);
        Preconditions.checkNotNull(zzwgVar);
        Preconditions.checkNotNull(zzwwVar);
        Preconditions.checkNotNull(zzuoVar);
        zzpjVar.zza.zzh(new zzvw(zzwgVar.zze()), new zznw(zzpjVar, zzuoVar, zztbVar, zzwgVar, zzwwVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzK(zzpj zzpjVar, zztb zztbVar, zzwg zzwgVar, zzvz zzvzVar, zzww zzwwVar, zzuo zzuoVar) {
        Preconditions.checkNotNull(zztbVar);
        Preconditions.checkNotNull(zzwgVar);
        Preconditions.checkNotNull(zzvzVar);
        Preconditions.checkNotNull(zzwwVar);
        Preconditions.checkNotNull(zzuoVar);
        zzpjVar.zza.zzi(zzwwVar, new zznx(zzpjVar, zzwwVar, zzvzVar, zztbVar, zzwgVar, zzuoVar));
    }

    private final void zzM(String str, zzup<zzwg> zzupVar) {
        Preconditions.checkNotNull(zzupVar);
        Preconditions.checkNotEmpty(str);
        zzwg zzj = zzwg.zzj(str);
        if (zzj.zzb()) {
            zzupVar.zzb(zzj);
            return;
        }
        this.zza.zzb(new zzvv(zzj.zzd()), new zzpi(this, zzupVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzN(zzvo zzvoVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzvoVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzp(zzvoVar, new zznv(this, zztbVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzO(zzwg zzwgVar, String str, String str2, Boolean bool, zze zzeVar, zztb zztbVar, zzuo zzuoVar) {
        Preconditions.checkNotNull(zzwgVar);
        Preconditions.checkNotNull(zzuoVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzh(new zzvw(zzwgVar.zze()), new zzny(this, zzuoVar, str2, str, bool, zzeVar, zztbVar, zzwgVar));
    }

    private final void zzP(zzwd zzwdVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzwdVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzk(zzwdVar, new zzpb(this, zztbVar));
    }

    public final void zzA(Context context, zzvs zzvsVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzvsVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzu(null, zzvsVar, new zzou(this, zztbVar));
    }

    public final void zzB(zzxc zzxcVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzxcVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzt(zzxcVar, new zzov(this, zztbVar));
    }

    public final void zzC(zzwd zzwdVar, zztb zztbVar) {
        zzP(zzwdVar, zztbVar);
    }

    public final void zzD(String str, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzox(this, zztbVar));
    }

    public final void zzE(String str, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzoz(this, zztbVar));
    }

    public final void zzF(String str, zztb zztbVar) {
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzo(str, new zzpa(this, zztbVar));
    }

    public final void zza(String str, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzb(new zzvv(str), new zzoc(this, zztbVar));
    }

    public final void zzb(zzxj zzxjVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzxjVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzc(zzxjVar, new zzor(this, zztbVar));
    }

    public final void zzc(Context context, zzxg zzxgVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzxgVar);
        Preconditions.checkNotNull(zztbVar);
        zzxgVar.zzf(true);
        this.zza.zzd(null, zzxgVar, new zzpc(this, zztbVar));
    }

    public final void zzd(String str, zztb zztbVar) {
        Preconditions.checkNotNull(zztbVar);
        this.zza.zze(new zzwy(str), new zzpd(this, zztbVar));
    }

    public final void zze(String str, UserProfileChangeRequest userProfileChangeRequest, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzpe(this, userProfileChangeRequest, zztbVar));
    }

    public final void zzf(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzpf(this, str2, zztbVar));
    }

    public final void zzg(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzpg(this, str2, zztbVar));
    }

    public final void zzh(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzww zzwwVar = new zzww();
        zzwwVar.zzm(str);
        zzwwVar.zzn(str2);
        this.zza.zzi(zzwwVar, new zzph(this, zztbVar));
    }

    public final void zzi(String str, String str2, String str3, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zze(new zzwy(str, str2, null, str3), new zzns(this, zztbVar));
    }

    public final void zzj(Context context, String str, String str2, String str3, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzf(null, new zzxm(str, str2, str3), new zznt(this, zztbVar));
    }

    public final void zzk(EmailAuthCredential emailAuthCredential, zztb zztbVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zztbVar);
        if (emailAuthCredential.zzf()) {
            zzM(emailAuthCredential.zze(), new zznu(this, emailAuthCredential, zztbVar));
        } else {
            zzN(new zzvo(emailAuthCredential, null), zztbVar);
        }
    }

    public final void zzl(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzj(new zzvk(str, str2), new zznz(this, zztbVar));
    }

    public final void zzm(String str, ActionCodeSettings actionCodeSettings, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzwd zzwdVar = new zzwd(actionCodeSettings.zzf());
        zzwdVar.zzc(str);
        zzwdVar.zze(actionCodeSettings);
        zzwdVar.zzf(str2);
        this.zza.zzk(zzwdVar, new zzoa(this, zztbVar));
    }

    public final void zzn(String str, ActionCodeSettings actionCodeSettings, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzwd zzwdVar = new zzwd(4);
        zzwdVar.zzd(str);
        if (actionCodeSettings != null) {
            zzwdVar.zze(actionCodeSettings);
        }
        zzP(zzwdVar, zztbVar);
    }

    public final void zzo(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzg(new zzwq(str, null, str2), new zzob(this, zztbVar));
    }

    public final void zzp(String str, String str2, String str3, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzg(new zzwq(str, str2, str3), new zzod(this, zztbVar));
    }

    public final void zzq(zzwt zzwtVar, zztb zztbVar) {
        Preconditions.checkNotEmpty(zzwtVar.zzb());
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzl(zzwtVar, new zzoe(this, zztbVar));
    }

    public final void zzr(Context context, zzxo zzxoVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzxoVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzm(null, zzxoVar, new zzof(this, zztbVar));
    }

    public final void zzs(String str, String str2, String str3, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zztbVar);
        zzM(str3, new zzog(this, str, str2, zztbVar));
    }

    public final void zzt(Context context, String str, zzxo zzxoVar, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzxoVar);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzoi(this, zzxoVar, null, zztbVar));
    }

    public final void zzu(String str, zzxg zzxgVar, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzxgVar);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzok(this, zzxgVar, zztbVar));
    }

    public final void zzv(String str, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzol(this, zztbVar));
    }

    public final void zzw(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        zzM(str2, new zzon(this, str, zztbVar));
    }

    public final void zzx(String str, String str2, zztb zztbVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzop(this, str2, zztbVar));
    }

    public final void zzy(zzxa zzxaVar, zztb zztbVar) {
        Preconditions.checkNotNull(zzxaVar);
        Preconditions.checkNotNull(zztbVar);
        this.zza.zzq(zzxaVar, new zzoq(this, zztbVar));
    }

    public final void zzz(Context context, zzvq zzvqVar, String str, zztb zztbVar) {
        Preconditions.checkNotNull(zzvqVar);
        Preconditions.checkNotNull(zztbVar);
        zzM(str, new zzot(this, zzvqVar, null, zztbVar));
    }
}
