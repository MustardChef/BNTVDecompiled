package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bke */
/* loaded from: classes2.dex */
final class bke extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        return new AtomicBoolean(bkvVar.mo3575q());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        bkxVar.mo3553l(((AtomicBoolean) obj).get());
    }
}
