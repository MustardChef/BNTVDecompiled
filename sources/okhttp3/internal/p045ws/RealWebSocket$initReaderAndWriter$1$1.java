package okhttp3.internal.p045ws;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RealWebSocket.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$1$1 */
/* loaded from: classes4.dex */
public final class RealWebSocket$initReaderAndWriter$1$1 extends Lambda implements Functions<Long> {
    final /* synthetic */ long $pingIntervalNanos;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealWebSocket$initReaderAndWriter$1$1(RealWebSocket realWebSocket, long j) {
        super(0);
        this.this$0 = realWebSocket;
        this.$pingIntervalNanos = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Long invoke() {
        this.this$0.writePingFrame$okhttp();
        return Long.valueOf(this.$pingIntervalNanos);
    }
}
