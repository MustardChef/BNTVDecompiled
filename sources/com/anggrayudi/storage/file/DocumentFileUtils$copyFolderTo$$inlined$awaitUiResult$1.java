package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, m107d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1", m98f = "DocumentFileExt.kt", m97i = {}, m96l = {58}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ FolderCallback $callback$inlined;
    final /* synthetic */ DocumentFile $this_copyFolderTo$inlined;
    final /* synthetic */ Thread $thread$inlined;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy$inlined;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1(CoroutineScope coroutineScope, Continuation continuation, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Thread thread) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$callback$inlined = folderCallback;
        this.$this_copyFolderTo$inlined = documentFile;
        this.$totalFilesToCopy$inlined = intRef;
        this.$thread$inlined = thread;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1(this.$uiScope, continuation, this.$callback$inlined, this.$this_copyFolderTo$inlined, this.$totalFilesToCopy$inlined, this.$thread$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: CoroutineExt.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¨\u0006\u0004"}, m107d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1$1$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    @DebugMetadata(m99c = "com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1$1", m98f = "DocumentFileExt.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1$1 */
    /* loaded from: classes.dex */
    public static final class C10891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FolderCallback $callback$inlined;
        final /* synthetic */ CancellableContinuation $it;
        final /* synthetic */ DocumentFile $this_copyFolderTo$inlined;
        final /* synthetic */ Thread $thread$inlined;
        final /* synthetic */ Ref.IntRef $totalFilesToCopy$inlined;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10891(CancellableContinuation cancellableContinuation, Continuation continuation, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Thread thread) {
            super(2, continuation);
            this.$it = cancellableContinuation;
            this.$callback$inlined = folderCallback;
            this.$this_copyFolderTo$inlined = documentFile;
            this.$totalFilesToCopy$inlined = intRef;
            this.$thread$inlined = thread;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10891(this.$it, continuation, this.$callback$inlined, this.$this_copyFolderTo$inlined, this.$totalFilesToCopy$inlined, this.$thread$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CancellableContinuation cancellableContinuation = this.$it;
                Result.Companion companion = Result.Companion;
                FolderCallback folderCallback = this.$callback$inlined;
                DocumentFile documentFile = this.$this_copyFolderTo$inlined;
                int i = this.$totalFilesToCopy$inlined.element;
                Thread thread = this.$thread$inlined;
                Intrinsics.checkNotNullExpressionValue(thread, "thread");
                cancellableContinuation.resumeWith(Result.m9066constructorimpl(boxing.boxLong(folderCallback.onStart(documentFile, i, this.$thread$inlined))));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope2 = this.$uiScope;
        this.L$0 = coroutineScope2;
        this.label = 1;
        DocumentFileUtils$copyFolderTo$$inlined$awaitUiResult$1 documentFileUtils$copyFolderTo$$inlined$awaitUiResult$1 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(documentFileUtils$copyFolderTo$$inlined$awaitUiResult$1), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new C10891(cancellableContinuationImpl, null, this.$callback$inlined, this.$this_copyFolderTo$inlined, this.$totalFilesToCopy$inlined, this.$thread$inlined), 2, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(documentFileUtils$copyFolderTo$$inlined$awaitUiResult$1);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}