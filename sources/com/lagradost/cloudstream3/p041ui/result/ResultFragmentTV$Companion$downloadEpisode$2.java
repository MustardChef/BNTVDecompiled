package com.lagradost.cloudstream3.p041ui.result;

import android.app.Activity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.p041ui.player.IGenerator;
import com.lagradost.cloudstream3.p041ui.player.RepoLinkGenerator;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.LinkedHashSet;
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
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2", m98f = "ResultFragmentTV.kt", m97i = {0, 0}, m96l = {393}, m95m = "invokeSuspend", m94n = {"currentLinks", "currentSubs"}, m93s = {"L$0", "L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$Companion$downloadEpisode$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $apiName;
    final /* synthetic */ String $currentHeaderName;
    final /* synthetic */ boolean $currentIsMovie;
    final /* synthetic */ String $currentPoster;
    final /* synthetic */ TvType $currentType;
    final /* synthetic */ ResultEpisode $episode;
    final /* synthetic */ int $parentId;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$Companion$downloadEpisode$2(ResultEpisode resultEpisode, Activity activity, boolean z, String str, TvType tvType, String str2, String str3, int i, String str4, Continuation<? super ResultFragmentTV$Companion$downloadEpisode$2> continuation) {
        super(1, continuation);
        this.$episode = resultEpisode;
        this.$activity = activity;
        this.$currentIsMovie = z;
        this.$currentHeaderName = str;
        this.$currentType = tvType;
        this.$currentPoster = str2;
        this.$apiName = str3;
        this.$parentId = i;
        this.$url = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultFragmentTV$Companion$downloadEpisode$2(this.$episode, this.$activity, this.$currentIsMovie, this.$currentHeaderName, this.$currentType, this.$currentPoster, this.$apiName, this.$parentId, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ResultFragmentTV$Companion$downloadEpisode$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LinkedHashSet linkedHashSet;
        Set set;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RepoLinkGenerator repoLinkGenerator = new RepoLinkGenerator(CollectionsKt.listOf(this.$episode), 0, null, 6, null);
            linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            this.L$0 = linkedHashSet;
            this.L$1 = linkedHashSet2;
            this.label = 1;
            if (IGenerator.DefaultImpls.generateLinks$default(repoLinkGenerator, false, false, new C49401(linkedHashSet), new C49412(linkedHashSet2), 0, this, 16, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            set = linkedHashSet2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            set = (Set) this.L$1;
            linkedHashSet = (Set) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (linkedHashSet.isEmpty()) {
            Coroutines.INSTANCE.main(new C49423(this.$activity, null));
            return Unit.INSTANCE;
        }
        ResultFragmentTV.Companion.startDownload(this.$activity, this.$episode, this.$currentIsMovie, this.$currentHeaderName, this.$currentType, this.$currentPoster, this.$apiName, this.$parentId, this.$url, MainAPIKt.sortUrls(linkedHashSet), MainAPIKt.sortSubs(set));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2$1 */
    /* loaded from: classes4.dex */
    public static final class C49401 extends Lambda implements Function1<Tuples<? extends ExtractorLink, ? extends ExtractorUri>, Unit> {
        final /* synthetic */ Set<ExtractorLink> $currentLinks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49401(Set<ExtractorLink> set) {
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
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "sub", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2$2 */
    /* loaded from: classes4.dex */
    public static final class C49412 extends Lambda implements Function1<SubtitleData, Unit> {
        final /* synthetic */ Set<SubtitleData> $currentSubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49412(Set<SubtitleData> set) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2$3", m98f = "ResultFragmentTV.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$downloadEpisode$2$3 */
    /* loaded from: classes4.dex */
    public static final class C49423 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49423(Activity activity, Continuation<? super C49423> continuation) {
            super(1, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C49423(this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C49423) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CommonActivity.INSTANCE.showToast(this.$activity, R.string.no_links_found_toast, 0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
