package com.lagradost.cloudstream3.animeproviders;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NineAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class NineAnimeProvider$load$3 extends Lambda implements Function1<AnimeLoadResponse, Unit> {
    final /* synthetic */ Element $binfo;
    final /* synthetic */ ArrayList<Episode> $dubEpisodes;
    final /* synthetic */ Element $info;
    final /* synthetic */ Element $ratingElement;
    final /* synthetic */ ArrayList<Episode> $subEpisodes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineAnimeProvider$load$3(ArrayList<Episode> arrayList, ArrayList<Episode> arrayList2, Element element, Element element2, Element element3) {
        super(1);
        this.$dubEpisodes = arrayList;
        this.$subEpisodes = arrayList2;
        this.$info = element;
        this.$binfo = element2;
        this.$ratingElement = element3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimeLoadResponse animeLoadResponse) {
        invoke2(animeLoadResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AnimeLoadResponse newAnimeLoadResponse) {
        Intrinsics.checkNotNullParameter(newAnimeLoadResponse, "$this$newAnimeLoadResponse");
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Dubbed, this.$dubEpisodes);
        MainAPIKt.addEpisodes(newAnimeLoadResponse, DubStatus.Subbed, this.$subEpisodes);
        Element selectFirst = this.$info.selectFirst(".synopsis > .shorting > .content");
        newAnimeLoadResponse.setPlot(selectFirst != null ? selectFirst.text() : null);
        Element selectFirst2 = this.$binfo.selectFirst(".poster > span > img");
        newAnimeLoadResponse.setPosterUrl(selectFirst2 != null ? selectFirst2.attr("src") : null);
        String attr = this.$ratingElement.attr("data-score");
        Intrinsics.checkNotNullExpressionValue(attr, "ratingElement.attr(\"data-score\")");
        newAnimeLoadResponse.setRating(Integer.valueOf((int) (Float.parseFloat(attr) * 1000.0f)));
        Elements select = this.$info.select(".bmeta > .meta > div");
        Intrinsics.checkNotNullExpressionValue(select, "info.select(\".bmeta > .meta > div\")");
        for (Element element : select) {
            String ownText = element.ownText();
            if (ownText != null) {
                switch (ownText.hashCode()) {
                    case -1774937088:
                        if (ownText.equals("Type: ")) {
                            Element selectFirst3 = element.selectFirst("span > a");
                            newAnimeLoadResponse.setType(Intrinsics.areEqual(selectFirst3 != null ? selectFirst3.text() : null, "ONA") ? TvType.OVA : newAnimeLoadResponse.getType());
                            break;
                        } else {
                            continue;
                        }
                    case -1069999142:
                        if (ownText.equals("Duration: ")) {
                            Element selectFirst4 = element.selectFirst(TtmlNode.TAG_SPAN);
                            newAnimeLoadResponse.setDuration(MainAPIKt.getDurationFromString(selectFirst4 != null ? selectFirst4.text() : null));
                            break;
                        } else {
                            continue;
                        }
                    case 1383335608:
                        if (ownText.equals("Status: ")) {
                            Element selectFirst5 = element.selectFirst(TtmlNode.TAG_SPAN);
                            String text = selectFirst5 != null ? selectFirst5.text() : null;
                            newAnimeLoadResponse.setShowStatus(Intrinsics.areEqual(text, "Releasing") ? ShowStatus.Ongoing : Intrinsics.areEqual(text, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED) ? ShowStatus.Completed : newAnimeLoadResponse.getShowStatus());
                            break;
                        } else {
                            continue;
                        }
                    case 1584878537:
                        if (ownText.equals("Genre: ")) {
                            Elements select2 = element.select("span > a");
                            Intrinsics.checkNotNullExpressionValue(select2, "element.select(\"span > a\")");
                            ArrayList arrayList = new ArrayList();
                            Iterator<Element> it = select2.iterator();
                            while (it.hasNext()) {
                                Element next = it.next();
                                String text2 = next != null ? next.text() : null;
                                if (text2 != null) {
                                    arrayList.add(text2);
                                }
                            }
                            newAnimeLoadResponse.setTags(arrayList);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }
}
