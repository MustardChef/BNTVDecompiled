package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MovieLoadResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrenchStreamProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class FrenchStreamProvider$load$2 extends Lambda implements Function1<MovieLoadResponse, Unit> {
    final /* synthetic */ String $description;
    final /* synthetic */ Ref.ObjectRef<String> $poster;
    final /* synthetic */ Document $soup;
    final /* synthetic */ List<String> $tagsList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrenchStreamProvider$load$2(Ref.ObjectRef<String> objectRef, Document document, List<String> list, String str) {
        super(1);
        this.$poster = objectRef;
        this.$soup = document;
        this.$tagsList = list;
        this.$description = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MovieLoadResponse movieLoadResponse) {
        invoke2(movieLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MovieLoadResponse newMovieLoadResponse) {
        String text;
        Intrinsics.checkNotNullParameter(newMovieLoadResponse, "$this$newMovieLoadResponse");
        newMovieLoadResponse.setPosterUrl(this.$poster.element);
        MovieLoadResponse movieLoadResponse = newMovieLoadResponse;
        LoadResponse.Companion.addRating(movieLoadResponse, this.$soup.select("div.fr-count > div").text());
        Elements select = this.$soup.select("ul.flist-col > li");
        Intrinsics.checkNotNullExpressionValue(select, "soup.select(\"ul.flist-col > li\")");
        Element element = (Element) CollectionsKt.getOrNull(select, 2);
        newMovieLoadResponse.setYear((element == null || (text = element.text()) == null) ? null : StringsKt.toIntOrNull(text));
        newMovieLoadResponse.setTags(this.$tagsList);
        newMovieLoadResponse.setPlot(this.$description);
        LoadResponse.Companion companion = LoadResponse.Companion;
        Element selectFirst = this.$soup.selectFirst("div.fleft > span > a");
        companion.addTrailer(movieLoadResponse, selectFirst != null ? selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF) : null);
    }
}
