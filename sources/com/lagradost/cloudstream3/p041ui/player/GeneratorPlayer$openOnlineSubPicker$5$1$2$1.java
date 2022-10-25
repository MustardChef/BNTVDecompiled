package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities;
import com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi;
import com.lagradost.cloudstream3.utils.Coroutines;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$5$1$2$1", m98f = "GeneratorPlayer.kt", m97i = {}, m96l = {342}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$5$1$2$1 */
/* loaded from: classes3.dex */
public final class GeneratorPlayer$openOnlineSubPicker$5$1$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenSubtitlesApi $api;
    final /* synthetic */ AbstractSubtitleEntities.SubtitleEntity $currentSubtitle;
    int label;
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$openOnlineSubPicker$5$1$2$1(OpenSubtitlesApi openSubtitlesApi, AbstractSubtitleEntities.SubtitleEntity subtitleEntity, GeneratorPlayer generatorPlayer, Continuation<? super GeneratorPlayer$openOnlineSubPicker$5$1$2$1> continuation) {
        super(1, continuation);
        this.$api = openSubtitlesApi;
        this.$currentSubtitle = subtitleEntity;
        this.this$0 = generatorPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GeneratorPlayer$openOnlineSubPicker$5$1$2$1(this.$api, this.$currentSubtitle, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((GeneratorPlayer$openOnlineSubPicker$5$1$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String openOnlineSubPicker$getName;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$api.load(this.$currentSubtitle, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        if (str == null) {
            return Unit.INSTANCE;
        }
        openOnlineSubPicker$getName = GeneratorPlayer.openOnlineSubPicker$getName(this.$currentSubtitle);
        Coroutines.INSTANCE.runOnMainThread(new C48711(this.this$0, new SubtitleData(openOnlineSubPicker$getName, str, SubtitleOrigin.URL, PlayerSubtitleHelper.Companion.toSubtitleMimeType(str), null, 16, null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneratorPlayer.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$5$1$2$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48711 extends Lambda implements Functions<Unit> {
        final /* synthetic */ SubtitleData $subtitle;
        final /* synthetic */ GeneratorPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48711(GeneratorPlayer generatorPlayer, SubtitleData subtitleData) {
            super(0);
            this.this$0 = generatorPlayer;
            this.$subtitle = subtitleData;
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.addAndSelectSubtitles(this.$subtitle);
        }
    }
}
