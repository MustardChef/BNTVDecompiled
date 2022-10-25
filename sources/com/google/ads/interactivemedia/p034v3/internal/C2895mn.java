package com.google.ads.interactivemedia.p034v3.internal;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mn */
/* loaded from: classes2.dex */
public final class C2895mn implements InterfaceC2910nb {

    /* renamed from: a */
    public final List f8105a;

    /* renamed from: b */
    final InterfaceC2939od f8106b;

    /* renamed from: c */
    final UUID f8107c;

    /* renamed from: d */
    final HandlerC2893ml f8108d;

    /* renamed from: e */
    private final InterfaceC2930nv f8109e;

    /* renamed from: f */
    private final InterfaceC2889mh f8110f;

    /* renamed from: g */
    private final InterfaceC2890mi f8111g;

    /* renamed from: h */
    private final boolean f8112h;

    /* renamed from: i */
    private final boolean f8113i;

    /* renamed from: j */
    private final HashMap f8114j;

    /* renamed from: k */
    private final C2601bq f8115k;

    /* renamed from: l */
    private int f8116l;

    /* renamed from: m */
    private int f8117m;

    /* renamed from: n */
    private HandlerThread f8118n;

    /* renamed from: o */
    private HandlerC2891mj f8119o;

    /* renamed from: p */
    private InterfaceC2663dy f8120p;

    /* renamed from: q */
    private C2909na f8121q;

    /* renamed from: r */
    private byte[] f8122r;

    /* renamed from: s */
    private byte[] f8123s;

    /* renamed from: t */
    private C2929nu f8124t;

    /* renamed from: u */
    private aeg f8125u;

