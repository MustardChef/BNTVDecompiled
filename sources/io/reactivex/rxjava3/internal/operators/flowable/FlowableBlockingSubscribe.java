package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BoundedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(Publisher<? extends T> source, Subscriber<? super T> subscriber) {
        Object poll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        source.subscribe(blockingSubscriber);
        do {
            try {
                if (blockingSubscriber.isCancelled()) {
                    return;
                }
                poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    if (blockingSubscriber.isCancelled()) {
                        return;
                    }
                    BlockingHelper.verifyNonBlocking();
                    poll = linkedBlockingQueue.take();
                }
                if (blockingSubscriber.isCancelled() || poll == BlockingSubscriber.TERMINATED) {
                    return;
                }
            } catch (InterruptedException e) {
                blockingSubscriber.cancel();
                subscriber.onError(e);
                return;
            }
        } while (!NotificationLite.acceptFull(poll, subscriber));
    }

    public static <T> void subscribe(Publisher<? extends T> source) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.REQUEST_MAX);
        source.subscribe(lambdaSubscriber);
        BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaSubscriber);
        Throwable th = blockingIgnoringReceiver.error;
        if (th != null) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void subscribe(Publisher<? extends T> o, final Consumer<? super T> onNext, final Consumer<? super Throwable> onError, final Action onComplete) {
        Objects.requireNonNull(onNext, "onNext is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        subscribe(o, new LambdaSubscriber(onNext, onError, onComplete, Functions.REQUEST_MAX));
    }

    public static <T> void subscribe(Publisher<? extends T> o, final Consumer<? super T> onNext, final Consumer<? super Throwable> onError, final Action onComplete, int bufferSize) {
        Objects.requireNonNull(onNext, "onNext is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        ObjectHelper.verifyPositive(bufferSize, "number > 0 required");
        subscribe(o, new BoundedSubscriber(onNext, onError, onComplete, Functions.boundedConsumer(bufferSize), bufferSize));
    }
}
