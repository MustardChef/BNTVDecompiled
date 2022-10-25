package com.anggrayudi.storage.callback;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: MultipleFileCallback.kt */
@Metadata(m108d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0006#$%&'(B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\tH\u0017J$\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u0016H\u0017J4\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u000f\u001a\u00020\u001aH\u0017J&\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0017¨\u0006)"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$Report;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$Result;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onContentConflict", "", "destinationParentFolder", "Landroidx/documentfile/provider/DocumentFile;", "conflictedFiles", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "action", "Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "onCountingFiles", "onInvalidSourceFilesFound", "invalidSourceFiles", "", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$InvalidSourceFilesAction;", "onParentConflict", "conflictedFolders", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentFolderConflictAction;", "onStart", "", "files", "", "totalFilesToCopy", "", "workerThread", "Ljava/lang/Thread;", "ErrorCode", "InvalidSourceFilesAction", "ParentConflict", "ParentFolderConflictAction", "Report", "Result", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public abstract class MultipleFileCallback extends BaseFileCallback<ErrorCode, Report, Result> {

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FILE_NOT_FOUND", "INVALID_TARGET_FOLDER", "UNKNOWN_IO_ERROR", "CANCELED", "NO_SPACE_LEFT_ON_TARGET_PATH", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FILE_NOT_FOUND,
        INVALID_TARGET_FOLDER,
        UNKNOWN_IO_ERROR,
        CANCELED,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    public MultipleFileCallback() {
        this(null, 1, null);
    }

    public void onCountingFiles() {
    }

    public long onStart(List<? extends DocumentFile> files, int i, Thread workerThread) {
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(workerThread, "workerThread");
        return 0L;
    }

    public /* synthetic */ MultipleFileCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipleFileCallback(CoroutineScope uiScope) {
        super(uiScope);
        Intrinsics.checkNotNullParameter(uiScope, "uiScope");
    }

    public void onInvalidSourceFilesFound(Map<DocumentFile, ? extends FolderCallback.ErrorCode> invalidSourceFiles, InvalidSourceFilesAction action) {
        Intrinsics.checkNotNullParameter(invalidSourceFiles, "invalidSourceFiles");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(false);
    }

    public void onParentConflict(DocumentFile destinationParentFolder, List<ParentConflict> conflictedFolders, List<ParentConflict> conflictedFiles, ParentFolderConflictAction action) {
        Intrinsics.checkNotNullParameter(destinationParentFolder, "destinationParentFolder");
        Intrinsics.checkNotNullParameter(conflictedFolders, "conflictedFolders");
        Intrinsics.checkNotNullParameter(conflictedFiles, "conflictedFiles");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(conflictedFiles);
    }

    public void onContentConflict(DocumentFile destinationParentFolder, List<FolderCallback.FileConflict> conflictedFiles, FolderCallback.FolderContentConflictAction action) {
        Intrinsics.checkNotNullParameter(destinationParentFolder, "destinationParentFolder");
        Intrinsics.checkNotNullParameter(conflictedFiles, "conflictedFiles");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(conflictedFiles);
    }

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$InvalidSourceFilesAction;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "confirmResolution", "", "abort", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class InvalidSourceFilesAction {
        private final CancellableContinuation<Boolean> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public InvalidSourceFilesAction(CancellableContinuation<? super Boolean> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public final void confirmResolution(boolean z) {
            CancellableContinuation<Boolean> cancellableContinuation = this.continuation;
            Result.Companion companion = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m9066constructorimpl(Boolean.valueOf(z)));
        }
    }

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentFolderConflictAction;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "confirmResolution", "", "resolution", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class ParentFolderConflictAction {
        private final CancellableContinuation<List<ParentConflict>> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public ParentFolderConflictAction(CancellableContinuation<? super List<ParentConflict>> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public final void confirmResolution(List<ParentConflict> resolution) {
            Intrinsics.checkNotNullParameter(resolution, "resolution");
            CancellableContinuation<List<ParentConflict>> cancellableContinuation = this.continuation;
            Result.Companion companion = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m9066constructorimpl(resolution));
        }
    }

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "", "source", "Landroidx/documentfile/provider/DocumentFile;", TypedValues.AttributesType.S_TARGET, "canMerge", "", "solution", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "(Landroidx/documentfile/provider/DocumentFile;Landroidx/documentfile/provider/DocumentFile;ZLcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;)V", "getCanMerge", "()Z", "getSolution", "()Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "setSolution", "(Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;)V", "getSource", "()Landroidx/documentfile/provider/DocumentFile;", "getTarget", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class ParentConflict {
        private final boolean canMerge;
        private FolderCallback.ConflictResolution solution;
        private final DocumentFile source;
        private final DocumentFile target;

        public ParentConflict(DocumentFile source, DocumentFile target, boolean z, FolderCallback.ConflictResolution solution) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(solution, "solution");
            this.source = source;
            this.target = target;
            this.canMerge = z;
            this.solution = solution;
        }

        public final DocumentFile getSource() {
            return this.source;
        }

        public final DocumentFile getTarget() {
            return this.target;
        }

        public final boolean getCanMerge() {
            return this.canMerge;
        }

        public /* synthetic */ ParentConflict(DocumentFile documentFile, DocumentFile documentFile2, boolean z, FolderCallback.ConflictResolution conflictResolution, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(documentFile, documentFile2, z, (i & 8) != 0 ? FolderCallback.ConflictResolution.CREATE_NEW : conflictResolution);
        }

        public final FolderCallback.ConflictResolution getSolution() {
            return this.solution;
        }

        public final void setSolution(FolderCallback.ConflictResolution conflictResolution) {
            Intrinsics.checkNotNullParameter(conflictResolution, "<set-?>");
            this.solution = conflictResolution;
        }
    }

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$Report;", "", "progress", "", "bytesMoved", "", "writeSpeed", "", "fileCount", "(FJII)V", "getBytesMoved", "()J", "getFileCount", "()I", "getProgress", "()F", "getWriteSpeed", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Report {
        private final long bytesMoved;
        private final int fileCount;
        private final float progress;
        private final int writeSpeed;

        public Report(float f, long j, int i, int i2) {
            this.progress = f;
            this.bytesMoved = j;
            this.writeSpeed = i;
            this.fileCount = i2;
        }

        public final long getBytesMoved() {
            return this.bytesMoved;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final int getWriteSpeed() {
            return this.writeSpeed;
        }
    }

    /* compiled from: MultipleFileCallback.kt */
    @Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, m107d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$Result;", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "totalFilesToCopy", "", "totalCopiedFiles", "success", "", "(Ljava/util/List;IIZ)V", "getFiles", "()Ljava/util/List;", "getSuccess", "()Z", "getTotalCopiedFiles", "()I", "getTotalFilesToCopy", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Result {
        private final List<DocumentFile> files;
        private final boolean success;
        private final int totalCopiedFiles;
        private final int totalFilesToCopy;

        /* JADX WARN: Multi-variable type inference failed */
        public Result(List<? extends DocumentFile> files, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(files, "files");
            this.files = files;
            this.totalFilesToCopy = i;
            this.totalCopiedFiles = i2;
            this.success = z;
        }

        public final List<DocumentFile> getFiles() {
            return this.files;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final int getTotalCopiedFiles() {
            return this.totalCopiedFiles;
        }

        public final int getTotalFilesToCopy() {
            return this.totalFilesToCopy;
        }
    }
}
