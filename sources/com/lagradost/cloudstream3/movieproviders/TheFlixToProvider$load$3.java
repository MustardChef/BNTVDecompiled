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
import kotlin.text.StringsKt;

/* compiled from: TheFlixToProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class TheFlixToProvider$load$3 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
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
    public TheFlixToProvider$load$3(String str, String str2, String str3, Integer num, List<String> list, List<String> list2, List<MovieSearchResponse> list3, boolean z, Integer num2) {
        super(1);
        this.$poster = str;
        this.$year = str2;
        this.$description = str3;
        this.$runtime = num;
        this.$cast = list;
        this.$tags = list2;
        this.$recommendationsitem = list3;
        this.$comingsoon = z;
        this.$rating = num2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        newTvSeriesLoadResponse.setPosterUrl(this.$poster);
        String str = this.$year;
        newTvSeriesLoadResponse.setYear(str != null ? StringsKt.toIntOrNull(str) : null);
        newTvSeriesLoadResponse.setPlot(this.$description);
        newTvSeriesLoadResponse.setDuration(this.$runtime);
        LoadResponse.Companion.addActorNames(newTvSeriesLoadResponse, this.$cast);
        newTvSeriesLoadResponse.setTags(this.$tags);
        newTvSeriesLoadResponse.setRecommendations(this.$recommendationsitem);
        newTvSeriesLoadResponse.setComingSoon(this.$comingsoon);
        newTvSeriesLoadResponse.setRating(this.$rating);
    }
}
