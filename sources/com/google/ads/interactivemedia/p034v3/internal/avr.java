package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avr */
/* loaded from: classes2.dex */
final class avr extends avi {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final Comparator f5187a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avr(avs avsVar) {
        super(avsVar);
        this.f5187a = avsVar.comparator();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avi
    /* renamed from: a */
    final /* bridge */ /* synthetic */ avh mo4486a(int i) {
        return new avq(this.f5187a);
    }
}
