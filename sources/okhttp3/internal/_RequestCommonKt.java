package okhttp3.internal;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

/* compiled from: -RequestCommon.kt */
@Metadata(m108d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\b\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u0017\u001a\u00020\u0004*\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0019\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u001c"}, m107d2 = {"canonicalUrl", "", "url", "commonAddHeader", "Lokhttp3/Request$Builder;", "name", "value", "commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "cacheControl", "commonDelete", "body", "Lokhttp3/RequestBody;", "commonGet", "commonHead", "commonHeader", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMethod", FirebaseAnalytics.Param.METHOD, "commonNewBuilder", "commonPatch", "commonPost", "commonPut", "commonRemoveHeader", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _RequestCommonKt {
    public static final String commonHeader(Request request, String name) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return request.headers().get(name);
    }

    public static final List<String> commonHeaders(Request request, String name) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return request.headers().values(name);
    }

    public static final Request.Builder commonNewBuilder(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        return new Request.Builder(request);
    }

    public static final CacheControl commonCacheControl(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        CacheControl lazyCacheControl$okhttp = request.getLazyCacheControl$okhttp();
        if (lazyCacheControl$okhttp == null) {
            CacheControl parse = CacheControl.Companion.parse(request.headers());
            request.setLazyCacheControl$okhttp(parse);
            return parse;
        }
        return lazyCacheControl$okhttp;
    }

    public static final String canonicalUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith(url, "ws:", true)) {
            String substring = url.substring(3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return Intrinsics.stringPlus("http:", substring);
        } else if (StringsKt.startsWith(url, "wss:", true)) {
            String substring2 = url.substring(4);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            return Intrinsics.stringPlus("https:", substring2);
        } else {
            return url;
        }
    }

    public static final Request.Builder commonHeader(Request.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders$okhttp().set(name, value);
        return builder;
    }

    public static final Request.Builder commonAddHeader(Request.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getHeaders$okhttp().add(name, value);
        return builder;
    }

    public static final Request.Builder commonRemoveHeader(Request.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        builder.getHeaders$okhttp().removeAll(name);
        return builder;
    }

    public static final Request.Builder commonHeaders(Request.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public static final Request.Builder commonCacheControl(Request.Builder builder, CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        String cacheControl2 = cacheControl.toString();
        return cacheControl2.length() == 0 ? builder.removeHeader("Cache-Control") : builder.header("Cache-Control", cacheControl2);
    }

    public static final Request.Builder commonGet(Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method(ShareTarget.METHOD_GET, null);
    }

    public static final Request.Builder commonHead(Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method("HEAD", null);
    }

    public static final Request.Builder commonPost(Request.Builder builder, RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method(ShareTarget.METHOD_POST, body);
    }

    public static final Request.Builder commonDelete(Request.Builder builder, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method("DELETE", requestBody);
    }

    public static final Request.Builder commonPut(Request.Builder builder, RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method("PUT", body);
    }

    public static final Request.Builder commonPatch(Request.Builder builder, RequestBody body) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        return builder.method("PATCH", body);
    }

    public static final Request.Builder commonMethod(Request.Builder builder, String method, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(method, "method");
        if (!(method.length() > 0)) {
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }
        if (requestBody == null) {
            if (!(true ^ HttpMethod.requiresRequestBody(method))) {
                throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
            }
        } else if (!HttpMethod.permitsRequestBody(method)) {
            throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
        }
        builder.setMethod$okhttp(method);
        builder.setBody$okhttp(requestBody);
        return builder;
    }
}
