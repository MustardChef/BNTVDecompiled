package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.baf */
/* loaded from: classes2.dex */
public final class baf {
    static {
        Charset.forName("UTF-8");
    }

    /* renamed from: a */
    public static bei m4221a(beg begVar) {
        bep m3902d = bei.m3902d();
        m3902d.m3812l(begVar.m3915b());
        for (bef befVar : begVar.m3912e()) {
            bep m3906f = beh.m3906f();
            m3906f.m3816h(befVar.m3921b().m3945d());
            m3906f.m3814j(befVar.m3918e());
            m3906f.m3815i(befVar.m3917f());
            m3906f.m3817g(befVar.m3922a());
            m3902d.m3813k((beh) m3906f.mo3179aR());
        }
        return (bei) m3902d.mo3179aR();
    }

    /* renamed from: b */
    public static void m4220b(beg begVar) throws GeneralSecurityException {
        int m3915b = begVar.m3915b();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (bef befVar : begVar.m3912e()) {
            if (befVar.m3918e() == bec.f5548b) {
                if (befVar.m3919d()) {
                    if (befVar.m3917f() != ben.f5590a) {
                        if (befVar.m3918e() != bec.f5547a) {
                            if (befVar.m3922a() == m3915b) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            z2 &= befVar.m3921b().m3942g() == bea.f5539d;
                            i++;
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(befVar.m3922a())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(befVar.m3922a())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(befVar.m3922a())));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
