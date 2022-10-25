package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alw */
/* loaded from: classes2.dex */
public final class alw {

    /* renamed from: a */
    private final Context f4415a;

    /* renamed from: b */
    private AdsRenderingSettings f4416b;

    public alw(Context context, AdsRenderingSettings adsRenderingSettings) {
        this.f4415a = context;
        this.f4416b = adsRenderingSettings;
    }

    /* renamed from: a */
    public final void m5011a(String str) {
        if (!this.f4416b.getEnableCustomTabs() || Build.VERSION.SDK_INT < 18) {
            Context context = this.f4415a;
            if (str == null || str.length() <= 0) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        new CustomTabsIntent.Builder().build().launchUrl(this.f4415a, Uri.parse(str));
    }

    /* renamed from: b */
    public final void m5010b(AdsRenderingSettings adsRenderingSettings) {
        this.f4416b = adsRenderingSettings;
    }
}
