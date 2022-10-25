package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuk */
/* loaded from: classes3.dex */
public final class zzuk extends zztm {
    final /* synthetic */ zzun zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuk(zzun zzunVar) {
        this.zza = zzunVar;
    }

    private final void zzb(Status status, AuthCredential authCredential, String str, String str2) {
        zzun.zzn(this.zza, status);
        zzun zzunVar = this.zza;
        zzunVar.zzp = authCredential;
        zzunVar.zzq = str;
        zzunVar.zzr = str2;
        zzao zzaoVar = zzunVar.zzg;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
        this.zza.zzk(status);
    }

    private final void zzc(zzul zzulVar) {
        this.zza.zzi.execute(new zzuj(this, zzulVar));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzd(zzwg zzwgVar) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 1;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzj = zzwgVar;
        zzun.zzl(zzunVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zze(zzwg zzwgVar, zzvz zzvzVar) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzj = zzwgVar;
        zzunVar.zzk = zzvzVar;
        zzun.zzl(zzunVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzf(zzvl zzvlVar) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 3;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzl = zzvlVar;
        zzun.zzl(zzunVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzg(zzwr zzwrVar) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 4;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzm = zzwrVar;
        zzun.zzl(zzunVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzun zzunVar = this.zza;
        if (zzunVar.zzb == 8) {
            zzunVar.zza = true;
            zzc(new zzui(this, status));
            return;
        }
        zzun.zzn(zzunVar, status);
        this.zza.zzk(status);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzi() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 5;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun.zzl(this.zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzj() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 6;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun.zzl(this.zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzk(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 7;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzn = str;
        zzun.zzl(zzunVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzl(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zzo = str;
        zzc(new zzuf(this, str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzm(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zza.zza = true;
        zzc(new zzug(this, phoneAuthCredential));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzn(String str) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun zzunVar = this.zza;
        zzunVar.zzo = str;
        zzunVar.zza = true;
        zzc(new zzuh(this, str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzo(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzb(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzp() throws RemoteException {
        int i = this.zza.zzb;
        boolean z = i == 9;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzun.zzl(this.zza);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzq(zzno zznoVar) {
        zzb(zznoVar.zza(), zznoVar.zzb(), zznoVar.zzc(), zznoVar.zzd());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztn
    public final void zzr(zznq zznqVar) {
        zzun zzunVar = this.zza;
        zzunVar.zzs = zznqVar;
        zzunVar.zzk(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }
}
