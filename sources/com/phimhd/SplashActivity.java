package com.phimhd;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.services.ApiUtils;
import com.lagradost.cloudstream3.services.CallBackBase;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Response;

/* compiled from: SplashActivity.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0002J\u0012\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, m107d2 = {"Lcom/phimhd/SplashActivity;", "Lcom/phimhd/BaseActivity;", "()V", "myContext", "Landroid/content/Context;", "getMyContext", "()Landroid/content/Context;", "getConfigApi", "", "url", "", "getCurrentLocale", "hiddenProgress", "initLayout", "", "initVariables", "initViews", "onError", "message", "onErrorApi", "onErrorAuthorization", "onFailGetConfig", "onSuccessGetConfig", "config", "Lcom/phimhd/Config;", "showProgress", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SplashActivity extends BaseActivity {
    public static final boolean BYPASS = true;
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Override // com.phimhd.BaseActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.phimhd.BaseActivity
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

    public final void hiddenProgress() {
    }

    @Override // com.phimhd.BaseActivity
    protected int initLayout() {
        return R.layout.splash_activity;
    }

    public final void onError(String str) {
    }

    public final void onErrorApi(String str) {
    }

    public final void onErrorAuthorization() {
    }

    public final void showProgress() {
    }

    /* compiled from: SplashActivity.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/phimhd/SplashActivity$Companion;", "", "()V", "BYPASS", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String getCurrentLocale() {
        Locale locale;
        Configuration configuration = getResources().getConfiguration();
        String language = (configuration == null || (locale = configuration.locale) == null) ? null : locale.getLanguage();
        return language == null ? "en" : language;
    }

    @Override // com.phimhd.BaseActivity
    protected void initVariables() {
        String str;
        String currentLocale = getCurrentLocale();
        if (Intrinsics.areEqual(currentLocale, "vi") || Intrinsics.areEqual(currentLocale, "en")) {
            str = "https://raw.githubusercontent.com/cinehubwork/abc/master/config_" + currentLocale + ".json";
        } else {
            str = "https://raw.githubusercontent.com/cinehubwork/abc/master/config_en.json";
        }
        LogUtils.m6080d("DuongKK", str);
        getConfigApi(str);
    }

    private final void getConfigApi(String str) {
        new ApiUtils().createApi().getConfig(str).enqueue(new CallBackBase<Config>() { // from class: com.phimhd.SplashActivity$getConfigApi$1
            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestSuccess(Call<Config> call, Response<Config> response) {
                Unit unit = null;
                if (response != null) {
                    SplashActivity splashActivity = SplashActivity.this;
                    if (!response.isSuccessful()) {
                        splashActivity.onFailGetConfig();
                    } else {
                        Config body = response.body();
                        if (body != null) {
                            LogUtils.m6080d("Du", body.toString());
                            float f = body.version;
                            if (!body.approvedApp) {
                                splashActivity.onFailGetConfig();
                            } else {
                                AppController companion = AppController.Companion.getInstance();
                                if (companion != null) {
                                    companion.setConfig(body);
                                }
                                AppController companion2 = AppController.Companion.getInstance();
                                if (companion2 != null) {
                                    companion2.setListBannerHome(body.getListBanners());
                                }
                                splashActivity.onSuccessGetConfig(body);
                            }
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            splashActivity.onFailGetConfig();
                        }
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    SplashActivity.this.onFailGetConfig();
                }
            }

            @Override // com.lagradost.cloudstream3.services.CallBackBase
            public void onRequestFailure(Call<Config> call, Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error ");
                sb.append(th != null ? th.getMessage() : null);
                LogUtils.m6078e(sb.toString(), new Object[0]);
                SplashActivity.this.onFailGetConfig();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFailGetConfig() {
        Intent intent = new Intent(this, ServerMaintenanceActivity.class);
        String stringExtra = getIntent().getStringExtra("jsonData");
        if (stringExtra != null) {
            intent.putExtra("jsonData", stringExtra);
        }
        startActivity(intent);
        finish();
    }

    @Override // com.phimhd.BaseActivity
    protected void initViews() {
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.tvVersion);
        Intrinsics.checkNotNull(textView);
        textView.setText(getString(R.string.version) + " 5.6.84");
    }

    public static /* synthetic */ void onSuccessGetConfig$default(SplashActivity splashActivity, Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = null;
        }
        splashActivity.onSuccessGetConfig(config);
    }

    public final void onSuccessGetConfig(Config config) {
        Intent intent = new Intent(this, MainActivity.class);
        String stringExtra = getIntent().getStringExtra("jsonData");
        if (stringExtra != null) {
            intent.putExtra("jsonData", stringExtra);
        }
        startActivity(intent);
        finish();
    }

    public final Context getMyContext() {
        return this;
    }
}
