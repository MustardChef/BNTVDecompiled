package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azj */
/* loaded from: classes2.dex */
public final class azj implements azh {

    /* renamed from: a */
    private final azo f5321a;

    /* renamed from: b */
    private final Class f5322b;

    public azj(azo azoVar, Class cls) {
        if (!azoVar.m4268g().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", azoVar.toString(), cls.getName()));
        }
        this.f5321a = azoVar;
        this.f5322b = cls;
    }

    /* renamed from: g */
    private final azi m4279g() {
        return new azi(this.f5321a.mo4173a());
    }

    /* renamed from: h */
    private final Object m4278h(boj bojVar) throws GeneralSecurityException {
        if (Void.class.equals(this.f5322b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.f5321a.mo4170h(bojVar);
        return this.f5321a.m4269e(bojVar, this.f5322b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: a */
    public final beb mo4285a(bls blsVar) throws GeneralSecurityException {
        try {
            boj m4286a = m4279g().m4286a(blsVar);
            bep m3940j = beb.m3940j();
            m3940j.m3808p(mo4280f());
            m3940j.m3807q(m4286a.mo3177ap());
            m3940j.m3806r(this.f5321a.mo4168j());
            return (beb) m3940j.mo3179aR();
        } catch (bnm e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: b */
    public final boj mo4284b(bls blsVar) throws GeneralSecurityException {
        try {
            return m4279g().m4286a(blsVar);
        } catch (bnm e) {
            String valueOf = String.valueOf(this.f5321a.mo4173a().m4273b().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: c */
    public final Class mo4283c() {
        return this.f5322b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: d */
    public final Object mo4282d(bls blsVar) throws GeneralSecurityException {
        try {
            return m4278h(this.f5321a.mo4172b(blsVar));
        } catch (bnm e) {
            String valueOf = String.valueOf(this.f5321a.m4270d().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: e */
    public final Object mo4281e(boj bojVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.f5321a.m4270d().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.f5321a.m4270d().isInstance(bojVar)) {
            return m4278h(bojVar);
        }
        throw new GeneralSecurityException(concat);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.azh
    /* renamed from: f */
    public final String mo4280f() {
        return this.f5321a.mo4171f();
    }

    public azj(azy azyVar, Class cls) {
        this((azo) azyVar, cls);
    }
}
