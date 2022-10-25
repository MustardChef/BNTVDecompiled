package com.lagradost.cloudstream3.network;

import android.content.Context;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.RequestsKt;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata(m108d1 = {"\u0000,\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"DEFAULT_HEADERS", "", "", "cookies", "Lokhttp3/Request;", "getCookies", "(Lokhttp3/Request;)Ljava/util/Map;", "getHeaders", "Lokhttp3/Headers;", "headers", "cookie", "initClient", "Lokhttp3/OkHttpClient;", "Lcom/lagradost/nicehttp/Requests;", "context", "Landroid/content/Context;", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.network.RequestsHelperKt */
/* loaded from: classes3.dex */
public final class RequestsHelper {
    private static final Map<String, String> DEFAULT_HEADERS = MapsKt.mapOf(TuplesKt.m100to("user-agent", MainAPIKt.USER_AGENT));

    public static final OkHttpClient initClient(Requests requests, Context context) {
        Intrinsics.checkNotNullParameter(requests, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt(context.getString(R.string.dns_pref), 0);
        OkHttpClient.Builder cache = RequestsKt.ignoreAllSSLErrors(new OkHttpClient.Builder().followRedirects(true).followSslRedirects(true)).cache(new Cache(new File(context.getCacheDir(), "http_cache"), 52428800L));
        if (i == 1) {
            DohProviders.addGoogleDns(cache);
        } else if (i == 2) {
            DohProviders.addCloudFlareDns(cache);
        } else if (i == 4) {
            DohProviders.addAdGuardDns(cache);
        }
        requests.setBaseClient(cache.build());
        return requests.getBaseClient();
    }

    public static final Map<String, String> getCookies(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        return RequestsKt.getCookies(request.headers(), HttpHeaders.COOKIE);
    }

    public static final Headers getHeaders(Map<String, String> headers, Map<String, String> cookie) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        if (!cookie.isEmpty()) {
            emptyMap = MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.COOKIE, CollectionsKt.joinToString$default(cookie.entrySet(), " ", null, null, 0, null, RequestsHelperKt$getHeaders$cookieMap$1.INSTANCE, 30, null)));
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        return Headers.Companion.m79of(MapsKt.plus(MapsKt.plus(DEFAULT_HEADERS, headers), emptyMap));
    }
}
