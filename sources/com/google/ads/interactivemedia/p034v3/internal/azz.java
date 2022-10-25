package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azz */
/* loaded from: classes2.dex */
public final class azz implements bad {

    /* renamed from: a */
    final /* synthetic */ azh f5341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public azz(azh azhVar) {
        this.f5341a = azhVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: a */
    public final azh mo4247a(Class cls) throws GeneralSecurityException {
        if (this.f5341a.mo4283c().equals(cls)) {
            return this.f5341a;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: b */
    public final azh mo4246b() {
        return this.f5341a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: c */
    public final Class mo4245c() {
        return this.f5341a.getClass();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: d */
    public final Class mo4244d() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bad
    /* renamed from: e */
    public final Set mo4243e() {
        return Collections.singleton(this.f5341a.mo4283c());
    }
}
