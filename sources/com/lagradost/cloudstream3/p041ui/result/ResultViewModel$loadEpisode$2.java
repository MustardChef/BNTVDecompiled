package com.lagradost.cloudstream3.p041ui.result;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.p041ui.player.IGenerator;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$loadEpisode$2", m98f = "ResultViewModel.kt", m97i = {0, 0}, m96l = {255}, m95m = "invokeSuspend", m94n = {"currentLinks", "currentSubs"}, m93s = {"L$0", "L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$loadEpisode$2 */
/* loaded from: classes4.dex */
public final class ResultViewModel$loadEpisode$2 extends SuspendLambda implements Function1<Continuation<? super Tuples<? extends Set<? extends ExtractorLink>, ? extends Set<? extends SubtitleData>>>, Object> {
    final /* synthetic */ boolean $clearCache;
    final /* synthetic */ ResultEpisode $episode;
    final /* synthetic */ boolean $isCasting;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultViewModel$loadEpisode$2(ResultViewModel resultViewModel, ResultEpisode resultEpisode, boolean z, boolean z2, Continuation<? super ResultViewModel$loadEpisode$2> continuation) {
        super(1, continuation);
        this.this$0 = resultViewModel;
        this.$episode = resultEpisode;
        this.$clearCache = z;
        this.$isCasting = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultViewModel$loadEpisode$2(this.this$0, this.$episode, this.$clearCache, this.$isCasting, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Tuples<? extends Set<? extends ExtractorLink>, ? extends Set<? extends SubtitleData>>> continuation) {
        return invoke2((Continuation<? super Tuples<? extends Set<? extends ExtractorLink>, ? extends Set<SubtitleData>>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Tuples<? extends Set<? extends ExtractorLink>, ? extends Set<SubtitleData>>> continuation) {
        return ((ResultViewModel$loadEpisode$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Set] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        Set linkedHashSet;
        LinkedHashSet linkedHashSet2;
        IGenerator iGenerator;
        IGenerator iGenerator2;
        LinkedHashSet linkedHashSet3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._episodes;
            List list = (List) mutableLiveData.getValue();
            int indexOf = list != null ? list.indexOf(this.$episode) : this.$episode.getIndex();
            linkedHashSet = new LinkedHashSet();
            linkedHashSet2 = new LinkedHashSet();
            iGenerator = this.this$0.generator;
            if (iGenerator != null) {
                iGenerator.mo8669goto(indexOf);
            }
            iGenerator2 = this.this$0.generator;
            if (iGenerator2 != null) {
                this.L$0 = linkedHashSet;
                this.L$1 = linkedHashSet2;
                this.label = 1;
                obj = IGenerator.DefaultImpls.generateLinks$default(iGenerator2, this.$clearCache, this.$isCasting, new C49511(linkedHashSet), new C49522(linkedHashSet2), 0, this, 16, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                linkedHashSet3 = linkedHashSet2;
            }
            return new Tuples(CollectionsKt.toSet(linkedHashSet), CollectionsKt.toSet(linkedHashSet2));
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            linkedHashSet = (Set) this.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashSet3 = (Set) this.L$1;
        }
        Boolean bool = (Boolean) obj;
        linkedHashSet2 = linkedHashSet3;
        return new Tuples(CollectionsKt.toSet(linkedHashSet), CollectionsKt.toSet(linkedHashSet2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$loadEpisode$2$1 */
    /* loaded from: classes4.dex */
    public static final class C49511 extends Lambda implements Function1<Tuples<? extends ExtractorLink, ? extends ExtractorUri>, Unit> {
        final /* synthetic */ Set<ExtractorLink> $currentLinks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49511(Set<ExtractorLink> set) {
            super(1);
            this.$currentLinks = set;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends ExtractorLink, ? extends ExtractorUri> tuples) {
            invoke2((Tuples<? extends ExtractorLink, ExtractorUri>) tuples);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples<? extends ExtractorLink, ExtractorUri> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ExtractorLink first = it.getFirst();
            if (first != null) {
                this.$currentLinks.add(first);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "sub", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$loadEpisode$2$2 */
    /* loaded from: classes4.dex */
    public static final class C49522 extends Lambda implements Function1<SubtitleData, Unit> {
        final /* synthetic */ Set<SubtitleData> $currentSubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49522(Set<SubtitleData> set) {
            super(1);
            this.$currentSubs = set;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubtitleData subtitleData) {
            invoke2(subtitleData);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SubtitleData sub) {
            Intrinsics.checkNotNullParameter(sub, "sub");
            this.$currentSubs.add(sub);
        }
    }
}
