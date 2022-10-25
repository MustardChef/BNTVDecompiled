package com.applovin.impl.sdk;

import android.content.Intent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.y */
/* loaded from: classes.dex */
public class C1780y {

    /* renamed from: a */
    private static WebView f2631a;

    /* renamed from: b */
    private static volatile String f2632b;

    /* renamed from: c */
    private static volatile Map<String, String> f2633c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.y$a */
    /* loaded from: classes.dex */
    public static class C1785a extends WebViewClient {

        /* renamed from: a */
        private final C1662k f2638a;

        private C1785a(C1662k c1662k) {
            this.f2638a = c1662k;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            this.f2638a.m6631ai().sendBroadcast(new Intent("com.applovin.render_process_gone"), null);
            return true;
        }
    }

    /* renamed from: a */
    public static String m6111a() {
        return f2632b;
    }

    /* renamed from: a */
    public static void m6110a(C1662k c1662k) {
        if (f2631a == null) {
            try {
                WebView webView = new WebView(c1662k.m6677J());
                f2631a = webView;
                webView.setWebViewClient(new C1785a(c1662k));
            } catch (Throwable th) {
                c1662k.m6588z().m6318b("WebViewDataCollector", "Failed to initialize WebView for data collection.", th);
            }
        }
    }

    /* renamed from: b */
    public static Map<String, String> m6107b() {
        return f2633c != null ? f2633c : Collections.emptyMap();
    }

    /* renamed from: b */
    public static void m6106b(final C1662k c1662k) {
        if (f2632b != null) {
            return;
        }
        f2632b = "";
        if (C1724f.m6277b()) {
            c1662k.m6670Q().m6793a(new C1642y(c1662k, true, new Runnable() { // from class: com.applovin.impl.sdk.y.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String unused = C1780y.f2632b = WebSettings.getDefaultUserAgent(C1662k.this.m6677J());
                    } catch (Throwable th) {
                        C1662k.this.m6588z().m6318b("WebViewDataCollector", "Failed to collect user agent", th);
                    }
                }
            }), C1620o.EnumC1622a.BACKGROUND);
        } else {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.y.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1780y.m6110a(C1662k.this);
                        String unused = C1780y.f2632b = C1780y.f2631a.getSettings().getUserAgentString();
                    } catch (Throwable th) {
                        C1662k.this.m6588z().m6318b("WebViewDataCollector", "Failed to collect user agent", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m6104c(final C1662k c1662k) {
        if (f2633c != null) {
            return;
        }
        f2633c = Collections.emptyMap();
        if (C1724f.m6275d()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.y.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1780y.m6110a(C1662k.this);
                        C1780y.f2631a.setWebViewClient(new C1785a(C1662k.this) { // from class: com.applovin.impl.sdk.y.3.1
                            @Override // android.webkit.WebViewClient
                            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                                HashMap hashMap = new HashMap();
                                for (Map.Entry<String, String> entry : webResourceRequest.getRequestHeaders().entrySet()) {
                                    hashMap.put("AppLovin-WebView-" + entry.getKey(), entry.getValue());
                                }
                                Map unused = C1780y.f2633c = hashMap;
                                return super.shouldInterceptRequest(webView, webResourceRequest);
                            }
                        });
                        C1780y.f2631a.loadUrl("https://blank");
                    } catch (Throwable th) {
                        C1662k.this.m6588z().m6318b("WebViewDataCollector", "Failed to collect WebView HTTP headers", th);
                    }
                }
            });
        }
    }
}
