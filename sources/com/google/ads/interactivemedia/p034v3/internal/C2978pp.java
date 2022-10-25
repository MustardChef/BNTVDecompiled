package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pp */
/* loaded from: classes2.dex */
public final class C2978pp implements InterfaceC3160wi {

    /* renamed from: a */
    final /* synthetic */ C2979pq f8471a;

    /* renamed from: b */
    private final Uri f8472b;

    /* renamed from: c */
    private final C3167wp f8473c = new C3167wp("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: d */
    private final InterfaceC2637cz f8474d;

    /* renamed from: e */
    private C2990qa f8475e;

    /* renamed from: f */
    private long f8476f;

    /* renamed from: g */
    private long f8477g;

    /* renamed from: h */
    private long f8478h;

    /* renamed from: i */
    private long f8479i;

    /* renamed from: j */
    private boolean f8480j;

    /* renamed from: k */
    private IOException f8481k;

    public C2978pp(C2979pq c2979pq, Uri uri) {
        this.f8471a = c2979pq;
        this.f8472b = uri;
        this.f8474d = C2979pq.m1364C(c2979pq).m1479a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* bridge */ /* synthetic */ boolean m1369n(C2978pp c2978pp, long j) {
        c2978pp.f8479i = SystemClock.elapsedRealtime() + j;
        return c2978pp.f8472b.equals(C2979pq.m1361e(c2978pp.f8471a)) && !C2979pq.m1351x(c2978pp.f8471a);
    }

    /* renamed from: p */
    private final void m1367p(Uri uri) {
        C2979pq c2979pq = this.f8471a;
        C3170ws c3170ws = new C3170ws(this.f8474d, uri, 4, C2979pq.m1356l(c2979pq).mo1325b(C2979pq.m1359g(c2979pq), this.f8475e));
        this.f8473c.m728b(c3170ws, this, C3161wj.m739b(c3170ws.f9317c));
        C2979pq.m1355m(this.f8471a).m1081j(new C3059sp(c3170ws.f9316b), c3170ws.f9317c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public final void m1366q(final Uri uri) {
        this.f8479i = 0L;
        if (this.f8480j) {
            return;
        }
        C3167wp c3167wp = this.f8473c;
        if (c3167wp.m717m() || c3167wp.m718l()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f8478h;
        if (elapsedRealtime < j) {
            this.f8480j = true;
            C2979pq.m1360f(this.f8471a).postDelayed(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.po
                @Override // java.lang.Runnable
                public final void run() {
                    C2978pp.this.m1373j(uri);
                }
            }, j - elapsedRealtime);
            return;
        }
        m1367p(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public final void m1365r(C2990qa c2990qa, C3059sp c3059sp) {
        C2990qa c2990qa2;
        long j;
        Uri uri;
        C2990qa c2990qa3 = this.f8475e;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f8476f = elapsedRealtime;
        C2990qa m1357j = C2979pq.m1357j(this.f8471a, c2990qa3, c2990qa);
        this.f8475e = m1357j;
        IOException iOException = null;
        if (m1357j != c2990qa3) {
            this.f8481k = null;
            this.f8477g = elapsedRealtime;
            C2979pq.m1352p(this.f8471a, this.f8472b, m1357j);
        } else if (!m1357j.f8551l) {
            long j2 = c2990qa.f8547h;
            int size = c2990qa.f8554o.size();
            boolean z = false;
            if (j2 + size < this.f8475e.f8547h) {
                iOException = new C2997qh();
                z = true;
            } else if (elapsedRealtime - this.f8477g > C2628cq.m2511w(c2990qa2.f8549j) * 3.5d) {
                iOException = new C2998qi();
            }
            if (iOException != null) {
                this.f8481k = iOException;
                C2979pq.m1350y(this.f8471a, this.f8472b, new C3159wh(iOException, 1), z);
            }
        }
        C2990qa c2990qa4 = this.f8475e;
        if (c2990qa4.f8558s.f8539e) {
            j = 0;
        } else if (c2990qa4 != c2990qa3) {
            j = c2990qa4.f8549j;
        } else {
            j = c2990qa4.f8549j / 2;
        }
        this.f8478h = elapsedRealtime + C2628cq.m2511w(j);
        if (c2990qa4.f8550k != C3282C.TIME_UNSET || this.f8472b.equals(C2979pq.m1361e(this.f8471a))) {
            C2990qa c2990qa5 = this.f8475e;
            if (c2990qa5.f8551l) {
                return;
            }
            if (c2990qa5 != null) {
                C2988pz c2988pz = c2990qa5.f8558s;
                if (c2988pz.f8535a != C3282C.TIME_UNSET || c2988pz.f8539e) {
                    Uri.Builder buildUpon = this.f8472b.buildUpon();
                    C2990qa c2990qa6 = this.f8475e;
                    if (c2990qa6.f8558s.f8539e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(c2990qa6.f8547h + c2990qa6.f8554o.size()));
                        C2990qa c2990qa7 = this.f8475e;
                        if (c2990qa7.f8550k != C3282C.TIME_UNSET) {
                            List list = c2990qa7.f8555p;
                            int size2 = list.size();
                            if (!list.isEmpty() && ((C2984pv) axd.m4386z(list)).f8518b) {
                                size2--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size2));
                        }
                    }
                    C2988pz c2988pz2 = this.f8475e.f8558s;
                    if (c2988pz2.f8535a != C3282C.TIME_UNSET) {
                        buildUpon.appendQueryParameter("_HLS_skip", true != c2988pz2.f8536b ? "YES" : "v2");
                    }
                    uri = buildUpon.build();
                    m1366q(uri);
                }
            }
            uri = this.f8472b;
            m1366q(uri);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* bridge */ /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        C3170ws c3170ws = (C3170ws) interfaceC3163wl;
        AbstractC2991qb abstractC2991qb = (AbstractC2991qb) c3170ws.m711d();
        long j3 = c3170ws.f9315a;
        C2642dd c2642dd = c3170ws.f9316b;
        c3170ws.m712c();
        c3170ws.m710f();
        c3170ws.m713a();
        C3059sp c3059sp = new C3059sp();
        if (abstractC2991qb instanceof C2990qa) {
            m1365r((C2990qa) abstractC2991qb, c3059sp);
            C2979pq.m1355m(this.f8471a).m1085f(c3059sp, 4);
        } else {
            this.f8481k = C2555ao.m4864c("Loaded playlist has unexpected type.", null);
            C2979pq.m1355m(this.f8471a).m1083h(c3059sp, 4, this.f8481k, true);
        }
        long j4 = c3170ws.f9315a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ com.google.ads.interactivemedia.p034v3.internal.C3158wg mo703bc(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl r4, long r5, long r7, java.io.IOException r9, int r10) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.ws r4 = (com.google.ads.interactivemedia.p034v3.internal.C3170ws) r4
            com.google.ads.interactivemedia.v3.internal.sp r5 = new com.google.ads.interactivemedia.v3.internal.sp
            long r6 = r4.f9315a
            com.google.ads.interactivemedia.v3.internal.dd r6 = r4.f9316b
            r4.m712c()
            r4.m710f()
            r4.m713a()
            r5.<init>()
            android.net.Uri r6 = r4.m712c()
            java.lang.String r7 = "_HLS_msn"
            java.lang.String r6 = r6.getQueryParameter(r7)
            boolean r7 = r9 instanceof com.google.ads.interactivemedia.p034v3.internal.C2992qc
            r8 = 1
            if (r6 != 0) goto L26
            if (r7 == 0) goto L3e
            r7 = 1
        L26:
            boolean r6 = r9 instanceof com.google.ads.interactivemedia.p034v3.internal.C2653do
            if (r6 == 0) goto L30
            r6 = r9
            com.google.ads.interactivemedia.v3.internal.do r6 = (com.google.ads.interactivemedia.p034v3.internal.C2653do) r6
            int r6 = r6.f7052b
            goto L33
        L30:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L33:
            if (r7 != 0) goto L7d
            r7 = 400(0x190, float:5.6E-43)
            if (r6 == r7) goto L7d
            r7 = 503(0x1f7, float:7.05E-43)
            if (r6 != r7) goto L3e
            goto L7d
        L3e:
            int r6 = r4.f9317c
            com.google.ads.interactivemedia.v3.internal.wh r6 = new com.google.ads.interactivemedia.v3.internal.wh
            r6.<init>(r9, r10)
            com.google.ads.interactivemedia.v3.internal.pq r7 = r3.f8471a
            android.net.Uri r10 = r3.f8472b
            r0 = 0
            boolean r7 = com.google.ads.interactivemedia.p034v3.internal.C2979pq.m1350y(r7, r10, r6, r0)
            if (r7 == 0) goto L65
            long r6 = com.google.ads.interactivemedia.p034v3.internal.C3161wj.m738c(r6)
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 == 0) goto L62
            com.google.ads.interactivemedia.v3.internal.wg r6 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.m716n(r0, r6)
            goto L67
        L62:
            com.google.ads.interactivemedia.v3.internal.wg r6 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.f9311c
            goto L67
        L65:
            com.google.ads.interactivemedia.v3.internal.wg r6 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.f9310b
        L67:
            boolean r7 = r6.m743a()
            r7 = r7 ^ r8
            com.google.ads.interactivemedia.v3.internal.pq r8 = r3.f8471a
            com.google.ads.interactivemedia.v3.internal.tf r8 = com.google.ads.interactivemedia.p034v3.internal.C2979pq.m1355m(r8)
            int r10 = r4.f9317c
            r8.m1083h(r5, r10, r9, r7)
            if (r7 != 0) goto L7a
            goto L95
        L7a:
            long r4 = r4.f9315a
            return r6
        L7d:
            long r6 = android.os.SystemClock.elapsedRealtime()
            r3.f8478h = r6
            r3.m1372k()
            com.google.ads.interactivemedia.v3.internal.pq r6 = r3.f8471a
            com.google.ads.interactivemedia.v3.internal.tf r6 = com.google.ads.interactivemedia.p034v3.internal.C2979pq.m1355m(r6)
            int r7 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            int r4 = r4.f9317c
            r6.m1083h(r5, r4, r9, r8)
            com.google.ads.interactivemedia.v3.internal.wg r6 = com.google.ads.interactivemedia.p034v3.internal.C3167wp.f9310b
        L95:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2978pp.mo703bc(com.google.ads.interactivemedia.v3.internal.wl, long, long, java.io.IOException, int):com.google.ads.interactivemedia.v3.internal.wg");
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
        C2979pq.m1355m(this.f8471a).m1087d(c3059sp, 4);
    }

    /* renamed from: g */
    public final C2990qa m1376g() {
        return this.f8475e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ void m1373j(Uri uri) {
        this.f8480j = false;
        m1367p(uri);
    }

    /* renamed from: k */
    public final void m1372k() {
        m1366q(this.f8472b);
    }

    /* renamed from: l */
    public final void m1371l() throws IOException {
        this.f8473c.mo715a();
        IOException iOException = this.f8481k;
        if (iOException != null) {
            throw iOException;
        }
    }

    /* renamed from: m */
    public final void m1370m() {
        this.f8473c.m720j();
    }

    /* renamed from: o */
    public final boolean m1368o() {
        int i;
        if (this.f8475e == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, C2628cq.m2511w(this.f8475e.f8557r));
        C2990qa c2990qa = this.f8475e;
        return c2990qa.f8551l || (i = c2990qa.f8540a) == 2 || i == 1 || this.f8476f + max > elapsedRealtime;
    }
}
