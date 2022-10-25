package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class StreamingcommunityProvider$load$5 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ Moviedata $datajs;
    final /* synthetic */ Document $document;
    final /* synthetic */ List<MovieSearchResponse> $listacorr;
    final /* synthetic */ String $poster;
    final /* synthetic */ String $trailerurl;
    final /* synthetic */ String $year;
    final /* synthetic */ StreamingcommunityProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamingcommunityProvider$load$5(StreamingcommunityProvider streamingcommunityProvider, String str, String str2, Document document, Moviedata moviedata, String str3, List<MovieSearchResponse> list) {
        super(1);
        this.this$0 = streamingcommunityProvider;
        this.$poster = str;
        this.$year = str2;
        this.$document = document;
        this.$datajs = moviedata;
        this.$trailerurl = str3;
        this.$listacorr = list;
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
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        newMovieLoadResponse.setYear(Integer.valueOf(Integer.parseInt(sb2)));
        Element selectFirst = this.$document.selectFirst("p.plot");
        Intrinsics.checkNotNull(selectFirst);
        newMovieLoadResponse.setPlot(selectFirst.text());
        Float floatOrNull = StringsKt.toFloatOrNull(this.$datajs.getVotes().get(0).getAverage());
        newMovieLoadResponse.setRating(floatOrNull != null ? Integer.valueOf((int) (floatOrNull.floatValue() * 1000)) : null);
        List<Genre> genres = this.$datajs.getGenres();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(genres, 10));
        for (Genre genre : genres) {
            arrayList.add(genre.getName());
        }
        newMovieLoadResponse.setTags(arrayList);
        Long runtime = this.$datajs.getRuntime();
        newMovieLoadResponse.setDuration(runtime != null ? Integer.valueOf((int) runtime.longValue()) : null);
        LoadResponse.Companion.addTrailer(newMovieLoadResponse, this.$trailerurl);
        newMovieLoadResponse.setRecommendations(this.$listacorr);
    }
}
