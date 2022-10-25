package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: APIRepository.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/LoadResponse;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.APIRepository$load$2", m98f = "APIRepository.kt", m97i = {}, m96l = {45}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.APIRepository$load$2 */
/* loaded from: classes.dex */
public final class APIRepository$load$2 extends SuspendLambda implements Function1<Continuation<? super LoadResponse>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ APIRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIRepository$load$2(APIRepository aPIRepository, String str, Continuation<? super APIRepository$load$2> continuation) {
        super(1, continuation);
        this.this$0 = aPIRepository;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new APIRepository$load$2(this.this$0, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super LoadResponse> continuation) {
        return ((APIRepository$load$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getApi().load(MainAPIKt.fixUrl(this.this$0.getApi(), this.$url), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        LoadResponse loadResponse = (LoadResponse) obj;
        if (loadResponse != null) {
            return loadResponse;
        }
        throw new ErrorLoadingException(null, 1, null);
    }
}
