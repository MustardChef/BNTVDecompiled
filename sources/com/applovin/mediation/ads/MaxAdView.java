package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.utils.C1719b;
import com.applovin.impl.sdk.utils.C1763o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.interactivemedia.p034v3.internal.bqk;

/* loaded from: classes.dex */
public class MaxAdView extends RelativeLayout {

    /* renamed from: a */
    private MaxAdViewImpl f2641a;

    /* renamed from: b */
    private View f2642b;

    /* renamed from: c */
    private int f2643c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adUnitId");
        String attributeValue2 = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adFormat");
        MaxAdFormat formatFromString = StringUtils.isValidString(attributeValue2) ? MaxAdFormat.formatFromString(attributeValue2) : C1719b.m6294a(context);
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (attributeValue == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(attributeValue)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Max ad view context is not an activity");
        }
        Activity activity = (Activity) context;
        m6097a(attributeValue, formatFromString, attributeIntValue, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Activity activity) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Activity activity) {
        super(activity);
        AbstractC1363a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        m6097a(str, maxAdFormat, 49, appLovinSdk, activity);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Activity activity) {
        this(str, C1719b.m6294a(activity), appLovinSdk, activity);
    }

    /* renamed from: a */
    private void m6098a(MaxAdFormat maxAdFormat, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int applyDimension = maxAdFormat == MaxAdFormat.MREC ? (int) TypedValue.applyDimension(1, maxAdFormat.getSize().getWidth(), displayMetrics) : displayMetrics.widthPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb((int) bqk.f6558bR, (int) bqk.f6558bR, (int) bqk.f6558bR));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, applyDimension, (int) TypedValue.applyDimension(1, maxAdFormat.getSize().getHeight(), displayMetrics));
    }

    /* renamed from: a */
    private void m6097a(String str, MaxAdFormat maxAdFormat, int i, AppLovinSdk appLovinSdk, Activity activity) {
        if (isInEditMode()) {
            m6098a(maxAdFormat, activity);
            return;
        }
        View view = new View(activity);
        this.f2642b = view;
        view.setBackgroundColor(0);
        addView(this.f2642b);
        this.f2642b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f2643c = getVisibility();
        this.f2641a = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.f2642b, appLovinSdk.coreSdk, activity);
        setGravity(i);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f2641a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f2641a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f2641a.getAdUnitId();
    }

    public String getPlacement() {
        return this.f2641a.getPlacement();
    }

    public void loadAd() {
        this.f2641a.loadAd();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.f2641a != null && C1763o.m6159a(this.f2643c, i)) {
            this.f2641a.onWindowVisibilityChanged(i);
        }
        this.f2643c = i;
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.f2642b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl2 = this.f2641a;
        if (maxAdViewImpl2 != null) {
            maxAdViewImpl2.setPublisherBackgroundColor(i);
        }
        View view = this.f2642b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setExtraParameter(String str, String str2) {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2641a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f2641a.setListener(maxAdViewAdListener);
    }

    public void setPlacement(String str) {
        this.f2641a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        maxAdViewImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2641a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f2641a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f2641a.stopAutoRefresh();
    }

    @Override // android.view.View
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f2641a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}
