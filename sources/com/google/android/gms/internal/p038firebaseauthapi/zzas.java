package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzaar;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzas */
/* loaded from: classes3.dex */
public abstract class zzas<KeyProtoT extends zzaar> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzar<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzas(Class<KeyProtoT> cls, zzar<?, KeyProtoT>... zzarVarArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            zzar<?, KeyProtoT> zzarVar = zzarVarArr[i];
            if (!hashMap.containsKey(zzarVar.zza())) {
                hashMap.put(zzarVar.zza(), zzarVar);
            } else {
                String valueOf = String.valueOf(zzarVar.zza().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
        }
        this.zzc = zzarVarArr[0].zza();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> zza() {
        return this.zza;
    }

    public abstract String zzb();

    public abstract zzhn zzc();

    public abstract KeyProtoT zzd(zzym zzymVar) throws zzzw;

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final <P> P zzf(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzar<?, KeyProtoT> zzarVar = this.zzb.get(cls);
        if (zzarVar == null) {
            String canonicalName = cls.getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
            sb.append("Requested primitive class ");
            sb.append(canonicalName);
            sb.append(" not supported.");
            throw new IllegalArgumentException(sb.toString());
        }
        return (P) zzarVar.zzb(keyprotot);
    }

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<?> zzh() {
        return this.zzc;
    }

    public zzaq<?, KeyProtoT> zzi() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
