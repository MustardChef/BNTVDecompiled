package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.PageResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.subtitleproviders.SubtitleApi;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* compiled from: APIRepository.kt */
@Metadata(m108d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001c2\u0006\u0010!\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJI\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\n2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00180&2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180&H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001c2\u0006\u0010!\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u001c2\u0006\u00100\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0\u001c2\u0006\u00100\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/APIRepository;", "", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "subtitleApi", "Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleApi;", "(Lcom/lagradost/cloudstream3/MainAPI;Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleApi;)V", "getApi", "()Lcom/lagradost/cloudstream3/MainAPI;", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "getSubtitleApi", "()Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleApi;", "extractorVerifierJob", "", "extractorData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPage", "Lcom/lagradost/cloudstream3/PageResponse;", "quickSearch", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.APIRepository */
/* loaded from: classes.dex */
public final class APIRepository {
    public static final Companion Companion = new Companion(null);
    private static HashSet<DubStatus> dubStatusActive = new HashSet<>();
    private static final MainAPI noneApi = new MainAPI() { // from class: com.lagradost.cloudstream3.ui.APIRepository$Companion$noneApi$1
        private String name = "None";
        private final Set<TvType> supportedTypes = SetsKt.emptySet();
        private String lang = "";

        @Override // com.lagradost.cloudstream3.MainAPI
        public String getName() {
            return this.name;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public Set<TvType> getSupportedTypes() {
            return this.supportedTypes;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public String getLang() {
            return this.lang;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public void setLang(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lang = str;
        }
    };
    private static final MainAPI randomApi = new MainAPI() { // from class: com.lagradost.cloudstream3.ui.APIRepository$Companion$randomApi$1
        private String name = "Random";
        private final Set<TvType> supportedTypes = SetsKt.emptySet();
        private String lang = "";

        @Override // com.lagradost.cloudstream3.MainAPI
        public String getName() {
            return this.name;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public Set<TvType> getSupportedTypes() {
            return this.supportedTypes;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public String getLang() {
            return this.lang;
        }

        @Override // com.lagradost.cloudstream3.MainAPI
        public void setLang(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lang = str;
        }
    };
    private final MainAPI api;
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;
    private final String mainUrl;
    private final String name;
    private final SubtitleApi subtitleApi;

    /* compiled from: APIRepository.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/APIRepository$Companion;", "", "()V", "dubStatusActive", "Ljava/util/HashSet;", "Lcom/lagradost/cloudstream3/DubStatus;", "Lkotlin/collections/HashSet;", "getDubStatusActive", "()Ljava/util/HashSet;", "setDubStatusActive", "(Ljava/util/HashSet;)V", "noneApi", "Lcom/lagradost/cloudstream3/MainAPI;", "getNoneApi", "()Lcom/lagradost/cloudstream3/MainAPI;", "randomApi", "getRandomApi", "isInvalidData", "", "data", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.APIRepository$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashSet<DubStatus> getDubStatusActive() {
            return APIRepository.dubStatusActive;
        }

        public final void setDubStatusActive(HashSet<DubStatus> hashSet) {
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            APIRepository.dubStatusActive = hashSet;
        }

        public final MainAPI getNoneApi() {
            return APIRepository.noneApi;
        }

        public final MainAPI getRandomApi() {
            return APIRepository.randomApi;
        }

        public final boolean isInvalidData(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return (data.length() == 0) || Intrinsics.areEqual(data, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) || Intrinsics.areEqual(data, "about:blank");
        }
    }

    public APIRepository(MainAPI api, SubtitleApi subtitleApi) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
        this.subtitleApi = subtitleApi;
        this.hasMainPage = api.getHasMainPage();
        this.name = api.getName();
        this.mainUrl = api.getMainUrl();
        this.hasQuickSearch = api.getHasQuickSearch();
    }

    public /* synthetic */ APIRepository(MainAPI mainAPI, SubtitleApi subtitleApi, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mainAPI, (i & 2) != 0 ? null : subtitleApi);
    }

    public final MainAPI getApi() {
        return this.api;
    }

    public final SubtitleApi getSubtitleApi() {
        return this.subtitleApi;
    }

    public final boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public final Object load(String str, Continuation<? super Resource<? extends LoadResponse>> continuation) {
        if (Companion.isInvalidData(str)) {
            throw new ErrorLoadingException(null, 1, null);
        }
        return ArchComponentExt.safeApiCall(new APIRepository$load$2(this, str, null), continuation);
    }

    public final Object search(String str, Continuation<? super Resource<? extends List<? extends SearchResponse>>> continuation) {
        if (str.length() == 0) {
            return new Resource.Success(CollectionsKt.emptyList());
        }
        return ArchComponentExt.safeApiCall(new APIRepository$search$2(this, str, null), continuation);
    }

    public final Object loadPage(String str, Continuation<? super Resource<PageResponse>> continuation) {
        return ArchComponentExt.safeApiCall(new APIRepository$loadPage$2(this, str, null), continuation);
    }

    public final Object quickSearch(String str, Continuation<? super Resource<? extends List<? extends SearchResponse>>> continuation) {
        if (str.length() == 0) {
            return new Resource.Success(CollectionsKt.emptyList());
        }
        return ArchComponentExt.safeApiCall(new APIRepository$quickSearch$2(this, str, null), continuation);
    }

    public final Object getMainPage(Continuation<? super Resource<HomePageResponse>> continuation) {
        return ArchComponentExt.safeApiCall(new APIRepository$getMainPage$2(this, null), continuation);
    }

    public final Object extractorVerifierJob(String str, Continuation<? super Unit> continuation) {
        Object safeApiCall = ArchComponentExt.safeApiCall(new APIRepository$extractorVerifierJob$2(this, str, null), continuation);
        return safeApiCall == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? safeApiCall : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadLinks(java.lang.String r9, boolean r10, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r11, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.lagradost.cloudstream3.p041ui.APIRepository$loadLinks$1
            if (r0 == 0) goto L14
            r0 = r13
            com.lagradost.cloudstream3.ui.APIRepository$loadLinks$1 r0 = (com.lagradost.cloudstream3.p041ui.APIRepository$loadLinks$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.lagradost.cloudstream3.ui.APIRepository$loadLinks$1 r0 = new com.lagradost.cloudstream3.ui.APIRepository$loadLinks$1
            r0.<init>(r8, r13)
        L19:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L2c
            goto L59
        L2c:
            r9 = move-exception
            goto L64
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r13)
            com.lagradost.cloudstream3.ui.APIRepository$Companion r13 = com.lagradost.cloudstream3.p041ui.APIRepository.Companion
            boolean r13 = r13.isInvalidData(r9)
            if (r13 == 0) goto L46
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r7)
            return r9
        L46:
            com.lagradost.cloudstream3.MainAPI r1 = r8.api     // Catch: java.lang.Throwable -> L2c
            if (r10 == 0) goto L4c
            r3 = 1
            goto L4d
        L4c:
            r3 = 0
        L4d:
            r6.label = r2     // Catch: java.lang.Throwable -> L2c
            r2 = r9
            r4 = r11
            r5 = r12
            java.lang.Object r13 = r1.loadLinks(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2c
            if (r13 != r0) goto L59
            return r0
        L59:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Throwable -> L2c
            boolean r9 = r13.booleanValue()     // Catch: java.lang.Throwable -> L2c
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r9)
            return r9
        L64:
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.APIRepository.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
