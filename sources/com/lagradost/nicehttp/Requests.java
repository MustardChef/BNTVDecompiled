package com.lagradost.nicehttp;

import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.Extensions;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001NB{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010Jï\u0001\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010DJç\u0001\u0010E\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJ¥\u0001\u0010G\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010HJ¥\u0001\u0010I\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010HJç\u0001\u0010J\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJç\u0001\u0010K\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJç\u0001\u0010L\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FJç\u0001\u0010M\u001a\u00020.2\u0006\u00100\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\r2\b\b\u0002\u0010@\u001a\u00020\u000f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020=H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010FR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, m107d2 = {"Lcom/lagradost/nicehttp/Requests;", "", "baseClient", "Lokhttp3/OkHttpClient;", "defaultHeaders", "", "", "defaultReferer", "defaultData", "defaultCookies", "defaultCacheTime", "", "defaultCacheTimeUnit", "Ljava/util/concurrent/TimeUnit;", "defaultTimeOut", "", "(Lokhttp3/OkHttpClient;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ILjava/util/concurrent/TimeUnit;J)V", "getBaseClient", "()Lokhttp3/OkHttpClient;", "setBaseClient", "(Lokhttp3/OkHttpClient;)V", "getDefaultCacheTime", "()I", "setDefaultCacheTime", "(I)V", "getDefaultCacheTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "setDefaultCacheTimeUnit", "(Ljava/util/concurrent/TimeUnit;)V", "getDefaultCookies", "()Ljava/util/Map;", "setDefaultCookies", "(Ljava/util/Map;)V", "getDefaultData", "setDefaultData", "getDefaultHeaders", "setDefaultHeaders", "getDefaultReferer", "()Ljava/lang/String;", "setDefaultReferer", "(Ljava/lang/String;)V", "getDefaultTimeOut", "()J", "setDefaultTimeOut", "(J)V", "custom", "Lcom/lagradost/nicehttp/NiceResponse;", FirebaseAnalytics.Param.METHOD, "url", "headers", "referer", NativeProtocol.WEB_DIALOG_PARAMS, "cookies", "data", "files", "", "Lcom/lagradost/nicehttp/NiceFile;", "json", "requestBody", "Lokhttp3/RequestBody;", "allowRedirects", "", "cacheTime", "cacheUnit", "timeout", "interceptor", "Lokhttp3/Interceptor;", "verify", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;Lokhttp3/RequestBody;ZILjava/util/concurrent/TimeUnit;JLokhttp3/Interceptor;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;Lokhttp3/RequestBody;ZILjava/util/concurrent/TimeUnit;JLokhttp3/Interceptor;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZILjava/util/concurrent/TimeUnit;JLokhttp3/Interceptor;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.TAG_HEAD, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "patch", "post", "put", "Companion", "library_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public class Requests {
    public static final Companion Companion = new Companion(null);
    private static ObjectMapper mapper;
    private OkHttpClient baseClient;
    private int defaultCacheTime;
    private TimeUnit defaultCacheTimeUnit;
    private Map<String, String> defaultCookies;
    private Map<String, String> defaultData;
    private Map<String, String> defaultHeaders;
    private String defaultReferer;
    private long defaultTimeOut;

    public Requests() {
        this(null, null, null, null, null, 0, null, 0L, 255, null);
    }

    public Requests(OkHttpClient baseClient, Map<String, String> defaultHeaders, String str, Map<String, String> defaultData, Map<String, String> defaultCookies, int i, TimeUnit defaultCacheTimeUnit, long j) {
        Intrinsics.checkNotNullParameter(baseClient, "baseClient");
        Intrinsics.checkNotNullParameter(defaultHeaders, "defaultHeaders");
        Intrinsics.checkNotNullParameter(defaultData, "defaultData");
        Intrinsics.checkNotNullParameter(defaultCookies, "defaultCookies");
        Intrinsics.checkNotNullParameter(defaultCacheTimeUnit, "defaultCacheTimeUnit");
        this.baseClient = baseClient;
        this.defaultHeaders = defaultHeaders;
        this.defaultReferer = str;
        this.defaultData = defaultData;
        this.defaultCookies = defaultCookies;
        this.defaultCacheTime = i;
        this.defaultCacheTimeUnit = defaultCacheTimeUnit;
        this.defaultTimeOut = j;
    }

    public /* synthetic */ Requests(OkHttpClient okHttpClient, Map map, String str, Map map2, Map map3, int i, TimeUnit timeUnit, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new OkHttpClient() : okHttpClient, (i2 & 2) != 0 ? MapsKt.mapOf(TuplesKt.m100to("user-agent", "NiceHttp")) : map, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? TimeUnit.MINUTES : timeUnit, (i2 & 128) != 0 ? 0L : j);
    }

    public final OkHttpClient getBaseClient() {
        return this.baseClient;
    }

    public final void setBaseClient(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "<set-?>");
        this.baseClient = okHttpClient;
    }

    public final Map<String, String> getDefaultHeaders() {
        return this.defaultHeaders;
    }

    public final void setDefaultHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.defaultHeaders = map;
    }

    public final String getDefaultReferer() {
        return this.defaultReferer;
    }

    public final void setDefaultReferer(String str) {
        this.defaultReferer = str;
    }

    public final Map<String, String> getDefaultData() {
        return this.defaultData;
    }

    public final void setDefaultData(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.defaultData = map;
    }

    public final Map<String, String> getDefaultCookies() {
        return this.defaultCookies;
    }

    public final void setDefaultCookies(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.defaultCookies = map;
    }

    public final int getDefaultCacheTime() {
        return this.defaultCacheTime;
    }

    public final void setDefaultCacheTime(int i) {
        this.defaultCacheTime = i;
    }

    public final TimeUnit getDefaultCacheTimeUnit() {
        return this.defaultCacheTimeUnit;
    }

    public final void setDefaultCacheTimeUnit(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "<set-?>");
        this.defaultCacheTimeUnit = timeUnit;
    }

    public final long getDefaultTimeOut() {
        return this.defaultTimeOut;
    }

    public final void setDefaultTimeOut(long j) {
        this.defaultTimeOut = j;
    }

    /* compiled from: Requests.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n*\u00020\u000bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m107d2 = {"Lcom/lagradost/nicehttp/Requests$Companion;", "", "()V", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "setMapper", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "await", "Lokhttp3/Response;", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ObjectMapper getMapper() {
            return Requests.mapper;
        }

        public final void setMapper(ObjectMapper objectMapper) {
            Intrinsics.checkNotNullParameter(objectMapper, "<set-?>");
            Requests.mapper = objectMapper;
        }

        private final Object await$$forInline(Call call, Continuation<? super Response> continuation) {
            InlineMarker.mark(0);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl2);
            call.enqueue(continuationCallback);
            cancellableContinuationImpl2.invokeOnCancellation(continuationCallback);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
            return result;
        }

        public final Object await(Call call, Continuation<? super Response> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ContinuationCallback continuationCallback = new ContinuationCallback(call, cancellableContinuationImpl2);
            call.enqueue(continuationCallback);
            cancellableContinuationImpl2.invokeOnCancellation(continuationCallback);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    static {
        ObjectMapper configure = Extensions.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Intrinsics.checkNotNullExpressionValue(configure, "jacksonObjectMapper().co…          false\n        )");
        mapper = configure;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object custom(java.lang.String r23, java.lang.String r24, java.util.Map<java.lang.String, java.lang.String> r25, java.lang.String r26, java.util.Map<java.lang.String, java.lang.String> r27, java.util.Map<java.lang.String, java.lang.String> r28, java.util.Map<java.lang.String, java.lang.String> r29, java.util.List<com.lagradost.nicehttp.NiceFile> r30, java.lang.Object r31, okhttp3.RequestBody r32, boolean r33, int r34, java.util.concurrent.TimeUnit r35, long r36, okhttp3.Interceptor r38, boolean r39, kotlin.coroutines.Continuation<? super com.lagradost.nicehttp.NiceResponse> r40) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.nicehttp.Requests.custom(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.util.List, java.lang.Object, okhttp3.RequestBody, boolean, int, java.util.concurrent.TimeUnit, long, okhttp3.Interceptor, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object custom$default(Requests requests, String str, String str2, Map map, String str3, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.custom(str, str2, (i2 & 4) != 0 ? MapsKt.emptyMap() : map, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? MapsKt.emptyMap() : map2, (i2 & 32) != 0 ? MapsKt.emptyMap() : map3, (i2 & 64) != 0 ? requests.getDefaultData() : map4, (i2 & 128) != 0 ? null : list, (i2 & 256) != 0 ? null : obj, (i2 & 512) != 0 ? null : requestBody, (i2 & 1024) != 0 ? true : z, (i2 & 2048) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 4096) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 8192) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 16384) != 0 ? null : interceptor, (i2 & 32768) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: custom");
    }

    public static /* synthetic */ Object get$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            return requests.get(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 128) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 256) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 512) != 0 ? null : interceptor, (i2 & 1024) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public final Object get(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom(ShareTarget.METHOD_GET, str, map, str2, map2, map3, null, null, null, null, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object post$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.post(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? requests.getDefaultData() : map4, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : obj, (i2 & 256) != 0 ? null : requestBody, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 2048) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 4096) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 8192) != 0 ? null : interceptor, (i2 & 16384) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
    }

    public final Object post(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, List<NiceFile> list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom(ShareTarget.METHOD_POST, str, map, str2, map2, map3, map4, list, obj, requestBody, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object put$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.put(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? requests.getDefaultData() : map4, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : obj, (i2 & 256) != 0 ? null : requestBody, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 2048) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 4096) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 8192) != 0 ? null : interceptor, (i2 & 16384) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
    }

    public final Object put(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, List<NiceFile> list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom("PUT", str, map, str2, map2, map3, map4, list, obj, requestBody, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object delete$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.delete(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? requests.getDefaultData() : map4, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : obj, (i2 & 256) != 0 ? null : requestBody, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 2048) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 4096) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 8192) != 0 ? null : interceptor, (i2 & 16384) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public final Object delete(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, List<NiceFile> list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom("DELETE", str, map, str2, map2, map3, map4, list, obj, requestBody, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object head$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            return requests.head(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 128) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 256) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 512) != 0 ? null : interceptor, (i2 & 1024) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: head");
    }

    public final Object head(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom("HEAD", str, map, str2, map2, map3, null, null, null, null, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object patch$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.patch(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? requests.getDefaultData() : map4, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : obj, (i2 & 256) != 0 ? null : requestBody, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 2048) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 4096) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 8192) != 0 ? null : interceptor, (i2 & 16384) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: patch");
    }

    public final Object patch(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, List<NiceFile> list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom("PATCH", str, map, str2, map2, map3, map4, list, obj, requestBody, z, i, timeUnit, j, interceptor, z2, continuation);
    }

    public static /* synthetic */ Object options$default(Requests requests, String str, Map map, String str2, Map map2, Map map3, Map map4, List list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation continuation, int i2, Object obj2) {
        if (obj2 == null) {
            return requests.options(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? MapsKt.emptyMap() : map2, (i2 & 16) != 0 ? MapsKt.emptyMap() : map3, (i2 & 32) != 0 ? requests.getDefaultData() : map4, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : obj, (i2 & 256) != 0 ? null : requestBody, (i2 & 512) != 0 ? true : z, (i2 & 1024) != 0 ? requests.getDefaultCacheTime() : i, (i2 & 2048) != 0 ? requests.getDefaultCacheTimeUnit() : timeUnit, (i2 & 4096) != 0 ? requests.getDefaultTimeOut() : j, (i2 & 8192) != 0 ? null : interceptor, (i2 & 16384) != 0 ? true : z2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: options");
    }

    public final Object options(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, List<NiceFile> list, Object obj, RequestBody requestBody, boolean z, int i, TimeUnit timeUnit, long j, Interceptor interceptor, boolean z2, Continuation<? super NiceResponse> continuation) {
        return custom("OPTIONS", str, map, str2, map2, map3, map4, list, obj, requestBody, z, i, timeUnit, j, interceptor, z2, continuation);
    }
}
