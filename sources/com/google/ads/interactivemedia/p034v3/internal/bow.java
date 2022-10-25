package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bow */
/* loaded from: classes2.dex */
final class bow implements Iterator {

    /* renamed from: a */
    private final ArrayDeque f6357a;

    /* renamed from: b */
    private blp f6358b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bow(bls blsVar) {
        bls blsVar2;
        if (blsVar instanceof box) {
            box boxVar = (box) blsVar;
            ArrayDeque arrayDeque = new ArrayDeque(boxVar.mo3052f());
            this.f6357a = arrayDeque;
            arrayDeque.push(boxVar);
            blsVar2 = boxVar.f6361d;
            this.f6358b = m3061b(blsVar2);
            return;
        }
        this.f6357a = null;
        this.f6358b = (blp) blsVar;
    }

    /* renamed from: b */
    private final blp m3061b(bls blsVar) {
        while (blsVar instanceof box) {
            box boxVar = (box) blsVar;
            this.f6357a.push(boxVar);
            blsVar = boxVar.f6361d;
        }
        return (blp) blsVar;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final blp next() {
        blp blpVar;
        bls blsVar;
        blp blpVar2 = this.f6358b;
        if (blpVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f6357a;
            blpVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            blsVar = ((box) this.f6357a.pop()).f6362e;
            blpVar = m3061b(blsVar);
        } while (blpVar.m3510B());
        this.f6358b = blpVar;
        return blpVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6358b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
