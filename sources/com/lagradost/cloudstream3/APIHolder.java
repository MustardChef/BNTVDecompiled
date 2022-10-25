package com.lagradost.cloudstream3;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.lagradost.cloudstream3.movieproviders.HDTodayProvider;
import com.lagradost.cloudstream3.movieproviders.LokLokProvider;
import com.lagradost.cloudstream3.movieproviders.PhimChillProvider;
import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import com.lagradost.cloudstream3.movieproviders.SolarmovieProvider;
import com.lagradost.cloudstream3.movieproviders.SubNhanhProvider;
import com.lagradost.cloudstream3.movieproviders.SuperStream;
import com.lagradost.cloudstream3.movieproviders.TocanimeProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bJ/\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0002J\n\u0010,\u001a\u00020\u000b*\u00020\u000bJ\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012*\u00020.2\b\b\u0002\u0010/\u001a\u000200J\u0010\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u00020.J\u0010\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b02*\u00020.J\u0010\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b02*\u00020.J\u0010\u00106\u001a\b\u0012\u0004\u0012\u00020702*\u00020.J\n\u00108\u001a\u00020\f*\u000209R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, m107d2 = {"Lcom/lagradost/cloudstream3/APIHolder;", "", "()V", "allProviders", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/MainAPI;", "Lkotlin/collections/ArrayList;", "getAllProviders", "()Ljava/util/ArrayList;", "apiMap", "", "", "", "getApiMap", "()Ljava/util/Map;", "setApiMap", "(Ljava/util/Map;)V", "apis", "", "getApis", "()Ljava/util/List;", "setApis", "(Ljava/util/List;)V", "defProvider", "unixTime", "", "getUnixTime", "()J", "unixTimeMS", "getUnixTimeMS", "getApiFromName", "apiName", "getApiFromNameNull", "getApiFromUrlNull", "url", "getApiNameFromUrl", "getCaptchaToken", SDKConstants.PARAM_KEY, "referer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoadResponseIdFromUrl", "initAll", "", "initMap", "capitalize", "filterProviderByPreferredMedia", "Landroid/content/Context;", "hasHomePageIsRequired", "", "getApiDubstatusSettings", "Ljava/util/HashSet;", "Lcom/lagradost/cloudstream3/DubStatus;", "getApiProviderLangSettings", "getApiSettings", "getApiTypeSettings", "Lcom/lagradost/cloudstream3/TvType;", "getId", "Lcom/lagradost/cloudstream3/LoadResponse;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class APIHolder {
    private static Map<String, Integer> apiMap;
    private static final int defProvider = 0;
    public static final APIHolder INSTANCE = new APIHolder();
    private static final ArrayList<MainAPI> allProviders = CollectionsKt.arrayListOf(new PhimChillProvider(), new SubNhanhProvider(), new LokLokProvider(), new SuperStream(), new SflixProvider(), new SolarmovieProvider(), new HDTodayProvider(), new TocanimeProvider());
    private static List<? extends MainAPI> apis = new ArrayList();

    private APIHolder() {
    }

    public final String capitalize(String str) {
        String valueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                valueOf = CharsKt.titlecase(charAt, locale);
            } else {
                valueOf = String.valueOf(charAt);
            }
            sb.append((Object) valueOf);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    public final long getUnixTime() {
        return System.currentTimeMillis() / 1000;
    }

    public final long getUnixTimeMS() {
        return System.currentTimeMillis();
    }

    public final ArrayList<MainAPI> getAllProviders() {
        return allProviders;
    }

    public final void initAll() {
        Iterator<MainAPI> it = allProviders.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
        apiMap = null;
    }

    public final List<MainAPI> getApis() {
        return apis;
    }

    public final void setApis(List<? extends MainAPI> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        apis = list;
    }

    public final Map<String, Integer> getApiMap() {
        return apiMap;
    }

    public final void setApiMap(Map<String, Integer> map) {
        apiMap = map;
    }

    public final String getApiNameFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        for (MainAPI mainAPI : apis) {
            String lowerCase = url.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) mainAPI.getMainUrl(), false, 2, (Object) null)) {
                String lowerCase2 = url.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt.contains$default((CharSequence) mainAPI.getMainUrl(), (CharSequence) lowerCase2, false, 2, (Object) null)) {
                }
            }
            return mainAPI.getName();
        }
        return apis.get(0).getName();
    }

    private final void initMap() {
        if (apiMap == null) {
            List<? extends MainAPI> list = apis;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(TuplesKt.m100to(((MainAPI) obj).getName(), Integer.valueOf(i)));
                i = i2;
            }
            apiMap = MapsKt.toMap(arrayList);
        }
    }

    public final MainAPI getApiFromName(String str) {
        MainAPI apiFromNameNull = getApiFromNameNull(str);
        return apiFromNameNull == null ? apis.get(0) : apiFromNameNull;
    }

    public final MainAPI getApiFromNameNull(String str) {
        Integer num;
        if (str == null) {
            return null;
        }
        initMap();
        Map<String, Integer> map = apiMap;
        if (map == null || (num = map.get(str)) == null) {
            return null;
        }
        return (MainAPI) CollectionsKt.getOrNull(apis, num.intValue());
    }

    public final MainAPI getApiFromUrlNull(String str) {
        if (str == null) {
            return null;
        }
        Iterator<MainAPI> it = allProviders.iterator();
        while (it.hasNext()) {
            MainAPI next = it.next();
            if (StringsKt.startsWith$default(str, next.getMainUrl(), false, 2, (Object) null)) {
                return next;
            }
        }
        return null;
    }

    public final int getLoadResponseIdFromUrl(String url, String apiName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        return StringsKt.replace$default(StringsKt.replace$default(url, getApiFromName(apiName).getMainUrl(), "", false, 4, (Object) null), "/", "", false, 4, (Object) null).hashCode();
    }

    public final int getId(LoadResponse loadResponse) {
        Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        return getLoadResponseIdFromUrl(loadResponse.getUrl(), loadResponse.getApiName());
    }

    public static /* synthetic */ Object getCaptchaToken$default(APIHolder aPIHolder, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return aPIHolder.getCaptchaToken(str, str2, str3, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0232 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCaptchaToken(java.lang.String r31, java.lang.String r32, java.lang.String r33, kotlin.coroutines.Continuation<? super java.lang.String> r34) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.APIHolder.getCaptchaToken(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final HashSet<String> getApiSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> apiProviderLangSettings = getApiProviderLangSettings(context);
        ArrayList arrayList = new ArrayList();
        for (Object obj : apis) {
            if (apiProviderLangSettings.contains(((MainAPI) obj).getLang())) {
                arrayList.add(obj);
            }
        }
        ArrayList<MainAPI> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (MainAPI mainAPI : arrayList2) {
            arrayList3.add(mainAPI.getName());
        }
        hashSet.addAll(arrayList3);
        return hashSet;
    }

    public final HashSet<DubStatus> getApiDubstatusSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        HashSet<DubStatus> hashSet = new HashSet<>();
        CollectionsKt.addAll(hashSet, DubStatus.values());
        String string = context.getString(com.bongngotv2.R.string.display_sub_key);
        HashSet<DubStatus> hashSet2 = hashSet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet2, 10));
        for (DubStatus dubStatus : hashSet2) {
            arrayList.add(dubStatus.name());
        }
        Set<String> stringSet = defaultSharedPreferences.getStringSet(string, CollectionsKt.toMutableSet(arrayList));
        if (stringSet == null) {
            return hashSet;
        }
        DubStatus[] values = DubStatus.values();
        ArrayList arrayList2 = new ArrayList(values.length);
        for (DubStatus dubStatus2 : values) {
            arrayList2.add(dubStatus2.name());
        }
        HashSet hashSet3 = CollectionsKt.toHashSet(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : stringSet) {
            if (hashSet3.contains((String) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList<String> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (String it : arrayList4) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList5.add(DubStatus.valueOf(it));
        }
        return CollectionsKt.toHashSet(arrayList5);
    }

    public final HashSet<String> getApiProviderLangSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("en");
        Set<String> stringSet = defaultSharedPreferences.getStringSet(context.getString(com.bongngotv2.R.string.provider_lang_key), CollectionsKt.toMutableSet(hashSet));
        Set<String> set = stringSet;
        return set == null || set.isEmpty() ? hashSet : CollectionsKt.toHashSet(stringSet);
    }

    public final HashSet<TvType> getApiTypeSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        HashSet<TvType> hashSet = new HashSet<>();
        CollectionsKt.addAll(hashSet, TvType.values());
        String string = context.getString(com.bongngotv2.R.string.search_types_list_key);
        HashSet<TvType> hashSet2 = hashSet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet2, 10));
        for (TvType tvType : hashSet2) {
            arrayList.add(tvType.name());
        }
        Set<String> stringSet = defaultSharedPreferences.getStringSet(string, CollectionsKt.toMutableSet(arrayList));
        Set<String> set = stringSet;
        if (set == null || set.isEmpty()) {
            return hashSet;
        }
        TvType[] values = TvType.values();
        ArrayList arrayList2 = new ArrayList(values.length);
        for (TvType tvType2 : values) {
            arrayList2.add(tvType2.name());
        }
        HashSet hashSet3 = CollectionsKt.toHashSet(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : stringSet) {
            if (hashSet3.contains((String) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList<String> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (String it : arrayList4) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList5.add(TvType.valueOf(it));
        }
        HashSet<TvType> hashSet4 = CollectionsKt.toHashSet(arrayList5);
        return hashSet4.isEmpty() ? hashSet : hashSet4;
    }

    public static /* synthetic */ List filterProviderByPreferredMedia$default(APIHolder aPIHolder, Context context, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aPIHolder.filterProviderByPreferredMedia(context, z);
    }

    public final List<MainAPI> filterProviderByPreferredMedia(Context context, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt(context.getString(com.bongngotv2.R.string.prefer_media_type_key), 0);
        HashSet<String> apiProviderLangSettings = getApiProviderLangSettings(context);
        ArrayList arrayList = new ArrayList();
        for (Object obj : apis) {
            if (apiProviderLangSettings.contains(((MainAPI) obj).getLang())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!((MainAPI) next).getHasMainPage() && z) {
                z3 = false;
            }
            if (z3) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (i < 1) {
            return arrayList3;
        }
        List listOf = CollectionsKt.listOf((Object[]) new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});
        List listOf2 = CollectionsKt.listOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Cartoon, TvType.AsianDrama});
        List listOf3 = CollectionsKt.listOf(TvType.Documentary);
        if (i != 2) {
            listOf = i != 3 ? listOf2 : listOf3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Set<TvType> supportedTypes = ((MainAPI) obj2).getSupportedTypes();
            if (!(supportedTypes instanceof Collection) || !supportedTypes.isEmpty()) {
                for (TvType tvType : supportedTypes) {
                    if (listOf.contains(tvType)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }
}
