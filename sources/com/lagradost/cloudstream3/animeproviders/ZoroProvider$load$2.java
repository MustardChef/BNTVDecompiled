package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.animeproviders.ZoroProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZoroProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ZoroProvider$load$2 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ List<ActorData> $actors;
    final /* synthetic */ String $description;
    final /* synthetic */ List<Episode> $episodes;
    final /* synthetic */ Ref.ObjectRef<String> $japaneseTitle;
    final /* synthetic */ String $poster;
    final /* synthetic */ List<AnimeSearchResponse> $recommendations;
    final /* synthetic */ Ref.ObjectRef<ShowStatus> $status;
    final /* synthetic */ ZoroProvider.ZoroSyncData $syncData;
    final /* synthetic */ List<String> $tags;
    final /* synthetic */ String $title;
    final /* synthetic */ Ref.ObjectRef<Integer> $year;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoroProvider$load$2(Ref.ObjectRef<String> objectRef, String str, String str2, Ref.ObjectRef<Integer> objectRef2, List<Episode> list, Ref.ObjectRef<ShowStatus> objectRef3, String str3, List<String> list2, List<AnimeSearchResponse> list3, List<ActorData> list4, ZoroProvider.ZoroSyncData zoroSyncData) {
        super(1);
        this.$japaneseTitle = objectRef;
        this.$title = str;
        this.$poster = str2;
        this.$year = objectRef2;
        this.$episodes = list;
        this.$status = objectRef3;
        this.$description = str3;
        this.$tags = list2;
        this.$recommendations = list3;
        this.$actors = list4;
        this.$syncData = zoroSyncData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        String aniListId;
        String malId;
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        newAnimeLoadResponse.setJapName(this.$japaneseTitle.element);
        newAnimeLoadResponse.setEngName(this.$title);
        newAnimeLoadResponse.setPosterUrl(this.$poster);
        newAnimeLoadResponse.setYear(this.$year.element);
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Subbed, this.$episodes);
        newAnimeLoadResponse.setShowStatus(this.$status.element);
        newAnimeLoadResponse.setPlot(this.$description);
        newAnimeLoadResponse.setTags(this.$tags);
        newAnimeLoadResponse.setRecommendations(this.$recommendations);
        newAnimeLoadResponse.setActors(this.$actors);
        LoadResponse.Companion companion = LoadResponse.Companion;
        AnimeLoadResponse animeLoadResponse = newAnimeLoadResponse;
        ZoroProvider.ZoroSyncData zoroSyncData = this.$syncData;
        Integer num = null;
        companion.addMalId(animeLoadResponse, (zoroSyncData == null || (malId = zoroSyncData.getMalId()) == null) ? null : StringsKt.toIntOrNull(malId));
        LoadResponse.Companion companion2 = LoadResponse.Companion;
        ZoroProvider.ZoroSyncData zoroSyncData2 = this.$syncData;
        if (zoroSyncData2 != null && (aniListId = zoroSyncData2.getAniListId()) != null) {
            num = StringsKt.toIntOrNull(aniListId);
        }
        companion2.addAniListId(animeLoadResponse, num);
    }
}
