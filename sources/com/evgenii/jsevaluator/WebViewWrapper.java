package com.evgenii.jsevaluator;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;
import com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class WebViewWrapper implements WebViewWrapperInterface {
    protected WebView mWebView;

    public WebViewWrapper(Context context, CallJavaResultInterface callJavaResultInterface) {
        WebView webView = new WebView(context);
        this.mWebView = webView;
        webView.setWillNotDraw(true);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        this.mWebView.addJavascriptInterface(new JavaScriptInterface(callJavaResultInterface), JsEvaluator.JS_NAMESPACE);
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public void loadJavaScript(String str) {
        try {
            String encodeToString = Base64.encodeToString(("<script>" + str + "</script>").getBytes("UTF-8"), 0);
            WebView webView = this.mWebView;
            webView.loadUrl("data:text/html;charset=utf-8;base64," + encodeToString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public void destroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.removeJavascriptInterface(JsEvaluator.JS_NAMESPACE);
            this.mWebView.loadUrl("about:blank");
            this.mWebView.stopLoading();
            if (Build.VERSION.SDK_INT < 19) {
                this.mWebView.freeMemory();
            }
            this.mWebView.clearHistory();
            this.mWebView.removeAllViews();
            this.mWebView.destroyDrawingCache();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    @Override // com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface
    public WebView getWebView() {
        return this.mWebView;
    }
}
