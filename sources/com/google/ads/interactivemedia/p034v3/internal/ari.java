package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ari */
/* loaded from: classes2.dex */
public final class ari {

    /* renamed from: a */
    protected static final byte[] f4933a = {61, 122, Ascii.DC2, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, Utf8.REPLACEMENT_BYTE, 50, 108, -113, -103, 74};

    /* renamed from: b */
    protected static final byte[] f4934b = {Ascii.DLE, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, 52, 111, -58, -77, 70, -48, ByteSourceJsonBootstrapper.UTF8_BOM_2, -60, 65, 95, -61, 57, -4, -4, -114, -63};

    /* renamed from: c */
    private final byte[] f4935c = f4934b;

    /* renamed from: d */
    private final byte[] f4936d = f4933a;

    /* renamed from: a */
    public final boolean m4735a(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] m5709e = aev.m5709e(file.getAbsolutePath());
            if (m5709e.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(m5709e[0][0].getEncoded());
            if (Arrays.equals(this.f4936d, digest)) {
                return true;
            }
            return !"user".equals(Build.TYPE) && Arrays.equals(this.f4935c, digest);
        } catch (aes e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException e2) {
            e = e2;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (RuntimeException e3) {
            e = e3;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}
