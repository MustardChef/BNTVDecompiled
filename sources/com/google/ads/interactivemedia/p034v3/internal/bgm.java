package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgm */
/* loaded from: classes2.dex */
public class bgm {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            bkx bkxVar = new bkx(stringWriter);
            bkxVar.m3551n(true);
            axn.m4377d(this, bkxVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
