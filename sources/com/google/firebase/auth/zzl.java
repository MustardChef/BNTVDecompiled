package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzl implements Runnable {
    final /* synthetic */ InternalTokenResult zza;
    final /* synthetic */ FirebaseAuth zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zzb = firebaseAuth;
        this.zza = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<IdTokenListener> list;
        List<FirebaseAuth.IdTokenListener> list2;
        list = this.zzb.zzc;
        for (IdTokenListener idTokenListener : list) {
            idTokenListener.onIdTokenChanged(this.zza);
        }
        list2 = this.zzb.zzb;
        for (FirebaseAuth.IdTokenListener idTokenListener2 : list2) {
            idTokenListener2.onIdTokenChanged(this.zzb);
        }
    }
}
