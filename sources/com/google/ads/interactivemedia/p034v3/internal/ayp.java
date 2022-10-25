package com.google.ads.interactivemedia.p034v3.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ayp */
/* loaded from: classes2.dex */
public abstract class ayp extends AtomicReference implements Runnable {

    /* renamed from: a */
    private static final Runnable f5305a = new ayo(null, 0);

    /* renamed from: b */
    private static final Runnable f5306b = new ayo(null, 0);

    /* renamed from: c */
    private final void m4323c(Thread thread) {
        Runnable runnable = (Runnable) get();
        ayn aynVar = null;
        boolean z = false;
        int i = 0;
        while (true) {
            if (!(runnable instanceof ayn)) {
                if (runnable != f5306b) {
                    break;
                }
            } else {
                aynVar = (ayn) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = f5306b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(aynVar);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    /* renamed from: a */
    abstract Object mo4311a() throws Exception;

    /* renamed from: b */
    abstract String mo4310b();

    /* renamed from: d */
    abstract void mo4309d(Throwable th);

    /* renamed from: e */
    abstract void mo4308e(Object obj);

    /* renamed from: g */
    abstract boolean mo4307g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m4322h() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            ayn aynVar = new ayn(this);
            super/*java.util.concurrent.locks.AbstractOwnableSynchronizer*/.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, aynVar)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(f5305a)) == f5306b) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(f5305a)) == f5306b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet(null, currentThread)) {
            boolean z = !mo4307g();
            if (z) {
                try {
                    obj = mo4311a();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, f5305a)) {
                        m4323c(currentThread);
                    }
                    mo4309d(th);
                    return;
                }
            }
            if (!compareAndSet(currentThread, f5305a)) {
                m4323c(currentThread);
            }
            if (z) {
                mo4308e(obj);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f5305a) {
            str = "running=[DONE]";
        } else if (runnable instanceof ayn) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String mo4310b = mo4310b();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(mo4310b).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(mo4310b);
        return sb2.toString();
    }
}
