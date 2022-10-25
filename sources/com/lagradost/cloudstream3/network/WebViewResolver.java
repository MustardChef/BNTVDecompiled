package com.lagradost.cloudstream3.network;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.nicehttp.RequestsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: WebViewResolver.kt */
@Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016JC\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0014H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001a\u00020\u0011*\u00020\u0018J\n\u0010\u0019\u001a\u00020\u001a*\u00020\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/network/WebViewResolver;", "Lokhttp3/Interceptor;", "interceptUrl", "Lkotlin/text/Regex;", "additionalUrls", "", "(Lkotlin/text/Regex;Ljava/util/List;)V", "getAdditionalUrls", "()Ljava/util/List;", "getInterceptUrl", "()Lkotlin/text/Regex;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "resolveUsingWebView", "Lkotlin/Pair;", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "requestCallBack", "Lkotlin/Function1;", "", "(Lokhttp3/Request;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toRequest", "Landroid/webkit/WebResourceRequest;", "toWebResourceResponse", "Landroid/webkit/WebResourceResponse;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WebViewResolver implements Interceptor {
    private final List<Regex> additionalUrls;
    private final Regex interceptUrl;

    public WebViewResolver(Regex interceptUrl, List<Regex> additionalUrls) {
        Intrinsics.checkNotNullParameter(interceptUrl, "interceptUrl");
        Intrinsics.checkNotNullParameter(additionalUrls, "additionalUrls");
        this.interceptUrl = interceptUrl;
        this.additionalUrls = additionalUrls;
    }

    public /* synthetic */ WebViewResolver(Regex regex, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Regex> getAdditionalUrls() {
        return this.additionalUrls;
    }

    public final Regex getInterceptUrl() {
        return this.interceptUrl;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return (Response) BuildersKt.runBlocking$default(null, new WebViewResolver$intercept$1(this, chain.request(), chain, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d3 -> B:24:0x00d6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resolveUsingWebView(okhttp3.Request r21, kotlin.jvm.functions.Function1<? super okhttp3.Request, java.lang.Boolean> r22, kotlin.coroutines.Continuation<? super kotlin.Tuples<okhttp3.Request, ? extends java.util.List<okhttp3.Request>>> r23) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.network.WebViewResolver.resolveUsingWebView(okhttp3.Request, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object resolveUsingWebView$default(WebViewResolver webViewResolver, Request request, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = WebViewResolver$resolveUsingWebView$2.INSTANCE;
        }
        return webViewResolver.resolveUsingWebView(request, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveUsingWebView$destroyWebView(Ref.ObjectRef<WebView> objectRef) {
        Coroutines.INSTANCE.main(new WebViewResolver$resolveUsingWebView$destroyWebView$1(objectRef, null));
    }

    public final Request toRequest(WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "<this>");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "this.url.toString()");
        String method = webResourceRequest.getMethod();
        Intrinsics.checkNotNullExpressionValue(method, "this.method");
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        Intrinsics.checkNotNullExpressionValue(requestHeaders, "this.requestHeaders");
        return RequestsKt.requestCreator$default(method, uri, requestHeaders, null, null, null, null, null, null, null, null, null, 4088, null);
    }

    public final WebResourceResponse toWebResourceResponse(Response response) {
        WebResourceResponse webResourceResponse;
        String str;
        List<String> groupValues;
        String str2;
        List<String> groupValues2;
        String str3;
        Intrinsics.checkNotNullParameter(response, "<this>");
        String header$default = Response.header$default(response, "Content-Type", null, 2, null);
        Regex regex = new Regex("(.*);(?:.*charset=(.*)(?:|;)|)");
        if (header$default != null) {
            MatchResult find$default = Regex.find$default(regex, header$default, 0, 2, null);
            if (find$default != null && (groupValues2 = find$default.getGroupValues()) != null && (str3 = (String) CollectionsKt.getOrNull(groupValues2, 1)) != null) {
                String str4 = str3;
                if (StringsKt.isBlank(str4)) {
                    str4 = null;
                }
                String str5 = str4;
                if (str5 != null) {
                    header$default = str5;
                }
            }
            if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 2)) == null) {
                str = null;
            } else {
                String str6 = str2;
                if (StringsKt.isBlank(str6)) {
                    str6 = null;
                }
                str = str6;
            }
            ResponseBody body = response.body();
            webResourceResponse = new WebResourceResponse(header$default, str, body != null ? body.byteStream() : null);
        } else {
            ResponseBody body2 = response.body();
            webResourceResponse = new WebResourceResponse(MimeType.BINARY_FILE, null, body2 != null ? body2.byteStream() : null);
        }
        return webResourceResponse;
    }
}
