package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wt */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3171wt implements Comparator {

    /* renamed from: c */
    private final /* synthetic */ int f9323c;

    /* renamed from: b */
    public static final /* synthetic */ C3171wt f9322b = new C3171wt(1);

    /* renamed from: a */
    public static final /* synthetic */ C3171wt f9321a = new C3171wt(0);

    private /* synthetic */ C3171wt(int i) {
        this.f9323c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (this.f9323c == 0) {
            return Float.compare(((C3172wu) obj).f9326c, ((C3172wu) obj2).f9326c);
        }
        return ((C3172wu) obj).f9324a - ((C3172wu) obj2).f9324a;
    }
}
