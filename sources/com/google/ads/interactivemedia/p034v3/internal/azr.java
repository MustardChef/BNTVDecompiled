package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azr */
/* loaded from: classes2.dex */
public final class azr {

    /* renamed from: a */
    private static final CopyOnWriteArrayList f5332a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static azq m4263a(String str) throws GeneralSecurityException {
        Iterator it = f5332a.iterator();
        while (it.hasNext()) {
            azq azqVar = (azq) it.next();
            if (azqVar.m4265a()) {
                return azqVar;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
