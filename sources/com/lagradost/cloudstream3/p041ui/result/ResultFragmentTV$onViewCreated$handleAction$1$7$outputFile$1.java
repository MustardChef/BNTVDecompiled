package com.lagradost.cloudstream3.p041ui.result;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1", m98f = "ResultFragmentTV.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ File $outputDir;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1(File file, Continuation<? super ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1> continuation) {
        super(2, continuation);
        this.$outputDir = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1(this.$outputDir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return ((ResultFragmentTV$onViewCreated$handleAction$1$7$outputFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return File.createTempFile("mirrorlist", ".m3u8", this.$outputDir);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
