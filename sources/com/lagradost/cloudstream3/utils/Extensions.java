package com.lagradost.cloudstream3.utils;

import com.facebook.internal.NativeProtocol;
import com.lagradost.nicehttp.Requests;
import kotlin.Metadata;

/* compiled from: Extensions.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/Extensions;", "", "()V", "RequestCustom", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Extensions {

    /* compiled from: Extensions.kt */
    @Metadata(m108d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J¥\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017Jç\u0001\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/Extensions$RequestCustom;", "Lcom/lagradost/nicehttp/Requests;", "()V", "getWithCustomCache", "Lcom/lagradost/nicehttp/NiceResponse;", "url", "", "headers", "", "referer", NativeProtocol.WEB_DIALOG_PARAMS, "cookies", "allowRedirects", "", "cacheTime", "", "cacheUnit", "Ljava/util/concurrent/TimeUnit;", "timeout", "", "interceptor", "Lokhttp3/Interceptor;", "verify", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZILjava/util/concurrent/TimeUnit;JLokhttp3/Interceptor;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postWithCustomCache", "data", "files", "", "Lcom/lagradost/nicehttp/NiceFile;", "json", "", "requestBody", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/Object;Lokhttp3/RequestBody;ZILjava/util/concurrent/TimeUnit;JLokhttp3/Interceptor;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class RequestCustom extends Requests {
        public RequestCustom() {
            super(null, null, null, null, null, 0, null, 0L, 255, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00f7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getWithCustomCache(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.util.Map<java.lang.String, java.lang.String> r24, java.util.Map<java.lang.String, java.lang.String> r25, boolean r26, int r27, java.util.concurrent.TimeUnit r28, long r29, okhttp3.Interceptor r31, boolean r32, kotlin.coroutines.Continuation<? super com.lagradost.nicehttp.NiceResponse> r33) {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.Extensions.RequestCustom.getWithCustomCache(java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Map, boolean, int, java.util.concurrent.TimeUnit, long, okhttp3.Interceptor, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ff  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object postWithCustomCache(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, java.lang.String r23, java.util.Map<java.lang.String, java.lang.String> r24, java.util.Map<java.lang.String, java.lang.String> r25, java.util.Map<java.lang.String, java.lang.String> r26, java.util.List<com.lagradost.nicehttp.NiceFile> r27, java.lang.Object r28, okhttp3.RequestBody r29, boolean r30, int r31, java.util.concurrent.TimeUnit r32, long r33, okhttp3.Interceptor r35, boolean r36, kotlin.coroutines.Continuation<? super com.lagradost.nicehttp.NiceResponse> r37) {
            /*
                Method dump skipped, instructions count: 266
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.Extensions.RequestCustom.postWithCustomCache(java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.util.List, java.lang.Object, okhttp3.RequestBody, boolean, int, java.util.concurrent.TimeUnit, long, okhttp3.Interceptor, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
