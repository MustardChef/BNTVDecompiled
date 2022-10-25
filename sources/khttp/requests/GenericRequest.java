package khttp.requests;

import android.util.JsonWriter;
import androidx.exifinterface.media.ExifInterface;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.internal.NativeProtocol;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.IDN;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import khttp.extensions.ExtensionsKt;
import khttp.structures.authorization.Authorization;
import khttp.structures.files.FileLike;
import khttp.structures.maps.CaseInsensitiveMutableMap;
import khttp.structures.parameters.Parameters;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GenericRequest.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\u009d\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\tH\u0002J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0002J\f\u00103\u001a\u000204*\u000204H\u0002J1\u00105\u001a\u00020\u0003\"\u0004\b\u0000\u00106*\u0002H62\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020:08H\u0002¢\u0006\u0002\u0010;R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0016\u0010\n\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0014\u0010\u0012\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)¨\u0006="}, m107d2 = {"Lkhttp/requests/GenericRequest;", "Lkhttp/requests/Request;", FirebaseAnalytics.Param.METHOD, "", "url", NativeProtocol.WEB_DIALOG_PARAMS, "", "headers", "data", "", "json", "auth", "Lkhttp/structures/authorization/Authorization;", "cookies", "timeout", "", "allowRedirects", "", "stream", "files", "", "Lkhttp/structures/files/FileLike;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Lkhttp/structures/authorization/Authorization;Ljava/util/Map;DLjava/lang/Boolean;ZLjava/util/List;)V", "_body", "", "getAllowRedirects", "()Z", "getAuth", "()Lkhttp/structures/authorization/Authorization;", "body", "getBody", "()[B", "getCookies", "()Ljava/util/Map;", "getData", "()Ljava/lang/Object;", "getFiles", "()Ljava/util/List;", "getHeaders", "getJson", "getMethod", "()Ljava/lang/String;", "getParams", "getStream", "getTimeout", "()D", "getUrl", "coerceToJSON", "any", "makeRoute", "route", "toIDN", "Ljava/net/URL;", "withJSONWriter", ExifInterface.GPS_DIRECTION_TRUE, "converter", "Lkotlin/Function2;", "Landroid/util/JsonWriter;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/String;", "Companion", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class GenericRequest implements Request {
    private byte[] _body;
    private final boolean allowRedirects;
    private final Authorization auth;
    private final Map<String, String> cookies;
    private final Object data;
    private final List<FileLike> files;
    private final Map<String, String> headers;
    private final Object json;
    private final String method;
    private final Map<String, String> params;
    private final boolean stream;
    private final double timeout;
    private final String url;
    public static final Companion Companion = new Companion(null);
    private static final Map<String, String> DEFAULT_HEADERS = MapsKt.mapOf(TuplesKt.m100to("Accept", MimeType.UNKNOWN), TuplesKt.m100to(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"), TuplesKt.m100to("User-Agent", "khttp/1.0.0-SNAPSHOT"));
    private static final Map<String, String> DEFAULT_DATA_HEADERS = MapsKt.mapOf(TuplesKt.m100to("Content-Type", "text/plain"));
    private static final Map<String, String> DEFAULT_FORM_HEADERS = MapsKt.mapOf(TuplesKt.m100to("Content-Type", "application/x-www-form-urlencoded"));
    private static final Map<String, String> DEFAULT_UPLOAD_HEADERS = MapsKt.mapOf(TuplesKt.m100to("Content-Type", "multipart/form-data; boundary=%s"));
    private static final Map<String, String> DEFAULT_JSON_HEADERS = MapsKt.mapOf(TuplesKt.m100to("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE));

    public GenericRequest(String method, String url, Map<String, String> params, Map<String, String> headers, Object obj, Object obj2, Authorization authorization, Map<String, String> map, double d, Boolean bool, boolean z, List<FileLike> files) {
        String str;
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        Intrinsics.checkParameterIsNotNull(files, "files");
        this.method = method;
        this.params = params;
        this.json = obj2;
        this.auth = authorization;
        this.cookies = map;
        this.timeout = d;
        this.stream = z;
        this.files = files;
        this.allowRedirects = bool != null ? bool.booleanValue() : !Intrinsics.areEqual(getMethod(), "HEAD");
        this.url = makeRoute(url);
        if (!SetsKt.setOf((Object[]) new String[]{"http", "https"}).contains(new URI(getUrl()).getScheme())) {
            throw new IllegalArgumentException("Invalid schema. Only http:// and https:// are supported.");
        }
        Object json = getJson();
        CaseInsensitiveMutableMap caseInsensitiveMutableMap = new CaseInsensitiveMutableMap(MapsKt.toSortedMap(headers));
        if (json == null) {
            this.data = obj;
            if (obj != null && getFiles().isEmpty()) {
                if (obj instanceof Map) {
                    ExtensionsKt.putAllIfAbsentWithNull(caseInsensitiveMutableMap, DEFAULT_FORM_HEADERS);
                } else {
                    ExtensionsKt.putAllIfAbsentWithNull(caseInsensitiveMutableMap, DEFAULT_DATA_HEADERS);
                }
            }
        } else {
            this.data = coerceToJSON(json);
            ExtensionsKt.putAllIfAbsentWithNull(caseInsensitiveMutableMap, DEFAULT_JSON_HEADERS);
        }
        CaseInsensitiveMutableMap caseInsensitiveMutableMap2 = caseInsensitiveMutableMap;
        ExtensionsKt.putAllIfAbsentWithNull(caseInsensitiveMutableMap2, DEFAULT_HEADERS);
        if (!getFiles().isEmpty()) {
            ExtensionsKt.putAllIfAbsentWithNull(caseInsensitiveMutableMap2, DEFAULT_UPLOAD_HEADERS);
            if (caseInsensitiveMutableMap2.containsKey((Object) "Content-Type")) {
                String str2 = (String) caseInsensitiveMutableMap.get((Object) "Content-Type");
                if (str2 != null) {
                    String uuid = UUID.randomUUID().toString();
                    Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
                    str = String.format(str2, Arrays.copyOf(new Object[]{StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null)}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
                } else {
                    str = null;
                }
                caseInsensitiveMutableMap2.put((CaseInsensitiveMutableMap) "Content-Type", str);
            }
        }
        Authorization auth = getAuth();
        if (auth != null) {
            Tuples<String, String> header = auth.getHeader();
            caseInsensitiveMutableMap2.put((CaseInsensitiveMutableMap) header.getFirst(), header.getSecond());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = caseInsensitiveMutableMap2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            linkedHashMap3.put(key, (String) value);
        }
        this.headers = new CaseInsensitiveMutableMap(MapsKt.toSortedMap(linkedHashMap3));
    }

    @Override // khttp.requests.Request
    public String getMethod() {
        return this.method;
    }

    @Override // khttp.requests.Request
    public Map<String, String> getParams() {
        return this.params;
    }

    @Override // khttp.requests.Request
    public Object getJson() {
        return this.json;
    }

    @Override // khttp.requests.Request
    public Authorization getAuth() {
        return this.auth;
    }

    @Override // khttp.requests.Request
    public Map<String, String> getCookies() {
        return this.cookies;
    }

    @Override // khttp.requests.Request
    public double getTimeout() {
        return this.timeout;
    }

    @Override // khttp.requests.Request
    public boolean getStream() {
        return this.stream;
    }

    @Override // khttp.requests.Request
    public List<FileLike> getFiles() {
        return this.files;
    }

    /* compiled from: GenericRequest.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, m107d2 = {"Lkhttp/requests/GenericRequest$Companion;", "", "()V", "DEFAULT_DATA_HEADERS", "", "", "getDEFAULT_DATA_HEADERS", "()Ljava/util/Map;", "DEFAULT_FORM_HEADERS", "getDEFAULT_FORM_HEADERS", "DEFAULT_HEADERS", "getDEFAULT_HEADERS", "DEFAULT_JSON_HEADERS", "getDEFAULT_JSON_HEADERS", "DEFAULT_UPLOAD_HEADERS", "getDEFAULT_UPLOAD_HEADERS", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, String> getDEFAULT_HEADERS() {
            return GenericRequest.DEFAULT_HEADERS;
        }

        public final Map<String, String> getDEFAULT_DATA_HEADERS() {
            return GenericRequest.DEFAULT_DATA_HEADERS;
        }

        public final Map<String, String> getDEFAULT_FORM_HEADERS() {
            return GenericRequest.DEFAULT_FORM_HEADERS;
        }

        public final Map<String, String> getDEFAULT_UPLOAD_HEADERS() {
            return GenericRequest.DEFAULT_UPLOAD_HEADERS;
        }

        public final Map<String, String> getDEFAULT_JSON_HEADERS() {
            return GenericRequest.DEFAULT_JSON_HEADERS;
        }
    }

    @Override // khttp.requests.Request
    public String getUrl() {
        return this.url;
    }

    @Override // khttp.requests.Request
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // khttp.requests.Request
    public Object getData() {
        return this.data;
    }

    @Override // khttp.requests.Request
    public boolean getAllowRedirects() {
        return this.allowRedirects;
    }

    @Override // khttp.requests.Request
    public byte[] getBody() {
        if (this._body == null) {
            Object data = getData();
            List<FileLike> files = getFiles();
            if (data == null && files.isEmpty()) {
                byte[] bArr = new byte[0];
                this._body = bArr;
                if (bArr != null) {
                    return bArr;
                }
                throw new IllegalStateException("Set to null by another thread");
            }
            if (data == null) {
                data = null;
            } else if ((data instanceof Map) && !(data instanceof Parameters)) {
                Map map = (Map) data;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(String.valueOf(entry.getKey()), entry.getValue());
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    linkedHashMap2.put(entry2.getKey(), String.valueOf(entry2.getValue()));
                }
                data = new Parameters(linkedHashMap2);
            }
            if (data != null && (!files.isEmpty()) && !(data instanceof Map)) {
                throw new IllegalArgumentException("data must be a Map".toString());
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!files.isEmpty()) {
                String str = getHeaders().get("Content-Type");
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                String str2 = (String) StringsKt.split$default((CharSequence) str, new String[]{"boundary="}, false, 0, 6, (Object) null).get(1);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, Charsets.UTF_8);
                if (data != null) {
                    for (Map.Entry entry3 : ((Map) data).entrySet()) {
                        Object key = entry3.getKey();
                        Object value = entry3.getValue();
                        OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
                        ExtensionsKt.writeAndFlush(outputStreamWriter2, "--" + str2 + "\r\n");
                        String valueOf = String.valueOf(key);
                        ExtensionsKt.writeAndFlush(outputStreamWriter2, "Content-Disposition: form-data; name=\"" + valueOf + "\"\r\n\r\n");
                        ExtensionsKt.writeAndFlush(outputStreamWriter2, String.valueOf(value));
                        ExtensionsKt.writeAndFlush(outputStreamWriter2, "\r\n");
                    }
                }
                for (FileLike fileLike : files) {
                    OutputStreamWriter outputStreamWriter3 = outputStreamWriter;
                    ExtensionsKt.writeAndFlush(outputStreamWriter3, "--" + str2 + "\r\n");
                    ExtensionsKt.writeAndFlush(outputStreamWriter3, "Content-Disposition: form-data; name=\"" + fileLike.getFieldName() + "\"; filename=\"" + fileLike.getFileName() + "\"\r\n\r\n");
                    byteArrayOutputStream.write(fileLike.getContents());
                    ExtensionsKt.writeAndFlush(outputStreamWriter3, "\r\n");
                }
                ExtensionsKt.writeAndFlush(outputStreamWriter, "--" + str2 + "--\r\n");
                outputStreamWriter.close();
            } else if (!(data instanceof File) && !(data instanceof InputStream)) {
                String valueOf2 = String.valueOf(data);
                Charset charset = Charsets.UTF_8;
                if (valueOf2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = valueOf2.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                byteArrayOutputStream.write(bytes);
            }
            this._body = byteArrayOutputStream.toByteArray();
        }
        byte[] bArr2 = this._body;
        if (bArr2 != null) {
            return bArr2;
        }
        throw new IllegalStateException("Set to null by another thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String coerceToJSON(Object obj) {
        String withJSONWriter;
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            withJSONWriter = new JSONObject((Map) obj).toString();
        } else if (obj instanceof Collection) {
            withJSONWriter = new JSONArray((Collection) obj).toString();
        } else if (obj instanceof Object[]) {
            withJSONWriter = new JSONArray(obj).toString();
        } else if (obj instanceof Iterable) {
            withJSONWriter = withJSONWriter(obj, new GenericRequest$coerceToJSON$1(this, obj));
        } else {
            throw new IllegalArgumentException("Could not coerce " + obj.getClass().getSimpleName() + " to JSON.");
        }
        Intrinsics.checkExpressionValueIsNotNull(withJSONWriter, "if (any is Map<*, *>) {\n…ame} to JSON.\")\n        }");
        return withJSONWriter;
    }

    private final <T> String withJSONWriter(T t, Function2<? super JsonWriter, ? super T, Unit> function2) {
        StringWriter stringWriter = new StringWriter();
        function2.invoke(new JsonWriter(stringWriter), t);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    private final URL toIDN(URL url) {
        String ascii = IDN.toASCII(url.getHost());
        String query = url.getQuery();
        return new URL(new URI(url.getProtocol(), url.getUserInfo(), ascii, url.getPort(), url.getPath(), query != null ? URLDecoder.decode(query, "UTF-8") : null, url.getRef()).toASCIIString());
    }

    private final String makeRoute(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!getParams().isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('?');
            sb2.append(new Parameters(getParams()));
            str2 = sb2.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        String url = toIDN(new URL(sb.toString())).toString();
        Intrinsics.checkExpressionValueIsNotNull(url, "URL(route + if (this.par…se \"\").toIDN().toString()");
        return url;
    }
}
