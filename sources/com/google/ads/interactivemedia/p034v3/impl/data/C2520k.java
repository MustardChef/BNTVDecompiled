package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.k */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2520k {
    /* renamed from: a */
    public static /* synthetic */ boolean m5995a(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    /* renamed from: b */
    public static boolean m5994b(Object[] objArr, Object obj) {
        if (objArr != null) {
            if (obj == null) {
                for (Object obj2 : objArr) {
                    if (obj2 == null) {
                        return true;
                    }
                }
            } else {
                for (Object obj3 : objArr) {
                    if (obj.equals(obj3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
