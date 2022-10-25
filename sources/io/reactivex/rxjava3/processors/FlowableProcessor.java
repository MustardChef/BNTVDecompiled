package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Processor;

/* loaded from: classes4.dex */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
    @CheckReturnValue
    public abstract Throwable getThrowable();

    @CheckReturnValue
    public abstract boolean hasComplete();

    @CheckReturnValue
    public abstract boolean hasSubscribers();

    @CheckReturnValue
    public abstract boolean hasThrowable();

    @CheckReturnValue
    public final FlowableProcessor<T> toSerialized() {
        return this instanceof SerializedProcessor ? this : new SerializedProcessor(this);
    }
}
