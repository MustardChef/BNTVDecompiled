package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: EgyBestProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "url", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EgyBestProvider$search$2", m98f = "EgyBestProvider.kt", m97i = {}, m96l = {64}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class EgyBestProvider$search$2 extends SuspendLambda implements Function2<String, Continuation<? super List<? extends Boolean>>, Object> {
    final /* synthetic */ ArrayList<SearchResponse> $result;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EgyBestProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EgyBestProvider$search$2(EgyBestProvider egyBestProvider, ArrayList<SearchResponse> arrayList, Continuation<? super EgyBestProvider$search$2> continuation) {
        super(2, continuation);
        this.this$0 = egyBestProvider;
        this.$result = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EgyBestProvider$search$2 egyBestProvider$search$2 = new EgyBestProvider$search$2(this.this$0, this.$result, continuation);
        egyBestProvider$search$2.L$0 = obj;
        return egyBestProvider$search$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super List<? extends Boolean>> continuation) {
        return invoke2(str, (Continuation<? super List<Boolean>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<? super List<Boolean>> continuation) {
        return ((EgyBestProvider$search$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        SearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Elements not = ((NiceResponse) obj2).getDocument().select("div.movies a").not("a.auto.load.btn.b");
        Intrinsics.checkNotNullExpressionValue(not, "d.select(\"div.movies a\").not(\"a.auto.load.btn.b\")");
        EgyBestProvider egyBestProvider = this.this$0;
        ArrayList<SearchResponse> arrayList = this.$result;
        ArrayList arrayList2 = new ArrayList();
        for (Element it : not) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            searchResponse = egyBestProvider.toSearchResponse(it);
            Boolean boxBoolean = searchResponse != null ? boxing.boxBoolean(arrayList.add(searchResponse)) : null;
            if (boxBoolean != null) {
                arrayList2.add(boxBoolean);
            }
        }
        return arrayList2;
    }
}
