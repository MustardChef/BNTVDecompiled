package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;

/* renamed from: com.applovin.impl.sdk.e.y */
/* loaded from: classes.dex */
public class C1642y extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final Runnable f2192a;

    public C1642y(C1662k c1662k, Runnable runnable) {
        this(c1662k, false, runnable);
    }

    public C1642y(C1662k c1662k, boolean z, Runnable runnable) {
        super("TaskRunnable", c1662k, z);
        this.f2192a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2192a.run();
    }
}
