package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayu */
/* loaded from: classes2.dex */
public final class ayu {
    /* renamed from: a */
    public static ayr m4319a(ExecutorService executorService) {
        ayr axpVar;
        if (executorService instanceof ayr) {
            return (ayr) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            axpVar = new ayt((ScheduledExecutorService) executorService);
        } else {
            axpVar = new axp(executorService);
        }
        return axpVar;
    }

    @SafeVarargs
    /* renamed from: b */
    public static ayg m4318b(ayq... ayqVarArr) {
        return new ayg(avg.m4516m(ayqVarArr));
    }

    /* renamed from: c */
    public static Object m4317c(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        if (future.isDone()) {
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return obj;
        }
        throw new IllegalStateException(atm.m4620b("Future was expected to be done: %s", future));
    }

    /* renamed from: d */
    public static void m4316d(ayq ayqVar, aye ayeVar, Executor executor) {
        atm.m4612j(ayeVar);
        ayqVar.mo4321g(new ayf(ayqVar, ayeVar), executor);
    }

    /* renamed from: e */
    public static void m4315e(Future future, Class cls) throws Exception {
        ayl.m4328b(future, cls);
    }

    /* renamed from: f */
    public static int m4314f(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
