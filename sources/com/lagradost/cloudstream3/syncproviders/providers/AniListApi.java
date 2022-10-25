package com.lagradost.cloudstream3.syncproviders.providers;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bongngotv2.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.DataStore;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AniListApi.kt */
@Metadata(m108d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b>\u0018\u0000 ^2\u00020\u00012\u00020\u0002:IQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001bH\u0002J!\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010$\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0007H\u0002J\u001b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010$\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0013\u0010/\u001a\u0004\u0018\u000100H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0016J\u001b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010$\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u00105J\u001b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010$\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u00105J\u0010\u00108\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0004H\u0002J\u001d\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0019\u0010=\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u00105J\u0006\u0010>\u001a\u00020\u001fJ\b\u0010?\u001a\u00020\u001fH\u0016J\n\u0010@\u001a\u0004\u0018\u00010AH\u0016J%\u0010B\u001a\u0004\u0018\u00010\u00072\u0006\u0010C\u001a\u00020\u00072\b\b\u0002\u0010D\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJ5\u0010F\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010KJ!\u0010I\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010L\u001a\u000207H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010MJ!\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u00105J\u0019\u0010P\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008d\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi;", "Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI;", FirebaseAnalytics.Param.INDEX, "", "(I)V", "createAccountUrl", "", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", SDKConstants.PARAM_KEY, "getKey", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "redirectUrl", "getRedirectUrl", "requiresLogin", "", "getRequiresLogin", "()Z", "authenticate", "", "checkToken", "getAllSeasons", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonResponse;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnilistAnimeListSmart", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Lists;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnilistListCached", "()[Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Lists;", "getAuth", "getDataAboutId", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListTitleHolder;", "getFullAnilistList", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$FullAnilistList;", "getIdFromUrl", "url", "getResult", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "getUrlFromId", "getUser", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListUser;", "setSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRedirect", "initGetUser", "logOut", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "postApi", "q", "cache", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postDataAboutId", "type", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;", "score", "progress", "(ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "status", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncSearchResult;", "toggleLike", "AniListAvatar", "AniListData", "AniListFavoritesMediaConnection", "AniListFavourites", "AniListRoot", "AniListTitleHolder", "AniListUser", "AniListViewer", "Character", "CharacterConnection", "CharacterEdge", "CharacterImage", "CharacterName", "Companion", "CompletedAt", "CoverImage", "Data", "Entries", "FullAnilistList", "GetDataData", "GetDataMedia", "GetDataMediaListEntry", "GetDataRoot", "GetSearchData", "GetSearchMedia", "GetSearchPage", "GetSearchRoot", "GetSearchTitle", "LikeAnime", "LikeData", "LikeFavourites", "LikeNode", "LikePageInfo", "LikeRoot", "LikeViewer", "Lists", "Media", "MediaCoverImage", "MediaListCollection", "MediaRecommendation", "MediaTitle", "MediaTrailer", "Nodes", "Recommendation", "RecommendationConnection", "RecommendationEdge", "Recommendations", "SeasonData", "SeasonEdge", "SeasonEdges", "SeasonMedia", "SeasonNextAiringEpisode", "SeasonNode", "SeasonResponse", "Staff", "StaffImage", "StaffName", "StartedAt", "Title", "TrailerObject", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class AniListApi extends AccountManager implements SyncAPI {
    public static final String ANILIST_CACHED_LIST = "anilist_cached_list";
    public static final String ANILIST_SHOULD_UPDATE_LIST = "anilist_should_update_list";
    public static final String ANILIST_TOKEN_KEY = "anilist_token";
    public static final String ANILIST_UNIXTIME_KEY = "anilist_unixtime";
    public static final String ANILIST_USER_KEY = "anilist_user";
    public static final Companion Companion = new Companion(null);
    private static final String[] aniListStatusString;
    private static final JsonMapper mapper;
    private final String createAccountUrl;
    private final int icon;
    private final String idPrefix;
    private final String key;
    private String mainUrl;
    private String name;
    private final String redirectUrl;
    private final boolean requiresLogin;

    public AniListApi(int i) {
        super(i);
        this.name = "AniList";
        this.key = "6871";
        this.redirectUrl = "anilistlogin";
        this.idPrefix = "anilist";
        this.mainUrl = "https://anilist.co";
        this.icon = R.drawable.ic_anilist_icon;
        this.requiresLogin = true;
        this.createAccountUrl = getMainUrl() + "/signup";
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
            java.lang.String r4 = "anilist_user"
            java.lang.String r1 = r3.getFolderName(r1, r4)
            android.content.SharedPreferences r0 = r3.getSharedPrefs(r0)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Exception -> L35
            if (r0 != 0) goto L20
            goto L35
        L20:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L35
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r3.getMapper()     // Catch: java.lang.Exception -> L35
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser> r3 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser.class
            java.lang.Object r0 = r1.readValue(r0, r3)     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L35
            goto L36
        L35:
            r0 = r2
        L36:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser) r0
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
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.loginInfo():com.lagradost.cloudstream3.syncproviders.AuthAPI$LoginInfo");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        removeAccountKeys();
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public void authenticate() {
        AcraApplication.Companion.openBrowser("https://anilist.co/api/v2/oauth/authorize?client_id=" + getKey() + "&response_type=token");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleRedirect(java.lang.String r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$handleRedirect$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$handleRedirect$1 r2 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$handleRedirect$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$handleRedirect$1 r2 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$handleRedirect$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L38
            if (r4 != r6) goto L30
            kotlin.ResultKt.throwOnFailure(r1)
            goto Lb4
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.AppUtils r1 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            java.net.URL r4 = new java.net.URL
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "cloudstreamapp"
            java.lang.String r9 = "https"
            r7 = r20
            java.lang.String r13 = kotlin.text.StringsKt.replace$default(r7, r8, r9, r10, r11, r12)
            r16 = 0
            r17 = 4
            r18 = 0
            java.lang.String r14 = "/#"
            java.lang.String r15 = "?"
            java.lang.String r7 = kotlin.text.StringsKt.replace$default(r13, r14, r15, r16, r17, r18)
            r4.<init>(r7)
            java.util.Map r1 = r1.splitQuery(r4)
            java.lang.String r4 = "access_token"
            java.lang.Object r4 = r1.get(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r7 = "expires_in"
            java.lang.Object r1 = r1.get(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.lagradost.cloudstream3.syncproviders.AccountManager$Companion r7 = com.lagradost.cloudstream3.syncproviders.AccountManager.Companion
            long r7 = r7.getUnixTime()
            long r9 = java.lang.Long.parseLong(r1)
            long r7 = r7 + r9
            r19.switchToNewAccount()
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r9 = r19.getAccountId()
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.boxing.boxLong(r7)
            java.lang.String r8 = "anilist_unixtime"
            r1.setKey(r9, r8, r7)
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r7 = r19.getAccountId()
            java.lang.String r8 = "anilist_token"
            r1.setKey(r7, r8, r4)
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r6)
            java.lang.String r7 = "anilist_should_update_list"
            r1.setKey(r7, r4)
            r1 = 0
            r2.label = r6
            java.lang.Object r1 = getUser$default(r0, r5, r2, r6, r1)
            if (r1 != r3) goto Lb4
            return r3
        Lb4:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser r1 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser) r1
            if (r1 == 0) goto Lb9
            r5 = 1
        Lb9:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.handleRedirect(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    public String getIdFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.removeSuffix(StringsKt.removePrefix(url, (CharSequence) (getMainUrl() + "/anime/")), (CharSequence) "/");
    }

    private final String getUrlFromId(int i) {
        return getMainUrl() + "/anime/" + i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r19, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncSearchResult>> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$search$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$search$1 r2 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$search$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$search$1 r2 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi r2 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L4d
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion r1 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion
            r2.L$0 = r0
            r2.label = r5
            r4 = r19
            java.lang.Object r1 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.access$searchShows(r1, r4, r2)
            if (r1 != r3) goto L4c
            return r3
        L4c:
            r2 = r0
        L4d:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$GetSearchRoot r1 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.GetSearchRoot) r1
            r3 = 0
            if (r1 != 0) goto L53
            return r3
        L53:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$GetSearchPage r1 = r1.getData()
            if (r1 == 0) goto Lc0
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$GetSearchData r1 = r1.getPage()
            if (r1 == 0) goto Lc0
            java.util.List r1 = r1.getMedia()
            if (r1 == 0) goto Lc0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L78:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto Lbc
            java.lang.Object r5 = r1.next()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$GetSearchMedia r5 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.GetSearchMedia) r5
            com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncSearchResult r15 = new com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncSearchResult
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$GetSearchTitle r6 = r5.getTitle()
            java.lang.String r7 = r6.getRomaji()
            if (r7 != 0) goto L91
            return r3
        L91:
            java.lang.String r8 = r2.getName()
            int r6 = r5.getId()
            java.lang.String r9 = java.lang.String.valueOf(r6)
            int r6 = r5.getId()
            java.lang.String r10 = r2.getUrlFromId(r6)
            java.lang.String r11 = r5.getBannerImage()
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = 0
            r16 = 480(0x1e0, float:6.73E-43)
            r17 = 0
            r6 = r15
            r3 = r15
            r15 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r4.add(r3)
            r3 = 0
            goto L78
        Lbc:
            r3 = r4
            java.util.List r3 = (java.util.List) r3
            goto Lc1
        Lc0:
            r3 = 0
        Lc1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ca, code lost:
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0128, code lost:
        if (r11 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0239 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0192  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getResult(java.lang.String r42, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncResult> r43) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getResult(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getStatus(java.lang.String r12, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncStatus> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getStatus$1
            if (r0 == 0) goto L14
            r0 = r13
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getStatus$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getStatus$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getStatus$1
            r0.<init>(r11, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r13)
            goto L49
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Integer r12 = kotlin.text.StringsKt.toIntOrNull(r12)
            if (r12 == 0) goto L6f
            int r12 = r12.intValue()
            r0.label = r3
            java.lang.Object r13 = r11.getDataAboutId(r12, r0)
            if (r13 != r1) goto L49
            return r1
        L49:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListTitleHolder r13 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListTitleHolder) r13
            if (r13 != 0) goto L4e
            return r4
        L4e:
            java.lang.Integer r7 = r13.getScore()
            java.lang.Integer r8 = r13.getProgress()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$AniListStatusType r12 = r13.getType()
            if (r12 == 0) goto L6f
            int r6 = r12.getValue()
            java.lang.Boolean r9 = r13.isFavourite()
            java.lang.Integer r10 = r13.getEpisodes()
            com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncStatus r12 = new com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncStatus
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            return r12
        L6f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.SyncAPI
    public Object score(String str, SyncAPI.SyncStatus syncStatus, Continuation<? super Boolean> continuation) {
        Integer intOrNull = StringsKt.toIntOrNull(str);
        if (intOrNull != null) {
            return postDataAboutId(intOrNull.intValue(), Companion.fromIntToAnimeStatus(syncStatus.getStatus()), syncStatus.getScore(), syncStatus.getWatchedEpisodes(), continuation);
        }
        return boxing.boxBoolean(false);
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J/\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion;", "", "()V", "ANILIST_CACHED_LIST", "", "ANILIST_SHOULD_UPDATE_LIST", "ANILIST_TOKEN_KEY", "ANILIST_UNIXTIME_KEY", "ANILIST_USER_KEY", "aniListStatusString", "", "[Ljava/lang/String;", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "convertAnilistStringToStatus", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;", TypedValues.Custom.S_STRING, "fixName", "name", "fromIntToAnimeStatus", "inp", "", "getSeason", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonResponse;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShowId", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchMedia;", "malId", "year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchShows", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchRoot;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AniListStatusType", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String fixName(String str) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = str.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return new Regex("[^a-zA-Z0-9]").replace(StringsKt.replace$default(lowerCase, " ", "", false, 4, (Object) null), "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object searchShows(java.lang.String r24, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.GetSearchRoot> r25) {
            /*
                Method dump skipped, instructions count: 228
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.searchShows(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x010a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0105 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getShowId(java.lang.String r25, java.lang.String r26, java.lang.Integer r27, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.GetSearchMedia> r28) {
            /*
                Method dump skipped, instructions count: 413
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.getShowId(java.lang.String, java.lang.String, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* compiled from: AniListApi.kt */
        @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "Watching", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "Paused", "Dropped", "Planning", "ReWatching", "None", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public enum AniListStatusType {
            Watching(0),
            Completed(1),
            Paused(2),
            Dropped(3),
            Planning(4),
            ReWatching(5),
            None(-1);
            
            private int value;

            AniListStatusType(int i) {
                this.value = i;
            }

            public final int getValue() {
                return this.value;
            }

            public final void setValue(int i) {
                this.value = i;
            }
        }

        public final AniListStatusType fromIntToAnimeStatus(int i) {
            switch (i) {
                case -1:
                    return AniListStatusType.None;
                case 0:
                    return AniListStatusType.Watching;
                case 1:
                    return AniListStatusType.Completed;
                case 2:
                    return AniListStatusType.Paused;
                case 3:
                    return AniListStatusType.Dropped;
                case 4:
                    return AniListStatusType.Planning;
                case 5:
                    return AniListStatusType.ReWatching;
                default:
                    return AniListStatusType.None;
            }
        }

        public final AniListStatusType convertAnilistStringToStatus(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return fromIntToAnimeStatus(ArraysKt.indexOf(AniListApi.aniListStatusString, string));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getSeason(int r24, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonResponse> r25) {
            /*
                r23 = this;
                r0 = r25
                boolean r1 = r0 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$1
                if (r1 == 0) goto L18
                r1 = r0
                com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$1 r1 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 & r3
                if (r2 == 0) goto L18
                int r0 = r1.label
                int r0 = r0 - r3
                r1.label = r0
                r2 = r23
                goto L1f
            L18:
                com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$1 r1 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$1
                r2 = r23
                r1.<init>(r2, r0)
            L1f:
                java.lang.Object r0 = r1.result
                java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                r15 = 1
                if (r3 == 0) goto L38
                if (r3 != r15) goto L30
                kotlin.ResultKt.throwOnFailure(r0)
                goto L8b
            L30:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L38:
                kotlin.ResultKt.throwOnFailure(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "\n               query ($id: Int = "
                r0.append(r3)
                r3 = r24
                r0.append(r3)
                java.lang.String r3 = ") {\n                   Media (id: $id, type: ANIME) {\n                       id\n                       idMal\n                       coverImage {\n                           extraLarge\n                           large\n                           medium\n                           color\n                       }\n                       title {\n                           romaji\n                           english\n                           native\n                           userPreferred\n                       }\n                       duration\n                       episodes\n                       genres\n                       synonyms\n                       averageScore\n                       isAdult\n                       description(asHtml: false)\n                       characters(sort: ROLE page: 1 perPage: 20) {\n                           edges {\n                               role\n                               voiceActors {\n                                   name {\n                                       userPreferred\n                                       full\n                                       native\n                                   }\n                                   age\n                                   image {\n                                       large\n                                       medium\n                                   }\n                               }\n                               node {\n                                   name {\n                                       userPreferred\n                                       full\n                                       native\n                                   }\n                                   age\n                                   image {\n                                       large\n                                       medium\n                                   }\n                               }\n                           }\n                       }\n                       trailer {\n                           id\n                           site\n                           thumbnail\n                       }\n                       relations {\n                           edges {\n                                id\n                                relationType(version: 2)\n                                node {\n                                     id\n                                     coverImage {\n                                         extraLarge\n                                         large\n                                         medium\n                                         color\n                                     }\n                                }\n                           }\n                       }\n                       recommendations {\n                           edges {\n                               node {\n                                   mediaRecommendation {\n                                       id\n                                       coverImage {\n                                           extraLarge\n                                           large\n                                           medium\n                                           color\n                                       }\n                                       title {\n                                           romaji\n                                           english\n                                           native\n                                           userPreferred\n                                       }\n                                   }\n                               }\n                           }\n                       }\n                       nextAiringEpisode {\n                           timeUntilAiring\n                           episode\n                       }\n                       format\n                   }\n               }\n        "
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                com.lagradost.cloudstream3.utils.Extensions$RequestCustom r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                java.lang.String r9 = "query"
                kotlin.Pair r0 = kotlin.TuplesKt.m100to(r9, r0)
                java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r0)
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r0 = 0
                r5 = 1
                r15 = r0
                r16 = 0
                r18 = 0
                r19 = 0
                r21 = 31710(0x7bde, float:4.4435E-41)
                r22 = 0
                r1.label = r5
                java.lang.String r0 = "https://graphql.anilist.co"
                r5 = r4
                r4 = r0
                r20 = r1
                r0 = r5
                r5 = 0
                java.lang.Object r1 = com.lagradost.nicehttp.Requests.post$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22)
                if (r1 != r0) goto L8a
                return r0
            L8a:
                r0 = r1
            L8b:
                com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
                java.lang.String r0 = r0.getText()
                com.lagradost.cloudstream3.utils.AppUtils r1 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
                r1 = 0
                if (r0 != 0) goto L97
                goto Laa
            L97:
                com.fasterxml.jackson.databind.json.JsonMapper r3 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Exception -> La9
                com.fasterxml.jackson.databind.ObjectMapper r3 = (com.fasterxml.jackson.databind.ObjectMapper) r3     // Catch: java.lang.Exception -> La9
                com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$$inlined$tryParseJson$1 r4 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$getSeason$$inlined$tryParseJson$1     // Catch: java.lang.Exception -> La9
                r4.<init>()     // Catch: java.lang.Exception -> La9
                com.fasterxml.jackson.core.type.TypeReference r4 = (com.fasterxml.jackson.core.type.TypeReference) r4     // Catch: java.lang.Exception -> La9
                java.lang.Object r1 = r3.readValue(r0, r4)     // Catch: java.lang.Exception -> La9
                goto Laa
            La9:
            Laa:
                com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonResponse r1 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonResponse) r1
                if (r1 == 0) goto Laf
                return r1
            Laf:
                com.lagradost.cloudstream3.ErrorLoadingException r1 = new com.lagradost.cloudstream3.ErrorLoadingException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Error parsing "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.getSeason(int, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    static {
        JsonMapper build = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
        Intrinsics.checkNotNull(build);
        mapper = build;
        aniListStatusString = new String[]{"CURRENT", "COMPLETED", "PAUSED", "DROPPED", "PLANNING", "REPEATING"};
    }

    public final void initGetUser() {
        if (getAuth() == null) {
            return;
        }
        Coroutines.INSTANCE.ioSafe(new AniListApi$initGetUser$1(this, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (r5 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean checkToken() {
        /*
            r8 = this;
            com.lagradost.cloudstream3.syncproviders.AccountManager$Companion r0 = com.lagradost.cloudstream3.syncproviders.AccountManager.Companion
            long r0 = r0.getUnixTime()
            com.lagradost.cloudstream3.AcraApplication$Companion r2 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r3 = r8.getAccountId()
            r4 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            android.content.Context r2 = r2.getContext()
            r5 = 0
            if (r2 == 0) goto L47
            com.lagradost.cloudstream3.utils.DataStore r6 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r7 = "anilist_unixtime"
            java.lang.String r3 = r6.getFolderName(r3, r7)
            android.content.SharedPreferences r2 = r6.getSharedPrefs(r2)     // Catch: java.lang.Exception -> L43
            java.lang.String r2 = r2.getString(r3, r5)     // Catch: java.lang.Exception -> L43
            if (r2 != 0) goto L2d
            r5 = r4
            goto L44
        L2d:
            java.lang.String r3 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L43
            com.fasterxml.jackson.databind.json.JsonMapper r3 = r6.getMapper()     // Catch: java.lang.Exception -> L43
            java.lang.Class<java.lang.Long> r6 = java.lang.Long.class
            java.lang.Object r2 = r3.readValue(r2, r6)     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L43
            r5 = r2
            goto L44
        L43:
        L44:
            if (r5 != 0) goto L47
            goto L48
        L47:
            r4 = r5
        L48:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            long r2 = r4.longValue()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L57
            r0 = 1
            goto L58
        L57:
            r0 = 0
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.checkToken():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDataAboutId(int r11, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListTitleHolder> r12) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getDataAboutId(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getAuth() {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String accountId = getAccountId();
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(accountId, ANILIST_TOKEN_KEY), null);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object postApi(java.lang.String r24, boolean r25, kotlin.coroutines.Continuation<? super java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.postApi(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object postApi$default(AniListApi aniListApi, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return aniListApi.postApi(str, z, continuation);
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJH\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;", "", "id", "", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "idMal", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "averageScore", "(ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/Integer;)V", "getAverageScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getId", "()I", "getIdMal", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MediaRecommendation {
        private final Integer averageScore;
        private final CoverImage coverImage;

        /* renamed from: id */
        private final int f9999id;
        private final Integer idMal;
        private final Title title;

        public static /* synthetic */ MediaRecommendation copy$default(MediaRecommendation mediaRecommendation, int i, Title title, Integer num, CoverImage coverImage, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = mediaRecommendation.f9999id;
            }
            if ((i2 & 2) != 0) {
                title = mediaRecommendation.title;
            }
            Title title2 = title;
            if ((i2 & 4) != 0) {
                num = mediaRecommendation.idMal;
            }
            Integer num3 = num;
            if ((i2 & 8) != 0) {
                coverImage = mediaRecommendation.coverImage;
            }
            CoverImage coverImage2 = coverImage;
            if ((i2 & 16) != 0) {
                num2 = mediaRecommendation.averageScore;
            }
            return mediaRecommendation.copy(i, title2, num3, coverImage2, num2);
        }

        public final int component1() {
            return this.f9999id;
        }

        public final Title component2() {
            return this.title;
        }

        public final Integer component3() {
            return this.idMal;
        }

        public final CoverImage component4() {
            return this.coverImage;
        }

        public final Integer component5() {
            return this.averageScore;
        }

        public final MediaRecommendation copy(@JsonProperty("id") int i, @JsonProperty("title") Title title, @JsonProperty("idMal") Integer num, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("averageScore") Integer num2) {
            return new MediaRecommendation(i, title, num, coverImage, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MediaRecommendation) {
                MediaRecommendation mediaRecommendation = (MediaRecommendation) obj;
                return this.f9999id == mediaRecommendation.f9999id && Intrinsics.areEqual(this.title, mediaRecommendation.title) && Intrinsics.areEqual(this.idMal, mediaRecommendation.idMal) && Intrinsics.areEqual(this.coverImage, mediaRecommendation.coverImage) && Intrinsics.areEqual(this.averageScore, mediaRecommendation.averageScore);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f9999id * 31;
            Title title = this.title;
            int hashCode = (i + (title == null ? 0 : title.hashCode())) * 31;
            Integer num = this.idMal;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            CoverImage coverImage = this.coverImage;
            int hashCode3 = (hashCode2 + (coverImage == null ? 0 : coverImage.hashCode())) * 31;
            Integer num2 = this.averageScore;
            return hashCode3 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "MediaRecommendation(id=" + this.f9999id + ", title=" + this.title + ", idMal=" + this.idMal + ", coverImage=" + this.coverImage + ", averageScore=" + this.averageScore + ')';
        }

        public MediaRecommendation(@JsonProperty("id") int i, @JsonProperty("title") Title title, @JsonProperty("idMal") Integer num, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("averageScore") Integer num2) {
            this.f9999id = i;
            this.title = title;
            this.idMal = num;
            this.coverImage = coverImage;
            this.averageScore = num2;
        }

        public final int getId() {
            return this.f9999id;
        }

        public final Title getTitle() {
            return this.title;
        }

        public final Integer getIdMal() {
            return this.idMal;
        }

        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        public final Integer getAverageScore() {
            return this.averageScore;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$FullAnilistList;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Data;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Data;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class FullAnilistList {
        private final Data data;

        public static /* synthetic */ FullAnilistList copy$default(FullAnilistList fullAnilistList, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                data = fullAnilistList.data;
            }
            return fullAnilistList.copy(data);
        }

        public final Data component1() {
            return this.data;
        }

        public final FullAnilistList copy(@JsonProperty("data") Data data) {
            return new FullAnilistList(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FullAnilistList) && Intrinsics.areEqual(this.data, ((FullAnilistList) obj).data);
        }

        public int hashCode() {
            Data data = this.data;
            if (data == null) {
                return 0;
            }
            return data.hashCode();
        }

        public String toString() {
            return "FullAnilistList(data=" + this.data + ')';
        }

        public FullAnilistList(@JsonProperty("data") Data data) {
            this.data = data;
        }

        public final Data getData() {
            return this.data;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CompletedAt;", "", "year", "", "month", "day", "(III)V", "getDay", "()I", "getMonth", "getYear", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CompletedAt {
        private final int day;
        private final int month;
        private final int year;

        public static /* synthetic */ CompletedAt copy$default(CompletedAt completedAt, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = completedAt.year;
            }
            if ((i4 & 2) != 0) {
                i2 = completedAt.month;
            }
            if ((i4 & 4) != 0) {
                i3 = completedAt.day;
            }
            return completedAt.copy(i, i2, i3);
        }

        public final int component1() {
            return this.year;
        }

        public final int component2() {
            return this.month;
        }

        public final int component3() {
            return this.day;
        }

        public final CompletedAt copy(@JsonProperty("year") int i, @JsonProperty("month") int i2, @JsonProperty("day") int i3) {
            return new CompletedAt(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CompletedAt) {
                CompletedAt completedAt = (CompletedAt) obj;
                return this.year == completedAt.year && this.month == completedAt.month && this.day == completedAt.day;
            }
            return false;
        }

        public int hashCode() {
            return (((this.year * 31) + this.month) * 31) + this.day;
        }

        public String toString() {
            return "CompletedAt(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ')';
        }

        public CompletedAt(@JsonProperty("year") int i, @JsonProperty("month") int i2, @JsonProperty("day") int i3) {
            this.year = i;
            this.month = i2;
            this.day = i3;
        }

        public final int getYear() {
            return this.year;
        }

        public final int getMonth() {
            return this.month;
        }

        public final int getDay() {
            return this.day;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;", "", "year", "", "month", "day", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "getMonth", "getYear", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class StartedAt {
        private final String day;
        private final String month;
        private final String year;

        public static /* synthetic */ StartedAt copy$default(StartedAt startedAt, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startedAt.year;
            }
            if ((i & 2) != 0) {
                str2 = startedAt.month;
            }
            if ((i & 4) != 0) {
                str3 = startedAt.day;
            }
            return startedAt.copy(str, str2, str3);
        }

        public final String component1() {
            return this.year;
        }

        public final String component2() {
            return this.month;
        }

        public final String component3() {
            return this.day;
        }

        public final StartedAt copy(@JsonProperty("year") String str, @JsonProperty("month") String str2, @JsonProperty("day") String str3) {
            return new StartedAt(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartedAt) {
                StartedAt startedAt = (StartedAt) obj;
                return Intrinsics.areEqual(this.year, startedAt.year) && Intrinsics.areEqual(this.month, startedAt.month) && Intrinsics.areEqual(this.day, startedAt.day);
            }
            return false;
        }

        public int hashCode() {
            String str = this.year;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.month;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.day;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "StartedAt(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ')';
        }

        public StartedAt(@JsonProperty("year") String str, @JsonProperty("month") String str2, @JsonProperty("day") String str3) {
            this.year = str;
            this.month = str2;
            this.day = str3;
        }

        public final String getYear() {
            return this.year;
        }

        public final String getMonth() {
            return this.month;
        }

        public final String getDay() {
            return this.day;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "", "english", "", "romaji", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnglish", "()Ljava/lang/String;", "getRomaji", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Title {
        private final String english;
        private final String romaji;

        public static /* synthetic */ Title copy$default(Title title, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = title.english;
            }
            if ((i & 2) != 0) {
                str2 = title.romaji;
            }
            return title.copy(str, str2);
        }

        public final String component1() {
            return this.english;
        }

        public final String component2() {
            return this.romaji;
        }

        public final Title copy(@JsonProperty("english") String str, @JsonProperty("romaji") String str2) {
            return new Title(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Title) {
                Title title = (Title) obj;
                return Intrinsics.areEqual(this.english, title.english) && Intrinsics.areEqual(this.romaji, title.romaji);
            }
            return false;
        }

        public int hashCode() {
            String str = this.english;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.romaji;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Title(english=" + this.english + ", romaji=" + this.romaji + ')';
        }

        public Title(@JsonProperty("english") String str, @JsonProperty("romaji") String str2) {
            this.english = str;
            this.romaji = str2;
        }

        public final String getEnglish() {
            return this.english;
        }

        public final String getRomaji() {
            return this.romaji;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "", "medium", "", "large", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CoverImage {
        private final String large;
        private final String medium;

        public static /* synthetic */ CoverImage copy$default(CoverImage coverImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = coverImage.medium;
            }
            if ((i & 2) != 0) {
                str2 = coverImage.large;
            }
            return coverImage.copy(str, str2);
        }

        public final String component1() {
            return this.medium;
        }

        public final String component2() {
            return this.large;
        }

        public final CoverImage copy(@JsonProperty("medium") String str, @JsonProperty("large") String str2) {
            return new CoverImage(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CoverImage) {
                CoverImage coverImage = (CoverImage) obj;
                return Intrinsics.areEqual(this.medium, coverImage.medium) && Intrinsics.areEqual(this.large, coverImage.large);
            }
            return false;
        }

        public int hashCode() {
            String str = this.medium;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.large;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CoverImage(medium=" + this.medium + ", large=" + this.large + ')';
        }

        public CoverImage(@JsonProperty("medium") String str, @JsonProperty("large") String str2) {
            this.medium = str;
            this.large = str2;
        }

        public final String getMedium() {
            return this.medium;
        }

        public final String getLarge() {
            return this.large;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fHÆ\u0003J\u0080\u0001\u0010/\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Media;", "", "id", "", "idMal", "season", "", "seasonYear", "format", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "synonyms", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)V", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getEpisodes", "()I", "getFormat", "()Ljava/lang/String;", "getId", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getSeason", "getSeasonYear", "getSynonyms", "()Ljava/util/List;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Media;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Media {
        private final CoverImage coverImage;
        private final int episodes;
        private final String format;

        /* renamed from: id */
        private final int f9998id;
        private final Integer idMal;
        private final SeasonNextAiringEpisode nextAiringEpisode;
        private final String season;
        private final int seasonYear;
        private final List<String> synonyms;
        private final Title title;

        public final int component1() {
            return this.f9998id;
        }

        public final SeasonNextAiringEpisode component10() {
            return this.nextAiringEpisode;
        }

        public final Integer component2() {
            return this.idMal;
        }

        public final String component3() {
            return this.season;
        }

        public final int component4() {
            return this.seasonYear;
        }

        public final String component5() {
            return this.format;
        }

        public final int component6() {
            return this.episodes;
        }

        public final Title component7() {
            return this.title;
        }

        public final CoverImage component8() {
            return this.coverImage;
        }

        public final List<String> component9() {
            return this.synonyms;
        }

        public final Media copy(@JsonProperty("id") int i, @JsonProperty("idMal") Integer num, @JsonProperty("season") String str, @JsonProperty("seasonYear") int i2, @JsonProperty("format") String str2, @JsonProperty("episodes") int i3, @JsonProperty("title") Title title, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("synonyms") List<String> synonyms, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(coverImage, "coverImage");
            Intrinsics.checkNotNullParameter(synonyms, "synonyms");
            return new Media(i, num, str, i2, str2, i3, title, coverImage, synonyms, seasonNextAiringEpisode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Media) {
                Media media = (Media) obj;
                return this.f9998id == media.f9998id && Intrinsics.areEqual(this.idMal, media.idMal) && Intrinsics.areEqual(this.season, media.season) && this.seasonYear == media.seasonYear && Intrinsics.areEqual(this.format, media.format) && this.episodes == media.episodes && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.coverImage, media.coverImage) && Intrinsics.areEqual(this.synonyms, media.synonyms) && Intrinsics.areEqual(this.nextAiringEpisode, media.nextAiringEpisode);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f9998id * 31;
            Integer num = this.idMal;
            int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.season;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.seasonYear) * 31;
            String str2 = this.format;
            int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.episodes) * 31) + this.title.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + this.synonyms.hashCode()) * 31;
            SeasonNextAiringEpisode seasonNextAiringEpisode = this.nextAiringEpisode;
            return hashCode3 + (seasonNextAiringEpisode != null ? seasonNextAiringEpisode.hashCode() : 0);
        }

        public String toString() {
            return "Media(id=" + this.f9998id + ", idMal=" + this.idMal + ", season=" + this.season + ", seasonYear=" + this.seasonYear + ", format=" + this.format + ", episodes=" + this.episodes + ", title=" + this.title + ", coverImage=" + this.coverImage + ", synonyms=" + this.synonyms + ", nextAiringEpisode=" + this.nextAiringEpisode + ')';
        }

        public Media(@JsonProperty("id") int i, @JsonProperty("idMal") Integer num, @JsonProperty("season") String str, @JsonProperty("seasonYear") int i2, @JsonProperty("format") String str2, @JsonProperty("episodes") int i3, @JsonProperty("title") Title title, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("synonyms") List<String> synonyms, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(coverImage, "coverImage");
            Intrinsics.checkNotNullParameter(synonyms, "synonyms");
            this.f9998id = i;
            this.idMal = num;
            this.season = str;
            this.seasonYear = i2;
            this.format = str2;
            this.episodes = i3;
            this.title = title;
            this.coverImage = coverImage;
            this.synonyms = synonyms;
            this.nextAiringEpisode = seasonNextAiringEpisode;
        }

        public final int getId() {
            return this.f9998id;
        }

        public final Integer getIdMal() {
            return this.idMal;
        }

        public final String getSeason() {
            return this.season;
        }

        public final int getSeasonYear() {
            return this.seasonYear;
        }

        public final String getFormat() {
            return this.format;
        }

        public final int getEpisodes() {
            return this.episodes;
        }

        public final Title getTitle() {
            return this.title;
        }

        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        public final SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J[\u0010'\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Entries;", "", "status", "", "completedAt", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CompletedAt;", "startedAt", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;", "updatedAt", "", "progress", "score", "private", "", "media", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Media;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CompletedAt;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;IIIZLcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Media;)V", "getCompletedAt", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CompletedAt;", "getMedia", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Media;", "getPrivate", "()Z", "getProgress", "()I", "getScore", "getStartedAt", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;", "getStatus", "()Ljava/lang/String;", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Entries {
        private final CompletedAt completedAt;
        private final Media media;

        /* renamed from: private  reason: not valid java name */
        private final boolean f10818private;
        private final int progress;
        private final int score;
        private final StartedAt startedAt;
        private final String status;
        private final int updatedAt;

        public final String component1() {
            return this.status;
        }

        public final CompletedAt component2() {
            return this.completedAt;
        }

        public final StartedAt component3() {
            return this.startedAt;
        }

        public final int component4() {
            return this.updatedAt;
        }

        public final int component5() {
            return this.progress;
        }

        public final int component6() {
            return this.score;
        }

        public final boolean component7() {
            return this.f10818private;
        }

        public final Media component8() {
            return this.media;
        }

        public final Entries copy(@JsonProperty("status") String str, @JsonProperty("completedAt") CompletedAt completedAt, @JsonProperty("startedAt") StartedAt startedAt, @JsonProperty("updatedAt") int i, @JsonProperty("progress") int i2, @JsonProperty("score") int i3, @JsonProperty("private") boolean z, @JsonProperty("media") Media media) {
            Intrinsics.checkNotNullParameter(completedAt, "completedAt");
            Intrinsics.checkNotNullParameter(startedAt, "startedAt");
            Intrinsics.checkNotNullParameter(media, "media");
            return new Entries(str, completedAt, startedAt, i, i2, i3, z, media);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Entries) {
                Entries entries = (Entries) obj;
                return Intrinsics.areEqual(this.status, entries.status) && Intrinsics.areEqual(this.completedAt, entries.completedAt) && Intrinsics.areEqual(this.startedAt, entries.startedAt) && this.updatedAt == entries.updatedAt && this.progress == entries.progress && this.score == entries.score && this.f10818private == entries.f10818private && Intrinsics.areEqual(this.media, entries.media);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.status;
            int hashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + this.completedAt.hashCode()) * 31) + this.startedAt.hashCode()) * 31) + this.updatedAt) * 31) + this.progress) * 31) + this.score) * 31;
            boolean z = this.f10818private;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.media.hashCode();
        }

        public String toString() {
            return "Entries(status=" + this.status + ", completedAt=" + this.completedAt + ", startedAt=" + this.startedAt + ", updatedAt=" + this.updatedAt + ", progress=" + this.progress + ", score=" + this.score + ", private=" + this.f10818private + ", media=" + this.media + ')';
        }

        public Entries(@JsonProperty("status") String str, @JsonProperty("completedAt") CompletedAt completedAt, @JsonProperty("startedAt") StartedAt startedAt, @JsonProperty("updatedAt") int i, @JsonProperty("progress") int i2, @JsonProperty("score") int i3, @JsonProperty("private") boolean z, @JsonProperty("media") Media media) {
            Intrinsics.checkNotNullParameter(completedAt, "completedAt");
            Intrinsics.checkNotNullParameter(startedAt, "startedAt");
            Intrinsics.checkNotNullParameter(media, "media");
            this.status = str;
            this.completedAt = completedAt;
            this.startedAt = startedAt;
            this.updatedAt = i;
            this.progress = i2;
            this.score = i3;
            this.f10818private = z;
            this.media = media;
        }

        public final String getStatus() {
            return this.status;
        }

        public final CompletedAt getCompletedAt() {
            return this.completedAt;
        }

        public final StartedAt getStartedAt() {
            return this.startedAt;
        }

        public final int getUpdatedAt() {
            return this.updatedAt;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final int getScore() {
            return this.score;
        }

        public final boolean getPrivate() {
            return this.f10818private;
        }

        public final Media getMedia() {
            return this.media;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Lists;", "", "status", "", "entries", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Entries;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntries", "()Ljava/util/List;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Lists {
        private final List<Entries> entries;
        private final String status;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Lists copy$default(Lists lists, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lists.status;
            }
            if ((i & 2) != 0) {
                list = lists.entries;
            }
            return lists.copy(str, list);
        }

        public final String component1() {
            return this.status;
        }

        public final List<Entries> component2() {
            return this.entries;
        }

        public final Lists copy(@JsonProperty("status") String str, @JsonProperty("entries") List<Entries> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new Lists(str, entries);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Lists) {
                Lists lists = (Lists) obj;
                return Intrinsics.areEqual(this.status, lists.status) && Intrinsics.areEqual(this.entries, lists.entries);
            }
            return false;
        }

        public int hashCode() {
            String str = this.status;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.entries.hashCode();
        }

        public String toString() {
            return "Lists(status=" + this.status + ", entries=" + this.entries + ')';
        }

        public Lists(@JsonProperty("status") String str, @JsonProperty("entries") List<Entries> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.status = str;
            this.entries = entries;
        }

        public final String getStatus() {
            return this.status;
        }

        public final List<Entries> getEntries() {
            return this.entries;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaListCollection;", "", "lists", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Lists;", "(Ljava/util/List;)V", "getLists", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MediaListCollection {
        private final List<Lists> lists;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MediaListCollection copy$default(MediaListCollection mediaListCollection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = mediaListCollection.lists;
            }
            return mediaListCollection.copy(list);
        }

        public final List<Lists> component1() {
            return this.lists;
        }

        public final MediaListCollection copy(@JsonProperty("lists") List<Lists> lists) {
            Intrinsics.checkNotNullParameter(lists, "lists");
            return new MediaListCollection(lists);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MediaListCollection) && Intrinsics.areEqual(this.lists, ((MediaListCollection) obj).lists);
        }

        public int hashCode() {
            return this.lists.hashCode();
        }

        public String toString() {
            return "MediaListCollection(lists=" + this.lists + ')';
        }

        public MediaListCollection(@JsonProperty("lists") List<Lists> lists) {
            Intrinsics.checkNotNullParameter(lists, "lists");
            this.lists = lists;
        }

        public final List<Lists> getLists() {
            return this.lists;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Data;", "", "MediaListCollection", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaListCollection;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaListCollection;)V", "getMediaListCollection", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaListCollection;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final MediaListCollection MediaListCollection;

        public static /* synthetic */ Data copy$default(Data data, MediaListCollection mediaListCollection, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaListCollection = data.MediaListCollection;
            }
            return data.copy(mediaListCollection);
        }

        public final MediaListCollection component1() {
            return this.MediaListCollection;
        }

        public final Data copy(@JsonProperty("MediaListCollection") MediaListCollection MediaListCollection) {
            Intrinsics.checkNotNullParameter(MediaListCollection, "MediaListCollection");
            return new Data(MediaListCollection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual(this.MediaListCollection, ((Data) obj).MediaListCollection);
        }

        public int hashCode() {
            return this.MediaListCollection.hashCode();
        }

        public String toString() {
            return "Data(MediaListCollection=" + this.MediaListCollection + ')';
        }

        public Data(@JsonProperty("MediaListCollection") MediaListCollection MediaListCollection) {
            Intrinsics.checkNotNullParameter(MediaListCollection, "MediaListCollection");
            this.MediaListCollection = MediaListCollection;
        }

        public final MediaListCollection getMediaListCollection() {
            return this.MediaListCollection;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[] getAnilistListCached() {
        /*
            r4 = this;
            com.lagradost.cloudstream3.AcraApplication$Companion r0 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = "anilist_cached_list"
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
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[]> r3 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[].class
            java.lang.Object r0 = r1.readValue(r0, r3)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2d:
            r0 = r2
        L2e:
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[]
            if (r1 == 0) goto L35
            r2 = r0
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[] r2 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[]) r2
        L35:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getAnilistListCached():com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAnilistAnimeListSmart(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[]> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAnilistAnimeListSmart$1
            if (r0 == 0) goto L14
            r0 = r8
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAnilistAnimeListSmart$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAnilistAnimeListSmart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAnilistAnimeListSmart$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAnilistAnimeListSmart$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "anilist_should_update_list"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L88
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.getAuth()
            if (r8 != 0) goto L3f
            return r5
        L3f:
            boolean r8 = r7.checkToken()
            if (r8 == 0) goto L46
            return r5
        L46:
            com.lagradost.cloudstream3.AcraApplication$Companion r8 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
            android.content.Context r8 = r8.getContext()
            if (r8 == 0) goto L74
            com.lagradost.cloudstream3.utils.DataStore r6 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            android.content.SharedPreferences r8 = r6.getSharedPrefs(r8)     // Catch: java.lang.Exception -> L74
            java.lang.String r8 = r8.getString(r3, r5)     // Catch: java.lang.Exception -> L74
            if (r8 != 0) goto L5f
            goto L75
        L5f:
            java.lang.String r2 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch: java.lang.Exception -> L74
            com.fasterxml.jackson.databind.json.JsonMapper r2 = r6.getMapper()     // Catch: java.lang.Exception -> L74
            java.lang.Class<java.lang.Boolean> r6 = java.lang.Boolean.class
            java.lang.Object r2 = r2.readValue(r8, r6)     // Catch: java.lang.Exception -> L74
            java.lang.String r8 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L75
        L74:
            r2 = r5
        L75:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r8)
            if (r8 == 0) goto Lc2
            r0.label = r4
            java.lang.Object r8 = r7.getFullAnilistList(r0)
            if (r8 != r1) goto L88
            return r1
        L88:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$FullAnilistList r8 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.FullAnilistList) r8
            r0 = 0
            if (r8 == 0) goto Laf
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Data r8 = r8.getData()
            if (r8 == 0) goto Laf
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$MediaListCollection r8 = r8.getMediaListCollection()
            if (r8 == 0) goto Laf
            java.util.List r8 = r8.getLists()
            if (r8 == 0) goto Laf
            java.util.Collection r8 = (java.util.Collection) r8
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[] r1 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[r0]
            java.lang.Object[] r8 = r8.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            java.util.Objects.requireNonNull(r8, r1)
            r5 = r8
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[] r5 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Lists[]) r5
        Laf:
            if (r5 == 0) goto Lc6
            com.lagradost.cloudstream3.AcraApplication$Companion r8 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r1 = "anilist_cached_list"
            r8.setKey(r1, r5)
            com.lagradost.cloudstream3.AcraApplication$Companion r8 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r0)
            r8.setKey(r3, r0)
            goto Lc6
        Lc2:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Lists[] r5 = r7.getAnilistListCached()
        Lc6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getAnilistAnimeListSmart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getFullAnilistList(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.FullAnilistList> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getFullAnilistList$1
            if (r0 == 0) goto L14
            r0 = r10
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getFullAnilistList$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getFullAnilistList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getFullAnilistList$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getFullAnilistList$1
            r0.<init>(r9, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            java.lang.String r7 = "mapper.readValue(this, T::class.java)"
            r2 = 1
            r8 = 0
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc7
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r3 = "anilist_user"
            java.util.List r1 = r1.getKeys(r3)
            if (r1 == 0) goto L8f
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L4f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L8f
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            com.lagradost.cloudstream3.AcraApplication$Companion r5 = com.lagradost.cloudstream3.AcraApplication.Companion
            android.content.Context r5 = r5.getContext()
            if (r5 == 0) goto L83
            com.lagradost.cloudstream3.utils.DataStore r6 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            android.content.SharedPreferences r5 = r6.getSharedPrefs(r5)     // Catch: java.lang.Exception -> L83
            java.lang.String r3 = r5.getString(r3, r8)     // Catch: java.lang.Exception -> L83
            if (r3 != 0) goto L70
            goto L83
        L70:
            java.lang.String r5 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch: java.lang.Exception -> L83
            com.fasterxml.jackson.databind.json.JsonMapper r5 = r6.getMapper()     // Catch: java.lang.Exception -> L83
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser> r6 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser.class
            java.lang.Object r3 = r5.readValue(r3, r6)     // Catch: java.lang.Exception -> L83
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)     // Catch: java.lang.Exception -> L83
            goto L84
        L83:
            r3 = r8
        L84:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser r3 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser) r3
            if (r3 == 0) goto L4f
            java.lang.Integer r3 = r3.getId()
            r10.element = r3
            goto L4f
        L8f:
            T r10 = r10.element
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto Ldd
            int r10 = r10.intValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "\n                query ($userID: Int = "
            r1.append(r3)
            r1.append(r10)
            java.lang.String r10 = ", $MEDIA: MediaType = "
            r1.append(r10)
            java.lang.String r10 = "ANIME"
            r1.append(r10)
            java.lang.String r10 = ") {\n                    MediaListCollection (userId: $userID, type: $MEDIA) { \n                        lists {\n                            status\n                            entries\n                            {\n                                status\n                                completedAt { year month day }\n                                startedAt { year month day }\n                                updatedAt\n                                progress\n                                score\n                                private\n                                media\n                                {\n                                    id\n                                    idMal\n                                    season\n                                    seasonYear\n                                    format\n                                    episodes\n                                    chapters\n                                    title\n                                    {\n                                        english\n                                        romaji\n                                    }\n                                    coverImage { medium }\n                                    synonyms\n                                    nextAiringEpisode {\n                                        timeUntilAiring\n                                        episode\n                                    }\n                                }\n                            }\n                        }\n                    }\n                    }\n            "
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2
            r1 = r9
            r2 = r10
            java.lang.Object r10 = postApi$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto Lc7
            return r0
        Lc7:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto Ldd
            com.lagradost.cloudstream3.utils.DataStore r0 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            com.fasterxml.jackson.databind.json.JsonMapper r0 = r0.getMapper()
            java.lang.Class<com.lagradost.cloudstream3.syncproviders.providers.AniListApi$FullAnilistList> r1 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.FullAnilistList.class
            java.lang.Object r10 = r0.readValue(r10, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r7)
            r8 = r10
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$FullAnilistList r8 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.FullAnilistList) r8
        Ldd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getFullAnilistList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object toggleLike(int r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$toggleLike$1
            if (r0 == 0) goto L14
            r0 = r10
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$toggleLike$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$toggleLike$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$toggleLike$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$toggleLike$1
            r0.<init>(r8, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L33
            if (r1 != r7) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L59
        L2b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "mutation ($animeId: Int = "
            r10.append(r1)
            r10.append(r9)
            java.lang.String r9 = ") {\n\t\t\t\tToggleFavourite (animeId: $animeId) {\n\t\t\t\t\tanime {\n\t\t\t\t\t\tnodes {\n\t\t\t\t\t\t\tid\n\t\t\t\t\t\t\ttitle {\n\t\t\t\t\t\t\t\tromaji\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}"
            r10.append(r9)
            java.lang.String r2 = r10.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r7
            r1 = r8
            java.lang.Object r10 = postApi$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L59
            return r0
        L59:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r9 = ""
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r9)
            r9 = r9 ^ r7
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.toggleLike(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object postDataAboutId(int r10, com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.AniListStatusType r11, java.lang.Integer r12, java.lang.Integer r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$postDataAboutId$1
            if (r0 == 0) goto L14
            r0 = r14
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$postDataAboutId$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$postDataAboutId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$postDataAboutId$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$postDataAboutId$1
            r0.<init>(r9, r14)
        L19:
            r4 = r0
            java.lang.Object r14 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            java.lang.String r7 = ""
            r8 = 1
            if (r1 == 0) goto L36
            if (r1 != r8) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lb1
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "mutation ($id: Int = "
            r14.append(r1)
            r14.append(r10)
            java.lang.String r10 = ", $status: MediaListStatus = "
            r14.append(r10)
            java.lang.String[] r10 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.aniListStatusString
            r1 = 0
            int r11 = r11.getValue()
            int r11 = java.lang.Math.max(r1, r11)
            r10 = r10[r11]
            r14.append(r10)
            java.lang.String r10 = ", "
            r14.append(r10)
            if (r12 == 0) goto L7a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "$scoreRaw: Int = "
            r10.append(r11)
            int r11 = r12.intValue()
            int r11 = r11 * 10
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            goto L7b
        L7a:
            r10 = r7
        L7b:
            r14.append(r10)
            java.lang.String r10 = " , "
            r14.append(r10)
            if (r13 == 0) goto L97
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "$progress: Int = "
            r10.append(r11)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            goto L98
        L97:
            r10 = r7
        L98:
            r14.append(r10)
            java.lang.String r10 = ") {\n                SaveMediaListEntry (mediaId: $id, status: $status, scoreRaw: $scoreRaw, progress: $progress) {\n                    id\n                    status\n                    progress\n                    score\n                }\n                }"
            r14.append(r10)
            java.lang.String r2 = r14.toString()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r8
            r1 = r9
            java.lang.Object r14 = postApi$default(r1, r2, r3, r4, r5, r6)
            if (r14 != r0) goto Lb1
            return r0
        Lb1:
            java.lang.String r14 = (java.lang.String) r14
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r7)
            r10 = r10 ^ r8
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.postDataAboutId(int, com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion$AniListStatusType, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUser(boolean r9, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListUser> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$1
            if (r0 == 0) goto L14
            r0 = r10
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$1
            r0.<init>(r8, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L39
            if (r1 != r7) goto L31
            boolean r9 = r4.Z$0
            java.lang.Object r0 = r4.L$0
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L50
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r8
            r4.Z$0 = r9
            r4.label = r7
            java.lang.String r2 = "\n\t\t\t\t{\n  \t\t\t\t\tViewer {\n    \t\t\t\t\tid\n    \t\t\t\t\tname\n\t\t\t\t\t\tavatar {\n\t\t\t\t\t\t\tlarge\n\t\t\t\t\t\t}\n                        favourites {\n                            anime {\n                                nodes {\n                                    id\n                                }\n                            }\n                        }\n  \t\t\t\t\t}\n\t\t\t\t}"
            r1 = r8
            java.lang.Object r10 = postApi$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L4f
            return r0
        L4f:
            r0 = r8
        L50:
            java.lang.String r10 = (java.lang.String) r10
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L5f
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L5e
            goto L5f
        L5e:
            r7 = 0
        L5f:
            r1 = 0
            if (r7 == 0) goto L63
            return r1
        L63:
            com.fasterxml.jackson.databind.json.JsonMapper r2 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.mapper
            com.fasterxml.jackson.databind.ObjectMapper r2 = (com.fasterxml.jackson.databind.ObjectMapper) r2
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$$inlined$readValue$1 r3 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getUser$$inlined$readValue$1
            r3.<init>()
            com.fasterxml.jackson.core.type.TypeReference r3 = (com.fasterxml.jackson.core.type.TypeReference) r3
            java.lang.Object r10 = r2.readValue(r10, r3)
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListRoot r10 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.AniListRoot) r10
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListData r10 = r10.getData()
            if (r10 == 0) goto L7f
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListViewer r10 = r10.getViewer()
            goto L80
        L7f:
            r10 = r1
        L80:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser r2 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListUser
            if (r10 == 0) goto L89
            java.lang.Integer r3 = r10.getId()
            goto L8a
        L89:
            r3 = r1
        L8a:
            if (r10 == 0) goto L91
            java.lang.String r4 = r10.getName()
            goto L92
        L91:
            r4 = r1
        L92:
            if (r10 == 0) goto L9e
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$AniListAvatar r10 = r10.getAvatar()
            if (r10 == 0) goto L9e
            java.lang.String r1 = r10.getLarge()
        L9e:
            r2.<init>(r3, r4, r1)
            if (r9 == 0) goto Lb1
            com.lagradost.cloudstream3.AcraApplication$Companion r9 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.String r10 = r0.getAccountId()
            java.lang.String r1 = "anilist_user"
            r9.setKey(r10, r1, r2)
            r0.registerAccount()
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getUser(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object getUser$default(AniListApi aniListApi, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aniListApi.getUser(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAllSeasons(int r5, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$1
            if (r0 == 0) goto L14
            r0 = r6
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = getAllSeasons$getSeasonRecursive(r6, r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r5 = r6
        L4c:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.toList(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getAllSeasons(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getAllSeasons$getSeasonRecursive(java.util.List<com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonResponse> r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$getSeasonRecursive$1
            if (r0 == 0) goto L14
            r0 = r11
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$getSeasonRecursive$1 r0 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$getSeasonRecursive$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$getSeasonRecursive$1 r0 = new com.lagradost.cloudstream3.syncproviders.providers.AniListApi$getAllSeasons$getSeasonRecursive$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "TV"
            r4 = 0
            r5 = 0
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L49
            if (r2 == r7) goto L41
            if (r2 != r6) goto L39
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$0
            java.util.List r10 = (java.util.List) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L93
        L39:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L41:
            java.lang.Object r9 = r0.L$0
            java.util.List r9 = (java.util.List) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L59
        L49:
            kotlin.ResultKt.throwOnFailure(r11)
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$Companion r11 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion
            r0.L$0 = r9
            r0.label = r7
            java.lang.Object r11 = com.lagradost.cloudstream3.syncproviders.providers.AniListApi.Companion.access$getSeason(r11, r10, r0)
            if (r11 != r1) goto L59
            return r1
        L59:
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonResponse r11 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonResponse) r11
            r9.add(r11)
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonData r10 = r11.getData()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonMedia r10 = r10.getMedia()
            java.lang.String r10 = r10.getFormat()
            if (r10 == 0) goto L73
            boolean r10 = kotlin.text.StringsKt.startsWith$default(r10, r3, r5, r6, r4)
            if (r10 != r7) goto L73
            goto L74
        L73:
            r7 = 0
        L74:
            if (r7 == 0) goto Ldc
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonData r10 = r11.getData()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonMedia r10 = r10.getMedia()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonEdges r10 = r10.getRelations()
            if (r10 == 0) goto Ldc
            java.util.List r10 = r10.getEdges()
            if (r10 == 0) goto Ldc
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            r8 = r10
            r10 = r9
            r9 = r8
        L93:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto Ldc
            java.lang.Object r11 = r9.next()
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonEdge r11 = (com.lagradost.cloudstream3.syncproviders.providers.AniListApi.SeasonEdge) r11
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonNode r2 = r11.getNode()
            if (r2 == 0) goto Laa
            java.lang.String r2 = r2.getFormat()
            goto Lab
        Laa:
            r2 = r4
        Lab:
            if (r2 == 0) goto L93
            java.lang.String r2 = r11.getRelationType()
            java.lang.String r7 = "SEQUEL"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r2 == 0) goto L93
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonNode r2 = r11.getNode()
            java.lang.String r2 = r2.getFormat()
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r2, r3, r5, r6, r4)
            if (r2 == 0) goto L93
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi$SeasonNode r11 = r11.getNode()
            int r11 = r11.getId()
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r6
            java.lang.Object r11 = getAllSeasons$getSeasonRecursive(r10, r11, r0)
            if (r11 != r1) goto L93
            return r1
        Ldc:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.syncproviders.providers.AniListApi.getAllSeasons$getSeasonRecursive(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonResponse;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonData;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonData;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonResponse {
        private final SeasonData data;

        public static /* synthetic */ SeasonResponse copy$default(SeasonResponse seasonResponse, SeasonData seasonData, int i, Object obj) {
            if ((i & 1) != 0) {
                seasonData = seasonResponse.data;
            }
            return seasonResponse.copy(seasonData);
        }

        public final SeasonData component1() {
            return this.data;
        }

        public final SeasonResponse copy(@JsonProperty("data") SeasonData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new SeasonResponse(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SeasonResponse) && Intrinsics.areEqual(this.data, ((SeasonResponse) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "SeasonResponse(data=" + this.data + ')';
        }

        public SeasonResponse(@JsonProperty("data") SeasonData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final SeasonData getData() {
            return this.data;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonData;", "", "Media", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;)V", "getMedia", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonData {
        private final SeasonMedia Media;

        public static /* synthetic */ SeasonData copy$default(SeasonData seasonData, SeasonMedia seasonMedia, int i, Object obj) {
            if ((i & 1) != 0) {
                seasonMedia = seasonData.Media;
            }
            return seasonData.copy(seasonMedia);
        }

        public final SeasonMedia component1() {
            return this.Media;
        }

        public final SeasonData copy(@JsonProperty("Media") SeasonMedia Media) {
            Intrinsics.checkNotNullParameter(Media, "Media");
            return new SeasonData(Media);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SeasonData) && Intrinsics.areEqual(this.Media, ((SeasonData) obj).Media);
        }

        public int hashCode() {
            return this.Media.hashCode();
        }

        public String toString() {
            return "SeasonData(Media=" + this.Media + ')';
        }

        public SeasonData(@JsonProperty("Media") SeasonMedia Media) {
            Intrinsics.checkNotNullParameter(Media, "Media");
            this.Media = Media;
        }

        public final SeasonMedia getMedia() {
            return this.Media;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012HÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010@\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010A\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 Jæ\u0001\u0010M\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020\u00162\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00100\u001a\u0004\b\u0015\u0010/R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006S"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "", "id", "", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTitle;", "idMal", "format", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "relations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaCoverImage;", TypedValues.TransitionType.S_DURATION, "episodes", "genres", "", "synonyms", "averageScore", "isAdult", "", "trailer", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTrailer;", "description", "characters", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterConnection;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTitle;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaCoverImage;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTrailer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterConnection;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;)V", "getAverageScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCharacters", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterConnection;", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaCoverImage;", "getDescription", "()Ljava/lang/String;", "getDuration", "getEpisodes", "getFormat", "getGenres", "()Ljava/util/List;", "getId", "getIdMal", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "getRelations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;", "getSynonyms", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTitle;", "getTrailer", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTrailer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTitle;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaCoverImage;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTrailer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterConnection;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonMedia {
        private final Integer averageScore;
        private final CharacterConnection characters;
        private final MediaCoverImage coverImage;
        private final String description;
        private final Integer duration;
        private final Integer episodes;
        private final String format;
        private final List<String> genres;

        /* renamed from: id */
        private final Integer f10003id;
        private final Integer idMal;
        private final Boolean isAdult;
        private final SeasonNextAiringEpisode nextAiringEpisode;
        private final RecommendationConnection recommendations;
        private final SeasonEdges relations;
        private final List<String> synonyms;
        private final MediaTitle title;
        private final MediaTrailer trailer;

        public final Integer component1() {
            return this.f10003id;
        }

        public final List<String> component10() {
            return this.genres;
        }

        public final List<String> component11() {
            return this.synonyms;
        }

        public final Integer component12() {
            return this.averageScore;
        }

        public final Boolean component13() {
            return this.isAdult;
        }

        public final MediaTrailer component14() {
            return this.trailer;
        }

        public final String component15() {
            return this.description;
        }

        public final CharacterConnection component16() {
            return this.characters;
        }

        public final RecommendationConnection component17() {
            return this.recommendations;
        }

        public final MediaTitle component2() {
            return this.title;
        }

        public final Integer component3() {
            return this.idMal;
        }

        public final String component4() {
            return this.format;
        }

        public final SeasonNextAiringEpisode component5() {
            return this.nextAiringEpisode;
        }

        public final SeasonEdges component6() {
            return this.relations;
        }

        public final MediaCoverImage component7() {
            return this.coverImage;
        }

        public final Integer component8() {
            return this.duration;
        }

        public final Integer component9() {
            return this.episodes;
        }

        public final SeasonMedia copy(@JsonProperty("id") Integer num, @JsonProperty("title") MediaTitle mediaTitle, @JsonProperty("idMal") Integer num2, @JsonProperty("format") String str, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode, @JsonProperty("relations") SeasonEdges seasonEdges, @JsonProperty("coverImage") MediaCoverImage mediaCoverImage, @JsonProperty("duration") Integer num3, @JsonProperty("episodes") Integer num4, @JsonProperty("genres") List<String> list, @JsonProperty("synonyms") List<String> list2, @JsonProperty("averageScore") Integer num5, @JsonProperty("isAdult") Boolean bool, @JsonProperty("trailer") MediaTrailer mediaTrailer, @JsonProperty("description") String str2, @JsonProperty("characters") CharacterConnection characterConnection, @JsonProperty("recommendations") RecommendationConnection recommendationConnection) {
            return new SeasonMedia(num, mediaTitle, num2, str, seasonNextAiringEpisode, seasonEdges, mediaCoverImage, num3, num4, list, list2, num5, bool, mediaTrailer, str2, characterConnection, recommendationConnection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeasonMedia) {
                SeasonMedia seasonMedia = (SeasonMedia) obj;
                return Intrinsics.areEqual(this.f10003id, seasonMedia.f10003id) && Intrinsics.areEqual(this.title, seasonMedia.title) && Intrinsics.areEqual(this.idMal, seasonMedia.idMal) && Intrinsics.areEqual(this.format, seasonMedia.format) && Intrinsics.areEqual(this.nextAiringEpisode, seasonMedia.nextAiringEpisode) && Intrinsics.areEqual(this.relations, seasonMedia.relations) && Intrinsics.areEqual(this.coverImage, seasonMedia.coverImage) && Intrinsics.areEqual(this.duration, seasonMedia.duration) && Intrinsics.areEqual(this.episodes, seasonMedia.episodes) && Intrinsics.areEqual(this.genres, seasonMedia.genres) && Intrinsics.areEqual(this.synonyms, seasonMedia.synonyms) && Intrinsics.areEqual(this.averageScore, seasonMedia.averageScore) && Intrinsics.areEqual(this.isAdult, seasonMedia.isAdult) && Intrinsics.areEqual(this.trailer, seasonMedia.trailer) && Intrinsics.areEqual(this.description, seasonMedia.description) && Intrinsics.areEqual(this.characters, seasonMedia.characters) && Intrinsics.areEqual(this.recommendations, seasonMedia.recommendations);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10003id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            MediaTitle mediaTitle = this.title;
            int hashCode2 = (hashCode + (mediaTitle == null ? 0 : mediaTitle.hashCode())) * 31;
            Integer num2 = this.idMal;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.format;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            SeasonNextAiringEpisode seasonNextAiringEpisode = this.nextAiringEpisode;
            int hashCode5 = (hashCode4 + (seasonNextAiringEpisode == null ? 0 : seasonNextAiringEpisode.hashCode())) * 31;
            SeasonEdges seasonEdges = this.relations;
            int hashCode6 = (hashCode5 + (seasonEdges == null ? 0 : seasonEdges.hashCode())) * 31;
            MediaCoverImage mediaCoverImage = this.coverImage;
            int hashCode7 = (hashCode6 + (mediaCoverImage == null ? 0 : mediaCoverImage.hashCode())) * 31;
            Integer num3 = this.duration;
            int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.episodes;
            int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
            List<String> list = this.genres;
            int hashCode10 = (hashCode9 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.synonyms;
            int hashCode11 = (hashCode10 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Integer num5 = this.averageScore;
            int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Boolean bool = this.isAdult;
            int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
            MediaTrailer mediaTrailer = this.trailer;
            int hashCode14 = (hashCode13 + (mediaTrailer == null ? 0 : mediaTrailer.hashCode())) * 31;
            String str2 = this.description;
            int hashCode15 = (hashCode14 + (str2 == null ? 0 : str2.hashCode())) * 31;
            CharacterConnection characterConnection = this.characters;
            int hashCode16 = (hashCode15 + (characterConnection == null ? 0 : characterConnection.hashCode())) * 31;
            RecommendationConnection recommendationConnection = this.recommendations;
            return hashCode16 + (recommendationConnection != null ? recommendationConnection.hashCode() : 0);
        }

        public String toString() {
            return "SeasonMedia(id=" + this.f10003id + ", title=" + this.title + ", idMal=" + this.idMal + ", format=" + this.format + ", nextAiringEpisode=" + this.nextAiringEpisode + ", relations=" + this.relations + ", coverImage=" + this.coverImage + ", duration=" + this.duration + ", episodes=" + this.episodes + ", genres=" + this.genres + ", synonyms=" + this.synonyms + ", averageScore=" + this.averageScore + ", isAdult=" + this.isAdult + ", trailer=" + this.trailer + ", description=" + this.description + ", characters=" + this.characters + ", recommendations=" + this.recommendations + ')';
        }

        public SeasonMedia(@JsonProperty("id") Integer num, @JsonProperty("title") MediaTitle mediaTitle, @JsonProperty("idMal") Integer num2, @JsonProperty("format") String str, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode, @JsonProperty("relations") SeasonEdges seasonEdges, @JsonProperty("coverImage") MediaCoverImage mediaCoverImage, @JsonProperty("duration") Integer num3, @JsonProperty("episodes") Integer num4, @JsonProperty("genres") List<String> list, @JsonProperty("synonyms") List<String> list2, @JsonProperty("averageScore") Integer num5, @JsonProperty("isAdult") Boolean bool, @JsonProperty("trailer") MediaTrailer mediaTrailer, @JsonProperty("description") String str2, @JsonProperty("characters") CharacterConnection characterConnection, @JsonProperty("recommendations") RecommendationConnection recommendationConnection) {
            this.f10003id = num;
            this.title = mediaTitle;
            this.idMal = num2;
            this.format = str;
            this.nextAiringEpisode = seasonNextAiringEpisode;
            this.relations = seasonEdges;
            this.coverImage = mediaCoverImage;
            this.duration = num3;
            this.episodes = num4;
            this.genres = list;
            this.synonyms = list2;
            this.averageScore = num5;
            this.isAdult = bool;
            this.trailer = mediaTrailer;
            this.description = str2;
            this.characters = characterConnection;
            this.recommendations = recommendationConnection;
        }

        public final Integer getId() {
            return this.f10003id;
        }

        public final MediaTitle getTitle() {
            return this.title;
        }

        public final Integer getIdMal() {
            return this.idMal;
        }

        public final String getFormat() {
            return this.format;
        }

        public final SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        public final SeasonEdges getRelations() {
            return this.relations;
        }

        public final MediaCoverImage getCoverImage() {
            return this.coverImage;
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final Integer getEpisodes() {
            return this.episodes;
        }

        public final List<String> getGenres() {
            return this.genres;
        }

        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        public final Integer getAverageScore() {
            return this.averageScore;
        }

        public final Boolean isAdult() {
            return this.isAdult;
        }

        public final MediaTrailer getTrailer() {
            return this.trailer;
        }

        public final String getDescription() {
            return this.description;
        }

        public final CharacterConnection getCharacters() {
            return this.characters;
        }

        public final RecommendationConnection getRecommendations() {
            return this.recommendations;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "", "edges", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationEdge;", "nodes", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendation;", "(Ljava/util/List;Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "getNodes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RecommendationConnection {
        private final List<RecommendationEdge> edges;
        private final List<Recommendation> nodes;

        public RecommendationConnection() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecommendationConnection copy$default(RecommendationConnection recommendationConnection, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = recommendationConnection.edges;
            }
            if ((i & 2) != 0) {
                list2 = recommendationConnection.nodes;
            }
            return recommendationConnection.copy(list, list2);
        }

        public final List<RecommendationEdge> component1() {
            return this.edges;
        }

        public final List<Recommendation> component2() {
            return this.nodes;
        }

        public final RecommendationConnection copy(@JsonProperty("edges") List<RecommendationEdge> edges, @JsonProperty("nodes") List<Recommendation> nodes) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            Intrinsics.checkNotNullParameter(nodes, "nodes");
            return new RecommendationConnection(edges, nodes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecommendationConnection) {
                RecommendationConnection recommendationConnection = (RecommendationConnection) obj;
                return Intrinsics.areEqual(this.edges, recommendationConnection.edges) && Intrinsics.areEqual(this.nodes, recommendationConnection.nodes);
            }
            return false;
        }

        public int hashCode() {
            return (this.edges.hashCode() * 31) + this.nodes.hashCode();
        }

        public String toString() {
            return "RecommendationConnection(edges=" + this.edges + ", nodes=" + this.nodes + ')';
        }

        public RecommendationConnection(@JsonProperty("edges") List<RecommendationEdge> edges, @JsonProperty("nodes") List<Recommendation> nodes) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            Intrinsics.checkNotNullParameter(nodes, "nodes");
            this.edges = edges;
            this.nodes = nodes;
        }

        public /* synthetic */ RecommendationConnection(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<RecommendationEdge> getEdges() {
            return this.edges;
        }

        public final List<Recommendation> getNodes() {
            return this.nodes;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationEdge;", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendation;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendation;)V", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendation;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class RecommendationEdge {
        private final Recommendation node;

        public static /* synthetic */ RecommendationEdge copy$default(RecommendationEdge recommendationEdge, Recommendation recommendation, int i, Object obj) {
            if ((i & 1) != 0) {
                recommendation = recommendationEdge.node;
            }
            return recommendationEdge.copy(recommendation);
        }

        public final Recommendation component1() {
            return this.node;
        }

        public final RecommendationEdge copy(@JsonProperty("node") Recommendation node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new RecommendationEdge(node);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RecommendationEdge) && Intrinsics.areEqual(this.node, ((RecommendationEdge) obj).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "RecommendationEdge(node=" + this.node + ')';
        }

        public RecommendationEdge(@JsonProperty("node") Recommendation node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final Recommendation getNode() {
            return this.node;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendation;", "", "mediaRecommendation", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;)V", "getMediaRecommendation", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Recommendation {
        private final SeasonMedia mediaRecommendation;

        public static /* synthetic */ Recommendation copy$default(Recommendation recommendation, SeasonMedia seasonMedia, int i, Object obj) {
            if ((i & 1) != 0) {
                seasonMedia = recommendation.mediaRecommendation;
            }
            return recommendation.copy(seasonMedia);
        }

        public final SeasonMedia component1() {
            return this.mediaRecommendation;
        }

        public final Recommendation copy(@JsonProperty("mediaRecommendation") SeasonMedia mediaRecommendation) {
            Intrinsics.checkNotNullParameter(mediaRecommendation, "mediaRecommendation");
            return new Recommendation(mediaRecommendation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Recommendation) && Intrinsics.areEqual(this.mediaRecommendation, ((Recommendation) obj).mediaRecommendation);
        }

        public int hashCode() {
            return this.mediaRecommendation.hashCode();
        }

        public String toString() {
            return "Recommendation(mediaRecommendation=" + this.mediaRecommendation + ')';
        }

        public Recommendation(@JsonProperty("mediaRecommendation") SeasonMedia mediaRecommendation) {
            Intrinsics.checkNotNullParameter(mediaRecommendation, "mediaRecommendation");
            this.mediaRecommendation = mediaRecommendation;
        }

        public final SeasonMedia getMediaRecommendation() {
            return this.mediaRecommendation;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010\u001f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006&"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterName;", "", "first", "", "middle", "last", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "alternative", "", "alternativeSpoiler", "userPreferred", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAlternative", "()Ljava/util/List;", "getAlternativeSpoiler", "getFirst", "()Ljava/lang/String;", "getFull", "getLast", "getMiddle", "getNative", "getUserPreferred", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CharacterName {
        private final List<String> alternative;
        private final List<String> alternativeSpoiler;
        private final String first;
        private final String full;
        private final String last;
        private final String middle;

        /* renamed from: native  reason: not valid java name */
        private final String f10817native;
        private final String userPreferred;

        public final String component1() {
            return this.first;
        }

        public final String component2() {
            return this.middle;
        }

        public final String component3() {
            return this.last;
        }

        public final String component4() {
            return this.full;
        }

        public final String component5() {
            return this.f10817native;
        }

        public final List<String> component6() {
            return this.alternative;
        }

        public final List<String> component7() {
            return this.alternativeSpoiler;
        }

        public final String component8() {
            return this.userPreferred;
        }

        public final CharacterName copy(@JsonProperty("name") String str, @JsonProperty("middle") String str2, @JsonProperty("last") String str3, @JsonProperty("full") String str4, @JsonProperty("native") String str5, @JsonProperty("alternative") List<String> list, @JsonProperty("alternativeSpoiler") List<String> list2, @JsonProperty("userPreferred") String str6) {
            return new CharacterName(str, str2, str3, str4, str5, list, list2, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CharacterName) {
                CharacterName characterName = (CharacterName) obj;
                return Intrinsics.areEqual(this.first, characterName.first) && Intrinsics.areEqual(this.middle, characterName.middle) && Intrinsics.areEqual(this.last, characterName.last) && Intrinsics.areEqual(this.full, characterName.full) && Intrinsics.areEqual(this.f10817native, characterName.f10817native) && Intrinsics.areEqual(this.alternative, characterName.alternative) && Intrinsics.areEqual(this.alternativeSpoiler, characterName.alternativeSpoiler) && Intrinsics.areEqual(this.userPreferred, characterName.userPreferred);
            }
            return false;
        }

        public int hashCode() {
            String str = this.first;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.middle;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.last;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.full;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f10817native;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            List<String> list = this.alternative;
            int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.alternativeSpoiler;
            int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
            String str6 = this.userPreferred;
            return hashCode7 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "CharacterName(first=" + this.first + ", middle=" + this.middle + ", last=" + this.last + ", full=" + this.full + ", native=" + this.f10817native + ", alternative=" + this.alternative + ", alternativeSpoiler=" + this.alternativeSpoiler + ", userPreferred=" + this.userPreferred + ')';
        }

        public CharacterName(@JsonProperty("name") String str, @JsonProperty("middle") String str2, @JsonProperty("last") String str3, @JsonProperty("full") String str4, @JsonProperty("native") String str5, @JsonProperty("alternative") List<String> list, @JsonProperty("alternativeSpoiler") List<String> list2, @JsonProperty("userPreferred") String str6) {
            this.first = str;
            this.middle = str2;
            this.last = str3;
            this.full = str4;
            this.f10817native = str5;
            this.alternative = list;
            this.alternativeSpoiler = list2;
            this.userPreferred = str6;
        }

        public final String getFirst() {
            return this.first;
        }

        public final String getMiddle() {
            return this.middle;
        }

        public final String getLast() {
            return this.last;
        }

        public final String getFull() {
            return this.full;
        }

        public final String getNative() {
            return this.f10817native;
        }

        public final List<String> getAlternative() {
            return this.alternative;
        }

        public final List<String> getAlternativeSpoiler() {
            return this.alternativeSpoiler;
        }

        public final String getUserPreferred() {
            return this.userPreferred;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterImage;", "", "large", "", "medium", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CharacterImage {
        private final String large;
        private final String medium;

        public static /* synthetic */ CharacterImage copy$default(CharacterImage characterImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = characterImage.large;
            }
            if ((i & 2) != 0) {
                str2 = characterImage.medium;
            }
            return characterImage.copy(str, str2);
        }

        public final String component1() {
            return this.large;
        }

        public final String component2() {
            return this.medium;
        }

        public final CharacterImage copy(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
            return new CharacterImage(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CharacterImage) {
                CharacterImage characterImage = (CharacterImage) obj;
                return Intrinsics.areEqual(this.large, characterImage.large) && Intrinsics.areEqual(this.medium, characterImage.medium);
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
            return "CharacterImage(large=" + this.large + ", medium=" + this.medium + ')';
        }

        public CharacterImage(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
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

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;", "", "name", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterName;", "age", "", "image", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterImage;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterName;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterImage;)V", "getAge", "()Ljava/lang/String;", "getImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterImage;", "getName", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterName;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Character {
        private final String age;
        private final CharacterImage image;
        private final CharacterName name;

        public static /* synthetic */ Character copy$default(Character character, CharacterName characterName, String str, CharacterImage characterImage, int i, Object obj) {
            if ((i & 1) != 0) {
                characterName = character.name;
            }
            if ((i & 2) != 0) {
                str = character.age;
            }
            if ((i & 4) != 0) {
                characterImage = character.image;
            }
            return character.copy(characterName, str, characterImage);
        }

        public final CharacterName component1() {
            return this.name;
        }

        public final String component2() {
            return this.age;
        }

        public final CharacterImage component3() {
            return this.image;
        }

        public final Character copy(@JsonProperty("name") CharacterName characterName, @JsonProperty("age") String str, @JsonProperty("image") CharacterImage characterImage) {
            return new Character(characterName, str, characterImage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Character) {
                Character character = (Character) obj;
                return Intrinsics.areEqual(this.name, character.name) && Intrinsics.areEqual(this.age, character.age) && Intrinsics.areEqual(this.image, character.image);
            }
            return false;
        }

        public int hashCode() {
            CharacterName characterName = this.name;
            int hashCode = (characterName == null ? 0 : characterName.hashCode()) * 31;
            String str = this.age;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            CharacterImage characterImage = this.image;
            return hashCode2 + (characterImage != null ? characterImage.hashCode() : 0);
        }

        public String toString() {
            return "Character(name=" + this.name + ", age=" + this.age + ", image=" + this.image + ')';
        }

        public Character(@JsonProperty("name") CharacterName characterName, @JsonProperty("age") String str, @JsonProperty("image") CharacterImage characterImage) {
            this.name = characterName;
            this.age = str;
            this.image = characterImage;
        }

        public final CharacterName getName() {
            return this.name;
        }

        public final String getAge() {
            return this.age;
        }

        public final CharacterImage getImage() {
            return this.image;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u0010#\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006*"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterEdge;", "", "id", "", "role", "", "name", "voiceActors", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Staff;", "favouriteOrder", "media", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonMedia;", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;)V", "getFavouriteOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getMedia", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;", "getRole", "getVoiceActors", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterEdge;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CharacterEdge {
        private final Integer favouriteOrder;

        /* renamed from: id */
        private final Integer f9995id;
        private final List<SeasonMedia> media;
        private final String name;
        private final Character node;
        private final String role;
        private final List<Staff> voiceActors;

        public static /* synthetic */ CharacterEdge copy$default(CharacterEdge characterEdge, Integer num, String str, String str2, List list, Integer num2, List list2, Character character, int i, Object obj) {
            if ((i & 1) != 0) {
                num = characterEdge.f9995id;
            }
            if ((i & 2) != 0) {
                str = characterEdge.role;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = characterEdge.name;
            }
            String str4 = str2;
            List<Staff> list3 = list;
            if ((i & 8) != 0) {
                list3 = characterEdge.voiceActors;
            }
            List list4 = list3;
            if ((i & 16) != 0) {
                num2 = characterEdge.favouriteOrder;
            }
            Integer num3 = num2;
            List<SeasonMedia> list5 = list2;
            if ((i & 32) != 0) {
                list5 = characterEdge.media;
            }
            List list6 = list5;
            if ((i & 64) != 0) {
                character = characterEdge.node;
            }
            return characterEdge.copy(num, str3, str4, list4, num3, list6, character);
        }

        public final Integer component1() {
            return this.f9995id;
        }

        public final String component2() {
            return this.role;
        }

        public final String component3() {
            return this.name;
        }

        public final List<Staff> component4() {
            return this.voiceActors;
        }

        public final Integer component5() {
            return this.favouriteOrder;
        }

        public final List<SeasonMedia> component6() {
            return this.media;
        }

        public final Character component7() {
            return this.node;
        }

        public final CharacterEdge copy(@JsonProperty("id") Integer num, @JsonProperty("role") String str, @JsonProperty("name") String str2, @JsonProperty("voiceActors") List<Staff> list, @JsonProperty("favouriteOrder") Integer num2, @JsonProperty("media") List<SeasonMedia> list2, @JsonProperty("node") Character character) {
            return new CharacterEdge(num, str, str2, list, num2, list2, character);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CharacterEdge) {
                CharacterEdge characterEdge = (CharacterEdge) obj;
                return Intrinsics.areEqual(this.f9995id, characterEdge.f9995id) && Intrinsics.areEqual(this.role, characterEdge.role) && Intrinsics.areEqual(this.name, characterEdge.name) && Intrinsics.areEqual(this.voiceActors, characterEdge.voiceActors) && Intrinsics.areEqual(this.favouriteOrder, characterEdge.favouriteOrder) && Intrinsics.areEqual(this.media, characterEdge.media) && Intrinsics.areEqual(this.node, characterEdge.node);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9995id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.role;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<Staff> list = this.voiceActors;
            int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            Integer num2 = this.favouriteOrder;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            List<SeasonMedia> list2 = this.media;
            int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
            Character character = this.node;
            return hashCode6 + (character != null ? character.hashCode() : 0);
        }

        public String toString() {
            return "CharacterEdge(id=" + this.f9995id + ", role=" + this.role + ", name=" + this.name + ", voiceActors=" + this.voiceActors + ", favouriteOrder=" + this.favouriteOrder + ", media=" + this.media + ", node=" + this.node + ')';
        }

        public CharacterEdge(@JsonProperty("id") Integer num, @JsonProperty("role") String str, @JsonProperty("name") String str2, @JsonProperty("voiceActors") List<Staff> list, @JsonProperty("favouriteOrder") Integer num2, @JsonProperty("media") List<SeasonMedia> list2, @JsonProperty("node") Character character) {
            this.f9995id = num;
            this.role = str;
            this.name = str2;
            this.voiceActors = list;
            this.favouriteOrder = num2;
            this.media = list2;
            this.node = character;
        }

        public final Integer getId() {
            return this.f9995id;
        }

        public final String getRole() {
            return this.role;
        }

        public final String getName() {
            return this.name;
        }

        public final List<Staff> getVoiceActors() {
            return this.voiceActors;
        }

        public final Integer getFavouriteOrder() {
            return this.favouriteOrder;
        }

        public final List<SeasonMedia> getMedia() {
            return this.media;
        }

        public final Character getNode() {
            return this.node;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffImage;", "", "large", "", "medium", "(Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class StaffImage {
        private final String large;
        private final String medium;

        public static /* synthetic */ StaffImage copy$default(StaffImage staffImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = staffImage.large;
            }
            if ((i & 2) != 0) {
                str2 = staffImage.medium;
            }
            return staffImage.copy(str, str2);
        }

        public final String component1() {
            return this.large;
        }

        public final String component2() {
            return this.medium;
        }

        public final StaffImage copy(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
            return new StaffImage(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StaffImage) {
                StaffImage staffImage = (StaffImage) obj;
                return Intrinsics.areEqual(this.large, staffImage.large) && Intrinsics.areEqual(this.medium, staffImage.medium);
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
            return "StaffImage(large=" + this.large + ", medium=" + this.medium + ')';
        }

        public StaffImage(@JsonProperty("large") String str, @JsonProperty("medium") String str2) {
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

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010\u001c\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffName;", "", "first", "", "middle", "last", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "alternative", "", "userPreferred", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAlternative", "()Ljava/util/List;", "getFirst", "()Ljava/lang/String;", "getFull", "getLast", "getMiddle", "getNative", "getUserPreferred", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class StaffName {
        private final List<String> alternative;
        private final String first;
        private final String full;
        private final String last;
        private final String middle;

        /* renamed from: native  reason: not valid java name */
        private final String f10820native;
        private final String userPreferred;

        public static /* synthetic */ StaffName copy$default(StaffName staffName, String str, String str2, String str3, String str4, String str5, List list, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = staffName.first;
            }
            if ((i & 2) != 0) {
                str2 = staffName.middle;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = staffName.last;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = staffName.full;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = staffName.f10820native;
            }
            String str10 = str5;
            List<String> list2 = list;
            if ((i & 32) != 0) {
                list2 = staffName.alternative;
            }
            List list3 = list2;
            if ((i & 64) != 0) {
                str6 = staffName.userPreferred;
            }
            return staffName.copy(str, str7, str8, str9, str10, list3, str6);
        }

        public final String component1() {
            return this.first;
        }

        public final String component2() {
            return this.middle;
        }

        public final String component3() {
            return this.last;
        }

        public final String component4() {
            return this.full;
        }

        public final String component5() {
            return this.f10820native;
        }

        public final List<String> component6() {
            return this.alternative;
        }

        public final String component7() {
            return this.userPreferred;
        }

        public final StaffName copy(@JsonProperty("name") String str, @JsonProperty("middle") String str2, @JsonProperty("last") String str3, @JsonProperty("full") String str4, @JsonProperty("native") String str5, @JsonProperty("alternative") List<String> list, @JsonProperty("userPreferred") String str6) {
            return new StaffName(str, str2, str3, str4, str5, list, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StaffName) {
                StaffName staffName = (StaffName) obj;
                return Intrinsics.areEqual(this.first, staffName.first) && Intrinsics.areEqual(this.middle, staffName.middle) && Intrinsics.areEqual(this.last, staffName.last) && Intrinsics.areEqual(this.full, staffName.full) && Intrinsics.areEqual(this.f10820native, staffName.f10820native) && Intrinsics.areEqual(this.alternative, staffName.alternative) && Intrinsics.areEqual(this.userPreferred, staffName.userPreferred);
            }
            return false;
        }

        public int hashCode() {
            String str = this.first;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.middle;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.last;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.full;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f10820native;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            List<String> list = this.alternative;
            int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
            String str6 = this.userPreferred;
            return hashCode6 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "StaffName(first=" + this.first + ", middle=" + this.middle + ", last=" + this.last + ", full=" + this.full + ", native=" + this.f10820native + ", alternative=" + this.alternative + ", userPreferred=" + this.userPreferred + ')';
        }

        public StaffName(@JsonProperty("name") String str, @JsonProperty("middle") String str2, @JsonProperty("last") String str3, @JsonProperty("full") String str4, @JsonProperty("native") String str5, @JsonProperty("alternative") List<String> list, @JsonProperty("userPreferred") String str6) {
            this.first = str;
            this.middle = str2;
            this.last = str3;
            this.full = str4;
            this.f10820native = str5;
            this.alternative = list;
            this.userPreferred = str6;
        }

        public final String getFirst() {
            return this.first;
        }

        public final String getMiddle() {
            return this.middle;
        }

        public final String getLast() {
            return this.last;
        }

        public final String getFull() {
            return this.full;
        }

        public final String getNative() {
            return this.f10820native;
        }

        public final List<String> getAlternative() {
            return this.alternative;
        }

        public final String getUserPreferred() {
            return this.userPreferred;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Staff;", "", "image", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffImage;", "name", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffName;", "age", "", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffImage;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffName;Ljava/lang/Integer;)V", "getAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffImage;", "getName", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffName;", "component1", "component2", "component3", "copy", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffImage;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StaffName;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Staff;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Staff {
        private final Integer age;
        private final StaffImage image;
        private final StaffName name;

        public static /* synthetic */ Staff copy$default(Staff staff, StaffImage staffImage, StaffName staffName, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                staffImage = staff.image;
            }
            if ((i & 2) != 0) {
                staffName = staff.name;
            }
            if ((i & 4) != 0) {
                num = staff.age;
            }
            return staff.copy(staffImage, staffName, num);
        }

        public final StaffImage component1() {
            return this.image;
        }

        public final StaffName component2() {
            return this.name;
        }

        public final Integer component3() {
            return this.age;
        }

        public final Staff copy(@JsonProperty("image") StaffImage staffImage, @JsonProperty("name") StaffName staffName, @JsonProperty("age") Integer num) {
            return new Staff(staffImage, staffName, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Staff) {
                Staff staff = (Staff) obj;
                return Intrinsics.areEqual(this.image, staff.image) && Intrinsics.areEqual(this.name, staff.name) && Intrinsics.areEqual(this.age, staff.age);
            }
            return false;
        }

        public int hashCode() {
            StaffImage staffImage = this.image;
            int hashCode = (staffImage == null ? 0 : staffImage.hashCode()) * 31;
            StaffName staffName = this.name;
            int hashCode2 = (hashCode + (staffName == null ? 0 : staffName.hashCode())) * 31;
            Integer num = this.age;
            return hashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "Staff(image=" + this.image + ", name=" + this.name + ", age=" + this.age + ')';
        }

        public Staff(@JsonProperty("image") StaffImage staffImage, @JsonProperty("name") StaffName staffName, @JsonProperty("age") Integer num) {
            this.image = staffImage;
            this.name = staffName;
            this.age = num;
        }

        public final StaffImage getImage() {
            return this.image;
        }

        public final StaffName getName() {
            return this.name;
        }

        public final Integer getAge() {
            return this.age;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterConnection;", "", "edges", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CharacterEdge;", "nodes", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Character;", "(Ljava/util/List;Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "getNodes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CharacterConnection {
        private final List<CharacterEdge> edges;
        private final List<Character> nodes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CharacterConnection copy$default(CharacterConnection characterConnection, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = characterConnection.edges;
            }
            if ((i & 2) != 0) {
                list2 = characterConnection.nodes;
            }
            return characterConnection.copy(list, list2);
        }

        public final List<CharacterEdge> component1() {
            return this.edges;
        }

        public final List<Character> component2() {
            return this.nodes;
        }

        public final CharacterConnection copy(@JsonProperty("edges") List<CharacterEdge> list, @JsonProperty("nodes") List<Character> list2) {
            return new CharacterConnection(list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CharacterConnection) {
                CharacterConnection characterConnection = (CharacterConnection) obj;
                return Intrinsics.areEqual(this.edges, characterConnection.edges) && Intrinsics.areEqual(this.nodes, characterConnection.nodes);
            }
            return false;
        }

        public int hashCode() {
            List<CharacterEdge> list = this.edges;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            List<Character> list2 = this.nodes;
            return hashCode + (list2 != null ? list2.hashCode() : 0);
        }

        public String toString() {
            return "CharacterConnection(edges=" + this.edges + ", nodes=" + this.nodes + ')';
        }

        public CharacterConnection(@JsonProperty("edges") List<CharacterEdge> list, @JsonProperty("nodes") List<Character> list2) {
            this.edges = list;
            this.nodes = list2;
        }

        public final List<CharacterEdge> getEdges() {
            return this.edges;
        }

        public final List<Character> getNodes() {
            return this.nodes;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTrailer;", "", "id", "", "site", "thumbnail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSite", "getThumbnail", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MediaTrailer {

        /* renamed from: id */
        private final String f10000id;
        private final String site;
        private final String thumbnail;

        public static /* synthetic */ MediaTrailer copy$default(MediaTrailer mediaTrailer, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mediaTrailer.f10000id;
            }
            if ((i & 2) != 0) {
                str2 = mediaTrailer.site;
            }
            if ((i & 4) != 0) {
                str3 = mediaTrailer.thumbnail;
            }
            return mediaTrailer.copy(str, str2, str3);
        }

        public final String component1() {
            return this.f10000id;
        }

        public final String component2() {
            return this.site;
        }

        public final String component3() {
            return this.thumbnail;
        }

        public final MediaTrailer copy(@JsonProperty("id") String str, @JsonProperty("site") String str2, @JsonProperty("thumbnail") String str3) {
            return new MediaTrailer(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MediaTrailer) {
                MediaTrailer mediaTrailer = (MediaTrailer) obj;
                return Intrinsics.areEqual(this.f10000id, mediaTrailer.f10000id) && Intrinsics.areEqual(this.site, mediaTrailer.site) && Intrinsics.areEqual(this.thumbnail, mediaTrailer.thumbnail);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f10000id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.site;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.thumbnail;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "MediaTrailer(id=" + this.f10000id + ", site=" + this.site + ", thumbnail=" + this.thumbnail + ')';
        }

        public MediaTrailer(@JsonProperty("id") String str, @JsonProperty("site") String str2, @JsonProperty("thumbnail") String str3) {
            this.f10000id = str;
            this.site = str2;
            this.thumbnail = str3;
        }

        public final String getId() {
            return this.f10000id;
        }

        public final String getSite() {
            return this.site;
        }

        public final String getThumbnail() {
            return this.thumbnail;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaCoverImage;", "", "extraLarge", "", "large", "medium", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getExtraLarge", "getLarge", "getMedium", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MediaCoverImage {
        private final String color;
        private final String extraLarge;
        private final String large;
        private final String medium;

        public static /* synthetic */ MediaCoverImage copy$default(MediaCoverImage mediaCoverImage, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mediaCoverImage.extraLarge;
            }
            if ((i & 2) != 0) {
                str2 = mediaCoverImage.large;
            }
            if ((i & 4) != 0) {
                str3 = mediaCoverImage.medium;
            }
            if ((i & 8) != 0) {
                str4 = mediaCoverImage.color;
            }
            return mediaCoverImage.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.extraLarge;
        }

        public final String component2() {
            return this.large;
        }

        public final String component3() {
            return this.medium;
        }

        public final String component4() {
            return this.color;
        }

        public final MediaCoverImage copy(@JsonProperty("extraLarge") String str, @JsonProperty("large") String str2, @JsonProperty("medium") String str3, @JsonProperty("color") String str4) {
            return new MediaCoverImage(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MediaCoverImage) {
                MediaCoverImage mediaCoverImage = (MediaCoverImage) obj;
                return Intrinsics.areEqual(this.extraLarge, mediaCoverImage.extraLarge) && Intrinsics.areEqual(this.large, mediaCoverImage.large) && Intrinsics.areEqual(this.medium, mediaCoverImage.medium) && Intrinsics.areEqual(this.color, mediaCoverImage.color);
            }
            return false;
        }

        public int hashCode() {
            String str = this.extraLarge;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.large;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.medium;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.color;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "MediaCoverImage(extraLarge=" + this.extraLarge + ", large=" + this.large + ", medium=" + this.medium + ", color=" + this.color + ')';
        }

        public MediaCoverImage(@JsonProperty("extraLarge") String str, @JsonProperty("large") String str2, @JsonProperty("medium") String str3, @JsonProperty("color") String str4) {
            this.extraLarge = str;
            this.large = str2;
            this.medium = str3;
            this.color = str4;
        }

        public final String getExtraLarge() {
            return this.extraLarge;
        }

        public final String getLarge() {
            return this.large;
        }

        public final String getMedium() {
            return this.medium;
        }

        public final String getColor() {
            return this.color;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "", "episode", "", "timeUntilAiring", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimeUntilAiring", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonNextAiringEpisode {
        private final Integer episode;
        private final Integer timeUntilAiring;

        public static /* synthetic */ SeasonNextAiringEpisode copy$default(SeasonNextAiringEpisode seasonNextAiringEpisode, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seasonNextAiringEpisode.episode;
            }
            if ((i & 2) != 0) {
                num2 = seasonNextAiringEpisode.timeUntilAiring;
            }
            return seasonNextAiringEpisode.copy(num, num2);
        }

        public final Integer component1() {
            return this.episode;
        }

        public final Integer component2() {
            return this.timeUntilAiring;
        }

        public final SeasonNextAiringEpisode copy(@JsonProperty("episode") Integer num, @JsonProperty("timeUntilAiring") Integer num2) {
            return new SeasonNextAiringEpisode(num, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeasonNextAiringEpisode) {
                SeasonNextAiringEpisode seasonNextAiringEpisode = (SeasonNextAiringEpisode) obj;
                return Intrinsics.areEqual(this.episode, seasonNextAiringEpisode.episode) && Intrinsics.areEqual(this.timeUntilAiring, seasonNextAiringEpisode.timeUntilAiring);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.episode;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.timeUntilAiring;
            return hashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "SeasonNextAiringEpisode(episode=" + this.episode + ", timeUntilAiring=" + this.timeUntilAiring + ')';
        }

        public SeasonNextAiringEpisode(@JsonProperty("episode") Integer num, @JsonProperty("timeUntilAiring") Integer num2) {
            this.episode = num;
            this.timeUntilAiring = num2;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final Integer getTimeUntilAiring() {
            return this.timeUntilAiring;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;", "", "edges", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdge;", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonEdges {
        private final List<SeasonEdge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeasonEdges copy$default(SeasonEdges seasonEdges, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = seasonEdges.edges;
            }
            return seasonEdges.copy(list);
        }

        public final List<SeasonEdge> component1() {
            return this.edges;
        }

        public final SeasonEdges copy(@JsonProperty("edges") List<SeasonEdge> list) {
            return new SeasonEdges(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SeasonEdges) && Intrinsics.areEqual(this.edges, ((SeasonEdges) obj).edges);
        }

        public int hashCode() {
            List<SeasonEdge> list = this.edges;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "SeasonEdges(edges=" + this.edges + ')';
        }

        public SeasonEdges(@JsonProperty("edges") List<SeasonEdge> list) {
            this.edges = list;
        }

        public final List<SeasonEdge> getEdges() {
            return this.edges;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdge;", "", "id", "", "relationType", "", "node", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;", "getRelationType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdge;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonEdge {

        /* renamed from: id */
        private final Integer f10002id;
        private final SeasonNode node;
        private final String relationType;

        public static /* synthetic */ SeasonEdge copy$default(SeasonEdge seasonEdge, Integer num, String str, SeasonNode seasonNode, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seasonEdge.f10002id;
            }
            if ((i & 2) != 0) {
                str = seasonEdge.relationType;
            }
            if ((i & 4) != 0) {
                seasonNode = seasonEdge.node;
            }
            return seasonEdge.copy(num, str, seasonNode);
        }

        public final Integer component1() {
            return this.f10002id;
        }

        public final String component2() {
            return this.relationType;
        }

        public final SeasonNode component3() {
            return this.node;
        }

        public final SeasonEdge copy(@JsonProperty("id") Integer num, @JsonProperty("relationType") String str, @JsonProperty("node") SeasonNode seasonNode) {
            return new SeasonEdge(num, str, seasonNode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeasonEdge) {
                SeasonEdge seasonEdge = (SeasonEdge) obj;
                return Intrinsics.areEqual(this.f10002id, seasonEdge.f10002id) && Intrinsics.areEqual(this.relationType, seasonEdge.relationType) && Intrinsics.areEqual(this.node, seasonEdge.node);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10002id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.relationType;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            SeasonNode seasonNode = this.node;
            return hashCode2 + (seasonNode != null ? seasonNode.hashCode() : 0);
        }

        public String toString() {
            return "SeasonEdge(id=" + this.f10002id + ", relationType=" + this.relationType + ", node=" + this.node + ')';
        }

        public SeasonEdge(@JsonProperty("id") Integer num, @JsonProperty("relationType") String str, @JsonProperty("node") SeasonNode seasonNode) {
            this.f10002id = num;
            this.relationType = str;
            this.node = seasonNode;
        }

        public final Integer getId() {
            return this.f10002id;
        }

        public final String getRelationType() {
            return this.relationType;
        }

        public final SeasonNode getNode() {
            return this.node;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavoritesMediaConnection;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeNode;", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListFavoritesMediaConnection {
        private final List<LikeNode> nodes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniListFavoritesMediaConnection copy$default(AniListFavoritesMediaConnection aniListFavoritesMediaConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aniListFavoritesMediaConnection.nodes;
            }
            return aniListFavoritesMediaConnection.copy(list);
        }

        public final List<LikeNode> component1() {
            return this.nodes;
        }

        public final AniListFavoritesMediaConnection copy(@JsonProperty("nodes") List<LikeNode> nodes) {
            Intrinsics.checkNotNullParameter(nodes, "nodes");
            return new AniListFavoritesMediaConnection(nodes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AniListFavoritesMediaConnection) && Intrinsics.areEqual(this.nodes, ((AniListFavoritesMediaConnection) obj).nodes);
        }

        public int hashCode() {
            return this.nodes.hashCode();
        }

        public String toString() {
            return "AniListFavoritesMediaConnection(nodes=" + this.nodes + ')';
        }

        public AniListFavoritesMediaConnection(@JsonProperty("nodes") List<LikeNode> nodes) {
            Intrinsics.checkNotNullParameter(nodes, "nodes");
            this.nodes = nodes;
        }

        public final List<LikeNode> getNodes() {
            return this.nodes;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavourites;", "", "anime", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavoritesMediaConnection;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavoritesMediaConnection;)V", "getAnime", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavoritesMediaConnection;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListFavourites {
        private final AniListFavoritesMediaConnection anime;

        public static /* synthetic */ AniListFavourites copy$default(AniListFavourites aniListFavourites, AniListFavoritesMediaConnection aniListFavoritesMediaConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                aniListFavoritesMediaConnection = aniListFavourites.anime;
            }
            return aniListFavourites.copy(aniListFavoritesMediaConnection);
        }

        public final AniListFavoritesMediaConnection component1() {
            return this.anime;
        }

        public final AniListFavourites copy(@JsonProperty("anime") AniListFavoritesMediaConnection anime) {
            Intrinsics.checkNotNullParameter(anime, "anime");
            return new AniListFavourites(anime);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AniListFavourites) && Intrinsics.areEqual(this.anime, ((AniListFavourites) obj).anime);
        }

        public int hashCode() {
            return this.anime.hashCode();
        }

        public String toString() {
            return "AniListFavourites(anime=" + this.anime + ')';
        }

        public AniListFavourites(@JsonProperty("anime") AniListFavoritesMediaConnection anime) {
            Intrinsics.checkNotNullParameter(anime, "anime");
            this.anime = anime;
        }

        public final AniListFavoritesMediaConnection getAnime() {
            return this.anime;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaTitle;", "", "romaji", "", "english", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "userPreferred", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnglish", "()Ljava/lang/String;", "getNative", "getRomaji", "getUserPreferred", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MediaTitle {
        private final String english;

        /* renamed from: native  reason: not valid java name */
        private final String f10819native;
        private final String romaji;
        private final String userPreferred;

        public static /* synthetic */ MediaTitle copy$default(MediaTitle mediaTitle, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mediaTitle.romaji;
            }
            if ((i & 2) != 0) {
                str2 = mediaTitle.english;
            }
            if ((i & 4) != 0) {
                str3 = mediaTitle.f10819native;
            }
            if ((i & 8) != 0) {
                str4 = mediaTitle.userPreferred;
            }
            return mediaTitle.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.romaji;
        }

        public final String component2() {
            return this.english;
        }

        public final String component3() {
            return this.f10819native;
        }

        public final String component4() {
            return this.userPreferred;
        }

        public final MediaTitle copy(@JsonProperty("romaji") String str, @JsonProperty("english") String str2, @JsonProperty("native") String str3, @JsonProperty("userPreferred") String str4) {
            return new MediaTitle(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MediaTitle) {
                MediaTitle mediaTitle = (MediaTitle) obj;
                return Intrinsics.areEqual(this.romaji, mediaTitle.romaji) && Intrinsics.areEqual(this.english, mediaTitle.english) && Intrinsics.areEqual(this.f10819native, mediaTitle.f10819native) && Intrinsics.areEqual(this.userPreferred, mediaTitle.userPreferred);
            }
            return false;
        }

        public int hashCode() {
            String str = this.romaji;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.english;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f10819native;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.userPreferred;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "MediaTitle(romaji=" + this.romaji + ", english=" + this.english + ", native=" + this.f10819native + ", userPreferred=" + this.userPreferred + ')';
        }

        public MediaTitle(@JsonProperty("romaji") String str, @JsonProperty("english") String str2, @JsonProperty("native") String str3, @JsonProperty("userPreferred") String str4) {
            this.romaji = str;
            this.english = str2;
            this.f10819native = str3;
            this.userPreferred = str4;
        }

        public final String getRomaji() {
            return this.romaji;
        }

        public final String getEnglish() {
            return this.english;
        }

        public final String getNative() {
            return this.f10819native;
        }

        public final String getUserPreferred() {
            return this.userPreferred;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJT\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;", "", "id", "", "format", "", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "idMal", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "averageScore", "(ILjava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/Integer;)V", "getAverageScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getFormat", "()Ljava/lang/String;", "getId", "()I", "getIdMal", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNode;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeasonNode {
        private final Integer averageScore;
        private final CoverImage coverImage;
        private final String format;

        /* renamed from: id */
        private final int f10004id;
        private final Integer idMal;
        private final Title title;

        public static /* synthetic */ SeasonNode copy$default(SeasonNode seasonNode, int i, String str, Title title, Integer num, CoverImage coverImage, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = seasonNode.f10004id;
            }
            if ((i2 & 2) != 0) {
                str = seasonNode.format;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                title = seasonNode.title;
            }
            Title title2 = title;
            if ((i2 & 8) != 0) {
                num = seasonNode.idMal;
            }
            Integer num3 = num;
            if ((i2 & 16) != 0) {
                coverImage = seasonNode.coverImage;
            }
            CoverImage coverImage2 = coverImage;
            if ((i2 & 32) != 0) {
                num2 = seasonNode.averageScore;
            }
            return seasonNode.copy(i, str2, title2, num3, coverImage2, num2);
        }

        public final int component1() {
            return this.f10004id;
        }

        public final String component2() {
            return this.format;
        }

        public final Title component3() {
            return this.title;
        }

        public final Integer component4() {
            return this.idMal;
        }

        public final CoverImage component5() {
            return this.coverImage;
        }

        public final Integer component6() {
            return this.averageScore;
        }

        public final SeasonNode copy(@JsonProperty("id") int i, @JsonProperty("format") String str, @JsonProperty("title") Title title, @JsonProperty("idMal") Integer num, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("averageScore") Integer num2) {
            return new SeasonNode(i, str, title, num, coverImage, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeasonNode) {
                SeasonNode seasonNode = (SeasonNode) obj;
                return this.f10004id == seasonNode.f10004id && Intrinsics.areEqual(this.format, seasonNode.format) && Intrinsics.areEqual(this.title, seasonNode.title) && Intrinsics.areEqual(this.idMal, seasonNode.idMal) && Intrinsics.areEqual(this.coverImage, seasonNode.coverImage) && Intrinsics.areEqual(this.averageScore, seasonNode.averageScore);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f10004id * 31;
            String str = this.format;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Title title = this.title;
            int hashCode2 = (hashCode + (title == null ? 0 : title.hashCode())) * 31;
            Integer num = this.idMal;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            CoverImage coverImage = this.coverImage;
            int hashCode4 = (hashCode3 + (coverImage == null ? 0 : coverImage.hashCode())) * 31;
            Integer num2 = this.averageScore;
            return hashCode4 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "SeasonNode(id=" + this.f10004id + ", format=" + this.format + ", title=" + this.title + ", idMal=" + this.idMal + ", coverImage=" + this.coverImage + ", averageScore=" + this.averageScore + ')';
        }

        public SeasonNode(@JsonProperty("id") int i, @JsonProperty("format") String str, @JsonProperty("title") Title title, @JsonProperty("idMal") Integer num, @JsonProperty("coverImage") CoverImage coverImage, @JsonProperty("averageScore") Integer num2) {
            this.f10004id = i;
            this.format = str;
            this.title = title;
            this.idMal = num;
            this.coverImage = coverImage;
            this.averageScore = num2;
        }

        public final int getId() {
            return this.f10004id;
        }

        public final String getFormat() {
            return this.format;
        }

        public final Title getTitle() {
            return this.title;
        }

        public final Integer getIdMal() {
            return this.idMal;
        }

        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        public final Integer getAverageScore() {
            return this.averageScore;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListAvatar;", "", "large", "", "(Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListAvatar {
        private final String large;

        public static /* synthetic */ AniListAvatar copy$default(AniListAvatar aniListAvatar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aniListAvatar.large;
            }
            return aniListAvatar.copy(str);
        }

        public final String component1() {
            return this.large;
        }

        public final AniListAvatar copy(@JsonProperty("large") String str) {
            return new AniListAvatar(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AniListAvatar) && Intrinsics.areEqual(this.large, ((AniListAvatar) obj).large);
        }

        public int hashCode() {
            String str = this.large;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "AniListAvatar(large=" + this.large + ')';
        }

        public AniListAvatar(@JsonProperty("large") String str) {
            this.large = str;
        }

        public final String getLarge() {
            return this.large;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListViewer;", "", "id", "", "name", "", "avatar", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListAvatar;", "favourites", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavourites;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListAvatar;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavourites;)V", "getAvatar", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListAvatar;", "getFavourites", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavourites;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListAvatar;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListFavourites;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListViewer;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListViewer {
        private final AniListAvatar avatar;
        private final AniListFavourites favourites;

        /* renamed from: id */
        private final Integer f9994id;
        private final String name;

        public static /* synthetic */ AniListViewer copy$default(AniListViewer aniListViewer, Integer num, String str, AniListAvatar aniListAvatar, AniListFavourites aniListFavourites, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniListViewer.f9994id;
            }
            if ((i & 2) != 0) {
                str = aniListViewer.name;
            }
            if ((i & 4) != 0) {
                aniListAvatar = aniListViewer.avatar;
            }
            if ((i & 8) != 0) {
                aniListFavourites = aniListViewer.favourites;
            }
            return aniListViewer.copy(num, str, aniListAvatar, aniListFavourites);
        }

        public final Integer component1() {
            return this.f9994id;
        }

        public final String component2() {
            return this.name;
        }

        public final AniListAvatar component3() {
            return this.avatar;
        }

        public final AniListFavourites component4() {
            return this.favourites;
        }

        public final AniListViewer copy(@JsonProperty("id") Integer num, @JsonProperty("name") String str, @JsonProperty("avatar") AniListAvatar aniListAvatar, @JsonProperty("favourites") AniListFavourites aniListFavourites) {
            return new AniListViewer(num, str, aniListAvatar, aniListFavourites);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AniListViewer) {
                AniListViewer aniListViewer = (AniListViewer) obj;
                return Intrinsics.areEqual(this.f9994id, aniListViewer.f9994id) && Intrinsics.areEqual(this.name, aniListViewer.name) && Intrinsics.areEqual(this.avatar, aniListViewer.avatar) && Intrinsics.areEqual(this.favourites, aniListViewer.favourites);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9994id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.name;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            AniListAvatar aniListAvatar = this.avatar;
            int hashCode3 = (hashCode2 + (aniListAvatar == null ? 0 : aniListAvatar.hashCode())) * 31;
            AniListFavourites aniListFavourites = this.favourites;
            return hashCode3 + (aniListFavourites != null ? aniListFavourites.hashCode() : 0);
        }

        public String toString() {
            return "AniListViewer(id=" + this.f9994id + ", name=" + this.name + ", avatar=" + this.avatar + ", favourites=" + this.favourites + ')';
        }

        public AniListViewer(@JsonProperty("id") Integer num, @JsonProperty("name") String str, @JsonProperty("avatar") AniListAvatar aniListAvatar, @JsonProperty("favourites") AniListFavourites aniListFavourites) {
            this.f9994id = num;
            this.name = str;
            this.avatar = aniListAvatar;
            this.favourites = aniListFavourites;
        }

        public final Integer getId() {
            return this.f9994id;
        }

        public final String getName() {
            return this.name;
        }

        public final AniListAvatar getAvatar() {
            return this.avatar;
        }

        public final AniListFavourites getFavourites() {
            return this.favourites;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListData;", "", "Viewer", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListViewer;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListViewer;)V", "getViewer", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListViewer;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListData {
        private final AniListViewer Viewer;

        public static /* synthetic */ AniListData copy$default(AniListData aniListData, AniListViewer aniListViewer, int i, Object obj) {
            if ((i & 1) != 0) {
                aniListViewer = aniListData.Viewer;
            }
            return aniListData.copy(aniListViewer);
        }

        public final AniListViewer component1() {
            return this.Viewer;
        }

        public final AniListData copy(@JsonProperty("Viewer") AniListViewer aniListViewer) {
            return new AniListData(aniListViewer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AniListData) && Intrinsics.areEqual(this.Viewer, ((AniListData) obj).Viewer);
        }

        public int hashCode() {
            AniListViewer aniListViewer = this.Viewer;
            if (aniListViewer == null) {
                return 0;
            }
            return aniListViewer.hashCode();
        }

        public String toString() {
            return "AniListData(Viewer=" + this.Viewer + ')';
        }

        public AniListData(@JsonProperty("Viewer") AniListViewer aniListViewer) {
            this.Viewer = aniListViewer;
        }

        public final AniListViewer getViewer() {
            return this.Viewer;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListRoot;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListData;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListData;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListRoot {
        private final AniListData data;

        public static /* synthetic */ AniListRoot copy$default(AniListRoot aniListRoot, AniListData aniListData, int i, Object obj) {
            if ((i & 1) != 0) {
                aniListData = aniListRoot.data;
            }
            return aniListRoot.copy(aniListData);
        }

        public final AniListData component1() {
            return this.data;
        }

        public final AniListRoot copy(@JsonProperty("data") AniListData aniListData) {
            return new AniListRoot(aniListData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AniListRoot) && Intrinsics.areEqual(this.data, ((AniListRoot) obj).data);
        }

        public int hashCode() {
            AniListData aniListData = this.data;
            if (aniListData == null) {
                return 0;
            }
            return aniListData.hashCode();
        }

        public String toString() {
            return "AniListRoot(data=" + this.data + ')';
        }

        public AniListRoot(@JsonProperty("data") AniListData aniListData) {
            this.data = aniListData;
        }

        public final AniListData getData() {
            return this.data;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListUser;", "", "id", "", "name", "", "picture", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getPicture", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListUser;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListUser {

        /* renamed from: id */
        private final Integer f9993id;
        private final String name;
        private final String picture;

        public static /* synthetic */ AniListUser copy$default(AniListUser aniListUser, Integer num, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniListUser.f9993id;
            }
            if ((i & 2) != 0) {
                str = aniListUser.name;
            }
            if ((i & 4) != 0) {
                str2 = aniListUser.picture;
            }
            return aniListUser.copy(num, str, str2);
        }

        public final Integer component1() {
            return this.f9993id;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.picture;
        }

        public final AniListUser copy(@JsonProperty("id") Integer num, @JsonProperty("name") String str, @JsonProperty("picture") String str2) {
            return new AniListUser(num, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AniListUser) {
                AniListUser aniListUser = (AniListUser) obj;
                return Intrinsics.areEqual(this.f9993id, aniListUser.f9993id) && Intrinsics.areEqual(this.name, aniListUser.name) && Intrinsics.areEqual(this.picture, aniListUser.picture);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9993id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.name;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.picture;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "AniListUser(id=" + this.f9993id + ", name=" + this.name + ", picture=" + this.picture + ')';
        }

        public AniListUser(@JsonProperty("id") Integer num, @JsonProperty("name") String str, @JsonProperty("picture") String str2) {
            this.f9993id = num;
            this.name = str;
            this.picture = str2;
        }

        public final Integer getId() {
            return this.f9993id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPicture() {
            return this.picture;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeNode;", "", "id", "", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeNode;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeNode {

        /* renamed from: id */
        private final Integer f9997id;

        public static /* synthetic */ LikeNode copy$default(LikeNode likeNode, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                num = likeNode.f9997id;
            }
            return likeNode.copy(num);
        }

        public final Integer component1() {
            return this.f9997id;
        }

        public final LikeNode copy(@JsonProperty("id") Integer num) {
            return new LikeNode(num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeNode) && Intrinsics.areEqual(this.f9997id, ((LikeNode) obj).f9997id);
        }

        public int hashCode() {
            Integer num = this.f9997id;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "LikeNode(id=" + this.f9997id + ')';
        }

        public LikeNode(@JsonProperty("id") Integer num) {
            this.f9997id = num;
        }

        public final Integer getId() {
            return this.f9997id;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "", "total", "", "currentPage", "lastPage", "perPage", "hasNextPage", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCurrentPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasNextPage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastPage", "getPerPage", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikePageInfo {
        private final Integer currentPage;
        private final Boolean hasNextPage;
        private final Integer lastPage;
        private final Integer perPage;
        private final Integer total;

        public static /* synthetic */ LikePageInfo copy$default(LikePageInfo likePageInfo, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                num = likePageInfo.total;
            }
            if ((i & 2) != 0) {
                num2 = likePageInfo.currentPage;
            }
            Integer num5 = num2;
            if ((i & 4) != 0) {
                num3 = likePageInfo.lastPage;
            }
            Integer num6 = num3;
            if ((i & 8) != 0) {
                num4 = likePageInfo.perPage;
            }
            Integer num7 = num4;
            if ((i & 16) != 0) {
                bool = likePageInfo.hasNextPage;
            }
            return likePageInfo.copy(num, num5, num6, num7, bool);
        }

        public final Integer component1() {
            return this.total;
        }

        public final Integer component2() {
            return this.currentPage;
        }

        public final Integer component3() {
            return this.lastPage;
        }

        public final Integer component4() {
            return this.perPage;
        }

        public final Boolean component5() {
            return this.hasNextPage;
        }

        public final LikePageInfo copy(@JsonProperty("total") Integer num, @JsonProperty("currentPage") Integer num2, @JsonProperty("lastPage") Integer num3, @JsonProperty("perPage") Integer num4, @JsonProperty("hasNextPage") Boolean bool) {
            return new LikePageInfo(num, num2, num3, num4, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LikePageInfo) {
                LikePageInfo likePageInfo = (LikePageInfo) obj;
                return Intrinsics.areEqual(this.total, likePageInfo.total) && Intrinsics.areEqual(this.currentPage, likePageInfo.currentPage) && Intrinsics.areEqual(this.lastPage, likePageInfo.lastPage) && Intrinsics.areEqual(this.perPage, likePageInfo.perPage) && Intrinsics.areEqual(this.hasNextPage, likePageInfo.hasNextPage);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.total;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.currentPage;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.lastPage;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.perPage;
            int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Boolean bool = this.hasNextPage;
            return hashCode4 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "LikePageInfo(total=" + this.total + ", currentPage=" + this.currentPage + ", lastPage=" + this.lastPage + ", perPage=" + this.perPage + ", hasNextPage=" + this.hasNextPage + ')';
        }

        public LikePageInfo(@JsonProperty("total") Integer num, @JsonProperty("currentPage") Integer num2, @JsonProperty("lastPage") Integer num3, @JsonProperty("perPage") Integer num4, @JsonProperty("hasNextPage") Boolean bool) {
            this.total = num;
            this.currentPage = num2;
            this.lastPage = num3;
            this.perPage = num4;
            this.hasNextPage = bool;
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final Integer getCurrentPage() {
            return this.currentPage;
        }

        public final Integer getLastPage() {
            return this.lastPage;
        }

        public final Integer getPerPage() {
            return this.perPage;
        }

        public final Boolean getHasNextPage() {
            return this.hasNextPage;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeAnime;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeNode;", "pageInfo", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "(Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;)V", "getNodes", "()Ljava/util/List;", "getPageInfo", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeAnime {
        private final List<LikeNode> nodes;
        private final LikePageInfo pageInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LikeAnime copy$default(LikeAnime likeAnime, List list, LikePageInfo likePageInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                list = likeAnime.nodes;
            }
            if ((i & 2) != 0) {
                likePageInfo = likeAnime.pageInfo;
            }
            return likeAnime.copy(list, likePageInfo);
        }

        public final List<LikeNode> component1() {
            return this.nodes;
        }

        public final LikePageInfo component2() {
            return this.pageInfo;
        }

        public final LikeAnime copy(@JsonProperty("nodes") List<LikeNode> list, @JsonProperty("pageInfo") LikePageInfo likePageInfo) {
            return new LikeAnime(list, likePageInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LikeAnime) {
                LikeAnime likeAnime = (LikeAnime) obj;
                return Intrinsics.areEqual(this.nodes, likeAnime.nodes) && Intrinsics.areEqual(this.pageInfo, likeAnime.pageInfo);
            }
            return false;
        }

        public int hashCode() {
            List<LikeNode> list = this.nodes;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            LikePageInfo likePageInfo = this.pageInfo;
            return hashCode + (likePageInfo != null ? likePageInfo.hashCode() : 0);
        }

        public String toString() {
            return "LikeAnime(nodes=" + this.nodes + ", pageInfo=" + this.pageInfo + ')';
        }

        public LikeAnime(@JsonProperty("nodes") List<LikeNode> list, @JsonProperty("pageInfo") LikePageInfo likePageInfo) {
            this.nodes = list;
            this.pageInfo = likePageInfo;
        }

        public final List<LikeNode> getNodes() {
            return this.nodes;
        }

        public final LikePageInfo getPageInfo() {
            return this.pageInfo;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeFavourites;", "", "anime", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeAnime;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeAnime;)V", "getAnime", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeAnime;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeFavourites {
        private final LikeAnime anime;

        public static /* synthetic */ LikeFavourites copy$default(LikeFavourites likeFavourites, LikeAnime likeAnime, int i, Object obj) {
            if ((i & 1) != 0) {
                likeAnime = likeFavourites.anime;
            }
            return likeFavourites.copy(likeAnime);
        }

        public final LikeAnime component1() {
            return this.anime;
        }

        public final LikeFavourites copy(@JsonProperty("anime") LikeAnime likeAnime) {
            return new LikeFavourites(likeAnime);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeFavourites) && Intrinsics.areEqual(this.anime, ((LikeFavourites) obj).anime);
        }

        public int hashCode() {
            LikeAnime likeAnime = this.anime;
            if (likeAnime == null) {
                return 0;
            }
            return likeAnime.hashCode();
        }

        public String toString() {
            return "LikeFavourites(anime=" + this.anime + ')';
        }

        public LikeFavourites(@JsonProperty("anime") LikeAnime likeAnime) {
            this.anime = likeAnime;
        }

        public final LikeAnime getAnime() {
            return this.anime;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeViewer;", "", "favourites", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeFavourites;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeFavourites;)V", "getFavourites", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeFavourites;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeViewer {
        private final LikeFavourites favourites;

        public static /* synthetic */ LikeViewer copy$default(LikeViewer likeViewer, LikeFavourites likeFavourites, int i, Object obj) {
            if ((i & 1) != 0) {
                likeFavourites = likeViewer.favourites;
            }
            return likeViewer.copy(likeFavourites);
        }

        public final LikeFavourites component1() {
            return this.favourites;
        }

        public final LikeViewer copy(@JsonProperty("favourites") LikeFavourites likeFavourites) {
            return new LikeViewer(likeFavourites);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeViewer) && Intrinsics.areEqual(this.favourites, ((LikeViewer) obj).favourites);
        }

        public int hashCode() {
            LikeFavourites likeFavourites = this.favourites;
            if (likeFavourites == null) {
                return 0;
            }
            return likeFavourites.hashCode();
        }

        public String toString() {
            return "LikeViewer(favourites=" + this.favourites + ')';
        }

        public LikeViewer(@JsonProperty("favourites") LikeFavourites likeFavourites) {
            this.favourites = likeFavourites;
        }

        public final LikeFavourites getFavourites() {
            return this.favourites;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeData;", "", "Viewer", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeViewer;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeViewer;)V", "getViewer", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeViewer;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeData {
        private final LikeViewer Viewer;

        public static /* synthetic */ LikeData copy$default(LikeData likeData, LikeViewer likeViewer, int i, Object obj) {
            if ((i & 1) != 0) {
                likeViewer = likeData.Viewer;
            }
            return likeData.copy(likeViewer);
        }

        public final LikeViewer component1() {
            return this.Viewer;
        }

        public final LikeData copy(@JsonProperty("Viewer") LikeViewer likeViewer) {
            return new LikeData(likeViewer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeData) && Intrinsics.areEqual(this.Viewer, ((LikeData) obj).Viewer);
        }

        public int hashCode() {
            LikeViewer likeViewer = this.Viewer;
            if (likeViewer == null) {
                return 0;
            }
            return likeViewer.hashCode();
        }

        public String toString() {
            return "LikeData(Viewer=" + this.Viewer + ')';
        }

        public LikeData(@JsonProperty("Viewer") LikeViewer likeViewer) {
            this.Viewer = likeViewer;
        }

        public final LikeViewer getViewer() {
            return this.Viewer;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeRoot;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeData;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeData;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikeData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LikeRoot {
        private final LikeData data;

        public static /* synthetic */ LikeRoot copy$default(LikeRoot likeRoot, LikeData likeData, int i, Object obj) {
            if ((i & 1) != 0) {
                likeData = likeRoot.data;
            }
            return likeRoot.copy(likeData);
        }

        public final LikeData component1() {
            return this.data;
        }

        public final LikeRoot copy(@JsonProperty("data") LikeData likeData) {
            return new LikeRoot(likeData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LikeRoot) && Intrinsics.areEqual(this.data, ((LikeRoot) obj).data);
        }

        public int hashCode() {
            LikeData likeData = this.data;
            if (likeData == null) {
                return 0;
            }
            return likeData.hashCode();
        }

        public String toString() {
            return "LikeRoot(data=" + this.data + ')';
        }

        public LikeRoot(@JsonProperty("data") LikeData likeData) {
            this.data = likeData;
        }

        public final LikeData getData() {
            return this.data;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003Jb\u0010!\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0004\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListTitleHolder;", "", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "isFavourite", "", "id", "", "progress", "episodes", "score", "type", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;)V", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProgress", "getScore", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getType", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Companion$AniListStatusType;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$AniListTitleHolder;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class AniListTitleHolder {
        private final Integer episodes;

        /* renamed from: id */
        private final Integer f9992id;
        private final Boolean isFavourite;
        private final Integer progress;
        private final Integer score;
        private final Title title;
        private final Companion.AniListStatusType type;

        public static /* synthetic */ AniListTitleHolder copy$default(AniListTitleHolder aniListTitleHolder, Title title, Boolean bool, Integer num, Integer num2, Integer num3, Integer num4, Companion.AniListStatusType aniListStatusType, int i, Object obj) {
            if ((i & 1) != 0) {
                title = aniListTitleHolder.title;
            }
            if ((i & 2) != 0) {
                bool = aniListTitleHolder.isFavourite;
            }
            Boolean bool2 = bool;
            if ((i & 4) != 0) {
                num = aniListTitleHolder.f9992id;
            }
            Integer num5 = num;
            if ((i & 8) != 0) {
                num2 = aniListTitleHolder.progress;
            }
            Integer num6 = num2;
            if ((i & 16) != 0) {
                num3 = aniListTitleHolder.episodes;
            }
            Integer num7 = num3;
            if ((i & 32) != 0) {
                num4 = aniListTitleHolder.score;
            }
            Integer num8 = num4;
            if ((i & 64) != 0) {
                aniListStatusType = aniListTitleHolder.type;
            }
            return aniListTitleHolder.copy(title, bool2, num5, num6, num7, num8, aniListStatusType);
        }

        public final Title component1() {
            return this.title;
        }

        public final Boolean component2() {
            return this.isFavourite;
        }

        public final Integer component3() {
            return this.f9992id;
        }

        public final Integer component4() {
            return this.progress;
        }

        public final Integer component5() {
            return this.episodes;
        }

        public final Integer component6() {
            return this.score;
        }

        public final Companion.AniListStatusType component7() {
            return this.type;
        }

        public final AniListTitleHolder copy(@JsonProperty("title") Title title, @JsonProperty("isFavourite") Boolean bool, @JsonProperty("id") Integer num, @JsonProperty("progress") Integer num2, @JsonProperty("episodes") Integer num3, @JsonProperty("score") Integer num4, @JsonProperty("type") Companion.AniListStatusType aniListStatusType) {
            return new AniListTitleHolder(title, bool, num, num2, num3, num4, aniListStatusType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AniListTitleHolder) {
                AniListTitleHolder aniListTitleHolder = (AniListTitleHolder) obj;
                return Intrinsics.areEqual(this.title, aniListTitleHolder.title) && Intrinsics.areEqual(this.isFavourite, aniListTitleHolder.isFavourite) && Intrinsics.areEqual(this.f9992id, aniListTitleHolder.f9992id) && Intrinsics.areEqual(this.progress, aniListTitleHolder.progress) && Intrinsics.areEqual(this.episodes, aniListTitleHolder.episodes) && Intrinsics.areEqual(this.score, aniListTitleHolder.score) && this.type == aniListTitleHolder.type;
            }
            return false;
        }

        public int hashCode() {
            Title title = this.title;
            int hashCode = (title == null ? 0 : title.hashCode()) * 31;
            Boolean bool = this.isFavourite;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num = this.f9992id;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.progress;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.episodes;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.score;
            int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Companion.AniListStatusType aniListStatusType = this.type;
            return hashCode6 + (aniListStatusType != null ? aniListStatusType.hashCode() : 0);
        }

        public String toString() {
            return "AniListTitleHolder(title=" + this.title + ", isFavourite=" + this.isFavourite + ", id=" + this.f9992id + ", progress=" + this.progress + ", episodes=" + this.episodes + ", score=" + this.score + ", type=" + this.type + ')';
        }

        public AniListTitleHolder(@JsonProperty("title") Title title, @JsonProperty("isFavourite") Boolean bool, @JsonProperty("id") Integer num, @JsonProperty("progress") Integer num2, @JsonProperty("episodes") Integer num3, @JsonProperty("score") Integer num4, @JsonProperty("type") Companion.AniListStatusType aniListStatusType) {
            this.title = title;
            this.isFavourite = bool;
            this.f9992id = num;
            this.progress = num2;
            this.episodes = num3;
            this.score = num4;
            this.type = aniListStatusType;
        }

        public final Title getTitle() {
            return this.title;
        }

        public final Boolean isFavourite() {
            return this.isFavourite;
        }

        public final Integer getId() {
            return this.f9992id;
        }

        public final Integer getProgress() {
            return this.progress;
        }

        public final Integer getEpisodes() {
            return this.episodes;
        }

        public final Integer getScore() {
            return this.score;
        }

        public final Companion.AniListStatusType getType() {
            return this.type;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;", "", "progress", "", "status", "", "score", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScore", "getStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetDataMediaListEntry {
        private final Integer progress;
        private final Integer score;
        private final String status;

        public static /* synthetic */ GetDataMediaListEntry copy$default(GetDataMediaListEntry getDataMediaListEntry, Integer num, String str, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = getDataMediaListEntry.progress;
            }
            if ((i & 2) != 0) {
                str = getDataMediaListEntry.status;
            }
            if ((i & 4) != 0) {
                num2 = getDataMediaListEntry.score;
            }
            return getDataMediaListEntry.copy(num, str, num2);
        }

        public final Integer component1() {
            return this.progress;
        }

        public final String component2() {
            return this.status;
        }

        public final Integer component3() {
            return this.score;
        }

        public final GetDataMediaListEntry copy(@JsonProperty("progress") Integer num, @JsonProperty("status") String str, @JsonProperty("score") Integer num2) {
            return new GetDataMediaListEntry(num, str, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetDataMediaListEntry) {
                GetDataMediaListEntry getDataMediaListEntry = (GetDataMediaListEntry) obj;
                return Intrinsics.areEqual(this.progress, getDataMediaListEntry.progress) && Intrinsics.areEqual(this.status, getDataMediaListEntry.status) && Intrinsics.areEqual(this.score, getDataMediaListEntry.score);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.progress;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.status;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num2 = this.score;
            return hashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "GetDataMediaListEntry(progress=" + this.progress + ", status=" + this.status + ", score=" + this.score + ')';
        }

        public GetDataMediaListEntry(@JsonProperty("progress") Integer num, @JsonProperty("status") String str, @JsonProperty("score") Integer num2) {
            this.progress = num;
            this.status = str;
            this.score = num2;
        }

        public final Integer getProgress() {
            return this.progress;
        }

        public final String getStatus() {
            return this.status;
        }

        public final Integer getScore() {
            return this.score;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Nodes;", "", "id", "", "mediaRecommendation", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediaRecommendation", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$MediaRecommendation;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Nodes;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Nodes {

        /* renamed from: id */
        private final Integer f10001id;
        private final MediaRecommendation mediaRecommendation;

        public static /* synthetic */ Nodes copy$default(Nodes nodes, Integer num, MediaRecommendation mediaRecommendation, int i, Object obj) {
            if ((i & 1) != 0) {
                num = nodes.f10001id;
            }
            if ((i & 2) != 0) {
                mediaRecommendation = nodes.mediaRecommendation;
            }
            return nodes.copy(num, mediaRecommendation);
        }

        public final Integer component1() {
            return this.f10001id;
        }

        public final MediaRecommendation component2() {
            return this.mediaRecommendation;
        }

        public final Nodes copy(@JsonProperty("id") Integer num, @JsonProperty("mediaRecommendation") MediaRecommendation mediaRecommendation) {
            return new Nodes(num, mediaRecommendation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Nodes) {
                Nodes nodes = (Nodes) obj;
                return Intrinsics.areEqual(this.f10001id, nodes.f10001id) && Intrinsics.areEqual(this.mediaRecommendation, nodes.mediaRecommendation);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f10001id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            MediaRecommendation mediaRecommendation = this.mediaRecommendation;
            return hashCode + (mediaRecommendation != null ? mediaRecommendation.hashCode() : 0);
        }

        public String toString() {
            return "Nodes(id=" + this.f10001id + ", mediaRecommendation=" + this.mediaRecommendation + ')';
        }

        public Nodes(@JsonProperty("id") Integer num, @JsonProperty("mediaRecommendation") MediaRecommendation mediaRecommendation) {
            this.f10001id = num;
            this.mediaRecommendation = mediaRecommendation;
        }

        public final Integer getId() {
            return this.f10001id;
        }

        public final MediaRecommendation getMediaRecommendation() {
            return this.mediaRecommendation;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMedia;", "", "isFavourite", "", "episodes", "", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "mediaListEntry", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;)V", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMediaListEntry", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMediaListEntry;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMedia;", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetDataMedia {
        private final Integer episodes;
        private final Boolean isFavourite;
        private final GetDataMediaListEntry mediaListEntry;
        private final Title title;

        public static /* synthetic */ GetDataMedia copy$default(GetDataMedia getDataMedia, Boolean bool, Integer num, Title title, GetDataMediaListEntry getDataMediaListEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = getDataMedia.isFavourite;
            }
            if ((i & 2) != 0) {
                num = getDataMedia.episodes;
            }
            if ((i & 4) != 0) {
                title = getDataMedia.title;
            }
            if ((i & 8) != 0) {
                getDataMediaListEntry = getDataMedia.mediaListEntry;
            }
            return getDataMedia.copy(bool, num, title, getDataMediaListEntry);
        }

        public final Boolean component1() {
            return this.isFavourite;
        }

        public final Integer component2() {
            return this.episodes;
        }

        public final Title component3() {
            return this.title;
        }

        public final GetDataMediaListEntry component4() {
            return this.mediaListEntry;
        }

        public final GetDataMedia copy(@JsonProperty("isFavourite") Boolean bool, @JsonProperty("episodes") Integer num, @JsonProperty("title") Title title, @JsonProperty("mediaListEntry") GetDataMediaListEntry getDataMediaListEntry) {
            return new GetDataMedia(bool, num, title, getDataMediaListEntry);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetDataMedia) {
                GetDataMedia getDataMedia = (GetDataMedia) obj;
                return Intrinsics.areEqual(this.isFavourite, getDataMedia.isFavourite) && Intrinsics.areEqual(this.episodes, getDataMedia.episodes) && Intrinsics.areEqual(this.title, getDataMedia.title) && Intrinsics.areEqual(this.mediaListEntry, getDataMedia.mediaListEntry);
            }
            return false;
        }

        public int hashCode() {
            Boolean bool = this.isFavourite;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Integer num = this.episodes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Title title = this.title;
            int hashCode3 = (hashCode2 + (title == null ? 0 : title.hashCode())) * 31;
            GetDataMediaListEntry getDataMediaListEntry = this.mediaListEntry;
            return hashCode3 + (getDataMediaListEntry != null ? getDataMediaListEntry.hashCode() : 0);
        }

        public String toString() {
            return "GetDataMedia(isFavourite=" + this.isFavourite + ", episodes=" + this.episodes + ", title=" + this.title + ", mediaListEntry=" + this.mediaListEntry + ')';
        }

        public GetDataMedia(@JsonProperty("isFavourite") Boolean bool, @JsonProperty("episodes") Integer num, @JsonProperty("title") Title title, @JsonProperty("mediaListEntry") GetDataMediaListEntry getDataMediaListEntry) {
            this.isFavourite = bool;
            this.episodes = num;
            this.title = title;
            this.mediaListEntry = getDataMediaListEntry;
        }

        public final Boolean isFavourite() {
            return this.isFavourite;
        }

        public final Integer getEpisodes() {
            return this.episodes;
        }

        public final Title getTitle() {
            return this.title;
        }

        public final GetDataMediaListEntry getMediaListEntry() {
            return this.mediaListEntry;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendations;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Nodes;", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Recommendations {
        private final List<Nodes> nodes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Recommendations copy$default(Recommendations recommendations, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = recommendations.nodes;
            }
            return recommendations.copy(list);
        }

        public final List<Nodes> component1() {
            return this.nodes;
        }

        public final Recommendations copy(@JsonProperty("nodes") List<Nodes> list) {
            return new Recommendations(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Recommendations) && Intrinsics.areEqual(this.nodes, ((Recommendations) obj).nodes);
        }

        public int hashCode() {
            List<Nodes> list = this.nodes;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "Recommendations(nodes=" + this.nodes + ')';
        }

        public Recommendations(@JsonProperty("nodes") List<Nodes> list) {
            this.nodes = list;
        }

        public final List<Nodes> getNodes() {
            return this.nodes;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataData;", "", "Media", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMedia;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMedia;)V", "getMedia", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataMedia;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetDataData {
        private final GetDataMedia Media;

        public static /* synthetic */ GetDataData copy$default(GetDataData getDataData, GetDataMedia getDataMedia, int i, Object obj) {
            if ((i & 1) != 0) {
                getDataMedia = getDataData.Media;
            }
            return getDataData.copy(getDataMedia);
        }

        public final GetDataMedia component1() {
            return this.Media;
        }

        public final GetDataData copy(@JsonProperty("Media") GetDataMedia getDataMedia) {
            return new GetDataData(getDataMedia);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetDataData) && Intrinsics.areEqual(this.Media, ((GetDataData) obj).Media);
        }

        public int hashCode() {
            GetDataMedia getDataMedia = this.Media;
            if (getDataMedia == null) {
                return 0;
            }
            return getDataMedia.hashCode();
        }

        public String toString() {
            return "GetDataData(Media=" + this.Media + ')';
        }

        public GetDataData(@JsonProperty("Media") GetDataMedia getDataMedia) {
            this.Media = getDataMedia;
        }

        public final GetDataMedia getMedia() {
            return this.Media;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataRoot;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataData;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataData;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetDataData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetDataRoot {
        private final GetDataData data;

        public static /* synthetic */ GetDataRoot copy$default(GetDataRoot getDataRoot, GetDataData getDataData, int i, Object obj) {
            if ((i & 1) != 0) {
                getDataData = getDataRoot.data;
            }
            return getDataRoot.copy(getDataData);
        }

        public final GetDataData component1() {
            return this.data;
        }

        public final GetDataRoot copy(@JsonProperty("data") GetDataData getDataData) {
            return new GetDataRoot(getDataData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetDataRoot) && Intrinsics.areEqual(this.data, ((GetDataRoot) obj).data);
        }

        public int hashCode() {
            GetDataData getDataData = this.data;
            if (getDataData == null) {
                return 0;
            }
            return getDataData.hashCode();
        }

        public String toString() {
            return "GetDataRoot(data=" + this.data + ')';
        }

        public GetDataRoot(@JsonProperty("data") GetDataData getDataData) {
            this.data = getDataData;
        }

        public final GetDataData getData() {
            return this.data;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchTitle;", "", "romaji", "", "(Ljava/lang/String;)V", "getRomaji", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetSearchTitle {
        private final String romaji;

        public static /* synthetic */ GetSearchTitle copy$default(GetSearchTitle getSearchTitle, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getSearchTitle.romaji;
            }
            return getSearchTitle.copy(str);
        }

        public final String component1() {
            return this.romaji;
        }

        public final GetSearchTitle copy(@JsonProperty("romaji") String str) {
            return new GetSearchTitle(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetSearchTitle) && Intrinsics.areEqual(this.romaji, ((GetSearchTitle) obj).romaji);
        }

        public int hashCode() {
            String str = this.romaji;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "GetSearchTitle(romaji=" + this.romaji + ')';
        }

        public GetSearchTitle(@JsonProperty("romaji") String str) {
            this.romaji = str;
        }

        public final String getRomaji() {
            return this.romaji;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$TrailerObject;", "", "id", "", "thumbnail", "site", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSite", "getThumbnail", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TrailerObject {

        /* renamed from: id */
        private final String f10005id;
        private final String site;
        private final String thumbnail;

        public static /* synthetic */ TrailerObject copy$default(TrailerObject trailerObject, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailerObject.f10005id;
            }
            if ((i & 2) != 0) {
                str2 = trailerObject.thumbnail;
            }
            if ((i & 4) != 0) {
                str3 = trailerObject.site;
            }
            return trailerObject.copy(str, str2, str3);
        }

        public final String component1() {
            return this.f10005id;
        }

        public final String component2() {
            return this.thumbnail;
        }

        public final String component3() {
            return this.site;
        }

        public final TrailerObject copy(@JsonProperty("id") String str, @JsonProperty("thumbnail") String str2, @JsonProperty("site") String str3) {
            return new TrailerObject(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TrailerObject) {
                TrailerObject trailerObject = (TrailerObject) obj;
                return Intrinsics.areEqual(this.f10005id, trailerObject.f10005id) && Intrinsics.areEqual(this.thumbnail, trailerObject.thumbnail) && Intrinsics.areEqual(this.site, trailerObject.site);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f10005id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.thumbnail;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.site;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "TrailerObject(id=" + this.f10005id + ", thumbnail=" + this.thumbnail + ", site=" + this.site + ')';
        }

        public TrailerObject(@JsonProperty("id") String str, @JsonProperty("thumbnail") String str2, @JsonProperty("site") String str3) {
            this.f10005id = str;
            this.thumbnail = str2;
            this.site = str3;
        }

        public final String getId() {
            return this.f10005id;
        }

        public final String getThumbnail() {
            return this.thumbnail;
        }

        public final String getSite() {
            return this.site;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0096\u0001\u00109\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\rHÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006@"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchMedia;", "", "id", "", "idMal", "seasonYear", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchTitle;", "startDate", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;", "averageScore", "meanScore", "bannerImage", "", "trailer", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$TrailerObject;", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendations;", "relations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;", "(ILjava/lang/Integer;ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchTitle;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$TrailerObject;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendations;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;)V", "getAverageScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBannerImage", "()Ljava/lang/String;", "getId", "()I", "getIdMal", "getMeanScore", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendations;", "getRelations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;", "getSeasonYear", "getStartDate", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchTitle;", "getTrailer", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$TrailerObject;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;ILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchTitle;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$StartedAt;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$TrailerObject;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Recommendations;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonEdges;)Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchMedia;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetSearchMedia {
        private final Integer averageScore;
        private final String bannerImage;

        /* renamed from: id */
        private final int f9996id;
        private final Integer idMal;
        private final Integer meanScore;
        private final SeasonNextAiringEpisode nextAiringEpisode;
        private final Recommendations recommendations;
        private final SeasonEdges relations;
        private final int seasonYear;
        private final StartedAt startDate;
        private final GetSearchTitle title;
        private final TrailerObject trailer;

        public final int component1() {
            return this.f9996id;
        }

        public final SeasonNextAiringEpisode component10() {
            return this.nextAiringEpisode;
        }

        public final Recommendations component11() {
            return this.recommendations;
        }

        public final SeasonEdges component12() {
            return this.relations;
        }

        public final Integer component2() {
            return this.idMal;
        }

        public final int component3() {
            return this.seasonYear;
        }

        public final GetSearchTitle component4() {
            return this.title;
        }

        public final StartedAt component5() {
            return this.startDate;
        }

        public final Integer component6() {
            return this.averageScore;
        }

        public final Integer component7() {
            return this.meanScore;
        }

        public final String component8() {
            return this.bannerImage;
        }

        public final TrailerObject component9() {
            return this.trailer;
        }

        public final GetSearchMedia copy(@JsonProperty("id") int i, @JsonProperty("idMal") Integer num, @JsonProperty("seasonYear") int i2, @JsonProperty("title") GetSearchTitle title, @JsonProperty("startDate") StartedAt startDate, @JsonProperty("averageScore") Integer num2, @JsonProperty("meanScore") Integer num3, @JsonProperty("bannerImage") String str, @JsonProperty("trailer") TrailerObject trailerObject, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode, @JsonProperty("recommendations") Recommendations recommendations, @JsonProperty("relations") SeasonEdges seasonEdges) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            return new GetSearchMedia(i, num, i2, title, startDate, num2, num3, str, trailerObject, seasonNextAiringEpisode, recommendations, seasonEdges);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetSearchMedia) {
                GetSearchMedia getSearchMedia = (GetSearchMedia) obj;
                return this.f9996id == getSearchMedia.f9996id && Intrinsics.areEqual(this.idMal, getSearchMedia.idMal) && this.seasonYear == getSearchMedia.seasonYear && Intrinsics.areEqual(this.title, getSearchMedia.title) && Intrinsics.areEqual(this.startDate, getSearchMedia.startDate) && Intrinsics.areEqual(this.averageScore, getSearchMedia.averageScore) && Intrinsics.areEqual(this.meanScore, getSearchMedia.meanScore) && Intrinsics.areEqual(this.bannerImage, getSearchMedia.bannerImage) && Intrinsics.areEqual(this.trailer, getSearchMedia.trailer) && Intrinsics.areEqual(this.nextAiringEpisode, getSearchMedia.nextAiringEpisode) && Intrinsics.areEqual(this.recommendations, getSearchMedia.recommendations) && Intrinsics.areEqual(this.relations, getSearchMedia.relations);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f9996id * 31;
            Integer num = this.idMal;
            int hashCode = (((((((i + (num == null ? 0 : num.hashCode())) * 31) + this.seasonYear) * 31) + this.title.hashCode()) * 31) + this.startDate.hashCode()) * 31;
            Integer num2 = this.averageScore;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.meanScore;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str = this.bannerImage;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            TrailerObject trailerObject = this.trailer;
            int hashCode5 = (hashCode4 + (trailerObject == null ? 0 : trailerObject.hashCode())) * 31;
            SeasonNextAiringEpisode seasonNextAiringEpisode = this.nextAiringEpisode;
            int hashCode6 = (hashCode5 + (seasonNextAiringEpisode == null ? 0 : seasonNextAiringEpisode.hashCode())) * 31;
            Recommendations recommendations = this.recommendations;
            int hashCode7 = (hashCode6 + (recommendations == null ? 0 : recommendations.hashCode())) * 31;
            SeasonEdges seasonEdges = this.relations;
            return hashCode7 + (seasonEdges != null ? seasonEdges.hashCode() : 0);
        }

        public String toString() {
            return "GetSearchMedia(id=" + this.f9996id + ", idMal=" + this.idMal + ", seasonYear=" + this.seasonYear + ", title=" + this.title + ", startDate=" + this.startDate + ", averageScore=" + this.averageScore + ", meanScore=" + this.meanScore + ", bannerImage=" + this.bannerImage + ", trailer=" + this.trailer + ", nextAiringEpisode=" + this.nextAiringEpisode + ", recommendations=" + this.recommendations + ", relations=" + this.relations + ')';
        }

        public GetSearchMedia(@JsonProperty("id") int i, @JsonProperty("idMal") Integer num, @JsonProperty("seasonYear") int i2, @JsonProperty("title") GetSearchTitle title, @JsonProperty("startDate") StartedAt startDate, @JsonProperty("averageScore") Integer num2, @JsonProperty("meanScore") Integer num3, @JsonProperty("bannerImage") String str, @JsonProperty("trailer") TrailerObject trailerObject, @JsonProperty("nextAiringEpisode") SeasonNextAiringEpisode seasonNextAiringEpisode, @JsonProperty("recommendations") Recommendations recommendations, @JsonProperty("relations") SeasonEdges seasonEdges) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            this.f9996id = i;
            this.idMal = num;
            this.seasonYear = i2;
            this.title = title;
            this.startDate = startDate;
            this.averageScore = num2;
            this.meanScore = num3;
            this.bannerImage = str;
            this.trailer = trailerObject;
            this.nextAiringEpisode = seasonNextAiringEpisode;
            this.recommendations = recommendations;
            this.relations = seasonEdges;
        }

        public final int getId() {
            return this.f9996id;
        }

        public final Integer getIdMal() {
            return this.idMal;
        }

        public final int getSeasonYear() {
            return this.seasonYear;
        }

        public final GetSearchTitle getTitle() {
            return this.title;
        }

        public final StartedAt getStartDate() {
            return this.startDate;
        }

        public final Integer getAverageScore() {
            return this.averageScore;
        }

        public final Integer getMeanScore() {
            return this.meanScore;
        }

        public final String getBannerImage() {
            return this.bannerImage;
        }

        public final TrailerObject getTrailer() {
            return this.trailer;
        }

        public final SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        public final Recommendations getRecommendations() {
            return this.recommendations;
        }

        public final SeasonEdges getRelations() {
            return this.relations;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchPage;", "", "Page", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchData;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchData;)V", "getPage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetSearchPage {
        private final GetSearchData Page;

        public static /* synthetic */ GetSearchPage copy$default(GetSearchPage getSearchPage, GetSearchData getSearchData, int i, Object obj) {
            if ((i & 1) != 0) {
                getSearchData = getSearchPage.Page;
            }
            return getSearchPage.copy(getSearchData);
        }

        public final GetSearchData component1() {
            return this.Page;
        }

        public final GetSearchPage copy(@JsonProperty("Page") GetSearchData getSearchData) {
            return new GetSearchPage(getSearchData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetSearchPage) && Intrinsics.areEqual(this.Page, ((GetSearchPage) obj).Page);
        }

        public int hashCode() {
            GetSearchData getSearchData = this.Page;
            if (getSearchData == null) {
                return 0;
            }
            return getSearchData.hashCode();
        }

        public String toString() {
            return "GetSearchPage(Page=" + this.Page + ')';
        }

        public GetSearchPage(@JsonProperty("Page") GetSearchData getSearchData) {
            this.Page = getSearchData;
        }

        public final GetSearchData getPage() {
            return this.Page;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchData;", "", "media", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchMedia;", "(Ljava/util/List;)V", "getMedia", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetSearchData {
        private final List<GetSearchMedia> media;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetSearchData copy$default(GetSearchData getSearchData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = getSearchData.media;
            }
            return getSearchData.copy(list);
        }

        public final List<GetSearchMedia> component1() {
            return this.media;
        }

        public final GetSearchData copy(@JsonProperty("media") List<GetSearchMedia> list) {
            return new GetSearchData(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetSearchData) && Intrinsics.areEqual(this.media, ((GetSearchData) obj).media);
        }

        public int hashCode() {
            List<GetSearchMedia> list = this.media;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "GetSearchData(media=" + this.media + ')';
        }

        public GetSearchData(@JsonProperty("media") List<GetSearchMedia> list) {
            this.media = list;
        }

        public final List<GetSearchMedia> getMedia() {
            return this.media;
        }
    }

    /* compiled from: AniListApi.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchRoot;", "", "data", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchPage;", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchPage;)V", "getData", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$GetSearchPage;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class GetSearchRoot {
        private final GetSearchPage data;

        public static /* synthetic */ GetSearchRoot copy$default(GetSearchRoot getSearchRoot, GetSearchPage getSearchPage, int i, Object obj) {
            if ((i & 1) != 0) {
                getSearchPage = getSearchRoot.data;
            }
            return getSearchRoot.copy(getSearchPage);
        }

        public final GetSearchPage component1() {
            return this.data;
        }

        public final GetSearchRoot copy(@JsonProperty("data") GetSearchPage getSearchPage) {
            return new GetSearchRoot(getSearchPage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetSearchRoot) && Intrinsics.areEqual(this.data, ((GetSearchRoot) obj).data);
        }

        public int hashCode() {
            GetSearchPage getSearchPage = this.data;
            if (getSearchPage == null) {
                return 0;
            }
            return getSearchPage.hashCode();
        }

        public String toString() {
            return "GetSearchRoot(data=" + this.data + ')';
        }

        public GetSearchRoot(@JsonProperty("data") GetSearchPage getSearchPage) {
            this.data = getSearchPage;
        }

        public final GetSearchPage getData() {
            return this.data;
        }
    }
}
