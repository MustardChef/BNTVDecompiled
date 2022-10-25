package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.Extensions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Extensions.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.Extensions$RequestCustom", m98f = "Extensions.kt", m97i = {0}, m96l = {81}, m95m = "postWithCustomCache", m94n = {"url"}, m93s = {"L$0"})
/* loaded from: classes4.dex */
public final class Extensions$RequestCustom$postWithCustomCache$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Extensions.RequestCustom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Extensions$RequestCustom$postWithCustomCache$1(Extensions.RequestCustom requestCustom, Continuation<? super Extensions$RequestCustom$postWithCustomCache$1> continuation) {
        super(continuation);
        this.this$0 = requestCustom;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postWithCustomCache(null, null, null, null, null, null, null, null, null, false, 0, null, 0L, null, false, this);
    }
}
