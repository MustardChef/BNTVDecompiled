package kotlinx.coroutines.channels;

import com.applovin.sdk.AppLovinMediationProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m98f = "Deprecated.kt", m97i = {0, 0, 0, 1, 1, 1, 1}, m96l = {420, 422}, m95m = "maxWith", m94n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", AppLovinMediationProvider.MAX}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes4.dex */
public final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$maxWith$1(Continuation<? super ChannelsKt__DeprecatedKt$maxWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object maxWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        maxWith = Deprecated.maxWith(null, null, this);
        return maxWith;
    }
}
