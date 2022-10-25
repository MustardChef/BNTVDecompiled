package khttp.responses;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import khttp.extensions.ExtensionsKt;
import khttp.requests.GenericRequest;
import khttp.requests.Request;
import khttp.structures.authorization.Authorization;
import khttp.structures.cookie.Cookie;
import khttp.structures.cookie.CookieJar;
import khttp.structures.maps.CaseInsensitiveMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.p043io.Closeable;
import kotlin.p043io.IOStreams;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0L2\u0006\u0010M\u001a\u00020\u0019H\u0016J\r\u0010N\u001a\u000202H\u0000¢\u0006\u0002\bOJ \u0010P\u001a\b\u0012\u0004\u0012\u00020\b0L2\u0006\u0010M\u001a\u00020\u00192\b\u0010Q\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010R\u001a\u00020\u000fH\u0016J\b\u0010S\u001a\u000202H\u0002J3\u0010T\u001a\u0004\u0018\u00010U\"\b\b\u0000\u0010V*\u00020W*\b\u0012\u0004\u0012\u0002HV0X2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u0002HVH\u0002¢\u0006\u0002\u0010[J-\u0010\\\u001a\u00020\u0006*\u00020]2\u0006\u0010^\u001a\u00020\u00012\u0017\u0010_\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002020`¢\u0006\u0002\baH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0013R&\u00100\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000202010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0018\u0010H\u001a\u00020\u0017*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006c"}, m107d2 = {"Lkhttp/responses/GenericResponse;", "Lkhttp/responses/Response;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lkhttp/requests/Request;", "(Lkhttp/requests/Request;)V", "_connection", "Ljava/net/HttpURLConnection;", "_content", "", "_cookies", "Lkhttp/structures/cookie/CookieJar;", "_encoding", "Ljava/nio/charset/Charset;", "_headers", "", "", "_history", "", "get_history$library_release", "()Ljava/util/List;", "set_history$library_release", "(Ljava/util/List;)V", "_raw", "Ljava/io/InputStream;", "_statusCode", "", "Ljava/lang/Integer;", "connection", "getConnection", "()Ljava/net/HttpURLConnection;", "content", "getContent", "()[B", "cookies", "getCookies", "()Lkhttp/structures/cookie/CookieJar;", "value", "encoding", "getEncoding", "()Ljava/nio/charset/Charset;", "setEncoding", "(Ljava/nio/charset/Charset;)V", "headers", "getHeaders", "()Ljava/util/Map;", "history", "", "getHistory", "initializers", "Lkotlin/Function2;", "", "jsonArray", "Lorg/json/JSONArray;", "getJsonArray", "()Lorg/json/JSONArray;", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "raw", "getRaw", "()Ljava/io/InputStream;", "getRequest", "()Lkhttp/requests/Request;", "statusCode", "getStatusCode", "()I", "text", "getText", "()Ljava/lang/String;", "url", "getUrl", "realInputStream", "getRealInputStream", "(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;", "contentIterator", "", "chunkSize", "init", "init$library_release", "lineIterator", TtmlNode.RUBY_DELIMITER, "toString", "updateRequestHeaders", "getField", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/net/URLConnection;", "Ljava/lang/Class;", "name", "instance", "(Ljava/lang/Class;Ljava/lang/String;Ljava/net/URLConnection;)Ljava/lang/Object;", "openRedirectingConnection", "Ljava/net/URL;", "first", "receiver", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Companion", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericResponse implements Response {
    private HttpURLConnection _connection;
    private byte[] _content;
    private final CookieJar _cookies;
    private Charset _encoding;
    private Map<String, String> _headers;
    private List<Response> _history;
    private InputStream _raw;
    private Integer _statusCode;
    private final List<Function2<GenericResponse, HttpURLConnection, Unit>> initializers;
    private final Request request;
    public static final Companion Companion = new Companion(null);
    private static final List<Function2<GenericResponse, HttpURLConnection, Unit>> defaultStartInitializers = CollectionsKt.arrayListOf(GenericResponse$Companion$defaultStartInitializers$1.INSTANCE, GenericResponse$Companion$defaultStartInitializers$2.INSTANCE, GenericResponse$Companion$defaultStartInitializers$3.INSTANCE, GenericResponse$Companion$defaultStartInitializers$4.INSTANCE, GenericResponse$Companion$defaultStartInitializers$5.INSTANCE);
    private static final List<Function2<GenericResponse, HttpURLConnection, Unit>> defaultEndInitializers = CollectionsKt.arrayListOf(GenericResponse$Companion$defaultEndInitializers$1.INSTANCE, GenericResponse$Companion$defaultEndInitializers$2.INSTANCE, GenericResponse$Companion$defaultEndInitializers$3.INSTANCE);

    public GenericResponse(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        this.request = request;
        this._history = new ArrayList();
        this._cookies = new CookieJar(null, 1, null);
        this.initializers = new ArrayList();
    }

    @Override // khttp.responses.Response
    public Request getRequest() {
        return this.request;
    }

    /* compiled from: GenericResponse.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R,\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u00020\u000e*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m107d2 = {"Lkhttp/responses/GenericResponse$Companion;", "", "()V", "defaultEndInitializers", "", "Lkotlin/Function2;", "Lkhttp/responses/GenericResponse;", "Ljava/net/HttpURLConnection;", "", "getDefaultEndInitializers$library_release", "()Ljava/util/List;", "defaultStartInitializers", "getDefaultStartInitializers$library_release", "cookieJar", "Lkhttp/structures/cookie/CookieJar;", "getCookieJar$library_release", "(Ljava/net/HttpURLConnection;)Lkhttp/structures/cookie/CookieJar;", "forceMethod", FirebaseAnalytics.Param.METHOD, "", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CookieJar getCookieJar$library_release(HttpURLConnection receiver$0) {
            Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
            Map<String, List<String>> headerFields = receiver$0.getHeaderFields();
            Intrinsics.checkExpressionValueIsNotNull(headerFields, "this.headerFields");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                if (Intrinsics.areEqual(entry.getKey(), HttpHeaders.SET_COOKIE)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                CollectionsKt.addAll(arrayList, (List) entry2.getValue());
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((String) next).length() > 0) {
                    arrayList2.add(next);
                }
            }
            ArrayList<String> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (String str : arrayList3) {
                arrayList4.add(new Cookie(str));
            }
            Object[] array = arrayList4.toArray(new Cookie[0]);
            if (array != null) {
                Cookie[] cookieArr = (Cookie[]) array;
                return new CookieJar((Cookie[]) Arrays.copyOf(cookieArr, cookieArr.length));
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void forceMethod(HttpURLConnection httpURLConnection, String str) {
            try {
                httpURLConnection.setRequestMethod(str);
            } catch (ProtocolException unused) {
                try {
                    Field declaredField = httpURLConnection.getClass().getDeclaredField("delegate");
                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "this");
                    declaredField.setAccessible(true);
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) declaredField.get(httpURLConnection);
                    if (httpURLConnection2 != null) {
                        forceMethod(httpURLConnection2, str);
                    }
                } catch (NoSuchFieldException unused2) {
                }
                for (Class cls : CollectionsKt.plus((Collection<? extends Class<?>>) ExtensionsKt.getSuperclasses(httpURLConnection.getClass()), httpURLConnection.getClass())) {
                    try {
                        Field declaredField2 = cls.getDeclaredField(FirebaseAnalytics.Param.METHOD);
                        Intrinsics.checkExpressionValueIsNotNull(declaredField2, "this");
                        declaredField2.setAccessible(true);
                        declaredField2.set(httpURLConnection, str);
                    } catch (NoSuchFieldException unused3) {
                    }
                }
            }
            if (!Intrinsics.areEqual(httpURLConnection.getRequestMethod(), str)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final List<Function2<GenericResponse, HttpURLConnection, Unit>> getDefaultStartInitializers$library_release() {
            return GenericResponse.defaultStartInitializers;
        }

        public final List<Function2<GenericResponse, HttpURLConnection, Unit>> getDefaultEndInitializers$library_release() {
            return GenericResponse.defaultEndInitializers;
        }
    }

    private final HttpURLConnection openRedirectingConnection(URL url, Response response, Function1<? super HttpURLConnection, Unit> function1) {
        URLConnection openConnection = url.openConnection();
        if (openConnection == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
        function1.invoke(httpURLConnection);
        httpURLConnection.connect();
        if (response.getRequest().getAllowRedirects() && ArraysKt.contains(new Integer[]{301, 302, 303, 307, 308}, Integer.valueOf(httpURLConnection.getResponseCode()))) {
            CookieJar cookieJar$library_release = Companion.getCookieJar$library_release(httpURLConnection);
            Request request = response.getRequest();
            String method = request.getMethod();
            String aSCIIString = url.toURI().resolve(httpURLConnection.getHeaderField("Location")).toASCIIString();
            Intrinsics.checkExpressionValueIsNotNull(aSCIIString, "this@openRedirectingConn…cation\")).toASCIIString()");
            Map<String, String> headers = request.getHeaders();
            Map<String, String> params = request.getParams();
            Object data = request.getData();
            Object json = request.getJson();
            Authorization auth = request.getAuth();
            CookieJar cookieJar = cookieJar$library_release;
            Map<String, String> cookies = request.getCookies();
            if (cookies == null) {
                cookies = MapsKt.emptyMap();
            }
            GenericResponse genericResponse = new GenericResponse(new GenericRequest(method, aSCIIString, params, headers, data, json, auth, MapsKt.plus(cookieJar, cookies), request.getTimeout(), false, request.getStream(), request.getFiles()));
            genericResponse._cookies.putAll(cookieJar);
            genericResponse._history.addAll(response.getHistory());
            if (response != null) {
                ((GenericResponse) response)._history.add(genericResponse);
                genericResponse.init$library_release();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type khttp.responses.GenericResponse");
            }
        }
        return httpURLConnection;
    }

    public final List<Response> get_history$library_release() {
        return this._history;
    }

    public final void set_history$library_release(List<Response> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this._history = list;
    }

    @Override // khttp.responses.Response
    public List<Response> getHistory() {
        List<Response> unmodifiableList = Collections.unmodifiableList(this._history);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(this._history)");
        return unmodifiableList;
    }

    @Override // khttp.responses.Response
    public HttpURLConnection getConnection() {
        if (this._connection == null) {
            URL url = new URL(getRequest().getUrl());
            GenericResponse genericResponse = (Response) CollectionsKt.firstOrNull((List<? extends Object>) this._history);
            if (genericResponse == null) {
                GenericResponse genericResponse2 = this;
                genericResponse2._history.add(genericResponse2);
                genericResponse = this;
            }
            this._connection = openRedirectingConnection(url, genericResponse, new GenericResponse$connection$2(this));
        }
        HttpURLConnection httpURLConnection = this._connection;
        if (httpURLConnection != null) {
            return httpURLConnection;
        }
        throw new IllegalStateException("Set to null by another thread");
    }

    @Override // khttp.responses.Response
    public int getStatusCode() {
        if (this._statusCode == null) {
            this._statusCode = Integer.valueOf(getConnection().getResponseCode());
        }
        Integer num = this._statusCode;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("Set to null by another thread");
    }

    @Override // khttp.responses.Response
    public Map<String, String> getHeaders() {
        if (this._headers == null) {
            Map<String, List<String>> headerFields = getConnection().getHeaderFields();
            Intrinsics.checkExpressionValueIsNotNull(headerFields, "this.connection.headerFields");
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
            Iterator<T> it = headerFields.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
                linkedHashMap.put(key, CollectionsKt.joinToString$default((Iterable) value, ", ", null, null, 0, null, null, 62, null));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (((String) entry2.getKey()) != null) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            this._headers = linkedHashMap2;
        }
        Map<String, String> map = this._headers;
        if (map == null) {
            throw new IllegalStateException("Set to null by another thread");
        }
        return new CaseInsensitiveMap(map);
    }

    private final InputStream getRealInputStream(HttpURLConnection httpURLConnection) {
        InputStream stream;
        String str;
        try {
            stream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            stream = httpURLConnection.getErrorStream();
        }
        String str2 = getHeaders().get("Content-Encoding");
        if (str2 == null) {
            str = null;
        } else if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else {
            str = str2.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3189082) {
                if (hashCode == 1545112619 && str.equals("deflate")) {
                    return new InflaterInputStream(stream);
                }
            } else if (str.equals("gzip")) {
                return new GZIPInputStream(stream);
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
        return stream;
    }

    @Override // khttp.responses.Response
    public InputStream getRaw() {
        if (this._raw == null) {
            this._raw = getRealInputStream(getConnection());
        }
        InputStream inputStream = this._raw;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("Set to null by another thread");
    }

    @Override // khttp.responses.Response
    public byte[] getContent() {
        if (this._content == null) {
            InputStream raw = getRaw();
            Throwable th = null;
            try {
                byte[] readBytes = IOStreams.readBytes(raw);
                Closeable.closeFinally(raw, th);
                this._content = readBytes;
            } finally {
            }
        }
        byte[] bArr = this._content;
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalStateException("Set to null by another thread");
    }

    @Override // khttp.responses.Response
    public String getText() {
        return new String(getContent(), getEncoding());
    }

    @Override // khttp.responses.Response
    public JSONObject getJsonObject() {
        return new JSONObject(getText());
    }

    @Override // khttp.responses.Response
    public JSONArray getJsonArray() {
        return new JSONArray(getText());
    }

    @Override // khttp.responses.Response
    public CookieJar getCookies() {
        init$library_release();
        return this._cookies;
    }

    @Override // khttp.responses.Response
    public String getUrl() {
        String url = getConnection().getURL().toString();
        Intrinsics.checkExpressionValueIsNotNull(url, "this.connection.url.toString()");
        return url;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0124, code lost:
        if (r0 != null) goto L59;
     */
    @Override // khttp.responses.Response
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.charset.Charset getEncoding() {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: khttp.responses.GenericResponse.getEncoding():java.nio.charset.Charset");
    }

    @Override // khttp.responses.Response
    public void setEncoding(Charset value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._encoding = value;
    }

    @Override // khttp.responses.Response
    public Iterator<byte[]> contentIterator(int i) {
        return new GenericResponse$contentIterator$1(this, i);
    }

    @Override // khttp.responses.Response
    public Iterator<byte[]> lineIterator(int i, byte[] bArr) {
        return new GenericResponse$lineIterator$1(this, bArr, i);
    }

    public String toString() {
        return "<Response [" + getStatusCode() + "]>";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends URLConnection> Object getField(Class<T> cls, String str, T t) {
        Iterator it = CollectionsKt.plus((Collection<? extends Class<T>>) ExtensionsKt.getSuperclasses(cls), cls).iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            try {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "this");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(t);
                    if (obj == null) {
                        throw new Exception();
                        break;
                    }
                    return obj;
                } catch (Exception unused) {
                    Field declaredField2 = cls2.getDeclaredField("delegate");
                    Intrinsics.checkExpressionValueIsNotNull(declaredField2, "this");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(t);
                    if (obj2 instanceof URLConnection) {
                        return getField(((URLConnection) obj2).getClass(), str, (URLConnection) obj2);
                    }
                    continue;
                }
            } catch (NoSuchFieldException unused2) {
            }
        }
        return null;
    }

    private final void updateRequestHeaders() {
        Map<String, String> headers = getRequest().getHeaders();
        if (headers == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        }
        Map asMutableMap = TypeIntrinsics.asMutableMap(headers);
        Object field = getField(getConnection().getClass(), "requests", getConnection());
        if (field != null) {
            Method declaredMethod = field.getClass().getDeclaredMethod("getHeaders", new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "this");
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(field, new Object[0]);
            if (invoke == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.List<kotlin.String>>");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((Map) invoke).entrySet()) {
                if (!((List) entry.getValue()).isEmpty()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                linkedHashMap3.put(entry2.getKey(), CollectionsKt.joinToString$default((Iterable) entry2.getValue(), ", ", null, null, 0, null, null, 62, null));
            }
            asMutableMap.putAll(linkedHashMap3);
        }
    }

    public final void init$library_release() {
        if (getRequest().getStream()) {
            getConnection();
        } else {
            getContent();
        }
        updateRequestHeaders();
    }
}
