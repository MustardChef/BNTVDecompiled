package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: CimaNowProvider.kt */
@Metadata(m108d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 JI\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0013\u0010/\u001a\u0004\u0018\u000100*\u00020\bH\u0002¢\u0006\u0002\u00101J\u000e\u00102\u001a\u0004\u0018\u00010-*\u000203H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/CimaNowProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "getIntFromText", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toSearchResponse", "Lorg/jsoup/nodes/Element;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class CimaNowProvider extends MainAPI {
    private final boolean usesWebView;
    private String lang = "ar";
    private String mainUrl = "https://cimanow.cc";
    private String name = "CimaNow";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.TvSeries, TvType.Movie});

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
    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final Integer getIntFromText(String str) {
        List<String> groupValues;
        String str2;
        MatchResult find$default = Regex.find$default(new Regex("\\d+"), str, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) groupValues)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResponse(Element element) {
        Elements select;
        boolean contains$default;
        String text;
        String url = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Elements select2 = element.select("img");
        String attr = select2 != null ? select2.attr("data-src") : null;
        String html = element.select("li[aria-label=\"title\"]").html();
        Intrinsics.checkNotNullExpressionValue(html, "select(\"li[aria-label=\\\"title\\\"]\").html()");
        String replace$default = StringsKt.replace$default(new Regex(" <em>.*|\\\\n").replace(html, ""), "&nbsp;", "", false, 4, (Object) null);
        String text2 = element.select("li[aria-label=\"year\"]").text();
        Intrinsics.checkNotNullExpressionValue(text2, "select(\"li[aria-label=\\\"year\\\"]\").text()");
        Integer intOrNull = StringsKt.toIntOrNull(text2);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        TvType tvType = new Regex("فيلم|مسرحية|حفلات").containsMatchIn(url) ? TvType.Movie : TvType.TvSeries;
        Element first = element.select("li[aria-label=\"ribbon\"]").first();
        String replace = (first == null || (text = first.text()) == null) ? null : new Regex(" |-|1080|720").replace(text, "");
        Intrinsics.checkNotNullExpressionValue(element.select("li[aria-label=\"ribbon\"]:nth-child(2)"), "select(\"li[aria-label=\\\"ribbon\\\"]:nth-child(2)\")");
        if (!select.isEmpty()) {
            String text3 = element.select("li[aria-label=\"ribbon\"]:nth-child(2)").text();
            Intrinsics.checkNotNullExpressionValue(text3, "select(\"li[aria-label=\\\"…\\\"]:nth-child(2)\").text()");
            contains$default = StringsKt.contains$default((CharSequence) text3, (CharSequence) "مدبلج", false, 2, (Object) null);
        } else {
            String text4 = element.select("li[aria-label=\"ribbon\"]:nth-child(1)").text();
            Intrinsics.checkNotNullExpressionValue(text4, "select(\"li[aria-label=\\\"…\\\"]:nth-child(1)\").text()");
            contains$default = StringsKt.contains$default((CharSequence) text4, (CharSequence) "مدبلج", false, 2, (Object) null);
        }
        if (contains$default) {
            replace$default = replace$default + " (مدبلج)";
        }
        return new MovieSearchResponse(replace$default + ' ' + element.select("li[aria-label=\"ribbon\"]:contains(الموسم)").text(), url, getName(), tvType, attr, intOrNull, null, MainAPIKt.getQualityFromString(replace), null, 256, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$1 r2 = (com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$1 r2 = new com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.CimaNowProvider r2 = (com.lagradost.cloudstream3.movieproviders.CimaNowProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L87
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r1
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r19.getMainUrl()
            r1.append(r5)
            java.lang.String r5 = "/home"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "user-agent"
            java.lang.String r6 = "MONKE"
            kotlin.Pair r5 = kotlin.TuplesKt.m100to(r5, r6)
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 2044(0x7fc, float:2.864E-42)
            r18 = 0
            r2.L$0 = r0
            r2.label = r4
            r4 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L85
            return r1
        L85:
            r1 = r2
            r2 = r0
        L87:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            org.jsoup.nodes.Document r1 = r1.getDocument()
            java.lang.String r3 = "section"
            org.jsoup.select.Elements r1 = r1.select(r3)
            java.lang.String r3 = "section:contains(أختر وجهتك المفضلة)"
            org.jsoup.select.Elements r1 = r1.not(r3)
            java.lang.String r3 = "section:contains(تم اضافته حديثاً)"
            org.jsoup.select.Elements r1 = r1.not(r3)
            java.lang.String r3 = "doc.select(\"section\").no…tains(تم اضافته حديثاً)\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.List r1 = (java.util.List) r1
            com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$pages$1 r3 = new com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$pages$1
            r4 = 0
            r3.<init>(r2, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.util.List r5 = com.lagradost.cloudstream3.ParCollections.apmap(r1, r3)
            com.lagradost.cloudstream3.HomePageResponse r1 = new com.lagradost.cloudstream3.HomePageResponse
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 30
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CimaNowProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0151  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r26, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r27) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CimaNowProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0152 A[LOOP:0: B:39:0x014c->B:41:0x0152, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018e A[LOOP:1: B:44:0x017e->B:46:0x018e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e3 A[EDGE_INSN: B:57:0x01e3->B:47:0x01e3 ?: BREAK  , SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r34, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r35) {
        /*
            Method dump skipped, instructions count: 770
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CimaNowProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r22, boolean r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r24, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.CimaNowProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
