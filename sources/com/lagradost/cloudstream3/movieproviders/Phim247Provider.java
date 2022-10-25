package com.lagradost.cloudstream3.movieproviders;

import android.util.Base64;
import android.util.Patterns;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.blankj.utilcode.util.LogUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: Phim247Provider.kt */
@Metadata(m108d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0005RSTUVB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0004J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0013\u00100\u001a\u0004\u0018\u000101H\u0096@ø\u0001\u0000¢\u0006\u0002\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020*H\u0002J \u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0002J/\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u00042\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040<H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010=J\u001b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010(\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@JI\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\b2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G0E2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020G0EH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0019\u0010K\u001a\u00020L2\u0006\u0010(\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J!\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010$2\u0006\u0010O\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0012\u0010P\u001a\u00020\u0004*\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "defaultPageUrl", "", "getDefaultPageUrl", "()Ljava/lang/String;", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "vpnStatus", "Lcom/lagradost/cloudstream3/VPNStatus;", "getVpnStatus", "()Lcom/lagradost/cloudstream3/VPNStatus;", "extractUrl", TvContractCompat.PARAM_INPUT, "extractUrls", "", "text", "getDataEpisode", "Lcom/lagradost/cloudstream3/Episode;", "url", "doc", "Lorg/jsoup/nodes/Document;", "getItemMovie", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "it", "Lorg/jsoup/nodes/Element;", "getItemMovieSearch", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPagingResult", "document", "getParamFromJS", "str", SDKConstants.PARAM_KEY, TtmlNode.END, "getRealHls", "urlPlaylist", "header", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPage", "Lcom/lagradost/cloudstream3/PageResponse;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "decrypt", "password", "BongNgoResponse", "BongNgoSourceResponse", "Companion", "DataEp", "Quality", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Phim247Provider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    public static final String HOST_GET_SUB = "subtitles.0apis.xyz";
    public static final String HOST_STREAM = "https://api.solist.bar/ajax/episodes";
    private String mainUrl = "https://247phim.net/";
    private String name = "247Phim";

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
        return false;
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
        return getMainUrl() + "/phim/phim-chieu-rap?xem-them=1";
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public VPNStatus getVpnStatus() {
        return VPNStatus.None;
    }

    /* compiled from: Phim247Provider.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$Companion;", "", "()V", "HOST_GET_SUB", "", "HOST_STREAM", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0179 A[LOOP:2: B:36:0x016d->B:38:0x0179, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e2 A[LOOP:3: B:40:0x01dc->B:42:0x01e2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x023d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x023e  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r30) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.movieproviders.Phim247Provider$loadPage$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.movieproviders.Phim247Provider$loadPage$1 r2 = (com.lagradost.cloudstream3.movieproviders.Phim247Provider$loadPage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.movieproviders.Phim247Provider$loadPage$1 r2 = new com.lagradost.cloudstream3.movieproviders.Phim247Provider$loadPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.movieproviders.Phim247Provider r2 = (com.lagradost.cloudstream3.movieproviders.Phim247Provider) r2
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
            java.lang.String r3 = ".panel-vod .item"
            org.jsoup.select.Elements r3 = r1.select(r3)
            java.lang.String r4 = "document.select(\".panel-vod .item\")"
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
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.loadPage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getPagingResult(Document document) {
        if (document.selectFirst(".pagination li") == null) {
            LogUtils.m6080d("no more page", new Object[0]);
        } else {
            Elements select = document.select(".pagination li");
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c3 A[LOOP:1: B:23:0x00bd->B:25:0x00c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0162 A[LOOP:0: B:33:0x015c->B:35:0x0162, LOOP_END] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r24, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r25) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final MovieSearchResponse getItemMovie(Element element) {
        Element last = element.select("h3").last();
        Intrinsics.checkNotNull(last);
        String title = last.text();
        Element selectFirst = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst);
        String attr = selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "it.selectFirst(\"a\")!!.attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(this, attr);
        Element selectFirst2 = element.selectFirst("img");
        Intrinsics.checkNotNull(selectFirst2);
        String attr2 = selectFirst2.attr("src");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return new MovieSearchResponse(title, fixUrl, getName(), TvType.Movie, attr2, 0, null, null, null, 448, null);
    }

    private final MovieSearchResponse getItemMovieSearch(Element element) {
        Element first = element.select(TtmlNode.TAG_P).first();
        Intrinsics.checkNotNull(first);
        String title = first.text();
        Element selectFirst = element.selectFirst("a");
        Intrinsics.checkNotNull(selectFirst);
        String attr = selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(attr, "it.selectFirst(\"a\")!!.attr(\"href\")");
        String fixUrl = MainAPIKt.fixUrl(this, attr);
        Element selectFirst2 = element.selectFirst("img");
        Intrinsics.checkNotNull(selectFirst2);
        String attr2 = selectFirst2.attr("src");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return new MovieSearchResponse(title, fixUrl, getName(), TvType.Movie, attr2, 0, null, null, null, 448, null);
    }

    public final String decrypt(String str, String password) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(password, "password");
        byte[] bytes = password.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bArr = new byte[16];
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        byte[] decryptedByteValue = cipher.doFinal(Base64.decode(str, 0));
        Intrinsics.checkNotNullExpressionValue(decryptedByteValue, "decryptedByteValue");
        return new String(decryptedByteValue, Charsets.UTF_8);
    }

    private final String getParamFromJS(String str, String str2, String str3) {
        String substring = str.substring(StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) + str2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String substring2 = substring.substring(0, StringsKt.indexOf$default((CharSequence) substring, str3, 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0178 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0284  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r45, boolean r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, kotlin.coroutines.Continuation<? super java.lang.Boolean> r49) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0172 A[LOOP:1: B:37:0x016c->B:39:0x0172, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d7  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r43, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r44) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<Episode> getDataEpisode(String url, Document doc) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(doc, "doc");
        Elements select = doc.select(".list-episodes");
        ArrayList arrayList = new ArrayList();
        int size = select.size();
        for (int i = 0; i < size; i++) {
            Elements select2 = select.get(i).select("li");
            int size2 = select2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Element element = select2.get(i2);
                element.attr("data-url_web");
                String text = element.text();
                element.attr("data-id");
                element.attr("data-video_id");
                String attr = element.attr("data-url_cdn");
                String urlVietSub = element.attr("data-url_sub");
                String urlEngSub = element.attr("data-url_sub_en");
                byte[] decode = Base64.decode(attr, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(dataKey, Base64.DEFAULT)");
                String str = new String(decode, Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(urlEngSub, "urlEngSub");
                Intrinsics.checkNotNullExpressionValue(urlVietSub, "urlVietSub");
                String json = new Gson().toJson(new DataEp(urlEngSub, urlVietSub, str));
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(dataEp)");
                arrayList.add(new Episode(json, text, Integer.valueOf(i), null, null, null, "Danh sách tập", null, 176, null));
            }
        }
        return arrayList;
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

    /* compiled from: Phim247Provider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$Quality;", "", "name", "", "urlStream", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrlStream", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Quality {
        private final String name;
        private final String urlStream;

        public static /* synthetic */ Quality copy$default(Quality quality, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = quality.name;
            }
            if ((i & 2) != 0) {
                str2 = quality.urlStream;
            }
            return quality.copy(str, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.urlStream;
        }

        public final Quality copy(String name, String urlStream) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(urlStream, "urlStream");
            return new Quality(name, urlStream);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Quality) {
                Quality quality = (Quality) obj;
                return Intrinsics.areEqual(this.name, quality.name) && Intrinsics.areEqual(this.urlStream, quality.urlStream);
            }
            return false;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.urlStream.hashCode();
        }

        public String toString() {
            return "Quality(name=" + this.name + ", urlStream=" + this.urlStream + ')';
        }

        public Quality(String name, String urlStream) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(urlStream, "urlStream");
            this.name = name;
            this.urlStream = urlStream;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrlStream() {
            return this.urlStream;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getRealHls(java.lang.String r21, java.util.Map<java.lang.String, java.lang.String> r22, kotlin.coroutines.Continuation<? super java.lang.String> r23) {
        /*
            r20 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.movieproviders.Phim247Provider$getRealHls$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.movieproviders.Phim247Provider$getRealHls$1 r1 = (com.lagradost.cloudstream3.movieproviders.Phim247Provider$getRealHls$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r20
            goto L1f
        L18:
            com.lagradost.cloudstream3.movieproviders.Phim247Provider$getRealHls$1 r1 = new com.lagradost.cloudstream3.movieproviders.Phim247Provider$getRealHls$1
            r2 = r20
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r14 = 1
            if (r3 == 0) goto L3e
            if (r3 != r14) goto L36
            java.lang.Object r1 = r1.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r19 = 1
            goto L73
        L36:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3e:
            kotlin.ResultKt.throwOnFailure(r0)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r0
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r0 = 0
            r16 = 0
            r17 = 2044(0x7fc, float:2.864E-42)
            r18 = 0
            r5 = r21
            r1.L$0 = r5
            r1.label = r14
            r4 = r21
            r5 = r22
            r19 = 1
            r14 = r0
            r0 = r15
            r15 = r16
            r16 = r1
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r1 != r0) goto L70
            return r0
        L70:
            r0 = r1
            r1 = r21
        L73:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            java.lang.String r0 = r0.getText()
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = ".*\\.m3u8"
            r3.<init>(r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4 = 2
            r5 = 0
            r6 = 0
            kotlin.text.MatchResult r0 = kotlin.text.Regex.find$default(r3, r0, r5, r4, r6)
            if (r0 == 0) goto L8f
            java.lang.String r6 = r0.getValue()
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            java.lang.String r8 = "/"
            int r3 = kotlin.text.StringsKt.lastIndexOf$default(r7, r8, r9, r10, r11, r12)
            int r3 = r3 + 1
            java.lang.String r1 = r1.substring(r5, r3)
            java.lang.String r3 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.Phim247Provider.getRealHls(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: Phim247Provider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$BongNgoSourceResponse;", "", SDKConstants.PARAM_KEY, "", "link", "typeplay", "namesv", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getLink", "getNamesv", "getTypeplay", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class BongNgoSourceResponse {
        private final String key;
        private final String link;
        private final String namesv;
        private final String typeplay;

        public static /* synthetic */ BongNgoSourceResponse copy$default(BongNgoSourceResponse bongNgoSourceResponse, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bongNgoSourceResponse.key;
            }
            if ((i & 2) != 0) {
                str2 = bongNgoSourceResponse.link;
            }
            if ((i & 4) != 0) {
                str3 = bongNgoSourceResponse.typeplay;
            }
            if ((i & 8) != 0) {
                str4 = bongNgoSourceResponse.namesv;
            }
            return bongNgoSourceResponse.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.link;
        }

        public final String component3() {
            return this.typeplay;
        }

        public final String component4() {
            return this.namesv;
        }

        public final BongNgoSourceResponse copy(@JsonProperty("key") String key, @JsonProperty("link") String link, @JsonProperty("typeplay") String typeplay, @JsonProperty("namesv") String namesv) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(typeplay, "typeplay");
            Intrinsics.checkNotNullParameter(namesv, "namesv");
            return new BongNgoSourceResponse(key, link, typeplay, namesv);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BongNgoSourceResponse) {
                BongNgoSourceResponse bongNgoSourceResponse = (BongNgoSourceResponse) obj;
                return Intrinsics.areEqual(this.key, bongNgoSourceResponse.key) && Intrinsics.areEqual(this.link, bongNgoSourceResponse.link) && Intrinsics.areEqual(this.typeplay, bongNgoSourceResponse.typeplay) && Intrinsics.areEqual(this.namesv, bongNgoSourceResponse.namesv);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.key.hashCode() * 31) + this.link.hashCode()) * 31) + this.typeplay.hashCode()) * 31) + this.namesv.hashCode();
        }

        public String toString() {
            return "BongNgoSourceResponse(key=" + this.key + ", link=" + this.link + ", typeplay=" + this.typeplay + ", namesv=" + this.namesv + ')';
        }

        public BongNgoSourceResponse(@JsonProperty("key") String key, @JsonProperty("link") String link, @JsonProperty("typeplay") String typeplay, @JsonProperty("namesv") String namesv) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(link, "link");
            Intrinsics.checkNotNullParameter(typeplay, "typeplay");
            Intrinsics.checkNotNullParameter(namesv, "namesv");
            this.key = key;
            this.link = link;
            this.typeplay = typeplay;
            this.namesv = namesv;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getTypeplay() {
            return this.typeplay;
        }

        public final String getNamesv() {
            return this.namesv;
        }
    }

    /* compiled from: Phim247Provider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$DataEp;", "", "engsub", "", "vietsub", "urlStream", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEngsub", "()Ljava/lang/String;", "getUrlStream", "getVietsub", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class DataEp {
        private final String engsub;
        private final String urlStream;
        private final String vietsub;

        public static /* synthetic */ DataEp copy$default(DataEp dataEp, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataEp.engsub;
            }
            if ((i & 2) != 0) {
                str2 = dataEp.vietsub;
            }
            if ((i & 4) != 0) {
                str3 = dataEp.urlStream;
            }
            return dataEp.copy(str, str2, str3);
        }

        public final String component1() {
            return this.engsub;
        }

        public final String component2() {
            return this.vietsub;
        }

        public final String component3() {
            return this.urlStream;
        }

        public final DataEp copy(@JsonProperty("engsub") String engsub, @JsonProperty("vietsub") String vietsub, @JsonProperty("urlStream") String urlStream) {
            Intrinsics.checkNotNullParameter(engsub, "engsub");
            Intrinsics.checkNotNullParameter(vietsub, "vietsub");
            Intrinsics.checkNotNullParameter(urlStream, "urlStream");
            return new DataEp(engsub, vietsub, urlStream);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DataEp) {
                DataEp dataEp = (DataEp) obj;
                return Intrinsics.areEqual(this.engsub, dataEp.engsub) && Intrinsics.areEqual(this.vietsub, dataEp.vietsub) && Intrinsics.areEqual(this.urlStream, dataEp.urlStream);
            }
            return false;
        }

        public int hashCode() {
            return (((this.engsub.hashCode() * 31) + this.vietsub.hashCode()) * 31) + this.urlStream.hashCode();
        }

        public String toString() {
            return "DataEp(engsub=" + this.engsub + ", vietsub=" + this.vietsub + ", urlStream=" + this.urlStream + ')';
        }

        public DataEp(@JsonProperty("engsub") String engsub, @JsonProperty("vietsub") String vietsub, @JsonProperty("urlStream") String urlStream) {
            Intrinsics.checkNotNullParameter(engsub, "engsub");
            Intrinsics.checkNotNullParameter(vietsub, "vietsub");
            Intrinsics.checkNotNullParameter(urlStream, "urlStream");
            this.engsub = engsub;
            this.vietsub = vietsub;
            this.urlStream = urlStream;
        }

        public final String getEngsub() {
            return this.engsub;
        }

        public final String getVietsub() {
            return this.vietsub;
        }

        public final String getUrlStream() {
            return this.urlStream;
        }
    }

    /* compiled from: Phim247Provider.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$BongNgoResponse;", "", "source", "", "Lcom/lagradost/cloudstream3/movieproviders/Phim247Provider$BongNgoSourceResponse;", "(Ljava/util/List;)V", "getSource", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class BongNgoResponse {
        private final List<BongNgoSourceResponse> source;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BongNgoResponse copy$default(BongNgoResponse bongNgoResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = bongNgoResponse.source;
            }
            return bongNgoResponse.copy(list);
        }

        public final List<BongNgoSourceResponse> component1() {
            return this.source;
        }

        public final BongNgoResponse copy(@JsonProperty("source") List<BongNgoSourceResponse> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new BongNgoResponse(source);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BongNgoResponse) && Intrinsics.areEqual(this.source, ((BongNgoResponse) obj).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "BongNgoResponse(source=" + this.source + ')';
        }

        public BongNgoResponse(@JsonProperty("source") List<BongNgoSourceResponse> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public final List<BongNgoSourceResponse> getSource() {
            return this.source;
        }
    }
}
