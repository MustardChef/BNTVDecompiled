package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvu */
/* loaded from: classes3.dex */
public enum zzvu {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzc;

    zzvu(String str) {
        this.zzc = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzc;
    }
}