    /* renamed from: v */
    private final C3161wj f8126v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* bridge */ /* synthetic */ void m1646f(C2895mn c2895mn, Object obj, Object obj2) {
        if (obj == c2895mn.f8125u && c2895mn.m1634v()) {
            c2895mn.f8125u = null;
            if (obj2 instanceof Exception) {
                c2895mn.m1636t((Exception) obj2, false);
                return;
            }
            try {
                byte[] mo1490l = c2895mn.f8109e.mo1490l(c2895mn.f8122r, (byte[]) obj2);
                if (c2895mn.f8123s != null && mo1490l != null && mo1490l.length != 0) {
                    c2895mn.f8123s = mo1490l;
                }
                c2895mn.f8116l = 4;
                c2895mn.m1639q(C2888mg.f8095b);
            } catch (Exception e) {
                c2895mn.m1636t(e, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* bridge */ /* synthetic */ void m1645g(C2895mn c2895mn, Object obj, Object obj2) {
        if (obj == c2895mn.f8124t) {
            if (c2895mn.f8116l == 2 || c2895mn.m1634v()) {
                c2895mn.f8124t = null;
                if (obj2 instanceof Exception) {
                    c2895mn.f8110f.mo1626b((Exception) obj2, false);
                    return;
                }
                try {
                    c2895mn.f8109e.mo1496f((byte[]) obj2);
                    c2895mn.f8110f.mo1627a();
                } catch (Exception e) {
                    c2895mn.f8110f.mo1626b(e, true);
                }
            }
        }
    }

    /* renamed from: q */
    private final void m1639q(InterfaceC2600bp interfaceC2600bp) {
        for (C2915ng c2915ng : this.f8115k.m2856b()) {
            interfaceC2600bp.mo919a(c2915ng);
        }
    }

    /* renamed from: r */
    private final void m1638r(boolean z) {
        long min;
        if (this.f8113i) {
            return;
        }
        byte[] bArr = this.f8122r;
        byte[] bArr2 = (byte[]) C2628cq.m2578E(bArr);
        byte[] bArr3 = this.f8123s;
        if (bArr3 == null) {
            m1635u(bArr2, 1, z);
            return;
        }
        if (this.f8116l != 4) {
            try {
                this.f8109e.mo1494h(bArr, bArr3);
            } catch (Exception e) {
                m1637s(e, 1);
                return;
            }
        }
        if (C2692f.f7210d.equals(this.f8107c)) {
            Pair m1438a = C2958ow.m1438a(this);
            C2616ce.m2689d(m1438a);
            min = Math.min(((Long) m1438a.first).longValue(), ((Long) m1438a.second).longValue());
        } else {
            min = Long.MAX_VALUE;
        }
        if (min > 60) {
            this.f8116l = 4;
            m1639q(C2888mg.f8094a);
            return;
        }
        StringBuilder sb = new StringBuilder(88);
        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
        sb.append(min);
        Log.d("DefaultDrmSession", sb.toString());
        m1635u(bArr2, 2, z);
    }

    /* renamed from: s */
    private final void m1637s(final Exception exc, int i) {
        int i2 = C2628cq.f6961a;
        int i3 = PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED;
        if (i2 >= 21 && C2924np.m1578b(exc)) {
            i3 = C2924np.m1579a(exc);
        } else {
            if (C2628cq.f6961a < 23 || !C2925nq.m1577a(exc)) {
                if (C2628cq.f6961a < 18 || !C2923no.m1580b(exc)) {
                    if (C2628cq.f6961a >= 18 && C2923no.m1581a(exc)) {
                        i3 = PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED;
                    } else if (exc instanceof C2941of) {
                        i3 = PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED;
                    } else if (exc instanceof C2899mr) {
                        i3 = PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR;
                    } else if (exc instanceof C2938oc) {
                        i3 = PlaybackException.ERROR_CODE_DRM_LICENSE_EXPIRED;
                    } else if (i != 1) {
                        if (i == 2) {
                            i3 = PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED;
                        }
                    }
                }
            }
            i3 = PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
        }
        this.f8121q = new C2909na(exc, i3);
        C2613cb.m2698a("DefaultDrmSession", "DRM session error", exc);
        m1639q(new InterfaceC2600bp() { // from class: com.google.ads.interactivemedia.v3.internal.mf
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2600bp
            /* renamed from: a */
            public final void mo919a(Object obj) {
                ((C2915ng) obj).m1591f(exc);
            }
        });
        if (this.f8116l != 4) {
            this.f8116l = 1;
        }
    }

    /* renamed from: t */
    private final void m1636t(Exception exc, boolean z) {
        if (!(exc instanceof NotProvisionedException)) {
            m1637s(exc, true != z ? 2 : 1);
        } else {
            this.f8110f.mo1625c(this);
        }
    }

    /* renamed from: u */
    private final void m1635u(byte[] bArr, int i, boolean z) {
        try {
            this.f8125u = this.f8109e.mo1489m(bArr, this.f8105a, i, this.f8114j);
            HandlerC2891mj handlerC2891mj = this.f8119o;
            int i2 = C2628cq.f6961a;
            aeg aegVar = this.f8125u;
            C2616ce.m2689d(aegVar);
            handlerC2891mj.m1648a(1, aegVar, z);
        } catch (Exception e) {
            m1636t(e, true);
        }
    }

    /* renamed from: v */
    private final boolean m1634v() {
        int i = this.f8116l;
        return i == 3 || i == 4;
    }

    /* renamed from: w */
    private final boolean m1633w() {
        if (m1634v()) {
            return true;
        }
        try {
            byte[] mo1491k = this.f8109e.mo1491k();
            this.f8122r = mo1491k;
            this.f8120p = this.f8109e.mo1500b(mo1491k);
            this.f8116l = 3;
            m1639q(new InterfaceC2600bp(3) { // from class: com.google.ads.interactivemedia.v3.internal.me

                /* renamed from: a */
                public final /* synthetic */ int f8092a = 3;

                @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2600bp
                /* renamed from: a */
                public final void mo919a(Object obj) {
                    ((C2915ng) obj).m1592e(3);
                }
            });
            C2616ce.m2689d(this.f8122r);
            return true;
        } catch (NotProvisionedException unused) {
            this.f8110f.mo1625c(this);
            return false;
        } catch (Exception e) {
            m1637s(e, 1);
            return false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: a */
    public final int mo1576a() {
        return this.f8116l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: b */
    public final InterfaceC2663dy mo1575b() {
        return this.f8120p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: c */
    public final C2909na mo1574c() {
        if (this.f8116l == 1) {
            return this.f8121q;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: d */
    public final Map mo1573d() {
        byte[] bArr = this.f8122r;
        if (bArr == null) {
            return null;
        }
        return this.f8109e.mo1498d(bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: e */
    public final UUID mo1572e() {
        return this.f8107c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: h */
    public final void mo1571h(C2915ng c2915ng) {
        int i = this.f8117m;
        if (i < 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Session reference count less than zero: ");
            sb.append(i);
            Log.e("DefaultDrmSession", sb.toString());
            this.f8117m = 0;
        }
        if (c2915ng != null) {
            this.f8115k.m2855c(c2915ng);
        }
        int i2 = this.f8117m + 1;
        this.f8117m = i2;
        if (i2 == 1) {
            C2616ce.m2685h(this.f8116l == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f8118n = handlerThread;
            handlerThread.start();
            this.f8119o = new HandlerC2891mj(this, this.f8118n.getLooper());
            if (m1633w()) {
                m1638r(true);
            }
        } else if (c2915ng != null && m1634v() && this.f8115k.m2857a(c2915ng) == 1) {
            c2915ng.m1592e(this.f8116l);
        }
        C2905mx c2905mx = (C2905mx) this.f8111g;
        C2906my.m1611l(c2905mx.f8145a).remove(this);
        Handler m1617d = C2906my.m1617d(c2905mx.f8145a);
        C2616ce.m2689d(m1617d);
        m1617d.removeCallbacksAndMessages(this);
    }

    /* renamed from: i */
    public final void m1644i(int i) {
        if (i == 2 && this.f8116l == 4) {
            int i2 = C2628cq.f6961a;
            m1638r(false);
        }
    }

    /* renamed from: j */
    public final void m1643j() {
        if (m1633w()) {
            m1638r(true);
        }
    }

    /* renamed from: k */
    public final void m1642k(Exception exc, boolean z) {
        m1637s(exc, true != z ? 3 : 1);
    }

    /* renamed from: l */
    public final void m1641l() {
        this.f8124t = this.f8109e.mo1499c();
        HandlerC2891mj handlerC2891mj = this.f8119o;
        int i = C2628cq.f6961a;
        C2929nu c2929nu = this.f8124t;
        C2616ce.m2689d(c2929nu);
        handlerC2891mj.m1648a(0, c2929nu, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: m */
    public final void mo1570m(C2915ng c2915ng) {
        int i = this.f8117m;
        if (i <= 0) {
            Log.e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.f8117m = i2;
        if (i2 == 0) {
            this.f8116l = 0;
            HandlerC2893ml handlerC2893ml = this.f8108d;
            int i3 = C2628cq.f6961a;
            handlerC2893ml.removeCallbacksAndMessages(null);
            this.f8119o.m1647b();
            this.f8119o = null;
            this.f8118n.quit();
            this.f8118n = null;
            this.f8120p = null;
            this.f8121q = null;
            this.f8125u = null;
            this.f8124t = null;
            byte[] bArr = this.f8122r;
            if (bArr != null) {
                this.f8109e.mo1497e(bArr);
                this.f8122r = null;
            }
        }
        if (c2915ng != null) {
            this.f8115k.m2854d(c2915ng);
            if (this.f8115k.m2857a(c2915ng) == 0) {
                c2915ng.m1590g();
            }
        }
        InterfaceC2890mi interfaceC2890mi = this.f8111g;
        int i4 = this.f8117m;
        if (i4 == 1) {
            C2905mx c2905mx = (C2905mx) interfaceC2890mi;
            C2906my c2906my = c2905mx.f8145a;
            if (C2906my.m1619a(c2906my) > 0) {
                C2906my.m1611l(c2906my).add(this);
                Handler m1617d = C2906my.m1617d(c2905mx.f8145a);
                C2616ce.m2689d(m1617d);
                m1617d.postAtTime(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.mw
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2895mn.this.mo1570m(null);
                    }
                }, this, SystemClock.uptimeMillis() + C2906my.m1618c(c2905mx.f8145a));
            }
        } else if (i4 == 0) {
            C2905mx c2905mx2 = (C2905mx) interfaceC2890mi;
            C2906my.m1612k(c2905mx2.f8145a).remove(this);
            C2906my c2906my2 = c2905mx2.f8145a;
            if (C2906my.m1614g(c2906my2) == this) {
                C2906my.m1607r(c2906my2);
            }
            C2906my c2906my3 = c2905mx2.f8145a;
            if (C2906my.m1615f(c2906my3) == this) {
                C2906my.m1608q(c2906my3);
            }
            C2906my.m1613h(c2905mx2.f8145a).m1624d(this);
            Handler m1617d2 = C2906my.m1617d(c2905mx2.f8145a);
            C2616ce.m2689d(m1617d2);
            m1617d2.removeCallbacksAndMessages(this);
            C2906my.m1611l(c2905mx2.f8145a).remove(this);
        }
        C2906my.m1609n(((C2905mx) interfaceC2890mi).f8145a);
    }

    /* renamed from: n */
    public final boolean m1640n(byte[] bArr) {
        return Arrays.equals(this.f8122r, bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: o */
    public final boolean mo1569o() {
        return this.f8112h;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2910nb
    /* renamed from: p */
    public final boolean mo1568p(String str) {
        return this.f8109e.mo1492j((byte[]) C2616ce.m2688e(this.f8122r), str);
    }

    public C2895mn(UUID uuid, InterfaceC2930nv interfaceC2930nv, InterfaceC2889mh interfaceC2889mh, InterfaceC2890mi interfaceC2890mi, List list, boolean z, boolean z2, byte[] bArr, HashMap hashMap, InterfaceC2939od interfaceC2939od, Looper looper, C3161wj c3161wj, byte[] bArr2) {
        this.f8107c = uuid;
        this.f8110f = interfaceC2889mh;
        this.f8111g = interfaceC2890mi;
        this.f8109e = interfaceC2930nv;
        this.f8112h = z;
        this.f8113i = z2;
        if (bArr != null) {
            this.f8123s = bArr;
            this.f8105a = null;
        } else {
            C2616ce.m2689d(list);
            this.f8105a = Collections.unmodifiableList(list);
        }
        this.f8114j = hashMap;
        this.f8106b = interfaceC2939od;
        this.f8115k = new C2601bq();
        this.f8126v = c3161wj;
        this.f8116l = 2;
        this.f8108d = new HandlerC2893ml(this, looper);
    }
}
