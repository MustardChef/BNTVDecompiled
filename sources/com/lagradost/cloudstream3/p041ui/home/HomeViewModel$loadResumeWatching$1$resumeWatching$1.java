package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$ResumeWatching;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadResumeWatching$1$resumeWatching$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadResumeWatching$1$resumeWatching$1 */
/* loaded from: classes3.dex */
final class HomeViewModel$loadResumeWatching$1$resumeWatching$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VideoDownloadHelper.ResumeWatching>>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeViewModel$loadResumeWatching$1$resumeWatching$1(Continuation<? super HomeViewModel$loadResumeWatching$1$resumeWatching$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadResumeWatching$1$resumeWatching$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VideoDownloadHelper.ResumeWatching>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VideoDownloadHelper.ResumeWatching>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VideoDownloadHelper.ResumeWatching>> continuation) {
        return ((HomeViewModel$loadResumeWatching$1$resumeWatching$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Integer> allResumeStateIds = DataStoreHelper.INSTANCE.getAllResumeStateIds();
            if (allResumeStateIds != null) {
                ArrayList arrayList = new ArrayList();
                for (Number number : allResumeStateIds) {
                    VideoDownloadHelper.ResumeWatching lastWatched = DataStoreHelper.INSTANCE.getLastWatched(boxing.boxInt(number.intValue()));
                    if (lastWatched != null) {
                        arrayList.add(lastWatched);
                    }
                }
                return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadResumeWatching$1$resumeWatching$1$invokeSuspend$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(-((VideoDownloadHelper.ResumeWatching) t).getUpdateTime()), Long.valueOf(-((VideoDownloadHelper.ResumeWatching) t2).getUpdateTime()));
                    }
                });
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
