package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: HDrezkaProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$getMainPage$2", m98f = "HDrezkaProvider.kt", m97i = {}, m96l = {41}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class HDrezkaProvider$getMainPage$2 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Resource<? extends Boolean>>, Object> {
    final /* synthetic */ ArrayList<HomePageList> $items;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HDrezkaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HDrezkaProvider$getMainPage$2(ArrayList<HomePageList> arrayList, HDrezkaProvider hDrezkaProvider, Continuation<? super HDrezkaProvider$getMainPage$2> continuation) {
        super(2, continuation);
        this.$items = arrayList;
        this.this$0 = hDrezkaProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HDrezkaProvider$getMainPage$2 hDrezkaProvider$getMainPage$2 = new HDrezkaProvider$getMainPage$2(this.$items, this.this$0, continuation);
        hDrezkaProvider$getMainPage$2.L$0 = obj;
        return hDrezkaProvider$getMainPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Resource<? extends Boolean>> continuation) {
        return invoke2((Tuples<String, String>) tuples, (Continuation<? super Resource<Boolean>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super Resource<Boolean>> continuation) {
        return ((HDrezkaProvider$getMainPage$2) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$getMainPage$2$1", m98f = "HDrezkaProvider.kt", m97i = {}, m96l = {42}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$getMainPage$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48051 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $header;
        final /* synthetic */ ArrayList<HomePageList> $items;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ HDrezkaProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48051(String str, ArrayList<HomePageList> arrayList, String str2, HDrezkaProvider hDrezkaProvider, Continuation<? super C48051> continuation) {
            super(1, continuation);
            this.$url = str;
            this.$items = arrayList;
            this.$header = str2;
            this.this$0 = hDrezkaProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48051(this.$url, this.$items, this.$header, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C48051) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            SearchResponse searchResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj2 = Requests.get$default(MainActivityKt.getApp(), this.$url, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            Elements select = ((NiceResponse) obj2).getDocument().select("div.b-content__inline_items div.b-content__inline_item");
            Intrinsics.checkNotNullExpressionValue(select, "app.get(url).document.se…e_item\"\n                )");
            Elements elements = select;
            HDrezkaProvider hDrezkaProvider = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
            for (Element it : elements) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                searchResult = hDrezkaProvider.toSearchResult(it);
                arrayList.add(searchResult);
            }
            return boxing.boxBoolean(this.$items.add(new HomePageList(MainAPIKt.fixTitle(this.$header), arrayList, null, null, null, 28, null)));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            String str = (String) tuples.component2();
            ArrayList<HomePageList> arrayList = this.$items;
            this.label = 1;
            obj = ArchComponentExt.safeApiCall(new C48051(str, arrayList, (String) tuples.component1(), this.this$0, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
