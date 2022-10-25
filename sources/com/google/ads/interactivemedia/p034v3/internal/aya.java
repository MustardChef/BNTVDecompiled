package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aya */
/* loaded from: classes2.dex */
final class aya implements Executor {

    /* renamed from: a */
    public static final aya f5291a;

    /* renamed from: b */
    private static final /* synthetic */ aya[] f5292b;

    static {
        aya ayaVar = new aya();
        f5291a = ayaVar;
        f5292b = new aya[]{ayaVar};
    }

    private aya() {
    }

    public static aya[] values() {
        return (aya[]) f5292b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
