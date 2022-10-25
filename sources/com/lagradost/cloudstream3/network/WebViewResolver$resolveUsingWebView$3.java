package com.lagradost.cloudstream3.network;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import okhttp3.Headers;
import okhttp3.Request;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewResolver.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.network.WebViewResolver$resolveUsingWebView$3", m98f = "WebViewResolver.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class WebViewResolver$resolveUsingWebView$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Request> $extraRequestList;
    final /* synthetic */ Ref.ObjectRef<Request> $fixedRequest;
    final /* synthetic */ Headers $headers;
    final /* synthetic */ Function1<Request, Boolean> $requestCallBack;
    final /* synthetic */ String $url;
    final /* synthetic */ Ref.ObjectRef<WebView> $webView;
    int label;
    final /* synthetic */ WebViewResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WebViewResolver$resolveUsingWebView$3(Ref.ObjectRef<WebView> objectRef, String str, Headers headers, WebViewResolver webViewResolver, Ref.ObjectRef<Request> objectRef2, List<Request> list, Function1<? super Request, Boolean> function1, Continuation<? super WebViewResolver$resolveUsingWebView$3> continuation) {
        super(1, continuation);
        this.$webView = objectRef;
        this.$url = str;
        this.$headers = headers;
        this.this$0 = webViewResolver;
        this.$fixedRequest = objectRef2;
        this.$extraRequestList = list;
        this.$requestCallBack = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WebViewResolver$resolveUsingWebView$3(this.$webView, this.$url, this.$headers, this.this$0, this.$fixedRequest, this.$extraRequestList, this.$requestCallBack, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WebViewResolver$resolveUsingWebView$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.webkit.WebView] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<WebView> objectRef;
        Context context;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                objectRef = this.$webView;
                context = AcraApplication.Companion.getContext();
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
            if (context != null) {
                ?? webView = new WebView(context);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.getSettings().setUserAgentString(MainAPIKt.USER_AGENT);
                webView.getSettings().setBlockNetworkImage(true);
                objectRef.element = webView;
                WebView webView2 = this.$webView.element;
                if (webView2 != null) {
                    webView2.setWebViewClient(new C48342(this.this$0, this.$fixedRequest, this.$extraRequestList, this.$requestCallBack, this.$webView));
                }
                WebView webView3 = this.$webView.element;
                if (webView3 != null) {
                    webView3.loadUrl(this.$url, MapsKt.toMap(this.$headers));
                }
                return Unit.INSTANCE;
            }
            throw new RuntimeException("No base context in WebViewResolver");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* compiled from: WebViewResolver.kt */
    @Metadata(m108d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m107d2 = {"com/lagradost/cloudstream3/network/WebViewResolver$resolveUsingWebView$3$2", "Landroid/webkit/WebViewClient;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Landroid/webkit/WebResourceRequest;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.network.WebViewResolver$resolveUsingWebView$3$2 */
    /* loaded from: classes3.dex */
    public static final class C48342 extends WebViewClient {
        final /* synthetic */ List<Request> $extraRequestList;
        final /* synthetic */ Ref.ObjectRef<Request> $fixedRequest;
        final /* synthetic */ Function1<Request, Boolean> $requestCallBack;
        final /* synthetic */ Ref.ObjectRef<WebView> $webView;
        final /* synthetic */ WebViewResolver this$0;

        /* JADX WARN: Multi-variable type inference failed */
        C48342(WebViewResolver webViewResolver, Ref.ObjectRef<Request> objectRef, List<Request> list, Function1<? super Request, Boolean> function1, Ref.ObjectRef<WebView> objectRef2) {
            this.this$0 = webViewResolver;
            this.$fixedRequest = objectRef;
            this.$extraRequestList = list;
            this.$requestCallBack = function1;
            this.$webView = objectRef2;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Object runBlocking$default;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new WebViewResolver$resolveUsingWebView$3$2$shouldInterceptRequest$1(request, this.this$0, this.$fixedRequest, this.$extraRequestList, this, view, this.$requestCallBack, this.$webView, null), 1, null);
            return (WebResourceResponse) runBlocking$default;
        }
    }
}
