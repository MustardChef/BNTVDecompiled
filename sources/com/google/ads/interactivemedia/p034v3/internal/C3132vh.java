package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vh */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3132vh implements Comparator {

    /* renamed from: d */
    private final /* synthetic */ int f9175d;

    /* renamed from: c */
    public static final /* synthetic */ C3132vh f9174c = new C3132vh(2);

    /* renamed from: b */
    public static final /* synthetic */ C3132vh f9173b = new C3132vh(1);

    /* renamed from: a */
    public static final /* synthetic */ C3132vh f9172a = new C3132vh(0);

    private /* synthetic */ C3132vh(int i) {
        this.f9175d = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.f9175d;
        if (i != 0) {
            if (i == 1) {
                return ((C2962p) obj2).f8368h - ((C2962p) obj).f8368h;
            }
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i2 = C3140vp.f9229a;
            return 0;
        }
        Integer num3 = (Integer) obj;
        Integer num4 = (Integer) obj2;
        int i3 = C3140vp.f9229a;
        if (num3.intValue() == -1) {
            return num4.intValue() == -1 ? 0 : -1;
        } else if (num4.intValue() == -1) {
            return 1;
        } else {
            return num3.intValue() - num4.intValue();
        }
    }
}
