package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amz */
/* loaded from: classes2.dex */
public final class amz implements asg {

    /* renamed from: a */
    final /* synthetic */ ana f4684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public amz(ana anaVar) {
        this.f4684a = anaVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asg
    /* renamed from: a */
    public final void mo4691a(int i, long j) {
        art artVar;
        artVar = this.f4684a.f4690d;
        artVar.m4726d(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asg
    /* renamed from: b */
    public final void mo4690b(int i, long j, String str) {
        art artVar;
        artVar = this.f4684a.f4690d;
        artVar.m4725e(i, System.currentTimeMillis() - j, str);
    }
}
