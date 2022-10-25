package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aed */
/* loaded from: classes2.dex */
public final class aed implements adx {

    /* renamed from: a */
    final /* synthetic */ aef f3579a;

    /* renamed from: b */
    private final C2620ci f3580b = new C2620ci(new byte[4]);

    public aed(aef aefVar) {
        this.f3579a = aefVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adx
    /* renamed from: a */
    public final void mo5751a(C2621cj c2621cj) {
        int i;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        int i2;
        if (c2621cj.m2633i() == 0 && (c2621cj.m2633i() & 128) != 0) {
            c2621cj.m2643G(6);
            int m2641a = c2621cj.m2641a() / 4;
            for (int i3 = 0; i3 < m2641a; i3++) {
                c2621cj.m2616z(this.f3580b, 4);
                int m2661c = this.f3580b.m2661c(16);
                this.f3580b.m2655i(3);
                if (m2661c == 0) {
                    this.f3580b.m2655i(13);
                } else {
                    int m2661c2 = this.f3580b.m2661c(13);
                    sparseArray2 = this.f3579a.f3592g;
                    if (sparseArray2.get(m2661c2) == null) {
                        aef aefVar = this.f3579a;
                        sparseArray3 = aefVar.f3592g;
                        sparseArray3.put(m2661c2, new ady(new aee(aefVar, m2661c2)));
                        aef aefVar2 = this.f3579a;
                        i2 = aefVar2.f3598m;
                        aefVar2.f3598m = i2 + 1;
                    }
                }
            }
            aef aefVar3 = this.f3579a;
            i = aefVar3.f3586a;
            if (i != 2) {
                sparseArray = aefVar3.f3592g;
                sparseArray.remove(0);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adx
    /* renamed from: b */
    public final void mo5750b(C2626co c2626co, InterfaceC3233za interfaceC3233za, aej aejVar) {
    }
}
