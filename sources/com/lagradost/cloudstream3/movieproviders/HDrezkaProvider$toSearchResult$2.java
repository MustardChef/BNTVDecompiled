package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HDrezkaProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class HDrezkaProvider$toSearchResult$2 extends Lambda implements Function1<AnimeSearchResponse, Unit> {
    final /* synthetic */ Integer $episode;
    final /* synthetic */ String $posterUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HDrezkaProvider$toSearchResult$2(String str, Integer num) {
        super(1);
        this.$posterUrl = str;
        this.$episode = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeSearchResponse animeSearchResponse) {
        invoke2(animeSearchResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeSearchResponse newAnimeSearchResponse) {
        Intrinsics.checkNotNullParameter(newAnimeSearchResponse, "$this$newAnimeSearchResponse");
        newAnimeSearchResponse.setPosterUrl(this.$posterUrl);
        Integer num = this.$episode;
        MainAPIKt.addDubStatus(newAnimeSearchResponse, true, true, num, num);
    }
}
