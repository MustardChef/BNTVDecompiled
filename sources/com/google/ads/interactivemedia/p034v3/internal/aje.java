package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aje */
/* loaded from: classes2.dex */
public final class aje extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ Context f4221a;

    /* renamed from: b */
    final /* synthetic */ alw f4222b;

    /* renamed from: c */
    final /* synthetic */ List f4223c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aje(Context context, alw alwVar, List list) {
        this.f4221a = context;
        this.f4222b = alwVar;
        this.f4223c = list;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(this.f4221a);
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        webView2.setWebViewClient(new ajd(this));
        message.sendToTarget();
        return true;
    }
}
