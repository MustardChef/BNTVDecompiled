package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.w */
/* loaded from: classes.dex */
public class C1318w extends WebViewClient {

    /* renamed from: a */
    private final C1710r f765a;

    /* renamed from: b */
    private WeakReference<InterfaceC1319a> f766b;

    /* renamed from: com.applovin.impl.adview.w$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1319a {
        /* renamed from: a */
        void mo7876a(C1317v c1317v);

        /* renamed from: b */
        void mo7875b(C1317v c1317v);

        /* renamed from: c */
        void mo7874c(C1317v c1317v);
    }

    public C1318w(C1662k c1662k) {
        this.f765a = c1662k.m6588z();
    }

    /* renamed from: a */
    private void m7878a(WebView webView, String str) {
        C1710r c1710r = this.f765a;
        c1710r.m6317c("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str == null || !(webView instanceof C1317v)) {
            return;
        }
        C1317v c1317v = (C1317v) webView;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        String path = parse.getPath();
        InterfaceC1319a interfaceC1319a = this.f766b.get();
        if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && interfaceC1319a != null) {
            if ("/track_click".equals(path)) {
                interfaceC1319a.mo7876a(c1317v);
            } else if ("/close_ad".equals(path)) {
                interfaceC1319a.mo7875b(c1317v);
            } else if ("/skip_ad".equals(path)) {
                interfaceC1319a.mo7874c(c1317v);
            } else {
                C1710r c1710r2 = this.f765a;
                c1710r2.m6315d("WebViewButtonClient", "Unknown URL: " + str);
                C1710r c1710r3 = this.f765a;
                c1710r3.m6315d("WebViewButtonClient", "Path: " + path);
            }
        }
    }

    /* renamed from: a */
    public void m7877a(WeakReference<InterfaceC1319a> weakReference) {
        this.f766b = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m7878a(webView, str);
        return true;
    }
}
