package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NginxProvider$load$4$1$1 extends Lambda implements Function1<Episode, Unit> {
    final /* synthetic */ String $date;
    final /* synthetic */ Integer $epNum;
    final /* synthetic */ String $name;
    final /* synthetic */ String $plot;
    final /* synthetic */ String $poster;
    final /* synthetic */ int $seasonInt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$load$4$1$1(String str, int i, Integer num, String str2, String str3, String str4) {
        super(1);
        this.$name = str;
        this.$seasonInt = i;
        this.$epNum = num;
        this.$poster = str2;
        this.$plot = str3;
        this.$date = str4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Episode episode) {
        invoke2(episode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Episode newEpisode) {
        Intrinsics.checkNotNullParameter(newEpisode, "$this$newEpisode");
        newEpisode.setName(this.$name);
        newEpisode.setSeason(Integer.valueOf(this.$seasonInt));
        newEpisode.setEpisode(this.$epNum);
        newEpisode.setPosterUrl(this.$poster);
        newEpisode.setDescription(this.$plot);
        MainAPIKt.addDate$default(newEpisode, this.$date, null, 2, null);
    }
}
