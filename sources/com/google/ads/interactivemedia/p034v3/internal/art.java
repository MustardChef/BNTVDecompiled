package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.art */
/* loaded from: classes2.dex */
public final class art {

    /* renamed from: a */
    public static final /* synthetic */ int f4946a = 0;

    /* renamed from: f */
    private static volatile int f4947f = afa.f3655a;

    /* renamed from: b */
    private final Context f4948b;

    /* renamed from: c */
    private final Executor f4949c;

    /* renamed from: d */
    private final Task f4950d;

    /* renamed from: e */
    private final boolean f4951e;

    art(Context context, Executor executor, Task task, boolean z) {
        this.f4948b = context;
        this.f4949c = executor;
        this.f4950d = task;
        this.f4951e = z;
    }

    /* renamed from: a */
    public static art m4729a(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.arr
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(asz.m4635c(context, "GLAS"));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ars
                @Override // java.lang.Runnable
                public final void run() {
                    TaskCompletionSource.this.setResult(asz.m4636b());
                }
            });
        }
        return new art(context, executor, taskCompletionSource.getTask(), z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static void m4723g(int i) {
        f4947f = i;
    }

    /* renamed from: h */
    private final Task m4722h(final int i, long j, Exception exc, String str, String str2) {
        if (this.f4951e) {
            final afc m5664j = afb.m5664j();
            m5664j.m5663a(this.f4948b.getPackageName());
            m5664j.m5659e(j);
            m5664j.m5657g(f4947f);
            if (exc != null) {
                m5664j.m5658f(ato.m4607a(exc));
                m5664j.m5660d(exc.getClass().getName());
            }
            if (str2 != null) {
                m5664j.m5662b(str2);
            }
            if (str != null) {
                m5664j.m5661c(str);
            }
            return this.f4950d.continueWith(this.f4949c, new Continuation(i, null) { // from class: com.google.ads.interactivemedia.v3.internal.arp

                /* renamed from: a */
                public final /* synthetic */ int f4940a;

                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    afc afcVar = afc.this;
                    int i2 = this.f4940a;
                    int i3 = art.f4946a;
                    if (task.isSuccessful()) {
                        asy m4637a = ((asz) task.getResult()).m4637a(((afb) afcVar.m3307aP()).mo3176ar());
                        m4637a.m4639b(i2);
                        m4637a.m4640a();
                        return true;
                    }
                    return false;
                }
            });
        }
        return this.f4950d.continueWith(this.f4949c, arq.f4942a);
    }

    /* renamed from: b */
    public final void m4728b(int i, String str) {
        m4722h(i, 0L, null, null, str);
    }

    /* renamed from: c */
    public final void m4727c(int i, long j, Exception exc) {
        m4722h(i, j, exc, null, null);
    }

    /* renamed from: d */
    public final void m4726d(int i, long j) {
        m4722h(i, j, null, null, null);
    }

    /* renamed from: e */
    public final void m4725e(int i, long j, String str) {
        m4722h(i, j, null, null, str);
    }

    /* renamed from: f */
    public final void m4724f(int i, long j, String str) {
        m4722h(i, j, null, str, null);
    }
}
