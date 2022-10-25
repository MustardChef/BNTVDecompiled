package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1134b;
import com.applovin.impl.p010a.C1137e;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1700h;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.d */
/* loaded from: classes.dex */
public class C1238d extends C1251i {

    /* renamed from: c */
    private static WebView f555c;

    /* renamed from: a */
    private final C1710r f556a;

    /* renamed from: b */
    private final C1662k f557b;

    /* renamed from: d */
    private C1584d f558d;

    /* renamed from: e */
    private AbstractC1537g f559e;

    /* renamed from: f */
    private boolean f560f;

    /* renamed from: g */
    private boolean f561g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1238d(C1244e c1244e, C1662k c1662k, Context context) {
        this(c1244e, c1662k, context, false);
    }

    C1238d(C1244e c1244e, C1662k c1662k, Context context, boolean z) {
        super(context);
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f557b = c1662k;
        this.f556a = c1662k.m6588z();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(c1244e);
        setWebChromeClient(new C1237c(c1662k));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (C1724f.m6271h() && ((Boolean) c1662k.m6656a(C1568b.f1874eK)).booleanValue()) {
            setWebViewRenderProcessClient(new C1246f(c1662k).m8070a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.d.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C1238d.this.f556a.m6319b("AdWebView", "Received a LongClick event.");
                return true;
            }
        });
    }

    /* renamed from: a */
    private String m8084a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return Utils.replaceCommonMacros(this.f561g, str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    public static void m8087a(final C1700h c1700h, final C1662k c1662k, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.d.3
            @Override // java.lang.Runnable
            public void run() {
                String a = C1700h.this.m6489a();
                C1238d.m8080c();
                if (C1238d.f555c == null) {
                    appLovinPostbackListener.onPostbackFailure(a, -1);
                    return;
                }
                if (C1700h.this.m6483c() != null) {
                    a = StringUtils.appendQueryParameters(a, C1700h.this.m6483c(), ((Boolean) c1662k.m6656a(C1568b.f1846di)).booleanValue());
                }
                String str = "al_firePostback('" + a + "');";
                if (C1724f.m6276c()) {
                    C1238d.f555c.evaluateJavascript(str, null);
                } else {
                    C1238d.f555c.loadUrl("javascript:" + str);
                }
                appLovinPostbackListener.onPostbackSuccess(a);
            }
        });
    }

    /* renamed from: a */
    private void m8083a(String str, String str2, String str3, C1662k c1662k) {
        String m8084a = m8084a(str3, str);
        if (StringUtils.isValidString(m8084a)) {
            C1710r c1710r = this.f556a;
            c1710r.m6319b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + m8084a);
            loadDataWithBaseURL(str2, m8084a, "text/html", null, "");
            return;
        }
        String m8084a2 = m8084a((String) c1662k.m6656a(C1568b.f1893ed), str);
        if (StringUtils.isValidString(m8084a2)) {
            C1710r c1710r2 = this.f556a;
            c1710r2.m6319b("AdWebView", "Rendering webview for VAST ad with resourceContents : " + m8084a2);
            loadDataWithBaseURL(str2, m8084a2, "text/html", null, "");
            return;
        }
        C1710r c1710r3 = this.f556a;
        c1710r3.m6319b("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        loadUrl(str);
    }

    /* renamed from: b */
    private void m8081b(AbstractC1537g abstractC1537g) {
        Boolean m7860n;
        Integer m7873a;
        loadUrl("about:blank");
        int m7100az = this.f559e.m7100az();
        if (m7100az >= 0) {
            setLayerType(m7100az, null);
        }
        if (C1724f.m6277b()) {
            getSettings().setMediaPlaybackRequiresUserGesture(abstractC1537g.m7104av());
        }
        if (C1724f.m6276c() && abstractC1537g.m7102ax()) {
            setWebContentsDebuggingEnabled(true);
        }
        C1320x m7101ay = abstractC1537g.m7101ay();
        if (m7101ay != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState m7872b = m7101ay.m7872b();
            if (m7872b != null) {
                settings.setPluginState(m7872b);
            }
            Boolean m7871c = m7101ay.m7871c();
            if (m7871c != null) {
                settings.setAllowFileAccess(m7871c.booleanValue());
            }
            Boolean m7870d = m7101ay.m7870d();
            if (m7870d != null) {
                settings.setLoadWithOverviewMode(m7870d.booleanValue());
            }
            Boolean m7869e = m7101ay.m7869e();
            if (m7869e != null) {
                settings.setUseWideViewPort(m7869e.booleanValue());
            }
            Boolean m7868f = m7101ay.m7868f();
            if (m7868f != null) {
                settings.setAllowContentAccess(m7868f.booleanValue());
            }
            Boolean m7867g = m7101ay.m7867g();
            if (m7867g != null) {
                settings.setBuiltInZoomControls(m7867g.booleanValue());
            }
            Boolean m7866h = m7101ay.m7866h();
            if (m7866h != null) {
                settings.setDisplayZoomControls(m7866h.booleanValue());
            }
            Boolean m7865i = m7101ay.m7865i();
            if (m7865i != null) {
                settings.setSaveFormData(m7865i.booleanValue());
            }
            Boolean m7864j = m7101ay.m7864j();
            if (m7864j != null) {
                settings.setGeolocationEnabled(m7864j.booleanValue());
            }
            Boolean m7863k = m7101ay.m7863k();
            if (m7863k != null) {
                settings.setNeedInitialFocus(m7863k.booleanValue());
            }
            Boolean m7862l = m7101ay.m7862l();
            if (m7862l != null) {
                settings.setAllowFileAccessFromFileURLs(m7862l.booleanValue());
            }
            Boolean m7861m = m7101ay.m7861m();
            if (m7861m != null) {
                settings.setAllowUniversalAccessFromFileURLs(m7861m.booleanValue());
            }
            if (C1724f.m6275d() && (m7873a = m7101ay.m7873a()) != null) {
                settings.setMixedContentMode(m7873a.intValue());
            }
            if (!C1724f.m6274e() || (m7860n = m7101ay.m7860n()) == null) {
                return;
            }
            settings.setOffscreenPreRaster(m7860n.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m8080c() {
        if (f555c != null) {
            return;
        }
        try {
            WebView webView = new WebView(C1662k.m6676K());
            f555c = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            f555c.loadData("<html><head>\n<script type=\"text/javascript\">\n    window.al_firePostback = function(postback) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = postback;\n    }, 100);\n};\n</script></head>\n<body></body></html>", "text/html", "UTF-8");
            f555c.setWebViewClient(new WebViewClient() { // from class: com.applovin.impl.adview.d.4
                @Override // android.webkit.WebViewClient
                public boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                    if (webView2 == C1238d.f555c) {
                        C1238d.f555c.destroy();
                        WebView unused = C1238d.f555c = null;
                        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.d.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C1238d.m8080c();
                            }
                        });
                        return true;
                    }
                    return true;
                }
            });
        } catch (Throwable th) {
            C1710r.m6316c("AdWebView", "Failed to initialize WebView for postbacks.", th);
        }
    }

    /* renamed from: a */
    public void m8088a(AbstractC1537g abstractC1537g) {
        C1710r c1710r;
        String str;
        C1710r c1710r2;
        String str2;
        String str3;
        String m7103aw;
        String str4;
        String str5;
        String str6;
        String m7103aw2;
        C1662k c1662k;
        if (this.f560f) {
            C1710r.m6310i("AdWebView", "Ad can not be loaded in a destroyed webview");
            return;
        }
        this.f559e = abstractC1537g;
        try {
            m8081b(abstractC1537g);
            if (Utils.isBML(abstractC1537g.getSize())) {
                setVisibility(0);
            }
            if (abstractC1537g instanceof C1527a) {
                loadDataWithBaseURL(abstractC1537g.m7103aw(), Utils.replaceCommonMacros(this.f561g, ((C1527a) abstractC1537g).m7233c()), "text/html", null, "");
                c1710r = this.f556a;
                str = "AppLovinAd rendered";
            } else if (!(abstractC1537g instanceof C1129a)) {
                return;
            } else {
                C1129a c1129a = (C1129a) abstractC1537g;
                C1134b m8412n = c1129a.m8412n();
                if (m8412n != null) {
                    C1137e m8383b = m8412n.m8383b();
                    Uri m8366b = m8383b.m8366b();
                    String uri = m8366b != null ? m8366b.toString() : "";
                    String m8365c = m8383b.m8365c();
                    String m8427aO = c1129a.m8427aO();
                    if (!StringUtils.isValidString(uri) && !StringUtils.isValidString(m8365c)) {
                        c1710r2 = this.f556a;
                        str2 = "Unable to load companion ad. No resources provided.";
                        c1710r2.m6314e("AdWebView", str2);
                        return;
                    }
                    if (m8383b.m8371a() == C1137e.EnumC1138a.STATIC) {
                        this.f556a.m6319b("AdWebView", "Rendering WebView for static VAST ad");
                        loadDataWithBaseURL(abstractC1537g.m7103aw(), m8084a((String) this.f557b.m6656a(C1568b.f1892ec), uri), "text/html", null, "");
                        return;
                    } else if (m8383b.m8371a() == C1137e.EnumC1138a.HTML) {
                        if (!StringUtils.isValidString(m8365c)) {
                            if (StringUtils.isValidString(uri)) {
                                this.f556a.m6319b("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                m7103aw2 = abstractC1537g.m7103aw();
                                c1662k = this.f557b;
                                m8083a(uri, m7103aw2, m8427aO, c1662k);
                                return;
                            }
                            return;
                        }
                        String m8084a = m8084a(m8427aO, m8365c);
                        str3 = StringUtils.isValidString(m8084a) ? m8084a : m8365c;
                        C1710r c1710r3 = this.f556a;
                        c1710r3.m6319b("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str3);
                        m7103aw = abstractC1537g.m7103aw();
                        str4 = "text/html";
                        str5 = null;
                        str6 = "";
                        loadDataWithBaseURL(m7103aw, str3, str4, str5, str6);
                        return;
                    } else if (m8383b.m8371a() != C1137e.EnumC1138a.IFRAME) {
                        c1710r2 = this.f556a;
                        str2 = "Failed to render VAST companion ad of invalid type";
                        c1710r2.m6314e("AdWebView", str2);
                        return;
                    } else if (StringUtils.isValidString(uri)) {
                        this.f556a.m6319b("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                        m7103aw2 = abstractC1537g.m7103aw();
                        c1662k = this.f557b;
                        m8083a(uri, m7103aw2, m8427aO, c1662k);
                        return;
                    } else if (StringUtils.isValidString(m8365c)) {
                        String m8084a2 = m8084a(m8427aO, m8365c);
                        str3 = StringUtils.isValidString(m8084a2) ? m8084a2 : m8365c;
                        C1710r c1710r4 = this.f556a;
                        c1710r4.m6319b("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                        m7103aw = abstractC1537g.m7103aw();
                        str4 = "text/html";
                        str5 = null;
                        str6 = "";
                        loadDataWithBaseURL(m7103aw, str3, str4, str5, str6);
                        return;
                    } else {
                        return;
                    }
                }
                c1710r = this.f556a;
                str = "No companion ad provided.";
            }
            c1710r.m6319b("AdWebView", str);
        } catch (Throwable th) {
            String valueOf = abstractC1537g != null ? String.valueOf(abstractC1537g.getAdIdNumber()) : "null";
            throw new RuntimeException("Unable to render AppLovin ad (" + valueOf + ") - " + th);
        }
    }

    /* renamed from: a */
    public void m8086a(String str) {
        m8085a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void m8085a(String str, Runnable runnable) {
        try {
            C1710r c1710r = this.f556a;
            c1710r.m6319b("AdWebView", "Forwarding \"" + str + "\" to ad template");
            loadUrl(str);
        } catch (Throwable th) {
            this.f556a.m6318b("AdWebView", "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f560f = true;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1537g getCurrentAd() {
        return this.f559e;
    }

    public C1584d getStatsManagerHelper() {
        return this.f558d;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
    }

    public void setIsShownOutOfContext(boolean z) {
        this.f561g = z;
    }

    public void setStatsManagerHelper(C1584d c1584d) {
        this.f558d = c1584d;
    }
}
