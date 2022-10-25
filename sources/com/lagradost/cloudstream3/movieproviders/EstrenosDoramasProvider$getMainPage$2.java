package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.EnumSet;
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
import kotlin.text.StringsKt;
import okio.Utf8;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: EstrenosDoramasProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EstrenosDoramasProvider$getMainPage$2", m98f = "EstrenosDoramasProvider.kt", m97i = {0}, m96l = {40}, m95m = "invokeSuspend", m94n = {"name"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
final class EstrenosDoramasProvider$getMainPage$2 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ArrayList<HomePageList> $items;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EstrenosDoramasProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EstrenosDoramasProvider$getMainPage$2(ArrayList<HomePageList> arrayList, EstrenosDoramasProvider estrenosDoramasProvider, Continuation<? super EstrenosDoramasProvider$getMainPage$2> continuation) {
        super(2, continuation);
        this.$items = arrayList;
        this.this$0 = estrenosDoramasProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EstrenosDoramasProvider$getMainPage$2 estrenosDoramasProvider$getMainPage$2 = new EstrenosDoramasProvider$getMainPage$2(this.$items, this.this$0, continuation);
        estrenosDoramasProvider$getMainPage$2.L$0 = obj;
        return estrenosDoramasProvider$getMainPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Boolean> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super Boolean> continuation) {
        return ((EstrenosDoramasProvider$getMainPage$2) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String cleanTitle;
        EnumSet of;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            String str2 = (String) tuples.component1();
            String str3 = (String) tuples.component2();
            this.L$0 = str3;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str2, null, null, null, null, false, 0, null, 120L, null, false, this, 1790, null);
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
        Elements select = ((NiceResponse) obj2).getDocument().select("div.clearfix");
        Intrinsics.checkNotNullExpressionValue(select, "app.get(url, timeout = 1…nt.select(\"div.clearfix\")");
        Elements elements = select;
        EstrenosDoramasProvider estrenosDoramasProvider = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            Element selectFirst = element.selectFirst("h3 a");
            String text = selectFirst != null ? selectFirst.text() : null;
            Intrinsics.checkNotNull(text);
            cleanTitle = estrenosDoramasProvider.cleanTitle(text);
            Element selectFirst2 = element.selectFirst("img.cate_thumb");
            String attr = selectFirst2 != null ? selectFirst2.attr("src") : null;
            Element selectFirst3 = element.selectFirst("a");
            String attr2 = selectFirst3 != null ? selectFirst3.attr(ShareConstants.WEB_DIALOG_PARAM_HREF) : null;
            Intrinsics.checkNotNull(attr2);
            String name = estrenosDoramasProvider.getName();
            TvType tvType = TvType.AsianDrama;
            String str4 = cleanTitle;
            if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "Latino", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) "Castellano", false, 2, (Object) null)) {
                of = EnumSet.of(DubStatus.Dubbed);
            } else {
                of = EnumSet.of(DubStatus.Subbed);
            }
            arrayList.add(new AnimeSearchResponse(cleanTitle, attr2, name, tvType, attr, null, of, null, null, null, null, null, Utf8.MASK_2BYTES, null));
        }
        return boxing.boxBoolean(this.$items.add(new HomePageList(str, arrayList, null, null, null, 28, null)));
    }
}
