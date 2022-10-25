package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aol */
/* loaded from: classes2.dex */
public final class aol extends ape {
    public aol(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "pzhIFr8jSwvyB8FXK2qfBOfw0jXHNl6+dmbReaTm1jquB51r9sbZLlTA4zaBxZEm", "RbRyr5uGUYOSrOuNnmzV0kl42YeLvs7OFWbwh2MFm18=", agaVar, i, 24, null, null, null);
    }

    /* renamed from: c */
    private final void m4848c() {
        AdvertisingIdClient m4903g = this.f4827a.m4903g();
        if (m4903g == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = m4903g.getInfo();
            String m4872d = anz.m4872d(info.getId());
            if (m4872d != null) {
                synchronized (this.f4833g) {
                    this.f4833g.m5440Y(m4872d);
                    this.f4833g.m5441X(info.isLimitAdTrackingEnabled());
                    this.f4833g.m5432aF(afk.f3718f);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (!this.f4827a.m4895o()) {
            synchronized (this.f4833g) {
                this.f4833g.m5440Y((String) this.f4830d.invoke(null, this.f4827a.m4908b()));
            }
            return;
        }
        m4848c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        mo4843f();
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: f */
    public final void mo4843f() throws Exception {
        if (this.f4827a.m4894p()) {
            super.mo4843f();
        } else if (this.f4827a.m4895o()) {
            m4848c();
        }
    }
}
