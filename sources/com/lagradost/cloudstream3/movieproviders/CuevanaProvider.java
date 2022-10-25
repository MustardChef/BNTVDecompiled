package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CuevanaProvider.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001c\u001a\u00020\u001dH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"JI\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020)0'H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/CuevanaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "Femcuevana", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class CuevanaProvider extends MainAPI {
    private String mainUrl = "https://cuevana3.me";
    private String name = "Cuevana";
    private String lang = "es";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

    /* compiled from: CuevanaProvider.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TvType.values().length];
            iArr[TvType.TvSeries.ordinal()] = 1;
            iArr[TvType.Movie.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

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
    public String getLang() {
        return this.lang;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:10|(3:11|12|13)|14|15|(16:18|19|20|21|22|23|24|25|26|27|(1:29)(1:52)|30|31|32|33|16)|64|65|37|38|(3:40|41|(1:43)(9:45|14|15|(1:16)|64|65|37|38|(2:46|(2:48|49)(2:50|51))(0)))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0364, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0365, code lost:
        r39 = r2;
        r31 = r3;
        r34 = r4;
        r32 = r5;
        r11 = r53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0181 A[LOOP:1: B:25:0x017b->B:27:0x0181, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02a1 A[Catch: Exception -> 0x0364, TRY_LEAVE, TryCatch #3 {Exception -> 0x0364, blocks: (B:36:0x0277, B:37:0x029b, B:39:0x02a1, B:32:0x023d), top: B:80:0x0277 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0386  */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0274 -> B:80:0x0277). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r72) {
        /*
            Method dump skipped, instructions count: 934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CuevanaProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CuevanaProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0229 A[LOOP:2: B:71:0x0223->B:73:0x0229, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d9  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r43, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r44) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CuevanaProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: CuevanaProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/CuevanaProvider$Femcuevana;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Femcuevana {
        private final String url;

        public static /* synthetic */ Femcuevana copy$default(Femcuevana femcuevana, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = femcuevana.url;
            }
            return femcuevana.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Femcuevana copy(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Femcuevana(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Femcuevana) && Intrinsics.areEqual(this.url, ((Femcuevana) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Femcuevana(url=" + this.url + ')';
        }

        public Femcuevana(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r25
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$1 r2 = (com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$1 r2 = new com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r14 = 1
            if (r3 == 0) goto L4b
            if (r3 != r14) goto L43
            java.lang.Object r3 = r2.L$3
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Object r4 = r2.L$2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r2.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.CuevanaProvider r2 = (com.lagradost.cloudstream3.movieproviders.CuevanaProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r7 = r3
            r6 = r4
            r19 = 1
            r4 = r2
            goto L8f
        L43:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L4b:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r1
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r1 = 0
            r16 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r2.L$0 = r0
            r4 = r21
            r2.L$1 = r4
            r22 = r15
            r15 = r23
            r2.L$2 = r15
            r15 = r24
            r2.L$3 = r15
            r2.label = r14
            r19 = 1
            r14 = r1
            r1 = r22
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L87
            return r1
        L87:
            r5 = r21
            r6 = r23
            r7 = r24
            r4 = r0
            r1 = r2
        L8f:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.lang.String r2 = "div.TPlayer.embed_div iframe"
            org.jsoup.select.Elements r1 = r1.select(r2)
            java.lang.String r2 = "app.get(data).document.s…Player.embed_div iframe\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.List r1 = (java.util.List) r1
            com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2 r2 = new com.lagradost.cloudstream3.movieproviders.CuevanaProvider$loadLinks$2
            r8 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.lagradost.cloudstream3.ParCollections.apmap(r1, r2)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CuevanaProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
