package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Reduce.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
@DebugMetadata(m99c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m98f = "Reduce.kt", m97i = {0}, m96l = {44}, m95m = "fold", m94n = {"accumulator"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$fold$1(Continuation<? super FlowKt__ReduceKt$fold$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Reduce.fold(null, null, null, this);
    }
}
