package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0015H\u0002J\u0011\u0010\u0016\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJI\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020#0!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/NginxProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getAuthHeader", "", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxProvider extends MainAPI {
    public static final Companion Companion = new Companion(null);
    public static final String ERROR_STRING = "No nginx url specified in the settings";
    private static String loginCredentials;
    private static String overrideUrl;
    private final boolean hasQuickSearch;
    private String name = "Nginx";
    private final boolean hasMainPage = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.AnimeMovie, TvType.TvSeries, TvType.Movie});

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
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* compiled from: NginxProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/NginxProvider$Companion;", "", "()V", "ERROR_STRING", "", "loginCredentials", "getLoginCredentials", "()Ljava/lang/String;", "setLoginCredentials", "(Ljava/lang/String;)V", "overrideUrl", "getOverrideUrl", "setOverrideUrl", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLoginCredentials() {
            return NginxProvider.loginCredentials;
        }

        public final void setLoginCredentials(String str) {
            NginxProvider.loginCredentials = str;
        }

        public final String getOverrideUrl() {
            return NginxProvider.overrideUrl;
        }

        public final void setOverrideUrl(String str) {
            NginxProvider.overrideUrl = str;
        }
    }

    private final Map<String, String> getAuthHeader() {
        String str = overrideUrl;
        if (str == null) {
            throw new ErrorLoadingException(ERROR_STRING);
        }
        setMainUrl(str);
        System.out.println((Object) ("OVERRIDING URL TO " + overrideUrl));
        if (Intrinsics.areEqual(getMainUrl(), "NONE") || StringsKt.isBlank(getMainUrl())) {
            throw new ErrorLoadingException(ERROR_STRING);
        }
        String str2 = loginCredentials;
        if (str2 == null || Intrinsics.areEqual(StringsKt.trim((CharSequence) str2).toString(), ":")) {
            return MapsKt.mapOf(TuplesKt.m100to("Authorization", "Basic "));
        }
        byte[] bytes = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String base64Encode = MainAPIKt.base64Encode(bytes);
        return MapsKt.mapOf(TuplesKt.m100to("Authorization", "Basic " + base64Encode));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0308 A[EDGE_INSN: B:132:0x0308->B:76:0x0308 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0192 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0302 A[LOOP:4: B:62:0x02c3->B:74:0x0302, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x043e  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r45, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r46) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.NginxProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        function12.invoke(new ExtractorLink(getName(), getName(), str, str, Qualities.Unknown.getValue(), false, getAuthHeader(), null, 128, null));
        return boxing.boxBoolean(true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(1:32)|33|34|35|36|37|38|(1:40)(8:42|43|44|45|(1:47)(1:59)|48|49|(1:51)(5:52|16|17|18|(8:20|21|22|23|(0)|26|27|(7:67|(1:101)(1:71)|72|(1:74)|75|76|(6:78|(1:98)(6:82|(1:84)(1:97)|85|(1:87)(1:96)|88|(1:90)(2:91|(1:93)(4:94|95|27|(0)(0))))|(0)|75|76|(2:99|100)(0))(0))(0))(0)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:42|43|44|45|(1:47)(1:59)|48|49|(1:51)(5:52|16|17|18|(8:20|21|22|23|(0)|26|27|(7:67|(1:101)(1:71)|72|(1:74)|75|76|(6:78|(1:98)(6:82|(1:84)(1:97)|85|(1:87)(1:96)|88|(1:90)(2:91|(1:93)(4:94|95|27|(0)(0))))|(0)|75|76|(2:99|100)(0))(0))(0))(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x03dd, code lost:
        r0 = r3;
        r6 = r4;
        r7 = r7;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x03e6, code lost:
        r16 = r6;
        r6 = r1;
        r11 = r5;
        r0 = r9;
        r18 = null;
        r12 = r13;
        r13 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x03f9, code lost:
        r9 = r4;
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0336 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0390 A[Catch: Exception -> 0x03d1, TRY_LEAVE, TryCatch #7 {Exception -> 0x03d1, blocks: (B:78:0x034b, B:79:0x0390), top: B:125:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0426  */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v29, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v32, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v28, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v31, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0463 -> B:105:0x046c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01d2 -> B:105:0x046c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0224 -> B:54:0x0249). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0337 -> B:121:0x033d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x03fa -> B:91:0x0404). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x0407 -> B:93:0x040e). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r49) {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.NginxProvider.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
