package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.AnimeSearchResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.select.Elements;

/* compiled from: NineAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class NineAnimeProvider$search$2$1 extends Lambda implements Function1<AnimeSearchResponse, Unit> {
    final /* synthetic */ Elements $img;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineAnimeProvider$search$2$1(Elements elements) {
        super(1);
        this.$img = elements;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeSearchResponse animeSearchResponse) {
        invoke2(animeSearchResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeSearchResponse newAnimeSearchResponse) {
        Intrinsics.checkNotNullParameter(newAnimeSearchResponse, "$this$newAnimeSearchResponse");
        newAnimeSearchResponse.setPosterUrl(this.$img.attr("src"));
    }
}
