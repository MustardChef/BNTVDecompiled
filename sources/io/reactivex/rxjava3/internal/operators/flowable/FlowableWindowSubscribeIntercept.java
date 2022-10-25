package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
final class FlowableWindowSubscribeIntercept<T> extends Flowable<T> {
    final AtomicBoolean once = new AtomicBoolean();
    final FlowableProcessor<T> window;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowableWindowSubscribeIntercept(FlowableProcessor<T> source) {
        this.window = source;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        this.window.subscribe(s);
        this.once.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryAbandon() {
        return !this.once.get() && this.once.compareAndSet(false, true);
    }
}
