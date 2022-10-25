package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arf */
/* loaded from: classes2.dex */
final class arf extends aqt {

    /* renamed from: a */
    final /* synthetic */ TaskCompletionSource f4929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public arf(TaskCompletionSource taskCompletionSource) {
        this.f4929a = taskCompletionSource;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqu
    /* renamed from: b */
    public final void mo4737b(int i) {
        this.f4929a.trySetException(new arc(i));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aqu
    /* renamed from: c */
    public final void mo4736c(aqz aqzVar) {
        this.f4929a.trySetResult(aqzVar.m4744a());
    }
}
