package com.facebook.core.internal.logging.dumpsys;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WebViewDumpHelper {
    public static final String GET_WEBVIEW_HTML_JS_SCRIPT = "(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();";
    private final Set<WebViewData> mWebViews = new HashSet();
    private final Map<String, String> mWebViewHTMLs = new HashMap();

    public void handle(WebView webView) {
        final WebViewData webViewData = new WebViewData(webView);
        this.mWebViews.add(webViewData);
        webView.evaluateJavascript(String.format(GET_WEBVIEW_HTML_JS_SCRIPT, Integer.valueOf(webViewData.left), Integer.valueOf(webViewData.top), Float.valueOf(webView.getResources().getDisplayMetrics().scaledDensity)), new ValueCallback<String>() { // from class: com.facebook.core.internal.logging.dumpsys.WebViewDumpHelper.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                WebViewDumpHelper.this.mWebViewHTMLs.put(webViewData.key, str);
            }
        });
    }

    public void dump(PrintWriter printWriter) {
        try {
            for (WebViewData webViewData : this.mWebViews) {
                String str = this.mWebViewHTMLs.get(webViewData.key);
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(webViewData);
                    printWriter.println(":");
                    printWriter.println(fixHtmlString(webViewData, str));
                }
            }
        } catch (Exception unused) {
        }
        this.mWebViews.clear();
        this.mWebViewHTMLs.clear();
    }

    private static String fixHtmlString(WebViewData webViewData, String str) {
        String replace = str.replace("\\u003C", "<").replace("\\n", "").replace("\\\"", "\"");
        return String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", webViewData.key, Integer.valueOf(webViewData.left), Integer.valueOf(webViewData.top), Integer.valueOf(webViewData.width), Integer.valueOf(webViewData.height), replace.substring(1, replace.length() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class WebViewData {
        private static final int[] mLocation = new int[2];
        public final int height;
        public final String key;
        public final int left;
        public final int top;
        public final int width;

        public WebViewData(WebView webView) {
            this.key = String.format("%s{%s}", webView.getClass().getName(), Integer.toHexString(webView.hashCode()));
            int[] iArr = mLocation;
            webView.getLocationOnScreen(iArr);
            this.left = iArr[0];
            this.top = iArr[1];
            this.width = webView.getWidth();
            this.height = webView.getHeight();
        }
    }
}
