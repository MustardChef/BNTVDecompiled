package kotlinx.coroutines.flow;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", m98f = "Channels.kt", m97i = {0, 0, 0, 1, 1, 1}, m96l = {51, 62}, m95m = "emitAllImpl$FlowKt__ChannelsKt", m94n = {"$this$emitAllImpl", TvContractCompat.PARAM_CHANNEL, "consume", "$this$emitAllImpl", TvContractCompat.PARAM_CHANNEL, "consume"}, m93s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
/* loaded from: classes4.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object emitAllImpl$FlowKt__ChannelsKt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
        return emitAllImpl$FlowKt__ChannelsKt;
    }
}
