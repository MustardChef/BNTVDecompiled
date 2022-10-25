package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.movieproviders.MyCimaProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyCimaProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$4", m98f = "MyCimaProvider.kt", m97i = {}, m96l = {194}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MyCimaProvider$load$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    final /* synthetic */ Elements $moreButton;
    final /* synthetic */ Integer $season;
    final /* synthetic */ Integer $totals;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyCimaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyCimaProvider$load$4(Integer num, MyCimaProvider myCimaProvider, Elements elements, ArrayList<Episode> arrayList, Integer num2, Continuation<? super MyCimaProvider$load$4> continuation) {
        super(2, continuation);
        this.$totals = num;
        this.this$0 = myCimaProvider;
        this.$moreButton = elements;
        this.$episodes = arrayList;
        this.$season = num2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyCimaProvider$load$4 myCimaProvider$load$4 = new MyCimaProvider$load$4(this.$totals, this.this$0, this.$moreButton, this.$episodes, this.$season, continuation);
        myCimaProvider$load$4.L$0 = obj;
        return myCimaProvider$load$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return ((MyCimaProvider$load$4) create(num, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Integer intFromText;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Integer num = (Integer) this.L$0;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this.$totals;
                Intrinsics.checkNotNull(num2);
                if (intValue > num2.intValue()) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                obj2 = Requests.get$default(MainActivityKt.getApp(), this.this$0.getMainUrl() + "/AjaxCenter/MoreEpisodes/" + this.$moreButton.attr("data-term") + JsonPointer.SEPARATOR + num, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        AppUtils appUtils = AppUtils.INSTANCE;
        String output = ((MyCimaProvider.MoreEPS) MainAPIKt.getMapper().readValue(((NiceResponse) obj2).getText(), new TypeReference<MyCimaProvider.MoreEPS>() { // from class: com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$4$invokeSuspend$$inlined$parseJson$1
        })).getOutput();
        Elements select = Jsoup.parse(output != null ? StringsKt.replace$default(output, "\\", "", false, 4, (Object) null) : null).select("a");
        Intrinsics.checkNotNullExpressionValue(select, "document.select(\"a\")");
        Elements elements = select;
        ArrayList<Episode> arrayList = this.$episodes;
        Integer num3 = this.$season;
        MyCimaProvider myCimaProvider = this.this$0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
            String text = element.text();
            String text2 = element.text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
            intFromText = myCimaProvider.getIntFromText(text2);
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(boxing.boxBoolean(arrayList.add(new Episode(attr, text, num3, intFromText, null, null, null, null, 240, null))));
            arrayList2 = arrayList3;
        }
        return Unit.INSTANCE;
    }
}
