package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1", m98f = "DocumentFileExt.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1 */
/* loaded from: classes.dex */
public final class C1094xb4f23346 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderCallback $callback$inlined;
    final /* synthetic */ FolderCallback.ErrorCode $errorCode$inlined;
    final /* synthetic */ DocumentFile $targetFolder$inlined;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles$inlined;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1094xb4f23346(Continuation continuation, FolderCallback folderCallback, FolderCallback.ErrorCode errorCode, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(2, continuation);
        this.$callback$inlined = folderCallback;
        this.$errorCode$inlined = errorCode;
        this.$targetFolder$inlined = documentFile;
        this.$totalFilesToCopy$inlined = intRef;
        this.$totalCopiedFiles$inlined = intRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1094xb4f23346(continuation, this.$callback$inlined, this.$errorCode$inlined, this.$targetFolder$inlined, this.$totalFilesToCopy$inlined, this.$totalCopiedFiles$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C1094xb4f23346) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback$inlined.onFailed(this.$errorCode$inlined);
            this.$callback$inlined.onCompleted(new FolderCallback.Result(this.$targetFolder$inlined, this.$totalFilesToCopy$inlined.element, this.$totalCopiedFiles$inlined.element, false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
