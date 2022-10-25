package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.p041ui.player.IGenerator;
import com.lagradost.cloudstream3.p041ui.player.RepoLinkGenerator;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1", m98f = "ControllerActivity.kt", m97i = {}, m96l = {297}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1 */
/* loaded from: classes.dex */
final class SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ Set<ExtractorLink> $currentLinks;
    final /* synthetic */ Set<SubtitleData> $currentSubs;
    final /* synthetic */ RepoLinkGenerator $generator;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1(RepoLinkGenerator repoLinkGenerator, Set<ExtractorLink> set, Set<SubtitleData> set2, Continuation<? super SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1> continuation) {
        super(1, continuation);
        this.$generator = repoLinkGenerator;
        this.$currentLinks = set;
        this.$currentSubs = set2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1(this.$generator, this.$currentLinks, this.$currentSubs, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerActivity.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1$1 */
    /* loaded from: classes.dex */
    public static final class C48381 extends Lambda implements Function1<Tuples<? extends ExtractorLink, ? extends ExtractorUri>, Unit> {
        final /* synthetic */ Set<ExtractorLink> $currentLinks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48381(Set<ExtractorLink> set) {
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
    /* compiled from: ControllerActivity.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1$2 */
    /* loaded from: classes.dex */
    public static final class C48392 extends Lambda implements Function1<SubtitleData, Unit> {
        final /* synthetic */ Set<SubtitleData> $currentSubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48392(Set<SubtitleData> set) {
            super(1);
            this.$currentSubs = set;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubtitleData subtitleData) {
            invoke2(subtitleData);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SubtitleData it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.$currentSubs.add(it);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IGenerator.DefaultImpls.generateLinks$default(this.$generator, false, true, new C48381(this.$currentLinks), new C48392(this.$currentSubs), 0, this, 16, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
