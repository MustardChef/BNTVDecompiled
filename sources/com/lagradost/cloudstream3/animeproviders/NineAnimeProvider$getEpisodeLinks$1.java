package com.lagradost.cloudstream3.animeproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NineAnimeProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.NineAnimeProvider", m98f = "NineAnimeProvider.kt", m97i = {}, m96l = {324}, m95m = "getEpisodeLinks", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class NineAnimeProvider$getEpisodeLinks$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NineAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineAnimeProvider$getEpisodeLinks$1(NineAnimeProvider nineAnimeProvider, Continuation<? super NineAnimeProvider$getEpisodeLinks$1> continuation) {
        super(continuation);
        this.this$0 = nineAnimeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object episodeLinks;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        episodeLinks = this.this$0.getEpisodeLinks(null, this);
        return episodeLinks;
    }
}
