package com.lagradost.cloudstream3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigationrail.NavigationRailView;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import com.lagradost.cloudstream3.p041ui.download.DownloadFragmentKt;
import com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.receivers.VideoDownloadRestartReceiver;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.OAuth2API;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.IOnBackPressed;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.phimhd.AdapterFilterItem;
import com.phimhd.AdsActivity;
import com.phimhd.ICallbackDialogFilter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(m108d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002KLB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0014J\b\u0010#\u001a\u00020\u0013H\u0014J\"\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020\u0013H\u0014J\u0010\u00103\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001fH\u0016J\u001a\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0012\u0010;\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010<\u001a\u00020\u0013H\u0014J\b\u0010=\u001a\u00020\u0013H\u0014J\b\u0010>\u001a\u00020\u0013H\u0014J$\u0010?\u001a\u00020\u00132\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0DH\u0016J\u0006\u0010E\u001a\u00020\u0013J\u0010\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020HH\u0002J\u0016\u0010I\u001a\u00020\u0015*\u00020H2\b\b\u0001\u0010J\u001a\u00020\u001fH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006M"}, m107d2 = {"Lcom/lagradost/cloudstream3/MainActivity;", "Lcom/phimhd/AdsActivity;", "Lcom/jaredrummler/android/colorpicker/ColorPickerDialogListener;", "Lcom/phimhd/ICallbackDialogFilter;", "()V", "mSessionManager", "Lcom/google/android/gms/cast/framework/SessionManager;", "getMSessionManager", "()Lcom/google/android/gms/cast/framework/SessionManager;", "setMSessionManager", "(Lcom/google/android/gms/cast/framework/SessionManager;)V", "mSessionManagerListener", "Lcom/google/android/gms/cast/framework/SessionManagerListener;", "Lcom/google/android/gms/cast/framework/Session;", "getMSessionManagerListener", "()Lcom/google/android/gms/cast/framework/SessionManagerListener;", "mSessionManagerListener$delegate", "Lkotlin/Lazy;", "backPressed", "", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "handleAppIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "hideDialogFilter", "initLayout", "", "initTvTimeCountdonwAds", "Landroid/widget/TextView;", "initVariables", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onColorSelected", "dialogId", "color", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismissed", "onKeyDown", "keyCode", "onNavDestinationSelected", "item", "Landroid/view/MenuItem;", "navController", "Landroidx/navigation/NavController;", "onNewIntent", "onPause", "onResume", "onUserLeaveHint", "showDialogFilter", "list", "", "Lcom/lagradost/cloudstream3/Page;", "iCallbackToFragment", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "test", "updateNavBar", "destination", "Landroidx/navigation/NavDestination;", "matchDestination", "destId", "Companion", "SessionManagerListenerImpl", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MainActivity extends AdsActivity implements ColorPickerDialogListener, ICallbackDialogFilter {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "MAINACT";
    public SessionManager mSessionManager;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy mSessionManagerListener$delegate = LazyKt.lazy(new MainActivity$mSessionManagerListener$2(this));

    @Override // com.phimhd.AdsActivity, com.phimhd.BaseActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.phimhd.AdsActivity, com.phimhd.BaseActivity
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void test() {
    }

    /* compiled from: MainActivity.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/MainActivity$Companion;", "", "()V", "TAG", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onColorSelected(int i, int i2) {
        CommonActivity.INSTANCE.getOnColorSelectedEvent().invoke(new Tuples<>(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onDialogDismissed(int i) {
        CommonActivity.INSTANCE.getOnDialogDismissedEvent().invoke(Integer.valueOf(i));
    }

    @Override // com.phimhd.AdsActivity
    public TextView initTvTimeCountdonwAds() {
        return (TextView) _$_findCachedViewById(C4761R.C4764id.tvTimeAds);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.AdsActivity, com.phimhd.BaseActivity
    public void initVariables() {
        super.initVariables();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.AdsActivity, com.phimhd.BaseActivity
    public void initViews() {
        super.initViews();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.rcvBlurFilter);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.rcvBlurFilter);
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) _$_findCachedViewById(C4761R.C4764id.btnCloseDialogBlur);
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.-$$Lambda$MainActivity$tHpbBIHKQj1tEKdz_J-Uo1-pRRo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.m8591initViews$lambda0(MainActivity.this, view);
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.blurViewDialog);
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.-$$Lambda$MainActivity$LCdJ2bQMIB9v3KGy_eqH4JpDGBw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.m8592initViews$lambda1(MainActivity.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViews$lambda-0  reason: not valid java name */
    public static final void m8591initViews$lambda0(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideDialogFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initViews$lambda-1  reason: not valid java name */
    public static final void m8592initViews$lambda1(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideDialogFilter();
    }

    @Override // com.phimhd.ICallbackDialogFilter
    public void showDialogFilter(List<Page> list, final ICallback<Page> iCallbackToFragment) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(iCallbackToFragment, "iCallbackToFragment");
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.rcvBlurFilter)).setAdapter(new AdapterFilterItem(list, new ICallback() { // from class: com.lagradost.cloudstream3.-$$Lambda$MainActivity$kR1NHcPF_uR0Mg9tRdwyzCeY_rw
            @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
            public final void onCallback(Object obj) {
                MainActivity.m8597showDialogFilter$lambda2(MainActivity.this, iCallbackToFragment, (Page) obj);
            }
        }));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.lagradost.cloudstream3.MainActivity$showDialogFilter$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setAlpha(0.0f);
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setAlpha(1.0f);
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setVisibility(0);
            }
        });
        ((FrameLayout) _$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setAlpha(1.0f);
        ((FrameLayout) _$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialogFilter$lambda-2  reason: not valid java name */
    public static final void m8597showDialogFilter$lambda2(MainActivity this$0, ICallback iCallbackToFragment, Page page) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iCallbackToFragment, "$iCallbackToFragment");
        this$0.hideDialogFilter();
        iCallbackToFragment.onCallback(page);
    }

    @Override // com.phimhd.ICallbackDialogFilter
    public void hideDialogFilter() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.lagradost.cloudstream3.MainActivity$hideDialogFilter$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setAlpha(1.0f);
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setAlpha(0.0f);
                ((FrameLayout) MainActivity.this._$_findCachedViewById(C4761R.C4764id.blurViewDialog)).setVisibility(8);
            }
        });
        ((FrameLayout) _$_findCachedViewById(C4761R.C4764id.blurViewDialog)).startAnimation(animationSet);
    }

    @Override // com.phimhd.AdsActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        CommonActivity.INSTANCE.updateLocale(this);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(com.bongngotv2.R.id.nav_host_fragment);
        Objects.requireNonNull(findFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        NavDestination currentDestination = ((NavHostFragment) findFragmentById).getNavController().getCurrentDestination();
        if (currentDestination != null) {
            updateNavBar(currentDestination);
        }
    }

    private final void updateNavBar(NavDestination navDestination) {
        UIHelper.INSTANCE.hideKeyboard(this);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.cast_mini_controller_holder);
        boolean z = true;
        if (linearLayout != null) {
            linearLayout.setVisibility(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) com.bongngotv2.R.id.navigation_results), Integer.valueOf((int) com.bongngotv2.R.id.navigation_player)}).contains(Integer.valueOf(navDestination.getId())) ^ true ? 0 : 8);
        }
        boolean contains = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) com.bongngotv2.R.id.navigation_home), Integer.valueOf((int) com.bongngotv2.R.id.navigation_search), Integer.valueOf((int) com.bongngotv2.R.id.navigation_downloads), Integer.valueOf((int) com.bongngotv2.R.id.navigation_profile), Integer.valueOf((int) com.bongngotv2.R.id.navigation_download_child), Integer.valueOf((int) com.bongngotv2.R.id.navigation_subtitles), Integer.valueOf((int) com.bongngotv2.R.id.navigation_chrome_subtitles), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_player), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_updates), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_ui), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_account), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_lang), Integer.valueOf((int) com.bongngotv2.R.id.navigation_settings_general)}).contains(Integer.valueOf(navDestination.getId()));
        int i = getResources().getConfiguration().orientation;
        boolean z2 = i != 1 && i == 2;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) _$_findCachedViewById(C4761R.C4764id.nav_view);
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(contains && !z2 ? 0 : 8);
        }
        NavigationRailView navigationRailView = (NavigationRailView) _$_findCachedViewById(C4761R.C4764id.nav_rail_view);
        if (navigationRailView == null) {
            return;
        }
        navigationRailView.setVisibility((contains && z2) ? false : false ? 0 : 8);
    }

    public final SessionManager getMSessionManager() {
        SessionManager sessionManager = this.mSessionManager;
        if (sessionManager != null) {
            return sessionManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSessionManager");
        return null;
    }

    public final void setMSessionManager(SessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(sessionManager, "<set-?>");
        this.mSessionManager = sessionManager;
    }

    private final SessionManagerListener<Session> getMSessionManagerListener() {
        return (SessionManagerListener) this.mSessionManagerListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainActivity.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/MainActivity$SessionManagerListenerImpl;", "Lcom/google/android/gms/cast/framework/SessionManagerListener;", "Lcom/google/android/gms/cast/framework/Session;", "(Lcom/lagradost/cloudstream3/MainActivity;)V", "onSessionEnded", "", "session", "error", "", "onSessionEnding", "onSessionResumeFailed", "i", "onSessionResumed", "wasSuspended", "", "onSessionResuming", "s", "", "onSessionStartFailed", "onSessionStarted", "sessionId", "onSessionStarting", "onSessionSuspended", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public final class SessionManagerListenerImpl implements SessionManagerListener<Session> {
        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnded(Session session, int i) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionEnding(Session session) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumeFailed(Session session, int i) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResuming(Session session, String s) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStartFailed(Session session, int i) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarting(Session session) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionSuspended(Session session, int i) {
            Intrinsics.checkNotNullParameter(session, "session");
        }

        public SessionManagerListenerImpl() {
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionStarted(Session session, String sessionId) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            MainActivity.this.invalidateOptionsMenu();
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        public void onSessionResumed(Session session, boolean z) {
            Intrinsics.checkNotNullParameter(session, "session");
            MainActivity.this.invalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (AppUtils.INSTANCE.isCastApiAvailable(this)) {
                getMSessionManager().addSessionManagerListener(getMSessionManagerListener());
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            if (AppUtils.INSTANCE.isCastApiAvailable(this)) {
                getMSessionManager().removeSessionManagerListener(getMSessionManagerListener());
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean dispatchKeyEvent = CommonActivity.INSTANCE.dispatchKeyEvent(this, keyEvent);
        return dispatchKeyEvent != null ? dispatchKeyEvent.booleanValue() : super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        CommonActivity.INSTANCE.onKeyDown(this, i, keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.BaseActivity, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        CommonActivity.INSTANCE.onUserLeaveHint(this);
    }

    private final void backPressed() {
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(UIHelper.INSTANCE.colorFromAttribute(this, com.bongngotv2.R.attr.primaryGrayBackground));
        }
        MainActivity mainActivity = this;
        CommonActivity.INSTANCE.updateLocale(mainActivity);
        super.onBackPressed();
        CommonActivity.INSTANCE.updateLocale(mainActivity);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager childFragmentManager;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(com.bongngotv2.R.id.nav_host_fragment);
        Unit unit = null;
        NavHostFragment navHostFragment = findFragmentById instanceof NavHostFragment ? (NavHostFragment) findFragmentById : null;
        Fragment primaryNavigationFragment = (navHostFragment == null || (childFragmentManager = navHostFragment.getChildFragmentManager()) == null) ? null : childFragmentManager.getPrimaryNavigationFragment();
        IOnBackPressed iOnBackPressed = primaryNavigationFragment instanceof IOnBackPressed ? (IOnBackPressed) primaryNavigationFragment : null;
        if (iOnBackPressed != null) {
            if (iOnBackPressed.onBackPressed()) {
                backPressed();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            backPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (42 == i && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra(MainActivityKt.VLC_EXTRA_POSITION_OUT, -1L);
            long longExtra2 = intent.getLongExtra(MainActivityKt.VLC_EXTRA_DURATION_OUT, -1L);
            DataStore dataStore = DataStore.INSTANCE;
            MainActivity mainActivity = this;
            Integer num = null;
            try {
                String string = dataStore.getSharedPrefs(mainActivity).getString(MainActivityKt.VLC_LAST_ID_KEY, null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, Integer.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    num = readValue;
                }
            } catch (Exception unused) {
            }
            Integer num2 = num;
            System.out.println((Object) ("SET KEY " + num2 + " at " + longExtra + " / " + longExtra2));
            if (longExtra2 > 0 && longExtra > 0) {
                DataStoreHelper.INSTANCE.setViewPos(num2, longExtra, longExtra2);
            }
            DataStore.INSTANCE.removeKey(mainActivity, MainActivityKt.VLC_LAST_ID_KEY);
            ResultFragmentPhimHD.Companion.updateUI();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.phimhd.AdsActivity, com.phimhd.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Intent intent = new Intent();
        intent.setAction("restart_service");
        intent.setClass(this, VideoDownloadRestartReceiver.class);
        sendBroadcast(intent);
        super.onDestroy();
    }

    @Override // com.phimhd.BaseActivity
    protected int initLayout() {
        return SettingsFragment.Companion.isTvSettings(this) ? com.bongngotv2.R.layout.activity_main_tv : com.bongngotv2.R.layout.activity_main;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        handleAppIntent(intent);
        super.onNewIntent(intent);
    }

    /* JADX WARN: Type inference failed for: r15v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    private final void handleAppIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = intent.getDataString();
        if (objectRef.element == 0) {
            objectRef.element = intent.getStringExtra("jsonData");
        }
        Log.d("DuongKK", "String data = " + ((String) objectRef.element));
        MainActivity mainActivity = this;
        AppUtils.INSTANCE.loadCache(mainActivity);
        if (objectRef.element != 0) {
            if (StringsKt.contains$default((CharSequence) objectRef.element, (CharSequence) AccountManager.appString, false, 2, (Object) null)) {
                for (OAuth2API oAuth2API : AccountManager.Companion.getOAuth2Apis()) {
                    if (StringsKt.contains$default((CharSequence) objectRef.element, (CharSequence) (JsonPointer.SEPARATOR + oAuth2API.getRedirectUrl()), false, 2, (Object) null)) {
                        Coroutines.INSTANCE.ioSafe(new MainActivity$handleAppIntent$1(objectRef, oAuth2API, this, null));
                    }
                }
            } else if (StringsKt.startsWith$default((String) objectRef.element, DownloadFragmentKt.DOWNLOAD_NAVIGATE_TO, false, 2, (Object) null)) {
                UIHelper.navigate$default(UIHelper.INSTANCE, mainActivity, com.bongngotv2.R.id.navigation_downloads, null, 2, null);
            } else {
                for (MainAPI mainAPI : APIHolder.INSTANCE.getApis()) {
                    if (StringsKt.startsWith$default((String) objectRef.element, mainAPI.getMainUrl(), false, 2, (Object) null)) {
                        AppUtils.INSTANCE.loadResult(this, (String) objectRef.element, mainAPI.getName(), (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.phimhd.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View currentFocus = getCurrentFocus();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        if (currentFocus instanceof EditText) {
            View currentFocus2 = getCurrentFocus();
            int[] iArr = new int[2];
            Intrinsics.checkNotNull(currentFocus2);
            currentFocus2.getLocationOnScreen(iArr);
            float rawX = (event.getRawX() + currentFocus2.getLeft()) - iArr[0];
            float rawY = (event.getRawY() + currentFocus2.getTop()) - iArr[1];
            if (event.getAction() == 1 && (rawX < currentFocus2.getLeft() || rawX >= currentFocus2.getRight() || rawY < currentFocus2.getTop() || rawY > currentFocus2.getBottom())) {
                Object systemService = getSystemService("input_method");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                View currentFocus3 = getWindow().getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus3);
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus3.getWindowToken(), 0);
            }
        }
        return dispatchTouchEvent;
    }

    private final boolean matchDestination(NavDestination navDestination, int i) {
        boolean z;
        Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(navDestination).iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            if (it.next().getId() == i) {
                z = true;
                continue;
            }
        } while (!z);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005f, code lost:
        if (matchDestination(r7, r6.getItemId()) == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean onNavDestinationSelected(android.view.MenuItem r6, androidx.navigation.NavController r7) {
        /*
            r5 = this;
            androidx.navigation.NavOptions$Builder r0 = new androidx.navigation.NavOptions$Builder
            r0.<init>()
            r1 = 1
            androidx.navigation.NavOptions$Builder r0 = r0.setLaunchSingleTop(r1)
            androidx.navigation.NavOptions$Builder r0 = r0.setRestoreState(r1)
            r2 = 2130771996(0x7f01001c, float:1.7147098E38)
            androidx.navigation.NavOptions$Builder r0 = r0.setEnterAnim(r2)
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            androidx.navigation.NavOptions$Builder r0 = r0.setExitAnim(r2)
            r2 = 2130772012(0x7f01002c, float:1.714713E38)
            androidx.navigation.NavOptions$Builder r0 = r0.setPopEnterAnim(r2)
            r2 = 2130772013(0x7f01002d, float:1.7147132E38)
            androidx.navigation.NavOptions$Builder r0 = r0.setPopExitAnim(r2)
            int r2 = r6.getOrder()
            r3 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r3
            r3 = 0
            if (r2 != 0) goto L45
            androidx.navigation.NavGraph$Companion r2 = androidx.navigation.NavGraph.Companion
            androidx.navigation.NavGraph r4 = r7.getGraph()
            androidx.navigation.NavDestination r2 = r2.findStartDestination(r4)
            int r2 = r2.getId()
            r0.setPopUpTo(r2, r3, r1)
        L45:
            androidx.navigation.NavOptions r0 = r0.build()
            int r2 = r6.getItemId()     // Catch: java.lang.IllegalArgumentException -> L64
            r4 = 0
            r7.navigate(r2, r4, r0)     // Catch: java.lang.IllegalArgumentException -> L64
            androidx.navigation.NavDestination r7 = r7.getCurrentDestination()     // Catch: java.lang.IllegalArgumentException -> L64
            if (r7 == 0) goto L62
            int r6 = r6.getItemId()     // Catch: java.lang.IllegalArgumentException -> L64
            boolean r6 = r5.matchDestination(r7, r6)     // Catch: java.lang.IllegalArgumentException -> L64
            if (r6 != r1) goto L62
            goto L63
        L62:
            r1 = 0
        L63:
            r3 = r1
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.MainActivity.onNavDestinationSelected(android.view.MenuItem, androidx.navigation.NavController):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:4|2)|5|6|(2:7|8)|9|(3:10|11|12)|(7:14|(2:94|95)(1:16)|17|18|19|20|(29:22|23|24|(3:26|(5:28|(2:29|(2:31|(2:33|34))(2:41|42))|35|(2:37|38)(1:40)|39)|43)|44|45|46|47|(1:49)|51|(1:53)|54|(1:56)|(1:58)|59|(1:61)|62|(1:64)|(1:66)|(1:68)|69|(1:71)|72|(2:74|(1:76))|78|79|80|81|82)(28:89|24|(0)|44|45|46|47|(0)|51|(0)|54|(0)|(0)|59|(0)|62|(0)|(0)|(0)|69|(0)|72|(0)|78|79|80|81|82))|99|(0)(0)|17|18|19|20|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:4|2)|5|6|7|8|9|(3:10|11|12)|(7:14|(2:94|95)(1:16)|17|18|19|20|(29:22|23|24|(3:26|(5:28|(2:29|(2:31|(2:33|34))(2:41|42))|35|(2:37|38)(1:40)|39)|43)|44|45|46|47|(1:49)|51|(1:53)|54|(1:56)|(1:58)|59|(1:61)|62|(1:64)|(1:66)|(1:68)|69|(1:71)|72|(2:74|(1:76))|78|79|80|81|82)(28:89|24|(0)|44|45|46|47|(0)|51|(0)|54|(0)|(0)|59|(0)|62|(0)|(0)|(0)|69|(0)|72|(0)|78|79|80|81|82))|99|(0)(0)|17|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014a, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014b, code lost:
        com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad A[Catch: Exception -> 0x00c2, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c2, blocks: (B:26:0x00a2, B:29:0x00ad), top: B:108:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7 A[Catch: Exception -> 0x014a, TryCatch #2 {Exception -> 0x014a, blocks: (B:25:0x009b, B:32:0x00c3, B:34:0x00c7, B:36:0x00cb, B:37:0x00d9, B:39:0x00df, B:43:0x00fa, B:45:0x00fe, B:46:0x0134, B:47:0x0137), top: B:100:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174 A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #3 {Exception -> 0x0188, blocks: (B:52:0x0169, B:54:0x0174), top: B:102:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    @Override // com.phimhd.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.MainActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-13  reason: not valid java name */
    public static final boolean m8594onCreate$lambda13(MainActivity this$0, NavController navController, MenuItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(item, "item");
        return this$0.onNavDestinationSelected(item, navController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-14  reason: not valid java name */
    public static final boolean m8595onCreate$lambda14(MainActivity this$0, NavController navController, MenuItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navController, "$navController");
        Intrinsics.checkNotNullParameter(item, "item");
        return this$0.onNavDestinationSelected(item, navController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-15  reason: not valid java name */
    public static final void m8596onCreate$lambda15(MainActivity this$0, NavController navController, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        this$0.updateNavBar(destination);
    }
}
