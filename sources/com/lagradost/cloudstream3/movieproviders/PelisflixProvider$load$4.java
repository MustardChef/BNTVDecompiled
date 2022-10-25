package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PelisflixProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class PelisflixProvider$load$4 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ String $descipt;
    final /* synthetic */ String $duration;
    final /* synthetic */ String $poster;
    final /* synthetic */ Integer $rating;
    final /* synthetic */ String $year;
    final /* synthetic */ PelisflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PelisflixProvider$load$4(PelisflixProvider pelisflixProvider, String str, String str2, String str3, Integer num, String str4) {
        super(1);
        this.this$0 = pelisflixProvider;
        this.$poster = str;
        this.$year = str2;
        this.$descipt = str3;
        this.$rating = num;
        this.$duration = str4;
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
        String str = this.$year;
        newMovieLoadResponse.setYear(str != null ? StringsKt.toIntOrNull(str) : null);
        newMovieLoadResponse.setPlot(this.$descipt);
        newMovieLoadResponse.setRating(this.$rating);
        LoadResponse.Companion.addDuration(newMovieLoadResponse, this.$duration);
    }
}
