package okhttp3.internal;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

/* compiled from: -ResponseCommon.kt */
@Metadata(m108d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010\u0019\u001a\u00020\f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c\u001a \u0010\u001d\u001a\u0004\u0018\u00010\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001a\u0010\u001d\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010\u001a\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 *\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\u001f\u001a\u00020\u0012*\u00020\u00122\u0006\u0010!\u001a\u00020\"\u001a\u0012\u0010#\u001a\u00020\u0012*\u00020\u00122\u0006\u0010$\u001a\u00020\u0010\u001a\u0014\u0010%\u001a\u00020\u0012*\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010'\u001a\u00020\u0012*\u00020\u0002\u001a\u0012\u0010(\u001a\u00020\u0016*\u00020\u00022\u0006\u0010)\u001a\u00020*\u001a\u0014\u0010+\u001a\u00020\u0012*\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010-\u001a\u00020\u0012*\u00020\u00122\u0006\u0010.\u001a\u00020/\u001a\u0012\u00100\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u00101\u001a\u00020\u0012*\u00020\u00122\u0006\u00102\u001a\u000203\u001a\n\u00104\u001a\u00020\u0010*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u00065"}, m107d2 = {"commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Response;", "getCommonCacheControl", "(Lokhttp3/Response;)Lokhttp3/CacheControl;", "commonIsRedirect", "", "getCommonIsRedirect", "(Lokhttp3/Response;)Z", "commonIsSuccessful", "getCommonIsSuccessful", "checkPriorResponse", "", "response", "checkSupportResponse", "name", "", "commonAddHeader", "Lokhttp3/Response$Builder;", "value", "commonBody", "body", "Lokhttp3/ResponseBody;", "commonCacheResponse", "cacheResponse", "commonClose", "commonCode", "code", "", "commonHeader", "defaultValue", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMessage", "message", "commonNetworkResponse", "networkResponse", "commonNewBuilder", "commonPeekBody", "byteCount", "", "commonPriorResponse", "priorResponse", "commonProtocol", "protocol", "Lokhttp3/Protocol;", "commonRemoveHeader", "commonRequest", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Request;", "commonToString", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _ResponseCommonKt {
    public static final boolean getCommonIsSuccessful(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        return 200 <= code && code < 300;
    }

    public static final List<String> commonHeaders(Response response, String name) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return response.headers().values(name);
    }

    public static final String commonHeader(Response response, String name, String str) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String str2 = response.headers().get(name);
        return str2 == null ? str : str2;
    }

    public static final ResponseBody commonPeekBody(Response response, long j) throws IOException {
        Intrinsics.checkNotNullParameter(response, "<this>");
        ResponseBody body = response.body();
        Intrinsics.checkNotNull(body);
        BufferedSource peek = body.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j);
        buffer.write((Source) peek, Math.min(j, peek.getBuffer().size()));
        return ResponseBody.Companion.create(buffer, response.body().contentType(), buffer.size());
    }

    public static final Response.Builder commonNewBuilder(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return new Response.Builder(response);
    }

    public static final boolean getCommonIsRedirect(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        if (code != 307 && code != 308) {
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static final CacheControl getCommonCacheControl(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        CacheControl lazyCacheControl$okhttp = response.getLazyCacheControl$okhttp();
        if (lazyCacheControl$okhttp == null) {
            CacheControl parse = CacheControl.Companion.parse(response.headers());
            response.setLazyCacheControl$okhttp(parse);
            return parse;
        }
        return lazyCacheControl$okhttp;
    }

    public static final void commonClose(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        ResponseBody body = response.body();
        if (body == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        body.close();
    }

    public static final String commonToString(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return "Response{protocol=" + response.protocol() + ", code=" + response.code() + ", message=" + response.message() + ", url=" + response.request().url() + '}';
    }

    public static final Response.Builder commonRequest(Response.Builder builder, Request request) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        builder.setRequest$okhttp(request);
        return builder;
    }

    public static final Response.Builder commonProtocol(Response.Builder builder, Protocol protocol) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        builder.setProtocol$okhttp(protocol);
        return builder;
    }

    public static final Response.Builder commonCode(Response.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setCode$okhttp(i);
        return builder;
    }

    public static final Response.Builder commonMessage(Response.Builder builder, String message) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        builder.setMessage$okhttp(message);
        return builder;
    }

    public static final Response.Builder commonHeader(Response.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders$okhttp().set(name, value);
        return builder;
    }

    public static final Response.Builder commonAddHeader(Response.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders$okhttp().add(name, value);
        return builder;
    }

    public static final Response.Builder commonRemoveHeader(Response.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        builder.getHeaders$okhttp().removeAll(name);
        return builder;
    }

    public static final Response.Builder commonHeaders(Response.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public static final Response.Builder commonBody(Response.Builder builder, ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setBody$okhttp(responseBody);
        return builder;
    }

    public static final Response.Builder commonNetworkResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        checkSupportResponse("networkResponse", response);
        builder.setNetworkResponse$okhttp(response);
        return builder;
    }

    public static final Response.Builder commonCacheResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        checkSupportResponse("cacheResponse", response);
        builder.setCacheResponse$okhttp(response);
        return builder;
    }

    private static final void checkSupportResponse(String str, Response response) {
        if (response == null) {
            return;
        }
        if (!(response.body() == null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".body != null").toString());
        }
        if (!(response.networkResponse() == null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".networkResponse != null").toString());
        }
        if (!(response.cacheResponse() == null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".cacheResponse != null").toString());
        }
        if (!(response.priorResponse() == null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".priorResponse != null").toString());
        }
    }

    public static final Response.Builder commonPriorResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        checkPriorResponse(response);
        builder.setPriorResponse$okhttp(response);
        return builder;
    }

    private static final void checkPriorResponse(Response response) {
        if (response == null) {
            return;
        }
        if (!(response.body() == null)) {
            throw new IllegalArgumentException("priorResponse.body != null".toString());
        }
    }
}
