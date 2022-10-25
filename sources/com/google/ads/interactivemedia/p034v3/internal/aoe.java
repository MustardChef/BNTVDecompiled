package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoe */
/* loaded from: classes2.dex */
public final class aoe extends ape {

    /* renamed from: h */
    private final Activity f4793h;

    /* renamed from: i */
    private final View f4794i;

    public aoe(anw anwVar, aga agaVar, int i, View view, Activity activity, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "VJibBREzYucPjNukhWG65jB60OIZQrcDVR3W2JV3G5ynshQ4Nd74pHrZYUgRiYK0", "TiANcug5zndviERrHpzUihvZthrd+vHCK5ngnbrocVE=", agaVar, i, 62, null, null, null);
        this.f4794i = view;
        this.f4793h = activity;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (this.f4794i == null) {
            return;
        }
        boolean booleanValue = ((Boolean) aql.f4900m.m4770f()).booleanValue();
        Object[] objArr = (Object[]) this.f4830d.invoke(null, this.f4794i, this.f4793h, Boolean.valueOf(booleanValue));
        synchronized (this.f4833g) {
            this.f4833g.m5454K(((Long) objArr[0]).longValue());
            this.f4833g.m5452M(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.f4833g.m5453L((String) objArr[2]);
            }
        }
    }
}
