package com.lagradost.cloudstream3.syncproviders.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxApi.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.providers.NginxApi", m98f = "NginxApi.kt", m97i = {}, m96l = {38}, m95m = "login", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class NginxApi$login$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NginxApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxApi$login$1(NginxApi nginxApi, Continuation<? super NginxApi$login$1> continuation) {
        super(continuation);
        this.this$0 = nginxApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.login(null, this);
    }
}
