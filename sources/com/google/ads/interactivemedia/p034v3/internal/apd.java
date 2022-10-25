package com.google.ads.interactivemedia.p034v3.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apd */
/* loaded from: classes2.dex */
public final class apd {

    /* renamed from: a */
    private final anw f4821a;

    /* renamed from: b */
    private final String f4822b;

    /* renamed from: c */
    private final String f4823c;

    /* renamed from: e */
    private final Class[] f4825e;

    /* renamed from: d */
    private volatile Method f4824d = null;

    /* renamed from: f */
    private final CountDownLatch f4826f = new CountDownLatch(1);

    public apd(anw anwVar, String str, String str2, Class... clsArr) {
        this.f4821a = anwVar;
        this.f4822b = str;
        this.f4823c = str2;
        this.f4825e = clsArr;
        anwVar.m4900j().submit(new apc(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* bridge */ /* synthetic */ void m4846b(apd apdVar) {
        CountDownLatch countDownLatch;
        Class loadClass;
        try {
            anw anwVar = apdVar.f4821a;
            loadClass = anwVar.m4902h().loadClass(apdVar.m4845c(anwVar.m4892r(), apdVar.f4822b));
        } catch (anh | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = apdVar.f4826f;
        } catch (Throwable th) {
            apdVar.f4826f.countDown();
            throw th;
        }
        if (loadClass == null) {
            countDownLatch = apdVar.f4826f;
        } else {
            apdVar.f4824d = loadClass.getMethod(apdVar.m4845c(apdVar.f4821a.m4892r(), apdVar.f4823c), apdVar.f4825e);
            if (apdVar.f4824d == null) {
                countDownLatch = apdVar.f4826f;
            }
            countDownLatch = apdVar.f4826f;
        }
        countDownLatch.countDown();
    }

    /* renamed from: c */
    private final String m4845c(byte[] bArr, String str) throws anh, UnsupportedEncodingException {
        return new String(this.f4821a.m4905e().m4916b(bArr, str), "UTF-8");
    }

    /* renamed from: a */
    public final Method m4847a() {
        if (this.f4824d != null) {
            return this.f4824d;
        }
        try {
            if (this.f4826f.await(2L, TimeUnit.SECONDS)) {
                return this.f4824d;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
