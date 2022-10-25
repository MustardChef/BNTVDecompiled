package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agw */
/* loaded from: classes2.dex */
public final class agw {

    /* renamed from: a */
    private static final agw f4029a = new agw();

    private agw() {
    }

    /* renamed from: a */
    public static agw m5309a() {
        return f4029a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m5308b(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (objArr.length > 0) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        sb.append("\"\"");
                    } else if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                            sb.append('\"');
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append(")}");
            String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
                return;
            } else {
                handler.post(new agv(webView, sb2));
                return;
            }
        }
        if (str.length() != 0) {
            "The WebView is null for ".concat(str);
        } else {
            new String("The WebView is null for ");
        }
        agc.f3950a.booleanValue();
    }

    /* renamed from: c */
    public final void m5307c(WebView webView) {
        m5308b(webView, "finishSession", new Object[0]);
    }

    /* renamed from: d */
    public final void m5306d(WebView webView, JSONObject jSONObject) {
        m5308b(webView, "init", jSONObject);
    }

    /* renamed from: e */
    public final void m5305e(WebView webView, float f) {
        m5308b(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: f */
    public final void m5304f(WebView webView, String str) {
        m5308b(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: g */
    public final void m5303g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        m5308b(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* renamed from: h */
    public final void m5302h(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(null)) {
            return;
        }
        webView.loadUrl("null".length() != 0 ? "javascript: ".concat("null") : new String("javascript: "));
    }
}
