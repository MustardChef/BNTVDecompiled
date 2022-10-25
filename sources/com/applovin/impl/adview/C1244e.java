package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1134b;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1577b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinWebViewActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.adview.e */
/* loaded from: classes.dex */
public class C1244e extends WebViewClient {

    /* renamed from: a */
    private final C1662k f568a;

    /* renamed from: b */
    private final C1710r f569b;

    /* renamed from: c */
    private final C1223b f570c;

    public C1244e(C1223b c1223b, C1662k c1662k) {
        this.f568a = c1662k;
        this.f569b = c1662k.m6588z();
        this.f570c = c1223b;
    }

    /* renamed from: a */
    private void m8079a() {
        this.f570c.m8112l();
    }

    /* renamed from: a */
    private void m8078a(PointF pointF) {
        this.f570c.m8154a(pointF);
    }

    /* renamed from: a */
    private void m8077a(Uri uri, C1238d c1238d) {
        C1710r c1710r;
        String str;
        final String queryParameter = uri.getQueryParameter("n");
        if (StringUtils.isValidString(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("load_type");
            if ("external".equalsIgnoreCase(queryParameter2)) {
                C1710r c1710r2 = this.f569b;
                c1710r2.m6319b("AdWebView", "Loading new page externally: " + queryParameter);
                Utils.openUri(c1238d.getContext(), Uri.parse(queryParameter), this.f568a);
                C1728i.m6214c(this.f570c.m8122g(), this.f570c.m8104p(), this.f570c.m8100r());
                return;
            } else if ("internal".equalsIgnoreCase(queryParameter2)) {
                C1710r c1710r3 = this.f569b;
                c1710r3.m6319b("AdWebView", "Loading new page in WebView: " + queryParameter);
                c1238d.loadUrl(queryParameter);
                String queryParameter3 = uri.getQueryParameter("bg_color");
                if (StringUtils.isValidString(queryParameter3)) {
                    c1238d.setBackgroundColor(Color.parseColor(queryParameter3));
                    return;
                }
                return;
            } else if ("in_app".equalsIgnoreCase(queryParameter2)) {
                C1710r c1710r4 = this.f569b;
                c1710r4.m6319b("AdWebView", "Loading new page in slide-up webview: " + queryParameter);
                this.f568a.m6636ad().m7239a(new AbstractC1718a() { // from class: com.applovin.impl.adview.e.1
                    @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            ((AppLovinWebViewActivity) activity).loadUrl(queryParameter, null);
                            C1728i.m6242a(C1244e.this.f570c.m8122g(), C1244e.this.f570c.m8104p(), C1244e.this.f570c.m8100r());
                        }
                    }

                    @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            C1728i.m6220b(C1244e.this.f570c.m8122g(), C1244e.this.f570c.m8104p(), C1244e.this.f570c.m8100r());
                            C1244e.this.f568a.m6636ad().m7237b(this);
                        }
                    }
                });
                Intent intent = new Intent(this.f568a.m6677J(), AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f568a.m6590x());
                intent.setFlags(268435456);
                this.f568a.m6677J().startActivity(intent);
                return;
            } else {
                c1710r = this.f569b;
                str = "Could not find load type in original uri";
            }
        } else {
            c1710r = this.f569b;
            str = "Could not find url to load from query in original uri";
        }
        c1710r.m6314e("AdWebView", str);
    }

    /* renamed from: a */
    private void m8075a(C1129a c1129a, C1238d c1238d) {
        C1134b m8412n = c1129a.m8412n();
        if (m8412n != null) {
            C1142i.m8344a(m8412n.m8382c(), this.f570c.m8102q());
            m8074a(c1238d, m8412n.m8385a());
        }
    }

    /* renamed from: a */
    private void m8074a(C1238d c1238d, Uri uri) {
        AbstractC1537g currentAd = c1238d.getCurrentAd();
        AppLovinAdView m8100r = this.f570c.m8100r();
        if (m8100r != null && currentAd != null) {
            C1584d statsManagerHelper = c1238d.getStatsManagerHelper();
            if (statsManagerHelper != null) {
                statsManagerHelper.m6921b();
            }
            this.f570c.m8144a(currentAd, m8100r, uri, c1238d.getAndClearLastClickLocation());
            return;
        }
        C1710r c1710r = this.f569b;
        c1710r.m6314e("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0191, code lost:
        if (r6.m8411o() != false) goto L34;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m8076a(android.webkit.WebView r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.C1244e.m8076a(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* renamed from: b */
    private void m8072b() {
        this.f570c.m8114k();
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        C1710r c1710r = this.f569b;
        c1710r.m6317c("AdWebView", "Loaded resource: " + str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f570c.m8152a(webView);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        AbstractC1537g m8104p = this.f570c.m8104p();
        String str3 = "Received error with error code: " + i + " with description \\'" + str + "\\' for URL: " + str2;
        if (m8104p != null) {
            this.f568a.m6639aa().m6954a(m8104p).m6928a(C1577b.f2002z, str3).m6931a();
        }
        this.f569b.m6314e("AdWebView", str3 + " for ad: " + m8104p);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        AbstractC1537g m8104p = this.f570c.m8104p();
        this.f568a.m6639aa().m6954a(m8104p).m6930a(C1577b.f1972A).m6931a();
        C1710r c1710r = this.f569b;
        c1710r.m6314e("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + m8104p);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        AbstractC1537g m8104p = this.f570c.m8104p();
        String str = "Received SSL error: " + sslError;
        this.f568a.m6639aa().m6954a(m8104p).m6928a(C1577b.f1974C, str).m6931a();
        this.f569b.m6314e("AdWebView", str + " for ad: " + m8104p);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        C1710r.m6310i("AdWebView", "Render process gone for ad: " + this.f570c.m8104p() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        AbstractC1537g m8104p = this.f570c.m8104p();
        if (m8104p != null) {
            this.f568a.m6639aa().m6954a(m8104p).m6930a(C1577b.f1973B).m6931a();
        }
        if (((Boolean) this.f568a.m6656a(C1568b.f1868eE)).booleanValue()) {
            if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f568a.m6656a(C1568b.f1871eH)).booleanValue()) {
                String valueOf = m8104p != null ? String.valueOf(m8104p.getAdIdNumber()) : "null";
                throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + valueOf);
            } else if (webView == null || !webView.equals(this.f570c.m8098s())) {
                return true;
            } else {
                this.f570c.m8124f();
                AppLovinAdSize m8135b = this.f570c.m8135b();
                if (Utils.isBML(m8135b)) {
                    this.f570c.m8137a(m8135b);
                    this.f570c.m8126e();
                    return true;
                }
                return true;
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean hasGesture = ((Boolean) this.f568a.m6656a(C1568b.f1759bz)).booleanValue() ? webResourceRequest.hasGesture() : true;
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return m8076a(webView, url.toString(), hasGesture);
        }
        this.f569b.m6314e("AdWebView", "No url found for request");
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m8076a(webView, str, true);
    }
}
