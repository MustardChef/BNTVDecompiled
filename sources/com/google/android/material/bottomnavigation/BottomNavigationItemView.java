package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.C3633R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes3.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return C3633R.C3638layout.design_bottom_navigation_item;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return C3633R.dimen.design_bottom_navigation_margin;
    }
}
