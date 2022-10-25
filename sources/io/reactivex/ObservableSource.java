package io.reactivex;

/* loaded from: classes4.dex */
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
