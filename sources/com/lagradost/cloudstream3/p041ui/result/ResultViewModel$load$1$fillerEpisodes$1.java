package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.utils.FillerEpisodeCheck;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\u008a@"}, m107d2 = {"<anonymous>", "Ljava/util/HashMap;", "", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1$fillerEpisodes$1", m98f = "ResultViewModel.kt", m97i = {}, m96l = {401}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1$fillerEpisodes$1 */
/* loaded from: classes4.dex */
final class ResultViewModel$load$1$fillerEpisodes$1 extends SuspendLambda implements Function1<Continuation<? super HashMap<Integer, Boolean>>, Object> {
    final /* synthetic */ LoadResponse $loadResponse;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultViewModel$load$1$fillerEpisodes$1(LoadResponse loadResponse, Continuation<? super ResultViewModel$load$1$fillerEpisodes$1> continuation) {
        super(1, continuation);
        this.$loadResponse = loadResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultViewModel$load$1$fillerEpisodes$1(this.$loadResponse, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super HashMap<Integer, Boolean>> continuation) {
        return ((ResultViewModel$load$1$fillerEpisodes$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = FillerEpisodeCheck.INSTANCE.getFillerEpisodes(this.$loadResponse.getName(), this);
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
