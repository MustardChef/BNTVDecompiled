package com.lagradost.nicehttp;

import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.net.URI;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000X\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001aJ\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001b\u001a8\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b\u001aÃ\u0001\u0010(\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010)\u001a\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b*\u00020$2\u0006\u0010*\u001a\u00020\u0002\u001a\n\u0010+\u001a\u00020,*\u00020,\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\r¨\u0006-"}, m107d2 = {"cantHaveBody", "", "", "getCantHaveBody", "()Ljava/util/List;", "mustHaveBody", "getMustHaveBody", "cookies", "", "Lokhttp3/Request;", "getCookies", "(Lokhttp3/Request;)Ljava/util/Map;", "Lokhttp3/Response;", "(Lokhttp3/Response;)Ljava/util/Map;", "addParamsToUrl", "url", NativeProtocol.WEB_DIALOG_PARAMS, "appendUri", ShareConstants.MEDIA_URI, "appendQuery", "getCache", "Lokhttp3/CacheControl;", "cacheTime", "", "cacheUnit", "Ljava/util/concurrent/TimeUnit;", "getData", "Lokhttp3/RequestBody;", FirebaseAnalytics.Param.METHOD, "data", "files", "Lcom/lagradost/nicehttp/NiceFile;", "json", "", "requestBody", "getHeaders", "Lokhttp3/Headers;", "headers", "referer", "cookie", "requestCreator", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;Lokhttp3/RequestBody;Ljava/lang/Integer;Ljava/util/concurrent/TimeUnit;)Lokhttp3/Request;", "cookieKey", "ignoreAllSSLErrors", "Lokhttp3/OkHttpClient$Builder;", "library_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class RequestsKt {
    private static final List<String> mustHaveBody = CollectionsKt.listOf((Object[]) new String[]{ShareTarget.METHOD_POST, "PUT"});
    private static final List<String> cantHaveBody = CollectionsKt.listOf((Object[]) new String[]{ShareTarget.METHOD_GET, "HEAD"});

    /* renamed from: ignoreAllSSLErrors$lambda-10 */
    public static final boolean m9026ignoreAllSSLErrors$lambda10(String str, SSLSession sSLSession) {
        return true;
    }

    public static final Map<String, String> getCookies(Headers headers, String cookieKey) {
        String str;
        String obj;
        String obj2;
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(cookieKey, "cookieKey");
        ArrayList arrayList = new ArrayList();
        for (Tuples<? extends String, ? extends String> tuples : headers) {
            if (StringsKt.equals(tuples.getFirst(), cookieKey, true)) {
                arrayList.add(tuples);
            }
        }
        Tuples tuples2 = (Tuples) CollectionsKt.getOrNull(arrayList, 0);
        LinkedHashMap linkedHashMap = null;
        List split$default = (tuples2 == null || (str = (String) tuples2.getSecond()) == null) ? null : StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        if (split$default != null) {
            List<String> list = split$default;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (String str2 : list) {
                List split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null);
                String str3 = (String) CollectionsKt.getOrNull(split$default2, 0);
                String str4 = "";
                if (str3 == null || (obj = StringsKt.trim((CharSequence) str3).toString()) == null) {
                    obj = "";
                }
                String str5 = (String) CollectionsKt.getOrNull(split$default2, 1);
                if (str5 != null && (obj2 = StringsKt.trim((CharSequence) str5).toString()) != null) {
                    str4 = obj2;
                }
                Tuples m100to = TuplesKt.m100to(obj, str4);
                linkedHashMap2.put(m100to.getFirst(), m100to.getSecond());
            }
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                if ((StringsKt.isBlank((CharSequence) entry.getKey()) ^ true) && (StringsKt.isBlank((CharSequence) entry.getValue()) ^ true)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return linkedHashMap == null ? MapsKt.emptyMap() : linkedHashMap;
    }

    public static final Map<String, String> getCookies(Response response) {
        return getCookies(response.headers(), "set-cookie");
    }

    private static final Map<String, String> getCookies(Request request) {
        return getCookies(request.headers(), HttpHeaders.COOKIE);
    }

    public static final List<String> getMustHaveBody() {
        return mustHaveBody;
    }

    public static final List<String> getCantHaveBody() {
        return cantHaveBody;
    }

    public static final RequestBody getData(String method, Map<String, String> map, List<NiceFile> list, Object obj, RequestBody requestBody) {
        RequestBody requestBody2;
        String jsonString;
        Intrinsics.checkNotNullParameter(method, "method");
        List<String> list2 = cantHaveBody;
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (list2.contains(upperCase)) {
            return null;
        }
        if (requestBody != null) {
            return requestBody;
        }
        if (map != null) {
            FormBody.Builder builder = new FormBody.Builder(null, 1, null);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            requestBody2 = builder.build();
        } else if (obj != null) {
            if (obj instanceof JSONObject) {
                jsonString = ((JSONObject) obj).toString();
            } else if (obj instanceof JSONArray) {
                jsonString = ((JSONArray) obj).toString();
            } else {
                jsonString = obj instanceof String ? (String) obj : Requests.Companion.getMapper().writeValueAsString(obj);
            }
            String str = obj instanceof String ? RequestBodyTypes.TEXT : RequestBodyTypes.JSON;
            RequestBody.Companion companion = RequestBody.Companion;
            Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
            requestBody2 = companion.create(jsonString, MediaType.Companion.parse(str));
        } else {
            List<NiceFile> list3 = list;
            if (!(list3 == null || list3.isEmpty())) {
                MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
                for (NiceFile niceFile : list) {
                    if (niceFile.getFile() != null) {
                        String name = niceFile.getName();
                        String fileName = niceFile.getFileName();
                        RequestBody.Companion companion2 = RequestBody.Companion;
                        File file = niceFile.getFile();
                        String fileType = niceFile.getFileType();
                        type.addFormDataPart(name, fileName, companion2.create(file, fileType == null ? null : MediaType.Companion.parse(fileType)));
                    } else {
                        type.addFormDataPart(niceFile.getName(), niceFile.getFileName());
                    }
                }
                requestBody2 = type.build();
            } else {
                requestBody2 = null;
            }
        }
        if (requestBody2 == null) {
            List<String> list4 = mustHaveBody;
            String upperCase2 = method.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return list4.contains(upperCase2) ? new FormBody.Builder(null, 1, null).build() : null;
        }
        return requestBody2;
    }

    private static final String appendUri(String str, String str2) {
        URI uri = new URI(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String path = uri.getPath();
        if (uri.getQuery() != null) {
            str2 = uri.getQuery() + Typography.amp + str2;
        }
        String uri2 = new URI(scheme, authority, path, str2, uri.getFragment()).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "URI(\n        oldUri.sche…fragment\n    ).toString()");
        return uri2;
    }

    private static final CacheControl getCache(int i, TimeUnit timeUnit) {
        return new CacheControl.Builder().maxStale(i, timeUnit).build();
    }

    public static final Headers getHeaders(Map<String, String> headers, String str, Map<String, String> cookie) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        Map mapOf = str == null ? null : MapsKt.mapOf(TuplesKt.m100to("referer", str));
        if (mapOf == null) {
            mapOf = MapsKt.emptyMap();
        }
        if (!cookie.isEmpty()) {
            emptyMap = MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.COOKIE, CollectionsKt.joinToString$default(cookie.entrySet(), " ", null, null, 0, null, RequestsKt$getHeaders$cookieMap$1.INSTANCE, 30, null)));
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        return Headers.Companion.m79of(MapsKt.plus(MapsKt.plus(headers, emptyMap), mapOf));
    }

    public static /* synthetic */ Request requestCreator$default(String str, String str2, Map map, String str3, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, Integer num, TimeUnit timeUnit, int i, Object obj2) {
        return requestCreator(str, str2, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? MapsKt.emptyMap() : map3, (i & 64) != 0 ? null : map4, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : obj, (i & 512) != 0 ? null : requestBody, (i & 1024) != 0 ? null : num, (i & 2048) == 0 ? timeUnit : null);
    }

    public static final Request requestCreator(String method, String url, Map<String, String> headers, String str, Map<String, String> params, Map<String, String> cookies, Map<String, String> map, List<NiceFile> list, Object obj, RequestBody requestBody, Integer num, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Request.Builder url2 = new Request.Builder().url(addParamsToUrl(url, params));
        if (num != null && timeUnit != null) {
            url2.cacheControl(getCache(num.intValue(), timeUnit));
        }
        return url2.headers(getHeaders(headers, str, cookies)).method(method, getData(method, map, list, obj, requestBody)).build();
    }

    public static final OkHttpClient.Builder ignoreAllSSLErrors(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.lagradost.nicehttp.RequestsKt$ignoreAllSSLErrors$naiveTrustManager$1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                Intrinsics.checkNotNullParameter(certs, "certs");
                Intrinsics.checkNotNullParameter(authType, "authType");
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                Intrinsics.checkNotNullParameter(certs, "certs");
                Intrinsics.checkNotNullParameter(authType, "authType");
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
        SSLSocketFactory insecureSocketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(insecureSocketFactory, "insecureSocketFactory");
        builder.sslSocketFactory(insecureSocketFactory, x509TrustManager);
        builder.hostnameVerifier($$Lambda$RequestsKt$bAfRwzknvdCXxHGMsD5sJemaoQ.INSTANCE);
        return builder;
    }

    private static final String addParamsToUrl(String str, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                str = appendUri(str, entry.getKey() + '=' + value);
            }
        }
        return str;
    }
}
