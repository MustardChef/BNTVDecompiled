package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtractorApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ExtractorApiKt", m98f = "ExtractorApi.kt", m97i = {0, 0, 0}, m96l = {180, 184}, m95m = "loadExtractor", m94n = {"referer", "subtitleCallback", "callback"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class ExtractorApiKt$loadExtractor$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtractorApiKt$loadExtractor$2(Continuation<? super ExtractorApiKt$loadExtractor$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExtractorApiKt.loadExtractor(null, null, null, null, this);
    }
}
