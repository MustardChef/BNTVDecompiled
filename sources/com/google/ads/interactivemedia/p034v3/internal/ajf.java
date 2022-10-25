package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.webkit.WebView;
import com.google.ads.interactivemedia.p034v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2480ay;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajf */
/* loaded from: classes2.dex */
public final class ajf extends WebView {
    public ajf(Context context, CompanionData companionData, List list, alw alwVar) {
        super(context);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setJavaScriptEnabled(true);
        }
        getSettings().setSupportMultipleWindows(true);
        setWebChromeClient(new aje(context, alwVar, list));
        if (companionData.type() == EnumC2480ay.Html) {
            loadData(Base64.encodeToString(companionData.src().getBytes(), 1), "text/html", "base64");
        } else if (companionData.type() == EnumC2480ay.IFrame) {
            loadUrl(companionData.src());
        } else {
            String valueOf = String.valueOf(companionData.type());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
            sb.append("Companion type ");
            sb.append(valueOf);
            sb.append(" is not valid for a CompanionWebView");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
