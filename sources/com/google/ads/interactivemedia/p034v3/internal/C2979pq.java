package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pq */
/* loaded from: classes2.dex */
public final class C2979pq implements InterfaceC3000qk, InterfaceC3160wi {

    /* renamed from: a */
    public static final C2975pm f8482a = C2975pm.f8467a;

    /* renamed from: b */
    private final InterfaceC2995qf f8483b;

    /* renamed from: e */
    private C3076tf f8486e;

    /* renamed from: f */
    private C3167wp f8487f;

    /* renamed from: g */
    private Handler f8488g;

    /* renamed from: h */
    private InterfaceC2999qj f8489h;

    /* renamed from: i */
    private C2983pu f8490i;

    /* renamed from: j */
    private Uri f8491j;

    /* renamed from: k */
    private C2990qa f8492k;

    /* renamed from: l */
    private boolean f8493l;

    /* renamed from: n */
    private final C2944oi f8495n;

    /* renamed from: o */
    private final C3161wj f8496o;

    /* renamed from: d */
    private final CopyOnWriteArrayList f8485d = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final HashMap f8484c = new HashMap();

    /* renamed from: m */
    private long f8494m = C3282C.TIME_UNSET;

    public C2979pq(C2944oi c2944oi, C3161wj c3161wj, InterfaceC2995qf interfaceC2995qf, byte[] bArr) {
        this.f8495n = c2944oi;
        this.f8483b = interfaceC2995qf;
        this.f8496o = c3161wj;
    }

