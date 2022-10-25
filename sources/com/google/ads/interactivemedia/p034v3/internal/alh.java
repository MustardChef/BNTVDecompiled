package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.esp.EspAdapterError;
import com.google.ads.interactivemedia.p034v3.api.esp.EspInitializeCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alh */
/* loaded from: classes2.dex */
public final class alh implements EspInitializeCallback {

    /* renamed from: a */
    final /* synthetic */ alj f4375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public alh(alj aljVar) {
        this.f4375a = aljVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.esp.EspInitializeCallback
    public final void onFailure(EspAdapterError espAdapterError) {
        TaskCompletionSource taskCompletionSource;
        taskCompletionSource = this.f4375a.f4381d;
        taskCompletionSource.trySetException(espAdapterError);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.esp.EspInitializeCallback
    public final void onSuccess() {
        TaskCompletionSource taskCompletionSource;
        taskCompletionSource = this.f4375a.f4381d;
        taskCompletionSource.trySetResult(null);
    }
}
