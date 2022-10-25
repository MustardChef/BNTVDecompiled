package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SearchResponse;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CimaNowProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CimaNowProvider$search$4", m98f = "CimaNowProvider.kt", m97i = {}, m96l = {73}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class CimaNowProvider$search$4 extends SuspendLambda implements Function2<Integer, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ ArrayList<SearchResponse> $result;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CimaNowProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CimaNowProvider$search$4(CimaNowProvider cimaNowProvider, String str, ArrayList<SearchResponse> arrayList, Continuation<? super CimaNowProvider$search$4> continuation) {
        super(2, continuation);
        this.this$0 = cimaNowProvider;
        this.$query = str;
        this.$result = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CimaNowProvider$search$4 cimaNowProvider$search$4 = new CimaNowProvider$search$4(this.this$0, this.$query, this.$result, continuation);
        cimaNowProvider$search$4.I$0 = ((Number) obj).intValue();
        return cimaNowProvider$search$4;
    }

    public final Object invoke(int i, Continuation<? super List<Unit>> continuation) {
        return ((CimaNowProvider$search$4) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super List<? extends Unit>> continuation) {
        return invoke(num.intValue(), (Continuation<? super List<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        SearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.I$0;
            Extensions.RequestCustom app = MainActivityKt.getApp();
            this.label = 1;
            obj2 = Requests.get$default(app, this.this$0.getMainUrl() + "/page/" + i2 + "/?s=" + this.$query + '\"', null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Elements select = ((NiceResponse) obj2).getDocument().select("section article a");
        Intrinsics.checkNotNullExpressionValue(select, "app.get(\"$mainUrl/page/$…lect(\"section article a\")");
        Elements elements = select;
        CimaNowProvider cimaNowProvider = this.this$0;
        ArrayList<SearchResponse> arrayList = this.$result;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            String postUrl = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Elements select2 = element.select("li[aria-label=\"episode\"]");
            Intrinsics.checkNotNullExpressionValue(select2, "element.select(\"li[aria-label=\\\"episode\\\"]\")");
            if (!(!select2.isEmpty())) {
                Intrinsics.checkNotNullExpressionValue(postUrl, "postUrl");
                if (!new Regex(cimaNowProvider.getMainUrl() + "/expired-download/|" + cimaNowProvider.getMainUrl() + "/افلام-اون-لاين/").containsMatchIn(postUrl)) {
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    searchResponse = cimaNowProvider.toSearchResponse(element);
                    Intrinsics.checkNotNull(searchResponse);
                    arrayList.add(searchResponse);
                }
            }
            arrayList2.add(Unit.INSTANCE);
        }
        return arrayList2;
    }
}
