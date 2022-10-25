package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahy */
/* loaded from: classes2.dex */
public final class ahy implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ ahz f4107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahy(ahz ahzVar) {
        this.f4107a = ahzVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Activity activity2;
        ahz ahzVar = this.f4107a;
        activity2 = ahzVar.f4112e;
        if (activity2 == activity) {
            ahzVar.f4112e = null;
            this.f4107a.m5221k();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Activity activity2;
        ajx ajxVar;
        String str;
        Activity activity3;
        ahz ahzVar = this.f4107a;
        activity2 = ahzVar.f4112e;
        if (activity2 != null) {
            activity3 = ahzVar.f4112e;
            if (activity3 != activity) {
                return;
            }
        }
        ahzVar.f4112e = activity;
        AbstractC2482b m5228c = this.f4107a.m5228c("", "", "inactive");
        ajxVar = this.f4107a.f4108a;
        ajo ajoVar = ajo.activityMonitor;
        ajp ajpVar = ajp.appStateChanged;
        str = this.f4107a.f4109b;
        ajxVar.mo5122o(new ajq(ajoVar, ajpVar, str, m5228c));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Activity activity2;
        ajx ajxVar;
        String str;
        ahz ahzVar = this.f4107a;
        activity2 = ahzVar.f4112e;
        if (activity2 == activity) {
            AbstractC2482b m5228c = ahzVar.m5228c("", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            ajxVar = this.f4107a.f4108a;
            ajo ajoVar = ajo.activityMonitor;
            ajp ajpVar = ajp.appStateChanged;
            str = this.f4107a.f4109b;
            ajxVar.mo5122o(new ajq(ajoVar, ajpVar, str, m5228c));
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
