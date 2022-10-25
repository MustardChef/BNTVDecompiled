package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pelisplus.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Pelisplus", m98f = "Pelisplus.kt", m97i = {0, 0, 0, 0, 1, 1, 1, 1}, m96l = {45, 76}, m95m = "getUrl", m94n = {"subtitleCallback", "callback", "extractorUrl", "isCasting", "subtitleCallback", "callback", "extractorUrl", "isCasting"}, m93s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes3.dex */
public final class Pelisplus$getUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Pelisplus this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pelisplus$getUrl$1(Pelisplus pelisplus, Continuation<? super Pelisplus$getUrl$1> continuation) {
        super(continuation);
        this.this$0 = pelisplus;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getUrl(null, false, null, null, this);
    }
}
