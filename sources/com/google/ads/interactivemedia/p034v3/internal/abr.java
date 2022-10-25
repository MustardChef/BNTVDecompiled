package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abr */
/* loaded from: classes2.dex */
final class abr extends abt {

    /* renamed from: a */
    public final long f3103a;

    /* renamed from: b */
    public final List f3104b;

    /* renamed from: c */
    public final List f3105c;

    public abr(int i, long j) {
        super(i);
        this.f3103a = j;
        this.f3104b = new ArrayList();
        this.f3105c = new ArrayList();
    }

    /* renamed from: a */
    public final abr m5893a(int i) {
        int size = this.f3105c.size();
        for (int i2 = 0; i2 < size; i2++) {
            abr abrVar = (abr) this.f3105c.get(i2);
            if (abrVar.f3107d == i) {
                return abrVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final abs m5892b(int i) {
        int size = this.f3104b.size();
        for (int i2 = 0; i2 < size; i2++) {
            abs absVar = (abs) this.f3104b.get(i2);
            if (absVar.f3107d == i) {
                return absVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final void m5891c(abr abrVar) {
        this.f3105c.add(abrVar);
    }

    /* renamed from: d */
    public final void m5890d(abs absVar) {
        this.f3104b.add(absVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abt
    public final String toString() {
        String g = m5887g(this.f3107d);
        String arrays = Arrays.toString(this.f3104b.toArray());
        String arrays2 = Arrays.toString(this.f3105c.toArray());
        int length = String.valueOf(g).length();
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(g);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
