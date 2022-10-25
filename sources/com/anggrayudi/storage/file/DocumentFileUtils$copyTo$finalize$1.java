package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public final class DocumentFileUtils$copyTo$finalize$1 extends Lambda implements Functions<Boolean> {
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ List<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Map<DocumentFile, DocumentFile> $results;
    final /* synthetic */ Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> $sourceInfos;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ int $totalFilesToCopy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, List<FolderCallback.FileConflict> list, boolean z, Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map, Map<DocumentFile, DocumentFile> map2, int i, Ref.IntRef intRef, MultipleFileCallback multipleFileCallback, Context context) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = list;
        this.$deleteSourceWhenComplete = z;
        this.$sourceInfos = map;
        this.$results = map2;
        this.$totalFilesToCopy = i;
        this.$totalCopiedFiles = intRef;
        this.$callback = multipleFileCallback;
        this.$context = context;
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
                Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map = this.$sourceInfos;
                Context context = this.$context;
                for (Map.Entry<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> entry : map.entrySet()) {
                    DocumentFileExt.deleteRecursively$default(entry.getKey(), context, false, 2, null);
                }
            }
            Map<DocumentFile, DocumentFile> map2 = this.$results;
            ArrayList arrayList = new ArrayList(map2.size());
            for (Map.Entry<DocumentFile, DocumentFile> entry2 : map2.entrySet()) {
                arrayList.add(entry2.getValue());
            }
            MultipleFileCallback.Result result = new MultipleFileCallback.Result(arrayList, this.$totalFilesToCopy, this.$totalCopiedFiles.element, this.$success.element);
            BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new DocumentFileUtils$copyTo$finalize$1$invoke$$inlined$postToUi$1(null, this.$callback, result), 2, null);
            return 1;
        }
        return null;
    }
}
