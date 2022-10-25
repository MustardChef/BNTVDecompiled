package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.utils.b */
/* loaded from: classes.dex */
public class C1719b {
    /* renamed from: a */
    public static MaxAdFormat m6294a(Context context) {
        return AppLovinSdkUtils.isTablet(context) ? MaxAdFormat.LEADER : MaxAdFormat.BANNER;
    }

    /* renamed from: a */
    public static AppLovinAdSize m6293a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "size");
        if (StringUtils.isValidString(attributeValue)) {
            return AppLovinAdSize.fromString(attributeValue);
        }
        return null;
    }

    /* renamed from: a */
    public static void m6291a(ViewGroup viewGroup, View view) {
        if (viewGroup == null) {
            return;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        if (indexOfChild == -1) {
            viewGroup.removeAllViews();
            return;
        }
        viewGroup.removeViews(0, indexOfChild);
        viewGroup.removeViews(1, viewGroup.getChildCount() - 1);
    }

    /* renamed from: a */
    public static boolean m6292a(View view) {
        if (view == null || view.getRootView() == null || !(view.getRootView().getLayoutParams() instanceof WindowManager.LayoutParams)) {
            return false;
        }
        int i = ((WindowManager.LayoutParams) view.getRootView().getLayoutParams()).type;
        return i == 2002 || i == 2007 || i == 2003 || i == 2010 || i == 2006 || (Build.VERSION.SDK_INT >= 26 && i == 2038);
    }

    /* renamed from: b */
    public static boolean m6290b(AttributeSet attributeSet) {
        return attributeSet != null && attributeSet.getAttributeBooleanValue(AppLovinAdView.NAMESPACE, "loadAdOnCreate", false);
    }
}
