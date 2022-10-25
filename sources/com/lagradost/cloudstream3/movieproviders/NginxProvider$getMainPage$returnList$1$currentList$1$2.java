package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesSearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxProvider$getMainPage$returnList$1$currentList$1$2 extends Lambda implements Function1<TvSeriesSearchResponse, Unit> {
    final /* synthetic */ Map<String, String> $authHeader;
    final /* synthetic */ String $posterUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$getMainPage$returnList$1$currentList$1$2(String str, Map<String, String> map) {
        super(1);
        this.$posterUrl = str;
        this.$authHeader = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesSearchResponse tvSeriesSearchResponse) {
        invoke2(tvSeriesSearchResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesSearchResponse newTvSeriesSearchResponse) {
        Intrinsics.checkNotNullParameter(newTvSeriesSearchResponse, "$this$newTvSeriesSearchResponse");
        MainAPIKt.addPoster(newTvSeriesSearchResponse, this.$posterUrl, this.$authHeader);
    }
}
