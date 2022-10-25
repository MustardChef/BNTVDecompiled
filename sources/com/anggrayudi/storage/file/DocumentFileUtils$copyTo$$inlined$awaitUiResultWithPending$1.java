package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, m107d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResultWithPending$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1", m98f = "DocumentFileExt.kt", m97i = {}, m96l = {58}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FolderCallback.FileConflict>>, Object> {
    final /* synthetic */ MultipleFileCallback $callback$inlined;
    final /* synthetic */ List $conflictedFiles$inlined;
    final /* synthetic */ CoroutineScope $uiScope;
    final /* synthetic */ DocumentFile $writableTargetParentFolder$inlined;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1(CoroutineScope coroutineScope, Continuation continuation, MultipleFileCallback multipleFileCallback, DocumentFile documentFile, List list) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$callback$inlined = multipleFileCallback;
        this.$writableTargetParentFolder$inlined = documentFile;
        this.$conflictedFiles$inlined = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1(this.$uiScope, continuation, this.$callback$inlined, this.$writableTargetParentFolder$inlined, this.$conflictedFiles$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends FolderCallback.FileConflict>> continuation) {
        return ((DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: CoroutineExt.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¨\u0006\u0004"}, m107d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResultWithPending$1$1$1"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    @DebugMetadata(m99c = "com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1$1", m98f = "DocumentFileExt.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1$1 */
    /* loaded from: classes.dex */
    public static final class C10971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MultipleFileCallback $callback$inlined;
        final /* synthetic */ List $conflictedFiles$inlined;
        final /* synthetic */ CancellableContinuation $it;
        final /* synthetic */ DocumentFile $writableTargetParentFolder$inlined;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10971(CancellableContinuation cancellableContinuation, Continuation continuation, MultipleFileCallback multipleFileCallback, DocumentFile documentFile, List list) {
            super(2, continuation);
            this.$it = cancellableContinuation;
            this.$callback$inlined = multipleFileCallback;
            this.$writableTargetParentFolder$inlined = documentFile;
            this.$conflictedFiles$inlined = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10971(this.$it, continuation, this.$callback$inlined, this.$writableTargetParentFolder$inlined, this.$conflictedFiles$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback$inlined.onContentConflict(this.$writableTargetParentFolder$inlined, this.$conflictedFiles$inlined, new FolderCallback.FolderContentConflictAction(this.$it));
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
        DocumentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1 documentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(documentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new C10971(cancellableContinuationImpl, null, this.$callback$inlined, this.$writableTargetParentFolder$inlined, this.$conflictedFiles$inlined), 2, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(documentFileUtils$copyTo$$inlined$awaitUiResultWithPending$1);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
