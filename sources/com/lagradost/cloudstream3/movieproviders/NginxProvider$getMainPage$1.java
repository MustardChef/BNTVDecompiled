package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.NginxProvider", m98f = "NginxProvider.kt", m97i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, m96l = {bqk.f6557bQ, bqk.f6562bV, 238, bqk.f6594ca}, m95m = "getMainPage", m94n = {"this", "authHeader", "this", "authHeader", "destination$iv$iv", "categoryTitle", "categoryPath", "this", "authHeader", "destination$iv$iv", "categoryTitle", "categoryPath", "destination$iv$iv", "mediaRootUrl", "this", "authHeader", "destination$iv$iv", "categoryTitle", "categoryPath", "destination$iv$iv", "mediaRootUrl", "nfoPath", "isMovieType"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "I$0"})
/* loaded from: classes3.dex */
public final class NginxProvider$getMainPage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NginxProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$getMainPage$1(NginxProvider nginxProvider, Continuation<? super NginxProvider$getMainPage$1> continuation) {
        super(continuation);
        this.this$0 = nginxProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMainPage(this);
    }
}
