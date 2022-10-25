package com.lagradost.cloudstream3.syncproviders.providers;

import android.content.Context;
import com.bongngotv2.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.movieproviders.NginxProvider;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager;
import com.lagradost.cloudstream3.utils.DataStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NginxApi.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0019\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/NginxApi;", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPIManager;", FirebaseAnalytics.Param.INDEX, "", "(I)V", "createAccountUrl", "", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", "name", "getName", "requiresPassword", "", "getRequiresPassword", "()Z", "requiresServer", "getRequiresServer", "requiresUsername", "getRequiresUsername", "getLatestLoginData", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeData", "logOut", "login", "data", "(Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxApi extends InAppAuthAPIManager {
    public static final Companion Companion = new Companion(null);
    public static final String NGINX_USER_KEY = "nginx_user";
    private final String createAccountUrl;
    private final int icon;
    private final String idPrefix;
    private final String name;
    private final boolean requiresPassword;
    private final boolean requiresServer;
    private final boolean requiresUsername;

    public NginxApi(int i) {
        super(i);
        this.name = "Nginx";
        this.idPrefix = "nginx";
        this.icon = R.drawable.nginx;
        this.requiresUsername = true;
        this.requiresPassword = true;
        this.requiresServer = true;
        this.createAccountUrl = "https://www.sarlays.com/use-nginx-with-cloudstream/";
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getIdPrefix() {
        return this.idPrefix;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public Integer getIcon() {
        return Integer.valueOf(this.icon);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresUsername() {
        return this.requiresUsername;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresPassword() {
        return this.requiresPassword;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresServer() {
        return this.requiresServer;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getCreateAccountUrl() {
        return this.createAccountUrl;
    }

    /* compiled from: NginxApi.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/NginxApi$Companion;", "", "()V", "NGINX_USER_KEY", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public InAppAuthAPI.LoginData getLatestLoginData() {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountId = getAccountId();
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(accountId, NGINX_USER_KEY), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, InAppAuthAPI.LoginData.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (InAppAuthAPI.LoginData) obj;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public AuthAPI.LoginInfo loginInfo() {
        InAppAuthAPI.LoginData latestLoginData = getLatestLoginData();
        if (latestLoginData == null) {
            return null;
        }
        String username = latestLoginData.getUsername();
        return new AuthAPI.LoginInfo(null, username == null ? latestLoginData.getServer() : username, getAccountIndex(), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object login(com.lagradost.cloudstream3.syncproviders.InAppAuthAPI.LoginData r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.lagradost.cloudstream3.syncproviders.providers.NginxApi$login$1
            if (r0 == 0) goto L14
            r0 = r7
            com.lagradost.cloudstream3.syncproviders.providers.NginxApi$login$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.NginxApi$login$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.NginxApi$login$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.NginxApi$login$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L69
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.getServer()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2 = 0
            if (r7 == 0) goto L47
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L45
            goto L47
        L45:
            r7 = 0
            goto L48
        L47:
            r7 = 1
        L48:
            if (r7 == 0) goto L4f
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r2)
            return r6
        L4f:
            r5.switchToNewAccount()
            com.lagradost.cloudstream3.AcraApplication$Companion r7 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r2 = r5.getAccountId()
            java.lang.String r4 = "nginx_user"
            r7.setKey(r2, r4, r6)
            r5.registerAccount()
            r0.label = r3
            java.lang.Object r6 = r5.initialize(r0)
            if (r6 != r1) goto L69
            return r1
        L69:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.NginxApi.login(com.lagradost.cloudstream3.syncproviders.InAppAuthAPI$LoginData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        removeAccountKeys();
        initializeData();
    }

    private final void initializeData() {
        InAppAuthAPI.LoginData latestLoginData = getLatestLoginData();
        if (latestLoginData == null) {
            NginxProvider.Companion.setOverrideUrl(null);
            NginxProvider.Companion.setLoginCredentials(null);
            return;
        }
        NginxProvider.Companion companion = NginxProvider.Companion;
        String server = latestLoginData.getServer();
        companion.setOverrideUrl(server != null ? StringsKt.removeSuffix(server, (CharSequence) "/") : null);
        NginxProvider.Companion companion2 = NginxProvider.Companion;
        StringBuilder sb = new StringBuilder();
        String username = latestLoginData.getUsername();
        if (username == null) {
            username = "";
        }
        sb.append(username);
        sb.append(':');
        String password = latestLoginData.getPassword();
        sb.append(password != null ? password : "");
        companion2.setLoginCredentials(sb.toString());
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager
    public Object initialize(Continuation<? super Unit> continuation) {
        initializeData();
        return Unit.INSTANCE;
    }
}
