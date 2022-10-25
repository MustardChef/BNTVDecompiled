package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EgyBestProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EgyBestProvider", m98f = "EgyBestProvider.kt", m97i = {0, 0}, m96l = {bqk.f6554bN}, m95m = "loadLinks", m94n = {"this", "callback"}, m93s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class EgyBestProvider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EgyBestProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EgyBestProvider$loadLinks$1(EgyBestProvider egyBestProvider, Continuation<? super EgyBestProvider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = egyBestProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
