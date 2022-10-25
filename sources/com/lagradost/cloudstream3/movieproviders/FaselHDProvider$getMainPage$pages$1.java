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

/* compiled from: FaselHDProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.FaselHDProvider$getMainPage$pages$1", m98f = "FaselHDProvider.kt", m97i = {0}, m96l = {46}, m95m = "invokeSuspend", m94n = {"title"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
final class FaselHDProvider$getMainPage$pages$1 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super HomePageList>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FaselHDProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaselHDProvider$getMainPage$pages$1(FaselHDProvider faselHDProvider, Continuation<? super FaselHDProvider$getMainPage$pages$1> continuation) {
        super(2, continuation);
        this.this$0 = faselHDProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FaselHDProvider$getMainPage$pages$1 faselHDProvider$getMainPage$pages$1 = new FaselHDProvider$getMainPage$pages$1(this.this$0, continuation);
        faselHDProvider$getMainPage$pages$1.L$0 = obj;
        return faselHDProvider$getMainPage$pages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super HomePageList> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super HomePageList> continuation) {
        return ((FaselHDProvider$getMainPage$pages$1) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object obj2;
        SearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            str = (String) tuples.component1();
            String str2 = (String) tuples.component2();
            this.L$0 = str;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str2, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        Elements select = ((NiceResponse) obj2).getDocument().select("div[id=\"postList\"] div[class=\"col-xl-2 col-lg-2 col-md-3 col-sm-3\"]");
        Intrinsics.checkNotNullExpressionValue(select, "doc.select(\"div[id=\\\"pos…-2 col-md-3 col-sm-3\\\"]\")");
        FaselHDProvider faselHDProvider = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Element element : select) {
            Intrinsics.checkNotNullExpressionValue(element, "element");
            searchResponse = faselHDProvider.toSearchResponse(element);
            if (searchResponse != null) {
                arrayList.add(searchResponse);
            }
        }
        return new HomePageList(str, arrayList, null, null, null, 28, null);
    }
}
