package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wv */
/* loaded from: classes2.dex */
public final class C3173wv {

    /* renamed from: a */
    private static final Comparator f9327a = C3171wt.f9322b;

    /* renamed from: b */
    private static final Comparator f9328b = C3171wt.f9321a;

    /* renamed from: g */
    private int f9333g;

    /* renamed from: h */
    private int f9334h;

    /* renamed from: i */
    private int f9335i;

    /* renamed from: c */
    private final int f9329c = 2000;

    /* renamed from: e */
    private final C3172wu[] f9331e = new C3172wu[5];

    /* renamed from: d */
    private final ArrayList f9330d = new ArrayList();

    /* renamed from: f */
    private int f9332f = -1;

    public C3173wv(int i) {
    }

    /* renamed from: a */
    public final void m709a(int i, float f) {
        C3172wu c3172wu;
        if (this.f9332f != 1) {
            Collections.sort(this.f9330d, f9327a);
            this.f9332f = 1;
        }
        int i2 = this.f9335i;
        if (i2 > 0) {
            C3172wu[] c3172wuArr = this.f9331e;
            int i3 = i2 - 1;
            this.f9335i = i3;
            c3172wu = c3172wuArr[i3];
        } else {
            c3172wu = new C3172wu(null);
        }
        int i4 = this.f9333g;
        this.f9333g = i4 + 1;
        c3172wu.f9324a = i4;
        c3172wu.f9325b = i;
        c3172wu.f9326c = f;
        this.f9330d.add(c3172wu);
        this.f9334h += i;
        while (true) {
            int i5 = this.f9334h;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            C3172wu c3172wu2 = (C3172wu) this.f9330d.get(0);
            int i7 = c3172wu2.f9325b;
            if (i7 <= i6) {
                this.f9334h -= i7;
                this.f9330d.remove(0);
                int i8 = this.f9335i;
                if (i8 < 5) {
                    C3172wu[] c3172wuArr2 = this.f9331e;
                    this.f9335i = i8 + 1;
                    c3172wuArr2[i8] = c3172wu2;
                }
            } else {
                c3172wu2.f9325b = i7 - i6;
                this.f9334h -= i6;
            }
        }
    }

    /* renamed from: b */
    public final void m708b() {
        this.f9330d.clear();
        this.f9332f = -1;
        this.f9333g = 0;
        this.f9334h = 0;
    }

    /* renamed from: c */
    public final float m707c() {
        if (this.f9332f != 0) {
            Collections.sort(this.f9330d, f9328b);
            this.f9332f = 0;
        }
        float f = this.f9334h * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.f9330d.size(); i2++) {
            C3172wu c3172wu = (C3172wu) this.f9330d.get(i2);
            i += c3172wu.f9325b;
            if (i >= f) {
                return c3172wu.f9326c;
            }
        }
        if (this.f9330d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.f9330d;
        return ((C3172wu) arrayList.get(arrayList.size() - 1)).f9326c;
    }
}
