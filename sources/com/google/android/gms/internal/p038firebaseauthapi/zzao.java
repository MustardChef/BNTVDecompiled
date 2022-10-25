package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzaar;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao */
/* loaded from: classes3.dex */
public class zzao<PrimitiveT, KeyProtoT extends zzaar> implements zzam<PrimitiveT> {
    private final zzas<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzao(zzas<KeyProtoT> zzasVar, Class<PrimitiveT> cls) {
        if (!zzasVar.zzg().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzasVar.toString(), cls.getName()));
        }
        this.zza = zzasVar;
        this.zzb = cls;
    }

    private final PrimitiveT zze(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.zzb)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zza.zze(keyprotot);
        return (PrimitiveT) this.zza.zzf(keyprotot, (Class<PrimitiveT>) this.zzb);
    }

    private final zzan<?, KeyProtoT> zzf() {
        return new zzan<>(this.zza.zzi());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzam
    public final PrimitiveT zza(zzym zzymVar) throws GeneralSecurityException {
        try {
            return zze(this.zza.zzd(zzymVar));
        } catch (zzzw e) {
            String valueOf = String.valueOf(this.zza.zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzam
    public final PrimitiveT zzb(zzaar zzaarVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zza.zza().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zza.zza().isInstance(zzaarVar)) {
            return zze(zzaarVar);
        }
        throw new GeneralSecurityException(concat);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzam
    public final zzaar zzc(zzym zzymVar) throws GeneralSecurityException {
        try {
            return zzf().zza(zzymVar);
        } catch (zzzw e) {
            String valueOf = String.valueOf(this.zza.zzi().zza().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzam
    public final zzho zzd(zzym zzymVar) throws GeneralSecurityException {
        try {
            KeyProtoT zza = zzf().zza(zzymVar);
            zzhl zzd = zzho.zzd();
            zzd.zza(this.zza.zzb());
            zzd.zzb(zza.zzn());
            zzd.zzc(this.zza.zzc());
            return zzd.zzl();
        } catch (zzzw e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
