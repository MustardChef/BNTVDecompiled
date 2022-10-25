package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.FolderCallback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n"}, m107d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFolderTo$handleError$1 extends Lambda implements Function1<Exception, Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Function1<FolderCallback.ErrorCode, Unit> $notifyCanceled;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DocumentFileUtils$copyFolderTo$handleError$1(Function1<? super FolderCallback.ErrorCode, Unit> function1, Ref.ObjectRef<Job> objectRef, FolderCallback folderCallback) {
        super(1);
        this.$notifyCanceled = function1;
        this.$timer = objectRef;
        this.$callback = folderCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Exception exc) {
        return Boolean.valueOf(invoke2(exc));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Exception it) {
        FolderCallback.ErrorCode folderCallbackErrorCode;
        Intrinsics.checkNotNullParameter(it, "it");
        folderCallbackErrorCode = DocumentFileExt.toFolderCallbackErrorCode(it);
        if (folderCallbackErrorCode == FolderCallback.ErrorCode.CANCELED || folderCallbackErrorCode == FolderCallback.ErrorCode.UNKNOWN_IO_ERROR) {
            this.$notifyCanceled.invoke(folderCallbackErrorCode);
            return true;
        }
        Job job = this.$timer.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new C1093xb267c840(null, this.$callback, folderCallbackErrorCode), 2, null);
        return false;
    }
}
