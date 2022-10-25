package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akg */
/* loaded from: classes2.dex */
public final class akg implements aye {

    /* renamed from: a */
    final /* synthetic */ String f4293a;

    /* renamed from: b */
    final /* synthetic */ akk f4294b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akg(akk akkVar, String str) {
        this.f4294b = akkVar;
        this.f4293a = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aye
    /* renamed from: a */
    public final void mo4334a(Throwable th) {
        C2525p.m5990b("Failure to make Native-layer network request", th);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aye
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo4333b(Object obj) {
        akc akcVar;
        ajq ajqVar = new ajq(ajo.nativeXhr, ajp.nativeResponse, this.f4293a, (AbstractC2500br) obj);
        akcVar = this.f4294b.f4298b;
        akcVar.mo5122o(ajqVar);
    }
}
