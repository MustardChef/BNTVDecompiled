package com.lagradost.cloudstream3.movieproviders;

import android.util.Patterns;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.blankj.utilcode.util.LogUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: SubNhanhProvider.kt */
@Metadata(m108d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 K2\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0004J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0%2\u0006\u0010)\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0011\u0010/\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0002\u00101J\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004032\u0006\u00104\u001a\u00020\u0004J\u0012\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0002J\u001b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010)\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*JI\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\b2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0AH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010FJ\u0019\u0010G\u001a\u00020H2\u0006\u0010)\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*J!\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010%2\u0006\u00104\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SubNhanhProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "defaultPageUrl", "", "getDefaultPageUrl", "()Ljava/lang/String;", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "extractUrl", TvContractCompat.PARAM_INPUT, "extractUrlPhoto", "extractUrls", "", "text", "getDataEpisode", "Lcom/lagradost/cloudstream3/Episode;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemMovie", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "it", "Lorg/jsoup/nodes/Element;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMapQueryFromUrl", "Ljava/util/HashMap;", "query", "getPagingResult", "document", "Lorg/jsoup/nodes/Document;", "getParamFromJS", "str", SDKConstants.PARAM_KEY, "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPage", "Lcom/lagradost/cloudstream3/PageResponse;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SubNhanhProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private String mainUrl = "https://subnhanhz.net";
    private String name = "SubNhanh";

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return false;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasDownloadSupport() {
        return true;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return true;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasQuickSearch() {
        return true;
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
    public String getDefaultPageUrl() {
        return getMainUrl() + "/the-loai/phim-bo";
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});
    }

    /* compiled from: SubNhanhProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SubNhanhProvider$Companion;", "", "()V", "getHomeConfig", "", "listHomePageList", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:45|46))(2:47|(2:52|(1:54))(3:51|42|43))|13|(6:17|(2:18|(4:20|(1:30)|(3:25|26|27)(1:29)|28)(1:31))|32|(1:34)(1:41)|35|(1:39))|42|43))|57|6|7|(0)(0)|13|(7:15|17|(3:18|(0)(0)|28)|32|(0)(0)|35|(2:37|39))|42|43) */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x011d, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d8 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:12:0x0032, B:26:0x0094, B:28:0x00a0, B:30:0x00a6, B:31:0x00d1, B:33:0x00d8, B:35:0x00e6, B:39:0x00ef, B:40:0x00f7, B:44:0x0106, B:46:0x0113, B:48:0x0119, B:43:0x0100, B:23:0x005f), top: B:53:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0100 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:12:0x0032, B:26:0x0094, B:28:0x00a0, B:30:0x00a6, B:31:0x00d1, B:33:0x00d8, B:35:0x00e6, B:39:0x00ef, B:40:0x00f7, B:44:0x0106, B:46:0x0113, B:48:0x0119, B:43:0x0100, B:23:0x005f), top: B:53:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00f7 A[EDGE_INSN: B:55:0x00f7->B:40:0x00f7 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getHomeConfig(java.util.ArrayList<com.lagradost.cloudstream3.HomePageList> r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.Companion.getHomeConfig(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public VPNStatus getVpnStatus() {
        return VPNStatus.None;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015e A[LOOP:2: B:36:0x0150->B:38:0x015e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d0 A[LOOP:3: B:40:0x01ca->B:42:0x01d0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x022b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x022c  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r30) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096 A[LOOP:0: B:19:0x0090->B:21:0x0096, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadPage(java.lang.String r21, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.PageResponse> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.SubNhanhProvider$loadPage$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.SubNhanhProvider$loadPage$1 r2 = (com.lagradost.cloudstream3.movieproviders.SubNhanhProvider$loadPage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.SubNhanhProvider$loadPage$1 r2 = new com.lagradost.cloudstream3.movieproviders.SubNhanhProvider$loadPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.SubNhanhProvider r2 = (com.lagradost.cloudstream3.movieproviders.SubNhanhProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L68
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
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r1 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r2.L$0 = r0
            r2.label = r4
            r4 = r21
            r19 = r15
            r15 = r1
            r16 = r2
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r2 = r19
            if (r1 != r2) goto L67
            return r2
        L67:
            r2 = r0
        L68:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            java.lang.String r1 = r1.getText()
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.parse(r1)
            java.lang.String r3 = "#p0 .item"
            org.jsoup.select.Elements r3 = r1.select(r3)
            java.lang.String r4 = "document.select(\"#p0 .item\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L90:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto La9
            java.lang.Object r5 = r3.next()
            org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
            java.lang.String r6 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.lagradost.cloudstream3.MovieSearchResponse r5 = r2.getItemMovie(r5)
            r4.add(r5)
            goto L90
        La9:
            java.util.List r4 = (java.util.List) r4
            com.lagradost.cloudstream3.PageResponse r3 = new com.lagradost.cloudstream3.PageResponse
            java.lang.String r5 = "document"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            java.lang.String r1 = r2.getPagingResult(r1)
            r3.<init>(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.loadPage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getPagingResult(Document document) {
        if (document.selectFirst("#pagination") == null) {
            LogUtils.m6080d("no more page", new Object[0]);
        } else {
            Elements select = document.select("li");
            if (select != null && !select.isEmpty()) {
                int size = select.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Element element = select.get(i);
                    if (element.attr("class") != null) {
                        String attr = element.attr("class");
                        Intrinsics.checkNotNullExpressionValue(attr, "li).attr(\"class\")");
                        if (StringsKt.contains$default((CharSequence) attr, (CharSequence) AppMeasurementSdk.ConditionalUserProperty.ACTIVE, false, 2, (Object) null)) {
                            if (i == select.size() - 1) {
                                LogUtils.m6080d("no more page", new Object[0]);
                            } else {
                                int i2 = i + 1;
                                if (select.get(i2) != null) {
                                    Elements elementsByTag = select.get(i2).getElementsByTag("a");
                                    if (elementsByTag != null && !elementsByTag.isEmpty()) {
                                        Element first = elementsByTag.first();
                                        Intrinsics.checkNotNull(first);
                                        String attr2 = first.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                                        Intrinsics.checkNotNullExpressionValue(attr2, "a.first()!!.attr(\"href\")");
                                        String fixUrl = MainAPIKt.fixUrl(this, attr2);
                                        LogUtils.m6080d("has more page", new Object[0]);
                                        return fixUrl;
                                    }
                                    LogUtils.m6080d("no more page", new Object[0]);
                                } else {
                                    LogUtils.m6080d("no more page", new Object[0]);
                                }
                            }
                        }
                    }
                    i++;
                }
            } else {
                LogUtils.m6080d("no more page", new Object[0]);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0 A[LOOP:0: B:23:0x00ca->B:25:0x00d0, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r21, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r22) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final MovieSearchResponse getItemMovie(Element element) {
        String replace$default;
        Element last = element.select(".item-block-title").last();
        Intrinsics.checkNotNull(last);
        String title = last.text();
        Element selectFirst = element.selectFirst(".item-block-title");
        Intrinsics.checkNotNull(selectFirst);
        String attr = selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "it.selectFirst(\".item-block-title\")!!.attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(this, attr);
        Element first = element.getElementsByClass("item-image-block").first();
        Intrinsics.checkNotNull(first);
        String variable = first.attr("style");
        Intrinsics.checkNotNullExpressionValue(variable, "variable");
        String extractUrlPhoto = extractUrlPhoto(variable);
        String replace$default2 = (extractUrlPhoto == null || (replace$default = StringsKt.replace$default(extractUrlPhoto, "background-image:url('", "", false, 4, (Object) null)) == null) ? null : StringsKt.replace$default(replace$default, "')", "", false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return new MovieSearchResponse(title, fixUrl, getName(), TvType.Movie, replace$default2, 0, null, null, null, 448, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|7|(1:(2:10|11)(2:50|51))(3:52|53|(1:55)(1:56))|12|13|(10:18|(1:20)(1:45)|21|22|23|(1:43)(1:27)|28|(1:30)(4:34|(2:39|(1:41))|42|(0))|31|32)|46|47))|59|6|7|(0)(0)|12|13|(12:15|18|(0)(0)|21|22|23|(1:25)|43|28|(0)(0)|31|32)|46|47|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0252, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0254, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0255, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0256, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x013e A[Catch: Exception -> 0x0254, TryCatch #0 {Exception -> 0x0254, blocks: (B:12:0x0039, B:21:0x0124, B:23:0x0130, B:26:0x0138, B:28:0x013e, B:30:0x0144, B:17:0x0095), top: B:60:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a3 A[Catch: Exception -> 0x0252, TRY_ENTER, TryCatch #1 {Exception -> 0x0252, blocks: (B:32:0x015a, B:34:0x0193, B:41:0x01a3, B:42:0x01ee, B:44:0x01f6, B:50:0x0202, B:51:0x0242), top: B:62:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ee A[Catch: Exception -> 0x0252, TryCatch #1 {Exception -> 0x0252, blocks: (B:32:0x015a, B:34:0x0193, B:41:0x01a3, B:42:0x01ee, B:44:0x01f6, B:50:0x0202, B:51:0x0242), top: B:62:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0202 A[Catch: Exception -> 0x0252, TryCatch #1 {Exception -> 0x0252, blocks: (B:32:0x015a, B:34:0x0193, B:41:0x01a3, B:42:0x01ee, B:44:0x01f6, B:50:0x0202, B:51:0x0242), top: B:62:0x012e }] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r28, boolean r29, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r30, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02db A[LOOP:2: B:54:0x02d5->B:56:0x02db, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0315 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0316  */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.List] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r32, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r33) {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDataEpisode(java.lang.String r32, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r33) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SubNhanhProvider.getDataEpisode(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getParamFromJS(String str, String str2) {
        String substring = str.substring(StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) + str2.length() + 4);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String substring2 = substring.substring(0, StringsKt.indexOf$default((CharSequence) substring, ";", 0, false, 6, (Object) null) - 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring2;
    }

    private final String extractUrl(String str) {
        Object obj;
        String replace$default;
        Iterator it = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Patterns.WEB_URL.matcher((String) obj).find()) {
                break;
            }
        }
        String str2 = (String) obj;
        if (str2 == null || (replace$default = StringsKt.replace$default(str2, "url(", "", false, 4, (Object) null)) == null) {
            return null;
        }
        return StringsKt.replace$default(replace$default, ")", "", false, 4, (Object) null);
    }

    public final List<String> extractUrls(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile("((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", 2);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(urlRegex, Pattern.CASE_INSENSITIVE)");
        Matcher matcher = compile.matcher(text);
        Intrinsics.checkNotNullExpressionValue(matcher, "pattern.matcher(text)");
        while (matcher.find()) {
            String substring = text.substring(matcher.start(0), matcher.end(0));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
        }
        return arrayList;
    }

    public final HashMap<String, String> getMapQueryFromUrl(String query) {
        String[] strArr;
        String str;
        Intrinsics.checkNotNullParameter(query, "query");
        Object[] array = StringsKt.split$default((CharSequence) query, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : (String[]) array) {
            Object[] array2 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String str3 = ((String[]) array2)[0];
            Object[] array3 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            if (array3.length > 1) {
                Object[] array4 = StringsKt.split$default((CharSequence) str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                str = ((String[]) array4)[1];
            } else {
                str = "";
            }
            hashMap.put(str3, str);
        }
        return hashMap;
    }

    private final String extractUrlPhoto(String str) {
        Object obj;
        Iterator it = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Patterns.WEB_URL.matcher((String) obj).find()) {
                break;
            }
        }
        return (String) obj;
    }
}
