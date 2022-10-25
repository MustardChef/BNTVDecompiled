package com.google.ads.interactivemedia.p034v3.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajd */
/* loaded from: classes2.dex */
final class ajd extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ aje f4220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajd(aje ajeVar) {
        this.f4220a = ajeVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f4220a.f4222b.m5011a(str);
        for (CompanionAdSlot.ClickListener clickListener : this.f4220a.f4223c) {
            clickListener.onCompanionAdClick();
        }
        return true;
    }
}
