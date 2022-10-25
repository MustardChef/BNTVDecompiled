package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.SearchResponse;
import java.util.List;
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
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.APIRepository$quickSearch$2", m98f = "APIRepository.kt", m97i = {}, m96l = {73}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.APIRepository$quickSearch$2 */
/* loaded from: classes.dex */
public final class APIRepository$quickSearch$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends SearchResponse>>, Object> {
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ APIRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIRepository$quickSearch$2(APIRepository aPIRepository, String str, Continuation<? super APIRepository$quickSearch$2> continuation) {
        super(1, continuation);
        this.this$0 = aPIRepository;
        this.$query = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new APIRepository$quickSearch$2(this.this$0, this.$query, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super List<? extends SearchResponse>> continuation) {
        return ((APIRepository$quickSearch$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getApi().quickSearch(this.$query, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list != null) {
            return list;
        }
        throw new ErrorLoadingException(null, 1, null);
    }
}
