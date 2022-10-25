package io.reactivex;

/* loaded from: classes4.dex */
public interface FlowableOnSubscribe<T> {
    void subscribe(FlowableEmitter<T> flowableEmitter) throws Exception;
}
