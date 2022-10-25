package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EgyBestProvider.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "it", "", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EgyBestProvider$load$4", m98f = "EgyBestProvider.kt", m97i = {0}, m96l = {124}, m95m = "invokeSuspend", m94n = {"it"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class EgyBestProvider$load$4 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Boolean>>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EgyBestProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EgyBestProvider$load$4(EgyBestProvider egyBestProvider, ArrayList<Episode> arrayList, Continuation<? super EgyBestProvider$load$4> continuation) {
        super(2, continuation);
        this.this$0 = egyBestProvider;
        this.$episodes = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EgyBestProvider$load$4 egyBestProvider$load$4 = new EgyBestProvider$load$4(this.this$0, this.$episodes, continuation);
        egyBestProvider$load$4.L$0 = obj;
        return egyBestProvider$load$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Boolean>> continuation) {
        return invoke2(str, (Continuation<? super List<Boolean>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<? super List<Boolean>> continuation) {
        return ((EgyBestProvider$load$4) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String it;
        Integer num;
        List<String> groupValues;
        Integer intFromText;
        Integer num2;
        Integer intFromText2;
        List<String> groupValues2;
        String str;
        Integer intFromText3;
        List<String> groupValues3;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String it2 = (String) this.L$0;
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            this.L$0 = it2;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), it2, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            it = it2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Regex regex = new Regex("season-(.....)");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        int i2 = 0;
        int i3 = 2;
        Integer num3 = null;
        MatchResult find$default = Regex.find$default(regex, it, 0, 2, null);
        Integer intFromText4 = (find$default == null || (groupValues3 = find$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues3, 1)) == null) ? null : this.this$0.getIntFromText(str2);
        Elements select = document.select("tr.published");
        Intrinsics.checkNotNullExpressionValue(select, "d.select(\"tr.published\")");
        boolean z = !select.isEmpty();
        String str3 = "ep-(.....)";
        String str4 = ShareConstants.WEB_DIALOG_PARAM_HREF;
        if (z) {
            Elements select2 = document.select("tr.published");
            Intrinsics.checkNotNullExpressionValue(select2, "d.select(\"tr.published\")");
            Elements elements = select2;
            EgyBestProvider egyBestProvider = this.this$0;
            ArrayList<Episode> arrayList = this.$episodes;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
            for (Element element : elements) {
                Regex regex2 = new Regex(str3);
                String attr = element.select(".ep_title a").attr(str4);
                Intrinsics.checkNotNullExpressionValue(attr, "element.select(\".ep_title a\").attr(\"href\")");
                MatchResult find$default2 = Regex.find$default(regex2, attr, i2, i3, num3);
                if (find$default2 == null || (groupValues2 = find$default2.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) {
                    num2 = num3;
                } else {
                    intFromText3 = egyBestProvider.getIntFromText(str);
                    num2 = intFromText3;
                }
                String attr2 = element.select(".ep_title a").attr(str4);
                Intrinsics.checkNotNullExpressionValue(attr2, "element.select(\".ep_title a\").attr(\"href\")");
                String html = element.select("td.ep_title").html();
                Intrinsics.checkNotNullExpressionValue(html, "element.select(\"td.ep_title\").html()");
                String replace = new Regex(".*</span>|</a>").replace(html, "");
                String text = element.select("td.tam:not(.date, .ep_len)").text();
                Intrinsics.checkNotNullExpressionValue(text, "element.select(\"td.tam:n…(.date, .ep_len)\").text()");
                intFromText2 = egyBestProvider.getIntFromText(text);
                ArrayList arrayList3 = arrayList2;
                ArrayList<Episode> arrayList4 = arrayList;
                arrayList3.add(boxing.boxBoolean(arrayList4.add(new Episode(attr2, replace, intFromText4, num2, null, intFromText2, null, null, 208, null))));
                str4 = str4;
                str3 = str3;
                arrayList2 = arrayList3;
                arrayList = arrayList4;
                i2 = 0;
                i3 = 2;
                num3 = null;
            }
            return arrayList2;
        }
        Elements select3 = document.select("#mainLoad > div:nth-child(3) > div.movies_small a");
        Intrinsics.checkNotNullExpressionValue(select3, "d.select(\"#mainLoad > di…3) > div.movies_small a\")");
        Elements elements2 = select3;
        EgyBestProvider egyBestProvider2 = this.this$0;
        ArrayList<Episode> arrayList5 = this.$episodes;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements2, 10));
        for (Element element2 : elements2) {
            Regex regex3 = new Regex("ep-(.....)");
            String attr3 = element2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr3, "eit.attr(\"href\")");
            MatchResult find$default3 = Regex.find$default(regex3, attr3, 0, 2, null);
            if (find$default3 != null && (groupValues = find$default3.getGroupValues()) != null) {
                String str5 = (String) CollectionsKt.getOrNull(groupValues, 1);
                if (str5 != null) {
                    intFromText = egyBestProvider2.getIntFromText(str5);
                    num = intFromText;
                    String attr4 = element2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                    Intrinsics.checkNotNullExpressionValue(attr4, "eit.attr(\"href\")");
                    arrayList6.add(boxing.boxBoolean(arrayList5.add(new Episode(attr4, element2.select("span.title").text(), intFromText4, num, null, null, null, null, 240, null))));
                }
            }
            num = null;
            String attr42 = element2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr42, "eit.attr(\"href\")");
            arrayList6.add(boxing.boxBoolean(arrayList5.add(new Episode(attr42, element2.select("span.title").text(), intFromText4, num, null, null, null, null, 240, null))));
        }
        return arrayList6;
    }
}
