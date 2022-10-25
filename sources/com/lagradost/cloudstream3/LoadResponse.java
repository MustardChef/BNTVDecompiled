package com.lagradost.cloudstream3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 I2\u00020\u0001:\u0001IR \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR&\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR \u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u0014\u00101\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\fR$\u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n04X¦\u000e¢\u0006\f\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R \u00107\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR \u0010:\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u0018\u0010=\u001a\u00020>X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\bD\u0010\f\"\u0004\bE\u0010\u000eR\u001a\u0010F\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0018\"\u0004\bH\u0010\u001a¨\u0006J"}, m107d2 = {"Lcom/lagradost/cloudstream3/LoadResponse;", "", "actors", "", "Lcom/lagradost/cloudstream3/ActorData;", "getActors", "()Ljava/util/List;", "setActors", "(Ljava/util/List;)V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "comingSoon", "", "getComingSoon", "()Z", "setComingSoon", "(Z)V", TypedValues.TransitionType.S_DURATION, "", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "name", "getName", "setName", "plot", "getPlot", "setPlot", "posterHeaders", "", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "posterUrl", "getPosterUrl", "setPosterUrl", "rating", "getRating", "setRating", "recommendations", "Lcom/lagradost/cloudstream3/SearchResponse;", "getRecommendations", "setRecommendations", "reviewUrl", "getReviewUrl", "syncData", "", "getSyncData", "setSyncData", "tags", "getTags", "setTags", "trailers", "getTrailers", "setTrailers", "type", "Lcom/lagradost/cloudstream3/TvType;", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "url", "getUrl", "setUrl", "year", "getYear", "setYear", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface LoadResponse {
    public static final Companion Companion = Companion.$$INSTANCE;

    List<ActorData> getActors();

    String getApiName();

    boolean getComingSoon();

    Integer getDuration();

    String getName();

    String getPlot();

    Map<String, String> getPosterHeaders();

    String getPosterUrl();

    Integer getRating();

    List<SearchResponse> getRecommendations();

    String getReviewUrl();

    Map<String, String> getSyncData();

    List<String> getTags();

    List<String> getTrailers();

    TvType getType();

    String getUrl();

    Integer getYear();

    void setActors(List<ActorData> list);

    void setApiName(String str);

    void setComingSoon(boolean z);

    void setDuration(Integer num);

    void setName(String str);

    void setPlot(String str);

    void setPosterHeaders(Map<String, String> map);

    void setPosterUrl(String str);

    void setRating(Integer num);

    void setRecommendations(List<? extends SearchResponse> list);

    void setSyncData(Map<String, String> map);

    void setTags(List<String> list);

    void setTrailers(List<String> list);

    void setType(TvType tvType);

    void setUrl(String str);

    void setYear(Integer num);

    /* compiled from: MainAPI.kt */
    @Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007¢\u0006\u0002\b\fJ/\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0018\u00010\nH\u0007¢\u0006\u0002\b\u000fJ*\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r\u0018\u00010\nH\u0007J!\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\b\u0010J\u0019\u0010\u0011\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u0007*\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0017\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0019\u0010\u001b\u001a\u00020\u0007*\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0014\u0010\u001b\u001a\u00020\u0007*\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u001e\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u001f\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0014\u0010 \u001a\u00020\u0007*\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u001a\u0010 \u001a\u00020\u0007*\u00020\b2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u0014\u0010#\u001a\u00020\u0007*\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/LoadResponse$Companion;", "", "()V", "aniListIdPrefix", "", "malIdPrefix", "addActors", "", "Lcom/lagradost/cloudstream3/LoadResponse;", "actors", "", "Lcom/lagradost/cloudstream3/Actor;", "addActorsOnly", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/ActorRole;", "addActorsRole", "addActorNames", "addAniListId", "id", "", "(Lcom/lagradost/cloudstream3/LoadResponse;Ljava/lang/Integer;)V", "addDuration", TvContractCompat.PARAM_INPUT, "addImdbId", "addImdbUrl", "url", "addMalId", "addRating", "value", "text", "addTMDbId", "addTrackId", "addTrailer", "trailerUrl", "trailerUrls", "addkitsuId", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String malIdPrefix = AccountManager.Companion.getMalApi().getIdPrefix();
        private static final String aniListIdPrefix = AccountManager.Companion.getAniListApi().getIdPrefix();

        public final void addImdbId(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        }

        public final void addTMDbId(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        }

        public final void addTrackId(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        }

        public final void addkitsuId(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
        }

        private Companion() {
        }

        public final void addActorNames(LoadResponse loadResponse, List<String> list) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            ArrayList arrayList = null;
            if (list != null) {
                List<String> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str : list2) {
                    arrayList2.add(new ActorData(new Actor(str, null, 2, null), null, null, null, 14, null));
                }
                arrayList = arrayList2;
            }
            loadResponse.setActors(arrayList);
        }

        public final void addActors(LoadResponse loadResponse, List<Tuples<Actor, String>> list) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (list != null) {
                List<Tuples<Actor, String>> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    Tuples tuples = (Tuples) it.next();
                    arrayList2.add(new ActorData((Actor) tuples.component1(), null, (String) tuples.component2(), null, 10, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            loadResponse.setActors(arrayList);
        }

        public final void addActorsRole(LoadResponse loadResponse, List<? extends Tuples<Actor, ? extends ActorRole>> list) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (list != null) {
                List<? extends Tuples<Actor, ? extends ActorRole>> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    Tuples tuples = (Tuples) it.next();
                    arrayList2.add(new ActorData((Actor) tuples.component1(), (ActorRole) tuples.component2(), null, null, 12, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            loadResponse.setActors(arrayList);
        }

        public final void addActorsOnly(LoadResponse loadResponse, List<Actor> list) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (list != null) {
                List<Actor> list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Actor actor : list2) {
                    arrayList2.add(new ActorData(actor, null, null, null, 14, null));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            loadResponse.setActors(arrayList);
        }

        public final void addMalId(LoadResponse loadResponse, Integer num) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            Map<String, String> syncData = loadResponse.getSyncData();
            String str = malIdPrefix;
            if (num != null) {
                syncData.put(str, String.valueOf(num.intValue()));
            }
        }

        public final void addAniListId(LoadResponse loadResponse, Integer num) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            Map<String, String> syncData = loadResponse.getSyncData();
            String str = aniListIdPrefix;
            if (num != null) {
                syncData.put(str, String.valueOf(num.intValue()));
            }
        }

        public final void addImdbUrl(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            addImdbId(loadResponse, MainAPIKt.imdbUrlToIdNullable(str));
        }

        public final void addTrailer(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (str == null) {
                return;
            }
            if (loadResponse.getTrailers() == null) {
                loadResponse.setTrailers(CollectionsKt.listOf(str));
                return;
            }
            List<String> trailers = loadResponse.getTrailers();
            List<String> mutableList = trailers != null ? CollectionsKt.toMutableList((Collection) trailers) : null;
            if (mutableList != null) {
                mutableList.add(str);
            }
            loadResponse.setTrailers(mutableList);
        }

        public final void addTrailer(LoadResponse loadResponse, List<String> list) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (list == null) {
                return;
            }
            if (loadResponse.getTrailers() == null) {
                loadResponse.setTrailers(list);
                return;
            }
            List<String> trailers = loadResponse.getTrailers();
            List<String> mutableList = trailers != null ? CollectionsKt.toMutableList((Collection) trailers) : null;
            if (mutableList != null) {
                mutableList.addAll(list);
            }
            loadResponse.setTrailers(mutableList);
        }

        public final void addRating(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            addRating(loadResponse, MainAPIKt.toRatingInt(str));
        }

        public final void addRating(LoadResponse loadResponse, Integer num) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            if (num == null || num.intValue() < 0 || num.intValue() > 10000) {
                return;
            }
            loadResponse.setRating(num);
        }

        public final void addDuration(LoadResponse loadResponse, String str) {
            Intrinsics.checkNotNullParameter(loadResponse, "<this>");
            Integer durationFromString = MainAPIKt.getDurationFromString(str);
            if (durationFromString == null) {
                durationFromString = loadResponse.getDuration();
            }
            loadResponse.setDuration(durationFromString);
        }
    }
}
