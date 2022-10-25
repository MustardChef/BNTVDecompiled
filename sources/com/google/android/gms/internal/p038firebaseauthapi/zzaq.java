package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzaar;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq */
/* loaded from: classes3.dex */
public abstract class zzaq<KeyFormatProtoT extends zzaar, KeyT> {
    private final Class<KeyFormatProtoT> zza;

    public zzaq(Class<KeyFormatProtoT> cls) {
        this.zza = cls;
    }

    public final Class<KeyFormatProtoT> zza() {
        return this.zza;
    }

    public abstract void zzb(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract KeyFormatProtoT zzc(zzym zzymVar) throws zzzw;

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
}
