package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxProvider$load$5 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ Map<String, String> $authHeader;
    final /* synthetic */ String $description;
    final /* synthetic */ ArrayList<Episode> $episodeList;
    final /* synthetic */ String $posterUrl;
    final /* synthetic */ List<String> $tagsList;
    final /* synthetic */ String $title;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$load$5(String str, String str2, ArrayList<Episode> arrayList, String str3, List<String> list, String str4, Map<String, String> map) {
        super(1);
        this.$title = str;
        this.$url = str2;
        this.$episodeList = arrayList;
        this.$description = str3;
        this.$tagsList = list;
        this.$posterUrl = str4;
        this.$authHeader = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        String title = this.$title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        newTvSeriesLoadResponse.setName(title);
        newTvSeriesLoadResponse.setUrl(this.$url);
        newTvSeriesLoadResponse.setEpisodes(this.$episodeList);
        newTvSeriesLoadResponse.setPlot(this.$description);
        newTvSeriesLoadResponse.setTags(this.$tagsList);
        MainAPIKt.addPoster(newTvSeriesLoadResponse, this.$posterUrl, this.$authHeader);
    }
}
