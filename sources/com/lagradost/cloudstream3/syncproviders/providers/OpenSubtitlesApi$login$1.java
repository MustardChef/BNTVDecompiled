package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpenSubtitlesApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi", m98f = "OpenSubtitlesApi.kt", m97i = {0}, m96l = {132}, m95m = "login", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class OpenSubtitlesApi$login$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenSubtitlesApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenSubtitlesApi$login$1(OpenSubtitlesApi openSubtitlesApi, Continuation<? super OpenSubtitlesApi$login$1> continuation) {
        super(continuation);
        this.this$0 = openSubtitlesApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.login(null, this);
    }
}
