package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnshortenUrl.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ShortLink", m98f = "UnshortenUrl.kt", m97i = {0, 0, 0}, m96l = {59}, m95m = "unshorten", m94n = {"type", "currentUrl", "oldurl"}, m93s = {"L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class ShortLink$unshorten$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnshortenUrl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortLink$unshorten$1(UnshortenUrl unshortenUrl, Continuation<? super ShortLink$unshorten$1> continuation) {
        super(continuation);
        this.this$0 = unshortenUrl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.unshorten(null, null, this);
    }
}
