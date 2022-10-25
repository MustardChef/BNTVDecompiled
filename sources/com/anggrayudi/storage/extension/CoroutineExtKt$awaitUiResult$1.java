package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.extension.CoroutineExtKt$awaitUiResult$1", m98f = "CoroutineExt.kt", m97i = {}, m96l = {58}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes.dex */
public final class CoroutineExtKt$awaitUiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Functions<R> $action;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtKt$awaitUiResult$1(CoroutineScope coroutineScope, Functions<? extends R> functions, Continuation<? super CoroutineExtKt$awaitUiResult$1> continuation) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$action = functions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$awaitUiResult$1(this.$uiScope, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((CoroutineExtKt$awaitUiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.$uiScope;
            Functions<R> functions = this.$action;
            this.L$0 = coroutineScope;
            this.L$1 = functions;
            this.label = 1;
            CoroutineExtKt$awaitUiResult$1 coroutineExtKt$awaitUiResult$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutineExtKt$awaitUiResult$1), 1);
            cancellableContinuationImpl.initCancellability();
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new CoroutineExtKt$awaitUiResult$1$1$1(cancellableContinuationImpl, functions, null), 2, null);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(coroutineExtKt$awaitUiResult$1);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Functions functions2 = (Functions) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = this.$uiScope;
        Functions<R> functions = this.$action;
        InlineMarker.mark(0);
        CoroutineExtKt$awaitUiResult$1 coroutineExtKt$awaitUiResult$1 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutineExtKt$awaitUiResult$1), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new CoroutineExtKt$awaitUiResult$1$1$1(cancellableContinuationImpl, functions, null), 2, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(coroutineExtKt$awaitUiResult$1);
        }
        InlineMarker.mark(1);
        return result;
    }
}
