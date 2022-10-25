package retrofit2.adapter.rxjava3;

import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class Result<T> {
    @Nullable
    private final Throwable error;
    @Nullable
    private final Response<T> response;

    public static <T> Result<T> error(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new Result<>(null, th);
    }

    public static <T> Result<T> response(Response<T> response) {
        Objects.requireNonNull(response, "response == null");
        return new Result<>(response, null);
    }

    private Result(@Nullable Response<T> response, @Nullable Throwable th) {
        this.response = response;
        this.error = th;
    }

    @Nullable
    public Response<T> response() {
        return this.response;
    }

    @Nullable
    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }
}
