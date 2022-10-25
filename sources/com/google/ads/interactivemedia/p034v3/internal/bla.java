package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.bla;
import com.google.ads.interactivemedia.p034v3.internal.blb;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bla */
/* loaded from: classes2.dex */
public abstract class bla<MessageType extends blb<MessageType, BuilderType>, BuilderType extends bla<MessageType, BuilderType>> implements boi {
    @Override // 
    /* renamed from: aK */
    public abstract bla clone();

    /* renamed from: aL */
    protected abstract bla mo3310aL(blb blbVar);

    @Override // com.google.ads.interactivemedia.p034v3.internal.boi
    /* renamed from: aM */
    public final /* bridge */ /* synthetic */ boi mo3180aM(boj bojVar) {
        if (!mo3171aT().getClass().isInstance(bojVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return mo3310aL((blb) bojVar);
    }

    /* renamed from: aN */
    public void mo3309aN(byte[] bArr, int i, bmr bmrVar) throws bnm {
        throw null;
    }
}
