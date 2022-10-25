package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
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
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TantifilmProvider$load$5 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ List<ActorData> $actors;
    final /* synthetic */ Integer $duratio;
    final /* synthetic */ String $plot;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ List<MovieSearchResponse> $recomm;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ String $trailerurl;
    final /* synthetic */ Ref.ObjectRef<String> $year;
    final /* synthetic */ TantiFilmProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TantifilmProvider$load$5(TantiFilmProvider tantiFilmProvider, String str, Ref.ObjectRef<String> objectRef, String str2, Integer num, List<MovieSearchResponse> list, List<String> list2, Integer num2, List<ActorData> list3, String str3) {
        super(1);
        this.this$0 = tantiFilmProvider;
        this.$poster = str;
        this.$year = objectRef;
        this.$plot = str2;
        this.$rating = num;
        this.$recomm = list;
        this.$tags = list2;
        this.$duratio = num2;
        this.$actors = list3;
        this.$trailerurl = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        newMovieLoadResponse.setPosterUrl(MainAPIKt.fixUrlNull(this.this$0, this.$poster));
        newMovieLoadResponse.setYear(StringsKt.toIntOrNull(this.$year.element));
        newMovieLoadResponse.setPlot(this.$plot);
        newMovieLoadResponse.setRating(this.$rating);
        newMovieLoadResponse.setRecommendations(this.$recomm);
        newMovieLoadResponse.setTags(this.$tags);
        newMovieLoadResponse.setDuration(this.$duratio);
        newMovieLoadResponse.setActors(this.$actors);
        LoadResponse.Companion.addTrailer(newMovieLoadResponse, this.$trailerurl);
    }
}
