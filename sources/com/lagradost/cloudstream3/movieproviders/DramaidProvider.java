package com.lagradost.cloudstream3.movieproviders;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* compiled from: DramaidProvider.kt */
@Metadata(m108d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0003;<=B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001e\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0002JI\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020$0'2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$0'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0019\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.JI\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00042\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020$0'2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$0'H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u001f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.J\f\u00109\u001a\u000207*\u00020:H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperDramaLink", ShareConstants.MEDIA_URI, "invokeDriveSource", "", "url", "subCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "sourceCallback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "callback", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "Companion", "Sources", "Tracks", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class DramaidProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private final boolean hasChromecastSupport;
    private final boolean hasQuickSearch;
    private String mainUrl = "https://185.224.83.103";
    private String name = "DramaId";
    private final boolean hasMainPage = true;
    private String lang = "id";
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.AsianDrama);

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
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
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
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* compiled from: DramaidProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider$Companion;", "", "()V", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShowStatus getStatus(String t) {
            Intrinsics.checkNotNullParameter(t, "t");
            return Intrinsics.areEqual(t, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED) ? ShowStatus.Completed : Intrinsics.areEqual(t, "Ongoing") ? ShowStatus.Ongoing : ShowStatus.Completed;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r29) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.DramaidProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getProperDramaLink(String str) {
        List<String> groupValues;
        String str2 = str;
        String str3 = null;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "/series/", false, 2, (Object) null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getMainUrl());
        sb.append("/series/");
        MatchResult find$default = Regex.find$default(new Regex(getMainUrl() + "/(.+)-ep.+"), str2, 0, 2, null);
        if (find$default != null && (groupValues = find$default.getGroupValues()) != null) {
            str3 = groupValues.get(1);
        }
        sb.append(str3);
        return sb.toString();
    }

    private final SearchResponse toSearchResult(Element element) {
        Element selectFirst = element.selectFirst("a.tip");
        Intrinsics.checkNotNull(selectFirst);
        String attr = selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "this.selectFirst(\"a.tip\")!!.attr(\"href\")");
        String properDramaLink = getProperDramaLink(attr);
        Element selectFirst2 = element.selectFirst("h2[itemprop=headline]");
        Intrinsics.checkNotNull(selectFirst2);
        String text = selectFirst2.text();
        Intrinsics.checkNotNullExpressionValue(text, "this.selectFirst(\"h2[itemprop=headline]\")!!.text()");
        String obj = StringsKt.trim((CharSequence) text).toString();
        Element selectFirst3 = element.selectFirst(".limit > noscript > img");
        Intrinsics.checkNotNull(selectFirst3);
        return MainAPIKt.newTvSeriesSearchResponse$default(this, obj, properDramaLink, TvType.AsianDrama, false, new DramaidProvider$toSearchResult$1(selectFirst3.attr("src")), 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa A[LOOP:0: B:19:0x00a4->B:21:0x00aa, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.DramaidProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4 A[LOOP:0: B:19:0x00be->B:21:0x00c4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0185 A[LOOP:1: B:29:0x017d->B:31:0x0185, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0218 A[LOOP:2: B:33:0x0212->B:35:0x0218, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02ac  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r29, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r30) {
        /*
            Method dump skipped, instructions count: 707
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.DramaidProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DramaidProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider$Sources;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "type", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider$Sources;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sources {

        /* renamed from: default  reason: not valid java name */
        private final Boolean f10813default;
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ Sources copy$default(Sources sources, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.file;
            }
            if ((i & 2) != 0) {
                str2 = sources.label;
            }
            if ((i & 4) != 0) {
                str3 = sources.type;
            }
            if ((i & 8) != 0) {
                bool = sources.f10813default;
            }
            return sources.copy(str, str2, str3, bool);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.type;
        }

        public final Boolean component4() {
            return this.f10813default;
        }

        public final Sources copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type, @JsonProperty("default") Boolean bool) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Sources(file, label, type, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sources) {
                Sources sources = (Sources) obj;
                return Intrinsics.areEqual(this.file, sources.file) && Intrinsics.areEqual(this.label, sources.label) && Intrinsics.areEqual(this.type, sources.type) && Intrinsics.areEqual(this.f10813default, sources.f10813default);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.f10813default;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "Sources(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ", default=" + this.f10813default + ')';
        }

        public Sources(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("type") String type, @JsonProperty("default") Boolean bool) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            this.file = file;
            this.label = label;
            this.type = type;
            this.f10813default = bool;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getType() {
            return this.type;
        }

        public final Boolean getDefault() {
            return this.f10813default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DramaidProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider$Tracks;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "type", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/movieproviders/DramaidProvider$Tracks;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Tracks {

        /* renamed from: default  reason: not valid java name */
        private final Boolean f10814default;
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ Tracks copy$default(Tracks tracks, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tracks.file;
            }
            if ((i & 2) != 0) {
                str2 = tracks.label;
            }
            if ((i & 4) != 0) {
                str3 = tracks.type;
            }
            if ((i & 8) != 0) {
                bool = tracks.f10814default;
            }
            return tracks.copy(str, str2, str3, bool);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.type;
        }

        public final Boolean component4() {
            return this.f10814default;
        }

        public final Tracks copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("kind") String type, @JsonProperty("default") Boolean bool) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Tracks(file, label, type, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tracks) {
                Tracks tracks = (Tracks) obj;
                return Intrinsics.areEqual(this.file, tracks.file) && Intrinsics.areEqual(this.label, tracks.label) && Intrinsics.areEqual(this.type, tracks.type) && Intrinsics.areEqual(this.f10814default, tracks.f10814default);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.type.hashCode()) * 31;
            Boolean bool = this.f10814default;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "Tracks(file=" + this.file + ", label=" + this.label + ", type=" + this.type + ", default=" + this.f10814default + ')';
        }

        public Tracks(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("kind") String type, @JsonProperty("default") Boolean bool) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(type, "type");
            this.file = file;
            this.label = label;
            this.type = type;
            this.f10814default = bool;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getType() {
            return this.type;
        }

        public final Boolean getDefault() {
            return this.f10814default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeDriveSource(java.lang.String r26, java.lang.String r27, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r28, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.DramaidProvider.invokeDriveSource(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0106 A[LOOP:1: B:25:0x0100->B:27:0x0106, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r21, boolean r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r23, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.DramaidProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
