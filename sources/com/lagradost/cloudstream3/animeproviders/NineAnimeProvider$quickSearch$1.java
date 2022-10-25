package com.lagradost.cloudstream3.animeproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NineAnimeProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.NineAnimeProvider", m98f = "NineAnimeProvider.kt", m97i = {0}, m96l = {198}, m95m = "quickSearch", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class NineAnimeProvider$quickSearch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NineAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineAnimeProvider$quickSearch$1(NineAnimeProvider nineAnimeProvider, Continuation<? super NineAnimeProvider$quickSearch$1> continuation) {
        super(continuation);
        this.this$0 = nineAnimeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.quickSearch(null, this);
    }
}
