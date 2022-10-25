package com.lagradost.cloudstream3.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: DdosGuardKiller.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Lokhttp3/Response;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.network.DdosGuardKiller$intercept$1", m98f = "DdosGuardKiller.kt", m97i = {}, m96l = {28, 32}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class DdosGuardKiller$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response>, Object> {
    final /* synthetic */ Interceptor.Chain $chain;
    int label;
    final /* synthetic */ DdosGuardKiller this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DdosGuardKiller$intercept$1(Interceptor.Chain chain, DdosGuardKiller ddosGuardKiller, Continuation<? super DdosGuardKiller$intercept$1> continuation) {
        super(2, continuation);
        this.$chain = chain;
        this.this$0 = ddosGuardKiller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DdosGuardKiller$intercept$1(this.$chain, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response> continuation) {
        return ((DdosGuardKiller$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return (Response) obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        Request request = this.$chain.request();
        z = this.this$0.alwaysBypass;
        if (z) {
            this.label = 1;
            obj = this.this$0.bypassDdosGuard(request, this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
        Response proceed = this.$chain.proceed(request);
        if (proceed.code() == 403) {
            this.label = 2;
            obj = this.this$0.bypassDdosGuard(request, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (Response) obj;
        }
        return proceed;
    }
}
