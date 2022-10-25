package kotlinx.coroutines.channels;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TickerChannels.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "kotlinx.coroutines.channels.TickerChannelsKt", m98f = "TickerChannels.kt", m97i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, m96l = {84, 88, 94, 96}, m95m = "fixedPeriodTicker", m94n = {TvContractCompat.PARAM_CHANNEL, "delayMillis", "deadline", TvContractCompat.PARAM_CHANNEL, "deadline", "delayNs", TvContractCompat.PARAM_CHANNEL, "deadline", "delayNs", TvContractCompat.PARAM_CHANNEL, "deadline", "delayNs"}, m93s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
/* loaded from: classes4.dex */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedPeriodTicker$1(Continuation<? super TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fixedPeriodTicker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fixedPeriodTicker = TickerChannels.fixedPeriodTicker(0L, 0L, null, this);
        return fixedPeriodTicker;
    }
}
