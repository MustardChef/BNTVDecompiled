package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzac extends MultiFactor {
    private final zzx zza;

    public zzac(zzx zzxVar) {
        Preconditions.checkNotNull(zzxVar);
        this.zza = zzxVar;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(multiFactorAssertion);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zzd()).zzA(zzxVar, multiFactorAssertion, str);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzr();
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).continueWithTask(new zzab(this));
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        Preconditions.checkNotNull(multiFactorInfo);
        String uid = multiFactorInfo.getUid();
        Preconditions.checkNotEmpty(uid);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zzd()).zzu(zzxVar, uid);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task<Void> unenroll(String str) {
        Preconditions.checkNotEmpty(str);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zzd()).zzu(zzxVar, str);
    }
}
