package com.lagradost.cloudstream3.movieproviders;

import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubNhanhProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SubNhanhProvider", m98f = "SubNhanhProvider.kt", m97i = {0, 1}, m96l = {MediaError.DetailedErrorCode.DASH_NO_INIT, 327}, m95m = "getDataEpisode", m94n = {"this", "this"}, m93s = {"L$0", "L$0"})
/* loaded from: classes3.dex */
public final class SubNhanhProvider$getDataEpisode$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubNhanhProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubNhanhProvider$getDataEpisode$1(SubNhanhProvider subNhanhProvider, Continuation<? super SubNhanhProvider$getDataEpisode$1> continuation) {
        super(continuation);
        this.this$0 = subNhanhProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDataEpisode(null, this);
    }
}
