package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$ResumeWatchingResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1 */
/* loaded from: classes3.dex */
final class HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DataStoreHelper.ResumeWatchingResult>>, Object> {
    final /* synthetic */ List<VideoDownloadHelper.ResumeWatching> $resumeWatching;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1(List<VideoDownloadHelper.ResumeWatching> list, Continuation<? super HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1> continuation) {
        super(2, continuation);
        this.$resumeWatching = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1(this.$resumeWatching, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends DataStoreHelper.ResumeWatchingResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<DataStoreHelper.ResumeWatchingResult>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<DataStoreHelper.ResumeWatchingResult>> continuation) {
        return ((HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            if (r1 != 0) goto Lc1
            kotlin.ResultKt.throwOnFailure(r25)
            java.util.List<com.lagradost.cloudstream3.utils.VideoDownloadHelper$ResumeWatching> r1 = r0.$resumeWatching
            r2 = 0
            if (r1 == 0) goto Lc0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L24:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lb8
            java.lang.Object r4 = r1.next()
            com.lagradost.cloudstream3.utils.VideoDownloadHelper$ResumeWatching r4 = (com.lagradost.cloudstream3.utils.VideoDownloadHelper.ResumeWatching) r4
            com.lagradost.cloudstream3.AcraApplication$Companion r5 = com.lagradost.cloudstream3.AcraApplication.Companion
            int r6 = r4.getParentId()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.content.Context r5 = r5.getContext()
            if (r5 == 0) goto L68
            com.lagradost.cloudstream3.utils.DataStore r7 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r8 = "download_header_cache"
            java.lang.String r6 = r7.getFolderName(r8, r6)
            android.content.SharedPreferences r5 = r7.getSharedPrefs(r5)     // Catch: java.lang.Exception -> L68
            java.lang.String r5 = r5.getString(r6, r2)     // Catch: java.lang.Exception -> L68
            if (r5 != 0) goto L53
            goto L68
        L53:
            java.lang.String r6 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Exception -> L68
            com.fasterxml.jackson.databind.json.JsonMapper r6 = r7.getMapper()     // Catch: java.lang.Exception -> L68
            java.lang.Class<com.lagradost.cloudstream3.utils.VideoDownloadHelper$DownloadHeaderCached> r7 = com.lagradost.cloudstream3.utils.VideoDownloadHelper.DownloadHeaderCached.class
            java.lang.Object r5 = r6.readValue(r5, r7)     // Catch: java.lang.Exception -> L68
            java.lang.String r6 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Exception -> L68
            goto L69
        L68:
            r5 = r2
        L69:
            com.lagradost.cloudstream3.utils.VideoDownloadHelper$DownloadHeaderCached r5 = (com.lagradost.cloudstream3.utils.VideoDownloadHelper.DownloadHeaderCached) r5
            if (r5 != 0) goto L6f
            r6 = r2
            goto Lb3
        L6f:
            com.lagradost.cloudstream3.utils.DataStoreHelper r6 = com.lagradost.cloudstream3.utils.DataStoreHelper.INSTANCE
            java.lang.Integer r7 = r4.getEpisodeId()
            com.lagradost.cloudstream3.utils.DataStoreHelper$PosDur r14 = r6.getViewPos(r7)
            com.lagradost.cloudstream3.utils.DataStoreHelper$ResumeWatchingResult r6 = new com.lagradost.cloudstream3.utils.DataStoreHelper$ResumeWatchingResult
            java.lang.String r9 = r5.getName()
            java.lang.String r10 = r5.getUrl()
            java.lang.String r11 = r5.getApiName()
            com.lagradost.cloudstream3.TvType r12 = r5.getType()
            java.lang.String r13 = r5.getPoster()
            java.lang.Integer r15 = r4.getEpisodeId()
            int r5 = r4.getParentId()
            java.lang.Integer r16 = kotlin.coroutines.jvm.internal.boxing.boxInt(r5)
            java.lang.Integer r17 = r4.getEpisode()
            java.lang.Integer r18 = r4.getSeason()
            boolean r19 = r4.isFromDownload()
            r20 = 0
            r21 = 0
            r22 = 6144(0x1800, float:8.61E-42)
            r23 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
        Lb3:
            r3.add(r6)
            goto L24
        Lb8:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r2 = kotlin.collections.CollectionsKt.filterNotNull(r3)
        Lc0:
            return r2
        Lc1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.home.HomeViewModel$loadResumeWatching$1$resumeWatchingResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
