package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzaar;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe */
/* loaded from: classes3.dex */
public final class zzbe<PrimitiveT, KeyProtoT extends zzaar, PublicKeyProtoT extends zzaar> extends zzao<PrimitiveT, KeyProtoT> implements zzam {
    private final zzbf<KeyProtoT, PublicKeyProtoT> zza;
    private final zzas<PublicKeyProtoT> zzb;

    public zzbe(zzbf<KeyProtoT, PublicKeyProtoT> zzbfVar, zzas<PublicKeyProtoT> zzasVar, Class<PrimitiveT> cls) {
        super(zzbfVar, cls);
        this.zza = zzbfVar;
        this.zzb = zzasVar;
    }

    public final zzho zze(zzym zzymVar) throws GeneralSecurityException {
        try {
            zzgn zzd = zzgn.zzd(zzymVar, zzzb.zza());
            zzcx.zzj(zzd);
            zzgq zzb = zzd.zzb();
            this.zzb.zze(zzb);
            zzhl zzd2 = zzho.zzd();
            zzd2.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
            zzd2.zzb(zzb.zzn());
            zzd2.zzc(zzhn.ASYMMETRIC_PUBLIC);
            return zzd2.zzl();
        } catch (zzzw e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
