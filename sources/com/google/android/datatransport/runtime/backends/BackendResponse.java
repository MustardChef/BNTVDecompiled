package com.google.android.datatransport.runtime.backends;

/* loaded from: classes2.dex */
public abstract class BackendResponse {

    /* loaded from: classes2.dex */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();

    public static BackendResponse transientError() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
    }

    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
    }

    /* renamed from: ok */
    public static BackendResponse m422ok(long j) {
        return new AutoValue_BackendResponse(Status.OK, j);
    }
}
