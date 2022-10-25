package com.anggrayudi.storage.callback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseFileCallback.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0002H\u0017¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0017J\u0015\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0013J\b\u0010\u0017\u001a\u00020\u0011H\u0017J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00028\u0001H\u0017¢\u0006\u0002\u0010\u0013J\b\u0010\u001a\u001a\u00020\u0011H\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u001b"}, m107d2 = {"Lcom/anggrayudi/storage/callback/BaseFileCallback;", "ErrorCode", "Report", "Result", "", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "setUiScope", "onCheckFreeSpace", "", "freeSpace", "", "fileSize", "onCompleted", "", "result", "(Ljava/lang/Object;)V", "onDeleteConflictedFiles", "onFailed", "errorCode", "onPrepare", "onReport", "report", "onValidate", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public abstract class BaseFileCallback<ErrorCode, Report, Result> {
    private CoroutineScope uiScope;

    public boolean onCheckFreeSpace(long j, long j2) {
        return j2 + ((long) 104857600) < j;
    }

    public void onCompleted(Result result) {
    }

    public void onDeleteConflictedFiles() {
    }

    public void onFailed(ErrorCode errorcode) {
    }

    public void onPrepare() {
    }

    public void onReport(Report report) {
    }

    public void onValidate() {
    }

    public BaseFileCallback(CoroutineScope uiScope) {
        Intrinsics.checkNotNullParameter(uiScope, "uiScope");
        this.uiScope = uiScope;
    }

    public final CoroutineScope getUiScope() {
        return this.uiScope;
    }

    public final void setUiScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.uiScope = coroutineScope;
    }
}
