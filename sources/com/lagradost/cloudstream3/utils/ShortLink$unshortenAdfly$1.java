package com.lagradost.cloudstream3.utils;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnshortenUrl.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.ShortLink", m98f = "UnshortenUrl.kt", m97i = {0}, m96l = {68}, m95m = "unshortenAdfly", m94n = {ShareConstants.MEDIA_URI}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class ShortLink$unshortenAdfly$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnshortenUrl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortLink$unshortenAdfly$1(UnshortenUrl unshortenUrl, Continuation<? super ShortLink$unshortenAdfly$1> continuation) {
        super(continuation);
        this.this$0 = unshortenUrl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.unshortenAdfly(null, this);
    }
}
