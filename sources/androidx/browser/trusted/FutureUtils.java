package androidx.browser.trusted;

import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
class FutureUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListenableFuture<T> immediateFailedFuture(Throwable cause) {
        ResolvableFuture create = ResolvableFuture.create();
        create.setException(cause);
        return create;
    }

    private FutureUtils() {
    }
}
