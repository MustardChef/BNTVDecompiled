package com.lagradost.cloudstream3.animeproviders;

import androidx.core.view.MotionEventCompat;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.TvType;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: NineAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u0006456789B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJI\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020+0)H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u0006\u00102\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001f\u00103\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", "hasQuickSearch", "getHasQuickSearch", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getEpisodeLinks", "Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Links;", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickSearch", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "Companion", "Links", "QuickSearchResponse", "QuickSearchResult", "Response", "Result", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NineAnimeProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    private static final String cipherKey = "rTKp3auwu0ULA6II";
    private static final String nineAnimeKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private String mainUrl = "https://9anime.id";
    private String name = "9Anime";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Anime);
    private final boolean hasQuickSearch = true;

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

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Companion;", "", "()V", "cipherKey", "", "nineAnimeKey", "cipher", SDKConstants.PARAM_KEY, "text", "decode", TvContractCompat.PARAM_INPUT, "decodeVrf", "decrypt", "encode", "encodeVrf", "encrypt", "getDubStatus", "Lcom/lagradost/cloudstream3/DubStatus;", "title", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DubStatus getDubStatus(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            if (StringsKt.contains((CharSequence) title, (CharSequence) "(dub)", true)) {
                return DubStatus.Dubbed;
            }
            return DubStatus.Subbed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String encodeVrf(String str) {
            return encode(new Regex("=+$").replace(encrypt(cipher(NineAnimeProvider.cipherKey, encode(str)), NineAnimeProvider.nineAnimeKey), ""));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String decodeVrf(String str) {
            return decode(cipher(NineAnimeProvider.cipherKey, decrypt(str, NineAnimeProvider.nineAnimeKey)));
        }

        public final String encrypt(String input, String key) {
            boolean z;
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(key, "key");
            String str = input;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = false;
                    break;
                }
                if (str.charAt(i) > 255) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                throw new Exception("illegal characters!");
            }
            String str2 = "";
            int progressionLastElement = progressionUtil.getProgressionLastElement(0, input.length() - 1, 3);
            if (progressionLastElement >= 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr = {-1, -1, -1, -1};
                    iArr[0] = input.charAt(i2) >> 2;
                    iArr[1] = (input.charAt(i2) & 3) << 4;
                    int i3 = i2 + 1;
                    if (input.length() > i3) {
                        iArr[1] = iArr[1] | (input.charAt(i3) >> 4);
                        iArr[2] = (input.charAt(i3) & 15) << 2;
                    }
                    int i4 = i2 + 2;
                    if (input.length() > i4) {
                        iArr[2] = iArr[2] | (input.charAt(i4) >> 6);
                        iArr[3] = input.charAt(i4) & '?';
                    }
                    for (int i5 = 0; i5 < 4; i5++) {
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            str2 = str2 + '=';
                        } else if (i6 >= 0 && i6 < 64) {
                            str2 = str2 + key.charAt(i6);
                        }
                    }
                    if (i2 == progressionLastElement) {
                        break;
                    }
                    i2 += 3;
                }
            }
            return str2;
        }

        public final String cipher(String key, String text) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(text, "text");
            int[] iArr = new int[256];
            int i = 0;
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            Iterator<Integer> it = ArraysKt.getIndices(iArr).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                i3 = ((i3 + iArr[nextInt]) + key.charAt(nextInt % key.length())) % 256;
                int i4 = iArr[nextInt];
                iArr[nextInt] = iArr[i3];
                iArr[i3] = i4;
            }
            IntRange indices = StringsKt.getIndices(text);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
            Iterator<Integer> it2 = indices.iterator();
            int i5 = 0;
            while (it2.hasNext()) {
                int nextInt2 = ((IntIterator) it2).nextInt();
                i = (i + 1) % 256;
                i5 = (i5 + iArr[i]) % 256;
                int i6 = iArr[i];
                iArr[i] = iArr[i5];
                iArr[i5] = i6;
                arrayList.add(Character.valueOf((char) (text.charAt(nextInt2) ^ iArr[(iArr[i] + iArr[i5]) % 256])));
            }
            return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }

        private final String decrypt(String str, String str2) {
            String str3 = str;
            String str4 = "";
            if (new Regex("[\\t\\n\\f\\r]").replace(str3, "").length() % 4 == 0) {
                str = new Regex("==?$").replace(str3, "");
            }
            if (str.length() % 4 != 1) {
                if (!new Regex("[^+/0-9A-Za-z]").containsMatchIn(str)) {
                    int length = str.length();
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        i2 = (i2 << 6) | StringsKt.indexOf$default((CharSequence) str2, str.charAt(i3), 0, false, 6, (Object) null);
                        i += 6;
                        if (24 == i) {
                            str4 = ((str4 + ((char) ((16711680 & i2) >> 16))) + ((char) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8))) + ((char) (i2 & 255));
                            i = 0;
                            i2 = 0;
                        }
                    }
                    if (12 == i) {
                        return str4 + ((char) (i2 >> 4));
                    }
                    if (18 == i) {
                        int i4 = i2 >> 2;
                        str4 = (str4 + ((char) ((i4 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8))) + ((char) (i4 & 255));
                    }
                    return str4;
                }
            }
            throw new Exception("bad input");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String encode(String str) {
            String encode = URLEncoder.encode(str, "utf-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(input, \"utf-8\")");
            return StringsKt.replace$default(encode, "+", "%20", false, 4, (Object) null);
        }

        private final String decode(String str) {
            String decode = URLDecoder.decode(str, "utf-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(input, \"utf-8\")");
            return decode;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        return new HomePageResponse(ParCollections.apmap(CollectionsKt.listOf((Object[]) new Tuples[]{TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/trending?page=1", "Trending"), TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/updated-all?page=1", "All"), TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/updated-sub?page=1", "Recently Updated (SUB)"), TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/updated-dub?page=1", "Recently Updated (DUB)"), TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/updated-china?page=1", "Recently Updated (Chinese)"), TuplesKt.m100to(getMainUrl() + "/ajax/home/widget/random?page=1", "Random")}), new NineAnimeProvider$getMainPage$items$1(this, null)), null, null, null, null, 30, null);
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Response;", "", "html", "", "(Ljava/lang/String;)V", "getHtml", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Response {
        private final String html;

        public static /* synthetic */ Response copy$default(Response response, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = response.html;
            }
            return response.copy(str);
        }

        public final String component1() {
            return this.html;
        }

        public final Response copy(@JsonProperty("result") String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            return new Response(html);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Response) && Intrinsics.areEqual(this.html, ((Response) obj).html);
        }

        public int hashCode() {
            return this.html.hashCode();
        }

        public String toString() {
            return "Response(html=" + this.html + ')';
        }

        public Response(@JsonProperty("result") String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            this.html = html;
        }

        public final String getHtml() {
            return this.html;
        }
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$QuickSearchResponse;", "", "result", "Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$QuickSearchResult;", "(Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$QuickSearchResult;)V", "getResult", "()Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$QuickSearchResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class QuickSearchResponse {
        private final QuickSearchResult result;

        public QuickSearchResponse() {
            this(null, 1, null);
        }

        public static /* synthetic */ QuickSearchResponse copy$default(QuickSearchResponse quickSearchResponse, QuickSearchResult quickSearchResult, int i, Object obj) {
            if ((i & 1) != 0) {
                quickSearchResult = quickSearchResponse.result;
            }
            return quickSearchResponse.copy(quickSearchResult);
        }

        public final QuickSearchResult component1() {
            return this.result;
        }

        public final QuickSearchResponse copy(@JsonProperty("result") QuickSearchResult quickSearchResult) {
            return new QuickSearchResponse(quickSearchResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickSearchResponse) && Intrinsics.areEqual(this.result, ((QuickSearchResponse) obj).result);
        }

        public int hashCode() {
            QuickSearchResult quickSearchResult = this.result;
            if (quickSearchResult == null) {
                return 0;
            }
            return quickSearchResult.hashCode();
        }

        public String toString() {
            return "QuickSearchResponse(result=" + this.result + ')';
        }

        public QuickSearchResponse(@JsonProperty("result") QuickSearchResult quickSearchResult) {
            this.result = quickSearchResult;
        }

        public /* synthetic */ QuickSearchResponse(QuickSearchResult quickSearchResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : quickSearchResult);
        }

        public final QuickSearchResult getResult() {
            return this.result;
        }
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$QuickSearchResult;", "", "html", "", "(Ljava/lang/String;)V", "getHtml", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class QuickSearchResult {
        private final String html;

        public QuickSearchResult() {
            this(null, 1, null);
        }

        public static /* synthetic */ QuickSearchResult copy$default(QuickSearchResult quickSearchResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = quickSearchResult.html;
            }
            return quickSearchResult.copy(str);
        }

        public final String component1() {
            return this.html;
        }

        public final QuickSearchResult copy(@JsonProperty("html") String str) {
            return new QuickSearchResult(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickSearchResult) && Intrinsics.areEqual(this.html, ((QuickSearchResult) obj).html);
        }

        public int hashCode() {
            String str = this.html;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "QuickSearchResult(html=" + this.html + ')';
        }

        public QuickSearchResult(@JsonProperty("html") String str) {
            this.html = str;
        }

        public /* synthetic */ QuickSearchResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getHtml() {
            return this.html;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|(1:(1:9)(2:48|49))(2:50|(1:52)(1:53))|10|11|12|13|(1:44)(5:19|(7:22|(1:24)(1:39)|(3:33|(1:35)(1:38)|(3:37|(3:28|29|30)(1:32)|31))|26|(0)(0)|31|20)|40|41|42)))|54|6|(0)(0)|10|11|12|13|(1:15)|44) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ac, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ad, code lost:
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object quickSearch(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r23) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.quickSearch(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r21, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r22) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0312  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r41, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r42) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Result;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Result {
        private final String url;

        public Result() {
            this(null, 1, null);
        }

        public static /* synthetic */ Result copy$default(Result result, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.url;
            }
            return result.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Result copy(@JsonProperty("url") String str) {
            return new Result(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual(this.url, ((Result) obj).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Result(url=" + this.url + ')';
        }

        public Result(@JsonProperty("url") String str) {
            this.url = str;
        }

        public /* synthetic */ Result(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: NineAnimeProvider.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Links;", "", "result", "Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Result;", "(Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Result;)V", "getResult", "()Lcom/lagradost/cloudstream3/animeproviders/NineAnimeProvider$Result;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Links {
        private final Result result;

        public Links() {
            this(null, 1, null);
        }

        public static /* synthetic */ Links copy$default(Links links, Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                result = links.result;
            }
            return links.copy(result);
        }

        public final Result component1() {
            return this.result;
        }

        public final Links copy(@JsonProperty("result") Result result) {
            return new Links(result);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Links) && Intrinsics.areEqual(this.result, ((Links) obj).result);
        }

        public int hashCode() {
            Result result = this.result;
            if (result == null) {
                return 0;
            }
            return result.hashCode();
        }

        public String toString() {
            return "Links(result=" + this.result + ')';
        }

        public Links(@JsonProperty("result") Result result) {
            this.result = result;
        }

        public /* synthetic */ Links(Result result, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : result);
        }

        public final Result getResult() {
            return this.result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getEpisodeLinks(java.lang.String r21, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.Links> r22) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$1
            if (r2 == 0) goto L1a
            r2 = r1
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$1 r2 = (com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L1a
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            r3 = r20
            goto L21
        L1a:
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$1 r2 = new com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$1
            r3 = r20
            r2.<init>(r3, r1)
        L21:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            kotlin.ResultKt.throwOnFailure(r1)
            goto L88
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r4 = r1
            com.lagradost.nicehttp.Requests r4 = (com.lagradost.nicehttp.Requests) r4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = r20.getMainUrl()
            r1.append(r6)
            java.lang.String r6 = "/ajax/server/"
            r1.append(r6)
            r1.append(r0)
            java.lang.String r6 = "?vrf="
            r1.append(r6)
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$Companion r6 = com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.Companion
            java.lang.String r0 = com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.Companion.access$encodeVrf(r6, r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r1 = 0
            r16 = 0
            r18 = 2046(0x7fe, float:2.867E-42)
            r19 = 0
            r2.label = r5
            r5 = r0
            r0 = r15
            r15 = r1
            r17 = r2
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19)
            if (r1 != r0) goto L88
            return r0
        L88:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            com.lagradost.nicehttp.Requests$Companion r0 = com.lagradost.nicehttp.Requests.Companion     // Catch: java.lang.Exception -> La0
            com.fasterxml.jackson.databind.ObjectMapper r0 = r0.getMapper()     // Catch: java.lang.Exception -> La0
            java.lang.String r1 = r1.getText()     // Catch: java.lang.Exception -> La0
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$$inlined$parsedSafe$1 r2 = new com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getEpisodeLinks$$inlined$parsedSafe$1     // Catch: java.lang.Exception -> La0
            r2.<init>()     // Catch: java.lang.Exception -> La0
            com.fasterxml.jackson.core.type.TypeReference r2 = (com.fasterxml.jackson.core.type.TypeReference) r2     // Catch: java.lang.Exception -> La0
            java.lang.Object r0 = r0.readValue(r1, r2)     // Catch: java.lang.Exception -> La0
            goto La5
        La0:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.getEpisodeLinks(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
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
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$1 r2 = (com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$1 r2 = new com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r14 = 1
            if (r3 == 0) goto L44
            if (r3 != r14) goto L3c
            java.lang.Object r3 = r2.L$2
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Object r4 = r2.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider r2 = (com.lagradost.cloudstream3.animeproviders.NineAnimeProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r19 = 1
            goto L84
        L3c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L44:
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
            r4 = r23
            r2.L$1 = r4
            r22 = r15
            r15 = r24
            r2.L$2 = r15
            r2.label = r14
            r4 = r21
            r19 = 1
            r14 = r1
            r1 = r22
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L7e
            return r1
        L7e:
            r4 = r23
            r3 = r24
            r1 = r2
            r2 = r0
        L84:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            com.lagradost.nicehttp.Requests$Companion r5 = com.lagradost.nicehttp.Requests.Companion
            com.fasterxml.jackson.databind.ObjectMapper r5 = r5.getMapper()
            java.lang.String r1 = r1.getText()
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$$inlined$parsed$1 r6 = new com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$$inlined$parsed$1
            r6.<init>()
            com.fasterxml.jackson.core.type.TypeReference r6 = (com.fasterxml.jackson.core.type.TypeReference) r6
            java.lang.Object r1 = r5.readValue(r1, r6)
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$Response r1 = (com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.Response) r1
            java.lang.String r1 = r1.getHtml()
            org.jsoup.nodes.Document r1 = org.jsoup.Jsoup.parse(r1)
            java.lang.String r5 = "li"
            org.jsoup.select.Elements r1 = r1.select(r5)
            java.lang.String r5 = "document.select(\"li\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            java.util.List r1 = (java.util.List) r1
            com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$2 r5 = new com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$2
            r6 = 0
            r5.<init>(r2, r4, r3, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            com.lagradost.cloudstream3.ParCollections.apmap(r1, r5)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
