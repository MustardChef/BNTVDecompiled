package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf */
/* loaded from: classes3.dex */
public final class zztf extends zztp {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzpj zzb;
    private final zzvd zzc;

    public zztf(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = new zzpj(new zzub(context, Preconditions.checkNotEmpty(str), zzua.zzb(), null, null, null));
        this.zzc = new zzvd(context);
    }

    private static boolean zzH(long j, boolean z) {
        if (j <= 0 || !z) {
            zza.m339w("App hash will not be appended to the request.", new Object[0]);
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzA(zzmw zzmwVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmwVar);
        Preconditions.checkNotNull(zzmwVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzk(zzmwVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzB(zzna zznaVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zznaVar);
        Preconditions.checkNotNull(zztnVar);
        String zzb = zznaVar.zzb();
        zztb zztbVar = new zztb(zztnVar, zza);
        if (this.zzc.zza(zzb)) {
            if (zznaVar.zze()) {
                this.zzc.zze(zzb);
            } else {
                this.zzc.zzc(zztbVar, zzb);
                return;
            }
        }
        long zzd = zznaVar.zzd();
        boolean zzh = zznaVar.zzh();
        zzxa zzb2 = zzxa.zzb(zznaVar.zza(), zznaVar.zzb(), zznaVar.zzc(), zznaVar.zzg(), zznaVar.zzf());
        if (zzH(zzd, zzh)) {
            zzb2.zzd(new zzvi(this.zzc.zzd()));
        }
        this.zzc.zzb(zzb, zztbVar, zzd, zzh);
        this.zzb.zzy(zzb2, new zzva(this.zzc, zztbVar, zzb));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzC(zzlq zzlqVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzlqVar);
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzz(null, zzvq.zzb(zzlqVar.zzb(), zzlqVar.zza().zzd(), zzlqVar.zza().getSmsCode(), zzlqVar.zzc()), zzlqVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzD(zzne zzneVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzneVar);
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzx(zzneVar.zza(), zzneVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzE(zznc zzncVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzncVar);
        Preconditions.checkNotNull(zztnVar);
        String phoneNumber = zzncVar.zza().getPhoneNumber();
        zztb zztbVar = new zztb(zztnVar, zza);
        if (this.zzc.zza(phoneNumber)) {
            if (zzncVar.zze()) {
                this.zzc.zze(phoneNumber);
            } else {
                this.zzc.zzc(zztbVar, phoneNumber);
                return;
            }
        }
        long zzd = zzncVar.zzd();
        boolean zzh = zzncVar.zzh();
        zzxc zzb = zzxc.zzb(zzncVar.zzb(), zzncVar.zza().getUid(), zzncVar.zza().getPhoneNumber(), zzncVar.zzc(), zzncVar.zzg(), zzncVar.zzf());
        if (zzH(zzd, zzh)) {
            zzb.zzd(new zzvi(this.zzc.zzd()));
        }
        this.zzc.zzb(phoneNumber, zztbVar, zzd, zzh);
        this.zzb.zzB(zzb, new zzva(this.zzc, zztbVar, phoneNumber));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzF(zzls zzlsVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzlsVar);
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzA(null, zzvs.zzb(zzlsVar.zzb(), zzlsVar.zza().zzd(), zzlsVar.zza().getSmsCode()), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzG(zznm zznmVar, zztn zztnVar) {
        Preconditions.checkNotNull(zznmVar);
        this.zzb.zzC(zzwd.zzb(zznmVar.zzc(), zznmVar.zza(), zznmVar.zzb()), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzb(zzlu zzluVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzluVar);
        Preconditions.checkNotNull(zztnVar);
        Preconditions.checkNotEmpty(zzluVar.zza());
        this.zzb.zza(zzluVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzc(zzms zzmsVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmsVar);
        Preconditions.checkNotEmpty(zzmsVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzb(new zzxj(zzmsVar.zza(), zzmsVar.zzb()), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzd(zzmq zzmqVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmqVar);
        Preconditions.checkNotNull(zzmqVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzc(null, zzmqVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zze(zznk zznkVar, zztn zztnVar) {
        Preconditions.checkNotNull(zznkVar);
        Preconditions.checkNotEmpty(zznkVar.zzb());
        Preconditions.checkNotNull(zznkVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zze(zznkVar.zzb(), zznkVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzf(zzle zzleVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzleVar);
        Preconditions.checkNotEmpty(zzleVar.zza());
        Preconditions.checkNotEmpty(zzleVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzf(zzleVar.zza(), zzleVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzg(zzlg zzlgVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzlgVar);
        Preconditions.checkNotEmpty(zzlgVar.zza());
        Preconditions.checkNotEmpty(zzlgVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzg(zzlgVar.zza(), zzlgVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzh(zzlm zzlmVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzlmVar);
        Preconditions.checkNotEmpty(zzlmVar.zza());
        Preconditions.checkNotEmpty(zzlmVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzi(zzlmVar.zza(), zzlmVar.zzb(), zzlmVar.zzc(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzi(zzmu zzmuVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmuVar);
        Preconditions.checkNotEmpty(zzmuVar.zza());
        Preconditions.checkNotEmpty(zzmuVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzj(null, zzmuVar.zza(), zzmuVar.zzb(), zzmuVar.zzc(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzj(zzlw zzlwVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzlwVar);
        Preconditions.checkNotEmpty(zzlwVar.zza());
        this.zzb.zzl(zzlwVar.zza(), zzlwVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzk(zzly zzlyVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzlyVar);
        Preconditions.checkNotEmpty(zzlyVar.zza());
        Preconditions.checkNotEmpty(zzlyVar.zzb());
        Preconditions.checkNotEmpty(zzlyVar.zzc());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzs(zzlyVar.zza(), zzlyVar.zzb(), zzlyVar.zzc(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzl(zzma zzmaVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmaVar);
        Preconditions.checkNotEmpty(zzmaVar.zza());
        Preconditions.checkNotNull(zzmaVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzu(zzmaVar.zza(), zzmaVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzm(zzng zzngVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzngVar);
        Preconditions.checkNotEmpty(zzngVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzv(zzngVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzn(zzni zzniVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzniVar);
        Preconditions.checkNotEmpty(zzniVar.zza());
        Preconditions.checkNotEmpty(zzniVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzw(zzniVar.zza(), zzniVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzo(zzme zzmeVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzmeVar);
        Preconditions.checkNotEmpty(zzmeVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzD(zzmeVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzp(zzmo zzmoVar, zztn zztnVar) {
        Preconditions.checkNotNull(zzmoVar);
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzd(zzmoVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzq(zzlo zzloVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzloVar);
        Preconditions.checkNotEmpty(zzloVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzE(zzloVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzr(zzli zzliVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzliVar);
        Preconditions.checkNotEmpty(zzliVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzo(zzliVar.zza(), zzliVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzs(zzlc zzlcVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzlcVar);
        Preconditions.checkNotEmpty(zzlcVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzh(zzlcVar.zza(), zzlcVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzt(zzlk zzlkVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzlkVar);
        Preconditions.checkNotEmpty(zzlkVar.zza());
        Preconditions.checkNotEmpty(zzlkVar.zzb());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzp(zzlkVar.zza(), zzlkVar.zzb(), zzlkVar.zzc(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzu(zzmk zzmkVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zztnVar);
        Preconditions.checkNotNull(zzmkVar);
        zzwt zzwtVar = (zzwt) Preconditions.checkNotNull(zzmkVar.zza());
        String zzb = zzwtVar.zzb();
        zztb zztbVar = new zztb(zztnVar, zza);
        if (this.zzc.zza(zzb)) {
            if (zzwtVar.zzd()) {
                this.zzc.zze(zzb);
            } else {
                this.zzc.zzc(zztbVar, zzb);
                return;
            }
        }
        long zzc = zzwtVar.zzc();
        boolean zzf = zzwtVar.zzf();
        if (zzH(zzc, zzf)) {
            zzwtVar.zzg(new zzvi(this.zzc.zzd()));
        }
        this.zzc.zzb(zzb, zztbVar, zzc, zzf);
        this.zzb.zzq(zzwtVar, new zzva(this.zzc, zztbVar, zzb));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzv(zzmy zzmyVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zztnVar);
        Preconditions.checkNotNull(zzmyVar);
        this.zzb.zzr(null, zzut.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzmyVar.zza())), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzw(zzmc zzmcVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zztnVar);
        Preconditions.checkNotNull(zzmcVar);
        this.zzb.zzt(null, Preconditions.checkNotEmpty(zzmcVar.zza()), zzut.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzmcVar.zzb())), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzx(zzmg zzmgVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzmgVar);
        Preconditions.checkNotEmpty(zzmgVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzn(zzmgVar.zza(), zzmgVar.zzb(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzy(zzmm zzmmVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzmmVar);
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzF(zzmmVar.zza(), new zztb(zztnVar, zza));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztq
    public final void zzz(zzmi zzmiVar, zztn zztnVar) throws RemoteException {
        Preconditions.checkNotNull(zzmiVar);
        Preconditions.checkNotEmpty(zzmiVar.zza());
        Preconditions.checkNotNull(zztnVar);
        this.zzb.zzm(zzmiVar.zza(), zzmiVar.zzb(), zzmiVar.zzc(), new zztb(zztnVar, zza));
    }
}
