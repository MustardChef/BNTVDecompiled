package com.lagradost.cloudstream3.syncproviders;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import com.lagradost.cloudstream3.syncproviders.providers.MALApi;
import com.lagradost.cloudstream3.syncproviders.providers.NginxApi;
import com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountManager.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0013H\u0004J\b\u0010\u0019\u001a\u00020\u0013H\u0004J\b\u0010\u001a\u001a\u00020\u0013H\u0004J\b\u0010\u001b\u001a\u00020\u0013H\u0004R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI;", "defIndex", "", "(I)V", "accountActiveKey", "", "getAccountActiveKey", "()Ljava/lang/String;", "accountId", "getAccountId", "accountIndex", "getAccountIndex", "()I", "setAccountIndex", "accountsKey", "getAccountsKey", "lastAccountIndex", "changeAccount", "", FirebaseAnalytics.Param.INDEX, "getAccounts", "", "init", "registerAccount", "removeAccountKeys", "switchToNewAccount", "switchToOldAccount", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public abstract class AccountManager implements AuthAPI {
    public static final String appString = "cloudstreamapp";
    public static final int maxStale = 600;
    private int accountIndex;
    private final int defIndex;
    private int lastAccountIndex;
    public static final Companion Companion = new Companion(null);
    private static final MALApi malApi = new MALApi(0);
    private static final AniListApi aniListApi = new AniListApi(0);
    private static final OpenSubtitlesApi openSubtitlesApi = new OpenSubtitlesApi(0);
    private static final NginxApi nginxApi = new NginxApi(0);

    /* compiled from: AccountManager.kt */
    @Metadata(m108d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00048F¢\u0006\u0006\u001a\u0004\b&\u0010\u0007R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u00060"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/AccountManager$Companion;", "", "()V", "OAuth2Apis", "", "Lcom/lagradost/cloudstream3/syncproviders/OAuth2API;", "getOAuth2Apis", "()Ljava/util/List;", "SyncApis", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "getSyncApis", "accountManagers", "Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "getAccountManagers", "aniListApi", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi;", "getAniListApi", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi;", "appString", "", "inAppAuths", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPIManager;", "getInAppAuths", "malApi", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi;", "getMalApi", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi;", "maxStale", "", "nginxApi", "Lcom/lagradost/cloudstream3/syncproviders/providers/NginxApi;", "getNginxApi", "()Lcom/lagradost/cloudstream3/syncproviders/providers/NginxApi;", "openSubtitlesApi", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi;", "getOpenSubtitlesApi", "()Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi;", "subtitleProviders", "getSubtitleProviders", "unixTime", "", "getUnixTime", "()J", "unixTimeMs", "getUnixTimeMs", "secondsToReadable", "seconds", "completedValue", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MALApi getMalApi() {
            return AccountManager.malApi;
        }

        public final AniListApi getAniListApi() {
            return AccountManager.aniListApi;
        }

        public final OpenSubtitlesApi getOpenSubtitlesApi() {
            return AccountManager.openSubtitlesApi;
        }

        public final NginxApi getNginxApi() {
            return AccountManager.nginxApi;
        }

        public final List<OAuth2API> getOAuth2Apis() {
            return CollectionsKt.listOf((Object[]) new OAuth2API[]{getMalApi(), getAniListApi()});
        }

        public final List<AccountManager> getAccountManagers() {
            return CollectionsKt.listOf((Object[]) new AccountManager[]{getMalApi(), getAniListApi(), getOpenSubtitlesApi(), getNginxApi()});
        }

        public final List<SyncRepo> getSyncApis() {
            return CollectionsKt.listOf((Object[]) new SyncRepo[]{new SyncRepo(getMalApi()), new SyncRepo(getAniListApi())});
        }

        public final List<InAppAuthAPIManager> getInAppAuths() {
            return CollectionsKt.listOf((Object[]) new InAppAuthAPIManager[]{getOpenSubtitlesApi(), getNginxApi()});
        }

        public final List<OpenSubtitlesApi> getSubtitleProviders() {
            return CollectionsKt.listOf(getOpenSubtitlesApi());
        }

        public final long getUnixTime() {
            return System.currentTimeMillis() / 1000;
        }

        public final long getUnixTimeMs() {
            return System.currentTimeMillis();
        }

        public final String secondsToReadable(int i, String completedValue) {
            String str;
            Intrinsics.checkNotNullParameter(completedValue, "completedValue");
            long j = i;
            long days = TimeUnit.SECONDS.toDays(j);
            long seconds = j - TimeUnit.DAYS.toSeconds(days);
            long hours = TimeUnit.SECONDS.toHours(seconds);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds - TimeUnit.HOURS.toSeconds(hours));
            TimeUnit.MINUTES.toSeconds(minutes);
            if (minutes < 0) {
                return completedValue;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            if (days != 0) {
                str = days + "d ";
            } else {
                str = "";
            }
            sb.append(str);
            if (hours != 0) {
                str2 = hours + "h ";
            }
            sb.append(str2);
            sb.append(minutes);
            sb.append('m');
            return sb.toString();
        }
    }

    public AccountManager(int i) {
        this.defIndex = i;
        this.accountIndex = i;
        this.lastAccountIndex = i;
    }

    public final int getAccountIndex() {
        return this.accountIndex;
    }

    public final void setAccountIndex(int i) {
        this.accountIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getAccountId() {
        return getIdPrefix() + "_account_" + this.accountIndex;
    }

    private final String getAccountActiveKey() {
        return getIdPrefix() + "_active";
    }

    private final String getAccountsKey() {
        return getIdPrefix() + "_accounts";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void removeAccountKeys() {
        ArrayList arrayList;
        AcraApplication.Companion.removeKeys(getAccountId());
        int[] accounts = getAccounts();
        if (accounts == null || (arrayList = ArraysKt.toMutableList(accounts)) == null) {
            arrayList = new ArrayList();
        }
        arrayList.remove(Integer.valueOf(this.accountIndex));
        AcraApplication.Companion.setKey(getAccountsKey(), CollectionsKt.toIntArray(arrayList));
        init();
    }

    public final int[] getAccounts() {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountsKey = getAccountsKey();
        Object obj = new int[0];
        Context context = companion.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(accountsKey, null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    obj = dataStore.getMapper().readValue(string, int[].class);
                    Intrinsics.checkNotNullExpressionValue(obj, "mapper.readValue(this, T::class.java)");
                }
            } catch (Exception unused) {
            }
            return (int[]) obj;
        }
        obj = null;
        return (int[]) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r5 = this;
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = r5.getAccountActiveKey()
            int r2 = r5.defIndex
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            android.content.Context r0 = r0.getContext()
            r3 = 0
            if (r0 == 0) goto L35
            com.lagradost.cloudstream3.utils.DataStore r4 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            android.content.SharedPreferences r0 = r4.getSharedPrefs(r0)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r0.getString(r1, r3)     // Catch: java.lang.Exception -> L35
            if (r0 != 0) goto L20
            goto L36
        L20:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L35
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r4.getMapper()     // Catch: java.lang.Exception -> L35
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            java.lang.Object r2 = r1.readValue(r0, r2)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch: java.lang.Exception -> L35
            goto L36
        L35:
            r2 = r3
        L36:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r0 = r2.intValue()
            r5.accountIndex = r0
            int[] r0 = r5.getAccounts()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L53
            int r3 = r0.length
            if (r3 != 0) goto L4e
            r3 = 1
            goto L4f
        L4e:
            r3 = 0
        L4f:
            r3 = r3 ^ r2
            if (r3 != r2) goto L53
            r1 = 1
        L53:
            if (r1 == 0) goto L61
            com.lagradost.cloudstream3.syncproviders.AuthAPI$LoginInfo r1 = r5.loginInfo()
            if (r1 != 0) goto L61
            int r0 = kotlin.collections.ArraysKt.first(r0)
            r5.accountIndex = r0
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.AccountManager.init():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void switchToNewAccount() {
        Integer maxOrNull;
        int[] accounts = getAccounts();
        this.lastAccountIndex = this.accountIndex;
        this.accountIndex = ((accounts == null || (maxOrNull = ArraysKt.maxOrNull(accounts)) == null) ? 0 : maxOrNull.intValue()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void switchToOldAccount() {
        this.accountIndex = this.lastAccountIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void registerAccount() {
        ArrayList arrayList;
        AcraApplication.Companion.setKey(getAccountActiveKey(), Integer.valueOf(this.accountIndex));
        int[] accounts = getAccounts();
        if (accounts == null || (arrayList = ArraysKt.toMutableList(accounts)) == null) {
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(Integer.valueOf(this.accountIndex))) {
            arrayList.add(Integer.valueOf(this.accountIndex));
        }
        AcraApplication.Companion.setKey(getAccountsKey(), CollectionsKt.toIntArray(arrayList));
    }

    public final void changeAccount(int i) {
        this.accountIndex = i;
        AcraApplication.Companion.setKey(getAccountActiveKey(), Integer.valueOf(i));
    }
}
