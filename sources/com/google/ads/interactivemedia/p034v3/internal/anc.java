package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anc */
/* loaded from: classes2.dex */
public final class anc extends anb {
    protected anc(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* renamed from: j */
    public static anc m4931j(String str, Context context, boolean z) {
        m4934v(context, z);
        return new anc(context, str, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anb
    /* renamed from: p */
    protected final List mo4930p(anw anwVar, Context context, aga agaVar, afd afdVar) {
        if (anwVar.m4900j() == null || !this.f4701t) {
            return super.mo4930p(anwVar, context, agaVar, afdVar);
        }
        int m4909a = anwVar.m4909a();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.mo4930p(anwVar, context, agaVar, afdVar));
        arrayList.add(new aol(anwVar, agaVar, m4909a, null, null, null));
        return arrayList;
    }
}
