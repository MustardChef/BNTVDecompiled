package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.CreateMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: FileCallback.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004\u0015\u0016\u0017\u0018B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0017J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¨\u0006\u0019"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/FileCallback$Report;", "", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCompleted", "", "result", "onConflict", "destinationFile", "Landroidx/documentfile/provider/DocumentFile;", "action", "Lcom/anggrayudi/storage/callback/FileCallback$FileConflictAction;", "onStart", "", "file", "workerThread", "Ljava/lang/Thread;", "ConflictResolution", "ErrorCode", "FileConflictAction", "Report", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public abstract class FileCallback extends BaseFileCallback<ErrorCode, Report, Object> {

    /* compiled from: FileCallback.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FILE_NOT_FOUND", "TARGET_FILE_NOT_FOUND", "TARGET_FOLDER_NOT_FOUND", "UNKNOWN_IO_ERROR", "CANCELED", "TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER", "NO_SPACE_LEFT_ON_TARGET_PATH", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FILE_NOT_FOUND,
        TARGET_FILE_NOT_FOUND,
        TARGET_FOLDER_NOT_FOUND,
        UNKNOWN_IO_ERROR,
        CANCELED,
        TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    public FileCallback() {
        this(null, 1, null);
    }

    @Override // com.anggrayudi.storage.callback.BaseFileCallback
    public void onCompleted(Object result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    public long onStart(Object file, Thread workerThread) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(workerThread, "workerThread");
        return 0L;
    }

    public /* synthetic */ FileCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCallback(CoroutineScope uiScope) {
        super(uiScope);
        Intrinsics.checkNotNullParameter(uiScope, "uiScope");
    }

    public void onConflict(DocumentFile destinationFile, FileConflictAction action) {
        Intrinsics.checkNotNullParameter(destinationFile, "destinationFile");
        Intrinsics.checkNotNullParameter(action, "action");
        action.confirmResolution(ConflictResolution.CREATE_NEW);
    }

    /* compiled from: FileCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$FileConflictAction;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "confirmResolution", "", "resolution", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class FileConflictAction {
        private final CancellableContinuation<ConflictResolution> continuation;

        /* JADX WARN: Multi-variable type inference failed */
        public FileConflictAction(CancellableContinuation<? super ConflictResolution> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.continuation = continuation;
        }

        public final void confirmResolution(ConflictResolution resolution) {
            Intrinsics.checkNotNullParameter(resolution, "resolution");
            CancellableContinuation<ConflictResolution> cancellableContinuation = this.continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9066constructorimpl(resolution));
        }
    }

    /* compiled from: FileCallback.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "", "(Ljava/lang/String;I)V", "toCreateMode", "Lcom/anggrayudi/storage/file/CreateMode;", "REPLACE", "CREATE_NEW", "SKIP", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public enum ConflictResolution {
        REPLACE,
        CREATE_NEW,
        SKIP;

        public final CreateMode toCreateMode() {
            return this == REPLACE ? CreateMode.REPLACE : CreateMode.CREATE_NEW;
        }
    }

    /* compiled from: FileCallback.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m107d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$Report;", "", "progress", "", "bytesMoved", "", "writeSpeed", "", "(FJI)V", "getBytesMoved", "()J", "getProgress", "()F", "getWriteSpeed", "()I", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Report {
        private final long bytesMoved;
        private final float progress;
        private final int writeSpeed;

        public Report(float f, long j, int i) {
            this.progress = f;
            this.bytesMoved = j;
            this.writeSpeed = i;
        }

        public final long getBytesMoved() {
            return this.bytesMoved;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final int getWriteSpeed() {
            return this.writeSpeed;
        }
    }
}
