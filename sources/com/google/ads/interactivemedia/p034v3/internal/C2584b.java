package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.b */
/* loaded from: classes2.dex */
public final class C2584b {

    /* renamed from: a */
    public static final C2584b f5342a = new C2584b(new C2536a[0]);

    /* renamed from: c */
    private static final C2536a f5343c = new C2536a().m5983c();

    /* renamed from: b */
    public final long f5344b = 0;

    /* renamed from: d */
    private final C2536a[] f5345d;

    private C2584b(C2536a[] c2536aArr) {
        this.f5345d = c2536aArr;
    }

    /* renamed from: a */
    public final C2536a m4252a(int i) {
        return i < 0 ? f5343c : this.f5345d[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2584b c2584b = (C2584b) obj;
            if (C2628cq.m2563T(null, null) && Arrays.equals(this.f5345d, c2584b.f5345d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) C3282C.TIME_UNSET) * 961) + Arrays.hashCode(this.f5345d);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=" + ((Object) null) + ", adResumePositionUs=0, adGroups=[])";
    }
}
