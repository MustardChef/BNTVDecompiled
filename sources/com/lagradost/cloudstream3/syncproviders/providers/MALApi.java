package com.lagradost.cloudstream3.syncproviders.providers;

import android.content.Context;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.bongngotv2.R;
import com.facebook.AccessToken;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.utils.DataStore;
import com.uwetrottmann.tmdb2.TmdbHelper;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: MALApi.kt */
@Metadata(m108d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u001fcdefghijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020'H\u0016J\u0011\u0010(\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bJ\u0010\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u0004H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u000bH\u0002J\u001b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0016J\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0015\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0002¢\u0006\u0002\u0010=J\u001d\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u00106J\u0019\u0010A\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)J\u001d\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020#H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u001b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u00105\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u001b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00105\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0019\u0010K\u001a\u00020#2\u0006\u00108\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010HJ\b\u0010L\u001a\u00020'H\u0016J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0019\u0010O\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010QJ\u0011\u0010R\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J!\u0010S\u001a\u00020#2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020JH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001f\u0010V\u001a\b\u0012\u0004\u0012\u00020X0W2\u0006\u0010\u001c\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0011\u0010Y\u001a\u00020'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)J=\u0010Z\u001a\u00020#2\u0006\u00105\u001a\u00020\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\\J?\u0010Z\u001a\u0004\u0018\u00010\u000b2\u0006\u00105\u001a\u00020\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010]J\u0010\u0010^\u001a\u00020'2\u0006\u0010_\u001a\u00020\u000bH\u0002J\u0014\u0010`\u001a\u0004\u0018\u00010X2\b\u0010a\u001a\u0004\u0018\u00010bH\u0002R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u000e\u0010!\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0081\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi;", "Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI;", FirebaseAnalytics.Param.INDEX, "", "(I)V", "allTitles", "Ljava/util/HashMap;", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalTitleHolder;", "Lkotlin/collections/HashMap;", "codeVerifier", "", "createAccountUrl", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", SDKConstants.PARAM_KEY, "getKey", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "name", "getName", "setName", "redirectUrl", "getRedirectUrl", "requestId", "requiresLogin", "", "getRequiresLogin", "()Z", "authenticate", "", "checkMalToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertJapanTimeToTimeRemaining", "date", "endDate", "convertToStatus", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatusType;", TypedValues.Custom.S_STRING, "fromIntToAnimeStatus", "inp", "getAuth", "getDataAboutMalId", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$SmallMalAnime;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdFromUrl", "url", "getMalAnimeList", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Data;", "getMalAnimeListCached", "()[Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Data;", "getMalAnimeListSlice", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalList;", TypedValues.CycleType.S_WAVE_OFFSET, "getMalAnimeListSmart", "getMalUser", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalUser;", "setSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResult", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "handleRedirect", "logOut", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "parseDate", "", "(Ljava/lang/String;)Ljava/lang/Long;", "refreshToken", "score", "status", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "setAllMalData", "setScoreRequest", "num_watched_episodes", "(ILcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatusType;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeToken", "response", "toSearchResult", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "AlternativeTitles", "Broadcast", "Companion", "Data", "Genres", "ListStatus", "MainPicture", "MalAnime", "MalDatum", "MalList", "MalMainPicture", "MalNode", "MalRoot", "MalSearch", "MalSearchNode", "MalStatus", "MalStatusType", "MalTitleHolder", "MalUser", "MyListStatus", "Node", "Paging", "Recommendations", "RelatedAnime", "ResponseToken", "SmallMalAnime", "StartSeason", "Statistics", "Status", "Studios", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MALApi extends AccountManager implements SyncAPI {
    public static final String MAL_CACHED_LIST = "mal_cached_list";
    public static final String MAL_REFRESH_TOKEN_KEY = "mal_refresh_token";
    public static final String MAL_SHOULD_UPDATE_LIST = "mal_should_update_list";
    public static final String MAL_TOKEN_KEY = "mal_token";
    public static final String MAL_UNIXTIME_KEY = "mal_unixtime";
    public static final String MAL_USER_KEY = "mal_user";
    private final HashMap<Integer, MalTitleHolder> allTitles;
    private String codeVerifier;
    private final String createAccountUrl;
    private final int icon;
    private final String idPrefix;
    private final String key;
    private String mainUrl;
    private final JsonMapper mapper;
    private String name;
    private final String redirectUrl;
    private int requestId;
    private final boolean requiresLogin;
    public static final Companion Companion = new Companion(null);
    private static final String[] malStatusAsString = {"watching", "completed", "on_hold", "dropped", "plan_to_watch"};

    public MALApi(int i) {
        super(i);
        this.name = "MAL";
        this.key = "1714d6f2f4f7cc19644384f8c4629910";
        this.redirectUrl = "mallogin";
        this.idPrefix = "mal";
        this.mainUrl = "https://myanimelist.net";
        this.icon = R.drawable.mal_logo;
        this.requiresLogin = true;
        this.createAccountUrl = getMainUrl() + "/register.php";
        JsonMapper build = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
        Intrinsics.checkNotNull(build);
        this.mapper = build;
        this.codeVerifier = "";
        this.allTitles = new HashMap<>();
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public String getKey() {
        return this.key;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getIdPrefix() {
        return this.idPrefix;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public Integer getIcon() {
        return Integer.valueOf(this.icon);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public boolean getRequiresLogin() {
        return this.requiresLogin;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getCreateAccountUrl() {
        return this.createAccountUrl;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        removeAccountKeys();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[RETURN] */
    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.lagradost.cloudstream3.syncproviders.AuthAPI.LoginInfo loginInfo() {
        /*
            r5 = this;
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = r5.getAccountId()
            android.content.Context r0 = r0.getContext()
            r2 = 0
            if (r0 == 0) goto L35
            com.lagradost.cloudstream3.utils.DataStore r3 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r4 = "mal_user"
            java.lang.String r1 = r3.getFolderName(r1, r4)
            android.content.SharedPreferences r0 = r3.getSharedPrefs(r0)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Exception -> L35
            if (r0 != 0) goto L20
            goto L35
        L20:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L35
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r3.getMapper()     // Catch: java.lang.Exception -> L35
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalUser> r3 = com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalUser.class
            java.lang.Object r0 = r1.readValue(r0, r3)     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L35
            goto L36
        L35:
            r0 = r2
        L36:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalUser r0 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalUser) r0
            if (r0 == 0) goto L4c
            com.lagradost.cloudstream3.syncproviders.AuthAPI$LoginInfo r1 = new com.lagradost.cloudstream3.syncproviders.AuthAPI$LoginInfo
            java.lang.String r2 = r0.getPicture()
            java.lang.String r0 = r0.getName()
            int r3 = r5.getAccountIndex()
            r1.<init>(r2, r0, r3)
            return r1
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.loginInfo():com.lagradost.cloudstream3.syncproviders.AuthAPI$LoginInfo");
    }

    private final String getAuth() {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountId = getAccountId();
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(accountId, MAL_TOKEN_KEY), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, String.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (String) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncSearchResult>> r23) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    public String getIdFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        MatchResult find$default = Regex.find$default(new Regex("/anime/((.*)/|(.*))"), url, 0, 2, null);
        Intrinsics.checkNotNull(find$default);
        return (String) CollectionsKt.first((List<? extends Object>) find$default.getGroupValues());
    }

    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    public Object score(String str, SyncAPI.SyncStatus syncStatus, Continuation<? super Boolean> continuation) {
        Integer intOrNull = StringsKt.toIntOrNull(str);
        if (intOrNull != null) {
            return setScoreRequest(intOrNull.intValue(), fromIntToAnimeStatus(syncStatus.getStatus()), syncStatus.getScore(), syncStatus.getWatchedEpisodes(), continuation);
        }
        return boxing.boxBoolean(false);
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0003\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0019\u0012\u0010\b\u0001\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019\u0012\u0010\b\u0001\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0019\u0012\u0010\b\u0001\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0019\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010/¢\u0006\u0002\u00100J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010j\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0019HÆ\u0003J\u0011\u0010r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010t\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0019HÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0019HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010/HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00104J²\u0003\u0010}\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00192\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00192\u0010\b\u0003\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00192\u0010\b\u0003\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00192\u0010\b\u0003\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00192\n\b\u0003\u0010.\u001a\u0004\u0018\u00010/HÆ\u0001¢\u0006\u0002\u0010~J\u0015\u0010\u007f\u001a\u00030\u0080\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u00107R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\b>\u00104R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u00107R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bH\u00104R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bI\u00104R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bJ\u00104R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bL\u00104R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00105\u001a\u0004\bM\u00104R\u0013\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u00107R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bO\u0010=R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bP\u0010=R\u0019\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010=R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u00107R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bS\u00107R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bX\u00107R\u0019\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bY\u0010=R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bZ\u00107R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u00107R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\\\u00107¨\u0006\u0084\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalAnime;", "", "id", "", "title", "", "mainPicture", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;", "alternativeTitles", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;", "startDate", "endDate", "synopsis", "mean", "", "rank", "popularity", "numListUsers", "numScoringUsers", "nsfw", "createdAt", "updatedAt", "mediaType", "status", "genres", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Genres;", "myListStatus", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;", "numEpisodes", "startSeason", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;", "broadcast", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;", "source", "averageEpisodeDuration", "rating", "pictures", "background", "relatedAnime", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$RelatedAnime;", "relatedManga", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Recommendations;", "studios", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Studios;", "statistics", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;)V", "getAlternativeTitles", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;", "getAverageEpisodeDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackground", "()Ljava/lang/String;", "getBroadcast", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;", "getCreatedAt", "getEndDate", "getGenres", "()Ljava/util/ArrayList;", "getId", "getMainPicture", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;", "getMean", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMediaType", "getMyListStatus", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;", "getNsfw", "getNumEpisodes", "getNumListUsers", "getNumScoringUsers", "getPictures", "getPopularity", "getRank", "getRating", "getRecommendations", "getRelatedAnime", "getRelatedManga", "getSource", "getStartDate", "getStartSeason", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;", "getStatistics", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;", "getStatus", "getStudios", "getSynopsis", "getTitle", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalAnime;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalAnime {
        private final AlternativeTitles alternativeTitles;
        private final Integer averageEpisodeDuration;
        private final String background;
        private final Broadcast broadcast;
        private final String createdAt;
        private final String endDate;
        private final ArrayList<Genres> genres;

        /* renamed from: id */
        private final Integer f10009id;
        private final MainPicture mainPicture;
        private final Double mean;
        private final String mediaType;
        private final MyListStatus myListStatus;
        private final String nsfw;
        private final Integer numEpisodes;
        private final Integer numListUsers;
        private final Integer numScoringUsers;
        private final ArrayList<MainPicture> pictures;
        private final Integer popularity;
        private final Integer rank;
        private final String rating;
        private final ArrayList<Recommendations> recommendations;
        private final ArrayList<RelatedAnime> relatedAnime;
        private final ArrayList<String> relatedManga;
        private final String source;
        private final String startDate;
        private final StartSeason startSeason;
        private final Statistics statistics;
        private final String status;
        private final ArrayList<Studios> studios;
        private final String synopsis;
        private final String title;
        private final String updatedAt;

        public final Integer component1() {
            return this.f10009id;
        }

        public final Integer component10() {
            return this.popularity;
        }

        public final Integer component11() {
            return this.numListUsers;
        }

        public final Integer component12() {
            return this.numScoringUsers;
        }

        public final String component13() {
            return this.nsfw;
        }

        public final String component14() {
            return this.createdAt;
        }

        public final String component15() {
            return this.updatedAt;
        }

        public final String component16() {
            return this.mediaType;
        }

        public final String component17() {
            return this.status;
        }

        public final ArrayList<Genres> component18() {
            return this.genres;
        }

        public final MyListStatus component19() {
            return this.myListStatus;
        }

        public final String component2() {
            return this.title;
        }

        public final Integer component20() {
            return this.numEpisodes;
        }

        public final StartSeason component21() {
            return this.startSeason;
        }

        public final Broadcast component22() {
            return this.broadcast;
        }

        public final String component23() {
            return this.source;
        }

        public final Integer component24() {
            return this.averageEpisodeDuration;
        }

        public final String component25() {
            return this.rating;
        }

        public final ArrayList<MainPicture> component26() {
            return this.pictures;
        }

        public final String component27() {
            return this.background;
        }

        public final ArrayList<RelatedAnime> component28() {
            return this.relatedAnime;
        }

        public final ArrayList<String> component29() {
            return this.relatedManga;
        }

        public final MainPicture component3() {
            return this.mainPicture;
        }

        public final ArrayList<Recommendations> component30() {
            return this.recommendations;
        }

        public final ArrayList<Studios> component31() {
            return this.studios;
        }

        public final Statistics component32() {
            return this.statistics;
        }

        public final AlternativeTitles component4() {
            return this.alternativeTitles;
        }

        public final String component5() {
            return this.startDate;
        }

        public final String component6() {
            return this.endDate;
        }

        public final String component7() {
            return this.synopsis;
        }

        public final Double component8() {
            return this.mean;
        }

        public final Integer component9() {
            return this.rank;
        }

        public final MalAnime copy(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("main_picture") MainPicture mainPicture, @JsonProperty("alternative_titles") AlternativeTitles alternativeTitles, @JsonProperty("start_date") String str2, @JsonProperty("end_date") String str3, @JsonProperty("synopsis") String str4, @JsonProperty("mean") Double d, @JsonProperty("rank") Integer num2, @JsonProperty("popularity") Integer num3, @JsonProperty("num_list_users") Integer num4, @JsonProperty("num_scoring_users") Integer num5, @JsonProperty("nsfw") String str5, @JsonProperty("created_at") String str6, @JsonProperty("updated_at") String str7, @JsonProperty("media_type") String str8, @JsonProperty("status") String str9, @JsonProperty("genres") ArrayList<Genres> arrayList, @JsonProperty("my_list_status") MyListStatus myListStatus, @JsonProperty("num_episodes") Integer num6, @JsonProperty("start_season") StartSeason startSeason, @JsonProperty("broadcast") Broadcast broadcast, @JsonProperty("source") String str10, @JsonProperty("average_episode_duration") Integer num7, @JsonProperty("rating") String str11, @JsonProperty("pictures") ArrayList<MainPicture> arrayList2, @JsonProperty("background") String str12, @JsonProperty("related_anime") ArrayList<RelatedAnime> arrayList3, @JsonProperty("related_manga") ArrayList<String> arrayList4, @JsonProperty("recommendations") ArrayList<Recommendations> arrayList5, @JsonProperty("studios") ArrayList<Studios> arrayList6, @JsonProperty("statistics") Statistics statistics) {
            return new MalAnime(num, str, mainPicture, alternativeTitles, str2, str3, str4, d, num2, num3, num4, num5, str5, str6, str7, str8, str9, arrayList, myListStatus, num6, startSeason, broadcast, str10, num7, str11, arrayList2, str12, arrayList3, arrayList4, arrayList5, arrayList6, statistics);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalAnime) {
                MalAnime malAnime = (MalAnime) obj;
                return Intrinsics.areEqual(this.f10009id, malAnime.f10009id) && Intrinsics.areEqual(this.title, malAnime.title) && Intrinsics.areEqual(this.mainPicture, malAnime.mainPicture) && Intrinsics.areEqual(this.alternativeTitles, malAnime.alternativeTitles) && Intrinsics.areEqual(this.startDate, malAnime.startDate) && Intrinsics.areEqual(this.endDate, malAnime.endDate) && Intrinsics.areEqual(this.synopsis, malAnime.synopsis) && Intrinsics.areEqual((Object) this.mean, (Object) malAnime.mean) && Intrinsics.areEqual(this.rank, malAnime.rank) && Intrinsics.areEqual(this.popularity, malAnime.popularity) && Intrinsics.areEqual(this.numListUsers, malAnime.numListUsers) && Intrinsics.areEqual(this.numScoringUsers, malAnime.numScoringUsers) && Intrinsics.areEqual(this.nsfw, malAnime.nsfw) && Intrinsics.areEqual(this.createdAt, malAnime.createdAt) && Intrinsics.areEqual(this.updatedAt, malAnime.updatedAt) && Intrinsics.areEqual(this.mediaType, malAnime.mediaType) && Intrinsics.areEqual(this.status, malAnime.status) && Intrinsics.areEqual(this.genres, malAnime.genres) && Intrinsics.areEqual(this.myListStatus, malAnime.myListStatus) && Intrinsics.areEqual(this.numEpisodes, malAnime.numEpisodes) && Intrinsics.areEqual(this.startSeason, malAnime.startSeason) && Intrinsics.areEqual(this.broadcast, malAnime.broadcast) && Intrinsics.areEqual(this.source, malAnime.source) && Intrinsics.areEqual(this.averageEpisodeDuration, malAnime.averageEpisodeDuration) && Intrinsics.areEqual(this.rating, malAnime.rating) && Intrinsics.areEqual(this.pictures, malAnime.pictures) && Intrinsics.areEqual(this.background, malAnime.background) && Intrinsics.areEqual(this.relatedAnime, malAnime.relatedAnime) && Intrinsics.areEqual(this.relatedManga, malAnime.relatedManga) && Intrinsics.areEqual(this.recommendations, malAnime.recommendations) && Intrinsics.areEqual(this.studios, malAnime.studios) && Intrinsics.areEqual(this.statistics, malAnime.statistics);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10009id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            MainPicture mainPicture = this.mainPicture;
            int hashCode3 = (hashCode2 + (mainPicture == null ? 0 : mainPicture.hashCode())) * 31;
            AlternativeTitles alternativeTitles = this.alternativeTitles;
            int hashCode4 = (hashCode3 + (alternativeTitles == null ? 0 : alternativeTitles.hashCode())) * 31;
            String str2 = this.startDate;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.endDate;
            int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.synopsis;
            int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Double d = this.mean;
            int hashCode8 = (hashCode7 + (d == null ? 0 : d.hashCode())) * 31;
            Integer num2 = this.rank;
            int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.popularity;
            int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.numListUsers;
            int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.numScoringUsers;
            int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
            String str5 = this.nsfw;
            int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.createdAt;
            int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.updatedAt;
            int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.mediaType;
            int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.status;
            int hashCode17 = (hashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
            ArrayList<Genres> arrayList = this.genres;
            int hashCode18 = (hashCode17 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
            MyListStatus myListStatus = this.myListStatus;
            int hashCode19 = (hashCode18 + (myListStatus == null ? 0 : myListStatus.hashCode())) * 31;
            Integer num6 = this.numEpisodes;
            int hashCode20 = (hashCode19 + (num6 == null ? 0 : num6.hashCode())) * 31;
            StartSeason startSeason = this.startSeason;
            int hashCode21 = (hashCode20 + (startSeason == null ? 0 : startSeason.hashCode())) * 31;
            Broadcast broadcast = this.broadcast;
            int hashCode22 = (hashCode21 + (broadcast == null ? 0 : broadcast.hashCode())) * 31;
            String str10 = this.source;
            int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Integer num7 = this.averageEpisodeDuration;
            int hashCode24 = (hashCode23 + (num7 == null ? 0 : num7.hashCode())) * 31;
            String str11 = this.rating;
            int hashCode25 = (hashCode24 + (str11 == null ? 0 : str11.hashCode())) * 31;
            ArrayList<MainPicture> arrayList2 = this.pictures;
            int hashCode26 = (hashCode25 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
            String str12 = this.background;
            int hashCode27 = (hashCode26 + (str12 == null ? 0 : str12.hashCode())) * 31;
            ArrayList<RelatedAnime> arrayList3 = this.relatedAnime;
            int hashCode28 = (hashCode27 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
            ArrayList<String> arrayList4 = this.relatedManga;
            int hashCode29 = (hashCode28 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
            ArrayList<Recommendations> arrayList5 = this.recommendations;
            int hashCode30 = (hashCode29 + (arrayList5 == null ? 0 : arrayList5.hashCode())) * 31;
            ArrayList<Studios> arrayList6 = this.studios;
            int hashCode31 = (hashCode30 + (arrayList6 == null ? 0 : arrayList6.hashCode())) * 31;
            Statistics statistics = this.statistics;
            return hashCode31 + (statistics != null ? statistics.hashCode() : 0);
        }

        public String toString() {
            return "MalAnime(id=" + this.f10009id + ", title=" + this.title + ", mainPicture=" + this.mainPicture + ", alternativeTitles=" + this.alternativeTitles + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", synopsis=" + this.synopsis + ", mean=" + this.mean + ", rank=" + this.rank + ", popularity=" + this.popularity + ", numListUsers=" + this.numListUsers + ", numScoringUsers=" + this.numScoringUsers + ", nsfw=" + this.nsfw + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", mediaType=" + this.mediaType + ", status=" + this.status + ", genres=" + this.genres + ", myListStatus=" + this.myListStatus + ", numEpisodes=" + this.numEpisodes + ", startSeason=" + this.startSeason + ", broadcast=" + this.broadcast + ", source=" + this.source + ", averageEpisodeDuration=" + this.averageEpisodeDuration + ", rating=" + this.rating + ", pictures=" + this.pictures + ", background=" + this.background + ", relatedAnime=" + this.relatedAnime + ", relatedManga=" + this.relatedManga + ", recommendations=" + this.recommendations + ", studios=" + this.studios + ", statistics=" + this.statistics + ')';
        }

        public MalAnime(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("main_picture") MainPicture mainPicture, @JsonProperty("alternative_titles") AlternativeTitles alternativeTitles, @JsonProperty("start_date") String str2, @JsonProperty("end_date") String str3, @JsonProperty("synopsis") String str4, @JsonProperty("mean") Double d, @JsonProperty("rank") Integer num2, @JsonProperty("popularity") Integer num3, @JsonProperty("num_list_users") Integer num4, @JsonProperty("num_scoring_users") Integer num5, @JsonProperty("nsfw") String str5, @JsonProperty("created_at") String str6, @JsonProperty("updated_at") String str7, @JsonProperty("media_type") String str8, @JsonProperty("status") String str9, @JsonProperty("genres") ArrayList<Genres> arrayList, @JsonProperty("my_list_status") MyListStatus myListStatus, @JsonProperty("num_episodes") Integer num6, @JsonProperty("start_season") StartSeason startSeason, @JsonProperty("broadcast") Broadcast broadcast, @JsonProperty("source") String str10, @JsonProperty("average_episode_duration") Integer num7, @JsonProperty("rating") String str11, @JsonProperty("pictures") ArrayList<MainPicture> arrayList2, @JsonProperty("background") String str12, @JsonProperty("related_anime") ArrayList<RelatedAnime> arrayList3, @JsonProperty("related_manga") ArrayList<String> arrayList4, @JsonProperty("recommendations") ArrayList<Recommendations> arrayList5, @JsonProperty("studios") ArrayList<Studios> arrayList6, @JsonProperty("statistics") Statistics statistics) {
            this.f10009id = num;
            this.title = str;
            this.mainPicture = mainPicture;
            this.alternativeTitles = alternativeTitles;
            this.startDate = str2;
            this.endDate = str3;
            this.synopsis = str4;
            this.mean = d;
            this.rank = num2;
            this.popularity = num3;
            this.numListUsers = num4;
            this.numScoringUsers = num5;
            this.nsfw = str5;
            this.createdAt = str6;
            this.updatedAt = str7;
            this.mediaType = str8;
            this.status = str9;
            this.genres = arrayList;
            this.myListStatus = myListStatus;
            this.numEpisodes = num6;
            this.startSeason = startSeason;
            this.broadcast = broadcast;
            this.source = str10;
            this.averageEpisodeDuration = num7;
            this.rating = str11;
            this.pictures = arrayList2;
            this.background = str12;
            this.relatedAnime = arrayList3;
            this.relatedManga = arrayList4;
            this.recommendations = arrayList5;
            this.studios = arrayList6;
            this.statistics = statistics;
        }

        public final Integer getId() {
            return this.f10009id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final MainPicture getMainPicture() {
            return this.mainPicture;
        }

        public final AlternativeTitles getAlternativeTitles() {
            return this.alternativeTitles;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final String getSynopsis() {
            return this.synopsis;
        }

        public final Double getMean() {
            return this.mean;
        }

        public final Integer getRank() {
            return this.rank;
        }

        public final Integer getPopularity() {
            return this.popularity;
        }

        public final Integer getNumListUsers() {
            return this.numListUsers;
        }

        public final Integer getNumScoringUsers() {
            return this.numScoringUsers;
        }

        public final String getNsfw() {
            return this.nsfw;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getMediaType() {
            return this.mediaType;
        }

        public final String getStatus() {
            return this.status;
        }

        public final ArrayList<Genres> getGenres() {
            return this.genres;
        }

        public final MyListStatus getMyListStatus() {
            return this.myListStatus;
        }

        public final Integer getNumEpisodes() {
            return this.numEpisodes;
        }

        public final StartSeason getStartSeason() {
            return this.startSeason;
        }

        public final Broadcast getBroadcast() {
            return this.broadcast;
        }

        public final String getSource() {
            return this.source;
        }

        public final Integer getAverageEpisodeDuration() {
            return this.averageEpisodeDuration;
        }

        public final String getRating() {
            return this.rating;
        }

        public final ArrayList<MainPicture> getPictures() {
            return this.pictures;
        }

        public final String getBackground() {
            return this.background;
        }

        public final ArrayList<RelatedAnime> getRelatedAnime() {
            return this.relatedAnime;
        }

        public final ArrayList<String> getRelatedManga() {
            return this.relatedManga;
        }

        public final ArrayList<Recommendations> getRecommendations() {
            return this.recommendations;
        }

        public final ArrayList<Studios> getStudios() {
            return this.studios;
        }

        public final Statistics getStatistics() {
            return this.statistics;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Recommendations;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "numRecommendations", "", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;Ljava/lang/Integer;)V", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "getNumRecommendations", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Recommendations;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Recommendations {
        private final Node node;
        private final Integer numRecommendations;

        public Recommendations() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Recommendations copy$default(Recommendations recommendations, Node node, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                node = recommendations.node;
            }
            if ((i & 2) != 0) {
                num = recommendations.numRecommendations;
            }
            return recommendations.copy(node, num);
        }

        public final Node component1() {
            return this.node;
        }

        public final Integer component2() {
            return this.numRecommendations;
        }

        public final Recommendations copy(@JsonProperty("node") Node node, @JsonProperty("num_recommendations") Integer num) {
            return new Recommendations(node, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Recommendations) {
                Recommendations recommendations = (Recommendations) obj;
                return Intrinsics.areEqual(this.node, recommendations.node) && Intrinsics.areEqual(this.numRecommendations, recommendations.numRecommendations);
            }
            return false;
        }

        public int hashCode() {
            Node node = this.node;
            int hashCode = (node == null ? 0 : node.hashCode()) * 31;
            Integer num = this.numRecommendations;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Recommendations(node=" + this.node + ", numRecommendations=" + this.numRecommendations + ')';
        }

        public Recommendations(@JsonProperty("node") Node node, @JsonProperty("num_recommendations") Integer num) {
            this.node = node;
            this.numRecommendations = num;
        }

        public /* synthetic */ Recommendations(Node node, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : node, (i & 2) != 0 ? null : num);
        }

        public final Node getNode() {
            return this.node;
        }

        public final Integer getNumRecommendations() {
            return this.numRecommendations;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Studios;", "", "id", "", "name", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Studios;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Studios {

        /* renamed from: id */
        private final Integer f10015id;
        private final String name;

        public Studios() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Studios copy$default(Studios studios, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = studios.f10015id;
            }
            if ((i & 2) != 0) {
                str = studios.name;
            }
            return studios.copy(num, str);
        }

        public final Integer component1() {
            return this.f10015id;
        }

        public final String component2() {
            return this.name;
        }

        public final Studios copy(@JsonProperty("id") Integer num, @JsonProperty("name") String str) {
            return new Studios(num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Studios) {
                Studios studios = (Studios) obj;
                return Intrinsics.areEqual(this.f10015id, studios.f10015id) && Intrinsics.areEqual(this.name, studios.name);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10015id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.name;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Studios(id=" + this.f10015id + ", name=" + this.name + ')';
        }

        public Studios(@JsonProperty("id") Integer num, @JsonProperty("name") String str) {
            this.f10015id = num;
            this.name = str;
        }

        public /* synthetic */ Studios(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        public final Integer getId() {
            return this.f10015id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;", "", "status", "", "score", "", "numEpisodesWatched", "isRewatching", "", "updatedAt", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNumEpisodesWatched", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScore", "getStatus", "()Ljava/lang/String;", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MyListStatus;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MyListStatus {
        private final Boolean isRewatching;
        private final Integer numEpisodesWatched;
        private final Integer score;
        private final String status;
        private final String updatedAt;

        public MyListStatus() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ MyListStatus copy$default(MyListStatus myListStatus, String str, Integer num, Integer num2, Boolean bool, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = myListStatus.status;
            }
            if ((i & 2) != 0) {
                num = myListStatus.score;
            }
            Integer num3 = num;
            if ((i & 4) != 0) {
                num2 = myListStatus.numEpisodesWatched;
            }
            Integer num4 = num2;
            if ((i & 8) != 0) {
                bool = myListStatus.isRewatching;
            }
            Boolean bool2 = bool;
            if ((i & 16) != 0) {
                str2 = myListStatus.updatedAt;
            }
            return myListStatus.copy(str, num3, num4, bool2, str2);
        }

        public final String component1() {
            return this.status;
        }

        public final Integer component2() {
            return this.score;
        }

        public final Integer component3() {
            return this.numEpisodesWatched;
        }

        public final Boolean component4() {
            return this.isRewatching;
        }

        public final String component5() {
            return this.updatedAt;
        }

        public final MyListStatus copy(@JsonProperty("status") String str, @JsonProperty("score") Integer num, @JsonProperty("num_episodes_watched") Integer num2, @JsonProperty("is_rewatching") Boolean bool, @JsonProperty("updated_at") String str2) {
            return new MyListStatus(str, num, num2, bool, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MyListStatus) {
                MyListStatus myListStatus = (MyListStatus) obj;
                return Intrinsics.areEqual(this.status, myListStatus.status) && Intrinsics.areEqual(this.score, myListStatus.score) && Intrinsics.areEqual(this.numEpisodesWatched, myListStatus.numEpisodesWatched) && Intrinsics.areEqual(this.isRewatching, myListStatus.isRewatching) && Intrinsics.areEqual(this.updatedAt, myListStatus.updatedAt);
            }
            return false;
        }

        public int hashCode() {
            String str = this.status;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.score;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.numEpisodesWatched;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Boolean bool = this.isRewatching;
            int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.updatedAt;
            return hashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "MyListStatus(status=" + this.status + ", score=" + this.score + ", numEpisodesWatched=" + this.numEpisodesWatched + ", isRewatching=" + this.isRewatching + ", updatedAt=" + this.updatedAt + ')';
        }

        public MyListStatus(@JsonProperty("status") String str, @JsonProperty("score") Integer num, @JsonProperty("num_episodes_watched") Integer num2, @JsonProperty("is_rewatching") Boolean bool, @JsonProperty("updated_at") String str2) {
            this.status = str;
            this.score = num;
            this.numEpisodesWatched = num2;
            this.isRewatching = bool;
            this.updatedAt = str2;
        }

        public /* synthetic */ MyListStatus(String str, Integer num, Integer num2, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str2);
        }

        public final String getStatus() {
            return this.status;
        }

        public final Integer getScore() {
            return this.score;
        }

        public final Integer getNumEpisodesWatched() {
            return this.numEpisodesWatched;
        }

        public final Boolean isRewatching() {
            return this.isRewatching;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$RelatedAnime;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "relationType", "", "relationTypeFormatted", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;Ljava/lang/String;Ljava/lang/String;)V", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "getRelationType", "()Ljava/lang/String;", "getRelationTypeFormatted", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RelatedAnime {
        private final Node node;
        private final String relationType;
        private final String relationTypeFormatted;

        public RelatedAnime() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ RelatedAnime copy$default(RelatedAnime relatedAnime, Node node, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                node = relatedAnime.node;
            }
            if ((i & 2) != 0) {
                str = relatedAnime.relationType;
            }
            if ((i & 4) != 0) {
                str2 = relatedAnime.relationTypeFormatted;
            }
            return relatedAnime.copy(node, str, str2);
        }

        public final Node component1() {
            return this.node;
        }

        public final String component2() {
            return this.relationType;
        }

        public final String component3() {
            return this.relationTypeFormatted;
        }

        public final RelatedAnime copy(@JsonProperty("node") Node node, @JsonProperty("relation_type") String str, @JsonProperty("relation_type_formatted") String str2) {
            return new RelatedAnime(node, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RelatedAnime) {
                RelatedAnime relatedAnime = (RelatedAnime) obj;
                return Intrinsics.areEqual(this.node, relatedAnime.node) && Intrinsics.areEqual(this.relationType, relatedAnime.relationType) && Intrinsics.areEqual(this.relationTypeFormatted, relatedAnime.relationTypeFormatted);
            }
            return false;
        }

        public int hashCode() {
            Node node = this.node;
            int hashCode = (node == null ? 0 : node.hashCode()) * 31;
            String str = this.relationType;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.relationTypeFormatted;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "RelatedAnime(node=" + this.node + ", relationType=" + this.relationType + ", relationTypeFormatted=" + this.relationTypeFormatted + ')';
        }

        public RelatedAnime(@JsonProperty("node") Node node, @JsonProperty("relation_type") String str, @JsonProperty("relation_type_formatted") String str2) {
            this.node = node;
            this.relationType = str;
            this.relationTypeFormatted = str2;
        }

        public /* synthetic */ RelatedAnime(Node node, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : node, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        public final Node getNode() {
            return this.node;
        }

        public final String getRelationType() {
            return this.relationType;
        }

        public final String getRelationTypeFormatted() {
            return this.relationTypeFormatted;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Status;", "", "watching", "", "completed", "onHold", "dropped", "planToWatch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCompleted", "()Ljava/lang/String;", "getDropped", "getOnHold", "getPlanToWatch", "getWatching", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Status {
        private final String completed;
        private final String dropped;
        private final String onHold;
        private final String planToWatch;
        private final String watching;

        public Status() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Status copy$default(Status status, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = status.watching;
            }
            if ((i & 2) != 0) {
                str2 = status.completed;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = status.onHold;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = status.dropped;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = status.planToWatch;
            }
            return status.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.watching;
        }

        public final String component2() {
            return this.completed;
        }

        public final String component3() {
            return this.onHold;
        }

        public final String component4() {
            return this.dropped;
        }

        public final String component5() {
            return this.planToWatch;
        }

        public final Status copy(@JsonProperty("watching") String str, @JsonProperty("completed") String str2, @JsonProperty("on_hold") String str3, @JsonProperty("dropped") String str4, @JsonProperty("plan_to_watch") String str5) {
            return new Status(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Status) {
                Status status = (Status) obj;
                return Intrinsics.areEqual(this.watching, status.watching) && Intrinsics.areEqual(this.completed, status.completed) && Intrinsics.areEqual(this.onHold, status.onHold) && Intrinsics.areEqual(this.dropped, status.dropped) && Intrinsics.areEqual(this.planToWatch, status.planToWatch);
            }
            return false;
        }

        public int hashCode() {
            String str = this.watching;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.completed;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.onHold;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.dropped;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.planToWatch;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Status(watching=" + this.watching + ", completed=" + this.completed + ", onHold=" + this.onHold + ", dropped=" + this.dropped + ", planToWatch=" + this.planToWatch + ')';
        }

        public Status(@JsonProperty("watching") String str, @JsonProperty("completed") String str2, @JsonProperty("on_hold") String str3, @JsonProperty("dropped") String str4, @JsonProperty("plan_to_watch") String str5) {
            this.watching = str;
            this.completed = str2;
            this.onHold = str3;
            this.dropped = str4;
            this.planToWatch = str5;
        }

        public /* synthetic */ Status(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
        }

        public final String getWatching() {
            return this.watching;
        }

        public final String getCompleted() {
            return this.completed;
        }

        public final String getOnHold() {
            return this.onHold;
        }

        public final String getDropped() {
            return this.dropped;
        }

        public final String getPlanToWatch() {
            return this.planToWatch;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;", "", "status", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Status;", "numListUsers", "", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Status;Ljava/lang/Integer;)V", "getNumListUsers", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Status;", "component1", "component2", "copy", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Status;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Statistics;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Statistics {
        private final Integer numListUsers;
        private final Status status;

        public Statistics() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ Statistics copy$default(Statistics statistics, Status status, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                status = statistics.status;
            }
            if ((i & 2) != 0) {
                num = statistics.numListUsers;
            }
            return statistics.copy(status, num);
        }

        public final Status component1() {
            return this.status;
        }

        public final Integer component2() {
            return this.numListUsers;
        }

        public final Statistics copy(@JsonProperty("status") Status status, @JsonProperty("num_list_users") Integer num) {
            return new Statistics(status, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Statistics) {
                Statistics statistics = (Statistics) obj;
                return Intrinsics.areEqual(this.status, statistics.status) && Intrinsics.areEqual(this.numListUsers, statistics.numListUsers);
            }
            return false;
        }

        public int hashCode() {
            Status status = this.status;
            int hashCode = (status == null ? 0 : status.hashCode()) * 31;
            Integer num = this.numListUsers;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Statistics(status=" + this.status + ", numListUsers=" + this.numListUsers + ')';
        }

        public Statistics(@JsonProperty("status") Status status, @JsonProperty("num_list_users") Integer num) {
            this.status = status;
            this.numListUsers = num;
        }

        public /* synthetic */ Statistics(Status status, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : status, (i & 2) != 0 ? null : num);
        }

        public final Status getStatus() {
            return this.status;
        }

        public final Integer getNumListUsers() {
            return this.numListUsers;
        }
    }

    private final Long parseDate(String str) {
        Date parse;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TmdbHelper.TMDB_DATE_PATTERN);
            if (str == null || (parse = simpleDateFormat.parse(str)) == null) {
                return null;
            }
            return Long.valueOf(parse.getTime());
        } catch (Exception unused) {
            return null;
        }
    }

    private final SyncAPI.SyncSearchResult toSearchResult(Node node) {
        String title;
        if (node == null || (title = node.getTitle()) == null) {
            return null;
        }
        String name = getName();
        String valueOf = String.valueOf(node.getId());
        String str = "https://myanimelist.net/anime/" + node.getId();
        MainPicture main_picture = node.getMain_picture();
        return new SyncAPI.SyncSearchResult(title, name, valueOf, str, main_picture != null ? main_picture.getLarge() : null, null, null, null, null, 480, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0213  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getResult(java.lang.String r45, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncResult> r46) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getResult(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getStatus(java.lang.String r14, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncStatus> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$getStatus$1
            if (r0 == 0) goto L14
            r0 = r15
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getStatus$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$getStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getStatus$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getStatus$1
            r0.<init>(r13, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r15)
            goto L49
        L2b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L33:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Integer r14 = kotlin.text.StringsKt.toIntOrNull(r14)
            if (r14 == 0) goto L85
            int r14 = r14.intValue()
            r0.label = r3
            java.lang.Object r15 = r13.getDataAboutMalId(r14, r0)
            if (r15 != r1) goto L49
            return r1
        L49:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$SmallMalAnime r15 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.SmallMalAnime) r15
            if (r15 == 0) goto L52
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalStatus r14 = r15.getMy_list_status()
            goto L53
        L52:
            r14 = r4
        L53:
            if (r14 == 0) goto L5f
            int r15 = r14.getScore()
            java.lang.Integer r15 = kotlin.coroutines.jvm.internal.boxing.boxInt(r15)
            r7 = r15
            goto L60
        L5f:
            r7 = r4
        L60:
            java.lang.String[] r15 = com.lagradost.cloudstream3.syncproviders.providers.MALApi.malStatusAsString
            if (r14 == 0) goto L69
            java.lang.String r0 = r14.getStatus()
            goto L6a
        L69:
            r0 = r4
        L6a:
            int r6 = kotlin.collections.ArraysKt.indexOf(r15, r0)
            if (r14 == 0) goto L78
            int r14 = r14.getNum_episodes_watched()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.boxing.boxInt(r14)
        L78:
            r8 = r4
            com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncStatus r14 = new com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncStatus
            r9 = 0
            r10 = 0
            r11 = 16
            r12 = 0
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r14
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Companion;", "", "()V", "MAL_CACHED_LIST", "", "MAL_REFRESH_TOKEN_KEY", "MAL_SHOULD_UPDATE_LIST", "MAL_TOKEN_KEY", "MAL_UNIXTIME_KEY", "MAL_USER_KEY", "malStatusAsString", "", "[Ljava/lang/String;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0139  */
    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleRedirect(java.lang.String r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.handleRedirect(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public void authenticate() {
        byte[] bArr = new byte[96];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(codeVerifierBytes, Base64.DEFAULT)");
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trimEnd(encodeToString, '='), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), "\n", "", false, 4, (Object) null);
        this.codeVerifier = replace$default;
        AcraApplication.Companion.openBrowser("https://myanimelist.net/v1/oauth2/authorize?response_type=code&client_id=" + getKey() + "&code_challenge=" + replace$default + "&state=RequestID" + this.requestId);
    }

    private final void storeToken(String str) {
        try {
            if (Intrinsics.areEqual(str, "")) {
                return;
            }
            ResponseToken responseToken = (ResponseToken) this.mapper.readValue(str, new TypeReference<ResponseToken>() { // from class: com.lagradost.cloudstream3.syncproviders.providers.MALApi$storeToken$$inlined$readValue$1
            });
            AcraApplication.Companion.setKey(getAccountId(), MAL_UNIXTIME_KEY, Long.valueOf(responseToken.getExpires_in() + AccountManager.Companion.getUnixTime()));
            AcraApplication.Companion.setKey(getAccountId(), MAL_REFRESH_TOKEN_KEY, responseToken.getRefresh_token());
            AcraApplication.Companion.setKey(getAccountId(), MAL_TOKEN_KEY, responseToken.getAccess_token());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(5:19|20|(4:22|23|24|(1:26)(2:27|28))|31|(1:33)(1:34))|12|13|14))|37|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e0, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshToken(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.refreshToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalList;", "", "data", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Data;", "paging", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Paging;", "(Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Paging;)V", "getData", "()Ljava/util/List;", "getPaging", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Paging;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalList {
        private final List<Data> data;
        private final Paging paging;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MalList copy$default(MalList malList, List list, Paging paging, int i, Object obj) {
            if ((i & 1) != 0) {
                list = malList.data;
            }
            if ((i & 2) != 0) {
                paging = malList.paging;
            }
            return malList.copy(list, paging);
        }

        public final List<Data> component1() {
            return this.data;
        }

        public final Paging component2() {
            return this.paging;
        }

        public final MalList copy(@JsonProperty("data") List<Data> data, @JsonProperty("paging") Paging paging) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(paging, "paging");
            return new MalList(data, paging);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalList) {
                MalList malList = (MalList) obj;
                return Intrinsics.areEqual(this.data, malList.data) && Intrinsics.areEqual(this.paging, malList.paging);
            }
            return false;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.paging.hashCode();
        }

        public String toString() {
            return "MalList(data=" + this.data + ", paging=" + this.paging + ')';
        }

        public MalList(@JsonProperty("data") List<Data> data, @JsonProperty("paging") Paging paging) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(paging, "paging");
            this.data = data;
            this.paging = paging;
        }

        public final List<Data> getData() {
            return this.data;
        }

        public final Paging getPaging() {
            return this.paging;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;", "", "medium", "", "large", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MainPicture {
        private final String large;
        private final String medium;

        public static /* synthetic */ MainPicture copy$default(MainPicture mainPicture, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mainPicture.medium;
            }
            if ((i & 2) != 0) {
                str2 = mainPicture.large;
            }
            return mainPicture.copy(str, str2);
        }

        public final String component1() {
            return this.medium;
        }

        public final String component2() {
            return this.large;
        }

        public final MainPicture copy(@JsonProperty("medium") String medium, @JsonProperty("large") String large) {
            Intrinsics.checkNotNullParameter(medium, "medium");
            Intrinsics.checkNotNullParameter(large, "large");
            return new MainPicture(medium, large);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MainPicture) {
                MainPicture mainPicture = (MainPicture) obj;
                return Intrinsics.areEqual(this.medium, mainPicture.medium) && Intrinsics.areEqual(this.large, mainPicture.large);
            }
            return false;
        }

        public int hashCode() {
            return (this.medium.hashCode() * 31) + this.large.hashCode();
        }

        public String toString() {
            return "MainPicture(medium=" + this.medium + ", large=" + this.large + ')';
        }

        public MainPicture(@JsonProperty("medium") String medium, @JsonProperty("large") String large) {
            Intrinsics.checkNotNullParameter(medium, "medium");
            Intrinsics.checkNotNullParameter(large, "large");
            this.medium = medium;
            this.large = large;
        }

        public final String getMedium() {
            return this.medium;
        }

        public final String getLarge() {
            return this.large;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\"J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00104J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010O\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¤\u0002\u0010\\\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010]J\u0013\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u0003HÖ\u0001J\t\u0010b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b8\u0010&R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b9\u0010&R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b:\u0010&R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b;\u0010&R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b<\u0010&R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b=\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0013\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+¨\u0006c"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "", "id", "", "title", "", "main_picture", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;", "alternative_titles", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;", MessengerShareContentUtility.MEDIA_TYPE, "num_episodes", "status", "start_date", "end_date", "average_episode_duration", "synopsis", "mean", "", "genres", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Genres;", "rank", "popularity", "num_list_users", "num_favorites", "num_scoring_users", "start_season", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;", "broadcast", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;", "nsfw", "created_at", "updated_at", "(ILjava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlternative_titles", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;", "getAverage_episode_duration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBroadcast", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;", "getCreated_at", "()Ljava/lang/String;", "getEnd_date", "getGenres", "()Ljava/util/List;", "getId", "()I", "getMain_picture", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;", "getMean", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMedia_type", "getNsfw", "getNum_episodes", "getNum_favorites", "getNum_list_users", "getNum_scoring_users", "getPopularity", "getRank", "getStart_date", "getStart_season", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;", "getStatus", "getSynopsis", "getTitle", "getUpdated_at", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MainPicture;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Node {
        private final AlternativeTitles alternative_titles;
        private final Integer average_episode_duration;
        private final Broadcast broadcast;
        private final String created_at;
        private final String end_date;
        private final List<Genres> genres;

        /* renamed from: id */
        private final int f10013id;
        private final MainPicture main_picture;
        private final Double mean;
        private final String media_type;
        private final String nsfw;
        private final Integer num_episodes;
        private final Integer num_favorites;
        private final Integer num_list_users;
        private final Integer num_scoring_users;
        private final Integer popularity;
        private final Integer rank;
        private final String start_date;
        private final StartSeason start_season;
        private final String status;
        private final String synopsis;
        private final String title;
        private final String updated_at;

        public final int component1() {
            return this.f10013id;
        }

        public final Integer component10() {
            return this.average_episode_duration;
        }

        public final String component11() {
            return this.synopsis;
        }

        public final Double component12() {
            return this.mean;
        }

        public final List<Genres> component13() {
            return this.genres;
        }

        public final Integer component14() {
            return this.rank;
        }

        public final Integer component15() {
            return this.popularity;
        }

        public final Integer component16() {
            return this.num_list_users;
        }

        public final Integer component17() {
            return this.num_favorites;
        }

        public final Integer component18() {
            return this.num_scoring_users;
        }

        public final StartSeason component19() {
            return this.start_season;
        }

        public final String component2() {
            return this.title;
        }

        public final Broadcast component20() {
            return this.broadcast;
        }

        public final String component21() {
            return this.nsfw;
        }

        public final String component22() {
            return this.created_at;
        }

        public final String component23() {
            return this.updated_at;
        }

        public final MainPicture component3() {
            return this.main_picture;
        }

        public final AlternativeTitles component4() {
            return this.alternative_titles;
        }

        public final String component5() {
            return this.media_type;
        }

        public final Integer component6() {
            return this.num_episodes;
        }

        public final String component7() {
            return this.status;
        }

        public final String component8() {
            return this.start_date;
        }

        public final String component9() {
            return this.end_date;
        }

        public final Node copy(@JsonProperty("id") int i, @JsonProperty("title") String title, @JsonProperty("main_picture") MainPicture mainPicture, @JsonProperty("alternative_titles") AlternativeTitles alternativeTitles, @JsonProperty("media_type") String str, @JsonProperty("num_episodes") Integer num, @JsonProperty("status") String str2, @JsonProperty("start_date") String str3, @JsonProperty("end_date") String str4, @JsonProperty("average_episode_duration") Integer num2, @JsonProperty("synopsis") String str5, @JsonProperty("mean") Double d, @JsonProperty("genres") List<Genres> list, @JsonProperty("rank") Integer num3, @JsonProperty("popularity") Integer num4, @JsonProperty("num_list_users") Integer num5, @JsonProperty("num_favorites") Integer num6, @JsonProperty("num_scoring_users") Integer num7, @JsonProperty("start_season") StartSeason startSeason, @JsonProperty("broadcast") Broadcast broadcast, @JsonProperty("nsfw") String str6, @JsonProperty("created_at") String str7, @JsonProperty("updated_at") String str8) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new Node(i, title, mainPicture, alternativeTitles, str, num, str2, str3, str4, num2, str5, d, list, num3, num4, num5, num6, num7, startSeason, broadcast, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return this.f10013id == node.f10013id && Intrinsics.areEqual(this.title, node.title) && Intrinsics.areEqual(this.main_picture, node.main_picture) && Intrinsics.areEqual(this.alternative_titles, node.alternative_titles) && Intrinsics.areEqual(this.media_type, node.media_type) && Intrinsics.areEqual(this.num_episodes, node.num_episodes) && Intrinsics.areEqual(this.status, node.status) && Intrinsics.areEqual(this.start_date, node.start_date) && Intrinsics.areEqual(this.end_date, node.end_date) && Intrinsics.areEqual(this.average_episode_duration, node.average_episode_duration) && Intrinsics.areEqual(this.synopsis, node.synopsis) && Intrinsics.areEqual((Object) this.mean, (Object) node.mean) && Intrinsics.areEqual(this.genres, node.genres) && Intrinsics.areEqual(this.rank, node.rank) && Intrinsics.areEqual(this.popularity, node.popularity) && Intrinsics.areEqual(this.num_list_users, node.num_list_users) && Intrinsics.areEqual(this.num_favorites, node.num_favorites) && Intrinsics.areEqual(this.num_scoring_users, node.num_scoring_users) && Intrinsics.areEqual(this.start_season, node.start_season) && Intrinsics.areEqual(this.broadcast, node.broadcast) && Intrinsics.areEqual(this.nsfw, node.nsfw) && Intrinsics.areEqual(this.created_at, node.created_at) && Intrinsics.areEqual(this.updated_at, node.updated_at);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f10013id * 31) + this.title.hashCode()) * 31;
            MainPicture mainPicture = this.main_picture;
            int hashCode2 = (hashCode + (mainPicture == null ? 0 : mainPicture.hashCode())) * 31;
            AlternativeTitles alternativeTitles = this.alternative_titles;
            int hashCode3 = (hashCode2 + (alternativeTitles == null ? 0 : alternativeTitles.hashCode())) * 31;
            String str = this.media_type;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.num_episodes;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.status;
            int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.start_date;
            int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.end_date;
            int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.average_episode_duration;
            int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str5 = this.synopsis;
            int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Double d = this.mean;
            int hashCode11 = (hashCode10 + (d == null ? 0 : d.hashCode())) * 31;
            List<Genres> list = this.genres;
            int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
            Integer num3 = this.rank;
            int hashCode13 = (hashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.popularity;
            int hashCode14 = (hashCode13 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.num_list_users;
            int hashCode15 = (hashCode14 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.num_favorites;
            int hashCode16 = (hashCode15 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.num_scoring_users;
            int hashCode17 = (hashCode16 + (num7 == null ? 0 : num7.hashCode())) * 31;
            StartSeason startSeason = this.start_season;
            int hashCode18 = (hashCode17 + (startSeason == null ? 0 : startSeason.hashCode())) * 31;
            Broadcast broadcast = this.broadcast;
            int hashCode19 = (hashCode18 + (broadcast == null ? 0 : broadcast.hashCode())) * 31;
            String str6 = this.nsfw;
            int hashCode20 = (hashCode19 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.created_at;
            int hashCode21 = (hashCode20 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.updated_at;
            return hashCode21 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.f10013id + ", title=" + this.title + ", main_picture=" + this.main_picture + ", alternative_titles=" + this.alternative_titles + ", media_type=" + this.media_type + ", num_episodes=" + this.num_episodes + ", status=" + this.status + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", average_episode_duration=" + this.average_episode_duration + ", synopsis=" + this.synopsis + ", mean=" + this.mean + ", genres=" + this.genres + ", rank=" + this.rank + ", popularity=" + this.popularity + ", num_list_users=" + this.num_list_users + ", num_favorites=" + this.num_favorites + ", num_scoring_users=" + this.num_scoring_users + ", start_season=" + this.start_season + ", broadcast=" + this.broadcast + ", nsfw=" + this.nsfw + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ')';
        }

        public Node(@JsonProperty("id") int i, @JsonProperty("title") String title, @JsonProperty("main_picture") MainPicture mainPicture, @JsonProperty("alternative_titles") AlternativeTitles alternativeTitles, @JsonProperty("media_type") String str, @JsonProperty("num_episodes") Integer num, @JsonProperty("status") String str2, @JsonProperty("start_date") String str3, @JsonProperty("end_date") String str4, @JsonProperty("average_episode_duration") Integer num2, @JsonProperty("synopsis") String str5, @JsonProperty("mean") Double d, @JsonProperty("genres") List<Genres> list, @JsonProperty("rank") Integer num3, @JsonProperty("popularity") Integer num4, @JsonProperty("num_list_users") Integer num5, @JsonProperty("num_favorites") Integer num6, @JsonProperty("num_scoring_users") Integer num7, @JsonProperty("start_season") StartSeason startSeason, @JsonProperty("broadcast") Broadcast broadcast, @JsonProperty("nsfw") String str6, @JsonProperty("created_at") String str7, @JsonProperty("updated_at") String str8) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.f10013id = i;
            this.title = title;
            this.main_picture = mainPicture;
            this.alternative_titles = alternativeTitles;
            this.media_type = str;
            this.num_episodes = num;
            this.status = str2;
            this.start_date = str3;
            this.end_date = str4;
            this.average_episode_duration = num2;
            this.synopsis = str5;
            this.mean = d;
            this.genres = list;
            this.rank = num3;
            this.popularity = num4;
            this.num_list_users = num5;
            this.num_favorites = num6;
            this.num_scoring_users = num7;
            this.start_season = startSeason;
            this.broadcast = broadcast;
            this.nsfw = str6;
            this.created_at = str7;
            this.updated_at = str8;
        }

        public final int getId() {
            return this.f10013id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final MainPicture getMain_picture() {
            return this.main_picture;
        }

        public final AlternativeTitles getAlternative_titles() {
            return this.alternative_titles;
        }

        public final String getMedia_type() {
            return this.media_type;
        }

        public final Integer getNum_episodes() {
            return this.num_episodes;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getStart_date() {
            return this.start_date;
        }

        public final String getEnd_date() {
            return this.end_date;
        }

        public final Integer getAverage_episode_duration() {
            return this.average_episode_duration;
        }

        public final String getSynopsis() {
            return this.synopsis;
        }

        public final Double getMean() {
            return this.mean;
        }

        public final List<Genres> getGenres() {
            return this.genres;
        }

        public final Integer getRank() {
            return this.rank;
        }

        public final Integer getPopularity() {
            return this.popularity;
        }

        public final Integer getNum_list_users() {
            return this.num_list_users;
        }

        public final Integer getNum_favorites() {
            return this.num_favorites;
        }

        public final Integer getNum_scoring_users() {
            return this.num_scoring_users;
        }

        public final StartSeason getStart_season() {
            return this.start_season;
        }

        public final Broadcast getBroadcast() {
            return this.broadcast;
        }

        public final String getNsfw() {
            return this.nsfw;
        }

        public final String getCreated_at() {
            return this.created_at;
        }

        public final String getUpdated_at() {
            return this.updated_at;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$ListStatus;", "", "status", "", "score", "", "num_episodes_watched", "is_rewatching", "", "updated_at", "(Ljava/lang/String;IIZLjava/lang/String;)V", "()Z", "getNum_episodes_watched", "()I", "getScore", "getStatus", "()Ljava/lang/String;", "getUpdated_at", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ListStatus {
        private final boolean is_rewatching;
        private final int num_episodes_watched;
        private final int score;
        private final String status;
        private final String updated_at;

        public static /* synthetic */ ListStatus copy$default(ListStatus listStatus, String str, int i, int i2, boolean z, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = listStatus.status;
            }
            if ((i3 & 2) != 0) {
                i = listStatus.score;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = listStatus.num_episodes_watched;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                z = listStatus.is_rewatching;
            }
            boolean z2 = z;
            if ((i3 & 16) != 0) {
                str2 = listStatus.updated_at;
            }
            return listStatus.copy(str, i4, i5, z2, str2);
        }

        public final String component1() {
            return this.status;
        }

        public final int component2() {
            return this.score;
        }

        public final int component3() {
            return this.num_episodes_watched;
        }

        public final boolean component4() {
            return this.is_rewatching;
        }

        public final String component5() {
            return this.updated_at;
        }

        public final ListStatus copy(@JsonProperty("status") String str, @JsonProperty("score") int i, @JsonProperty("num_episodes_watched") int i2, @JsonProperty("is_rewatching") boolean z, @JsonProperty("updated_at") String updated_at) {
            Intrinsics.checkNotNullParameter(updated_at, "updated_at");
            return new ListStatus(str, i, i2, z, updated_at);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListStatus) {
                ListStatus listStatus = (ListStatus) obj;
                return Intrinsics.areEqual(this.status, listStatus.status) && this.score == listStatus.score && this.num_episodes_watched == listStatus.num_episodes_watched && this.is_rewatching == listStatus.is_rewatching && Intrinsics.areEqual(this.updated_at, listStatus.updated_at);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.status;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.score) * 31) + this.num_episodes_watched) * 31;
            boolean z = this.is_rewatching;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.updated_at.hashCode();
        }

        public String toString() {
            return "ListStatus(status=" + this.status + ", score=" + this.score + ", num_episodes_watched=" + this.num_episodes_watched + ", is_rewatching=" + this.is_rewatching + ", updated_at=" + this.updated_at + ')';
        }

        public ListStatus(@JsonProperty("status") String str, @JsonProperty("score") int i, @JsonProperty("num_episodes_watched") int i2, @JsonProperty("is_rewatching") boolean z, @JsonProperty("updated_at") String updated_at) {
            Intrinsics.checkNotNullParameter(updated_at, "updated_at");
            this.status = str;
            this.score = i;
            this.num_episodes_watched = i2;
            this.is_rewatching = z;
            this.updated_at = updated_at;
        }

        public final String getStatus() {
            return this.status;
        }

        public final int getScore() {
            return this.score;
        }

        public final int getNum_episodes_watched() {
            return this.num_episodes_watched;
        }

        public final boolean is_rewatching() {
            return this.is_rewatching;
        }

        public final String getUpdated_at() {
            return this.updated_at;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Data;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "list_status", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$ListStatus;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$ListStatus;)V", "getList_status", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$ListStatus;", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final ListStatus list_status;
        private final Node node;

        public static /* synthetic */ Data copy$default(Data data, Node node, ListStatus listStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                node = data.node;
            }
            if ((i & 2) != 0) {
                listStatus = data.list_status;
            }
            return data.copy(node, listStatus);
        }

        public final Node component1() {
            return this.node;
        }

        public final ListStatus component2() {
            return this.list_status;
        }

        public final Data copy(@JsonProperty("node") Node node, @JsonProperty("list_status") ListStatus listStatus) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Data(node, listStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.node, data.node) && Intrinsics.areEqual(this.list_status, data.list_status);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.node.hashCode() * 31;
            ListStatus listStatus = this.list_status;
            return hashCode + (listStatus == null ? 0 : listStatus.hashCode());
        }

        public String toString() {
            return "Data(node=" + this.node + ", list_status=" + this.list_status + ')';
        }

        public Data(@JsonProperty("node") Node node, @JsonProperty("list_status") ListStatus listStatus) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.list_status = listStatus;
        }

        public final Node getNode() {
            return this.node;
        }

        public final ListStatus getList_status() {
            return this.list_status;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Paging;", "", "next", "", "(Ljava/lang/String;)V", "getNext", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Paging {
        private final String next;

        public static /* synthetic */ Paging copy$default(Paging paging, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paging.next;
            }
            return paging.copy(str);
        }

        public final String component1() {
            return this.next;
        }

        public final Paging copy(@JsonProperty("next") String str) {
            return new Paging(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paging) && Intrinsics.areEqual(this.next, ((Paging) obj).next);
        }

        public int hashCode() {
            String str = this.next;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Paging(next=" + this.next + ')';
        }

        public Paging(@JsonProperty("next") String str) {
            this.next = str;
        }

        public final String getNext() {
            return this.next;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$AlternativeTitles;", "", "synonyms", "", "", "en", "ja", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getEn", "()Ljava/lang/String;", "getJa", "getSynonyms", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AlternativeTitles {

        /* renamed from: en */
        private final String f10006en;

        /* renamed from: ja */
        private final String f10007ja;
        private final List<String> synonyms;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AlternativeTitles copy$default(AlternativeTitles alternativeTitles, List list, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = alternativeTitles.synonyms;
            }
            if ((i & 2) != 0) {
                str = alternativeTitles.f10006en;
            }
            if ((i & 4) != 0) {
                str2 = alternativeTitles.f10007ja;
            }
            return alternativeTitles.copy(list, str, str2);
        }

        public final List<String> component1() {
            return this.synonyms;
        }

        public final String component2() {
            return this.f10006en;
        }

        public final String component3() {
            return this.f10007ja;
        }

        public final AlternativeTitles copy(@JsonProperty("synonyms") List<String> synonyms, @JsonProperty("en") String en, @JsonProperty("ja") String ja) {
            Intrinsics.checkNotNullParameter(synonyms, "synonyms");
            Intrinsics.checkNotNullParameter(en, "en");
            Intrinsics.checkNotNullParameter(ja, "ja");
            return new AlternativeTitles(synonyms, en, ja);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AlternativeTitles) {
                AlternativeTitles alternativeTitles = (AlternativeTitles) obj;
                return Intrinsics.areEqual(this.synonyms, alternativeTitles.synonyms) && Intrinsics.areEqual(this.f10006en, alternativeTitles.f10006en) && Intrinsics.areEqual(this.f10007ja, alternativeTitles.f10007ja);
            }
            return false;
        }

        public int hashCode() {
            return (((this.synonyms.hashCode() * 31) + this.f10006en.hashCode()) * 31) + this.f10007ja.hashCode();
        }

        public String toString() {
            return "AlternativeTitles(synonyms=" + this.synonyms + ", en=" + this.f10006en + ", ja=" + this.f10007ja + ')';
        }

        public AlternativeTitles(@JsonProperty("synonyms") List<String> synonyms, @JsonProperty("en") String en, @JsonProperty("ja") String ja) {
            Intrinsics.checkNotNullParameter(synonyms, "synonyms");
            Intrinsics.checkNotNullParameter(en, "en");
            Intrinsics.checkNotNullParameter(ja, "ja");
            this.synonyms = synonyms;
            this.f10006en = en;
            this.f10007ja = ja;
        }

        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        public final String getEn() {
            return this.f10006en;
        }

        public final String getJa() {
            return this.f10007ja;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Genres;", "", "id", "", "name", "", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Genres {

        /* renamed from: id */
        private final int f10008id;
        private final String name;

        public static /* synthetic */ Genres copy$default(Genres genres, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = genres.f10008id;
            }
            if ((i2 & 2) != 0) {
                str = genres.name;
            }
            return genres.copy(i, str);
        }

        public final int component1() {
            return this.f10008id;
        }

        public final String component2() {
            return this.name;
        }

        public final Genres copy(@JsonProperty("id") int i, @JsonProperty("name") String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Genres(i, name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Genres) {
                Genres genres = (Genres) obj;
                return this.f10008id == genres.f10008id && Intrinsics.areEqual(this.name, genres.name);
            }
            return false;
        }

        public int hashCode() {
            return (this.f10008id * 31) + this.name.hashCode();
        }

        public String toString() {
            return "Genres(id=" + this.f10008id + ", name=" + this.name + ')';
        }

        public Genres(@JsonProperty("id") int i, @JsonProperty("name") String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f10008id = i;
            this.name = name;
        }

        public final int getId() {
            return this.f10008id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$StartSeason;", "", "year", "", "season", "", "(ILjava/lang/String;)V", "getSeason", "()Ljava/lang/String;", "getYear", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class StartSeason {
        private final String season;
        private final int year;

        public static /* synthetic */ StartSeason copy$default(StartSeason startSeason, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = startSeason.year;
            }
            if ((i2 & 2) != 0) {
                str = startSeason.season;
            }
            return startSeason.copy(i, str);
        }

        public final int component1() {
            return this.year;
        }

        public final String component2() {
            return this.season;
        }

        public final StartSeason copy(@JsonProperty("year") int i, @JsonProperty("season") String season) {
            Intrinsics.checkNotNullParameter(season, "season");
            return new StartSeason(i, season);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartSeason) {
                StartSeason startSeason = (StartSeason) obj;
                return this.year == startSeason.year && Intrinsics.areEqual(this.season, startSeason.season);
            }
            return false;
        }

        public int hashCode() {
            return (this.year * 31) + this.season.hashCode();
        }

        public String toString() {
            return "StartSeason(year=" + this.year + ", season=" + this.season + ')';
        }

        public StartSeason(@JsonProperty("year") int i, @JsonProperty("season") String season) {
            Intrinsics.checkNotNullParameter(season, "season");
            this.year = i;
            this.season = season;
        }

        public final int getYear() {
            return this.year;
        }

        public final String getSeason() {
            return this.season;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Broadcast;", "", "day_of_the_week", "", TvContractCompat.PARAM_START_TIME, "(Ljava/lang/String;Ljava/lang/String;)V", "getDay_of_the_week", "()Ljava/lang/String;", "getStart_time", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Broadcast {
        private final String day_of_the_week;
        private final String start_time;

        public static /* synthetic */ Broadcast copy$default(Broadcast broadcast, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = broadcast.day_of_the_week;
            }
            if ((i & 2) != 0) {
                str2 = broadcast.start_time;
            }
            return broadcast.copy(str, str2);
        }

        public final String component1() {
            return this.day_of_the_week;
        }

        public final String component2() {
            return this.start_time;
        }

        public final Broadcast copy(@JsonProperty("day_of_the_week") String str, @JsonProperty("start_time") String str2) {
            return new Broadcast(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Broadcast) {
                Broadcast broadcast = (Broadcast) obj;
                return Intrinsics.areEqual(this.day_of_the_week, broadcast.day_of_the_week) && Intrinsics.areEqual(this.start_time, broadcast.start_time);
            }
            return false;
        }

        public int hashCode() {
            String str = this.day_of_the_week;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.start_time;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Broadcast(day_of_the_week=" + this.day_of_the_week + ", start_time=" + this.start_time + ')';
        }

        public Broadcast(@JsonProperty("day_of_the_week") String str, @JsonProperty("start_time") String str2) {
            this.day_of_the_week = str;
            this.start_time = str2;
        }

        public final String getDay_of_the_week() {
            return this.day_of_the_week;
        }

        public final String getStart_time() {
            return this.start_time;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[] getMalAnimeListCached() {
        /*
            r4 = this;
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = "mal_cached_list"
            android.content.Context r0 = r0.getContext()
            r2 = 0
            if (r0 == 0) goto L2d
            com.lagradost.cloudstream3.utils.DataStore r3 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            android.content.SharedPreferences r0 = r3.getSharedPrefs(r0)     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Exception -> L2d
            if (r0 != 0) goto L18
            goto L2d
        L18:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L2d
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r3.getMapper()     // Catch: java.lang.Exception -> L2d
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[]> r3 = com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[].class
            java.lang.Object r0 = r1.readValue(r0, r3)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2d:
            r0 = r2
        L2e:
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[]
            if (r1 == 0) goto L35
            r2 = r0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[] r2 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[]) r2
        L35:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getMalAnimeListCached():com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMalAnimeListSmart(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[]> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSmart$1
            if (r0 == 0) goto L14
            r0 = r8
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSmart$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSmart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSmart$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSmart$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "mal_should_update_list"
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.getAuth()
            r2 = 0
            if (r8 != 0) goto L3f
            return r2
        L3f:
            com.lagradost.cloudstream3.AcraApplication$Companion r8 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
            android.content.Context r8 = r8.getContext()
            if (r8 == 0) goto L70
            com.lagradost.cloudstream3.utils.DataStore r6 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            android.content.SharedPreferences r8 = r6.getSharedPrefs(r8)     // Catch: java.lang.Exception -> L6f
            java.lang.String r8 = r8.getString(r3, r2)     // Catch: java.lang.Exception -> L6f
            if (r8 != 0) goto L59
            r2 = r5
            goto L70
        L59:
            java.lang.String r5 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)     // Catch: java.lang.Exception -> L6f
            com.fasterxml.jackson.databind.json.JsonMapper r5 = r6.getMapper()     // Catch: java.lang.Exception -> L6f
            java.lang.Class<java.lang.Boolean> r6 = java.lang.Boolean.class
            java.lang.Object r8 = r5.readValue(r8, r6)     // Catch: java.lang.Exception -> L6f
            java.lang.String r5 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)     // Catch: java.lang.Exception -> L6f
            r2 = r8
            goto L70
        L6f:
        L70:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r8)
            if (r8 == 0) goto L97
            r0.label = r4
            java.lang.Object r8 = r7.getMalAnimeList(r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[] r8 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[]) r8
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = "mal_cached_list"
            r0.setKey(r1, r8)
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r1)
            r0.setKey(r3, r1)
            goto L9b
        L97:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[] r8 = r7.getMalAnimeListCached()
        L9b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getMalAnimeListSmart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0077 -> B:24:0x007a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMalAnimeList(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[]> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeList$1
            if (r0 == 0) goto L14
            r0 = r10
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeList$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeList$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeList$1
            r0.<init>(r9, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4a
            if (r2 == r5) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r2 = r0.L$2
            kotlin.text.Regex r2 = (kotlin.text.Regex) r2
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi r7 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7a
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L42:
            java.lang.Object r2 = r0.L$0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi r2 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L59
        L4a:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r9.checkMalToken(r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            r2 = r9
        L59:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            kotlin.text.Regex r6 = new kotlin.text.Regex
            java.lang.String r7 = "offset=(\\d+)"
            r6.<init>(r7)
            r7 = r2
            r2 = r6
            r6 = r10
            r10 = 0
        L6b:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r10 = r7.getMalAnimeListSlice(r10, r0)
            if (r10 != r1) goto L7a
            return r1
        L7a:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalList r10 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalList) r10
            if (r10 != 0) goto L7f
            goto Lb8
        L7f:
            java.util.List r8 = r10.getData()
            java.util.Collection r8 = (java.util.Collection) r8
            r6.addAll(r8)
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$Paging r10 = r10.getPaging()
            java.lang.String r10 = r10.getNext()
            if (r10 == 0) goto Lb8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8 = 0
            kotlin.text.MatchResult r10 = kotlin.text.Regex.find$default(r2, r10, r3, r4, r8)
            if (r10 == 0) goto Lb1
            java.util.List r10 = r10.getGroupValues()
            if (r10 == 0) goto Lb1
            java.lang.Object r10 = r10.get(r5)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto Lb1
            int r10 = java.lang.Integer.parseInt(r10)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.boxing.boxInt(r10)
        Lb1:
            if (r8 == 0) goto Lb8
            int r10 = r8.intValue()
            goto L6b
        Lb8:
            java.util.Collection r6 = (java.util.Collection) r6
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$Data[] r10 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi.Data[r3]
            java.lang.Object[] r10 = r6.toArray(r10)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            java.util.Objects.requireNonNull(r10, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getMalAnimeList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final MalStatusType convertToStatus(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return fromIntToAnimeStatus(ArraysKt.indexOf(malStatusAsString, string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMalAnimeListSlice(int r20, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalList> r21) {
        /*
            r19 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSlice$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSlice$1 r1 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSlice$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r19
            goto L1f
        L18:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSlice$1 r1 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getMalAnimeListSlice$1
            r2 = r19
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L39
            if (r3 != r4) goto L31
            kotlin.ResultKt.throwOnFailure(r0)
            goto La2
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r19.getAuth()
            if (r0 != 0) goto L44
            r0 = 0
            return r0
        L44:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "https://api.myanimelist.net/v2/users/"
            r3.append(r5)
            java.lang.String r5 = "@me"
            r3.append(r5)
            java.lang.String r5 = "/animelist?fields=list_status,num_episodes,media_type,status,start_date,end_date,synopsis,alternative_titles,mean,genres,rank,num_list_users,nsfw,average_episode_duration,num_favorites,popularity,num_scoring_users,start_season,favorites_info,broadcast,created_at,updated_at&nsfw=1&limit=100&offset="
            r3.append(r5)
            r5 = r20
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Bearer "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            java.lang.String r6 = "Authorization"
            kotlin.Pair r0 = kotlin.TuplesKt.m100to(r6, r0)
            java.util.Map r0 = kotlin.collections.MapsKt.mapOf(r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 1980(0x7bc, float:2.775E-42)
            r18 = 0
            r1.label = r4
            r4 = r5
            r5 = r0
            r0 = r15
            r15 = r16
            r16 = r1
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r1 != r0) goto La1
            return r0
        La1:
            r0 = r1
        La2:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            java.lang.String r0 = r0.getText()
            com.lagradost.cloudstream3.utils.DataStore r1 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r1.getMapper()
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalList> r3 = com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalList.class
            java.lang.Object r0 = r1.readValue(r0, r3)
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getMalAnimeListSlice(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getMalAnimeListSlice$default(MALApi mALApi, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return mALApi.getMalAnimeListSlice(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDataAboutMalId(int r20, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.MALApi.SmallMalAnime> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$1 r2 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$1 r2 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi r2 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto La0
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "https://api.myanimelist.net/v2/anime/"
            r1.append(r3)
            r3 = r20
            r1.append(r3)
            java.lang.String r3 = "?fields=id,title,num_episodes,my_list_status"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Bearer "
            r5.append(r6)
            java.lang.String r6 = r19.getAuth()
            if (r6 != 0) goto L6d
            r1 = 0
            return r1
        L6d:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "Authorization"
            kotlin.Pair r5 = kotlin.TuplesKt.m100to(r6, r5)
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 1980(0x7bc, float:2.775E-42)
            r18 = 0
            r2.L$0 = r0
            r2.label = r4
            r4 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            if (r2 != r1) goto L9e
            return r1
        L9e:
            r1 = r2
            r2 = r0
        La0:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            java.lang.String r1 = r1.getText()
            com.fasterxml.jackson.databind.json.JsonMapper r2 = r2.mapper
            com.fasterxml.jackson.databind.ObjectMapper r2 = (com.fasterxml.jackson.databind.ObjectMapper) r2
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$$inlined$readValue$1 r3 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$getDataAboutMalId$$inlined$readValue$1
            r3.<init>()
            com.fasterxml.jackson.core.type.TypeReference r3 = (com.fasterxml.jackson.core.type.TypeReference) r3
            java.lang.Object r1 = r2.readValue(r1, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getDataAboutMalId(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116 A[LOOP:0: B:29:0x0110->B:31:0x0116, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0145 A[LOOP:1: B:33:0x013f->B:35:0x0145, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0169  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00df -> B:28:0x00e2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setAllMalData(kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.setAllMalData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ String convertJapanTimeToTimeRemaining$default(MALApi mALApi, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return mALApi.convertJapanTimeToTimeRemaining(str, str2);
    }

    public final String convertJapanTimeToTimeRemaining(String date, String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        if (str != null) {
            try {
                if (new SimpleDateFormat(TmdbHelper.TMDB_DATE_PATTERN).parse(str).getTime() < System.currentTimeMillis()) {
                    return null;
                }
            } catch (ParseException e) {
                ArchComponentExt.logError(e);
            }
        }
        String str2 = date;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "null", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "other", false, 2, (Object) null)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(4);
        int i2 = calendar.get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM W EEEE HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Japan"));
        Date parse = simpleDateFormat.parse(i2 + ' ' + (calendar.get(2) + 1) + ' ' + i + ' ' + date);
        if (parse == null) {
            return null;
        }
        long time = (parse.getTime() - System.currentTimeMillis()) / 1000;
        if (time > -604800 && time < 0) {
            time += 604800;
        }
        return AccountManager.Companion.secondsToReadable((int) time, "Now");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object checkMalToken(Continuation<? super Unit> continuation) {
        long unixTime = AccountManager.Companion.getUnixTime();
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountId = getAccountId();
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(accountId, MAL_UNIXTIME_KEY), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, Long.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        Long l = (Long) obj;
        if (unixTime > (l != null ? l.longValue() : 0L)) {
            Object refreshToken = refreshToken(continuation);
            return refreshToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? refreshToken : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMalUser(boolean r23, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalUser> r24) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.getMalUser(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getMalUser$default(MALApi mALApi, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return mALApi.getMalUser(z, continuation);
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatusType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "Watching", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "OnHold", "Dropped", "PlanToWatch", "None", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public enum MalStatusType {
        Watching(0),
        Completed(1),
        OnHold(2),
        Dropped(3),
        PlanToWatch(4),
        None(-1);
        
        private int value;

        MalStatusType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int i) {
            this.value = i;
        }
    }

    private final MalStatusType fromIntToAnimeStatus(int i) {
        switch (i) {
            case -1:
                return MalStatusType.None;
            case 0:
                return MalStatusType.Watching;
            case 1:
                return MalStatusType.Completed;
            case 2:
                return MalStatusType.OnHold;
            case 3:
                return MalStatusType.Dropped;
            case 4:
                return MalStatusType.PlanToWatch;
            case 5:
                return MalStatusType.Watching;
            default:
                return MalStatusType.None;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setScoreRequest(int r10, com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalStatusType r11, java.lang.Integer r12, java.lang.Integer r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$1
            if (r0 == 0) goto L14
            r0 = r14
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$1
            r0.<init>(r9, r14)
        L19:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 0
            r8 = 1
            if (r1 == 0) goto L3a
            if (r1 != r8) goto L32
            int r10 = r6.I$0
            java.lang.Object r11 = r6.L$0
            com.lagradost.cloudstream3.syncproviders.providers.MALApi r11 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L60
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            kotlin.ResultKt.throwOnFailure(r14)
            if (r11 != 0) goto L41
            r11 = 0
            goto L4d
        L41:
            java.lang.String[] r14 = com.lagradost.cloudstream3.syncproviders.providers.MALApi.malStatusAsString
            int r11 = r11.getValue()
            int r11 = java.lang.Math.max(r7, r11)
            r11 = r14[r11]
        L4d:
            r3 = r11
            r6.L$0 = r9
            r6.I$0 = r10
            r6.label = r8
            r1 = r9
            r2 = r10
            r4 = r12
            r5 = r13
            java.lang.Object r14 = r1.setScoreRequest(r2, r3, r4, r5, r6)
            if (r14 != r0) goto L5f
            return r0
        L5f:
            r11 = r9
        L60:
            java.lang.String r14 = (java.lang.String) r14
            r12 = r14
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L70
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)
            if (r12 == 0) goto L6e
            goto L70
        L6e:
            r12 = 0
            goto L71
        L70:
            r12 = 1
        L71:
            if (r12 == 0) goto L74
            goto Lc8
        L74:
            com.fasterxml.jackson.databind.json.JsonMapper r12 = r11.mapper
            com.fasterxml.jackson.databind.ObjectMapper r12 = (com.fasterxml.jackson.databind.ObjectMapper) r12
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$$inlined$readValue$1 r13 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$setScoreRequest$$inlined$readValue$1
            r13.<init>()
            com.fasterxml.jackson.core.type.TypeReference r13 = (com.fasterxml.jackson.core.type.TypeReference) r13
            java.lang.Object r12 = r12.readValue(r14, r13)
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalStatus r12 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalStatus) r12
            java.util.HashMap<java.lang.Integer, com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder> r13 = r11.allTitles
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.boxing.boxInt(r10)
            boolean r13 = r13.containsKey(r14)
            if (r13 == 0) goto Lb5
            java.util.HashMap<java.lang.Integer, com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder> r13 = r11.allTitles
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.boxing.boxInt(r10)
            java.lang.Object r13 = r13.get(r14)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder r13 = (com.lagradost.cloudstream3.syncproviders.providers.MALApi.MalTitleHolder) r13
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.boxing.boxInt(r10)
            java.util.HashMap<java.lang.Integer, com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder> r11 = r11.allTitles
            java.util.Map r11 = (java.util.Map) r11
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder r0 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder
            java.lang.String r13 = r13.getName()
            r0.<init>(r12, r10, r13)
            r11.put(r14, r0)
            goto Lc7
        Lb5:
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.boxing.boxInt(r10)
            java.util.HashMap<java.lang.Integer, com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder> r11 = r11.allTitles
            java.util.Map r11 = (java.util.Map) r11
            com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder r14 = new com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalTitleHolder
            java.lang.String r0 = ""
            r14.<init>(r12, r10, r0)
            r11.put(r13, r14)
        Lc7:
            r7 = 1
        Lc8:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.setScoreRequest(int, com.lagradost.cloudstream3.syncproviders.providers.MALApi$MalStatusType, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setScoreRequest(int r25, java.lang.String r26, java.lang.Integer r27, java.lang.Integer r28, kotlin.coroutines.Continuation<? super java.lang.String> r29) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.MALApi.setScoreRequest(int, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$ResponseToken;", "", "token_type", "", AccessToken.EXPIRES_IN_KEY, "", "access_token", "refresh_token", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "getExpires_in", "()I", "getRefresh_token", "getToken_type", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ResponseToken {
        private final String access_token;
        private final int expires_in;
        private final String refresh_token;
        private final String token_type;

        public static /* synthetic */ ResponseToken copy$default(ResponseToken responseToken, String str, int i, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = responseToken.token_type;
            }
            if ((i2 & 2) != 0) {
                i = responseToken.expires_in;
            }
            if ((i2 & 4) != 0) {
                str2 = responseToken.access_token;
            }
            if ((i2 & 8) != 0) {
                str3 = responseToken.refresh_token;
            }
            return responseToken.copy(str, i, str2, str3);
        }

        public final String component1() {
            return this.token_type;
        }

        public final int component2() {
            return this.expires_in;
        }

        public final String component3() {
            return this.access_token;
        }

        public final String component4() {
            return this.refresh_token;
        }

        public final ResponseToken copy(@JsonProperty("token_type") String token_type, @JsonProperty("expires_in") int i, @JsonProperty("access_token") String access_token, @JsonProperty("refresh_token") String refresh_token) {
            Intrinsics.checkNotNullParameter(token_type, "token_type");
            Intrinsics.checkNotNullParameter(access_token, "access_token");
            Intrinsics.checkNotNullParameter(refresh_token, "refresh_token");
            return new ResponseToken(token_type, i, access_token, refresh_token);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResponseToken) {
                ResponseToken responseToken = (ResponseToken) obj;
                return Intrinsics.areEqual(this.token_type, responseToken.token_type) && this.expires_in == responseToken.expires_in && Intrinsics.areEqual(this.access_token, responseToken.access_token) && Intrinsics.areEqual(this.refresh_token, responseToken.refresh_token);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.token_type.hashCode() * 31) + this.expires_in) * 31) + this.access_token.hashCode()) * 31) + this.refresh_token.hashCode();
        }

        public String toString() {
            return "ResponseToken(token_type=" + this.token_type + ", expires_in=" + this.expires_in + ", access_token=" + this.access_token + ", refresh_token=" + this.refresh_token + ')';
        }

        public ResponseToken(@JsonProperty("token_type") String token_type, @JsonProperty("expires_in") int i, @JsonProperty("access_token") String access_token, @JsonProperty("refresh_token") String refresh_token) {
            Intrinsics.checkNotNullParameter(token_type, "token_type");
            Intrinsics.checkNotNullParameter(access_token, "access_token");
            Intrinsics.checkNotNullParameter(refresh_token, "refresh_token");
            this.token_type = token_type;
            this.expires_in = i;
            this.access_token = access_token;
            this.refresh_token = refresh_token;
        }

        public final String getToken_type() {
            return this.token_type;
        }

        public final int getExpires_in() {
            return this.expires_in;
        }

        public final String getAccess_token() {
            return this.access_token;
        }

        public final String getRefresh_token() {
            return this.refresh_token;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalRoot;", "", "data", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalDatum;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalRoot {
        private final List<MalDatum> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MalRoot copy$default(MalRoot malRoot, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = malRoot.data;
            }
            return malRoot.copy(list);
        }

        public final List<MalDatum> component1() {
            return this.data;
        }

        public final MalRoot copy(@JsonProperty("data") List<MalDatum> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new MalRoot(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MalRoot) && Intrinsics.areEqual(this.data, ((MalRoot) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "MalRoot(data=" + this.data + ')';
        }

        public MalRoot(@JsonProperty("data") List<MalDatum> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final List<MalDatum> getData() {
            return this.data;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalDatum;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalNode;", "list_status", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalNode;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;)V", "getList_status", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalNode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalDatum {
        private final MalStatus list_status;
        private final MalNode node;

        public static /* synthetic */ MalDatum copy$default(MalDatum malDatum, MalNode malNode, MalStatus malStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                malNode = malDatum.node;
            }
            if ((i & 2) != 0) {
                malStatus = malDatum.list_status;
            }
            return malDatum.copy(malNode, malStatus);
        }

        public final MalNode component1() {
            return this.node;
        }

        public final MalStatus component2() {
            return this.list_status;
        }

        public final MalDatum copy(@JsonProperty("node") MalNode node, @JsonProperty("list_status") MalStatus list_status) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(list_status, "list_status");
            return new MalDatum(node, list_status);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalDatum) {
                MalDatum malDatum = (MalDatum) obj;
                return Intrinsics.areEqual(this.node, malDatum.node) && Intrinsics.areEqual(this.list_status, malDatum.list_status);
            }
            return false;
        }

        public int hashCode() {
            return (this.node.hashCode() * 31) + this.list_status.hashCode();
        }

        public String toString() {
            return "MalDatum(node=" + this.node + ", list_status=" + this.list_status + ')';
        }

        public MalDatum(@JsonProperty("node") MalNode node, @JsonProperty("list_status") MalStatus list_status) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(list_status, "list_status");
            this.node = node;
            this.list_status = list_status;
        }

        public final MalNode getNode() {
            return this.node;
        }

        public final MalStatus getList_status() {
            return this.list_status;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalNode;", "", "id", "", "title", "", "(ILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalNode {

        /* renamed from: id */
        private final int f10010id;
        private final String title;

        public static /* synthetic */ MalNode copy$default(MalNode malNode, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = malNode.f10010id;
            }
            if ((i2 & 2) != 0) {
                str = malNode.title;
            }
            return malNode.copy(i, str);
        }

        public final int component1() {
            return this.f10010id;
        }

        public final String component2() {
            return this.title;
        }

        public final MalNode copy(@JsonProperty("id") int i, @JsonProperty("title") String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new MalNode(i, title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalNode) {
                MalNode malNode = (MalNode) obj;
                return this.f10010id == malNode.f10010id && Intrinsics.areEqual(this.title, malNode.title);
            }
            return false;
        }

        public int hashCode() {
            return (this.f10010id * 31) + this.title.hashCode();
        }

        public String toString() {
            return "MalNode(id=" + this.f10010id + ", title=" + this.title + ')';
        }

        public MalNode(@JsonProperty("id") int i, @JsonProperty("title") String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.f10010id = i;
            this.title = title;
        }

        public final int getId() {
            return this.f10010id;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "", "status", "", "score", "", "num_episodes_watched", "is_rewatching", "", "updated_at", "(Ljava/lang/String;IIZLjava/lang/String;)V", "()Z", "getNum_episodes_watched", "()I", "getScore", "getStatus", "()Ljava/lang/String;", "getUpdated_at", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalStatus {
        private final boolean is_rewatching;
        private final int num_episodes_watched;
        private final int score;
        private final String status;
        private final String updated_at;

        public static /* synthetic */ MalStatus copy$default(MalStatus malStatus, String str, int i, int i2, boolean z, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = malStatus.status;
            }
            if ((i3 & 2) != 0) {
                i = malStatus.score;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = malStatus.num_episodes_watched;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                z = malStatus.is_rewatching;
            }
            boolean z2 = z;
            if ((i3 & 16) != 0) {
                str2 = malStatus.updated_at;
            }
            return malStatus.copy(str, i4, i5, z2, str2);
        }

        public final String component1() {
            return this.status;
        }

        public final int component2() {
            return this.score;
        }

        public final int component3() {
            return this.num_episodes_watched;
        }

        public final boolean component4() {
            return this.is_rewatching;
        }

        public final String component5() {
            return this.updated_at;
        }

        public final MalStatus copy(@JsonProperty("status") String status, @JsonProperty("score") int i, @JsonProperty("num_episodes_watched") int i2, @JsonProperty("is_rewatching") boolean z, @JsonProperty("updated_at") String updated_at) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(updated_at, "updated_at");
            return new MalStatus(status, i, i2, z, updated_at);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalStatus) {
                MalStatus malStatus = (MalStatus) obj;
                return Intrinsics.areEqual(this.status, malStatus.status) && this.score == malStatus.score && this.num_episodes_watched == malStatus.num_episodes_watched && this.is_rewatching == malStatus.is_rewatching && Intrinsics.areEqual(this.updated_at, malStatus.updated_at);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.status.hashCode() * 31) + this.score) * 31) + this.num_episodes_watched) * 31;
            boolean z = this.is_rewatching;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.updated_at.hashCode();
        }

        public String toString() {
            return "MalStatus(status=" + this.status + ", score=" + this.score + ", num_episodes_watched=" + this.num_episodes_watched + ", is_rewatching=" + this.is_rewatching + ", updated_at=" + this.updated_at + ')';
        }

        public MalStatus(@JsonProperty("status") String status, @JsonProperty("score") int i, @JsonProperty("num_episodes_watched") int i2, @JsonProperty("is_rewatching") boolean z, @JsonProperty("updated_at") String updated_at) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(updated_at, "updated_at");
            this.status = status;
            this.score = i;
            this.num_episodes_watched = i2;
            this.is_rewatching = z;
            this.updated_at = updated_at;
        }

        public final String getStatus() {
            return this.status;
        }

        public final int getScore() {
            return this.score;
        }

        public final int getNum_episodes_watched() {
            return this.num_episodes_watched;
        }

        public final boolean is_rewatching() {
            return this.is_rewatching;
        }

        public final String getUpdated_at() {
            return this.updated_at;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalUser;", "", "id", "", "name", "", FirebaseAnalytics.Param.LOCATION, "joined_at", "picture", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getJoined_at", "()Ljava/lang/String;", "getLocation", "getName", "getPicture", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalUser {

        /* renamed from: id */
        private final int f10012id;
        private final String joined_at;
        private final String location;
        private final String name;
        private final String picture;

        public static /* synthetic */ MalUser copy$default(MalUser malUser, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = malUser.f10012id;
            }
            if ((i2 & 2) != 0) {
                str = malUser.name;
            }
            String str5 = str;
            if ((i2 & 4) != 0) {
                str2 = malUser.location;
            }
            String str6 = str2;
            if ((i2 & 8) != 0) {
                str3 = malUser.joined_at;
            }
            String str7 = str3;
            if ((i2 & 16) != 0) {
                str4 = malUser.picture;
            }
            return malUser.copy(i, str5, str6, str7, str4);
        }

        public final int component1() {
            return this.f10012id;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.location;
        }

        public final String component4() {
            return this.joined_at;
        }

        public final String component5() {
            return this.picture;
        }

        public final MalUser copy(@JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("location") String location, @JsonProperty("joined_at") String joined_at, @JsonProperty("picture") String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(joined_at, "joined_at");
            return new MalUser(i, name, location, joined_at, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalUser) {
                MalUser malUser = (MalUser) obj;
                return this.f10012id == malUser.f10012id && Intrinsics.areEqual(this.name, malUser.name) && Intrinsics.areEqual(this.location, malUser.location) && Intrinsics.areEqual(this.joined_at, malUser.joined_at) && Intrinsics.areEqual(this.picture, malUser.picture);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((this.f10012id * 31) + this.name.hashCode()) * 31) + this.location.hashCode()) * 31) + this.joined_at.hashCode()) * 31;
            String str = this.picture;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "MalUser(id=" + this.f10012id + ", name=" + this.name + ", location=" + this.location + ", joined_at=" + this.joined_at + ", picture=" + this.picture + ')';
        }

        public MalUser(@JsonProperty("id") int i, @JsonProperty("name") String name, @JsonProperty("location") String location, @JsonProperty("joined_at") String joined_at, @JsonProperty("picture") String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(joined_at, "joined_at");
            this.f10012id = i;
            this.name = name;
            this.location = location;
            this.joined_at = joined_at;
            this.picture = str;
        }

        public final int getId() {
            return this.f10012id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getLocation() {
            return this.location;
        }

        public final String getJoined_at() {
            return this.joined_at;
        }

        public final String getPicture() {
            return this.picture;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalMainPicture;", "", "large", "", "medium", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalMainPicture {
        private final String large;
        private final String medium;

        public static /* synthetic */ MalMainPicture copy$default(MalMainPicture malMainPicture, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = malMainPicture.large;
            }
            if ((i & 2) != 0) {
                str2 = malMainPicture.medium;
            }
            return malMainPicture.copy(str, str2);
        }

        public final String component1() {
            return this.large;
        }

        public final String component2() {
            return this.medium;
        }

        public final MalMainPicture copy(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
            return new MalMainPicture(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalMainPicture) {
                MalMainPicture malMainPicture = (MalMainPicture) obj;
                return Intrinsics.areEqual(this.large, malMainPicture.large) && Intrinsics.areEqual(this.medium, malMainPicture.medium);
            }
            return false;
        }

        public int hashCode() {
            String str = this.large;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.medium;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "MalMainPicture(large=" + this.large + ", medium=" + this.medium + ')';
        }

        public MalMainPicture(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
            this.large = str;
            this.medium = str2;
        }

        public final String getLarge() {
            return this.large;
        }

        public final String getMedium() {
            return this.medium;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$SmallMalAnime;", "", "id", "", "title", "", "num_episodes", "my_list_status", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "main_picture", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalMainPicture;", "(ILjava/lang/String;ILcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalMainPicture;)V", "getId", "()I", "getMain_picture", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalMainPicture;", "getMy_list_status", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "getNum_episodes", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SmallMalAnime {

        /* renamed from: id */
        private final int f10014id;
        private final MalMainPicture main_picture;
        private final MalStatus my_list_status;
        private final int num_episodes;
        private final String title;

        public static /* synthetic */ SmallMalAnime copy$default(SmallMalAnime smallMalAnime, int i, String str, int i2, MalStatus malStatus, MalMainPicture malMainPicture, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = smallMalAnime.f10014id;
            }
            if ((i3 & 2) != 0) {
                str = smallMalAnime.title;
            }
            String str2 = str;
            if ((i3 & 4) != 0) {
                i2 = smallMalAnime.num_episodes;
            }
            int i4 = i2;
            if ((i3 & 8) != 0) {
                malStatus = smallMalAnime.my_list_status;
            }
            MalStatus malStatus2 = malStatus;
            if ((i3 & 16) != 0) {
                malMainPicture = smallMalAnime.main_picture;
            }
            return smallMalAnime.copy(i, str2, i4, malStatus2, malMainPicture);
        }

        public final int component1() {
            return this.f10014id;
        }

        public final String component2() {
            return this.title;
        }

        public final int component3() {
            return this.num_episodes;
        }

        public final MalStatus component4() {
            return this.my_list_status;
        }

        public final MalMainPicture component5() {
            return this.main_picture;
        }

        public final SmallMalAnime copy(@JsonProperty("id") int i, @JsonProperty("title") String str, @JsonProperty("num_episodes") int i2, @JsonProperty("my_list_status") MalStatus malStatus, @JsonProperty("main_picture") MalMainPicture malMainPicture) {
            return new SmallMalAnime(i, str, i2, malStatus, malMainPicture);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SmallMalAnime) {
                SmallMalAnime smallMalAnime = (SmallMalAnime) obj;
                return this.f10014id == smallMalAnime.f10014id && Intrinsics.areEqual(this.title, smallMalAnime.title) && this.num_episodes == smallMalAnime.num_episodes && Intrinsics.areEqual(this.my_list_status, smallMalAnime.my_list_status) && Intrinsics.areEqual(this.main_picture, smallMalAnime.main_picture);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f10014id * 31;
            String str = this.title;
            int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.num_episodes) * 31;
            MalStatus malStatus = this.my_list_status;
            int hashCode2 = (hashCode + (malStatus == null ? 0 : malStatus.hashCode())) * 31;
            MalMainPicture malMainPicture = this.main_picture;
            return hashCode2 + (malMainPicture != null ? malMainPicture.hashCode() : 0);
        }

        public String toString() {
            return "SmallMalAnime(id=" + this.f10014id + ", title=" + this.title + ", num_episodes=" + this.num_episodes + ", my_list_status=" + this.my_list_status + ", main_picture=" + this.main_picture + ')';
        }

        public SmallMalAnime(@JsonProperty("id") int i, @JsonProperty("title") String str, @JsonProperty("num_episodes") int i2, @JsonProperty("my_list_status") MalStatus malStatus, @JsonProperty("main_picture") MalMainPicture malMainPicture) {
            this.f10014id = i;
            this.title = str;
            this.num_episodes = i2;
            this.my_list_status = malStatus;
            this.main_picture = malMainPicture;
        }

        public final int getId() {
            return this.f10014id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getNum_episodes() {
            return this.num_episodes;
        }

        public final MalStatus getMy_list_status() {
            return this.my_list_status;
        }

        public final MalMainPicture getMain_picture() {
            return this.main_picture;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalSearchNode;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;)V", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$Node;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalSearchNode {
        private final Node node;

        public static /* synthetic */ MalSearchNode copy$default(MalSearchNode malSearchNode, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                node = malSearchNode.node;
            }
            return malSearchNode.copy(node);
        }

        public final Node component1() {
            return this.node;
        }

        public final MalSearchNode copy(@JsonProperty("node") Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new MalSearchNode(node);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MalSearchNode) && Intrinsics.areEqual(this.node, ((MalSearchNode) obj).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "MalSearchNode(node=" + this.node + ')';
        }

        public MalSearchNode(@JsonProperty("node") Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalSearch;", "", "data", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalSearchNode;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalSearch {
        private final List<MalSearchNode> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MalSearch copy$default(MalSearch malSearch, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = malSearch.data;
            }
            return malSearch.copy(list);
        }

        public final List<MalSearchNode> component1() {
            return this.data;
        }

        public final MalSearch copy(@JsonProperty("data") List<MalSearchNode> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new MalSearch(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MalSearch) && Intrinsics.areEqual(this.data, ((MalSearch) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "MalSearch(data=" + this.data + ')';
        }

        public MalSearch(@JsonProperty("data") List<MalSearchNode> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final List<MalSearchNode> getData() {
            return this.data;
        }
    }

    /* compiled from: MALApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalTitleHolder;", "", "status", "Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "id", "", "name", "", "(Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getStatus", "()Lcom/lagradost/cloudstream3/syncproviders/providers/MALApi$MalStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MalTitleHolder {

        /* renamed from: id */
        private final int f10011id;
        private final String name;
        private final MalStatus status;

        public static /* synthetic */ MalTitleHolder copy$default(MalTitleHolder malTitleHolder, MalStatus malStatus, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                malStatus = malTitleHolder.status;
            }
            if ((i2 & 2) != 0) {
                i = malTitleHolder.f10011id;
            }
            if ((i2 & 4) != 0) {
                str = malTitleHolder.name;
            }
            return malTitleHolder.copy(malStatus, i, str);
        }

        public final MalStatus component1() {
            return this.status;
        }

        public final int component2() {
            return this.f10011id;
        }

        public final String component3() {
            return this.name;
        }

        public final MalTitleHolder copy(MalStatus status, int i, String name) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(name, "name");
            return new MalTitleHolder(status, i, name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MalTitleHolder) {
                MalTitleHolder malTitleHolder = (MalTitleHolder) obj;
                return Intrinsics.areEqual(this.status, malTitleHolder.status) && this.f10011id == malTitleHolder.f10011id && Intrinsics.areEqual(this.name, malTitleHolder.name);
            }
            return false;
        }

        public int hashCode() {
            return (((this.status.hashCode() * 31) + this.f10011id) * 31) + this.name.hashCode();
        }

        public String toString() {
            return "MalTitleHolder(status=" + this.status + ", id=" + this.f10011id + ", name=" + this.name + ')';
        }

        public MalTitleHolder(MalStatus status, int i, String name) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(name, "name");
            this.status = status;
            this.f10011id = i;
            this.name = name;
        }

        public final MalStatus getStatus() {
            return this.status;
        }

        public final int getId() {
            return this.f10011id;
        }

        public final String getName() {
            return this.name;
        }
    }
}
