package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axo */
/* loaded from: classes2.dex */
public abstract class axo<V> extends ayz implements ayq<V> {

    /* renamed from: aP */
    private static final boolean f5248aP;

    /* renamed from: b */
    private static final Logger f5249b;

    /* renamed from: c */
    private static final AbstractC2569a f5250c;

    /* renamed from: d */
    private static final Object f5251d;
    private volatile C2573d listeners;
    private volatile Object value;
    private volatile C2581k waiters;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$a */
    /* loaded from: classes2.dex */
    public abstract class AbstractC2569a {
        /* synthetic */ AbstractC2569a() {
        }

        /* renamed from: a */
        abstract void mo4356a(C2581k c2581k, C2581k c2581k2);

        /* renamed from: b */
        abstract void mo4355b(C2581k c2581k, Thread thread);

        /* renamed from: c */
        abstract boolean mo4354c(axo axoVar, C2573d c2573d, C2573d c2573d2);

        /* renamed from: d */
        abstract boolean mo4353d(axo axoVar, Object obj, Object obj2);

        /* renamed from: e */
        abstract boolean mo4352e(axo axoVar, C2581k c2581k, C2581k c2581k2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$b */
    /* loaded from: classes2.dex */
    public final class C2570b {

        /* renamed from: a */
        static final C2570b f5252a;

        /* renamed from: b */
        static final C2570b f5253b;

        /* renamed from: c */
        final boolean f5254c;

        /* renamed from: d */
        final Throwable f5255d;

        static {
            if (axo.f5248aP) {
                f5253b = null;
                f5252a = null;
                return;
            }
            f5253b = new C2570b(false, null);
            f5252a = new C2570b(true, null);
        }

        C2570b(boolean z, Throwable th) {
            this.f5254c = z;
            this.f5255d = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$c */
    /* loaded from: classes2.dex */
    public final class C2571c {

        /* renamed from: a */
        static final C2571c f5256a = new C2571c(new Throwable() { // from class: com.google.ads.interactivemedia.v3.internal.axo.c.1
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b */
        final Throwable f5257b;

        C2571c(Throwable th) {
            atm.m4612j(th);
            this.f5257b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$d */
    /* loaded from: classes2.dex */
    public final class C2573d {

        /* renamed from: a */
        static final C2573d f5258a = new C2573d();

        /* renamed from: b */
        final Runnable f5259b;

        /* renamed from: c */
        final Executor f5260c;
        C2573d next;

        C2573d() {
            this.f5259b = null;
            this.f5260c = null;
        }

        C2573d(Runnable runnable, Executor executor) {
            this.f5259b = runnable;
            this.f5260c = executor;
        }
    }

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$e */
    /* loaded from: classes2.dex */
    final class C2574e extends AbstractC2569a {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<C2581k, Thread> f5261a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<C2581k, C2581k> f5262b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<axo, C2581k> f5263c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<axo, C2573d> f5264d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<axo, Object> f5265e;

        C2574e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.f5261a = atomicReferenceFieldUpdater;
            this.f5262b = atomicReferenceFieldUpdater2;
            this.f5263c = atomicReferenceFieldUpdater3;
            this.f5264d = atomicReferenceFieldUpdater4;
            this.f5265e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: a */
        final void mo4356a(C2581k c2581k, C2581k c2581k2) {
            this.f5262b.lazySet(c2581k, c2581k2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: b */
        final void mo4355b(C2581k c2581k, Thread thread) {
            this.f5261a.lazySet(c2581k, thread);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: c */
        final boolean mo4354c(axo axoVar, C2573d c2573d, C2573d c2573d2) {
            return this.f5264d.compareAndSet(axoVar, c2573d, c2573d2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: d */
        final boolean mo4353d(axo axoVar, Object obj, Object obj2) {
            return this.f5265e.compareAndSet(axoVar, obj, obj2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: e */
        final boolean mo4352e(axo axoVar, C2581k c2581k, C2581k c2581k2) {
            return this.f5263c.compareAndSet(axoVar, c2581k, c2581k2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$f */
    /* loaded from: classes2.dex */
    public final class RunnableC2575f<V> implements Runnable {

        /* renamed from: a */
        final axo<V> f5266a;

        /* renamed from: b */
        final ayq<? extends V> f5267b;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$g */
    /* loaded from: classes2.dex */
    final class C2576g extends AbstractC2569a {
        private C2576g() {
        }

        /* synthetic */ C2576g(byte[] bArr) {
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: a */
        final void mo4356a(C2581k c2581k, C2581k c2581k2) {
            c2581k.next = c2581k2;
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: b */
        final void mo4355b(C2581k c2581k, Thread thread) {
            c2581k.thread = thread;
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: c */
        final boolean mo4354c(axo axoVar, C2573d c2573d, C2573d c2573d2) {
            synchronized (axoVar) {
                if (axoVar.listeners == c2573d) {
                    axoVar.listeners = c2573d2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: d */
        final boolean mo4353d(axo axoVar, Object obj, Object obj2) {
            synchronized (axoVar) {
                if (axoVar.value == obj) {
                    axoVar.value = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: e */
        final boolean mo4352e(axo axoVar, C2581k c2581k, C2581k c2581k2) {
            synchronized (axoVar) {
                if (axoVar.waiters == c2581k) {
                    axoVar.waiters = c2581k2;
                    return true;
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$h */
    /* loaded from: classes2.dex */
    public interface InterfaceC2577h<V> extends ayq<V> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$i */
    /* loaded from: classes2.dex */
    public abstract class AbstractC2578i<V> extends axo<V> implements InterfaceC2577h<V> {
    }

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$j */
    /* loaded from: classes2.dex */
    final class C2579j extends AbstractC2569a {

        /* renamed from: a */
        static final Unsafe f5268a;

        /* renamed from: b */
        static final long f5269b;

        /* renamed from: c */
        static final long f5270c;

        /* renamed from: d */
        static final long f5271d;

        /* renamed from: e */
        static final long f5272e;

        /* renamed from: f */
        static final long f5273f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.ads.interactivemedia.v3.internal.axo.j.1
                        /* renamed from: a */
                        public static final Unsafe m4351a() throws Exception {
                            Field[] declaredFields;
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }

                        @Override // java.security.PrivilegedExceptionAction
                        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                            return m4351a();
                        }
                    });
                }
                try {
                    f5270c = unsafe.objectFieldOffset(axo.class.getDeclaredField("waiters"));
                    f5269b = unsafe.objectFieldOffset(axo.class.getDeclaredField("listeners"));
                    f5271d = unsafe.objectFieldOffset(axo.class.getDeclaredField("value"));
                    f5272e = unsafe.objectFieldOffset(C2581k.class.getDeclaredField("thread"));
                    f5273f = unsafe.objectFieldOffset(C2581k.class.getDeclaredField("next"));
                    f5268a = unsafe;
                } catch (Exception e) {
                    ato.m4606b(e);
                    throw new RuntimeException(e);
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }

        private C2579j() {
        }

        /* synthetic */ C2579j(byte[] bArr) {
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: a */
        final void mo4356a(C2581k c2581k, C2581k c2581k2) {
            f5268a.putObject(c2581k, f5273f, c2581k2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: b */
        final void mo4355b(C2581k c2581k, Thread thread) {
            f5268a.putObject(c2581k, f5272e, thread);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: c */
        final boolean mo4354c(axo axoVar, C2573d c2573d, C2573d c2573d2) {
            return f5268a.compareAndSwapObject(axoVar, f5269b, c2573d, c2573d2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: d */
        final boolean mo4353d(axo axoVar, Object obj, Object obj2) {
            return f5268a.compareAndSwapObject(axoVar, f5271d, obj, obj2);
        }

        @Override // com.google.ads.interactivemedia.p034v3.internal.axo.AbstractC2569a
        /* renamed from: e */
        final boolean mo4352e(axo axoVar, C2581k c2581k, C2581k c2581k2) {
            return f5268a.compareAndSwapObject(axoVar, f5270c, c2581k, c2581k2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.internal.axo$k */
    /* loaded from: classes2.dex */
    public final class C2581k {

        /* renamed from: a */
        static final C2581k f5274a = new C2581k(null);
        volatile C2581k next;
        volatile Thread thread;

        C2581k() {
            axo.f5250c.mo4355b(this, Thread.currentThread());
        }

        C2581k(byte[] bArr) {
        }

        /* renamed from: a */
        final void m4350a(C2581k c2581k) {
            axo.f5250c.mo4356a(this, c2581k);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        AbstractC2569a c2576g;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f5248aP = z;
        f5249b = Logger.getLogger(axo.class.getName());
        try {
            c2576g = new C2579j(null);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = th3;
                c2576g = new C2574e(AtomicReferenceFieldUpdater.newUpdater(C2581k.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(C2581k.class, C2581k.class, "next"), AtomicReferenceFieldUpdater.newUpdater(axo.class, C2581k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(axo.class, C2573d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(axo.class, Object.class, "value"));
                th = null;
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                c2576g = new C2576g(null);
            }
        }
        f5250c = c2576g;
        if (th != null) {
            Logger logger = f5249b;
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        f5251d = new Object();
    }

    /* renamed from: q */
    private static Object m4365q(ayq ayqVar) {
        Throwable mo4302f;
        if (ayqVar instanceof InterfaceC2577h) {
            Object obj = ((axo) ayqVar).value;
            if (obj instanceof C2570b) {
                C2570b c2570b = (C2570b) obj;
                if (c2570b.f5254c) {
                    Throwable th = c2570b.f5255d;
                    obj = th != null ? new C2570b(false, th) : C2570b.f5253b;
                }
            }
            obj.getClass();
            return obj;
        } else if (!(ayqVar instanceof ayz) || (mo4302f = ((ayz) ayqVar).mo4302f()) == null) {
            boolean isCancelled = ayqVar.isCancelled();
            if ((!f5248aP) & isCancelled) {
                C2570b c2570b2 = C2570b.f5253b;
                c2570b2.getClass();
                return c2570b2;
            }
            try {
                Object m4364r = m4364r(ayqVar);
                if (!isCancelled) {
                    return m4364r == null ? f5251d : m4364r;
                }
                String valueOf = String.valueOf(ayqVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new C2570b(false, new IllegalArgumentException(sb.toString()));
            } catch (CancellationException e) {
                if (!isCancelled) {
                    String valueOf2 = String.valueOf(ayqVar);
                    String.valueOf(valueOf2).length();
                    return new C2571c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(valueOf2)), e));
                }
                return new C2570b(false, e);
            } catch (ExecutionException e2) {
                if (isCancelled) {
                    String valueOf3 = String.valueOf(ayqVar);
                    String.valueOf(valueOf3).length();
                    return new C2570b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(valueOf3)), e2));
                }
                return new C2571c(e2.getCause());
            } catch (Throwable th2) {
                return new C2571c(th2);
            }
        } else {
            return new C2571c(mo4302f);
        }
    }

    /* renamed from: r */
    private static Object m4364r(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
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

    /* renamed from: s */
    private final void m4363s(StringBuilder sb) {
        try {
            Object m4364r = m4364r(this);
            sb.append("SUCCESS, result=[");
            if (m4364r == null) {
                sb.append("null");
            } else if (m4364r == this) {
                sb.append("this future");
            } else {
                sb.append(m4364r.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(m4364r)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    /* renamed from: t */
    private final void m4362t(StringBuilder sb) {
        String concat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof RunnableC2575f) {
            sb.append(", setFuture=[");
            m4361u(sb, ((RunnableC2575f) obj).f5267b);
            sb.append("]");
        } else {
            try {
                concat = atm.m4621a(mo4306e());
            } catch (RuntimeException | StackOverflowError e) {
                String valueOf = String.valueOf(e.getClass());
                String.valueOf(valueOf).length();
                concat = "Exception thrown from implementation: ".concat(String.valueOf(valueOf));
            }
            if (concat != null) {
                sb.append(", info=[");
                sb.append(concat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            m4363s(sb);
        }
    }

    /* renamed from: u */
    private final void m4361u(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    /* renamed from: v */
    private static void m4360v(axo axoVar) {
        C2573d c2573d;
        C2573d c2573d2;
        C2573d c2573d3 = null;
        while (true) {
            C2581k c2581k = axoVar.waiters;
            if (f5250c.mo4352e(axoVar, c2581k, C2581k.f5274a)) {
                while (c2581k != null) {
                    Thread thread = c2581k.thread;
                    if (thread != null) {
                        c2581k.thread = null;
                        LockSupport.unpark(thread);
                    }
                    c2581k = c2581k.next;
                }
                axoVar.mo4305h();
                do {
                    c2573d = axoVar.listeners;
                } while (!f5250c.mo4354c(axoVar, c2573d, C2573d.f5258a));
                while (true) {
                    c2573d2 = c2573d3;
                    c2573d3 = c2573d;
                    if (c2573d3 == null) {
                        break;
                    }
                    c2573d = c2573d3.next;
                    c2573d3.next = c2573d2;
                }
                while (c2573d2 != null) {
                    c2573d3 = c2573d2.next;
                    Runnable runnable = c2573d2.f5259b;
                    runnable.getClass();
                    if (runnable instanceof RunnableC2575f) {
                        RunnableC2575f runnableC2575f = (RunnableC2575f) runnable;
                        axoVar = runnableC2575f.f5266a;
                        if (axoVar.value == runnableC2575f) {
                            if (f5250c.mo4353d(axoVar, runnableC2575f, m4365q(runnableC2575f.f5267b))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = c2573d2.f5260c;
                        executor.getClass();
                        m4359w(runnable, executor);
                    }
                    c2573d2 = c2573d3;
                }
                return;
            }
        }
    }

    /* renamed from: w */
    private static void m4359w(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f5249b;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
        }
    }

    /* renamed from: x */
    private final void m4358x(C2581k c2581k) {
        c2581k.thread = null;
        while (true) {
            C2581k c2581k2 = this.waiters;
            if (c2581k2 != C2581k.f5274a) {
                C2581k c2581k3 = null;
                while (c2581k2 != null) {
                    C2581k c2581k4 = c2581k2.next;
                    if (c2581k2.thread != null) {
                        c2581k3 = c2581k2;
                    } else if (c2581k3 != null) {
                        c2581k3.next = c2581k4;
                        if (c2581k3.thread == null) {
                            break;
                        }
                    } else if (!f5250c.mo4352e(this, c2581k2, c2581k4)) {
                        break;
                    }
                    c2581k2 = c2581k4;
                }
                return;
            }
            return;
        }
    }

    /* renamed from: y */
    private static final Object m4357y(Object obj) throws ExecutionException {
        if (obj instanceof C2570b) {
            Throwable th = ((C2570b) obj).f5255d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof C2571c) {
            throw new ExecutionException(((C2571c) obj).f5257b);
        } else {
            if (obj == f5251d) {
                return null;
            }
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        C2570b c2570b;
        Object obj = this.value;
        if ((obj == null) || (obj instanceof RunnableC2575f)) {
            if (f5248aP) {
                c2570b = new C2570b(z, new CancellationException("Future.cancel() was called."));
            } else {
                if (z) {
                    c2570b = C2570b.f5252a;
                } else {
                    c2570b = C2570b.f5253b;
                }
                c2570b.getClass();
            }
            boolean z2 = false;
            axo<V> axoVar = this;
            while (true) {
                if (f5250c.mo4353d(axoVar, obj, c2570b)) {
                    if (z) {
                        axoVar.mo4341i();
                    }
                    m4360v(axoVar);
                    if (!(obj instanceof RunnableC2575f)) {
                        break;
                    }
                    ayq<? extends V> ayqVar = ((RunnableC2575f) obj).f5267b;
                    if (ayqVar instanceof InterfaceC2577h) {
                        axoVar = (axo) ayqVar;
                        obj = axoVar.value;
                        if (!(obj == null) && !(obj instanceof RunnableC2575f)) {
                            break;
                        }
                        z2 = true;
                    } else {
                        ayqVar.cancel(z);
                        break;
                    }
                } else {
                    obj = axoVar.value;
                    if (!(obj instanceof RunnableC2575f)) {
                        return z2;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public String mo4306e() {
        if (this instanceof ScheduledFuture) {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder(41);
            sb.append("remaining delay=[");
            sb.append(delay);
            sb.append(" ms]");
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.ayz
    /* renamed from: f */
    public final Throwable mo4302f() {
        if (this instanceof InterfaceC2577h) {
            Object obj = this.value;
            if (obj instanceof C2571c) {
                return ((C2571c) obj).f5257b;
            }
            return null;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ayq
    /* renamed from: g */
    public final void mo4321g(Runnable runnable, Executor executor) {
        C2573d c2573d;
        atm.m4611k(runnable, "Runnable was null.");
        atm.m4611k(executor, "Executor was null.");
        if (isDone() || (c2573d = this.listeners) == C2573d.f5258a) {
            m4359w(runnable, executor);
        }
        C2573d c2573d2 = new C2573d(runnable, executor);
        do {
            c2573d2.next = c2573d;
            if (f5250c.mo4354c(this, c2573d, c2573d2)) {
                return;
            }
            c2573d = this.listeners;
        } while (c2573d != C2573d.f5258a);
        m4359w(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof RunnableC2575f))) {
                return m4357y(obj2);
            }
            C2581k c2581k = this.waiters;
            if (c2581k != C2581k.f5274a) {
                C2581k c2581k2 = new C2581k();
                do {
                    c2581k2.m4350a(c2581k);
                    if (f5250c.mo4352e(this, c2581k, c2581k2)) {
                        do {
                            LockSupport.park(this);
                            if (Thread.interrupted()) {
                                m4358x(c2581k2);
                                throw new InterruptedException();
                            }
                            obj = this.value;
                        } while (!((obj != null) & (!(obj instanceof RunnableC2575f))));
                        return m4357y(obj);
                    }
                    c2581k = this.waiters;
                } while (c2581k != C2581k.f5274a);
                Object obj3 = this.value;
                obj3.getClass();
                return m4357y(obj3);
            }
            Object obj32 = this.value;
            obj32.getClass();
            return m4357y(obj32);
        }
        throw new InterruptedException();
    }

    /* renamed from: h */
    protected void mo4305h() {
    }

    /* renamed from: i */
    protected void mo4341i() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof C2570b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof RunnableC2575f)) & (obj != null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo4313k(Object obj) {
        if (obj == null) {
            obj = f5251d;
        }
        if (f5250c.mo4353d(this, null, obj)) {
            m4360v(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final boolean m4370l() {
        Object obj = this.value;
        return (obj instanceof C2570b) && ((C2570b) obj).f5254c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public final void m4366p(Throwable th) {
        atm.m4612j(th);
        if (f5250c.mo4353d(this, null, new C2571c(th))) {
            m4360v(this);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m4363s(sb);
        } else {
            m4362t(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof RunnableC2575f))) {
                return m4357y(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                C2581k c2581k = this.waiters;
                if (c2581k != C2581k.f5274a) {
                    C2581k c2581k2 = new C2581k();
                    do {
                        c2581k2.m4350a(c2581k);
                        if (f5250c.mo4352e(this, c2581k, c2581k2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    m4358x(c2581k2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if (!((obj2 != null) & (!(obj2 instanceof RunnableC2575f)))) {
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    return m4357y(obj2);
                                }
                            } while (nanos >= 1000);
                            m4358x(c2581k2);
                        } else {
                            c2581k = this.waiters;
                        }
                    } while (c2581k != C2581k.f5274a);
                    Object obj3 = this.value;
                    obj3.getClass();
                    return m4357y(obj3);
                }
                Object obj32 = this.value;
                obj32.getClass();
                return m4357y(obj32);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if (!((obj4 != null) & (!(obj4 instanceof RunnableC2575f)))) {
                    if (!Thread.interrupted()) {
                        nanos = nanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return m4357y(obj4);
                }
            }
            String axoVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = sb2.concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                if (i != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (i > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = sb4.concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(axoVar).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(axoVar);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }
}
