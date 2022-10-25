package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MultiAnimeProvider$load$2$1 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ SyncAPI.SyncResult $res;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiAnimeProvider$load$2$1(SyncAPI.SyncResult syncResult) {
        super(1);
        this.$res = syncResult;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        newAnimeLoadResponse.setPosterUrl(this.$res.getPosterUrl());
        newAnimeLoadResponse.setPlot(this.$res.getSynopsis());
        newAnimeLoadResponse.setTags(this.$res.getGenres());
        newAnimeLoadResponse.setRating(this.$res.getPublicScore());
        AnimeLoadResponse animeLoadResponse = newAnimeLoadResponse;
        LoadResponse.Companion.addTrailer(animeLoadResponse, this.$res.getTrailerUrl());
        LoadResponse.Companion.addAniListId(animeLoadResponse, StringsKt.toIntOrNull(this.$res.getId()));
        newAnimeLoadResponse.setRecommendations(this.$res.getRecommendations());
    }
}
