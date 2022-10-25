package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.C1223b;
import com.applovin.impl.sdk.C1710r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.interactivemedia.p034v3.internal.bqk;

/* loaded from: classes.dex */
public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    private C1223b f163a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8437a(null, null, null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m8437a(appLovinAdSize, str, null, context, null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        m8437a(appLovinAdSize, str, appLovinSdk, context, null);
    }

    /* renamed from: a */
    private void m8438a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb((int) bqk.f6558bR, (int) bqk.f6558bR, (int) bqk.f6558bR));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    /* renamed from: a */
    private void m8437a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            m8438a(attributeSet, context);
            return;
        }
        C1223b c1223b = new C1223b();
        c1223b.m8151a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
        this.f163a = c1223b;
    }

    public void destroy() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8124f();
        }
    }

    @Deprecated
    public C1223b getAdViewController() {
        return this.f163a;
    }

    public AppLovinAdSize getSize() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            return c1223b.m8135b();
        }
        return null;
    }

    public String getZoneId() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            return c1223b.m8130c();
        }
        return null;
    }

    public void loadNextAd() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8156a();
        } else {
            C1710r.m6312g("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8118i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8116j();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8128d();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8142a(appLovinAd);
        }
    }

    public void resume() {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8126e();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8140a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8139a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8138a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        C1223b c1223b = this.f163a;
        if (c1223b != null) {
            c1223b.m8149a(appLovinAdViewEventListener);
        }
    }

    @Override // android.view.View
    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "\", size=" + getSize() + '}';
    }
}
