package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.media.MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1", m98f = "MediaFile.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes.dex */
public final class MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileCallback $callback$inlined;
    final /* synthetic */ FileCallback.Report $report$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1(Continuation continuation, FileCallback fileCallback, FileCallback.Report report) {
        super(2, continuation);
        this.$callback$inlined = fileCallback;
        this.$report$inlined = report;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$report$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback$inlined.onReport(this.$report$inlined);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
