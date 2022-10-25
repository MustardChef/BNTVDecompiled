package com.lagradost.cloudstream3.mvvm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchComponentExt.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.mvvm.ArchComponentExtKt", m98f = "ArchComponentExt.kt", m97i = {}, m96l = {56}, m95m = "suspendSafeApiCall", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class ArchComponentExtKt$suspendSafeApiCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArchComponentExtKt$suspendSafeApiCall$1(Continuation<? super ArchComponentExtKt$suspendSafeApiCall$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ArchComponentExt.suspendSafeApiCall(null, this);
    }
}
