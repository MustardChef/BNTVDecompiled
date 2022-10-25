package com.lagradost.cloudstream3.movieproviders;

import androidx.core.view.MotionEventCompat;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.internal.progressionUtil;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: BflixProvider.kt */
@Metadata(m108d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0004:;<=B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0011\u0010\u001f\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002J\u001b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u001e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)JI\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00042\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002000.H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J!\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u00108\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u00109\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/BflixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasMainPage", "getHasMainPage", SDKConstants.PARAM_KEY, "", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "decode", TvContractCompat.PARAM_INPUT, "encode", "getLink", "url", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVrf", "id", "je", "inputOne", "inputTwo", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "ue", "ze", "Links", "Response", "Servers", "Subtitles", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class BflixProvider extends MainAPI {
    private String mainUrl = "https://bflix.ru";
    private String name = "Bflix";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});
    private final String key = "5uLKesbh0nkrpPq9VwMC6+tQBdomjJ4HNl/fWOSiREvAYagT8yIG7zx2D13UZFXc";

    /* compiled from: BflixProvider.kt */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider r27, kotlin.coroutines.Continuation r28) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.BflixProvider.getMainPage$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getVrf(String str) {
        String replace$default;
        String obj = StringsKt.reversed((CharSequence) StringsKt.slice(m139ue(encode(str) + "0000000"), new IntRange(0, 5))).toString();
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        String encode = encode(str);
        if (encode == null || (replace$default = StringsKt.replace$default(encode, "+", "%20", false, 4, (Object) null)) == null) {
            return null;
        }
        sb.append(new Regex("=+$").replace(m139ue(m140je(obj, replace$default)), ""));
        return sb.toString();
    }

    private final String getLink(String str) {
        return decode(m140je(StringsKt.slice(str, new IntRange(0, 5)), m138ze(StringsKt.slice(str, new IntRange(6, StringsKt.getLastIndex(str))))));
    }

    /* renamed from: ue */
    private final String m139ue(String str) {
        boolean z;
        String str2 = str;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                z = false;
                break;
            }
            if (str2.charAt(i) >= 256) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            throw new Exception("illegal characters!");
        }
        String str3 = "";
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, str.length() - 1, 3);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = {-1, -1, -1, -1};
                iArr[0] = str.charAt(i2) >> 2;
                iArr[1] = (str.charAt(i2) & 3) << 4;
                int i3 = i2 + 1;
                if (str.length() > i3) {
                    iArr[1] = iArr[1] | (str.charAt(i3) >> 4);
                    iArr[2] = (str.charAt(i3) & 15) << 2;
                }
                int i4 = i2 + 2;
                if (str.length() > i4) {
                    iArr[2] = iArr[2] | (str.charAt(i4) >> 6);
                    iArr[3] = str.charAt(i4) & '?';
                }
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = iArr[i5];
                    if (i6 == -1) {
                        str3 = str3 + '=';
                    } else if (i6 >= 0 && i6 < 64) {
                        str3 = str3 + this.key.charAt(i6);
                    }
                }
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 3;
            }
        }
        return str3;
    }

    /* renamed from: je */
    private final String m140je(String str, String str2) {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = ((i2 + iArr[i3]) + str.charAt(i3 % str.length())) % 256;
            int i4 = iArr[i3];
            iArr[i3] = iArr[i2];
            iArr[i2] = i4;
        }
        int length = str2.length();
        String str3 = "";
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            i5 = (i5 + i7) % 256;
            i6 = (i6 + iArr[i5]) % 256;
            int i8 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i8;
            str3 = str3 + ((char) (str2.charAt(i7) ^ iArr[(iArr[i5] + iArr[i6]) % 256]));
        }
        return str3;
    }

    /* renamed from: ze */
    private final String m138ze(String str) {
        String str2 = str;
        String str3 = "";
        if (new Regex("[\\t\\n\\f\\r]").replace(str2, "").length() % 4 == 0) {
            str = new Regex("/==?$/").replace(str2, "");
        }
        if (str.length() % 4 != 1) {
            if (!new Regex("[^+/0-9A-Za-z]").containsMatchIn(str)) {
                int length = str.length();
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    i2 = (i2 << 6) | StringsKt.indexOf$default((CharSequence) this.key, str.charAt(i3), 0, false, 6, (Object) null);
                    i += 6;
                    if (24 == i) {
                        str3 = ((str3 + ((char) ((16711680 & i2) >> 16))) + ((char) ((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8))) + ((char) (i2 & 255));
                        i = 0;
                        i2 = 0;
                    }
                }
                if (12 == i) {
                    return str3 + ((char) (i2 >> 4));
                }
                if (18 == i) {
                    int i4 = i2 >> 2;
                    str3 = (str3 + ((char) ((i4 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8))) + ((char) (i4 & 255));
                }
                return str3;
            }
        }
        throw new Exception("bad input");
    }

    private final String encode(String str) {
        return URLEncoder.encode(str, "utf-8");
    }

    private final String decode(String str) {
        return URLDecoder.decode(str, "utf-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object search$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider r20, java.lang.String r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.BflixProvider.search$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: BflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/BflixProvider$Response;", "", "html", "", "(Ljava/lang/String;)V", "getHtml", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
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

        public final Response copy(@JsonProperty("html") String html) {
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

        public Response(@JsonProperty("html") String html) {
            Intrinsics.checkNotNullParameter(html, "html");
            this.html = html;
        }

        public final String getHtml() {
            return this.html;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0307 A[EDGE_INSN: B:139:0x0307->B:65:0x0307 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03c2  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object load$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider r56, java.lang.String r57, kotlin.coroutines.Continuation r58) {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.BflixProvider.load$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: BflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/BflixProvider$Subtitles;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "kind", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKind", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Subtitles {
        private final String file;
        private final String kind;
        private final String label;

        public static /* synthetic */ Subtitles copy$default(Subtitles subtitles, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitles.file;
            }
            if ((i & 2) != 0) {
                str2 = subtitles.label;
            }
            if ((i & 4) != 0) {
                str3 = subtitles.kind;
            }
            return subtitles.copy(str, str2, str3);
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

        public final Subtitles copy(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("kind") String kind) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(kind, "kind");
            return new Subtitles(file, label, kind);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Subtitles) {
                Subtitles subtitles = (Subtitles) obj;
                return Intrinsics.areEqual(this.file, subtitles.file) && Intrinsics.areEqual(this.label, subtitles.label) && Intrinsics.areEqual(this.kind, subtitles.kind);
            }
            return false;
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + this.kind.hashCode();
        }

        public String toString() {
            return "Subtitles(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Subtitles(@JsonProperty("file") String file, @JsonProperty("label") String label, @JsonProperty("kind") String kind) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(kind, "kind");
            this.file = file;
            this.label = label;
            this.kind = kind;
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

    /* compiled from: BflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/BflixProvider$Links;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Links {
        private final String url;

        public static /* synthetic */ Links copy$default(Links links, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = links.url;
            }
            return links.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Links copy(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Links(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Links) && Intrinsics.areEqual(this.url, ((Links) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Links(url=" + this.url + ')';
        }

        public Links(@JsonProperty("url") String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: BflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/BflixProvider$Servers;", "", "mcloud", "", "mp4upload", "streamtape", "vidstream", "videovard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMcloud", "()Ljava/lang/String;", "getMp4upload", "getStreamtape", "getVideovard", "getVidstream", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Servers {
        private final String mcloud;
        private final String mp4upload;
        private final String streamtape;
        private final String videovard;
        private final String vidstream;

        public static /* synthetic */ Servers copy$default(Servers servers, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = servers.mcloud;
            }
            if ((i & 2) != 0) {
                str2 = servers.mp4upload;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = servers.streamtape;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = servers.vidstream;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = servers.videovard;
            }
            return servers.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.mcloud;
        }

        public final String component2() {
            return this.mp4upload;
        }

        public final String component3() {
            return this.streamtape;
        }

        public final String component4() {
            return this.vidstream;
        }

        public final String component5() {
            return this.videovard;
        }

        public final Servers copy(@JsonProperty("28") String str, @JsonProperty("35") String str2, @JsonProperty("40") String str3, @JsonProperty("41") String str4, @JsonProperty("43") String str5) {
            return new Servers(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Servers) {
                Servers servers = (Servers) obj;
                return Intrinsics.areEqual(this.mcloud, servers.mcloud) && Intrinsics.areEqual(this.mp4upload, servers.mp4upload) && Intrinsics.areEqual(this.streamtape, servers.streamtape) && Intrinsics.areEqual(this.vidstream, servers.vidstream) && Intrinsics.areEqual(this.videovard, servers.videovard);
            }
            return false;
        }

        public int hashCode() {
            String str = this.mcloud;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.mp4upload;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.streamtape;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.vidstream;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.videovard;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Servers(mcloud=" + this.mcloud + ", mp4upload=" + this.mp4upload + ", streamtape=" + this.streamtape + ", vidstream=" + this.vidstream + ", videovard=" + this.videovard + ')';
        }

        public Servers(@JsonProperty("28") String str, @JsonProperty("35") String str2, @JsonProperty("40") String str3, @JsonProperty("41") String str4, @JsonProperty("43") String str5) {
            this.mcloud = str;
            this.mp4upload = str2;
            this.streamtape = str3;
            this.vidstream = str4;
            this.videovard = str5;
        }

        public final String getMcloud() {
            return this.mcloud;
        }

        public final String getMp4upload() {
            return this.mp4upload;
        }

        public final String getStreamtape() {
            return this.streamtape;
        }

        public final String getVidstream() {
            return this.vidstream;
        }

        public final String getVideovard() {
            return this.videovard;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04bb A[LOOP:0: B:91:0x04b5->B:93:0x04bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04f9  */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r4v26, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x02e3 -> B:95:0x04e9). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0410 -> B:64:0x0331). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x048c -> B:90:0x0494). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider r42, java.lang.String r43, boolean r44, kotlin.jvm.functions.Function1 r45, kotlin.jvm.functions.Function1 r46, kotlin.coroutines.Continuation r47) {
        /*
            Method dump skipped, instructions count: 1281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.BflixProvider.loadLinks$suspendImpl(com.lagradost.cloudstream3.movieproviders.BflixProvider, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
