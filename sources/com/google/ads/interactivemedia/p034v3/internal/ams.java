package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import com.google.android.exoplayer2.PlaybackException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ams */
/* loaded from: classes2.dex */
public final class ams implements amv {

    /* renamed from: b */
    private static ams f4641b;

    /* renamed from: c */
    private final Context f4643c;

    /* renamed from: d */
    private final asq f4644d;

    /* renamed from: e */
    private final asu f4645e;

    /* renamed from: f */
    private final asw f4646f;

    /* renamed from: g */
    private final anr f4647g;

    /* renamed from: h */
    private final art f4648h;

    /* renamed from: i */
    private final Executor f4649i;

    /* renamed from: j */
    private final InterfaceC2563ast f4650j;

    /* renamed from: m */
    private volatile boolean f4653m;

    /* renamed from: o */
    private final int f4655o;

    /* renamed from: a */
    volatile long f4642a = 0;

    /* renamed from: l */
    private final Object f4652l = new Object();

    /* renamed from: n */
    private volatile boolean f4654n = false;

    /* renamed from: k */
    private final CountDownLatch f4651k = new CountDownLatch(1);

    ams(Context context, art artVar, asq asqVar, asu asuVar, asw aswVar, anr anrVar, Executor executor, ari ariVar, int i) {
        this.f4643c = context;
        this.f4648h = artVar;
        this.f4644d = asqVar;
        this.f4645e = asuVar;
        this.f4646f = aswVar;
        this.f4647g = anrVar;
        this.f4649i = executor;
        this.f4655o = i;
        this.f4650j = new amq(ariVar);
    }

    /* renamed from: a */
    public static synchronized ams m4998a(String str, Context context, boolean z, boolean z2) {
        ams m4997b;
        synchronized (ams.class) {
            m4997b = m4997b(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return m4997b;
    }

    @Deprecated
    /* renamed from: b */
    public static synchronized ams m4997b(String str, Context context, Executor executor, boolean z, boolean z2) {
        ams amsVar;
        synchronized (ams.class) {
            if (f4641b == null) {
                aru m4717a = arv.m4717a();
                m4717a.m4720b(str);
                m4717a.m4718d(z);
                arv m4721a = m4717a.m4721a();
                art m4729a = art.m4729a(context, executor, z2);
                ang m4919c = ((Boolean) aql.f4909v.m4770f()).booleanValue() ? ang.m4919c(context) : null;
                asf m4695e = asf.m4695e(context, executor, m4729a, m4721a);
                anq anqVar = new anq(context);
                anr anrVar = new anr(m4721a, m4695e, new aod(context, anqVar), anqVar, m4919c);
                int m6013d = C2467al.m6013d(context, m4729a);
                ari ariVar = new ari();
                ams amsVar2 = new ams(context, m4729a, new asq(context, m6013d), new asu(context, m6013d, new amp(m4729a), ((Boolean) aql.f4889b.m4770f()).booleanValue()), new asw(context, anrVar, m4729a, ariVar), anrVar, executor, ariVar, m6013d);
                f4641b = amsVar2;
                amsVar2.m4992m();
                f4641b.m4991o();
            }
            amsVar = f4641b;
        }
        return amsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (r4.m4837c().m4821j().equals(r5.m4821j()) != false) goto L47;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ void m4993j(com.google.ads.interactivemedia.p034v3.internal.ams r8) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ams.m4993j(com.google.ads.interactivemedia.v3.internal.ams):void");
    }

    /* renamed from: t */
    private final asp m4988t(int i) {
        if (C2467al.m6014c(this.f4655o)) {
            if (((Boolean) aql.f4888a.m4770f()).booleanValue()) {
                return this.f4645e.m4658c(1);
            }
            return this.f4644d.m4665d(1);
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: e */
    public final String mo4954e(Context context, String str, View view, Activity activity) {
        m4991o();
        arw m4648a = this.f4646f.m4648a();
        if (m4648a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String mo4684a = m4648a.mo4684a(context, str, view, activity);
            this.f4648h.m4724f(5000, System.currentTimeMillis() - currentTimeMillis, mo4684a);
            return mo4684a;
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: f */
    public final String mo4953f(Context context) {
        m4991o();
        arw m4648a = this.f4646f.m4648a();
        if (m4648a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String mo4682c = m4648a.mo4682c(context);
            this.f4648h.m4724f(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, System.currentTimeMillis() - currentTimeMillis, mo4682c);
            return mo4682c;
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: g */
    public final String mo4952g(Context context, byte[] bArr) {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: h */
    public final String mo4951h(Context context, View view, Activity activity) {
        m4991o();
        arw m4648a = this.f4646f.m4648a();
        if (m4648a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String mo4683b = m4648a.mo4683b(context, view, activity);
            this.f4648h.m4724f(PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED, System.currentTimeMillis() - currentTimeMillis, mo4683b);
            return mo4683b;
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: k */
    public final void mo4948k(MotionEvent motionEvent) {
        arw m4648a = this.f4646f.m4648a();
        if (m4648a != null) {
            try {
                m4648a.mo4681d(motionEvent);
            } catch (asv e) {
                this.f4648h.m4727c(e.m4649a(), -1L, e);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: l */
    public final void mo4947l(int i, int i2, int i3) {
    }

    /* renamed from: m */
    final synchronized void m4992m() {
        long currentTimeMillis = System.currentTimeMillis();
        asp m4988t = m4988t(1);
        if (m4988t != null) {
            if (this.f4646f.m4646c(m4988t)) {
                this.f4654n = true;
                this.f4651k.countDown();
                return;
            }
            return;
        }
        this.f4648h.m4726d(4013, System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: n */
    public final void mo4938n(View view) {
        this.f4647g.m4911d(view);
    }

    /* renamed from: o */
    public final void m4991o() {
        if (this.f4653m) {
            return;
        }
        synchronized (this.f4652l) {
            if (!this.f4653m) {
                if ((System.currentTimeMillis() / 1000) - this.f4642a < 3600) {
                    return;
                }
                asp m4647b = this.f4646f.m4647b();
                if ((m4647b == null || m4647b.m4670d()) && C2467al.m6014c(this.f4655o)) {
                    this.f4649i.execute(new RunnableC2553amr(this));
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: q */
    public final boolean mo4946q() {
        return m4989r();
    }

    /* renamed from: r */
    public final synchronized boolean m4989r() {
        return this.f4654n;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: s */
    public final boolean mo4945s() {
        try {
            this.f4651k.await();
        } catch (InterruptedException unused) {
        }
        return m4989r();
    }
}
