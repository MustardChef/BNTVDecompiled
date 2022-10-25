package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dn */
/* loaded from: classes2.dex */
public class C2652dn extends C2639da {
    public C2652dn() {
        super(m2476b(2008, 1));
    }

    /* renamed from: a */
    public static C2652dn m2477a(IOException iOException, C2642dd c2642dd, int i) {
        String message = iOException.getMessage();
        int i2 = 2001;
        if (iOException instanceof SocketTimeoutException) {
            i2 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = 1004;
        } else if (message != null && anx.m4881c(message).matches("cleartext.*not permitted.*")) {
            i2 = 2007;
        }
        if (i2 == 2007) {
            return new C2651dm(iOException, c2642dd);
        }
        return new C2652dn(iOException, i2, i);
    }

    /* renamed from: b */
    private static int m2476b(int i, int i2) {
        return i == 2000 ? i2 != 1 ? 2000 : 2001 : i;
    }

    public C2652dn(IOException iOException, int i, int i2) {
        super(iOException, m2476b(i, i2));
    }

    public C2652dn(String str, IOException iOException, int i) {
        super(str, iOException, m2476b(i, 1));
    }
}
