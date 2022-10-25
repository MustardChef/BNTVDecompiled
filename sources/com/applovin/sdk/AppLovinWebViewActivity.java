package com.applovin.sdk;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Set;

/* loaded from: classes.dex */
public class AppLovinWebViewActivity extends Activity {
    public static final String EVENT_DISMISSED_VIA_BACK_BUTTON = "dismissed_via_back_button";
    public static final String INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON = "immersive_mode_on";
    public static final String INTENT_EXTRA_KEY_SDK_KEY = "sdk_key";

    /* renamed from: a */
    private String f2695a;

    /* renamed from: b */
    private WebView f2696b;

    /* renamed from: c */
    private EventListener f2697c;

    /* loaded from: classes.dex */
    public interface EventListener {
        void onReceivedEvent(String str);
    }

    public void loadUrl(String str, EventListener eventListener) {
        this.f2697c = eventListener;
        WebView webView = this.f2696b;
        if (webView == null) {
            this.f2695a = str;
        } else {
            webView.loadUrl(str);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        EventListener eventListener = this.f2697c;
        if (eventListener != null) {
            eventListener.onReceivedEvent(EVENT_DISMISSED_VIA_BACK_BUTTON);
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(INTENT_EXTRA_KEY_SDK_KEY);
        if (TextUtils.isEmpty(stringExtra)) {
            C1710r.m6310i("AppLovinWebViewActivity", "No SDK key specified");
        } else {
            final C1662k c1662k = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(getApplicationContext()), getApplicationContext()).coreSdk;
            try {
                WebView webView = new WebView(this);
                this.f2696b = webView;
                setContentView(webView);
                WebSettings settings = this.f2696b.getSettings();
                settings.setSupportMultipleWindows(false);
                settings.setJavaScriptEnabled(true);
                this.f2696b.setVerticalScrollBarEnabled(true);
                this.f2696b.setHorizontalScrollBarEnabled(true);
                this.f2696b.setScrollBarStyle(33554432);
                this.f2696b.setWebViewClient(new WebViewClient() { // from class: com.applovin.sdk.AppLovinWebViewActivity.1
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                        Uri parse = Uri.parse(str);
                        String scheme = parse.getScheme();
                        String host = parse.getHost();
                        String path = parse.getPath();
                        C1710r m6588z = c1662k.m6588z();
                        m6588z.m6319b("AppLovinWebViewActivity", "Handling url load: " + str);
                        if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && AppLovinWebViewActivity.this.f2697c != null) {
                            if (path.endsWith("webview_event")) {
                                Set<String> queryParameterNames = parse.getQueryParameterNames();
                                String str2 = queryParameterNames.isEmpty() ? "" : (String) queryParameterNames.toArray()[0];
                                if (!StringUtils.isValidString(str2)) {
                                    c1662k.m6588z().m6314e("AppLovinWebViewActivity", "Failed to parse WebView event parameter");
                                    return true;
                                }
                                String queryParameter = parse.getQueryParameter(str2);
                                C1710r m6588z2 = c1662k.m6588z();
                                m6588z2.m6319b("AppLovinWebViewActivity", "Parsed WebView event parameter name: " + str2 + " and value: " + queryParameter);
                                AppLovinWebViewActivity.this.f2697c.onReceivedEvent(queryParameter);
                                return true;
                            }
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView2, str);
                    }
                });
                if (getIntent().getBooleanExtra(INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, false)) {
                    getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                if (StringUtils.isValidString(this.f2695a)) {
                    this.f2696b.loadUrl(this.f2695a);
                    return;
                }
                return;
            } catch (Throwable th) {
                c1662k.m6588z().m6318b("AppLovinWebViewActivity", "Failed to initialize WebView.", th);
            }
        }
        finish();
    }
}
