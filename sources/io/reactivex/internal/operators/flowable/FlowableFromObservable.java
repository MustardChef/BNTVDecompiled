package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }

    /* loaded from: classes4.dex */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: d */
        private Disposable f10187d;

        /* renamed from: s */
        private final Subscriber<? super T> f10188s;

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f10188s = subscriber;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f10188s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f10188s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.f10188s.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f10187d = disposable;
            this.f10188s.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f10187d.dispose();
        }
    }
}
