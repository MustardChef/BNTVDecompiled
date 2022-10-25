package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzaar;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzan */
/* loaded from: classes3.dex */
final class zzan<KeyFormatProtoT extends zzaar, KeyProtoT extends zzaar> {
    final zzaq<KeyFormatProtoT, KeyProtoT> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzaq<KeyFormatProtoT, KeyProtoT> zzaqVar) {
        this.zza = zzaqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyProtoT zza(zzym zzymVar) throws GeneralSecurityException, zzzw {
        KeyFormatProtoT zzc = this.zza.zzc(zzymVar);
        this.zza.zzb(zzc);
        return this.zza.zzd(zzc);
    }
}
