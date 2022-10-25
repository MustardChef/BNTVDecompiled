package com.lagradost.cloudstream3.services;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: ApiUtils.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ!\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/ApiUtils;", "", "()V", "builder", "Lretrofit2/Retrofit$Builder;", "getBuilder", "()Lretrofit2/Retrofit$Builder;", "httpClient", "Lokhttp3/OkHttpClient$Builder;", "getHttpClient", "()Lokhttp3/OkHttpClient$Builder;", "setHttpClient", "(Lokhttp3/OkHttpClient$Builder;)V", "createApi", "Lcom/lagradost/cloudstream3/services/ApiService;", "createService", ExifInterface.LATITUDE_SOUTH, "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ApiUtils {
    public static final Companion Companion = new Companion(null);
    private final Retrofit.Builder builder;
    private OkHttpClient.Builder httpClient;

    public ApiUtils() {
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl("https://phimhd.xyz/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create());
        Intrinsics.checkNotNullExpressionValue(addConverterFactory, "Builder()\n        .baseU…onverterFactory.create())");
        this.builder = addConverterFactory;
    }

    public final OkHttpClient.Builder getHttpClient() {
        return this.httpClient;
    }

    public final void setHttpClient(OkHttpClient.Builder builder) {
        this.httpClient = builder;
    }

    public final Retrofit.Builder getBuilder() {
        return this.builder;
    }

    /* compiled from: ApiUtils.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/ApiUtils$Companion;", "", "()V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final <S> S createService(Class<S> cls) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.httpClient = builder;
        if (builder != null) {
            builder.readTimeout(3L, TimeUnit.MINUTES);
        }
        OkHttpClient.Builder builder2 = this.httpClient;
        if (builder2 != null) {
            builder2.connectTimeout(3L, TimeUnit.MINUTES);
        }
        OkHttpClient.Builder builder3 = this.httpClient;
        if (builder3 != null) {
            builder3.addInterceptor($$Lambda$ApiUtils$bDXlutHUzLCg3HelnBfEzhZ7gME.INSTANCE);
        }
        OkHttpClient.Builder builder4 = this.httpClient;
        Intrinsics.checkNotNull(builder4);
        Retrofit build = this.builder.client(builder4.build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.client(client).build()");
        return (S) build.create(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createService$lambda-0  reason: not valid java name */
    public static final Response m8604createService$lambda0(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        return chain.proceed(request.newBuilder().addHeader("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE).method(request.method(), request.body()).build());
    }

    public final ApiService createApi() {
        return (ApiService) createService(ApiService.class);
    }
}
