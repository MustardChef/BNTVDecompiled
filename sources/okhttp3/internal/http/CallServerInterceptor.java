package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Interceptor;

/* compiled from: CallServerInterceptor.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m107d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd A[Catch: IOException -> 0x019d, TryCatch #3 {IOException -> 0x019d, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00dd, B:47:0x00e6, B:48:0x00e9, B:49:0x010d, B:53:0x0118, B:55:0x0137, B:57:0x0145, B:64:0x015b, B:70:0x016e, B:74:0x0191, B:75:0x019b, B:73:0x0189, B:67:0x0164, B:59:0x0150, B:54:0x0127), top: B:89:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0164 A[Catch: IOException -> 0x019d, TryCatch #3 {IOException -> 0x019d, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00dd, B:47:0x00e6, B:48:0x00e9, B:49:0x010d, B:53:0x0118, B:55:0x0137, B:57:0x0145, B:64:0x015b, B:70:0x016e, B:74:0x0191, B:75:0x019b, B:73:0x0189, B:67:0x0164, B:59:0x0150, B:54:0x0127), top: B:89:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016e A[Catch: IOException -> 0x019d, TryCatch #3 {IOException -> 0x019d, blocks: (B:40:0x00a8, B:42:0x00b1, B:43:0x00b5, B:45:0x00dd, B:47:0x00e6, B:48:0x00e9, B:49:0x010d, B:53:0x0118, B:55:0x0137, B:57:0x0145, B:64:0x015b, B:70:0x016e, B:74:0x0191, B:75:0x019b, B:73:0x0189, B:67:0x0164, B:59:0x0150, B:54:0x0127), top: B:89:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
