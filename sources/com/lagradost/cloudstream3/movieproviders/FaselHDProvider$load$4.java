package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.Extensions;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FaselHDProvider.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.FaselHDProvider$load$4", m98f = "FaselHDProvider.kt", m97i = {}, m96l = {119}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class FaselHDProvider$load$4 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends Boolean>>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FaselHDProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaselHDProvider$load$4(FaselHDProvider faselHDProvider, ArrayList<Episode> arrayList, Continuation<? super FaselHDProvider$load$4> continuation) {
        super(2, continuation);
        this.this$0 = faselHDProvider;
        this.$episodes = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FaselHDProvider$load$4 faselHDProvider$load$4 = new FaselHDProvider$load$4(this.this$0, this.$episodes, continuation);
        faselHDProvider$load$4.L$0 = obj;
        return faselHDProvider$load$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Element element, Continuation<? super List<? extends Boolean>> continuation) {
        return invoke2(element, (Continuation<? super List<Boolean>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Element element, Continuation<? super List<Boolean>> continuation) {
        return ((FaselHDProvider$load$4) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Integer intFromText;
        Integer intFromText2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Extensions.RequestCustom app = MainActivityKt.getApp();
            this.label = 1;
            obj2 = Requests.get$default(app, this.this$0.getMainUrl() + "/?p=" + ((Element) this.L$0).attr("data-href"), null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Elements select = document.select("div.epAll a");
        Intrinsics.checkNotNullExpressionValue(select, "s.select(\"div.epAll a\")");
        Elements elements = select;
        ArrayList<Episode> arrayList = this.$episodes;
        FaselHDProvider faselHDProvider = this.this$0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
            String text = element.text();
            String text2 = document.select("div.seasonDiv.active div.title").text();
            Intrinsics.checkNotNullExpressionValue(text2, "s.select(\"div.seasonDiv.active div.title\").text()");
            intFromText = faselHDProvider.getIntFromText(text2);
            String text3 = element.text();
            Intrinsics.checkNotNullExpressionValue(text3, "it.text()");
            intFromText2 = faselHDProvider.getIntFromText(text3);
            arrayList2.add(boxing.boxBoolean(arrayList.add(new Episode(attr, text, intFromText, intFromText2, null, null, null, null, 240, null))));
        }
        return arrayList2;
    }
}
