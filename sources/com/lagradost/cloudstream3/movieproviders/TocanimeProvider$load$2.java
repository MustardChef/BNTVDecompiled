package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
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
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TocanimeProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TocanimeProvider$load$2 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ Document $document;
    final /* synthetic */ List<Episode> $episodes;
    final /* synthetic */ String $trailer;
    final /* synthetic */ TocanimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TocanimeProvider$load$2(TocanimeProvider tocanimeProvider, Document document, List<Episode> list, String str) {
        super(1);
        this.this$0 = tocanimeProvider;
        this.$document = document;
        this.$episodes = list;
        this.$trailer = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        AnimeSearchResponse searchResult;
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        TocanimeProvider tocanimeProvider = this.this$0;
        Element selectFirst = this.$document.selectFirst("img.img");
        newAnimeLoadResponse.setPosterUrl(MainAPIKt.fixUrlNull(tocanimeProvider, selectFirst != null ? selectFirst.attr("data-original") : null));
        String text = this.$document.select("dl.movie-des dd").get(1).text();
        Intrinsics.checkNotNullExpressionValue(text, "document.select(\"dl.movie-des dd\")[1].text()");
        newAnimeLoadResponse.setYear(StringsKt.toIntOrNull((String) CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) text, new String[]{"/"}, false, 0, 6, (Object) null))));
        newAnimeLoadResponse.setShowStatus(TocanimeProvider.Companion.getStatus(this.$document.select("dl.movie-des dd").get(0).text().toString()));
        newAnimeLoadResponse.setPlot(this.$document.select("div.box-content > p").text());
        Elements select = this.$document.select("dl.movie-des dd").get(4).select("li");
        Intrinsics.checkNotNullExpressionValue(select, "document.select(\"dl.movie-des dd\")[4].select(\"li\")");
        Elements<Element> elements = select;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            String text2 = element.select("a").text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.select(\"a\").text()");
            arrayList.add(StringsKt.trim((CharSequence) StringsKt.removeSuffix(text2, (CharSequence) ",")).toString());
        }
        newAnimeLoadResponse.setTags(arrayList);
        Elements select2 = this.$document.select("div.col-lg-3.col-md-4.col-6");
        Intrinsics.checkNotNullExpressionValue(select2, "document.select(\"div.col-lg-3.col-md-4.col-6\")");
        Elements elements2 = select2;
        TocanimeProvider tocanimeProvider2 = this.this$0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements2, 10));
        for (Element it : elements2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            searchResult = tocanimeProvider2.toSearchResult(it);
            arrayList2.add(searchResult);
        }
        newAnimeLoadResponse.setRecommendations(arrayList2);
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Subbed, this.$episodes);
        LoadResponse.Companion.addTrailer(newAnimeLoadResponse, this.$trailer);
    }
}
