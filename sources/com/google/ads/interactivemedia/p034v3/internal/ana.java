package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ana */
/* loaded from: classes2.dex */
public final class ana implements Runnable, amv {

    /* renamed from: c */
    private Context f4689c;

    /* renamed from: d */
    private final art f4690d;

    /* renamed from: e */
    private final Executor f4691e;

    /* renamed from: f */
    private final aew f4692f;

    /* renamed from: g */
    private final boolean f4693g;

    /* renamed from: h */
    private final boolean f4694h;

    /* renamed from: b */
    private final AtomicReference f4688b = new AtomicReference();

    /* renamed from: a */
    final CountDownLatch f4687a = new CountDownLatch(1);

    /* renamed from: i */
    private final List f4695i = new ArrayList();

    public ana(Context context, Executor executor, aew aewVar) {
        this.f4692f = aewVar;
        this.f4689c = context;
        this.f4691e = executor;
        aql.m4755a(context);
        boolean z = false;
        if (((Boolean) aql.f4890c.m4770f()).booleanValue() && aewVar.m5689d()) {
            z = true;
        }
        this.f4693g = z;
        art m4729a = art.m4729a(context, executor, z);
        this.f4690d = m4729a;
        Context context2 = this.f4689c;
        this.f4694h = new asu(this.f4689c, C2467al.m6013d(context2, m4729a), new amz(this), ((Boolean) aql.f4889b.m4770f()).booleanValue()).m4657d(1);
        executor.execute(this);
    }

    /* renamed from: d */
    private final void m4955d() {
        if (this.f4695i.isEmpty() || this.f4688b.get() == null) {
            return;
        }
        for (Object[] objArr : this.f4695i) {
            int length = objArr.length;
            if (length == 1) {
                ((amv) this.f4688b.get()).mo4948k((MotionEvent) objArr[0]);
            } else if (length == 3) {
                ((amv) this.f4688b.get()).mo4947l(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.f4695i.clear();
    }

    /* renamed from: i */
    private static final Context m4950i(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    /* renamed from: j */
    private final void m4949j() {
        this.f4688b.set(anc.m4931j(this.f4692f.m5691b(), m4950i(this.f4689c), this.f4692f.m5690c()));
    }

    /* renamed from: a */
    public final amv m4958a() {
        return (amv) this.f4688b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void m4956c() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ams.m4998a(this.f4692f.m5691b(), m4950i(this.f4689c), this.f4692f.m5690c(), this.f4693g).m4991o();
        } catch (NullPointerException e) {
            this.f4690d.m4727c(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    @Deprecated
    /* renamed from: e */
    public final String mo4954e(Context context, String str, View view, Activity activity) {
        if (mo4945s()) {
            m4955d();
            return ((amv) this.f4688b.get()).mo4954e(m4950i(context), str, view, activity);
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: f */
    public final String mo4953f(Context context) {
        return mo4952g(context, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: g */
    public final String mo4952g(Context context, byte[] bArr) {
        if (mo4945s()) {
            m4955d();
            return ((amv) this.f4688b.get()).mo4953f(m4950i(context));
        }
        return "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: h */
    public final String mo4951h(Context context, View view, Activity activity) {
        return mo4945s() ? ((amv) this.f4688b.get()).mo4951h(context, view, activity) : "";
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: k */
    public final void mo4948k(MotionEvent motionEvent) {
        if (this.f4688b.get() != null) {
            m4955d();
            ((amv) this.f4688b.get()).mo4948k(motionEvent);
            return;
        }
        this.f4695i.add(new Object[]{motionEvent});
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: l */
    public final void mo4947l(int i, int i2, int i3) {
        if (this.f4688b.get() == null) {
            this.f4695i.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        m4955d();
        ((amv) this.f4688b.get()).mo4947l(i, i2, i3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: n */
    public final void mo4938n(View view) {
        if (this.f4688b.get() != null) {
            ((amv) this.f4688b.get()).mo4938n(view);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: q */
    public final boolean mo4946q() {
        return this.f4687a.getCount() == 0 && this.f4688b.get() != null && ((amv) this.f4688b.get()).mo4946q();
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        int m5684j;
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                int i2 = aex.f3641a;
                m5684j = this.f4692f.m5684j();
                i = m5684j - 1;
            } catch (NullPointerException e) {
                if (this.f4692f.m5688e()) {
                    m4949j();
                }
                this.f4690d.m4727c(2031, System.currentTimeMillis() - currentTimeMillis, e);
                this.f4689c = null;
                countDownLatch = this.f4687a;
            }
            if (m5684j == 0) {
                throw null;
            }
            int i3 = i != 2 ? aex.f3642b : (this.f4694h || !this.f4692f.m5688e()) ? aex.f3643c : aex.f3642b;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == 1) {
                m4949j();
                if (this.f4692f.m5684j() == aex.f3643c) {
                    this.f4691e.execute(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.amy
                        @Override // java.lang.Runnable
                        public final void run() {
                            ana.this.m4956c();
                        }
                    });
                }
            } else if (i4 == 2) {
                ams m4997b = ams.m4997b(this.f4692f.m5691b(), m4950i(this.f4689c), this.f4691e, this.f4692f.m5690c(), this.f4693g);
                this.f4688b.set(m4997b);
                if (!m4997b.m4989r() && this.f4692f.m5688e()) {
                    m4949j();
                }
            }
            this.f4689c = null;
            countDownLatch = this.f4687a;
            countDownLatch.countDown();
        } catch (Throwable th) {
            this.f4689c = null;
            this.f4687a.countDown();
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: s */
    public final boolean mo4945s() {
        try {
            this.f4687a.await();
            if (this.f4688b.get() != null) {
                return ((amv) this.f4688b.get()).mo4945s();
            }
            return false;
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
