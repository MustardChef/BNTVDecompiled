package com.lagradost.cloudstream3;

import android.content.ComponentName;
import android.content.Context;
import com.lagradost.cloudstream3.utils.Extensions;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* compiled from: MainActivity.kt */
@Metadata(m108d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, m107d2 = {"DEFAULT_CACHE_TIME", "", "DEFAULT_CACHE_TIME_UNIT", "Ljava/util/concurrent/TimeUnit;", "getDEFAULT_CACHE_TIME_UNIT", "()Ljava/util/concurrent/TimeUnit;", "VLC_COMPONENT", "Landroid/content/ComponentName;", "getVLC_COMPONENT", "()Landroid/content/ComponentName;", "VLC_EXTRA_DURATION_OUT", "", "VLC_EXTRA_POSITION_OUT", "VLC_FROM_PROGRESS", "VLC_FROM_START", "VLC_INTENT_ACTION_RESULT", "VLC_LAST_ID_KEY", "VLC_PACKAGE", "VLC_REQUEST_CODE", "app", "Lcom/lagradost/cloudstream3/utils/Extensions$RequestCustom;", "getApp", "()Lcom/lagradost/cloudstream3/utils/Extensions$RequestCustom;", "setApp", "(Lcom/lagradost/cloudstream3/utils/Extensions$RequestCustom;)V", "cache", "Lokhttp3/Cache;", "getCache", "()Lokhttp3/Cache;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MainActivityKt {
    public static final int DEFAULT_CACHE_TIME = 4;
    private static final TimeUnit DEFAULT_CACHE_TIME_UNIT;
    public static final String VLC_EXTRA_DURATION_OUT = "extra_duration";
    public static final String VLC_EXTRA_POSITION_OUT = "extra_position";
    public static final int VLC_FROM_PROGRESS = -2;
    public static final int VLC_FROM_START = -1;
    public static final String VLC_INTENT_ACTION_RESULT = "org.videolan.vlc.player.result";
    public static final String VLC_LAST_ID_KEY = "vlc_last_open_id";
    public static final int VLC_REQUEST_CODE = 42;
    private static Extensions.RequestCustom app;
    private static final Cache cache;
    private static final OkHttpClient okHttpClient;
    public static final String VLC_PACKAGE = "org.videolan.vlc";
    private static final ComponentName VLC_COMPONENT = new ComponentName(VLC_PACKAGE, "org.videolan.vlc.gui.video.VideoPlayerActivity");

    public static final ComponentName getVLC_COMPONENT() {
        return VLC_COMPONENT;
    }

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        DEFAULT_CACHE_TIME_UNIT = timeUnit;
        Context context = AcraApplication.Companion.getContext();
        Cache cache2 = new Cache(new File(context != null ? context.getCacheDir() : null, "http_cache"), 52428800L);
        cache = cache2;
        OkHttpClient build = new OkHttpClient.Builder().cache(cache2).addInterceptor(new ForceCacheInterceptor()).build();
        okHttpClient = build;
        Extensions.RequestCustom requestCustom = new Extensions.RequestCustom();
        requestCustom.setBaseClient(build);
        requestCustom.setDefaultHeaders(MapsKt.mapOf(TuplesKt.m100to("user-agent", MainAPIKt.USER_AGENT)));
        requestCustom.setDefaultCacheTime(4);
        requestCustom.setDefaultCacheTimeUnit(timeUnit);
        app = requestCustom;
    }

    public static final TimeUnit getDEFAULT_CACHE_TIME_UNIT() {
        return DEFAULT_CACHE_TIME_UNIT;
    }

    public static final Cache getCache() {
        return cache;
    }

    public static final OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static final Extensions.RequestCustom getApp() {
        return app;
    }

    public static final void setApp(Extensions.RequestCustom requestCustom) {
        Intrinsics.checkNotNullParameter(requestCustom, "<set-?>");
        app = requestCustom;
    }
}
