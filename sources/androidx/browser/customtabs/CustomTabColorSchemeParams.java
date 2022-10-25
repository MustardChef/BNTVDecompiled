package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final class CustomTabColorSchemeParams {
    public final Integer navigationBarColor;
    public final Integer navigationBarDividerColor;
    public final Integer secondaryToolbarColor;
    public final Integer toolbarColor;

    CustomTabColorSchemeParams(Integer toolbarColor, Integer secondaryToolbarColor, Integer navigationBarColor, Integer navigationBarDividerColor) {
        this.toolbarColor = toolbarColor;
        this.secondaryToolbarColor = secondaryToolbarColor;
        this.navigationBarColor = navigationBarColor;
        this.navigationBarDividerColor = navigationBarDividerColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Integer num = this.toolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.navigationBarColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR, num4.intValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CustomTabColorSchemeParams fromBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabColorSchemeParams withDefaults(CustomTabColorSchemeParams defaults) {
        Integer num = this.toolbarColor;
        if (num == null) {
            num = defaults.toolbarColor;
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 == null) {
            num2 = defaults.secondaryToolbarColor;
        }
        Integer num3 = this.navigationBarColor;
        if (num3 == null) {
            num3 = defaults.navigationBarColor;
        }
        Integer num4 = this.navigationBarDividerColor;
        if (num4 == null) {
            num4 = defaults.navigationBarDividerColor;
        }
        return new CustomTabColorSchemeParams(num, num2, num3, num4);
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private Integer mNavigationBarColor;
        private Integer mNavigationBarDividerColor;
        private Integer mSecondaryToolbarColor;
        private Integer mToolbarColor;

        public Builder setToolbarColor(int color) {
            this.mToolbarColor = Integer.valueOf(color | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }

        public Builder setSecondaryToolbarColor(int color) {
            this.mSecondaryToolbarColor = Integer.valueOf(color);
            return this;
        }

        public Builder setNavigationBarColor(int color) {
            this.mNavigationBarColor = Integer.valueOf(color | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }

        public Builder setNavigationBarDividerColor(int color) {
            this.mNavigationBarDividerColor = Integer.valueOf(color);
            return this;
        }

        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.mToolbarColor, this.mSecondaryToolbarColor, this.mNavigationBarColor, this.mNavigationBarDividerColor);
        }
    }
}
