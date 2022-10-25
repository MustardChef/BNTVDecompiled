package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
final class ObservableWindowSubscribeIntercept<T> extends Observable<T> {
    final AtomicBoolean once = new AtomicBoolean();
    final Subject<T> window;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObservableWindowSubscribeIntercept(Subject<T> source) {
        this.window = source;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> s) {
        this.window.subscribe(s);
        this.once.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryAbandon() {
        return !this.once.get() && this.once.compareAndSet(false, true);
    }
}
