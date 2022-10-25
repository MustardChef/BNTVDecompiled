package com.evgenii.jsevaluator;

import android.content.Context;
import android.webkit.WebView;
import com.evgenii.jsevaluator.interfaces.CallJavaResultInterface;
import com.evgenii.jsevaluator.interfaces.HandlerWrapperInterface;
import com.evgenii.jsevaluator.interfaces.JsCallback;
import com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface;
import com.evgenii.jsevaluator.interfaces.WebViewWrapperInterface;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class JsEvaluator implements CallJavaResultInterface, JsEvaluatorInterface {
    private static final String JS_ERROR_PREFIX = "evgeniiJsEvaluatorException";
    public static final String JS_NAMESPACE = "evgeniiJsEvaluator";
    private final Context mContext;
    protected WebViewWrapperInterface mWebViewWrapper;
    private AtomicReference<JsCallback> callback = new AtomicReference<>(null);
    private HandlerWrapperInterface mHandler = new HandlerWrapper();

    public static String escapeCarriageReturn(String str) {
        return str.replace("\r", "\\r");
    }

    public static String escapeClosingScript(String str) {
        return str.replace("</", "<\\/");
    }

    public static String escapeNewLines(String str) {
        return str.replace("\n", "\\n");
    }

    public static String escapeSingleQuotes(String str) {
        return str.replace("'", "\\'");
    }

    public static String escapeSlash(String str) {
        return str.replace("\\", "\\\\");
    }

    public static String getJsForEval(String str) {
        return String.format("%s.returnResultToJava(eval('try{%s}catch(e){\"%s\"+e}'));", JS_NAMESPACE, escapeCarriageReturn(escapeNewLines(escapeClosingScript(escapeSingleQuotes(escapeSlash(str))))), JS_ERROR_PREFIX);
    }

    public JsEvaluator(Context context) {
        this.mContext = context;
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void callFunction(String str, JsCallback jsCallback, String str2, Object... objArr) {
        evaluate(str + "; " + JsFunctionCallFormatter.toString(str2, objArr), jsCallback);
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void evaluate(String str) {
        evaluate(str, null);
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void evaluate(String str, JsCallback jsCallback) {
        String jsForEval = getJsForEval(str);
        this.callback.set(jsCallback);
        getWebViewWrapper().loadJavaScript(jsForEval);
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public void destroy() {
        getWebViewWrapper().destroy();
    }

    @Override // com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface
    public WebView getWebView() {
        return getWebViewWrapper().getWebView();
    }

    public WebViewWrapperInterface getWebViewWrapper() {
        if (this.mWebViewWrapper == null) {
            this.mWebViewWrapper = new WebViewWrapper(this.mContext, this);
        }
        return this.mWebViewWrapper;
    }

    @Override // com.evgenii.jsevaluator.interfaces.CallJavaResultInterface
    public void jsCallFinished(final String str) {
        final JsCallback andSet = this.callback.getAndSet(null);
        if (andSet == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.evgenii.jsevaluator.JsEvaluator.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 != null && str2.startsWith(JsEvaluator.JS_ERROR_PREFIX)) {
                    andSet.onError(str.substring(27));
                } else {
                    andSet.onResult(str);
                }
            }
        });
    }

    public void setHandler(HandlerWrapperInterface handlerWrapperInterface) {
        this.mHandler = handlerWrapperInterface;
    }

    public void setWebViewWrapper(WebViewWrapperInterface webViewWrapperInterface) {
        this.mWebViewWrapper = webViewWrapperInterface;
    }

    public JsCallback getCallback() {
        return this.callback.get();
    }
}
