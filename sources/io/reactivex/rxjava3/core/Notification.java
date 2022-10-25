package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class Notification<T> {
    static final Notification<Object> COMPLETE = new Notification<>(null);
    final Object value;

    private Notification(Object value) {
        this.value = value;
    }

    public boolean isOnComplete() {
        return this.value == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    public boolean isOnNext() {
        Object obj = this.value;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public T getValue() {
        Object obj = this.value;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.value;
    }

    public Throwable getError() {
        Object obj = this.value;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return Objects.equals(this.value, ((Notification) obj).value);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    public static <T> Notification<T> createOnNext(T value) {
        Objects.requireNonNull(value, "value is null");
        return new Notification<>(value);
    }

    public static <T> Notification<T> createOnError(Throwable error) {
        Objects.requireNonNull(error, "error is null");
        return new Notification<>(NotificationLite.error(error));
    }

    public static <T> Notification<T> createOnComplete() {
        return (Notification<T>) COMPLETE;
    }
}
