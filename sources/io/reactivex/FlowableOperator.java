package io.reactivex;

import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public interface FlowableOperator<Downstream, Upstream> {
    Subscriber<? super Upstream> apply(Subscriber<? super Downstream> subscriber) throws Exception;
}
