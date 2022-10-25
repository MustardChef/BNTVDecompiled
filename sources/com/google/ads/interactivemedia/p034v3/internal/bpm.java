package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpm */
/* loaded from: classes2.dex */
public final class bpm {

    /* renamed from: a */
    private static final bpm f6386a = new bpm(0, new int[0], new Object[0], false);

    /* renamed from: b */
    private int f6387b;

    /* renamed from: c */
    private int[] f6388c;

    /* renamed from: d */
    private Object[] f6389d;

    /* renamed from: e */
    private int f6390e;

    /* renamed from: f */
    private boolean f6391f;

    private bpm() {
        this(0, new int[8], new Object[8], true);
    }

    private bpm(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f6390e = -1;
        this.f6387b = i;
        this.f6388c = iArr;
        this.f6389d = objArr;
        this.f6391f = z;
    }

    /* renamed from: c */
    public static bpm m2949c() {
        return f6386a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static bpm m2948d(bpm bpmVar, bpm bpmVar2) {
        int i = bpmVar.f6387b + bpmVar2.f6387b;
        int[] copyOf = Arrays.copyOf(bpmVar.f6388c, i);
        System.arraycopy(bpmVar2.f6388c, 0, copyOf, bpmVar.f6387b, bpmVar2.f6387b);
        Object[] copyOf2 = Arrays.copyOf(bpmVar.f6389d, i);
        System.arraycopy(bpmVar2.f6389d, 0, copyOf2, bpmVar.f6387b, bpmVar2.f6387b);
        return new bpm(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static bpm m2947e() {
        return new bpm(0, new int[8], new Object[8], true);
    }

    /* renamed from: a */
    public final int m2951a() {
        int m3365x;
        int i = this.f6390e;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6387b; i3++) {
                int i4 = this.f6388c[i3];
                int m2853a = bqb.m2853a(i4);
                int m2852b = bqb.m2852b(i4);
                if (m2852b == 0) {
                    m3365x = bma.m3365x(m2853a, ((Long) this.f6389d[i3]).longValue());
                } else if (m2852b == 1) {
                    ((Long) this.f6389d[i3]).longValue();
                    m3365x = bma.m3391aj(m2853a);
                } else if (m2852b == 2) {
                    m3365x = bma.m3387b(m2853a, (bls) this.f6389d[i3]);
                } else if (m2852b == 3) {
                    int m3368u = bma.m3368u(m2853a);
                    m3365x = m3368u + m3368u + ((bpm) this.f6389d[i3]).m2951a();
                } else if (m2852b == 5) {
                    ((Integer) this.f6389d[i3]).intValue();
                    m3365x = bma.m3392ai(m2853a);
                } else {
                    throw new IllegalStateException(bnm.m3258a());
                }
                i2 += m3365x;
            }
            this.f6390e = i2;
            return i2;
        }
        return i;
    }

    /* renamed from: b */
    public final int m2950b() {
        int i = this.f6390e;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6387b; i3++) {
                int i4 = this.f6388c[i3];
                int m3368u = bma.m3368u(1);
                i2 += m3368u + m3368u + bma.m3367v(2, bqb.m2853a(i4)) + bma.m3387b(3, (bls) this.f6389d[i3]);
            }
            this.f6390e = i2;
            return i2;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof bpm)) {
            bpm bpmVar = (bpm) obj;
            int i = this.f6387b;
            if (i == bpmVar.f6387b) {
                int[] iArr = this.f6388c;
                int[] iArr2 = bpmVar.f6388c;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.f6389d;
                        Object[] objArr2 = bpmVar.f6389d;
                        int i3 = this.f6387b;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    } else if (iArr[i2] != iArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public final void m2946f() {
        this.f6391f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final void m2945g(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f6387b; i2++) {
            bqd.m2808E(sb, i, String.valueOf(bqb.m2853a(this.f6388c[i2])), this.f6389d[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m2944h(int i, Object obj) {
        if (this.f6391f) {
            int i2 = this.f6387b;
            int[] iArr = this.f6388c;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.f6388c = Arrays.copyOf(iArr, i3);
                this.f6389d = Arrays.copyOf(this.f6389d, i3);
            }
            int[] iArr2 = this.f6388c;
            int i4 = this.f6387b;
            iArr2[i4] = i;
            this.f6389d[i4] = obj;
            this.f6387b = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = this.f6387b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f6388c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f6389d;
        int i7 = this.f6387b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final void m2943i(bqc bqcVar) throws IOException {
        for (int i = 0; i < this.f6387b; i++) {
            bqcVar.mo2815x(bqb.m2853a(this.f6388c[i]), this.f6389d[i]);
        }
    }

    /* renamed from: j */
    public final void m2942j(bqc bqcVar) throws IOException {
        if (this.f6387b != 0) {
            for (int i = 0; i < this.f6387b; i++) {
                m2941k(this.f6388c[i], this.f6389d[i], bqcVar);
            }
        }
    }

    /* renamed from: k */
    private static void m2941k(int i, Object obj, bqc bqcVar) throws IOException {
        int m2853a = bqb.m2853a(i);
        int m2852b = bqb.m2852b(i);
        if (m2852b == 0) {
            bqcVar.mo2819t(m2853a, ((Long) obj).longValue());
        } else if (m2852b == 1) {
            bqcVar.mo2826m(m2853a, ((Long) obj).longValue());
        } else if (m2852b == 2) {
            bqcVar.mo2835d(m2853a, (bls) obj);
        } else if (m2852b != 3) {
            if (m2852b == 5) {
                bqcVar.mo2828k(m2853a, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(bnm.m3258a());
        } else {
            bqcVar.mo2844G(m2853a);
            ((bpm) obj).m2942j(bqcVar);
            bqcVar.mo2831h(m2853a);
        }
    }
}
