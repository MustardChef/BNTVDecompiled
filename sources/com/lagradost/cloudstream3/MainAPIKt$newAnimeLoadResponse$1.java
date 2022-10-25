package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MainAPIKt$newAnimeLoadResponse$1 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    public static final MainAPIKt$newAnimeLoadResponse$1 INSTANCE = new MainAPIKt$newAnimeLoadResponse$1();

    MainAPIKt$newAnimeLoadResponse$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse animeLoadResponse) {
        Intrinsics.checkNotNullParameter(animeLoadResponse, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }
}
