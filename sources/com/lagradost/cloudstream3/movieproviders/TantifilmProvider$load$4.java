package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TantiFilmProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TantifilmProvider$load$4 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ List<String> $descipt;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<MovieSearchResponse> $recomm;
    final /* synthetic */ String $trailerurl;
    final /* synthetic */ Ref.ObjectRef<String> $year;
    final /* synthetic */ TantiFilmProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TantifilmProvider$load$4(TantiFilmProvider tantiFilmProvider, String str, Ref.ObjectRef<String> objectRef, List<String> list, Integer num, List<MovieSearchResponse> list2, String str2) {
        super(1);
        this.this$0 = tantiFilmProvider;
        this.$poster = str;
        this.$year = objectRef;
        this.$descipt = list;
        this.$rating = num;
        this.$recomm = list2;
        this.$trailerurl = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        newTvSeriesLoadResponse.setPosterUrl(MainAPIKt.fixUrlNull(this.this$0, this.$poster));
        newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$year.element));
        newTvSeriesLoadResponse.setPlot(this.$descipt.get(0));
        newTvSeriesLoadResponse.setRating(this.$rating);
        newTvSeriesLoadResponse.setRecommendations(this.$recomm);
        LoadResponse.Companion.addTrailer(newTvSeriesLoadResponse, this.$trailerurl);
    }
}
