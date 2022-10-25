package com.lagradost.cloudstream3.services;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseSubtitle.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/ResponseSubtitle;", "", "fullPath", "", "(Ljava/lang/String;)V", "getFullPath", "()Ljava/lang/String;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ResponseSubtitle {
    private final String fullPath;

    public ResponseSubtitle(String fullPath) {
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        this.fullPath = fullPath;
    }

    public final String getFullPath() {
        return this.fullPath;
    }
}
