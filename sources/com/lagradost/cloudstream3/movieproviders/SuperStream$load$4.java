package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.movieproviders.SuperStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuperStream.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SuperStream$load$4 extends Lambda implements Function1<TvSeriesLoadResponse, Unit> {
    final /* synthetic */ SuperStream.SeriesData $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperStream$load$4(SuperStream.SeriesData seriesData) {
        super(1);
        this.$data = seriesData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TvSeriesLoadResponse tvSeriesLoadResponse) {
        invoke2(tvSeriesLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(TvSeriesLoadResponse newTvSeriesLoadResponse) {
        List split$default;
        List split$default2;
        String str;
        Intrinsics.checkNotNullParameter(newTvSeriesLoadResponse, "$this$newTvSeriesLoadResponse");
        newTvSeriesLoadResponse.setYear(this.$data.getYear());
        newTvSeriesLoadResponse.setPlot(this.$data.getDescription());
        String posterOrg = this.$data.getPosterOrg();
        if (posterOrg == null) {
            posterOrg = this.$data.getPoster();
        }
        newTvSeriesLoadResponse.setPosterUrl(posterOrg);
        String imdbRating = this.$data.getImdbRating();
        ArrayList arrayList = null;
        newTvSeriesLoadResponse.setRating((imdbRating == null || (split$default2 = StringsKt.split$default((CharSequence) imdbRating, new String[]{"/"}, false, 0, 6, (Object) null)) == null || (str = (String) split$default2.get(0)) == null) ? null : StringsKt.toIntOrNull(str));
        String cats = this.$data.getCats();
        if (cats != null && (split$default = StringsKt.split$default((CharSequence) cats, new String[]{","}, false, 0, 6, (Object) null)) != null) {
            List<String> list = split$default;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str2 : list) {
                arrayList2.add(APIHolder.INSTANCE.capitalize(str2));
            }
            arrayList = arrayList2;
        }
        newTvSeriesLoadResponse.setTags(arrayList);
        LoadResponse.Companion.addImdbId(newTvSeriesLoadResponse, this.$data.getImdbId());
    }
}
