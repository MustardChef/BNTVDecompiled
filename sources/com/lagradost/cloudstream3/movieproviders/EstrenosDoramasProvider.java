package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: EstrenosDoramasProvider.kt */
@Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u000278B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002J\u0011\u0010'\u001a\u00020(H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,JI\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00042\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020$0\"2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u00102J\u001f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010,R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/EstrenosDoramasProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "cleanExtractor", "source", "url", "referer", "m3u8", "callback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "", "cleanTitle", "title", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "Companion", "ReproDoramas", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class EstrenosDoramasProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private String mainUrl = "https://www23.estrenosdoramas.net";
    private String name = "EstrenosDoramas";
    private String lang = "es";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.AsianDrama);

    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TvType.values().length];
            iArr[TvType.AsianDrama.ordinal()] = 1;
            iArr[TvType.Movie.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/EstrenosDoramasProvider$Companion;", "", "()V", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TvType getType(String t) {
            Intrinsics.checkNotNullParameter(t, "t");
            String str = t;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "OVA", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "Especial", false, 2, (Object) null)) {
                return TvType.OVA;
            }
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "Pelicula", false, 2, (Object) null) ? TvType.Movie : TvType.TvSeries;
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

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(getMainUrl(), "Últimas series"), new Tuples(getMainUrl() + "/category/peliculas", "Películas")});
        ArrayList arrayList = new ArrayList();
        ParCollections.apmap(listOf, new EstrenosDoramasProvider$getMainPage$2(arrayList, this, null));
        if (arrayList.size() <= 0) {
            throw new ErrorLoadingException(null, 1, null);
        }
        return new HomePageResponse(arrayList, null, null, null, null, 30, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r25, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r26) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|(2:3|(19:5|6|(1:(1:9)(2:64|65))(2:66|(1:68)(1:69))|10|(1:12)(1:63)|13|(1:15)(1:62)|16|17|(1:19)(1:60)|20|(1:58)(1:26)|27|(8:30|(1:32)(1:43)|33|(1:35)(1:42)|36|(2:38|39)(1:41)|40|28)|44|45|(1:47)(1:57)|48|(1:(1:54)(2:51|52))(2:55|56)))|70|6|(0)(0)|10|(0)(0)|13|(0)(0)|16|17|(0)(0)|20|(1:22)|58|27|(1:28)|44|45|(0)(0)|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
        r7 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a6, blocks: (B:26:0x0097, B:28:0x009f), top: B:67:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a2  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r41, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r42) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: EstrenosDoramasProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/EstrenosDoramasProvider$ReproDoramas;", "", "link", "", "time", "", "(Ljava/lang/String;I)V", "getLink", "()Ljava/lang/String;", "getTime", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ReproDoramas {
        private final String link;
        private final int time;

        public static /* synthetic */ ReproDoramas copy$default(ReproDoramas reproDoramas, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = reproDoramas.link;
            }
            if ((i2 & 2) != 0) {
                i = reproDoramas.time;
            }
            return reproDoramas.copy(str, i);
        }

        public final String component1() {
            return this.link;
        }

        public final int component2() {
            return this.time;
        }

        public final ReproDoramas copy(@JsonProperty("link") String link, @JsonProperty("time") int i) {
            Intrinsics.checkNotNullParameter(link, "link");
            return new ReproDoramas(link, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReproDoramas) {
                ReproDoramas reproDoramas = (ReproDoramas) obj;
                return Intrinsics.areEqual(this.link, reproDoramas.link) && this.time == reproDoramas.time;
            }
            return false;
        }

        public int hashCode() {
            return (this.link.hashCode() * 31) + this.time;
        }

        public String toString() {
            return "ReproDoramas(link=" + this.link + ", time=" + this.time + ')';
        }

        public ReproDoramas(@JsonProperty("link") String link, @JsonProperty("time") int i) {
            Intrinsics.checkNotNullParameter(link, "link");
            this.link = link;
            this.time = i;
        }

        public final String getLink() {
            return this.link;
        }

        public final int getTime() {
            return this.time;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cleanTitle(String str) {
        return new Regex("[Pp]elicula |[Pp]elicula").replace(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean cleanExtractor(String str, String str2, String str3, String str4, boolean z, Function1<? super ExtractorLink, Unit> function1) {
        function1.invoke(new ExtractorLink(str, str2, str3, str4, Qualities.Unknown.getValue(), z, null, null, 192, null));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r23, boolean r24, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r25, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
