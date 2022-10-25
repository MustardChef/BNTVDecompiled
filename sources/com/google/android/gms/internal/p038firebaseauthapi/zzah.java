package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzah */
/* loaded from: classes3.dex */
public final class zzah implements zzav {
    private final OutputStream zza;

    private zzah(OutputStream outputStream, boolean z) {
        this.zza = outputStream;
    }

    public static zzav zza(OutputStream outputStream) {
        return new zzah(outputStream, false);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzav
    public final void zzc(zzgy zzgyVar) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzav
    public final void zzb(zzib zzibVar) throws IOException {
        zzibVar.zzp(this.zza);
    }
}
