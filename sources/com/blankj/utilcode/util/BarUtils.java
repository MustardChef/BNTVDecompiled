package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public class BarUtils {
    private static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final String FAKE_STATUS_BAR_VIEW_TAG = "FAKE_STATUS_BAR_VIEW_TAG";
    private static final String FAKE_TRANSLUCENT_VIEW_TAG = "FAKE_TRANSLUCENT_VIEW_TAG";
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;

    private BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void addTranslucentView(Activity activity, int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewWithTag = viewGroup.findViewWithTag(FAKE_TRANSLUCENT_VIEW_TAG);
        if (findViewWithTag == null) {
            viewGroup.addView(createTranslucentStatusBarView(activity, i));
            return;
        }
        if (findViewWithTag.getVisibility() == 8) {
            findViewWithTag.setVisibility(0);
        }
        findViewWithTag.setBackgroundColor(Color.argb(i, 0, 0, 0));
    }

    private static int calculateStatusColor(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (i2 / 255.0f);
        return ((int) (((i & 255) * f) + 0.5d)) | (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8);
    }

    private static void clearPreviousSetting(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    private static View createStatusBarView(Activity activity, int i) {
        return createStatusBarView(activity, i, 0);
    }

    private static View createStatusBarView(Activity activity, int i, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(calculateStatusColor(i, i2));
        view.setTag(FAKE_STATUS_BAR_VIEW_TAG);
        return view;
    }

    private static View createTranslucentStatusBarView(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setTag(FAKE_TRANSLUCENT_VIEW_TAG);
        return view;
    }

    public static int getActionBarHeight(Activity activity) {
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void hideFakeStatusBarView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
        View findViewWithTag2 = viewGroup.findViewWithTag(FAKE_TRANSLUCENT_VIEW_TAG);
        if (findViewWithTag2 != null) {
            findViewWithTag2.setVisibility(8);
        }
    }

    public static void hideNotificationBar(Context context) {
        invokePanels(context, Build.VERSION.SDK_INT <= 16 ? "collapse" : "collapsePanels");
    }

    public static void hideStatusBar(Activity activity) {
        activity.requestWindowFeature(1);
        activity.getWindow().setFlags(1024, 1024);
    }

    private static void invokePanels(Context context, String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(context.getSystemService("statusbar"), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isStatusBarExists(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 1024;
    }

    public static void setColor(Activity activity, int i) {
        setColor(activity, i, 112);
    }

    public static void setColor(Activity activity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(calculateStatusColor(i, i2));
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
            if (findViewWithTag != null) {
                if (findViewWithTag.getVisibility() == 8) {
                    findViewWithTag.setVisibility(0);
                }
                findViewWithTag.setBackgroundColor(calculateStatusColor(i, i2));
            } else {
                viewGroup.addView(createStatusBarView(activity, i, i2));
            }
            setRootView(activity);
        }
    }

    @Deprecated
    public static void setColorDiff(Activity activity, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        transparentStatusBar(activity);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
        if (findViewWithTag != null) {
            if (findViewWithTag.getVisibility() == 8) {
                findViewWithTag.setVisibility(0);
            }
            findViewWithTag.setBackgroundColor(i);
        } else {
            viewGroup.addView(createStatusBarView(activity, i));
        }
        setRootView(activity);
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        setColorForDrawerLayout(activity, drawerLayout, i, 112);
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(67108864);
        }
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
        if (findViewWithTag != null) {
            if (findViewWithTag.getVisibility() == 8) {
                findViewWithTag.setVisibility(0);
            }
            findViewWithTag.setBackgroundColor(i);
        } else {
            viewGroup.addView(createStatusBarView(activity, i), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), getStatusBarHeight(activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        setDrawerLayoutProperty(drawerLayout, viewGroup);
        addTranslucentView(activity, i2);
    }

    @Deprecated
    public static void setColorForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewWithTag = viewGroup.findViewWithTag(FAKE_STATUS_BAR_VIEW_TAG);
            if (findViewWithTag != null) {
                if (findViewWithTag.getVisibility() == 8) {
                    findViewWithTag.setVisibility(0);
                }
                findViewWithTag.setBackgroundColor(calculateStatusColor(i, 112));
            } else {
                viewGroup.addView(createStatusBarView(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
            }
            setDrawerLayoutProperty(drawerLayout, viewGroup);
        }
    }

    public static void setColorForSwipeBack(Activity activity, int i) {
        setColorForSwipeBack(activity, i, 112);
    }

    public static void setColorForSwipeBack(Activity activity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            int statusBarHeight = getStatusBarHeight(activity);
            if (childAt == null || !(childAt instanceof CoordinatorLayout)) {
                viewGroup.setPadding(0, statusBarHeight, 0, 0);
                viewGroup.setBackgroundColor(calculateStatusColor(i, i2));
            } else {
                final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) childAt;
                if (Build.VERSION.SDK_INT < 21) {
                    coordinatorLayout.setFitsSystemWindows(false);
                    viewGroup.setBackgroundColor(calculateStatusColor(i, i2));
                    if (viewGroup.getPaddingTop() < statusBarHeight) {
                        viewGroup.setPadding(0, statusBarHeight, 0, 0);
                        coordinatorLayout.post(new Runnable() { // from class: com.blankj.utilcode.util.BarUtils.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CoordinatorLayout.this.requestLayout();
                            }
                        });
                    }
                } else {
                    coordinatorLayout.setStatusBarBackgroundColor(calculateStatusColor(i, i2));
                }
            }
            setTransparentForWindow(activity);
        }
    }

    public static void setColorNoTranslucent(Activity activity, int i) {
        setColor(activity, i, 0);
    }

    public static void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        setColorForDrawerLayout(activity, drawerLayout, i, 0);
    }

    private static void setDrawerLayoutProperty(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    private static void setRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void setTranslucent(Activity activity) {
        setTranslucent(activity, 112);
    }

    public static void setTranslucent(Activity activity, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        setTransparent(activity);
        addTranslucentView(activity, i);
    }

    @Deprecated
    public static void setTranslucentDiff(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            setRootView(activity);
        }
    }

    public static void setTranslucentForCoordinatorLayout(Activity activity, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        transparentStatusBar(activity);
        addTranslucentView(activity, i);
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        setTranslucentForDrawerLayout(activity, drawerLayout, 112);
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        setTransparentForDrawerLayout(activity, drawerLayout);
        addTranslucentView(activity, i);
    }

    @Deprecated
    public static void setTranslucentForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public static void setTranslucentForImageView(Activity activity, int i, View view) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        setTransparentForWindow(activity);
        addTranslucentView(activity, i);
        if (view != null) {
            Object tag = view.getTag(TAG_KEY_HAVE_SET_OFFSET);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(TAG_KEY_HAVE_SET_OFFSET, true);
            }
        }
    }

    public static void setTranslucentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 112, view);
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, int i, View view) {
        setTranslucentForImageView(activity, i, view);
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        clearPreviousSetting(activity);
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 112, view);
    }

    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        transparentStatusBar(activity);
        setRootView(activity);
    }

    public static void setTransparentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(0);
        } else {
            activity.getWindow().addFlags(67108864);
        }
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }
        setDrawerLayoutProperty(drawerLayout, viewGroup);
    }

    public static void setTransparentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 0, view);
    }

    public static void setTransparentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 0, view);
    }

    private static void setTransparentForWindow(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().setFlags(67108864, 67108864);
        }
    }

    public static void setTransparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            activity.getWindow().addFlags(134217728);
        }
    }

    public static void showNotificationBar(Context context, boolean z) {
        invokePanels(context, Build.VERSION.SDK_INT <= 16 ? "expand" : z ? "expandSettingsPanel" : "expandNotificationsPanel");
    }

    private static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT < 21) {
            activity.getWindow().addFlags(67108864);
            return;
        }
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(134217728);
        activity.getWindow().setStatusBarColor(0);
    }
}
