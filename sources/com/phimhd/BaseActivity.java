package com.phimhd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.StrictMode;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.LogUtils;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.gson.Gson;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import com.lagradost.cloudstream3.services.ApiResponse;
import com.lagradost.cloudstream3.services.ApiUtils;
import com.lagradost.cloudstream3.services.CallBackBase;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Response;

/* compiled from: BaseActivity.kt */
@Metadata(m108d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 T2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001TB\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020'H\u0002J\u0006\u0010,\u001a\u00020'J\b\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0014\u00104\u001a\u0004\u0018\u00010\u00032\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0006\u00107\u001a\u00020'J\b\u00108\u001a\u00020*H$J\b\u00109\u001a\u00020'H$J\b\u0010:\u001a\u00020'H$J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0003H\u0016J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u00020'H\u0014J\u0006\u0010A\u001a\u00020'J\b\u0010B\u001a\u00020'H\u0014J\b\u0010C\u001a\u00020'H\u0014J\b\u0010D\u001a\u00020'H\u0004J\u0006\u0010E\u001a\u00020'J\b\u0010F\u001a\u00020'H\u0014J\b\u0010G\u001a\u00020'H\u0014J\b\u0010H\u001a\u00020'H\u0014J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\u0019H\u0016J\u0006\u0010K\u001a\u00020'J\u0006\u0010L\u001a\u00020'J\u0006\u0010M\u001a\u00020'J\u0010\u0010N\u001a\u00020'2\b\u0010O\u001a\u0004\u0018\u000103J\u0018\u0010P\u001a\u00020'2\b\u0010Q\u001a\u0004\u0018\u00010\u00032\u0006\u0010R\u001a\u00020*J\u0016\u0010S\u001a\u00020'2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0019X\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006U"}, m107d2 = {"Lcom/phimhd/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "", "()V", "connection", "Landroid/content/ServiceConnection;", "dialogLoading", "Lcom/phimhd/ProgressDialogCustom;", "getDialogLoading", "()Lcom/phimhd/ProgressDialogCustom;", "setDialogLoading", "(Lcom/phimhd/ProgressDialogCustom;)V", "dialogNetwork", "Landroidx/appcompat/app/AlertDialog;", "getDialogNetwork", "()Landroidx/appcompat/app/AlertDialog;", "setDialogNetwork", "(Landroidx/appcompat/app/AlertDialog;)V", "dialogUpgrade", "Lcom/phimhd/BottomUpgradeDialog;", "dialogUpgradeSuccess", "getDialogUpgradeSuccess", "setDialogUpgradeSuccess", "mBound", "", "getMBound", "()Z", "setMBound", "(Z)V", "mBounded", ViewHierarchyConstants.TAG_KEY, "getTag", "()Ljava/lang/String;", "visibleFragment", "Landroidx/fragment/app/Fragment;", "getVisibleFragment", "()Landroidx/fragment/app/Fragment;", "addToTab", "", "fragmentSearch", "idResource", "", "applicationWillEnterForeground", "applicationdidenterbackground", "checkMyKey", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "generateDialogUpgradeSuccess", SDKConstants.PARAM_KEY, "Lcom/phimhd/Key;", "getProcessName", "context", "Landroid/content/Context;", "hideDialogUpgrade", "initLayout", "initVariables", "initViews", "onCallback", "s", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNetworkTurnOn", "onPause", "onResume", "onServiceConnected", "onSocketConnected", "onStart", "onStop", "onUserLeaveHint", "onWindowFocusChanged", "hasFocus", "showDialogExpired", "showDialogKeyUpgrade", "showDialogUpgrade", "showKeyToUI", "newKey", "showToast", "message", "type", "tranToTab", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseActivity extends AppCompatActivity implements ICallback<String> {
    public static final Companion Companion = new Companion(null);
    private static boolean isAppWentToBg;
    private static boolean isBackPressed;
    private static boolean isMenuOpened;
    private static boolean isWindowFocused;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final ServiceConnection connection = new ServiceConnection() { // from class: com.phimhd.BaseActivity$connection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(service, "service");
            BaseActivity.this.setMBound(true);
            LogUtils.m6080d("onServiceConnected", new Object[0]);
            BaseActivity.this.onServiceConnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            BaseActivity.this.setMBound(false);
            LogUtils.m6080d("onServiceDisconnected", new Object[0]);
        }
    };
    private ProgressDialogCustom dialogLoading;
    private AlertDialog dialogNetwork;
    private BottomUpgradeDialog dialogUpgrade;
    private AlertDialog dialogUpgradeSuccess;
    private boolean mBound;
    private final boolean mBounded;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    public final String getTag() {
        return null;
    }

    protected abstract int initLayout();

    protected abstract void initVariables();

    protected abstract void initViews();

    public final void onNetworkTurnOn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onServiceConnected() {
    }

    public final void onSocketConnected() {
    }

    public final void showDialogExpired() {
    }

    public final void showToast(String str, int i) {
    }

    protected final boolean getMBound() {
        return this.mBound;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMBound(boolean z) {
        this.mBound = z;
    }

    public final AlertDialog getDialogNetwork() {
        return this.dialogNetwork;
    }

    public final void setDialogNetwork(AlertDialog alertDialog) {
        this.dialogNetwork = alertDialog;
    }

    public final AlertDialog getDialogUpgradeSuccess() {
        return this.dialogUpgradeSuccess;
    }

    public final void setDialogUpgradeSuccess(AlertDialog alertDialog) {
        this.dialogUpgradeSuccess = alertDialog;
    }

    public final ProgressDialogCustom getDialogLoading() {
        return this.dialogLoading;
    }

    public final void setDialogLoading(ProgressDialogCustom progressDialogCustom) {
        this.dialogLoading = progressDialogCustom;
    }

    public final void tranToTab(Fragment fragmentSearch, int i) {
        Intrinsics.checkNotNullParameter(fragmentSearch, "fragmentSearch");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        supportFragmentManager.beginTransaction().replace(i, fragmentSearch, fragmentSearch.getClass().getSimpleName()).addToBackStack(null).commit();
    }

    public final void addToTab(Fragment fragmentSearch, int i) {
        Intrinsics.checkNotNullParameter(fragmentSearch, "fragmentSearch");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        supportFragmentManager.beginTransaction().add(i, fragmentSearch, fragmentSearch.getClass().getSimpleName()).commit();
    }

    public final Fragment getVisibleFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible()) {
                return fragment;
            }
        }
        return null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
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

    private final String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String processName;
        super.onCreate(bundle);
        setContentView(initLayout());
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        }
        initViews();
        BaseActivity baseActivity = this;
        this.dialogLoading = new ProgressDialogCustom(baseActivity);
        initVariables();
        if (Build.VERSION.SDK_INT >= 28 && (processName = getProcessName(baseActivity)) != null && !Intrinsics.areEqual(getPackageName(), processName)) {
            WebView.setDataDirectorySuffix(processName);
        }
        this.dialogUpgrade = BottomUpgradeDialog.Companion.newInstance();
    }

    private final void checkMyKey() {
        final Key key;
        AppController companion = AppController.Companion.getInstance();
        if (companion == null || (key = companion.getKey()) == null) {
            return;
        }
        LogUtils.m6080d("Check Key Token :" + new Gson().toJson(key), new Object[0]);
        new ApiUtils().createApi().checkKeyWithToken(AbstractSpiCall.ACCEPT_JSON_VALUE, key).enqueue(new CallBackBase<ApiResponse<Key>>() { // from class: com.phimhd.BaseActivity$checkMyKey$1
            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestSuccess(Call<ApiResponse<Key>> call, Response<ApiResponse<Key>> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<Key> body = response.body();
                    Intrinsics.checkNotNull(body);
                    if (body.isSuccess()) {
                        ApiResponse<Key> body2 = response.body();
                        Intrinsics.checkNotNull(body2);
                        if (body2.getData() != null) {
                            ApiResponse<Key> body3 = response.body();
                            Intrinsics.checkNotNull(body3);
                            Key data = body3.getData();
                            AppController companion2 = AppController.Companion.getInstance();
                            if (companion2 == null) {
                                return;
                            }
                            companion2.setKey(data);
                            return;
                        }
                    }
                    AppController companion3 = AppController.Companion.getInstance();
                    if (companion3 != null) {
                        companion3.setKey(null);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n                                ");
                    ApiResponse<Key> body4 = response.body();
                    Intrinsics.checkNotNull(body4);
                    sb.append(body4.getMessage());
                    sb.append("\n                                ");
                    sb.append(new Gson().toJson(Key.this));
                    sb.append("\n                                ");
                    LogUtils.m6078e(StringsKt.trimIndent(sb.toString()), new Object[0]);
                    return;
                }
                AppController companion4 = AppController.Companion.getInstance();
                if (companion4 != null) {
                    companion4.setKey(null);
                }
                LogUtils.m6078e(response.message(), new Object[0]);
            }

            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestFailure(Call<ApiResponse<Key>> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                LogUtils.m6078e(t.getMessage(), new Object[0]);
            }
        });
    }

    private final void generateDialogUpgradeSuccess(Key key) {
        String str;
        String str2;
        if (key == null) {
            return;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setTitle((CharSequence) Html.fromHtml(getString(R.string.active_success_title)));
        String format = new SimpleDateFormat("dd/MM/yyyy").format(new Date(key.getExpiredTime()));
        if (key.isExpired()) {
            format = getString(R.string.expired_code);
        }
        if (key.getExpiredTime() == -1) {
            str2 = getString(R.string.unlimited_plan);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(R.string.unlimited_plan)");
            str = getString(R.string.unlimited_text);
        } else {
            String string = getString(R.string.premium_plan);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.premium_plan)");
            str = format;
            str2 = string;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.active_success_content);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.active_success_content)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str2, key.getKey(), str}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        materialAlertDialogBuilder.setMessage((CharSequence) Html.fromHtml(format2));
        materialAlertDialogBuilder.setPositiveButton((CharSequence) getString(R.string.ok), (DialogInterface.OnClickListener) $$Lambda$BaseActivity$rzJn9kRpLjrG9Q1xoZbXLpjRQcE.INSTANCE);
        materialAlertDialogBuilder.setNegativeButton((CharSequence) getString(R.string.delete), new DialogInterface.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseActivity$q707XPG3e5SI5lUCLkAAszecsmE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BaseActivity.m9035generateDialogUpgradeSuccess$lambda2(BaseActivity.this, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setCancelable(true);
        materialAlertDialogBuilder.setBackground(getDrawable(R.drawable.bg_white));
        AlertDialog create = materialAlertDialogBuilder.create();
        this.dialogUpgradeSuccess = create;
        Intrinsics.checkNotNull(create);
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.phimhd.-$$Lambda$BaseActivity$A0UKHTQZ6eMB5F4yVBOa5Ur_fjM
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseActivity.m9036generateDialogUpgradeSuccess$lambda3(BaseActivity.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: generateDialogUpgradeSuccess$lambda-1  reason: not valid java name */
    public static final void m9034generateDialogUpgradeSuccess$lambda1(DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: generateDialogUpgradeSuccess$lambda-2  reason: not valid java name */
    public static final void m9035generateDialogUpgradeSuccess$lambda2(BaseActivity this$0, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        AppController companion = AppController.Companion.getInstance();
        if (companion != null) {
            companion.setKey(null);
        }
        dialog.dismiss();
        this$0.recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: generateDialogUpgradeSuccess$lambda-3  reason: not valid java name */
    public static final void m9036generateDialogUpgradeSuccess$lambda3(BaseActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = this$0.dialogUpgradeSuccess;
        Intrinsics.checkNotNull(alertDialog);
        BaseActivity baseActivity = this$0;
        alertDialog.getButton(-1).setTextColor(ContextCompat.getColor(baseActivity, R.color.blue));
        int identifier = this$0.getResources().getIdentifier("alertTitle", "id", "android");
        AlertDialog alertDialog2 = this$0.dialogUpgradeSuccess;
        Intrinsics.checkNotNull(alertDialog2);
        TextView textView = (TextView) alertDialog2.findViewById(identifier);
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(baseActivity, R.color.background_color));
        }
    }

    public final void showDialogKeyUpgrade() {
        if (this.dialogUpgradeSuccess != null) {
            AppController companion = AppController.Companion.getInstance();
            if ((companion != null ? companion.getKey() : null) != null) {
                AlertDialog alertDialog = this.dialogUpgradeSuccess;
                Intrinsics.checkNotNull(alertDialog);
                alertDialog.show();
                return;
            }
        }
        AppController companion2 = AppController.Companion.getInstance();
        generateDialogUpgradeSuccess(companion2 != null ? companion2.getKey() : null);
        AlertDialog alertDialog2 = this.dialogUpgradeSuccess;
        if (alertDialog2 != null) {
            Intrinsics.checkNotNull(alertDialog2);
            alertDialog2.show();
        }
    }

    public final void showDialogUpgrade() {
        BottomUpgradeDialog bottomUpgradeDialog = this.dialogUpgrade;
        if (bottomUpgradeDialog != null) {
            Intrinsics.checkNotNull(bottomUpgradeDialog);
            if (bottomUpgradeDialog.isVisible()) {
                return;
            }
            BottomUpgradeDialog bottomUpgradeDialog2 = this.dialogUpgrade;
            Intrinsics.checkNotNull(bottomUpgradeDialog2);
            bottomUpgradeDialog2.show(getSupportFragmentManager(), "dialogUpgrade");
        }
    }

    public final void hideDialogUpgrade() {
        BottomUpgradeDialog bottomUpgradeDialog = this.dialogUpgrade;
        if (bottomUpgradeDialog != null) {
            Intrinsics.checkNotNull(bottomUpgradeDialog);
            if (bottomUpgradeDialog.isVisible()) {
                BottomUpgradeDialog bottomUpgradeDialog2 = this.dialogUpgrade;
                Intrinsics.checkNotNull(bottomUpgradeDialog2);
                bottomUpgradeDialog2.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        isWindowFocused = z;
        if (isBackPressed && !z) {
            isBackPressed = false;
            isWindowFocused = true;
        }
        super.onWindowFocusChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Log.d("onUserLeaveHint", "Home button pressed");
        super.onUserLeaveHint();
    }

    private final void applicationWillEnterForeground() {
        if (isAppWentToBg) {
            isAppWentToBg = false;
        }
    }

    public final void applicationdidenterbackground() {
        if (isWindowFocused) {
            return;
        }
        isAppWentToBg = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        applicationdidenterbackground();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        applicationWillEnterForeground();
        super.onStart();
        checkMyKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideDialogUpgrade();
        AlertDialog alertDialog = this.dialogUpgradeSuccess;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            if (alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.dialogUpgradeSuccess;
                Intrinsics.checkNotNull(alertDialog2);
                alertDialog2.dismiss();
            }
        }
        super.onDestroy();
    }

    @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
    public void onCallback(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        ProgressDialogCustom progressDialogCustom = this.dialogLoading;
        Intrinsics.checkNotNull(progressDialogCustom);
        progressDialogCustom.showDialog();
        Key key = new Key();
        key.setKey(s);
        new ApiUtils().createApi().checkKey(AbstractSpiCall.ACCEPT_JSON_VALUE, key).enqueue(new CallBackBase<ApiResponse<Key>>() { // from class: com.phimhd.BaseActivity$onCallback$1
            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestSuccess(Call<ApiResponse<Key>> call, Response<ApiResponse<Key>> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ProgressDialogCustom dialogLoading = BaseActivity.this.getDialogLoading();
                Intrinsics.checkNotNull(dialogLoading);
                dialogLoading.hideDialog();
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse<Key> body = response.body();
                    Intrinsics.checkNotNull(body);
                    if (body.isSuccess()) {
                        ApiResponse<Key> body2 = response.body();
                        Intrinsics.checkNotNull(body2);
                        if (body2.getData() != null) {
                            ApiResponse<Key> body3 = response.body();
                            Intrinsics.checkNotNull(body3);
                            Key data = body3.getData();
                            AppController companion = AppController.Companion.getInstance();
                            if (companion != null) {
                                companion.setKey(data);
                            }
                            BaseActivity.this.showKeyToUI(data);
                            return;
                        }
                    }
                    ApiResponse<Key> body4 = response.body();
                    Intrinsics.checkNotNull(body4);
                    LogUtils.m6078e(body4.getMessage(), new Object[0]);
                    BaseActivity baseActivity = BaseActivity.this;
                    Toast.makeText(baseActivity, baseActivity.getString(R.string.active_fail), 0).show();
                    return;
                }
                LogUtils.m6078e(response.message(), new Object[0]);
                BaseActivity baseActivity2 = BaseActivity.this;
                Toast.makeText(baseActivity2, baseActivity2.getString(R.string.active_fail), 0).show();
            }

            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestFailure(Call<ApiResponse<Key>> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                ProgressDialogCustom dialogLoading = BaseActivity.this.getDialogLoading();
                Intrinsics.checkNotNull(dialogLoading);
                dialogLoading.hideDialog();
                LogUtils.m6078e(t.getMessage(), new Object[0]);
                BaseActivity baseActivity = BaseActivity.this;
                Toast.makeText(baseActivity, baseActivity.getString(R.string.active_fail), 0).show();
            }
        });
    }

    public final void showKeyToUI(Key key) {
        BaseActivity baseActivity = this;
        LocalBroadcastManager.getInstance(baseActivity).sendBroadcast(new Intent(Constants.INTENT_UPDATE_KEY));
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(baseActivity);
        lottieAnimationView.setAnimation(R.raw.animation);
        lottieAnimationView.setLayoutParams(new WindowManager.LayoutParams(-1, -1));
        if (findViewById(R.id.homeRoot) != null) {
            View findViewById = findViewById(R.id.homeRoot);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) findViewById).addView(lottieAnimationView);
        }
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.playAnimation();
        lottieAnimationView.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.phimhd.BaseActivity$showKeyToUI$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                if (BaseActivity.this.findViewById(R.id.homeRoot) != null) {
                    View findViewById2 = BaseActivity.this.findViewById(R.id.homeRoot);
                    Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) findViewById2).removeView(lottieAnimationView);
                }
            }
        });
        generateDialogUpgradeSuccess(key);
        AlertDialog alertDialog = this.dialogUpgradeSuccess;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            if (alertDialog.isShowing()) {
                return;
            }
            AlertDialog alertDialog2 = this.dialogUpgradeSuccess;
            Intrinsics.checkNotNull(alertDialog2);
            alertDialog2.show();
        }
    }

    /* compiled from: BaseActivity.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u000e"}, m107d2 = {"Lcom/phimhd/BaseActivity$Companion;", "", "()V", "isAppWentToBg", "", "()Z", "setAppWentToBg", "(Z)V", "isBackPressed", "setBackPressed", "isMenuOpened", "setMenuOpened", "isWindowFocused", "setWindowFocused", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isAppWentToBg() {
            return BaseActivity.isAppWentToBg;
        }

        public final void setAppWentToBg(boolean z) {
            BaseActivity.isAppWentToBg = z;
        }

        public final boolean isWindowFocused() {
            return BaseActivity.isWindowFocused;
        }

        public final void setWindowFocused(boolean z) {
            BaseActivity.isWindowFocused = z;
        }

        public final boolean isMenuOpened() {
            return BaseActivity.isMenuOpened;
        }

        public final void setMenuOpened(boolean z) {
            BaseActivity.isMenuOpened = z;
        }

        public final boolean isBackPressed() {
            return BaseActivity.isBackPressed;
        }

        public final void setBackPressed(boolean z) {
            BaseActivity.isBackPressed = z;
        }
    }
}
