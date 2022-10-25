package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbLink;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020!0\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TrailersTwoProvider;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "instantLinkLoading", "", "getInstantLinkLoading", "()Z", "mainUrl", "getMainUrl", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "useMetaLoadResponse", "getUseMetaLoadResponse", "user", "getUser", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TrailersEpisode", "TrailersMovie", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TrailersTwoProvider extends TmdbProvider {
    private final String user = "cloudstream";
    private final String apiName = "Trailers.to";
    private String name = "Trailers.to";
    private String mainUrl = "https://trailers.to";
    private final boolean useMetaLoadResponse = true;
    private final boolean instantLinkLoading = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries});

    public final String getUser() {
        return this.user;
    }

    @Override // com.lagradost.cloudstream3.metaproviders.TmdbProvider
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.metaproviders.TmdbProvider
    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    /* compiled from: TrailersTwoProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TrailersTwoProvider$TrailersEpisode;", "", "itemID", "", "imdb", "", "tmdb", "(ILjava/lang/String;Ljava/lang/Integer;)V", "getImdb", "()Ljava/lang/String;", "getItemID", "()I", "getTmdb", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/TrailersTwoProvider$TrailersEpisode;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TrailersEpisode {
        private final String imdb;
        private final int itemID;
        private final Integer tmdb;

        public static /* synthetic */ TrailersEpisode copy$default(TrailersEpisode trailersEpisode, int i, String str, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = trailersEpisode.itemID;
            }
            if ((i2 & 2) != 0) {
                str = trailersEpisode.imdb;
            }
            if ((i2 & 4) != 0) {
                num = trailersEpisode.tmdb;
            }
            return trailersEpisode.copy(i, str, num);
        }

        public final int component1() {
            return this.itemID;
        }

        public final String component2() {
            return this.imdb;
        }

        public final Integer component3() {
            return this.tmdb;
        }

        public final TrailersEpisode copy(@JsonProperty("ItemID") int i, @JsonProperty("IMDb") String str, @JsonProperty("TMDb") Integer num) {
            return new TrailersEpisode(i, str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TrailersEpisode) {
                TrailersEpisode trailersEpisode = (TrailersEpisode) obj;
                return this.itemID == trailersEpisode.itemID && Intrinsics.areEqual(this.imdb, trailersEpisode.imdb) && Intrinsics.areEqual(this.tmdb, trailersEpisode.tmdb);
            }
            return false;
        }

        public int hashCode() {
            int i = this.itemID * 31;
            String str = this.imdb;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.tmdb;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "TrailersEpisode(itemID=" + this.itemID + ", imdb=" + this.imdb + ", tmdb=" + this.tmdb + ')';
        }

        public TrailersEpisode(@JsonProperty("ItemID") int i, @JsonProperty("IMDb") String str, @JsonProperty("TMDb") Integer num) {
            this.itemID = i;
            this.imdb = str;
            this.tmdb = num;
        }

        public final int getItemID() {
            return this.itemID;
        }

        public final String getImdb() {
            return this.imdb;
        }

        public final Integer getTmdb() {
            return this.tmdb;
        }
    }

    /* compiled from: TrailersTwoProvider.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TrailersTwoProvider$TrailersMovie;", "", "itemID", "", "imdb", "", "tmdb", "(ILjava/lang/String;Ljava/lang/Integer;)V", "getImdb", "()Ljava/lang/String;", "getItemID", "()I", "getTmdb", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/TrailersTwoProvider$TrailersMovie;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class TrailersMovie {
        private final String imdb;
        private final int itemID;
        private final Integer tmdb;

        public static /* synthetic */ TrailersMovie copy$default(TrailersMovie trailersMovie, int i, String str, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = trailersMovie.itemID;
            }
            if ((i2 & 2) != 0) {
                str = trailersMovie.imdb;
            }
            if ((i2 & 4) != 0) {
                num = trailersMovie.tmdb;
            }
            return trailersMovie.copy(i, str, num);
        }

        public final int component1() {
            return this.itemID;
        }

        public final String component2() {
            return this.imdb;
        }

        public final Integer component3() {
            return this.tmdb;
        }

        public final TrailersMovie copy(@JsonProperty("ItemID") int i, @JsonProperty("IMDb") String str, @JsonProperty("TMDb") Integer num) {
            return new TrailersMovie(i, str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TrailersMovie) {
                TrailersMovie trailersMovie = (TrailersMovie) obj;
                return this.itemID == trailersMovie.itemID && Intrinsics.areEqual(this.imdb, trailersMovie.imdb) && Intrinsics.areEqual(this.tmdb, trailersMovie.tmdb);
            }
            return false;
        }

        public int hashCode() {
            int i = this.itemID * 31;
            String str = this.imdb;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.tmdb;
            return hashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "TrailersMovie(itemID=" + this.itemID + ", imdb=" + this.imdb + ", tmdb=" + this.tmdb + ')';
        }

        public TrailersMovie(@JsonProperty("ItemID") int i, @JsonProperty("IMDb") String str, @JsonProperty("TMDb") Integer num) {
            this.itemID = i;
            this.imdb = str;
            this.tmdb = num;
        }

        public final int getItemID() {
            return this.itemID;
        }

        public final String getImdb() {
            return this.imdb;
        }

        public final Integer getTmdb() {
            return this.tmdb;
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Object loadLinks(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Boolean> continuation) {
        Tuples tuples;
        AppUtils appUtils = AppUtils.INSTANCE;
        TmdbLink tmdbLink = (TmdbLink) MainAPIKt.getMapper().readValue(str, new TypeReference<TmdbLink>() { // from class: com.lagradost.cloudstream3.movieproviders.TrailersTwoProvider$loadLinks$$inlined$parseJson$1
        });
        List listOf = tmdbLink.getImdbID() != null ? CollectionsKt.listOf((Object[]) new String[]{tmdbLink.getImdbID(), "imdb"}) : CollectionsKt.listOf((Object[]) new String[]{String.valueOf(tmdbLink.getTmdbID()), "tmdb"});
        String str2 = (String) listOf.get(0);
        String str3 = (String) listOf.get(1);
        boolean z2 = tmdbLink.getEpisode() == null && tmdbLink.getSeason() == null;
        if (z2) {
            String str4 = this.user + JsonPointer.SEPARATOR + str3 + JsonPointer.SEPARATOR + str2;
            tuples = new Tuples("https://trailers.to/video/" + str4, "https://trailers.to/subtitles/" + str4);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.user);
            sb.append(JsonPointer.SEPARATOR);
            sb.append(str3);
            sb.append(JsonPointer.SEPARATOR);
            sb.append(str2);
            sb.append("/S");
            Integer season = tmdbLink.getSeason();
            sb.append(season != null ? season.intValue() : 1);
            sb.append('E');
            Integer episode = tmdbLink.getEpisode();
            sb.append(episode != null ? episode.intValue() : 1);
            String sb2 = sb.toString();
            tuples = new Tuples("https://trailers.to/video/" + sb2, "https://trailers.to/subtitles/" + sb2);
        }
        String str5 = (String) tuples.component1();
        function12.invoke(new ExtractorLink(getName(), getName(), str5, "https://trailers.to", Qualities.Unknown.getValue(), false, null, null, 192, null));
        ParCollections.argamap(new TrailersTwoProvider$loadLinks$2((String) tuples.component2(), function1, null), new TrailersTwoProvider$loadLinks$3(tmdbLink, z2, str5, function12, this, null));
        return boxing.boxBoolean(true);
    }
}
