package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayarKaca21Provider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.LayarKacaProvider", m98f = "LayarKaca21Provider.kt", m97i = {0}, m96l = {112}, m95m = "search", m94n = {"this"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class LayarKacaProvider$search$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LayarKaca21Provider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayarKacaProvider$search$1(LayarKaca21Provider layarKaca21Provider, Continuation<? super LayarKacaProvider$search$1> continuation) {
        super(continuation);
        this.this$0 = layarKaca21Provider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.search(null, this);
    }
}
