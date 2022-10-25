package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmp */
/* loaded from: classes2.dex */
public final class bmp {

    /* renamed from: a */
    final boj f6168a;

    /* renamed from: b */
    final bnc f6169b;

    public bmp() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bmp(boj bojVar, boj bojVar2, bnc bncVar) {
        this();
        if (bojVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (bncVar.f6256c == bpz.MESSAGE && bojVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.f6168a = bojVar2;
        this.f6169b = bncVar;
    }

    /* renamed from: a */
    public final bpz m3343a() {
        return this.f6169b.f6256c;
    }

    /* renamed from: b */
    public final boolean m3342b() {
        return this.f6169b.f6257d;
    }
}
