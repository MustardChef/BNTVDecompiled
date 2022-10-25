package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bov */
/* loaded from: classes2.dex */
public final class bov {

    /* renamed from: a */
    private final ArrayDeque f6356a = new ArrayDeque();

    private bov() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ bls m3065a(bov bovVar, bls blsVar, bls blsVar2) {
        bovVar.m3064b(blsVar);
        bovVar.m3064b(blsVar2);
        bls blsVar3 = (bls) bovVar.f6356a.pop();
        while (!bovVar.f6356a.isEmpty()) {
            blsVar3 = new box((bls) bovVar.f6356a.pop(), blsVar3, null);
        }
        return blsVar3;
    }

    /* renamed from: b */
    private final void m3064b(bls blsVar) {
        if (blsVar.mo3050h()) {
            int m3063c = m3063c(blsVar.mo3054d());
            int m3055c = box.m3055c(m3063c + 1);
            if (this.f6356a.isEmpty() || ((bls) this.f6356a.peek()).mo3054d() >= m3055c) {
                this.f6356a.push(blsVar);
                return;
            }
            int m3055c2 = box.m3055c(m3063c);
            bls blsVar2 = (bls) this.f6356a.pop();
            while (!this.f6356a.isEmpty() && ((bls) this.f6356a.peek()).mo3054d() < m3055c2) {
                blsVar2 = new box((bls) this.f6356a.pop(), blsVar2, null);
            }
            box boxVar = new box(blsVar2, blsVar, null);
            while (!this.f6356a.isEmpty()) {
                if (((bls) this.f6356a.peek()).mo3054d() >= box.m3055c(m3063c(boxVar.mo3054d()) + 1)) {
                    break;
                }
                boxVar = new box((bls) this.f6356a.pop(), boxVar, null);
            }
            this.f6356a.push(boxVar);
        } else if (blsVar instanceof box) {
            box boxVar2 = (box) blsVar;
            m3064b(box.m3051g(boxVar2));
            m3064b(box.m3060E(boxVar2));
        } else {
            String valueOf = String.valueOf(blsVar.getClass());
            String.valueOf(valueOf).length();
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(valueOf)));
        }
    }

    /* renamed from: c */
    private static final int m3063c(int i) {
        int binarySearch = Arrays.binarySearch(box.f6359a, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bov(byte[] bArr) {
    }
}
