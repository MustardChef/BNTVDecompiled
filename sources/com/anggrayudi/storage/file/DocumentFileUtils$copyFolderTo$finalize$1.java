package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyFolderTo$finalize$1 extends Lambda implements Functions<Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ ArrayList<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ DocumentFile $targetFolder;
    final /* synthetic */ DocumentFile $this_copyFolderTo;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, ArrayList<FolderCallback.FileConflict> arrayList, boolean z, DocumentFile documentFile, Context context, FolderCallback folderCallback, DocumentFile documentFile2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = arrayList;
        this.$deleteSourceWhenComplete = z;
        this.$this_copyFolderTo = documentFile;
        this.$context = context;
        this.$callback = folderCallback;
        this.$targetFolder = documentFile2;
        this.$totalFilesToCopy = intRef;
        this.$totalCopiedFiles = intRef2;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2() {
        Job job = this.$timer.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (!this.$success.element || this.$conflictedFiles.isEmpty()) {
            if (this.$deleteSourceWhenComplete && this.$success.element) {
                DocumentFileExt.forceDelete$default(this.$this_copyFolderTo, this.$context, false, 2, null);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new C1092xc10a66aa(null, this.$callback, this.$targetFolder, this.$totalFilesToCopy, this.$totalCopiedFiles, this.$success), 2, null);
            return 1;
        }
        return null;
    }
}
