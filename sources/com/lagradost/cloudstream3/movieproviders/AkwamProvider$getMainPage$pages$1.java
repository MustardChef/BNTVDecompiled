package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SearchResponse;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: AkwamProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "it", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.AkwamProvider$getMainPage$pages$1", m98f = "AkwamProvider.kt", m97i = {0}, m96l = {45}, m95m = "invokeSuspend", m94n = {"it"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
final class AkwamProvider$getMainPage$pages$1 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super HomePageList>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AkwamProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AkwamProvider$getMainPage$pages$1(AkwamProvider akwamProvider, Continuation<? super AkwamProvider$getMainPage$pages$1> continuation) {
        super(2, continuation);
        this.this$0 = akwamProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AkwamProvider$getMainPage$pages$1 akwamProvider$getMainPage$pages$1 = new AkwamProvider$getMainPage$pages$1(this.this$0, continuation);
        akwamProvider$getMainPage$pages$1.L$0 = obj;
        return akwamProvider$getMainPage$pages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super HomePageList> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super HomePageList> continuation) {
        return ((AkwamProvider$getMainPage$pages$1) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Tuples tuples;
        SearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples2 = (Tuples) this.L$0;
            this.L$0 = tuples2;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), (String) tuples2.getSecond(), null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            tuples = tuples2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            tuples = (Tuples) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Elements select = ((NiceResponse) obj2).getDocument().select("div.col-lg-auto.col-md-4.col-6.mb-12");
        Intrinsics.checkNotNullExpressionValue(select, "doc.select(\"div.col-lg-auto.col-md-4.col-6.mb-12\")");
        AkwamProvider akwamProvider = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Element element : select) {
            Intrinsics.checkNotNullExpressionValue(element, "element");
            searchResponse = akwamProvider.toSearchResponse(element);
            if (searchResponse != null) {
                arrayList.add(searchResponse);
            }
        }
        return new HomePageList((String) tuples.getFirst(), arrayList, null, null, null, 28, null);
    }
}
