package com.google.ads.interactivemedia.p034v3.internal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aof */
/* loaded from: classes2.dex */
public final class aof extends ape {
    public aof(anw anwVar, aga agaVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "SnrtMYC9+qStj9ZoSAj1DR6mGb7YlLFiZbsMn2F8wpevpQUtlzrwws7lBSZ1KQhS", "3Z4807bJ0KoyYYoQ9dcfmEBolGH5CdxZiQurF1neOqs=", agaVar, i, 49, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        this.f4833g.m5433aE(afw.f3910c);
        try {
            this.f4833g.m5433aE(((Boolean) this.f4830d.invoke(null, this.f4827a.m4908b())).booleanValue() ? afw.f3909b : afw.f3908a);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
