package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncUtil.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.SyncUtil", m98f = "SyncUtil.kt", m97i = {}, m96l = {63}, m95m = "getIdsFromSlug", m94n = {}, m93s = {})
/* loaded from: classes4.dex */
public final class SyncUtil$getIdsFromSlug$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SyncUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtil$getIdsFromSlug$1(SyncUtil syncUtil, Continuation<? super SyncUtil$getIdsFromSlug$1> continuation) {
        super(continuation);
        this.this$0 = syncUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object idsFromSlug;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        idsFromSlug = this.this$0.getIdsFromSlug(null, null, this);
        return idsFromSlug;
    }
}
