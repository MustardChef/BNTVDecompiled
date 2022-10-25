package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: -ResponseBodyCommon.kt */
@Metadata(m108d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000\u001aG\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00130\u0011H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, m107d2 = {"commonAsResponseBody", "Lokhttp3/ResponseBody;", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "commonByteString", "Lokio/ByteString;", "commonBytes", "", "commonClose", "", "commonConsumeSource", ExifInterface.GPS_DIRECTION_TRUE, "", "consumer", "Lkotlin/Function1;", "sizeMapper", "", "(Lokhttp3/ResponseBody;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "commonToResponseBody", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _ResponseBodyCommonKt {
    public static final <T> T commonConsumeSource(ResponseBody responseBody, Function1<? super BufferedSource, ? extends T> consumer, Function1<? super T, Integer> sizeMapper) {
        T t;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(sizeMapper, "sizeMapper");
        long contentLength = responseBody.contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(contentLength)));
        }
        BufferedSource source = responseBody.source();
        Throwable th = null;
        try {
            t = consumer.invoke(source);
        } catch (Throwable th2) {
            th = th2;
            t = (Object) null;
        }
        if (source != null) {
            try {
                source.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(t);
        int intValue = sizeMapper.invoke(t).intValue();
        if (contentLength == -1 || contentLength == intValue) {
            return (T) t;
        }
        throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
    }

    public static final void commonClose(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        _UtilCommonKt.closeQuietly(responseBody.source());
    }

    public static final ResponseBody commonToResponseBody(byte[] bArr, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ResponseBody.Companion.create(new Buffer().write(bArr), mediaType, bArr.length);
    }

    public static final ResponseBody commonToResponseBody(ByteString byteString, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return ResponseBody.Companion.create(new Buffer().write(byteString), mediaType, byteString.size());
    }

    public static final ResponseBody commonAsResponseBody(final BufferedSource bufferedSource, final MediaType mediaType, final long j) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return new ResponseBody() { // from class: okhttp3.internal._ResponseBodyCommonKt$commonAsResponseBody$1
            @Override // okhttp3.ResponseBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.ResponseBody
            public long contentLength() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            public BufferedSource source() {
                return bufferedSource;
            }
        };
    }

    public static final byte[] commonBytes(ResponseBody responseBody) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long contentLength = responseBody.contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(contentLength)));
        }
        BufferedSource source = responseBody.source();
        Throwable th = null;
        try {
            bArr = source.readByteArray();
        } catch (Throwable th2) {
            bArr = null;
            th = th2;
        }
        if (source != null) {
            try {
                source.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(bArr);
        int length = bArr.length;
        if (contentLength == -1 || contentLength == length) {
            return bArr;
        }
        throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
    }

    public static final ByteString commonByteString(ResponseBody responseBody) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long contentLength = responseBody.contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException(Intrinsics.stringPlus("Cannot buffer entire body for content length: ", Long.valueOf(contentLength)));
        }
        BufferedSource source = responseBody.source();
        Throwable th = null;
        try {
            byteString = source.readByteString();
        } catch (Throwable th2) {
            byteString = null;
            th = th2;
        }
        if (source != null) {
            try {
                source.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        Intrinsics.checkNotNull(byteString);
        int size = byteString.size();
        if (contentLength == -1 || contentLength == size) {
            return byteString;
        }
        throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
    }
}
