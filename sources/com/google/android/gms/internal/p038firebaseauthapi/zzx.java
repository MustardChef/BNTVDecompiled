package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzx */
/* loaded from: classes3.dex */
final class zzx {
    private static final Logger zza = Logger.getLogger(zzx.class.getName());
    private static final zzw zzb = new zzw(null);

    private zzx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzs zzb(String str) {
        return new zzu(Pattern.compile("[.-]"));
    }
}
