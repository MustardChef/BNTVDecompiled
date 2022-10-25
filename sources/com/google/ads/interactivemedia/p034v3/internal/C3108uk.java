package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.uk */
/* loaded from: classes2.dex */
public final class C3108uk {

    /* renamed from: a */
    private final int[] f9074a;

    /* renamed from: b */
    private final C3096tz[] f9075b;

    public C3108uk(int[] iArr, C3096tz[] c3096tzArr) {
        this.f9074a = iArr;
        this.f9075b = c3096tzArr;
    }

    /* renamed from: a */
    public final void m906a(long j) {
        for (C3096tz c3096tz : this.f9075b) {
            c3096tz.m981D(j);
        }
    }

    /* renamed from: b */
    public final int[] m905b() {
        int[] iArr = new int[this.f9075b.length];
        int i = 0;
        while (true) {
            C3096tz[] c3096tzArr = this.f9075b;
            if (i >= c3096tzArr.length) {
                return iArr;
            }
            iArr[i] = c3096tzArr[i].m948m();
            i++;
        }
    }

    /* renamed from: c */
    public final InterfaceC3253zu m904c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f9074a;
            if (i2 < iArr.length) {
                if (i == iArr[i2]) {
                    return this.f9075b[i2];
                }
                i2++;
            } else {
                StringBuilder sb = new StringBuilder(36);
                sb.append("Unmatched track of type: ");
                sb.append(i);
                Log.e("BaseMediaChunkOutput", sb.toString());
                return new C3228yw();
            }
        }
    }
}