    /* renamed from: D */
    private final Uri m1363D(Uri uri) {
        C2985pw c2985pw;
        C2990qa c2990qa = this.f8492k;
        if (c2990qa == null || !c2990qa.f8558s.f8539e || (c2985pw = (C2985pw) c2990qa.f8556q.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(c2985pw.f8520b));
        int i = c2985pw.f8521c;
        if (i != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return buildUpon.build();
    }

    /* renamed from: E */
    private static C2986px m1362E(C2990qa c2990qa, C2990qa c2990qa2) {
        int i = (int) (c2990qa2.f8547h - c2990qa.f8547h);
        List list = c2990qa.f8554o;
        if (i < list.size()) {
            return (C2986px) list.get(i);
        }
        return null;
    }

    /* renamed from: p */
    public static /* bridge */ /* synthetic */ void m1352p(C2979pq c2979pq, Uri uri, C2990qa c2990qa) {
        if (uri.equals(c2979pq.f8491j)) {
            if (c2979pq.f8492k == null) {
                c2979pq.f8493l = !c2990qa.f8551l;
                c2979pq.f8494m = c2990qa.f8544e;
            }
            c2979pq.f8492k = c2990qa;
            c2979pq.f8489h.mo1322b(c2990qa);
        }
        Iterator it = c2979pq.f8485d.iterator();
        while (it.hasNext()) {
            ((InterfaceC2996qg) it.next()).mo1324j();
        }
    }

    /* renamed from: x */
    public static /* bridge */ /* synthetic */ boolean m1351x(C2979pq c2979pq) {
        long j;
        Uri uri;
        List list = c2979pq.f8490i.f8510c;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            C2978pp c2978pp = (C2978pp) c2979pq.f8484c.get(((C2982pt) list.get(i)).f8502a);
            C2616ce.m2689d(c2978pp);
            j = c2978pp.f8479i;
            if (elapsedRealtime > j) {
                uri = c2978pp.f8472b;
                c2979pq.f8491j = uri;
                c2978pp.m1366q(c2979pq.m1363D(uri));
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m1350y(C2979pq c2979pq, Uri uri, C3159wh c3159wh, boolean z) {
        Iterator it = c2979pq.f8485d.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !((InterfaceC2996qg) it.next()).mo1323s(uri, c3159wh, z);
        }
        return z2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: A */
    public final boolean mo1321A() {
        return this.f8493l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: B */
    public final boolean mo1320B(Uri uri) {
        return ((C2978pp) this.f8484c.get(uri)).m1368o();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* bridge */ /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        C2983pu c2983pu;
        C3170ws c3170ws = (C3170ws) interfaceC3163wl;
        AbstractC2991qb abstractC2991qb = (AbstractC2991qb) c3170ws.m711d();
        boolean z = abstractC2991qb instanceof C2990qa;
        if (z) {
            c2983pu = C2983pu.m1349a(abstractC2991qb.f8559t);
        } else {
            c2983pu = (C2983pu) abstractC2991qb;
        }
        this.f8490i = c2983pu;
        this.f8491j = ((C2982pt) c2983pu.f8510c.get(0)).f8502a;
        this.f8485d.add(new C2976pn(this));
        List list = c2983pu.f8509b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = (Uri) list.get(i);
            this.f8484c.put(uri, new C2978pp(this, uri));
        }
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        C2978pp c2978pp = (C2978pp) this.f8484c.get(this.f8491j);
        if (z) {
            c2978pp.m1365r((C2990qa) abstractC2991qb, c3059sp);
        } else {
            c2978pp.m1372k();
        }
        long j4 = c3170ws.f9315a;
        this.f8486e.m1085f(c3059sp, 4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    public final /* bridge */ /* synthetic */ C3158wg mo703bc(InterfaceC3163wl interfaceC3163wl, long j, long j2, IOException iOException, int i) {
        C3170ws c3170ws = (C3170ws) interfaceC3163wl;
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        int i2 = c3170ws.f9317c;
        long m738c = C3161wj.m738c(new C3159wh(iOException, i));
        boolean z = m738c == C3282C.TIME_UNSET;
        this.f8486e.m1083h(c3059sp, c3170ws.f9317c, iOException, z);
        if (z) {
            long j4 = c3170ws.f9315a;
            return C3167wp.f9311c;
        }
        return C3167wp.m716n(false, m738c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final /* bridge */ /* synthetic */ void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
        C3170ws c3170ws = (C3170ws) interfaceC3163wl;
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        long j4 = c3170ws.f9315a;
        this.f8486e.m1087d(c3059sp, 4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: d */
    public final long mo1319d() {
        return this.f8494m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: h */
    public final C2983pu mo1318h() {
        return this.f8490i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: k */
    public final C2990qa mo1317k(Uri uri, boolean z) {
        C2990qa c2990qa;
        C2990qa m1376g = ((C2978pp) this.f8484c.get(uri)).m1376g();
        if (m1376g != null && z && !uri.equals(this.f8491j)) {
            List list = this.f8490i.f8510c;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (uri.equals(((C2982pt) list.get(i)).f8502a)) {
                    C2990qa c2990qa2 = this.f8492k;
                    if (c2990qa2 == null || !c2990qa2.f8551l) {
                        this.f8491j = uri;
                        C2978pp c2978pp = (C2978pp) this.f8484c.get(uri);
                        c2990qa = c2978pp.f8475e;
                        if (c2990qa == null || !c2990qa.f8551l) {
                            c2978pp.m1366q(m1363D(uri));
                        } else {
                            this.f8492k = c2990qa;
                            this.f8489h.mo1322b(c2990qa);
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        return m1376g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: q */
    public final void mo1316q(InterfaceC2996qg interfaceC2996qg) {
        this.f8485d.add(interfaceC2996qg);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: r */
    public final void mo1315r(Uri uri) throws IOException {
        ((C2978pp) this.f8484c.get(uri)).m1371l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: s */
    public final void mo1314s() throws IOException {
        C3167wp c3167wp = this.f8487f;
        if (c3167wp != null) {
            c3167wp.mo715a();
        }
        Uri uri = this.f8491j;
        if (uri != null) {
            mo1315r(uri);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: t */
    public final void mo1313t(Uri uri) {
        ((C2978pp) this.f8484c.get(uri)).m1372k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: u */
    public final void mo1312u(InterfaceC2996qg interfaceC2996qg) {
        this.f8485d.remove(interfaceC2996qg);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: v */
    public final void mo1311v(Uri uri, C3076tf c3076tf, InterfaceC2999qj interfaceC2999qj) {
        this.f8488g = C2628cq.m2508z();
        this.f8486e = c3076tf;
        this.f8489h = interfaceC2999qj;
        C3170ws c3170ws = new C3170ws(this.f8495n.m1479a(), uri, 4, this.f8483b.mo1326a());
        C2616ce.m2685h(this.f8487f == null);
        C3167wp c3167wp = new C3167wp("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f8487f = c3167wp;
        c3167wp.m728b(c3170ws, this, C3161wj.m739b(c3170ws.f9317c));
        c3076tf.m1081j(new C3059sp(c3170ws.f9316b), c3170ws.f9317c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: w */
    public final void mo1310w() {
        this.f8491j = null;
        this.f8492k = null;
        this.f8490i = null;
        this.f8494m = C3282C.TIME_UNSET;
        this.f8487f.m720j();
        this.f8487f = null;
        for (C2978pp c2978pp : this.f8484c.values()) {
            c2978pp.m1370m();
        }
        this.f8488g.removeCallbacksAndMessages(null);
        this.f8488g = null;
        this.f8484c.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3000qk
    /* renamed from: z */
    public final boolean mo1309z(Uri uri, long j) {
        C2978pp c2978pp = (C2978pp) this.f8484c.get(uri);
        return (c2978pp == null || C2978pp.m1369n(c2978pp, j)) ? false : true;
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ C2990qa m1357j(C2979pq c2979pq, C2990qa c2990qa, C2990qa c2990qa2) {
        long j;
        int i;
        C2986px m1362E;
        int i2;
        int size;
        int size2;
        int size3;
        if (c2990qa != null && c2990qa2.f8547h <= c2990qa.f8547h && (i2 < 0 || ((size = c2990qa2.f8554o.size() - c2990qa.f8554o.size()) == 0 ? !((size2 = c2990qa2.f8555p.size()) > (size3 = c2990qa.f8555p.size()) || (size2 == size3 && c2990qa2.f8551l && !c2990qa.f8551l)) : size <= 0))) {
            return (!c2990qa2.f8551l || c2990qa.f8551l) ? c2990qa : new C2990qa(c2990qa.f8540a, c2990qa.f8559t, c2990qa.f8560u, c2990qa.f8541b, c2990qa.f8543d, c2990qa.f8544e, c2990qa.f8545f, c2990qa.f8546g, c2990qa.f8547h, c2990qa.f8548i, c2990qa.f8549j, c2990qa.f8550k, c2990qa.f8561v, true, c2990qa.f8552m, c2990qa.f8553n, c2990qa.f8554o, c2990qa.f8555p, c2990qa.f8558s, c2990qa.f8556q);
        }
        if (c2990qa2.f8552m) {
            j = c2990qa2.f8544e;
        } else {
            C2990qa c2990qa3 = c2979pq.f8492k;
            j = c2990qa3 != null ? c2990qa3.f8544e : 0L;
            if (c2990qa != null) {
                int size4 = c2990qa.f8554o.size();
                C2986px m1362E2 = m1362E(c2990qa, c2990qa2);
                if (m1362E2 != null) {
                    j = c2990qa.f8544e + m1362E2.f8528g;
                } else if (size4 == c2990qa2.f8547h - c2990qa.f8547h) {
                    j = c2990qa.m1346a();
                }
            }
        }
        long j2 = j;
        if (c2990qa2.f8545f) {
            i = c2990qa2.f8546g;
        } else {
            C2990qa c2990qa4 = c2979pq.f8492k;
            i = c2990qa4 != null ? c2990qa4.f8546g : 0;
            if (c2990qa != null && (m1362E = m1362E(c2990qa, c2990qa2)) != null) {
                i = (c2990qa.f8546g + m1362E.f8527f) - ((C2986px) c2990qa2.f8554o.get(0)).f8527f;
            }
        }
        return new C2990qa(c2990qa2.f8540a, c2990qa2.f8559t, c2990qa2.f8560u, c2990qa2.f8541b, c2990qa2.f8543d, j2, true, i, c2990qa2.f8547h, c2990qa2.f8548i, c2990qa2.f8549j, c2990qa2.f8550k, c2990qa2.f8561v, c2990qa2.f8551l, c2990qa2.f8552m, c2990qa2.f8553n, c2990qa2.f8554o, c2990qa2.f8555p, c2990qa2.f8558s, c2990qa2.f8556q);
    }
}
