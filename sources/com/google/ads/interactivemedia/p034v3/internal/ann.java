package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ann */
/* loaded from: classes2.dex */
final class ann implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f4721a;

    /* renamed from: b */
    private final WeakReference f4722b;

    /* renamed from: c */
    private boolean f4723c = false;

    public ann(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f4722b = new WeakReference(activityLifecycleCallbacks);
        this.f4721a = application;
    }

    /* renamed from: a */
    protected final void m4913a(anm anmVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f4722b.get();
            if (activityLifecycleCallbacks != null) {
                anmVar.mo4914a(activityLifecycleCallbacks);
            } else if (this.f4723c) {
            } else {
                this.f4721a.unregisterActivityLifecycleCallbacks(this);
                this.f4723c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m4913a(new anl(activity, bundle, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        m4913a(new ank(activity, 4));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        m4913a(new ank(activity, 2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        m4913a(new ank(activity, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m4913a(new anl(activity, bundle, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        m4913a(new ank(activity, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        m4913a(new ank(activity, 3));
    }
}
