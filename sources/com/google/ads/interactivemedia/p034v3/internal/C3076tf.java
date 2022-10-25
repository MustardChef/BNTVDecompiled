package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tf */
/* loaded from: classes2.dex */
public final class C3076tf {

    /* renamed from: a */
    public final int f8902a;

    /* renamed from: b */
    public final C3067sx f8903b;

    /* renamed from: c */
    private final CopyOnWriteArrayList f8904c;

    /* renamed from: d */
    private final long f8905d;

    public C3076tf() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    private C3076tf(CopyOnWriteArrayList copyOnWriteArrayList, int i, C3067sx c3067sx, long j) {
        this.f8904c = copyOnWriteArrayList;
        this.f8902a = i;
        this.f8903b = c3067sx;
        this.f8905d = j;
    }

    /* renamed from: t */
    private final long m1071t(long j) {
        long m2511w = C2628cq.m2511w(j);
        return m2511w == C3282C.TIME_UNSET ? C3282C.TIME_UNSET : this.f8905d + m2511w;
    }

    /* renamed from: a */
    public final C3076tf m1090a(int i, C3067sx c3067sx, long j) {
        return new C3076tf(this.f8904c, i, c3067sx, j);
    }

    /* renamed from: b */
    public final void m1089b(Handler handler, InterfaceC3077tg interfaceC3077tg) {
        C2616ce.m2689d(handler);
        C2616ce.m2689d(interfaceC3077tg);
        this.f8904c.add(new C3075te(handler, interfaceC3077tg));
    }

    /* renamed from: c */
    public final void m1088c(final C3064su c3064su) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            final InterfaceC3077tg interfaceC3077tg = c3075te.f8901b;
            C2628cq.m2537as(c3075te.f8900a, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.tc
                @Override // java.lang.Runnable
                public final void run() {
                    C3076tf c3076tf = C3076tf.this;
                    interfaceC3077tg.mo1070ag(c3076tf.f8902a, c3076tf.f8903b, c3064su);
                }
            });
        }
    }

    /* renamed from: d */
    public final void m1087d(C3059sp c3059sp, int i) {
        m1075p(c3059sp, i, -1, null, 0, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
    }

    /* renamed from: e */
    public final void m1086e(C3059sp c3059sp, C3064su c3064su) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            C2628cq.m2537as(c3075te.f8900a, new RunnableC3071ta(this, c3075te.f8901b, c3059sp, c3064su, 1));
        }
    }

    /* renamed from: f */
    public final void m1085f(C3059sp c3059sp, int i) {
        m1074q(c3059sp, i, -1, null, 0, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
    }

    /* renamed from: g */
    public final void m1084g(C3059sp c3059sp, C3064su c3064su) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            C2628cq.m2537as(c3075te.f8900a, new RunnableC3071ta(this, c3075te.f8901b, c3059sp, c3064su, 0));
        }
    }

    /* renamed from: h */
    public final void m1083h(C3059sp c3059sp, int i, IOException iOException, boolean z) {
        m1073r(c3059sp, i, -1, null, 0, C3282C.TIME_UNSET, C3282C.TIME_UNSET, iOException, z);
    }

    /* renamed from: i */
    public final void m1082i(final C3059sp c3059sp, final C3064su c3064su, final IOException iOException, final boolean z) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            final InterfaceC3077tg interfaceC3077tg = c3075te.f8901b;
            C2628cq.m2537as(c3075te.f8900a, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.tb
                @Override // java.lang.Runnable
                public final void run() {
                    C3076tf c3076tf = C3076tf.this;
                    interfaceC3077tg.mo1066i(c3076tf.f8902a, c3076tf.f8903b, c3059sp, c3064su, iOException, z);
                }
            });
        }
    }

    /* renamed from: j */
    public final void m1081j(C3059sp c3059sp, int i) {
        m1072s(c3059sp, i, -1, null, 0, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
    }

    /* renamed from: k */
    public final void m1080k(C3059sp c3059sp, C3064su c3064su) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            C2628cq.m2537as(c3075te.f8900a, new RunnableC3071ta(this, c3075te.f8901b, c3059sp, c3064su, 2));
        }
    }

    /* renamed from: l */
    public final void m1079l(InterfaceC3077tg interfaceC3077tg) {
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            if (c3075te.f8901b == interfaceC3077tg) {
                this.f8904c.remove(c3075te);
            }
        }
    }

    /* renamed from: m */
    public final void m1078m(final C3064su c3064su) {
        final C3067sx c3067sx = this.f8903b;
        C2616ce.m2689d(c3067sx);
        Iterator it = this.f8904c.iterator();
        while (it.hasNext()) {
            C3075te c3075te = (C3075te) it.next();
            final InterfaceC3077tg interfaceC3077tg = c3075te.f8901b;
            C2628cq.m2537as(c3075te.f8900a, new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.td
                @Override // java.lang.Runnable
                public final void run() {
                    C3076tf c3076tf = C3076tf.this;
                    interfaceC3077tg.mo1069aq(c3076tf.f8902a, c3067sx, c3064su);
                }
            });
        }
    }

    /* renamed from: n */
    public final void m1077n(int i, long j, long j2) {
        m1078m(new C3064su(1, i, null, 3, m1071t(j), m1071t(j2)));
    }

    /* renamed from: o */
    public final void m1076o(int i, C2962p c2962p, int i2, long j) {
        m1088c(new C3064su(1, i, c2962p, i2, m1071t(j), C3282C.TIME_UNSET));
    }

    /* renamed from: p */
    public final void m1075p(C3059sp c3059sp, int i, int i2, C2962p c2962p, int i3, long j, long j2) {
        m1086e(c3059sp, new C3064su(i, i2, c2962p, i3, m1071t(j), m1071t(j2)));
    }

    /* renamed from: q */
    public final void m1074q(C3059sp c3059sp, int i, int i2, C2962p c2962p, int i3, long j, long j2) {
        m1084g(c3059sp, new C3064su(i, i2, c2962p, i3, m1071t(j), m1071t(j2)));
    }

    /* renamed from: r */
    public final void m1073r(C3059sp c3059sp, int i, int i2, C2962p c2962p, int i3, long j, long j2, IOException iOException, boolean z) {
        m1082i(c3059sp, new C3064su(i, i2, c2962p, i3, m1071t(j), m1071t(j2)), iOException, z);
    }

    /* renamed from: s */
    public final void m1072s(C3059sp c3059sp, int i, int i2, C2962p c2962p, int i3, long j, long j2) {
        m1080k(c3059sp, new C3064su(i, i2, c2962p, i3, m1071t(j), m1071t(j2)));
    }
}
