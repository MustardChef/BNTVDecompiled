package com.google.ads.interactivemedia.p034v3.internal;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.PlaybackException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.my */
/* loaded from: classes2.dex */
public final class C2906my implements InterfaceC2921nm {

    /* renamed from: a */
    volatile HandlerC2898mq f8146a;

    /* renamed from: c */
    private final UUID f8147c;

    /* renamed from: d */
    private final InterfaceC2939od f8148d;

    /* renamed from: e */
    private final HashMap f8149e;

    /* renamed from: f */
    private final int[] f8150f;

    /* renamed from: g */
    private final C2903mv f8151g;

    /* renamed from: h */
    private final C2905mx f8152h;

    /* renamed from: i */
    private final long f8153i;

    /* renamed from: j */
    private final List f8154j;

    /* renamed from: k */
    private final Set f8155k;

    /* renamed from: l */
    private final Set f8156l;

    /* renamed from: m */
    private int f8157m;

    /* renamed from: n */
    private InterfaceC2930nv f8158n;

    /* renamed from: o */
    private C2895mn f8159o;

    /* renamed from: p */
    private C2895mn f8160p;

    /* renamed from: q */
    private Looper f8161q;

    /* renamed from: r */
    private Handler f8162r;

    /* renamed from: s */
    private byte[] f8163s;

    /* renamed from: t */
    private final C2933ny f8164t;

    /* renamed from: u */
    private final C3161wj f8165u;

