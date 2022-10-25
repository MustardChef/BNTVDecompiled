package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class PhoneMultiFactorAssertion extends MultiFactorAssertion {
    private final PhoneAuthCredential zza;

    public PhoneMultiFactorAssertion(PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(phoneAuthCredential);
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.MultiFactorAssertion
    public String getFactorId() {
        return "phone";
    }

    public final PhoneAuthCredential zza() {
        return this.zza;
    }
}
