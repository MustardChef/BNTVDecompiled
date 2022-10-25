package io.reactivex.rxjava3.internal.subscribers;

/* loaded from: classes4.dex */
public interface InnerQueuedSubscriberSupport<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> inner);

    void innerError(InnerQueuedSubscriber<T> inner, Throwable e);

    void innerNext(InnerQueuedSubscriber<T> inner, T value);
}
