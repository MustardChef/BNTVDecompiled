package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.SearchResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CimaNowProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CimaNowProvider$getMainPage$pages$1", m98f = "CimaNowProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class CimaNowProvider$getMainPage$pages$1 extends SuspendLambda implements Function2<Element, Continuation<? super HomePageList>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CimaNowProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CimaNowProvider$getMainPage$pages$1(CimaNowProvider cimaNowProvider, Continuation<? super CimaNowProvider$getMainPage$pages$1> continuation) {
        super(2, continuation);
        this.this$0 = cimaNowProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CimaNowProvider$getMainPage$pages$1 cimaNowProvider$getMainPage$pages$1 = new CimaNowProvider$getMainPage$pages$1(this.this$0, continuation);
        cimaNowProvider$getMainPage$pages$1.L$0 = obj;
        return cimaNowProvider$getMainPage$pages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super HomePageList> continuation) {
        return ((CimaNowProvider$getMainPage$pages$1) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SearchResponse searchResponse;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Element element = (Element) this.L$0;
            String html = element.select(TtmlNode.TAG_SPAN).html();
            Intrinsics.checkNotNullExpressionValue(html, "it.select(\"span\").html()");
            String replace = new Regex("<em>.*| <i c.*").replace(html, "");
            Elements select = element.select("a");
            Intrinsics.checkNotNullExpressionValue(select, "it.select(\"a\")");
            CimaNowProvider cimaNowProvider = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (Element it : select) {
                String attr = it.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
                if (new Regex(cimaNowProvider.getMainUrl() + "/category/|" + cimaNowProvider.getMainUrl() + "/الاكثر-مشاهدة/").containsMatchIn(attr)) {
                    searchResponse = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    searchResponse = cimaNowProvider.toSearchResponse(it);
                }
                if (searchResponse != null) {
                    arrayList.add(searchResponse);
                }
            }
            return new HomePageList(replace, arrayList, null, null, null, 28, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
