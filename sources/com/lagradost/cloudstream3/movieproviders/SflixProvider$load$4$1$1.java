package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SflixProvider$load$4$1$1 extends Lambda implements Function1<Episode, Unit> {
    final /* synthetic */ int $episodeNum;
    final /* synthetic */ String $episodePosterUrl;
    final /* synthetic */ String $episodeTitle;
    final /* synthetic */ int $season;
    final /* synthetic */ SflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$load$4$1$1(SflixProvider sflixProvider, String str, String str2, int i, int i2) {
        super(1);
        this.this$0 = sflixProvider;
        this.$episodePosterUrl = str;
        this.$episodeTitle = str2;
        this.$episodeNum = i;
        this.$season = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Episode episode) {
        invoke2(episode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Episode newEpisode) {
        String str;
        Intrinsics.checkNotNullParameter(newEpisode, "$this$newEpisode");
        newEpisode.setPosterUrl(MainAPIKt.fixUrlNull(this.this$0, this.$episodePosterUrl));
        String str2 = this.$episodeTitle;
        if (str2 != null) {
            str = StringsKt.removePrefix(str2, (CharSequence) ("Episode " + this.$episodeNum + ": "));
        } else {
            str = null;
        }
        newEpisode.setName(str);
        newEpisode.setSeason(Integer.valueOf(this.$season + 1));
        newEpisode.setEpisode(Integer.valueOf(this.$episodeNum));
    }
}
