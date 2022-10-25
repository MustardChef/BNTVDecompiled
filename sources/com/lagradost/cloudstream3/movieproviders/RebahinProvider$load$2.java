package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RebahinProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class RebahinProvider$load$2 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ List<String> $actors;
    final /* synthetic */ String $description;
    final /* synthetic */ Integer $duration;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ String $trailer;
    final /* synthetic */ Integer $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RebahinProvider$load$2(String str, Integer num, String str2, List<String> list, Integer num2, Integer num3, List<String> list2, String str3) {
        super(1);
        this.$poster = str;
        this.$year = num;
        this.$description = str2;
        this.$tags = list;
        this.$rating = num2;
        this.$duration = num3;
        this.$actors = list2;
        this.$trailer = str3;
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
        newTvSeriesLoadResponse.setTags(this.$tags);
        newTvSeriesLoadResponse.setRating(this.$rating);
        newTvSeriesLoadResponse.setDuration(this.$duration);
        TvSeriesLoadResponse tvSeriesLoadResponse = newTvSeriesLoadResponse;
        LoadResponse.Companion.addActorNames(tvSeriesLoadResponse, this.$actors);
        LoadResponse.Companion.addTrailer(tvSeriesLoadResponse, this.$trailer);
    }
}
