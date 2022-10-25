package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.movieproviders.SuperStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuperStream.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SuperStream$load$2 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ SuperStream.MovieData $data;
    final /* synthetic */ SuperStream this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperStream$load$2(SuperStream.MovieData movieData, SuperStream superStream) {
        super(1);
        this.$data = movieData;
        this.this$0 = superStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        ArrayList arrayList;
        List split$default;
        String str;
        List split$default2;
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        SuperStream superStream = this.this$0;
        ArrayList arrayList2 = new ArrayList();
        for (SuperStream.Data data : this.$data.getRecommend()) {
            MovieSearchResponse searchResponse = data.toSearchResponse(superStream);
            if (searchResponse != null) {
                arrayList2.add(searchResponse);
            }
        }
        newMovieLoadResponse.setRecommendations(arrayList2);
        String posterOrg = this.$data.getPosterOrg();
        if (posterOrg == null) {
            posterOrg = this.$data.getPoster();
        }
        newMovieLoadResponse.setPosterUrl(posterOrg);
        newMovieLoadResponse.setYear(this.$data.getYear());
        newMovieLoadResponse.setPlot(this.$data.getDescription());
        String cats = this.$data.getCats();
        Integer num = null;
        if (cats == null || (split$default2 = StringsKt.split$default((CharSequence) cats, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            arrayList = null;
        } else {
            List<String> list = split$default2;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str2 : list) {
                arrayList3.add(APIHolder.INSTANCE.capitalize(str2));
            }
            arrayList = arrayList3;
        }
        newMovieLoadResponse.setTags(arrayList);
        String imdbRating = this.$data.getImdbRating();
        if (imdbRating != null && (split$default = StringsKt.split$default((CharSequence) imdbRating, new String[]{"/"}, false, 0, 6, (Object) null)) != null && (str = (String) split$default.get(0)) != null) {
            num = StringsKt.toIntOrNull(str);
        }
        newMovieLoadResponse.setRating(num);
        MovieLoadResponse movieLoadResponse = newMovieLoadResponse;
        LoadResponse.Companion.addTrailer(movieLoadResponse, this.$data.getTrailerUrl());
        LoadResponse.Companion.addImdbId(movieLoadResponse, this.$data.getImdbId());
    }
}
