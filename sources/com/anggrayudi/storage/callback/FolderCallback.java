package com.anggrayudi.storage.callback;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.file.CreateMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: FolderCallback.kt */
@Metadata(m108d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0007\u001d\u001e\u001f !\"#B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\tH\u0017J \u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017¨\u0006$"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/FolderCallback$Report;", "Lcom/anggrayudi/storage/callback/FolderCallback$Result;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onContentConflict", "", "destinationFolder", "Landroidx/documentfile/provider/DocumentFile;", "conflictedFiles", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "action", "Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "onCountingFiles", "onParentConflict", "Lcom/anggrayudi/storage/callback/FolderCallback$ParentFolderConflictAction;", "canMerge", "", "onStart", "", "folder", "totalFilesToCopy", "", "workerThread", "Ljava/lang/Thread;", "ConflictResolution", "ErrorCode", "FileConflict", "FolderContentConflictAction", "ParentFolderConflictAction", "Report", "Result", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public abstract class FolderCallback extends BaseFileCallback<ErrorCode, Report, Result> {

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FOLDER_NOT_FOUND", "SOURCE_FILE_NOT_FOUND", "INVALID_TARGET_FOLDER", "UNKNOWN_IO_ERROR", "CANCELED", "TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER", "NO_SPACE_LEFT_ON_TARGET_PATH", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FOLDER_NOT_FOUND,
        SOURCE_FILE_NOT_FOUND,
        INVALID_TARGET_FOLDER,
        UNKNOWN_IO_ERROR,
        CANCELED,
        TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    public FolderCallback() {
        this(null, 1, null);
    }

    public void onCountingFiles() {
    }

    public long onStart(DocumentFile folder, int i, Thread workerThread) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(workerThread, "workerThread");
        return 0L;
    }

    public /* synthetic */ FolderCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderCallback(CoroutineScope uiScope) {
        super(uiScope);
        Intrinsics.checkNotNullParameter(uiScope, "uiScope");
    }

    public void onParentConflict(DocumentFile destinationFolder, ParentFolderConflictAction action, boolean z) {
        Intrinsics.checkNotNullParameter(destinationFolder, "destinationFolder");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(ConflictResolution.CREATE_NEW);
    }

    public void onContentConflict(DocumentFile destinationFolder, List<FileConflict> conflictedFiles, FolderContentConflictAction action) {
        Intrinsics.checkNotNullParameter(destinationFolder, "destinationFolder");
        Intrinsics.checkNotNullParameter(conflictedFiles, "conflictedFiles");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(conflictedFiles);
    }

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ParentFolderConflictAction;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "confirmResolution", "", "resolution", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class ParentFolderConflictAction {
        private final CancellableContinuation<ConflictResolution> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public ParentFolderConflictAction(CancellableContinuation<? super ConflictResolution> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public final void confirmResolution(ConflictResolution resolution) {
            Intrinsics.checkNotNullParameter(resolution, "resolution");
            CancellableContinuation<ConflictResolution> cancellableContinuation = this.continuation;
            Result.Companion companion = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m9066constructorimpl(resolution));
        }
    }

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "confirmResolution", "", "resolutions", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class FolderContentConflictAction {
        private final CancellableContinuation<List<FileConflict>> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public FolderContentConflictAction(CancellableContinuation<? super List<FileConflict>> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public final void confirmResolution(List<FileConflict> resolutions) {
            Intrinsics.checkNotNullParameter(resolutions, "resolutions");
            CancellableContinuation<List<FileConflict>> cancellableContinuation = this.continuation;
            Result.Companion companion = kotlin.Result.Companion;
            cancellableContinuation.resumeWith(kotlin.Result.m9066constructorimpl(resolutions));
        }
    }

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "", "(Ljava/lang/String;I)V", "toCreateMode", "Lcom/anggrayudi/storage/file/CreateMode;", "toFileConflictResolution", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "REPLACE", "MERGE", "CREATE_NEW", "SKIP", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public enum ConflictResolution {
        REPLACE,
        MERGE,
        CREATE_NEW,
        SKIP;

        /* compiled from: FolderCallback.kt */
        @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ConflictResolution.values().length];
                iArr[ConflictResolution.REPLACE.ordinal()] = 1;
                iArr[ConflictResolution.MERGE.ordinal()] = 2;
                iArr[ConflictResolution.CREATE_NEW.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final CreateMode toCreateMode() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return CreateMode.REUSE;
                }
                return CreateMode.CREATE_NEW;
            }
            return CreateMode.REPLACE;
        }

        public final FileCallback.ConflictResolution toFileConflictResolution() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i != 1) {
                if (i == 3) {
                    return FileCallback.ConflictResolution.CREATE_NEW;
                }
                return FileCallback.ConflictResolution.SKIP;
            }
            return FileCallback.ConflictResolution.REPLACE;
        }
    }

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "", "source", "Landroidx/documentfile/provider/DocumentFile;", TypedValues.AttributesType.S_TARGET, "solution", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "(Landroidx/documentfile/provider/DocumentFile;Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;)V", "getSolution", "()Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "setSolution", "(Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;)V", "getSource", "()Landroidx/documentfile/provider/DocumentFile;", "getTarget", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class FileConflict {
        private FileCallback.ConflictResolution solution;
        private final DocumentFile source;
        private final DocumentFile target;

        public FileConflict(DocumentFile source, DocumentFile target, FileCallback.ConflictResolution solution) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(solution, "solution");
            this.source = source;
            this.target = target;
            this.solution = solution;
        }

        public final DocumentFile getSource() {
            return this.source;
        }

        public final DocumentFile getTarget() {
            return this.target;
        }

        public /* synthetic */ FileConflict(DocumentFile documentFile, DocumentFile documentFile2, FileCallback.ConflictResolution conflictResolution, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(documentFile, documentFile2, (i & 4) != 0 ? FileCallback.ConflictResolution.CREATE_NEW : conflictResolution);
        }

        public final FileCallback.ConflictResolution getSolution() {
            return this.solution;
        }

        public final void setSolution(FileCallback.ConflictResolution conflictResolution) {
            Intrinsics.checkNotNullParameter(conflictResolution, "<set-?>");
            this.solution = conflictResolution;
        }
    }

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$Report;", "", "progress", "", "bytesMoved", "", "writeSpeed", "", "fileCount", "(FJII)V", "getBytesMoved", "()J", "getFileCount", "()I", "getProgress", "()F", "getWriteSpeed", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
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

    /* compiled from: FolderCallback.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$Result;", "", "folder", "Landroidx/documentfile/provider/DocumentFile;", "totalFilesToCopy", "", "totalCopiedFiles", "success", "", "(Landroidx/documentfile/provider/DocumentFile;IIZ)V", "getFolder", "()Landroidx/documentfile/provider/DocumentFile;", "getSuccess", "()Z", "getTotalCopiedFiles", "()I", "getTotalFilesToCopy", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Result {
        private final DocumentFile folder;
        private final boolean success;
        private final int totalCopiedFiles;
        private final int totalFilesToCopy;

        public Result(DocumentFile folder, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            this.folder = folder;
            this.totalFilesToCopy = i;
            this.totalCopiedFiles = i2;
            this.success = z;
        }

        public final DocumentFile getFolder() {
            return this.folder;
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
