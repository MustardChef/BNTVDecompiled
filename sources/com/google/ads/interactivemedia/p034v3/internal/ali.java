package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.esp.EspAdapter;
import com.google.ads.interactivemedia.p034v3.api.esp.EspAdapterError;
import com.google.ads.interactivemedia.p034v3.api.esp.EspCollectSignalsCallback;
import com.google.ads.interactivemedia.p034v3.api.esp.VersionInfo;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2484bb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ali */
/* loaded from: classes2.dex */
public final class ali implements EspCollectSignalsCallback {

    /* renamed from: a */
    final /* synthetic */ TaskCompletionSource f4376a;

    /* renamed from: b */
    final /* synthetic */ alj f4377b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ali(alj aljVar, TaskCompletionSource taskCompletionSource) {
        this.f4377b = aljVar;
        this.f4376a = taskCompletionSource;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.esp.EspCollectSignalsCallback
    public final void onFailure(EspAdapterError espAdapterError) {
        this.f4376a.trySetException(espAdapterError);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.esp.EspCollectSignalsCallback
    public final void onSuccess(String str) {
        EspAdapter espAdapter;
        EspAdapter espAdapter2;
        espAdapter = this.f4377b.f4378a;
        VersionInfo versionInfo = espAdapter.getVersionInfo();
        espAdapter2 = this.f4377b.f4378a;
        this.f4376a.trySetResult(AbstractC2484bb.create(versionInfo, espAdapter2.getSDKVersionInfo(), this.f4377b.m5032e(), str));
    }
}
