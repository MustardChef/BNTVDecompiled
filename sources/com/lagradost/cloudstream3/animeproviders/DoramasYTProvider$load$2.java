package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ShowStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DoramasYTProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class DoramasYTProvider$load$2 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ String $description;
    final /* synthetic */ List<Episode> $episodes;
    final /* synthetic */ List<String> $genres;
    final /* synthetic */ String $poster;
    final /* synthetic */ ShowStatus $status;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoramasYTProvider$load$2(String str, List<Episode> list, ShowStatus showStatus, String str2, List<String> list2) {
        super(1);
        this.$poster = str;
        this.$episodes = list;
        this.$status = showStatus;
        this.$description = str2;
        this.$genres = list2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        newAnimeLoadResponse.setPosterUrl(this.$poster);
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Subbed, this.$episodes);
        newAnimeLoadResponse.setShowStatus(this.$status);
        newAnimeLoadResponse.setPlot(this.$description);
        newAnimeLoadResponse.setTags(this.$genres);
    }
}
