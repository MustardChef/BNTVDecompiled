package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amw */
/* loaded from: classes2.dex */
public abstract class amw implements amv {

    /* renamed from: a */
    protected static volatile anw f4662a;

    /* renamed from: b */
    protected MotionEvent f4663b;

    /* renamed from: k */
    protected double f4672k;

    /* renamed from: l */
    protected float f4673l;

    /* renamed from: m */
    protected float f4674m;

    /* renamed from: n */
    protected float f4675n;

    /* renamed from: o */
    protected float f4676o;

    /* renamed from: q */
    protected DisplayMetrics f4678q;

    /* renamed from: r */
    private double f4679r;

    /* renamed from: s */
    private double f4680s;

    /* renamed from: c */
    protected final LinkedList f4664c = new LinkedList();

    /* renamed from: d */
    protected long f4665d = 0;

    /* renamed from: e */
    protected long f4666e = 0;

    /* renamed from: f */
    protected long f4667f = 0;

    /* renamed from: g */
    protected long f4668g = 0;

    /* renamed from: h */
    protected long f4669h = 0;

    /* renamed from: i */
    protected long f4670i = 0;

    /* renamed from: j */
    protected long f4671j = 0;

    /* renamed from: t */
    private boolean f4681t = false;

    /* renamed from: p */
    protected boolean f4677p = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public amw(Context context) {
        try {
            if (((Boolean) aql.f4906s.m4770f()).booleanValue()) {
                ama.m5005c();
            } else {
                anx.m4883a(f4662a);
            }
            this.f4678q = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    private final void m4981j() {
        this.f4669h = 0L;
        this.f4665d = 0L;
        this.f4666e = 0L;
        this.f4667f = 0L;
        this.f4668g = 0L;
        this.f4670i = 0L;
        this.f4671j = 0L;
        if (this.f4664c.size() > 0) {
            Iterator it = this.f4664c.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f4664c.clear();
        } else {
            MotionEvent motionEvent = this.f4663b;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.f4663b = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(14:5|6|7|(4:9|(1:11)(1:69)|12|(1:14)(1:68))(1:70)|15|16|(1:18)(1:(1:55)(1:56))|(1:21)|23|24|(3:41|42|(1:44)(4:45|(2:(1:49)(1:(1:52)(1:53))|50)|27|28))|26|27|28)|75|7|(0)(0)|15|16|(0)(0)|(1:21)|23|24|(0)|26|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r10 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        if (r2 == 3) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
        r0 = 1003;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
        if (r2 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
        r0 = 1009;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
        r0 = 1001;
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
        r3 = 2;
        r12.m4985c(r0, -1, java.lang.System.currentTimeMillis() - r8, r13, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: Exception -> 0x0063, TRY_ENTER, TryCatch #3 {Exception -> 0x0063, blocks: (B:24:0x005a, B:32:0x007e, B:28:0x0067, B:29:0x0071), top: B:74:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String m4980m(android.content.Context r22, java.lang.String r23, int r24, android.view.View r25, android.app.Activity r26, byte[] r27) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.amw.m4980m(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    /* renamed from: a */
    protected abstract long mo4944a(StackTraceElement[] stackTraceElementArr) throws ano;

    /* renamed from: b */
    protected abstract any mo4943b(MotionEvent motionEvent) throws ano;

    /* renamed from: c */
    protected abstract aga mo4942c(Context context, View view, Activity activity);

    /* renamed from: d */
    protected abstract aga mo4941d(Context context, afd afdVar);

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: e */
    public final String mo4954e(Context context, String str, View view, Activity activity) {
        return m4980m(context, str, 3, view, activity, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: f */
    public final String mo4953f(Context context) {
        if (anz.m4870f()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return m4980m(context, null, 1, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: g */
    public final String mo4952g(Context context, byte[] bArr) {
        if (anz.m4870f()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return m4980m(context, null, 1, null, null, bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: h */
    public final String mo4951h(Context context, View view, Activity activity) {
        return m4980m(context, null, 2, view, activity, null);
    }

    /* renamed from: i */
    protected abstract aga mo4940i(Context context, View view, Activity activity);

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: k */
    public final synchronized void mo4948k(MotionEvent motionEvent) {
        Long l;
        if (this.f4681t) {
            m4981j();
            this.f4681t = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4672k = 0.0d;
            this.f4679r = motionEvent.getRawX();
            this.f4680s = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.f4679r;
            double d2 = rawY - this.f4680s;
            this.f4672k += Math.sqrt((d * d) + (d2 * d2));
            this.f4679r = rawX;
            this.f4680s = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    this.f4663b = obtain;
                    this.f4664c.add(obtain);
                    if (this.f4664c.size() > 6) {
                        ((MotionEvent) this.f4664c.remove()).recycle();
                    }
                    this.f4667f++;
                    this.f4669h = mo4944a(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.f4666e += motionEvent.getHistorySize() + 1;
                    any mo4943b = mo4943b(motionEvent);
                    Long l2 = mo4943b.f4763d;
                    if (l2 != null && mo4943b.f4766g != null) {
                        this.f4670i += l2.longValue() + mo4943b.f4766g.longValue();
                    }
                    if (this.f4678q != null && (l = mo4943b.f4764e) != null && mo4943b.f4767h != null) {
                        this.f4671j += l.longValue() + mo4943b.f4767h.longValue();
                    }
                } else if (action2 == 3) {
                    this.f4668g++;
                }
            } catch (ano unused) {
            }
        } else {
            this.f4673l = motionEvent.getX();
            this.f4674m = motionEvent.getY();
            this.f4675n = motionEvent.getRawX();
            this.f4676o = motionEvent.getRawY();
            this.f4665d++;
        }
        this.f4677p = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: l */
    public final synchronized void mo4947l(int i, int i2, int i3) {
        if (this.f4663b != null) {
            if (((Boolean) aql.f4895h.m4770f()).booleanValue()) {
                m4981j();
            } else {
                this.f4663b.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.f4678q;
        if (displayMetrics != null) {
            this.f4663b = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, this.f4678q.density * i2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f4663b = null;
        }
        this.f4677p = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: n */
    public void mo4938n(View view) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: q */
    public final boolean mo4946q() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.amv
    /* renamed from: s */
    public final boolean mo4945s() {
        return true;
    }
}
