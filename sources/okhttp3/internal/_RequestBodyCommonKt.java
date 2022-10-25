package okhttp3.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: -RequestBodyCommon.kt */
@Metadata(m108d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a$\u0010\u0006\u001a\u00020\u0002*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, m107d2 = {"commonContentLength", "", "Lokhttp3/RequestBody;", "commonIsDuplex", "", "commonIsOneShot", "commonToRequestBody", "", "contentType", "Lokhttp3/MediaType;", TypedValues.CycleType.S_WAVE_OFFSET, "", "byteCount", "Lokio/ByteString;", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _RequestBodyCommonKt {
    public static final long commonContentLength(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return -1L;
    }

    public static final boolean commonIsDuplex(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return false;
    }

    public static final boolean commonIsOneShot(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return false;
    }

    public static final RequestBody commonToRequestBody(final byte[] bArr, final MediaType mediaType, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        _UtilCommonKt.checkOffsetAndCount(bArr.length, i, i2);
        return new RequestBody() { // from class: okhttp3.internal._RequestBodyCommonKt$commonToRequestBody$1
            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write(bArr, i, i2);
            }
        };
    }

    public static final RequestBody commonToRequestBody(final ByteString byteString, final MediaType mediaType) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return new RequestBody() { // from class: okhttp3.internal._RequestBodyCommonKt$commonToRequestBody$2
            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return byteString.size();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.write(byteString);
            }
        };
    }
}
