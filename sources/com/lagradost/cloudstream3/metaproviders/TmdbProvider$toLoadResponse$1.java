package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.uwetrottmann.tmdb2.entities.BaseTvShow;
import com.uwetrottmann.tmdb2.entities.CastMember;
import com.uwetrottmann.tmdb2.entities.Credits;
import com.uwetrottmann.tmdb2.entities.Genre;
import com.uwetrottmann.tmdb2.entities.TvExternalIds;
import com.uwetrottmann.tmdb2.entities.TvShow;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TmdbProvider$toLoadResponse$1 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ TvShow $this_toLoadResponse;
    final /* synthetic */ TmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TmdbProvider$toLoadResponse$1(TmdbProvider tmdbProvider, TvShow tvShow) {
        super(1);
        this.this$0 = tmdbProvider;
        this.$this_toLoadResponse = tvShow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        String imageUrl;
        Integer num;
        ArrayList arrayList;
        List<String> trailers;
        ArrayList arrayList2;
        List<Tuples<Actor, String>> actors;
        List<CastMember> list;
        Iterable iterable;
        TvSeriesSearchResponse searchResponse;
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        imageUrl = this.this$0.getImageUrl(this.$this_toLoadResponse.poster_path);
        newTvSeriesLoadResponse.setPosterUrl(imageUrl);
        Date date = this.$this_toLoadResponse.first_air_date;
        List list2 = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            num = Integer.valueOf(calendar.get(1));
        } else {
            num = null;
        }
        newTvSeriesLoadResponse.setYear(num);
        newTvSeriesLoadResponse.setPlot(this.$this_toLoadResponse.overview);
        LoadResponse.Companion companion = LoadResponse.Companion;
        TvSeriesLoadResponse tvSeriesLoadResponse = newTvSeriesLoadResponse;
        TvExternalIds tvExternalIds = this.$this_toLoadResponse.external_ids;
        companion.addImdbId(tvSeriesLoadResponse, tvExternalIds != null ? tvExternalIds.imdb_id : null);
        List<Genre> list3 = this.$this_toLoadResponse.genres;
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Genre genre : list3) {
                String str = genre.name;
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        newTvSeriesLoadResponse.setTags(arrayList);
        List<Integer> list4 = this.$this_toLoadResponse.episode_run_time;
        newTvSeriesLoadResponse.setDuration(list4 != null ? Integer.valueOf((int) CollectionsKt.averageOfInt(list4)) : null);
        newTvSeriesLoadResponse.setRating(this.$this_toLoadResponse.rating);
        LoadResponse.Companion companion2 = LoadResponse.Companion;
        trailers = this.this$0.toTrailers(this.$this_toLoadResponse.videos);
        companion2.addTrailer(tvSeriesLoadResponse, trailers);
        TvShowResultsPage tvShowResultsPage = this.$this_toLoadResponse.recommendations;
        if (tvShowResultsPage == null) {
            tvShowResultsPage = this.$this_toLoadResponse.similar;
        }
        if (tvShowResultsPage == null || (iterable = tvShowResultsPage.results) == null) {
            arrayList2 = null;
        } else {
            Iterable<BaseTvShow> iterable2 = iterable;
            TmdbProvider tmdbProvider = this.this$0;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (BaseTvShow it : iterable2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                searchResponse = tmdbProvider.toSearchResponse(it);
                arrayList4.add(searchResponse);
            }
            arrayList2 = arrayList4;
        }
        newTvSeriesLoadResponse.setRecommendations(arrayList2);
        LoadResponse.Companion companion3 = LoadResponse.Companion;
        TmdbProvider tmdbProvider2 = this.this$0;
        Credits credits = this.$this_toLoadResponse.credits;
        if (credits != null && (list = credits.cast) != null) {
            list2 = CollectionsKt.toList(list);
        }
        actors = tmdbProvider2.toActors(list2);
        companion3.addActors(tvSeriesLoadResponse, actors);
    }
}
