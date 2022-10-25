package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ZoroProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class ZoroProvider$search$2$1 extends Lambda implements Function1<AnimeSearchResponse, Unit> {
    final /* synthetic */ boolean $dubExist;
    final /* synthetic */ Integer $episodes;
    final /* synthetic */ String $poster;
    final /* synthetic */ boolean $subExist;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoroProvider$search$2$1(String str, boolean z, boolean z2, Integer num) {
        super(1);
        this.$poster = str;
        this.$dubExist = z;
        this.$subExist = z2;
        this.$episodes = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeSearchResponse animeSearchResponse) {
        invoke2(animeSearchResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeSearchResponse newAnimeSearchResponse) {
        Intrinsics.checkNotNullParameter(newAnimeSearchResponse, "$this$newAnimeSearchResponse");
        newAnimeSearchResponse.setPosterUrl(this.$poster);
        boolean z = this.$dubExist;
        boolean z2 = this.$subExist;
        Integer num = this.$episodes;
        MainAPIKt.addDubStatus(newAnimeSearchResponse, z, z2, num, num);
    }
}
