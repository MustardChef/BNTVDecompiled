package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zznl;
import com.google.android.gms.internal.cast.zznm;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zznl<MessageType extends zznm<MessageType, BuilderType>, BuilderType extends zznl<MessageType, BuilderType>> implements zzpx {
    @Override // 
    /* renamed from: zzj */
    public abstract BuilderType clone();

    protected abstract BuilderType zzk(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzpx
    public final /* bridge */ /* synthetic */ zzpx zzl(zzpy zzpyVar) {
        if (!zzs().getClass().isInstance(zzpyVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zzk((zznm) zzpyVar);
    }
}
