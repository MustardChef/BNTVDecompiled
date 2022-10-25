package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yo */
/* loaded from: classes2.dex */
public class C3220yo {

    /* renamed from: a */
    protected final C3214yi f9512a;

    /* renamed from: b */
    protected final InterfaceC3219yn f9513b;

    /* renamed from: c */
    protected C3216yk f9514c;

    /* renamed from: d */
    private final int f9515d;

    /* JADX INFO: Access modifiers changed from: protected */
    public C3220yo(InterfaceC3217yl interfaceC3217yl, InterfaceC3219yn interfaceC3219yn, long j, long j2, long j3, long j4, long j5, int i) {
        this.f9513b = interfaceC3219yn;
        this.f9515d = i;
        this.f9512a = new C3214yi(interfaceC3217yl, j, j2, j3, j4, j5);
    }

    /* renamed from: f */
    protected static final int m515f(InterfaceC3230yy interfaceC3230yy, long j, C3247zo c3247zo) {
        if (j == interfaceC3230yy.mo498d()) {
            return 0;
        }
        c3247zo.f9610a = j;
        return 1;
    }

    /* renamed from: g */
    protected static final boolean m514g(InterfaceC3230yy interfaceC3230yy, long j) throws IOException {
        long mo498d = j - interfaceC3230yy.mo498d();
        if (mo498d < 0 || mo498d > 262144) {
            return false;
        }
        interfaceC3230yy.mo493i((int) mo498d);
        return true;
    }

    /* renamed from: a */
    public final int m520a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        while (true) {
            C3216yk c3216yk = this.f9514c;
            C2616ce.m2688e(c3216yk);
            j = c3216yk.f9505f;
            j2 = c3216yk.f9506g;
            j3 = c3216yk.f9507h;
            if (j2 - j > this.f9515d) {
                if (m514g(interfaceC3230yy, j3)) {
                    interfaceC3230yy.mo494h();
                    InterfaceC3219yn interfaceC3219yn = this.f9513b;
                    j4 = c3216yk.f9501b;
                    C3218ym mo522a = interfaceC3219yn.mo522a(interfaceC3230yy, j4);
                    i = mo522a.f9509b;
                    if (i == -3) {
                        m516e();
                        return m515f(interfaceC3230yy, j3, c3247zo);
                    } else if (i == -2) {
                        j9 = mo522a.f9510c;
                        j10 = mo522a.f9511d;
                        C3216yk.m531h(c3216yk, j9, j10);
                    } else if (i == -1) {
                        j7 = mo522a.f9510c;
                        j8 = mo522a.f9511d;
                        C3216yk.m532g(c3216yk, j7, j8);
                    } else {
                        j5 = mo522a.f9511d;
                        m514g(interfaceC3230yy, j5);
                        m516e();
                        j6 = mo522a.f9511d;
                        return m515f(interfaceC3230yy, j6, c3247zo);
                    }
                } else {
                    return m515f(interfaceC3230yy, j3, c3247zo);
                }
            } else {
                m516e();
                return m515f(interfaceC3230yy, j, c3247zo);
            }
        }
    }

    /* renamed from: b */
    public final InterfaceC3250zr m519b() {
        return this.f9512a;
    }

    /* renamed from: c */
    public final void m518c(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        C3216yk c3216yk = this.f9514c;
        if (c3216yk != null) {
            j6 = c3216yk.f9500a;
            if (j6 == j) {
                return;
            }
        }
        long m539f = this.f9512a.m539f(j);
        C3214yi c3214yi = this.f9512a;
        j2 = c3214yi.f9496c;
        j3 = c3214yi.f9497d;
        j4 = c3214yi.f9498e;
        j5 = c3214yi.f9499f;
        this.f9514c = new C3216yk(j, m539f, j2, j3, j4, j5);
    }

    /* renamed from: d */
    public final boolean m517d() {
        return this.f9514c != null;
    }

    /* renamed from: e */
    protected final void m516e() {
        this.f9514c = null;
        this.f9513b.mo521b();
    }
}
