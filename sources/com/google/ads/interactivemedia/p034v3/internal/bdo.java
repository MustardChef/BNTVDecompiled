package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdo */
/* loaded from: classes2.dex */
public final class bdo {

    /* renamed from: a */
    public static final int f5483a = 2;

    /* renamed from: b */
    public static final int f5484b = 3;

    /* renamed from: c */
    public static final int f5485c = 4;

    /* renamed from: d */
    public static final int f5486d = 5;

    /* renamed from: e */
    public static final int f5487e = 1;

    /* renamed from: f */
    private static final /* synthetic */ int[] f5488f = {f5483a, f5484b, f5485c, f5486d, f5487e};

    /* renamed from: a */
    public static int m4030a(int i) {
        if (i != f5487e) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    /* renamed from: b */
    public static int m4029b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return f5486d;
                }
                return f5485c;
            }
            return f5484b;
        }
        return f5483a;
    }

    public static int[] values$ar$edu$34ac0a47_0() {
        return new int[]{f5483a, f5484b, f5485c, f5486d, f5487e};
    }
}
