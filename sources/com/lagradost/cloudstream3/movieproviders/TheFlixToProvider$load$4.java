package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* compiled from: TheFlixToProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class TheFlixToProvider$load$4 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ List<String> $cast;
    final /* synthetic */ boolean $comingsoon;
    final /* synthetic */ String $description;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<MovieSearchResponse> $recommendationsitem;
    final /* synthetic */ Integer $runtime;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ String $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TheFlixToProvider$load$4(String str, String str2, String str3, Integer num, List<String> list, List<String> list2, List<MovieSearchResponse> list3, boolean z, Integer num2) {
        super(1);
        this.$year = str;
        this.$poster = str2;
        this.$description = str3;
        this.$runtime = num;
        this.$cast = list;
        this.$tags = list2;
        this.$recommendationsitem = list3;
        this.$comingsoon = z;
        this.$rating = num2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        String str = this.$year;
        newMovieLoadResponse.setYear(str != null ? StringsKt.toIntOrNull(str) : null);
        newMovieLoadResponse.setPosterUrl(this.$poster);
        newMovieLoadResponse.setPlot(this.$description);
        newMovieLoadResponse.setDuration(this.$runtime);
        LoadResponse.Companion.addActorNames(newMovieLoadResponse, this.$cast);
        newMovieLoadResponse.setTags(this.$tags);
        newMovieLoadResponse.setRecommendations(this.$recommendationsitem);
        newMovieLoadResponse.setComingSoon(this.$comingsoon);
        newMovieLoadResponse.setRating(this.$rating);
    }
}