    public /* synthetic */ C2906my(UUID uuid, C2933ny c2933ny, InterfaceC2939od interfaceC2939od, HashMap hashMap, int[] iArr, C3161wj c3161wj, long j, byte[] bArr) {
        C2616ce.m2689d(uuid);
        C2616ce.m2686g(!C2692f.f7208b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f8147c = uuid;
        this.f8164t = c2933ny;
        this.f8148d = interfaceC2939od;
        this.f8149e = hashMap;
        this.f8150f = iArr;
        this.f8165u = c3161wj;
        this.f8151g = new C2903mv();
        this.f8152h = new C2905mx(this);
        this.f8154j = new ArrayList();
        this.f8155k = axd.m4407e();
        this.f8156l = axd.m4407e();
        this.f8153i = 300000L;
    }

    /* renamed from: A */
    private final void m1623A() {
        axf it = avo.m4495l(this.f8156l).iterator();
        while (it.hasNext()) {
            ((InterfaceC2910nb) it.next()).mo1570m(null);
        }
    }

    /* renamed from: B */
    private final void m1622B() {
        axf it = avo.m4495l(this.f8155k).iterator();
        while (it.hasNext()) {
            ((C2902mu) it.next()).mo1588c();
        }
    }

    /* renamed from: C */
    private static boolean m1621C(InterfaceC2910nb interfaceC2910nb) {
        if (interfaceC2910nb.mo1576a() == 1) {
            if (C2628cq.f6961a >= 19) {
                C2909na mo1574c = interfaceC2910nb.mo1574c();
                C2616ce.m2689d(mo1574c);
                return mo1574c.getCause() instanceof ResourceBusyException;
            }
            return true;
        }
        return false;
    }

    /* renamed from: D */
    private static final void m1620D(InterfaceC2910nb interfaceC2910nb, C2915ng c2915ng) {
        interfaceC2910nb.mo1570m(c2915ng);
        interfaceC2910nb.mo1570m(null);
    }

    /* renamed from: u */
    private final C2895mn m1604u(List list, boolean z, C2915ng c2915ng) {
        C2616ce.m2689d(this.f8158n);
        UUID uuid = this.f8147c;
        InterfaceC2930nv interfaceC2930nv = this.f8158n;
        C2903mv c2903mv = this.f8151g;
        C2905mx c2905mx = this.f8152h;
        byte[] bArr = this.f8163s;
        HashMap hashMap = this.f8149e;
        InterfaceC2939od interfaceC2939od = this.f8148d;
        Looper looper = this.f8161q;
        C2616ce.m2689d(looper);
        C2895mn c2895mn = new C2895mn(uuid, interfaceC2930nv, c2903mv, c2905mx, list, z, z, bArr, hashMap, interfaceC2939od, looper, this.f8165u, null);
        c2895mn.mo1571h(c2915ng);
        c2895mn.mo1571h(null);
        return c2895mn;
    }

    /* renamed from: v */
    private final C2895mn m1603v(List list, boolean z, C2915ng c2915ng, boolean z2) {
        C2895mn m1604u = m1604u(list, z, c2915ng);
        if (m1621C(m1604u) && !this.f8156l.isEmpty()) {
            m1623A();
            m1620D(m1604u, c2915ng);
            m1604u = m1604u(list, z, c2915ng);
        }
        if (m1621C(m1604u) && z2 && !this.f8155k.isEmpty()) {
            m1622B();
            if (!this.f8156l.isEmpty()) {
                m1623A();
            }
            m1620D(m1604u, c2915ng);
            return m1604u(list, z, c2915ng);
        }
        return m1604u;
    }

    /* renamed from: w */
    public final InterfaceC2910nb m1602w(Looper looper, C2915ng c2915ng, C2962p c2962p, boolean z) {
        if (this.f8146a == null) {
            this.f8146a = new HandlerC2898mq(this, looper);
        }
        C2854l c2854l = c2962p.f8375o;
        List list = null;
        if (c2854l == null) {
            int m4976a = C2554an.m4976a(c2962p.f8372l);
            InterfaceC2930nv interfaceC2930nv = this.f8158n;
            C2616ce.m2689d(interfaceC2930nv);
            if ((interfaceC2930nv.mo1501a() == 2 && C2931nw.f8192a) || C2628cq.m2521m(this.f8150f, m4976a) == -1 || interfaceC2930nv.mo1501a() == 1) {
                return null;
            }
            C2895mn c2895mn = this.f8159o;
            if (c2895mn == null) {
                C2895mn m1603v = m1603v(avg.m4515n(), true, null, z);
                this.f8154j.add(m1603v);
                this.f8159o = m1603v;
            } else {
                c2895mn.mo1571h(null);
            }
            return this.f8159o;
        }
        if (this.f8163s == null) {
            C2616ce.m2689d(c2854l);
            list = m1601x(c2854l, this.f8147c, false);
            if (list.isEmpty()) {
                C2899mr c2899mr = new C2899mr(this.f8147c);
                C2613cb.m2698a("DefaultDrmSessionMgr", "DRM error", c2899mr);
                if (c2915ng != null) {
                    c2915ng.m1591f(c2899mr);
                }
                return new C2927ns(new C2909na(c2899mr, PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR));
            }
        }
        C2895mn c2895mn2 = this.f8160p;
        if (c2895mn2 == null) {
            C2895mn m1603v2 = m1603v(list, false, c2915ng, z);
            this.f8160p = m1603v2;
            this.f8154j.add(m1603v2);
            return m1603v2;
        }
        c2895mn2.mo1571h(c2915ng);
        return c2895mn2;
    }

    /* renamed from: x */
    private static List m1601x(C2854l c2854l, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(c2854l.f7956b);
        for (int i = 0; i < c2854l.f7956b; i++) {
            C2827k m1736a = c2854l.m1736a(i);
            if ((m1736a.m1838c(uuid) || (C2692f.f7209c.equals(uuid) && m1736a.m1838c(C2692f.f7208b))) && (m1736a.f7783d != null || z)) {
                arrayList.add(m1736a);
            }
        }
        return arrayList;
    }

    /* renamed from: y */
    private final synchronized void m1600y(Looper looper) {
        Looper looper2 = this.f8161q;
        if (looper2 == null) {
            this.f8161q = looper;
            this.f8162r = new Handler(looper);
            return;
        }
        C2616ce.m2685h(looper2 == looper);
        C2616ce.m2689d(this.f8162r);
    }

    /* renamed from: z */
    public final void m1599z() {
        if (this.f8158n != null && this.f8157m == 0 && this.f8154j.isEmpty() && this.f8155k.isEmpty()) {
            InterfaceC2930nv interfaceC2930nv = this.f8158n;
            C2616ce.m2689d(interfaceC2930nv);
            interfaceC2930nv.mo1495g();
            this.f8158n = null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: b */
    public final int mo1587b(C2962p c2962p) {
        InterfaceC2930nv interfaceC2930nv = this.f8158n;
        C2616ce.m2689d(interfaceC2930nv);
        int mo1501a = interfaceC2930nv.mo1501a();
        C2854l c2854l = c2962p.f8375o;
        if (c2854l == null) {
            if (C2628cq.m2521m(this.f8150f, C2554an.m4976a(c2962p.f8372l)) != -1) {
                return mo1501a;
            }
            return 0;
        }
        if (this.f8163s == null) {
            if (m1601x(c2854l, this.f8147c, true).isEmpty()) {
                if (c2854l.f7956b == 1 && c2854l.m1736a(0).m1838c(C2692f.f7208b)) {
                    String valueOf = String.valueOf(this.f8147c);
                    String.valueOf(valueOf).length();
                    Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: ".concat(String.valueOf(valueOf)));
                }
                return 1;
            }
            String str = c2854l.f7955a;
            if (str != null && !C3282C.CENC_TYPE_cenc.equals(str) && (!C3282C.CENC_TYPE_cbcs.equals(str) ? C3282C.CENC_TYPE_cbc1.equals(str) || C3282C.CENC_TYPE_cens.equals(str) : C2628cq.f6961a < 25)) {
                return 1;
            }
        }
        return mo1501a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: i */
    public final InterfaceC2910nb mo1586i(Looper looper, C2915ng c2915ng, C2962p c2962p) {
        C2616ce.m2685h(this.f8157m > 0);
        m1600y(looper);
        return m1602w(looper, c2915ng, c2962p, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: j */
    public final InterfaceC2920nl mo1585j(Looper looper, C2915ng c2915ng, final C2962p c2962p) {
        C2616ce.m2685h(this.f8157m > 0);
        m1600y(looper);
        final C2902mu c2902mu = new C2902mu(this, c2915ng);
        Handler handler = c2902mu.f8138a.f8162r;
        C2616ce.m2689d(handler);
        handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.mt
            @Override // java.lang.Runnable
            public final void run() {
                C2902mu.this.m1629a(c2962p);
            }
        });
        return c2902mu;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: o */
    public final void mo1584o() {
        int i = this.f8157m;
        this.f8157m = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f8158n == null) {
            InterfaceC2930nv m1565a = this.f8164t.m1565a(this.f8147c);
            this.f8158n = m1565a;
            m1565a.mo1493i(new C2897mp(this));
            return;
        }
        for (int i2 = 0; i2 < this.f8154j.size(); i2++) {
            ((C2895mn) this.f8154j.get(i2)).mo1571h(null);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2921nm
    /* renamed from: p */
    public final void mo1583p() {
        int i = this.f8157m - 1;
        this.f8157m = i;
        if (i != 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f8154j);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((C2895mn) arrayList.get(i2)).mo1570m(null);
        }
        m1622B();
        m1599z();
    }

    /* renamed from: t */
    public final void m1605t(byte[] bArr) {
        C2616ce.m2685h(this.f8154j.isEmpty());
        this.f8163s = bArr;
    }
}
