package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aod */
/* loaded from: classes2.dex */
public final class aod implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static final Handler f4780a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private final Context f4781b;

    /* renamed from: c */
    private Application f4782c;

    /* renamed from: d */
    private final PowerManager f4783d;

    /* renamed from: e */
    private final KeyguardManager f4784e;

    /* renamed from: f */
    private BroadcastReceiver f4785f;

    /* renamed from: g */
    private final anq f4786g;

    /* renamed from: h */
    private WeakReference f4787h;

    /* renamed from: i */
    private WeakReference f4788i;

    /* renamed from: j */
    private ann f4789j;

    /* renamed from: k */
    private byte f4790k = -1;

    /* renamed from: l */
    private int f4791l = -1;

    /* renamed from: m */
    private long f4792m = -3;

    public aod(Context context, anq anqVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4781b = applicationContext;
        this.f4786g = anqVar;
        this.f4783d = (PowerManager) applicationContext.getSystemService("power");
        this.f4784e = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.f4782c = application;
            this.f4789j = new ann(application, this);
        }
        m4858d(null);
    }

    /* renamed from: e */
    private final void m4857e(Activity activity, int i) {
        Window window;
        if (this.f4788i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View m4860b = m4860b();
        if (m4860b == null || peekDecorView == null || m4860b.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.f4791l = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
        if ((r5.flags & 524288) != 0) goto L36;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4856f() {
        /*
            r7 = this;
            java.lang.ref.WeakReference r0 = r7.f4788i
            if (r0 != 0) goto L5
            return
        L5:
            android.view.View r0 = r7.m4860b()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L13
            r7.f4792m = r2
            r7.f4790k = r1
            return
        L13:
            int r4 = r0.getVisibility()
            if (r4 == 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            boolean r5 = r0.isShown()
            if (r5 != 0) goto L24
            r4 = r4 | 2
        L24:
            android.os.PowerManager r5 = r7.f4783d
            if (r5 == 0) goto L30
            boolean r5 = r5.isScreenOn()
            if (r5 != 0) goto L30
            r4 = r4 | 4
        L30:
            com.google.ads.interactivemedia.v3.internal.anq r5 = r7.f4786g
            boolean r5 = r5.m4912a()
            if (r5 != 0) goto L60
            android.app.KeyguardManager r5 = r7.f4784e
            if (r5 == 0) goto L5e
            boolean r5 = r5.inKeyguardRestrictedInputMode()
            if (r5 == 0) goto L5e
            android.app.Activity r5 = com.google.ads.interactivemedia.p034v3.internal.anz.m4874b(r0)
            if (r5 != 0) goto L49
            goto L5e
        L49:
            android.view.Window r5 = r5.getWindow()
            if (r5 != 0) goto L51
            r5 = 0
            goto L55
        L51:
            android.view.WindowManager$LayoutParams r5 = r5.getAttributes()
        L55:
            if (r5 == 0) goto L5e
            int r5 = r5.flags
            r6 = 524288(0x80000, float:7.34684E-40)
            r5 = r5 & r6
            if (r5 != 0) goto L60
        L5e:
            r4 = r4 | 8
        L60:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L6d
            r4 = r4 | 16
        L6d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L7a
            r4 = r4 | 32
        L7a:
            int r0 = r0.getWindowVisibility()
            int r5 = r7.f4791l
            if (r5 == r1) goto L83
            r0 = r5
        L83:
            if (r0 == 0) goto L87
            r4 = r4 | 64
        L87:
            byte r0 = r7.f4790k
            if (r0 == r4) goto L9a
            byte r0 = (byte) r4
            r7.f4790k = r0
            if (r4 != 0) goto L95
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L98
        L95:
            long r0 = (long) r4
            long r0 = r2 - r0
        L98:
            r7.f4792m = r0
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aod.m4856f():void");
    }

    /* renamed from: g */
    private final void m4855g() {
        f4780a.post(new aob(this));
    }

    /* renamed from: h */
    private final void m4854h(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f4787h = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f4785f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            aoc aocVar = new aoc(this);
            this.f4785f = aocVar;
            this.f4781b.registerReceiver(aocVar, intentFilter);
        }
        Application application = this.f4782c;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.f4789j);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: i */
    private final void m4853i(View view) {
        try {
            WeakReference weakReference = this.f4787h;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f4787h = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.f4785f;
        if (broadcastReceiver != null) {
            try {
                this.f4781b.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.f4785f = null;
        }
        Application application = this.f4782c;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.f4789j);
            } catch (Exception unused4) {
            }
        }
    }

    /* renamed from: a */
    public final long m4861a() {
        if (this.f4792m <= -2 && m4860b() == null) {
            this.f4792m = -3L;
        }
        return this.f4792m;
    }

    /* renamed from: b */
    final View m4860b() {
        WeakReference weakReference = this.f4788i;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m4858d(View view) {
        long j;
        View m4860b = m4860b();
        if (m4860b != null) {
            m4860b.removeOnAttachStateChangeListener(this);
            m4853i(m4860b);
        }
        this.f4788i = new WeakReference(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                m4854h(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.f4792m = j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m4857e(activity, 0);
        m4856f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        m4856f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        m4857e(activity, 4);
        m4856f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        m4857e(activity, 0);
        m4856f();
        m4855g();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m4856f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        m4857e(activity, 0);
        m4856f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        m4856f();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        m4856f();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        m4856f();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f4791l = -1;
        m4854h(view);
        m4856f();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f4791l = -1;
        m4856f();
        m4855g();
        m4853i(view);
    }
}
