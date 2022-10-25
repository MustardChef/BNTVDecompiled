package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: UIHelper.kt */
@Metadata(m108d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\f\u0010\u0016\u001a\u00020\u0017*\u0004\u0018\u00010\u0018J\u0012\u0010\u0019\u001a\u00020\u0007*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017J\n\u0010\u001c\u001a\u00020\u0017*\u00020\u001aJ\u0012\u0010\u001d\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0007J\f\u0010\u001f\u001a\u00020\u000f*\u0004\u0018\u00010 J\u0016\u0010\u001f\u001a\u00020\u000f*\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\"\u001a\u00020\u000f*\u0004\u0018\u00010\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0012\u0010$\u001a\u00020\u000f*\u00020\u00182\u0006\u0010#\u001a\u00020\u0011J\n\u0010%\u001a\u00020\u0007*\u00020\u0018J \u0010&\u001a\u00020\u0007*\u00020\u00182\b\b\u0001\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u0004H\u0007J\u0013\u0010)\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010*J\n\u0010+\u001a\u00020\u0007*\u00020\u0018J\n\u0010,\u001a\u00020\u0017*\u00020\u0018J\n\u0010\u000e\u001a\u00020\u000f*\u00020\u001aJ\n\u0010\u000e\u001a\u00020\u000f*\u00020-J\n\u0010.\u001a\u00020\u000f*\u00020\u001aJ\"\u0010/\u001a\u00020\u000f*\u0004\u0018\u00010\u001a2\b\b\u0001\u00100\u001a\u00020\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\n\u00103\u001a\u00020\u000f*\u000204J?\u00105\u001a\u000206*\u00020\u00112\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000709082\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0;¢\u0006\u0002\b=H\u0007J?\u0010>\u001a\u000206*\u00020\u00112\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020?09082\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0;¢\u0006\u0002\b=H\u0007J\n\u0010@\u001a\u00020\u000f*\u00020\u001aJ?\u0010A\u001a\u00020\u0017*\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010?2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010E2\n\b\u0003\u0010F\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010GJ'\u0010H\u001a\u00020\u000f*\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010JJ@\u0010K\u001a\u00020\u000f*\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010?2\u0006\u0010L\u001a\u00020\u00072\b\b\u0002\u0010M\u001a\u00020\u00072\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010EJ\u0012\u0010N\u001a\u00020\u0017*\u00020\u00182\u0006\u0010O\u001a\u00020\u0017J\n\u0010P\u001a\u00020\u000f*\u00020\u001aR\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0003\u001a\u00020\u0007*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0015\u0010\t\u001a\u00020\u0007*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006Q"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/UIHelper;", "", "()V", "toDp", "", "getToDp", "(F)F", "", "(I)I", "toPx", "getToPx", "adjustAlpha", "color", "factor", "hideKeyboard", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "setListViewHeightBasedOnItems", "listView", "Landroid/widget/ListView;", "showInputMethod", "IsBottomLayout", "", "Landroid/content/Context;", "changeStatusBarState", "Landroid/app/Activity;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "checkWrite", "colorFromAttribute", "attribute", "dismissSafe", "Landroid/app/Dialog;", "activity", "fixPaddingStatusbar", "v", "fixPaddingStatusbarView", "getNavigationBarHeight", "getResourceColor", "resource", "alphaFactor", "getSpanCount", "(Landroid/app/Activity;)Ljava/lang/Integer;", "getStatusBarHeight", "hasPIPPermission", "Landroidx/fragment/app/Fragment;", "hideSystemUI", "navigate", NotificationCompat.CATEGORY_NAVIGATION, "arguments", "Landroid/os/Bundle;", "popCurrentPage", "Landroidx/fragment/app/FragmentActivity;", "popupMenuNoIcons", "Landroidx/appcompat/widget/PopupMenu;", FirebaseAnalytics.Param.ITEMS, "", "Lkotlin/Pair;", "onMenuItemClick", "Lkotlin/Function1;", "Landroid/view/MenuItem;", "Lkotlin/ExtensionFunctionType;", "popupMenuNoIconsAndNoStringRes", "", "requestRW", "setImage", "Landroid/widget/ImageView;", "url", "headers", "", "errorImageDrawable", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;)Z", "setImage1", "isUsingTransition", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Boolean;)V", "setImageBlur", "radius", "sample", "shouldShowPIPMode", "isInPlayer", "showSystemUI", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class UIHelper {
    public static final UIHelper INSTANCE = new UIHelper();

    private UIHelper() {
    }

    public final int getToPx(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public final float getToPx(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    public final int getToDp(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }

    public final float getToDp(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    public final boolean checkWrite(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final void requestRW(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1337);
    }

    public final void setListViewHeightBasedOnItems(ListView listView) {
        ListAdapter adapter = listView != null ? listView.getAdapter() : null;
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter.getView(i2, null, listView);
            Intrinsics.checkNotNullExpressionValue(view, "listAdapter.getView(itemPos, null, listView)");
            view.measure(0, 0);
            i += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "listView.layoutParams");
        layoutParams.height = i + (listView.getDividerHeight() * (count - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    public final Integer getSpanCount(Activity activity) {
        Resources resources;
        Configuration configuration;
        if (activity == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return null;
        }
        if (configuration.orientation == 2) {
            return 6;
        }
        return 3;
    }

    public final void hideKeyboard(Fragment fragment) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.clearFocus();
        }
        View view = fragment.getView();
        if (view != null) {
            INSTANCE.hideKeyboard(view);
        }
    }

    public final void hideKeyboard(Activity activity) {
        View rootView;
        View decorView;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Window window = activity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.clearFocus();
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById == null || (rootView = findViewById.getRootView()) == null) {
            return;
        }
        INSTANCE.hideKeyboard(rootView);
    }

    public static /* synthetic */ void navigate$default(UIHelper uIHelper, Activity activity, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        uIHelper.navigate(activity, i, bundle);
    }

    public final void navigate(Activity activity, int i, Bundle bundle) {
        NavController navController;
        if (activity instanceof FragmentActivity) {
            Fragment findFragmentById = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            NavHostFragment navHostFragment = findFragmentById instanceof NavHostFragment ? (NavHostFragment) findFragmentById : null;
            if (navHostFragment == null || (navController = navHostFragment.getNavController()) == null) {
                return;
            }
            navController.navigate(i, bundle);
        }
    }

    public static /* synthetic */ int getResourceColor$default(UIHelper uIHelper, Context context, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        return uIHelper.getResourceColor(context, i, f);
    }

    public final int getResourceColor(Context context, int i, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(intArrayOf(resource))");
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return f < 1.0f ? Color.argb(MathKt.roundToInt(((color >> 24) & 255) * f), (color >> 16) & 255, (color >> 8) & 255, color & 255) : color;
    }

    public static /* synthetic */ void setImage1$default(UIHelper uIHelper, ImageView imageView, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        uIHelper.setImage1(imageView, str, bool);
    }

    public final void setImage1(ImageView imageView, String str, Boolean bool) {
        if (imageView != null) {
            String str2 = str;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return;
            }
            try {
                GlideUrl glideUrl = new GlideUrl(str, new LazyHeaders.Builder().addHeader(HttpHeaders.REFERER, "https://phimchill.tv/").build());
                DrawableCrossFadeFactory build = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    GlideApp.with(imageView.getContext()).asBitmap().load((Object) glideUrl).transition((TransitionOptions<?, ? super Bitmap>) BitmapTransitionOptions.withCrossFade(build)).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                } else {
                    GlideApp.with(imageView.getContext()).load((Object) glideUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean setImage$default(UIHelper uIHelper, ImageView imageView, String str, Map map, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        return uIHelper.setImage(imageView, str, map, num);
    }

    public final boolean setImage(ImageView imageView, String str, final Map<String, String> map, Integer num) {
        if (imageView != null) {
            String str2 = str;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return false;
            }
            try {
                GlideRequest<Drawable> transition = GlideApp.with(imageView.getContext()).load((Object) new GlideUrl(str, new Headers() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$UIHelper$Kw1Orhcme-BpGHEVuoh434kh708
                    @Override // com.bumptech.glide.load.model.Headers
                    public final Map getHeaders() {
                        Map m9021setImage$lambda2;
                        m9021setImage$lambda2 = UIHelper.m9021setImage$lambda2(map);
                        return m9021setImage$lambda2;
                    }
                })).transition((TransitionOptions<?, ? super Drawable>) DrawableTransitionOptions.withCrossFade());
                Intrinsics.checkNotNullExpressionValue(transition, "with(this.context)\n     …sFade()\n                )");
                if (num != null) {
                    transition.error(num.intValue()).into(imageView);
                } else {
                    transition.into(imageView);
                }
                return true;
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setImage$lambda-2  reason: not valid java name */
    public static final Map m9021setImage$lambda2(Map map) {
        return map == null ? MapsKt.emptyMap() : map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setImageBlur$default(UIHelper uIHelper, ImageView imageView, String str, int i, int i2, Map map, int i3, Object obj) {
        int i4 = (i3 & 4) != 0 ? 3 : i2;
        Map<String, String> map2 = map;
        if ((i3 & 8) != 0) {
            map2 = null;
        }
        uIHelper.setImageBlur(imageView, str, i, i4, map2);
    }

    public final void setImageBlur(ImageView imageView, String str, int i, int i2, final Map<String, String> map) {
        if (imageView != null) {
            String str2 = str;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return;
            }
            try {
                GlideApp.with(imageView.getContext()).load((Object) new GlideUrl(str, new Headers() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$UIHelper$OlkUFkVmDse_BPgyEnOjLGFlbKM
                    @Override // com.bumptech.glide.load.model.Headers
                    public final Map getHeaders() {
                        Map m9022setImageBlur$lambda3;
                        m9022setImageBlur$lambda3 = UIHelper.m9022setImageBlur$lambda3(map);
                        return m9022setImageBlur$lambda3;
                    }
                })).apply((BaseRequestOptions<?>) GlideOptions.bitmapTransform((Transformation<Bitmap>) new BlurTransformation(i, i2))).transition((TransitionOptions<?, ? super Drawable>) DrawableTransitionOptions.withCrossFade()).into(imageView);
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setImageBlur$lambda-3  reason: not valid java name */
    public static final Map m9022setImageBlur$lambda3(Map map) {
        return map == null ? MapsKt.emptyMap() : map;
    }

    public final int adjustAlpha(int i, float f) {
        return Color.argb(MathKt.roundToInt(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final int colorFromAttribute(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(intArrayOf(attribute))");
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public final void hideSystemUI(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final void popCurrentPage(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        fragmentActivity.onBackPressed();
    }

    public final int getStatusBarHeight(Context context) {
        int identifier;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!SettingsFragment.Companion.isTvSettings(context) && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final void fixPaddingStatusbar(Context context, View view) {
        if (view == null || context == null) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    public final void fixPaddingStatusbarView(Context context, View v) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(v, "v");
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.height = getStatusBarHeight(context);
        v.setLayoutParams(layoutParams);
    }

    public final int getNavigationBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean IsBottomLayout(Context context) {
        if (context == null) {
            return true;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.bottom_title_key), true);
    }

    public final int changeStatusBarState(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (z) {
            Window window = activity.getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
            }
            return 0;
        }
        activity.getWindow().clearFlags(1024);
        return getStatusBarHeight(activity);
    }

    public final void showSystemUI(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        changeStatusBarState(activity, SettingsFragment.Companion.isEmulatorSettings(activity));
    }

    public final boolean shouldShowPIPMode(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            return (defaultSharedPreferences != null ? defaultSharedPreferences.getBoolean(context.getString(R.string.pip_enabled_key), true) : true) && z;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return false;
        }
    }

    public final boolean hasPIPPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("appops");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
        return Build.VERSION.SDK_INT < 26 || ((AppOpsManager) systemService).checkOpNoThrow("android:picture_in_picture", Process.myUid(), context.getPackageName()) == 0;
    }

    public final void hideKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final void showInputMethod(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 0);
    }

    public final void dismissSafe(Dialog dialog, Activity activity) {
        boolean z = true;
        if (dialog != null && dialog.isShowing()) {
            if ((activity == null || activity.isFinishing()) ? false : false) {
                dialog.dismiss();
            }
        }
    }

    public final void dismissSafe(Dialog dialog) {
        boolean z = true;
        if ((dialog == null || !dialog.isShowing()) ? false : false) {
            dialog.dismiss();
        }
    }

    public final PopupMenu popupMenuNoIcons(View view, List<Tuples<Integer, Integer>> items, final Function1<? super MenuItem, Unit> onMenuItemClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onMenuItemClick, "onMenuItemClick");
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), (int) R.style.PopupMenu), view, 0, R.attr.actionOverflowMenuStyle, 0);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            Tuples tuples = (Tuples) it.next();
            popupMenu.getMenu().add(0, ((Number) tuples.component1()).intValue(), 0, ((Number) tuples.component2()).intValue());
        }
        Menu menu = popupMenu.getMenu();
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (menuBuilder != null) {
            menuBuilder.setOptionalIconsVisible(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$UIHelper$JEIN4LEvArmruQt8YTSl_7hLf8A
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean m9019popupMenuNoIcons$lambda5;
                m9019popupMenuNoIcons$lambda5 = UIHelper.m9019popupMenuNoIcons$lambda5(Function1.this, menuItem);
                return m9019popupMenuNoIcons$lambda5;
            }
        });
        popupMenu.show();
        return popupMenu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: popupMenuNoIcons$lambda-5  reason: not valid java name */
    public static final boolean m9019popupMenuNoIcons$lambda5(Function1 onMenuItemClick, MenuItem it) {
        Intrinsics.checkNotNullParameter(onMenuItemClick, "$onMenuItemClick");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onMenuItemClick.invoke(it);
        return true;
    }

    public final PopupMenu popupMenuNoIconsAndNoStringRes(View view, List<Tuples<Integer, String>> items, final Function1<? super MenuItem, Unit> onMenuItemClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onMenuItemClick, "onMenuItemClick");
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), (int) R.style.PopupMenu), view, 0, R.attr.actionOverflowMenuStyle, 0);
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            Tuples tuples = (Tuples) it.next();
            popupMenu.getMenu().add(0, ((Number) tuples.component1()).intValue(), 0, (String) tuples.component2());
        }
        Menu menu = popupMenu.getMenu();
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (menuBuilder != null) {
            menuBuilder.setOptionalIconsVisible(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$UIHelper$9wTzmhaWbligerBLGrAJVtpJRxE
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean m9020popupMenuNoIconsAndNoStringRes$lambda7;
                m9020popupMenuNoIconsAndNoStringRes$lambda7 = UIHelper.m9020popupMenuNoIconsAndNoStringRes$lambda7(Function1.this, menuItem);
                return m9020popupMenuNoIconsAndNoStringRes$lambda7;
            }
        });
        popupMenu.show();
        return popupMenu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: popupMenuNoIconsAndNoStringRes$lambda-7  reason: not valid java name */
    public static final boolean m9020popupMenuNoIconsAndNoStringRes$lambda7(Function1 onMenuItemClick, MenuItem it) {
        Intrinsics.checkNotNullParameter(onMenuItemClick, "$onMenuItemClick");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        onMenuItemClick.invoke(it);
        return true;
    }
}
