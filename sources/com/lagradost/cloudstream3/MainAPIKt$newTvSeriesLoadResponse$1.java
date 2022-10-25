package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class MainAPIKt$newTvSeriesLoadResponse$1 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    public static final MainAPIKt$newTvSeriesLoadResponse$1 INSTANCE = new MainAPIKt$newTvSeriesLoadResponse$1();

    MainAPIKt$newTvSeriesLoadResponse$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse tvSeriesLoadResponse) {
        Intrinsics.checkNotNullParameter(tvSeriesLoadResponse, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }
}
