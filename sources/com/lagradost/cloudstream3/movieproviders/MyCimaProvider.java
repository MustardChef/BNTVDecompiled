package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: MyCimaProvider.kt */
@Metadata(m108d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 JI\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u000e\u0010/\u001a\u0004\u0018\u00010\b*\u00020\bH\u0002J\u0013\u00100\u001a\u0004\u0018\u000101*\u00020\bH\u0002¢\u0006\u0002\u00102J\u000e\u00103\u001a\u0004\u0018\u00010-*\u000204H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MyCimaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "getImageURL", "getIntFromText", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "toSearchResponse", "Lorg/jsoup/nodes/Element;", "MoreEPS", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MyCimaProvider extends MainAPI {
    private final boolean usesWebView;
    private String lang = "ar";
    private String mainUrl = "https://mycima.tv";
    private String name = "MyCima";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.TvSeries, TvType.Movie, TvType.Anime});

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

    private final String getImageURL(String str) {
        return new Regex("--im(age|g):url\\(|\\);").replace(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getIntFromText(String str) {
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
        String attr;
        Elements select = element.select("div.Thumb--GridItem a");
        Elements select2 = element.select("span.BG--GridItem");
        String imageURL = (select2 == null || (attr = select2.attr("data-lazy-style")) == null) ? null : getImageURL(attr);
        Elements select3 = element.select("div.GridItem span.year");
        String text = select3 != null ? select3.text() : null;
        String text2 = element.select("div.Thumb--GridItem strong").text();
        Intrinsics.checkNotNullExpressionValue(text2, "select(\"div.Thumb--GridItem strong\").text()");
        String replace$default = StringsKt.replace$default(new Regex("مشاهدة|فيلم|مسلسل|مترجم").replace(StringsKt.replace$default(text2, String.valueOf(text), "", false, 4, (Object) null), ""), "( نسخة مدبلجة )", " ( نسخة مدبلجة ) ", false, 4, (Object) null);
        String attr2 = select.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr2, "url.attr(\"href\")");
        String name = getName();
        String attr3 = select.attr("title");
        Intrinsics.checkNotNullExpressionValue(attr3, "url.attr(\"title\")");
        return new MovieSearchResponse(replace$default, attr2, name, StringsKt.contains$default((CharSequence) attr3, (CharSequence) "فيلم", false, 2, (Object) null) ? TvType.Movie : TvType.TvSeries, imageURL, text != null ? getIntFromText(text) : null, null, null, null, 384, null);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        return new HomePageResponse(CollectionsKt.sortedWith(ParCollections.apmap(CollectionsKt.listOf((Object[]) new Tuples[]{TuplesKt.m100to("Movies", getMainUrl() + "/movies/page/" + RangesKt.random(new IntRange(0, 25), Random.Default)), TuplesKt.m100to("Series", getMainUrl() + "/seriestv/new/page/" + RangesKt.random(new IntRange(0, 25), Random.Default))}), new MyCimaProvider$getMainPage$pages$1(this, null)), new Comparator() { // from class: com.lagradost.cloudstream3.movieproviders.MyCimaProvider$getMainPage$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((HomePageList) t).getName(), ((HomePageList) t2).getName());
            }
        }), null, null, null, null, 30, null);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        String replace$default = StringsKt.replace$default(str, " ", "%20", false, 4, (Object) null);
        ArrayList arrayList = new ArrayList();
        ParCollections.apmap(CollectionsKt.listOf((Object[]) new String[]{getMainUrl() + "/search/" + replace$default, getMainUrl() + "/search/" + replace$default + "/list/series/", getMainUrl() + "/search/" + replace$default + "/list/anime/"}), new MyCimaProvider$search$2(this, arrayList, null));
        return CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList), new Comparator() { // from class: com.lagradost.cloudstream3.movieproviders.MyCimaProvider$search$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SearchResponse) t).getName(), ((SearchResponse) t2).getName());
            }
        });
    }

    /* compiled from: MyCimaProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/MyCimaProvider$MoreEPS;", "", AgentOptions.OUTPUT, "", "(Ljava/lang/String;)V", "getOutput", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MoreEPS {
        private final String output;

        public static /* synthetic */ MoreEPS copy$default(MoreEPS moreEPS, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = moreEPS.output;
            }
            return moreEPS.copy(str);
        }

        public final String component1() {
            return this.output;
        }

        public final MoreEPS copy(String output) {
            Intrinsics.checkNotNullParameter(output, "output");
            return new MoreEPS(output);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MoreEPS) && Intrinsics.areEqual(this.output, ((MoreEPS) obj).output);
        }

        public int hashCode() {
            return this.output.hashCode();
        }

        public String toString() {
            return "MoreEPS(output=" + this.output + ')';
        }

        public MoreEPS(String output) {
            Intrinsics.checkNotNullParameter(output, "output");
            this.output = output;
        }

        public final String getOutput() {
            return this.output;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e4 A[LOOP:1: B:74:0x01de->B:76:0x01e4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024e  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r30, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r31) {
        /*
            Method dump skipped, instructions count: 1233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.MyCimaProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r32, boolean r33, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r34, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r35, kotlin.coroutines.Continuation<? super java.lang.Boolean> r36) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.MyCimaProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
