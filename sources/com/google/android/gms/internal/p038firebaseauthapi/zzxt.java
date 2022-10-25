package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzxt;
import com.google.android.gms.internal.p038firebaseauthapi.zzxu;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt */
/* loaded from: classes3.dex */
public abstract class zzxt<MessageType extends zzxu<MessageType, BuilderType>, BuilderType extends zzxt<MessageType, BuilderType>> implements zzaaq {
    @Override // 
    /* renamed from: zzf */
    public abstract BuilderType clone();

    protected abstract BuilderType zzg(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaq
    public final /* bridge */ /* synthetic */ zzaaq zzh(zzaar zzaarVar) {
        if (zzo().getClass().isInstance(zzaarVar)) {
            return zzg((zzxu) zzaarVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
