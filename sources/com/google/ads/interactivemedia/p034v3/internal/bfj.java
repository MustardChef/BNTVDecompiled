package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfj */
/* loaded from: classes2.dex */
public final class bfj {

    /* renamed from: a */
    public static final bfj f5644a;

    /* renamed from: b */
    public static final bfj f5645b;

    /* renamed from: c */
    public static final bfj f5646c;

    /* renamed from: d */
    public static final bfj f5647d;

    /* renamed from: e */
    public static final bfj f5648e;

    /* renamed from: f */
    private static final Logger f5649f = Logger.getLogger(bfj.class.getName());

    /* renamed from: g */
    private static final List f5650g;

    /* renamed from: h */
    private static final boolean f5651h;

    /* renamed from: i */
    private final bfl f5652i;

    static {
        if (bbq.m4198b()) {
            f5650g = m3765b(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt");
            f5651h = false;
        } else if (axd.m4401k()) {
            f5650g = m3765b(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
            f5651h = true;
        } else {
            f5650g = new ArrayList();
            f5651h = true;
        }
        f5644a = new bfj(new bfk(1));
        f5645b = new bfj(new bfk(4));
        f5646c = new bfj(new bfk(0));
        f5647d = new bfj(new bfk(3));
        f5648e = new bfj(new bfk(2));
    }

    public bfj(bfl bflVar) {
        this.f5652i = bflVar;
    }

    /* renamed from: b */
    public static List m3765b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f5649f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final Object m3766a(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider provider : f5650g) {
            try {
                return this.f5652i.mo3764a(str, provider);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (f5651h) {
            return this.f5652i.mo3764a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
