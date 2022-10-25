package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arq */
/* loaded from: classes2.dex */
public final /* synthetic */ class arq implements Continuation {

    /* renamed from: a */
    public static final /* synthetic */ arq f4942a = new arq();

    private /* synthetic */ arq() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return Boolean.valueOf(task.isSuccessful());
    }
}
