package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1", m98f = "PlayerGeneratorViewModel.kt", m97i = {}, m96l = {83}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$preLoadNextLinks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerGeneratorViewModel$preLoadNextLinks$1(PlayerGeneratorViewModel playerGeneratorViewModel, Continuation<? super PlayerGeneratorViewModel$preLoadNextLinks$1> continuation) {
        super(2, continuation);
        this.this$0 = playerGeneratorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerGeneratorViewModel$preLoadNextLinks$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerGeneratorViewModel$preLoadNextLinks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IGenerator iGenerator;
        IGenerator iGenerator2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            iGenerator = this.this$0.generator;
            boolean z = false;
            if (iGenerator != null && iGenerator.getHasCache()) {
                iGenerator2 = this.this$0.generator;
                if (iGenerator2 != null && iGenerator2.hasNext()) {
                    z = true;
                }
                if (z) {
                    this.label = 1;
                    if (ArchComponentExt.safeApiCall(new C48771(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerGeneratorViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1$1", m98f = "PlayerGeneratorViewModel.kt", m97i = {}, m96l = {84}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48771 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ PlayerGeneratorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48771(PlayerGeneratorViewModel playerGeneratorViewModel, Continuation<? super C48771> continuation) {
            super(1, continuation);
            this.this$0 = playerGeneratorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48771(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C48771) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PlayerGeneratorViewModel.kt */
        @Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1$1$1 */
        /* loaded from: classes3.dex */
        public static final class C48781 extends Lambda implements Function1<Tuples<? extends ExtractorLink, ? extends ExtractorUri>, Unit> {
            public static final C48781 INSTANCE = new C48781();

            C48781() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Tuples<? extends ExtractorLink, ExtractorUri> it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends ExtractorLink, ? extends ExtractorUri> tuples) {
                invoke2((Tuples<? extends ExtractorLink, ExtractorUri>) tuples);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PlayerGeneratorViewModel.kt */
        @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$preLoadNextLinks$1$1$2 */
        /* loaded from: classes3.dex */
        public static final class C48792 extends Lambda implements Function1<SubtitleData, Unit> {
            public static final C48792 INSTANCE = new C48792();

            C48792() {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SubtitleData it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubtitleData subtitleData) {
                invoke2(subtitleData);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IGenerator iGenerator;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                iGenerator = this.this$0.generator;
                if (iGenerator == null) {
                    return null;
                }
                this.label = 1;
                obj = iGenerator.generateLinks(false, false, C48781.INSTANCE, C48792.INSTANCE, 1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return (Boolean) obj;
        }
    }
}
