package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azp */
/* loaded from: classes2.dex */
public final class azp {

    /* renamed from: a */
    private final beg f5331a;

    private azp(beg begVar) {
        this.f5331a = begVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static final azp m4267a(beg begVar) throws GeneralSecurityException {
        if (begVar == null || begVar.m3916a() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new azp(begVar);
    }

    /* renamed from: b */
    public final Object m4266b(Class cls) throws GeneralSecurityException {
        Class m4239d = bae.m4239d(cls);
        if (m4239d == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        baf.m4220b(this.f5331a);
        azw m4255c = azw.m4255c(m4239d);
        for (bef befVar : this.f5331a.m3912e()) {
            if (befVar.m3918e() == bec.f5548b) {
                azu m4257a = m4255c.m4257a(bae.m4238e(befVar.m3921b(), m4239d), befVar);
                if (befVar.m3922a() == this.f5331a.m3915b()) {
                    m4255c.m4253e(m4257a);
                }
            }
        }
        return bae.m4235h(m4255c, cls);
    }

    public final String toString() {
        return baf.m4221a(this.f5331a).toString();
    }
}
