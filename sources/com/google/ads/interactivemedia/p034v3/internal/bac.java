package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bac */
/* loaded from: classes2.dex */
public final class bac {
    /* renamed from: a */
    public static azk m4248a(String str) throws GeneralSecurityException {
        if (!bae.m4234i().containsKey(str)) {
            throw new GeneralSecurityException(str.length() != 0 ? "cannot find key template: ".concat(str) : new String("cannot find key template: "));
        }
        return (azk) bae.m4234i().get(str);
    }
}
