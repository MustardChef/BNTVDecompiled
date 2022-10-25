package com.lagradost.cloudstream3.movieproviders;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoaptwoDayProvider.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJI\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0$H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "ServerJson", "Subs", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SoaptwoDayProvider extends MainAPI {
    private String mainUrl = "https://secretlink.xyz";
    private String name = "Soap2Day";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

    /* compiled from: SoaptwoDayProvider.kt */
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

    /* JADX WARN: Can't wrap try/catch for region: R(7:22|(1:23)|24|25|26|27|(1:29)(8:31|13|14|(1:15)|18|19|20|(2:39|40)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01a9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01aa, code lost:
        r14 = r23;
        r15 = r24;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0129 A[Catch: Exception -> 0x01a7, LOOP:0: B:29:0x0123->B:31:0x0129, LOOP_END, TryCatch #2 {Exception -> 0x01a7, blocks: (B:28:0x00ff, B:29:0x0123, B:31:0x0129, B:32:0x0193), top: B:47:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01bb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00f9 -> B:47:0x00ff). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01b4 -> B:19:0x00a5). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r30) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SoaptwoDayProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab A[LOOP:0: B:19:0x00a5->B:21:0x00ab, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SoaptwoDayProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a6, code lost:
        if (r9 == null) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028b  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r42, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r43) {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SoaptwoDayProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: SoaptwoDayProvider.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\tHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00065"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider$ServerJson;", "", "zero", "", SDKConstants.PARAM_KEY, "", "stream", "streambackup", "pos", "", "type", "subs", "", "Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider$Subs;", "prevEpiTitle", "prevEpiUrl", "nextEpiTitle", "nextEpiUrl", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNextEpiTitle", "()Ljava/lang/String;", "getNextEpiUrl", "getPos", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrevEpiTitle", "getPrevEpiUrl", "getStream", "getStreambackup", "getSubs", "()Ljava/util/List;", "getType", "getZero", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider$ServerJson;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerJson {
        private final Boolean key;
        private final String nextEpiTitle;
        private final String nextEpiUrl;
        private final Integer pos;
        private final String prevEpiTitle;
        private final String prevEpiUrl;
        private final String stream;
        private final String streambackup;
        private final List<Subs> subs;
        private final String type;
        private final String zero;

        public final String component1() {
            return this.zero;
        }

        public final String component10() {
            return this.nextEpiTitle;
        }

        public final String component11() {
            return this.nextEpiUrl;
        }

        public final Boolean component2() {
            return this.key;
        }

        public final String component3() {
            return this.stream;
        }

        public final String component4() {
            return this.streambackup;
        }

        public final Integer component5() {
            return this.pos;
        }

        public final String component6() {
            return this.type;
        }

        public final List<Subs> component7() {
            return this.subs;
        }

        public final String component8() {
            return this.prevEpiTitle;
        }

        public final String component9() {
            return this.prevEpiUrl;
        }

        public final ServerJson copy(@JsonProperty("0") String str, @JsonProperty("key") Boolean bool, @JsonProperty("val") String str2, @JsonProperty("val_bak") String str3, @JsonProperty("pos") Integer num, @JsonProperty("type") String str4, @JsonProperty("subs") List<Subs> list, @JsonProperty("prev_epi_title") String str5, @JsonProperty("prev_epi_url") String str6, @JsonProperty("next_epi_title") String str7, @JsonProperty("next_epi_url") String str8) {
            return new ServerJson(str, bool, str2, str3, num, str4, list, str5, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServerJson) {
                ServerJson serverJson = (ServerJson) obj;
                return Intrinsics.areEqual(this.zero, serverJson.zero) && Intrinsics.areEqual(this.key, serverJson.key) && Intrinsics.areEqual(this.stream, serverJson.stream) && Intrinsics.areEqual(this.streambackup, serverJson.streambackup) && Intrinsics.areEqual(this.pos, serverJson.pos) && Intrinsics.areEqual(this.type, serverJson.type) && Intrinsics.areEqual(this.subs, serverJson.subs) && Intrinsics.areEqual(this.prevEpiTitle, serverJson.prevEpiTitle) && Intrinsics.areEqual(this.prevEpiUrl, serverJson.prevEpiUrl) && Intrinsics.areEqual(this.nextEpiTitle, serverJson.nextEpiTitle) && Intrinsics.areEqual(this.nextEpiUrl, serverJson.nextEpiUrl);
            }
            return false;
        }

        public int hashCode() {
            String str = this.zero;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.key;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.stream;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.streambackup;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.pos;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str4 = this.type;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            List<Subs> list = this.subs;
            int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
            String str5 = this.prevEpiTitle;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.prevEpiUrl;
            int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.nextEpiTitle;
            int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.nextEpiUrl;
            return hashCode10 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "ServerJson(zero=" + this.zero + ", key=" + this.key + ", stream=" + this.stream + ", streambackup=" + this.streambackup + ", pos=" + this.pos + ", type=" + this.type + ", subs=" + this.subs + ", prevEpiTitle=" + this.prevEpiTitle + ", prevEpiUrl=" + this.prevEpiUrl + ", nextEpiTitle=" + this.nextEpiTitle + ", nextEpiUrl=" + this.nextEpiUrl + ')';
        }

        public ServerJson(@JsonProperty("0") String str, @JsonProperty("key") Boolean bool, @JsonProperty("val") String str2, @JsonProperty("val_bak") String str3, @JsonProperty("pos") Integer num, @JsonProperty("type") String str4, @JsonProperty("subs") List<Subs> list, @JsonProperty("prev_epi_title") String str5, @JsonProperty("prev_epi_url") String str6, @JsonProperty("next_epi_title") String str7, @JsonProperty("next_epi_url") String str8) {
            this.zero = str;
            this.key = bool;
            this.stream = str2;
            this.streambackup = str3;
            this.pos = num;
            this.type = str4;
            this.subs = list;
            this.prevEpiTitle = str5;
            this.prevEpiUrl = str6;
            this.nextEpiTitle = str7;
            this.nextEpiUrl = str8;
        }

        public final String getZero() {
            return this.zero;
        }

        public final Boolean getKey() {
            return this.key;
        }

        public final String getStream() {
            return this.stream;
        }

        public final String getStreambackup() {
            return this.streambackup;
        }

        public final Integer getPos() {
            return this.pos;
        }

        public final String getType() {
            return this.type;
        }

        public final List<Subs> getSubs() {
            return this.subs;
        }

        public final String getPrevEpiTitle() {
            return this.prevEpiTitle;
        }

        public final String getPrevEpiUrl() {
            return this.prevEpiUrl;
        }

        public final String getNextEpiTitle() {
            return this.nextEpiTitle;
        }

        public final String getNextEpiUrl() {
            return this.nextEpiUrl;
        }
    }

    /* compiled from: SoaptwoDayProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010&\u001a\u00020\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0090\u0001\u0010)\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\nHÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011¨\u00060"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider$Subs;", "", "id", "", "movieId", "tvId", "episodeId", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, "IsShow", "name", "", "path", "downlink", "sourceFileName", "createtime", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getIsShow", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatetime", "getDefault", "getDownlink", "()Ljava/lang/String;", "getEpisodeId", "getId", "getMovieId", "getName", "getPath", "getSourceFileName", "getTvId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SoaptwoDayProvider$Subs;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Subs {
        private final Integer IsShow;
        private final Integer createtime;

        /* renamed from: default  reason: not valid java name */
        private final Integer f10815default;
        private final String downlink;
        private final Integer episodeId;

        /* renamed from: id */
        private final Integer f9972id;
        private final Integer movieId;
        private final String name;
        private final String path;
        private final String sourceFileName;
        private final Integer tvId;

        public final Integer component1() {
            return this.f9972id;
        }

        public final String component10() {
            return this.sourceFileName;
        }

        public final Integer component11() {
            return this.createtime;
        }

        public final Integer component2() {
            return this.movieId;
        }

        public final Integer component3() {
            return this.tvId;
        }

        public final Integer component4() {
            return this.episodeId;
        }

        public final Integer component5() {
            return this.f10815default;
        }

        public final Integer component6() {
            return this.IsShow;
        }

        public final String component7() {
            return this.name;
        }

        public final String component8() {
            return this.path;
        }

        public final String component9() {
            return this.downlink;
        }

        public final Subs copy(@JsonProperty("id") Integer num, @JsonProperty("movieId") Integer num2, @JsonProperty("tvId") Integer num3, @JsonProperty("episodeId") Integer num4, @JsonProperty("default") Integer num5, @JsonProperty("IsShow") Integer num6, @JsonProperty("name") String name, @JsonProperty("path") String str, @JsonProperty("downlink") String str2, @JsonProperty("source_file_name") String str3, @JsonProperty("createtime") Integer num7) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Subs(num, num2, num3, num4, num5, num6, name, str, str2, str3, num7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Subs) {
                Subs subs = (Subs) obj;
                return Intrinsics.areEqual(this.f9972id, subs.f9972id) && Intrinsics.areEqual(this.movieId, subs.movieId) && Intrinsics.areEqual(this.tvId, subs.tvId) && Intrinsics.areEqual(this.episodeId, subs.episodeId) && Intrinsics.areEqual(this.f10815default, subs.f10815default) && Intrinsics.areEqual(this.IsShow, subs.IsShow) && Intrinsics.areEqual(this.name, subs.name) && Intrinsics.areEqual(this.path, subs.path) && Intrinsics.areEqual(this.downlink, subs.downlink) && Intrinsics.areEqual(this.sourceFileName, subs.sourceFileName) && Intrinsics.areEqual(this.createtime, subs.createtime);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9972id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.movieId;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.tvId;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.episodeId;
            int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.f10815default;
            int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.IsShow;
            int hashCode6 = (((hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31) + this.name.hashCode()) * 31;
            String str = this.path;
            int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.downlink;
            int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sourceFileName;
            int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num7 = this.createtime;
            return hashCode9 + (num7 != null ? num7.hashCode() : 0);
        }

        public String toString() {
            return "Subs(id=" + this.f9972id + ", movieId=" + this.movieId + ", tvId=" + this.tvId + ", episodeId=" + this.episodeId + ", default=" + this.f10815default + ", IsShow=" + this.IsShow + ", name=" + this.name + ", path=" + this.path + ", downlink=" + this.downlink + ", sourceFileName=" + this.sourceFileName + ", createtime=" + this.createtime + ')';
        }

        public Subs(@JsonProperty("id") Integer num, @JsonProperty("movieId") Integer num2, @JsonProperty("tvId") Integer num3, @JsonProperty("episodeId") Integer num4, @JsonProperty("default") Integer num5, @JsonProperty("IsShow") Integer num6, @JsonProperty("name") String name, @JsonProperty("path") String str, @JsonProperty("downlink") String str2, @JsonProperty("source_file_name") String str3, @JsonProperty("createtime") Integer num7) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f9972id = num;
            this.movieId = num2;
            this.tvId = num3;
            this.episodeId = num4;
            this.f10815default = num5;
            this.IsShow = num6;
            this.name = name;
            this.path = str;
            this.downlink = str2;
            this.sourceFileName = str3;
            this.createtime = num7;
        }

        public final Integer getId() {
            return this.f9972id;
        }

        public final Integer getMovieId() {
            return this.movieId;
        }

        public final Integer getTvId() {
            return this.tvId;
        }

        public final Integer getEpisodeId() {
            return this.episodeId;
        }

        public final Integer getDefault() {
            return this.f10815default;
        }

        public final Integer getIsShow() {
            return this.IsShow;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getDownlink() {
            return this.downlink;
        }

        public final String getSourceFileName() {
            return this.sourceFileName;
        }

        public final Integer getCreatetime() {
            return this.createtime;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|(1:(1:(6:10|11|(4:13|(5:16|(4:19|(2:23|24)|25|17)|28|29|14)|30|31)(1:45)|(1:44)|33|(9:35|(1:37)|38|(1:40)|11|(0)(0)|(0)|33|(2:42|43)(0))(0))(2:46|47))(1:48))(2:69|(1:71)(1:72))|49|(1:51)(1:68)|52|(1:54)(1:67)|55|56|57))|73|6|(0)(0)|49|(0)(0)|52|(0)(0)|55|56|57|(1:(6:59|60|(1:62)(1:64)|63|33|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0108, code lost:
        if (r6 != null) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0369  */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0269 -> B:45:0x026c). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r48, boolean r49, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r50, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r51, kotlin.coroutines.Continuation<? super java.lang.Boolean> r52) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SoaptwoDayProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
