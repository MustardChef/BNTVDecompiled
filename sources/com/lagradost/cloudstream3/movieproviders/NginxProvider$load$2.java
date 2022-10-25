package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxProvider$load$2 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ Map<String, String> $authHeader;
    final /* synthetic */ Integer $date;
    final /* synthetic */ String $description;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $ratingAverage;
    final /* synthetic */ List<String> $tagsList;
    final /* synthetic */ List<String> $trailer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$load$2(Integer num, String str, Integer num2, List<String> list, List<String> list2, String str2, Map<String, String> map) {
        super(1);
        this.$date = num;
        this.$description = str;
        this.$ratingAverage = num2;
        this.$tagsList = list;
        this.$trailer = list2;
        this.$poster = str2;
        this.$authHeader = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        newMovieLoadResponse.setYear(this.$date);
        newMovieLoadResponse.setPlot(this.$description);
        newMovieLoadResponse.setRating(this.$ratingAverage);
        newMovieLoadResponse.setTags(this.$tagsList);
        MovieLoadResponse movieLoadResponse = newMovieLoadResponse;
        LoadResponse.Companion.addTrailer(movieLoadResponse, this.$trailer);
        MainAPIKt.addPoster(movieLoadResponse, this.$poster, this.$authHeader);
    }
}
