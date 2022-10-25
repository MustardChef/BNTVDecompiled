package com.lagradost.nicehttp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/nicehttp/Session;", "Lcom/lagradost/nicehttp/Requests;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "CustomCookieJar", "library_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Session extends Requests {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Session(OkHttpClient client) {
        super(null, null, null, null, null, 0, null, 0L, 255, null);
        Intrinsics.checkNotNullParameter(client, "client");
        setBaseClient(client.newBuilder().cookieJar(new CustomCookieJar(this)).build());
    }

    /* compiled from: Requests.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m107d2 = {"Lcom/lagradost/nicehttp/Session$CustomCookieJar;", "Lokhttp3/CookieJar;", "(Lcom/lagradost/nicehttp/Session;)V", "cookies", "", "", "Lokhttp3/Cookie;", "loadForRequest", "", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "library_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public final class CustomCookieJar implements CookieJar {
        private Map<String, Cookie> cookies;
        final /* synthetic */ Session this$0;

        public CustomCookieJar(Session this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.cookies = MapsKt.emptyMap();
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return CollectionsKt.toList(this.cookies.values());
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(cookies, "cookies");
            Map<String, Cookie> map = this.cookies;
            List<Cookie> list = cookies;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Cookie cookie : list) {
                arrayList.add(TuplesKt.m100to(cookie.name(), cookie));
            }
            this.cookies = MapsKt.plus(map, arrayList);
        }
    }
}
