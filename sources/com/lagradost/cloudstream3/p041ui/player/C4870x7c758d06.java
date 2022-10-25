package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities;
import com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;", "it", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1$results$1", m98f = "GeneratorPlayer.kt", m97i = {}, m96l = {293}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1$results$1 */
/* loaded from: classes3.dex */
final class C4870x7c758d06 extends SuspendLambda implements Function2<OpenSubtitlesApi, Continuation<? super List<? extends AbstractSubtitleEntities.SubtitleEntity>>, Object> {
    final /* synthetic */ AbstractSubtitleEntities.SubtitleSearch $search;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4870x7c758d06(AbstractSubtitleEntities.SubtitleSearch subtitleSearch, Continuation<? super C4870x7c758d06> continuation) {
        super(2, continuation);
        this.$search = subtitleSearch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C4870x7c758d06 c4870x7c758d06 = new C4870x7c758d06(this.$search, continuation);
        c4870x7c758d06.L$0 = obj;
        return c4870x7c758d06;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(OpenSubtitlesApi openSubtitlesApi, Continuation<? super List<AbstractSubtitleEntities.SubtitleEntity>> continuation) {
        return ((C4870x7c758d06) create(openSubtitlesApi, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(OpenSubtitlesApi openSubtitlesApi, Continuation<? super List<? extends AbstractSubtitleEntities.SubtitleEntity>> continuation) {
        return invoke2(openSubtitlesApi, (Continuation<? super List<AbstractSubtitleEntities.SubtitleEntity>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OpenSubtitlesApi openSubtitlesApi = (OpenSubtitlesApi) this.L$0;
                this.label = 1;
                obj = openSubtitlesApi.search(this.$search, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return (List) obj;
        } catch (Exception unused) {
            return null;
        }
    }
}
