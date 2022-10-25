package okhttp3.internal.http2;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Connection.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Http2Connection$pushResetLater$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ ErrorCode $errorCode;
    final /* synthetic */ int $streamId;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushResetLater$1(Http2Connection http2Connection, int i, ErrorCode errorCode) {
        super(0);
        this.this$0 = http2Connection;
        this.$streamId = i;
        this.$errorCode = errorCode;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PushObserver pushObserver;
        Set set;
        pushObserver = this.this$0.pushObserver;
        pushObserver.onReset(this.$streamId, this.$errorCode);
        Http2Connection http2Connection = this.this$0;
        int i = this.$streamId;
        synchronized (http2Connection) {
            set = http2Connection.currentPushRequests;
            set.remove(Integer.valueOf(i));
            Unit unit = Unit.INSTANCE;
        }
    }
}
