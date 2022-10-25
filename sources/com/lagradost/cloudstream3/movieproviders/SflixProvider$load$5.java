package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SflixProvider$load$5 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ Ref.ObjectRef<List<String>> $cast;
    final /* synthetic */ Ref.ObjectRef<String> $duration;
    final /* synthetic */ String $plot;
    final /* synthetic */ String $posterUrl;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<MovieSearchResponse> $recommendations;
    final /* synthetic */ Ref.ObjectRef<List<String>> $tags;
    final /* synthetic */ Ref.ObjectRef<Integer> $year;
    final /* synthetic */ String $youtubeTrailer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$load$5(String str, Ref.ObjectRef<Integer> objectRef, String str2, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<List<String>> objectRef3, Ref.ObjectRef<List<String>> objectRef4, List<MovieSearchResponse> list, String str3, Integer num) {
        super(1);
        this.$posterUrl = str;
        this.$year = objectRef;
        this.$plot = str2;
        this.$duration = objectRef2;
        this.$cast = objectRef3;
        this.$tags = objectRef4;
        this.$recommendations = list;
        this.$youtubeTrailer = str3;
        this.$rating = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
        newTvSeriesLoadResponse.setYear(this.$year.element);
        newTvSeriesLoadResponse.setPlot(this.$plot);
        TvSeriesLoadResponse tvSeriesLoadResponse = newTvSeriesLoadResponse;
        LoadResponse.Companion.addDuration(tvSeriesLoadResponse, this.$duration.element);
        LoadResponse.Companion.addActorNames(tvSeriesLoadResponse, this.$cast.element);
        newTvSeriesLoadResponse.setTags(this.$tags.element);
        newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
        LoadResponse.Companion.addTrailer(tvSeriesLoadResponse, this.$youtubeTrailer);
        newTvSeriesLoadResponse.setRating(this.$rating);
    }
}
