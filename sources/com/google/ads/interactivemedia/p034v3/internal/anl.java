package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anl */
/* loaded from: classes2.dex */
final class anl implements anm {

    /* renamed from: a */
    final /* synthetic */ Activity f4718a;

    /* renamed from: b */
    final /* synthetic */ Bundle f4719b;

    /* renamed from: c */
    private final /* synthetic */ int f4720c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anl(Activity activity, Bundle bundle, int i) {
        this.f4720c = i;
        this.f4718a = activity;
        this.f4719b = bundle;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anm
    /* renamed from: a */
    public final void mo4914a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.f4720c != 0) {
            activityLifecycleCallbacks.onActivityCreated(this.f4718a, this.f4719b);
        } else {
            activityLifecycleCallbacks.onActivitySaveInstanceState(this.f4718a, this.f4719b);
        }
    }
}
