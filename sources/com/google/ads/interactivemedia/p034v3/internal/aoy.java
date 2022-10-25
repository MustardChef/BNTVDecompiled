package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aoy */
/* loaded from: classes2.dex */
public final class aoy extends ape {

    /* renamed from: h */
    private final aod f4813h;

    /* renamed from: i */
    private long f4814i;

    public aoy(anw anwVar, aga agaVar, int i, aod aodVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "e3op4R4hYomHt8fD4e46pNuu/60OumzY4fWht1zvNw/PVRGde3uP5Y0px+X+3p+E", "jLlOehpoNgAQzvuHrTyBcudcfwOhFguv/E47mcpJrto=", agaVar, i, 53, null, null, null);
        this.f4813h = aodVar;
        if (aodVar != null) {
            this.f4814i = aodVar.m4861a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (this.f4813h != null) {
            this.f4833g.m5407au(((Long) this.f4830d.invoke(null, Long.valueOf(this.f4814i))).longValue());
        }
    }
}
