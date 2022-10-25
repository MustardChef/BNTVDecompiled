package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IdlixProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.IdlixProvider", m98f = "IdlixProvider.kt", m97i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m96l = {bqk.f6565bY, bqk.f6567ba}, m95m = "invokeLaviolaSource", m94n = {"this", "subCallback", "sourceCallback", "this", "subCallback", "sourceCallback", "baseName", "baseUrl", "destination$iv$iv", "script", "destination$iv$iv", "m3u"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$10"})
/* loaded from: classes3.dex */
public final class IdlixProvider$invokeLaviolaSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
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
    final /* synthetic */ IdlixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdlixProvider$invokeLaviolaSource$1(IdlixProvider idlixProvider, Continuation<? super IdlixProvider$invokeLaviolaSource$1> continuation) {
        super(continuation);
        this.this$0 = idlixProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeLaviolaSource;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeLaviolaSource = this.this$0.invokeLaviolaSource(null, null, null, this);
        return invokeLaviolaSource;
    }
}
