package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal.http.HttpStatusCodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion", m98f = "SflixProvider.kt", m97i = {0, 0, 0, 1, 1, 1}, m96l = {HttpStatusCodes.HTTP_UNAVAILABLE_FOR_LEGAL_REASONS, 454}, m95m = "negotiateNewSid", m94n = {"this", "baseUrl", "i", "this", "baseUrl", "i"}, m93s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes3.dex */
public final class SflixProvider$Companion$negotiateNewSid$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SflixProvider.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$Companion$negotiateNewSid$1(SflixProvider.Companion companion, Continuation<? super SflixProvider$Companion$negotiateNewSid$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object negotiateNewSid;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        negotiateNewSid = this.this$0.negotiateNewSid(null, this);
        return negotiateNewSid;
    }
}
