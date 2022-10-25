package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: MultiAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J!\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, m107d2 = {"Lcom/lagradost/cloudstream3/metaproviders/MultiAnimeProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "syncApi", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI;", "syncUtilType", "getSyncUtilType", "syncUtilType$delegate", "Lkotlin/Lazy;", "usesWebView", "", "getUsesWebView", "()Z", "validApis", "", "getValidApis", "()Ljava/util/List;", "validApis$delegate", "filterName", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MultiAnimeProvider extends MainAPI {
    private String name = "MultiAnime";
    private String lang = "en";
    private final boolean usesWebView = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Anime);
    private final SyncAPI syncApi = AccountManager.Companion.getAniListApi();
    private final Lazy syncUtilType$delegate = LazyKt.lazy(new MultiAnimeProvider$syncUtilType$2(this));
    private final Lazy validApis$delegate = LazyKt.lazy(new MultiAnimeProvider$validApis$2(this));

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
    public String getLang() {
        return this.lang;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getUsesWebView() {
        return this.usesWebView;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final String getSyncUtilType() {
        return (String) this.syncUtilType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MainAPI> getValidApis() {
        return (List) this.validApis$delegate.getValue();
    }

    private final String filterName(String str) {
        return new Regex("[^a-zA-Z0-9-]").replace(str, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1 A[ORIG_RETURN, RETURN] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$search$1 r2 = (com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$search$1 r2 = new com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider r2 = (com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L4d
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.syncproviders.SyncAPI r1 = r0.syncApi
            r2.L$0 = r0
            r2.label = r5
            r4 = r22
            java.lang.Object r1 = r1.search(r4, r2)
            if (r1 != r3) goto L4c
            return r3
        L4c:
            r2 = r0
        L4d:
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto La1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L64:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L9e
            java.lang.Object r4 = r1.next()
            com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncSearchResult r4 = (com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncSearchResult) r4
            com.lagradost.cloudstream3.AnimeSearchResponse r15 = new com.lagradost.cloudstream3.AnimeSearchResponse
            java.lang.String r6 = r4.getName()
            java.lang.String r7 = r4.getUrl()
            java.lang.String r8 = r2.getName()
            com.lagradost.cloudstream3.TvType r9 = com.lagradost.cloudstream3.TvType.Anime
            java.lang.String r10 = r4.getPosterUrl()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r4 = 0
            r16 = 0
            r17 = 0
            r18 = 4064(0xfe0, float:5.695E-42)
            r19 = 0
            r5 = r15
            r20 = r15
            r15 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r4 = r20
            r3.add(r4)
            goto L64
        L9e:
            java.util.List r3 = (java.util.List) r3
            goto La2
        La1:
            r3 = 0
        La2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[ORIG_RETURN, RETURN] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r18, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r19) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
