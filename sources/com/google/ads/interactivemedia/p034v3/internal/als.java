package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.als */
/* loaded from: classes2.dex */
final class als implements aye {

    /* renamed from: a */
    final /* synthetic */ TaskCompletionSource f4403a;

    /* renamed from: b */
    final /* synthetic */ String f4404b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public als(TaskCompletionSource taskCompletionSource, String str) {
        this.f4403a = taskCompletionSource;
        this.f4404b = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aye
    /* renamed from: a */
    public final void mo4334a(Throwable th) {
        TaskCompletionSource taskCompletionSource = this.f4403a;
        String valueOf = String.valueOf(this.f4404b);
        taskCompletionSource.setException(new Exception(valueOf.length() != 0 ? "Failed to load image from: ".concat(valueOf) : new String("Failed to load image from: "), th));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aye
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo4333b(Object obj) {
        this.f4403a.trySetResult((Bitmap) obj);
    }
}
