package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzu */
/* loaded from: classes3.dex */
final class zzu extends zzs implements Serializable {
    private final Pattern zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(Pattern pattern) {
        Objects.requireNonNull(pattern);
        this.zza = pattern;
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzs
    public final zzr zza(CharSequence charSequence) {
        return new zzt(this.zza.matcher(charSequence));
    }
}
