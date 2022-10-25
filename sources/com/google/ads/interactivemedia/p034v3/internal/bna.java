package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bna */
/* loaded from: classes2.dex */
public class bna extends bmz implements bok {
    /* JADX INFO: Access modifiers changed from: protected */
    public bna(bnb bnbVar) {
        super(bnbVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmz, com.google.ads.interactivemedia.p034v3.internal.boi
    /* renamed from: a */
    public final bnb mo3178aS() {
        if (this.f6250b) {
            return (bnb) this.f6249a;
        }
        ((bnb) this.f6249a).f6253a.m3329i();
        return (bnb) super.mo3178aS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bmz
    /* renamed from: aU */
    public final void mo3302aU() {
        super.mo3302aU();
        bnb bnbVar = (bnb) this.f6249a;
        bnbVar.f6253a = bnbVar.f6253a.clone();
    }
}
