package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

/* renamed from: com.applovin.impl.adview.v */
/* loaded from: classes.dex */
public class C1317v extends C1251i {
    public C1317v(C1318w c1318w, Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(c1318w);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    /* renamed from: a */
    public void m7879a(String str) {
        loadDataWithBaseURL("/", str, "text/html", null, "");
    }
}
