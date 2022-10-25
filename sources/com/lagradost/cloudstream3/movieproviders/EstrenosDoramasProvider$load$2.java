package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EstrenosDoramasProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class EstrenosDoramasProvider$load$2 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ ArrayList<Episode> $epi;
    final /* synthetic */ String $finaldesc;
    final /* synthetic */ String $poster;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EstrenosDoramasProvider$load$2(String str, String str2, ArrayList<Episode> arrayList, String str3) {
        super(1);
        this.$title = str;
        this.$poster = str2;
        this.$epi = arrayList;
        this.$finaldesc = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        newAnimeLoadResponse.setJapName(null);
        newAnimeLoadResponse.setEngName(new Regex("[Pp]elicula |[Pp]elicula").replace(this.$title, ""));
        newAnimeLoadResponse.setPosterUrl(this.$poster);
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Subbed, CollectionsKt.reversed(this.$epi));
        newAnimeLoadResponse.setPlot(this.$finaldesc);
    }
}
