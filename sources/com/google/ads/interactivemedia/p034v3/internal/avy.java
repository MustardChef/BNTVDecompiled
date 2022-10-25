package com.google.ads.interactivemedia.p034v3.internal;

import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avy */
/* loaded from: classes2.dex */
final class avy extends axf {

    /* renamed from: a */
    boolean f5197a;

    /* renamed from: b */
    final /* synthetic */ Object f5198b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avy(Object obj) {
        this.f5198b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f5197a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5197a) {
            throw new NoSuchElementException();
        }
        this.f5197a = true;
        return this.f5198b;
    }
}
