package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.Ref;

/* compiled from: Reduce.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m107d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class FlowKt__ReduceKt$lastOrNull$2<T> implements FlowCollector, SuspendFunction {
    final /* synthetic */ Ref.ObjectRef<T> $result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$lastOrNull$2(Ref.ObjectRef<T> objectRef) {
        this.$result = objectRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$result.element = t;
        return Unit.INSTANCE;
    }
}
