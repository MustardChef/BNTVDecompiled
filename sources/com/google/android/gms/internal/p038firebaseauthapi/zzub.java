package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzub */
/* loaded from: classes3.dex */
public final class zzub extends zzuq implements zzvg {
    zzuc zza;
    private zztr zzb;
    private zzts zzc;
    private zzuu zzd;
    private final zzua zze;
    private final Context zzf;
    private final String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzub(Context context, String str, zzua zzuaVar, zzuu zzuuVar, zztr zztrVar, zzts zztsVar) {
        this.zzf = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzg = Preconditions.checkNotEmpty(str);
        this.zze = (zzua) Preconditions.checkNotNull(zzuaVar);
        zzv(null, null, null);
        zzvh.zzc(str, this);
    }

    private final void zzv(zzuu zzuuVar, zztr zztrVar, zzts zztsVar) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza = zzve.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza)) {
            zza = zzvh.zzd(this.zzg);
        } else {
            String valueOf = String.valueOf(zza);
            Log.e("LocalClient", valueOf.length() != 0 ? "Found hermetic configuration for secureToken URL: ".concat(valueOf) : new String("Found hermetic configuration for secureToken URL: "));
        }
        if (this.zzd == null) {
            this.zzd = new zzuu(zza, zzw());
        }
        String zza2 = zzve.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzvh.zze(this.zzg);
        } else {
            String valueOf2 = String.valueOf(zza2);
            Log.e("LocalClient", valueOf2.length() != 0 ? "Found hermetic configuration for identityToolkit URL: ".concat(valueOf2) : new String("Found hermetic configuration for identityToolkit URL: "));
        }
        if (this.zzb == null) {
            this.zzb = new zztr(zza2, zzw());
        }
        String zza3 = zzve.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzvh.zzf(this.zzg);
        } else {
            String valueOf3 = String.valueOf(zza3);
            Log.e("LocalClient", valueOf3.length() != 0 ? "Found hermetic configuration for identityToolkitV2 URL: ".concat(valueOf3) : new String("Found hermetic configuration for identityToolkitV2 URL: "));
        }
        if (this.zzc == null) {
            this.zzc = new zzts(zza3, zzw());
        }
    }

    private final zzuc zzw() {
        if (this.zza == null) {
            this.zza = new zzuc(this.zzf, this.zze.zza());
        }
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzvg
    public final void zza() {
        zzv(null, null, null);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzb(zzvv zzvvVar, zzup<zzwg> zzupVar) {
        Preconditions.checkNotNull(zzvvVar);
        Preconditions.checkNotNull(zzupVar);
        zzuu zzuuVar = this.zzd;
        zzur.zza(zzuuVar.zza("/token", this.zzg), zzvvVar, zzupVar, zzwg.class, zzuuVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzc(zzxj zzxjVar, zzup<zzxk> zzupVar) {
        Preconditions.checkNotNull(zzxjVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/verifyCustomToken", this.zzg), zzxjVar, zzupVar, zzxk.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzd(Context context, zzxg zzxgVar, zzup<zzxi> zzupVar) {
        Preconditions.checkNotNull(zzxgVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/verifyAssertion", this.zzg), zzxgVar, zzupVar, zzxi.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zze(zzwy zzwyVar, zzup<zzwz> zzupVar) {
        Preconditions.checkNotNull(zzwyVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/signupNewUser", this.zzg), zzwyVar, zzupVar, zzwz.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzf(Context context, zzxm zzxmVar, zzup<zzxn> zzupVar) {
        Preconditions.checkNotNull(zzxmVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/verifyPassword", this.zzg), zzxmVar, zzupVar, zzxn.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzg(zzwq zzwqVar, zzup<zzwr> zzupVar) {
        Preconditions.checkNotNull(zzwqVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/resetPassword", this.zzg), zzwqVar, zzupVar, zzwr.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzh(zzvw zzvwVar, zzup<zzvx> zzupVar) {
        Preconditions.checkNotNull(zzvwVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/getAccountInfo", this.zzg), zzvwVar, zzupVar, zzvx.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzi(zzww zzwwVar, zzup<zzwx> zzupVar) {
        Preconditions.checkNotNull(zzwwVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/setAccountInfo", this.zzg), zzwwVar, zzupVar, zzwx.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzj(zzvk zzvkVar, zzup<zzvl> zzupVar) {
        Preconditions.checkNotNull(zzvkVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/createAuthUri", this.zzg), zzvkVar, zzupVar, zzvl.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzk(zzwd zzwdVar, zzup<zzwe> zzupVar) {
        Preconditions.checkNotNull(zzwdVar);
        Preconditions.checkNotNull(zzupVar);
        if (zzwdVar.zzg() != null) {
            zzw().zzc(zzwdVar.zzg().zzd());
        }
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/getOobConfirmationCode", this.zzg), zzwdVar, zzupVar, zzwe.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzl(zzwt zzwtVar, zzup<zzwv> zzupVar) {
        Preconditions.checkNotNull(zzwtVar);
        Preconditions.checkNotNull(zzupVar);
        if (!TextUtils.isEmpty(zzwtVar.zze())) {
            zzw().zzc(zzwtVar.zze());
        }
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/sendVerificationCode", this.zzg), zzwtVar, zzupVar, zzwv.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzm(Context context, zzxo zzxoVar, zzup<zzxp> zzupVar) {
        Preconditions.checkNotNull(zzxoVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/verifyPhoneNumber", this.zzg), zzxoVar, zzupVar, zzxp.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzn(zzvn zzvnVar, zzup<Void> zzupVar) {
        Preconditions.checkNotNull(zzvnVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/deleteAccount", this.zzg), zzvnVar, zzupVar, Void.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzo(String str, zzup<Void> zzupVar) {
        Preconditions.checkNotNull(zzupVar);
        zzw().zzb(str);
        ((zzpa) zzupVar).zza.zzm();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzp(zzvo zzvoVar, zzup<zzvp> zzupVar) {
        Preconditions.checkNotNull(zzvoVar);
        Preconditions.checkNotNull(zzupVar);
        zztr zztrVar = this.zzb;
        zzur.zza(zztrVar.zza("/emailLinkSignin", this.zzg), zzvoVar, zzupVar, zzvp.class, zztrVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzq(zzxa zzxaVar, zzup<zzxb> zzupVar) {
        Preconditions.checkNotNull(zzxaVar);
        Preconditions.checkNotNull(zzupVar);
        if (!TextUtils.isEmpty(zzxaVar.zzc())) {
            zzw().zzc(zzxaVar.zzc());
        }
        zzts zztsVar = this.zzc;
        zzur.zza(zztsVar.zza("/mfaEnrollment:start", this.zzg), zzxaVar, zzupVar, zzxb.class, zztsVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzr(Context context, zzvq zzvqVar, zzup<zzvr> zzupVar) {
        Preconditions.checkNotNull(zzvqVar);
        Preconditions.checkNotNull(zzupVar);
        zzts zztsVar = this.zzc;
        zzur.zza(zztsVar.zza("/mfaEnrollment:finalize", this.zzg), zzvqVar, zzupVar, zzvr.class, zztsVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzs(zzxq zzxqVar, zzup<zzxr> zzupVar) {
        Preconditions.checkNotNull(zzxqVar);
        Preconditions.checkNotNull(zzupVar);
        zzts zztsVar = this.zzc;
        zzur.zza(zztsVar.zza("/mfaEnrollment:withdraw", this.zzg), zzxqVar, zzupVar, zzxr.class, zztsVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzt(zzxc zzxcVar, zzup<zzxd> zzupVar) {
        Preconditions.checkNotNull(zzxcVar);
        Preconditions.checkNotNull(zzupVar);
        if (!TextUtils.isEmpty(zzxcVar.zzc())) {
            zzw().zzc(zzxcVar.zzc());
        }
        zzts zztsVar = this.zzc;
        zzur.zza(zztsVar.zza("/mfaSignIn:start", this.zzg), zzxcVar, zzupVar, zzxd.class, zztsVar.zzb);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuq
    public final void zzu(Context context, zzvs zzvsVar, zzup<zzvt> zzupVar) {
        Preconditions.checkNotNull(zzvsVar);
        Preconditions.checkNotNull(zzupVar);
        zzts zztsVar = this.zzc;
        zzur.zza(zztsVar.zza("/mfaSignIn:finalize", this.zzg), zzvsVar, zzupVar, zzvt.class, zztsVar.zzb);
    }
}
