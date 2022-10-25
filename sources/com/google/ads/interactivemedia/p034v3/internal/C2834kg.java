package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kg */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2834kg implements Comparator {

    /* renamed from: a */
    public static final /* synthetic */ C2834kg f7849a = new C2834kg();

    private /* synthetic */ C2834kg() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        C2863li c2863li = (C2863li) obj;
        C2863li c2863li2 = (C2863li) obj2;
        int i = c2863li.f8006c;
        int i2 = c2863li2.f8006c;
        int i3 = i == i2 ? 0 : i < i2 ? -1 : 1;
        return i3 != 0 ? i3 : c2863li.f8005b.compareTo(c2863li2.f8005b);
    }
}
