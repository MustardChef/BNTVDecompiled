package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: WithLifecycleState.kt */
@Metadata(m108d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 176)
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2 extends Lambda implements Functions<R> {
    final /* synthetic */ Functions<R> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(Functions<? extends R> functions) {
        super(0);
        this.$block = functions;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
    @Override // kotlin.jvm.functions.Functions
    public final R invoke() {
        return this.$block.invoke();
    }
}
