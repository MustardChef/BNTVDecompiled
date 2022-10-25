package com.lagradost.cloudstream3.extractors.helper;

import com.lagradost.cloudstream3.extractors.helper.WcoHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WcoHelper.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.helper.WcoHelper$Companion", m98f = "WcoHelper.kt", m97i = {}, m96l = {39}, m95m = "getWcoKey", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class WcoHelper$Companion$getWcoKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcoHelper.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WcoHelper$Companion$getWcoKey$1(WcoHelper.Companion companion, Continuation<? super WcoHelper$Companion$getWcoKey$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getWcoKey(this);
    }
}
