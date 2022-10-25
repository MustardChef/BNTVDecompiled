package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.adview.c */
/* loaded from: classes.dex */
public class C1237c extends WebChromeClient {

    /* renamed from: a */
    private final C1710r f554a;

    public C1237c(C1662k c1662k) {
        this.f554a = c1662k.m6588z();
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        C1710r c1710r = this.f554a;
        c1710r.m6315d("AdWebView", "console.log[" + i + "] :" + str);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f554a.m6319b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        C1710r c1710r = this.f554a;
        c1710r.m6315d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        C1710r c1710r = this.f554a;
        c1710r.m6315d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        C1710r c1710r = this.f554a;
        c1710r.m6315d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }
}
