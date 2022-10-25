package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: WithLifecycleState.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher;
    final /* synthetic */ C0499xfdb59cc4 $observer;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(CoroutineDispatcher coroutineDispatcher, Lifecycle lifecycle, C0499xfdb59cc4 c0499xfdb59cc4) {
        super(1);
        this.$lifecycleDispatcher = coroutineDispatcher;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$observer = c0499xfdb59cc4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (this.$lifecycleDispatcher.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
            final Lifecycle lifecycle = this.$this_suspendWithStateAtLeastUnchecked;
            final C0499xfdb59cc4 c0499xfdb59cc4 = this.$observer;
            this.$lifecycleDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.removeObserver(c0499xfdb59cc4);
                }
            });
            return;
        }
        this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this.$observer);
    }
}
