package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtractorApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ExtractorApiKt", m98f = "ExtractorApi.kt", m97i = {0, 0, 0, 0, 0}, m96l = {355, 357}, m95m = "getPostForm", m94n = {"requestUrl", "op", "id", "mode", "hash"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes4.dex */
public final class ExtractorApiKt$getPostForm$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtractorApiKt$getPostForm$1(Continuation<? super ExtractorApiKt$getPostForm$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExtractorApiKt.getPostForm(null, null, this);
    }
}
