package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p030d.C1577b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.adview.f */
/* loaded from: classes.dex */
public class C1246f {

    /* renamed from: a */
    private final C1662k f573a;

    /* renamed from: b */
    private final WebViewRenderProcessClient f574b = new WebViewRenderProcessClient() { // from class: com.applovin.impl.adview.f.1
        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof C1238d) {
                AbstractC1537g currentAd = ((C1238d) webView).getCurrentAd();
                C1246f.this.f573a.m6639aa().m6954a(currentAd).m6930a(C1577b.f1975D).m6931a();
                C1710r m6588z = C1246f.this.f573a.m6588z();
                m6588z.m6314e("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1246f(C1662k c1662k) {
        this.f573a = c1662k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public WebViewRenderProcessClient m8070a() {
        return this.f574b;
    }
}
