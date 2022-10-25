package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ch */
/* loaded from: classes2.dex */
public final class C2619ch {

    /* renamed from: a */
    private static C2619ch f6937a;

    /* renamed from: b */
    private final Handler f6938b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private final CopyOnWriteArrayList f6939c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private final Object f6940d = new Object();

    /* renamed from: e */
    private int f6941e = 0;

    private C2619ch(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new C2617cf(this), intentFilter);
    }

    /* renamed from: b */
    public static synchronized C2619ch m2666b(Context context) {
        C2619ch c2619ch;
        synchronized (C2619ch.class) {
            if (f6937a == null) {
                f6937a = new C2619ch(context);
            }
            c2619ch = f6937a;
        }
        return c2619ch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* bridge */ /* synthetic */ void m2665c(C2619ch c2619ch, int i) {
        synchronized (c2619ch.f6940d) {
            if (c2619ch.f6941e == i) {
                return;
            }
            c2619ch.f6941e = i;
            Iterator it = c2619ch.f6939c.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C3155wd c3155wd = (C3155wd) weakReference.get();
                if (c3155wd != null) {
                    c3155wd.m761a(i);
                } else {
                    c2619ch.f6939c.remove(weakReference);
                }
            }
        }
    }

    /* renamed from: a */
    public final int m2667a() {
        int i;
        synchronized (this.f6940d) {
            i = this.f6941e;
        }
        return i;
    }

    /* renamed from: d */
    public final void m2664d(final C3155wd c3155wd) {
        Iterator it = this.f6939c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.f6939c.remove(weakReference);
            }
        }
        this.f6939c.add(new WeakReference(c3155wd));
        this.f6938b.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.cd
            @Override // java.lang.Runnable
            public final void run() {
                c3155wd.m761a(C2619ch.this.m2667a());
            }
        });
    }
}
