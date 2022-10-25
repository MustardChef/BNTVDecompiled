package com.lagradost.cloudstream3.movieproviders;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 :2\u00020\u0001:\u0005:;<=>B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$JI\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\"0/2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\"0/H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J\u001f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\f\u00108\u001a\u000206*\u000209H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "usesWebView", "getUsesWebView", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "extractorVerifierJob", "", "extractorData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toSearchResult", "Lorg/jsoup/nodes/Element;", "Companion", "IframeJson", "SourceObject", "Sources", "Tracks", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class SflixProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private final boolean hasQuickSearch;
    private String mainUrl = "https://sflix.to";
    private String name = "Sflix.to";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final boolean usesWebView = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});
    private final VPNStatus vpnStatus = VPNStatus.None;

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object extractorVerifierJob(String str, Continuation<? super Unit> continuation) {
        return extractorVerifierJob$suspendImpl(this, str, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object load(String str, Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, (Function1) function1, (Function1) function12, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, (Continuation) continuation);
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
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
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
    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public VPNStatus getVpnStatus() {
        return this.vpnStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.getMainPage$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object search$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider r19, java.lang.String r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.search$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0450 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d5  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v23, types: [T] */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [T] */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37, types: [T] */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object load$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider r59, java.lang.String r60, kotlin.coroutines.Continuation r61) {
        /*
            Method dump skipped, instructions count: 1802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.load$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Tracks;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "kind", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKind", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Tracks {
        private final String file;
        private final String kind;
        private final String label;

        public static /* synthetic */ Tracks copy$default(Tracks tracks, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tracks.file;
            }
            if ((i & 2) != 0) {
                str2 = tracks.label;
            }
            if ((i & 4) != 0) {
                str3 = tracks.kind;
            }
            return tracks.copy(str, str2, str3);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.kind;
        }

        public final Tracks copy(@JsonProperty("file") String str, @JsonProperty("label") String str2, @JsonProperty("kind") String str3) {
            return new Tracks(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tracks) {
                Tracks tracks = (Tracks) obj;
                return Intrinsics.areEqual(this.file, tracks.file) && Intrinsics.areEqual(this.label, tracks.label) && Intrinsics.areEqual(this.kind, tracks.kind);
            }
            return false;
        }

        public int hashCode() {
            String str = this.file;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.label;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.kind;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Tracks(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Tracks(@JsonProperty("file") String str, @JsonProperty("label") String str2, @JsonProperty("kind") String str3) {
            this.file = str;
            this.label = str2;
            this.kind = str3;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getKind() {
            return this.kind;
        }
    }

    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Sources;", "", "file", "", "type", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Sources {
        private final String file;
        private final String label;
        private final String type;

        public static /* synthetic */ Sources copy$default(Sources sources, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sources.file;
            }
            if ((i & 2) != 0) {
                str2 = sources.type;
            }
            if ((i & 4) != 0) {
                str3 = sources.label;
            }
            return sources.copy(str, str2, str3);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.label;
        }

        public final Sources copy(@JsonProperty("file") String str, @JsonProperty("type") String str2, @JsonProperty("label") String str3) {
            return new Sources(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sources) {
                Sources sources = (Sources) obj;
                return Intrinsics.areEqual(this.file, sources.file) && Intrinsics.areEqual(this.type, sources.type) && Intrinsics.areEqual(this.label, sources.label);
            }
            return false;
        }

        public int hashCode() {
            String str = this.file;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.label;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Sources(file=" + this.file + ", type=" + this.type + ", label=" + this.label + ')';
        }

        public Sources(@JsonProperty("file") String str, @JsonProperty("type") String str2, @JsonProperty("label") String str3) {
            this.file = str;
            this.type = str2;
            this.label = str3;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getType() {
            return this.type;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0012\b\u0001\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0001\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0001\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0001\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0001\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0003HÆ\u0003Jm\u0010\u0016\u001a\u00020\u00002\u0012\b\u0003\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0003\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0003\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0003\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0003\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$SourceObject;", "", "sources", "", "Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Sources;", "sources1", "sources2", "sourcesBackup", "tracks", "Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Tracks;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getSources1", "getSources2", "getSourcesBackup", "getTracks", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SourceObject {
        private final List<Sources> sources;
        private final List<Sources> sources1;
        private final List<Sources> sources2;
        private final List<Sources> sourcesBackup;
        private final List<Tracks> tracks;

        public static /* synthetic */ SourceObject copy$default(SourceObject sourceObject, List list, List list2, List list3, List list4, List list5, int i, Object obj) {
            List<Sources> list6 = list;
            if ((i & 1) != 0) {
                list6 = sourceObject.sources;
            }
            List<Sources> list7 = list2;
            if ((i & 2) != 0) {
                list7 = sourceObject.sources1;
            }
            List list8 = list7;
            List<Sources> list9 = list3;
            if ((i & 4) != 0) {
                list9 = sourceObject.sources2;
            }
            List list10 = list9;
            List<Sources> list11 = list4;
            if ((i & 8) != 0) {
                list11 = sourceObject.sourcesBackup;
            }
            List list12 = list11;
            List<Tracks> list13 = list5;
            if ((i & 16) != 0) {
                list13 = sourceObject.tracks;
            }
            return sourceObject.copy(list6, list8, list10, list12, list13);
        }

        public final List<Sources> component1() {
            return this.sources;
        }

        public final List<Sources> component2() {
            return this.sources1;
        }

        public final List<Sources> component3() {
            return this.sources2;
        }

        public final List<Sources> component4() {
            return this.sourcesBackup;
        }

        public final List<Tracks> component5() {
            return this.tracks;
        }

        public final SourceObject copy(@JsonProperty("sources") List<Sources> list, @JsonProperty("sources_1") List<Sources> list2, @JsonProperty("sources_2") List<Sources> list3, @JsonProperty("sourcesBackup") List<Sources> list4, @JsonProperty("tracks") List<Tracks> list5) {
            return new SourceObject(list, list2, list3, list4, list5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SourceObject) {
                SourceObject sourceObject = (SourceObject) obj;
                return Intrinsics.areEqual(this.sources, sourceObject.sources) && Intrinsics.areEqual(this.sources1, sourceObject.sources1) && Intrinsics.areEqual(this.sources2, sourceObject.sources2) && Intrinsics.areEqual(this.sourcesBackup, sourceObject.sourcesBackup) && Intrinsics.areEqual(this.tracks, sourceObject.tracks);
            }
            return false;
        }

        public int hashCode() {
            List<Sources> list = this.sources;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<Sources> list2 = this.sources1;
            int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<Sources> list3 = this.sources2;
            int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
            List<Sources> list4 = this.sourcesBackup;
            int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
            List<Tracks> list5 = this.tracks;
            return hashCode4 + (list5 != null ? list5.hashCode() : 0);
        }

        public String toString() {
            return "SourceObject(sources=" + this.sources + ", sources1=" + this.sources1 + ", sources2=" + this.sources2 + ", sourcesBackup=" + this.sourcesBackup + ", tracks=" + this.tracks + ')';
        }

        public SourceObject(@JsonProperty("sources") List<Sources> list, @JsonProperty("sources_1") List<Sources> list2, @JsonProperty("sources_2") List<Sources> list3, @JsonProperty("sourcesBackup") List<Sources> list4, @JsonProperty("tracks") List<Tracks> list5) {
            this.sources = list;
            this.sources1 = list2;
            this.sources2 = list3;
            this.sourcesBackup = list4;
            this.tracks = list5;
        }

        public final List<Sources> getSources() {
            return this.sources;
        }

        public final List<Sources> getSources1() {
            return this.sources1;
        }

        public final List<Sources> getSources2() {
            return this.sources2;
        }

        public final List<Sources> getSourcesBackup() {
            return this.sourcesBackup;
        }

        public final List<Tracks> getTracks() {
            return this.tracks;
        }
    }

    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$IframeJson;", "", "link", "", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class IframeJson {
        private final String link;

        public IframeJson() {
            this(null, 1, null);
        }

        public static /* synthetic */ IframeJson copy$default(IframeJson iframeJson, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iframeJson.link;
            }
            return iframeJson.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final IframeJson copy(@JsonProperty("link") String str) {
            return new IframeJson(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IframeJson) && Intrinsics.areEqual(this.link, ((IframeJson) obj).link);
        }

        public int hashCode() {
            String str = this.link;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "IframeJson(link=" + this.link + ')';
        }

        public IframeJson(@JsonProperty("link") String str) {
            this.link = str;
        }

        public /* synthetic */ IframeJson(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getLink() {
            return this.link;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider r25, java.lang.String r26, boolean r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.loadLinks$suspendImpl(com.lagradost.cloudstream3.movieproviders.SflixProvider, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object extractorVerifierJob$suspendImpl(SflixProvider sflixProvider, String str, Continuation continuation) {
        Object runSflixExtractorVerifierJob = Companion.runSflixExtractorVerifierJob(sflixProvider, str, "https://rabbitstream.net/", continuation);
        return runSflixExtractorVerifierJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? runSflixExtractorVerifierJob : Unit.INSTANCE;
    }

    private final SearchResponse toSearchResult(Element element) {
        List emptyList;
        String text;
        String obj;
        Integer intOrNull;
        Integer num;
        SearchQuality searchQuality;
        String text2;
        String obj2;
        String text3;
        String obj3;
        Elements select;
        Element selectFirst = element.selectFirst("div.film-poster");
        Intrinsics.checkNotNull(selectFirst);
        Elements select2 = selectFirst.select("img");
        String title = select2.attr("title");
        String attr = select2.attr("data-src");
        String attr2 = attr == null ? select2.attr("src") : attr;
        String attr3 = selectFirst.select("a").attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr3, "inner.select(\"a\").attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(this, attr3);
        Integer num2 = null;
        boolean contains$default = StringsKt.contains$default((CharSequence) fixUrl, (CharSequence) "/movie/", false, 2, (Object) null);
        Element selectFirst2 = element.selectFirst("div.film-detail > div.fd-infor");
        if (selectFirst2 == null || (select = selectFirst2.select(TtmlNode.TAG_SPAN)) == null || (emptyList = CollectionsKt.toList(select)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        int size = emptyList.size();
        if (size == 1) {
            Element element2 = (Element) emptyList.get(0);
            if (element2 != null && (text = element2.text()) != null && (obj = StringsKt.trim((CharSequence) text).toString()) != null) {
                intOrNull = StringsKt.toIntOrNull(obj);
                num = intOrNull;
                searchQuality = null;
            }
            intOrNull = null;
            num = intOrNull;
            searchQuality = null;
        } else if (size == 2) {
            Element element3 = (Element) emptyList.get(0);
            if (element3 != null && (text2 = element3.text()) != null && (obj2 = StringsKt.trim((CharSequence) text2).toString()) != null) {
                intOrNull = StringsKt.toIntOrNull(obj2);
                num = intOrNull;
                searchQuality = null;
            }
            intOrNull = null;
            num = intOrNull;
            searchQuality = null;
        } else if (size != 3) {
            num = null;
            searchQuality = null;
        } else {
            Element element4 = (Element) emptyList.get(1);
            SearchQuality qualityFromString = MainAPIKt.getQualityFromString(element4 != null ? element4.text() : null);
            Element element5 = (Element) emptyList.get(2);
            if (element5 != null && (text3 = element5.text()) != null && (obj3 = StringsKt.trim((CharSequence) text3).toString()) != null) {
                num2 = StringsKt.toIntOrNull(obj3);
            }
            searchQuality = qualityFromString;
            num = num2;
        }
        if (contains$default) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            return new MovieSearchResponse(title, fixUrl, getName(), TvType.Movie, attr2, num, null, searchQuality, null, 320, null);
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return new TvSeriesSearchResponse(title, fixUrl, getName(), TvType.Movie, attr2, num, null, null, searchQuality, null, 640, null);
    }

    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J5\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018Jo\u0010\u0019\u001a\u0004\u0018\u00010\u0015*\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00150\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00150\u001c2\u0006\u0010 \u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\f\u0010#\u001a\u00020\b*\u0004\u0018\u00010\u0004J0\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010%*\u00020&2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u001d*\u00020*H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Companion;", "", "()V", "generateTimeStamp", "", "getUpdatedData", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Companion$PollingData;", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "data", "baseUrl", "(Lcom/lagradost/nicehttp/NiceResponse;Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Companion$PollingData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initPolling", "extractorData", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "negotiateNewSid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runSflixExtractorVerifierJob", "", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractRabbitStream", "url", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "useSidAuthentication", "nameTransformer", "(Lcom/lagradost/cloudstream3/MainAPI;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isValidServer", "toExtractorLink", "", "Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Sources;", "caller", "name", "toSubtitleFile", "Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Tracks;", "PollingData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: SflixProvider.kt */
        @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJB\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Companion$PollingData;", "", "sid", "", "upgrades", "Ljava/util/ArrayList;", "pingInterval", "", "pingTimeout", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPingInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPingTimeout", "getSid", "()Ljava/lang/String;", "getUpgrades", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SflixProvider$Companion$PollingData;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class PollingData {
            private final Integer pingInterval;
            private final Integer pingTimeout;
            private final String sid;
            private final ArrayList<String> upgrades;

            public PollingData() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PollingData copy$default(PollingData pollingData, String str, ArrayList arrayList, Integer num, Integer num2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = pollingData.sid;
                }
                if ((i & 2) != 0) {
                    arrayList = pollingData.upgrades;
                }
                if ((i & 4) != 0) {
                    num = pollingData.pingInterval;
                }
                if ((i & 8) != 0) {
                    num2 = pollingData.pingTimeout;
                }
                return pollingData.copy(str, arrayList, num, num2);
            }

            public final String component1() {
                return this.sid;
            }

            public final ArrayList<String> component2() {
                return this.upgrades;
            }

            public final Integer component3() {
                return this.pingInterval;
            }

            public final Integer component4() {
                return this.pingTimeout;
            }

            public final PollingData copy(@JsonProperty("sid") String str, @JsonProperty("upgrades") ArrayList<String> upgrades, @JsonProperty("pingInterval") Integer num, @JsonProperty("pingTimeout") Integer num2) {
                Intrinsics.checkNotNullParameter(upgrades, "upgrades");
                return new PollingData(str, upgrades, num, num2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PollingData) {
                    PollingData pollingData = (PollingData) obj;
                    return Intrinsics.areEqual(this.sid, pollingData.sid) && Intrinsics.areEqual(this.upgrades, pollingData.upgrades) && Intrinsics.areEqual(this.pingInterval, pollingData.pingInterval) && Intrinsics.areEqual(this.pingTimeout, pollingData.pingTimeout);
                }
                return false;
            }

            public int hashCode() {
                String str = this.sid;
                int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.upgrades.hashCode()) * 31;
                Integer num = this.pingInterval;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                Integer num2 = this.pingTimeout;
                return hashCode2 + (num2 != null ? num2.hashCode() : 0);
            }

            public String toString() {
                return "PollingData(sid=" + this.sid + ", upgrades=" + this.upgrades + ", pingInterval=" + this.pingInterval + ", pingTimeout=" + this.pingTimeout + ')';
            }

            public PollingData(@JsonProperty("sid") String str, @JsonProperty("upgrades") ArrayList<String> upgrades, @JsonProperty("pingInterval") Integer num, @JsonProperty("pingTimeout") Integer num2) {
                Intrinsics.checkNotNullParameter(upgrades, "upgrades");
                this.sid = str;
                this.upgrades = upgrades;
                this.pingInterval = num;
                this.pingTimeout = num2;
            }

            public final String getSid() {
                return this.sid;
            }

            public /* synthetic */ PollingData(String str, ArrayList arrayList, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
            }

            public final ArrayList<String> getUpgrades() {
                return this.upgrades;
            }

            public final Integer getPingInterval() {
                return this.pingInterval;
            }

            public final Integer getPingTimeout() {
                return this.pingTimeout;
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String generateTimeStamp() {
            long unixTimeMS = APIHolder.INSTANCE.getUnixTimeMS();
            String str = "";
            while (unixTimeMS > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                long j = 64;
                sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".charAt((int) (unixTimeMS % j)));
                str = sb.toString();
                unixTimeMS /= j;
            }
            return StringsKt.reversed((CharSequence) str).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00f2 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ec -> B:13:0x003c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object negotiateNewSid(java.lang.String r26, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData> r27) {
            /*
                Method dump skipped, instructions count: 244
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.negotiateNewSid(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getUpdatedData(com.lagradost.nicehttp.NiceResponse r6, com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Tuples<com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData, java.lang.Boolean>> r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$getUpdatedData$1
                if (r0 == 0) goto L14
                r0 = r9
                com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$getUpdatedData$1 r0 = (com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$getUpdatedData$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$getUpdatedData$1 r0 = new com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$getUpdatedData$1
                r0.<init>(r5, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L38
                if (r2 != r4) goto L30
                java.lang.Object r6 = r0.L$0
                r7 = r6
                com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$PollingData r7 = (com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData) r7
                kotlin.ResultKt.throwOnFailure(r9)
                goto L50
            L30:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L38:
                kotlin.ResultKt.throwOnFailure(r9)
                okhttp3.Response r6 = r6.getOkhttpResponse()
                boolean r6 = r6.isSuccessful()
                if (r6 != 0) goto L67
                r0.L$0 = r7
                r0.label = r4
                java.lang.Object r9 = r5.negotiateNewSid(r8, r0)
                if (r9 != r1) goto L50
                return r1
            L50:
                com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$PollingData r9 = (com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData) r9
                if (r9 == 0) goto L5e
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
                kotlin.Pair r6 = kotlin.TuplesKt.m100to(r9, r6)
                if (r6 != 0) goto L66
            L5e:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r3)
                kotlin.Pair r6 = kotlin.TuplesKt.m100to(r7, r6)
            L66:
                return r6
            L67:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r3)
                kotlin.Pair r6 = kotlin.TuplesKt.m100to(r7, r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.getUpdatedData(com.lagradost.nicehttp.NiceResponse, com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$PollingData, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01a4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0220 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0233  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object initPolling(java.lang.String r32, java.lang.String r33, kotlin.coroutines.Continuation<? super kotlin.Tuples<com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.PollingData, java.lang.String>> r34) {
            /*
                Method dump skipped, instructions count: 571
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.initPolling(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x026d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x026e  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0286  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x028b  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02b3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0347 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0348  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x03b7  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x03d9  */
        /* JADX WARN: Type inference failed for: r0v15, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v2, types: [com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$PollingData, T] */
        /* JADX WARN: Type inference failed for: r3v9, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x03a5 -> B:75:0x03ae). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x03b7 -> B:41:0x01c8). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object runSflixExtractorVerifierJob(com.lagradost.cloudstream3.MainAPI r43, java.lang.String r44, java.lang.String r45, kotlin.coroutines.Continuation<? super kotlin.Unit> r46) {
            /*
                Method dump skipped, instructions count: 993
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.runSflixExtractorVerifierJob(com.lagradost.cloudstream3.MainAPI, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final boolean isValidServer(String str) {
            String str2;
            List listOf = CollectionsKt.listOf((Object[]) new String[]{"upcloud", "vidcloud", "streamlare"});
            if (str != null) {
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                str2 = str.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            return CollectionsKt.contains(listOf, str2);
        }

        static /* synthetic */ List toExtractorLink$default(Companion companion, Sources sources, MainAPI mainAPI, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.toExtractorLink(sources, mainAPI, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<ExtractorLink> toExtractorLink(Sources sources, MainAPI mainAPI, String str, String str2) {
            String file = sources.getFile();
            if (file != null) {
                String path = new URI(sources.getFile()).getPath();
                Intrinsics.checkNotNullExpressionValue(path, "URI(this.file).path");
                boolean z = false;
                if ((StringsKt.endsWith$default(path, ".m3u8", false, 2, (Object) null) || StringsKt.equals(sources.getType(), "hls", true)) ? true : true) {
                    List<M3u8Helper.M3u8Stream> m3u8Generation = new M3u8Helper().m3u8Generation(new M3u8Helper.M3u8Stream(sources.getFile(), null, null, 4, null), null);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(m3u8Generation, 10));
                    for (M3u8Helper.M3u8Stream m3u8Stream : m3u8Generation) {
                        String name = mainAPI.getName();
                        String str3 = mainAPI.getName() + ' ' + str;
                        String streamUrl = m3u8Stream.getStreamUrl();
                        String mainUrl = mainAPI.getMainUrl();
                        Integer quality = m3u8Stream.getQuality();
                        arrayList.add(new ExtractorLink(name, str3, streamUrl, mainUrl, ExtractorApiKt.getQualityFromName(quality != null ? quality.toString() : null), true, null, str2, 64, null));
                    }
                    return arrayList;
                }
                return CollectionsKt.listOf(new ExtractorLink(mainAPI.getName(), mainAPI.getName(), file, mainAPI.getMainUrl(), ExtractorApiKt.getQualityFromName(sources.getLabel()), false, null, str2, 64, null));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SubtitleFile toSubtitleFile(Tracks tracks) {
            String file = tracks.getFile();
            if (file != null) {
                String label = tracks.getLabel();
                if (label == null) {
                    label = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                return new SubtitleFile(label, file, null, 4, null);
            }
            return null;
        }

        public final Object extractRabbitStream(MainAPI mainAPI, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, boolean z, String str2, Function1<? super String, String> function13, Continuation<? super Unit> continuation) {
            return ArchComponentExt.suspendSafeApiCall(new SflixProvider$Companion$extractRabbitStream$2(str, mainAPI, z, str2, function1, function13, function12, null), continuation);
        }
    }
}
