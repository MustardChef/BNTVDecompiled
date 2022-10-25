package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
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
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "errorCode", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFolderTo$notifyCanceled$1 extends Lambda implements Function1<FolderCallback.ErrorCode, Unit> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Ref.BooleanRef $canceled;
    final /* synthetic */ Ref.ObjectRef<DocumentFile> $targetFile;
    final /* synthetic */ DocumentFile $targetFolder;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$notifyCanceled$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<DocumentFile> objectRef2, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.$canceled = booleanRef;
        this.$timer = objectRef;
        this.$targetFile = objectRef2;
        this.$callback = folderCallback;
        this.$targetFolder = documentFile;
        this.$totalFilesToCopy = intRef;
        this.$totalCopiedFiles = intRef2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FolderCallback.ErrorCode errorCode) {
        invoke2(errorCode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FolderCallback.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.$canceled.element) {
            return;
        }
        this.$canceled.element = true;
        Job job = this.$timer.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        DocumentFile documentFile = this.$targetFile.element;
        if (documentFile != null) {
            documentFile.delete();
        }
        BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new C1094xb4f23346(null, this.$callback, errorCode, this.$targetFolder, this.$totalFilesToCopy, this.$totalCopiedFiles), 2, null);
    }
}
