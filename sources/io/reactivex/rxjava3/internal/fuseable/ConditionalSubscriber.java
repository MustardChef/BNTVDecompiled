package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.core.FlowableSubscriber;

/* loaded from: classes4.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(T t);
}
