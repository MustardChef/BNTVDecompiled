package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoLinkGenerator.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.RepoLinkGenerator", m98f = "RepoLinkGenerator.kt", m97i = {0, 0, 0, 0, 0}, m96l = {108}, m95m = "generateLinks", m94n = {"this", "subtitleCallback", "current", "currentLinkCache", "currentSubsCache"}, m93s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator$generateLinks$1 */
/* loaded from: classes3.dex */
public final class RepoLinkGenerator$generateLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepoLinkGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoLinkGenerator$generateLinks$1(RepoLinkGenerator repoLinkGenerator, Continuation<? super RepoLinkGenerator$generateLinks$1> continuation) {
        super(continuation);
        this.this$0 = repoLinkGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.generateLinks(false, false, null, null, 0, this);
    }
}
