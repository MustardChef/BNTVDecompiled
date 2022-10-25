package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DramaidProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesSearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class DramaidProvider$search$2$1 extends Lambda implements Function1<TvSeriesSearchResponse, Unit> {
    final /* synthetic */ String $poster;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DramaidProvider$search$2$1(String str) {
        super(1);
        this.$poster = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesSearchResponse tvSeriesSearchResponse) {
        invoke2(tvSeriesSearchResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesSearchResponse newTvSeriesSearchResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesSearchResponse, "$this$newTvSeriesSearchResponse");
        newTvSeriesSearchResponse.setPosterUrl(this.$poster);
    }
}
