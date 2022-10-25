package com.lagradost.cloudstream3.network;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.network.WebViewResolver$resolveUsingWebView$3;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;

/* compiled from: WebViewResolver.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Landroid/webkit/WebResourceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.network.WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1", m98f = "WebViewResolver.kt", m97i = {}, m96l = {156, 161}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WebResourceResponse>, Object> {
    final /* synthetic */ List<Request> $extraRequestList;
    final /* synthetic */ Ref.ObjectRef<Request> $fixedRequest;
    final /* synthetic */ WebResourceRequest $request;
    final /* synthetic */ Function1<Request, Boolean> $requestCallBack;
    final /* synthetic */ WebView $view;
    final /* synthetic */ Ref.ObjectRef<WebView> $webView;
    Object L$0;
    int label;
    final /* synthetic */ WebViewResolver this$0;
    final /* synthetic */ WebViewResolver$resolveUsingWebView$3.C48342 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1(WebResourceRequest webResourceRequest, WebViewResolver webViewResolver, Ref.ObjectRef<Request> objectRef, List<Request> list, WebViewResolver$resolveUsingWebView$3.C48342 c48342, WebView webView, Function1<? super Request, Boolean> function1, Ref.ObjectRef<WebView> objectRef2, Continuation<? super WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1> continuation) {
        super(2, continuation);
        this.$request = webResourceRequest;
        this.this$0 = webViewResolver;
        this.$fixedRequest = objectRef;
        this.$extraRequestList = list;
        this.this$1 = c48342;
        this.$view = webView;
        this.$requestCallBack = function1;
        this.$webView = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1(this.$request, this.this$0, this.$fixedRequest, this.$extraRequestList, this.this$1, this.$view, this.$requestCallBack, this.$webView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WebResourceResponse> continuation) {
        return ((WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39, types: [okhttp3.Request, T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        WebResourceResponse shouldInterceptRequest;
        Object post$default;
        WebViewResolver webViewResolver;
        Object obj2;
        WebViewResolver webViewResolver2;
        WebResourceResponse shouldInterceptRequest2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    webViewResolver2 = (WebViewResolver) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    return webViewResolver2.toWebResourceResponse(((NiceResponse) obj2).getOkhttpResponse());
                } else if (i == 2) {
                    webViewResolver = (WebViewResolver) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    post$default = obj;
                    return webViewResolver.toWebResourceResponse(((NiceResponse) post$default).getOkhttpResponse());
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            String uri = this.$request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            String str = uri;
            if (this.this$0.getInterceptUrl().containsMatchIn(str)) {
                Ref.ObjectRef<Request> objectRef = this.$fixedRequest;
                ?? request = this.this$0.toRequest(this.$request);
                Function1<Request, Boolean> function1 = this.$requestCallBack;
                Ref.ObjectRef<WebView> objectRef2 = this.$webView;
                if (((Boolean) function1.invoke(request)).booleanValue()) {
                    WebViewResolver.resolveUsingWebView$destroyWebView(objectRef2);
                }
                objectRef.element = request;
                System.out.println((Object) ("Web-view request finished: " + uri));
                WebViewResolver.resolveUsingWebView$destroyWebView(this.$webView);
                return null;
            }
            List<Regex> additionalUrls = this.this$0.getAdditionalUrls();
            if (!(additionalUrls instanceof Collection) || !additionalUrls.isEmpty()) {
                for (Regex regex : additionalUrls) {
                    if (regex.containsMatchIn(str)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                List<Request> list = this.$extraRequestList;
                Request request2 = this.this$0.toRequest(this.$request);
                Function1<Request, Boolean> function12 = this.$requestCallBack;
                Ref.ObjectRef<WebView> objectRef3 = this.$webView;
                if (function12.invoke(request2).booleanValue()) {
                    WebViewResolver.resolveUsingWebView$destroyWebView(objectRef3);
                }
                list.add(request2);
            }
            List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{".jpg", ".png", ".webp", ".mpg", ".mpeg", ".jpeg", ".webm", ".mp4", ".mp3", ".gifv", ".flv", ".asf", ".mov", ".mng", ".mkv", ".ogg", ".avi", ".wav", ".woff2", ".woff", ".ttf", ".css", ".vtt", ".srt", ".ts", ".gif", "wss://"});
            if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
                for (String str2 : listOf) {
                    String path = new URI(uri).getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "URI(webViewUrl).path");
                    if (StringsKt.contains$default((CharSequence) path, (CharSequence) str2, false, 2, (Object) null)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2 && !StringsKt.endsWith$default(uri, "/favicon.ico", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) uri, (CharSequence) "recaptcha", false, 2, (Object) null)) {
                    shouldInterceptRequest2 = super/*android.webkit.WebViewClient*/.shouldInterceptRequest(this.$view, this.$request);
                    return shouldInterceptRequest2;
                } else if (Intrinsics.areEqual(this.$request.getMethod(), ShareTarget.METHOD_GET)) {
                    WebViewResolver webViewResolver3 = this.this$0;
                    Map<String, String> requestHeaders = this.$request.getRequestHeaders();
                    Intrinsics.checkNotNullExpressionValue(requestHeaders, "request.requestHeaders");
                    this.L$0 = webViewResolver3;
                    this.label = 1;
                    obj2 = Requests.get$default(MainActivityKt.getApp(), uri, requestHeaders, null, null, null, false, 0, null, 0L, null, false, this, 2044, null);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    webViewResolver2 = webViewResolver3;
                    return webViewResolver2.toWebResourceResponse(((NiceResponse) obj2).getOkhttpResponse());
                } else if (!Intrinsics.areEqual(this.$request.getMethod(), ShareTarget.METHOD_POST)) {
                    shouldInterceptRequest = super/*android.webkit.WebViewClient*/.shouldInterceptRequest(this.$view, this.$request);
                    return shouldInterceptRequest;
                } else {
                    WebViewResolver webViewResolver4 = this.this$0;
                    Map<String, String> requestHeaders2 = this.$request.getRequestHeaders();
                    Intrinsics.checkNotNullExpressionValue(requestHeaders2, "request.requestHeaders");
                    this.L$0 = webViewResolver4;
                    this.label = 2;
                    post$default = Requests.post$default(MainActivityKt.getApp(), uri, requestHeaders2, null, null, null, null, null, null, null, false, 0, null, 0L, null, false, this, 32764, null);
                    if (post$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    webViewResolver = webViewResolver4;
                    return webViewResolver.toWebResourceResponse(((NiceResponse) post$default).getOkhttpResponse());
                }
            }
            return new WebResourceResponse("image/png", null, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
