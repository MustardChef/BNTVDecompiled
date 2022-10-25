package com.lagradost.cloudstream3.p041ui.browser;

import android.webkit.JavascriptInterface;

/* renamed from: com.lagradost.cloudstream3.ui.browser.JavaScriptInterface */
/* loaded from: classes.dex */
public class JavaScriptInterface {
    ICallback<String> iCallback;

    public JavaScriptInterface(ICallback<String> iCallback) {
        this.iCallback = iCallback;
    }

    @JavascriptInterface
    public void processHTML(String str) {
        this.iCallback.onCallback(str);
    }
}
