package com.lagradost.cloudstream3.animeproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.animeproviders.NineAnimeProvider;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: NineAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getMainPage$items$1", m98f = "NineAnimeProvider.kt", m97i = {0}, m96l = {150}, m95m = "invokeSuspend", m94n = {"name"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
final class NineAnimeProvider$getMainPage$items$1 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super HomePageList>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NineAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineAnimeProvider$getMainPage$items$1(NineAnimeProvider nineAnimeProvider, Continuation<? super NineAnimeProvider$getMainPage$items$1> continuation) {
        super(2, continuation);
        this.this$0 = nineAnimeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NineAnimeProvider$getMainPage$items$1 nineAnimeProvider$getMainPage$items$1 = new NineAnimeProvider$getMainPage$items$1(this.this$0, continuation);
        nineAnimeProvider$getMainPage$items$1.L$0 = obj;
        return nineAnimeProvider$getMainPage$items$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super HomePageList> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super HomePageList> continuation) {
        return ((NineAnimeProvider$getMainPage$items$1) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        Integer num;
        Integer num2;
        Element selectFirst;
        String text;
        Element selectFirst2;
        String text2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            String str2 = (String) tuples.component1();
            String str3 = (String) tuples.component2();
            this.L$0 = str3;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str2, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str3;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        Elements select = Jsoup.parse(((NineAnimeProvider.Response) Requests.Companion.getMapper().readValue(((NiceResponse) obj2).getText(), new TypeReference<NineAnimeProvider.Response>() { // from class: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$getMainPage$items$1$invokeSuspend$$inlined$parsed$1
        })).getHtml()).select("div.item");
        Intrinsics.checkNotNullExpressionValue(select, "parse(\n                a…     ).select(\"div.item\")");
        NineAnimeProvider nineAnimeProvider = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Element element : select) {
            Element selectFirst3 = element.selectFirst(".info > .name");
            AnimeSearchResponse animeSearchResponse = null;
            if (selectFirst3 != null) {
                Intrinsics.checkNotNullExpressionValue(selectFirst3, "element.selectFirst(\".in…?: return@mapNotNull null");
                String link = selectFirst3.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                Element selectFirst4 = element.selectFirst(".poster > a > img");
                String attr = selectFirst4 != null ? selectFirst4.attr("src") : null;
                Element selectFirst5 = element.selectFirst(".poster > a > .meta > .inner > .left");
                if (selectFirst5 == null || (selectFirst2 = selectFirst5.selectFirst(".sub")) == null || (text2 = selectFirst2.text()) == null) {
                    num = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(text2, "text()");
                    num = StringsKt.toIntOrNull(text2);
                }
                if (selectFirst5 == null || (selectFirst = selectFirst5.selectFirst(".dub")) == null || (text = selectFirst.text()) == null) {
                    num2 = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(text, "text()");
                    num2 = StringsKt.toIntOrNull(text);
                }
                NineAnimeProvider nineAnimeProvider2 = nineAnimeProvider;
                String text3 = selectFirst3.text();
                if (text3 != null) {
                    Intrinsics.checkNotNullExpressionValue(text3, "title.text() ?: return@mapNotNull null");
                    Intrinsics.checkNotNullExpressionValue(link, "link");
                    animeSearchResponse = MainAPIKt.newAnimeSearchResponse$default(nineAnimeProvider2, text3, link, null, false, new NineAnimeProvider$getMainPage$items$1$home$1$1(attr, num2, num), 12, null);
                }
            }
            if (animeSearchResponse != null) {
                arrayList.add(animeSearchResponse);
            }
        }
        return new HomePageList(str, arrayList, null, null, null, 28, null);
    }
}
