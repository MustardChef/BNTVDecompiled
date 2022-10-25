package com.lagradost.cloudstream3.extractors;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SBPlay.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.SBPlay", m98f = "SBPlay.kt", m97i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3}, m96l = {26, 41, 42, 46}, m95m = "getUrl$suspendImpl", m94n = {"this", "this", "links", "name", ShareConstants.WEB_DIALOG_PARAM_HREF, "this", "links", "name", ShareConstants.WEB_DIALOG_PARAM_HREF, "hrefResponse", "this", "links", "name"}, m93s = {"L$0", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$3", "L$4", "L$5", "L$0", "L$1", "L$3"})
/* loaded from: classes3.dex */
public final class SBPlay$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SBPlay this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SBPlay$getUrl$1(SBPlay sBPlay, Continuation<? super SBPlay$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = sBPlay;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SBPlay.getUrl$suspendImpl(this.this$0, (String) null, (String) null, (Continuation) this);
    }
}
