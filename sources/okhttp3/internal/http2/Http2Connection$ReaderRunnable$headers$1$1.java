package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.platform.Platform;

/* compiled from: Http2Connection.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class Http2Connection$ReaderRunnable$headers$1$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Http2Stream $newStream;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$headers$1$1(Http2Connection http2Connection, Http2Stream http2Stream) {
        super(0);
        this.this$0 = http2Connection;
        this.$newStream = http2Stream;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            this.this$0.getListener$okhttp().onStream(this.$newStream);
        } catch (IOException e) {
            Platform.Companion.get().log(Intrinsics.stringPlus("Http2Connection.Listener failure for ", this.this$0.getConnectionName$okhttp()), 4, e);
            try {
                this.$newStream.close(ErrorCode.PROTOCOL_ERROR, e);
            } catch (IOException unused) {
            }
        }
    }
}
