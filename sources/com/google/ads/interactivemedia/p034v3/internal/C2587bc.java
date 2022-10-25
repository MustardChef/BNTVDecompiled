package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bc */
/* loaded from: classes2.dex */
public final class C2587bc {

    /* renamed from: a */
    public final int f5406a;

    /* renamed from: b */
    private final C2962p[] f5407b;

    /* renamed from: c */
    private int f5408c;

    public C2587bc(C2962p... c2962pArr) {
        int length = c2962pArr.length;
        int i = 1;
        C2616ce.m2687f(length > 0);
        this.f5407b = c2962pArr;
        this.f5406a = length;
        String m4191d = m4191d(c2962pArr[0].f8363c);
        int m4192c = m4192c(c2962pArr[0].f8365e);
        while (true) {
            C2962p[] c2962pArr2 = this.f5407b;
            if (i >= c2962pArr2.length) {
                return;
            }
            if (m4191d.equals(m4191d(c2962pArr2[i].f8363c))) {
                C2962p[] c2962pArr3 = this.f5407b;
                if (m4192c != m4192c(c2962pArr3[i].f8365e)) {
                    m4190e("role flags", Integer.toBinaryString(c2962pArr3[0].f8365e), Integer.toBinaryString(this.f5407b[i].f8365e), i);
                    return;
                }
                i++;
            } else {
                C2962p[] c2962pArr4 = this.f5407b;
                m4190e("languages", c2962pArr4[0].f8363c, c2962pArr4[i].f8363c, i);
                return;
            }
        }
    }

    /* renamed from: c */
    private static int m4192c(int i) {
        return i | 16384;
    }

    /* renamed from: d */
    private static String m4191d(String str) {
        return (str == null || str.equals(C3282C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    /* renamed from: e */
    private static void m4190e(String str, String str2, String str3, int i) {
        int length = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(str.length() + 78 + length + String.valueOf(str3).length());
        sb.append("Different ");
        sb.append(str);
        sb.append(" combined in one TrackGroup: '");
        sb.append(str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i);
        sb.append(")");
        C2613cb.m2698a("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    /* renamed from: a */
    public final int m4194a(C2962p c2962p) {
        int i = 0;
        while (true) {
            C2962p[] c2962pArr = this.f5407b;
            if (i >= c2962pArr.length) {
                return -1;
            }
            if (c2962p == c2962pArr[i]) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: b */
    public final C2962p m4193b(int i) {
        return this.f5407b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2587bc c2587bc = (C2587bc) obj;
            if (this.f5406a == c2587bc.f5406a && Arrays.equals(this.f5407b, c2587bc.f5407b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f5408c;
        if (i == 0) {
            int hashCode = Arrays.hashCode(this.f5407b) + 527;
            this.f5408c = hashCode;
            return hashCode;
        }
        return i;
    }
}
