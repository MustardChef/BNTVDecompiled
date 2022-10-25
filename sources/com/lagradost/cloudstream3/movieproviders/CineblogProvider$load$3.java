package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.ActorData;
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
/* compiled from: CineblogProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class CineblogProvider$load$3 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ List<ActorData> $actors;
    final /* synthetic */ String $description;
    final /* synthetic */ String $poster;
    final /* synthetic */ Void $rating;
    final /* synthetic */ List<MovieSearchResponse> $recomm;
    final /* synthetic */ Ref.ObjectRef<String> $year;
    final /* synthetic */ CineblogProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CineblogProvider$load$3(CineblogProvider cineblogProvider, String str, Ref.ObjectRef<String> objectRef, String str2, Void r5, List<MovieSearchResponse> list, List<ActorData> list2) {
        super(1);
        this.this$0 = cineblogProvider;
        this.$poster = str;
        this.$year = objectRef;
        this.$description = str2;
        this.$rating = r5;
        this.$recomm = list;
        this.$actors = list2;
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
        newMovieLoadResponse.setPlot(this.$description);
        newMovieLoadResponse.setRating((Integer) this.$rating);
        newMovieLoadResponse.setRecommendations(this.$recomm);
        newMovieLoadResponse.setDuration(null);
        newMovieLoadResponse.setActors(this.$actors);
    }
}
