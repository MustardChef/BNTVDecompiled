package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtractorApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ExtractorApiKt", m98f = "ExtractorApi.kt", m97i = {0}, m96l = {150}, m95m = "unshortenLinkSafe", m94n = {"url"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class ExtractorApiKt$unshortenLinkSafe$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtractorApiKt$unshortenLinkSafe$1(Continuation<? super ExtractorApiKt$unshortenLinkSafe$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExtractorApiKt.unshortenLinkSafe(null, this);
    }
}
