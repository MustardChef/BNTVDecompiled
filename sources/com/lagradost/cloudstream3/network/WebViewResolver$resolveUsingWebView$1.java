package com.lagradost.cloudstream3.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewResolver.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.network.WebViewResolver", m98f = "WebViewResolver.kt", m97i = {0, 0, 0, 0, 0, 0}, m96l = {192}, m95m = "resolveUsingWebView", m94n = {"webView", "fixedRequest", "extraRequestList", "loop", "totalTime", "delayTime"}, m93s = {"L$0", "L$1", "L$2", "I$0", "J$0", "J$1"})
/* loaded from: classes3.dex */
public final class WebViewResolver$resolveUsingWebView$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewResolver$resolveUsingWebView$1(WebViewResolver webViewResolver, Continuation<? super WebViewResolver$resolveUsingWebView$1> continuation) {
        super(continuation);
        this.this$0 = webViewResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resolveUsingWebView(null, null, this);
    }
}
