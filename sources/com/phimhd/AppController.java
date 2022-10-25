package com.phimhd;

import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.HomePageList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppController.kt */
@Metadata(m108d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u0004\u0018\u00010\nJ\u0006\u0010:\u001a\u00020&J\b\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020<2\b\u00106\u001a\u0004\u0018\u000105J\u0010\u0010>\u001a\u00020<2\b\u0010'\u001a\u0004\u0018\u00010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00106\u001a\u0004\u0018\u0001052\b\u00104\u001a\u0004\u0018\u000105@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006@"}, m107d2 = {"Lcom/phimhd/AppController;", "Lcom/lagradost/cloudstream3/AcraApplication;", "()V", "config", "Lcom/phimhd/Config;", "getConfig", "()Lcom/phimhd/Config;", "setConfig", "(Lcom/phimhd/Config;)V", "fid", "", "getFid", "()Ljava/lang/String;", "setFid", "(Ljava/lang/String;)V", "homePageLiveTv", "Lcom/lagradost/cloudstream3/HomePageList;", "getHomePageLiveTv", "()Lcom/lagradost/cloudstream3/HomePageList;", "setHomePageLiveTv", "(Lcom/lagradost/cloudstream3/HomePageList;)V", SDKConstants.PARAM_KEY, "Lcom/phimhd/Key;", "getKey", "()Lcom/phimhd/Key;", "setKey", "(Lcom/phimhd/Key;)V", "listBannerHome", "", "Lcom/phimhd/Banner;", "getListBannerHome", "()Ljava/util/List;", "setListBannerHome", "(Ljava/util/List;)V", "listHomeConfigCollection", "getListHomeConfigCollection", "setListHomeConfigCollection", "mSetting", "Lcom/blankj/utilcode/util/SPUtils;", "tokenFCM", "user", "Lcom/phimhd/User;", "getUser", "()Lcom/phimhd/User;", "setUser", "(Lcom/phimhd/User;)V", "vastAdded", "", "getVastAdded", "()Z", "setVastAdded", "(Z)V", "<set-?>", "Lcom/phimhd/Version;", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "getVersion", "()Lcom/phimhd/Version;", "getTokenFCM", "getmSetting", "onCreate", "", "setNewVersion", "setTokenFCM", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class AppController extends AcraApplication {
    public static final Companion Companion = new Companion(null);
    private static AppController instance;
    private Config config;
    private String fid;
    private HomePageList homePageLiveTv;
    private Key key;
    private List<Banner> listBannerHome;
    private List<HomePageList> listHomeConfigCollection;
    private SPUtils mSetting;
    private String tokenFCM;
    private User user;
    private boolean vastAdded;
    private Version version;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m9033onCreate$lambda0(AppLovinSdkConfiguration appLovinSdkConfiguration) {
    }

    public final List<HomePageList> getListHomeConfigCollection() {
        return this.listHomeConfigCollection;
    }

    public final void setListHomeConfigCollection(List<HomePageList> list) {
        this.listHomeConfigCollection = list;
    }

    public final HomePageList getHomePageLiveTv() {
        return this.homePageLiveTv;
    }

    public final void setHomePageLiveTv(HomePageList homePageList) {
        this.homePageLiveTv = homePageList;
    }

    public final List<Banner> getListBannerHome() {
        return this.listBannerHome;
    }

    public final void setListBannerHome(List<Banner> list) {
        this.listBannerHome = list;
    }

    public final boolean getVastAdded() {
        return this.vastAdded;
    }

    public final void setVastAdded(boolean z) {
        this.vastAdded = z;
    }

    public final Key getKey() {
        String string;
        if (this.key == null && (string = getmSetting().getString(SDKConstants.PARAM_KEY)) != null) {
            if (!(string.length() == 0)) {
                this.key = (Key) new Gson().fromJson(string, (Class<Object>) Key.class);
            }
        }
        return this.key;
    }

    public final void setKey(Key key) {
        this.key = key;
        if (key != null) {
            getmSetting().put(SDKConstants.PARAM_KEY, new Gson().toJson(key));
        } else {
            getmSetting().remove(SDKConstants.PARAM_KEY);
        }
    }

    public final void setFid(String str) {
        this.fid = str;
    }

    public final String getFid() {
        LogUtils.m6080d("Fid: " + this.fid, new Object[0]);
        return this.fid;
    }

    public final Version getVersion() {
        return this.version;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user) {
        this.user = user;
        getmSetting().put("user", new Gson().toJson(user));
        if (user == null || user.getKey() == null || getKey() != null) {
            return;
        }
        setKey(user.getKey());
    }

    @Override // com.lagradost.cloudstream3.AcraApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppController appController = this;
        Utils.init(appController);
        FacebookSdk.sdkInitialize(appController);
        this.mSetting = new SPUtils("setting");
        String string = getmSetting().getString(SDKConstants.PARAM_KEY);
        if (string != null) {
            if (!(string.length() == 0)) {
                setKey((Key) new Gson().fromJson(string, (Class<Object>) Key.class));
            }
        }
        String string2 = getmSetting().getString("user");
        if (string2 != null) {
            if (!(string2.length() == 0)) {
                setUser((User) new Gson().fromJson(string2, (Class<Object>) User.class));
            }
        }
        this.tokenFCM = getmSetting().getString("tokenFCM");
        AppLovinSdk.getInstance(appController).setMediationProvider(AppLovinMediationProvider.MAX);
        AppLovinSdk.initializeSdk(appController, $$Lambda$AppController$n3oMObSP4iuyVxCugFCRuwa4Yzs.INSTANCE);
    }

    public final SPUtils getmSetting() {
        if (this.mSetting == null) {
            this.mSetting = new SPUtils("setting");
        }
        SPUtils sPUtils = this.mSetting;
        Intrinsics.checkNotNull(sPUtils);
        return sPUtils;
    }

    public final Config getConfig() {
        SPUtils sPUtils = this.mSetting;
        Intrinsics.checkNotNull(sPUtils);
        if (sPUtils.getString("config") != null) {
            SPUtils sPUtils2 = this.mSetting;
            Intrinsics.checkNotNull(sPUtils2);
            String configStr = sPUtils2.getString("config");
            Intrinsics.checkNotNullExpressionValue(configStr, "configStr");
            if (configStr.length() == 0) {
                return null;
            }
            return (Config) new Gson().fromJson(configStr, (Class<Object>) Config.class);
        }
        return null;
    }

    public final void setConfig(Config config) {
        this.config = config;
        if (config != null) {
            getmSetting().put("config", new Gson().toJson(config));
        } else {
            getmSetting().remove("config");
        }
    }

    public final void setNewVersion(Version version) {
        this.version = version;
    }

    public final void setTokenFCM(String str) {
        this.tokenFCM = str;
        getmSetting().put("tokenFCM", str);
    }

    public final String getTokenFCM() {
        return this.tokenFCM;
    }

    /* compiled from: AppController.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m107d2 = {"Lcom/phimhd/AppController$Companion;", "", "()V", "<set-?>", "Lcom/phimhd/AppController;", "instance", "getInstance", "()Lcom/phimhd/AppController;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized AppController getInstance() {
            return AppController.instance;
        }
    }
}
