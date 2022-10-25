package com.lagradost.cloudstream3.movieproviders;

import androidx.mediarouter.media.MediaRouterJellybean;
import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ElifilmsProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.ElifilmsProvider$getMainPage$2", m98f = "ElifilmsProvider.kt", m97i = {0}, m96l = {27}, m95m = "invokeSuspend", m94n = {"name"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ElifilmsProvider$getMainPage$2 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ArrayList<HomePageList> $items;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ElifilmsProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElifilmsProvider$getMainPage$2(ArrayList<HomePageList> arrayList, ElifilmsProvider elifilmsProvider, Continuation<? super ElifilmsProvider$getMainPage$2> continuation) {
        super(2, continuation);
        this.$items = arrayList;
        this.this$0 = elifilmsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ElifilmsProvider$getMainPage$2 elifilmsProvider$getMainPage$2 = new ElifilmsProvider$getMainPage$2(this.$items, this.this$0, continuation);
        elifilmsProvider$getMainPage$2.L$0 = obj;
        return elifilmsProvider$getMainPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Boolean> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super Boolean> continuation) {
        return ((ElifilmsProvider$getMainPage$2) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            String str4 = (String) tuples.component1();
            String str5 = (String) tuples.component2();
            Extensions.RequestCustom app = MainActivityKt.getApp();
            String str6 = str4 == null ? "" : str4;
            this.L$0 = str5;
            this.label = 1;
            obj2 = Requests.get$default(app, str6, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str5;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        Elements select = ((NiceResponse) obj2).getDocument().select("article.shortstory.cf");
        Intrinsics.checkNotNullExpressionValue(select, "soup.select(\"article.shortstory.cf\")");
        Elements elements = select;
        ElifilmsProvider elifilmsProvider = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            Element selectFirst = element.selectFirst(".short_header");
            String str7 = null;
            String text = selectFirst != null ? selectFirst.text() : null;
            if (text == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(text, "it.selectFirst(\".short_header\")?.text() ?: \"\"");
                str2 = text;
            }
            Element selectFirst2 = element.selectFirst("div a");
            String attr = selectFirst2 != null ? selectFirst2.attr(ShareConstants.WEB_DIALOG_PARAM_HREF) : null;
            if (attr == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(attr, "it.selectFirst(\"div a\")?.attr(\"href\") ?: \"\"");
                str3 = attr;
            }
            String name = elifilmsProvider.getName();
            TvType tvType = TvType.Movie;
            Element selectFirst3 = element.selectFirst("a.ah-imagge img");
            if (selectFirst3 != null) {
                str7 = selectFirst3.attr("data-src");
            }
            arrayList.add(new TvSeriesSearchResponse(str2, str3, name, tvType, str7, null, null, null, null, null, MediaRouterJellybean.DEVICE_OUT_BLUETOOTH, null));
        }
        return boxing.boxBoolean(this.$items.add(new HomePageList(str, arrayList, null, null, null, 28, null)));
    }
}
