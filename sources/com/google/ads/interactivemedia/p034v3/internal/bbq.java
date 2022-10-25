package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbq */
/* loaded from: classes2.dex */
public final class bbq {

    /* renamed from: a */
    private static final Logger f5399a = Logger.getLogger(bbq.class.getName());

    /* renamed from: b */
    private static final AtomicBoolean f5400b = new AtomicBoolean(false);

    private bbq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Boolean m4199a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            f5399a.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4198b() {
        return f5400b.get();
    }
}
