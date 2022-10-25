package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzm implements Runnable {
    final /* synthetic */ FirebaseAuth zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<FirebaseAuth.AuthStateListener> list;
        list = this.zza.zzd;
        for (FirebaseAuth.AuthStateListener authStateListener : list) {
            authStateListener.onAuthStateChanged(this.zza);
        }
    }
}
