package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SequentialExchangeFinder.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m107d2 = {"Lokhttp3/internal/connection/SequentialExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "(Lokhttp3/internal/connection/RoutePlanner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "find", "Lokhttp3/internal/connection/RealConnection;", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    @Override // okhttp3.internal.connection.ExchangeFinder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RealConnection find() {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            okhttp3.internal.connection.RoutePlanner r3 = r7.getRoutePlanner()
            boolean r3 = r3.isCanceled()
            if (r3 != 0) goto L6c
            if (r1 == 0) goto L11
            r3 = r0
            goto L1c
        L11:
            okhttp3.internal.connection.RoutePlanner r3 = r7.getRoutePlanner()     // Catch: java.io.IOException -> L4b
            okhttp3.internal.connection.RoutePlanner$Plan r3 = r3.plan()     // Catch: java.io.IOException -> L4b
            r6 = r3
            r3 = r1
            r1 = r6
        L1c:
            boolean r4 = r1.isReady()     // Catch: java.io.IOException -> L49
            if (r4 != 0) goto L44
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r1.connectTcp()     // Catch: java.io.IOException -> L49
            boolean r5 = r4.isSuccess()     // Catch: java.io.IOException -> L49
            if (r5 == 0) goto L30
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r1.connectTlsEtc()     // Catch: java.io.IOException -> L49
        L30:
            okhttp3.internal.connection.RoutePlanner$Plan r5 = r4.component2()     // Catch: java.io.IOException -> L49
            java.lang.Throwable r3 = r4.component3()     // Catch: java.io.IOException -> L49
            if (r3 != 0) goto L40
            if (r5 == 0) goto L3e
            r1 = r5
            goto L3
        L3e:
            r3 = r5
            goto L44
        L40:
            throw r3     // Catch: java.io.IOException -> L41
        L41:
            r1 = move-exception
            r3 = r5
            goto L4f
        L44:
            okhttp3.internal.connection.RealConnection r0 = r1.handleSuccess()     // Catch: java.io.IOException -> L49
            return r0
        L49:
            r1 = move-exception
            goto L4f
        L4b:
            r3 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
        L4f:
            if (r2 != 0) goto L53
            r2 = r1
            goto L5b
        L53:
            r4 = r2
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            kotlin.ExceptionsKt.addSuppressed(r4, r1)
        L5b:
            if (r3 != 0) goto L6a
            okhttp3.internal.connection.RoutePlanner r1 = r7.getRoutePlanner()
            r4 = 1
            boolean r1 = okhttp3.internal.connection.RoutePlanner.DefaultImpls.hasNext$default(r1, r0, r4, r0)
            if (r1 == 0) goto L69
            goto L6a
        L69:
            throw r2
        L6a:
            r1 = r3
            goto L3
        L6c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.SequentialExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }
}
