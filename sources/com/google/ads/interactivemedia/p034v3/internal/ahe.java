package com.google.ads.interactivemedia.p034v3.internal;

import android.webkit.WebView;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahe */
/* loaded from: classes2.dex */
public final class ahe extends ahd {
    public ahe(WebView webView) {
        if (!webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        m5284i(webView);
    }
}
