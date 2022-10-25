package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RoutePlanner;

/* compiled from: FailedPlan.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m107d2 = {"Lokhttp3/internal/connection/FailedPlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "e", "", "(Ljava/lang/Throwable;)V", "isReady", "", "()Z", "result", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "getResult", "()Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "cancel", "", "connectTcp", "connectTlsEtc", "handleSuccess", "retry", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class FailedPlan implements RoutePlanner.Plan {
    private final boolean isReady;
    private final RoutePlanner.ConnectResult result;

    public FailedPlan(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.result = new RoutePlanner.ConnectResult(this, null, e, 2, null);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public /* bridge */ /* synthetic */ RealConnection handleSuccess() {
        return (RealConnection) handleSuccess();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public /* bridge */ /* synthetic */ RoutePlanner.Plan retry() {
        return (RoutePlanner.Plan) retry();
    }

    public final RoutePlanner.ConnectResult getResult() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.isReady;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public RoutePlanner.ConnectResult connectTcp() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public RoutePlanner.ConnectResult connectTlsEtc() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public Void handleSuccess() {
        throw new IllegalStateException("unexpected call".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    public Void cancel() {
        throw new IllegalStateException("unexpected cancel".toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public Void retry() {
        throw new IllegalStateException("unexpected retry".toString());
    }
}
