package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aka */
/* loaded from: classes2.dex */
final class aka extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ akd f4279a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aka(akd akdVar) {
        this.f4279a = akdVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        C2525p.m5989c(valueOf.length() != 0 ? "Finished loading WebView".concat(valueOf) : new String("Finished loading WebView"));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String valueOf = String.valueOf(str);
        C2525p.m5989c(valueOf.length() != 0 ? "Started loading WebView".concat(valueOf) : new String("Started loading WebView"));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Error: ");
        sb.append(i);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        C2525p.m5989c(sb.toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("gmsg://")) {
            this.f4279a.m5116f(str);
            return true;
        }
        return false;
    }
}
