package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int capacity) {
        super(capacity);
    }

    public boolean setResource(int index, Subscription resource) {
        Subscription subscription;
        do {
            subscription = get(index);
            if (subscription == SubscriptionHelper.CANCELLED) {
                if (resource != null) {
                    resource.cancel();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(index, subscription, resource));
        if (subscription != null) {
            subscription.cancel();
            return true;
        }
        return true;
    }

    public Subscription replaceResource(int index, Subscription resource) {
        Subscription subscription;
        do {
            subscription = get(index);
            if (subscription == SubscriptionHelper.CANCELLED) {
                if (resource != null) {
                    resource.cancel();
                    return null;
                }
                return null;
            }
        } while (!compareAndSet(index, subscription, resource));
        return subscription;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        Subscription andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (get(i) != SubscriptionHelper.CANCELLED && (andSet = getAndSet(i, SubscriptionHelper.CANCELLED)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }
}
