package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Limit.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
@DebugMetadata(m99c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m98f = "Limit.kt", m97i = {0}, m96l = {137}, m95m = "collectWhile", m94n = {"collector"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Limit.collectWhile(null, null, this);
    }
}
