package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.AbstractC1252j;

/* renamed from: com.applovin.impl.adview.n */
/* loaded from: classes.dex */
public class C1267n extends FrameLayout {

    /* renamed from: a */
    private final AbstractC1252j f633a;

    public C1267n(AbstractC1252j.EnumC1253a enumC1253a, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        AbstractC1252j m8056a = AbstractC1252j.m8056a(enumC1253a, activity);
        this.f633a = m8056a;
        addView(m8056a);
    }

    /* renamed from: a */
    public void m8028a(int i, int i2, int i3, int i4) {
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f633a.setLayoutParams(layoutParams2);
        this.f633a.mo7900a(i);
    }
}
