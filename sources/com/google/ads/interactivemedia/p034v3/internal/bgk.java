package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgk */
/* loaded from: classes2.dex */
public final class bgk extends bgm implements Iterable {

    /* renamed from: a */
    private final List f5696a = new ArrayList();

    /* renamed from: a */
    public final void m3713a(bgm bgmVar) {
        if (bgmVar == null) {
            bgmVar = bgo.f5697a;
        }
        this.f5696a.add(bgmVar);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof bgk) && ((bgk) obj).f5696a.equals(this.f5696a));
    }

    public final int hashCode() {
        return this.f5696a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f5696a.iterator();
    }
}
