package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Connection.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Http2Connection$pushDataLater$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Buffer $buffer;
    final /* synthetic */ int $byteCount;
    final /* synthetic */ boolean $inFinished;
    final /* synthetic */ int $streamId;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushDataLater$1(Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z) {
        super(0);
        this.this$0 = http2Connection;
        this.$streamId = i;
        this.$buffer = buffer;
        this.$byteCount = i2;
        this.$inFinished = z;
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
        Http2Connection http2Connection = this.this$0;
        int i = this.$streamId;
        Buffer buffer = this.$buffer;
        int i2 = this.$byteCount;
        boolean z = this.$inFinished;
        try {
            pushObserver = http2Connection.pushObserver;
            boolean onData = pushObserver.onData(i, buffer, i2, z);
            if (onData) {
                http2Connection.getWriter().rstStream(i, ErrorCode.CANCEL);
            }
            if (onData || z) {
                synchronized (http2Connection) {
                    set = http2Connection.currentPushRequests;
                    set.remove(Integer.valueOf(i));
                }
            }
        } catch (IOException unused) {
        }
    }
}
