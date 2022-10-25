package com.google.android.gms.internal.p038firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzun */
/* loaded from: classes3.dex */
public abstract class zzun<ResultT, CallbackT> implements zzpn<zztc, ResultT> {
    private boolean zza;
    protected final int zzb;
    protected FirebaseApp zzd;
    protected FirebaseUser zze;
    protected CallbackT zzf;
    protected zzao zzg;
    protected Executor zzi;
    protected zzwg zzj;
    protected zzvz zzk;
    protected zzvl zzl;
    protected zzwr zzm;
    protected String zzn;
    protected String zzo;
    protected AuthCredential zzp;
    protected String zzq;
    protected String zzr;
    protected zznq zzs;
    ResultT zzt;
    Status zzu;
    protected zzum zzv;
    final zzuk zzc = new zzuk(this);
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzh = new ArrayList();

    public zzun(int i) {
        this.zzb = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzun zzunVar) {
        zzunVar.zzc();
        Preconditions.checkState(zzunVar.zza, "no success or failure set on method implementation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzun zzunVar, Status status) {
        zzao zzaoVar = zzunVar.zzg;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
    }

    public abstract void zzc();

    public final zzun<ResultT, CallbackT> zze(FirebaseApp firebaseApp) {
        this.zzd = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzun<ResultT, CallbackT> zzf(FirebaseUser firebaseUser) {
        this.zze = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzun<ResultT, CallbackT> zzg(CallbackT callbackt) {
        this.zzf = (CallbackT) Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public final zzun<ResultT, CallbackT> zzh(zzao zzaoVar) {
        this.zzg = (zzao) Preconditions.checkNotNull(zzaoVar, "external failure callback cannot be null");
        return this;
    }

    public final zzun<ResultT, CallbackT> zzi(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc = zzux.zzc(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            this.zzh.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zzc));
        }
        if (activity != null) {
            zzue.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzj(ResultT resultt) {
        this.zza = true;
        this.zzt = resultt;
        this.zzv.zza(resultt, null);
    }

    public final void zzk(Status status) {
        this.zza = true;
        this.zzu = status;
        this.zzv.zza(null, status);
    }
}
