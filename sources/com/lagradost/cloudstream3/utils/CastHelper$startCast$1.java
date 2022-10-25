package com.lagradost.cloudstream3.utils;

import com.google.android.gms.cast.framework.CastSession;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CastHelper.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CastHelper$startCast$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $apiName;
    final /* synthetic */ int $currentEpisodeIndex;
    final /* synthetic */ List<ExtractorLink> $currentLinks;
    final /* synthetic */ List<ResultEpisode> $episodes;
    final /* synthetic */ int $index;
    final /* synthetic */ boolean $isMovie;
    final /* synthetic */ String $poster;
    final /* synthetic */ Long $startTime;
    final /* synthetic */ List<SubtitleData> $subtitles;
    final /* synthetic */ CastSession $this_startCast;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CastHelper$startCast$1(List<? extends ExtractorLink> list, int i, CastSession castSession, String str, boolean z, String str2, String str3, int i2, List<ResultEpisode> list2, List<SubtitleData> list3, Long l) {
        super(1);
        this.$currentLinks = list;
        this.$index = i;
        this.$this_startCast = castSession;
        this.$apiName = str;
        this.$isMovie = z;
        this.$title = str2;
        this.$poster = str3;
        this.$currentEpisodeIndex = i2;
        this.$episodes = list2;
        this.$subtitles = list3;
        this.$startTime = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (this.$currentLinks.size() > this.$index + 1) {
            CastHelper.INSTANCE.startCast(this.$this_startCast, this.$apiName, this.$isMovie, this.$title, this.$poster, this.$currentEpisodeIndex, this.$episodes, this.$currentLinks, this.$subtitles, Integer.valueOf(this.$index + 1), this.$startTime);
        }
    }
}
