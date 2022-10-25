package com.lagradost.cloudstream3.metaproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.cast.MediaError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TmdbProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.TmdbProvider", m98f = "TmdbProvider.kt", m97i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7, 8}, m96l = {290, 294, 302, TypedValues.AttributesType.TYPE_PIVOT_TARGET, MediaError.DetailedErrorCode.DASH_NO_INIT, 330, 339, 342, 352}, m95m = "load$suspendImpl", m94n = {"this", "id", "this", "response", "id", "this", "response", "this", "id", "this", "response", "id", "this", "response", "this", "id", "this", "it", "id", "this"}, m93s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "I$0", "L$0", "L$1", "I$0", "L$0"})
/* loaded from: classes3.dex */
public final class TmdbProvider$load$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TmdbProvider$load$1(TmdbProvider tmdbProvider, Continuation<? super TmdbProvider$load$1> continuation) {
        super(continuation);
        this.this$0 = tmdbProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TmdbProvider.load$suspendImpl(this.this$0, (String) null, (Continuation) this);
    }
}
