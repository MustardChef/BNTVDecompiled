package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u008a@"}, m107d2 = {"<anonymous>", "", "season", "", "element", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$load$4", m98f = "SflixProvider.kt", m97i = {0, 0}, m96l = {bqk.f6598ce}, m95m = "invokeSuspend", m94n = {"episode", "season"}, m93s = {"L$0", "I$0"})
/* loaded from: classes3.dex */
public final class SflixProvider$load$4 extends SuspendLambda implements Function3<Integer, Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    final /* synthetic */ String $url;
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$load$4(SflixProvider sflixProvider, ArrayList<Episode> arrayList, String str, Continuation<? super SflixProvider$load$4> continuation) {
        super(3, continuation);
        this.this$0 = sflixProvider;
        this.$episodes = arrayList;
        this.$url = str;
    }

    public final Object invoke(int i, Element element, Continuation<? super Unit> continuation) {
        SflixProvider$load$4 sflixProvider$load$4 = new SflixProvider$load$4(this.this$0, this.$episodes, this.$url, continuation);
        sflixProvider$load$4.I$0 = i;
        sflixProvider$load$4.L$0 = element;
        return sflixProvider$load$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Element element, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), element, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i;
        Ref.IntRef intRef;
        String ownText;
        int i2;
        List<String> groupValues;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 0;
        int i5 = 1;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int i6 = this.I$0;
            String attr = ((Element) this.L$0).attr("data-id");
            String str2 = attr;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return Unit.INSTANCE;
            }
            Ref.IntRef intRef2 = new Ref.IntRef();
            Extensions.RequestCustom app = MainActivityKt.getApp();
            this.L$0 = intRef2;
            this.I$0 = i6;
            this.label = 1;
            obj2 = Requests.get$default(app, this.this$0.getMainUrl() + "/ajax/v2/season/episodes/" + attr, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i6;
            intRef = intRef2;
        } else if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            i = this.I$0;
            intRef = (Ref.IntRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Elements seasonEpisodesItems = document.select("div.flw-item.film_single-item.episode-item.eps-item");
        Elements elements = seasonEpisodesItems;
        if (elements == null || elements.isEmpty()) {
            seasonEpisodesItems = document.select("ul > li > a");
        }
        Intrinsics.checkNotNullExpressionValue(seasonEpisodesItems, "seasonEpisodesItems");
        ArrayList<Episode> arrayList = this.$episodes;
        SflixProvider sflixProvider = this.this$0;
        String str3 = this.$url;
        Iterator<Element> it = seasonEpisodesItems.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            Integer num = null;
            Elements select = next != null ? next.select("img") : null;
            if (select == null || (ownText = select.attr("title")) == null) {
                ownText = next.ownText();
            }
            String attr2 = select != null ? select.attr("src") : null;
            String attr3 = next.attr("data-id");
            if (attr3 != null) {
                Intrinsics.checkNotNullExpressionValue(attr3, "it.attr(\"data-id\") ?: return@forEach");
                intRef.element += i5;
                String str4 = next.select("div.episode-number").text();
                if (str4 == null) {
                    str4 = ownText;
                }
                Regex regex = new Regex("\\d+");
                Intrinsics.checkNotNullExpressionValue(str4, "str");
                MatchResult find$default = Regex.find$default(regex, str4, i4, 2, null);
                if (find$default != null && (groupValues = find$default.getGroupValues()) != null && (str = (String) CollectionsKt.firstOrNull((List<? extends Object>) groupValues)) != null) {
                    num = StringsKt.toIntOrNull(str);
                }
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    i2 = intRef.element;
                }
                arrayList.add(MainAPIKt.newEpisode(sflixProvider, new Tuples(str3, attr3), new SflixProvider$load$4$1$1(sflixProvider, attr2, ownText, i2, i)));
                i4 = 0;
                i5 = 1;
            }
        }
        return Unit.INSTANCE;
    }
}
