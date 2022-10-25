package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.ProviderType;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.BaseTvShow;
import com.uwetrottmann.tmdb2.entities.CastMember;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.entities.TvSeason;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: TmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0002\u0010 J\u001b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u0004H\u0016J \u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u001eH\u0016J \u0010*\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J!\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010(2\u0006\u0010-\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J,\u0010.\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000200\u0012\u0006\u0012\u0004\u0018\u00010\u00040/\u0018\u00010(*\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010(H\u0002J\f\u00102\u001a\u000203*\u000204H\u0002J\f\u00102\u001a\u000205*\u000206H\u0002J\f\u00107\u001a\u000208*\u000209H\u0002J\f\u00107\u001a\u00020:*\u00020;H\u0002J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(*\u0004\u0018\u00010=H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, m107d2 = {"Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "disableSeasonZero", "", "getDisableSeasonZero", "()Z", "hasMainPage", "getHasMainPage", "includeAdult", "getIncludeAdult", "providerType", "Lcom/lagradost/cloudstream3/ProviderType;", "getProviderType", "()Lcom/lagradost/cloudstream3/ProviderType;", "tmdb", "Lcom/uwetrottmann/tmdb2/Tmdb;", "useMetaLoadResponse", "getUseMetaLoadResponse", "getImageUrl", "link", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "id", "", "tvShow", "(Ljava/lang/Integer;Z)Ljava/lang/String;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFromImdb", "imdb", "seasons", "", "Lcom/uwetrottmann/tmdb2/entities/TvSeason;", "loadFromTmdb", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "toActors", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/Actor;", "Lcom/uwetrottmann/tmdb2/entities/CastMember;", "toLoadResponse", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "Lcom/uwetrottmann/tmdb2/entities/Movie;", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "Lcom/uwetrottmann/tmdb2/entities/TvShow;", "toSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "Lcom/uwetrottmann/tmdb2/entities/BaseMovie;", "Lcom/lagradost/cloudstream3/TvSeriesSearchResponse;", "Lcom/uwetrottmann/tmdb2/entities/BaseTvShow;", "toTrailers", "Lcom/uwetrottmann/tmdb2/entities/Videos;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class TmdbProvider extends MainAPI {
    private final boolean includeAdult;
    private final boolean useMetaLoadResponse;
    private final String apiName = "TMDB";
    private final boolean disableSeasonZero = true;
    private final boolean hasMainPage = true;
    private final ProviderType providerType = ProviderType.MetaProvider;
    private final Tmdb tmdb = new Tmdb("e6333b32409e02a4a6eba6fb7ff866bb");

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object getMainPage(Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object load(String str, Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, (Continuation) continuation);
    }

    public LoadResponse loadFromImdb(String imdb) {
        Intrinsics.checkNotNullParameter(imdb, "imdb");
        return null;
    }

    public LoadResponse loadFromImdb(String imdb, List<? extends TvSeason> seasons) {
        Intrinsics.checkNotNullParameter(imdb, "imdb");
        Intrinsics.checkNotNullParameter(seasons, "seasons");
        return null;
    }

    public LoadResponse loadFromTmdb(int i) {
        return null;
    }

    public LoadResponse loadFromTmdb(int i, List<? extends TvSeason> seasons) {
        Intrinsics.checkNotNullParameter(seasons, "seasons");
        return null;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object search(String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, (Continuation) continuation);
    }

    public boolean getIncludeAdult() {
        return this.includeAdult;
    }

    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    public String getApiName() {
        return this.apiName;
    }

    public boolean getDisableSeasonZero() {
        return this.disableSeasonZero;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public ProviderType getProviderType() {
        return this.providerType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getImageUrl(String str) {
        if (str == null) {
            return null;
        }
        if (StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            return "https://image.tmdb.org/t/p/w500/" + str;
        }
        return str;
    }

    private final String getUrl(Integer num, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://www.themoviedb.org/tv/");
            sb.append(num != null ? num.intValue() : -1);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://www.themoviedb.org/movie/");
        sb2.append(num != null ? num.intValue() : -1);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TvSeriesSearchResponse toSearchResponse(BaseTvShow baseTvShow) {
        Integer num;
        String str = baseTvShow.name;
        if (str == null) {
            str = baseTvShow.original_name;
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "this.name ?: this.original_name");
        String url = getUrl(baseTvShow.f10057id, true);
        String apiName = getApiName();
        TvType tvType = TvType.TvSeries;
        String imageUrl = getImageUrl(baseTvShow.poster_path);
        Date date = baseTvShow.first_air_date;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            num = Integer.valueOf(calendar.get(1));
        } else {
            num = null;
        }
        return new TvSeriesSearchResponse(str2, url, apiName, tvType, imageUrl, num, null, baseTvShow.f10057id, null, null, 768, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MovieSearchResponse toSearchResponse(BaseMovie baseMovie) {
        Integer num;
        String str = baseMovie.title;
        if (str == null) {
            str = baseMovie.original_title;
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "this.title ?: this.original_title");
        String url = getUrl(baseMovie.f10051id, false);
        String apiName = getApiName();
        TvType tvType = TvType.TvSeries;
        String imageUrl = getImageUrl(baseMovie.poster_path);
        Date date = baseMovie.release_date;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            num = Integer.valueOf(calendar.get(1));
        } else {
            num = null;
        }
        return new MovieSearchResponse(str2, url, apiName, tvType, imageUrl, num, baseMovie.f10051id, null, null, 384, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Tuples<Actor, String>> toActors(List<? extends CastMember> list) {
        Tuples tuples;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (CastMember castMember : list) {
                String str = castMember != null ? castMember.name : null;
                if (str == null) {
                    tuples = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it?.name ?: return@mapNotNull null");
                    tuples = new Tuples(new Actor(str, getImageUrl(castMember.profile_path)), castMember.character);
                }
                if (tuples != null) {
                    arrayList.add(tuples);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r6 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x017b, code lost:
        if (r2 == null) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.lagradost.cloudstream3.TvSeriesLoadResponse toLoadResponse(com.uwetrottmann.tmdb2.entities.TvShow r32) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.TmdbProvider.toLoadResponse(com.uwetrottmann.tmdb2.entities.TvShow):com.lagradost.cloudstream3.TvSeriesLoadResponse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> toTrailers(com.uwetrottmann.tmdb2.entities.Videos r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto La8
            java.util.List<com.uwetrottmann.tmdb2.entities.Videos$Video> r7 = r7.results
            if (r7 == 0) goto La8
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r7 = r7.iterator()
        L14:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L36
            java.lang.Object r2 = r7.next()
            r3 = r2
            com.uwetrottmann.tmdb2.entities.Videos$Video r3 = (com.uwetrottmann.tmdb2.entities.Videos.Video) r3
            com.uwetrottmann.tmdb2.enumerations.VideoType r4 = r3.type
            com.uwetrottmann.tmdb2.enumerations.VideoType r5 = com.uwetrottmann.tmdb2.enumerations.VideoType.OPENING_CREDITS
            if (r4 == r5) goto L2f
            com.uwetrottmann.tmdb2.enumerations.VideoType r3 = r3.type
            com.uwetrottmann.tmdb2.enumerations.VideoType r4 = com.uwetrottmann.tmdb2.enumerations.VideoType.FEATURETTE
            if (r3 == r4) goto L2f
            r3 = 1
            goto L30
        L2f:
            r3 = 0
        L30:
            if (r3 == 0) goto L14
            r1.add(r2)
            goto L14
        L36:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            com.lagradost.cloudstream3.metaproviders.TmdbProvider$toTrailers$$inlined$sortedBy$1 r7 = new com.lagradost.cloudstream3.metaproviders.TmdbProvider$toTrailers$$inlined$sortedBy$1
            r7.<init>()
            java.util.Comparator r7 = (java.util.Comparator) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.sortedWith(r1, r7)
            if (r7 == 0) goto La8
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r7 = r7.iterator()
        L54:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto La5
            java.lang.Object r2 = r7.next()
            com.uwetrottmann.tmdb2.entities.Videos$Video r2 = (com.uwetrottmann.tmdb2.entities.Videos.Video) r2
            java.lang.String r3 = r2.site
            if (r3 == 0) goto L81
            java.lang.String r4 = "site"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L81
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L82
        L81:
            r3 = r0
        L82:
            java.lang.String r4 = "youtube"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L9e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "https://www.youtube.com/watch?v="
            r3.append(r4)
            java.lang.String r2 = r2.key
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L9f
        L9e:
            r2 = r0
        L9f:
            if (r2 == 0) goto L54
            r1.add(r2)
            goto L54
        La5:
            r0 = r1
            java.util.List r0 = (java.util.List) r0
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.TmdbProvider.toTrailers(com.uwetrottmann.tmdb2.entities.Videos):java.util.List");
    }

    private final MovieLoadResponse toLoadResponse(Movie movie) {
        TmdbProvider tmdbProvider = this;
        String str = movie.title;
        if (str == null) {
            str = movie.original_title;
        }
        Intrinsics.checkNotNullExpressionValue(str, "this.title ?: this.original_title");
        String url = getUrl(movie.f10051id, false);
        TvType tvType = TvType.Movie;
        AppUtils appUtils = AppUtils.INSTANCE;
        String str2 = movie.imdb_id;
        Integer num = movie.f10051id;
        String str3 = movie.title;
        if (str3 == null) {
            str3 = movie.original_title;
        }
        return MainAPIKt.newMovieLoadResponse((MainAPI) tmdbProvider, str, url, tvType, appUtils.toJson(new TmdbLink(str2, num, null, null, str3)), (Function1<? super MovieLoadResponse, Unit>) new TmdbProvider$toLoadResponse$2(this, movie));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List, T] */
    static /* synthetic */ Object getMainPage$suspendImpl(TmdbProvider tmdbProvider, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = CollectionsKt.emptyList();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = CollectionsKt.emptyList();
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = CollectionsKt.emptyList();
        ParCollections.argamap(new TmdbProvider$getMainPage$2(objectRef, tmdbProvider, null), new TmdbProvider$getMainPage$3(objectRef2, tmdbProvider, null), new TmdbProvider$getMainPage$4(objectRef3, tmdbProvider, null), new TmdbProvider$getMainPage$5(objectRef4, tmdbProvider, null));
        return new HomePageResponse(CollectionsKt.listOf((Object[]) new HomePageList[]{new HomePageList("Popular Movies", (List) objectRef.element, null, null, null, 28, null), new HomePageList("Popular Series", (List) objectRef2.element, null, null, null, 28, null), new HomePageList("Top Movies", (List) objectRef3.element, null, null, null, 28, null), new HomePageList("Top Series", (List) objectRef4.element, null, null, null, 28, null)}), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object load$suspendImpl(com.lagradost.cloudstream3.metaproviders.TmdbProvider r17, java.lang.String r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.TmdbProvider.load$suspendImpl(com.lagradost.cloudstream3.metaproviders.TmdbProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object search$suspendImpl(com.lagradost.cloudstream3.metaproviders.TmdbProvider r10, java.lang.String r11, kotlin.coroutines.Continuation r12) {
        /*
            boolean r0 = r12 instanceof com.lagradost.cloudstream3.metaproviders.TmdbProvider$search$1
            if (r0 == 0) goto L14
            r0 = r12
            com.lagradost.cloudstream3.metaproviders.TmdbProvider$search$1 r0 = (com.lagradost.cloudstream3.metaproviders.TmdbProvider$search$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.lagradost.cloudstream3.metaproviders.TmdbProvider$search$1 r0 = new com.lagradost.cloudstream3.metaproviders.TmdbProvider$search$1
            r0.<init>(r10, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r10 = r0.L$0
            com.lagradost.cloudstream3.metaproviders.TmdbProvider r10 = (com.lagradost.cloudstream3.metaproviders.TmdbProvider) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L64
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            com.uwetrottmann.tmdb2.Tmdb r12 = r10.tmdb
            com.uwetrottmann.tmdb2.services.SearchService r4 = r12.searchService()
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.boxing.boxInt(r3)
            boolean r12 = r10.getIncludeAdult()
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r12)
            java.lang.String r7 = "en-Us"
            java.lang.String r8 = "US"
            r5 = r11
            retrofit2.Call r11 = r4.multi(r5, r6, r7, r8, r9)
            java.lang.String r12 = "tmdb.searchService().mul…-Us\", \"US\", includeAdult)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r12 = retrofit2.KotlinExtensions.awaitResponse(r11, r0)
            if (r12 != r1) goto L64
            return r1
        L64:
            retrofit2.Response r12 = (retrofit2.Response) r12
            java.lang.Object r11 = r12.body()
            com.uwetrottmann.tmdb2.entities.MediaResultsPage r11 = (com.uwetrottmann.tmdb2.entities.MediaResultsPage) r11
            r12 = 0
            if (r11 == 0) goto Lb9
            java.util.List<T> r11 = r11.results
            if (r11 == 0) goto Lb9
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r11 = r11.iterator()
        L80:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto Lb6
            java.lang.Object r1 = r11.next()
            com.uwetrottmann.tmdb2.entities.Media r1 = (com.uwetrottmann.tmdb2.entities.Media) r1
            com.uwetrottmann.tmdb2.entities.BaseMovie r2 = r1.movie
            if (r2 == 0) goto L9e
            java.lang.String r3 = "movie"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.lagradost.cloudstream3.MovieSearchResponse r2 = r10.toSearchResponse(r2)
            if (r2 == 0) goto L9e
            com.lagradost.cloudstream3.SearchResponse r2 = (com.lagradost.cloudstream3.SearchResponse) r2
            goto Lb0
        L9e:
            com.uwetrottmann.tmdb2.entities.BaseTvShow r1 = r1.tvShow
            if (r1 == 0) goto Laf
            java.lang.String r2 = "tvShow"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.lagradost.cloudstream3.TvSeriesSearchResponse r1 = r10.toSearchResponse(r1)
            r2 = r1
            com.lagradost.cloudstream3.SearchResponse r2 = (com.lagradost.cloudstream3.SearchResponse) r2
            goto Lb0
        Laf:
            r2 = r12
        Lb0:
            if (r2 == 0) goto L80
            r0.add(r2)
            goto L80
        Lb6:
            r12 = r0
            java.util.List r12 = (java.util.List) r12
        Lb9:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.TmdbProvider.search$suspendImpl(com.lagradost.cloudstream3.metaproviders.TmdbProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
