package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.MainAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "episodeClick", "Lcom/lagradost/cloudstream3/ui/result/EpisodeClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$adapter$1 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$adapter$1 extends Lambda implements Function1<EpisodeClickEvent, Unit> {
    final /* synthetic */ MainAPI $api;
    final /* synthetic */ String $apiName;
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$adapter$1(ResultFragmentPhimHD resultFragmentPhimHD, String str, MainAPI mainAPI) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
        this.$apiName = str;
        this.$api = mainAPI;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EpisodeClickEvent episodeClickEvent) {
        invoke2(episodeClickEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EpisodeClickEvent episodeClick) {
        Intrinsics.checkNotNullParameter(episodeClick, "episodeClick");
        ResultFragmentPhimHD.onViewCreated$handleAction(this.this$0, this.$apiName, this.$api, episodeClick);
    }
}
