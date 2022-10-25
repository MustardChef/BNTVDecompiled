package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alg */
/* loaded from: classes2.dex */
public final class alg implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f4373a;

    /* renamed from: b */
    private final List f4374b = new ArrayList();

    public alg(Application application) {
        this.f4373a = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public final void m5038a(alf alfVar) {
        this.f4374b.add(alfVar);
    }

    /* renamed from: b */
    public final void m5037b() {
        this.f4373a.unregisterActivityLifecycleCallbacks(this);
        this.f4374b.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        for (alf alfVar : this.f4374b) {
            alfVar.mo5040d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        for (alf alfVar : this.f4374b) {
            alfVar.mo5039e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
