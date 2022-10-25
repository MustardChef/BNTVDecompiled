package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akd */
/* loaded from: classes2.dex */
public final class akd {

    /* renamed from: a */
    private final WebView f4280a;

    /* renamed from: b */
    private final Handler f4281b;

    /* renamed from: c */
    private akb f4282c;

    /* renamed from: d */
    private boolean f4283d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akd(Handler handler, WebView webView) {
        this.f4281b = handler;
        this.f4280a = webView;
        webView.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT > 19) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new aka(this));
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, true);
        }
    }

    /* renamed from: a */
    public final WebView m5121a() {
        return this.f4280a;
    }

    /* renamed from: b */
    public final void m5120b() {
        this.f4281b.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ajy
            @Override // java.lang.Runnable
            public final void run() {
                akd.this.m5119c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void m5119c() {
        this.f4283d = true;
        this.f4280a.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void m5118d(ajq ajqVar) {
        String m5156f = ajqVar.m5156f();
        if (this.f4283d) {
            String valueOf = String.valueOf(ajqVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50 + String.valueOf(m5156f).length());
            sb.append("Attempted to send bridge message after cleanup: ");
            sb.append(valueOf);
            sb.append("; ");
            sb.append(m5156f);
            C2525p.m5988d(sb.toString());
            return;
        }
        String valueOf2 = String.valueOf(ajqVar);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31 + String.valueOf(m5156f).length());
        sb2.append("Sending Javascript msg: ");
        sb2.append(valueOf2);
        sb2.append("; URL: ");
        sb2.append(m5156f);
        C2525p.m5989c(sb2.toString());
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                this.f4280a.evaluateJavascript(m5156f, null);
                return;
            } catch (IllegalStateException unused) {
                this.f4280a.loadUrl(m5156f);
                return;
            }
        }
        this.f4280a.loadUrl(m5156f);
    }

    /* renamed from: e */
    public final void m5117e(String str) {
        this.f4280a.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final void m5116f(String str) {
        try {
            ajq m5159c = ajq.m5159c(str);
            String obj = m5159c.toString();
            StringBuilder sb = new StringBuilder(obj.length() + 32 + String.valueOf(str).length());
            sb.append("Received Javascript msg: ");
            sb.append(obj);
            sb.append("; URL: ");
            sb.append(str);
            C2525p.m5989c(sb.toString());
            this.f4282c.mo5123k(m5159c);
        } catch (IllegalArgumentException unused) {
            String valueOf = String.valueOf(str);
            C2525p.m5988d(valueOf.length() != 0 ? "Invalid internal message. Please make sure the Google IMA SDK library is up to date. Message: ".concat(valueOf) : new String("Invalid internal message. Please make sure the Google IMA SDK library is up to date. Message: "));
        } catch (Exception e) {
            String valueOf2 = String.valueOf(str);
            C2525p.m5990b(valueOf2.length() != 0 ? "Invalid internal message. Message could not be be parsed: ".concat(valueOf2) : new String("Invalid internal message. Message could not be be parsed: "), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m5115g(akb akbVar) {
        this.f4282c = akbVar;
    }

    /* renamed from: h */
    public final void m5114h(final ajq ajqVar) {
        this.f4281b.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.ajz
            @Override // java.lang.Runnable
            public final void run() {
                akd.this.m5118d(ajqVar);
            }
        });
    }
}
