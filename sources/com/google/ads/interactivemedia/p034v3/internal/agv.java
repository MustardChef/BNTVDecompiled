package com.google.ads.interactivemedia.p034v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agv */
/* loaded from: classes2.dex */
final class agv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebView f4027a;

    /* renamed from: b */
    final /* synthetic */ String f4028b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agv(WebView webView, String str) {
        this.f4027a = webView;
        this.f4028b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4027a.loadUrl(this.f4028b);
    }
}
