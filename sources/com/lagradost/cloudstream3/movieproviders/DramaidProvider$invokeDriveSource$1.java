package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DramaidProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.DramaidProvider", m98f = "DramaidProvider.kt", m97i = {0, 0, 0, 0}, m96l = {161}, m95m = "invokeDriveSource", m94n = {"this", "name", "subCallback", "sourceCallback"}, m93s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
public final class DramaidProvider$invokeDriveSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DramaidProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DramaidProvider$invokeDriveSource$1(DramaidProvider dramaidProvider, Continuation<? super DramaidProvider$invokeDriveSource$1> continuation) {
        super(continuation);
        this.this$0 = dramaidProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeDriveSource;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        invokeDriveSource = this.this$0.invokeDriveSource(null, null, null, null, this);
        return invokeDriveSource;
    }
}