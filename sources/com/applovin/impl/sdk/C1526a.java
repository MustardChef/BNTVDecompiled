package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a */
/* loaded from: classes.dex */
public class C1526a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final List<AbstractC1718a> f1465a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private WeakReference<Activity> f1466b;

    /* renamed from: c */
    private WeakReference<Activity> f1467c;

    public C1526a(Context context) {
        this.f1466b = new WeakReference<>(null);
        this.f1467c = new WeakReference<>(null);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.f1466b = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.f1467c = this.f1466b;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    /* renamed from: a */
    public Activity m7240a() {
        return this.f1466b.get();
    }

    /* renamed from: a */
    public void m7239a(AbstractC1718a abstractC1718a) {
        this.f1465a.add(abstractC1718a);
    }

    /* renamed from: b */
    public Activity m7238b() {
        return this.f1467c.get();
    }

    /* renamed from: b */
    public void m7237b(AbstractC1718a abstractC1718a) {
        this.f1465a.remove(abstractC1718a);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f1467c = new WeakReference<>(null);
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.f1466b = weakReference;
        this.f1467c = weakReference;
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        for (AbstractC1718a abstractC1718a : new ArrayList(this.f1465a)) {
            abstractC1718a.onActivityStopped(activity);
        }
    }
}
