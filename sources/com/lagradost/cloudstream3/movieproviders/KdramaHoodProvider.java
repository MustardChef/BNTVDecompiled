package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: KdramaHoodProvider.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u001b\u001a\u00020\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!JI\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020(0&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/KdramaHoodProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "ResponseDatas", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class KdramaHoodProvider extends MainAPI {
    private final boolean hasChromecastSupport;
    private final boolean hasQuickSearch;
    private String mainUrl = "https://kdramahood.com";
    private String name = "KDramaHood";
    private final boolean hasMainPage = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KdramaHoodProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/KdramaHoodProvider$ResponseDatas;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "file", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseDatas {
        private final String file;
        private final String label;

        public static /* synthetic */ ResponseDatas copy$default(ResponseDatas responseDatas, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = responseDatas.label;
            }
            if ((i & 2) != 0) {
                str2 = responseDatas.file;
            }
            return responseDatas.copy(str, str2);
        }

        public final String component1() {
            return this.label;
        }

        public final String component2() {
            return this.file;
        }

        public final ResponseDatas copy(@JsonProperty("label") String label, @JsonProperty("file") String file) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(file, "file");
            return new ResponseDatas(label, file);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseDatas) {
                ResponseDatas responseDatas = (ResponseDatas) obj;
                return Intrinsics.areEqual(this.label, responseDatas.label) && Intrinsics.areEqual(this.file, responseDatas.file);
            }
            return false;
        }

        public int hashCode() {
            return (this.label.hashCode() * 31) + this.file.hashCode();
        }

        public String toString() {
            return "ResponseDatas(label=" + this.label + ", file=" + this.file + ')';
        }

        public ResponseDatas(@JsonProperty("label") String label, @JsonProperty("file") String file) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(file, "file");
            this.label = label;
            this.file = file;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getFile() {
            return this.file;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c0 A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r33) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r23) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(2:3|(22:5|6|(1:(1:(14:10|11|(1:119)(1:17)|18|(1:118)(1:22)|(1:117)(2:26|(4:28|(4:31|(2:47|48)(2:35|(2:41|42))|43|29)|49|50))|51|(4:53|(4:56|(1:70)(5:58|59|(2:61|(1:65))(1:69)|66|67)|68|54)|71|72)(1:116)|73|74|(1:76)|77|78|(4:80|(1:99)(1:86)|87|(2:92|(18:94|(1:96)|11|(1:13)|119|18|(1:20)|118|(1:24)|117|51|(0)(0)|73|74|(0)|77|78|(3:100|(1:115)(1:104)|(2:106|107)(4:108|(1:114)|112|113))(0))(6:98|74|(0)|77|78|(0)(0)))(5:89|(0)|77|78|(0)(0)))(0))(2:120|121))(1:122))(2:227|(1:229)(1:230))|123|(1:226)(1:127)|128|(1:130)|131|(1:133)(1:225)|134|(1:136)|137|(1:139)(1:224)|140|141|(1:222)(4:145|(6:148|(7:151|152|153|154|155|(3:207|208|209)(10:157|158|159|160|161|162|163|(1:165)|166|167)|168)|214|215|168|146)|217|218)|219|171|(7:174|(1:176)(1:197)|(2:185|(4:187|(1:189)|190|(3:192|(1:194)|(3:196|(3:180|181|182)(1:184)|183))))|178|(0)(0)|183|172)|198|199|(3:201|78|(0)(0))(4:202|(1:102)|115|(0)(0))))|231|6|(0)(0)|123|(1:125)|226|128|(0)|131|(0)(0)|134|(0)|137|(0)(0)|140|141|(1:143)|222|219|171|(1:172)|198|199|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b6, code lost:
        r48 = r1;
        r16 = r3;
        r26 = r4;
        r15 = r24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x01db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e1  */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object, org.jsoup.select.Elements] */
    /* JADX WARN: Type inference failed for: r4v37, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x02e0 -> B:185:0x04bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0343 -> B:124:0x0346). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x0488 -> B:184:0x048f). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r48, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r49) {
        /*
            Method dump skipped, instructions count: 1371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        Ref.IntRef intRef = new Ref.IntRef();
        AppUtils appUtils = AppUtils.INSTANCE;
        ParCollections.apmap((List) MainAPIKt.getMapper().readValue(str, new TypeReference<List<? extends String>>() { // from class: com.lagradost.cloudstream3.movieproviders.KdramaHoodProvider$loadLinks$$inlined$parseJson$1
        }), new KdramaHoodProvider$loadLinks$2(intRef, this, function1, function12, null));
        return boxing.boxBoolean(intRef.element > 0);
    }
}
