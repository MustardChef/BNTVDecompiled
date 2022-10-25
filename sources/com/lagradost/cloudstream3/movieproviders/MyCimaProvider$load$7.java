package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: MyCimaProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class MyCimaProvider$load$7 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ List<Actor> $actors;
    final /* synthetic */ Integer $duration;
    final /* synthetic */ String $posterUrl;
    final /* synthetic */ List<SearchResponse> $recommendations;
    final /* synthetic */ String $synopsis;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ Integer $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MyCimaProvider$load$7(Integer num, String str, List<String> list, Integer num2, String str2, List<? extends SearchResponse> list2, List<Actor> list3) {
        super(1);
        this.$duration = num;
        this.$posterUrl = str;
        this.$tags = list;
        this.$year = num2;
        this.$synopsis = str2;
        this.$recommendations = list2;
        this.$actors = list3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        newTvSeriesLoadResponse.setDuration(this.$duration);
        newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
        newTvSeriesLoadResponse.setTags(this.$tags);
        newTvSeriesLoadResponse.setYear(this.$year);
        newTvSeriesLoadResponse.setPlot(this.$synopsis);
        newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
        LoadResponse.Companion.addActorsOnly(newTvSeriesLoadResponse, this.$actors);
    }
}
