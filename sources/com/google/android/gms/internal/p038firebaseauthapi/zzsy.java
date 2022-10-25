package com.google.android.gms.internal.p038firebaseauthapi;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsy */
/* loaded from: classes3.dex */
public final class zzsy extends zzpo<zztv> {
    private final Context zza;
    private final zztv zzb;
    private final Future<zzpk<zztv>> zzc = zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsy(Context context, zztv zztvVar) {
        this.zza = context;
        this.zzb = zztvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzS(FirebaseApp firebaseApp, zzvz zzvzVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzvzVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzvzVar, FirebaseAuthProvider.PROVIDER_ID));
        List<zzwm> zzp = zzvzVar.zzp();
        if (zzp != null && !zzp.isEmpty()) {
            for (int i = 0; i < zzp.size(); i++) {
                arrayList.add(new zzt(zzp.get(i)));
            }
        }
        zzx zzxVar = new zzx(firebaseApp, arrayList);
        zzxVar.zzm(new zzz(zzvzVar.zzh(), zzvzVar.zzg()));
        zzxVar.zzn(zzvzVar.zzi());
        zzxVar.zzp(zzvzVar.zzr());
        zzxVar.zzi(zzba.zzb(zzvzVar.zzt()));
        return zzxVar;
    }

    public final Task<Void> zzA(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zze(1);
        zzrl zzrlVar = new zzrl(str, actionCodeSettings, str2, "sendPasswordResetEmail");
        zzrlVar.zze(firebaseApp);
        return zzc(zzrlVar);
    }

    public final Task<Void> zzB(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zze(6);
        zzrl zzrlVar = new zzrl(str, actionCodeSettings, str2, "sendSignInLinkToEmail");
        zzrlVar.zze(firebaseApp);
        return zzc(zzrlVar);
    }

    public final Task<Void> zzC(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzrj zzrjVar = new zzrj(str, actionCodeSettings);
        zzrjVar.zze(firebaseApp);
        return zzc(zzrjVar);
    }

    public final Task<ActionCodeResult> zzD(FirebaseApp firebaseApp, String str, String str2) {
        zzpt zzptVar = new zzpt(str, str2);
        zzptVar.zze(firebaseApp);
        return zzc(zzptVar);
    }

    public final Task<Void> zzE(FirebaseApp firebaseApp, String str, String str2) {
        zzpr zzprVar = new zzpr(str, str2);
        zzprVar.zze(firebaseApp);
        return zzc(zzprVar);
    }

    public final Task<String> zzF(FirebaseApp firebaseApp, String str, String str2) {
        zzsv zzsvVar = new zzsv(str, str2);
        zzsvVar.zze(firebaseApp);
        return zzc(zzsvVar);
    }

    public final Task<Void> zzG(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzpv zzpvVar = new zzpv(str, str2, str3);
        zzpvVar.zze(firebaseApp);
        return zzc(zzpvVar);
    }

    public final Task<AuthResult> zzH(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbkVar);
        List<String> zza = firebaseUser.zza();
        if (zza == null || !zza.contains(authCredential.getProvider())) {
            if (authCredential instanceof EmailAuthCredential) {
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
                if (!emailAuthCredential.zzh()) {
                    zzqj zzqjVar = new zzqj(emailAuthCredential);
                    zzqjVar.zze(firebaseApp);
                    zzqjVar.zzf(firebaseUser);
                    zzqjVar.zzg(zzbkVar);
                    zzqjVar.zzh(zzbkVar);
                    return zzc(zzqjVar);
                }
                zzqp zzqpVar = new zzqp(emailAuthCredential);
                zzqpVar.zze(firebaseApp);
                zzqpVar.zzf(firebaseUser);
                zzqpVar.zzg(zzbkVar);
                zzqpVar.zzh(zzbkVar);
                return zzc(zzqpVar);
            } else if (!(authCredential instanceof PhoneAuthCredential)) {
                Preconditions.checkNotNull(firebaseApp);
                Preconditions.checkNotNull(authCredential);
                Preconditions.checkNotNull(firebaseUser);
                Preconditions.checkNotNull(zzbkVar);
                zzql zzqlVar = new zzql(authCredential);
                zzqlVar.zze(firebaseApp);
                zzqlVar.zzf(firebaseUser);
                zzqlVar.zzg(zzbkVar);
                zzqlVar.zzh(zzbkVar);
                return zzc(zzqlVar);
            } else {
                zzux.zza();
                zzqn zzqnVar = new zzqn((PhoneAuthCredential) authCredential);
                zzqnVar.zze(firebaseApp);
                zzqnVar.zzf(firebaseUser);
                zzqnVar.zzg(zzbkVar);
                zzqnVar.zzh(zzbkVar);
                return zzc(zzqnVar);
            }
        }
        return Tasks.forException(zzte.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
    }

    public final Task<AuthResult> zzI(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbkVar);
        List<String> zza = firebaseUser.zza();
        if ((zza != null && !zza.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzte.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (((str.hashCode() == 1216985755 && str.equals("password")) ? (char) 0 : (char) 65535) != 0) {
            zzsj zzsjVar = new zzsj(str);
            zzsjVar.zze(firebaseApp);
            zzsjVar.zzf(firebaseUser);
            zzsjVar.zzg(zzbkVar);
            zzsjVar.zzh(zzbkVar);
            return zzc(zzsjVar);
        }
        zzsh zzshVar = new zzsh();
        zzshVar.zze(firebaseApp);
        zzshVar.zzf(firebaseUser);
        zzshVar.zzg(zzbkVar);
        zzshVar.zzh(zzbkVar);
        return zzc(zzshVar);
    }

    public final Task<Void> zzJ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbk zzbkVar) {
        zzrh zzrhVar = new zzrh();
        zzrhVar.zze(firebaseApp);
        zzrhVar.zzf(firebaseUser);
        zzrhVar.zzg(zzbkVar);
        zzrhVar.zzh(zzbkVar);
        return zzb(zzrhVar);
    }

    public final Task<Void> zzK(FirebaseUser firebaseUser, zzan zzanVar) {
        zzpz zzpzVar = new zzpz();
        zzpzVar.zzf(firebaseUser);
        zzpzVar.zzg(zzanVar);
        zzpzVar.zzh(zzanVar);
        return zzc(zzpzVar);
    }

    public final Task<Void> zzL(String str) {
        return zzc(new zzrn(str));
    }

    public final Task<Void> zzM(zzag zzagVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzsb zzsbVar = new zzsb(zzagVar, str, str2, j, z, z2, str3, str4, z3);
        zzsbVar.zzi(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzc(zzsbVar);
    }

    public final Task<Void> zzN(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzg zzgVar) {
        zzux.zza();
        zzqd zzqdVar = new zzqd(phoneMultiFactorAssertion, firebaseUser.zzg(), str);
        zzqdVar.zze(firebaseApp);
        zzqdVar.zzg(zzgVar);
        return zzc(zzqdVar);
    }

    public final Task<Void> zzO(zzag zzagVar, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzsd zzsdVar = new zzsd(phoneMultiFactorInfo, zzagVar.zzd(), str, j, z, z2, str2, str3, z3);
        zzsdVar.zzi(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zzc(zzsdVar);
    }

    public final Task<AuthResult> zzP(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzgVar) {
        zzux.zza();
        zzqf zzqfVar = new zzqf(phoneMultiFactorAssertion, str);
        zzqfVar.zze(firebaseApp);
        zzqfVar.zzg(zzgVar);
        if (firebaseUser != null) {
            zzqfVar.zzf(firebaseUser);
        }
        return zzc(zzqfVar);
    }

    public final Task<Void> zzQ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzsf zzsfVar = new zzsf(firebaseUser.zzg(), str);
        zzsfVar.zze(firebaseApp);
        zzsfVar.zzf(firebaseUser);
        zzsfVar.zzg(zzbkVar);
        zzsfVar.zzh(zzbkVar);
        return zzc(zzsfVar);
    }

    public final Task<Void> zzR(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zze(7);
        return zzc(new zzst(str, str2, actionCodeSettings));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzpo
    final Future<zzpk<zztv>> zza() {
        Future<zzpk<zztv>> future = this.zzc;
        if (future != null) {
            return future;
        }
        return zzh.zza().zza(2).submit(new zzsz(this.zzb, this.zza));
    }

    public final Task<GetTokenResult> zze(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzqh zzqhVar = new zzqh(str);
        zzqhVar.zze(firebaseApp);
        zzqhVar.zzf(firebaseUser);
        zzqhVar.zzg(zzbkVar);
        zzqhVar.zzh(zzbkVar);
        return zzb(zzqhVar);
    }

    public final Task<AuthResult> zzf(FirebaseApp firebaseApp, String str, String str2, zzg zzgVar) {
        zzrt zzrtVar = new zzrt(str, str2);
        zzrtVar.zze(firebaseApp);
        zzrtVar.zzg(zzgVar);
        return zzc(zzrtVar);
    }

    public final Task<AuthResult> zzg(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzg zzgVar) {
        zzrr zzrrVar = new zzrr(authCredential, str);
        zzrrVar.zze(firebaseApp);
        zzrrVar.zzg(zzgVar);
        return zzc(zzrrVar);
    }

    public final Task<Void> zzh(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbk zzbkVar) {
        zzqr zzqrVar = new zzqr(authCredential, str);
        zzqrVar.zze(firebaseApp);
        zzqrVar.zzf(firebaseUser);
        zzqrVar.zzg(zzbkVar);
        zzqrVar.zzh(zzbkVar);
        return zzc(zzqrVar);
    }

    public final Task<AuthResult> zzi(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzbk zzbkVar) {
        zzqt zzqtVar = new zzqt(authCredential, str);
        zzqtVar.zze(firebaseApp);
        zzqtVar.zzf(firebaseUser);
        zzqtVar.zzg(zzbkVar);
        zzqtVar.zzh(zzbkVar);
        return zzc(zzqtVar);
    }

    public final Task<AuthResult> zzj(FirebaseApp firebaseApp, zzg zzgVar, String str) {
        zzrp zzrpVar = new zzrp(str);
        zzrpVar.zze(firebaseApp);
        zzrpVar.zzg(zzgVar);
        return zzc(zzrpVar);
    }

    public final void zzk(FirebaseApp firebaseApp, zzwt zzwtVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzsx zzsxVar = new zzsx(zzwtVar);
        zzsxVar.zze(firebaseApp);
        zzsxVar.zzi(onVerificationStateChangedCallbacks, activity, executor, zzwtVar.zzb());
        zzc(zzsxVar);
    }

    public final Task<Void> zzl(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbk zzbkVar) {
        zzsr zzsrVar = new zzsr(userProfileChangeRequest);
        zzsrVar.zze(firebaseApp);
        zzsrVar.zzf(firebaseUser);
        zzsrVar.zzg(zzbkVar);
        zzsrVar.zzh(zzbkVar);
        return zzc(zzsrVar);
    }

    public final Task<Void> zzm(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzsl zzslVar = new zzsl(str);
        zzslVar.zze(firebaseApp);
        zzslVar.zzf(firebaseUser);
        zzslVar.zzg(zzbkVar);
        zzslVar.zzh(zzbkVar);
        return zzc(zzslVar);
    }

    public final Task<Void> zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzsn zzsnVar = new zzsn(str);
        zzsnVar.zze(firebaseApp);
        zzsnVar.zzf(firebaseUser);
        zzsnVar.zzg(zzbkVar);
        zzsnVar.zzh(zzbkVar);
        return zzc(zzsnVar);
    }

    public final Task<Void> zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbk zzbkVar) {
        zzux.zza();
        zzsp zzspVar = new zzsp(phoneAuthCredential);
        zzspVar.zze(firebaseApp);
        zzspVar.zzf(firebaseUser);
        zzspVar.zzg(zzbkVar);
        zzspVar.zzh(zzbkVar);
        return zzc(zzspVar);
    }

    public final Task<AuthResult> zzp(FirebaseApp firebaseApp, String str, String str2, String str3, zzg zzgVar) {
        zzpx zzpxVar = new zzpx(str, str2, str3);
        zzpxVar.zze(firebaseApp);
        zzpxVar.zzg(zzgVar);
        return zzc(zzpxVar);
    }

    public final Task<AuthResult> zzq(FirebaseApp firebaseApp, String str, String str2, String str3, zzg zzgVar) {
        zzrv zzrvVar = new zzrv(str, str2, str3);
        zzrvVar.zze(firebaseApp);
        zzrvVar.zzg(zzgVar);
        return zzc(zzrvVar);
    }

    public final Task<AuthResult> zzr(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zzg zzgVar) {
        zzrx zzrxVar = new zzrx(emailAuthCredential);
        zzrxVar.zze(firebaseApp);
        zzrxVar.zzg(zzgVar);
        return zzc(zzrxVar);
    }

    public final Task<Void> zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzbk zzbkVar) {
        zzqz zzqzVar = new zzqz(str, str2, str3);
        zzqzVar.zze(firebaseApp);
        zzqzVar.zzf(firebaseUser);
        zzqzVar.zzg(zzbkVar);
        zzqzVar.zzh(zzbkVar);
        return zzc(zzqzVar);
    }

    public final Task<AuthResult> zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzbk zzbkVar) {
        zzrb zzrbVar = new zzrb(str, str2, str3);
        zzrbVar.zze(firebaseApp);
        zzrbVar.zzf(firebaseUser);
        zzrbVar.zzg(zzbkVar);
        zzrbVar.zzh(zzbkVar);
        return zzc(zzrbVar);
    }

    public final Task<Void> zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbkVar) {
        zzqv zzqvVar = new zzqv(emailAuthCredential);
        zzqvVar.zze(firebaseApp);
        zzqvVar.zzf(firebaseUser);
        zzqvVar.zzg(zzbkVar);
        zzqvVar.zzh(zzbkVar);
        return zzc(zzqvVar);
    }

    public final Task<AuthResult> zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbkVar) {
        zzqx zzqxVar = new zzqx(emailAuthCredential);
        zzqxVar.zze(firebaseApp);
        zzqxVar.zzf(firebaseUser);
        zzqxVar.zzg(zzbkVar);
        zzqxVar.zzh(zzbkVar);
        return zzc(zzqxVar);
    }

    public final Task<AuthResult> zzw(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzg zzgVar) {
        zzux.zza();
        zzrz zzrzVar = new zzrz(phoneAuthCredential, str);
        zzrzVar.zze(firebaseApp);
        zzrzVar.zzg(zzgVar);
        return zzc(zzrzVar);
    }

    public final Task<Void> zzx(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbk zzbkVar) {
        zzux.zza();
        zzrd zzrdVar = new zzrd(phoneAuthCredential, str);
        zzrdVar.zze(firebaseApp);
        zzrdVar.zzf(firebaseUser);
        zzrdVar.zzg(zzbkVar);
        zzrdVar.zzh(zzbkVar);
        return zzc(zzrdVar);
    }

    public final Task<AuthResult> zzy(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzbk zzbkVar) {
        zzux.zza();
        zzrf zzrfVar = new zzrf(phoneAuthCredential, str);
        zzrfVar.zze(firebaseApp);
        zzrfVar.zzf(firebaseUser);
        zzrfVar.zzg(zzbkVar);
        zzrfVar.zzh(zzbkVar);
        return zzc(zzrfVar);
    }

    public final Task<SignInMethodQueryResult> zzz(FirebaseApp firebaseApp, String str, String str2) {
        zzqb zzqbVar = new zzqb(str, str2);
        zzqbVar.zze(firebaseApp);
        return zzb(zzqbVar);
    }
}
