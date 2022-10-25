package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Phim247Provider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.Phim247Provider", m98f = "Phim247Provider.kt", m97i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m96l = {bqk.f6567ba, 241, bqk.f6546bF}, m95m = "loadLinks", m94n = {"this", "subtitleCallback", "callback", "this", "subtitleCallback", "callback", "urlPlaylist", "urlVietSub", "urlEngSub", "this", "subtitleCallback", "callback", "it", "urlPlaylist"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes3.dex */
public final class Phim247Provider$loadLinks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Phim247Provider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Phim247Provider$loadLinks$1(Phim247Provider phim247Provider, Continuation<? super Phim247Provider$loadLinks$1> continuation) {
        super(continuation);
        this.this$0 = phim247Provider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLinks(null, false, null, null, this);
    }
}
