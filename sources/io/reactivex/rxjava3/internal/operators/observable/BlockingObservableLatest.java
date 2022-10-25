package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> source;

    public BlockingObservableLatest(ObservableSource<T> source) {
        this.source = source;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.source).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }

    /* loaded from: classes4.dex */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<T>> value = new AtomicReference<>();

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }

        BlockingObservableLatestIterator() {
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public /* bridge */ /* synthetic */ void onNext(Object args) {
            onNext((Notification) ((Notification) args));
        }

        public void onNext(Notification<T> args) {
            if (this.value.getAndSet(args) == null) {
                this.notify.release();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            RxJavaPlugins.onError(e);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.iteratorNotification;
            if (notification != null && notification.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
            }
            if (this.iteratorNotification == null) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.notify.acquire();
                    Notification<T> andSet = this.value.getAndSet(null);
                    this.iteratorNotification = andSet;
                    if (andSet.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (InterruptedException e) {
                    dispose();
                    this.iteratorNotification = Notification.createOnError(e);
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.iteratorNotification.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T value = this.iteratorNotification.getValue();
                this.iteratorNotification = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}
