package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: FilmpertuttiProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class FilmpertuttiProvider$load$4 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ String $description;
    final /* synthetic */ String $poster;
    final /* synthetic */ String $rating;
    final /* synthetic */ String $trailerurl;
    final /* synthetic */ Integer $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilmpertuttiProvider$load$4(String str, Integer num, String str2, String str3, String str4) {
        super(1);
        this.$poster = str;
        this.$year = num;
        this.$description = str2;
        this.$rating = str3;
        this.$trailerurl = str4;
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
        newTvSeriesLoadResponse.setYear(this.$year);
        newTvSeriesLoadResponse.setPlot(this.$description);
        TvSeriesLoadResponse tvSeriesLoadResponse = newTvSeriesLoadResponse;
        LoadResponse.Companion.addRating(tvSeriesLoadResponse, this.$rating);
        LoadResponse.Companion.addTrailer(tvSeriesLoadResponse, this.$trailerurl);
    }
}
