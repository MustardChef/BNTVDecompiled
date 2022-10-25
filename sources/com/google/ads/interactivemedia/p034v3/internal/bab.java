package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bab */
/* loaded from: classes2.dex */
public final class bab implements bad {

    /* renamed from: a */
    final /* synthetic */ azy f5365a;

    /* renamed from: b */
    final /* synthetic */ azo f5366b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bab(azy azyVar, azo azoVar) {
        this.f5365a = azyVar;
        this.f5366b = azoVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: a */
    public final azh mo4247a(Class cls) throws GeneralSecurityException {
        try {
            return new azj(this.f5365a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: b */
    public final azh mo4246b() {
        azy azyVar = this.f5365a;
        return new azj(azyVar, azyVar.m4271c());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: c */
    public final Class mo4245c() {
        return this.f5365a.getClass();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: d */
    public final Class mo4244d() {
        return this.f5366b.getClass();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: e */
    public final Set mo4243e() {
        return this.f5365a.m4268g();
    }
}
