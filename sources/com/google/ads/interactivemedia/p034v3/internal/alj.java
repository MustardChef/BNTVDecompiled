package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.p034v3.api.esp.EspAdapter;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alj */
/* loaded from: classes2.dex */
public final class alj {

    /* renamed from: a */
    private final EspAdapter f4378a;

    /* renamed from: b */
    private final Context f4379b;

    /* renamed from: c */
    private final String f4380c;

    /* renamed from: d */
    private final TaskCompletionSource f4381d = new TaskCompletionSource();

    /* JADX INFO: Access modifiers changed from: package-private */
    public alj(EspAdapter espAdapter, String str, Context context) {
        this.f4378a = espAdapter;
        this.f4380c = str;
        this.f4379b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final Task m5035b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4378a.collectSignals(this.f4379b, new ali(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final Task m5034c() {
        this.f4378a.initialize(this.f4379b, new alh(this));
        return this.f4381d.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final String m5032e() {
        return this.f4380c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final String m5031f() {
        return this.f4378a.getVersionInfo().toString();
    }
}
