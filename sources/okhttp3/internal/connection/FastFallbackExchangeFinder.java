package okhttp3.internal.connection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;

/* compiled from: FastFallbackExchangeFinder.kt */
@Metadata(m108d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m107d2 = {"Lokhttp3/internal/connection/FastFallbackExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "connectDelayNanos", "", "connectResults", "Ljava/util/concurrent/BlockingQueue;", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "kotlin.jvm.PlatformType", "deferredPlans", "Lkotlin/collections/ArrayDeque;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "nextTcpConnectAtNanos", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "tcpConnectsInFlight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "awaitTcpConnect", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "cancelInFlightConnects", "", "find", "Lokhttp3/internal/connection/RealConnection;", "launchTcpConnect", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos;
    private final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private final ArrayDeque<RoutePlanner.Plan> deferredPlans;
    private long nextTcpConnectAtNanos;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight;

    public FastFallbackExchangeFinder(RoutePlanner routePlanner, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.deferredPlans = new ArrayDeque<>();
        this.connectResults = taskRunner.getBackend().decorate(new LinkedBlockingDeque());
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:3:0x0002, B:5:0x000e, B:7:0x0019, B:12:0x002b, B:14:0x0035, B:22:0x005f, B:25:0x0068, B:27:0x006e, B:29:0x007b, B:30:0x0084, B:32:0x008a, B:35:0x0096, B:37:0x009c, B:40:0x00a2, B:41:0x00a6, B:42:0x00ad, B:43:0x00ae, B:45:0x00b4, B:20:0x0054, B:46:0x00bb, B:47:0x00c2), top: B:51:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:3:0x0002, B:5:0x000e, B:7:0x0019, B:12:0x002b, B:14:0x0035, B:22:0x005f, B:25:0x0068, B:27:0x006e, B:29:0x007b, B:30:0x0084, B:32:0x008a, B:35:0x0096, B:37:0x009c, B:40:0x00a2, B:41:0x00a6, B:42:0x00ad, B:43:0x00ae, B:45:0x00b4, B:20:0x0054, B:46:0x00bb, B:47:0x00c2), top: B:51:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0002 A[SYNTHETIC] */
    @Override // okhttp3.internal.connection.ExchangeFinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RealConnection find() {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r9.tcpConnectsInFlight     // Catch: java.lang.Throwable -> Lc3
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> Lc3
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lc3
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != 0) goto L2b
            kotlin.collections.ArrayDeque<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r9.deferredPlans     // Catch: java.lang.Throwable -> Lc3
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> Lc3
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lc3
            r2 = r2 ^ r3
            if (r2 != 0) goto L2b
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch: java.lang.Throwable -> Lc3
            boolean r2 = okhttp3.internal.connection.RoutePlanner.DefaultImpls.hasNext$default(r2, r0, r3, r0)     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L24
            goto L2b
        L24:
            r9.cancelInFlightConnects()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            throw r1
        L2b:
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch: java.lang.Throwable -> Lc3
            boolean r2 = r2.isCanceled()     // Catch: java.lang.Throwable -> Lc3
            if (r2 != 0) goto Lbb
            okhttp3.internal.concurrent.TaskRunner r2 = r9.taskRunner     // Catch: java.lang.Throwable -> Lc3
            okhttp3.internal.concurrent.TaskRunner$Backend r2 = r2.getBackend()     // Catch: java.lang.Throwable -> Lc3
            long r2 = r2.nanoTime()     // Catch: java.lang.Throwable -> Lc3
            long r4 = r9.nextTcpConnectAtNanos     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4 - r2
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r6 = r9.tcpConnectsInFlight     // Catch: java.lang.Throwable -> Lc3
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Lc3
            if (r6 != 0) goto L54
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L51
            goto L54
        L51:
            r5 = r4
            r4 = r0
            goto L5d
        L54:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.launchTcpConnect()     // Catch: java.lang.Throwable -> Lc3
            long r5 = r9.connectDelayNanos     // Catch: java.lang.Throwable -> Lc3
            long r2 = r2 + r5
            r9.nextTcpConnectAtNanos = r2     // Catch: java.lang.Throwable -> Lc3
        L5d:
            if (r4 != 0) goto L68
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> Lc3
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.awaitTcpConnect(r5, r2)     // Catch: java.lang.Throwable -> Lc3
            if (r4 != 0) goto L68
            goto L2
        L68:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L96
            r9.cancelInFlightConnects()     // Catch: java.lang.Throwable -> Lc3
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> Lc3
            boolean r2 = r2.isReady()     // Catch: java.lang.Throwable -> Lc3
            if (r2 != 0) goto L84
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch: java.lang.Throwable -> Lc3
            okhttp3.internal.connection.RoutePlanner$ConnectResult r2 = r2.connectTlsEtc()     // Catch: java.lang.Throwable -> Lc3
            r4 = r2
        L84:
            boolean r2 = r4.isSuccess()     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L96
            okhttp3.internal.connection.RoutePlanner$Plan r0 = r4.getPlan()     // Catch: java.lang.Throwable -> Lc3
            okhttp3.internal.connection.RealConnection r0 = r0.handleSuccess()     // Catch: java.lang.Throwable -> Lc3
            r9.cancelInFlightConnects()
            return r0
        L96:
            java.lang.Throwable r2 = r4.getThrowable()     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto Lae
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> Lc3
            if (r3 == 0) goto Lad
            if (r1 != 0) goto La6
            java.io.IOException r2 = (java.io.IOException) r2     // Catch: java.lang.Throwable -> Lc3
            r1 = r2
            goto Lae
        La6:
            r3 = r1
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Throwable -> Lc3
            kotlin.ExceptionsKt.addSuppressed(r3, r2)     // Catch: java.lang.Throwable -> Lc3
            goto Lae
        Lad:
            throw r2     // Catch: java.lang.Throwable -> Lc3
        Lae:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getNextPlan()     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L2
            kotlin.collections.ArrayDeque<okhttp3.internal.connection.RoutePlanner$Plan> r3 = r9.deferredPlans     // Catch: java.lang.Throwable -> Lc3
            r3.addFirst(r2)     // Catch: java.lang.Throwable -> Lc3
            goto L2
        Lbb:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc3
            throw r0     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r0 = move-exception
            r9.cancelInFlightConnects()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.FastFallbackExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        RoutePlanner.Plan failedPlan;
        if (!this.deferredPlans.isEmpty()) {
            failedPlan = this.deferredPlans.removeFirst();
        } else {
            if (RoutePlanner.DefaultImpls.hasNext$default(getRoutePlanner(), null, 1, null)) {
                try {
                    failedPlan = getRoutePlanner().plan();
                } catch (Throwable th) {
                    failedPlan = new FailedPlan(th);
                }
            }
            return null;
        }
        final RoutePlanner.Plan plan = failedPlan;
        if (plan.isReady()) {
            return new RoutePlanner.ConnectResult(plan, null, null, 6, null);
        }
        if (plan instanceof FailedPlan) {
            return ((FailedPlan) plan).getResult();
        }
        this.tcpConnectsInFlight.add(plan);
        final String str = _UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact();
        TaskQueue.schedule$default(this.taskRunner.newQueue(), new Task(str, plan, this) { // from class: okhttp3.internal.connection.FastFallbackExchangeFinder$launchTcpConnect$1
            final /* synthetic */ RoutePlanner.Plan $plan;
            final /* synthetic */ String $taskName;
            final /* synthetic */ FastFallbackExchangeFinder this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, false, 2, null);
                this.$taskName = str;
                this.$plan = plan;
                this.this$0 = this;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                RoutePlanner.ConnectResult connectResult;
                CopyOnWriteArrayList copyOnWriteArrayList;
                BlockingQueue blockingQueue;
                try {
                    connectResult = this.$plan.connectTcp();
                } catch (Throwable th2) {
                    connectResult = new RoutePlanner.ConnectResult(this.$plan, null, th2, 2, null);
                }
                copyOnWriteArrayList = this.this$0.tcpConnectsInFlight;
                if (copyOnWriteArrayList.contains(this.$plan)) {
                    blockingQueue = this.this$0.connectResults;
                    blockingQueue.put(connectResult);
                    return -1L;
                }
                return -1L;
            }
        }, 0L, 2, null);
        return null;
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult poll;
        if (this.tcpConnectsInFlight.isEmpty() || (poll = this.connectResults.poll(j, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(poll.getPlan());
        return poll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.cancel();
            RoutePlanner.Plan retry = next.retry();
            if (retry != null) {
                this.deferredPlans.add(retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }
}
