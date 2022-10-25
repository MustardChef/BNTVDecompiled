package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.ContinuationCallback;
import com.lagradost.nicehttp.Requests;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Request;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZoroProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.ZoroProvider$getVideoInterceptor$1$1", m98f = "ZoroProvider.kt", m97i = {0}, m96l = {371}, m95m = "invokeSuspend", m94n = {"$this$await$iv"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ZoroProvider$getVideoInterceptor$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $options;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoroProvider$getVideoInterceptor$1$1(Request request, Continuation<? super ZoroProvider$getVideoInterceptor$1$1> continuation) {
        super(1, continuation);
        this.$options = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ZoroProvider$getVideoInterceptor$1$1(this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ZoroProvider$getVideoInterceptor$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Requests.Companion companion = Requests.Companion;
            Call newCall = MainActivityKt.getApp().getBaseClient().newCall(this.$options);
            this.L$0 = newCall;
            this.label = 1;
            ZoroProvider$getVideoInterceptor$1$1 zoroProvider$getVideoInterceptor$1$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(zoroProvider$getVideoInterceptor$1$1), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ContinuationCallback continuationCallback = new ContinuationCallback(newCall, cancellableContinuationImpl2);
            newCall.enqueue(continuationCallback);
            cancellableContinuationImpl2.invokeOnCancellation(continuationCallback);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(zoroProvider$getVideoInterceptor$1$1);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Call call = (Call) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
