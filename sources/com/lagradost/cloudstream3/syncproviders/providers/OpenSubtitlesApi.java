package com.lagradost.cloudstream3.syncproviders.providers;

import android.content.Context;
import com.applovin.sdk.AppLovinEventParameters;
import com.bongngotv2.R;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.subtitles.AbstractSubProvider;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpenSubtitlesApi.kt */
@Metadata(m108d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u00012\u00020\u0002:\t456789:;<B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J!\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020%H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020!H\u0016J\u0019\u0010(\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J!\u0010,\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0096@ø\u0001\u0000¢\u0006\u0002\u00100J\u0012\u00101\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi;", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPIManager;", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubProvider;", FirebaseAnalytics.Param.INDEX, "", "(I)V", "createAccountUrl", "", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", "name", "getName", "requiresPassword", "", "getRequiresPassword", "()Z", "requiresUsername", "getRequiresUsername", "canDoRequest", "getAuthKey", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$SubtitleOAuthEntity;", "getLatestLoginData", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;", "initLogin", AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "data", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;", "(Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "login", "(Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "search", "", "query", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;", "(Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAuthKey", "throwGotTooManyRequests", "throwIfCantDoRequest", "Companion", "OAuthToken", "ResultAttributes", "ResultData", "ResultDownloadLink", "ResultFeatureDetails", "ResultFiles", "Results", "SubtitleOAuthEntity", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class OpenSubtitlesApi extends InAppAuthAPIManager implements AbstractSubProvider {
    public static final Companion Companion = new Companion(null);
    public static final String OPEN_SUBTITLES_USER_KEY = "open_subtitles_user";
    public static final String TAG = "OPENSUBS";
    public static final String apiKey = "uyBLgFD17MgrYmA0gSXoKllMJBelOYj2";
    public static final long coolDownDuration = 30000;
    private static long currentCoolDown = 0;
    private static SubtitleOAuthEntity currentSession = null;
    public static final String host = "https://api.opensubtitles.com/api/v1";
    private final String createAccountUrl;
    private final int icon;
    private final String idPrefix;
    private final String name;
    private final boolean requiresPassword;
    private final boolean requiresUsername;

    public OpenSubtitlesApi(int i) {
        super(i);
        this.idPrefix = "opensubtitles";
        this.name = "OpenSubtitles";
        this.icon = R.drawable.open_subtitles_icon;
        this.requiresPassword = true;
        this.requiresUsername = true;
        this.createAccountUrl = "https://www.opensubtitles.com/en/users/sign_up";
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getIdPrefix() {
        return this.idPrefix;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public Integer getIcon() {
        return Integer.valueOf(this.icon);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresPassword() {
        return this.requiresPassword;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresUsername() {
        return this.requiresUsername;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getCreateAccountUrl() {
        return this.createAccountUrl;
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$Companion;", "", "()V", "OPEN_SUBTITLES_USER_KEY", "", "TAG", "apiKey", "coolDownDuration", "", "currentCoolDown", "getCurrentCoolDown", "()J", "setCurrentCoolDown", "(J)V", "currentSession", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$SubtitleOAuthEntity;", "getCurrentSession", "()Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$SubtitleOAuthEntity;", "setCurrentSession", "(Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$SubtitleOAuthEntity;)V", "host", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getCurrentCoolDown() {
            return OpenSubtitlesApi.currentCoolDown;
        }

        public final void setCurrentCoolDown(long j) {
            OpenSubtitlesApi.currentCoolDown = j;
        }

        public final SubtitleOAuthEntity getCurrentSession() {
            return OpenSubtitlesApi.currentSession;
        }

        public final void setCurrentSession(SubtitleOAuthEntity subtitleOAuthEntity) {
            OpenSubtitlesApi.currentSession = subtitleOAuthEntity;
        }
    }

    private final boolean canDoRequest() {
        return AccountManager.Companion.getUnixTimeMs() > currentCoolDown;
    }

    private final void throwIfCantDoRequest() {
        if (canDoRequest()) {
            return;
        }
        throw new ErrorLoadingException("Too many requests wait for " + ((currentCoolDown - AccountManager.Companion.getUnixTimeMs()) / 1000) + 's');
    }

    private final void throwGotTooManyRequests() {
        currentCoolDown = AccountManager.Companion.getUnixTimeMs() + 30000;
        throw new ErrorLoadingException("Too many requests");
    }

    private final SubtitleOAuthEntity getAuthKey() {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountId = getAccountId();
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(accountId, OPEN_SUBTITLES_USER_KEY), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, SubtitleOAuthEntity.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (SubtitleOAuthEntity) obj;
    }

    private final void setAuthKey(SubtitleOAuthEntity subtitleOAuthEntity) {
        if (subtitleOAuthEntity == null) {
            AcraApplication.Companion.removeKey(getAccountId(), OPEN_SUBTITLES_USER_KEY);
        }
        currentSession = subtitleOAuthEntity;
        AcraApplication.Companion.setKey(getAccountId(), OPEN_SUBTITLES_USER_KEY, subtitleOAuthEntity);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public AuthAPI.LoginInfo loginInfo() {
        SubtitleOAuthEntity authKey = getAuthKey();
        if (authKey != null) {
            return new AuthAPI.LoginInfo(null, authKey.getUser(), getAccountIndex());
        }
        return null;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public InAppAuthAPI.LoginData getLatestLoginData() {
        SubtitleOAuthEntity authKey = getAuthKey();
        if (authKey == null) {
            return null;
        }
        return new InAppAuthAPI.LoginData(authKey.getUser(), authKey.getPass(), null, null, 12, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager
    public Object initialize(Continuation<? super Unit> continuation) {
        String pass;
        String user;
        SubtitleOAuthEntity authKey = getAuthKey();
        String str = "duong12210119";
        String str2 = "duongnv1996";
        if (authKey == null) {
            authKey = new SubtitleOAuthEntity("duongnv1996", "duong12210119", "");
        }
        currentSession = authKey;
        if (authKey != null && (user = authKey.getUser()) != null) {
            str2 = user;
        }
        SubtitleOAuthEntity subtitleOAuthEntity = currentSession;
        if (subtitleOAuthEntity != null && (pass = subtitleOAuthEntity.getPass()) != null) {
            str = pass;
        }
        Object initLogin = initLogin(str2, str, continuation);
        return initLogin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? initLogin : Unit.INSTANCE;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        setAuthKey(null);
        removeAccountKeys();
        currentSession = getAuthKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initLogin(java.lang.String r29, java.lang.String r30, kotlin.coroutines.Continuation<? super java.lang.Boolean> r31) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi.initLogin(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:12:0x002a, B:27:0x0056, B:29:0x005e), top: B:40:0x002a }] */
    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager, com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object login(com.lagradost.cloudstream3.syncproviders.InAppAuthAPI.LoginData r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi$login$1
            if (r0 == 0) goto L14
            r0 = r6
            com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi$login$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi$login$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi$login$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi$login$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi r5 = (com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2e
            goto L56
        L2e:
            r6 = move-exception
            goto L68
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getUsername()
            if (r6 == 0) goto L81
            java.lang.String r5 = r5.getPassword()
            if (r5 == 0) goto L79
            r4.switchToNewAccount()
            r0.L$0 = r4     // Catch: java.lang.Exception -> L66
            r0.label = r3     // Catch: java.lang.Exception -> L66
            java.lang.Object r6 = r4.initLogin(r6, r5, r0)     // Catch: java.lang.Exception -> L66
            if (r6 != r1) goto L55
            return r1
        L55:
            r5 = r4
        L56:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Exception -> L2e
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Exception -> L2e
            if (r6 == 0) goto L70
            r5.registerAccount()     // Catch: java.lang.Exception -> L2e
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r3)     // Catch: java.lang.Exception -> L2e
            return r5
        L66:
            r6 = move-exception
            r5 = r4
        L68:
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r6)
            r5.switchToOldAccount()
        L70:
            r5.switchToOldAccount()
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r5)
            return r5
        L79:
            com.lagradost.cloudstream3.ErrorLoadingException r5 = new com.lagradost.cloudstream3.ErrorLoadingException
            java.lang.String r6 = "Requires Password"
            r5.<init>(r6)
            throw r5
        L81:
            com.lagradost.cloudstream3.ErrorLoadingException r5 = new com.lagradost.cloudstream3.ErrorLoadingException
            java.lang.String r6 = "Requires Username"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi.login(com.lagradost.cloudstream3.syncproviders.InAppAuthAPI$LoginData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d7  */
    @Override // com.lagradost.cloudstream3.subtitles.AbstractSubProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities.SubtitleSearch r25, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities.SubtitleEntity>> r26) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi.search(com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities$SubtitleSearch, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013a  */
    @Override // com.lagradost.cloudstream3.subtitles.AbstractSubProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities.SubtitleEntity r24, kotlin.coroutines.Continuation<? super java.lang.String> r25) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi.load(com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities$SubtitleEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$SubtitleOAuthEntity;", "", "user", "", "pass", "access_token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "setAccess_token", "(Ljava/lang/String;)V", "getPass", "setPass", "getUser", "setUser", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SubtitleOAuthEntity {
        private String access_token;
        private String pass;
        private String user;

        public static /* synthetic */ SubtitleOAuthEntity copy$default(SubtitleOAuthEntity subtitleOAuthEntity, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitleOAuthEntity.user;
            }
            if ((i & 2) != 0) {
                str2 = subtitleOAuthEntity.pass;
            }
            if ((i & 4) != 0) {
                str3 = subtitleOAuthEntity.access_token;
            }
            return subtitleOAuthEntity.copy(str, str2, str3);
        }

        public final String component1() {
            return this.user;
        }

        public final String component2() {
            return this.pass;
        }

        public final String component3() {
            return this.access_token;
        }

        public final SubtitleOAuthEntity copy(String user, String pass, String access_token) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(pass, "pass");
            Intrinsics.checkNotNullParameter(access_token, "access_token");
            return new SubtitleOAuthEntity(user, pass, access_token);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleOAuthEntity) {
                SubtitleOAuthEntity subtitleOAuthEntity = (SubtitleOAuthEntity) obj;
                return Intrinsics.areEqual(this.user, subtitleOAuthEntity.user) && Intrinsics.areEqual(this.pass, subtitleOAuthEntity.pass) && Intrinsics.areEqual(this.access_token, subtitleOAuthEntity.access_token);
            }
            return false;
        }

        public int hashCode() {
            return (((this.user.hashCode() * 31) + this.pass.hashCode()) * 31) + this.access_token.hashCode();
        }

        public String toString() {
            return "SubtitleOAuthEntity(user=" + this.user + ", pass=" + this.pass + ", access_token=" + this.access_token + ')';
        }

        public SubtitleOAuthEntity(String user, String pass, String access_token) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(pass, "pass");
            Intrinsics.checkNotNullParameter(access_token, "access_token");
            this.user = user;
            this.pass = pass;
            this.access_token = access_token;
        }

        public final String getUser() {
            return this.user;
        }

        public final void setUser(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.user = str;
        }

        public final String getPass() {
            return this.pass;
        }

        public final void setPass(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pass = str;
        }

        public final String getAccess_token() {
            return this.access_token;
        }

        public final void setAccess_token(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.access_token = str;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$OAuthToken;", "", "token", "", "status", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$OAuthToken;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class OAuthToken {
        private Integer status;
        private String token;

        public OAuthToken() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ OAuthToken copy$default(OAuthToken oAuthToken, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oAuthToken.token;
            }
            if ((i & 2) != 0) {
                num = oAuthToken.status;
            }
            return oAuthToken.copy(str, num);
        }

        public final String component1() {
            return this.token;
        }

        public final Integer component2() {
            return this.status;
        }

        public final OAuthToken copy(@JsonProperty("token") String str, @JsonProperty("status") Integer num) {
            return new OAuthToken(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OAuthToken) {
                OAuthToken oAuthToken = (OAuthToken) obj;
                return Intrinsics.areEqual(this.token, oAuthToken.token) && Intrinsics.areEqual(this.status, oAuthToken.status);
            }
            return false;
        }

        public int hashCode() {
            String str = this.token;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.status;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "OAuthToken(token=" + this.token + ", status=" + this.status + ')';
        }

        public OAuthToken(@JsonProperty("token") String str, @JsonProperty("status") Integer num) {
            this.token = str;
            this.status = num;
        }

        public /* synthetic */ OAuthToken(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getToken() {
            return this.token;
        }

        public final void setToken(String str) {
            this.token = str;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final void setStatus(Integer num) {
            this.status = num;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$Results;", "", "data", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultData;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Results {
        private List<ResultData> data;

        public Results() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Results copy$default(Results results, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = results.data;
            }
            return results.copy(list);
        }

        public final List<ResultData> component1() {
            return this.data;
        }

        public final Results copy(@JsonProperty("data") List<ResultData> list) {
            return new Results(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Results) && Intrinsics.areEqual(this.data, ((Results) obj).data);
        }

        public int hashCode() {
            List<ResultData> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "Results(data=" + this.data + ')';
        }

        public Results(@JsonProperty("data") List<ResultData> list) {
            this.data = list;
        }

        public /* synthetic */ Results(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<ResultData> getData() {
            return this.data;
        }

        public final void setData(List<ResultData> list) {
            this.data = list;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultData;", "", "id", "", "type", "attributes", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultAttributes;", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultAttributes;)V", "getAttributes", "()Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultAttributes;", "setAttributes", "(Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultAttributes;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResultData {
        private ResultAttributes attributes;

        /* renamed from: id */
        private String f10016id;
        private String type;

        public ResultData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ResultData copy$default(ResultData resultData, String str, String str2, ResultAttributes resultAttributes, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resultData.f10016id;
            }
            if ((i & 2) != 0) {
                str2 = resultData.type;
            }
            if ((i & 4) != 0) {
                resultAttributes = resultData.attributes;
            }
            return resultData.copy(str, str2, resultAttributes);
        }

        public final String component1() {
            return this.f10016id;
        }

        public final String component2() {
            return this.type;
        }

        public final ResultAttributes component3() {
            return this.attributes;
        }

        public final ResultData copy(@JsonProperty("id") String str, @JsonProperty("type") String str2, @JsonProperty("attributes") ResultAttributes resultAttributes) {
            return new ResultData(str, str2, resultAttributes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResultData) {
                ResultData resultData = (ResultData) obj;
                return Intrinsics.areEqual(this.f10016id, resultData.f10016id) && Intrinsics.areEqual(this.type, resultData.type) && Intrinsics.areEqual(this.attributes, resultData.attributes);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f10016id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ResultAttributes resultAttributes = this.attributes;
            return hashCode2 + (resultAttributes != null ? resultAttributes.hashCode() : 0);
        }

        public String toString() {
            return "ResultData(id=" + this.f10016id + ", type=" + this.type + ", attributes=" + this.attributes + ')';
        }

        public ResultData(@JsonProperty("id") String str, @JsonProperty("type") String str2, @JsonProperty("attributes") ResultAttributes resultAttributes) {
            this.f10016id = str;
            this.type = str2;
            this.attributes = resultAttributes;
        }

        public final String getId() {
            return this.f10016id;
        }

        public final void setId(String str) {
            this.f10016id = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public /* synthetic */ ResultData(String str, String str2, ResultAttributes resultAttributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ResultAttributes(null, null, null, null, null, null, 63, null) : resultAttributes);
        }

        public final ResultAttributes getAttributes() {
            return this.attributes;
        }

        public final void setAttributes(ResultAttributes resultAttributes) {
            this.attributes = resultAttributes;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010%\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultAttributes;", "", "subtitleId", "", "language", "release", "url", "files", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFiles;", "featDetails", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;)V", "getFeatDetails", "()Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;", "setFeatDetails", "(Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;)V", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getRelease", "setRelease", "getSubtitleId", "setSubtitleId", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResultAttributes {
        private ResultFeatureDetails featDetails;
        private List<ResultFiles> files;
        private String language;
        private String release;
        private String subtitleId;
        private String url;

        public ResultAttributes() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ ResultAttributes copy$default(ResultAttributes resultAttributes, String str, String str2, String str3, String str4, List list, ResultFeatureDetails resultFeatureDetails, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resultAttributes.subtitleId;
            }
            if ((i & 2) != 0) {
                str2 = resultAttributes.language;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = resultAttributes.release;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = resultAttributes.url;
            }
            String str7 = str4;
            List<ResultFiles> list2 = list;
            if ((i & 16) != 0) {
                list2 = resultAttributes.files;
            }
            List list3 = list2;
            if ((i & 32) != 0) {
                resultFeatureDetails = resultAttributes.featDetails;
            }
            return resultAttributes.copy(str, str5, str6, str7, list3, resultFeatureDetails);
        }

        public final String component1() {
            return this.subtitleId;
        }

        public final String component2() {
            return this.language;
        }

        public final String component3() {
            return this.release;
        }

        public final String component4() {
            return this.url;
        }

        public final List<ResultFiles> component5() {
            return this.files;
        }

        public final ResultFeatureDetails component6() {
            return this.featDetails;
        }

        public final ResultAttributes copy(@JsonProperty("subtitle_id") String str, @JsonProperty("language") String str2, @JsonProperty("release") String str3, @JsonProperty("url") String str4, @JsonProperty("files") List<ResultFiles> list, @JsonProperty("feature_details") ResultFeatureDetails resultFeatureDetails) {
            return new ResultAttributes(str, str2, str3, str4, list, resultFeatureDetails);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResultAttributes) {
                ResultAttributes resultAttributes = (ResultAttributes) obj;
                return Intrinsics.areEqual(this.subtitleId, resultAttributes.subtitleId) && Intrinsics.areEqual(this.language, resultAttributes.language) && Intrinsics.areEqual(this.release, resultAttributes.release) && Intrinsics.areEqual(this.url, resultAttributes.url) && Intrinsics.areEqual(this.files, resultAttributes.files) && Intrinsics.areEqual(this.featDetails, resultAttributes.featDetails);
            }
            return false;
        }

        public int hashCode() {
            String str = this.subtitleId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.language;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.release;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.url;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            List<ResultFiles> list = this.files;
            int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
            ResultFeatureDetails resultFeatureDetails = this.featDetails;
            return hashCode5 + (resultFeatureDetails != null ? resultFeatureDetails.hashCode() : 0);
        }

        public String toString() {
            return "ResultAttributes(subtitleId=" + this.subtitleId + ", language=" + this.language + ", release=" + this.release + ", url=" + this.url + ", files=" + this.files + ", featDetails=" + this.featDetails + ')';
        }

        public ResultAttributes(@JsonProperty("subtitle_id") String str, @JsonProperty("language") String str2, @JsonProperty("release") String str3, @JsonProperty("url") String str4, @JsonProperty("files") List<ResultFiles> list, @JsonProperty("feature_details") ResultFeatureDetails resultFeatureDetails) {
            this.subtitleId = str;
            this.language = str2;
            this.release = str3;
            this.url = str4;
            this.files = list;
            this.featDetails = resultFeatureDetails;
        }

        public final String getSubtitleId() {
            return this.subtitleId;
        }

        public final void setSubtitleId(String str) {
            this.subtitleId = str;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final String getRelease() {
            return this.release;
        }

        public final void setRelease(String str) {
            this.release = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public /* synthetic */ ResultAttributes(String str, String str2, String str3, String str4, List list, ResultFeatureDetails resultFeatureDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : null, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? new ResultFeatureDetails(null, null, null, null, null, null, null, null, null, null, null, 2047, null) : resultFeatureDetails);
        }

        public final List<ResultFiles> getFiles() {
            return this.files;
        }

        public final void setFiles(List<ResultFiles> list) {
            this.files = list;
        }

        public final ResultFeatureDetails getFeatDetails() {
            return this.featDetails;
        }

        public final void setFeatDetails(ResultFeatureDetails resultFeatureDetails) {
            this.featDetails = resultFeatureDetails;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFiles;", "", "fileId", "", "fileName", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/Integer;", "setFileId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFiles;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResultFiles {
        private Integer fileId;
        private String fileName;

        public ResultFiles() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ ResultFiles copy$default(ResultFiles resultFiles, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = resultFiles.fileId;
            }
            if ((i & 2) != 0) {
                str = resultFiles.fileName;
            }
            return resultFiles.copy(num, str);
        }

        public final Integer component1() {
            return this.fileId;
        }

        public final String component2() {
            return this.fileName;
        }

        public final ResultFiles copy(@JsonProperty("file_id") Integer num, @JsonProperty("file_name") String str) {
            return new ResultFiles(num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResultFiles) {
                ResultFiles resultFiles = (ResultFiles) obj;
                return Intrinsics.areEqual(this.fileId, resultFiles.fileId) && Intrinsics.areEqual(this.fileName, resultFiles.fileName);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.fileId;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.fileName;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ResultFiles(fileId=" + this.fileId + ", fileName=" + this.fileName + ')';
        }

        public ResultFiles(@JsonProperty("file_id") Integer num, @JsonProperty("file_name") String str) {
            this.fileId = num;
            this.fileName = str;
        }

        public /* synthetic */ ResultFiles(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        public final Integer getFileId() {
            return this.fileId;
        }

        public final void setFileId(Integer num) {
            this.fileId = num;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final void setFileName(String str) {
            this.fileName = str;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010&\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006-"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultDownloadLink;", "", "link", "", "fileName", "requests", "", "remaining", "message", "resetTime", "resetTimeUtc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getLink", "setLink", "getMessage", "setMessage", "getRemaining", "()Ljava/lang/Integer;", "setRemaining", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRequests", "setRequests", "getResetTime", "setResetTime", "getResetTimeUtc", "setResetTimeUtc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultDownloadLink;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResultDownloadLink {
        private String fileName;
        private String link;
        private String message;
        private Integer remaining;
        private Integer requests;
        private String resetTime;
        private String resetTimeUtc;

        public ResultDownloadLink() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ ResultDownloadLink copy$default(ResultDownloadLink resultDownloadLink, String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resultDownloadLink.link;
            }
            if ((i & 2) != 0) {
                str2 = resultDownloadLink.fileName;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                num = resultDownloadLink.requests;
            }
            Integer num3 = num;
            if ((i & 8) != 0) {
                num2 = resultDownloadLink.remaining;
            }
            Integer num4 = num2;
            if ((i & 16) != 0) {
                str3 = resultDownloadLink.message;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                str4 = resultDownloadLink.resetTime;
            }
            String str8 = str4;
            if ((i & 64) != 0) {
                str5 = resultDownloadLink.resetTimeUtc;
            }
            return resultDownloadLink.copy(str, str6, num3, num4, str7, str8, str5);
        }

        public final String component1() {
            return this.link;
        }

        public final String component2() {
            return this.fileName;
        }

        public final Integer component3() {
            return this.requests;
        }

        public final Integer component4() {
            return this.remaining;
        }

        public final String component5() {
            return this.message;
        }

        public final String component6() {
            return this.resetTime;
        }

        public final String component7() {
            return this.resetTimeUtc;
        }

        public final ResultDownloadLink copy(@JsonProperty("link") String str, @JsonProperty("file_name") String str2, @JsonProperty("requests") Integer num, @JsonProperty("remaining") Integer num2, @JsonProperty("message") String str3, @JsonProperty("reset_time") String str4, @JsonProperty("reset_time_utc") String str5) {
            return new ResultDownloadLink(str, str2, num, num2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResultDownloadLink) {
                ResultDownloadLink resultDownloadLink = (ResultDownloadLink) obj;
                return Intrinsics.areEqual(this.link, resultDownloadLink.link) && Intrinsics.areEqual(this.fileName, resultDownloadLink.fileName) && Intrinsics.areEqual(this.requests, resultDownloadLink.requests) && Intrinsics.areEqual(this.remaining, resultDownloadLink.remaining) && Intrinsics.areEqual(this.message, resultDownloadLink.message) && Intrinsics.areEqual(this.resetTime, resultDownloadLink.resetTime) && Intrinsics.areEqual(this.resetTimeUtc, resultDownloadLink.resetTimeUtc);
            }
            return false;
        }

        public int hashCode() {
            String str = this.link;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.fileName;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.requests;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.remaining;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str3 = this.message;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.resetTime;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.resetTimeUtc;
            return hashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "ResultDownloadLink(link=" + this.link + ", fileName=" + this.fileName + ", requests=" + this.requests + ", remaining=" + this.remaining + ", message=" + this.message + ", resetTime=" + this.resetTime + ", resetTimeUtc=" + this.resetTimeUtc + ')';
        }

        public ResultDownloadLink(@JsonProperty("link") String str, @JsonProperty("file_name") String str2, @JsonProperty("requests") Integer num, @JsonProperty("remaining") Integer num2, @JsonProperty("message") String str3, @JsonProperty("reset_time") String str4, @JsonProperty("reset_time_utc") String str5) {
            this.link = str;
            this.fileName = str2;
            this.requests = num;
            this.remaining = num2;
            this.message = str3;
            this.resetTime = str4;
            this.resetTimeUtc = str5;
        }

        public /* synthetic */ ResultDownloadLink(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            this.link = str;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final void setFileName(String str) {
            this.fileName = str;
        }

        public final Integer getRequests() {
            return this.requests;
        }

        public final void setRequests(Integer num) {
            this.requests = num;
        }

        public final Integer getRemaining() {
            return this.remaining;
        }

        public final void setRemaining(Integer num) {
            this.remaining = num;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final String getResetTime() {
            return this.resetTime;
        }

        public final void setResetTime(String str) {
            this.resetTime = str;
        }

        public final String getResetTimeUtc() {
            return this.resetTimeUtc;
        }

        public final void setResetTimeUtc(String str) {
            this.resetTimeUtc = str;
        }
    }

    /* compiled from: OpenSubtitlesApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0092\u0001\u00106\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013¨\u0006="}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;", "", "year", "", "title", "", "movieName", "imdbId", "tmdbId", "seasonNumber", "episodeNumber", "parentImdbId", "parentTitle", "parentTmdbId", "parentFeatureId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisodeNumber", "()Ljava/lang/Integer;", "setEpisodeNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getImdbId", "setImdbId", "getMovieName", "()Ljava/lang/String;", "setMovieName", "(Ljava/lang/String;)V", "getParentFeatureId", "setParentFeatureId", "getParentImdbId", "setParentImdbId", "getParentTitle", "setParentTitle", "getParentTmdbId", "setParentTmdbId", "getSeasonNumber", "setSeasonNumber", "getTitle", "setTitle", "getTmdbId", "setTmdbId", "getYear", "setYear", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi$ResultFeatureDetails;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResultFeatureDetails {
        private Integer episodeNumber;
        private Integer imdbId;
        private String movieName;
        private Integer parentFeatureId;
        private Integer parentImdbId;
        private String parentTitle;
        private Integer parentTmdbId;
        private Integer seasonNumber;
        private String title;
        private Integer tmdbId;
        private Integer year;

        public ResultFeatureDetails() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public final Integer component1() {
            return this.year;
        }

        public final Integer component10() {
            return this.parentTmdbId;
        }

        public final Integer component11() {
            return this.parentFeatureId;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.movieName;
        }

        public final Integer component4() {
            return this.imdbId;
        }

        public final Integer component5() {
            return this.tmdbId;
        }

        public final Integer component6() {
            return this.seasonNumber;
        }

        public final Integer component7() {
            return this.episodeNumber;
        }

        public final Integer component8() {
            return this.parentImdbId;
        }

        public final String component9() {
            return this.parentTitle;
        }

        public final ResultFeatureDetails copy(@JsonProperty("year") Integer num, @JsonProperty("title") String str, @JsonProperty("movie_name") String str2, @JsonProperty("imdb_id") Integer num2, @JsonProperty("tmdb_id") Integer num3, @JsonProperty("season_number") Integer num4, @JsonProperty("episode_number") Integer num5, @JsonProperty("parent_imdb_id") Integer num6, @JsonProperty("parent_title") String str3, @JsonProperty("parent_tmdb_id") Integer num7, @JsonProperty("parent_feature_id") Integer num8) {
            return new ResultFeatureDetails(num, str, str2, num2, num3, num4, num5, num6, str3, num7, num8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResultFeatureDetails) {
                ResultFeatureDetails resultFeatureDetails = (ResultFeatureDetails) obj;
                return Intrinsics.areEqual(this.year, resultFeatureDetails.year) && Intrinsics.areEqual(this.title, resultFeatureDetails.title) && Intrinsics.areEqual(this.movieName, resultFeatureDetails.movieName) && Intrinsics.areEqual(this.imdbId, resultFeatureDetails.imdbId) && Intrinsics.areEqual(this.tmdbId, resultFeatureDetails.tmdbId) && Intrinsics.areEqual(this.seasonNumber, resultFeatureDetails.seasonNumber) && Intrinsics.areEqual(this.episodeNumber, resultFeatureDetails.episodeNumber) && Intrinsics.areEqual(this.parentImdbId, resultFeatureDetails.parentImdbId) && Intrinsics.areEqual(this.parentTitle, resultFeatureDetails.parentTitle) && Intrinsics.areEqual(this.parentTmdbId, resultFeatureDetails.parentTmdbId) && Intrinsics.areEqual(this.parentFeatureId, resultFeatureDetails.parentFeatureId);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.year;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.movieName;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num2 = this.imdbId;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.tmdbId;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.seasonNumber;
            int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.episodeNumber;
            int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.parentImdbId;
            int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
            String str3 = this.parentTitle;
            int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num7 = this.parentTmdbId;
            int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.parentFeatureId;
            return hashCode10 + (num8 != null ? num8.hashCode() : 0);
        }

        public String toString() {
            return "ResultFeatureDetails(year=" + this.year + ", title=" + this.title + ", movieName=" + this.movieName + ", imdbId=" + this.imdbId + ", tmdbId=" + this.tmdbId + ", seasonNumber=" + this.seasonNumber + ", episodeNumber=" + this.episodeNumber + ", parentImdbId=" + this.parentImdbId + ", parentTitle=" + this.parentTitle + ", parentTmdbId=" + this.parentTmdbId + ", parentFeatureId=" + this.parentFeatureId + ')';
        }

        public ResultFeatureDetails(@JsonProperty("year") Integer num, @JsonProperty("title") String str, @JsonProperty("movie_name") String str2, @JsonProperty("imdb_id") Integer num2, @JsonProperty("tmdb_id") Integer num3, @JsonProperty("season_number") Integer num4, @JsonProperty("episode_number") Integer num5, @JsonProperty("parent_imdb_id") Integer num6, @JsonProperty("parent_title") String str3, @JsonProperty("parent_tmdb_id") Integer num7, @JsonProperty("parent_feature_id") Integer num8) {
            this.year = num;
            this.title = str;
            this.movieName = str2;
            this.imdbId = num2;
            this.tmdbId = num3;
            this.seasonNumber = num4;
            this.episodeNumber = num5;
            this.parentImdbId = num6;
            this.parentTitle = str3;
            this.parentTmdbId = num7;
            this.parentFeatureId = num8;
        }

        public /* synthetic */ ResultFeatureDetails(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str3, Integer num7, Integer num8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : num6, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num7, (i & 1024) == 0 ? num8 : null);
        }

        public final Integer getYear() {
            return this.year;
        }

        public final void setYear(Integer num) {
            this.year = num;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getMovieName() {
            return this.movieName;
        }

        public final void setMovieName(String str) {
            this.movieName = str;
        }

        public final Integer getImdbId() {
            return this.imdbId;
        }

        public final void setImdbId(Integer num) {
            this.imdbId = num;
        }

        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        public final void setTmdbId(Integer num) {
            this.tmdbId = num;
        }

        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        public final void setSeasonNumber(Integer num) {
            this.seasonNumber = num;
        }

        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        public final void setEpisodeNumber(Integer num) {
            this.episodeNumber = num;
        }

        public final Integer getParentImdbId() {
            return this.parentImdbId;
        }

        public final void setParentImdbId(Integer num) {
            this.parentImdbId = num;
        }

        public final String getParentTitle() {
            return this.parentTitle;
        }

        public final void setParentTitle(String str) {
            this.parentTitle = str;
        }

        public final Integer getParentTmdbId() {
            return this.parentTmdbId;
        }

        public final void setParentTmdbId(Integer num) {
            this.parentTmdbId = num;
        }

        public final Integer getParentFeatureId() {
            return this.parentFeatureId;
        }

        public final void setParentFeatureId(Integer num) {
            this.parentFeatureId = num;
        }
    }
}
