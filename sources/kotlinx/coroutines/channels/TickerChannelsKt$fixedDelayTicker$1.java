package kotlinx.coroutines.channels;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TickerChannels.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "kotlinx.coroutines.channels.TickerChannelsKt", m98f = "TickerChannels.kt", m97i = {0, 0, 1, 1, 2, 2}, m96l = {106, 108, 109}, m95m = "fixedDelayTicker", m94n = {TvContractCompat.PARAM_CHANNEL, "delayMillis", TvContractCompat.PARAM_CHANNEL, "delayMillis", TvContractCompat.PARAM_CHANNEL, "delayMillis"}, m93s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
/* loaded from: classes4.dex */
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fixedDelayTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedDelayTicker = TickerChannels.fixedDelayTicker(0L, 0L, null, this);
        return fixedDelayTicker;
    }
}
