package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    private AuthCredential zza;
    private String zzb;
    private String zzc;

    public FirebaseAuthUserCollisionException(String str, String str2) {
        super(str, str2);
    }

    public String getEmail() {
        return this.zzb;
    }

    public AuthCredential getUpdatedCredential() {
        return this.zza;
    }

    public final FirebaseAuthUserCollisionException zza(String str) {
        this.zzb = str;
        return this;
    }

    public final FirebaseAuthUserCollisionException zzb(AuthCredential authCredential) {
        this.zza = authCredential;
        return this;
    }

    public final FirebaseAuthUserCollisionException zzc(String str) {
        this.zzc = str;
        return this;
    }
}
