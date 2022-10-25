package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AkwamProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class AkwamProvider$load$2 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ List<Actor> $actors;
    final /* synthetic */ Integer $duration;
    final /* synthetic */ String $posterUrl;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<MovieSearchResponse> $recommendations;
    final /* synthetic */ String $synopsis;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ Integer $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AkwamProvider$load$2(String str, Integer num, String str2, Integer num2, List<String> list, Integer num3, List<MovieSearchResponse> list2, List<Actor> list3) {
        super(1);
        this.$posterUrl = str;
        this.$year = num;
        this.$synopsis = str2;
        this.$rating = num2;
        this.$tags = list;
        this.$duration = num3;
        this.$recommendations = list2;
        this.$actors = list3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        newMovieLoadResponse.setPosterUrl(this.$posterUrl);
        newMovieLoadResponse.setYear(this.$year);
        newMovieLoadResponse.setPlot(this.$synopsis);
        newMovieLoadResponse.setRating(this.$rating);
        newMovieLoadResponse.setTags(this.$tags);
        newMovieLoadResponse.setDuration(this.$duration);
        newMovieLoadResponse.setRecommendations(this.$recommendations);
        LoadResponse.Companion.addActorsOnly(newMovieLoadResponse, this.$actors);
    }
}
