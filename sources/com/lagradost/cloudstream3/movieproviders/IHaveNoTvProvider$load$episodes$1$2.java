package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Episode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Element;

/* compiled from: IHaveNoTvProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class IHaveNoTvProvider$load$episodes$1$2 extends Lambda implements Function1<Episode, Unit> {
    final /* synthetic */ Element $ep;
    final /* synthetic */ Integer $epNum;
    final /* synthetic */ Integer $season;
    final /* synthetic */ String $thumb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IHaveNoTvProvider$load$episodes$1$2(Element element, Integer num, Integer num2, String str) {
        super(1);
        this.$ep = element;
        this.$season = num;
        this.$epNum = num2;
        this.$thumb = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Episode episode) {
        invoke2(episode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Episode newEpisode) {
        Intrinsics.checkNotNullParameter(newEpisode, "$this$newEpisode");
        Element selectFirst = this.$ep.selectFirst("a[title]");
        Intrinsics.checkNotNull(selectFirst);
        newEpisode.setName(selectFirst.attr("title"));
        newEpisode.setSeason(this.$season);
        newEpisode.setEpisode(this.$epNum);
        newEpisode.setPosterUrl(this.$thumb);
        Element selectFirst2 = this.$ep.selectFirst(".episodeSynopsis");
        newEpisode.setDescription(selectFirst2 != null ? selectFirst2.text() : null);
    }
}
