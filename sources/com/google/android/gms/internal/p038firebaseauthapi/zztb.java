package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztb */
/* loaded from: classes3.dex */
public class zztb {
    private final zztn zza;
    private final Logger zzb;

    public zztb(zztb zztbVar) {
        this(zztbVar.zza, zztbVar.zzb);
    }

    public final void zza(zzwg zzwgVar) {
        try {
            this.zza.zzd(zzwgVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zzb(zzwg zzwgVar, zzvz zzvzVar) {
        try {
            this.zza.zze(zzwgVar, zzvzVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zzc(zzvl zzvlVar) {
        try {
            this.zza.zzf(zzvlVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zzd(zzwr zzwrVar) {
        try {
            this.zza.zzg(zzwrVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zze() {
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzf() {
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzg(String str) {
        try {
            this.zza.zzk(str);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public void zzh(String str) {
        try {
            this.zza.zzl(str);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zzi(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzm(phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }

    public final void zzj(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }

    public void zzk(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzl(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzo(status, phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zzn(zzno zznoVar) {
        try {
            this.zza.zzq(zznoVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zzo(zznq zznqVar) {
        try {
            this.zza.zzr(zznqVar);
        } catch (RemoteException e) {
            this.zzb.m344e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public zztb(zztn zztnVar, Logger logger) {
        this.zza = (zztn) Preconditions.checkNotNull(zztnVar);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }
}
