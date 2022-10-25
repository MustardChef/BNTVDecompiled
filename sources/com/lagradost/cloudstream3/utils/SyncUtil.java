package com.lagradost.cloudstream3.utils;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: SyncUtil.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0018\u0019\u001a\u001b\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil;", "", "()V", "GOGOANIME", "", "NINE_ANIME", "TAG", "TWIST_MOE", "matchList", "", "regexs", "", "Lkotlin/text/Regex;", "getIdsFromSlug", "Lkotlin/Pair;", "slug", "site", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdsFromUrl", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrlsFromId", "id", "type", "Anilist", "Mal", "MalSyncPage", "ProviderPage", "SyncPage", "SyncPages", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SyncUtil {
    private static final String TAG = "SYNCUTIL";
    public static final SyncUtil INSTANCE = new SyncUtil();
    private static final List<Regex> regexs = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(9anime)\\.(?:to|center|id)/watch/(?:.*?)\\.([^/?]*)"), new Regex("(gogoanime|gogoanimes)\\..*?/category/([^/?]*)"), new Regex("(twist\\.moe)/a/([^/?]*)")});
    private static final String NINE_ANIME = "9anime";
    private static final String GOGOANIME = "Gogoanime";
    private static final String TWIST_MOE = "Twistmoe";
    private static final Map<String, String> matchList = MapsKt.mapOf(TuplesKt.m100to(NINE_ANIME, NINE_ANIME), TuplesKt.m100to("gogoanime", GOGOANIME), TuplesKt.m100to("gogoanimes", GOGOANIME), TuplesKt.m100to("twist.moe", TWIST_MOE));

    private SyncUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b0 -> B:30:0x00b3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getIdsFromUrl(java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Tuples<java.lang.String, java.lang.String>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.lagradost.cloudstream3.utils.SyncUtil$getIdsFromUrl$1
            if (r0 == 0) goto L14
            r0 = r11
            com.lagradost.cloudstream3.utils.SyncUtil$getIdsFromUrl$1 r0 = (com.lagradost.cloudstream3.utils.SyncUtil$getIdsFromUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.lagradost.cloudstream3.utils.SyncUtil$getIdsFromUrl$1 r0 = new com.lagradost.cloudstream3.utils.SyncUtil$getIdsFromUrl$1
            r0.<init>(r9, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r10 = r0.L$1
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lb3
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 != 0) goto L42
            return r4
        L42:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = "getIdsFromUrl "
            r11.append(r2)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            java.lang.String r2 = "SYNCUTIL"
            android.util.Log.i(r2, r11)
            java.util.List<kotlin.text.Regex> r11 = com.lagradost.cloudstream3.utils.SyncUtil.regexs
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r11 = r10
            r10 = r8
        L61:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lbd
            java.lang.Object r2 = r10.next()
            kotlin.text.Regex r2 = (kotlin.text.Regex) r2
            r5 = r11
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            r7 = 2
            kotlin.text.MatchResult r2 = kotlin.text.Regex.find$default(r2, r5, r6, r7, r4)
            if (r2 == 0) goto L61
            java.util.List r5 = r2.getGroupValues()
            int r5 = r5.size()
            r6 = 3
            if (r5 != r6) goto L61
            java.util.List r5 = r2.getGroupValues()
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r2 = r2.getGroupValues()
            java.lang.Object r2 = r2.get(r7)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map<java.lang.String, java.lang.String> r6 = com.lagradost.cloudstream3.utils.SyncUtil.matchList
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L61
            com.lagradost.cloudstream3.utils.SyncUtil r6 = com.lagradost.cloudstream3.utils.SyncUtil.INSTANCE
            r0.L$0 = r11
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r2 = r6.getIdsFromSlug(r2, r5, r0)
            if (r2 != r1) goto Lb0
            return r1
        Lb0:
            r8 = r2
            r2 = r11
            r11 = r8
        Lb3:
            kotlin.Pair r11 = (kotlin.Tuples) r11
            if (r11 == 0) goto Lb8
            return r11
        Lb8:
            r11 = r4
            java.lang.Void r11 = (java.lang.Void) r11
            r11 = r2
            goto L61
        Lbd:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.SyncUtil.getIdsFromUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:11:0x0032, B:21:0x00a7, B:23:0x00c2, B:37:0x00ea, B:45:0x0101, B:47:0x0107, B:49:0x010e, B:40:0x00f2, B:42:0x00f8, B:26:0x00ca, B:28:0x00d0, B:32:0x00db, B:34:0x00e1, B:18:0x0062), top: B:54:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0113 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getIdsFromSlug(java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation<? super kotlin.Tuples<java.lang.String, java.lang.String>> r25) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.SyncUtil.getIdsFromSlug(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getIdsFromSlug$default(SyncUtil syncUtil, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = GOGOANIME;
        }
        return syncUtil.getIdsFromSlug(str, str2, continuation);
    }

    public static /* synthetic */ Object getUrlsFromId$default(SyncUtil syncUtil, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "anilist";
        }
        return syncUtil.getUrlsFromId(str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUrlsFromId(java.lang.String r20, java.lang.String r21, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r22) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.SyncUtil.getUrlsFromId(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$SyncPage;", "", "pages", "Lcom/lagradost/cloudstream3/utils/SyncUtil$SyncPages;", "(Lcom/lagradost/cloudstream3/utils/SyncUtil$SyncPages;)V", "getPages", "()Lcom/lagradost/cloudstream3/utils/SyncUtil$SyncPages;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class SyncPage {
        private final SyncPages pages;

        public static /* synthetic */ SyncPage copy$default(SyncPage syncPage, SyncPages syncPages, int i, Object obj) {
            if ((i & 1) != 0) {
                syncPages = syncPage.pages;
            }
            return syncPage.copy(syncPages);
        }

        public final SyncPages component1() {
            return this.pages;
        }

        public final SyncPage copy(@JsonProperty("Pages") SyncPages syncPages) {
            return new SyncPage(syncPages);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SyncPage) && Intrinsics.areEqual(this.pages, ((SyncPage) obj).pages);
        }

        public int hashCode() {
            SyncPages syncPages = this.pages;
            if (syncPages == null) {
                return 0;
            }
            return syncPages.hashCode();
        }

        public String toString() {
            return "SyncPage(pages=" + this.pages + ')';
        }

        public SyncPage(@JsonProperty("Pages") SyncPages syncPages) {
            this.pages = syncPages;
        }

        public final SyncPages getPages() {
            return this.pages;
        }
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0014\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003JK\u0010\u0010\u001a\u00020\u00002\u0014\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$SyncPages;", "", "nineanime", "", "", "Lcom/lagradost/cloudstream3/utils/SyncUtil$ProviderPage;", "gogoanime", "twistmoe", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getGogoanime", "()Ljava/util/Map;", "getNineanime", "getTwistmoe", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class SyncPages {
        private final Map<String, ProviderPage> gogoanime;
        private final Map<String, ProviderPage> nineanime;
        private final Map<String, ProviderPage> twistmoe;

        public SyncPages() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SyncPages copy$default(SyncPages syncPages, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                map = syncPages.nineanime;
            }
            if ((i & 2) != 0) {
                map2 = syncPages.gogoanime;
            }
            if ((i & 4) != 0) {
                map3 = syncPages.twistmoe;
            }
            return syncPages.copy(map, map2, map3);
        }

        public final Map<String, ProviderPage> component1() {
            return this.nineanime;
        }

        public final Map<String, ProviderPage> component2() {
            return this.gogoanime;
        }

        public final Map<String, ProviderPage> component3() {
            return this.twistmoe;
        }

        public final SyncPages copy(@JsonProperty("9anime") Map<String, ProviderPage> nineanime, @JsonProperty("Gogoanime") Map<String, ProviderPage> gogoanime, @JsonProperty("Twistmoe") Map<String, ProviderPage> twistmoe) {
            Intrinsics.checkNotNullParameter(nineanime, "nineanime");
            Intrinsics.checkNotNullParameter(gogoanime, "gogoanime");
            Intrinsics.checkNotNullParameter(twistmoe, "twistmoe");
            return new SyncPages(nineanime, gogoanime, twistmoe);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SyncPages) {
                SyncPages syncPages = (SyncPages) obj;
                return Intrinsics.areEqual(this.nineanime, syncPages.nineanime) && Intrinsics.areEqual(this.gogoanime, syncPages.gogoanime) && Intrinsics.areEqual(this.twistmoe, syncPages.twistmoe);
            }
            return false;
        }

        public int hashCode() {
            return (((this.nineanime.hashCode() * 31) + this.gogoanime.hashCode()) * 31) + this.twistmoe.hashCode();
        }

        public String toString() {
            return "SyncPages(nineanime=" + this.nineanime + ", gogoanime=" + this.gogoanime + ", twistmoe=" + this.twistmoe + ')';
        }

        public SyncPages(@JsonProperty("9anime") Map<String, ProviderPage> nineanime, @JsonProperty("Gogoanime") Map<String, ProviderPage> gogoanime, @JsonProperty("Twistmoe") Map<String, ProviderPage> twistmoe) {
            Intrinsics.checkNotNullParameter(nineanime, "nineanime");
            Intrinsics.checkNotNullParameter(gogoanime, "gogoanime");
            Intrinsics.checkNotNullParameter(twistmoe, "twistmoe");
            this.nineanime = nineanime;
            this.gogoanime = gogoanime;
            this.twistmoe = twistmoe;
        }

        public /* synthetic */ SyncPages(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3);
        }

        public final Map<String, ProviderPage> getNineanime() {
            return this.nineanime;
        }

        public final Map<String, ProviderPage> getGogoanime() {
            return this.gogoanime;
        }

        public final Map<String, ProviderPage> getTwistmoe() {
            return this.twistmoe;
        }
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$ProviderPage;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class ProviderPage {
        private final String url;

        public static /* synthetic */ ProviderPage copy$default(ProviderPage providerPage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = providerPage.url;
            }
            return providerPage.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final ProviderPage copy(@JsonProperty("url") String str) {
            return new ProviderPage(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProviderPage) && Intrinsics.areEqual(this.url, ((ProviderPage) obj).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ProviderPage(url=" + this.url + ')';
        }

        public ProviderPage(@JsonProperty("url") String str) {
            this.url = str;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJæ\u0001\u0010E\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u000fHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010%\u001a\u0004\b+\u0010$R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"¨\u0006K"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$MalSyncPage;", "", "identifier", "", "type", "page", "title", "url", "image", "hentai", "", "sticky", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "actor", "malId", "", "aniId", "createdAt", "updatedAt", "deletedAt", "Mal", "Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;", "Anilist", "Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;", "malUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;Ljava/lang/String;)V", "getAnilist", "()Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;", "getMal", "()Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActor", "()Ljava/lang/String;", "getAniId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatedAt", "getDeletedAt", "getHentai", "getIdentifier", "getImage", "getMalId", "getMalUrl", "getPage", "getSticky", "getTitle", "getType", "getUpdatedAt", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;Ljava/lang/String;)Lcom/lagradost/cloudstream3/utils/SyncUtil$MalSyncPage;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class MalSyncPage {
        private final Anilist Anilist;
        private final Mal Mal;
        private final Boolean active;
        private final String actor;
        private final Integer aniId;
        private final String createdAt;
        private final String deletedAt;
        private final Boolean hentai;
        private final String identifier;
        private final String image;
        private final Integer malId;
        private final String malUrl;
        private final String page;
        private final Boolean sticky;
        private final String title;
        private final String type;
        private final String updatedAt;
        private final String url;

        public final String component1() {
            return this.identifier;
        }

        public final String component10() {
            return this.actor;
        }

        public final Integer component11() {
            return this.malId;
        }

        public final Integer component12() {
            return this.aniId;
        }

        public final String component13() {
            return this.createdAt;
        }

        public final String component14() {
            return this.updatedAt;
        }

        public final String component15() {
            return this.deletedAt;
        }

        public final Mal component16() {
            return this.Mal;
        }

        public final Anilist component17() {
            return this.Anilist;
        }

        public final String component18() {
            return this.malUrl;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.page;
        }

        public final String component4() {
            return this.title;
        }

        public final String component5() {
            return this.url;
        }

        public final String component6() {
            return this.image;
        }

        public final Boolean component7() {
            return this.hentai;
        }

        public final Boolean component8() {
            return this.sticky;
        }

        public final Boolean component9() {
            return this.active;
        }

        public final MalSyncPage copy(@JsonProperty("identifier") String str, @JsonProperty("type") String str2, @JsonProperty("page") String str3, @JsonProperty("title") String str4, @JsonProperty("url") String str5, @JsonProperty("image") String str6, @JsonProperty("hentai") Boolean bool, @JsonProperty("sticky") Boolean bool2, @JsonProperty("active") Boolean bool3, @JsonProperty("actor") String str7, @JsonProperty("malId") Integer num, @JsonProperty("aniId") Integer num2, @JsonProperty("createdAt") String str8, @JsonProperty("updatedAt") String str9, @JsonProperty("deletedAt") String str10, @JsonProperty("Mal") Mal mal, @JsonProperty("Anilist") Anilist anilist, @JsonProperty("malUrl") String str11) {
            return new MalSyncPage(str, str2, str3, str4, str5, str6, bool, bool2, bool3, str7, num, num2, str8, str9, str10, mal, anilist, str11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalSyncPage) {
                MalSyncPage malSyncPage = (MalSyncPage) obj;
                return Intrinsics.areEqual(this.identifier, malSyncPage.identifier) && Intrinsics.areEqual(this.type, malSyncPage.type) && Intrinsics.areEqual(this.page, malSyncPage.page) && Intrinsics.areEqual(this.title, malSyncPage.title) && Intrinsics.areEqual(this.url, malSyncPage.url) && Intrinsics.areEqual(this.image, malSyncPage.image) && Intrinsics.areEqual(this.hentai, malSyncPage.hentai) && Intrinsics.areEqual(this.sticky, malSyncPage.sticky) && Intrinsics.areEqual(this.active, malSyncPage.active) && Intrinsics.areEqual(this.actor, malSyncPage.actor) && Intrinsics.areEqual(this.malId, malSyncPage.malId) && Intrinsics.areEqual(this.aniId, malSyncPage.aniId) && Intrinsics.areEqual(this.createdAt, malSyncPage.createdAt) && Intrinsics.areEqual(this.updatedAt, malSyncPage.updatedAt) && Intrinsics.areEqual(this.deletedAt, malSyncPage.deletedAt) && Intrinsics.areEqual(this.Mal, malSyncPage.Mal) && Intrinsics.areEqual(this.Anilist, malSyncPage.Anilist) && Intrinsics.areEqual(this.malUrl, malSyncPage.malUrl);
            }
            return false;
        }

        public int hashCode() {
            String str = this.identifier;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.page;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.title;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.url;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.image;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Boolean bool = this.hentai;
            int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.sticky;
            int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.active;
            int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str7 = this.actor;
            int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num = this.malId;
            int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.aniId;
            int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str8 = this.createdAt;
            int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.updatedAt;
            int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.deletedAt;
            int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Mal mal = this.Mal;
            int hashCode16 = (hashCode15 + (mal == null ? 0 : mal.hashCode())) * 31;
            Anilist anilist = this.Anilist;
            int hashCode17 = (hashCode16 + (anilist == null ? 0 : anilist.hashCode())) * 31;
            String str11 = this.malUrl;
            return hashCode17 + (str11 != null ? str11.hashCode() : 0);
        }

        public String toString() {
            return "MalSyncPage(identifier=" + this.identifier + ", type=" + this.type + ", page=" + this.page + ", title=" + this.title + ", url=" + this.url + ", image=" + this.image + ", hentai=" + this.hentai + ", sticky=" + this.sticky + ", active=" + this.active + ", actor=" + this.actor + ", malId=" + this.malId + ", aniId=" + this.aniId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", Mal=" + this.Mal + ", Anilist=" + this.Anilist + ", malUrl=" + this.malUrl + ')';
        }

        public MalSyncPage(@JsonProperty("identifier") String str, @JsonProperty("type") String str2, @JsonProperty("page") String str3, @JsonProperty("title") String str4, @JsonProperty("url") String str5, @JsonProperty("image") String str6, @JsonProperty("hentai") Boolean bool, @JsonProperty("sticky") Boolean bool2, @JsonProperty("active") Boolean bool3, @JsonProperty("actor") String str7, @JsonProperty("malId") Integer num, @JsonProperty("aniId") Integer num2, @JsonProperty("createdAt") String str8, @JsonProperty("updatedAt") String str9, @JsonProperty("deletedAt") String str10, @JsonProperty("Mal") Mal mal, @JsonProperty("Anilist") Anilist anilist, @JsonProperty("malUrl") String str11) {
            this.identifier = str;
            this.type = str2;
            this.page = str3;
            this.title = str4;
            this.url = str5;
            this.image = str6;
            this.hentai = bool;
            this.sticky = bool2;
            this.active = bool3;
            this.actor = str7;
            this.malId = num;
            this.aniId = num2;
            this.createdAt = str8;
            this.updatedAt = str9;
            this.deletedAt = str10;
            this.Mal = mal;
            this.Anilist = anilist;
            this.malUrl = str11;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getType() {
            return this.type;
        }

        public final String getPage() {
            return this.page;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getImage() {
            return this.image;
        }

        public final Boolean getHentai() {
            return this.hentai;
        }

        public final Boolean getSticky() {
            return this.sticky;
        }

        public final Boolean getActive() {
            return this.active;
        }

        public final String getActor() {
            return this.actor;
        }

        public final Integer getMalId() {
            return this.malId;
        }

        public final Integer getAniId() {
            return this.aniId;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getDeletedAt() {
            return this.deletedAt;
        }

        public final Mal getMal() {
            return this.Mal;
        }

        public final Anilist getAnilist() {
            return this.Anilist;
        }

        public final String getMalUrl() {
            return this.malUrl;
        }
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0092\u0001\u0010,\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u00062"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;", "", "id", "", "malId", "type", "", "title", "url", "image", MonitorLogServerProtocol.PARAM_CATEGORY, "hentai", "", "createdAt", "updatedAt", "deletedAt", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getCreatedAt", "getDeletedAt", "getHentai", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getMalId", "getTitle", "getType", "getUpdatedAt", "getUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/utils/SyncUtil$Anilist;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Anilist {
        private final String category;
        private final String createdAt;
        private final String deletedAt;
        private final Boolean hentai;

        /* renamed from: id */
        private final Integer f10029id;
        private final String image;
        private final Integer malId;
        private final String title;
        private final String type;
        private final String updatedAt;
        private final String url;

        public final Integer component1() {
            return this.f10029id;
        }

        public final String component10() {
            return this.updatedAt;
        }

        public final String component11() {
            return this.deletedAt;
        }

        public final Integer component2() {
            return this.malId;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.title;
        }

        public final String component5() {
            return this.url;
        }

        public final String component6() {
            return this.image;
        }

        public final String component7() {
            return this.category;
        }

        public final Boolean component8() {
            return this.hentai;
        }

        public final String component9() {
            return this.createdAt;
        }

        public final Anilist copy(@JsonProperty("id") Integer num, @JsonProperty("malId") Integer num2, @JsonProperty("type") String str, @JsonProperty("title") String str2, @JsonProperty("url") String str3, @JsonProperty("image") String str4, @JsonProperty("category") String str5, @JsonProperty("hentai") Boolean bool, @JsonProperty("createdAt") String str6, @JsonProperty("updatedAt") String str7, @JsonProperty("deletedAt") String str8) {
            return new Anilist(num, num2, str, str2, str3, str4, str5, bool, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Anilist) {
                Anilist anilist = (Anilist) obj;
                return Intrinsics.areEqual(this.f10029id, anilist.f10029id) && Intrinsics.areEqual(this.malId, anilist.malId) && Intrinsics.areEqual(this.type, anilist.type) && Intrinsics.areEqual(this.title, anilist.title) && Intrinsics.areEqual(this.url, anilist.url) && Intrinsics.areEqual(this.image, anilist.image) && Intrinsics.areEqual(this.category, anilist.category) && Intrinsics.areEqual(this.hentai, anilist.hentai) && Intrinsics.areEqual(this.createdAt, anilist.createdAt) && Intrinsics.areEqual(this.updatedAt, anilist.updatedAt) && Intrinsics.areEqual(this.deletedAt, anilist.deletedAt);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10029id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.malId;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.type;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.title;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.url;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.image;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.category;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool = this.hentai;
            int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str6 = this.createdAt;
            int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.updatedAt;
            int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.deletedAt;
            return hashCode10 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "Anilist(id=" + this.f10029id + ", malId=" + this.malId + ", type=" + this.type + ", title=" + this.title + ", url=" + this.url + ", image=" + this.image + ", category=" + this.category + ", hentai=" + this.hentai + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ')';
        }

        public Anilist(@JsonProperty("id") Integer num, @JsonProperty("malId") Integer num2, @JsonProperty("type") String str, @JsonProperty("title") String str2, @JsonProperty("url") String str3, @JsonProperty("image") String str4, @JsonProperty("category") String str5, @JsonProperty("hentai") Boolean bool, @JsonProperty("createdAt") String str6, @JsonProperty("updatedAt") String str7, @JsonProperty("deletedAt") String str8) {
            this.f10029id = num;
            this.malId = num2;
            this.type = str;
            this.title = str2;
            this.url = str3;
            this.image = str4;
            this.category = str5;
            this.hentai = bool;
            this.createdAt = str6;
            this.updatedAt = str7;
            this.deletedAt = str8;
        }

        public final Integer getId() {
            return this.f10029id;
        }

        public final Integer getMalId() {
            return this.malId;
        }

        public final String getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getCategory() {
            return this.category;
        }

        public final Boolean getHentai() {
            return this.hentai;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getDeletedAt() {
            return this.deletedAt;
        }
    }

    /* compiled from: SyncUtil.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0086\u0001\u0010)\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006/"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;", "", "id", "", "type", "", "title", "url", "image", MonitorLogServerProtocol.PARAM_CATEGORY, "hentai", "", "createdAt", "updatedAt", "deletedAt", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getCreatedAt", "getDeletedAt", "getHentai", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getTitle", "getType", "getUpdatedAt", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/utils/SyncUtil$Mal;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Mal {
        private final String category;
        private final String createdAt;
        private final String deletedAt;
        private final Boolean hentai;

        /* renamed from: id */
        private final Integer f10030id;
        private final String image;
        private final String title;
        private final String type;
        private final String updatedAt;
        private final String url;

        public final Integer component1() {
            return this.f10030id;
        }

        public final String component10() {
            return this.deletedAt;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.url;
        }

        public final String component5() {
            return this.image;
        }

        public final String component6() {
            return this.category;
        }

        public final Boolean component7() {
            return this.hentai;
        }

        public final String component8() {
            return this.createdAt;
        }

        public final String component9() {
            return this.updatedAt;
        }

        public final Mal copy(@JsonProperty("id") Integer num, @JsonProperty("type") String str, @JsonProperty("title") String str2, @JsonProperty("url") String str3, @JsonProperty("image") String str4, @JsonProperty("category") String str5, @JsonProperty("hentai") Boolean bool, @JsonProperty("createdAt") String str6, @JsonProperty("updatedAt") String str7, @JsonProperty("deletedAt") String str8) {
            return new Mal(num, str, str2, str3, str4, str5, bool, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Mal) {
                Mal mal = (Mal) obj;
                return Intrinsics.areEqual(this.f10030id, mal.f10030id) && Intrinsics.areEqual(this.type, mal.type) && Intrinsics.areEqual(this.title, mal.title) && Intrinsics.areEqual(this.url, mal.url) && Intrinsics.areEqual(this.image, mal.image) && Intrinsics.areEqual(this.category, mal.category) && Intrinsics.areEqual(this.hentai, mal.hentai) && Intrinsics.areEqual(this.createdAt, mal.createdAt) && Intrinsics.areEqual(this.updatedAt, mal.updatedAt) && Intrinsics.areEqual(this.deletedAt, mal.deletedAt);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10030id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.type;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.title;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.url;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.image;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.category;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool = this.hentai;
            int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str6 = this.createdAt;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.updatedAt;
            int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.deletedAt;
            return hashCode9 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "Mal(id=" + this.f10030id + ", type=" + this.type + ", title=" + this.title + ", url=" + this.url + ", image=" + this.image + ", category=" + this.category + ", hentai=" + this.hentai + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ')';
        }

        public Mal(@JsonProperty("id") Integer num, @JsonProperty("type") String str, @JsonProperty("title") String str2, @JsonProperty("url") String str3, @JsonProperty("image") String str4, @JsonProperty("category") String str5, @JsonProperty("hentai") Boolean bool, @JsonProperty("createdAt") String str6, @JsonProperty("updatedAt") String str7, @JsonProperty("deletedAt") String str8) {
            this.f10030id = num;
            this.type = str;
            this.title = str2;
            this.url = str3;
            this.image = str4;
            this.category = str5;
            this.hentai = bool;
            this.createdAt = str6;
            this.updatedAt = str7;
            this.deletedAt = str8;
        }

        public final Integer getId() {
            return this.f10030id;
        }

        public final String getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getCategory() {
            return this.category;
        }

        public final Boolean getHentai() {
            return this.hentai;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getDeletedAt() {
            return this.deletedAt;
        }
    }
}
