package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lc */
/* loaded from: classes2.dex */
final class C2857lc implements InterfaceC3098ua {

    /* renamed from: a */
    private final C2962p f7973a;

    /* renamed from: c */
    private long[] f7975c;

    /* renamed from: d */
    private boolean f7976d;

    /* renamed from: e */
    private C2868ln f7977e;

    /* renamed from: f */
    private boolean f7978f;

    /* renamed from: g */
    private int f7979g;

    /* renamed from: b */
    private final aac f7974b = new aac();

    /* renamed from: h */
    private long f7980h = C3282C.TIME_UNSET;

    public C2857lc(C2868ln c2868ln, C2962p c2962p, boolean z) {
        this.f7973a = c2962p;
        this.f7977e = c2868ln;
        this.f7975c = c2868ln.f8037b;
        m1725f(c2868ln, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        int i2 = this.f7979g;
        int length = this.f7975c.length;
        if (i2 != length || this.f7976d) {
            if ((i & 2) != 0 || !this.f7978f) {
                c2717fy.f7335b = this.f7973a;
                this.f7978f = true;
                return -5;
            } else if (i2 == length) {
                return -3;
            } else {
                this.f7979g = i2 + 1;
                byte[] m5980a = this.f7974b.m5980a(this.f7977e.f8036a[i2]);
                c2669ed.m2448l(m5980a.length);
                c2669ed.f7092b.put(m5980a);
                c2669ed.f7094d = this.f7975c[i2];
                c2669ed.m2466c(1);
                return -4;
            }
        }
        c2669ed.m2466c(4);
        return -4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        int max = Math.max(this.f7979g, C2628cq.m2543am(this.f7975c, j, true));
        int i = this.f7979g;
        this.f7979g = max;
        return max - i;
    }

    /* renamed from: c */
    public final String m1727c() {
        return this.f7977e.m1679a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() throws IOException {
    }

    /* renamed from: e */
    public final void m1726e(long j) {
        int m2543am = C2628cq.m2543am(this.f7975c, j, true);
        this.f7979g = m2543am;
        if (!this.f7976d || m2543am != this.f7975c.length) {
            j = -9223372036854775807L;
        }
        this.f7980h = j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        return true;
    }

    /* renamed from: f */
    public final void m1725f(C2868ln c2868ln, boolean z) {
        int i = this.f7979g;
        long j = i == 0 ? -9223372036854775807L : this.f7975c[i - 1];
        this.f7976d = z;
        this.f7977e = c2868ln;
        long[] jArr = c2868ln.f8037b;
        this.f7975c = jArr;
        long j2 = this.f7980h;
        if (j2 != C3282C.TIME_UNSET) {
            m1726e(j2);
        } else if (j != C3282C.TIME_UNSET) {
            this.f7979g = C2628cq.m2543am(jArr, j, false);
        }
    }
}
