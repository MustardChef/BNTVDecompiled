package com.google.ads.interactivemedia.p034v3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aor */
/* loaded from: classes2.dex */
public final class aor extends ape {

    /* renamed from: h */
    private static volatile String f4808h;

    /* renamed from: i */
    private static final Object f4809i = new Object();

    public aor(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "uVfRV2qL6y+/frn7UQ8HZUcJpLFj+yNt3k4Ns9czyDlwcIbIheGCFGCtGsGaaHh4", "RmtCo/dRwPWzjhuo/V+opsA0IDlV0P6pRfQFRNu3WDY=", agaVar, i, 1, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        this.f4833g.m5422af(ExifInterface.LONGITUDE_EAST);
        if (f4808h == null) {
            synchronized (f4809i) {
                if (f4808h == null) {
                    f4808h = (String) this.f4830d.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f4833g) {
            this.f4833g.m5422af(f4808h);
        }
    }
}
