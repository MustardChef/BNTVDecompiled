package com.google.ads.interactivemedia.p034v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahf */
/* loaded from: classes2.dex */
final class ahf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ahg f4063a;

    /* renamed from: b */
    private final WebView f4064b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahf(ahg ahgVar) {
        WebView webView;
        this.f4063a = ahgVar;
        webView = ahgVar.f4065a;
        this.f4064b = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4064b.destroy();
    }
}
