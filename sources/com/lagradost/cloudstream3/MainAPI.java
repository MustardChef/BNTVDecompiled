package com.lagradost.cloudstream3;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u001b\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0004\u0018\u000109H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0016J\u0006\u0010?\u001a\u000205J\u001b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u00107JI\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u00042\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002050G2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002050GH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u001b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010B\u001a\u00020\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u00107J\u000e\u0010M\u001a\u0002052\u0006\u0010D\u001a\u00020NJ!\u0010O\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P2\u0006\u0010R\u001a\u00020\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u00107J!\u0010S\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P2\u0006\u0010R\u001a\u00020\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u00107R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u001bR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0014\u00100\u001a\u000201X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, m107d2 = {"Lcom/lagradost/cloudstream3/MainAPI;", "", "()V", "canBeOverridden", "", "getCanBeOverridden", "()Z", "setCanBeOverridden", "(Z)V", "defaultPageUrl", "", "getDefaultPageUrl", "()Ljava/lang/String;", "hasChromecastSupport", "getHasChromecastSupport", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "instantLinkLoading", "getInstantLinkLoading", "isPremiumContent", "lang", "getLang", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "providerType", "Lcom/lagradost/cloudstream3/ProviderType;", "getProviderType", "()Lcom/lagradost/cloudstream3/ProviderType;", "storedCredentials", "getStoredCredentials", "setStoredCredentials", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "extractorVerifierJob", "", "extractorData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "init", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPage", "Lcom/lagradost/cloudstream3/PageResponse;", "overrideWithNewData", "Lcom/lagradost/cloudstream3/ProvidersInfoJson;", "quickSearch", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public abstract class MainAPI {
    public static final Companion Companion = new Companion(null);
    private static HashMap<String, ProvidersInfoJson> overrideData;
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;
    private final boolean instantLinkLoading;
    private final boolean isPremiumContent;
    private String storedCredentials;
    private final boolean usesWebView;
    private String name = "NONE";
    private String mainUrl = "NONE";
    private boolean canBeOverridden = true;
    private final String defaultPageUrl = "NONE";
    private String lang = "en";
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Cartoon, TvType.Anime, TvType.OVA});
    private final VPNStatus vpnStatus = VPNStatus.None;
    private final ProviderType providerType = ProviderType.DirectProvider;

    public Object extractorVerifierJob(String str, Continuation<? super Unit> continuation) {
        return extractorVerifierJob$suspendImpl(this, str, continuation);
    }

    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, continuation);
    }

    public Interceptor getVideoInterceptor(ExtractorLink extractorLink) {
        Intrinsics.checkNotNullParameter(extractorLink, "extractorLink");
        return null;
    }

    public Object load(String str, Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function12, continuation);
    }

    public Object loadPage(String str, Continuation<? super PageResponse> continuation) {
        return loadPage$suspendImpl(this, str, continuation);
    }

    public Object quickSearch(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        return quickSearch$suspendImpl(this, str, continuation);
    }

    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    /* compiled from: MainAPI.kt */
    @Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, m107d2 = {"Lcom/lagradost/cloudstream3/MainAPI$Companion;", "", "()V", "overrideData", "Ljava/util/HashMap;", "", "Lcom/lagradost/cloudstream3/ProvidersInfoJson;", "getOverrideData", "()Ljava/util/HashMap;", "setOverrideData", "(Ljava/util/HashMap;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashMap<String, ProvidersInfoJson> getOverrideData() {
            return MainAPI.overrideData;
        }

        public final void setOverrideData(HashMap<String, ProvidersInfoJson> hashMap) {
            MainAPI.overrideData = hashMap;
        }
    }

    public final void init() {
        ProvidersInfoJson providersInfoJson;
        HashMap<String, ProvidersInfoJson> hashMap = overrideData;
        if (hashMap == null || (providersInfoJson = hashMap.get(getClass().getSimpleName())) == null) {
            return;
        }
        overrideWithNewData(providersInfoJson);
    }

    public final void overrideWithNewData(ProvidersInfoJson data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getCanBeOverridden()) {
            setName(data.getName());
            if ((!StringsKt.isBlank(data.getUrl())) && !Intrinsics.areEqual(data.getUrl(), "NONE")) {
                setMainUrl(data.getUrl());
            }
            setStoredCredentials(data.getCredentials());
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    public String getStoredCredentials() {
        return this.storedCredentials;
    }

    public void setStoredCredentials(String str) {
        this.storedCredentials = str;
    }

    public boolean getCanBeOverridden() {
        return this.canBeOverridden;
    }

    public void setCanBeOverridden(boolean z) {
        this.canBeOverridden = z;
    }

    public String getDefaultPageUrl() {
        return this.defaultPageUrl;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public boolean isPremiumContent() {
        return this.isPremiumContent;
    }

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public VPNStatus getVpnStatus() {
        return this.vpnStatus;
    }

    public ProviderType getProviderType() {
        return this.providerType;
    }

    static /* synthetic */ Object getMainPage$suspendImpl(MainAPI mainAPI, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object search$suspendImpl(MainAPI mainAPI, String str, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object loadPage$suspendImpl(MainAPI mainAPI, String str, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object quickSearch$suspendImpl(MainAPI mainAPI, String str, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object load$suspendImpl(MainAPI mainAPI, String str, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object extractorVerifierJob$suspendImpl(MainAPI mainAPI, String str, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    static /* synthetic */ Object loadLinks$suspendImpl(MainAPI mainAPI, String str, boolean z, Function1 function1, Function1 function12, Continuation continuation) {
        throw new Standard(null, 1, null);
    }
}
