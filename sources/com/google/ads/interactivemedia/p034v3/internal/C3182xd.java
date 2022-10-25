package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xd */
/* loaded from: classes2.dex */
public final class C3182xd {

    /* renamed from: c */
    private boolean f9370c;

    /* renamed from: e */
    private int f9372e;

    /* renamed from: a */
    private C3181xc f9368a = new C3181xc();

    /* renamed from: b */
    private C3181xc f9369b = new C3181xc();

    /* renamed from: d */
    private long f9371d = C3282C.TIME_UNSET;

    /* renamed from: a */
    public final float m675a() {
        if (m669g()) {
            return (float) (1.0E9d / this.f9368a.m682a());
        }
        return -1.0f;
    }

    /* renamed from: b */
    public final int m674b() {
        return this.f9372e;
    }

    /* renamed from: c */
    public final long m673c() {
        return m669g() ? this.f9368a.m682a() : C3282C.TIME_UNSET;
    }

    /* renamed from: d */
    public final long m672d() {
        return m669g() ? this.f9368a.m681b() : C3282C.TIME_UNSET;
    }

    /* renamed from: e */
    public final void m671e(long j) {
        this.f9368a.m680c(j);
        if (this.f9368a.m677f()) {
            this.f9370c = false;
        } else if (this.f9371d != C3282C.TIME_UNSET) {
            if (!this.f9370c || this.f9369b.m678e()) {
                this.f9369b.m679d();
                this.f9369b.m680c(this.f9371d);
            }
            this.f9370c = true;
            this.f9369b.m680c(j);
        }
        if (this.f9370c && this.f9369b.m677f()) {
            C3181xc c3181xc = this.f9368a;
            this.f9368a = this.f9369b;
            this.f9369b = c3181xc;
            this.f9370c = false;
        }
        this.f9371d = j;
        this.f9372e = this.f9368a.m677f() ? 0 : this.f9372e + 1;
    }

    /* renamed from: f */
    public final void m670f() {
        this.f9368a.m679d();
        this.f9369b.m679d();
        this.f9370c = false;
        this.f9371d = C3282C.TIME_UNSET;
        this.f9372e = 0;
    }

    /* renamed from: g */
    public final boolean m669g() {
        return this.f9368a.m677f();
    }
}
