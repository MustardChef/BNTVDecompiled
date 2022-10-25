package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

/* loaded from: classes4.dex */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    @CheckReturnValue
    public abstract Throwable getThrowable();

    @CheckReturnValue
    public abstract boolean hasComplete();

    @CheckReturnValue
    public abstract boolean hasObservers();

    @CheckReturnValue
    public abstract boolean hasThrowable();

    @CheckReturnValue
    public final Subject<T> toSerialized() {
        return this instanceof SerializedSubject ? this : new SerializedSubject(this);
    }
}
