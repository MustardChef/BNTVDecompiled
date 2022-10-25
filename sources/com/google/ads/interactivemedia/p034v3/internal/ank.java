package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ank */
/* loaded from: classes2.dex */
final class ank implements anm {

    /* renamed from: a */
    final /* synthetic */ Activity f4716a;

    /* renamed from: b */
    private final /* synthetic */ int f4717b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ank(Activity activity, int i) {
        this.f4717b = i;
        this.f4716a = activity;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anm
    /* renamed from: a */
    public final void mo4914a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        int i = this.f4717b;
        if (i == 0) {
            activityLifecycleCallbacks.onActivityResumed(this.f4716a);
        } else if (i == 1) {
            activityLifecycleCallbacks.onActivityStarted(this.f4716a);
        } else if (i == 2) {
            activityLifecycleCallbacks.onActivityPaused(this.f4716a);
        } else if (i != 3) {
            activityLifecycleCallbacks.onActivityDestroyed(this.f4716a);
        } else {
            activityLifecycleCallbacks.onActivityStopped(this.f4716a);
        }
    }
}
