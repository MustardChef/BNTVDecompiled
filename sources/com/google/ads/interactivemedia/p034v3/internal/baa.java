package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.baa */
/* loaded from: classes2.dex */
public final class baa implements bad {

    /* renamed from: a */
    final /* synthetic */ azo f5364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public baa(azo azoVar) {
        this.f5364a = azoVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: a */
    public final azh mo4247a(Class cls) throws GeneralSecurityException {
        try {
            return new azj(this.f5364a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: b */
    public final azh mo4246b() {
        azo azoVar = this.f5364a;
        return new azj(azoVar, azoVar.m4271c());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: c */
    public final Class mo4245c() {
        return this.f5364a.getClass();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: d */
    public final Class mo4244d() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: e */
    public final Set mo4243e() {
        return this.f5364a.m4268g();
    }
}
